import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryAddress extends Setup {
    @Test
    void TestAddressDialog()
    {
        openAddressDialog();

        // Assertion

        closeAddressDialog();

        // Assertion
    }

    @Test
    void SetDeliveryAddress()
    {
        setAddress("Biscayne Hall");

        Assert.assertEquals(checkAddress(), "Biscayne Hall");
    }

    @Test
    void ChangeDeliveryAddress()
    {
        setAddress("Osprey Hall");

        Assert.assertEquals(checkAddress(), "Osprey Hall");
    }

    void setAddress(String Address)
    {
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

    void openAddressDialog()
    {

    }

    void closeAddressDialog()
    {

    }
}
