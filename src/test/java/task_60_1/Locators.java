package task_60_1;

import org.openqa.selenium.By;

public class Locators {
    static final By.ByXPath FIRST_LOGIN_BUTTON = new By.ByXPath("//*[contains(text(), 'Log in')]/ancestor::a");
    static final By.ByName EMAIL_INPUT = new By.ByName("login");
    static final By.ByCssSelector PASS_INPUT = new By.ByCssSelector("input[name='passwd']");
    static final By.ByClassName SUBMIT_BUTTON = new By.ByClassName("Button2_type_submit");
    static final By.ByXPath ACCOUNT_NAME = new By.ByXPath("//*[@href='https://passport.yandex.com']");
    static final By.ByXPath LOGOUT_BUTTON = new By.ByXPath("//*[@aria-label='Log out']");
}
