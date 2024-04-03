import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import java.io.File;
import java.io.IOException;

public class Setup {
    public WebDriver driver;
    public String LoginCode = "";
    public String screenshotPath = "C:\\Users\\jorda\\Desktop\\";
    @BeforeSuite
    void OpenBrowser()
    {
        driver = new ChromeDriver();

        driver.get("https://www.ubereats.com/feed?diningMode=DELIVERY&pl=JTdCJTIyYWRkcmVzcyUyMiUzQSUyMkZsb3JpZGElMjBHdWxmJTIwQ29hc3QlMjBVbml2ZXJzaXR5JTIyJTJDJTIycmVmZXJlbmNlJTIyJTNBJTIyaGVyZSUzQXBkcyUzQXBsYWNlJTNBODQwZGh0eWUtZTQ0NWUzZmM4ZDc2NGJjOGE0MTZhNGYyN2FhMmRiNWMlMjIlMkMlMjJyZWZlcmVuY2VUeXBlJTIyJTNBJTIyaGVyZV9wbGFjZXMlMjIlMkMlMjJsYXRpdHVkZSUyMiUzQTI2LjQ2MzY0JTJDJTIybG9uZ2l0dWRlJTIyJTNBLTgxLjc3MjU1JTdE");
        driver.manage().window().maximize();
    }

//    @Test (priority = 1)
//    void CheckWebsite() throws IOException {
//        Assert.assertEquals(driver.getTitle(), "Uber Eats | Food Delivery and Takeout | Order Online from Restaurants Near You");
//        TakeScreenshot(screenshotPath+"Homepage.png");
//    }

    @Test (priority = 1)
    void CheckTitle() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Order Food Online | Food Delivery App | Uber Eats");
    }

    @AfterSuite
    void CloseBrowser()
    {
        driver.quit();
    }

    public WebDriver getDriver() // from: https://stackoverflow.com/questions/42331659/how-to-pass-selenium-webdriver-instance-to-another-class
    {
        if (driver == null){ //This null designation causes a problem on the CheckTitle method: java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.WebDriver.getTitle()" because "this.driver" is null
            driver = new ChromeDriver();
            return driver;
        }else{
            return driver;
        }
    }

//    public void TakeScreenshot(String filepath) throws IOException
//    {
//        TakesScreenshot screenshot = (TakesScreenshot)driver;
//        File src = screenshot.getScreenshotAs(OutputType.FILE);
//        File des = new File(filepath);
//        FileHandler.copy(src, des);
//    }
}
