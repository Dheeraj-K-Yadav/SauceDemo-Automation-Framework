package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenShort {
    public static String takeScreenshot(WebDriver driver, String testName) {
        // Create a date-based unique name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Take the screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save path
        String destPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(src, new File(destPath));
            System.out.println("📸 Screenshot saved at: " + destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timestamp;
    }
}
