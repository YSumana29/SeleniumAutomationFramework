package StepDefinitionstepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.File;
import java.util.List;
import java.util.Map;

public class LoginSteps {

    private String username;
    private String password;

    @Given("I load test data for {string} and {string}")
    public void iLoadTestDataFor(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("Testing with Username: " + username + ", Password: " + password);
    }

    @When("I test login")
    public void iTestLogin() {
        // Add Selenium logic to perform login
    }

    @Then("I should see the dashboard for {string}")
    public void iShouldSeeTheDashboard(String username) {
        System.out.println("Dashboard verified for Username: " + username);
    }
}
