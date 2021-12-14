package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.GoogleWebPages.HomePage;
import pageObjects.GoogleWebPages.SearchPage;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Open google.com, search EPAM and checking relevant search results")
    public void simpleWebTest() throws InterruptedException {
        PageObject pageObject = getPageObject();
        HomePage homePage = (HomePage) pageObject.getEntryPageObject();
        homePage.openHomePage();
        new WebDriverWait(getDriver(), 10)
            .until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        SearchPage searchPageObject = homePage.google("EPAM");
        new WebDriverWait(getDriver(), 10)
            .until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        Thread.sleep(1000);
        searchPageObject.assertResultsRelevance("EPAM");
        System.out.println("Site opening done");
    }
}
