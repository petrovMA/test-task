package com.casino.ui.tests;

import com.casino.ui.GuiBase;
import com.casino.ui.pages.LoginPage;
import com.casino.ui.pages.MainPage;
import com.casino.ui.pages.PlayersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class StepDefinition {

    private final WebDriver driver = GuiBase.getDriver();
    private PlayersPage playersPage;

    @Given("authorize with login {string} and password {string}")
    public void login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith(login, password);
    }

    @When("open list of players")
    public void openListOfPlayers() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToPlayersPage();
    }

    @Then("sort list of players by name")
    public void sortListOfPlayersByName() {
        playersPage = new PlayersPage(driver);
        playersPage.sortByUsername(Duration.ofSeconds(4));
    }

    @And("check that list of players sorted correctly")
    public void checkThatListOfPlayersSortedCorrectly() {
        playersPage.checkOrderByUsername();
    }
}
