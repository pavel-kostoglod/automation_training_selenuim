package task_60_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;
import utils.WebDriverWaitSingleton;

public class HomePage {
    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Log in')]/ancestor::a")
    WebElement firstLoginButton;

    public HomePage() {
        wait = WebDriverWaitSingleton.getWaiter();
        driver = WebDriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public EmailPage clickLoginButton() {
        firstLoginButton.click();
        return PageFactory.initElements(driver, EmailPage.class);
    }
}
