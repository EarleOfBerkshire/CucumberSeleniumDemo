package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.context.WebDriverContext;
import com.gitlab.richard_earle_uk.pages.CheckoutOverviewPage;
import com.gitlab.richard_earle_uk.pages.ProductsPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewSteps {

  private final WebDriver driver;
  private ProductsPage productsPage;
  private CheckoutOverviewPage checkoutOverviewPage;

  public CheckoutOverviewSteps(WebDriverContext context) {
    this.driver = context.getDriver();
  }

  @When("the user finishes the checkout")
  public void theUserFinishesTheCheckout() {
    checkoutOverviewPage.clickFinishButton();
  }
}
