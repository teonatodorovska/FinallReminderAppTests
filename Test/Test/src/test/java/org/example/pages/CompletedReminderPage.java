
package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletedReminderPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public CompletedReminderPage(AndroidDriver driver) {
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

    public void clickReminderFromList() {
        WebElement reminderItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.FrameLayout[@resource-id='com.sam.reminders.todos:id/linRoot']/android.view.ViewGroup")));
        reminderItem.click();
    }

    public void markAsCompleted() {
        WebElement completeIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.LinearLayout[@resource-id='com.sam.reminders.todos:id/lin_complate']/android.widget.ImageView")));
        completeIcon.click();
    }
}

