package com.gitlab.richard_earle_uk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
  private static final By headerMessage = By.className("complete-header");

  private final WebDriver driver;

  public OrderConfirmationPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeaderMessage() {
    return driver.findElement(headerMessage).getText();
  }
}
