
package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReminderPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public ReminderPage(AndroidDriver driver) {
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

    public void clickAddReminder() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/btn_add_reminder")));
        addButton.click();
    }

    public void enterTitle(String title) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.sam.reminders.todos:id/ed_memo")));
        titleInput.sendKeys(title);
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

