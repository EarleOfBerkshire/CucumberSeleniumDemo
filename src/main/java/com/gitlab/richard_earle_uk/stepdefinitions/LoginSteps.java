package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.context.WebDriverContext;
import com.gitlab.richard_earle_uk.pages.LoginPage;
import com.gitlab.richard_earle_uk.utils.ConfigReader;
import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.ScreenshotUtil;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
  private static final String VALID_USERNAME = "standard_user";
  private static final String VALID_PASSWORD = "secret_sauce";
  private final WebDriver driver;
  private LoginPage loginPage;

  public LoginSteps(WebDriverContext context) {
    this.driver = context.getDriver();
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

  @When("the user logs in with valid credentials")
  public void theUserLogsInWithValidCredentials() {
    loginPage.login(VALID_USERNAME, VALID_PASSWORD);
  }

  @Then("the user should be logged in")
  public void the_user_should_be_logged_in() {
    Assertions.assertTrue(loginPage.isOnInventoryPage(), "User is not on inventory page after login.");
  }

  @Then("the user should see an error message {string}")
  public void the_user_should_see_an_error_message(String expectedMessage) {
    String actualMessage = loginPage.getErrorMessage();
    Assertions.assertEquals(
        expectedMessage, actualMessage, "Error message does not match expected.");
  }




}
