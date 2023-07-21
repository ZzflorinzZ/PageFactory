package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers{

	public BlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "But I must explain to you how all this mistaken idea") public WebElement blogPost1;
	@FindBy(linkText = "The Problem With Typefaces on the Web") public WebElement blogPost2;
	@FindBy(linkText = "English Breakfast Tea With Tasty Donut Desserts") public WebElement blogPost3;
	@FindBy(linkText = "On the other hand we provide denounce with righteous") public WebElement blogPost4;
	
	public List<WebElement> initBlogPost(){
	List<WebElement> blogPosts = new ArrayList<>(Arrays.asList(blogPost1, blogPost2, blogPost3, blogPost4));
		return blogPosts;
	}

}
