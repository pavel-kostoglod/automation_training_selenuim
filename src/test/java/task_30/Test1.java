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

public class Test1 {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private String EMAIL = "automationtester.p";
    private String PASSWORD = "automationtester";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    void test1() {
        driver.get("https://mail.yandex.com");
        driver.findElement(Test1Locators.FIRST_LOGIN_BUTTON).click();
        WebElement loginInput = driver.findElement(Test1Locators.EMAIL_INPUT);
        loginInput.sendKeys(EMAIL);
        driver.findElement(Test1Locators.SUBMIT_BUTTON).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Test1Locators.PASS_INPUT));
        WebElement passInput = driver.findElement(Test1Locators.PASS_INPUT);
        passInput.sendKeys(PASSWORD);
        driver.findElement(Test1Locators.SUBMIT_BUTTON).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(Test1Locators.PHONE_INPUT));

        Assertions.assertTrue(driver.findElement(Test1Locators.PHONE_INPUT).isDisplayed());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
