package pe.tpido.menu;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.tpido.page.MantenimientoPedidoPage;

public class Menu {
	

	private static By linkMenuHamburguesa = By.xpath("/html/body/section/div[1]/div");
	
	private static By linkModuloPedido = By.xpath("/html/body/section/div[1]/nav/ul/li/span");
	
	private static By linkRegistrarPedido = By.linkText("Registrar Pedido");
	
	public static MantenimientoPedidoPage clicMantenimientoPedido(WebDriver driver) {
		
		try {
			
			Thread.sleep(1000);
			driver.findElement(linkMenuHamburguesa).click();
			
			Thread.sleep(1000);
			driver.findElement(linkModuloPedido).click();
			
			Thread.sleep(1000);
			driver.findElement(linkRegistrarPedido).click();
			
			return new MantenimientoPedidoPage(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Ocurrió un error al ir a la pagina de registrar pedido", e);
		}
		
	}
	

}
