import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Meals extends Setup{

    @Test(priority = 1)
    void MealSelection(){
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys("Chipotle");
    }
}
