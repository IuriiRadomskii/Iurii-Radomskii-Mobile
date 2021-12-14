package pageObjects.GoogleWebPages;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    private AppiumDriver appiumDriver;

    public HomePage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void openHomePage() {
        appiumDriver.navigate().to("http://www.google.com/");
    }

    public SearchPage google(String searchString) {
        searchField.sendKeys("EPAM\n");
        return new SearchPage(appiumDriver);
    }
}
