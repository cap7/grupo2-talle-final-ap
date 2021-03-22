package pe.tpido.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MantenimientoPedidoPage {

	private WebDriver driver;
	
	public MantenimientoPedidoPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public RegistrarPedidoPage irRegistrarPedido() {
		return new RegistrarPedidoPage(driver);
	}
}
