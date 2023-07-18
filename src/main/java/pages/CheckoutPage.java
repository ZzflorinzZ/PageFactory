package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[type='checkbox']") public WebElement termsAndConditionsCheckbox;
	@FindBy(css = "button[id='place_order']") public WebElement placeOrderButton;
	@FindBy(css = "p[class$='order-received']") public WebElement orderSentConfirmationText;
	@FindBy(css = "li[class$='order']") public WebElement orderNumber;
}
