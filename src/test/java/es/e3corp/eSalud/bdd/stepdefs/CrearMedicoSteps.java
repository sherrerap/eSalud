package es.e3corp.eSalud.bdd.stepdefs;

import org.springframework.boot.test.context.SpringBootTest;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest
public class CrearMedicoSteps {

    @Given("^Se registra un usuario medico con los siguientes campos$")
    public void se_registra_un_usuario_medico_con_los_siguientes_campos(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        // throw new PendingException();
    }

    @When("^el usuario medico guarda sus datos 'con todos los campos requeridos'$")
    public void el_usuario_medico_guarda_sus_datos_con_todos_los_campos_requeridos() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
    }

    @Then("^el resultado de guardar el usuario medico 'es correcto'$")
    public void el_resultado_de_guardar_el_usuario_medico_es_correcto() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
    }

}
