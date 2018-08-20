package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessorApplicantDashboardPage 
{
	WebDriver driver;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement applicantDashboardMenuLink;
	@FindBy(xpath="//span[contains(text(),'Search for available batches')]")
	private WebElement searchAndApplyForAvailableBatchesButton;
	@FindBy(xpath="//span[contains(text(),'View Batches')]")
	private WebElement viewBatchesButton;
			
	public AssessorApplicantDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGetApplicantDashboard()
	{
		applicantDashboardMenuLink.click();
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
