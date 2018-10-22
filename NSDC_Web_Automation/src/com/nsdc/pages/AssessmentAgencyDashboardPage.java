package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentAgencyDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="(//strong[contains(text(),'Assessment Requests')])[1]")
	private WebElement batchAssessmentRequestsCardText;
	@FindBy(xpath="(//strong[contains(text(),'Link Assessor')])[1]")
	private WebElement linkAssessorsCardText;
	
	public AssessmentAgencyDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickBatchAssessmentRequests()
	{
		batchAssessmentRequestsCardText.click();
	}
	public void clickLinksAssessors()
	{
		linkAssessorsCardText.click();
	}
}
