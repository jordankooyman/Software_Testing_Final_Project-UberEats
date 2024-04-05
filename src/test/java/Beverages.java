import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class Beverages extends Setup {
    @Test(priority = 1)
    void navigateToRestaurant() {
        // function to navigate to correct starting point for tests
        driver.get("https://www.ubereats.com/feed?diningMode=DELIVERY&pl=JTdC...");
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys("Poke Fusion");
        wait(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys(Keys.ENTER);
        wait(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).click();
        wait(2000);
        driver.findElement(By.id("search-suggestions-typeahead-item-0")).click();
        wait(2000);
    }

    private void addButton(int numberOfClicks) {
        // finds the "add" button using CSS selector with a specific "data test" attribute to identify it
        WebElement addButton = driver.findElement(By.cssSelector("button[data-test='quick-add-plus']"));
        for (int i = 0; i < numberOfClicks; i++) {
            addButton.click();
            wait(1500); // delay to allow the UI to process each click
        }
    }

    @Test(priority = 1)
    // find "beverages" tab on restaurant page
    void viewBeverages() {
        wait(2000);
        WebElement beveragesButton = driver.findElement(By.xpath("//button[.//div[text()='Beverages']]"));
        beveragesButton.click();
        wait(2000);
    }

    @Test(priority = 2)
    // adds different beverages to cart in different amounts
    void addMultiBeverages() {
        // Add lemonade
        WebElement lemonadeAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-73756f1c-8813-4c81-a1a9-a1dc97e8406c']//button[@data-testid='quick-add-button']"));
        lemonadeAddButton.click(); // adds to cart
        wait(2000);
        addButton(1); // clicks add button once more for lemonade
        wait(1000);
        // Add kombucha
        WebElement kombuchaAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-abdeea98-065c-4a59-9092-cbd3e0fd925a']//button[@data-testid='quick-add-button']"));
        kombuchaAddButton.click();
        wait(2000);
        addButton(2);
        wait(1000);
        // Add water
        WebElement waterAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-60538e90-cb33-4323-98e4-579e44d28aa4']//button[@data-testid='quick-add-button']"));
        waterAddButton.click();
        wait(1000);
        addButton(3);
        wait(2000);
    }
        @Test(priority = 3)
        void editCart () {
        // views cart and edits quantity of kombucha from 3 to 2
            WebElement checkoutButton = driver.findElement(By.cssSelector("button[aria-label='checkout']"));
            wait(2000);
            checkoutButton.click();

            WebElement dropdownElement = driver.findElement(By.cssSelector("li[data-test='cart-item-abdeea98-065c-4a59-9092-cbd3e0fd925a'] select"));
            wait(2000);
            Select dropdown = new Select(dropdownElement);
            wait(2000);
            dropdown.selectByValue("200000"); // selects option with the value of "2"
            wait(3000);
        }
    }