package com.earleofberkshire.stepdefinitions;

import com.earleofberkshire.pages.LoginPage;
import com.earleofberkshire.utils.ConfigReader;
import com.earleofberkshire.utils.WebDriverManagerUtil;
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

  public LoginSteps(WebDriverManagerUtil webDriverManager) {
    this.driver = WebDriverManagerUtil.getDriver();
  }

  @Given("the user is on the login page")
  public void userIsOnLoginPage() {
    driver.get(ConfigReader.get("base.url"));
    loginPage = new LoginPage(driver);
  }

  @When("the user logs in with username {string} and password {string}")
  public void userLogsIn(String username, String password) {
    loginPage.login(username, password);
  }

  @When("the user logs in with valid credentials")
  public void theUserLogsInWithValidCredentials() {
    loginPage.login(VALID_USERNAME, VALID_PASSWORD);
  }

  @Then("the user should be logged in")
  public void theUserShouldBeLoggedIn() {
    Assertions.assertTrue(
        loginPage.isOnInventoryPage(), "User is not on inventory page after login.");
  }

  @Then("the user should see an error message {string}")
  public void theUserShouldSeeAnErrorMessage(String expectedMessage) {
    String actualMessage = loginPage.getErrorMessage();
    Assertions.assertEquals(
        expectedMessage, actualMessage, "Error message does not match expected.");
  }
}
