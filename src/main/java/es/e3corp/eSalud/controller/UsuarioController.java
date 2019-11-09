
package es.e3corp.eSalud.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

import es.e3corp.eSalud.Service.UsuarioService;
import es.e3corp.eSalud.exception.UserNotFoundException;
import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.utilidades.Utilidades;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = { "http://localhost:4200", "https://esalud.herokuapp.com" }, allowedHeaders = "*")
public class UsuarioController {

	private static final Log log = LogFactory.getLog(UsuarioController.class);
	private final UsuarioService usersService;
	private Usuario user;

	@Autowired
	public UsuarioController(UsuarioService usersService) {
		this.usersService = usersService;
	}

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Usuario> getUserPassword(@RequestParam("dni") String dni,
      @RequestParam("password") String password) {
	  
	String dniEncriptado = Utilidades.encriptar(dni);
    String contraseñaEncriptado = Utilidades.encriptar(password);
      
    Usuario usuario = usersService.getUserByDniAndPassword(dniEncriptado, contraseñaEncriptado);
    if (usuario != null) {
      System.out.println("[SERVER] Usuario encontrado: " + usuario.getNombre());
      return ResponseEntity.ok(usuario);
    } else {
      System.out.println("[SERVER] No se ha encontrado ningún usuario.");
      return ResponseEntity.badRequest().build();
    }
  }

  @RequestMapping(value = "/{userDni}", method = RequestMethod.GET)
  @ApiOperation(value = "Find an user", notes = "Return a user by DNI")
  public ResponseEntity<Usuario> userByDni(@PathVariable String userDni) throws UserNotFoundException {
    log.info("[SERVER] Buscando usuario: " + userDni);
    try {
      //System.out.println("Se recibe el dni: " +userDni);
      String dniEncriptado = Utilidades.encriptar(userDni);
      //System.out.println("Se recibe el dni encriptado: " +dniEncriptado);
      user = usersService.findByUserDni(dniEncriptado);
      log.info("[SERVER] Usuario encontrado.");
    } catch (UserNotFoundException e) {
      user = null;
      log.error("[SERVER] Usuario no encontrado.");
    }
    return ResponseEntity.ok(user);
  }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<Usuario>> usuarioById() {
//        log.info("Get allUsers");
//        return ResponseEntity.ok(usersService.findAll());
//    }

    
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ApiOperation(value = "Find all user", notes = "Return all users" )
    public ResponseEntity<List<Usuario>> allUsers(){
      log.info("Get allUsers");
      return ResponseEntity.ok(usersService.findAll());
    }
    
    @RequestMapping(value = "/pacientes",method = RequestMethod.GET)
    @ApiOperation(value = "Find all user", notes = "Return all users" )
    public ResponseEntity<List<Usuario>> allPacientes(){
      log.info("Get allUsers");
      return ResponseEntity.ok(usersService.getUsersByRol(Utilidades.encriptar("paciente")));
    }
    
    @RequestMapping(value = "/medicos",method = RequestMethod.GET)
    @ApiOperation(value = "Find all user", notes = "Return all users" )
    public ResponseEntity<List<Usuario>> allMedicos(){
      log.info("Get allUsers");
      return ResponseEntity.ok(usersService.getUsersByRol(Utilidades.encriptar("médico")));
    }
     
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an user", notes = "Delete a user by Id")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        log.info("Delete user " + userId);
        usersService.deleteUsuario(userId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody String p) {
    	JSONObject jso = new JSONObject(p);
        String dni = jso.getString("dni");
        String contraseña = jso.getString("password");
        
        //System.out.println("Se recibe el dni: " +dni);
        String dniEncriptado = Utilidades.encriptar(dni);
        //System.out.println("Se recibe el dni encriptado: " +dniEncriptado);
       
        String contraseñaEncriptado = Utilidades.encriptar(contraseña);
        
        Usuario usuario1 = usersService.getUserByDniAndPassword(dniEncriptado, contraseñaEncriptado);
        if (usuario1 == null) {
          String nombre = null, apellidos = null, email = null, localidad = null, centro = null, medico = null, rol = null,
              especialidad = null;
          String numTelefono = null;
          try {
            System.out.println("[SERVER] Registrando usuario...");
            nombre = jso.getString("nombre");
            apellidos = jso.getString("apellidos");
            numTelefono = jso.getString("tel");
            email = jso.getString("correo");
            if (jso.getString("rol").equals("paciente")) {
              localidad = jso.getString("localidad");
              rol = jso.getString("rol");
            } else {
              rol = jso.getString("rol");
              centro = jso.getString("centro");
              medico = jso.getString("medico");
              especialidad = jso.getString("especialidad");
            }
          } catch (JSONException j) {
            System.out.println("[SERVER] Error en la lectura del JSON.");
            System.out.println(j.getMessage());
            return ResponseEntity.badRequest().build();
          }

          usuario1 = new Usuario(dni, nombre, apellidos, contraseña, rol, especialidad, medico, numTelefono, localidad,
              centro, email);
          usersService.saveUsuario(usuario1);
          System.out.println("[SERVER] Usuario registrado.");
          System.out.println("[SERVER] " + usuario1.toString());
          return ResponseEntity.ok().build();
        } else {
          System.out.println("[SERVER] Error: el usuario ya está registrado.");
          System.out.println("[SERVER] " + usuario1.toString());
          return ResponseEntity.badRequest().build();
        }
    }
 }

