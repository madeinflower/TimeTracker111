package com.crewmeister.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeTrackerPage {

    private final WebDriver driver;

    public TimeTrackerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clockIn() {
        WebElement clockInButton = driver.findElement(By.cssSelector("span[data-e2e-test='stamp-watch-start-work']"));
        clockInButton.click();
    }

    public boolean isClockOutButtonDisplayed() {
        return driver.findElement(By.cssSelector("span[data-e2e-test='stamp-watch-stop-work']")).isDisplayed();
    }

    public void clockOut() {
        WebElement clockOutButton = driver.findElement(By.cssSelector("span[data-e2e-test='stamp-watch-stop-work']"));
        clockOutButton.click();
    }

    public void Done() {
        WebElement clockOutButton = driver.findElement(By.cssSelector("#page-time-tracking-done"));
        clockOutButton.click();
    }

    public boolean isDoneButtonDisplayed() {
        return driver.findElement(By.cssSelector("\"#page-time-tracking-done")).isDisplayed();
    }

    public boolean isClockInButtonDisplayed() {
        return driver.findElement(By.cssSelector("\"span[data-e2e-test='stamp-watch-start-work']")).isDisplayed();
    }

    public String getTimeTableText() {
        return driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(2) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > div:nth-child(1) > div:nth-child(1)")).getText();
    }

    public void clickEditLastEntry() {
        WebElement editButton = driver.findElement(By.cssSelector("div[class='jss36'] div div"));
        editButton.click();
    }

    public String getEmployeeNameText() {
        return driver.findElement(By.id("Tetiana")).getText();
    }
}


