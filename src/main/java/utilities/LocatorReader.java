package utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

import org.openqa.selenium.By;

public class LocatorReader {

    private static JsonObject locators;
    private static final String LOCATOR_FILE_PATH = "C://Users//User//Automation//SeleniumAutomationFramework//SeleniumAutomationFramework//SeleniumAutomationFramework//src//main//java//resources//locators//locators.json";

    static {
        try (FileReader reader = new FileReader(LOCATOR_FILE_PATH)) {
            locators = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            throw new RuntimeException("Error reading locators file: " + e.getMessage());
        }
    }

    public static String getLocatorValue(String page, String element) {
        return locators.getAsJsonObject(page)
                .getAsJsonObject(element)
                .get("value")
                .getAsString();
    }

    public static String getLocatorType(String page, String element) {
        return locators.getAsJsonObject(page)
                .getAsJsonObject(element)
                .get("type")
                .getAsString();
    }

    public static By getByLocator(String elementLocator) throws Exception {
        String[] elementLocatorSplit = elementLocator.split("\\.");
        String type = getLocatorType(elementLocatorSplit[0], elementLocatorSplit[1]);
        String value = getLocatorValue(elementLocatorSplit[0], elementLocatorSplit[1]);
        By byLocator;
        if (type.equalsIgnoreCase("id")) {
            byLocator = By.id(value);
        } else if (type.equalsIgnoreCase("xpath")) {
            byLocator = By.xpath(value);
        } else if (type.equalsIgnoreCase("css")) {
            byLocator = By.cssSelector(value);
        } else if (type.equalsIgnoreCase("className")) {
            byLocator = By.className(value);
        } else if (type.equalsIgnoreCase("linkText")) {
            byLocator = By.linkText(value);
        } else if (type.equalsIgnoreCase("tagName")) {
            byLocator = By.tagName(value);
        } else {
            throw new Exception("The type of the Locator" + elementLocator + "is invalid/ not handled");
        }

        return byLocator;
    }

    /*
     * public static void main(String[] args) {
     * System.out.println(locators.getAsJsonObject("name").toString());
     * 
     * }
     */
}
