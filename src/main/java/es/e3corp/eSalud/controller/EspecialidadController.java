package es.e3corp.eSalud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.e3corp.eSalud.Service.EspecialidadService;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = { "http://localhost:4200", "https://esalud.herokuapp.com" }, allowedHeaders = "*")
/**
 * @author e3corp
 */
public class EspecialidadController {
  /**
   * Campo LOG.
   * 
   * @author e3corp
   */
  private static final Log LOG = LogFactory.getLog(EspecialidadController.class);
  /**
   * Interfaz EspecialidadService.
   * 
   * @author e3corp
   */
  private final EspecialidadService especialidadService;

  @Autowired
  /**
   * Contructor EspecialidadController.
   * 
   * @author e3corp
   */
  public EspecialidadController(EspecialidadService especialidadService) {
    super();
    this.especialidadService = especialidadService;
  }

}
