package scenarios.ex1;

import ex1.TestData.Data;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ex1.pageObjects.PageObject;
import ex1.pageObjects.GoogleWebPages.HomePage;
import ex1.pageObjects.GoogleWebPages.SearchPage;
import ex1.setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Open google.com, search EPAM and assert that there is relevant results",
          dataProviderClass = Data.class, dataProvider = "getRequestedString")
    public void simpleWebTest(String searchString) {
        PageObject pageObject = getPageObject();
        HomePage homePage = (HomePage) pageObject.getEntryPageObject();
        homePage.openHomePage();
        new WebDriverWait(getDriver(), 10)
            .until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        SearchPage searchPageObject = homePage.google(searchString);
        new WebDriverWait(getDriver(), 10)
            .until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        List<String> results = searchPageObject.getResultsContainingRequestString(searchString);
        Assert.assertTrue(results.size() > 0);
    }
}
