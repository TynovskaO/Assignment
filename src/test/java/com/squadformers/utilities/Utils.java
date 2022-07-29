package com.squadformers.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
    private static Faker faker = new Faker();

    public static void goToMainPage() {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 5);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        webDriverWait.until(ExpectedConditions.urlToBe(ConfigurationReader.getProperty("url")));
    }

    public static void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void clickButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    public static String getRandomNumber() {
        return String.valueOf(faker.number().numberBetween(1, 1000));
    }

    public static String getRandomCoinName(){
        return faker.regexify("Ethereum|Bitcoin|Solana");
    }

}
