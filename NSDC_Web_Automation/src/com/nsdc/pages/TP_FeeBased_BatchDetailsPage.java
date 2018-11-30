package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_BatchDetailsPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Enter Batch Name']")
	private WebElement batchNmeTextbox;
	@FindBy(xpath="//input[@formcontrolname='batchSize']")
	private WebElement batchSizeTextbox;
	@FindBy(xpath="(//input[@placeholder='Start Date'])[1]")
	private WebElement startDate_BatchDurationTextbox;
	@FindBy(xpath="(//input[@placeholder='End Date'])[1]")
	private WebElement endDate_BatchDurationTextbox;
	@FindBy(xpath="//select[@formcontrolname='batchType']")
	private WebElement batchTypeDropDownList;
	@FindBy(xpath="//select[@formcontrolname='courseId']")
	private WebElement courseNameDropDownList;
	@FindBy(xpath="//input[@placeholder='Sector']")
	private WebElement sectorTextbox;
	@FindBy(xpath="//input[@formcontrolname='qpCode']")
	private WebElement associatedQPTextbox;
	@FindBy(xpath="//input[@formcontrolname='nsqfLevel']")
	private WebElement nsqfLevelTextbox;
	@FindBy(xpath="//select[@formcontrolname='userName']")
	private WebElement trainerNameDropDownList;
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="//input[@formcontrolname='mobile']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath="(//input[@placeholder='Start Date'])[2]")
	private WebElement startDate_TrainingDurationTextbox;
	@FindBy(xpath="(//input[@placeholder='End Date'])[2]")
	private WebElement endDate_TrainingDurationTextbox;
	@FindBy(xpath="(//input[@placeholder='Start Date'])[3]")
	private WebElement startDate_AssessmentDurationTextbox;
	@FindBy(xpath="(//input[@placeholder='End Date'])[3]")
	private WebElement endDate_AssessmentDurationTextbox;
	@FindBy(xpath="//select[@formcontrolname='assessmentMode']")
	private WebElement assessmentModeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='trainingFee']")
	private WebElement trainingFeeTextbox;
	@FindBy(xpath="//select[@formcontrolname='feePaidBy']")
	private WebElement feePaidByDropDownList;
	@FindBy(xpath="//button[text()='Save & Submit Batch']")
	private WebElement saveAndSubmitBatchButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'Yes Create Batch')]")
	private WebElement yesCreateBatchButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancel_CreateBatchButton;
	@FindBy(xpath="//button[contains(text(),'Enroll Candidate')]")
	private WebElement enrollCandidatesButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancel_EnrollCandidatesButton;
	
	public TP_FeeBased_BatchDetailsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterBatchName(String batchName)
	{
		batchNmeTextbox.clear();
		batchNmeTextbox.sendKeys(batchName);
	}
	
	public void enterBatchSize(String batchSize)
	{
		batchSizeTextbox.clear();
		batchSizeTextbox.sendKeys(batchSize);
	}
	
	public void clickOnStartDate_BatchDuration()throws Exception
	{
		startDate_BatchDurationTextbox.click();
		Thread.sleep(3000);
		startDate_BatchDurationTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDate_BatchDuration()throws Exception
	{
		Thread.sleep(3000);
		endDate_BatchDurationTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropDownList, batchType);
	}
	
	public void selectCourseName(String courseName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(courseNameDropDownList, courseName);
	}
	
	public void enterSector(String sector)
	{
		sectorTextbox.clear();
		sectorTextbox.sendKeys(sector);
	}
	
	public void enterAssociatedQP(String associatedQP)
	{
		associatedQPTextbox.clear();
		associatedQPTextbox.sendKeys(associatedQP);
	}
	
	public void enterNSQFLevel(String nsqfLevel)
	{
		nsqfLevelTextbox.clear();
		nsqfLevelTextbox.sendKeys(nsqfLevel);
	}
	
	public void selectTrainerName(String trainerName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainerNameDropDownList, trainerName);
	}
	
	public void enterEmailAddress(String email)
	{
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys(email);
	}
	
	public void enterMobileNumber(String moboileNumber)
	{
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(moboileNumber);
	}
	
	public void clickOnStartDate_TrainingDuration()throws Exception
	{
		startDate_TrainingDurationTextbox.click();
		Thread.sleep(3000);
		startDate_TrainingDurationTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDate_TrainingDuration()throws Exception
	{
		Thread.sleep(5000);
		endDate_TrainingDurationTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnStartDate_AssessmentDuration()throws Exception
	{
		Thread.sleep(3000);
		startDate_AssessmentDurationTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDate_AssessmentDuration()throws Exception
	{
		Thread.sleep(3000);
		endDate_AssessmentDurationTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void selectAssessmentMode(String assessmentMode)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assessmentModeDropDownList, assessmentMode);
	}
	
	public void enterTrainingFee(String trainingFee)
	{
		trainingFeeTextbox.clear();
		trainingFeeTextbox.sendKeys(trainingFee);
	}
	
	public void selectFeePaidBy(String feePaidBy)
	{
		SelectDropDownList.selectDropDownListByVisibleText(feePaidByDropDownList, feePaidBy);
	}
	
	public void clickOnSaveAndSubmitBatch()
	{
		saveAndSubmitBatchButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnYesCreateBatch()
	{
		yesCreateBatchButton.click();
	}
	
	public void clickOnCancel_CreateBatch()
	{
		cancel_CreateBatchButton.click();
	}
	
	public void clickOnEnrollCandidates()
	{
		enrollCandidatesButton.click();
	}
	
	public void clickOnCancel_EnrollCandidates()
	{
		cancel_EnrollCandidatesButton.click();
	}

}
