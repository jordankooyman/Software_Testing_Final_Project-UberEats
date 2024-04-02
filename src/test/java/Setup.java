import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

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

        driver.get("https://www.ubereats.com");
        driver.manage().window().maximize();
    }

    @Test (priority = 1)
    void CheckWebsite() throws IOException {
        Assert.assertEquals(driver.getTitle(), "Uber Eats | Food Delivery and Takeout | Order Online from Restaurants Near You");
        TakeScreenshot(screenshotPath+"Homepage.png");
    }

    @Test (priority = 2)
    void EnterAddress() throws InterruptedException {
        driver.findElement(By.id("location-typeahead-home-input")).sendKeys("Florida Gulf Coast University");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[1]/div[2]/div/div[1]/div/button")).click(); // Does not work yet
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Order Food Online | Food Delivery App | Uber Eats");
    }

//    @AfterSuite
//    void CloseBrowser()
//    {
//        driver.quit();
//    }

    public WebDriver getDriver() // from: https://stackoverflow.com/questions/42331659/how-to-pass-selenium-webdriver-instance-to-another-class
    {
        if (driver == null){
            driver = new ChromeDriver();
            return driver;
        }else{
            return driver;
        }
    }

    public void TakeScreenshot(String filepath) throws IOException
    {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(filepath);
        FileHandler.copy(src, des);
    }
}
