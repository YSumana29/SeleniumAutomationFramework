package StepDefinitions;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import Base.browserInitialization;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LocatorReader;
import utilities.ReadingProperties;

public class StepDefinitions1 {

    browserInitialization browserDriver = new browserInitialization();
    WebDriver driver = browserDriver.getDriver();

    private List<Map<String, String>> testData;

    @Given("the user is on login page")
    public void navigate_to_login_page() throws UnsupportedEncodingException {
        String url = ReadingProperties.getEnvironmentPropertyValue("stage");
        driver.get(url);
    }

    @Then("check if the page title is correct")
    public void check_page_title() {
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "abcdefg";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @When("I click on element {string}")
    public void I_click_on_element(String s) {
        By byLocator;
        System.out.println(s);
        try {
            byLocator = LocatorReader.getByLocator(s);
            driver.findElement(byLocator).sendKeys("Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
