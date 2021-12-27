package ex3.pageObjects;

import io.appium.java_client.AppiumDriver;
import ex3.pageObjects.nativePages.LoginPage;
import ex3.pageObjects.GoogleWebPages.HomePage;

import java.lang.reflect.Field;

public class PageObject implements IPageObject {

    private final Object entryPageObject; // it should be set of web page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: " + appType);
        switch(appType){
            case "native":
                entryPageObject = new LoginPage(appiumDriver);
                break;
            case "web":
                entryPageObject = new HomePage(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for " + appType);
        }
    }

    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = entryPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(entryPageObject);
    }

    public Object getEntryPageObject() {
        return entryPageObject;
    }
}
