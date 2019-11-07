package es.e3corp.eSalud.utilidades;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.constraints.NotNull;

import org.apache.commons.codec.binary.Base64;

import es.e3corp.eSalud.model.Usuario;

public class Utilidades {

	
	
	public static String encriptar(String texto) {

        String secretKey = "esalud"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
	
	public static String desencriptar(String textoEncriptado) throws Exception {

        String secretKey = "esalud"; //llave para desencriptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

	public static Optional<Usuario> desencriptarUsuario(Optional<Usuario> user) {
		
		try {
			
			user.get().setDni(desencriptar(user.get().getDni()));
			user.get().setNombre(desencriptar(user.get().getNombre()));
			user.get().setApellidos(desencriptar(user.get().getApellidos()));
			user.get().setContraseña(desencriptar(user.get().getContraseña()));
			user.get().setRol(desencriptar(user.get().getRol()));
			user.get().setEspecialidad(desencriptar(user.get().getEspecialidad()));
			user.get().setMedico(desencriptar(user.get().getMedico()));
			user.get().setNumTelefono(desencriptar(user.get().getNumTelefono()));
			user.get().setLocalidad(desencriptar(user.get().getLocalidad()));
			user.get().setCentro(desencriptar(user.get().getCentro()));
			user.get().setEmail(desencriptar(user.get().getEmail()));
			return user;
		}
		
		catch (Exception ex) {
			
			return null;
	    }
		
		
	}
	
	
}
