package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MyAccount extends SeleniumWrappers{

	public MyAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username") public WebElement usernameField;
	@FindBy(id="password") public WebElement passwordField;
	@FindBy(css="button[name='login']") public WebElement loginButton;
	
	@FindBy(how=How.ID, using="username") public WebElement test;
	
	
	public void loginInApp(String user, String pass) {
		sendKeys(usernameField, user);
		sendKeys(passwordField, pass);
		click(loginButton);
	}

}
