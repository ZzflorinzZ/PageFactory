package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TestClass extends BaseTest{
	
	@Parameters({"product"})
	@Test
	public void searchAndAddProductToChart(String product) {
		app.menu.searchProduct(product);
	}

}
