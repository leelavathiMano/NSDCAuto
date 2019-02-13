package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class Candidate_ProfilePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//select[@id='namePrefix']")
	private WebElement candidateNamePrefixDropDownList;
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement candidateNameTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement profilePicture_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement profilePicture_UploadFileButton;
	@FindBy(xpath="//select[@id='gender']")
	private WebElement selectGenderDropDownList;
	@FindBy(xpath="//input[@placeholder='Select Date of Birth']")
	private WebElement dobTextbox;
	@FindBy(xpath="//span[@class='input-group-text']")
	private WebElement calenderIconButton;
	@FindBy(xpath="//select[@id='relationWithGuardian']")
	private WebElement guardianRelationDropDownList;
	@FindBy(xpath="//input[@id='parentName']")
	private WebElement guardianNameTextbox;
	@FindBy(xpath="//input[@id='aadhar']")
	private WebElement aadharNumberTextbox;
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	private WebElement verifyButton;
	@FindBy(xpath="//select[@id='alternateIdType']")
	private WebElement alternateID_TypeDropDownList;
	@FindBy(xpath="//input[@id='alternateIdNumber']")
	private WebElement alternateID_NumberTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement idProofCopy_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement idProofCopy_UploadFileButton;
	@FindBy(xpath="//select[@id='caste']")
	private WebElement categoryDropDownList;
	@FindBy(xpath="//select[@id='religion']")
	private WebElement religionDropDownList;
	@FindBy(xpath="//select[@id='differentlyAbled']")
	private WebElement disablityDropDownList;
	@FindBy(xpath="//select[@id='disabilityCategory']")
	private WebElement disablityTypeDropDownList;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement supportingDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement supportingDocument_UploadFileButton;
	//@FindBy(xpath="//button[text()='Save & Next']")
	@FindBy(xpath="//button[contains(text(),'Save &')]")
	private WebElement saveAndNextButton;
	@FindBy(xpath="//button[contains(text(),'Save As Draft')]")
	private WebElement saveAsDraftButton;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailIDTextbox;
	@FindBy(xpath="(//textarea[@id='address1'])[1]")
	private WebElement permanent_AddressTextbox;
	@FindBy(xpath="(//input[@id='landmark'])[1]")
	private WebElement permanent_NearByLandmarkTextbox;
	@FindBy(xpath="(//input[@id='pincode'])[1]")
	private WebElement permanent_PinCodeTextbox;
	@FindBy(xpath="(//select[@id='state'])[1]")
	private WebElement permanent_StateDropDownList;
	@FindBy(xpath="(//select[@id='district'])[1]")
	private WebElement permanent_DistrictDropDownList;
	@FindBy(xpath="(//select[@id='tehsil'])[1]")
	private WebElement permanent_SubDistrictDropDownList;
	@FindBy(xpath="(//select[@id='city'])[1]")
	private WebElement permanent_VillageORCityDropDownList;
	@FindBy(xpath="(//select[@id='parliamentaryConstituency'])[1]")
	private WebElement permanent_ParliamentryConstituencyDropDownList;
	@FindBy(xpath="//label[input[@class='ng-untouched ng-pristine ng-valid']]/span")
	private WebElement sameAsPermanentAddressCheckBox;
	@FindBy(xpath="(//textarea[@id='address1'])[2]")
	private WebElement communication_AddressTextbox;
	@FindBy(xpath="(//input[@id='landmark'])[2]")
	private WebElement communication_NearByLandmarkTextbox;
	@FindBy(xpath="(//input[@id='pincode'])[2]")
	private WebElement communication_PinCodeTextbox;
	@FindBy(xpath="(//select[@id='state'])[2]")
	private WebElement communication_StateDropDownList;
	@FindBy(xpath="(//select[@id='district'])[2]")
	private WebElement communication_DistrictDropDownList;
	@FindBy(xpath="(//select[@id='tehsil'])[2]")
	private WebElement communication_SubDistrictDropDownList;
	@FindBy(xpath="(//select[@id='city'])[2]")
	private WebElement communication_VillageORCityDropDownList;
	@FindBy(xpath="(//select[@id='parliamentaryConstituency'])[2]")
	private WebElement communication_ParliamentryConstituencyDropDownList;
	
	@FindBy(xpath="(//select[@formcontrolname='education'])[1]")
	private WebElement educationDropDownList;
	@FindBy(xpath="//input[@formcontrolname='educationName']")
	private WebElement educationNameTextbox;
	@FindBy(xpath="(//select[@formcontrolname='passingYear'])[1]")
	private WebElement yearOfPassingDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='specialization'])[1]")
	private WebElement specializationTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement specializationSupportDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement specializationSupportDocument_UploadFileButton;
	@FindBy(xpath="//button[contains(text(),'Add Education Details')]")
	private WebElement addEducationDetailButton;
	@FindBy(xpath="(//button[contains(text(),'Remove')])[1]")
	private WebElement removeEducationButton;
	@FindBy(xpath="(//select[@formcontrolname='education'])[2]")
	private WebElement second_EducationDropDownList;
	//@FindBy(xpath="(//input[@formcontrolname='educationName'])[2]")
	//private WebElement second_EducationNameTextbox;
	@FindBy(xpath="(//select[@formcontrolname='passingYear'])[2]")
	private WebElement second_YearOfPassingDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='specialization'])[2]")
	private WebElement second_SpecializationTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement second_SpecializationSupportDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement second_SpecializationSupportDocument_UploadFileButton;
	@FindBy(xpath="(//button[contains(text(),'Remove')])[2]")
	private WebElement second_RemoveEducationButton;
	@FindBy(xpath="(//select[@formcontrolname='education'])[3]")
	private WebElement third_EducationDropDownList;
	//@FindBy(xpath="(//input[@formcontrolname='educationName'])[3]")
	//private WebElement third_EducationNameTextbox;
	@FindBy(xpath="(//select[@formcontrolname='passingYear'])[3]")
	private WebElement third_YearOfPassingDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='specialization'])[3]")
	private WebElement third_SpecializationTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement third_SpecializationSupportDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement third_SpecializationSupportDocument_UploadFileButton;
	@FindBy(xpath="(//button[contains(text(),'Remove')])[3]")
	private WebElement third_RemoveEducationButton;
	
	@FindBy(xpath="//div[label[p[text()='From Where did you']]]//select")
	private WebElement hearFromWhereDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[1]")
	private WebElement sectorDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[1]")
	private WebElement subSectorDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[1]")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="(//button[contains(text(),'Remove')])[1]")
	private WebElement remove_PrefrencesButton;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[2]")
	private WebElement second_SectorDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[2]")
	private WebElement second_SubSectorDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[2]")
	private WebElement second_JobRoleDropDownList;
	@FindBy(xpath="(//button[contains(text(),'Remove')])[2]")
	private WebElement second_Remove_PrefrencesButton;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[3]")
	private WebElement third_SectorDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[3]")
	private WebElement third_SubSectorDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[3]")
	private WebElement third_JobRoleDropDownList;
	@FindBy(xpath="(//button[contains(text(),'Remove')])[3]")
	private WebElement third_Remove_PrefrencesButton;
	@FindBy(xpath="//button[contains(text(),'Add Another Preference')]")
	private WebElement addAnotherPrefrencesButton;
	@FindBy(xpath="(//span[contains(text(),'Agree & Submit')])[1]")
	private WebElement first_AgreeAndSaveButton;
	@FindBy(xpath="//span[contains(text(),'Previous')]")
	private WebElement previousButton;
	@FindBy(xpath="//button[contains(text(),'Agree & Submit')]")
	private WebElement agreeAndSaveButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	
	
	public Candidate_ProfilePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void selectNamePrefix(String prefix)
	{
		SelectDropDownList.selectDropDownListByVisibleText(candidateNamePrefixDropDownList, prefix);
	}
	
	public void enterCandidateFullName(String name)
	{
		candidateNameTextbox.clear();
		candidateNameTextbox.sendKeys(name);
	}
	
	public void clickOnBrowseFileForProfilePicture()
	{
		profilePicture_BrowseFileButton.click();
	}
	
	public void clickOnUploadFileForProfilePicture()
	{
		profilePicture_UploadFileButton.click();
	}
	
	public void selectCandidateGender(String gender)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectGenderDropDownList, gender);
	}
	
	public void clickOnDOBField()
	{
		dobTextbox.click();
		calenderIconButton.click();
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
	
	public void enterAadharNumber(String aadharNumber)
	{
		aadharNumberTextbox.clear();
		aadharNumberTextbox.sendKeys(aadharNumber);
	}
	
	public void clickOnVerify()
	{
		verifyButton.click();
	}
	
	public void selectAlternateID_Type(String idtype)
	{
		SelectDropDownList.selectDropDownListByVisibleText(alternateID_TypeDropDownList, idtype);
	}
	
	public void enterAlternateID_Number(String idNumber)
	{
		alternateID_NumberTextbox.clear();
		alternateID_NumberTextbox.sendKeys(idNumber);
	}
	
	public void clickOnBrowseFileForIDProofCopy()
	{
		idProofCopy_BrowseFileButton.click();
	}
	
	public void clickOnUploadFileForIDProofCopy()
	{
		idProofCopy_UploadFileButton.click();
	}
	
	public void selectCategory(String category)
	{
		SelectDropDownList.selectDropDownListByVisibleText(categoryDropDownList, category);
	}
	
	public void selectReligion(String religion)
	{
		SelectDropDownList.selectDropDownListByVisibleText(religionDropDownList, religion);
	}
	
	public void selectDisablity(String disablity)
	{
		SelectDropDownList.selectDropDownListByVisibleText(disablityDropDownList, disablity);
	}
	
	public void selectDisablityType(String disablityType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(disablityTypeDropDownList, disablityType);
	}
	
	public void clickOnBrowseFileForDisablitySupportingDocument()
	{
		supportingDocument_BrowseFileButton.click();
	}
	
	public void clickOnUploadFileForDisblitySupportingDocument()
	{
		supportingDocument_UploadFileButton.click();
	}
	
	public void clickOnSaveAndNext()
	{
		saveAndNextButton.click();
	}
	
	public void clickOnSaveAsDraft()
	{
		saveAsDraftButton.click();
	}
	
	public void enterMobileNumber(String mobileNumber)
	{
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(mobileNumber);
	}
	
	public void enterEmailID(String email)
	{
		emailIDTextbox.clear();
		emailIDTextbox.sendKeys(email);
	}
	
	public void enterPermanent_AddressTextbox(String address)
	{
		permanent_AddressTextbox.clear();
		permanent_AddressTextbox.sendKeys(address);
	}
	
	public void enterPermanent_NearByLandmark(String landmark)
	{
		permanent_NearByLandmarkTextbox.clear();
		permanent_NearByLandmarkTextbox.sendKeys(landmark);
	}
	
	public void enterPermanent_PinCode(String pinCode)
	{
		permanent_PinCodeTextbox.clear();
		permanent_PinCodeTextbox.sendKeys(pinCode);
	}
	
	public void selectPermanent_State(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(permanent_StateDropDownList, state);
	}
	
	public void selectPermanent_District(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(permanent_DistrictDropDownList, district);
	}
	
	public void selectPermanent_ParliamentryConstituency(String parliamentryConstituency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(permanent_ParliamentryConstituencyDropDownList, parliamentryConstituency);
	}
	
	public void selectPermanent_TehsilOrBlock(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(permanent_SubDistrictDropDownList, subDistrict);
	}
	
	public void selectPermanent_VillageOrCity(String villageORCity)
	{
		SelectDropDownList.selectDropDownListByVisibleText(permanent_VillageORCityDropDownList, villageORCity);
	}
	
	public void clickOnSameAsPermanentAddressCheckBox()
	{
		sameAsPermanentAddressCheckBox.click();
	}
	
	public void enterCommunication_Address(String communicationAddress)
	{
		communication_AddressTextbox.clear();
		communication_AddressTextbox.sendKeys(communicationAddress);
	}
	
	public void enterCommunication_NearByLandmark(String communicationLandmark)
	{
		communication_NearByLandmarkTextbox.clear();
		communication_NearByLandmarkTextbox.sendKeys(communicationLandmark);
	}
	
	public void enterCommunication_PinCode(String communicationPinCode)
	{
		communication_PinCodeTextbox.clear();
		communication_PinCodeTextbox.sendKeys(communicationPinCode);
	}
	
	public void selectCommunication_State(String communicationState)
	{
		SelectDropDownList.selectDropDownListByVisibleText(communication_StateDropDownList, communicationState);
	}
	
	public void selectCommunication_District(String communicationDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(communication_DistrictDropDownList, communicationDistrict);
	}
	
	public void selectCommunication_ParliamentryConstituency(String communicationParliamentryConstituency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(communication_ParliamentryConstituencyDropDownList, communicationParliamentryConstituency);
	}
	
	public void selectCommunication_Tehsil(String communicationTehsil)
	{
		SelectDropDownList.selectDropDownListByVisibleText(communication_SubDistrictDropDownList, communicationTehsil);
	}
	
	public void selectCommunication_VillageOrCity(String communicationVillageORCity)
	{
		SelectDropDownList.selectDropDownListByVisibleText(communication_VillageORCityDropDownList, communicationVillageORCity);
	}
	
	public void selectEduation(String education)
	{
		SelectDropDownList.selectDropDownListByVisibleText(educationDropDownList, education);
	}
	
	public void enterOthers_EducationName(String educationName)
	{
		educationNameTextbox.clear();
		educationNameTextbox.sendKeys(educationName);
	}
		
	public void selectYearOfPassing(String passingYear)
	{
		SelectDropDownList.selectDropDownListByVisibleText(yearOfPassingDropDownList, passingYear);
	}
	
	public void enterSpecialization(String specialization)
	{
		specializationTextbox.clear();
		specializationTextbox.sendKeys(specialization);
	}
	
	public void clickOnBrowseFileForSpecializationSupportDocument()
	{
		specializationSupportDocument_BrowseFileButton.click();
	}
	
	public void clickOnUploadFileForSpecializationSupportDocument()
	{
		specializationSupportDocument_UploadFileButton.click();
	}
	
	public void clickOnAddEducationDetails()
	{
		addEducationDetailButton.click();
	}
	
	public void clickOnRemoveEducation()
	{
		removeEducationButton.click();
	}

	public void select_SecondEduation(String secondEducation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_EducationDropDownList, secondEducation);
	}
	
	/*public void enterOthers_SecondEducationName(String secondEducationName)
	{
		second_EducationNameTextbox.clear();
		second_EducationNameTextbox.sendKeys(secondEducationName);
	}*/
	
	public void enter_SecondSpecialization(String secondSpecialization)
	{
		second_SpecializationTextbox.clear();
		second_SpecializationTextbox.sendKeys(secondSpecialization);
	}
	
	public void select_SecondYearOfPassing(String secondPassingYear)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_YearOfPassingDropDownList, secondPassingYear);
	}
	
	public void clickOn_SecondBrowseFileForSpecializationSupportDocument()
	{
		second_SpecializationSupportDocument_BrowseFileButton.click();
	}
	
	public void clickOn_SecondUploadFileForSpecializationSupportDocument()
	{
		second_SpecializationSupportDocument_UploadFileButton.click();
	}
	
	public void clickOn_SecondRemoveEducation()
	{
		second_RemoveEducationButton.click();
	}
	
	public void select_ThirdEduation(String thirdEducation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_EducationDropDownList, thirdEducation);
	}
	
	/*public void enterOthers_ThirdEducationName(String thirdEducationName)
	{
		third_EducationNameTextbox.clear();
		third_EducationNameTextbox.sendKeys(thirdEducationName);
	}*/
	
	public void enter_ThirdSpecialization(String thirdSpecialization)
	{
		third_SpecializationTextbox.clear();
		third_SpecializationTextbox.sendKeys(thirdSpecialization);
	}
	
	public void select_ThirdYearOfPassing(String thirdPassingYear)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_YearOfPassingDropDownList, thirdPassingYear);
	}
	
	public void clickOn_ThirdBrowseFileForSpecializationSupportDocument()
	{
		third_SpecializationSupportDocument_BrowseFileButton.click();
	}
	
	public void clickOn_ThirdUploadFileForSpecializationSupportDocument()
	{
		third_SpecializationSupportDocument_UploadFileButton.click();
	}
		
	public void clickOn_ThirdRemoveEducation()
	{
		third_RemoveEducationButton.click();
	}
	
	public void selectFromWhereYouHear(String hearFromWhere)
	{
		SelectDropDownList.selectDropDownListByVisibleText(hearFromWhereDropDownList, hearFromWhere);
	}
	
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	}
	
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropDownList, subSector);
	}
	
	public void selectJobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropDownList, jobRole);
	}
	
	public void clickOnRemove_Prefrences()
	{
		remove_PrefrencesButton.click();
	}
	
	public void selectSecond_Sector(String secondSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_SectorDropDownList, secondSector);
	}
	
	public void selectSecond_SubSector(String secondSubSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_SubSectorDropDownList, secondSubSector);
	}
	
	public void selectSecond_JobRole(String secondJobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_JobRoleDropDownList, secondJobRole);
	}
	
	public void clickOnSecond_Remove_Prefrences()
	{
		second_Remove_PrefrencesButton.click();
	}
	
	public void selectThird_Sector(String thirdSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_SectorDropDownList, thirdSector);
	}
	
	public void selectThird_SubSector(String thirdSubSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_SubSectorDropDownList, thirdSubSector);
	}
	
	public void selectThird_JobRole(String thirdJobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_JobRoleDropDownList, thirdJobRole);
	}
	
	public void clickOnThird_Remove_Prefrences()
	{
		third_Remove_PrefrencesButton.click();
	}
	
	public void clickOnAddAnotherPrefrences()
	{
		addAnotherPrefrencesButton.click();
	}
	
	public void clickOn_FirstAgreeAndSaveButton()
	{
		first_AgreeAndSaveButton.click();
	}
	
	public void clickOnPrevious()
	{
		previousButton.click();
	}
	
	public void clickOnAgreeAndSave()
	{
		agreeAndSaveButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}


}
