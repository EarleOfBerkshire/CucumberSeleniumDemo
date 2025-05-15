package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  private final WebDriver driver;
  private final By usernameInput = By.id("user-name");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("login-button");
  private final By errorMessage = By.cssSelector("h3[data-test='error']");
  private final ElementUtil elementUtil;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.elementUtil=new ElementUtil(driver);
  }

  public void login(String user, String pass) {
    elementUtil.sendKeys(usernameInput, user);
    elementUtil.sendKeys(passwordInput,pass);
    elementUtil.click(loginButton);
  }

  public String getErrorMessage() {
    return elementUtil.getText(errorMessage);
  }

  public boolean isOnInventoryPage() {
    return driver.getCurrentUrl().contains("inventory.html");
  }
}
