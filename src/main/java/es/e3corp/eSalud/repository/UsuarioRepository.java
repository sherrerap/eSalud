package es.e3corp.eSalud.repository;

import es.e3corp.eSalud.model.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository {
	
    Optional<List<Usuario>> findAll();

    public void saveUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void deleteUsuario(String usuarioId);

    Optional<Usuario> findOne(String userId);

    Usuario findByDniAndContraseña(String dni, String contraseña);

	List<Usuario> findByRole(String rol);

}