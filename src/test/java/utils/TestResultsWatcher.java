package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestResultsWatcher implements TestWatcher, AfterAllCallback {
    private final WebDriver driver;
    private final String fileName;
    private Capabilities cap;

    public TestResultsWatcher() {
        this.fileName = RandomStringUtils.randomAlphabetic(10);
        this.driver = WebDriverSingleton.getDriver();
        this.cap = ((RemoteWebDriver) driver).getCapabilities();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Screenshots.makeScreenshot(driver, fileName);
        System.out.println(cap.getBrowserName());
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {

    }
}