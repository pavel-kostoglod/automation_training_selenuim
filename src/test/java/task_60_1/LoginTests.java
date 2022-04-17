package task_60_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://mail.yandex.com/";
    private WebDriver driver;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    void verifyLoginAndLogout() {
        loadHomePage();
        HomePage homePage = new HomePage(driver);
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