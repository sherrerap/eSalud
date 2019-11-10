
package es.e3corp.eSalud.Service;

import java.util.List;

import es.e3corp.eSalud.model.Usuario;

/**
 * @author e3corp
 */
public interface UsuarioService {
  /**
   * @author e3corp
   */
  List<Usuario> findAll();

  /**
   * @author e3corp
   */
  Usuario findByUserDni(String dni);

  /**
   * @author e3corp
   */
  void saveUsuario(Usuario usuario);

  /**
   * @author e3corp
   */
  void updateUsuario(Usuario usuario);

  /**
   * @author e3corp
   */
  void deleteUsuario(String userId);

  /**
   * @author e3corp
   */
  Usuario getUserByDniAndPassword(String dni, String password);

  /**
   * @author e3corp
   */
  List<Usuario> getUsersByRol(String rol);

}