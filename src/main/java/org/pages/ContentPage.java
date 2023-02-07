package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ContentPage extends PageBase{
    public ContentPage(WebDriver driver) {
        super(driver);
    }

    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    @FindBy (css = ".button.button--action.button--primary")
    WebElement addContentButton;

    @FindBy (css= "div[class='layout-container'] div:nth-child(6)")
    WebElement landingPageButton;

    @FindBy (css ="div:nth-child(10)")
    WebElement newsItemButton;

    public void AddContents(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.button--action.button--primary")));
        addContentButton.click();
    }
    public void AddLandingPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='layout-container'] div:nth-child(6)")));
        landingPageButton.click();
    }
    public void AddNewsPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(10)")));
        newsItemButton.click();
    }
}
