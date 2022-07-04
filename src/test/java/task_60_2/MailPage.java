package task_60_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;
import utils.WebDriverWaitSingleton;

public class MailPage {
    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@href='https://passport.yandex.com']")
    WebElement accountName;

    @FindBy(how = How.XPATH, using = "//*[@aria-label='Log out']")
    WebElement logoutButton;

    @FindBy(how = How.XPATH, using = "//a/*[contains(text(), 'Create an account')]")
    WebElement createAccountButton;

    public MailPage() {
        wait = WebDriverWaitSingleton.getWaiter();
        driver = WebDriverSingleton.getDriver();
    }

    public PasswordPage logout() {
        wait.until(ExpectedConditions.visibilityOf(accountName));
        accountName.click();
        logoutButton.click();
        return PageFactory.initElements(driver, PasswordPage.class);
    }

    public boolean isPasswordPageAfterLogout() {
        return createAccountButton.isDisplayed();
    }
}
