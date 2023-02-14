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

public class DistributorPage extends PageBase{
    public DistributorPage(WebDriver driver) {
        super(driver);
    }

    // Fluent Wait
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);


    // Company Name
    @FindBy (id = "edit-title-0-value")
    WebElement companyName;

    public void DistributorCompanyName(String CompanyName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-title-0-value")));
        companyName.sendKeys(CompanyName);
    }

    // Language
    @FindBy (id = "edit-langcode-0-value")
    WebElement selectLanguage;

    public void SelectDistributorLanguage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-langcode-0-value")));
        Select selectLanguageOption = new Select(selectLanguage);
        selectLanguageOption.selectByValue("en");
    }

    // Regions
    @FindBy (id = "edit-field-regions")
    WebElement regions;

    public void DistributorRegions(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-regions")));
        Select selectRegionsOption = new Select(regions);
        selectRegionsOption.selectByValue("1041");
    }

    // Distributor additional properties
    @FindBy (id = "edit-field-category")
    WebElement distributorAdditionalProperties;

    public void DistributorAdditionalProperties(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-category")));
        Select selectDistributorAdditionalProperties = new Select(distributorAdditionalProperties);
        selectDistributorAdditionalProperties.selectByValue("1036");
    }

    // Address Section

    // Phone, Email and Web Url
    @FindBy (id = "edit-field-phone-numbers-0-value")
    WebElement phone;
    @FindBy (id = "edit-field-emails-0-value")
    WebElement email;
    @FindBy (id = "edit-field-link-0-uri")
    WebElement webURL;

    public void AddPhoneEmailWebDistributor(String Phone, String Email, String WebURL){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-phone-numbers-0-value")));
        phone.sendKeys(Phone);
        email.sendKeys(Email);
        webURL.sendKeys(WebURL);
    }

    // Distributor Location and Business
    @FindBy (id = "edit-field-distributor-location-0-target-id")
    WebElement distributorLocation;
    @FindBy (id = "edit-field-business-0-target-id")
    WebElement business;

    public void DistributorLocationAndBusiness(String Location, String Business){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-distributor-location-0-target-id")));
        distributorLocation.sendKeys(Location);
        business.sendKeys(Business);

    }

    // Comment
    @FindBy (css = "iframe[title='Rich Text Editor, Comment field']")
    WebElement commentIframe;
    @FindBy (xpath = "(//body)[1]")
    WebElement comment;

    public void SwitchToDistributorIframe(String DescriptionFiled){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title='Rich Text Editor, Comment field']")));
        driver.switchTo().frame(commentIframe);
        comment.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
    }

    // Save node
    @FindBy (id = "edit-submit--2--gin-edit-form")
    WebElement saveDistributorNode;

    public void SaveDistributorNode(){
        saveDistributorNode.click();
    }

    // Delete node
    @FindBy(linkText = "Delete")
    WebElement deleteDistributorNode;

    @FindBy(id = "edit-submit")
    WebElement deleteBtn;

    public void DeleteDistributor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Translate")));
        deleteDistributorNode.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("claro-details__summary")));
        deleteBtn.click();
    }

}
