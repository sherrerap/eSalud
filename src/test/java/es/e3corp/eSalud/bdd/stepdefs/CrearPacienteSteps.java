package es.e3corp.eSalud.bdd.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.repository.UsuarioRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrearPacienteSteps {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private Usuario u;

    @Given("^Se registra un usuario paciente con los siguientes campos$")
    public void se_registra_un_usuario_paciente_con_los_siguientes_campos(DataTable pacienteDt) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        // List<Usuario> pacienteList = pacienteDt.asList(Usuario.class);
        u = new Usuario("975324508", "fadsguyd", "gdsufhgidf", "12343", "paciente", "", "", 845302345, "Miguelturra",
                "coijenwa", "emai");
        // u = pacienteList.get(0);
    }

    @When("^el usuario paciente guarda sus datos 'con todos los campos requeridos'$")
    public void el_usuario_paciente_guarda_sus_datos_con_todos_los_campos_requeridos() {
        this.usuarioRepository.saveUsuario(u);
    }

    @Then("^el resultado de guardar el usuario 'es correcto'$")
    public void el_resultado_de_guardar_el_usuario_es_correcto() throws Throwable {
        assertEquals(u.getDni(), this.usuarioRepository.findByDniAndContraseña(u.getDni(), u.getContraseña()).getDni());
    }
}
