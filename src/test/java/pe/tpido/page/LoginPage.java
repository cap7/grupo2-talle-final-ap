package pe.tpido.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;



public class LoginPage {
	
	private By txtUsuario = By.id("txtUsuario");
	private By txtClave = By.id("txtClave");
	private By btnIniciarSesion = By.id("btnIniciarSesion");
	private By linkNuevoCliente = By.xpath("//*[@id=\"frmLogin\"]/div[3]/a");
	private By lblTitle = By.xpath("//*[@id=\"frmLogin\"]/div[1]");
	private String textTitle;
	private WebDriver driver;
	private String url;
	
	public LoginPage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}
	
	public void irPaginaLogin() {
		driver.get(url);
	}
	
	public BienvenidaPage iniciarSesion(String usuario, String clave) {
		driver.findElement(txtUsuario).clear();
		driver.findElement(txtUsuario).sendKeys(usuario);
		driver.findElement(txtClave).clear();
		driver.findElement(txtClave).sendKeys(clave);
		driver.findElement(btnIniciarSesion).click();
		return new BienvenidaPage(driver);
		
	}
	
	public RegistrarClientePage irRegistrarCliente() {
		driver.findElement(linkNuevoCliente).click();
		return new RegistrarClientePage(driver);
	}
	
	public String getTextTitle() {
		return textTitle = driver.findElement(lblTitle).getText();
	}
	

}

