package ex3.setup;

import ex3.utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import ex3.pageObjects.PageObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    PageObject po;

    @Override
    public AppiumDriver getDriver() { return appiumDriver; }

    public PageObject getPageObject() { return po; }

    @Parameters({"platformName", "appType", "udid", "browserName",
                    "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, udid, browserName, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String udid, String browserName, String appPackage,
                                 String appActivity, String bundleId) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // common capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("udid", udid);

        //common capabilities for web testing
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        // Capabilities for test of Android native app on EPAM Mobile Cloud
        capabilities.setCapability("appPackage",appPackage);
        capabilities.setCapability("appActivity",appActivity);

        // Capabilities for test of iOS native app on EPAM Mobile Cloud
        capabilities.setCapability("bundleId",bundleId);
        if(platformName.equals("iOS")) {
            capabilities.setCapability("automationName","XCUITest");
        }

        try {
            String token = URLEncoder.encode(PropertyUtils.get("token"), StandardCharsets.UTF_8.name());
            String projectName = PropertyUtils.get("projectName");
            String hubName = PropertyUtils.get("hubName");
            appiumDriver = new AppiumDriver(
                new URL(String.format("https://%s:%s@%s",projectName, token, hubName)), capabilities);
        } catch (MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }

}
