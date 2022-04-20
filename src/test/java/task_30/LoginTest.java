package task_30;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://mail.yandex.com";
    private final int WAIT = 10;
    private final int POOLING_FREQUENCY = 1000;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit waiter
        wait = new WebDriverWait(driver, WAIT, POOLING_FREQUENCY); // explicit waiter initialization
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/credentials.csv")
    void verifyLogin(String email, String pass) {
        driver.get(URL);
        driver.findElement(LoginTestLocators.FIRST_LOGIN_BUTTON).click();
        WebElement loginInput = driver.findElement(LoginTestLocators.EMAIL_INPUT);
        loginInput.sendKeys(email);
        driver.findElement(LoginTestLocators.SUBMIT_BUTTON).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { // "native" programming language explicit waiter
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginTestLocators.PASS_INPUT)); // explicit waiter usage
        WebElement passInput = driver.findElement(LoginTestLocators.PASS_INPUT);
        passInput.sendKeys(pass);
        driver.findElement(LoginTestLocators.SUBMIT_BUTTON).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(LoginTestLocators.USER_NAME_LABEL)); // explicit waiter usage

        Assertions.assertTrue(driver.findElement(LoginTestLocators.USER_NAME_LABEL).isEnabled());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
