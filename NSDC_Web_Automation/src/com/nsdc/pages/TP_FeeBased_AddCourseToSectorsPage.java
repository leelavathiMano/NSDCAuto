package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_AddCourseToSectorsPage 
{
	WebDriver driver;
	
	@FindBy(id="course")
	private WebElement courseNameTextbox;
	@FindBy(id="sectorName")
	private WebElement sectorDropDownList;
	@FindBy(id="jobRoleMappingType")
	private WebElement jobRoleMappingTypeDropDownList;
	@FindBy(id="jobRoleName")
	private WebElement associateQPDropDownList;
	@FindBy(id="nsqfLevel")
	private WebElement nsqfLevelTextbox;
	@FindBy(id="description")
	private WebElement courseDescriptionTextbox;
	@FindBy(id="issuedCertificateName")
	private WebElement issuedCertificateNameTextbox;
	@FindBy(id="minimumAge")
	private WebElement minimumAgeDropDownList;
	@FindBy(id="minimumEducationRequired")
	private WebElement minimumEducationRequiredDropDownList;
	@FindBy(id="courseDurationInHours")
	private WebElement courseDurationTextbox;
	@FindBy(id="hoursPerDay")
	private WebElement numberOfHoursTextbox;
	@FindBy(id="courseFee")
	private WebElement courseFeeTextbox;
	@FindBy(id="gradingPreferences")
	private WebElement gradingPrefrencesDropDownList;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement courseApprovalDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement courseApprovalDocument_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement affiliationCertificate_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement affiliationCertificate_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement workOrder_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement workOrder_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[4]")
	private WebElement challanOfFeePaid_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[4]")
	private WebElement challanOfFeePaid_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[5]")
	private WebElement stampPaper_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[5]")
	private WebElement stampPaper_UploadFileButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	
	
	
	public TP_FeeBased_AddCourseToSectorsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCourseName(String courseName)
	{
		courseNameTextbox.clear();
		courseNameTextbox.sendKeys(courseName);
	}
	
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	}
	
	public void selectJobRoleMappingType(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleMappingTypeDropDownList, jobRole);
	}
	
	public void selectAssociatedQPOrJobRoleName(String jobRoleName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(associateQPDropDownList, jobRoleName);
	}
	
	public void enterNSQFLevel(String nsqfLevel)
	{
		nsqfLevelTextbox.clear();
		nsqfLevelTextbox.sendKeys(nsqfLevel);
	}
	
	public void enterCourseDescription(String courseDescription)
	{
		courseDescriptionTextbox.clear();
		courseDescriptionTextbox.sendKeys(courseDescription);
	}
	
	public void enterNameOfTheCertificateIssued(String certificateName)
	{
		issuedCertificateNameTextbox.clear();
		issuedCertificateNameTextbox.sendKeys(certificateName);
	}
	
	public void selectMinimumAge(String minimumAge)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumAgeDropDownList, minimumAge);
	}
	
	public void selectMinimumEducationRequired(String minimumEducation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumEducationRequiredDropDownList, minimumEducation);
	}
	
	public void enterCourseDuration(String courseDuration)
	{
		courseDurationTextbox.clear();
		courseDurationTextbox.sendKeys(courseDuration);
	}
	
	public void enterNumberOfHours(String hourPerDay)
	{
		numberOfHoursTextbox.clear();
		numberOfHoursTextbox.sendKeys(hourPerDay);
	}
	
	public void enterCourseFee(String courseFee)
	{
		courseFeeTextbox.clear();
		courseFeeTextbox.sendKeys(courseFee);
	}
	
	public void selectGradingPrefrences(String gradingPreference)
	{
		SelectDropDownList.selectDropDownListByVisibleText(gradingPrefrencesDropDownList, gradingPreference);
	}
	
	public void clickOnCourseApprovalDocument_BrowseFile()
	{
		courseApprovalDocument_BrowseFileButton.click();
	}
	
	public void clickOnCourseApprovalDocument_UploadFile()
	{
		courseApprovalDocument_UploadFileButton.click();
	}
	
	public void clickOnAffiliationCertificate_BrowseFile()
	{
		affiliationCertificate_BrowseFileButton.click();
	}
	
	public void clickOnAffiliationCertificate_UploadFile()
	{
		affiliationCertificate_UploadFileButton.click();
	}
	
	public void clickOnWorkOrder_BrowseFile()
	{
		workOrder_BrowseFileButton.click();
	}
	
	public void clickOnWorkOrder_UploadFile()
	{
		workOrder_UploadFileButton.click();
	}
	
	public void clickOnChallanOfFeePaid_BrowseFile()
	{
		challanOfFeePaid_BrowseFileButton.click();
	}
	
	public void clickOnChallanOfFeePaid_UploadFile()
	{
		challanOfFeePaid_UploadFileButton.click();
	}
	
	public void clickOnStampPaper_BrowseFile()
	{
		stampPaper_BrowseFileButton.click();
	}
	
	public void clickOnStampPaper_UploadFile()
	{
		stampPaper_UploadFileButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	
	

}
