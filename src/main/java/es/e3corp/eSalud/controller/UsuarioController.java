
package es.e3corp.eSalud.controller;
import es.e3corp.eSalud.exception.UserNotFoundException;

import es.e3corp.eSalud.model.Usuario;

import es.e3corp.eSalud.Service.UsuarioService;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

import javax.validation.Valid;

import com.wordnik.swagger.annotations.ApiOperation;


@RestController

@RequestMapping("users")

public class UsuarioController {


    private static final Log log = LogFactory.getLog(UsuarioController.class);


    private final UsuarioService usersService;

    private Usuario user;


    @Autowired

    public UsuarioController(UsuarioService usersService) {

        this.usersService = usersService;

    }


    @RequestMapping(value="/{userId}",method = RequestMethod.GET)

    @ApiOperation(value = "Find an user", notes = "Return a user by Id")

    public ResponseEntity<Usuario> userById(@PathVariable String userId)  throws  UserNotFoundException{

        log.info("Get userById");

        try{

        	user = usersService.findByUserId(userId);

        }catch(UserNotFoundException e){

        	user = null;

        }

        return ResponseEntity.ok(user);


    }

    @RequestMapping(method = RequestMethod.GET)

     public ResponseEntity<List<Usuario>> usuarioById(){

        log.info("Get allUsers");

        return ResponseEntity.ok(usersService.findAll());

    }

/*     @RequestMapping(method = RequestMethod.GET)

    @ApiOperation(value = "Find all user", notes = "Return all users" )

    public ResponseEntity<List<Usuario>> userById(){

        log.info("Get allUsers");

        return ResponseEntity.ok(usersService.findAll());

    }
 */ 
    @RequestMapping(value="/{userId}",method = RequestMethod.DELETE)

    @ApiOperation(value = "Delete an user", notes = "Delete a user by Id")

    public ResponseEntity<Void> deleteUser(@PathVariable String userId){

    	log.info("Delete user " + userId);

        usersService.deleteUsuario(userId);

        return ResponseEntity.noContent().build();

    }


    @RequestMapping(method=RequestMethod.POST)

    @ApiOperation(value = "Create an user", notes = "Create a new user")

    public  ResponseEntity<Usuario> saveUser(@RequestBody @Valid Usuario usuario){

    	log.info("Save new user");

         return ResponseEntity.ok(usersService.saveUsuario(usuario));

    }

} 