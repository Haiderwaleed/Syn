package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class UserLoginPage extends PageBase{

    public UserLoginPage(WebDriver driver)
    {
        super(driver);
    }

    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    @FindBy (name = "name")
    WebElement emailField;

    @FindBy (name = "pass")
    WebElement passwordField;

    @FindBy (id = "edit-remember-me")
    WebElement rememberMeCheckBox;

    @FindBy (id = "edit-submit")
    WebElement loginButton;

    @FindBy (xpath = "//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[1]/a")
    public WebElement successLogin;

    public void userLogin(String email, String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        rememberMeCheckBox.click();
        loginButton.click();
    }




}
