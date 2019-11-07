
package es.e3corp.eSalud.Service;

import java.util.List;

import es.e3corp.eSalud.model.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();

	Usuario findByUserDni(String dni);

	void saveUsuario(Usuario usuario);

	void updateUsuario(Usuario usuario);

	void deleteUsuario(String userId);

	Usuario getUserByDniAndPassword(String dni, String password);

	List<Usuario> getUsersByRole(String rol);

}