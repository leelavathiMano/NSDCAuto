package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartAdmin_AllSDMSUserPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchTextbox;
	@FindBy(xpath="(//a[contains(text(),'Edit')])[1]")
	private WebElement edit_ActionButton;
	@FindBy(xpath="(//a[contains(text(),'Remove')])[1]")
	private WebElement remove_ActionButton;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement fullName_UserDetailsTextbox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitbutton;
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement oKButton;
	
	public SmartAdmin_AllSDMSUserPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterSearchByKeyword(String search)
	{
		searchTextbox.clear();
		searchTextbox.sendKeys(search);
		searchTextbox.sendKeys(Keys.ENTER);
	}
	
	public void clickOnEdit()
	{
		edit_ActionButton.click();
	}
	
	public void clickOnRemove()
	{
		remove_ActionButton.click();
	}
	
	public void enterFullName_UserDetails(String name)
	{
		fullName_UserDetailsTextbox.clear();
		fullName_UserDetailsTextbox.sendKeys(name);
	}
	
	public void clickOnSubmit()
	{
		submitbutton.click();
	}
	
	public void clickOnYes()
	{
		yesButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
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
