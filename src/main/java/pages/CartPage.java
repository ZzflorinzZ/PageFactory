package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers{

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); //inlocuieste driver.findElement
	}

	@FindBy(xpath = "(//i[@class='klbth-icon-plus'])[1]") public WebElement increaseQtyButton;
	@FindBy(xpath = "//td[@data-title='Total']/descendant::bdi") public WebElement totalPrice;
	@FindBy(linkText = "Proceed to checkout") public WebElement checkoutButton;
}
