package task_60_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage {
    private String EMAIL = "automationtester.p";
    WebDriver driver;
    private WebDriverWait wait;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    public void enterEmail() {
        WebElement loginInput = driver.findElement(Locators.EMAIL_INPUT);
        loginInput.sendKeys(EMAIL);
    }

    public PasswordPage clickSubmitEmailButton() {
        driver.findElement(Locators.SUBMIT_BUTTON).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.PASS_INPUT));
        return new PasswordPage(driver);
    }
}
