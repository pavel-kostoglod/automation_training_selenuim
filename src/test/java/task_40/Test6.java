package task_40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test6 {
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
    void snth() {
        driver.get(URL);
        Select show = new Select(driver.findElement(Task40Locators.SHOW_SELECT));
        show.selectByVisibleText("10");
        List<Employee> employeeList = collectEmployees(30, 500000);
        for (Employee e: employeeList) {
            System.out.println(e);
        }
    }


    private List<Employee> collectEmployees(int age, int salary) {
        int numberOfRows = driver.findElements(Task40Locators.TABLE_ROW).size();
        List<Employee> employeeList = new ArrayList<>();

        for(int n = 1; n <= numberOfRows; n++) {
            if (
                    Integer.parseInt(driver.findElement(By.xpath(String.format(Task40Locators.AGE_CELL, n))).getText()) > age &&
                    Integer.parseInt(driver.findElement(By.xpath(String.format(Task40Locators.SALARY_CELL, n))).getAttribute("data-order")) <= salary
            ) {
                String name = driver.findElement(By.xpath(String.format(Task40Locators.NAME_CELL, n))).getAttribute("data-search");
                String position = driver.findElement(By.xpath(String.format(Task40Locators.POSITION_CELL, n))).getText();
                String office = driver.findElement(By.xpath(String.format(Task40Locators.OFFICE_CELL, n))).getText();

                employeeList.add(new Employee(name, position, office));
            }
        }
        return employeeList;
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}

class Employee {
    private String name;
    private String position;
    private String office;


    Employee(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}
