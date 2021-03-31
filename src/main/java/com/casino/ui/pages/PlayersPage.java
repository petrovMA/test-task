package com.casino.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class PlayersPage {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    WebDriver driver;

    @FindBy(xpath = "//*[@id = 'payment-system-transaction-grid_c1']//a[text()='Username']")
    WebElement hrefUsername;

    @FindAll(@FindBy(xpath = "//tbody/tr/td[2]/a"))
    List<WebElement> playerUsernames;

    public PlayersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortByUsername(Duration sortWaitTime) {
        hrefUsername.click();

        WebDriverWait wait = new WebDriverWait(driver, sortWaitTime);

        wait.until(
                (ExpectedCondition<Boolean>) driver -> driver
                        .findElements(By.xpath("//div[@id='payment-system-transaction-grid' and @class='grid-view grid-view-loading']"))
                        .isEmpty()
        );
    }


    public void checkOrderByUsername() {

        List<String> actualNames = playerUsernames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());


        assertThat(actualNames)
                .as("List of Players wrong sorted by 'Username'")
                .isSortedAccordingTo(String::compareTo);
    }
}
