package task_60_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    private String PASSWORD = "automationtester";
    private WebDriver driver;
    private WebDriverWait wait;

    public PasswordPage(WebDriverWait wait) {
        this.wait = wait;
        driver = LoginTests.getDriver();
    }

    public void enterPassword() {
        WebElement passInput = driver.findElement(Locators.PASS_INPUT);
        passInput.sendKeys(PASSWORD);
    }

    public PhoneNumberPage clickSubmitEmailButton() {
        driver.findElement(Locators.SUBMIT_BUTTON).click();
        return new PhoneNumberPage(wait);
    }
}
