package task_60_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {
    private String PASSWORD = "automationtester";
    WebDriver driver;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPassword() {
        WebElement passInput = driver.findElement(Locators.PASS_INPUT);
        passInput.sendKeys(PASSWORD);
    }

    public PhoneNumberPage clickSubmitEmailButton() {
        driver.findElement(Locators.SUBMIT_BUTTON).click();
        return new PhoneNumberPage(driver);
    }
}
