package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
  private static final By finishButton = By.linkText("FINISH");

  public CheckoutOverviewPage(WebDriver driver) {
    super(driver);
  }

  public void clickFinishButton() {
    elementUtil.click(finishButton);
  }
}
