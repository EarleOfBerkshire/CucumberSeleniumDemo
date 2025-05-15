package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
  private static final By finishButton = By.linkText("FINISH");

  private  WebDriver driver;
  private  ElementUtil elementUtil;

  public CheckoutOverviewPage(WebDriverManagerUtil driverManagerUtil) {
    this.driver = driverManagerUtil.getDriver();
    this.elementUtil = new ElementUtil(driver);
  }

  public void clickFinishButton() {
    elementUtil.click(finishButton);
  }
}
