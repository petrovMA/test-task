package com.casino.ui;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com/casino/ui/tests", plugin = {"pretty", "html:target/cucumber-report.html"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}