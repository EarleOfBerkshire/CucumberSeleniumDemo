package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
  private static final By headerMessage = By.className("complete-header");

  private final WebDriver driver;
  private final ElementUtil elementUtil;

  public OrderConfirmationPage(WebDriverManagerUtil driverManagerUtil) {
    this.driver = driverManagerUtil.getDriver();
    this.elementUtil = new ElementUtil(driver);
  }

  public String getHeaderMessage() {
    return elementUtil.getText(headerMessage);
  }
}
