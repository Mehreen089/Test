package tests;

import cofigs.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.junit.Rule;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rules.ScreenShotOnFailure;

public class BaseTest {

    public AppiumDriver driver;
    public DriverManager driverManager = new DriverManager();

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driverManager.setupDriver());

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        this.driver = driverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){}
}
