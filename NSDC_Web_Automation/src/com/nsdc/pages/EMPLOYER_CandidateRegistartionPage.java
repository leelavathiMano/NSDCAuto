package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class EMPLOYER_CandidateRegistartionPage
{
	WebDriver driver;
	@FindBy(xpath="//p[contains(text(),'My Candidates')]")
	private WebElement myCandidatesCard;
	@FindBy(xpath="//p[text()='Register Candidates']")
	private WebElement registerCandidateButton;
	@FindBy(xpath="(//label[@class='m-radio'])[1]")
	private WebElement bulkExcelSheetUploadRadioButton;
	@FindBy(xpath="(//label[@class='m-radio'])[2]")
	private WebElement registerIndividualCandidateRadioButton;
	@FindBy(xpath="//input[@formcontrolname='excelFile']")
	private WebElement excelFileBrowseButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'Register')]")
	private WebElement registerButton;
	@FindBy(xpath="//span[contains(text(),'Register Candidate')]")
	private WebElement registerCandidate_InMyCandidateButton;
	//	@FindBy(xpath="//select[@formcontrolname='namePrefix']")
	@FindBy(id="exampleSelect1")
	private WebElement namePrefixDropdownList;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement fullNameTextbox;
	@FindBy(xpath="//input[@class='custom-file-input ']")
	private WebElement browseButton1;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadButton1;
	@FindBy(xpath="//input[@formcontrolname='phone']")
	private WebElement mobileNumberTextField;
	@FindBy(xpath="//select[@formcontrolname='countryCode']")
	private WebElement countryCodeDropdownList;
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement emailTextField;
	@FindBy(xpath="//input[@placeholder='Select Date of Birth']")
	private WebElement dobTextbox;
	@FindBy(xpath="//span[@class='input-group-text']")
	private WebElement calenderIconButton;
	@FindBy(xpath="//select[@formcontrolname='relationWithGuardian']")
	private WebElement guardianRelationDropDownList;
	@FindBy(xpath="//input[@placeholder='Enter Name']")
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
	@FindBy(xpath="(//input[@id='customFile'])[2]")
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
	//New Fields
	@FindBy(xpath="//input[@formcontrolname='locationSpoc']")
	private WebElement locationSPOCTextField;
	@FindBy(xpath="//select[@formcontrolname='placebirthstate']")
	private WebElement birthStateDropdownList;
	@FindBy(xpath="//select[@formcontrolname='placebirthdistrict']")
	private WebElement birthDistrictDropdownList;
	//Bank Details
	@FindBy(xpath="//input[@formcontrolname='accountHolderName']")
	private WebElement accountHolderNameTextField;
	@FindBy(xpath="//input[@formcontrolname='accountNumber']")
	private WebElement accountNumberTextField;
	@FindBy(xpath="//input[@formcontrolname='ifscCode']")
	private WebElement ifscTextField;
	@FindBy(xpath="//input[@formcontrolname='bankName']")
	private WebElement bankNameTextField;
	@FindBy(xpath="//textarea[@formcontrolname='bankAddress']")
	private WebElement bankAddressTextField;
	@FindBy(xpath="//select[@formcontrolname='boardingLodging']")
	private WebElement boardingAndLodgingDropdownList;
	//Candidate Experiencd
	@FindBy(xpath="//select[@formcontrolname='sectorId']")
	private WebElement candidateExperienceSectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='qpCode']")
	private WebElement candidateExperienceJobRoleDropdownList;
	@FindBy(xpath="//label[input[@name='agree']]")
	private WebElement iAgreeCheckbox;
	//New Changes
	@FindBy(xpath="//input[@formcontrolname='motherName']")
	private WebElement motherNameTextField;
	@FindBy(xpath="//input[@formcontrolname='fatherName']")
	private WebElement fatherNameTextField;
	@FindBy(xpath="//input[@formcontrolname='guardianName']")
	private WebElement guardianNameTextField;
	//
	@FindBy(xpath="(//label[input[@formcontrolname='idType']])[1]")
	private WebElement alterNateID_RadioButton;
	@FindBy(xpath="(//label[input[@formcontrolname='idType']])[2]")
	private WebElement aadhaarRadioButton;;
	@FindBy(xpath="//select[@formcontrolname='alternateIdType']")
	private WebElement alternateIdDropdownList;
	@FindBy(xpath="//input[@formcontrolname='alternateIdNumber']")
	private WebElement alternateIdNumberTextField;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement alternateIdFileBrowseButton1;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement alternateIdUploadButton1;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement alternateIdFileBrowseButton2;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement alternateIdUploadButton2;
	@FindBy(xpath="//input[@formcontrolname='aadharNumber']")
	private WebElement aadhaarNumberTextField;
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	private WebElement verifyButton;
	@FindBy(xpath="//select[@formcontrolname='preTrainingStatus']")
	private WebElement preTrainingStatusDropdownList;
	@FindBy(xpath="//select[@formcontrolname='monthOfExperience']")
	private WebElement candidateExperienceMonthsDropdownList;
	@FindBy(xpath="//select[@formcontrolname='sectorId']")
	private WebElement candidateExperienceYearDropdownList;
	@FindBy(xpath="//button[contains(text(),'Dummy Verify')]")
	private WebElement dummyVerifyButton;
	
	public EMPLOYER_CandidateRegistartionPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickMyCandidates()
	{
		myCandidatesCard.click();
	}
	public void clickOnRegisterCandidate()
	{
		registerCandidateButton.click();
	}
	public void clickToChooseBulkExcelSheetUpload()
	{
		bulkExcelSheetUploadRadioButton.click();
	}
	public void clickForExcelFileBrowse()
	{
		excelFileBrowseButton.click();
	}
	public void clickClose()
	{
		closeButton.click();
	}
	public void clickOnRegisterCandidate_InViewMyCandidate()
	{
		registerCandidate_InMyCandidateButton.click();
	}
	public void clickToChooseIndividualCandidateRegistration()
	{
		registerIndividualCandidateRadioButton.click();
	}
	public void clickRegister()
	{
		registerButton.click();
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
	public void enterMobileNumber(String mobileNumber)
	{
		mobileNumberTextField.clear();
		mobileNumberTextField.sendKeys(mobileNumber);
	}
	public void enterEmailID(String emailID)
	{
		emailTextField.clear();
		emailTextField.sendKeys(emailID);
	}
	public void clickToChooseGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			driver.findElement(By.xpath("(//label[input[@formcontrolname='gender']])[1]")).click();
		}
		else if(gender.equalsIgnoreCase("female"))
		{
			driver.findElement(By.xpath("(//label[input[@formcontrolname='gender']])[2]")).click();
		}
		else
		{
			driver.findElement(By.xpath("(//label[input[@formcontrolname='gender']])[3]")).click();
		}
