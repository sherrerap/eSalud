package es.e3corp.eSalud.bdd.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActualizarUsuarioPacienteSteps {
    @Given("^se quieren cambiar los valores de los campos del usuario para actualizarlos$")
    public void se_quieren_cambiar_los_valores_de_los_campos_del_usuario_para_actualizarlos(DataTable pacienteDt)
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        // Implementation Goes Here
        // List<UsuarioDocument> listaPaciente =
        // pacienteDt.asList(UsuarioDocument.class);
    }

    @When("^cuando se salves los cambios del usuario paciente en sus datos 'SIN NOMBRE INTRODUCIDO'$")
    public void cuando_se_salves_los_cambios_del_usuario_paciente_en_sus_datos_SIN_NOMBRE_INTRODUCIDO()
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Implementation Goes Here
    }

    @Then("^se realzia el cambio correctamente 'FAILS'$")
    public void se_realzia_el_cambio_correctamente_FAILS() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Implementation Goes Here
    }

    @When("^cuando se salves los cambios del usuario paciente en sus datos 'SIN APELLIDOS INTRODUCIDOS'$")
    public void cuando_se_salves_los_cambios_del_usuario_paciente_en_sus_datos_SIN_APELLIDOS_INTRODUCIDOS()
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Implementation Goes Here
    }

    @When("^cuando se salves los cambios del usuario paciente en sus datos 'SIN CONTRASEÑA INTRODUCIDA'$")
    public void cuando_se_salves_los_cambios_del_usuario_paciente_en_sus_datos_SIN_CONTRASEÑA_INTRODUCIDA()
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Implementation Goes Here
    }

    @When("^cuando se salves los cambios del usuario paciente en sus datos 'SIN EMAIL INTRODUCIDO'$")
    public void cuando_se_salves_los_cambios_del_usuario_paciente_en_sus_datos_SIN_EMAIL_INTRODUCIDO()
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Implementation Goes Here
    }

    @When("^cuando se salves los cambios del usuario paciente en sus datos 'SIN LOCALIDAD INTRODUCIDA'$")
    public void cuando_se_salves_los_cambios_del_usuario_paciente_en_sus_datos_SIN_LOCALIDAD_INTRODUCIDA()
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Implementation Goes Here
    }

    @Then("^se realzia el cambio correctamente 'IS SUCCESSFUL'$")
    public void se_realzia_el_cambio_correctamente_IS_SUCCESSFUL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Implementation Goes Here
    }
}
