package task_60_2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Screenshots;
import utils.TestResultsWatcher;
import utils.WebDriverSingleton;
import utils.WebDriverWaitSingleton;

@ExtendWith(TestResultsWatcher.class)
@Nested
@DisplayName("Basic tests")
public class LoginTests {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeEach
    void setup() {
        driver = WebDriverSingleton.getDriver();
        wait = WebDriverWaitSingleton.getWaiter();
    }

    @AfterEach
    void cleanup() {
        WebDriverSingleton.quitDriver();
    }

    @Test
    @DisplayName("Verify Login")
    void verifyLogin() {
        loadHomePage();
        HomePage homePage = new HomePage();
        Screenshots.makeScreenshot(driver, "home_page");
        EmailPage emailPage = homePage.clickLoginButton();
        emailPage.enterEmail();
        PasswordPage passwordPage = emailPage.clickSubmitEmailButton();
        passwordPage.enterPassword();
        passwordPage.clickSubmitEmailButton();

        Assertions.assertTrue(passwordPage.isMainPageAfterLogin());
    }

    @Test
    @DisplayName("Verify Logout")
    void verifyLogout() {
        loadHomePage();
        HomePage homePage = new HomePage();
        Screenshots.makeScreenshot(driver, "home_page");
        EmailPage emailPage = homePage.clickLoginButton();
        emailPage.enterEmail();
        PasswordPage passwordPage = emailPage.clickSubmitEmailButton();
        passwordPage.enterPassword();
        MailPage mailPage = passwordPage.clickSubmitEmailButton();
        mailPage.logout();

        Assertions.assertTrue(mailPage.isPasswordPageAfterLogout());
    }

    private void loadHomePage() {
        driver.get(TestConstants.URL);
    }
}