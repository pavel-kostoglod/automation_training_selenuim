package task_60_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    private String PASSWORD = "automationtester";
    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(how = How.NAME, using = "passwd")
    WebElement passwordInput;

    @FindBy(how = How.CLASS_NAME, using = "Button2_type_submit")
    WebElement submitButton;

    public PasswordPage() {
        wait = LoginTests.getWaiter();
        driver = LoginTests.getDriver();
    }

    public void enterPassword() {
        passwordInput.sendKeys(PASSWORD);
    }

    public PhoneNumberPage clickSubmitEmailButton() {
        submitButton.click();
        return PageFactory.initElements(driver, PhoneNumberPage.class);
    }
}
