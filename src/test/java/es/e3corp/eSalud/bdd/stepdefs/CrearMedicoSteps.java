package es.e3corp.eSalud.bdd.stepdefs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.e3corp.eSalud.repository.UsuarioRepository;

import static org.junit.Assert.*;

import org.junit.Test;

@SpringBootTest
public class CrearMedicoSteps {

    @Test
    @Given("^Se registra un usuario medico con los siguientes campos$")
    public void se_registra_un_usuario_paciente_con_los_siguientes_campos(DataTable medicoDt) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)

    }

    @Test(expected = NullPointerException.class)
    @When("^el usuario medico guarda sus datos 'con todos los campos requeridos'$")
    public void el_usuario_paciente_guarda_sus_datos_con_todos_los_campos_requeridos() {

    }

    @Test
    @Then("^el resultado de guardar el usuario medico 'es correcto'$")
    public void el_resultado_de_guardar_el_usuario_es_correcto() {
        // Optional <Usuario> medicoinsertado =
        // crepo.findUsuarioById(medicoUsuario.getId());
        // String idmedicoinsertado = medicoinsertado.get().getId();
        // assertEquals(medicoUsuario.getId(), idmedicoinsertado);
    }

}
