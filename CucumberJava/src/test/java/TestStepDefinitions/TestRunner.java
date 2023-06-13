package TestStepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/practice2.feature", glue = {
		"TestStepDefinitions" }, plugin = { "pretty", "json:target/JSONReports/reports.json",
				"junit:target/JUNITReports/reports.xml", "html:target/HTMLReports" })

public class TestRunner {

}
