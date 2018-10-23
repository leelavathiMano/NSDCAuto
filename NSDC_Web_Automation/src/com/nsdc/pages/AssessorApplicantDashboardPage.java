package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessorApplicantDashboardPage 
{
	WebDriver driver;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement applicantDashboardLink;
	@FindBy(xpath="//strong[contains(text(),'Search & Apply')]")
	private WebElement searchAndApplyForAvailableBatchesCardText;
	@FindBy(xpath="//strong[contains(text(),'View Batches')]")
	private WebElement viewBatchesCardText;
			
	public AssessorApplicantDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGetApplicantDashboard()
	{
		applicantDashboardLink.click();
	}
	public void clickSearchAndApplyforAvailableBatches()
	{
		searchAndApplyForAvailableBatchesCardText.click();
	}
	public void clickViewBatches()
	{
		viewBatchesCardText.click();
	}
}
