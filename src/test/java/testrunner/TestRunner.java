package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/", 
		glue="stepdefinition", 
		monochrome=true, 
		dryRun=false, 
//		plugin= {"pretty", "html:target/cucumber_reports/cucumber_report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunner {

}
