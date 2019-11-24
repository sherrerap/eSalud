package es.e3corp.eSalud.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * Clase de excepciones de citas. author: a3corp
 */
public class CitaNotFoundException extends NestedRuntimeException {

  /**
   * serialVersionUID. author: a3corp
   */
  private static final long serialVersionUID = 1L;

  /**
   * Método principal que lanza el mensaje de excepción. author: a3corp
   */
  public CitaNotFoundException(final String idcita) {

    super(String.format("Cita with  Id '%s' not found", idcita));

  }

}