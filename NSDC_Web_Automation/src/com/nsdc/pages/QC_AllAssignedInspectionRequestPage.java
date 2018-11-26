package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QC_AllAssignedInspectionRequestPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextbox;
	
	
	
	public QC_AllAssignedInspectionRequestPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterForSearchByKeyword(String keyword)
	{
		searchByKeywordTextbox.clear();
		searchByKeywordTextbox.sendKeys(keyword);
	}

}
