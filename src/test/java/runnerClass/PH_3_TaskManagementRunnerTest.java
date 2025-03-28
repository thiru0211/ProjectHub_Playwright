package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles\\PH_3_TaskManagement.feature", 
glue = "stepDefinition", 
monochrome = true,
//dryRun = true,
//tags="@TC_55",
plugin = {"pretty",
		"html:target/cucumber/Task_Management_cucumberhtml-report.html",
		"json:target/cucumber/Task_Management_cucumber.json",
		"rerun:target/failedScenarios/Task_Management_Failed.txt"
		})
public class PH_3_TaskManagementRunnerTest {

}


