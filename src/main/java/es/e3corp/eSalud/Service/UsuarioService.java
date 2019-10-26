
package es.e3corp.eSalud.Service;
import es.e3corp.eSalud.model.Usuario;
import java.util.List;


public interface UsuarioService {


  List<Usuario> findAll();


  Usuario findByUserId(String id);


  Usuario saveUsuario(Usuario usuario);


  void updateUsuario(Usuario usuario);


  void deleteUsuario(String userId);

}