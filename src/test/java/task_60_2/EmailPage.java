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

public class EmailPage {
    private final String EMAIL = "automationtester.p";
    private WebDriverWait wait;
    private RemoteWebDriver driver;

    @FindBy(how = How.NAME, using = "login")
    WebElement emailInput;

    @FindBy(how = How.CLASS_NAME, using = "Button2_type_submit")
    WebElement submitButton;

    @FindBy(how = How.NAME, using = "passwd")
    WebElement passwordInput;

    public EmailPage() {
        wait = WebDriverWaitSingleton.getWaiter();
        driver = RemoteWebDriverSingleton.getDriver();
    }

    public void enterEmail() {
        emailInput.sendKeys(EMAIL);
    }

    public PasswordPage clickSubmitEmailButton() {
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        return PageFactory.initElements(driver, PasswordPage.class);
    }
}
