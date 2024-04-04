import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class Beverages extends Setup {
    @Test(priority = 1)
    void navigateToRestaurant() throws InterruptedException {
        // function to navigate to correct starting point for tests
        driver.get("https://www.ubereats.com/feed?diningMode=DELIVERY&pl=JTdC...");
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys("Poke Fusion");
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-item-0")).click();
        Thread.sleep(2000);
    }

    private void addButton(int numberOfClicks) throws InterruptedException {
        // finds the "add" button using CSS selector with a specific "data test" attribute to identify it
        WebElement addButton = driver.findElement(By.cssSelector("button[data-test='quick-add-plus']"));
        for (int i = 0; i < numberOfClicks; i++) {
            addButton.click();
            Thread.sleep(1500); // delay to allow the UI to process each click
        }
    }

    @Test(priority = 1)
    // find "beverages" tab on restaurant page
    void viewBeverages() throws InterruptedException {
        Thread.sleep(2000);
        WebElement beveragesButton = driver.findElement(By.xpath("//button[.//div[text()='Beverages']]"));
        beveragesButton.click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    // adds different beverages to cart in different amounts
    void addMultiBeverages() throws InterruptedException {
        // Add lemonade
        WebElement lemonadeAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-73756f1c-8813-4c81-a1a9-a1dc97e8406c']//button[@data-testid='quick-add-button']"));
        lemonadeAddButton.click(); // adds to cart
        Thread.sleep(2000);
        addButton(1); // clicks add button once more for lemonade
        Thread.sleep(1000);
        // Add kombucha
        WebElement kombuchaAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-abdeea98-065c-4a59-9092-cbd3e0fd925a']//button[@data-testid='quick-add-button']"));
        kombuchaAddButton.click();
        Thread.sleep(2000);
        addButton(2);
        Thread.sleep(1000);
        // Add water
        WebElement waterAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-60538e90-cb33-4323-98e4-579e44d28aa4']//button[@data-testid='quick-add-button']"));
        waterAddButton.click();
        Thread.sleep(1000);
        addButton(3);
        Thread.sleep(2000);
    }
        @Test(priority = 3)
        void editCart () throws InterruptedException {
        // views cart and edits quantity of kombucha from 3 to 2
            WebElement checkoutButton = driver.findElement(By.cssSelector("button[aria-label='checkout']"));
            Thread.sleep(2000);
            checkoutButton.click();

            WebElement dropdownElement = driver.findElement(By.cssSelector("li[data-test='cart-item-abdeea98-065c-4a59-9092-cbd3e0fd925a'] select"));
            Thread.sleep(2000);
            Select dropdown = new Select(dropdownElement);
            Thread.sleep(2000);
            dropdown.selectByValue("200000"); // selects option with the value of "2"
            Thread.sleep(3000);
        }
    }