package com.casino.ui;

import com.casino.AutotestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class GuiBase extends AutotestBase {
    private final Duration implicitTimeout = config.getDuration("autotests.ui.implicit_timeout");
    private final String uiUrl = config.getString("autotests.ui.ui_url");

    private static WebDriver driver;

    @Before
    public void setUpWebDriver() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(implicitTimeout);
        driver.manage().window().maximize();
        driver.get(uiUrl);
    }


    @After
    public void stopWebDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
