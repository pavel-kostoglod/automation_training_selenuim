package task_60_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTests {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://mail.yandex.com/";
    private static WebDriver driver;
    private WebDriverWait wait;

    private LoginTests() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = getDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    void verifyLoginAndLogout() {
        loadHomePage();
        HomePage homePage = new HomePage(wait);
        EmailPage emailPage = homePage.clickLoginButton();
        emailPage.enterEmail();
        PasswordPage passwordPage = emailPage.clickSubmitEmailButton();
        passwordPage.enterPassword();
        PhoneNumberPage phoneNumberPage = passwordPage.clickSubmitEmailButton();
        phoneNumberPage.logout();

        Assertions.assertTrue(driver.findElement(Locators.PASS_INPUT).isDisplayed());
    }

    private void loadHomePage() {
        driver.get(URL);
    }
}