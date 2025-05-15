package com.gitlab.richard_earle_uk.pages;

import com.gitlab.richard_earle_uk.utils.ElementUtil;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  protected WebDriver driver;
  protected ElementUtil elementUtil;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.elementUtil = new ElementUtil(driver);
  }
}
