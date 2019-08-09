package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessorViewBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Requests")
	private WebElement pendingRequestsLink;
	@FindBy(linkText="Accepted")
	private WebElement acceptedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept/Reject Batch')]")
	private WebElement acceptOrRejectBatchOption;	
	@FindBy(xpath="//button[contains(text(),'View All Batches')]")
	private WebElement viewAllBatchesButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[2]")
	private WebElement rejectBatchRadioButton;
	@FindBy(xpath="(//textarea[@name='comment'])[1]")
	private WebElement remarksForAcceptingBatchTextArea;
	@FindBy(xpath="//angular2-multiselect[@name='reason']/div")
	private WebElement rejectionReasonsList;
	@FindBy(xpath="(//textarea[@name='comment'])[2]")
	private WebElement remarksForRejectingBatchTextArea;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[1]")
	private WebElement saveAndSubmitOfAcceptBatchButton;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[2]")
	private WebElement saveAndSubmitOfRejectBatchButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	//Approved Applicants
	@FindBy(linkText="Batch Details")
	private WebElement batchDetailsSectionLinkText;
	@FindBy(linkText="Approved Applicants")
	private WebElement approvedApplicantsSectionLinkText;
	@FindBy(id="Search")
	private WebElement searchForBatchIDTextField;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applySearchFiltersButton;
	public AssessorViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clicktoGoToPendingRequestsSection()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(pendingRequestsLink));
		pendingRequestsLink.click();
	}
	public void clickToGoToAcceptedBatchesSection()
	{
		acceptedBatchesLink.click();
	}
	public void clickToGoToRejectedBatchesSection()
	{
		rejectedBatchesLink.click();
	}
	public void clickToGetActionMenuOptions(String batchID)
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")));
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void clickToSelectViewBatchDetailsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'View Batch Details')]")).click();
	}
	public void clickToSelectAcceptBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Accept Batch')]")).click();
	}
	public void clickToSelectRejectBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Reject Batch')]")).click();
	}
	public void enterRemarksForAcceptingBatch(String remarks)
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(remarksForAcceptingBatchTextArea));
		remarksForAcceptingBatchTextArea.clear();	
		remarksForAcceptingBatchTextArea.sendKeys(remarks);
	}
	public void selectReasonForRejectingBatch(String rejectionReason) throws InterruptedException
	{
		rejectionReasonsList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+rejectionReason+"')]")).click();
	}
	public void enterRemarksForRejectingBatch(String remarksForRejectingBatch)
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(remarksForRejectingBatchTextArea));
		remarksForRejectingBatchTextArea.clear();
		remarksForRejectingBatchTextArea.sendKeys(remarksForRejectingBatch);
	}
	public void clickToSaveAndSubmitBatchAccceptance()
	{
		saveAndSubmitOfAcceptBatchButton.click();
	}
	public void clickToSaveAndSubmitBatchRejection()
	{
		saveAndSubmitOfRejectBatchButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(okButton));
		okButton.click();
	}
	public void clickToGoBack()
	{
		goBackButton.click();
	}
	//After SSC Approving Batch
	public void clickToGoToBatchDetailsSection()
	{
		batchDetailsSectionLinkText.click();
	}
	public void clickToGoToApprovedApplicantsSection()
	{
		approvedApplicantsSectionLinkText.click();
	}
	public void clickToGetApplicantActionMenu(String applicnatID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicnatID+"')]]//a[i[@class='la la-ellipsis-h']]")).click();
	}
	public void selectViewDetailsOfApplicantOption(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[span[contains(text(),'View Details')]]")).click();
	}	
	public void enterBatchIDToSearch(String batchID)
	{
		searchForBatchIDTextField.clear();
		searchForBatchIDTextField.sendKeys(batchID);
	}
	public void clickToGetSearchResult()
	{
		applySearchFiltersButton.click();
	}
}