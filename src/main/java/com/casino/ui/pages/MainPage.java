package com.casino.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id = 's-menu-users']/..")
    WebElement iconUsers;

    @FindBy(xpath = "//*[@id = 's-menu-users']//a[text()='Players']")
    WebElement hrefPlayers;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToPlayersPage() {
        iconUsers.click();
        hrefPlayers.click();
    }
}
