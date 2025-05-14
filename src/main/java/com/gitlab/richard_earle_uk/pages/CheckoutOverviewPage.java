package com.gitlab.richard_earle_uk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
  private static final By finishButton = By.linkText("FINISH");

  private final WebDriver driver;

  public CheckoutOverviewPage(WebDriver driver) {
    this.driver = driver;
  }

  public void clickFinishButton() {
    driver.findElement(finishButton).click();
  }
}
