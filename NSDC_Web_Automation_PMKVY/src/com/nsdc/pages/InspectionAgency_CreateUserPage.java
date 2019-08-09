package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class InspectionAgency_CreateUserPage 
{
	WebDriver driver;
	
	@FindBy(css=".bnt.btn-with-border")
	private WebElement goBackButton;
	@FindBy(xpath="//select[@formcontrolname='role']")
	private WebElement selectUserTypeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement fullNameTextBox;
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement emailAddressTextBox;
	@FindBy(xpath="//input[@formcontrolname='mobile']")
	private WebElement mobileNumberTextBox;
	@FindBy(xpath="//button[contains(text(),'Generate OTP')]")
	private WebElement generateOTPButton;
	@FindBy(xpath="//input[@formcontrolname='mobileOTP']")
	private WebElement mobileOTPTextbox;
	@FindBy(xpath="//input[@formcontrolname='emailOTP']")
	private WebElement emailOTPTextbox;
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	private WebElement verifyButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//input[@formcontrolname='aadhar']")
	private WebElement aadhaarNumberTextBox;
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	private WebElement verifyAadharNumberButton;
	@FindBy(xpath="//input[@formcontrolname='employeeId']")	
	private WebElement employeeIdTextBox;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement addressProof_browseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement addressProof_uploadButton;
	@FindBy(xpath="//label[input[@formcontrolname='changeStatusChecked']]/span")
	private WebElement iAgreeCheckBox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//a[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	@FindBy(xpath="//select[@formcontrolname='identityType']")
	private WebElement identityTypeDropdownList;
	@FindBy(xpath="//input[@formcontrolname='identityNumber']")
	private WebElement identityNumberTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement identityProofDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement identityProofDocument_UploadFileButton;

	
	
	public InspectionAgency_CreateUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnGoBack()
	{
		goBackButton.click();
	}
	
	public void selectTheUserType(String type)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectUserTypeDropDownList, type);
	}
	
	public void enterFullName(String name)
	{
		fullNameTextBox.clear();
		fullNameTextBox.sendKeys(name);
	}
	
	public void enterEmailAddress(String email)
	{
		emailAddressTextBox.clear();
		emailAddressTextBox.sendKeys(email);
	}
	
	public void enterMobileNumber(String mobileNo)
	{
		mobileNumberTextBox.clear();
		mobileNumberTextBox.sendKeys(mobileNo);
	}
	
	public void clickOnGenerateOTP()
	{
		generateOTPButton.click();
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
	
	public void clickOnVerify()
	{
		verifyButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void enterAadhaarNumber(String aadhar)
	{
		aadhaarNumberTextBox.clear();
		aadhaarNumberTextBox.sendKeys(aadhar);
	}
	
	public void clickOnVerifyAadhar()
	{
		verifyAadharNumberButton.click();
	}
	
	public void enterEmployeeId(String id)
	{
		employeeIdTextBox.clear();
		employeeIdTextBox.sendKeys(id);
	}
	
	public void clickOnBrowseForAddressProof()
	{
		addressProof_browseButton.click();
	}
	
	public void clickOnUploadForAddressProof()
	{
		addressProof_uploadButton.click();
	}
	
	public void clickOnIAgree()
	{
		iAgreeCheckBox.click();
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void clickOnOk()
	{
		okButton.click();
	}
	
	public void selectForIdentityType(String identityType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(identityTypeDropdownList, identityType);
	}
	
	public void enterIdentityNumber(String identityNumber)
	{
		identityNumberTextbox.clear();
		identityNumberTextbox.sendKeys(identityNumber);
	}
	
	public void clickOnIdentityProof_BrowseFile()
	{
		identityProofDocument_BrowseFileButton.click();
	}
	
	public void clickOnIndentityProof_UploadFile()
	{
		identityProofDocument_UploadFileButton.click();
	}
	
	
}
