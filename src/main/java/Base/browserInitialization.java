package Base;

import java.io.FileInputStream;
import java.io.ObjectInputFilter.Config;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.errorprone.annotations.ThreadSafe;

import utilities.ReadingProperties;

public class browserInitialization {

    ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

    Properties browserProprties = new Properties();

    String browserName;

    WebDriver driver;

    public WebDriver getDriver() {
        if (threadSafeDriver.get() == null) {
            WebDriver driver = getCorrectDriver();
            threadSafeDriver.set(driver);
        }
        return threadSafeDriver.get();

    }

    public WebDriver getCorrectDriver() {
        browserName = ReadingProperties.getBrowserPropertyValue("browser");
        System.out.println(browserName);
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
