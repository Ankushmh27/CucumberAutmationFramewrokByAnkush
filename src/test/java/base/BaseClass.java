package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	// Thread-safe WebDriver
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void initializeBrowser() {

		driver.set(new ChromeDriver());

		getDriver().manage().window().maximize();

		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	public static void quitBrowser() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}

}