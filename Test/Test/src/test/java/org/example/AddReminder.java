package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import org.example.pages.ReminderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class AddReminder {
    private AndroidDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        driver = SetupTest.initializeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addReminderWithTimeTest() {
        try {
            driver.startActivity(new Activity("com.sam.reminders.todos", "com.sam.reminders.todos.activities.SplashScreenActivity"));

            ReminderPage reminderPage = new ReminderPage(driver);

            reminderPage.skipLanguageSelectionIfVisible();
            reminderPage.clickAddReminder();
            reminderPage.enterTitle("To Do");
            reminderPage.toggleAddTime(); //
            reminderPage.saveReminder();

            System.out.println("Test passed: Reminder with time added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Test failed due to exception: " + e.getMessage(), false);
        }
    }
}
