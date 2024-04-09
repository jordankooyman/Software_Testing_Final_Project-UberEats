import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

public class NearbyPickup extends Setup {
    @Test (priority = 1)
    void testTogglePickupMode()
    {
        switchToPickup();

        try {
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[1]/div[2]")).getText().contains("Pickup nearby"));
        } catch (NoSuchElementException e) {
            Assert.fail("Not on Pickup Page");
        }

        exitPickup();

        try {
            Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[1]/div[2]")).getText().contains("Pickup nearby"));
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    @Test (priority = 2)
    void testZoom()
    {
        switchToPickup();
        zoomIn();
        zoomIn();
        zoomIn();

        Assert.assertTrue(withinRange(attributeCount("//*[@id=\"view-default-view\"]/div[2]"),1, 40), "Incorrect Number of Restaurants shown around FGCU");

        zoomOut();
        zoomOut();
        zoomOut();

        Assert.assertTrue(withinRange(attributeCount("//*[@id=\"view-default-view\"]/div[2]"),50, 150), "Incorrect Number of Restaurants shown around FGCU area");

        exitPickup();
    }

    @Test (priority = 4)
    void selectRestaurantFromList()
    {
        switchToPickup();
        zoomIn();
        wait(2000);
        zoomIn();

        clickFromList("Insomnia Cookie");

        Assert.assertEquals(driver.getTitle(), "Order Insomnia Cookies (Fort Myers) Menu Delivery【Menu & Prices】| Fort Myers-Naples | Uber Eats");

        clickXPath("//*[@id=\"wrapper\"]/header/div/div/div/div/div/div[1]/a/img");
        wait(250);

        Assert.assertEquals(driver.getTitle(), "Order Food Online | Food Delivery App | Uber Eats");

        exitPickup();
    }

//    @Test (priority = 3)
    void selectRestaurantFromMap()
    {
        // Extra toggle sequence to ensure the map will stay centered on FGCU (delivery location given) (for testing only)
        switchToPickup();
        zoomIn();
        exitPickup();

        switchToPickup();
//        moveMap();
        zoomIn();
        zoomIn();

        clickMapPin("Insomnia Cookie");

        wait(2000);

        Assert.assertEquals(driver.getTitle(), "Order Insomnia Cookies (Fort Myers) Menu Delivery【Menu & Prices】| Fort Myers-Naples | Uber Eats");

        clickXPath("//*[@id=\"wrapper\"]/header/div/div/div/div/div/div[1]/a/img"); // Back to Main page
        wait(250);

        Assert.assertEquals(driver.getTitle(), "Order Food Online | Food Delivery App | Uber Eats");

        exitPickup();
    }

    void switchToPickup()
    {
        clickXPath("//*[@id=\"wrapper\"]/header/div/div/div/div/div/div[2]/div[1]/div[1]/div/div/div[2]/div");
        wait(2000); // Give enough time for the map to load
    }

    void exitPickup()
    {
        clickXPath("//*[@id=\"wrapper\"]/header/div/div/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div");
        wait(500);
    }

    void zoomIn()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div[2]/div[2]/div[1]");
        wait(500);
    }

    void zoomOut()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div[2]/div[2]/div[2]");
        wait(500);
    }

//    void moveMap()
//    {
//        WebElement map = driver.findElement(By.xpath("//*[@id=\"view-default-view\"]"));
//
//        Actions actions = new Actions(driver);
//
//        // Click and drag the map
//        actions.clickAndHold(map)       // Drag the map by 300 pixels horizontally (left) and 200 pixels vertically (up)
//                .moveByOffset(300, 200)
//                .release()
//                .perform();
//        wait(500);
//    }

    void clickFromList(String Restaurant)
    {
        WebElement selection = driver.findElement(By.partialLinkText(Restaurant));
        // Find all parent elements using the relative XPath expression "../../.."
        List<WebElement> parentElements = selection.findElements(By.xpath("../../../.."));

        // Assuming there is only one parent element, take the first one in the list
        WebElement parent = parentElements.isEmpty() ? null : parentElements.get(0);

        Assert.assertNotNull(parent);

        parent.click();
        wait(750);
    }

    void clickMapPin(String Restaurant)
    {
        WebElement selection = driver.findElement(By.xpath("//*[@id=\"view-default-view\"]" + "/div[contains(., '" + Restaurant + "')]")); // Find the right bubble

        // Find the parent element using a relative XPath expression
        WebElement parent = selection.findElement(By.xpath(".."));

        // Starting at: [@id="view-default-view"]/div[2]/div[2]/div/div/div[2] <-- Has Restaurant name
        // Get to:      [@id="view-default-view"]/div[2]/div[2]/div/div/div[1] <-- Has action to open popup

        List<WebElement> childElements = parent.findElements(By.xpath("./*"));

        // Assuming there are 2 elements in the list, get the first one
        WebElement otherChild = childElements.isEmpty() ? null : childElements.get(0); // get a variable for the element that has to be clicked

        Assert.assertNotNull(otherChild);


        // Attempts to try to click on the element, but the element is covered and not directly clickable

//        WebElement grandParent = parent.findElement(By.xpath(".."));
//
//        // otherChild.click(); // Alternative method since this element is hidden un
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].children[0].click();", parent); // forcibly click the hidden element

//        js.executeScript("arguments[0].style.visibility = 'visible';", otherChild); // force hidden element visible (normally only visible when hovering over it)

//        Actions action = new Actions(driver);
//        action.moveToElement(otherChild.findElement(By.xpath(".."))).perform();
//        wait(10000);
////        action.click().perform();
//        action.release();
//
//        otherChild.click();


//        // Get the location of the WebElement within the browser window
//        Point location = otherChild.getLocation();
//
//        // Get the size of the element
//        Dimension size = otherChild.getSize();
//
//        // Calculate the center point of the element
//        int centerX = (int) (location.getX() + size.getWidth() / 2);
//        int centerY = (int) (location.getY() + size.getHeight() / 2);
//
//        // Get the browser's position on the screen
//        Point browserPosition = driver.manage().window().getPosition();
//
//        // Calculate the absolute screen coordinates
//        int screenX = browserPosition.getX() + centerX;
//        int screenY = browserPosition.getY() + centerY;
//
//        try { // https://www.geeksforgeeks.org/automate-mouse-events-using-java-robot-class/
//            Robot robot = new Robot();
//            robot.mouseMove(screenX, screenY);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            wait(5);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        } catch (AWTException e) {
//            Assert.fail("Robot Error");
//        }


        wait(1000); // Wait for popup animation to complete and everything to load

        clickXPath("//*[@id=\"view-default-view\"]/div[2]/div[7]/div/a/div"); // Click pop up window
    }

    int attributeCount(String XPath)
    {
        WebElement element = driver.findElement(By.xpath(XPath));

        // Find all child elements
        List<WebElement> childElements = element.findElements(By.xpath("./*"));

        return childElements.size();
    }
}
