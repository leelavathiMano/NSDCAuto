package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class RegistrationPage
{
    WebDriver driver;
    
    @FindBy(xpath="//select[@id='exampleSelect1']")
    private WebElement UserTypeDropdownList;
    @FindBy(xpath="//input[@name='name']")
    private WebElement spocNameTextbox;
    @FindBy(xpath="//input[@name='email']")
    private WebElement emailTextbox;
    @FindBy(xpath="//input[@name='mobile']")
    private WebElement mobileTextbox;
    @FindBy(xpath="//button[contains(text(),'Register')]")
    private WebElement registerButton;
    @FindBy(xpath="//input[@name='eOTP']")
    private WebElement emailOTPTextbox;
    @FindBy(xpath="//input[@name='mOTP']")
    private WebElement mobileOTPTextbox;
    @FindBy(xpath="//button[contains(text(),'Verify')]")
    private WebElement verifyButton;
    @FindBy(xpath="//span[@class='text-bold']")
    private WebElement usernameLabel;
    @FindBy(xpath="//button[contains(text(),'Go to Login')]")
    private WebElement goToLoginButton;
    
    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void selectDropdownList(String visibleText)
    {
        SelectDropDownList.selectDropDownListByVisibleText(UserTypeDropdownList, visibleText);
    }
    
    public void enterSPOCName(String spocName)
    {
        spocNameTextbox.clear();
        spocNameTextbox.sendKeys(spocName);
    }
    
    public void enterEmail(String email)
    {
        emailTextbox.clear();
        emailTextbox.sendKeys(email);
    }
    
    public void enterMobile(String mobile)
    {
        mobileTextbox.clear();
        mobileTextbox.sendKeys(mobile);
    }
    
    public void clickRegister()
    {
        registerButton.click();
    }
    
    public void enterEmailOTP(String emailOTP)
    {
        emailOTPTextbox.clear();
        emailOTPTextbox.sendKeys(emailOTP);
    }
    
    public void enterMobileOTP(String mobileOTP)
    {
        mobileOTPTextbox.clear();
        mobileOTPTextbox.sendKeys(mobileOTP);
    }
    
    public void clickGoToLogin()
    {
        goToLoginButton.click();
    }
    
    public void clickVerify()
    {
        verifyButton.click();
    }
    
}

