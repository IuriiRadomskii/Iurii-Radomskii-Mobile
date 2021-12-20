package scenarios.ex3;

import ex3.ConfigUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static java.util.Optional.ofNullable;
import static org.openqa.selenium.By.className;


public class AppiumDemo {

    private static final String API_KEY = ConfigUtils.getToken();
    private static final String PLATFORM_NAME = "Android";
    private static final String PLATFORM_VERSION = "8.0.0";
    private static final String BROWSER_NAME = "Chrome";
    private static final String UDID = "RZ8R80RXQFF";

    private final DesiredCapabilities capabilities;

    private AppiumDriver driver = null;

    public AppiumDemo() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("browserName", BROWSER_NAME);
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");
    }

    @BeforeClass
    public void before() throws Exception {
        String key = URLEncoder.encode(API_KEY, StandardCharsets.UTF_8.name());

        driver = new AndroidDriver(
            new URL(format("https://iurii_radomskii:%s@mobilecloud.epam.com/wd/hub", key)), capabilities);

        // For devices with low performance
        driver.manage().timeouts()
              .pageLoadTimeout(5, TimeUnit.MINUTES)
              .implicitlyWait(90, TimeUnit.SECONDS);
    }

    @Test
    public void demoTest() {
        final String epamUrl = "https://www.epam.com/";
        driver.get(epamUrl);
        new FluentWait<>(driver).withMessage("Page was not loaded")
                                .pollingEvery(ofSeconds(1))
                                .withTimeout(ofMinutes(1))
                                .until(driver -> driver.findElements(className("header__logo")).size() > 0);
    }

    @AfterClass
    public void after() {
        ofNullable(driver).ifPresent(RemoteWebDriver::quit);
    }
}
