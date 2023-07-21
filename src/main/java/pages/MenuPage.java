package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	@FindBy(css = "input[id='dgwt-wcas-search-input-1']") public WebElement searchInput;
	@FindBy(linkText = "BLOG") public WebElement blogLink;
	@FindBy(xpath = "//span[text()='ALL CATEGORIES']") public WebElement allCategories;
	@FindBy(linkText = "Fruits & Vegetables") public WebElement fruitsAndVegetables;
	@FindBy(linkText = "Breakfast & Dairy") public WebElement breakfastAndDairy;
	@FindBy(linkText = "Biscuits & Snacks") public WebElement biscuitsAndSnacks;
	@FindBy(linkText = "Beverages") public WebElement beverages;
	@FindBy(linkText = "Wishlist") public WebElement wishlist;
	
	//de pus categoriile intr-o lista
	//o iterez cu un if simplu in test
	
	public void searchProduct(String product) {
		click(searchInput);
		sendKeys(searchInput, product);
		searchInput.sendKeys(Keys.ENTER);
	}
}
