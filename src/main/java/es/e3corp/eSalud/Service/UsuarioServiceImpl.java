package es.e3corp.eSalud.Service;

import es.e3corp.eSalud.exception.UserNotFoundException;
import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.repository.UsuarioRepository;
import es.e3corp.eSalud.utilidades.Utilidades;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("UsuarioService")
/**
 * @author e3corp
 */
@Transactional

public class UsuarioServiceImpl implements UsuarioService {
  /**
   * Variable de Log.
   * @author e3corp
   */
  private static final Log LOG = LogFactory.getLog(UsuarioServiceImpl.class);
  /**
   * Variable de repositorio de usuario.
   * @author e3corp
   */
  private UsuarioRepository userRepository;

  /**
   * Constructor.
   * @author e3corp
   */
  @Autowired

  public UsuarioServiceImpl(final UsuarioRepository userRepository) {

    this.userRepository = userRepository;

  }

  /**
   * Método para encontrar usuarios por dni.
   * @author e3corp
   */
  @Override
  public Usuario findByUserDni(final String userDni) {

    final Optional<Usuario> user = userRepository.findOne(userDni);

    if (user.isPresent()) {

      LOG.debug(String.format("Read userId '{}'", userDni));

      final Optional<Usuario> userDesencriptado = Utilidades.desencriptarOptionalUsuario(user);

      return userDesencriptado.get();

    } else {

      throw new UserNotFoundException(userDni);

    }

  }

  /**
   * Método para encontrar todos los usuarios.
   * @author e3corp
   */
  @Override
  public List<Usuario> findAll() {

    final Optional<List<Usuario>> users = userRepository.findAll();

    return  Utilidades.desencriptarListaUsuarios(users);

  }

  /**
   * Método para guardar usuarios.
   * @author e3corp
   */
  @Override
  public void saveUsuario(final Usuario usuario) {

    userRepository.saveUsuario(usuario);

  }

  /**
   * Método para actualizar usuarios.
   * @author e3corp
   */
  @Override
  public void updateUsuario(final Usuario user) {

    userRepository.updateUsuario(user);

  }

  /**
   * Método para borrar usuarios.
   * @author e3corp
   */
  @Override
  public void deleteUsuario(final String userId) {

    userRepository.deleteUsuario(userId);

  }

  @Override
  public Usuario getUserByDniAndPassword(final String dni, final String password) {
    // System.out.println("[SERVER] DNI recibido: " + dni);
    // System.out.println("[SERVER] Contraseña recibida: " + password);

    final Usuario usuario = userRepository.findByDniAndContrasena(dni, password);
    return Utilidades.desencriptarUsuario(usuario);
  }

  @Override
  public List<Usuario> getUsersByRol(final String rol) {
    return userRepository.findByRol(rol);
  }

}
