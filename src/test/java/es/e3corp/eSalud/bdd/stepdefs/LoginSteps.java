package es.e3corp.eSalud.bdd.stepdefs;

import static org.junit.Assert.assertEquals;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import es.e3corp.eSalud.repository.UsuarioRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

  WebDriver driver;
  UsuarioRepository ur;
  List<Map<String, String>> a;

  @Given("abrimos el navegador e iniciamos la aplicacion")
  public void abrimos_el_navegador_e_iniciamos_la_aplicacion() {

    Path path = FileSystems.getDefault().getPath("src/test/resources/drivers/geckodriver");
    System.setProperty("webdriver.gecko.driver", path.toString());
    FirefoxOptions fo = new FirefoxOptions();
    fo.addArguments("--headless");
    WebDriver driver = new FirefoxDriver(fo);

    driver.get("http://localhost:8080/auth/login");
  }

  @When("introducimos los datos de acceso a la aplicación")
  public void introducimos_los_datos_de_acceso_a_la_aplicación(io.cucumber.datatable.DataTable dataTable) {

    a = dataTable.asMaps(String.class, String.class);

    driver.findElement(By.xpath("//input[@placeholder='DNI']")).sendKeys(a.get(0).get("dni"));
    driver.findElement(By.xpath("//input[@placeholder='Contraseña']")).sendKeys(a.get(0).get("contraseña"));

  }

  @Then("accedemos a la aplicacion")
  public void accedemos_a_la_aplicacionla_aplicacion() throws InterruptedException {

    driver.findElement(By.xpath("//input[@value='Acceder']")).click();

    // REMIRARLO

    String expectedUrl = driver.getCurrentUrl();

    if (a.get(0).get("testCase") == "CASE 1") {
      assertEquals("http://localhost:8080/admin", expectedUrl);
    } else if (a.get(0).get("testCase") == "CASE 2") {
      assertEquals("http://localhost:8080/listado-citas", expectedUrl);
    } else if (a.get(0).get("testCase") == "CASE 3") {
      assertEquals("http://localhost:8080/sidenavAdmin", expectedUrl);
    } else {
      assertEquals("http://localhost:8080/auth/login", expectedUrl);
    }

    Thread.sleep(7000);
    driver.close();

  }

}
