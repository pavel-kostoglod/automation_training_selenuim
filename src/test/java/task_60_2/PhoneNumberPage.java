package task_60_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneNumberPage {
    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@href='https://passport.yandex.com']")
    WebElement accountName;

    @FindBy(how = How.XPATH, using = "//*[@aria-label='Log out']")
    WebElement logoutButton;

    @FindBy(how = How.NAME, using = "passwd")
    WebElement passwordInput;

    public PhoneNumberPage() {
        wait = LoginTests.getWaiter();
        driver = LoginTests.getDriver();
    }

    public PasswordPage logout() {
        wait.until(ExpectedConditions.visibilityOf(accountName));
        accountName.click();
        logoutButton.click();
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        return PageFactory.initElements(driver, PasswordPage.class);
    }

    public boolean isPasswordPageAfterLogout() {
        return passwordInput.isDisplayed();
    }
}
