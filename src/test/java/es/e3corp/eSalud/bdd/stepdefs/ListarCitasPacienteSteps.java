package es.e3corp.eSalud.bdd.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListarCitasPacienteSteps {
    @When("el usuario pulsa en lista de citas")
    public void el_usuario_pulsa_en_lista_de_citas(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @Then("se muestra la lista de citas del paciente {string}")
    public void se_muestra_la_lista_de_citas_del_paciente(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
