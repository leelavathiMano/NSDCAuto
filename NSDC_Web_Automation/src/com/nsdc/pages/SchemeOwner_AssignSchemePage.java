package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SchemeOwner_AssignSchemePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@ng-reflect-name='assignedToSchemeAdmin' or @title='Select Scheme Admin']")
	private WebElement selectSchemeOwnerDropDownList;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitAndAssignSchemeButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	
	 public SchemeOwner_AssignSchemePage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void selectSchemeOwner(String scheme_Owner)
		{
	    	SelectDropDownList.selectDropDownListByVisibleText(selectSchemeOwnerDropDownList, scheme_Owner);
		}
		
	    public void clickOnSubmitAndAssignScheme()
	    {
	    	submitAndAssignSchemeButton.click();
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
