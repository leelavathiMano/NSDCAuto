package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TP_SPOCChangePage
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement sPOCFullNameTextbox;
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="//input[@formcontrolname='mobileNumber']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath="//button[contains(text(),'Save & Next')]")
	private WebElement saveAndNextButton;
	@FindBy(xpath="//a[contains(text(),'close')]")
	private WebElement closeButton;
	@FindBy(xpath="//input[@placeholder='Enter Your Training Partner ID']")
	private WebElement enterTPIDTextbox;
	@FindBy(xpath="//input[@placeholder='Enter Password']")
	private WebElement enterPasswordTextbox;
	@FindBy(xpath="//input[@formcontrolname='mobileOTP']")
	private WebElement mobileOTPTextbox;
	@FindBy(xpath="//input[@formcontrolname='emailOTP']")
	private WebElement emailOTPTextbox;
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	private WebElement verifyButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	public TP_SPOCChangePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterTP_SPOCFullName(String name)
	{
		sPOCFullNameTextbox.clear();
		sPOCFullNameTextbox.sendKeys(name);
	}
	
	public void enterTP_SPOCEmailAddress(String email)
	{
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys(email);
	}
	
	public void enterTP_SPOCMobileNumber(String mobileNumber)
	{
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(mobileNumber);
	}
	
	public void clickOnSaveAndNext()
	{
		saveAndNextButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void enterTPIDTextbox(String tpID)
	{
		enterTPIDTextbox.clear();
		enterTPIDTextbox.sendKeys(tpID);
	}
	
	public void enterPassword(String password)
	{
		enterPasswordTextbox.clear();
		enterPasswordTextbox.sendKeys(password);
	}
	
	public void enterMobileOTP(String mobileOTP)
	{
		mobileOTPTextbox.clear();
		mobileOTPTextbox.sendKeys(mobileOTP);
	}
	
	public void enterEmailOTPTextbox(String emailOTP)
	{
		emailOTPTextbox.clear();
		emailOTPTextbox.sendKeys(emailOTP);
	}
	
	public void clickOnVerify()
	{
		verifyButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOk()
	{
		okButton.click();
	}

}
