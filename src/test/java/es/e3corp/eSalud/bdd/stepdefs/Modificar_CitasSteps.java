package es.e3corp.eSalud.bdd.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import es.e3corp.eSalud.model.Usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.*;

@SpringBootTest
public class Modificar_CitasSteps {
	
	WebDriver driver;
	CitasRepository citasRepository;
    Cita c = new Cita();
    List<Map<String, String>> a;
    

    	@Given("el usuario se ha logueado y quiere cambiar los valores de los campos de la cita para actualizarlos")
    	public void el_usuario_se_ha_logueado_y_quiere_cambiar_los_valores_de_los_campos_de_la_cita_para_actualizarlos(io.cucumber.datatable.DataTable dataTable) {

    		driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://esalud.herokuapp.com/modificarcita");
    	}

    	@When("el usuario paciente modifica los datos de una cita")
    	public void el_usuario_paciente_modifica_los_datos_de_una_cita(io.cucumber.datatable.DataTable dataTable) {
    		a = dataTable.asMaps(String.class, String.class);
            c.setPaciente(a.get(0).get("paciente"));
            c.setTipo(a.get(0).get("tipo"));
            c.setFecha(a.get(0).get("fecha"));
            c.setHora(a.get(0).get("hora"));
            c.setCentro(a.get(0).get("centro"));
            c.setMedico(a.get(0).get("médico"));
            
            driver.findElement(By.xpath("//input[@placeholder='paciente']")).sendKeys(c.getPaciente());
            driver.findElement(By.xpath("//input[@placeholder='tipo']")).sendKeys(c.getTipo());
            driver.findElement(By.xpath("//input[@placeholder='fecha']")).sendKeys(c.getFecha());
            driver.findElement(By.xpath("//input[@placeholder='hora']")).sendKeys(c.getHora());
            driver.findElement(By.xpath("//input[@placeholder='centro']")).sendKeys(c.getCentro());
            driver.findElement(By.xpath("//input[@placeholder='médico']")).sendKeys(c.getMedico());
            
    	    
    	}
    	
    	@Then("se modifica la cita y se sustituye en la base de datos FAILS")
    	public void se_modifica_la_cita_y_se_sustituye_en_la_base_de_datos_FAILS() {
    		driver.findElement(By.xpath("//input[@value='Modificar cita']")).click();
    		fail("Prueba erronea");
    		driver.close();
    	}

    	@Then("se modifica la cita y se sustituye en la base de datos IS SUCCESFUL")
    	public void se_modifica_la_cita_y_se_sustituye_en_la_base_de_datos_IS_SUCCESFUL() {
    		driver.findElement(By.xpath("//input[@value='Modificar cita']")).click();
    		citasRepository.updateCita(c);
            assertEquals(c.getId(), citasRepository.findById(c.getId).getId());
            citasRepository.deleteCita(c.getId());
            driver.close();
    	}


}
