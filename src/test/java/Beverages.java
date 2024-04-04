import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Beverages extends Setup {
    @BeforeClass
    void setUp() throws InterruptedException {
        driver.get("https://www.ubereats.com/feed?diningMode=DELIVERY&pl=JTdC...");
        //Check title will fail
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys("Poke Fusion");
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-input")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("search-suggestions-typeahead-item-0")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    void orderLemon() throws InterruptedException {
        WebElement beveragesButton = driver.findElement(By.xpath("//button[.//div[text()='Beverages']]"));
        beveragesButton.click();
        Thread.sleep(1000);

        // Add lemonade
        WebElement lemonadeAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-73756f1c-8813-4c81-a1a9-a1dc97e8406c']//button[@data-testid='quick-add-button']"));
        lemonadeAddButton.click();
        Thread.sleep(2000);

        // WebElement additionalLemonadeAdd = driver.findElement(By.xpath("  "));
        // Thread.sleep(1000);
        // additionalLemonadeAdd.click();
        // Thread.sleep(3000);
    }

    @Test(priority = 2)
    void orderKombucha() throws InterruptedException {
        // Add kombucha
        WebElement kombuchaAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-abdeea98-065c-4a59-9092-cbd3e0fd925a']//button[@data-testid='quick-add-button']"));
        Thread.sleep(2000);
        kombuchaAddButton.click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void orderWater() throws InterruptedException {
        // Add water
        WebElement waterAddButton = driver.findElement(By.xpath("//li[@data-test='store-item-60538e90-cb33-4323-98e4-579e44d28aa4']//button[@data-testid='quick-add-button']"));
        waterAddButton.click();
        Thread.sleep(2000);
    }
}
