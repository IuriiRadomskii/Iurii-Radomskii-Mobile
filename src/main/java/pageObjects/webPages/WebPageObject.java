package pageObjects.webPages;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject  {

    @FindBy(xpath = "//div[@aria-level='3']")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    private AppiumDriver appiumDriver;

    public WebPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public void open() {
        appiumDriver.navigate().to("http://www.google.com/");
    }
}
