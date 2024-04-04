import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryAddress extends Setup {
    @Test
    void TestAddressDialog() {
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
    }

    @Test
    void SetDeliveryAddress() {
        setAddress("Biscayne Hall");

        Assert.assertEquals(checkAddress(), "Biscayne Hall"); // Update
    }

    @Test
    void ChangeDeliveryAddress() {
        setAddress("Osprey Hall");

        Assert.assertEquals(checkAddress(), "Osprey Hall"); // Update
    }

    void setAddress(String Address) {
        openAddressDialog();

        // Do something

        closeAddressDialog();
    }

    String checkAddress()
    {
        String Address = "";

        // Find address

        return Address;
    }

    void openAddressDialog() {
        driver.findElement(By.partialLinkText("Florida Gulf Coast Uni")).click();

        // Wait for the dialog box to open
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void closeAddressDialog()
    {
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div/div[2]/div[2]/button")).click();

        // Wait for the dialog box to close
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