//		driver.findElement(By.xpath("//label[input[@value='"+gender+"']]")).click();
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
	public void selectJobRole(String jobRole, String jobRoleCode)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropdownList, jobRole+" ("+jobRoleCode+")");
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
	//New Fields 
	public void selectBirthState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(birthStateDropdownList, state);
	}
	public void selectBirthDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(birthDistrictDropdownList, district);
	}
	public void enterLocationSPOC(String locationSPOC)
	{
		locationSPOCTextField.clear();
		locationSPOCTextField.sendKeys(locationSPOC);
	}
	public void enterAccountHolderName(String accountHolderName)
	{
		accountHolderNameTextField.clear();
		accountHolderNameTextField.sendKeys(accountHolderName);
	}
	public void enterAccountNumber(String accountNumber)
	{
		accountNumberTextField.clear();
		accountNumberTextField.sendKeys(accountNumber);
	}
	public void enterIFSC(String ifsc)
	{
		ifscTextField.clear();
		ifscTextField.sendKeys(ifsc);
	}
	public void clickToGetAutopopulatedBankDetails()
	{
		bankNameTextField.click();
	}
	public void enterBankName(String bankName) throws InterruptedException
	{
		bankNameTextField.click();
		bankNameTextField.clear();
		bankNameTextField.sendKeys(bankName);
	}
	public void enterBankAddress(String bankAddress)
	{
		bankAddressTextField.clear();
		bankAddressTextField.sendKeys(bankAddress);
	}
	public void selectBoardingAndLodging(String boardingAndLodging)
	{
		SelectDropDownList.selectDropDownListByVisibleText(boardingAndLodgingDropdownList, boardingAndLodging);
	}
	//Candidate Experience
	public void selectCandidateExperienceSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(candidateExperienceSectorDropdownList, sector);
	}
	public void selectCandidateExperienceJobRole(String jobrole, String jobRoleCode)
	{
		SelectDropDownList.selectDropDownListByVisibleText(candidateExperienceJobRoleDropdownList, jobrole+" ("+jobRoleCode+")");
	}
	public void clickIAgree()
	{
		iAgreeCheckbox.click();
	}
	public void selectCountryCode(String countryCode)
	{
		SelectDropDownList.selectDropDownListByVisibleText(countryCodeDropdownList, countryCode);
	}
	//New Changes
	public void enterMotherName(String motherName)
	{
		motherNameTextField.clear();
		motherNameTextField.sendKeys(motherName);
	}
	public void enterFatherName(String fatherName)
	{
		fatherNameTextField.clear();
		fatherNameTextField.sendKeys(fatherName);
	}
	public void enterNameOFGuardian(String guardianName)
	{
		guardianNameTextField.clear();
		guardianNameTextField.sendKeys(guardianName);
	}
	public void clickToChooseAlternateId()
	{
		alterNateID_RadioButton.click();
	}
	public void clickToChooseAadhaar()
	{
		aadhaarRadioButton.click();
	}
	public void enterAadhaarNumber(String aadhaarNumber)
	{
		aadhaarNumberTextField.clear();
		aadhaarNumberTextField.sendKeys(aadhaarNumber);
	}
	public void clickToVerifyAadhaar()
	{
		verifyButton.click();
	}
	public void selectAlternateIdtype(String alternateType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(alternateIdDropdownList, alternateType);
	}
	public void enterAlternateID(String alternateID)
	{
		alternateIdNumberTextField.clear();
		alternateIdNumberTextField.sendKeys(alternateID);
	}
	public void clickToBrowseAlternateIdFile(String isDisabled)
	{
		if(isDisabled.equalsIgnoreCase("yes"))
		{
			alternateIdFileBrowseButton2.click();
		}
		else
		{
			alternateIdFileBrowseButton1.click();
		}
		
	}
	public void clickToUploadAlternateIdFile(String isDisabled)
	{
		if(isDisabled.equalsIgnoreCase("yes"))
		{
			alternateIdUploadButton2.click();
		}
		else
		{
			alternateIdUploadButton1.click();
		}
	}
	public void selectPreTrainingStatus(String pretrainingStatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(preTrainingStatusDropdownList, pretrainingStatus);
	}
	public void selectExperienceMonths(String experienceMonths)
	{
		SelectDropDownList.selectDropDownListByVisibleText(candidateExperienceMonthsDropdownList, experienceMonths);
	}
	public void clickDummyVerify()
	{
		dummyVerifyButton.click();
	}
}