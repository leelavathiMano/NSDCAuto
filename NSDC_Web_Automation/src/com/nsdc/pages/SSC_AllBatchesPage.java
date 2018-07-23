package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_AllBatchesPage
{
	WebDriver driver;
	
	@FindBy(xpath="//strong[contains(text(),'Create Batch')]")
	private WebElement createBatchCard;
	@FindBy(xpath="//strong[contains(text(),'All Batches')]")
	private WebElement allBatchesCard;
	
	
	public SSC_AllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickCreateBatchCard()
	{
		createBatchCard.click();
	}
	public void clickAllBatchesCard()
	{
		allBatchesCard.click();
	}
	
}