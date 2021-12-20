package ex3.pageObjects.GoogleWebPages;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//li[@role='presentation']")
    private List<WebElement> dropDownVariants;

    private AppiumDriver appiumDriver;

    public HomePage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void openGoogleHomePage() {
        System.out.println("Open google.com");
        appiumDriver.navigate().to("http://www.google.com/");
    }

    public SearchPage google(String searchString) {
        System.out.printf("Search in google '%s'\n", searchString);
        searchField.sendKeys(searchString);
        dropDownVariants.get(0).click();

        return new SearchPage(appiumDriver);
    }
}
