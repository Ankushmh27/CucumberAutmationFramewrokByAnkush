package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "./resources/features/login.feature",

		glue = { "stepDefinitions", "hooks" },

		plugin = {

				"pretty",

				"html:target/cucumber-report.html" }, monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests {

}