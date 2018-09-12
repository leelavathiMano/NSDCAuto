package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessorDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[2]")
	private WebElement assessorDashboardLink;
	@FindBy(xpath="//span[contains(text(),'View Batches')]")
	private WebElement viewBatchesButton;
	@FindBy(xpath="//span[contains(text(),'Update Batch Status')]")
	private WebElement updateBatchstatusButton;
	
	public AssessorDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGetTrainerDashboard()
	{
		assessorDashboardLink.click();
	}
	public void clickViewBatches()
	{
		viewBatchesButton.click();
	}
	public void clickUpdateBatchStatus()
	{
		updateBatchstatusButton.click();
	}

}
