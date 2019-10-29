package es.e3corp.eSalud.bdd.stepdefs;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CrearPacienteSteps {
	@Given("^Se registra un usuario paciente con los siguientes campos$")
	public void se_registra_un_usuario_paciente_con_los_siguientes_campos(DataTable pacienteDt){
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	}

	@When("^el usuario paciente guarda sus datos 'con todos los campos requeridos'$")
	public void el_usuario_paciente_guarda_sus_datos_con_todos_los_campos_requeridos() {
	    
		// Implementation Goes Here
		
	}

	@Then("^el resultado de guardar el usuario 'es correcto'$")
	public void el_resultado_de_guardar_el_usuario_es_correcto() throws Throwable {
		// Implementation Goes Here
	}
}
