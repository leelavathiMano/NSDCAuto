package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentAgency_BatchIDPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Batch Details')]")
	private WebElement batchDetailsButton;
	@FindBy(xpath="//a[contains(text(),'Enrolled Candidates Details(Marksheet & Certification)')]")
	private WebElement enrolledCandidatesDetailsButton;
	@FindBy(xpath="//input[@placeholder='Search by ID']")
	private WebElement searchByIDTextbox;
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;
	@FindBy(xpath="//button[contains(text(),'All Marksheet for the Batch Approval')]")
	private WebElement allMarksheetForBatchApprovalButton;
	//@FindBy(linkText="Accept Batch Marksheet")
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[1]")
	private WebElement acceptBatchMarksheetRadioButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[2]")
	private WebElement rejectBatchMarksheetButton;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[1]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	
	
	public AssessmentAgency_BatchIDPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnBatchDetails()
	{
		batchDetailsButton.click();
	}
	
	public void clickOnEnrolledCandidatesDetails()
	{
		enrolledCandidatesDetailsButton.click();
	}
	
	public void enterSearchByID(String id)
	{
		searchByIDTextbox.clear();
		searchByIDTextbox.sendKeys(id);
	}
	
	public void clickOnSearch()
	{
		searchButton.click();
	}
	
	public void clickOnAllMarksheetForBatchApproval()
	{
		allMarksheetForBatchApprovalButton.click();
	}
	
	public void clickOnAcceptBatchMarksheet()
	{
		acceptBatchMarksheetRadioButton.click();
	}
	
	public void clickOnRejectBatchMarksheet()
	{
		rejectBatchMarksheetButton.click();
	}
	
	public void clickOnSaveAndSubmit()
	{
		saveAndSubmitButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}

}
