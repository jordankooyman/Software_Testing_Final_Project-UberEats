import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login extends Setup {
    @Test (priority = 1)
    void LoginPage() {
        WebDriver driver = getDriver();
//        System.out.println("Navigate to Login Page");
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div/div/div/div/div/div/div[3]/div/a[1]")).click();

        Assert.assertEquals(driver.getTitle(), "Uber");

        driver.findElement(By.id("phone-number-or-email-input-container")).sendKeys("testtakehome@gmail.com");

        driver.findElement(By.id("forward-button")).click();
    }

    @Test (priority = 2)
    void SolvePuzzle() throws InterruptedException {
        // Puzzle Prompt
        Thread.sleep(1000); // Debugging breakpoint here, resume after puzzle solved
    }


}
