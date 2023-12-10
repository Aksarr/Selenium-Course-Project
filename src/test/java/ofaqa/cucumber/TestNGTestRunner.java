package ofaqa.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Eclipse\\Projects\\SeleniumFrameworkDesign\\src\\test\\java\\ofaqa\\cucumber", glue = "ofaqa.cucumberStepDefinitions", tags = "@ErrorValidation", monochrome = true, plugin = {
		"html:target\\cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
