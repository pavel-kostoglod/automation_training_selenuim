package task_40;

import org.openqa.selenium.By;

public class Task40Locators {
    // Test2
    static final By.ById SELECT = new By.ById("multi-select");
    // Test3
    static final By.ByXPath CLICK_GO_GET_CONFIRM_BOX_BUTTON = new By.ByXPath("//*[text()='Click the button to display an confirm box:']/following-sibling::button");
    static final By.ByXPath ACCEPT_CONFIRM_BOX_TEXT = new By.ByXPath("//*[text()='Click the button to display an confirm box:']/following-sibling::p[text()='You pressed OK!']");
    static final By.ByXPath DISMISS_CONFIRM_BOX_TEXT = new By.ByXPath("//*[text()='Click the button to display an confirm box:']/following-sibling::p[text()='You pressed Cancel!']");
    static final By.ByXPath CLICK_GO_GET_ALERT_BOX_BUTTON = new By.ByXPath("//*[text()='Click below button for prompt box.']/following-sibling::button");
    static final By.ByXPath SUBMITTED_ALERT_BOX_TEXT = new By.ByXPath("//*[text()='Click below button for prompt box.']/following-sibling::p[@id='prompt-demo']");
    // Test4
    static final By.ByXPath GET_NEW_USER_BUTTON = new By.ByXPath("//button[@id='save']");
    static final By.ByXPath NEW_USER_BLOCK_WITH_ATTRIBUTES = new By.ByXPath("//*[@id='loading' and contains(text(), 'First Name')]");
    // Test5
    static final By.ByXPath DOWNLOAD_BUTTON = new By.ByXPath("//*[@id='cricle-btn']");
    static final By.ByXPath DOWNLOAD_PROGRESS_TEXT = new By.ByXPath("//*[@class='percenttext']");
    // Test6
    static final By.ByXPath SHOW_SELECT = new By.ByXPath("//select[@name='example_length']");
    static final By.ByXPath TABLE_ROW = new By.ByXPath("//tbody/tr");
    static final String AGE_CELL = "//tbody/tr[%d]/td[4]";
    static final String SALARY_CELL = "//tbody/tr[%d]/td[6]";
    static final String NAME_CELL = "//tbody/tr[%d]/td[1]";
    static final String POSITION_CELL = "//tbody/tr[%d]/td[2]";
    static final String OFFICE_CELL = "//tbody/tr[%d]/td[3]";
}
