package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;
import org.example.pages.AddReminderPage;

public class AddReminderTest {

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
    public void addReminderWithPlusButtonTest() {
        try {
            driver.startActivity(new Activity("com.sam.reminders.todos", "com.sam.reminders.todos.activities.SplashScreenActivity"));

            AddReminderPage addReminderPage = new AddReminderPage(driver);

            addReminderPage.clickPlusButton();
            addReminderPage.enterTitle("Edit reminder");
            addReminderPage.clickSave();

            System.out.println("Test passed: Reminder added using plus button successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Test failed due to exception: " + e.getMessage(), false);
        }
    }
}




