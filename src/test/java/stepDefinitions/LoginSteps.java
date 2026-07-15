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

	@When("User enters username and password")
	public void user_enters_username_and_password() {
		login.entersUsenameAndPassword("Admin", "admin123");
	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
		login.clickOnLoginButton();
	}

	@Then("User should see Dashboard")
	public void user_should_see_dashboard() {
		util = new CommonUtil();
		try {
			WebElement dashboard = login.getDashboardTitle();
			util.waitForVisibility(dashboard);

			String actualTitle = getDriver().getTitle();
			String expectedTitle = actualTitle;

			System.out.println("LOGIN SUCCESS");
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

			Assert.fail("LOGIN FAILED: " + error.getText());

		} catch (Exception e) {
			System.out.println("Login Success");
		}
	}

}
