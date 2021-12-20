package scenarios.ex3;

import ex3.TestData.Data;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ex3.pageObjects.PageObject;
import ex3.pageObjects.GoogleWebPages.HomePage;
import ex3.pageObjects.GoogleWebPages.SearchPage;
import ex3.setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Open google.com, search EPAM and assert that there is relevant results",
          dataProviderClass = Data.class, dataProvider = "getRequestedString")
    public void simpleWebTest(String searchString) throws InterruptedException {
        PageObject pageObject = getPageObject();
        HomePage homePage = (HomePage) pageObject.getEntryPageObject();
        homePage.openGoogleHomePage();
        Thread.sleep(5000);
        SearchPage searchPageObject = homePage.google(searchString);
        List<String> results = searchPageObject.getResultsContainingRequestString(searchString);
        Assert.assertTrue(results.size() > 0);
    }
}
