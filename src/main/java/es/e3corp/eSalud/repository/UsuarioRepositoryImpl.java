package es.e3corp.eSalud.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.stereotype.Repository;

import org.springframework.util.Assert;

import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.repository.UsuarioRepository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;

/**
 * @author e3corp
 */
@Repository

public class UsuarioRepositoryImpl implements UsuarioRepository {
  /**
   * @author e3corp
   */
  private final MongoOperations mongoOperations;

  /**
   * @author e3corp
   */
  @Autowired

  public UsuarioRepositoryImpl(final MongoOperations mongoOperations) {
    Assert.notNull(mongoOperations, "notNull");
    this.mongoOperations = mongoOperations;

  }

  // Find all users
  /**
   * @author e3corp
   */
  public Optional<List<Usuario>> findAll() {

    List<Usuario> users = this.mongoOperations.find(new Query(), Usuario.class);

    Optional<List<Usuario>> optionalUsuarios = Optional.ofNullable(users);

    return optionalUsuarios;

  }

  /**
   * @author e3corp
   */
  public Optional<Usuario> findOne(final String dni) {
    System.out.println("el usuario buscado encriptado es: " + dni);
    Usuario d = this.mongoOperations.findOne(new Query(Criteria.where("dni").is(dni)), Usuario.class);
    Optional<Usuario> usuario = Optional.ofNullable(d);
    return usuario;
  }

  /**
   * @author e3corp
   */
  public void saveUsuario(final Usuario usuario) {
    this.mongoOperations.save(usuario);
  }

  /**
   * @author e3corp
   */
  public void updateUsuario(final Usuario usuario) {

    this.mongoOperations.save(usuario);

  }

  /**
   * @author e3corp
   */
  public void deleteUsuario(final String id) {

    this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Usuario.class);

  }

  @Override
  public Usuario findByDniAndContrasena(final String dni, final String contrasena) {
    Usuario usuario = this.mongoOperations
        .findOne(new Query(Criteria.where("dni").is(dni).and("contraseña").is(contrasena)), Usuario.class);
    return usuario;
  }

  @Override
  public List<Usuario> findByRol(final String rol) {
    List<Usuario> usuariosRol = this.mongoOperations.find(new Query(Criteria.where("rol").is(rol)), Usuario.class);
    return usuariosRol;
  }

}
