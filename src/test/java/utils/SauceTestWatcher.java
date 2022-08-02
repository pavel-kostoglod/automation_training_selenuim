package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceTestWatcher implements TestWatcher {
    private static RemoteWebDriver driver;

    @Override
    public void testSuccessful(ExtensionContext context) {
        driver = RemoteWebDriverSingleton.getDriver();
        driver.executeScript("sauce:job-result=passed");
        driver.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        driver = RemoteWebDriverSingleton.getDriver();
        driver.executeScript("sauce:job-result=failed");
        driver.quit();
    }
}
