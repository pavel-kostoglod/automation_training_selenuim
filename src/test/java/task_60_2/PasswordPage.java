package task_60_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RemoteWebDriverSingleton;
import utils.WebDriverSingleton;
import utils.WebDriverWaitSingleton;

public class PasswordPage {
    private String PASSWORD = "automationtester1";
    private WebDriverWait wait;
    private RemoteWebDriver driver;

    @FindBy(how = How.NAME, using = "passwd")
    WebElement passwordInput;

    @FindBy(how = How.CLASS_NAME, using = "Button2_type_submit")
    WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//a[@href='#inbox']")
    WebElement mailBoxButton;

    public PasswordPage() {
        wait = WebDriverWaitSingleton.getWaiter();
        driver = RemoteWebDriverSingleton.getDriver();
    }

    public void enterPassword() {
        passwordInput.sendKeys(PASSWORD);
    }

    public MailPage clickSubmitEmailButton() {
        submitButton.click();
        return PageFactory.initElements(driver, MailPage.class);
    }

    public boolean isMainPageAfterLogin() {
        return mailBoxButton.isDisplayed();
    }
}
