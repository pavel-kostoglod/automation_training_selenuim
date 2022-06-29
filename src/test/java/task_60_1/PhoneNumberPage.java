package task_60_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneNumberPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PhoneNumberPage(WebDriverWait wait) {
        this.wait = wait;
        driver = LoginTests.getDriver();
    }

    public PasswordPage logout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ACCOUNT_NAME));
        driver.findElement(Locators.ACCOUNT_NAME).click();
        driver.findElement(Locators.LOGOUT_BUTTON).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.PASS_INPUT));
        return new PasswordPage(wait);
    }
}
