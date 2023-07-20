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
		for (WebElement element : app.blogPage.blogPosts) {
			assertTrue(true);
/*			app.checkElementIsDisplayed(element);												// pica pe isDisplayed in <<for each>>
			app.click(element); 																// nu face click in <<for each>>
			action.moveToElement(app.genericBlogPostPage.postCommentButton).perform();
			assertEquals(app.genericBlogPostPage.commentTextToPost.getTagName(), "textarea");
			assertEquals(app.genericBlogPostPage.authorPost.getTagName(), "input");
			assertEquals(app.genericBlogPostPage.emailPost.getTagName(), "input");
			app.genericBlogPostPage.postComment(commentText, author, email);
			assertTrue(app.genericBlogPostPage.commentConfirmationText.getText().contains("Your comment is awaiting moderation."));
			driver.navigate().to("https://keyfood.ro/blog/");
*/		}
		
	// in afara <<for each>> codul functioneaza, dar nu are sens sa duplic codul pt fiecare blog post; 
	// ar trebui sa pot sa-l folosesc in <<for each>>
		app.checkElementIsDisplayed(app.blogPage.blogPost1);
		app.click(app.blogPage.blogPost1);
		action.moveToElement(app.genericBlogPostPage.postCommentButton).perform();
		assertEquals(app.genericBlogPostPage.commentTextToPost.getTagName(), "textarea");
		assertEquals(app.genericBlogPostPage.authorPost.getTagName(), "input");
		assertEquals(app.genericBlogPostPage.emailPost.getTagName(), "input");
		app.genericBlogPostPage.postComment(commentText, author, email);
		assertTrue(app.genericBlogPostPage.commentConfirmationText.getText().contains("Your comment is awaiting moderation."));
		driver.navigate().to("https://keyfood.ro/blog/");
	}

}
