package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddReminderPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public AddReminderPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickPlusButton() {
        WebElement addPlusButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/addEvent")));
        addPlusButton.click();
    }

    public void enterTitle(String title) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.sam.reminders.todos:id/ed_memo")));
        titleInput.sendKeys(title);
    }

    public void clickSave() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.sam.reminders.todos:id/txt_save")));
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            // Ignore if keyboard not visible
        }
        saveButton.click();
    }
}







