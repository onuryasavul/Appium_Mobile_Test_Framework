package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsHelper {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // Default timeout: 10 saniye
    public ActionsHelper(AndroidDriver driver) {
        this(driver, 10);
    }

    // Custom timeout
    public ActionsHelper(AndroidDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // ===== GENERIC WAITS =====

    public WebElement waitForVisibility(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public boolean waitForInvisibility(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    public boolean waitForText(By locator, String expectedText) {
        return wait.until(
                ExpectedConditions.textToBe(locator, expectedText)
        );
    }

    // ===== SAFE ACTIONS =====

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    public void unsafeClick(By locator) {
        driver.findElement(locator).click();
    }

    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    // ===== TIME WAITS (Controlled Sleep) =====
    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Wait interrupted", e);
        }
    }
}
