package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class TrainingPartner_CandidateRegistrationPage
{
	WebDriver driver;
	@FindBy(xpath="//select[@formcontrolname='namePrefix']")
	private WebElement namePrefixDropdownList;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement fullNameTextbox;
	@FindBy(xpath="//input[@class='custom-file-input ']")
	private WebElement browseButton1;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadButton1;
	@FindBy(id="dob")
	private WebElement dobTextbox;
	@FindBy(xpath="//span[@class='input-group-text']")
	private WebElement calenderIconButton;
	@FindBy(xpath="//select[@formcontrolname='relationWithGuardian']")
	private WebElement guardianRelationDropDownList;
	@FindBy(xpath="//input[@formcontrolname='guardianName']")
	private WebElement guardianNameTextbox;
	@FindBy(xpath="//select[@formcontrolname='maritialStatus']")
	private WebElement maritalStatusDropdownList;
	@FindBy(xpath="//input[@formcontrolname='placeOfBirth']")
	private WebElement placeOfBirthTextField;
	@FindBy(xpath="//select[@formcontrolname='caste']")
	private WebElement castDropDownList;
	@FindBy(xpath="//select[@formcontrolname='religion']")
	private WebElement religionDropDownList;
	@FindBy(xpath="(//label[input[@formcontrolname='differentlyAbled']])[1]")
	private WebElement disabilityYesRadioButton;
	@FindBy(xpath="(//label[input[@formcontrolname='differentlyAbled']])[2]")
	private WebElement disabilityNoRadioButton;
	@FindBy(xpath="//select[@formcontrolname='disabilityCategory']")
	private WebElement disabilityDropdownList;
	@FindBy(xpath="(//input[@class='custom-file-input '])[2]")
	private WebElement browseButton2;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement uploadButton2;
	@FindBy(xpath="(//input[@class='custom-file-input '])[3]")
	private WebElement browseButton3;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement uploadButton3;
	@FindBy(xpath="//input[@formcontrolname='address1']")
	private WebElement addressTextField;
	@FindBy(xpath="//select[@formcontrolname='city']")
	private WebElement villageDropdownList;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateDropdownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subDistrict']")
	private WebElement subDistrictDropdownList;
	@FindBy(xpath="//input[@formcontrolname='pinCode']")
	private WebElement pincodeTextField;
	@FindBy(xpath="//select[@formcontrolname='parliamentaryConstituency']")
	private WebElement parlimetaryConstituencyDropdownList;
	@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
	private WebElement saveAndContinueButton;
	//contact details
	@FindBy(xpath="//select[@formcontrolname='alternateIdType']")
	private WebElement identificationTypeDropdownList;
	@FindBy(xpath="//input[@formcontrolname='alternateIdNumber']")
	private WebElement identificationIDnumberTextField;
	@FindBy(xpath="//div[label[contains(text(),'Same as Permanent Address')]]/div/label/span")
	private WebElement sameAsPermanentAddressCheckbox;
	//Education Details
	@FindBy(xpath="//select[@formcontrolname='education']")
	private WebElement educationDropdownList;
	@FindBy(xpath="//input[@formcontrolname='specialization']")
	private WebElement specialisationTextField;
	@FindBy(xpath="//select[@formcontrolname='passingYear']")
	private WebElement yearOfPassingDropdownList;
	@FindBy(xpath="//button[contains(text(),'Add Education Details')]")
	private WebElement addEducationDetailsButton;
	//second education records
	@FindBy(xpath="(//select[@formcontrolname='education'])[2]")
	private WebElement education2DropdownList;
	@FindBy(xpath="(//input[@formcontrolname='specialization'])[2]")
	private WebElement specialisation2TextField;
	@FindBy(xpath="//input[@formcontrolname='educationName']")
	private WebElement educationNameTextField;
	@FindBy(xpath="(//select[@formcontrolname='passingYear'])[2]")
	private WebElement yearOfPassing2DropdownList;
	//Third Education Records
	@FindBy(xpath="(//select[@formcontrolname='education'])[3]")
	private WebElement education3DropdownList;
	@FindBy(xpath="(//input[@formcontrolname='specialization'])[3]")
	private WebElement specialisation3TextField;
	@FindBy(xpath="(//select[@formcontrolname='passingYear'])[3]")
	private WebElement yearOfPassing3DropdownList;
	@FindBy(xpath="(//button[contains(text(),'Remove')])[3]")
	private WebElement thirdRemoveButton;
	//Course Preference 
	@FindBy(xpath="//select[@formcontrolname='heardFrom']")
	private WebElement hearAboutUsDropdownList;
	@FindBy(xpath="//select[@formcontrolname='sector']")
	private WebElement sectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subSector']")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='jobRole']")
	private WebElement jobRoleDropdownList;
	@FindBy(xpath="//button[contains(text(),'Add Another')]")
	private WebElement addAnotherPreferenceButton;
	//Second Preference
	@FindBy(xpath="(//select[@formcontrolname='sector'])[2]")
	private WebElement sector2DropdownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[2]")
	private WebElement subSector2DropdownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[2]")
	private WebElement jobRole2DropdownList;
	//Third Preference
	@FindBy(xpath="(//select[@formcontrolname='sector'])[3]")
	private WebElement sector3DropdownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[3]")
	private WebElement subSector3DropdownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[3]")
	private WebElement jobRole3DropdownList;
	@FindBy(xpath="//button[contains(text(),'Agree & Submit')]")
	private WebElement agreeAndSubmitButton;
	@FindBy(linkText="Review before submission")
	private WebElement reviewBeforeSubmissionLink;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	
	public TrainingPartner_CandidateRegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void selectNamePrefix(String namePrefix)
	{
		SelectDropDownList.selectDropDownListByVisibleText(namePrefixDropdownList, namePrefix);
	}
	public void enterFullName(String fullName)
	{
		fullNameTextbox.clear();
		fullNameTextbox.sendKeys(fullName);
	}
	public void clickToBrowseProfilePicture()
	{
		browseButton1.click();
	}
	public void clickToUploadProfilePicture()
	{
		uploadButton1.click();
	}
	public void clickToChooseGender(String gender)
	{
		driver.findElement(By.xpath("//label[input[@value='"+gender+"']]")).click();
	}
	public void clickToSelectDOB() throws InterruptedException
	{
		dobTextbox.click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//div[@class='datepicker-days']/table/tbody/tr/td[text()='1'])[1]")).click();
    	Thread.sleep(2000);
        calenderIconButton.click();
        Thread.sleep(2000);
	}
	public void selectRelationWithGuardian(String guardianRelation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(guardianRelationDropDownList, guardianRelation);
	}
	public void enterGuardianName(String guardianname)
	{
		guardianNameTextbox.clear();
		guardianNameTextbox.sendKeys(guardianname);
	}
	public void selectMaritalStatus(String maritalStatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(maritalStatusDropdownList, maritalStatus);
	}
	public void enterPlaceOfBirth(String placeOfBirth)
	{
		placeOfBirthTextField.clear();
		placeOfBirthTextField.sendKeys(placeOfBirth);
	}
	public void selectCast(String cast)
	{
		SelectDropDownList.selectDropDownListByVisibleText(castDropDownList, cast);
	}
	public void selectReligion(String religion)
	{
		SelectDropDownList.selectDropDownListByVisibleText(religionDropDownList, religion);
	}
	public void clickDisabilityYes()
	{
		disabilityYesRadioButton.click();
	}
	public void clickDisabilityNo()
	{
		disabilityNoRadioButton.click();
	}
	public void selectDisablity(String disablity)
	{
		SelectDropDownList.selectDropDownListByVisibleText(disabilityDropdownList, disablity);
	}
	public void clickToBrowsedisabilityProofDoc()
	{
		browseButton2.click();
	}
	public void clickToUploadDisabilityProofDoc()
	{
		uploadButton2.click();
	}
	public void enterAddress(String address)
	{
		addressTextField.clear();
		addressTextField.sendKeys(address);
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropdownList, state);
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropdownList, district);
	}
	public void selectSubDistrict(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrictDropdownList, subDistrict);
	}
	public void selectVillage(String village)
	{
		SelectDropDownList.selectDropDownListByVisibleText(villageDropdownList, village);
	}
	public void enterPincode(String pincode)
	{
		pincodeTextField.clear();
		pincodeTextField.sendKeys(pincode);
	}
	public void selectParlimentaryConstituency(String parlimentaryConstituency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(parlimetaryConstituencyDropdownList, parlimentaryConstituency);
	}
	public void clickSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	//contact details
	public void selectIdentificationType(String identificationType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(identificationTypeDropdownList, identificationType);
	}
	public void enterIdentificationIDNumber(String identificationIDnumber)
	{
		identificationIDnumberTextField.clear();
		identificationIDnumberTextField.sendKeys(identificationIDnumber);
	}
	public void clickToBrowseIdentificationProofDoc()
	{
		browseButton1.click();
	}
	public void clickToUploadIdentificationProofDoc()
	{
		uploadButton1.click();
	}
	public void clickSameAsPermanetAddress()
	{
		sameAsPermanentAddressCheckbox.click();
	}
	//Education Record 1
	public void selectEducation(String education)
	{
		SelectDropDownList.selectDropDownListByVisibleText(educationDropdownList, education);
	}
	public void enterSpecialisation(String specialisation)
	{
		specialisationTextField.clear();
		specialisationTextField.sendKeys(specialisation);
	}
	public void selectYearOfPassing(String yearOfPassing)
	{
		SelectDropDownList.selectDropDownListByVisibleText(yearOfPassingDropdownList, yearOfPassing);
	}
	public void clickToBrowseEducationProofDoc()
	{
		browseButton1.click();
	}
	public void clickToUploadEducationProof()
	{
		uploadButton1.click();
	}
	public void clickToAddOneMoreEducationRecord()
	{
		addEducationDetailsButton.click();
	}
	//Second Education Record
	public void seelctSecondEducation(String education2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(education2DropdownList, education2);
	}
	public void enterSecondSpecialisation(String specialisation2)
	{
		specialisation2TextField.clear();
		specialisation2TextField.sendKeys(specialisation2);
	}
	public void enterEducationNameInCaseOFOthers(String othersEducationName)
	{
		educationNameTextField.clear();
		educationNameTextField.sendKeys(othersEducationName);
	}
	public void selectSecondYearOfPassing(String yearOfPassing2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(yearOfPassing2DropdownList, yearOfPassing2);
	}
	public void clickToBrowseSecondEducationProof()
	{
		browseButton2.click();
	}
	public void clickToUploadSecondEducationProof()
	{
		uploadButton2.click();
	}
	//Third Education Record
	public void selectThirdEducation(String education3)
	{
		SelectDropDownList.selectDropDownListByVisibleText(education3DropdownList, education3);
	}
	public void enterThirdSpecialisation(String specialisation3)
	{
		specialisation3TextField.clear();
		specialisation3TextField.sendKeys(specialisation3);
	}
	public void selectThirdYearOfPassing(String yearOfPassing3)
	{
		SelectDropDownList.selectDropDownListByVisibleText(yearOfPassing3DropdownList, yearOfPassing3);
	}
	public void clickToBrowseThirdEducationProof()
	{
		browseButton3.click();
	}
	public void clickToUploadThirdEducationProof()
	{
		uploadButton3.click();
	}
	//Removing Added Third Education Record
	public void clickToRemoveAddedThirdEducationRecord()
	{
		thirdRemoveButton.click();
	}
	//course perferences
	public void selectHearAboutUs(String hearAboutUs)
	{
		SelectDropDownList.selectDropDownListByVisibleText(hearAboutUsDropdownList, hearAboutUs);
	}
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropdownList, sector);
	}
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropdownList, subSector);
	}
	public void selectJobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropdownList, jobRole);
	}
	public void clickToAddAnotherPreference()
	{
		addAnotherPreferenceButton.click();
	}
	//Second Preference
	public void selectSecondSector(String sector2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sector2DropdownList, sector2);
	}
	public void selectSecondSubSector(String subSector2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSector2DropdownList, subSector2);
	}
	public void selectSecondJobRole(String jobRole2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRole2DropdownList, jobRole2);
	}
	//Third Preference
	public void selectThirdSector(String sector3)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sector3DropdownList, sector3);
	}
	public void selectThirdSubSector(String subSector3)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSector3DropdownList, subSector3);
	}
	public void selectThirdJobRole(String jobRole3)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRole3DropdownList, jobRole3);
	}
	public void clickToRemoveAddedThirdPreference()
	{
		thirdRemoveButton.click();
	}
	public void clickToAgreeAndSubmit()
	{
		agreeAndSubmitButton.click();
	}
	public void clickToReviewBeforeSubmission()
	{
		reviewBeforeSubmissionLink.click();
	}
	public void clickOK()
	{
		okButton.click();
	}
}