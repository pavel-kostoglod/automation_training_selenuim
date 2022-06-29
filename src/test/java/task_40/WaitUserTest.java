package task_40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUserTest {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    private WebDriver driver;
    private WebDriverWait wait;
    private final int WAIT = 30;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, WAIT);
    }

    @Test
    void verifyNewUserAppearing() {
        driver.get(URL);
        driver.findElement(Task40Locators.GET_NEW_USER_BUTTON).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(Task40Locators.NEW_USER_BLOCK_WITH_ATTRIBUTES));
        Assertions.assertTrue(driver.findElement(Task40Locators.NEW_USER_BLOCK_WITH_ATTRIBUTES).isDisplayed());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
