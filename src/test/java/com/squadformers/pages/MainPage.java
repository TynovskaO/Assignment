package com.squadformers.pages;

import com.squadformers.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='Home_assetText__o_glR']")
    public WebElement selectCoinButton;

    @FindBy(xpath = "//input[@class='Home_amount__ImoJo']")
    public WebElement amountInput;

    @FindBy(xpath = "//button[.='Buy']")
    public WebElement buyButton;

    @FindBy(xpath = "(//div[@class='Toastify__toast-body']/div)[2]")
    public WebElement message;

    public WebElement getCoin(String name){
        return  Driver.getDriver().findElement(By.xpath("//div[.='"+name+"']"));
    }
}
