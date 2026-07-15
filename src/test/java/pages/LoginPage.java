package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtil;

public class LoginPage {

	private WebDriver driver;
	CommonUtil util;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement pagetitle;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardText;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMessage;

	public void entersUsenameAndPassword(String userName, String userPassword) {
		util = new CommonUtil();
  // wait
		util.waitForVisibility(username);
		username.sendKeys(userName);

		util.waitForVisibility(password);
		password.sendKeys(userPassword);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	// Return dashboard page text
	public WebElement getDashboardTitle() {
		util.waitForVisibility(dashboardText);
		return dashboardText;
	}

	// Return login error
	public WebElement getErrorMessage() {
		util.waitForVisibility(errorMessage);
		return errorMessage;
	}

	public void clearUsernameAndPassword() {
		username.clear();
		password.clear();
	}
}