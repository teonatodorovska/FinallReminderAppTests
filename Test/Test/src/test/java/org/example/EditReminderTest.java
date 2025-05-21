package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import org.example.pages.EditReminderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class EditReminderTest {
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
    public void editReminderWithDateTimeTest() {
        try {
            driver.startActivity(new Activity("com.sam.reminders.todos", "com.sam.reminders.todos.activities.SplashScreenActivity"));

            EditReminderPage editPage = new EditReminderPage(driver);

            editPage.clickExistingReminder();
            editPage.clickEditButton();

            editPage.editTitle("Updated Title");

            // Постави нов датум
            editPage.openDatePicker();
            editPage.selectDate(24);
            editPage.confirmDate();

            // Постави ново време
            editPage.openTimePicker();
            editPage.selectTimeTextInput("6", "");

            editPage.saveReminder();

            System.out.println("Test passed: Reminder updated with new title, date, and time.");

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Test failed due to exception: " + e.getMessage(), false);
        }
    }
}







