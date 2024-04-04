import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test(priority = 3) //Made this right when the restaurant closed, appears that it should work because the error mentioned the button is clickable just not at a certain point due to the schedule order popup
    void OrderStandardMeal() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[5]/div/div[3]/div/ul/li[3]/div/ul/li[3]/a/div/div[2]/div/button")).click();
        Thread.sleep(2000);
    }
}
