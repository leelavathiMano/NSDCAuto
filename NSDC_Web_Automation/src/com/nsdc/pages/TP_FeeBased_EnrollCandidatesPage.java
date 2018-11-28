package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_EnrollCandidatesPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Edit Batch Details')]")
	private WebElement editBatchDetailsButton;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backbutton;
	@FindBy(xpath="//button[contains(text(),'Enroll Candidates')]")
	private WebElement enrollCandidateButton;
	@FindBy(xpath="//a[contains(text(),'Download Template')]")
	private WebElement downloadTemplateButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadCandidateListButton;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement candidateList_BrowseFileButton;
	@FindBy(xpath="(//button[text()='Submit'])[1]")
	private WebElement submitButton;
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'Re-Upload Candidate Sheet')]")
	private WebElement reUploadCandidateListButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadDetailsButton;
	@FindBy(xpath="//span[text()='attendance']")
	private WebElement attendanceButton;
	@FindBy(xpath="//select[@formcontrolname='assessmentMode']")
	private WebElement selectModeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='assessmentAgencyUserName']")
	private WebElement assessmentAgencyDropDownList;
	@FindBy(xpath="//select[@formcontrolname='assessorUserName']")
	private WebElement assessorDropDownList;
	@FindBy(xpath="(//button[text()='Submit'])[2]")
	private WebElement submit_AssessmentDetailButton;
	@FindBy(xpath="(//button[text()='Close'])[2]")
	private WebElement close_AssessmentDetailsButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement action_FirstCandidateButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[2]")
	private WebElement action_SecondCandidateButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[3]")
	private WebElement action_ThirdCandidateButton;
	@FindBy(xpath="(//a[text()='Upload Certificate'])[1]")
	private WebElement uploadCertificate_FirstCandidateButton;
	@FindBy(xpath="(//a[text()='Upload Certificate'])[2]")
	private WebElement uploadCertificate_SecondCandidateButton;
	@FindBy(xpath="(//a[text()='Upload Certificate'])[3]")
	private WebElement uploadCertificate_ThirdCandidateButton;
	@FindBy(xpath="//label[input[@formcontrolname='typeOfDocument']]/span")
	private WebElement certificateRadioButton;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement certificate_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement certificate_UploadFileButton;
	@FindBy(xpath="(//button[text()='Submit'])[3]")
	private WebElement submit_CandidateCertificateButton;
	@FindBy(xpath="(//button[text()='Close'])[3]")
	private WebElement cancel_CandidateCertificateButton;
	@FindBy(xpath="(//a[contains(text(),'Upload Placement')])[1]")
	private WebElement placementDocument_FirstCandidateButton;
	@FindBy(xpath="(//a[contains(text(),'Upload Placement')])[2]")
	private WebElement placementDocument_SecondCandidateButton;
	@FindBy(xpath="(//a[contains(text(),'Upload Placement')])[3]")
	private WebElement placementDocument_ThirdCandidateButton;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement placementDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement placementDocument_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[4]")
	private WebElement appointmentLetter_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement appointmentLetter_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[5]")
	private WebElement salarySlip_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[4]")
	private WebElement salarySlip_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[6]")
	private WebElement undertakingDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[5]")
	private WebElement undertakingDocument_UploadFileButton;
	@FindBy(xpath="(//button[text()='Submit'])[4]")
	private WebElement submit_PlacementDocumentButton;
	@FindBy(xpath="(//button[text()='Close'])[4]")
	private WebElement close_PlacementDocumentButton;
	@FindBy(xpath="//button[contains(text(),'Submit For Assessment')]")
	private WebElement submitForAssessmentButton;
	
	public TP_FeeBased_EnrollCandidatesPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnEditBatchDetails()
	{
		editBatchDetailsButton.click();
	}
	
	public void clickOnBack()throws Exception
	{
		Thread.sleep(10000);
		backbutton.click();
	}
	
	public void clickOnEnrollCandidates()throws Exception
	{
		Thread.sleep(3000);
		enrollCandidateButton.click();
	}
	
	public void clickOnDownloadTemplate()
	{
		downloadTemplateButton.click();
	}
	
	public void clickOnUploadCandidateList()
	{
		uploadCandidateListButton.click();
	}
	
	public void clickOnCandidateList_BrowseFile()
	{
		candidateList_BrowseFileButton.click();
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		closeButton.click();
	}
	
	public void clickOnReUploadCandidateList()
	{
		reUploadCandidateListButton.click();
	}
	
	public void clickOnUploadDetails()
	{
		uploadDetailsButton.click();
	}
	
	public void clickOnAttendence()
	{
		attendanceButton.click();
	}
	
	public void selectAssessmentMode(String assessmentMode)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectModeDropDownList, assessmentMode);
	}
	
	public void selectAssessmentAgencyName(String assessmentAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assessmentAgencyDropDownList, assessmentAgency);
	}
	
	public void selectAssessor(String assessor)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assessorDropDownList, assessor);
	}
	
	public void clickOnSubmit_AssessmentDetails()
	{
		submit_AssessmentDetailButton.click();
	}
	
	public void clickOnClose_AssessmentDetails()
	{
		close_AssessmentDetailsButton.click();
	}
	
	public void clickOnAction_FirstCandidate()
	{
		action_FirstCandidateButton.click();
	}
	
	public void clickOnAction_SecondCandidate()
	{
		action_SecondCandidateButton.click();
	}
	
	public void clickOnAction_ThirdCandidate()
	{
		action_ThirdCandidateButton.click();
	}
	
	public void clickOnUploadCertificate_FirstCandidate()
	{
		uploadCertificate_FirstCandidateButton.click();
	}
	
	public void clickOnUploadCertificate_SecondCandidate()
	{
		uploadCertificate_SecondCandidateButton.click();
	}
	
	public void clickOnUploadCertificate_ThirdCandidate()
	{
		uploadCertificate_ThirdCandidateButton.click();
	}
	
	public void clickOnCertificate()
	{
		certificateRadioButton.click();
	}
	
	public void clickOnCertificate_BrowseFile()
	{
		certificate_BrowseFileButton.click();
	}
	
	public void clickOnCertificate_UploadFile()
	{
		certificate_UploadFileButton.click();
	}
	
	public void clickOnSubmit_CandidateCertificate()
	{
		submit_CandidateCertificateButton.click();
	}
	
	public void clickOnCancel_CandidateCertificate()
	{
		cancel_CandidateCertificateButton.click();
	}
	
	public void clickOnUploadPlacementDocument_FirstCandidate()
	{
		placementDocument_FirstCandidateButton.click();
	}
	
	public void clickOnUploadPlacementDocument_SecondCandidate()
	{
		placementDocument_SecondCandidateButton.click();
	}
	
	public void clickOnUploadPlacementDocument_ThirdCandidate()
	{
		placementDocument_ThirdCandidateButton.click();
	}
	
	public void clickOnPlacementDocument_BrowseFile()
	{
		placementDocument_BrowseFileButton.click();
	}
	
	public void clickOnPlacementDocument_UploadFile()
	{
		placementDocument_UploadFileButton.click();
	}
	
	public void clickOnAppointmentLetter_BrowseFile()
	{
		appointmentLetter_BrowseFileButton.click();
	}
	
	public void clickOnAppointmentLetter_UploadFile()
	{
		appointmentLetter_UploadFileButton.click();
	}
	
	public void clickOnSalarySlip_BrowseFile()
	{
		salarySlip_BrowseFileButton.click();
	}
	
	public void clickOnSalarySlip_UploadFile()
	{
		salarySlip_UploadFileButton.click();
	}
	
	public void clickOnUndertakingDocument_BrowseFile()
	{
		undertakingDocument_BrowseFileButton.click();
	}
	
	public void clickOnUndertakingDocument_UploadFile()
	{
		undertakingDocument_UploadFileButton.click();
	}
	
	public void clickOnSubmit_PlacementDocument()
	{
		submit_PlacementDocumentButton.click();
	}
	
	public void clickOnClose_PlacementDocument()
	{
		close_PlacementDocumentButton.click();
	}
	
	public void clickOnSubmitForAssessment()
	{
		submitForAssessmentButton.click();
	}

}
