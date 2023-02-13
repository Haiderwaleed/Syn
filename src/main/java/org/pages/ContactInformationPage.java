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

import java.time.Duration;

public class ContactInformationPage extends PageBase{
    public ContactInformationPage(WebDriver driver) {
        super(driver);
    }

    // Fluent Wait
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    // Add 1st Title
    @FindBy (id = "edit-field-title-0-value")
    WebElement firstContactInfoTitle;

    public void AddFirstContactInfoTitle(String ContactInfoTitle){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-title-0-value")));
        firstContactInfoTitle.sendKeys(ContactInfoTitle);
    }

    // Add Body
    @FindBy (css = "iframe[title='Rich Text Editor, Body field']")
    WebElement contactInfoBodyIframe;
    @FindBy (xpath = "(//body)[1]")
    WebElement contactInfoBody;

    public void AddContactInfoBody(String DescriptionFiled){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title='Rich Text Editor, Body field']")));
        driver.switchTo().frame(contactInfoBodyIframe);
        contactInfoBody.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
    }

    // Address
    @FindBy (id = "edit-field-address-0")
    WebElement addressDropdown;
    @FindBy(id = "edit-field-address-0-address-country-code--2")
    WebElement selectContactInfoCountryAddress;
    @FindBy (id = "edit-field-address-0-address-address-line1--n98D4u63raI")
    WebElement contactInfoStreetAddress;
    @FindBy (id = "edit-field-address-0-address-postal-code--FaC1zPxeOoQ")
    WebElement contactInfoPostalCode;
    @FindBy (id = "edit-field-address-0-address-locality--aylclkk2Qbc")
    WebElement contactInfoCity;

//    public void AddressSection(String StreetAddress, String PostalCode, String City) {
//        addressDropdown.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-address-0-address-country-code--2")));
//        Select selectCountryAddressOption = new Select(selectContactInfoCountryAddress);
//        selectCountryAddressOption.selectByIndex(31);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".js-form-item.form-item.js-form-type-textfield.form-type--textfield.js-form-item-field-address-0-address-address-line1.form-item--field-address-0-address-address-line1")));
//        contactInfoStreetAddress.sendKeys(StreetAddress);
//        contactInfoPostalCode.sendKeys(PostalCode);
//        contactInfoCity.sendKeys(City);
//
//
//    }

    // Country
    @FindBy (id = "edit-field-country")
    WebElement selectContactInfoCountry;

    public void SelectContactInfoCountry(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-country")));
        Select selectContactInfoCountryOption = new Select(selectContactInfoCountry);
        selectContactInfoCountryOption.selectByIndex(1);
    }

    // Phone and Site
    @FindBy (id = "edit-field-phone-number-0-value")
    WebElement addContactInfoPhoneNumber;
    @FindBy (id = "edit-field-syngenta-website-0-value")
    WebElement addContactInfoSite;

    public void AddPhoneAndSite(String Phone, String Site){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-phone-number-0-value")));
        addContactInfoPhoneNumber.sendKeys(Phone);
        addContactInfoSite.sendKeys(Site);
    }

    // Country logo
    @FindBy (id = "edit-field-country-logo-open-button")
    WebElement addContactInfoLogoImage;
    @FindBy (xpath = "(//div[@class='views-field views-field-rendered-entity js-click-to-select-trigger media-library-item__click-to-select-trigger'])[1]")
    WebElement selectContactInfoLogoImage;
    @FindBy (css = "button[class='media-library-select button button--primary js-form-submit form-submit ui-button ui-corner-all ui-widget']")
    WebElement insertSelectedContactInfoLogoImage;

    public void AddContactInfoLogoImage(){
        addContactInfoLogoImage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view-header")));
        selectContactInfoLogoImage.click();
        insertSelectedContactInfoLogoImage.click();
    }

    // Add 2nd Title
    @FindBy (id = "edit-title-0-value")
    WebElement addContactInfo2ndTitle;

    public void Add2ndTitle(String SecondTitle) throws InterruptedException {
        Thread.sleep(3000);
        addContactInfo2ndTitle.sendKeys(SecondTitle);
    }

    // Save node
    @FindBy (id = "edit-submit--2--gin-edit-form")
    WebElement saveContactInfoNode;

    public void SaveBlogNode(){
        saveContactInfoNode.click();
    }

    // Delete node
    @FindBy(linkText = "Delete")
    WebElement deleteContactInfoNode;

    @FindBy(id = "edit-submit")
    WebElement deleteBtn;

    public void DeleteContactInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Translate")));
        deleteContactInfoNode.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("claro-details__summary")));
        deleteBtn.click();
    }
}
