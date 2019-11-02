package es.e3corp.eSalud.bdd.stepdefs;

import es.e3corp.eSalud.repository.UsuarioRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Registro {

    WebDriver driver;
    UsuarioRepository ur;
    List<Map<String, String>> a;

    @Given("abrimos el navegador e iniciamos la pantalla de registro")
    public void abrimos_el_navegador_e_iniciamos_la_pantalla_de_registro() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox", "--disable-dev-shm-usage");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://esalud.herokuapp.com/auth/register");

    }

    @When("introducimos los datos de registro")
    public void introducimos_los_datos_de_registro(io.cucumber.datatable.DataTable dataTable) {

        a = dataTable.asMaps(String.class, String.class);

        driver.findElement(By.xpath("//input[@placeholder='DNI']")).sendKeys(a.get(0).get("dni"));
        driver.findElement(By.xpath("//input[@placeholder='Contraseña']")).sendKeys(a.get(0).get("contraseña"));
        driver.findElement(By.xpath("//input[@placeholder='Repita su contraseña']"))
                .sendKeys(a.get(0).get("contraseña2"));
        driver.findElement(By.xpath("//input[@placeholder='Correo electrónico']")).sendKeys(a.get(0).get("email"));
        driver.findElement(By.xpath("//input[@placeholder='Localidad']")).sendKeys(a.get(0).get("localidad"));
        driver.findElement(By.xpath("//input[@placeholder='Apellidos']")).sendKeys(a.get(0).get("apellidos"));
        driver.findElement(By.xpath("//input[@placeholder='Teléfono']")).sendKeys(a.get(0).get("numTelefono"));
        driver.findElement(By.xpath("//input[@placeholder='Nombre']")).sendKeys(a.get(0).get("nombre"));

    }

    @Then("nos registramos en la aplicacion")
    public void nos_registramos_en_la_aplicacion() {

        // REMIRARLO

        driver.findElement(By.xpath("//input[@value='Registrarse']")).click();

        if (a.get(0).get("resultadoEsperado") == "REGISTRO CORRECTO") {
            assertEquals(a.get(0).get("dni"), this.ur.findOne(a.get(0).get("dni")));
            // this.ur.deleteUsuario(a.get(0).get("dni"));
        }

        driver.close();
    }

}
