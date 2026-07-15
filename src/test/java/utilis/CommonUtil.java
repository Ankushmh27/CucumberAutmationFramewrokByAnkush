package utilis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class CommonUtil {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	public CommonUtil() {
		this.driver = BaseClass.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.actions = new Actions(driver);
	}

	public String captureScreenshot(String testName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = "screenshots/" + testName + ".png";

		FileUtils.copyFile(src, new File(path));

		return path;
	}

	// ======================== WAIT METHODS ========================//

	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean waitForText(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	// ======================== ACTION METHODS ========================//

	public void click(WebElement element) {
		waitForClickable(element).click();
	}

	public void type(WebElement element, String value) {
		waitForVisibility(element).clear();
		element.sendKeys(value);
	}

	public void hover(WebElement element) {
		actions.moveToElement(element).perform();
	}

	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}

	public void pressEnter() {
		actions.sendKeys(Keys.ENTER).perform();
	}

	// ======================== SELECT METHODS ========================//

	public void selectByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	public void selectByValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	public void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	// ======================== JAVASCRIPT ========================//

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// ======================== ALERT ========================//

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	// ======================== FRAME ========================//

	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// ======================== WINDOW ========================//

	public void switchToNewWindow() {

		String parent = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {

			if (!window.equals(parent)) {

				driver.switchTo().window(window);

				break;
			}
		}
	}
}
