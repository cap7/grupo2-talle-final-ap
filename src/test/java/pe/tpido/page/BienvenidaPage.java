package pe.tpido.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.tpido.menu.Menu;



public class BienvenidaPage {

	private By lblMensajeBienvenida = By.xpath("//*[@id=\"j_idt16_header\"]/span");
	private WebDriver driver;
	
	public BienvenidaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getMensajeBienvenida() {
		return driver.findElement(lblMensajeBienvenida).getText();
	}
	
	public MantenimientoPedidoPage irMantenimientoPedido() {
		return Menu.clicMantenimientoPedido(driver);
		
	}
}
