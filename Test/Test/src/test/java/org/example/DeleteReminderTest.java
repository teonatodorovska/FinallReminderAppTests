package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import org.example.pages.DeleteReminderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class DeleteReminderTest {
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
    public void deleteReminderTest() {
        try {
            driver.startActivity(new Activity("com.sam.reminders.todos", "com.sam.reminders.todos.activities.SplashScreenActivity"));

            DeleteReminderPage deletePage = new DeleteReminderPage(driver);

            deletePage.skipLanguageSelectionIfVisible();
            deletePage.openReminderFromList();
            deletePage.clickDeleteButton();
            deletePage.confirmDeletion();

            System.out.println("Test passed: Reminder deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Test failed due to exception: " + e.getMessage(), false);
        }
    }
}
