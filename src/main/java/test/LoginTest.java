package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class LoginTest extends BaseTest{

	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void login(String user, String pass) {
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(user, pass);
	}
	
	@Parameters({"invuser", "invpass"})
	@Test(priority = 2)
	public void invalidLogin(String user, String pass) {
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(user, pass);
	}

}
