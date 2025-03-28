package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles\\PH_1_Login.feature", 
glue = "stepDefinition", 
monochrome = true,
//dryRun = true,
//tags="@TC_15",
		plugin = {"pretty",
				"html:target/cucumber/Login_cucumberhtml-report.html",
				"json:target/cucumber/Login_cucumber.json",
				"rerun:target/failedScenarios/Login_Failed.txt"
				})
public class PH_1_LoginRunnerTest {

}


