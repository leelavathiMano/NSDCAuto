package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage
{
    WebDriver driver;
    
    @FindBy(xpath="//li[@routerlink='login']")
    private WebElement loginButton;
    @FindBy(xpath="//li[contains(text(),'Register')]")
    private WebElement registerButton;
    
    public LaunchPage(WebDriver driver)
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

