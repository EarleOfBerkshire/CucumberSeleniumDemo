package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the Login page. Provides methods for performing login actions and
 * retrieving error messages.
 */
public class LoginPage extends BasePage {
  private final By usernameInput = By.id("user-name");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("login-button");
  private final By errorMessage = By.cssSelector("h3[data-test='error']");

  /**
   * Constructs a LoginPage instance with the given WebDriver.
   *
   * @param driver the WebDriver instance to interact with the browser
   */
  public LoginPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Performs login using the provided username and password.
   *
   * @param user the username to enter
   * @param pass the password to enter
   */
  public void login(String user, String pass) {
    elementUtil.sendKeys(usernameInput, user);
    elementUtil.sendKeys(passwordInput, pass);
    elementUtil.click(loginButton);
  }

  /**
   * Retrieves the error message displayed on failed login attempts.
   *
   * @return the error message text
   */
  public String getErrorMessage() {
    return elementUtil.getText(errorMessage);
  }

  /**
   * Checks if the current page URL indicates that the user is on the inventory page.
   *
   * @return true if the URL contains "inventory.html", false otherwise
   */
  public boolean isOnInventoryPage() {
    return driver.getCurrentUrl().contains("inventory.html");
  }
}
