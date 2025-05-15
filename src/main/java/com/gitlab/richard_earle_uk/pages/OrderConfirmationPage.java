package com.gitlab.richard_earle_uk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {
  private static final By headerMessage = By.className("complete-header");

  public OrderConfirmationPage(WebDriver driver) {
    super(driver);
  }

  public String getHeaderMessage() {
    return elementUtil.getText(headerMessage);
  }
}
