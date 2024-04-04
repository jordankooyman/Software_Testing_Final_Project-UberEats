import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Meals extends Setup{

    @Test(priority = 1)
    void RestaurantSelection() {
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys("Chipotle");
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("search-suggestions-typeahead-input")).click();
        driver.findElement(By.id("search-suggestions-typeahead-item-0")).click();
    }
}
