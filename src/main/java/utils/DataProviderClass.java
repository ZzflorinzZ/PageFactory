package utils;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "wishlistDataProvider")
	public Object[][] wishlistDataProvider(){
		Object[][] data = new Object[4][2];
		
		data[0][0] = By.linkText("Zevia Kidz Strawberry Lemonade Zero Calorie Soda");
		data[0][1] = By.xpath("//span[text()='Buy product']");
		
		data[1][0] = By.linkText("Shimmer Pastel Almond Blend");
		data[1][1] = By.xpath("//span[text()='Add to Cart']");
		
		data[2][0] = By.linkText("Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar");
		data[2][1] = By.xpath("//span[text()='Add to Cart']");
		
		data[3][0] = By.linkText("Fresh Produce Melons Each");
		data[3][1] = By.xpath("//span[text()='Add to Cart']");
		
		return data;
		
	}

}
