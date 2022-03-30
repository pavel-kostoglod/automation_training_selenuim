package task_30;

import org.openqa.selenium.By;

public class Test_1_locators {
    final By.ByXPath FIRST_LOGIN_BUTTON = new By.ByXPath("//*[contains(text(), 'Log in')]/ancestor::a");
    final By.ByName EMAIL_INPUT = new By.ByName("login");
    final By.ByCssSelector PASS_INPUT = new By.ByCssSelector("input[name='passwd']");
    final By.ByClassName SUBMIT_BUTTON = new By.ByClassName("Button2_type_submit");
    final By.ById PHONE_INPUT = new By.ById("passp-field-phoneNumber");


}
