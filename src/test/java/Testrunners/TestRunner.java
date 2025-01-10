package Testrunners;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/Features/loginFeature2.feature", // Path to feature files
                glue = { "StepDefinitions" }, // Path to step definitions
                // tags = "@SmokeTest", // Tags to filter scenarios
                plugin = {
                                "pretty", // Prints formatted console output
                                "html:target/cucumber-reports.html", // HTML report
                                "json:target/cucumber-reports.json", // JSON report
                                "rerun:target/failed_scenarios.txt" // Rerun failed scenarios
                }, monochrome = true // Makes console output readable
)

public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(name = "scenarios")
        public Object[][] scenarios() {
                // Load data from JSON and dynamically generate the Examples section
                try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        File file = new File("src/main/java/resources/locators/testData.json");
                        List<Map<String, String>> testData = objectMapper.readValue(file, List.class);

                        // Convert JSON data into Cucumber Examples format
                        Object[][] examples = new Object[testData.size()][2];
                        for (int i = 0; i < testData.size(); i++) {
                                examples[i][0] = testData.get(i).get("username");
                                examples[i][1] = testData.get(i).get("password");
                        }

                        return examples;
                } catch (Exception e) {
                        throw new RuntimeException("Failed to load test data", e);
                }
        }

}
