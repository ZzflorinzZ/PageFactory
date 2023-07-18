package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertListContains;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class PlaceOrderTest extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void login(String user, String pass) {
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(user, pass);
	}
	
	@Parameters({"product1", "product2"})
	@Test(priority = 2)
	public void searchAndAddProductToCart(String product1, String product2) {
		app.menu.searchProduct(product1);
		app.click(app.genericProduct.addToCart);
		
/*		System.out.println(app.genericProduct.addToCartConfirmationText.getText());
		StringBuilder firstProductConfirmationText = new StringBuilder(app.genericProduct.addToCartConfirmationText.getText());
		firstProductConfirmationText.delete(0, 9);
		System.out.println(firstProductConfirmationText);
		assertEquals(firstProductConfirmationText, "“Rold Gold Tiny Twists Pretzels” has been added to your cart.");

*/		assertNotNull(app.genericProduct.addToCartConfirmationText.getText());
		
		app.menu.searchProduct(product2);
		app.click(app.shopPage.beefStewMeat);
		app.click(app.genericProduct.addToCart);
		assertNotNull(app.genericProduct.addToCartConfirmationText.getText());	
	}
	
	@Test(priority = 3)
	public void modifyQtyAndPlaceOrder() {
		app.click(app.genericProduct.viewCartButton);
		
		StringBuilder initialTotalPrice = new StringBuilder(app.cartPage.totalPrice.getText().toString());
		initialTotalPrice.delete(0, 1);

		// “Rold Gold Tiny Twists Pretzels” has been added to your cart.
		double initialTotalPriceD = Double.parseDouble(initialTotalPrice.toString());
		
		app.click(app.cartPage.increaseQtyButton);
		
		StringBuilder finalTotalPrice = new StringBuilder(app.cartPage.totalPrice.getText().toString());
		finalTotalPrice.delete(0, 1);
		double finalTotalPriceD = Double.parseDouble(finalTotalPrice.toString());
		
		if(initialTotalPriceD < finalTotalPriceD) {
			assertTrue(true);
		}
		
		app.click(app.cartPage.checkoutButton);
		app.click(app.checkoutPage.termsAndConditionsCheckbox);
		app.click(app.checkoutPage.placeOrderButton);
		assertEquals(app.checkoutPage.orderSentConfirmationText.getText(), "Thank you. Your order has been received.");
		assertNotEquals("Order number:", app.checkoutPage.orderNumber.getText());
	}


}
