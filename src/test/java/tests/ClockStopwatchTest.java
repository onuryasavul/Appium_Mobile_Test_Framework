package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ClockPage;

public class ClockStopwatchTest extends BaseTest {

   

@Test(groups = {"demo"})
    public void startAndStopStopwatchTest() {

        ClockPage clockPage = new ClockPage(driver);


        // Stopwatch aç
        clockPage.openStopwatch();

        // Sayacı başlat
        clockPage.startStopwatch();

        // 3 saniye bekle
        clockPage.waitSeconds(3);

        // Sayacı durdur
        clockPage.stopStopwatch();

        // Assert – süre 00:00 olmamalı
        String time = clockPage.getStopwatchTimeSeconds();
        Assert.assertNotEquals(time, "00:00", "Stopwatch did not work!");
    }


}