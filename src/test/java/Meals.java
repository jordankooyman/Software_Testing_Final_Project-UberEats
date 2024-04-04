import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Meals extends Setup{

    @Test(priority = 1)
    void RestaurantSelection() throws InterruptedException{
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys("Chipotle"); //Searches for the nearest Chipotle (the one in GCTC)
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys(Keys.ENTER); //hits the enter key to submit the string
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).click(); //Clicks again to access the item search result list
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-item-0")).click(); //Uses the search listing as opposed to the restaurant card
        Assert.assertEquals(driver.getTitle(), "Order Food Online | Food Delivery App | Uber Eats");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    void StandardMealSection() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[2]/div[1]/div[2]/div/div/nav/div[3]/button")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.ubereats.com/store/chipotle-mexican-grill-10010-university-plaza-drive/gV8nhcqQThWJqxe97nKKQQ?diningMode=DELIVERY&sc=SEARCH_SUGGESTION");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void OrderStandardMeal() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[3]/div/ul/li[3]/div/ul/li[3]/a/div/div[2]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/button[1]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void OrderCustomMeal() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[2]/div[1]/div[2]/div/div/nav/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[3]/div/ul/li[2]/div/ul/li[1]/a/div/div[2]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("quick_view-item-2a5005c4-e44d-5918-a05a-06b4669357e4-1-742f32d2-5332-53c8-b038-f529dfc31cb5+0")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/button")).click();
        Thread.sleep(2000);

    }
}
