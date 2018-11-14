package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSCAllBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Batches")
	private WebElement  pendingBatchesSectionLink;
	@FindBy(linkText="Published Batches")
	private WebElement publishedBatchesSectionLink;
	//Verifying Applied Trainer Batch applicants from SSC End after TC Approval
	@FindBy(xpath="//*[text()='Batch Details']")
	private WebElement batchDetailsSectionLink;
	@FindBy(xpath="//*[text()='Enrolled Candidates']")
	private WebElement enrolledCandidatesSectionLink;
	@FindBy(xpath="//*[contains(text(),'Approved Candidates')]")
	private WebElement approvedCandidatesSectionLink;
	@FindBy(xpath="//*[contains(text(),'Applicants')]")
	private WebElement applicantsSectionLink;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	//Reschedule and cancellation
	@FindBy(xpath="(//button[contains(text(),'Reject Request')])[1]")
	private WebElement rejectBatchRescheduleRequestButton;
	@FindBy(xpath="(//button[contains(text(),'Approve Request')])[1]")
	private WebElement approveBatchRescheduleRequestButton;
	
	
	public SSCAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void clickToViewAllPendingBatches()
	{
		pendingBatchesSectionLink.click();
	}
	public void clickToViewAllPublishedBatches()
	{
		publishedBatchesSectionLink.click();
	}
	public void clickToGetBatchActionMenu(String batchID)
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+batchID+"')]]//a)[1]")).click();
	}
	public void selectViewDetailsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]//span[contains(text(),'View Details')]")).click();	
	}
	public void selectApproveApplicantsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]//span[contains(text(),'Approve Applicants')]")).click();
	}
	//Verifying Trainer Batch Applicants from SSC End
	public void clickToGoToBatchDetailsSection()
	{
		batchDetailsSectionLink.click();
	}
	public void clickToGoToEnrolledCandidatesSection()
	{
		enrolledCandidatesSectionLink.click();
	}
	public void clickToGoToApprovedCandidatesSection()
	{
		approvedCandidatesSectionLink.click();
	}
	public void clickToGoToApplicantsSection()
	{
		applicantsSectionLink.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	//Batch Reschedule and Cancellation
	public void selectApproveOrRejectRescheduleRequestOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]//span[contains(text(),'Approve/ Reject Reschedule Request')]")).click();
	}
	public void clickToRejectBatchRescheduleRequest()
	{
		rejectBatchRescheduleRequestButton.click();
	}
	public void clickToApproveBatchRescheduleRequest()
	{
		approveBatchRescheduleRequestButton.click();
	}
}	
	
	
	
	
	
	
	
