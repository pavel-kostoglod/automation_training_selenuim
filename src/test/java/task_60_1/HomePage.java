package task_60_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriverWait wait) {
        this.wait = wait;
        driver = LoginTests.getDriver();
    }

    public EmailPage clickLoginButton() {
        driver.findElement(Locators.FIRST_LOGIN_BUTTON).click();
        return new EmailPage(wait);
    }
}
