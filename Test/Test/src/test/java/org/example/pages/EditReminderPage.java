// src/test/java/org/example/pages/EditReminderPage.java
package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditReminderPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public EditReminderPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void skipLanguageSelectionIfVisible() {
        try {
            WebElement languageDoneBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.sam.reminders.todos:id/doneImg")));
            languageDoneBtn.click();
        } catch (Exception ignored) {}
    }

    public void clickExistingReminder() {
        WebElement reminderItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.FrameLayout[@resource-id='com.sam.reminders.todos:id/linRoot']/android.view.ViewGroup")));
        reminderItem.click();
    }

    public void editTitle(String newTitle) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.sam.reminders.todos:id/ed_memo")));
        titleInput.clear();
        titleInput.sendKeys(newTitle);
    }

    public void toggleAddTime() {
        WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/simpleSwitch")));
        toggle.click();
    }

    public void saveReminder() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/txt_save")));
        saveButton.click();
    }
}

