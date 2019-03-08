package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class LocationBasedTC_ViewBatchesPage
{
	WebDriver driver;
	@FindBy(xpath="//span[@class='m-menu__link-text']")
	private WebElement totToAToMTToMALink;
	@FindBy(linkText="Pending Requests")
	private WebElement PendingRequestsLink;
	@FindBy(linkText="Accepted")
	private WebElement acceptedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
	@FindBy(id="Search")
	private WebElement searchForBatchIDTextfield;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applySearchfilterButton;
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement actionMenuLink;
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept Batch')]")
	private WebElement acceptBatchOption;
	@FindBy(xpath="//span[contains(text(),'Reject Batch')]")
	private WebElement rejectBatchOption;
	@FindBy(xpath="(//textarea[@formcontrolname='remarks'])[2]")
	private WebElement remarksForAcceptingBatchTextArea;
	@FindBy(xpath="(//textarea[@formcontrolname='remarks'])[1]")
	private WebElement remarksForRejectingBatchTextArea;
	@FindBy(xpath="//select[@formcontrolname='reason']")
	private WebElement reasonsForRejectingBatchDropdownList;
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement saveAndSubmitOfRejectionButton;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[2]")
	private WebElement saveAndSubmitOfAcceptanceButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	//view batch details option resulted page
	@FindBy(linkText="Batch Details")
	private WebElement batchDetailsSectionLink;
	@FindBy(linkText="Enrolled Applicants")
	private WebElement enrolledApplicantsSectionLink;
	@FindBy(linkText="Applied Applicants")
	private WebElement appliedApplicantsSectionLink;
	@FindBy(xpath="//button[contains(text(),'Enroll Selected Applicants')]")
	private WebElement enrollSelectedApplicantsButton;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	private WebElement yesButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="//button[contains(text(),'Send Batch')]")
	private WebElement sendBatchForApprovalButton;
	//Applicants Rejection
	@FindBy(xpath="//angular2-multiselect[@name='reason']/div")
	private WebElement reasonsForRejectingApplicantList;
	@FindBy(xpath="//textarea[@name='remarks']")
	private WebElement remarksForRejectingApplicantTextArea;
	@FindBy(xpath="(//button[contains(text(),'Reject Candidate')])[2]")
	private WebElement rejectApplicantButton;
	//Reschedule Elements
	@FindBy(id="customFile")
	private WebElement batchRescheduleSupportingDocumentBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement batchRescheduleSupportingDocumentUploadButton;
	@FindBy(xpath="(//textarea[@formcontrolname='comments'])[1]")
	private WebElement batchRescheduleCommentsTextArea;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[3]")
	private WebElement batchRescheduleSubmitButton;
	//Cancellation Elements
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement batchCancellationSupportingDocumentBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement batchCancellationSupportingDocumentUploadButton;
	@FindBy(xpath="(//textarea[@formcontrolname='comments'])[2]")
	private WebElement batchCancellationCommentsTextArea;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[4]")
	private WebElement batchCancellationSubmitButton;
				
	public LocationBasedTC_ViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterToSearchForBatchID(String batchID) throws InterruptedException
	{
		searchForBatchIDTextfield.clear();
		Thread.sleep(2000);
		searchForBatchIDTextfield.sendKeys(batchID);
	}
	public void clickToGetSearchResult()
	{
		applySearchfilterButton.click();
	}
	public void clikToGetBatchActionMenu(String batchID)
	{
		//actionMenu.click();
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void selectViewBatchDetailsOption(String batchID)
	{
		//viewBatchDetailsOption.click();
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a/span[contains(text(),'View Batch Details')]")).click();
	}
	public void selectAcceptBatchOption(String batchID)
	{
		//acceptOrRejectBatchOption.click();
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a/span[contains(text(),'Accept')]")).click();
	}
	public void selectRejectBatchOption(String batchID)
	{
		//acceptOrRejectBatchOption.click();
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a/span[contains(text(),'Reject')]")).click();
	}
	public void selectRaiseRescheduleRequestOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a/span[contains(text(),'Raise Reschedule Request')]")).click();
	}
	public void selectRaiseCancellationRequest(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a/span[contains(text(),'Raise Cancellation Request')]")).click();
	}
	public void selectEnrollApplicantsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a//span[contains(text(),'Enroll Applicants')]")).click();
	}
	public void selectReEnrollApplicantsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a//span[contains(text(),'Re-Enroll Applicants')]")).click();
	}
	public void clickToGoToDashboard()
	{
		totToAToMTToMALink.click();
	}
	public void enterRemarksForAcceptingBatch(String remarksForAcceptingBatch)
	{
		remarksForAcceptingBatchTextArea.clear();
		remarksForAcceptingBatchTextArea.sendKeys(remarksForAcceptingBatch);
	}
	public void selectReasonForRejectingBatch(String reasonForRejectingBatch)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reasonsForRejectingBatchDropdownList, reasonForRejectingBatch);
	}
	public void enterRemarksForRejectingBatch(String remarksForRejectingBatch)
	{
		remarksForRejectingBatchTextArea.clear();
		remarksForRejectingBatchTextArea.sendKeys(remarksForRejectingBatch);
	}
	public void clickToAcceptBatch()
	{
		saveAndSubmitOfAcceptanceButton.click();
	}
	public void clickToRejectBatch()
	{
		saveAndSubmitOfRejectionButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	public void clickToViewAllAcceptedBatches()
	{
		acceptedBatchesLink.click();
	}
	public void clickToViewAllRejectedBatches()
	{
		rejectedBatchesLink.click();
	}
	public void clickToGoToBatchDetailsSection()
	{
		batchDetailsSectionLink.click();
	}
	public void clickToGoToEnrolledApplicantsSection()
	{
		enrolledApplicantsSectionLink.click();
	}
	public void clickToGoToAppliedApplicantsSection()
	{
		appliedApplicantsSectionLink.click();
	}
	//Applied Candidates Section
	public void clickToGetApplicantActionMenu(String createdAssessorID)
	{
		driver.findElement(By.xpath("(//tr[td[text()='"+createdAssessorID+"']]//a)[1]")).click();
	}
	public void selectViewDetailsOfApplicantOption(String createdAssessorID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]//a[contains(text(),'View Details')]")).click();
	}
	public void selectEnrollApplicantOption(String createdAssessorID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]//a[contains(text(),'Enroll Applicant')]")).click();
	}
	public void selectRejectApplicantOption(String createdAssessorID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]//a[contains(text(),'Reject Applicant')]")).click();
	}
	public void clickToSelectApplicantToBeEnrolled(String createdAssessorID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+createdAssessorID+"']]//label[input[@name='Checkbox']]/span")).click();
	}
	public void clickToEnrollAllSelectedApplicants()
	{
		enrollSelectedApplicantsButton.click();
	}
	public void clickToFinallyEnrollSelectedApplicants()
	{
		yesButton.click();
	}
	public void selectReasonForRejectingApplicant() throws InterruptedException
	{
		reasonsForRejectingApplicantList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Other')]")).click();
	}
	public void enterRemarksForRejectingApplicant()
	{
		remarksForRejectingApplicantTextArea.sendKeys("TC Rejecting this Applicant");
	}
	public void clickToRejectApplicant()
	{
		rejectApplicantButton.click();
	}
	public void clickGoBack()
	{
		goBackButton.click();
	}
	public void clickToSendBatchForApproval()
	{
		sendBatchForApprovalButton.click();
	}
	//Batch Reschedule
	public void clickToBrowseForBatchRescheduleSupportingDocument()
	{
		batchRescheduleSupportingDocumentBrowseButton.click();
	}
	public void clickToUploadBatchRescheduleSupportingDocument()
	{
		batchRescheduleSupportingDocumentUploadButton.click();
	}
	public void enterCommentsForBatchReschedule(String batchRescheduleComments)
	{
		batchRescheduleCommentsTextArea.clear();
		batchRescheduleCommentsTextArea.sendKeys(batchRescheduleComments);
	}
	public void clickToSubmitBatchreschedule()
	{
		batchRescheduleSubmitButton.click();
	}
	//Batch Cancellation
	public void clickToBrowseForBatchCancellationSupportingDocument()
	{
		batchCancellationSupportingDocumentBrowseButton.click();
	}
	public void clickToUploadBatchCancellationSupportingDocument()
	{
		batchCancellationSupportingDocumentUploadButton.click();
	}
	public void enterCommentsForBatchCancellation(String batchCancellationComments)
	{
		batchCancellationCommentsTextArea.clear();
		batchCancellationCommentsTextArea.sendKeys(batchCancellationComments);
	}
	public void clickToSubmitBatchCancellation()
	{
		batchCancellationSubmitButton.click();
	}
}