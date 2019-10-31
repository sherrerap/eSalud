package es.e3corp.eSalud.bdd.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.repository.UsuarioRepository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.*;

@SpringBootTest
public class CrearUsuarioSteps {
	
	
	 @Autowired
	    private UsuarioRepository usuarioRepository;
	    private Usuario u;

	@Given("se registra un usuario con los siguientes campos")
	public void se_registra_un_usuario_paciente_con_los_siguientes_campos() {
		 u = new Usuario("05706193P", "Hector", "Estoy hasta los huevos", "12343", "paciente", "", "", 845302345, "Miguelturra",
	                "coijenwa", "emai");
	    
	}

	@When("el usuario guarda sus datos con los campos requeridos")
	public void el_usuario_guarda_sus_datos_con_los_campos_requeridos() {
		this.usuarioRepository.saveUsuario(u);
	    
	}

	@Then("el resultado de guardar el usuario es correcto")
	public void el_resultado_de_guardar_el_usuario_es_correcto() {
	    assertEquals(u.getDni(), this.usuarioRepository.findByDniAndContraseña(u.getDni(), u.getContraseña()).getDni());
	}

}
