import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryAddress extends Setup {
    @Test (priority = 1)
    void TestAddressDialog() {
//        wait(500);
        Assert.assertTrue(checkAddress().contains("Florida Gulf Coast University"));
//        Assert.assertEquals(checkAddress(),"Florida Gulf Coast University");

        openAddressDialog();
        WebElement dialogBox = null;

        try {
            dialogBox = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div/div[2]"));
            Assert.assertNotNull(dialogBox);
        } catch (NoSuchElementException e)
        {
            Assert.fail();
        }

        closeAddressDialog();

        dialogBox = null;
        try {
            dialogBox = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div/div[2]"));
            Assert.fail();
        } catch (NoSuchElementException e)
        {
            Assert.assertNull(dialogBox);
        }

        Assert.assertTrue(checkAddress().contains("Florida Gulf Coast University"));
    }

    @Test (priority = 2)
    void SetDeliveryAddress() {
        setAddress("Biscayne");

        Assert.assertTrue(checkAddress().contains("Biscayne Hall"));
    }

    @Test (priority = 3)
    void ChangeDeliveryAddress() {
        setAddress("Osprey");

        Assert.assertTrue(checkAddress().contains("Osprey Hall"));
    }

    void setAddress(String newAddress) {
        wait(3000);
        openAddressDialog();

        driver.findElement(By.partialLinkText("hange")).click(); // Look for "Change" or "click.change" button text

        // Wait for the dialog box to update
        wait(3000);

        driver.findElement(By.id("location-typeahead-location-manager-input")).sendKeys(newAddress);
        wait(2000); // Wait for search to complete
        driver.findElement(By.id("location-typeahead-location-manager-input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("location-typeahead-location-manager-input")).sendKeys(Keys.ENTER); // Closes Dialog as well
        wait(3000);

        // closeAddressDialog();
    }

    String checkAddress()
    {
        String Address = "";

        // Find address
        Address = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/header/div/div/div/div/div/div[2]/div[1]/div[2]/a")).getText();

        return Address;
    }

    void openAddressDialog() {
        //driver.findElement(By.partialLinkText(curAddress).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/header/div/div/div/div/div/div[2]/div[1]/div[2]/a")).click();

        // Wait for the dialog box to open
        wait(1000);
    }

    void closeAddressDialog()
    {
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div/div[2]/div[2]/button")).click();

        // Wait for the dialog box to close
        wait(1100);
    }
}
