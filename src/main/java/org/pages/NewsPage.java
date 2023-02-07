package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class NewsPage extends PageBase {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    // Fluent Wait
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    // Select the node language
    @FindBy(id = "edit-langcode-0-value")
    WebElement selectNewsLanguage;

    public void SelectNewLanguage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-langcode-0-value")));
        Select selectNewsOption = new Select(selectNewsLanguage);
        Assert.assertFalse(selectNewsOption.isMultiple());
        selectNewsOption.selectByValue("en");
    }

    // Add the news node title
    @FindBy(id = "edit-title-0-value")
    WebElement addTitleForNewsPage;

    public void AddNewsTitle(String NewsTitle) {
        addTitleForNewsPage.sendKeys(NewsTitle);
    }

    // Select item type
    @FindBy(id = "edit-field-item-type")
    WebElement selectItemType;

    public void SelectNewsItemType() {
        Select selectNewsItemOption = new Select(selectItemType);
        Assert.assertFalse(selectNewsItemOption.isMultiple());
        selectNewsItemOption.selectByValue("news");
    }

    // Select the main category
    @FindBy(id = "edit-field-main-category-0-target-id")
    WebElement mainCategory;

    public void AddNewsMainCategory(String MainCategoryTitle) {
        mainCategory.sendKeys(MainCategoryTitle);
    }

    // Select the secondary category
    @FindBy(id = "edit-field-secondary-category-0-target-id")
    WebElement secondaryCategory;

    public void AddNewsSecondaryCategory(String SecondaryCategoryTitle) {
        secondaryCategory.sendKeys(SecondaryCategoryTitle);
    }

    // Add Teaser
    @FindBy(id = "edit-field-teaser-0-value")
    WebElement teaserNews;

    public void AddNewsTeaser(String NewsTeaserValue) {
        teaserNews.sendKeys(NewsTeaserValue);
    }

    // Add Body text
    @FindBy(css = "iframe[title='Rich Text Editor, Body field']")
    WebElement bodyIframe;
    @FindBy(xpath = "(//body)[1]")
    WebElement bodyTextarea;

    public void switchToFrame(String NewsBodyValue) {
        driver.switchTo().frame(bodyIframe);
        bodyTextarea.sendKeys(NewsBodyValue);
        driver.switchTo().defaultContent();
    }

    // Click on the taxonomy dropdown button
    @FindBy(xpath = "(//summary[normalize-space()='Taxonomy'])[1]")
    WebElement taxonomyDropDownBtn;

    public void TaxonomyDropdown() {
        taxonomyDropDownBtn.click();
    }

    // Add news tags
    @FindBy(id = "edit-field-tags-0-target-id")
    WebElement AddTagsNews;

    public void AddTags(String TagsTitle) {
        AddTagsNews.sendKeys(TagsTitle);
    }

    // Add News Geo region
    @FindBy(id = "edit-field-geo-region-0-target-id")
    WebElement addGeoRegionNews;

    public void AddGeoRegion(String GeoTitle) {
        addGeoRegionNews.sendKeys(GeoTitle);
    }

    // Click on the Media dropdown button
    @FindBy(css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-media']")
    WebElement mediaDropDownBtn;

    public void MediaDropDown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-media']")));
        mediaDropDownBtn.click();
    }

    // Add Thumbnail image
    @FindBy(id = "edit-field-thumbnail-image-open-button")
    WebElement addThumbnailImage;

    @FindBy(css = "article[data-quickedit-entity-id='media/2826']")
    WebElement selectThumbnailImage;

    @FindBy(xpath = "(//button[normalize-space()='Insert selected'])[1]")
    WebElement insertSelectedBtnThumbnail;

    public void AddThumbnailImage() {
        addThumbnailImage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-dialog-titlebar")));
        selectThumbnailImage.click();
        insertSelectedBtnThumbnail.click();
    }

    // Add Main image
    @FindBy(id = "edit-field-main-image-open-button")
    WebElement addMainImage;

    @FindBy(xpath = "(//div)[1185]")
    WebElement selectMainImage;

    @FindBy(xpath = "(//button[normalize-space()='Insert selected'])[1]")
    WebElement insertSelectedBtnMainImage;

    public void AddMainImage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".contextual-region.syn-media-type.media-library-item__preview-wrapper[data-drupal-selector='edit-field-thumbnail-image-selection-0-rendered-entity']")));
        addMainImage.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div)[1185]")));
        selectMainImage.click();
        insertSelectedBtnMainImage.click();
    }

    // Click on the Related Content dropdown button
    @FindBy(css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-related-content']")
    WebElement relatedContentDropDownBtn;

    public void RelatedContentDropdown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".contextual-region.syn-media-type.media-library-item__preview-wrapper")));
        relatedContentDropDownBtn.click();
    }

    // Add CP Product
    @FindBy(id = "edit-field-cp-products-0-target-id")
    WebElement addCPProductsNews;

    public void AddCpProducts(String CPProductTitle) {
        addCPProductsNews.sendKeys(CPProductTitle);
    }

    // Add Seeds
    @FindBy(id = "edit-field-seeds-0-target-id")
    WebElement addSeedsNews;

    public void AddSeeds(String SeedTitle) {
        addSeedsNews.sendKeys(SeedTitle);
    }

    // Add Targets
    @FindBy(id = "edit-field-targets-0-target-id")
    WebElement addTargetNews;

    public void AddTargets(String TargetTitle) {

        addTargetNews.sendKeys(TargetTitle);
    }

    // Save Node
    @FindBy(id = "edit-submit--2--gin-edit-form")
    WebElement saveButton;

    public void SaveNewsNode() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-submit--2--gin-edit-form")));
        Thread.sleep(3000);
        saveButton.click();
    }

    // Delete News
    @FindBy(linkText = "Delete")
    WebElement deleteNewsNode;

    @FindBy(id = "edit-submit")
    WebElement deleteBtn;

    public void DeleteNews() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav[aria-label='Tabs']")));
        deleteNewsNode.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("claro-details__summary")));
        deleteBtn.click();


    }

}
