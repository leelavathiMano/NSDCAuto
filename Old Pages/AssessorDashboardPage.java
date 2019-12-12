package com.nsdc.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessorDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[2]")
	private WebElement assessorDashboardLink;
	@FindBy(xpath="//span[contains(text(),'Batch Assessment Requests')]")
	private WebElement batchAssessmentRequestsCardText;
	@FindBy(xpath="//span[contains(text(),'Update Batch Status')]")
	private WebElement updateBatchstatusButton;
	
	public AssessorDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGetAssessorDashboard()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(assessorDashboardLink));
		assessorDashboardLink.click();
	}
	public void clickBatchAssessmentRequests()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", batchAssessmentRequestsCardText);
	}
	public void clickUpdateBatchStatus()
	{
		updateBatchstatusButton.click();
	}
}