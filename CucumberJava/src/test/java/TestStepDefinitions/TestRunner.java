package TestStepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/login1.feature", glue = {
		"TestStepDefinitions" }, monochrome = true, plugin = { "pretty", "json:target/JSONReports/reports.json",
				"junit:target/JUNITReports/reports.xml", "html:target/HTMLReports" })

public class TestRunner {

}
