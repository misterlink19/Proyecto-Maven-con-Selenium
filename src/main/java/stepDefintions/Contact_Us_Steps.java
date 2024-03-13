package stepDefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");

        ChromeOptions opcionesChrome = new ChromeOptions();
        opcionesChrome.addArguments("--remote-allow-origins=*");
        opcionesChrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(opcionesChrome);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Given("Yo entro al apartado de Contacto")
    public void yo_entro_al_apartado_de_contacto() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("Entro mi nombre")
    public void entro_mi_nombre() throws InterruptedException {
        driver.findElement(By.name("first_name")).sendKeys("Elver");
        Thread.sleep(3000);
    }

    @And("Entro mi apellido")
    public void entro_mi_apellido() throws InterruptedException {
        driver.findElement(By.name("last_name")).sendKeys("Galarga");
        Thread.sleep(3000);
    }

    @And("Entro mi correo")
    public void entro_mi_correo() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("Relleno@cachu.com");
        Thread.sleep(3000);
    }

    @And("Entro un comentario")
    public void entro_un_comentario() throws InterruptedException {
        driver.findElement(By.name("message")).sendKeys("Comentario aleatorio");
        Thread.sleep(3000);
    }

    @And("Hago click al boton de enviar")
    public void hago_click_al_boton_de_enviar() throws InterruptedException {
        driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
        Thread.sleep(3000);
    }

    @Then("Deberia Presentarme un mensaje de que fue enviado correctamente.")
    public void deberia_presentarme_un_mensaje_de_que_fue_enviado_correctamente() {
        WebElement contactUs_EnvioCorrecto_Mensaje = driver.findElement(By.xpath("//h1[normalize-space()='Thank You for your Message!']"));
        Assert.assertEquals(contactUs_EnvioCorrecto_Mensaje.getText(), "Thank You for your Message!");

    }
}
