package utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import task_60_2.TestConstants;

import java.net.MalformedURLException;
import java.net.URL;


public class RemoteWebDriverSingleton {
    private static RemoteWebDriver driver;

    private RemoteWebDriverSingleton() {}

    public static RemoteWebDriver getDriver(){
        if (driver == null) {
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", System.getenv("oauth-paul.kostoglod-a52bb"));
            sauceOptions.setCapability("access_key", System.getenv("aef6580f-50b8-414b-9982-6f6b155c0617"));
//            sauceOptions.setCapability("name", testInfo.getDisplayName());
            sauceOptions.setCapability("browserVersion", "latest");

            ChromeOptions options = new ChromeOptions();
            options.setCapability("sauce:options", sauceOptions);
            URL url = null;
            try {
                url = new URL("https://ondemand.eu-central-1.saucelabs.com/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            driver = new RemoteWebDriver(url, options);
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver=null;
    }
}
