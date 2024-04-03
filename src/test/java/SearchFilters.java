import org.testng.annotations.Test;

public class SearchFilters extends Setup {

    @Test
    void SelectOneCuisine()
    {

    }

    @Test
    void DeselectOneCuisine()
    {

    }

    @Test
    void SelectThreeCuisine()
    {

    }

    @Test
    void DeselectThreeCuisine()
    {

    }

    @Test
    void SelectUnder30()
    {

    }

    @Test
    void DeselectUnder30()
    {

    }

    @Test
    void SelectVegan()
    {

    }

    @Test
    void DeselectVegan()
    {

    }

    @Test
    void SelectRatingSort()
    {

    }

    @Test
    void DeselectRatingSort()
    {

    }

    @Test
    void CombineFilters()
    {
        SelectOneCuisine();
        SelectRatingSort();
        SelectUnder30();

        // Assertion

        DeselectUnder30();

        // Assertion

        DeselectOneCuisine();
        DeselectRatingSort();

        // Assertion
    }
    void toggleFilterT(String Text)
    {
        // Select a filter using the given text
    }

    void toggleFilterX(String XPath)
    {
        // Select a filter using the given XPath
    }

    void toggleFilterI(String ID)
    {
        // Select a filter using the given ID
    }
}
