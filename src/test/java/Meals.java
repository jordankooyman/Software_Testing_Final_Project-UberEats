import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Meals extends Setup {

    @Test(priority = 1)
    void RestaurantSelection() {
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys("Chipotle"); //Searches for the nearest Chipotle (the one in GCTC)
        wait(4000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys(Keys.ENTER); //hits the enter key to submit the string
        wait(4000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).click(); //Clicks again to access the item search result list
        wait(4000);
        driver.findElement(By.id("search-suggestions-typeahead-item-0")).click(); //Uses the search listing as opposed to the restaurant card
        Assert.assertEquals(driver.getTitle(), "Uber Eats | Food Delivery and Takeout | Order Online from Restaurants Near You");
        wait(5000);
    }

    @Test(priority = 2)
    void StandardMealSection() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[4]/div/div[2]/div[1]/div[2]/div/div/nav/div[3]/button")).click(); //Navigates to the premade bowls
        wait(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ubereats.com/store/chipotle-mexican-grill-10010-university-plaza-drive/gV8nhcqQThWJqxe97nKKQQ?diningMode=DELIVERY&sc=SEARCH_SUGGESTION"); //Checks to verify URL
        wait(4000);
    }

    @Test(priority = 3)
    void OrderStandardMeal() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[4]/div/div[3]/div/ul/li[3]/div/ul/li[3]/a/div/div[2]/div/button")).click(); //Selects premade bowl
        wait(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/button[1]")).click(); //Adds to cart
        wait(4000);
    }

    @Test(priority = 4)
    void OrderCustomMeal() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[4]/div/div[2]/div[1]/div[2]/div/div/nav/div[3]/button")).click(); //Navigates to custom items
        wait(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-600)", ""); //Scrolls up by 600 pixels
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/main/div[4]/div/div[3]/div/ul/li[2]/div/ul/li[1]/a/div/div[2]/div/button")).click(); //selects custom bowl
        wait(3000);
        driver.findElement(By.id("quick_view-item-2a5005c4-e44d-5918-a05a-06b4669357e4-1-742f32d2-5332-53c8-b038-f529dfc31cb5+0")).click(); //Selects sofritas
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/button")).click(); //Backs out of portion size to confirm normal portion
        wait(2000);
        driver.findElement(By.id("quick_view-item-a36c5832-7650-5057-ac2b-f6a8f094d188-1-c6084151-5d90-54f6-8445-b3dff79421dc+2")).click(); //Brown rice
        wait(3000);
        driver.findElement(By.id("quick_view-item-d55ec641-0af2-549e-b798-3b8a7355257c-1-ba97cba2-0c7b-53d7-8877-19eb1dfef0e9+3")).click(); //Pinto beans
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[1]")).click(); //Tomato salsa
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[2]")).click(); //corn salsa
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[4]")).click(); //red tomatillo salsa
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[7]")).click(); //cheese
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[8]")).click(); //lettuce
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[5]/div/div[2]/div[9]")).click(); //queso
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li[7]/div/div[2]/div[7]/div[1]/button")).click(); //Blackberry Izze
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div[3]/div/button[1]")).click(); //adds to cart
        wait(3000);
    }
    @Test(priority = 5)
    void RemoveStandardMeal(){
        WebElement reopenCart = driver.findElement(By.cssSelector("button[aria-label='checkout']"));
        wait(2000);
        reopenCart.click();
        WebElement standardMealQuantity = driver.findElement(By.cssSelector("li[data-test='cart-item-fcb9ce04-1a4d-5a02-a945-9e5e943917a5'] select"));
        wait(2000);
        Select dropdown = new Select(standardMealQuantity);
        wait(2000);
        dropdown.selectByValue("0");
        wait(3000);
    }
}
