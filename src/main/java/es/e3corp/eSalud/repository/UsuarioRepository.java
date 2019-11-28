package es.e3corp.eSalud.repository;

import es.e3corp.eSalud.model.Usuario;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

/**
 * Interfaz de UsuarioRepository.
 * 
 * @author e3corp
 */
@Repository
public interface UsuarioRepository {
  /**
   * Método que te devuelve todos los usuarios.
   *  
   * @author e3corp
   */
  Optional<List<Usuario>> findAll();

  /**
   * Método para guardar un usuario.
   * 
   * @author e3corp
   */
  void saveUsuario(Usuario usuario);

  /**
   * Método para actualizar un usuario.
   * 
   * @author e3corp
   */
  void updateUsuario(Usuario usuario);

  /**
   * Método para borrar un usuario.
   * 
   * @author e3corp
   */
  void deleteUsuario(String usuarioId);

  /**
   * Método para obtener un usuario por su id.
   * 
   * @author e3corp
   */
  Optional<Usuario> findOne(String userId);

  /**
   * Método para obtener un usuario por su dni y contraseña.
   * 
   * @author e3corp
   */
  Usuario findByDniAndContrasena(String dni, String contrasena);

  /**
   * Método para obtener un usuario en función de su rol.
   * 
   * @author e3corp
   */
  List<Usuario> findByRol(String rol);

}