package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class CandidateRegistrationPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement fullNameTextbox;
	@FindBy(xpath="//input[@formcontrolname='guardianName']")
	private WebElement guardianNameTextbox;
	@FindBy(xpath="//input[@formcontrolname='dob']")
	private WebElement dobTextbox;
	@FindBy(xpath="//th[contains(text(),'July 2004')]")
	private WebElement dob_YearButton;
	@FindBy(xpath="(//th[@class='datepicker-switch'])[2]")
	private WebElement selectYearFieldButton;
	@FindBy(xpath="(//span[contains(text(),'2000')])[1]")
	private WebElement selectYearButton;
	@FindBy(xpath="//span[contains(text(),'Feb')]")
	private WebElement selectMonthButton;
	@FindBy(xpath="//td[contains(text(),'2')]")
	private WebElement selectDateButton;
	@FindBy(xpath="//span[@class='input-group-text']")
	private WebElement calenderIconButton;
	@FindBy(xpath="//select[@formcontrolname='gender']")
	private WebElement selectGenderDropDownList;
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="//input[@formcontrolname='phone']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath="//select[@formcontrolname='education']")
	private WebElement selectEducationDropDownList;
	@FindBy(xpath="//input[@formcontrolname='pinCode']")
	private WebElement location_PinCodeTextbox;
	@FindBy(xpath="//select[@formcontrolname='stateObj']")
	private WebElement StateDropDownList;
	@FindBy(xpath="//select[@formcontrolname='districtDetailsObj']")
	private WebElement districtDropDownList;
	@FindBy(xpath="//select[@formcontrolname='sectorObj']")
	private WebElement sectorDropDownList;
	@FindBy(xpath="//select[@formcontrolname='subSectorObj']")
	private WebElement subSectorDropDownList;
	@FindBy(xpath="//select[@formcontrolname='jobRole']")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	
	
	
	public CandidateRegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void enterCandidateFullName(String candidateName)
	{
		fullNameTextbox.clear();
		fullNameTextbox.sendKeys(candidateName);
	}
	
	public void enterGuardianName(String guardianName)
	{
		guardianNameTextbox.clear();
		guardianNameTextbox.sendKeys(guardianName);
	}
	
	public void clickOnDateOfBirthField() throws Exception
	{
		Thread.sleep(4000);
		dobTextbox.click();
		dob_YearButton.click();
		selectYearFieldButton.click();
		selectYearButton.click();
		selectMonthButton.click();
		selectDateButton.click();
		calenderIconButton.click();
	}
	
	public void selectGender(String gender)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectGenderDropDownList, gender);
	}
	
	public void enterCandidateEmailAddress(String email)
	{
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys(email);
	}
	
	public void enterCandidateMobileNumber(String mobileNumber)
	{
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(mobileNumber);
	}
	
	public void selectEducationLevel(String education)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectEducationDropDownList, education);
	}
	
	public void enterLocation_PinCode(String pincode)
	{
		location_PinCodeTextbox.clear();
		location_PinCodeTextbox.sendKeys(pincode);
	}
	
	public void selectState_Location(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(StateDropDownList, state);
	}
	
	public void selectDistrict_Location(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}
	
	public void selectForSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	}
	
	public void selectForSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropDownList, subSector);
	}
	
	public void selectCandidate_JobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropDownList, jobRole);
	}
	
	public void clickForSubmit()
	{
		submitButton.click();
	}
	
	public void clickForCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
