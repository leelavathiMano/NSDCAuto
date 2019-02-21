package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerViewBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Requests")
	private WebElement pendingBatchesLink;
	@FindBy(linkText="Accepted")
	private WebElement acceptedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="//textarea[@formcontrolname='acceptComment']")
	private WebElement remarksForAcceptingBatchTextArea;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='rejectedReasons']/div")
	private WebElement rejectionReasonsList;
	@FindBy(xpath="//textarea[@formcontrolname='rejectionComment']")
	private WebElement remarksForRejectingBatchTextArea;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	private WebElement rejectionSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	//Approved Applicants
	@FindBy(linkText="Batch Details")
	private WebElement batchDetailsSectionLinkText;
	@FindBy(linkText="Approved Applicants")
	private WebElement approvedApplicantsSectionLinkText;
	//On-going Batch
	@FindBy(xpath="//input[@placeholder='Search by Batch ID']")
	private WebElement searchByBatchIDTextField;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applySearchFilterButton;
	@FindBy(linkText="Batch Attendance")
	private WebElement batchAttendanceSectionLinkText;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='jobRole']/div")
	private WebElement platformJobRoleList;
	@FindBy(name="uploadFile")
	private WebElement browseForAttendanceButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadAttendanceButton;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement browseForAttendanceSupportingDocButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement uploadAttendanceSupportDocButton;
	@FindBy(xpath="//td[contains(text(),'Delete')]")
	private WebElement deleteAttendanceSupportDocButton;
	@FindBy(xpath="//button[contains(text(),'Submit to SSC')]")
	private WebElement submitBatchAttendanceToSSCButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	private WebElement submitBatchAttendanceToSSCFinalButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
			
	public TrainerViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clicktoGoPendingBatchesSection()
	{
		pendingBatchesLink.click();
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
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void clickToSelectViewDetailsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'View Details')]")).click();
	}
	public void clickToSelectAcceptBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Accept Batch')]")).click();
	}
	public void clickToSelectRejectBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Reject Batch')]")).click();
	}
	public void clickGoBackFromBatchDetails()
	{
		goBackButton.click();
	}
	public void enterRemarksForAcceptingBatch(String remarks)
	{
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
		remarksForRejectingBatchTextArea.clear();
		remarksForRejectingBatchTextArea.sendKeys(remarksForRejectingBatch);
	}
	public void clickToSubmit()
	{
		submitButton.click();
	}
	public void clickToSubmitBatchRejection()
	{
		rejectionSubmitButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
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
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[contains(text(),'View Details')]")).click();
	}
	//On-Going Batch
	public void enterBatchIDToSearch(String batchID)
	{
		searchByBatchIDTextField.clear();
		searchByBatchIDTextField.sendKeys(batchID);
	}
	public void clickToGetSearchFilterResult()
	{
		applySearchFilterButton.click();
	}
	public void clickToSelectUploadAttendanceOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Upload Attendance')]")).click();
	}
	public void clickToGoToBatchAttendanceSection()
	{
		batchAttendanceSectionLinkText.click();
	}
	public void selectplatformJobRole(String platformJobRole)
	{
		platformJobRoleList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+platformJobRole+"')]")).click();
	}
	public void clickToBrowseForAttendanceFile()
	{
		browseForAttendanceButton.click();
	}
	public void clickToUploadChoosedAttendanceFile()
	{
		uploadAttendanceButton.click();
	}
	//
	public void clickToBrowseForAttendanceSupportFile()
	{
		browseForAttendanceSupportingDocButton.click();
	}
	public void clickToUploadChoosedAttendanceSupportFile()
	{
		uploadAttendanceSupportDocButton.click();
	}
	public void clickToDeleteUploadedAttendanceSupportDoc()
	{
		deleteAttendanceSupportDocButton.click();
	}
	public void clickToSubmitBatchAttendanceToSSC()
	{
		submitBatchAttendanceToSSCButton.click();
	}
	public void clickToFinallySubmitBatchAttendanceToSSC()
	{
		submitBatchAttendanceToSSCFinalButton.click();
	}
	public void clickToCancel()
	{
		cancelButton.click();
	}
}
