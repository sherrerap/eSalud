package es.e3corp.eSalud.utilidades;

import es.e3corp.eSalud.model.Cita;
import es.e3corp.eSalud.model.Especialidad;
import es.e3corp.eSalud.model.Usuario;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



/**
 * Clase Utilidades.
 * 
 * @author e3corp
 */
public class Utilidades {

  /**
   * Método para encriptar texto.
   * 
   * @author e3corp
   */
  public static String encriptar(final String texto) {

    final String secretKey = "esalud"; // llave para encriptar datos
    String base64EncryptedString = "";

    try {

      final MessageDigest md = MessageDigest.getInstance("MD5");
      final byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
      final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

      final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
      final Cipher cipher = Cipher.getInstance("DESede");
      cipher.init(Cipher.ENCRYPT_MODE, key);

      final byte[] plainTextBytes = texto.getBytes("utf-8");
      final byte[] buf = cipher.doFinal(plainTextBytes);
      final byte[] base64Bytes = Base64.encodeBase64(buf);
      base64EncryptedString = new String(base64Bytes);

    } catch (Exception ex) {
    }
    return base64EncryptedString;
  }

  /**
   * Método para desencriptar texto.
   * 
   * @author e3corp
   */

  public static String desencriptar(final String textoEncriptado) throws Exception {

    final String secretKey = "esalud"; // llave para desencriptar datos
    String base64EncryptedString = "";

    try {
      final byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
      final MessageDigest md = MessageDigest.getInstance("MD5");
      final byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
      final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
      final SecretKey key = new SecretKeySpec(keyBytes, "DESede");

      final Cipher decipher = Cipher.getInstance("DESede");
      decipher.init(Cipher.DECRYPT_MODE, key);

      final byte[] plainText = decipher.doFinal(message);

      base64EncryptedString = new String(plainText, "UTF-8");

    } catch (Exception ex) {
    }
    return base64EncryptedString;
  }

  /**
   * Método para desencriptar usuario.
   * 
   * @author e3corp
   */

  public static Optional<Usuario> desencriptarOptionalUsuario(final Optional<Usuario> user) {

    try {

      user.get().setDni(desencriptar(user.get().getDni()));
      user.get().setNombre(desencriptar(user.get().getNombre()));
      user.get().setApellidos(desencriptar(user.get().getApellidos()));
      user.get().setcontrasena(desencriptar(user.get().getcontrasena()));
      user.get().setRol(desencriptar(user.get().getRol()));
      user.get().setEspecialidad(desencriptar(user.get().getEspecialidad()));
      user.get().setMedico(desencriptar(user.get().getMedico()));
      user.get().setNumTelefono(desencriptar(user.get().getNumTelefono()));
      user.get().setLocalidad(desencriptar(user.get().getLocalidad()));
      user.get().setCentro(desencriptar(user.get().getCentro()));
      user.get().setEmail(desencriptar(user.get().getEmail()));
      return user;
    } catch (Exception ex) {

      return null;
    }

  }

  /**
   * Método para desencriptar usuario.
   * 
   * @author e3corp
   */
  public static Usuario desencriptarUsuario(final Usuario user) {

    try {

      user.setDni(desencriptar(user.getDni()));
      user.setNombre(desencriptar(user.getNombre()));
      user.setApellidos(desencriptar(user.getApellidos()));
      user.setcontrasena(desencriptar(user.getcontrasena()));
      user.setRol(desencriptar(user.getRol()));
      user.setEspecialidad(desencriptar(user.getEspecialidad()));
      user.setMedico(desencriptar(user.getMedico()));
      user.setNumTelefono(desencriptar(user.getNumTelefono()));
      user.setLocalidad(desencriptar(user.getLocalidad()));
      user.setCentro(desencriptar(user.getCentro()));
      user.setEmail(desencriptar(user.getEmail()));
      return user;
    } catch (Exception ex) {

      return null;
    }

  }

  /**
   * Método para desencriptar una lista de usuarios.
   * 
   * @author e3corp
   */
  public static List<Usuario> desencriptarListaUsuarios(final Optional<List<Usuario>> users) {

    final List<Usuario> usersDesencriptado = new ArrayList<Usuario>();
    System.out.println("Tamaño de la lista normal: " + users.get().size());

    for (int i = 0; i < users.get().size(); i++) {
      final Usuario usuario = users.get().get(i);
      System.out.println(usuario.toString());
      // aun no desencripta porque no coinciden los valores que hay en la BBDD
      usersDesencriptado.add(desencriptarUsuario(usuario));

      // usersDesencriptado.add(usuario);
    }

    return usersDesencriptado;
  }

