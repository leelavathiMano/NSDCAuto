package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterLoginPage
{
    WebDriver driver;
    
    @FindBy(xpath="//input[@name='email']")
    private WebElement usernameTextbox;
    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordTextbox;
    @FindBy(xpath="//button[contains(text(),'Login')]")
    private WebElement loginButton;
    
    public EnterLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void performlogin(String username, String password) throws Exception
    {
        usernameTextbox.sendKeys(username);
        passwordTextbox.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
    }
    
    public void enterUsername(String username)
    {
        usernameTextbox.clear();
        usernameTextbox.sendKeys(username);
    }
    
    public void enterPassword(String password)
    {
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }
    
    public void clickLoginToSubmit()
    {
        loginButton.click();
    }
}

