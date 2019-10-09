package es.e3corp.proyecto.repository;

import es.e3corp.proyecto.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends MongoRepository<Usuario, String> {

} 