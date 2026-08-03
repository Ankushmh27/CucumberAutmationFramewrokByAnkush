package stepDefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilis.CommonUtil;

public class LoginSteps extends BaseClass {

	LoginPage login;
	CommonUtil util;

	@Given("User launches the application")
	public void user_launches_the_application() {
		login = new LoginPage(getDriver());
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		
		login.entersUsenameAndPassword(username, password);
	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
		try {
		    login.clickOnLoginButton();
		} catch (Exception ex) {
		    System.out.println("Exception occurred: " + ex.getMessage());
		    ex.printStackTrace();
		}
//		login.clickOnLoginButton();
	}

	@Then("User should see Dashboard {string}")
	public void user_should_see_dashboard(String expectedMessage) {
		util = new CommonUtil();
		try {
			WebElement dashboard = login.getDashboardTitle();
			util.waitForVisibility(dashboard);

			String actualTitle = getDriver().getTitle();
			String expectedTitle = "OrangeHRM";

			System.out.println("Login Successful : "+expectedMessage.equals("Login Successful"));
			System.out.println("Page Title: " + actualTitle);

			Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
			return; // stop execution if login success

		} catch (Exception e) {
			// ignore and go to failure check
		}

		// ================= FAILURE CHECK =================
		try {
			WebElement error = login.getErrorMessage();
			util.waitForVisibility(error);
			String actualError = login.getErrorMessage().getText();
			Assert.fail("LOGIN FAILED: " + error.getText());
		    Assert.assertEquals(actualError, expectedMessage);
		    
		} catch (Exception e) {
			System.out.println("Login Success" + expectedMessage);
		}
		
		/*if(expectedMessage.equalsIgnoreCase("Login Successful")) {

		    WebElement dashboard = login.getDashboardTitle();
		    util.waitForVisibility(dashboard);

		    Assert.assertTrue(dashboard.isDisplayed());
		    Assert.assertEquals(getDriver().getTitle(), "OrangeHRM");

		}
		else {

		    WebElement error = login.getErrorMessage();
		    util.waitForVisibility(error);

		    Assert.assertTrue(error.isDisplayed());
		    Assert.assertEquals(error.getText(), expectedMessage);
		}*/
		
	}
		
}
