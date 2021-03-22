package pe.tpido.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrarClientePage {
	
	private By txtNombre = By.id("txtNombre");
	private By txtApellido = By.id("txtApellido");
	private By txtCorreo = By.id("txtCorreo");
	private By txtClave = By.id("txtClave");
	private By btnGuardar = By.id("btnGuardar");
	private By lblMensajeGuardadoCorrecto = By.xpath("//*[@id=\"messages\"]/div/ul/li/span");
	private By linkVolver = By.xpath("//*[@id=\"panel02\"]/tbody/tr[6]/td[3]/a");
	private String mensajeObtenido;
	private WebDriver driver;
	private WebDriverWait driverWait;
	
	public RegistrarClientePage(WebDriver driver) {
		this.driver = driver;
		this.driverWait = new WebDriverWait(driver, 30);
	}
	
	public void ingresarDatos(String nombre,
			String apellido,
			String correo,
			String clave) {
		try {
			
			driver.findElement(txtNombre).clear();
			driver.findElement(txtNombre).sendKeys(nombre);
			driver.findElement(txtApellido).clear();
			driver.findElement(txtApellido).sendKeys(apellido);
			driver.findElement(txtCorreo).clear();
			driver.findElement(txtCorreo).sendKeys(correo);
			driver.findElement(txtClave).clear();
			driver.findElement(txtClave).sendKeys(clave);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void guardarCliente() {
		try {
		driver.findElement(btnGuardar).click();
		
		driverWait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return driver.findElement(lblMensajeGuardadoCorrecto).getText().length() > 0;
			}
			
		});
		
		mensajeObtenido = driver.findElement(lblMensajeGuardadoCorrecto).getText();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void guardarClienteEnter() {
		try {
		driver.findElement(txtClave).sendKeys(Keys.ENTER);
		
		driverWait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return driver.findElement(lblMensajeGuardadoCorrecto).getText().length() > 0;
			}
			
		});
		
		mensajeObtenido = driver.findElement(lblMensajeGuardadoCorrecto).getText();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void volverLogin() {
		driver.findElement(linkVolver).click();
	}
	
	public String getMensajeObtenido() {
		return mensajeObtenido;
	}
	
	

}
