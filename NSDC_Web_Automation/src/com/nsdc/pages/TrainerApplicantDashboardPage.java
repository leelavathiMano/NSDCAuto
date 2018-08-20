package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerApplicantDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'Search for available batches')]")
	private WebElement searchAndApplyForAvailableBatchesButton;
	@FindBy(xpath="//span[contains(text(),'View Batches')]")
	private WebElement viewBatchesButton;
			
	public TrainerApplicantDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickSearchAndApplyforAvailableBatches()
	{
		searchAndApplyForAvailableBatchesButton.click();
	}
	public void clickViewBatches()
	{
		viewBatchesButton.click();
	}
	
}