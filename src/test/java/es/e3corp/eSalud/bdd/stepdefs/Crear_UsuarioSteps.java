package es.e3corp.eSalud.bdd.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.e3corp.eSalud.model.Usuario;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.springframework.data.mongodb.core.*;

public class Crear_UsuarioSteps {

    private MongoOperations mongoOperations;
    private Usuario u;

    @Given("^Se registra un usuario con los siguientes campos$")
    public void se_registra_un_usuario_con_losa_siguientes_campos(DataTable usuarioDt) {
        List<Usuario> usuarioList = usuarioDt.asList(Usuario.class);
        u = usuarioList.get(0);
    }

    @When("^el paciente guarda sus datos 'con todos los campos requeridos'$")
    public void el_paciente_guarda_sus_datos_con_todos_los_campos_requeridos() {
        this.mongoOperations.save(u);
        
    }

    @Then("^el resultado de guardar el paciente 'es correcto'$")
    public void el_resultado_de_guardar_el_paciente_es_correcto() {
        assertEquals(u.getId(), this.mongoOperations.findById(u.getId(), Usuario.class));
    }

}
