package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_AssessmentAgencyInfoPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement assessmentAgencyNameTextbox;
	@FindBy(xpath="//input[@placeholder='Select From Date']")
	private WebElement startDateTextbox;
	@FindBy(xpath="//input[@placeholder='Select To Date']")
	private WebElement endDateTextbox;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement supportingDocument_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement supportingDocument_UploadButton;
	@FindBy(xpath="//textarea[@id='address1']")
	private WebElement addressTextbox;
	@FindBy(xpath="//input[@id='landmark']")
	private WebElement nearByLandmarkTextbox;
	@FindBy(xpath="//input[@id='pincode']")
	private WebElement pincodeTextbox;
	@FindBy(xpath="//select[@id='state']")
	private WebElement stateDropDownList;
	@FindBy(xpath="//select[@id='district']")
	private WebElement districtDropDownList;
	@FindBy(xpath="//select[@id='tehsil']")
	private WebElement tehsilOrBlockDropDownList;
	@FindBy(xpath="//select[@id='parliamentaryConstituency']")
	private WebElement parliamentryConstituencyDropDownList;
	@FindBy(xpath="//input[@id='search_places']")
	private WebElement geoLocationTextbox;
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstNameOfSpocTextbox;
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement lastNameOfSpocTextbox;
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="//input[@id='mobileNumber']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	public TP_FeeBased_AssessmentAgencyInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterAssessmentAgencyName(String assessmentAgencyName)
	{
		assessmentAgencyNameTextbox.clear();
		assessmentAgencyNameTextbox.sendKeys(assessmentAgencyName);
	}
	
	public void enterStartDate()
	{
		startDateTextbox.click();
		startDateTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void enterEndDate()
	{
		endDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnSupportingDocument_BrowseFile()
	{
		supportingDocument_BrowseFileButton.click();
	}
	
	public void clickOnSupportingDocument_UploadButton()
	{
		supportingDocument_UploadButton.click();
	}
	
	public void enterAddressOfAssessmentAgency(String assessmentAgencyAddress)
	{
		addressTextbox.clear();
		addressTextbox.sendKeys(assessmentAgencyAddress);
	}
	
	public void enterNearByLandmark(String landmark)
	{
		nearByLandmarkTextbox.clear();
		nearByLandmarkTextbox.sendKeys(landmark);
	}
	
	public void enterPincode(String pincode)
	{
		pincodeTextbox.clear();
		pincodeTextbox.sendKeys(pincode);
	}
	
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
	}
	
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}
	
	public void selectTehsilOrBlock(String tehsil)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tehsilOrBlockDropDownList, tehsil);
	}
	
	public void selectParliamentryConstituency(String parliamentryConstoituency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(parliamentryConstituencyDropDownList, parliamentryConstoituency);
	}
	
	public void enterGeoLocation(String geoLocation)throws Exception
	{
		geoLocationTextbox.clear();
		geoLocationTextbox.sendKeys(geoLocation);
		Thread.sleep(2000);
		geoLocationTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}
	
	public void enterFirstNameOfSPOC(String firstName)
	{
		firstNameOfSpocTextbox.clear();
		firstNameOfSpocTextbox.sendKeys(firstName);
	}
	
	public void enterLastNameOfSPOC(String lastName)
	{
		lastNameOfSpocTextbox.clear();
		lastNameOfSpocTextbox.sendKeys(lastName);
	}
	
	public void enterEmailAddressOfSPOC(String email)
	{
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys(email);
	}
	
	public void enterMobileNumberOfSPOC(String mobileNumber)
	{
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(mobileNumber);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}
	

}
