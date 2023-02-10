package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;


public class LandingPage extends PageBase{
    public LandingPage(WebDriver driver) {

        super(driver);
    }
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    @FindBy (id = "edit-langcode-0-value")
    WebElement optionList;

    @FindBy (id = "edit-title-0-value")
    WebElement landingPageTitle;

    @FindBy (id = "edit-submit--2--gin-edit-form")
    WebElement saveLandingPageButton;

    public void LanguageSelectorOption (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-langcode-0-value")));
        Select selectOption = new Select(optionList);
        Assert.assertFalse(selectOption.isMultiple());
        selectOption.selectByValue("en");
    }

    public void AddTitleLandingPage(String title){
        landingPageTitle.sendKeys(title);
    }

    public void SaveLandingPage(){
        saveLandingPageButton.click();
    }

    @FindBy (css = "div[class='region region-highlighted'] li:nth-child(4) a:nth-child(1)")
    WebElement deleteLandingPageBtn;

    @FindBy (id = "edit-submit")
    WebElement deleteBtn;
    public void DeleteLandingPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='region region-highlighted'] li:nth-child(4) a:nth-child(1)")));
        deleteLandingPageBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-submit")));
        deleteBtn.click();


    }

}
