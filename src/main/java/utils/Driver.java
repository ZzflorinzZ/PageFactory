package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	//for parallel execution purpose
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver initBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {	
			//WebDriver driver = new ChromeDriver();
			driver.set(new ChromeDriver(getChromeOptions()));
			System.out.println("Chrome" + Thread.currentThread().getId());
			return driver.get();	
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			System.out.println("Firefox" + Thread.currentThread().getId());
			return driver.get();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			System.out.println("Edge" + Thread.currentThread().getId());
			return driver.get();
		}
		return driver.get(); 	
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1580, 1280");
		return options; 
	}

}
