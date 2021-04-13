package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest{

    @Test
    public void testHomePage(){
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals("Downloads", homePage.getHeadline());
        homePage.search("item");
        Assert.assertEquals("No items", homePage.getMessage());
    }
}
