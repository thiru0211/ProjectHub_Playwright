package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles\\PH_6_Release.feature", 
glue = "stepDefinition", 
//monochrome = true,
dryRun = true,
//tags="@TC_09",
plugin = {"pretty",
		"html:target/cucumber/Timesheet_cucumberhtml-report.html",
		"json:target/cucumber/Timesheet_cucumber.json",
		"rerun:target/failedScenarios/Timesheet_Failed.txt"
		})
public class PH_6_ReleaseRunnerTest {

}


