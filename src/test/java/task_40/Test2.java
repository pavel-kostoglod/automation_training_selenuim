package task_40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private WebDriver driver;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    void verify3SelectedOptionsInMultiselect() {
        driver.get(URL);
        Select select = new Select(driver.findElement(Task40Locators.SELECT));
        select.selectByVisibleText("California");
        select.selectByVisibleText("New Jersey");
        select.selectByVisibleText("Texas");
        List<String> expectedSelection = Arrays.asList("California", "New Jersey", "Texas");
        List<String> actualSelection = new ArrayList<>();

        for(WebElement option : select.getAllSelectedOptions()) {
            actualSelection.add(option.getText());
        }

        Assertions.assertArrayEquals(expectedSelection.toArray(),actualSelection.toArray());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
