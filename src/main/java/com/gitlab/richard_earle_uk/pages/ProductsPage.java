package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By firstAddToCartButton = By.cssSelector(".inventory_item:first-of-type button");
    private By shoppingCartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriverManagerUtil driverManagerUtil) {
        this.driver = driverManagerUtil.getDriver();
    }

    public void addFirstItemToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void navigateToCart() {
        driver.findElement(shoppingCartLink).click();
    }
}