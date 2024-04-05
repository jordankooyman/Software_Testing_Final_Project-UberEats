import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFilters extends Setup {

    @Test
    void testOneCuisine()
    {
        SelectOneCuisine("BBQ");

        Assert.assertTrue(checkSearchResults(200, 400));

        DeselectOneCuisine("BBQ");

        Assert.assertFalse(checkSearchResults(1, 400));
    }

    @Test
    void testUnder30()
    {
        SelectOneCuisine("Fast Food");
        SelectUnder30();

        Assert.assertTrue(checkSearchResults(10,25));

        DeselectUnder30();
        DeselectOneCuisine("Fast Food");

        Assert.assertFalse(checkSearchResults(10, 350));
    }

    @Test
    void testVegan()
    {
        SelectVegan();

        Assert.assertTrue(checkSearchResults(1,10));

        DeselectVegan();

        Assert.assertFalse(checkSearchResults(1, 350));
    }

    @Test
    void testSorting()
    {
        SelectOneCuisine("Pizza");
        SelectRatingSort();
//        TakeScreenshot("1-RatingSort");
        Assert.assertTrue(checkSorting("Rating"));
        SelectRecommenedSort();
//        TakeScreenshot("2-RecommendedSort");
        Assert.assertTrue(checkSorting("Recommended"));
        SelectDeliverySort();
//        TakeScreenshot("3-DeliveryTimeSort");
        Assert.assertTrue(checkSorting("Delivery time"));
        DeselectSort();
//        TakeScreenshot("4-NoSort");
        Assert.assertFalse(checkSorting("Sort by"));
        DeselectOneCuisine("Pizza");
    }

    @Test
    void CombineFilters()
    {
        SelectOneCuisine("Mexican");
        SelectRatingSort();
        SelectUnder30();

//        TakeScreenshot("1-2FiltersSorted");
        Assert.assertTrue(checkSearchResults(1,10));
        Assert.assertTrue(checkSorting("Rating"));

        DeselectUnder30();

//        TakeScreenshot("2-1FilterSorted");
        Assert.assertTrue(checkSearchResults(50,150));
        Assert.assertTrue(checkSorting("Rating"));

        DeselectSort();
        SelectOneCuisine("Sushi");

//        TakeScreenshot("3-1Filter");
        Assert.assertTrue(checkSearchResults(50,150));
        Assert.assertFalse(checkSorting("Sort by"));

        DeselectOneCuisine("Sushi");
    }
    void SelectOneCuisine(String Filter)
    {
        clickPartialLinkText(Filter);


        boolean Page;
        boolean Search = checkSearchResults(1, 400); // Just ensure it loaded something

        try {
            Page = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div")).getText().contains(Filter);
        } catch (NoSuchElementException e) {
            Page = false;
        }

        Assert.assertTrue(Page || Search);

        Assert.assertFalse(Page, "Loaded Full Page Category Search");
        wait(500);
    }

    void DeselectOneCuisine(String Filter)
    {
        clickPartialLinkText(Filter);
        wait(500);
    }


    void SelectUnder30()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[3]");
        wait(500);
    }


    void DeselectUnder30()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[3]");
        wait(500);
    }

    void SelectVegan()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[7]"); // Dietary
        clickXPath("//*[@id=\"bui4\"]/div/section/div/div[2]/div[1]/ul/button[2]"); // Vegan
        clickXPath("//*[@id=\"bui4\"]/div/section/div/div[2]/div[2]/button[2]"); // Apply
        wait(500);
    }

    void DeselectVegan()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[7]"); // Dietary
        clickXPath("//*[@id=\"bui4\"]/div/section/div/div[2]/div[2]/button[1]"); // Reset
        wait(500);
    }

    void SelectRatingSort()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[8]"); // Sort
        clickXPath("//*[@id=\"bui5\"]/div/section/div/div[2]/div[1]/ul/button[2]"); // Rating
        clickXPath("//*[@id=\"bui5\"]/div/section/div/div[2]/div[2]/button[2]"); // Apply
        wait(500);
    }

    void SelectDeliverySort()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[8]"); // Sort
        clickXPath("//*[@id=\"bui5\"]/div/section/div/div[2]/div[1]/ul/button[3]"); // Delivery Time
        clickXPath("//*[@id=\"bui5\"]/div/section/div/div[2]/div[2]/button[2]"); // Apply
        wait(500);
    }

    void DeselectSort()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[8]"); // Sort
        clickXPath("//*[@id=\"bui5\"]/div/section/div/div[2]/div[2]/button[1]"); // Reset
        wait(500);
    }

    void SelectRecommenedSort()
    {
        clickXPath("//*[@id=\"main-content\"]/div/div[2]/div/button[8]"); // Sort
        clickXPath("//*[@id=\"bui5\"]/div/section/div/div[2]/div[1]/ul/button[1]"); // Recommended (default)
        clickXPath("//*[@id=\"bui5\"]/div/section/div/div[2]/div[2]/button[2]"); // Apply
        wait(500);
    }


    boolean checkSorting(String Expected)
    {
        try {
            return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/button[8]")).getText().contains(Expected);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    boolean checkSearchResults(int LowerBoundResultCount, int UpperBoundResultCount)
    {
        String FastFoodSearch;
        try {
            FastFoodSearch = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[4]/div/div/div[2]/h1")).getText();
        } catch (NoSuchElementException e) {
            return false;
        }

        int FastFoodSearchCount = isolateNumber(FastFoodSearch);

        return withinRange(FastFoodSearchCount, LowerBoundResultCount, UpperBoundResultCount);
    }

    int isolateNumber(String input) {
        // Use regex to find the first occurrence of a number
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String numStr = matcher.group();
            return Integer.parseInt(numStr);
        }

        return -1; // Return a default value if no number is found
    }
}
