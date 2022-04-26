package task_60_1;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import task_60_2.EmailPage;
import task_60_2.HomePage;
import task_60_2.PasswordPage;
import task_60_2.PhoneNumberPage;

import java.io.File;
import java.io.IOException;

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
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/test/resources/screenshots/home_page.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        task_60_2.HomePage homePage = new HomePage();
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