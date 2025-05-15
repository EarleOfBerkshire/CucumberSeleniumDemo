package com.earleofberkshire.pages;

import com.earleofberkshire.utils.ElementUtil;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  protected WebDriver driver;
  protected ElementUtil elementUtil;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.elementUtil = new ElementUtil(driver);
  }
}
