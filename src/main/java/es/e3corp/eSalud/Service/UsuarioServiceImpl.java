package es.e3corp.eSalud.Service;

import es.e3corp.eSalud.model.Usuario;

import es.e3corp.eSalud.exception.UserNotFoundException;

import es.e3corp.eSalud.repository.UsuarioRepository;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Optional;

@Service("UsuarioService")

@Transactional

public class UsuarioServiceImpl implements UsuarioService {

	private static final Log log = LogFactory.getLog(UsuarioServiceImpl.class);

	private UsuarioRepository userRepository;

	@Autowired

	public UsuarioServiceImpl(UsuarioRepository userRepository) {

		this.userRepository = userRepository;

	}

	public Usuario findByUserId(String userId) {

		Optional<Usuario> user = userRepository.findOne(userId);

		if (user.isPresent()) {

			log.debug(String.format("Read userId '{}'", userId));

			return user.get();

		} else

			throw new UserNotFoundException(userId);

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
	public Usuario getUserByDniAndPassword(String dni, String password) 
	{
		System.out.println("Dni que llega: "+dni);
		System.out.println("Password que llega: "+password);

		Usuario usuario = userRepository.findByDniAndContraseña(dni, password);
		return usuario;
	}


}
