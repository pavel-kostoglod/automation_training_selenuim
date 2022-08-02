package task_60_2;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.*;

import java.net.MalformedURLException;

//@ExtendWith(TestResultsWatcher.class)
@Nested
@Epic("Log in examples")
@Feature("Log in/log out tests")
public class LoginTests {
//    private static WebDriver driver;
    private static RemoteWebDriver driver;
//    private static WebDriverWait wait;

    @RegisterExtension
    public SauceTestWatcher watcher = new SauceTestWatcher();

//    @BeforeEach
//    void setup() {
//        driver = WebDriverSingleton.getDriver();
//        wait = WebDriverWaitSingleton.getWaiter();
//    }

    // new
    @BeforeEach
    public void setup(TestInfo testInfo) throws MalformedURLException {
        driver = RemoteWebDriverSingleton.getDriver();
    }

//    @AfterEach
//    void cleanup() {
//        WebDriverSingleton.quitDriver();
//    }

    @AfterEach
    void cleanup() {
        RemoteWebDriverSingleton.quitDriver();
    }

    @Test
    @Description("Verify Login")
    @Issue("TEST-213")
    @Link("https://example.org")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Log in story")
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