package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class WishlistPage extends SeleniumWrappers{

	public WishlistPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Zevia Kidz Strawberry Lemonade Zero Calorie Soda") public WebElement zeviaKidz;
	@FindBy(linkText = "Shimmer Pastel Almond Blend") public WebElement pastelAlmond;
	@FindBy(linkText = "Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar") public WebElement eggBites;
	@FindBy(linkText = "Fresh Produce Melons Each") public WebElement melons;
	@FindBy(xpath = "//span[text()='Add to Cart']") public WebElement addToCartButton;
	@FindBy(xpath = "//span[text()='Buy product']") public WebElement buyProductButton;
	
	public Map<WebElement, WebElement> initWishlistProducts(){
	Map<WebElement, WebElement> wishlistProducts = new HashMap<>();	
		wishlistProducts.put (zeviaKidz, buyProductButton);
		wishlistProducts.put (pastelAlmond, addToCartButton);
		wishlistProducts.put (melons, addToCartButton);
		wishlistProducts.put (eggBites, addToCartButton);
	return wishlistProducts;
	}
	
	@FindBy(css = "input[title^='Select all']") public WebElement selectAllCheckbox;
	@FindBy(id = "tinvwl_product_actions") public WebElement actionsDropdownList;
	@FindBy(css = "button[title='Apply Action']") public WebElement applyActionButton;
	@FindBy(xpath = "//ul[@class='woocommerce-error']/li") public WebElement alertMessage;
}
