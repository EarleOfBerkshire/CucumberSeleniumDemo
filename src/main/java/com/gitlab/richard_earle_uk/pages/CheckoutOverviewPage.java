package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
  private static final By finishButton = By.linkText("FINISH");

  private final WebDriver driver;

  public CheckoutOverviewPage(WebDriverManagerUtil driverManagerUtil) {
    this.driver = driverManagerUtil.getDriver();
  }

  public void clickFinishButton() {
    driver.findElement(finishButton).click();
  }
}
