package es.e3corp.eSalud.bdd.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.repository.UsuarioRepository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.*;

public class Modificar_CitaSteps {

    private MongoOperations mongoOperations;
    private CitaRepository citaRepository;
    private Cita citaAntes;
    private Cita citaDespues;

    @Given("se quieren cambiar los valores de los campos de la cita para actualizarlos")
    public void se_quieren_cambiar_los_valores_de_los_campos_de_la_cita_para_actualizarlos(DataTable citaDt) {
        List<Cita> citaList = citaDt.asList(Cita.class);
        citaAntes = this.usuarioRepository.findById(usuarioList.get(0).getId());
        citaDespues = usuarioList.get(1);
    }

    @When("el usuario paciente modifica los datos de una cita")
    public void el_usuario_paciente_modifica_los_datos_de_una_cita() {
    	citaAntes.setDni(citaDespues.getDni());
    	citaAntes.setFecha(citaDespues.getFecha());
    	citaAntes.setHora(citaDespues.getHora());
    	citaAntes.setCentro(citaDespues.getCentro());
    	citaAntes.setIdMedico(citaDespues.getIdMedico());
    	citaAntes.setEspecialidad(citaDespues);
    	citaAntes.setExplicacionCita(citaDespues.getExplicacionCita());
		this.citaRepository.deleteCita(citaDespues.getId());
		this.citaRepository.saveCita(citaAntes);
        
    }

    @Then("el resultado de modificar la cita es correcto")
    public void el_resultado_de_modificar_la_cita_es_correcto() {
    	assertArrayEquals(citaDespues.getDni(), this.citasRepository.findById(citaAntes.getId()).getDni());
    	assertArrayEquals(citaDespues.getFecha(), this.citasRepository.findById(citaAntes.getId()).getFecha());
    	assertArrayEquals(citaDespues.getHora(), this.citasRepository.findById(citaAntes.getId()).getHora());
    	assertArrayEquals(citaDespues.getCentro(), this.citasRepository.findById(citaAntes.getId()).getCentro());
    	assertArrayEquals(citaDespues.getIdMedico(), this.citasRepository.findById(citaAntes.getId()).getIdMedico());
    	assertArrayEquals(citaDespues.getEspecialidad(), this.citasRepository.findById(citaAntes.getId()).getEspecialidad());
    	assertArrayEquals(citaDespues.getExplicacionCita(), this.citasRepository.findById(citaAntes.getId()).getExplicacionCita());
    }

}
