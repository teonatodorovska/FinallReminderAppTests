package org.example.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class EditReminderPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public EditReminderPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickExistingReminder() {
        WebElement reminderItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.FrameLayout[@resource-id='com.sam.reminders.todos:id/linRoot']/android.view.ViewGroup")));
        reminderItem.click();
    }

    public void clickEditButton() {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/lin_edit")));
        editButton.click();
    }

    public void editTitle(String newTitle) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.sam.reminders.todos:id/ed_memo")));
        titleInput.clear();
        titleInput.sendKeys(newTitle);
    }

    public void openDatePicker() {
        WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/tv_date")));
        datePicker.click();
    }

    public void selectDate(int day) {
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@content-desc='Saturday, May " + day + "']")));
        dayElement.click();
    }

    public void confirmDate() {
        WebElement confirmDateBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/confirm_button")));
        confirmDateBtn.click();
    }

    public void openTimePicker() {
        WebElement timeField = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/tv_time")));
        timeField.click();
    }
    public void selectTimeTextInput(String hour, String minute) {
        // Префрли во текстуален мод
        WebElement switchToTextInputBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@content-desc='Switch to text input mode for the time input.']")));
        switchToTextInputBtn.click();

        // Внеси час
        WebElement hourInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@index='0']")));
        hourInput.clear();
        hourInput.sendKeys(hour);

//        WebElement minuteInput = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.widget.EditText[@index='1']")));
//        minuteInput.clear();
//        minuteInput.sendKeys(minute);
//        WebElement minutesView = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.view.View[@content-desc='0 minutes']")));
//        minutesView.click();
//        WebElement minutesView = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.view.View[@content-desc='" + minute + " minutes']")));
//        minutesView.click();

        // Избери PM
        WebElement pmButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/material_clock_period_pm_button")));
        pmButton.click();

        // Кликни OK
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/material_timepicker_ok_button")));
        okButton.click();
    }
    public void saveReminder() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/txt_save")));
        saveButton.click();
    }
}






