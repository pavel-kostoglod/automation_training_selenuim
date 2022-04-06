package task_40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test3 {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private WebDriver driver;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    void rightTextAppearsAfterClickingOkButtonInConfirmBox() {
        driver.get(URL);
        driver.findElement(Task40Locators.CLICK_GO_GET_CONFIRM_BOX_BUTTON).click();
        driver.switchTo().alert().accept();

        Assertions.assertTrue(driver.findElement(Task40Locators.ACCEPT_CONFIRM_BOX_TEXT).isDisplayed());
    }

    @Test
    void rightTextAppearsAfterClickingCancelButtonInConfirmBox() {
        driver.get(URL);
        driver.findElement(Task40Locators.CLICK_GO_GET_CONFIRM_BOX_BUTTON).click();
        driver.switchTo().alert().dismiss();

        Assertions.assertTrue(driver.findElement(Task40Locators.DISMISS_CONFIRM_BOX_TEXT).isDisplayed());
    }

    @Test
    void rightTextAppearsAfterSubmittingSomeTextInAlertBox() {
        final String TEST_MESSAGE = "test message";
        driver.get(URL);
        driver.findElement(Task40Locators.CLICK_GO_GET_ALERT_BOX_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(TEST_MESSAGE);
        alert.accept();

        Assertions.assertTrue(driver.findElement(Task40Locators.SUBMITTED_ALERT_BOX_TEXT).getText().contains(TEST_MESSAGE));
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
