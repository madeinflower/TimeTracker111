package com.crewmeister.tests;

import com.crewmeister.pages.TimeTrackerPage;
import com.crewmeister.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeTrackerTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zar\\Documents\\Google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Constants.TIME_TRACKER_URL);
        login();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    private void login() {
        driver.findElement(By.id("email")).sendKeys("tatsenko.tetiana@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
    @Test
    void testClockInClockOut() {
        TimeTrackerPage timeTrackerPage = new TimeTrackerPage(driver);
        timeTrackerPage.clockIn();
        assertTrue(timeTrackerPage.isClockOutButtonDisplayed());

        timeTrackerPage.clockOut();
        assertTrue(timeTrackerPage.isDoneButtonDisplayed());

        timeTrackerPage.Done();
        assertTrue(timeTrackerPage.isClockInButtonDisplayed());

        assertTrue(timeTrackerPage.getTimeTableText().contains(Constants.EMPLOYEE_NAME));

        timeTrackerPage.clickEditLastEntry();
        assertEquals(Constants.EMPLOYEE_NAME, timeTrackerPage.getEmployeeNameText());
    }
}
