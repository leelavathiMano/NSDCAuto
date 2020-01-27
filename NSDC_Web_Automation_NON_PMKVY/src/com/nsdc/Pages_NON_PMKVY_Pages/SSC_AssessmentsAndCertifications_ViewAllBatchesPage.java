package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SSC_AssessmentsAndCertifications_ViewAllBatchesPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Pending Requests')]")
	private WebElement pendingRequestButton;
	@FindBy(xpath="//a[contains(text(),'Accepted')]")
	private WebElement acceptedButton;
	@FindBy(xpath="//a[contains(text(),'Rejected')]")
	private WebElement rejectedButton;
	@FindBy(xpath="(//select[@name='selectStatus'])[1]")
	private WebElement schemeNameDropDownList;
	@FindBy(xpath="(//select[@name='selectStatus'])[2]")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="(//select[@name='selectStatus'])[3]")
	private WebElement requestTypeDropDownList;
	@FindBy(xpath="(//select[@name='selectStatus'])[4]")
	private WebElement statusDropDownList;
	@FindBy(xpath="//input[@id='undefined']")
	private WebElement searchKeywordTextbox;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="(//input[@id='startDate'])[2]")
	private WebElement assessmentStartDateTextbox;
	@FindBy(xpath="//input[@id='endDate']")
	private WebElement assessmentEndDateTextbox;
	@FindBy(xpath="(//button[text()='Submit'])[2]")
	private WebElement submitButton;
	@FindBy(xpath="(//button[text()='Cancel'])[3]")
	private WebElement cancelButton;
	@FindBy(xpath="//select[@formcontrolname='aaId']")
	private WebElement assessmentAgencyDropDownList;
	@FindBy(xpath="(//button[text()='Submit'])[3]")
	private WebElement approveMarksheet_SubmitButton;
	@FindBy(xpath="(//button[text()='Cancel'])[6]")
	private WebElement approveMarksheet_CancelButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	
	public SSC_AssessmentsAndCertifications_ViewAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPendingRequest()
	{
		pendingRequestButton.click();
	}
	
	public void clickOnAccepted()
	{
		acceptedButton.click();
	}
	
	public void clickOnRejected()
	{
		rejectedButton.click();
	}
	
	public void selectSchemeName(String schemeName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(schemeNameDropDownList, schemeName);
	}
	
	public void selectJobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropDownList, jobRole);
	}
	
	public void selectRequestType(String requestType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(requestTypeDropDownList, requestType);
	}
	
	public void selectStatus(String status)
	{
		SelectDropDownList.selectDropDownListByVisibleText(statusDropDownList, status);
	}
	
	public void enterSearhKeyWord(String keyword)
	{
		searchKeywordTextbox.clear();
		searchKeywordTextbox.sendKeys(keyword);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnAssessment_StartDate()
	{
		assessmentStartDateTextbox.click();
		assessmentStartDateTextbox.sendKeys(Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnAssessment_EndDate()
	{
		assessmentEndDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void selectAssessmentAgency(String assessmentAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assessmentAgencyDropDownList, assessmentAgency);
	}
	
	public void clickOnSubmit_ApproveMarksheet()
	{
		approveMarksheet_SubmitButton.click();
	}
	
	public void clickOnCancel_ApproveMarksheet()
	{
		approveMarksheet_CancelButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}

}
