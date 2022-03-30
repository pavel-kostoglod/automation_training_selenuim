package task_30;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_1 {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private String EMAIL = "automationtester.p";
    private String PASSWORD = "automationtester";
    private WebDriver driver;
    private WebDriverWait wait;
    private Test_1_locators elements;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
        elements = new Test_1_locators();
    }

    @Test
    void test_1() {
        driver.get("https://mail.yandex.com");
        driver.findElement(elements.FIRST_LOGIN_BUTTON).click();
        WebElement loginInput = driver.findElement(elements.EMAIL_INPUT);
        loginInput.sendKeys(EMAIL);
        driver.findElement(elements.SUBMIT_BUTTON).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(elements.PASS_INPUT));
        WebElement passInput = driver.findElement(elements.PASS_INPUT);
        passInput.sendKeys(PASSWORD);
        driver.findElement(elements.SUBMIT_BUTTON).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(elements.PHONE_INPUT));

        Assertions.assertTrue(driver.findElement(elements.PHONE_INPUT).isDisplayed());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
