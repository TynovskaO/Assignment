package com.squadformers.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Assertions {

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    public static void verifyElementContainsText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        assertTrue(element.getText().contains(text));
    }

    public static void verifyButtonIsDisabled(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        assertFalse(button.isEnabled());
    }
}
