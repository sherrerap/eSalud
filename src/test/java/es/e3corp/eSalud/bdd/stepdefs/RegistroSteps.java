package es.e3corp.eSalud.bdd.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegistroSteps {

	@Given("^tenemos un usuario vacio$")
	public void tenemos_un_usuario_vacio() throws Throwable {
	   
	}

	@When("^llamo al recurso \"(.*?)\" con los \"(.*?)\" de registro$")
	public void llamo_al_recurso_con_los_de_registro(String arg1, String arg2) throws Throwable {
	    
	}

	@Then("^introducimos los \"(.*?)\" a la base de datos$")
	public void introducimos_los_a_la_base_de_datos(String arg1) throws Throwable {
	   
	}
	@Then("^recibimos el codigo (\\d+)$")
	public void recibimos_el_codigo(int arg1) throws Throwable {
//		OkHttpClient client = new OkHttpClient();
//
//		Request request = new Request.Builder()
//		  .url("http://")
//		  .get()
//		  .addHeader("cache-control", "no-cache")
//		  .addHeader("Postman-Token", "9df3c40b-85a0-4153-a787-24790278fa67")
//		  .build();
//
//		Response response = client.newCall(request).execute(); 
	}
}
