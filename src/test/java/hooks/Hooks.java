package hooks;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilis.CommonUtil;

public class Hooks {

	@Before

	public void setup() {

		BaseClass.initializeBrowser();

	}

	@After

	public void tearDown(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {

			CommonUtil util = new CommonUtil();

			util.captureScreenshot(scenario.getName());
		}

		BaseClass.quitBrowser();
	}
}