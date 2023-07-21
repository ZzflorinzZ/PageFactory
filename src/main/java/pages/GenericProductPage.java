package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class GenericProductPage extends SeleniumWrappers{

	public GenericProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add to cart']") public WebElement addToCart;
	@FindBy(css = "div[role='alert']") public WebElement addToCartConfirmationText;
	@FindBy(linkText = "View cart") public WebElement viewCartButton;
	@FindBy(xpath = "(//span[@class='tinvwl_add_to_wishlist-text'])[2]") public WebElement addToWishlistButton;
	@FindBy(css = "button[class$='tinvwl_button_close']") public WebElement wishlistAlertCloseButton;
	


}
