package es.e3corp.eSalud.bdd.stepdefs;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

public class LoginSteps {

	 	WebDriver driver;			
		
	 	@Given("^Accediendo a la aplicacion por Firefox$")
	 	public void accediendo_a_la_aplicacion_por_Firefox() throws Throwable {				
//	        driver= new FirefoxDriver();					
//	        driver.manage().window().maximize();			
//	        driver.get("http://localhost:8080");	
	 	}

	 	@When("^introduciomos \"(.*?)\" y \"(.*?)\" correctos$")
	 	public void introduciomos_y_correctos(String email, String password) throws Throwable {
//	 		driver.findElement(By.name("email")).sendKeys(email);					
//	        driver.findElement(By.name("password")).sendKeys(password);
	 	}

	 	@Then("^Accedemos a la aplicacion$")
	 	public void si_el_usuario_y_la_contraseña_son_correctos_accedo_a_la_aplicacion() throws Throwable {
//	 		driver.findElement(By.name("btnAcceder")).click();
	 	}
	    
}