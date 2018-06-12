package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;
    
    @FindBy(xpath="//li[text()='Login']")
    private WebElement loginButton;
    @FindBy(xpath="//li[text()='Register']")
    private WebElement registerButton;
    
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickLogin()
    {
        loginButton.click();
    }
    
    public void clickRegister()
    {
        registerButton.click();
    }
}

