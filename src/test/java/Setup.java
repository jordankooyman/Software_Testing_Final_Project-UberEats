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
    public String screenshotPath = "C:\\Users\\jorda\\Desktop\\";
    @BeforeSuite
    void OpenBrowser()
    {
        driver = new ChromeDriver();

        // Dead address now: driver.get("https://www.ubereats.com/feed?diningMode=DELIVERY&pl=JTdCJTIyYWRkcmVzcyUyMiUzQSUyMkZsb3JpZGElMjBHdWxmJTIwQ29hc3QlMjBVbml2ZXJzaXR5JTIyJTJDJTIycmVmZXJlbmNlJTIyJTNBJTIyaGVyZSUzQXBkcyUzQXBsYWNlJTNBODQwZGh0eWUtZTQ0NWUzZmM4ZDc2NGJjOGE0MTZhNGYyN2FhMmRiNWMlMjIlMkMlMjJyZWZlcmVuY2VUeXBlJTIyJTNBJTIyaGVyZV9wbGFjZXMlMjIlMkMlMjJsYXRpdHVkZSUyMiUzQTI2LjQ2MzY0JTJDJTIybG9uZ2l0dWRlJTIyJTNBLTgxLjc3MjU1JTdE");
        driver.get("https://www.ubereats.com");
        driver.manage().window().maximize();
        wait(2000);

        WebElement addressBox = driver.findElement(By.id("location-typeahead-home-input"));
        addressBox.sendKeys("\u00A0"); // Non-breaking space (ASCII code 160)
        wait(100);
        addressBox.sendKeys("Florida Gulf Coast University");
        wait(2000); // Wait for search to load
        addressBox.sendKeys(Keys.ARROW_DOWN); // Select first entry in combobox shown
        addressBox.sendKeys(Keys.ENTER);
        wait(5000); // Let new webpage load
    }

    @Test (priority = 1)
    void CheckTitle() {
        Assert.assertEquals(driver.getTitle(), "Order Food Online | Food Delivery App | Uber Eats", "Initial Address not Loaded");
    }

//    @AfterSuite
//    void CloseBrowser()
//    {
//        driver.quit();
//    }

    void wait(int time) // Sleep function with error handling built in
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void clickPartialLinkText(String Text)
    {
        driver.findElement(By.partialLinkText(Text)).click();
        wait(1000);
    }

    void clickXPath(String XPath)
    {
        driver.findElement(By.xpath(XPath)).click();
        wait(1000);
    }

    boolean withinRange(int Value, int LowBound, int HighBound)
    {
        System.out.println("The value checked is: " + Value);
        return Value >= LowBound && Value <= HighBound;
    }


    public void TakeScreenshot(String fileName)
    {
        String filepath = screenshotPath + fileName + ".png";
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(filepath);
        try {
            FileHandler.copy(src, des);
        } catch (IOException e) {
            Assert.fail("IO Exception in Screenshot");
        }
    }
}
