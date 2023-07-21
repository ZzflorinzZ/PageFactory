package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class AddProductsToWishlistAndCartTest extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void login(String user, String pass) {
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(user, pass);
	}
	
	@Test(priority = 2)
	public void addProductsToWishlistAndCart() {
		app.click(app.menu.allCategories);
		app.click(app.menu.fruitsAndVegetables);
		app.click(app.genericProductCategoryPage.melons);
		app.click(app.genericProduct.addToWishlistButton);
		app.click(app.genericProduct.wishlistAlertCloseButton);
		
		app.click(app.menu.allCategories);
		app.click(app.menu.breakfastAndDairy);
		app.click(app.genericProductCategoryPage.eggBites);
		app.click(app.genericProduct.addToWishlistButton);
		app.click(app.genericProduct.wishlistAlertCloseButton);
		
		app.click(app.menu.allCategories);
		app.click(app.menu.biscuitsAndSnacks);
		app.click(app.genericProductCategoryPage.pastelAlmond);
		app.click(app.genericProduct.addToWishlistButton);
		app.click(app.genericProduct.wishlistAlertCloseButton);
		
		app.click(app.menu.allCategories);
		app.click(app.menu.beverages);
		app.click(app.genericProductCategoryPage.zeviaKidz);
		app.click(app.genericProduct.addToWishlistButton);		
		app.click(app.genericProduct.wishlistAlertCloseButton);
		
		app.click(app.menu.wishlist);
	
	/*
	 * aici ar trebui sa fie assert-urile pt asocierea Product name cu Button
	 * am incercat sa folosesc o mapa in clasa Wishlist dar nu am reusit sa adaug elementele in mapa (nu-mi dau seama de ce intoarce syntax error cand fac .put)
	 * 
	 * am facut si un DataProvider, dar relatia directa dintre cele 2 elemente nu se obtine in urma unei actiuni asupra unuia dintre elemente si nu ar avea sens sa folosesc data provider (care oricum nu am reusit sa-l scriu cu @FindBy)
	 */
		
		app.click(app.wishlistPage.selectAllCheckbox);
		app.selectByValue(app.wishlistPage.actionsDropdownList, "add_selected");
		app.click(app.wishlistPage.applyActionButton);
		assertTrue(app.wishlistPage.alertMessage.getText().contains("Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met."));
	}

}
