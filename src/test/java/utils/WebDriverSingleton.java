package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import task_60_2.TestConstants;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver=null;
    }
}
