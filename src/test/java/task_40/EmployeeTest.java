package task_40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.EmployeesHandler;
import utils.Employee;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmployeeTest {
    private final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private final String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
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
    void collectingEmployees() {
        driver.get(URL);
        Select show = new Select(driver.findElement(Task40Locators.SHOW_SELECT));
        show.selectByVisibleText("10");
        List<Employee> employeeList = EmployeesHandler.collectEmployees(30, 500000, driver);
        for (Employee e: employeeList) {
            System.out.println(e);
        }
        Assertions.assertTrue(employeeList.size() > 0);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}

