package es.e3corp.eSalud.Service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.e3corp.eSalud.exception.UserNotFoundException;
import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.repository.UsuarioRepository;
import es.e3corp.eSalud.utilidades.Utilidades;

@Service("UsuarioService")

@Transactional

public class UsuarioServiceImpl implements UsuarioService {

  private static final Log log = LogFactory.getLog(UsuarioServiceImpl.class);

  private UsuarioRepository userRepository;

  @Autowired

  public UsuarioServiceImpl(UsuarioRepository userRepository) {

    this.userRepository = userRepository;

  }

  public Usuario findByUserDni(String userDni) {

    Optional<Usuario> user = userRepository.findOne(userDni);

    if (user.isPresent()) {

      log.debug(String.format("Read userId '{}'", userDni));
      
      Optional<Usuario> userDesencriptado = Utilidades.desencriptarUsuario(user);
      
      return userDesencriptado.get();

    } else

      throw new UserNotFoundException(userDni);

  }

  public List<Usuario> findAll() {

    Optional<List<Usuario>> user = userRepository.findAll();

    return user.get();

  }

  public void saveUsuario(Usuario usuario) {

    userRepository.saveUsuario(usuario);

  }

  public void updateUsuario(Usuario user) {

    userRepository.updateUsuario(user);

  }

  public void deleteUsuario(String userId) {

    userRepository.deleteUsuario(userId);

  }

    @Override
    public Usuario getUserByDniAndPassword(String dni, String password) {
        //System.out.println("[SERVER] DNI recibido: " + dni);
        //System.out.println("[SERVER] Contraseña recibida: " + password);

    Usuario usuario = userRepository.findByDniAndContraseña(dni, password);
    return usuario;
  }

}
