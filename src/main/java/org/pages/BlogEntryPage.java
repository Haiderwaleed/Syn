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

public class BlogEntryPage extends PageBase {
    public BlogEntryPage(WebDriver driver) {
        super(driver);
    }

    // Fluent Wait
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);


    // Select Node Language

    @FindBy(id = "edit-langcode-0-value")
    WebElement selectBlogLanguage;

    public void SelectBlogLanguage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-langcode-0-value")));
        Select selectBlogLanguageOption = new Select(selectBlogLanguage);
        Assert.assertFalse(selectBlogLanguageOption.isMultiple());
        selectBlogLanguageOption.selectByValue("en");

    }

    // Add Event Title
    @FindBy(id = "edit-title-0-value")
    WebElement addBlogTitle;

    public void AddBlogTitle(String BlogTitle) {
        addBlogTitle.sendKeys(BlogTitle);
    }

    // Add Blog Author
    @FindBy (id = "edit-field-blog-author")
    WebElement selectBlogAuthor;

    public void SelectBlogAuthor(){
        Select selectBlogAuthorOption  = new Select(selectBlogAuthor);
        selectBlogAuthorOption.selectByIndex(1);
    }

    // Add Blog type
    @FindBy (id = "edit-field-blog-type-0-target-id--level-0")
    WebElement selectBlogType;

    public void SelectBlogType(){
        Select selectAuthorType = new Select(selectBlogType);
        selectAuthorType.selectByIndex(1);
    }

    // Add Thumbnail image
    @FindBy (id = "edit-field-thumbnail-image-open-button")
    WebElement addBlogThumbnailImage;
    @FindBy (xpath = "(//div[@class='views-field views-field-media-library-select-form js-click-to-select-checkbox media-library-item__click-to-select-checkbox'])[1]")
    WebElement selectThumbnailImage;
    @FindBy (css = "button[class='media-library-select button button--primary js-form-submit form-submit ui-button ui-corner-all ui-widget']")
    WebElement insertBlogThumbnailImage;

    public void AddThumbnailImage(){
        addBlogThumbnailImage.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".view-header")));
        selectThumbnailImage.click();
        insertBlogThumbnailImage.click();
    }

    // Add Body
    @FindBy (css = "iframe[title='Rich Text Editor, Body field']")
    WebElement switchToBlogIframe;

    @FindBy (xpath = "(//body)[1]")
    WebElement blogBodyTextArea;

    public void AddBlogBody(String DescriptionFiled) throws InterruptedException {
        Thread.sleep(4000);
        driver.switchTo().frame(switchToBlogIframe);
        blogBodyTextArea.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
    }

    // Display author's name
    @FindBy (id = "edit-field-display-author-value")
    WebElement enableDisplayAuthorName;

    public void DisplayAuthorName(){
        enableDisplayAuthorName.click();
    }

    // Visibility
    @FindBy (id = "edit-field-visibility-public")
    WebElement visibleToAnonymousUsers;

    public void BlogVisibility(){
        visibleToAnonymousUsers.click();
    }

    // Customer Group
    @FindBy (id = "edit-field-customer-groups-341")
    WebElement blogCommunity;

    public void CustomerGroup(){
        blogCommunity.click();
    }

    // Rating option
    @FindBy (id = "edit-group-rating-options")
    WebElement ratingOptionDropdown;
    @FindBy (id = "edit-field-rating-options-public")
    WebElement allowedRatingForAllUsers;

    public void RatingOptions(){
        ratingOptionDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-rating-options-public")));
        allowedRatingForAllUsers.click();
    }

    // Comment option
    @FindBy (css = ".claro-details__summary.claro-details__summary--vertical-tabs-item[aria-controls='edit-group-comment-options']")
    WebElement commentOptionDropdown;
    @FindBy (id = "edit-field-comment-options-public")
    WebElement allowedCommentForAllUsers;

    public void CommentOption (){
        commentOptionDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-comment-options-public")));
        allowedCommentForAllUsers.click();
    }

    // Save node
    @FindBy (id = "edit-submit--2--gin-edit-form")
    WebElement saveBlogNode;

    public void SaveBlogNode(){
        saveBlogNode.click();
    }

    // Delete node
    @FindBy(linkText = "Delete")
    WebElement deleteBlogNode;

    @FindBy(id = "edit-submit")
    WebElement deleteBtn;

    public void DeleteBlog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
        deleteBlogNode.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("claro-details__summary")));
        deleteBtn.click();
    }


}