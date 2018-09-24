package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentAgencyDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'View Batches')]")
	private WebElement viewBatchesCardText;
	@FindBy(xpath="(//span[contains(text(),'Associated Assessors')])[1]")
	private WebElement associatedAssessorsCardText;
	
	public AssessmentAgencyDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToViewBatches()
	{
		viewBatchesCardText.click();
	}
	public void clickToViewAllAssociatedAssessors()
	{
		associatedAssessorsCardText.click();
	}
}
