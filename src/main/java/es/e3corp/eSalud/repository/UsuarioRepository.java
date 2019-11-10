package es.e3corp.eSalud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.e3corp.eSalud.model.Usuario;

/**
 * @author e3corp
 */
@Repository
public interface UsuarioRepository {
  /**
   * @author e3corp
   */
  Optional<List<Usuario>> findAll();

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
  void deleteUsuario(String usuarioId);

  /**
   * @author e3corp
   */
  Optional<Usuario> findOne(String userId);

  /**
   * @author e3corp
   */
  Usuario findByDniAndContrasena(String dni, String contrasena);

  /**
   * @author e3corp
   */
  List<Usuario> findByRol(String rol);

}