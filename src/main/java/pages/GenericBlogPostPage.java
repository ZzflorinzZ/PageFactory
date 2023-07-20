package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class GenericBlogPostPage extends SeleniumWrappers{

	public GenericBlogPostPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "reply-title") public WebElement leaveAReply;
	@FindBy(id = "comment") public WebElement commentTextToPost;
	@FindBy(id = "author") public WebElement authorPost;
	@FindBy(id = "email") public WebElement emailPost;
	@FindBy(id = "submit") public WebElement postCommentButton;
	@FindBy(xpath = "//em[text()='Your comment is awaiting moderation.']") public WebElement commentConfirmationText;
	
	
	public void postComment(String commentText, String author, String email) {
		sendKeys(commentTextToPost, commentText); 
		sendKeys(authorPost, author);
		sendKeys(emailPost, email);
		click(postCommentButton);
	}

}
