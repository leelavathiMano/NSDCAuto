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
	@FindBy(xpath="//input[@formcontrolname='aadhar']")
	private WebElement aadhaarNumberTextBox;
	@FindBy(xpath="//input[@formcontrolname='employeeId']")
	private WebElement employeeIdTextBox;
	@FindBy(id="customFile")
	private WebElement addressProof_browseButton;
	@FindBy(css=".btn.btn-outline-success")
	private WebElement addressProof_uploadButton;
	@FindBy(css=".btn.btn-next")
	private WebElement submitButton;
	@FindBy(xpath="//a[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
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
	
	public void enterAadhaarNumber(String aadhar)
	{
		aadhaarNumberTextBox.clear();
		aadhaarNumberTextBox.sendKeys(aadhar);
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
	
}
