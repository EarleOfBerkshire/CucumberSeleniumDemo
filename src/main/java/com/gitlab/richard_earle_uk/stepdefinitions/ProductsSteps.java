package com.gitlab.richard_earle_uk.stepdefinitions;

import com.gitlab.richard_earle_uk.pages.ProductsPage;
import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ProductsSteps {

  private final ProductsPage productsPage;

  public ProductsSteps(WebDriverManagerUtil driverManagerUtil) {
    this.productsPage = new ProductsPage(driverManagerUtil);
  }

  @When("the user adds the first item to the cart")
  public void theUserAddsTheFirstItemToTheCart() {
    productsPage.addFirstItemToCart();
  }

  @And("the user navigates to the cart")
  public void theUserNavigatesToTheCart() {
    productsPage.navigateToCart();
  }
}
