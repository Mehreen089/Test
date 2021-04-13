package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage{

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id="breadcrumb_text")
    MobileElement headline;

    @AndroidFindBy(id="option_menu_search")
    MobileElement search;

    @AndroidFindBy(id="search_src_text")
    MobileElement searchTxt;

    @AndroidFindBy(id="message")
    MobileElement message;

    public String getHeadline(){
        return headline.getText();
    }

    public void search(String item){
        search.click();
        searchTxt.setValue(item);
    }

    public String getMessage(){

        return message.getText();
    }

}
