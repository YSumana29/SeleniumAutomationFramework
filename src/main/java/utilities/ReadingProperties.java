package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadingProperties {

    private static final Properties envProperties = new Properties();
    private static final Properties browserProperties = new Properties();
    private static String ENV_RelativeFilePath = "src/main/java/resources/config/environment.properties";
    private static String BROWSER_RelativeFilePath = "src/main/java/resources/config/browser.properties";
    private static final String ENV_FILE_PATH = System.getProperty("user.dir")
            + File.separator + ENV_RelativeFilePath.replace("/", File.separator);
    private static final String BROWSER_FILE_PATH = System.getProperty("user.dir")
            + File.separator + BROWSER_RelativeFilePath.replace("/", File.separator);

    static {
        loadProperties(envProperties, ENV_FILE_PATH);
        loadProperties(browserProperties, BROWSER_FILE_PATH);

    }

    public static void loadProperties(Properties properties, String filePath) {

        try (
                FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);

        } catch (Exception e) {
            System.err.println("Error loading properties file: " + filePath + " - " + e.getMessage());
        }

    }

    public static String getBrowserPropertyValue(String key) {
        return browserProperties.getProperty(key);
    }

    public static String getEnvironmentPropertyValue(String key) {
        return envProperties.getProperty(key);
    }
}
