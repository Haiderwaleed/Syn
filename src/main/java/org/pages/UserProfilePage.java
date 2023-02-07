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

public class UserProfilePage extends PageBase{
    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    @FindBy (linkText = "Content")
    WebElement contentButton;


    public void openContentPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Content")));
        contentButton.click();
    }


}
