package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy(name="KeywordSearch")
	private WebElement searchByBatchIDTextField;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applySearchFilterButton;
	@FindBy(xpath="//button[contains(text(),'Download Template')]")
	private WebElement downloadTemplateButton;
	@FindBy(linkText="Batch Attendance")
	private WebElement batchAttendanceSectionLinkText;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='jobRole']/div")
	private WebElement jobRoleList;
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(pendingBatchesLink));
		pendingBatchesLink.click();
	}
	public void clickToGoToAcceptedBatchesSection()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accepted")));
		acceptedBatchesLink.click();
	}
	public void clickToGoToRejectedBatchesSection()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Rejected")));
		rejectedBatchesLink.click();
	}
	public void enterBatchIDToSearch(String batchID)
	{
		searchByBatchIDTextField.clear();
		searchByBatchIDTextField.sendKeys(batchID);
	}
	public void clickToGetSearchFilterResult()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(applySearchFilterButton));
		applySearchFilterButton.click();
	}
	public void clickToGetActionMenuOptions(String batchID)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")));
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
	public void clickGoBack()
	{
		goBackButton.click();
	}
	public void enterRemarksForAcceptingBatch(String remarks)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(remarksForRejectingBatchTextArea));
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(okButton));
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
	public void clickToSelectUploadAttendanceOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Upload Attendance')]")).click();
	}
	public void clickToGoToBatchAttendanceSection()
	{
		batchAttendanceSectionLinkText.click();
	}
	public void selectDomainJobRole(String domainJobRole)
	{
		jobRoleList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+domainJobRole+"')]")).click();
	}
	public void selectPlatformJobRole(String platformJobRole)
	{
		jobRoleList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+platformJobRole+"')]")).click();
	}
	public void clickToDownloadAttendanceTemplate()
	{
		downloadTemplateButton.click();
	}
	public void clickToBrowseForAttendanceFile()
	{
		browseForAttendanceButton.click();
	}
	public void clickToUploadChoosedAttendanceFile()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(uploadAttendanceButton));
		uploadAttendanceButton.click();
	}
	public void clickToBrowseForAttendanceSupportFile()
	{
		browseForAttendanceSupportingDocButton.click();
	}
	public void clickToUploadChoosedAttendanceSupportFile()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(uploadAttendanceSupportDocButton));
		uploadAttendanceSupportDocButton.click();
	}
	public void clickToDeleteUploadedAttendanceSupportDoc()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(deleteAttendanceSupportDocButton));
		deleteAttendanceSupportDocButton.click();
	}
	public void clickToSubmitBatchAttendanceToSSC()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(submitBatchAttendanceToSSCButton));
		submitBatchAttendanceToSSCButton.click();
	}
	public void clickToFinallySubmitBatchAttendanceToSSC()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(submitBatchAttendanceToSSCFinalButton));
		submitBatchAttendanceToSSCFinalButton.click();
	}
	public void clickToCancel()
	{
		cancelButton.click();
	}
}