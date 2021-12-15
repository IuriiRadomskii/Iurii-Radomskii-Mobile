package pageObjects.GoogleWebPages;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "//div[@aria-level='3']/div")
    private List<WebElement> searchResults;

    private AppiumDriver appiumDriver;

    public SearchPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public List<String> getResultsContainingRequestString(String searchString) {
        System.out.printf("Found %d results\n", searchResults.size());
        return searchResults.stream()
                     .map(WebElement::getText)
                     .filter(text -> text.contains(searchString))
                     .collect(Collectors.toList());
    }
}
