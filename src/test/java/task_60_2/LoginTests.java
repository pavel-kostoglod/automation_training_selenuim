package task_60_2;

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
    private static WebDriverWait wait;

    private LoginTests() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWaiter() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 5);
        }
        return wait;
    }

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = getDriver();
        wait = getWaiter();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    void verifyLoginAndLogout() {
        loadHomePage();
        HomePage homePage = new HomePage();
        EmailPage emailPage = homePage.clickLoginButton();
        emailPage.enterEmail();
        PasswordPage passwordPage = emailPage.clickSubmitEmailButton();
        passwordPage.enterPassword();
        PhoneNumberPage phoneNumberPage = passwordPage.clickSubmitEmailButton();
        phoneNumberPage.logout();

        Assertions.assertTrue(phoneNumberPage.isPasswordPageAfterLogout());
    }

    private void loadHomePage() {
        driver.get(URL);
    }
}