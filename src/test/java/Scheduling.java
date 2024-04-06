import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scheduling extends Setup {

    // Select delivery options
    @Test (priority = 1)
    void selectDeliveryDetails() {
        WebElement deliveryDetails = driver.findElement(By.cssSelector("svg[aria-label='Deliver to']"));
        deliveryDetails.click();
        wait(2000);
    }
    // Choose to schedule a delivery
    @Test (priority = 2)
    void selectScheduleOptions() {
        WebElement scheduleOptions = driver.findElement(By.cssSelector("a[data-testid='schedule-button']"));
        scheduleOptions.click();
        wait(2000);
    }
    // Select a date (tomorrow) and a time for delivery
    @Test (priority = 3)
    void clickDateSelector() {
        // Locate and click the delivery time option
        WebElement scheduleForTomorrow = driver.findElement(By.xpath("//button[@data-testid='date-schedule-selector-button' and contains(., 'Tomorrow')]"));
        wait(2000);
        scheduleForTomorrow.click();
        wait(4000);
        WebElement timeSlot = driver.findElement(By.xpath("//label[.//span[text()='5:30 PM - 6:00 PM']]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", timeSlot);
        wait(3000);
    }
    // Switch from delivery tomorrow to today and "deliver now"
    @Test (priority = 4)
    void selectDeliverNow() {
        WebElement scheduleForToday = driver.findElement(By.xpath("//button[@data-testid='date-schedule-selector-button' and contains(., 'Today')]"));
        scheduleForToday.click();
        wait(2000);
        WebElement deliverNowButton = driver.findElement(By.xpath("//span[@data-testid='rich-text' and text()='Deliver now']"));
        deliverNowButton.click();
        wait(2000);
    }
}
