package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[span[strong[contains(text(),'My CAAF Submit')]]]")
	private WebElement myCAAFSubmitButton;
	@FindBy(xpath="//div[span[strong[contains(text(),'View Batches')]]]")
	private WebElement viewBatchesButton;
	@FindBy(xpath="//div[span[strong[contains(text(),'View Batches-New')]]]")
	private WebElement viewBatches_NewButton;
	@FindBy(xpath="//div[span[strong[contains(text(),'Associated Trainers')]]]")
	private WebElement associatedTrainerButton;
	@FindBy(xpath="//div[span[strong[contains(text(),'TC SPOC Change')]]]")
	private WebElement TCSPOCChangeButton;
	@FindBy(xpath="//div[span[strong[contains(text(),'Appeal')]]]")
	private WebElement appealButton;
	@FindBy(xpath="//div[span[strong[contains(text(),' View Applications ')]]]")
	private WebElement viewApplicationsButton;
	@FindBy(xpath="//div[span[strong[contains(text(),' Re-Inspection ')]]]")
	private WebElement reInspectionButton;
	
	
	public TC_DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMyCAAFSubmit()
	{
		myCAAFSubmitButton.click();
	}
	
	public void clickOnViewBatches()
	{
		viewBatchesButton.click();
	}
	
	public void clickOnNew_ViewBatches()
	{
		viewBatches_NewButton.click();
	}
	
	public void clickOnAssociatedTrainers()
	{
		associatedTrainerButton.click();
	}
	
	public void clickOnTCSPOCChaange()
	{
		TCSPOCChangeButton.click();
	}
	
	public void clickOnAppeal()
	{
		appealButton.click();
	}
	
	public void clickOnViewApplications()
	{
		viewApplicationsButton.click();
	}
	
	public void clickOnReInspection()
	{
		reInspectionButton.click();
	}

}
