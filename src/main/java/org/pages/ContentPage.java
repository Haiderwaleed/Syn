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
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    @FindBy (partialLinkText= "Add content")
    WebElement addContentButton;
    @FindBy (css= "div[class='layout-container'] div:nth-child(6)")
    WebElement landingPageButton;
    @FindBy (css ="div:nth-child(10)")
    WebElement newsItemButton;
    @FindBy (linkText = "Content")
    WebElement contentButton;
    @FindBy (css = "a[title='Event']")
    WebElement AddEvent;
    @FindBy (css = "a[title='Blog entry']")
    WebElement addBlog;
    @FindBy (css = "a[title='Contact Information']")
    WebElement addContactInfoPage;
    @FindBy (css = "a[title='Distributor']")
    WebElement addDistributorPage;
    @FindBy (css = "a[title='FAQ']")
    WebElement addFAQPage;

    public void openContentPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Content")));
        contentButton.click();
    }
    public void AddContents(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Add content")));
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
    public void AddEventPage(){
        AddEvent.click();
    }
    public void AddBlogPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Blog entry']")));
        addBlog.click();
    }
    public void AddContactInfoPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Contact Information']")));
        addContactInfoPage.click();
    }
    public void AddDistributorPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Distributor']")));
        addDistributorPage.click();
    }
    public void AddFAQPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='FAQ']")));
        addFAQPage.click();
    }


}
