package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationBasedTC_DashboardPage
{
	WebDriver driver;
	@FindBy(xpath="//p[text()='View Batches']")
	private WebElement viewBatchesButton;
	
	public LocationBasedTC_DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToViewLocationBasedTrainingBatches()
	{
		viewBatchesButton.click();
	}

}
