package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtil;

public class BasePage {

	protected WebDriver driver;

	protected CommonUtil util;

	public BasePage() {

		driver = BaseClass.getDriver();

		util = new CommonUtil();

		PageFactory.initElements(driver, this);
	}
}