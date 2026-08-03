package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

    features = "resources/features/login.feature",

    glue = { "stepDefinitions", "hooks" },

    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/json-report/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    
    },

    publish = true,
    monochrome = true,
//    tags = "@Admin_Login_Positive"
    tags = "@testNG"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}