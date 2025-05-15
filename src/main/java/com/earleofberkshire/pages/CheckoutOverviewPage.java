package com.earleofberkshire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
  private static final By finishButton = By.linkText("FINISH");
  private static final By checkoutOverviewHeader = By.xpath("//div[@class='subheader' and text()='Checkout: Overview']");

  public CheckoutOverviewPage(WebDriver driver) {
    super(driver);
  }

  public void clickFinishButton() {
    elementUtil.click(finishButton);
  }

  public boolean isLoaded() {
    return elementUtil.isElementDisplayed(checkoutOverviewHeader);
  }
}
