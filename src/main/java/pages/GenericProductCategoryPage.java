package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class GenericProductCategoryPage extends SeleniumWrappers{

	public GenericProductCategoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Fresh Produce Melons Each") public WebElement melons;
	@FindBy(linkText = "Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar") public WebElement eggBites;
	@FindBy(linkText = "Shimmer Pastel Almond Blend") public WebElement pastelAlmond;
	@FindBy(linkText = "Zevia Kidz Strawberry Lemonade Zero Calorie Soda") public WebElement zeviaKidz;

	//de pus intr-o lista

	public List<WebElement> initListOfProducts(){
		List<WebElement> ListOfProducts = new ArrayList<>(Arrays.asList(melons, eggBites, pastelAlmond, zeviaKidz));
		return ListOfProducts;
	}
}
