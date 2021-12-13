package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pageObjects.nativePages.LoginPage;
import pageObjects.webPages.WebPageObject;
import setup.IPageObject;

import java.lang.reflect.Field;

public class PageObject implements IPageObject {

    private final Object entryPageObject; // it should be set of web page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                entryPageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                entryPageObject = new LoginPage(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }

    }

    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = entryPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(entryPageObject);

    }
}
