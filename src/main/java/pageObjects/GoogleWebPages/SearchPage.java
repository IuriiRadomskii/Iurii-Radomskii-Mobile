package pageObjects.GoogleWebPages;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "//input[@name='q']")
    private List<WebElement> searchResults;

    private AppiumDriver appiumDriver;

    public SearchPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void assertResultsRelevance(String searchString) {
        System.out.println("START");
        System.out.println(searchResults.size());
        searchResults.stream().map(element -> element.getAttribute("value")).forEach(System.out::println);
        System.out.println("END");
        /*searchResults.stream()
                     .filter(w -> w.getText().contains(searchString))
                     .forEach(w -> Assert.assertTrue(w.getText().contains(searchString)));*/
    }
}
