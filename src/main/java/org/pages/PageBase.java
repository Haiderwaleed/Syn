package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
    public WebDriver driver;

    // create constructor

    public PageBase(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

}
