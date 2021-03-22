package pe.tpido.pedido.registrar;

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
import pe.tpido.page.BienvenidaPage;
import pe.tpido.page.LoginPage;
import pe.tpido.page.RegistrarClientePage;
import pe.tpido.page.RegistrarPedidoPage;

public class RegistrarPedidoPasos {
	
	private String url = "http://localhost:8080/TPidoWeb/index.xhtml";
	private BienvenidaPage bienvenidaPage;
	private LoginPage loginPage;

	@Managed
	private  WebDriver driver;
	private RegistrarPedidoPage registrarPedidoPage;
	
	@Before
	public  void configuracionInicial() {
	
		loginPage = new LoginPage(driver, url);
	}
	
	@After
	public  void configuracionFinal() {
		driver.close();
	}
	
	@Given("Ingreso al aplicativo TPido")
	public void cargarVisorWeb() {
		loginPage.irPaginaLogin();
	}
	
	@And("inicio sesion con el usuario {string} y la clave {string}")
	public void ingresarUsuarioYClave(String usuario, String clave) {
		bienvenidaPage =loginPage.iniciarSesion(usuario, clave);
	}
	
	@When("Ingreso a la ventana registrar pedido")
	public void cargarVentanaRegistrarPedido() {
		registrarPedidoPage=bienvenidaPage.irMantenimientoPedido().irRegistrarPedido();
		
		
	}
	
	@And("Selecciono {string} unidades de COCA COLA")
	public void registrarPedido(String stock) {
		registrarPedidoPage.insertar(stock);

	}
	
	@Then("el sistema muestra el mensaje {string}")
	public void validarRegistroCategoria(String mensajeEsperado) {
		Assert.assertEquals(mensajeEsperado, registrarPedidoPage.getMensajeObtenido());
	}
	
}
