package pe.tpido.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrearDriver {
	
	public enum NavegadorWeb { CHROME, FIREFOX };
	
	public static WebDriver getDriver(NavegadorWeb navegador) {
		
		switch (navegador) {
		case CHROME:
			return getDriverChrome();
			
		case FIREFOX:
			return getDriverFirefox();
			
		default:
			throw new IllegalArgumentException("El navegador indicado no se encuentra implementado");
		}
	}
	
	private static WebDriver getDriverChrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	private static WebDriver getDriverFirefox() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
