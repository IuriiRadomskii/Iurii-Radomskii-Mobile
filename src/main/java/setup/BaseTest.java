package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pageObjects.PageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    PageObject po;

    @Override
    public AppiumDriver getDriver() { return appiumDriver; }

    public PageObject getPageObject() {
        return po;
    }

    @Parameters({"platformName","appType","deviceName","browserName","app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(@Optional("")String platformName, @Optional("")String appType, @Optional("")String deviceName, @Optional("") String browserName, @Optional("") String app) throws Exception {
        String appTypee = "web";
        System.out.println("Before: app type - " + appTypee);
        setAppiumDriver(platformName, deviceName, browserName, app);
        setPageObject(appTypee, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        //capabilities.setCapability("platformName",platformName);
        //capabilities.setCapability("deviceName",deviceName);
//
        //if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());
//
        //capabilities.setCapability("browserName", browserName);
        //capabilities.setCapability("chromedriverDisableBuildCheck","true");

        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("chromedriverDisableBuildCheck","true");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","R58R102XG4H");



        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }

}
