package task_60_1;

import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailPage clickLoginButton() {
        driver.findElement(Locators.FIRST_LOGIN_BUTTON).click();
        return new EmailPage(driver);
    }
}
