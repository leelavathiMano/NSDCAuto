package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSCDashboardPage
{
	WebDriver driver;
	
	@FindBy(xpath="//p[text()='Create Batch']")
	private WebElement createBatchCard;
	
	
	public SSCDashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickCreateBatchCard()
	{
		createBatchCard.click();
	}
	
}