package hooks;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilis.CommonUtil;

public class Hooks {

	@Before

	public void beforeScenario() {

		BaseClass.initializeBrowser();

	}

	@After

	public void afterScenario(Scenario scenario) throws IOException {
		CommonUtil util = new CommonUtil();
		if(scenario.isFailed()) {
            scenario.attach(util.captureScreenshot(scenario.getName()+"_screenshots"), "png",scenario.getName());
        }

//		if (scenario.isFailed()) {
//
//			
//
//			util.captureScreenshot(scenario.getName());
//		}

		BaseClass.quitBrowser();
	}
}