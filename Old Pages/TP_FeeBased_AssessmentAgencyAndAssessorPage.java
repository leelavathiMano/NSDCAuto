package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_AssessmentAgencyAndAssessorPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="(//button[@class='btn m-btn--pill btn-primary'])[1]")
	private WebElement addAssessmentAgencyButton;
	@FindBy(xpath="(//button[@class='btn m-btn--pill btn-primary'])[2]")
	private WebElement linkAssessorButton;
	@FindBy(xpath="//a[contains(text(),'Added Assessment Agencies')]")
	private WebElement addedAssessmentAgenciesButton;
	@FindBy(xpath="//a[contains(text(),'Linked Assessor')]")
	private WebElement linkedAssessorButton;
	@FindBy(id="assessmentAgencyId")
	private WebElement assessmentIdSearchTextbox;
	@FindBy(id="assessorId")
	private WebElement assessorSDMSIDTextbox;
	@FindBy(id="nameOfAssessor")
	private WebElement assessorNameTextbox;
	@FindBy(id="assessmentAgencyAligned")
	private WebElement assessmentAgencyAlignedDropDownList;
	@FindBy(xpath="//input[@placeholder='Select From Date:']")
	private WebElement startDateTexbox;
	@FindBy(xpath="//input[@placeholder='Select To Date:']")
	private WebElement endDateTextbox;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement supportingDocument_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement supportingDocument_UploadButton;
	@FindBy(xpath="//button[contains(text(),'Generate OTP')]")
	private WebElement generateOTPButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton;
	@FindBy(id="mobileOtp")
	private WebElement mobileOTPTextbox;
	@FindBy(id="emailOtp")
	private WebElement emailOTPTextbox;
	@FindBy(xpath="//button[text()='Verify OTP']")
	private WebElement verifyOTPButton;
	@FindBy(xpath="(//button[text()='Cancel'])[2]")
	private WebElement cancel_OTPButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	
	public TP_FeeBased_AssessmentAgencyAndAssessorPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnAddAssessmentAgency()
	{
		addAssessmentAgencyButton.click();
	}
	
	public void clickOnLinkAssessor()
	{
		linkAssessorButton.click();
	}
	
	public void clickOnAddedAssessmentAgencies()
	{
		addedAssessmentAgenciesButton.click();
	}
	
	public void clickOnLinkedAssessor()
	{
		linkedAssessorButton.click();
	}
	
	public void enterAssessmentAgencyID(String assessmentAgencyID)
	{
		assessmentIdSearchTextbox.clear();
		assessmentIdSearchTextbox.sendKeys(assessmentAgencyID);
	}
	
	public void enterAssessorSDMSID(String assessorID)
	{
		assessorSDMSIDTextbox.clear();
		assessorSDMSIDTextbox.sendKeys(assessorID);
	}
	
	public void enterAssessorName(String assessorName)
	{
		assessorNameTextbox.clear();
		assessorNameTextbox.sendKeys(assessorName);
	}
	
	public void selectAssessmentAgencyAligned(String assessmentAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assessmentAgencyAlignedDropDownList, assessmentAgency);
	}
	
	public void clickOnStartDateForValidity()
	{
		startDateTexbox.click();
		startDateTexbox.sendKeys(Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDateForValidity()
	{
		endDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnSupportingDocument_BrowseFile()
	{
		supportingDocument_BrowseFileButton.click();
	}
	
	public void clickOnSupportingDocument_UploadFile()
	{
		supportingDocument_UploadButton.click();
	}
	
	public void clickOnGenerateOTP()
	{
		generateOTPButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void enterMobileOTP(String mobileOTP)
	{
		mobileOTPTextbox.clear();
		mobileOTPTextbox.sendKeys(mobileOTP);
	}
	
	public void enterEmailOTP(String emailOTP)
	{
		emailOTPTextbox.clear();
		emailOTPTextbox.sendKeys(emailOTP);
		
	}
	
	public void clickOnVerifyOTP()
	{
		verifyOTPButton.click();
	}
	
	public void clickOnCancel_OTP()
	{
		cancel_OTPButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}

}
