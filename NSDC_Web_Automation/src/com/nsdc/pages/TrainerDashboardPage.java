package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerDashboardPage
{
	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Search & Apply')]")
	private WebElement searchAndApplyCard;
	@FindBy(xpath="//span[contains(text(),'View Batches')]")
	private WebElement viewBatchesCard;
	
	
	public TrainerDashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickSearchAndApplyCard()
	{
		searchAndApplyCard.click();
	}
	public void clickViewBatchesCard()
	{
		viewBatchesCard.click();
	}
	
}