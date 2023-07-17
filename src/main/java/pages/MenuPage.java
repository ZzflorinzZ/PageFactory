package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers{

	public MenuPage(WebDriver driver) {
		super(driver);	
		PageFactory.initElements(driver, this);
	}
	
	
//	public By myAccountLink = By.linkText("My account");
		//myAccountLink ==> locator
		//driver.findElement(locator) ==> webElement
	
	@FindBy(linkText = "My account") public WebElement myAccountLink;
	
/*	String ceva;
	@FindBy(css = "button[class='"+ ceva + "]") public WebElement element; //FindBy asteapta o constanta; nu poate lucra dinamic
*/	
	public By myAccountLink2 = By.cssSelector("button[class='\"+ ceva + \"]");
	
}
