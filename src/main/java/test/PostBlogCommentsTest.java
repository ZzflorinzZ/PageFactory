package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class PostBlogCommentsTest extends BaseTest {

	@Parameters({ "commentText", "author", "email" })
	@Test(priority = 1)
	public void postBlogComments(String commentText, String author, String email) {
		Actions action = new Actions(driver);

		app.click(app.menu.blogLink);
		for (WebElement element : app.blogPage.initBlogPost()) {
			app.checkElementIsDisplayed(element);												
			app.click(element); 																
			action.moveToElement(app.genericBlogPostPage.postCommentButton).perform();
			assertEquals(app.genericBlogPostPage.commentTextToPost.getTagName(), "textarea");
			assertEquals(app.genericBlogPostPage.authorPost.getTagName(), "input");
			assertEquals(app.genericBlogPostPage.emailPost.getTagName(), "input");
			app.genericBlogPostPage.postComment(commentText, author, email);
			assertTrue(app.genericBlogPostPage.commentConfirmationText.getText().contains("Your comment is awaiting moderation."));
			driver.navigate().to("https://keyfood.ro/blog/");
		}
	}

}
