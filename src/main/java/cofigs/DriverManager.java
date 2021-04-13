package cofigs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverManager {

    private AppiumDriver driver;
    private String host = "127.0.0.1";
    private String port = "4723";
    private String androidAppPath = "src/main/resources/";
    private String androidVersion = "11";

    public DriverManager(){}

    public AppiumDriver setupDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidVersion);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.documentsui");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.documentsui.files.FilesActivity");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("enableWebviewDetailsCollection",true);
//        File filePath = new File(System.getProperty("user.dir"));
//        File appDir = new File(filePath, androidAppPath);
//        File app = new File(appDir, "Amazon_shopping.apk");
//        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        try {
            driver = new AppiumDriver(new URL("http://" + host + ":" + port + "/wd/hub"), capabilities);
        } catch(Exception e) {
            e.getStackTrace();
        }

        return driver;
    }

    public AppiumDriver getDriver(){
        return driver;
    }
}
