package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class AppTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("10");
        options.setDeviceName("Galaxy A50s");
        options.setAutomationName("UiAutomator2");

        // Правилниот package и activity за Reminder апликацијата
        //options.setAppPackage("com.sam.reminders.todos");
        //options.setAppActivity("com.sam.reminders.todos.activities.SplashScreenActivity");

        //options.setAppPackage("com.samsung.android.app.reminder");
        //options.setAppActivity("com.samsung.android.app.reminder.ui.activity.main.LaunchActivity");
        //options.setAppPackage("com.sam.reminders.todos");
       // options.setAppActivity("com.sam.reminders.todos.HomeActivity");
        options.setCapability("appActivity", "com.sam.reminders.todos.activities.SplashScreenActivity");
        options.setCapability("appPackage", "com.sam.reminders.todos");



        options.setNoReset(true); // за да не ресетира податоци секој пат
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void openAppTest() {
        // Само отвори ја апликацијата, ако има проблем - тестот ќе падне
        System.out.println("Reminder app is opened.");
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}






















//package org.example;

//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//
//import java.net.MalformedURLException;
//import java.net.URL;


//public class AppTest
//        extends TestCase {
//
//    private AndroidDriver driver;
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setPlatformName("Android");
//        options.setPlatformVersion("13");
//        options.setDeviceName("Galaxy A23 5G");
//        options.setAutomationName("UiAutomator2");
//        options.setAppPackage("com.samsung.android.app.reminder");
//        options.setAppActivity(".ui.LaunchMainActivity");
//        options.setNoReset(true);
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//    }
//
//    @Test
//    public void addReminderTest() {
//        try {
//            System.out.println("Opening Reminder App...");
//
//            driver.findElement(By.id("com.samsung.android.app.reminder:id/floating_action_button")).click();
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            assert false : "Reminder not added successfully.";
//        }
//    }
//

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
