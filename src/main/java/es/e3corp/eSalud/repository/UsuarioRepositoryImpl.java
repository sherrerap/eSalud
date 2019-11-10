package es.e3corp.eSalud.repository;

import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.stereotype.Repository;

import org.springframework.util.Assert;

import java.util.List;

import java.util.Optional;

import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;

@Repository

public class UsuarioRepositoryImpl implements UsuarioRepository {

	private final MongoOperations mongoOperations;

	@Autowired

	public UsuarioRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations, "notNull");
		this.mongoOperations = mongoOperations;

	}

	// Find all users

	public Optional<List<Usuario>> findAll() {

		List<Usuario> users = this.mongoOperations.find(new Query(), Usuario.class);

		Optional<List<Usuario>> optionalUsuarios = Optional.ofNullable(users);

		return optionalUsuarios;

  }
  
  

	public Optional<Usuario> findOne(String dni) {
		System.out.println("el usuario buscado encriptado es: "+dni );
		Usuario d = this.mongoOperations.findOne(new Query(Criteria.where("dni").is(dni)), Usuario.class);
		Optional<Usuario> usuario = Optional.ofNullable(d);
		return usuario;
	}

	public void saveUsuario(Usuario usuario) {
		this.mongoOperations.save(usuario);
	}

	public void updateUsuario(Usuario usuario) {

		this.mongoOperations.save(usuario);

	}

	public void deleteUsuario(String id) {

		this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Usuario.class);

	}

  @Override
  public Usuario findByDniAndContraseña(String dni, String contraseña) {
    Usuario usuario = this.mongoOperations
        .findOne(new Query(Criteria.where("dni").is(dni).and("contraseña").is(contraseña)), Usuario.class);
    return usuario;
  }
  
  @Override
  public List<Usuario> findByRol(String rol) {
    List <Usuario> usuariosRol = this.mongoOperations.find(new Query(Criteria.where("rol").is(rol)),Usuario.class);
    return usuariosRol;
  }

}
