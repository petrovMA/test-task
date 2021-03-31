package com.casino.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id = 'UserLogin_username']")
    WebElement textFieldUserName;

    @FindBy(xpath = "//*[@id = 'UserLogin_password']")
    WebElement textFieldPassword;

    @FindBy(xpath = "//*[@type = 'submit']")
    WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWith(String userName, String password) {
        textFieldUserName.sendKeys(userName);
        textFieldPassword.sendKeys(password);
        buttonSubmit.click();
    }
}
