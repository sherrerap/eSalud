package es.e3corp.eSalud.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * Esta excepción saltará si un usuario no es encontrado.
 * 
 * @author e3corp
 *
 */
public class UserNotFoundException extends NestedRuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Este método muestra el mensaje de excepción de usuario no encontrado.
   */
  public UserNotFoundException(final String userId) {

    super(String.format("User with  Id '%s' not found", userId));

  }

}