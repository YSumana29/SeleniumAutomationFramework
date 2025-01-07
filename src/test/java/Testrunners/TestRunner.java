package Testrunners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/Features/login.feature",  // Path to feature files
        glue = {"StepDefinitions"},               // Path to step definitions
        //tags = "@SmokeTest",                      // Tags to filter scenarios
        plugin = {
                "pretty",                          // Prints formatted console output
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber-reports.json", // JSON report
                "rerun:target/failed_scenarios.txt"  // Rerun failed scenarios
        },
        monochrome = true                         // Makes console output readable
)

public class TestRunner extends AbstractTestNGCucumberTests {


}
