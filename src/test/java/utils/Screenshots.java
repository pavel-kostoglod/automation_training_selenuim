package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void makeScreenshot(WebDriver driver, String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(String.format("src/test/resources/screenshots/%s.png", fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
