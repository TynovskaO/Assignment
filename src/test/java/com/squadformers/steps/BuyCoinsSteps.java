package com.squadformers.steps;

import com.squadformers.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.squadformers.utilities.Assertions.verifyButtonIsDisabled;
import static com.squadformers.utilities.Assertions.verifyElementContainsText;
import static com.squadformers.utilities.Utils.*;

public class BuyCoinsSteps {

    MainPage mainPage = new MainPage();
    private String amount = getRandomNumber();
    private static String coinName;

    @When("user is on main page")
    public void userIsOnMainPage() {
        goToMainPage();
    }

    @And("user selects {string}")
    public void userSelects(String coin) {
        coinName = coin;
        clickElement(mainPage.selectCoinButton);
        clickElement(mainPage.getCoin(coin));
    }

    @And("user enters amount")
    public void userEntersAmount() {
        mainPage.amountInput.sendKeys(amount);
    }

    @And("user clicks BUY")
    public void userClicksBUY() {
        clickButton(mainPage.buyButton);
    }

    @Then("user sees successful message")
    public void userSeesSuccessfulMessage() {
        String expected_message = String.format("Purchased $%s %s!", amount, coinName);
        verifyElementContainsText(mainPage.message, expected_message);
    }


    @And("user selects random coin")
    public void userSelectsRandomCoin() {
        coinName = getRandomCoinName();
        clickElement(mainPage.selectCoinButton);
        clickElement(mainPage.getCoin(coinName));
    }

    @And("user enters {string}")
    public void userEnters(String invalidAmout) {
        mainPage.amountInput.sendKeys(invalidAmout);
    }

    @Then("BUY button should be disabled")
    public void buyButtonShouldBeDisabled() {
        verifyButtonIsDisabled(mainPage.buyButton);
    }
}
