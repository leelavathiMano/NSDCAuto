package com.nsdc.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentAgencyDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="(//strong[contains(text(),'Assessment Requests')])[1]")
	private WebElement batchAssessmentRequestsCardText;
	@FindBy(xpath="(//strong[contains(text(),'Link Assessor')])[1]")
	private WebElement linkAssessorsCardText;
	@FindBy(xpath="//strong[contains(text(),'Assessment Requests')]")
	private WebElement assessmentRequestsButton;
	
	public AssessmentAgencyDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickBatchAssessmentRequests()
	{
		WebDriverWait wait=new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(batchAssessmentRequestsCardText));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", batchAssessmentRequestsCardText);
	}
	public void clickLinksAssessors()
	{
		linkAssessorsCardText.click();
	}
	public void clickOnAssessmentRequest() 
	{
		assessmentRequestsButton.click();
	}
}