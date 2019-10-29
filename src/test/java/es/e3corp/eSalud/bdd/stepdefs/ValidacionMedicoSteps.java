package es.e3corp.eSalud.bdd.stepdefs;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidacionMedicoSteps {

	@Given("^el usuario medico se da de alta en sistema con los siguientes datos$")
	public void el_usuario_medico_se_da_de_alta_en_sistema_con_los_siguientes_datos(DataTable medicoDt) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	}

	@When("^el usuario medico se guarda con sus datos 'SIN NOMBRE INTRODUCIDO'$")
	public void el_usuario_medico_se_guarda_con_sus_datos_SIN_NOMBRE_INTRODUCIDO() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}

	@Then("^se guarda el medico en la aplicación 'FAILS'$")
	public void se_guarda_el_medico_en_la_aplicación_FAILS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}

	@When("^el usuario medico se guarda con sus datos 'SIN APELLIDOS INTRODUCIDOS'$")
	public void el_usuario_medico_se_guarda_con_sus_datos_SIN_APELLIDOS_INTRODUCIDOS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}

	@When("^el usuario medico se guarda con sus datos 'SIN CONTRASEÑA INTRODUCIDA'$")
	public void el_usuario_medico_se_guarda_con_sus_datos_SIN_CONTRASEÑA_INTRODUCIDA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}

	@When("^el usuario medico se guarda con sus datos 'SIN EMAIL INTRODUCIDO'$")
	public void el_usuario_medico_se_guarda_con_sus_datos_SIN_EMAIL_INTRODUCIDO() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}

	@When("^el usuario medico se guarda con sus datos 'SIN LOCALIDAD INTRODUCIDA'$")
	public void el_usuario_medico_se_guarda_con_sus_datos_SIN_LOCALIDAD_INTRODUCIDA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}

	@Then("^se guarda el medico en la aplicación 'IS SUCCESSFUL'$")
	public void se_guarda_el_medico_en_la_aplicación_IS_SUCCESSFUL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}

	@When("^el usuario medico se guarda con sus datos 'SIN ESPECIALIDAD INTRODUCIDA'$")
	public void el_usuario_medico_se_guarda_con_sus_datos_SIN_ESPECIALIDAD_INTRODUCIDA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Implementation Goes Here
	}
}
