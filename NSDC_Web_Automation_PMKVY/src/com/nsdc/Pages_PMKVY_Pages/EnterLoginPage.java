package com.nsdc.Pages_PMKVY_Pages;

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
    @FindBy(xpath="//button[contains(text(),'LOGIN')]")
    private WebElement loginButton;
    @FindBy(xpath="//input[@formcontrolname='oldPassword']")
    private WebElement oldPasswordTextbox;
    @FindBy(xpath="//input[@formcontrolname='newPassword']")
    private WebElement newPasswordTextBox;
    
    @FindBy(xpath="//input[@formcontrolname='confirmPassword']")
    private WebElement ConfirmPasswordTextBox;
    @FindBy(xpath="//button[contains(text(),'Reset & Re-login')]")
    private WebElement ResetAndReloginButton;
    @FindBy(xpath="//button[text()='OK']")
    private WebElement OKButton;
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
    
    public void EnteroldPassword(String oldpassword)
    {
    	oldPasswordTextbox.sendKeys(oldpassword);
    }
    public void Enternewpassword(String newPassword)
    {
    	newPasswordTextBox.sendKeys(newPassword);
    }
    public void EnterConfirmPassword(String confirmPassword)
    {
    	ConfirmPasswordTextBox.sendKeys(confirmPassword);
    }
    public void ClickOnResetAndRelogin()
    {
    	ResetAndReloginButton.click();
    }
    public void ClickOnOK()
    {
    	OKButton.click();
    }
}

