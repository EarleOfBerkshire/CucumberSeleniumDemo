package com.gitlab.richard_earle_uk.pages;

import java.util.List;

import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
  private static final By firstNameInput = By.id("first-name");
  private static final By lastNameInput = By.id("last-name");
  private static final By postalCodeInput = By.id("postal-code");
  private static final By continueButton = By.cssSelector("input[value='CONTINUE']");
  private final WebDriver driver;

  public CheckoutPage(WebDriverManagerUtil driverManagerUtil) {
    this.driver = driverManagerUtil.getDriver();

  }


  public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
    driver.findElement(firstNameInput).sendKeys(firstName);
    driver.findElement(lastNameInput).sendKeys(lastName);
    driver.findElement(postalCodeInput).sendKeys(postalCode);
    driver.findElement(continueButton).click();
  }
}
