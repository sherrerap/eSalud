package es.e3corp.eSalud.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * Clase de excepciones de especialidades. author: a3corp
 */
public class EspecialidadNotFoundException extends NestedRuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Este método muestra el mensaje de excepción de especialidad no encontrado.
   */
  public EspecialidadNotFoundException(final String nombre) {

    super(String.format("Especialidad with name '%s' not found", nombre));

  }
}