  /**
   * Método para desencriptar usuarios.
   * 
   * @author e3corp
   */
  public static List<Usuario> desencriptarUsuarios(final List<Usuario> users) {

    final List<Usuario> usersDesencriptado = new ArrayList<Usuario>();
    System.out.println("Tamaño de la lista normal: " + users.size());

    for (int i = 0; i < users.size(); i++) {
      final Usuario usuario = users.get(i);
      System.out.println(usuario.toString());
      // aun no desencripta porque no coinciden los valores que hay en la BBDD
      usersDesencriptado.add(desencriptarUsuario(usuario));

      // usersDesencriptado.add(usuario);
    }

    return usersDesencriptado;
  }

  /**
   * Método para desenciptar citas.
   * 
   * @author e3corp
   */

  public static Cita desencriptarCita(final Cita cita1) {
    try {
      final Cita cita = new Cita();

      cita.setId(cita1.getId());
      cita.setPaciente(desencriptar(cita1.getPaciente()));
      cita.setPaciente(desencriptar(cita1.getPaciente()));

      cita.setMedico(desencriptar(cita1.getMedico()));
      cita.setMedico(desencriptar(cita1.getMedico()));

      cita.setFecha(desencriptar(cita1.getFecha()));
      cita.setFecha(desencriptar(cita1.getFecha()));

      cita.setHora(desencriptar(cita1.getHora()));
      cita.setHora(desencriptar(cita1.getHora()));

      cita.setTipo(desencriptar(cita1.getTipo()));
      cita.setTipo(desencriptar(cita1.getTipo()));

      cita.setCentro(desencriptar(cita1.getCentro()));
      cita.setCentro(desencriptar(cita1.getCentro()));
      return cita;
    }

    catch (Exception ex) {

      return null;
    }
  }

  /**
   * Método para desencriptar lista de citas.
   * 
   * @author e3corp
   */
  public static List<Cita> desencriptarListaCitas(final List<Cita> citas) {
    final List<Cita> citasDesencriptado = new ArrayList<Cita>();
    for (final Cita citasDesencriptadas : citas) {
      citasDesencriptado.add(desencriptarCita(citasDesencriptadas));
    }

    return citasDesencriptado;
  }

  /**
   * desenciptarCita.
   * 
   * @author e3corp
   */

  public static Optional<Cita> desencriptarOptionalCita(final Optional<Cita> cita) {
    try {

      cita.get().setPaciente(desencriptar(cita.get().getPaciente()));
      cita.get().setPaciente(desencriptar(cita.get().getPaciente()));

      cita.get().setMedico(desencriptar(cita.get().getMedico()));
      cita.get().setMedico(desencriptar(cita.get().getMedico()));

      cita.get().setFecha(desencriptar(cita.get().getFecha()));
      cita.get().setFecha(desencriptar(cita.get().getFecha()));

      cita.get().setHora(desencriptar(cita.get().getHora()));
      cita.get().setHora(desencriptar(cita.get().getHora()));

      cita.get().setTipo(desencriptar(cita.get().getTipo()));
      cita.get().setTipo(desencriptar(cita.get().getTipo()));

      cita.get().setCentro(desencriptar(cita.get().getCentro()));
      cita.get().setCentro(desencriptar(cita.get().getCentro()));
      return cita;
    } catch (Exception ex) {

      return null;
    }
  }

  /**
   * Método para desencriptar especialidad.
   * 
   * @author e3corp
   */
  public static Optional<Especialidad> desencriptarOptionalEspecialidad(final Optional<Especialidad> especialidad) {
    try {

      especialidad.get().setEspecialidad(desencriptar(especialidad.get().getEspecialidad()));
      especialidad.get().setHoraInicio(desencriptar(especialidad.get().getHoraInicio()));
      especialidad.get().setHoraFin(desencriptar(especialidad.get().getHoraFin()));
      especialidad.get().setTiempoConsulta(desencriptar(especialidad.get().getTiempoConsulta()));
      return especialidad;
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   * Método para desencriptar lista de especialidades.
   * 
   * @author e3corp
   */
  public static List<Especialidad> desencriptarListaEspecialidades(final Optional<List<Especialidad>> especialidades) {
    final List<Especialidad> especialidadesDesencriptado = new ArrayList<Especialidad>();
    System.out.println("Tamaño de la lista normal: " + especialidades.get().size());

    for (int i = 0; i < especialidades.get().size(); i++) {
      final Especialidad especialidad = especialidades.get().get(i);
      System.out.println(especialidad.toString());
      especialidadesDesencriptado.add(desencriptarEspecialidad(especialidad));
    }

    return especialidadesDesencriptado;

  }

  /**
   * Método para desencriptar especialidad.
   * 
   * @author e3corp
   */

  public static Especialidad desencriptarEspecialidad(final Especialidad especialidad) {
    try {

      especialidad.setEspecialidad(desencriptar(especialidad.getEspecialidad()));
      especialidad.setHoraInicio(desencriptar(especialidad.getHoraInicio()));
      especialidad.setHoraFin(desencriptar(especialidad.getHoraFin()));
      especialidad.setTiempoConsulta(desencriptar(especialidad.getTiempoConsulta()));

      return especialidad;
    } catch (Exception ex) {

      return null;
    }

  }

}
