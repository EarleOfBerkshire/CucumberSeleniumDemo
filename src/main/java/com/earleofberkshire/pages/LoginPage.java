package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
  private final By usernameInput = By.id("user-name");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("login-button");
  private final By errorMessage = By.cssSelector("h3[data-test='error']");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String user, String pass) {
    elementUtil.sendKeys(usernameInput, user);
    elementUtil.sendKeys(passwordInput, pass);
    elementUtil.click(loginButton);
  }

  public String getErrorMessage() {
    return elementUtil.getText(errorMessage);
  }

  public boolean isOnInventoryPage() {
    return driver.getCurrentUrl().contains("inventory.html");
  }
}
