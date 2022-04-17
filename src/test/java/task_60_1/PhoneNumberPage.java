package task_60_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneNumberPage {
    WebDriver driver;
    private WebDriverWait wait;

    public PhoneNumberPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }

    public PasswordPage logout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ACCOUNT_NAME));
        driver.findElement(Locators.ACCOUNT_NAME).click();
        driver.findElement(Locators.LOGOUT_BUTTON).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.PASS_INPUT));
        return new PasswordPage(driver);
    }
}
