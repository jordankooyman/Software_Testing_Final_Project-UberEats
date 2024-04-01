import org.testng.annotations.Test;

public class Checkout {
    @Test (priority = 1)
    void ViewCart()
    {
        // Go to cart and take screenshot
    }

    @Test (priority = 2)
    void EnterCheckout()
    {
        // Go to checkout from cart
    }

    @Test (priority = 3)
    void EnterLocation()
    {
        // Enter desired delivery location (?)
    }

    @Test (priority = 4)
    void EnterTime()
    {
        // Enter desired delivery time (?)
    }

    @Test (priority = 5)
    void BeginPayment()
    {
        // Start payment, enter invalid info and take screenshot, stopping here
    }
}
