package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.CheckoutOverviewPage;
import com.gitlab.richard_earle_uk.pages.CheckoutPage;
import com.gitlab.richard_earle_uk.pages.OrderConfirmationPage;
import com.gitlab.richard_earle_uk.pages.ProductsPage;
import com.gitlab.richard_earle_uk.utils.DriverFactory;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationSteps {
  private final String EXPECTED_ORDER_CONFIRMATION_HEADER = "THANK YOU FOR YOUR ORDER";

  private final WebDriver driver;
  private ProductsPage productsPage;
  private CheckoutPage checkoutPage;
  private CheckoutOverviewPage checkoutOverviewPage;
  private OrderConfirmationPage orderConfirmationPage;

  public OrderConfirmationSteps(WebDriver driver) {
    this.driver = driver;
  }

  @Then("the user should see a confirmation message")
  public void theUserShouldSeeAConfirmationMessage() {
    String actualOrderConfirmationHeaderMessage = orderConfirmationPage.getHeaderMessage();
    Assertions.assertEquals(
        EXPECTED_ORDER_CONFIRMATION_HEADER,
        actualOrderConfirmationHeaderMessage,
        "Order confirmation header message did not match expected");
  }
}
