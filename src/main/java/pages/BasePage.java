package pages;

import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public MenuPage menu = new MenuPage(driver);
	public MyAccount myAccount = new MyAccount(driver);
	public GenericProductPage genericProduct = new GenericProductPage(driver);
	public ShopPage shopPage = new ShopPage(driver);
	public CartPage	cartPage = new CartPage(driver);
	public CheckoutPage	checkoutPage = new CheckoutPage(driver); 
	public BlogPage	blogPage = new BlogPage(driver);
	public GenericBlogPostPage genericBlogPostPage = new GenericBlogPostPage(driver);
	

}
