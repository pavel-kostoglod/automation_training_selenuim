package utils;

import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitSingleton {
    private static WebDriverWait wait;

    private WebDriverWaitSingleton() {}

    public static WebDriverWait getWaiter() {
        if (wait == null) {
            wait = new WebDriverWait(RemoteWebDriverSingleton.getDriver(), 5);
        }
        return wait;
    }
}
