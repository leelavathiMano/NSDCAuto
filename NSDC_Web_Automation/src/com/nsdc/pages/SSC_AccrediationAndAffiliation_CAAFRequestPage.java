package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SSC_AccrediationAndAffiliation_CAAFRequestPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextbox;
	
	
	
	public void enterSearchByKeywords(String keywords)
	{
		searchByKeywordTextbox.clear();
		searchByKeywordTextbox.sendKeys(keywords);
	}

}
