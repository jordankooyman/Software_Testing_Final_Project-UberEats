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
        Thread.sleep(4000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys(Keys.ENTER); //hits the enter key to submit the string
        Thread.sleep(4000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).click(); //Clicks again to access the item search result list
        Thread.sleep(4000);
        driver.findElement(By.id("search-suggestions-typeahead-item-0")).click(); //Uses the search listing as opposed to the restaurant card
        Assert.assertEquals(driver.getTitle(), "Uber Eats | Food Delivery and Takeout | Order Online from Restaurants Near You");
        Thread.sleep(4000);
    }

    @Test(priority = 2)
    void StandardMealSection() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[2]/div[1]/div[2]/div/div/nav/div[3]/button")).click(); //Navigates to the premade bowls
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.ubereats.com/store/chipotle-mexican-grill-10010-university-plaza-drive/gV8nhcqQThWJqxe97nKKQQ?diningMode=DELIVERY&sc=SEARCH_SUGGESTION"); //Checks to verify URL
        Thread.sleep(4000);
    }

    @Test(priority = 3)
    void OrderStandardMeal() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[3]/div/ul/li[3]/div/ul/li[3]/a/div/div[2]/div/button")).click(); //Selects premade bowl
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/button[1]")).click(); //Adds to cart
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void OrderCustomMeal() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[2]/div[1]/div[2]/div/div/nav/div[2]/button")).click(); //Navigates to custom items
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[3]/div/ul/li[2]/div/ul/li[1]/a/div/div[2]/div/button")).click(); //selects custom bowl
        Thread.sleep(2000);
        driver.findElement(By.id("quick_view-item-2a5005c4-e44d-5918-a05a-06b4669357e4-1-742f32d2-5332-53c8-b038-f529dfc31cb5+0")).click(); //Selects sofritas
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/button")).click(); //Backs out of portion size to confirm normal portion
        Thread.sleep(2000);
        driver.findElement(By.id("quick_view-item-a36c5832-7650-5057-ac2b-f6a8f094d188-1-c6084151-5d90-54f6-8445-b3dff79421dc+2")).click(); //Brown rice
        Thread.sleep(3000);
        driver.findElement(By.id("quick_view-item-d55ec641-0af2-549e-b798-3b8a7355257c-1-ba97cba2-0c7b-53d7-8877-19eb1dfef0e9+3")).click(); //Pinto beans
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[1]")).click(); //Tomato salsa
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[2]")).click(); //corn salsa
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[4]")).click(); //red tomatillo salsa
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[7]")).click(); //cheese
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[8]")).click(); //lettuce
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[9]")).click(); //queso
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[7]/div/div[2]/div[7]/div[1]/button")).click(); //Blackberry Izze
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/button[1]")).click(); //adds to cart
        Thread.sleep(3000);
    }
}
