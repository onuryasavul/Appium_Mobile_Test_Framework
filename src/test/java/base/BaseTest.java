package base;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import config.Config;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

// Driver is created once per test class
// Driver lifecycle is centralized
// Tests stay clean and readable
// Easy to extend for parallel runs later

public abstract class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName(Config.DEVICE_NAME)
            .setPlatformName(Config.PLATFORM_NAME)      // Android
            .setAutomationName(Config.AUTOMATION_NAME)  // UiAutomator2
            .setAppPackage(Config.APP_PACKAGE)
            .setAppActivity(Config.APP_ACTIVITY)
            .setNoReset(true)
            .setAutoGrantPermissions(true);


        
        URL appiumServerUrl = new URI(Config.APPIUM_URL).toURL();

        driver = new AndroidDriver(appiumServerUrl, options);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}