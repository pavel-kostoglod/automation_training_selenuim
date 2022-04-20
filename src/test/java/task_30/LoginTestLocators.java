package task_30;

import org.openqa.selenium.By;

public class LoginTestLocators {
    static final By.ByXPath FIRST_LOGIN_BUTTON = new By.ByXPath("//*[contains(text(), 'Log in')]/ancestor::a");
    static final By.ByName EMAIL_INPUT = new By.ByName("login");
    static final By.ByCssSelector PASS_INPUT = new By.ByCssSelector("input[name='passwd']");
    static final By.ByClassName SUBMIT_BUTTON = new By.ByClassName("Button2_type_submit");
    static final By.ByXPath USER_NAME_LABEL = new By.ByXPath("//*[contains(@class, 'user-pic')]/preceding-sibling::span[@class='user-account__name']");
}
