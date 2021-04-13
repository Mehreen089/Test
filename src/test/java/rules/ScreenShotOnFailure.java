package rules;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailure extends TestWatcher {

    private RemoteWebDriver driver;
    private String fileName = "";

    public ScreenShotOnFailure(RemoteWebDriver driver){
        this.driver = driver;
    }

    @Override
    public void starting(Description description){
        fileName = description.getMethodName();
    }

    @Override
    public void finished(Description description){
        if(driver != null)
            driver.quit();
    }

    public void failed(Throwable e, Description description){
        try {
            captureScreenShot(fileName);
        } catch (Throwable t) {
            t.getStackTrace();
        }
    }

    public void captureScreenShot(String fileName) throws IOException {
        File filePath = new File(System.getProperty("user.dir"));
        File path = new File(filePath, "/Screenshots");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(path + "/"+fileName  + ".png");
        FileUtils.copyFile(scrFile, targetFile);
    }
}