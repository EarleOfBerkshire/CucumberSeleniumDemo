package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.LoginPage;
import com.gitlab.richard_earle_uk.utils.ConfigReader;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import com.gitlab.richard_earle_uk.utils.ScreenshotUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = WebDriverManagerUtil.getDriver();
    }

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        driver.get(ConfigReader.get("base.url"));
        loginPage = new LoginPage(driver);
    }

    @When("the user logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        loginPage.login(username, password);
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(driver, scenario.getName());
        }
    }

    @After
    public void tearDown() {
        WebDriverManagerUtil.quitDriver();
    }
}