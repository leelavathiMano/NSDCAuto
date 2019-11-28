package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Key;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class TP_FeeBased_ViewAllTrainersPage 
{
	
	WebDriver driver;
	
	@FindBy(id="trainersId")
	private WebElement searchTrainerIDTextbox;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="//button[contains(text(),'Link New Trainer')]")
	private WebElement linkNewTrainerButton;
	@FindBy(xpath="//input[@placeholder='Enter Trainer SDMS ID']")
	private WebElement trainerSDMSIDTextbox;
	@FindBy(xpath="//input[@id='nameOfTheTrainer']")
	private WebElement trainerNameTextbox;
	@FindBy(xpath="//input[@formcontrolname='associatedTrainingCentre']")
	private WebElement associatedTrainingCentreTextBox;
	@FindBy(xpath="//input[@name='fromDate']")
	private WebElement startDateTextbox;
	
	@FindBy(xpath="(//select[@class='custom-select'])[1]")
	private WebElement monthDropdownList;
	
	@FindBy(xpath="//select[@class='custom-select'][2]")
	private WebElement yearDropdownList;
	
	
	
	
	
	
	
	
	@FindBy(xpath="//input[@name='toDate']")
	private WebElement endDateTextbox;
	@FindBy(xpath="//label[contains(text(),'Supporting Document:')]/..//input[@id='customFile']")
	private WebElement supportingDocument_BrowseFileButton;
	@FindBy(xpath="//label[contains(text(),'Supporting Document:')]/..//button[contains(text(),'Upload')]")
	private WebElement supportingDocument_UploadFileButton;
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
	private WebElement cancelOTPButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	public TP_FeeBased_ViewAllTrainersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTrainerID(String trainerID)
	{
		searchTrainerIDTextbox.clear();
		searchTrainerIDTextbox.sendKeys(trainerID);
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnLinkNewTrainer()
	{
		linkNewTrainerButton.click();
	}
	
	public void enterTrainerSDMSID(String trainerSDMSID)
	{
		trainerSDMSIDTextbox.clear();
		trainerSDMSIDTextbox.sendKeys(trainerSDMSID);
	}
	
	public void enterTrainerName(String trainerName)
	{
		trainerNameTextbox.clear();
		trainerNameTextbox.sendKeys(trainerName);
		trainerNameTextbox.sendKeys(Key.TAB);
	}
	
	public void EnterAssociatedTrainingCentreName(String tcName)
	{
		//SelectDropDownList.selectDropDownListByVisibleText(associatedTrainingCentreTextBox, tcName);
		
		associatedTrainingCentreTextBox.sendKeys(tcName);
		
	}
	
	public void ClickStartDate() throws InterruptedException
	{
		Thread.sleep(2000);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(BatchStartDate).click().build().perform();
		startDateTextbox.click();
	}

	public void SelectBatchStartDate(String StartDate) throws InterruptedException {
		Thread.sleep(2000);
		ToT_ToA_Batch_DatePicker.chooseDate(driver, StartDate, startDateTextbox, monthDropdownList, yearDropdownList);
	}

	public void ClickEndDate() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(endDateTextbox).click().build().perform();
	}

	public void SelectBatchEndDate(String EndDate) throws InterruptedException {
		Thread.sleep(2000);
		ToT_ToA_Batch_DatePicker.chooseDate(driver, EndDate, endDateTextbox, monthDropdownList, yearDropdownList);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void clickOnStartDateForValidity()
//	{
//		startDateTextbox.click();
//		startDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
//	}
//	
//	public void clickOnEndDateForValidity()
//	{
//		endDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
//	}
	
	public void clickOnSupportingDocument_BrowseFileButton()
	{
		supportingDocument_BrowseFileButton.click();
	}
	
	public void clickOnSuppoertingDocument_UploadFileButton()
	{
		supportingDocument_UploadFileButton.click();
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
	
	public void cancel_OTP()
	{
		cancelOTPButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}

}
