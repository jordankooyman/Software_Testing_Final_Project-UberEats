import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondFactorAuthentication extends Setup{
    private WebDriver driver2;
    @Test(priority = 1)
    void OpenGmail()
    {
        // Open a new browser
        driver2 = new ChromeDriver();
        driver2.manage().window().maximize();

        // Navigate to Gmail
        driver2.get("https://mail.google.com");

        //Assert.assertEquals(driver2.getTitle(), "Something");
    }

    @Test (priority = 2)
    void GmailLogin() throws InterruptedException {
        driver2.findElement(By.name("identifier")).sendKeys("fgcuSeleniumTest2@gmail.com"); // Enter username
        driver2.findElement(By.id("identifierNext")).click(); // Click "Next"
        Thread.sleep(5000);
        driver2.findElement(By.name("Passwd")).sendKeys("tF$E3hM,##mq8Zy"); // Enter password
        driver2.findElement(By.id("passwordNext")).click(); // Click "Next" - Submit button
    }

}
