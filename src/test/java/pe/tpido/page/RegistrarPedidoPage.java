package pe.tpido.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrarPedidoPage {
	private By txtCantidad = By.id("spCantidad_input");
	private By btnAgregar = By.id("j_idt25");
	private By btnGuardar = By.id("j_idt41");
	private By lblMensaje = By.id("messages");
	private String mensajeObtenido;
	private WebDriver driver;

	public RegistrarPedidoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void insertar(String cantProducto ) {
		
		try {
			
			driver.findElement(txtCantidad).clear();
			driver.findElement(txtCantidad).sendKeys(cantProducto);
			driver.findElement(btnAgregar).click();
			driver.findElement(btnGuardar).click();

			Thread.sleep(2000);
			
			mensajeObtenido = driver.findElement(lblMensaje).getText();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Ocurrió un error al registrar pedido", e);
		}
		
	}
	
	public String getMensajeObtenido() {
		return mensajeObtenido;
	}
	
}
