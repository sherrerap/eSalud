
package es.e3corp.eSalud.Service;

import es.e3corp.eSalud.model.Usuario;
import java.util.List;

/**
 * Clase UsuarioService.
 * @author e3corp
 */
public interface UsuarioService {
  /**
   * Lista de usuarios.
   * @author e3corp
   */
  List<Usuario> findAll();

  /**
   * Método para encontrar usuarios por dni.
   * @author e3corp
   */
  Usuario findByUserDni(String dni);

  /**
   * Método para guardar usuarios.
   * @author e3corp
   */
  void saveUsuario(Usuario usuario);

  /**
   * Metodo para actualizar usuarios.
   * @author e3corp
   */
  void updateUsuario(Usuario usuario);

  /**
   * Metodo para borrar usuarios de la bbdd.
   * @author e3corp
   */
  void deleteUsuario(String userId);

  /**
   * Metodo para obtener usuarios por dni y contraseña.
   * @author e3corp
   */
  Usuario getUserByDniAndPassword(String dni, String password);

  /**
   * Metodo para obtener usuarios por rol.
   * @author e3corp
   */
  List<Usuario> getUsersByRol(String rol);

}