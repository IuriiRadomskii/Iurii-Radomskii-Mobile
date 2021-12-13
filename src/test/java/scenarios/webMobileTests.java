package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.webPages.WebPageObject;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Open google.com, search EPAM and checking relevant search results")
    public void simpleWebTest() throws InterruptedException {
        PageObject pageObject = getPageObject();
        WebPageObject webPageObject = (WebPageObject) pageObject.getEntryPageObject();
        webPageObject.open();
        new WebDriverWait(getDriver(), 10)
            .until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        Thread.sleep(3000);

        System.out.println("Site opening done");
    }

}
