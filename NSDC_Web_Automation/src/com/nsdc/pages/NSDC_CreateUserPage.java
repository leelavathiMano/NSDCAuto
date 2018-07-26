package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class NSDC_CreateUserPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@formcontrolname='role']")
	private WebElement businessUserDropDownList;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement fullNameTextbox;
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="//input[@formcontrolname='mobile']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//span[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement oKButton;
	
	public NSDC_CreateUserPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	public void selectBusinessUser(String businessUser)
	{
		SelectDropDownList.selectDropDownListByVisibleText(businessUserDropDownList, businessUser);
	}
	
	public void enterFullName(String fullname)
	{
		fullNameTextbox.clear();
		fullNameTextbox.sendKeys(fullname);
	}
	
	public void enterEmailAddress(String email)
	{
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys(email);
	}
	
	public void enterMobileNumber(String mobileNumber)
	{
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(mobileNumber);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
