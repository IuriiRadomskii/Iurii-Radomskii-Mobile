package ex1.pageObjects;

import ex1.pageObjects.nativePages.LoginPage;
import io.appium.java_client.AppiumDriver;
import ex1.pageObjects.GoogleWebPages.HomePage;

public class PageObject {

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

    public Object getEntryPageObject() {
        return entryPageObject;
    }
}
