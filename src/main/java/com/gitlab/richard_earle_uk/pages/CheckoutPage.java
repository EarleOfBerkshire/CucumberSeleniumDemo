package com.gitlab.richard_earle_uk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
  private static final By firstNameInput = By.id("first-name");
  private static final By lastNameInput = By.id("last-name");
  private static final By postalCodeInput = By.id("postal-code");
  private static final By continueButton = By.cssSelector("input[value='CONTINUE']");
  private static final By checkoutInfoHeader =
      By.xpath("//div[@class='subheader' and text()='Checkout: Your Information']");

  public CheckoutPage(WebDriver driver) {
    super(driver);
  }

  public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
    elementUtil.sendKeys(firstNameInput, firstName);
    elementUtil.sendKeys(lastNameInput, lastName);
    elementUtil.sendKeys(postalCodeInput, postalCode);
    elementUtil.click(continueButton);
  }

  public boolean isLoaded() {
    return elementUtil.isElementDisplayed(checkoutInfoHeader);
  }
}
