package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.CheckoutOverviewPage;
import com.gitlab.richard_earle_uk.pages.CheckoutPage;
import com.gitlab.richard_earle_uk.pages.OrderConfirmationPage;
import com.gitlab.richard_earle_uk.pages.ProductsPage;
import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewSteps {
  private static final String DEFAULT_FIRST_NAME = "Fred";
  private static final String DEFAULT_LAST_NAME = "Dibner";
  private static final String DEFAULT_POSTAL_CODE = "12345";
  private final String EXPECTED_ORDER_CONFIRMATION_HEADER = "THANK YOU FOR YOUR ORDER";

  private final WebDriver driver;
  private ProductsPage productsPage;
  private CheckoutOverviewPage checkoutOverviewPage;

  public CheckoutOverviewSteps(WebDriver driver) {
    this.driver = driver;
  }


  @When("the user finishes the checkout")
  public void theUserFinishesTheCheckout() {
    checkoutOverviewPage.clickFinishButton();
  }
}
