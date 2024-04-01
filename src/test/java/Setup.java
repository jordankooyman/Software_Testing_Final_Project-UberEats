import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Setup {
    public WebDriver driver;
    @BeforeSuite
    void OpenBrowser()
    {
        driver = new ChromeDriver();

        driver.get("https://www.ubereats.com");
        driver.manage().window().maximize();
    }

    @AfterSuite
    void CloseBrowser()
    {
        driver.quit();
    }

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
        File des = new File("C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\School\\Software Testing (CEN 4072)\\WebScreenshot.png");
        FileHandler.copy(src, des);
    }
}
