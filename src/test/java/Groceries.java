import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Groceries extends Setup{

    @Test(priority = 1)
    void NavigateToGroceries() {
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/div/div[1]/li/a")).click(); //grocery filter
        wait(3000);
        Assert.assertEquals(driver.getTitle(),"Order Food Online | Food Delivery App | Uber Eats");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.ubereats.com/category-feed/Shop?diningMode=DELIVERY&pl=JTdCJTIyYWRkcmVzcyUyMiUzQSUyMkZsb3JpZGElMjBHdWxmJTIwQ29hc3QlMjBVbml2ZXJzaXR5JTIyJTJDJTIycmVmZXJlbmNlJTIyJTNBJTIyaGVyZSUzQXBkcyUzQXBsYWNlJTNBODQwZGh0eWUtZTQ0NWUzZmM4ZDc2NGJjOGE0MTZhNGYyN2FhMmRiNWMlMjIlMkMlMjJyZWZlcmVuY2VUeXBlJTIyJTNBJTIyaGVyZV9wbGFjZXMlMjIlMkMlMjJsYXRpdHVkZSUyMiUzQTI2LjQ2MzY0JTJDJTIybG9uZ2l0dWRlJTIyJTNBLTgxLjc3MjU1JTdE");
        wait(6000);
    }

    @Test(priority = 2)
    void FilterGroceryType(){ //Navigates to 3 different grocery pages then navigates back to the main grocery page via the home page (due to no direct link)
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div/div/div[3]/div[1]/nav/ul/li[7]/a")).click(); //pharmacy filter
        wait(4000);
        driver.navigate().back();
        wait(4000);
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div/div/div[3]/div[1]/nav/ul/li[11]/a")).click(); //Specialty foods filter
        wait(4000);
        driver.navigate().back();
        wait(4000);
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div/div/div[3]/div[1]/nav/ul/li[3]/a")).click(); //convenience filter
        wait(4000);
    }

    @Test(priority = 3)
    void SelectGroceryStore(){
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div/div/div[3]/div[1]/div/a/h3")).click(); //Selects WAWA
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.ubereats.com/store/wawa-5237-16971-aaron-warnek-pl/9ImCpSA0UhShMAm-_jLylA?diningMode=DELIVERY");
    }

    @Test
}
