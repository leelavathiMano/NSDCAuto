package com.nsdc.pages;

import org.openqa.selenium.Keys;
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
	@FindBy(xpath="//td[contains(text(),'18')]")
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
	@FindBy(xpath="//input[@placeholder='Enter Area Name']")
	private WebElement geoTagTextbox;
	@FindBy(xpath="//select[@formcontrolname='sectorObj']")
	private WebElement sectorDropDownList;
	@FindBy(xpath="//select[@formcontrolname='subSectorObj']")
	private WebElement subSectorDropDownList;
	@FindBy(xpath="//select[@formcontrolname='jobRole']")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="//select[@formcontrolname='associatedProgramName']")
	private WebElement associateProgramNameDropDownList;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement profliePicture_BrowseFileButton;
	@FindBy(xpath="//select[@formcontrolname='cioType']")
	private WebElement cioTypeDropDownList;
	@FindBy(xpath="//select[@formcontrolname='cioName']")
	private WebElement cioNameDropDownList;
	@FindBy(xpath="(//label[input[@formcontrolname='interestedIn']]/span)[1]")
	private WebElement pMKVYTrainingRadioButton;
	@FindBy(xpath="(//label[input[@formcontrolname='interestedIn']]/span)[2]")
	private WebElement pMKVYTrainingAndPlacementRadioButton;
	@FindBy(xpath="//label[a[contains(text(),'Privacy Policy')]]/span")
	private WebElement iAgreeCheckBox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
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
		guardianNameTextbox.sendKeys(Keys.TAB);
	}
	
	public void clickOnDateOfBirthField() throws Exception
	{
		Thread.sleep(2000);
		dobTextbox.sendKeys(Keys.ENTER, Keys.TAB);
		//dob_YearButton.click();
		//selectYearFieldButton.click();
		//selectYearButton.click();
		//selectMonthButton.click();
		//Thread.sleep(3000);
		//selectDateButton.click();
//		Thread.sleep(4000);
//		calenderIconButton.click();
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
	
	public void enterGeoTag(String geoTag)throws Exception
	{
		geoTagTextbox.clear();
		geoTagTextbox.sendKeys(geoTag);
		Thread.sleep(3000);
		geoTagTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
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
	
	public void selectAssociateProgramName(String associateProgram)
	{
		SelectDropDownList.selectDropDownListByVisibleText(associateProgramNameDropDownList, associateProgram);
	}
	
	public void clickOnUploadProfilePicture()
	{
		profliePicture_BrowseFileButton.click();
	}
	
	public void selectCIOType(String cioType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(cioTypeDropDownList, cioType);
	}
	
	public void selectCIOName(String cioName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(cioNameDropDownList, cioName);
	}
	
	public void clickOnIntrestedInPMKVYTraining()
	{
		pMKVYTrainingRadioButton.click();
	}
	
	public void clcikOnInterestedInPMKVYTrainingAndPlacement()
	{
		pMKVYTrainingAndPlacementRadioButton.click();
	}
	
	public void clickOnIAgree()
	{
		iAgreeCheckBox.click();
	}
	
	public void clickForSubmit()
	{
		submitButton.click();
	}
	
	public void clickForClose()
	{
		closeButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
