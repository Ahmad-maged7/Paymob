import Pages.SearchPage;
import Pages.SearchResultsPage;
import base.TestBase;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    SearchPage searchObject;
    SearchResultsPage searchResultsObject;

    @Test(priority = 1)
    public void searchForText() {
        searchObject = new SearchPage(driver);
        searchObject.enterSearchKeyword("Cucumber IO");
        searchObject.doSearchForEnteredKeyword();
    }

    @Test(priority = 2)
    public void goToSecondPage() throws InterruptedException {
        searchResultsObject = new SearchResultsPage(driver);
        searchResultsObject.goToSecondPage();
        searchResultsObject.validateLinkOfSecondResult();

    }
}
