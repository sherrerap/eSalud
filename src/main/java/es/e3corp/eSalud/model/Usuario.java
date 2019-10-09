package es.e3corp.eSalud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection = "usuarios")
public class Usuario {
	
	@Id
	String id;
	String nombre;
	String apellidos;
	String contraseña;
	String email;
	String centro;
	
	public Usuario(String id, String nombre, String apellidos, String contraseña, String email, String centro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contraseña = contraseña;
		this.email = email;
		this.centro = centro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contraseña=" + contraseña
				+ ", email=" + email + ", centro=" + centro + "]";
	}


}
