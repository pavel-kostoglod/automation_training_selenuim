package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;

public class TestResultsWatcher implements TestWatcher, AfterAllCallback {
    private final WebDriver driver;
    private final String fileName;

    public TestResultsWatcher() {
        this.fileName = RandomStringUtils.randomAlphabetic(10);
        this.driver = WebDriverSingleton.getDriver();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Screenshots.makeScreenshot(driver, fileName);
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {

    }
}