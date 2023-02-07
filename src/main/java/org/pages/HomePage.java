package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);

    }
    @FindBy (xpath="//*[@id=\"block-secondary\"]/ul/li[4]/a")
    WebElement loginLink;

    public void loginPage()
    {

    loginLink.click();

    }
}
