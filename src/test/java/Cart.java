import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Cart extends Meals{

    @Test(priority = 1)
    void LoadCart(){ //Runs all of meals class to load the cart again for testing
        Assert.assertEquals(driver.getTitle(), "Order Food Online | Food Delivery App | Uber Eats");
        wait(3000);
    }

    @Test(priority = 2)
    void IncreaseStandardMeal(){
        WebElement reopenCart = driver.findElement(By.cssSelector("button[aria-label='checkout']"));
        wait(2000);
        reopenCart.click();
        wait(3000);
        WebElement standardMealQuantity = driver.findElement(By.cssSelector("li[data-test='cart-item-fcb9ce04-1a4d-5a02-a945-9e5e943917a5'] select"));
        wait(2000);
        Select dropdown = new Select(standardMealQuantity);
        wait(2000);
        dropdown.selectByValue("200000"); // selects option with the value of "2"
        wait(3000);
    }

}
