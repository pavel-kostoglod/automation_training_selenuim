package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import task_60_2.TestConstants;

import java.net.MalformedURLException;
import java.net.URL;


public class RemoteWebDriverSingleton {
    private static RemoteWebDriver driver;

    private RemoteWebDriverSingleton() {}

    public static RemoteWebDriver getDriver(){
        if (driver == null) {
//            ChromeOptions options = new ChromeOptions();
//            EdgeOptions options = new EdgeOptions();
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("platformName", "Windows 8.1");
            options.setCapability("browserVersion", "85");
            URL url = null;
            try {
                url = new URL("https://"+
                        TestConstants.SAUCELAB_USERNAME+":"+
                        TestConstants.SAUCELAB_KEY+
                        "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
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
