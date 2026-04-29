package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import utils.ActionsHelper;


public class ClockPage {

    private final AndroidDriver driver;
    private final ActionsHelper actions;


    // ====== LOCATORS ======
    private final By stopwatchTab =
            AppiumBy.accessibilityId("Stopwatch");

    private final By fabButton =
        AppiumBy.id("com.google.android.deskclock:id/fab");


    private final By stopwatchTimeSeconds =
            AppiumBy.id("com.google.android.deskclock:id/stopwatch_time_text");

    private final By stopwatchTimeHundredths =
            AppiumBy.id("com.google.android.deskclock:id/stopwatch_hundredths_text");

    // ===== CONSTRUCTOR =====
    public ClockPage(AndroidDriver driver) {
        this.driver = driver;
        this.actions = new ActionsHelper(driver);
    }



    // ====== ACTIONS ======
    
    public void openStopwatch() {
        actions.click(stopwatchTab);
    }

    public void startStopwatch() {
        actions.click(fabButton);
    }


    public void stopStopwatch() {
        actions.click(fabButton);
    }

    
    public void waitSeconds(int seconds) {
        actions.waitSeconds(seconds);
    }


    // ====== GETTERS ======
    public String getStopwatchTimeSeconds() {
        return actions.getText(stopwatchTimeSeconds);
    }

    public String getStopwatchTimeHundredths() {
        return actions.getText(stopwatchTimeHundredths);
    }
}