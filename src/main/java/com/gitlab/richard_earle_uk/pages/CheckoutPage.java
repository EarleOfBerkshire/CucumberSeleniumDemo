package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
  private static final By firstNameInput = By.id("first-name");
  private static final By lastNameInput = By.id("last-name");
  private static final By postalCodeInput = By.id("postal-code");
  private static final By continueButton = By.cssSelector("input[value='CONTINUE']");
  private final WebDriver driver;
  private final ElementUtil elementUtil;

  public CheckoutPage(WebDriverManagerUtil driverManagerUtil) {
    this.driver = driverManagerUtil.getDriver();
    this.elementUtil = new ElementUtil(driver);
  }

  public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
    elementUtil.sendKeys(firstNameInput, firstName);
    elementUtil.sendKeys(lastNameInput, lastName);
    elementUtil.sendKeys(postalCodeInput, postalCode);
    elementUtil.click(continueButton);
  }
}
