package pe.tpido.cliente.registrar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import pe.tpido.driver.CrearDriver;
import pe.tpido.driver.CrearDriver.NavegadorWeb;
import pe.tpido.page.LoginPage;
import pe.tpido.page.RegistrarClientePage;



public class RegistrarClientePasos {
	
	private String url = "http://localhost:8080/TPidoWeb/index.xhtml";
	private LoginPage loginPage;
	
	@Managed
	private WebDriver driver;
	private RegistrarClientePage registrarClientePage;
	
	
	@Before
	public void ConfiguracionInicial() {
		//driver = CrearDriver.getDriver(NavegadorWeb.CHROME);
		loginPage = new LoginPage(driver, url);
	}
	
	@After
	public void configuracionFinal() {
		driver.close();
	}
	
	@Given("Ingreso al aplicativo TPIDO Web")
	public void cargarVisorWeb() {
		loginPage.irPaginaLogin();
	}
	
	@And("ingreso a la ventana registrar nuevo cliente")
	public void cargarVentanaRegistrarNuevoCliente(){
		registrarClientePage = loginPage.irRegistrarCliente();
	}
	
	
	@When("ingreso los datos {string}, {string}, {string}, {string}")
	public void ingresarDatosCliente(String nombre, String apellido, String correo, String clave) {
		registrarClientePage.ingresarDatos(nombre, apellido, correo, clave);
	}
	
	@And("selecciono la opcion guardar")
	public void registrarNuevoCliente() {
		registrarClientePage.guardarCliente();
	}
	
	
	@And("se presiono la tecla enter")
	public void registrarNuevoClienteEnter() {
		registrarClientePage.guardarClienteEnter();
	}
	
	@And("se presiono el link volver a inicio")
	public void retornarLogin() {
		registrarClientePage.volverLogin();
	}
	
	@Then("el sistema muestra el mensaje {string}")
	public void validarRegistroCliente(String mensajeEsperado) {
		Assert.assertEquals(mensajeEsperado,registrarClientePage.getMensajeObtenido());
	}
	
	@Then("el sistema retorna al login {string}")
	public void validarVentanLogin(String mensajeEsperado) {
		Assert.assertEquals(mensajeEsperado,loginPage.getTextTitle());
	}
	
	
	
	
	

}
