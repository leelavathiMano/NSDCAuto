package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingCentreDashboardPage
{
	WebDriver driver;
	
	@FindBy(xpath="//p[text()='View Batches']")
	private WebElement viewBatchCard;
	
	
	public TrainingCentreDashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickViewBatchCard()
	{
		viewBatchCard.click();
	}
	
}