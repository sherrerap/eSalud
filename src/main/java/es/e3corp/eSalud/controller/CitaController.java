
package es.e3corp.eSalud.controller;

import es.e3corp.eSalud.exception.CitaNotFoundException;

import es.e3corp.eSalud.model.Cita;

import es.e3corp.eSalud.Service.CitaService;

import java.util.List;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = { "http://localhost:4200", "https://esalud.herokuapp.com" }, allowedHeaders = "*")
public class CitaController {

  private static final Log log = LogFactory.getLog(CitaController.class);
  private final CitaService citasService;
  private Cita cita;

  @Autowired
  public CitaController(CitaService citasService) {
    this.citasService = citasService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Cita> getCitaFecha(@RequestParam(required = false) String paciente,
      @RequestParam(required = false) String médico, @RequestParam(required = false) String fecha,
      @RequestParam(required = false) String hora) {
    Cita cita = citasService.getCitaByPacienteMedicoFechaHora(paciente, médico, fecha, hora);
    if (cita != null) {
      System.out.println("[SERVER] Cita encontrada: " + cita.getId());
      return ResponseEntity.ok(cita);
    } else {
      System.out.println("[SERVER] No se ha encontrado ninguna cita.");
      return ResponseEntity.badRequest().build();
    }
  }
  @RequestMapping(value = "paciente/{dni}", method = RequestMethod.GET)
  public ResponseEntity<List<Cita>> getListadoCitasByPaciente(@PathVariable(required = true) String dni){
	  List<Cita> citas= citasService.getCitasByPaciente(dni);
	  return ResponseEntity.ok(citas);
  }
  
  @RequestMapping(value = "medico/{id}", method = RequestMethod.GET)
  public ResponseEntity<List<Cita>> getListadoCitasByMedico(@PathVariable(required = true) String id){
	  List<Cita> citas= citasService.getCitasByMedico(id);
	  return ResponseEntity.ok(citas);
  }
  

  @RequestMapping(value = "/{citaId}", method = RequestMethod.GET)
  @ApiOperation(value = "Find cita", notes = "Return a cita by Id")
  public ResponseEntity<Cita> citaById(@PathVariable String citaId) throws CitaNotFoundException {
    log.info("Get citaById");
    try {
      cita = citasService.findByCitaId(citaId);
    } catch (CitaNotFoundException e) {
      cita = null;
    }
    return ResponseEntity.ok(cita);
  }

  @RequestMapping(value = "{citaId}", method = RequestMethod.DELETE)
  @ApiOperation(value = "Delete cita", notes = "Delete cita")
  public ResponseEntity<Void> deleteCita(@PathVariable String citaId) {
    log.info("[SERVER] Borrando cita:  " + citaId);
    citasService.deleteCita(citaId);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Cita> registrarCita(@RequestBody String p) {
    JSONObject jso = new JSONObject(p);
    String paciente = jso.getString("paciente");
    String médico = jso.getString("médico");
    String fecha = jso.getString("fecha");
    String hora = jso.getString("hora");
    Cita cita1 = citasService.getCitaByPacienteMedicoFechaHora(paciente, médico, fecha, hora);
    if (cita1 == null) {
      String tipo = null, centro = null;

      try {
        System.out.println("[SERVER] Registrando cita...");

        tipo = jso.getString("tipo");
        centro = jso.getString("centro");

      } catch (JSONException j) {
        System.out.println("[SERVER] Error en la lectura del JSON.");
        System.out.println(j.getMessage());
        return ResponseEntity.badRequest().build();
      }

      cita1 = new Cita(paciente, tipo, fecha, centro, médico, hora);
      citasService.saveCita(cita1);
      System.out.println("[SERVER] Cita registrada.");
      System.out.println("[SERVER] " + cita1.toString());
      return ResponseEntity.ok().build();
    } else {
      System.out.println("[SERVER] Error: la cita ya está registrada.");
      return ResponseEntity.badRequest().build();
    }
  }

}