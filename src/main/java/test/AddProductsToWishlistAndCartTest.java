package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class AddProductsToWishlistAndCartTest extends BaseTest {

	@Parameters({ "user", "pass" })
	@Test(priority = 1)
	public void login(String user, String pass) {
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(user, pass);
	}

	@Test(priority = 2)
	public void addProductsToWishlistAndCart() {

		int i = 0;
		int j = 0;
		do {
			app.click(app.menu.allCategories);
			if (app.menu.initListOfProductCategories().size() >= i) {
				app.click(app.menu.initListOfProductCategories().get(i));
				i++;
				app.click(app.genericProductCategoryPage.initListOfProducts().get(j));
				j++;
				app.click(app.genericProduct.addToWishlistButton);
				app.click(app.genericProduct.wishlistAlertCloseButton);
			}
		} while (i < app.menu.initListOfProductCategories().size() || j < app.genericProductCategoryPage.initListOfProducts().size());
		
		app.click(app.menu.wishlist);
		
		assertEquals(app.wishlistPage.initWishlistProducts().get(app.wishlistPage.melons), app.wishlistPage.addToCartButton);
		assertEquals(app.wishlistPage.initWishlistProducts().get(app.wishlistPage.eggBites), app.wishlistPage.addToCartButton);
		assertEquals(app.wishlistPage.initWishlistProducts().get(app.wishlistPage.pastelAlmond), app.wishlistPage.addToCartButton);
		assertEquals(app.wishlistPage.initWishlistProducts().get(app.wishlistPage.zeviaKidz), app.wishlistPage.buyProductButton);

		app.click(app.wishlistPage.selectAllCheckbox);
		app.selectByValue(app.wishlistPage.actionsDropdownList, "add_selected");
		app.click(app.wishlistPage.applyActionButton);
		assertTrue(app.wishlistPage.alertMessage.getText().contains(
				"Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met."));
	}

}
