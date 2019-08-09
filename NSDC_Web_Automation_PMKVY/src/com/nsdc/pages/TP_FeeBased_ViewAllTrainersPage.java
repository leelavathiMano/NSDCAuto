package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_ViewAllTrainersPage 
{
	
	WebDriver driver;
	
	@FindBy(id="trainersId")
	private WebElement searchTrainerIDTextbox;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="//button[contains(text(),'Link New Trainer')]")
	private WebElement linkNewTrainerButton;
	@FindBy(xpath="//input[@id='trainerId']")
	private WebElement trainerSDMSIDTextbox;
	@FindBy(xpath="//input[@id='nameOfTheTrainer']")
	private WebElement trainerNameTextbox;
	@FindBy(xpath="//select[@id='associatedTrainingCentre']")
	private WebElement associatedTrainingCentreDropDownList;
	@FindBy(xpath="//input[@placeholder='Select From Date:']")
	private WebElement startDateTextbox;
	@FindBy(xpath="//input[@placeholder='Select To Date:']")
	private WebElement endDateTextbox;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement supportingDocument_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
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
	}
	
	public void selectAssociatedTrainingCentreName(String tcName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(associatedTrainingCentreDropDownList, tcName);
	}
	
	public void clickOnStartDateForValidity()
	{
		startDateTextbox.click();
		startDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDateForValidity()
	{
		endDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
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
