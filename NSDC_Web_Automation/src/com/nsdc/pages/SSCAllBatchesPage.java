package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSCAllBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Batches")
	private WebElement  pendingBatchesSectionLink;
	@FindBy(linkText="Published Batches")
	private WebElement publishedBatchesSectionLink;
	@FindBy(xpath="//input[@placeholder='Search by Batch ID']")
	private WebElement searchByBatchIDTextField;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applySearchFiltersButton;
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
	//Reschedule
	@FindBy(xpath="(//button[contains(text(),'Reject Request')])[1]")
	private WebElement rejectBatchRescheduleRequestButton;
	@FindBy(xpath="(//button[contains(text(),'Approve Request')])[1]")
	private WebElement approveBatchRescheduleRequestButton;
	//cancellation
	@FindBy(xpath="(//button[contains(text(),'Reject Request')])[2]")
	private WebElement rejectBatchCancellationRequestButton;
	@FindBy(xpath="(//button[contains(text(),'Approve Request')])[2]")
	private WebElement approveBatchCancellationRequestButton;
	
	
	public SSCAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void clickToViewAllPendingBatches()
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Pending Batches")));
		pendingBatchesSectionLink.click();
	}
	public void clickToViewAllPublishedBatches()
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Published Batches")));
		publishedBatchesSectionLink.click();
	}
	public void enterBatchIDToSearch(String batchID)
	{
		searchByBatchIDTextField.clear();
		searchByBatchIDTextField.sendKeys(batchID);
	}
	public void clickToGetSearchResult()
	{
		applySearchFiltersButton.click();
	}
	public void clickToGetBatchActionMenu(String batchID)
	{
		driver.findElement(By.xpath("(//tr[td[1][contains(text(),'"+batchID+"')]]//a)[1]")).click();
	}
	public void selectViewDetailsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'View Details')]")).click();	
	}
	public void selectApproveApplicantsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'Approve Applicants')]")).click();
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
	//Batch Reschedule
	public void selectApproveOrRejectRescheduleRequestOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'Approve/ Reject Reschedule Request')]")).click();
	}
	public void clickToRejectBatchRescheduleRequest()
	{
		rejectBatchRescheduleRequestButton.click();
	}
	public void clickToApproveBatchRescheduleRequest()
	{
		approveBatchRescheduleRequestButton.click();
	}
	//Batch Cancellation
	public void selectApproveOrRejectCancellationRequestOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'Approve/ Reject Cancellation Request')]")).click();
	}
	public void clickToRejectBatchCancellationRequest()
	{
		rejectBatchCancellationRequestButton.click();
	}
	public void clickToApproveBatchCancellationRequest()
	{
		approveBatchCancellationRequestButton.click();
	}
}