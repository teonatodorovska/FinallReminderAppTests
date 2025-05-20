package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import org.example.pages.EditReminderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class EditReminder {
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
    public void editReminderWithTimeTest() {
        try {
            driver.startActivity(new Activity("com.sam.reminders.todos", "com.sam.reminders.todos.activities.SplashScreenActivity"));

            EditReminderPage editPage = new EditReminderPage(driver);

            editPage.skipLanguageSelectionIfVisible();
            editPage.clickExistingReminder();
            editPage.editTitle("Updated Title");
            editPage.toggleAddTime(); // ако веќе не е вклучено
            editPage.saveReminder();

            System.out.println("Test passed: Reminder updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Test failed due to exception: " + e.getMessage(), false);
        }
    }
}

