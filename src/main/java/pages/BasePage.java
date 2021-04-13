package pages;


import cofigs.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class BasePage extends DriverManager {

    protected AppiumDriver driver;

    private Duration DURATION = Duration.ofSeconds(15);

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver,DURATION), this);
    }

}
