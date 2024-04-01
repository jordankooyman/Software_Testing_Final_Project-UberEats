import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class Setup {
    public WebDriver driver;
    @BeforeSuite
    void OpenBrowser()
    {
        driver = new ChromeDriver();

        driver.get("https://www.ubereats.com");
        driver.manage().window().maximize();
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

    public void TakeScreenshot(String filepath)
    {

    }
}
