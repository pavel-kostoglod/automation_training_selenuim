package task_40;

import org.openqa.selenium.By;

public class Task40Locators {
    // Test2
    public static final By.ById SELECT = new By.ById("multi-select");
    // Test3
    public static final By.ByXPath CLICK_GO_GET_CONFIRM_BOX_BUTTON = new By.ByXPath("//*[@id='confirm-demo']/preceding-sibling::button");
    public static final By.ByXPath CONFIRM_BOX_TEXT = new By.ByXPath("//*[@id='confirm-demo']");
    public static final By.ByXPath CLICK_GO_GET_ALERT_BOX_BUTTON = new By.ByXPath("//*[@id='prompt-demo']/preceding-sibling::button");
    public static final By.ByXPath SUBMITTED_ALERT_BOX_TEXT = new By.ByXPath("//*[@id='prompt-demo']");
    // Test4
    public static final By.ByXPath GET_NEW_USER_BUTTON = new By.ByXPath("//button[@id='save']");
    public static final By.ByXPath NEW_USER_BLOCK_WITH_ATTRIBUTES = new By.ByXPath("//img[contains(@src, 'https://randomuser.me')]");
    // Test5
    public static final By.ByXPath DOWNLOAD_BUTTON = new By.ByXPath("//*[@id='cricle-btn']");
    public static final By.ByXPath DOWNLOAD_PROGRESS_TEXT = new By.ByXPath("//*[@class='percenttext']");
    // Test6
    public static final By.ByXPath SHOW_SELECT = new By.ByXPath("//select[@name='example_length']");
    public static final By.ByXPath TABLE_ROW = new By.ByXPath("//tr[contains(@class, 'odd') or contains(@class, 'even')]");
}
