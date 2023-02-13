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

public class EventsPage extends PageBase{
    public EventsPage(WebDriver driver) {
        super(driver);
    }

    // Fluent Wait
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);


    // Select the node language
    @FindBy (id = "edit-langcode-0-value")
    WebElement selectEventLanguage;

    public void SelectEventLanguage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-langcode-0-value")));
        Select selectEventOption = new Select(selectEventLanguage);
        Assert.assertFalse(selectEventOption.isMultiple());
        selectEventOption.selectByValue("en");
    }

    // Event title
    @FindBy (id = "edit-title-0-value")
    WebElement eventTitle;

    public void AddEventName(String EventTitle){
        eventTitle.sendKeys(EventTitle);
    }


    // Select event type
    @FindBy(id = "edit-field-event-type")
    WebElement selectEventType;

    public void SelectEventItemType() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-event-type-wrapper")));
        Select selectEventItemOption = new Select(selectEventType);
        selectEventItemOption.selectByIndex(1);
    }


    // show end date
    @FindBy (id ="edit-field-show-end-date-value")
    WebElement enableEndDate;

    public void EnableEndDate(){
        enableEndDate.click();
    }

    // show timezone
    @FindBy (id ="edit-field-show-timezone-value")
    WebElement enableTimezone;

    public void EnableTimezone(){
        enableTimezone.click();
    }


    // Event data
    @FindBy (id = "edit-field-event-date-0-value-date")
    WebElement addEvenStartDate;

    @FindBy (id = "edit-field-event-date-0-value-time")
    WebElement addEventStartTime;

    @FindBy (id = "edit-field-event-date-0-end-value-date")
    WebElement addEventFinalDate;
    @FindBy (id = "edit-field-event-date-0-end-value-time")
    WebElement addEventFinalTime;

    @FindBy (id = "edit-field-event-date-0-timezone")
    WebElement selectTimeZone;

    public void AddEventStartDate(String StartData, String Time){
        addEvenStartDate.sendKeys(StartData);
        addEventStartTime.sendKeys(Time);
    }
    public void AddEventFinalDate(String FinalDate, String Time){
        addEventFinalDate.sendKeys(FinalDate);
        addEventFinalTime.sendKeys(Time);
    }

    public void SelectTimeZone(){
        Select selectEventTimeZoneOption = new Select(selectTimeZone);
        selectEventTimeZoneOption.selectByIndex(360);
    }

    // Event Tease
    @FindBy (id = "edit-field-teaser-0-value")
    WebElement eventTeaser;

    public void AddEventTeaser(String TeaserField){
        eventTeaser.sendKeys(TeaserField);
    }


    // Event description
    @FindBy(css = "iframe[title='Rich Text Editor, Event description field']")
    WebElement descriptionIframe;
    @FindBy(xpath = "(//body)[1]")
    WebElement descriptionTextarea;

    public void switchToFrameEventDescription(String DescriptionFiled) {
        driver.switchTo().frame(descriptionIframe);
        descriptionTextarea.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
    }

    // Add Thumbnail image
    @FindBy(id = "edit-field-teaser-image-open-button")
    WebElement addEventThumbnailImage;

    @FindBy(xpath = "(//div[@class='views-field views-field-media-library-select-form js-click-to-select-checkbox media-library-item__click-to-select-checkbox'])[3]")
    WebElement selectEventThumbnailImage;

    @FindBy(css = "button[class='media-library-select button button--primary js-form-submit form-submit ui-button ui-corner-all ui-widget']")
    WebElement insertSelectedEventBtnThumbnail;

    public void AddEventThumbnailImage(){
        addEventThumbnailImage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drupal-modal")));
        selectEventThumbnailImage.click();
        insertSelectedEventBtnThumbnail.click();
    }

    // Add Homepage image
    @FindBy(id = "edit-field-main-image-open-button")
    WebElement addHomepageImage;

    @FindBy(xpath = "(//div[@class='views-field views-field-media-library-select-form js-click-to-select-checkbox media-library-item__click-to-select-checkbox'])[1]")
    WebElement selectHomepageImage;

    @FindBy(css = "button[class='media-library-select button button--primary js-form-submit form-submit ui-button ui-corner-all ui-widget']")
    WebElement insertSelectedBtnHomepageImage;

    public void AddEventHomepageImage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".contextual-region.syn-media-type.media-library-item__preview-wrapper[data-drupal-selector='edit-field-teaser-image-selection-0-rendered-entity']")));
        addHomepageImage.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".view-header")));
        selectHomepageImage.click();
        insertSelectedBtnHomepageImage.click();
    }

    // Add Banner Image
    @FindBy(id = "edit-field-banner-open-button")
    WebElement addBannerImage;

    @FindBy(xpath = "(//div[@class='views-field views-field-media-library-select-form js-click-to-select-checkbox media-library-item__click-to-select-checkbox'])[1]")
    WebElement selectBannerImage;

    @FindBy(css = "button[class='media-library-select button button--primary js-form-submit form-submit ui-button ui-corner-all ui-widget']")
    WebElement insertSelectedBtnBannerImage;

    public void AddEventBannerImage()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".contextual-region.syn-media-type.media-library-item__preview-wrapper[data-drupal-selector='edit-field-main-image-selection-0-rendered-entity']")));
        addBannerImage.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".view-header")));
        selectBannerImage.click();
        insertSelectedBtnBannerImage.click();
    }

    // Add Event Geo region
    @FindBy(id = "edit-field-geo-region-target-id")
    WebElement addEventGeoRegion;

    public void AddEventGeoRegion(String GeoTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".contextual-region.syn-media-type.media-library-item__preview-wrapper[data-drupal-selector='edit-field-banner-selection-0-rendered-entity']")));
        addEventGeoRegion.sendKeys(GeoTitle);
    }

    // Address dropdown
    @FindBy (css = ".claro-details__summary[aria-controls='edit-field-address-0']")
    WebElement addressDropdown;

    public void AddressDropdown(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".claro-details__summary[aria-controls='edit-field-address-0']")));
        addressDropdown.click();
    }

    // Address section
    @FindBy(id = "edit-field-other-title-0-value")
    WebElement addEventCommentAddress;

    public void AddEventAddress(String CommentAddress){
        addEventCommentAddress.sendKeys(CommentAddress);

    }

    // Registration
    @FindBy (css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-registration']")
    WebElement registrationEventDropdown;

    @FindBy (id = "edit-field-registration-date-0-value-date")
    WebElement addRegistrationDate;

    public void AddEventRegistration(String Date){
        registrationEventDropdown.click();
        addRegistrationDate.sendKeys(Date);
    }

    // Overview
    @FindBy (css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-overview']")
    WebElement overviewEventDropdown;
    @FindBy(css = "iframe[title='Rich Text Editor, Description field']")
    WebElement overviewDescriptionIframe;
    @FindBy(xpath = "(//body)[1]")
    WebElement overviewDescriptionTextarea;

    public void AddEventOverview(String DescriptionFiled){
        overviewEventDropdown.click();
        driver.switchTo().frame(overviewDescriptionIframe);
        overviewDescriptionTextarea.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
    }

    // Logistics
    @FindBy (css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-logistics']")
    WebElement logisticsEventDropdown;

    @FindBy(css = "iframe[title='Rich Text Editor, Logistics field']")
    WebElement logisticDescriptionIframe;
    @FindBy(xpath = "(//body)[1]")
    WebElement logisticDescriptionTextarea;
    @FindBy (id = "edit-field-additional-title-0-value")
    WebElement logisticsLabelOfTheTabEvent;

    public void AddEventLogistics(String DescriptionFiled, String EventLabel){
        logisticsEventDropdown.click();
        driver.switchTo().frame(logisticDescriptionIframe);
        logisticDescriptionTextarea.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
        logisticsLabelOfTheTabEvent.sendKeys(EventLabel);
    }

    // Agenda
    @FindBy (css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-agenda']")
    WebElement agendaEventDropdown;
    @FindBy (css = "iframe[title='Rich Text Editor, Agenda field']")
    WebElement agendaDescriptionIframe;
    @FindBy (xpath = "(//body)[1]")
    WebElement agendaDescriptionTextarea;
    @FindBy (id = "edit-field-extra-title-0-value")
    WebElement agendaLabelOfTheTabEvent;

    public void AddEventAgenda(String DescriptionFiled, String EventLabel){
        agendaEventDropdown.click();
        driver.switchTo().frame(agendaDescriptionIframe);
        agendaDescriptionTextarea.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
        agendaLabelOfTheTabEvent.sendKeys(EventLabel);
    }

    // Related event
    @FindBy (css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-related-events']")
    WebElement relatedEventDropdown;

    @FindBy (id = "edit-field-events-0-target-id")
    WebElement addRelatedEvent;

    public void AddEventRelatedEvent (String RelatedEventField){
        relatedEventDropdown.click();
        addRelatedEvent.sendKeys(RelatedEventField);
    }

    // Sales representative
    @FindBy (css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-sales-']")
    WebElement salesRepEventDropdown;
    @FindBy (id = "edit-field-sales-reps-limited-0-target-id")
    WebElement addSalesRepEvent;

    public void AddEventSalesRepresentative(String SalesFiled){
        salesRepEventDropdown.click();
        addSalesRepEvent.sendKeys(SalesFiled);
    }

    @FindBy (id = "edit-submit--2--gin-edit-form")
    WebElement saveEventNode;

    public void SaveEventNode(){
        saveEventNode.click();
    }

    // Delete Event
    @FindBy(linkText = "Delete")
    WebElement deleteEventNode;

    @FindBy(id = "edit-submit")
    WebElement deleteBtn;

    public void DeleteEvent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Translate")));
        deleteEventNode.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("claro-details__summary")));
        deleteBtn.click();
    }




}
