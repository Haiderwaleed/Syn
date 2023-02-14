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

public class FAQPage extends PageBase{
    public FAQPage(WebDriver driver) {
        super(driver);
    }
    // Fluent Wait
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);


    // Title
    @FindBy (id = "edit-title-0-value")
    WebElement title;

    public void FAQTitle(String FAQTitle){
        title.sendKeys(FAQTitle);
    }

    // Language
    @FindBy (id = "edit-langcode-0-value")
    WebElement selectLanguage;

    public void SelectFAQLanguage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-langcode-0-value")));
        Select selectLanguageOption = new Select(selectLanguage);
        selectLanguageOption.selectByValue("en");
    }

    // Body
    @FindBy (css = "iframe[title='Rich Text Editor, Body field']")
    WebElement bodyIframe;
    @FindBy (xpath = "(//body)[1]")
    WebElement bodyDescription;

    public void SwitchToBodyIframe(String DescriptionFiled){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title='Rich Text Editor, Body field']")));
        driver.switchTo().frame(bodyIframe);
        bodyDescription.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();

    }
    // FAQ
    @FindBy (css = "iframe[title='Rich Text Editor, Description field']")
    WebElement accordionIframe;
    @FindBy (xpath = "(//body)[1]")
    WebElement accordionDescription;
    @FindBy (id = "edit-field-faq-0-subform-field-items-0-subform-field-title-0-value")
    WebElement question;
    @FindBy (css = "iframe[title='Rich Text Editor, Answer field']")
    WebElement answerIframe;
    @FindBy (xpath = "(//body)[1]")
    WebElement answerDescription;

    public void SwitchToDistributorIframe(String DescriptionFiled, String Question){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title='Rich Text Editor, Description field']")));
        driver.switchTo().frame(accordionIframe);
        accordionDescription.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title='Rich Text Editor, Answer field']")));
        question.sendKeys(Question);
        driver.switchTo().frame(answerIframe);
        answerDescription.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();

    }

    @FindBy (css = "#edit-field-faq-0-subform-field-items-add-more-add-more-button-accordion-item")
    WebElement addAccordionItem;
    @FindBy (name = "field_faq[0][subform][field_items][1][subform][field_title][0][value]")
    WebElement question2;
    @FindBy (xpath = "(//iframe[@title='Rich Text Editor, Answer field'])[2]")
    WebElement accordionIframe2;
    @FindBy (css = "body")
    WebElement accordionDescription2;

    public void AddAccordionItem (String DescriptionFiled, String Question){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#edit-field-faq-0-subform-field-items-add-more-add-more-button-accordion-item")));
        addAccordionItem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field_faq[0][subform][field_items][1][subform][field_title][0][value]")));
        question2.sendKeys(Question);
        driver.switchTo().frame(accordionIframe2);
        accordionDescription2.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();
    }

    // Add 2nd Accordion
    @FindBy (id = "edit-field-faq-add-more-add-more-button-accordion")
    WebElement addSecondAccordion;
    @FindBy (xpath = "(//iframe[@title='Rich Text Editor, Description field'])[2]")
    WebElement switchToSecondAccordionIframe;
    @FindBy (css = "body")
    WebElement addSecondAccordionDescription;
    @FindBy (name = "field_faq[1][subform][field_items][0][subform][field_title][0][value]")
    WebElement addSecondAccordionQuestion;
    @FindBy (xpath = "(//iframe[@title='Rich Text Editor, Answer field'])[2]")
    WebElement switchTOSecondAccordionItems;
    @FindBy (css = "body")
    WebElement addSecondAccordionDescriptionItem;

    public void AddSecondAccordion(String DescriptionFiled, String Question){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-faq-add-more-add-more-button-accordion")));
        addSecondAccordion.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@title='Rich Text Editor, Description field'])[2]")));
        driver.switchTo().frame(switchToSecondAccordionIframe);
        addSecondAccordionDescription.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@title='Rich Text Editor, Answer field'])[2]")));
        addSecondAccordionQuestion.sendKeys(Question);
        driver.switchTo().frame(switchTOSecondAccordionItems);
        addSecondAccordionDescriptionItem.sendKeys(DescriptionFiled);
        driver.switchTo().defaultContent();

    }

    // Tag
    @FindBy (id = "edit-field-tags-0-target-id")
    WebElement tags;

    public void FAQTags(String Tags){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-field-tags-0-target-id")));
        tags.sendKeys(Tags);
    }

    // Save node
    @FindBy(id = "edit-submit--2--gin-edit-form")
    WebElement saveFAQNode;

    public void SaveFAQNode(){
        saveFAQNode.click();
    }

    // Delete node
    @FindBy(linkText = "Delete")
    WebElement deleteFAQNode;

    @FindBy(id = "edit-submit")
    WebElement deleteBtn;

    public void DeleteFAQ() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Translate")));
        deleteFAQNode.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("claro-details__summary")));
        deleteBtn.click();
    }

}
