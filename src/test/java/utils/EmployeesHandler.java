package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import task_40.Task40Locators;

import java.util.ArrayList;
import java.util.List;

public class EmployeesHandler {

    public static List<Employee> collectEmployees(int age, int salary, WebDriver driver) {
        List<WebElement> rows = driver.findElements(Task40Locators.TABLE_ROW);
        List<Employee> employeeList = new ArrayList<>();

        for(WebElement row: rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (
                    Integer.parseInt(columns.get(3).getText()) > age &&
                            Integer.parseInt(columns.get(5).getAttribute("data-order")) <= salary
            ) {
                String name = columns.get(0).getAttribute("data-search");
                String position = columns.get(1).getText();
                String office = columns.get(2).getText();

                employeeList.add(new Employee(name, position, office));
            }
        }
        return employeeList;
    }
}
