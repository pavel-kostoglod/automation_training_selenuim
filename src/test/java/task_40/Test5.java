package task_40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test5 {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private WebDriver driver;
    private WebDriverWait wait;
    private final int WAIT = 30;
    private final int POOLING_FREQUENCY = 200;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, WAIT, POOLING_FREQUENCY);
    }

    @Test
    void refreshPageWhenDownloadProgressIs50Percents() {
        driver.get(URL);
        driver.findElement(Task40Locators.DOWNLOAD_BUTTON).click();

        wait.until(ExpectedConditions.textToBe(Task40Locators.DOWNLOAD_PROGRESS_TEXT, "50%"));
        driver.navigate().refresh();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
