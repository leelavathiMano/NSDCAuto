package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AssessorMyProfilePage
{
	WebDriver driver;
	@FindBy(xpath="(//a[@class='m-menu__link m-menu__toggle'])[3]")
	private WebElement myProfileLink;
	@FindBy(xpath="//span[@class='m-card-profile__name']")
	private WebElement profileNameText;
	@FindBy(linkText="Personal Information")
	private WebElement personalInformationLink;
	@FindBy(linkText="Contact & Address")
	private WebElement contactAndAddressLink;
	@FindBy(linkText="Education & Work")
	private WebElement educationAndWorkLink;
	@FindBy(xpath="//a[contains(text(),'Training Requests')]")
	private WebElement trainingRequestsLink;
	@FindBy(xpath="//div[label[contains(text(),'Name of the Applicant')]]/div/input")
	private WebElement nameOfTheApplicantTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Gender')]]/div/input")
	private WebElement genderTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Date of Birth')]]/div/input")
	private WebElement dateOfBirthTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Languages Known:')]]/div/select")
	private WebElement languagesKnownMulktiSelectDropdown;
	@FindBy(xpath="//div[label[contains(text(),'Religion:')]]/div/input")
	private WebElement religionTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Category:')]]/div/input")
	private WebElement categoryTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Disability (If Any):')]]/div/input")
	private WebElement disabiltyIfAnyTextBox;
	@FindBy(xpath="//div[label[contains(text(),'aadhar')]]/div/label")
	private WebElement aadharNumberVerificationStatusText;
	@FindBy(xpath="//div[label[contains(text(),'PAN')]]/div/label")
	private WebElement panNumberVerificationStatusText;
	@FindBy(xpath="//div[label[contains(text(),'Upload New Photograph:')]]//input[@id='customFile']")
	private WebElement photoFileBrowseButton;
	@FindBy(xpath="//div[label[contains(text(),'Upload New Photograph:')]]//button[contains(text(),'Upload')]")
	private WebElement uploadPhotoFileButton;
	@FindBy(xpath="//div[label[contains(text(),'Select Applicant Category:')]]/div/select")
	private WebElement applicantCategoryMultiSelectDropdown;
	@FindBy(xpath="(//button[contains(text(),'Save changes')])[1]")
	private WebElement saveChangesButton1;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton1;
	@FindBy(xpath="//div[label[contains(text(),'Mobile Number of Applicant:')]]/div/input")
	private WebElement mobileNumOfApplicantTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Email Address of Applicant:')]]/div/input")
	private WebElement emailOfApplicantTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Applicant Address:')]]/div/textarea")
	private WebElement applicantAddressTextArea;
	@FindBy(xpath="//div[label[contains(text(),'Nearby Landmark:')]]/div/input")
	private WebElement nearByLandmarkTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Pincode:')]]/div/input")
	private WebElement pincodeTextBox;
	@FindBy(xpath="//div[label[contains(text(),'State / Union Territory:')]]/div/input")
	private WebElement stateOrUnionTerritoryTextBox;
	@FindBy(xpath="//div[label[contains(text(),'District / City:')]]/div/input")
	private WebElement districtOrCityTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Tehsil / Mandal:')]]/div/input")
	private WebElement tehsilOrMandalTextBox;
	@FindBy(xpath="//div[label[contains(text(),'Parliamentary Constituency:')]]/div/input")
	private WebElement parlimentoryConstituencyTextBox;
	//Education
	@FindBy(xpath="(//button[contains(text(),'Add')])[1]")
	private WebElement addEducationDetailsButton;
	@FindBy(xpath="//select[@formcontrolname='education']")
	private WebElement educationAttainedDropdownList;	
	@FindBy(xpath="(//input[@formcontrolname='details'])[1]")
	private WebElement	detailsOfEducationTextfield;	
	@FindBy(xpath="(//div[label[contains(text(),'Upload Proof Document:')]]//input[@id='customFile'])[1]")
	private WebElement educationProofDocBrowseButton;	
	@FindBy(xpath="(//div[label[contains(text(),'Upload Proof Document:')]]//button[contains(text(),'Upload')])[1]")
	private WebElement educationProofDocUploadButton;
	@FindBy(xpath="(//button[contains(text(),'Add')])[1]")
	private WebElement educationDetailsSaveAndSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement educationDetailsCloseButton;
	@FindBy(xpath="(//i[@class='la la-trash delete-icon'])[3]")
	private WebElement deleteAddedThirdEducationDetailsButton;
	@FindBy(xpath="(//i[@class='la la-trash delete-icon'])[2]")
	private WebElement deleteAddedFirstEducationDetailsButton;
	//Industrial Experience Details Record
	@FindBy(xpath="(//button[contains(text(),'Add')])[2]")
	private WebElement addIndustrilExperienceDetailsButton;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[1]")
	private WebElement indutrySectorDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='years'])[1]")
	private WebElement industryYearsDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='months'])[1]")
	private WebElement indutryMonthsDropdownList;
	@FindBy(xpath="(//input[@formcontrolname='details'])[2]")
	private WebElement industryExperienceDetailsTextfield;
	@FindBy(xpath="(//div[label[contains(text(),'Upload Proof Document:')]]//input[@id='customFile'])[2]")
	private WebElement industrialExperienceProofDocBrowseButton;	
	@FindBy(xpath="(//div[label[contains(text(),'Upload Proof Document:')]]//button[contains(text(),'Upload')])[2]")
	private WebElement industrialExperienceProofDocUploadButton;
	@FindBy(xpath="(//button[contains(text(),'Add')])[2]")
	private WebElement industrialExperienceDetailsSaveAndSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[2]")
	private WebElement industrialExperienceDetailsCloseButton;
	@FindBy(xpath="(//i[@class='la la-trash delete-icon'])[5]")
	private WebElement deleteAddedThirdIndustrialExperienceDetailsButton;
	@FindBy(xpath="(//i[@class='la la-trash delete-icon'])[4]")
	private WebElement deleteAddedThirdtIndustrialExperienceRecordInCaseOfUneducatedButton;
	//Training Details Record
	@FindBy(xpath="(//button[contains(text(),'Add')])[3]")
	private WebElement addTrainingExperienceDetailsButton;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[2]")
	private WebElement trainingSectorDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='years'])[2]")
	private WebElement trainingYearsDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='months'])[2]")
	private WebElement trainingMonthsDropdownList;
	@FindBy(xpath="(//input[@formcontrolname='details'])[3]")
	private WebElement trainingExperienceDetailsTextfield;
	@FindBy(xpath="(//div[label[contains(text(),'Upload Proof Document:')]]//input[@id='customFile'])[3]")
	private WebElement trainingExperienceProofDocBrowseButton;	
	@FindBy(xpath="(//div[label[contains(text(),'Upload Proof Document:')]]//button[contains(text(),'Upload')])[3]")
	private WebElement trainingExperienceProofDocUploadButton;
	@FindBy(xpath="(//button[contains(text(),'Add')])[3]")
	private WebElement trainingExperienceDetailsSaveAndSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[3]")
	private WebElement trainingExperienceDetailsCloseButton;
	@FindBy(xpath="(//i[@class='la la-trash delete-icon'])[7]")
	private WebElement deleteAddedThirdTrainingExperienceDetailsButton;	
	@FindBy(xpath="(//i[@class='la la-trash delete-icon'])[6]")
	private WebElement deleteAddedThirdTrainingExperienceDetailsRecordInCaseOfUneducatedButton;
	@FindBy(xpath="//div[label[contains(text(),'Upload Curriculum Vitae(CV) or Resume Document:')]]//input[@id='customFile']")
	private WebElement curriculumVitaeBrowseButton;
	@FindBy(xpath="//div[label[contains(text(),'Upload Curriculum Vitae(CV) or Resume Document:')]]//button[contains(text(),'Upload')]")
	private WebElement curriculumVitaeUploadButton;
	@FindBy(xpath="(//button[contains(text(),'Save changes')])[2]")
	private WebElement saveChangesButton2;
	@FindBy(xpath="(//button[contains(text(),'Save changes')])[3]")
	private WebElement saveChangesButton3;
	@FindBy(xpath="(//button[contains(text(),'Save changes')])[4]")
	private WebElement saveChangesButton4;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[2]")
	private WebElement cancelButton2;
	@FindBy(xpath="//button[text()='Search & Apply']")
	private WebElement searchAndAppluButton;
	//Edit Profile
	@FindBy(xpath="//button[contains(text(),'Edit Profile')]")
	private WebElement editProfileButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	
	public AssessorMyProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickProfile()
	{
		myProfileLink.click();
	}
	public String getNameOfTheApplicant()
	{
		return nameOfTheApplicantTextBox.getAttribute("value");
	}
	public String getGenderOfApplicant()
	{
		return genderTextBox.getAttribute("value");
	}
	public String getDateOfBirth()
	{
		return dateOfBirthTextBox.getAttribute("value");
	}
	public String getReligion()
	{
		return religionTextBox.getAttribute("value");
	}
	public String getCategory()
	{
		return categoryTextBox.getAttribute("value");
	}
	public String getDisability()
	{
		return disabiltyIfAnyTextBox.getAttribute("value");
	}
	public String getAadharNumVerificationStatus()
	{
		return aadharNumberVerificationStatusText.getText();
	}
	public String getPanNumVerificationStatus()
	{
		return panNumberVerificationStatusText.getText();
	}
	public void clickToBrowsePhotoFile()
	{
		photoFileBrowseButton.click();
	}
	public void clickToUploadPhotoFile()
	{
		uploadPhotoFileButton.click();
		
	}
	public void clickSaveChanges1()
	{
		saveChangesButton1.click();
	}
	public void clickContactAndAddress()
	{
		contactAndAddressLink.click();
	}
	public String getMobileNumOfApplicant()
	{
		return mobileNumOfApplicantTextBox.getAttribute("value");
	}
	public String getEmailOfApplicant()
	{
		return emailOfApplicantTextBox.getAttribute("value");
	}
	public String getAddressOfApplicant()
	{
		return applicantAddressTextArea.getAttribute("value");
	}
	public String getNearByLandMark()
	{
		return nearByLandmarkTextBox.getAttribute("value");
	}
	public String getPincode()
	{
		return pincodeTextBox.getAttribute("value");
	}
	public String getState()
	{
		return stateOrUnionTerritoryTextBox.getAttribute("value");
	}
	public String getDistrict()
	{
		return districtOrCityTextBox.getAttribute("value");
	}
	public String getTehsil()
	{
		return tehsilOrMandalTextBox.getAttribute("value");
	}
	public String getParlimentaryConstituency()
	{
		return parlimentoryConstituencyTextBox.getAttribute("value");
	}
	
	public void clickEducationAndWork()
	{
		educationAndWorkLink.click();
	}
		
	public void clickCurriculumVitaeBrowse()
	{
		curriculumVitaeBrowseButton.click();
	}
	public void clickCurriculumVitaeUpload()
	{
		curriculumVitaeUploadButton.click();
	}
	
	public void clickSaveChanges2()
	{
		saveChangesButton2.click();
	}
	public void clickSaveChanges3()
	{
		saveChangesButton3.click();
	}
	public void clickSaveChanges4()
	{
		saveChangesButton4.click();
	}
	public void clickTrainingRequests()
	{
		trainingRequestsLink.click();
	}
	public void clickToAddEducationDetails()
	{
		addEducationDetailsButton.click();
	}
	public void selectEducationAttained(String educationAttained)
	{
		SelectDropDownList.selectDropDownListByVisibleText(educationAttainedDropdownList, educationAttained);
	}
	public void enterDetailsOfEducation(String attainedEducationDetails)
	{
		detailsOfEducationTextfield.clear();
		detailsOfEducationTextfield.sendKeys(attainedEducationDetails);
	}
	public void clickToBrowseForEducationProofDocument()
	{
		educationProofDocBrowseButton.click();
	}
	public void clickToUploadSelectedEducationProofDoc()
	{
		educationProofDocUploadButton.click();
	}
	public void clickToSubmitEducationDetails()
	{
		educationDetailsSaveAndSubmitButton.click();
	}
	public void clickToCloseAddEducationDetailsForm()
	{
		educationDetailsCloseButton.click();
	}
	public void clickToDeleteThirdEducationDetailsRecord()
	{
		deleteAddedThirdEducationDetailsButton.click();
	}
	public void clickToDeleteAddedFirstEducationDetailsRecord()
	{
		deleteAddedFirstEducationDetailsButton.click();
	}
	public void clickToAddIndustrialExperienceDetails()
	{
		addIndustrilExperienceDetailsButton.click();
	}
	public void selectIndustrialSector(String industrialExperienceSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(indutrySectorDropdownList, industrialExperienceSector);
	}
	public void selectIndustrialYears(String industrialExperienceYears)
	{
		SelectDropDownList.selectDropDownListByVisibleText(industryYearsDropdownList, industrialExperienceYears);
	}
	public void selectIndustrialMonths(String industrialExperienceMonths)
	{
		SelectDropDownList.selectDropDownListByVisibleText(indutryMonthsDropdownList, industrialExperienceMonths);
	}
	public void enterDetailsOfIndustrialExperience(String industrialExperienceDetails)
	{
		industryExperienceDetailsTextfield.clear();
		industryExperienceDetailsTextfield.sendKeys(industrialExperienceDetails);
	}
	public void clickToBrowseForIndustrilExperienceProofDocument()
	{
		industrialExperienceProofDocBrowseButton.click();
	}
	public void clickToUploadSelectedIndustrialExperienceProofDoc()
	{
		industrialExperienceProofDocUploadButton.click();
	}
	public void clickToSubmitIndustrialExperienceDetails()
	{
		industrialExperienceDetailsSaveAndSubmitButton.click();
	}
	public void clickToCloseAddIndustrialExperienceDetailsForm()
	{
		industrialExperienceDetailsCloseButton.click();
	}
	public void clickToDeleteThirdIndustrialExperienceDetailsRecord()
	{
		deleteAddedThirdIndustrialExperienceDetailsButton.click();
	}
	public void clickToDeleteAddedThirdIndustrialExperienceDetailsRecordInCaseOfUneducated()
	{
		deleteAddedThirdtIndustrialExperienceRecordInCaseOfUneducatedButton.click();
	}
	public void clickToAddTrainingExperienceDetails()
	{
		addTrainingExperienceDetailsButton.click();
	}
	public void selectTrainingSector(String trainingExperienceSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingSectorDropdownList, trainingExperienceSector);
	}
	public void selectTrainingYears(String trainingExperienceYears)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingYearsDropdownList, trainingExperienceYears);
	}
	public void selectTrainingMonths(String trainingExperienceMonths)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingMonthsDropdownList, trainingExperienceMonths);
	}
	public void enterDetailsOfTrainingExperience(String trainingExperienceDetails)
	{
		trainingExperienceDetailsTextfield.clear();
		trainingExperienceDetailsTextfield.sendKeys(trainingExperienceDetails);
	}
	public void clickToBrowseForTrainingExperienceProofDocument()
	{
		trainingExperienceProofDocBrowseButton.click();
	}
	public void clickToUploadSelectedTrainingExperienceProofDoc()
	{
		trainingExperienceProofDocUploadButton.click();
	}
	public void clickToSubmitTrainingExperienceDetails()
	{
		trainingExperienceDetailsSaveAndSubmitButton.click();
	}
	public void clickToCloseAddTrainingExperienceDetailsForm()
	{
		trainingExperienceDetailsCloseButton.click();
	}
	public void clickToDeleteThirdTrainingExperienceDetailsRecord()
	{
		deleteAddedThirdTrainingExperienceDetailsButton.click();
	}
	public void clickToDeleteAddedThirdTrainingExperienceDetailsRecordInCaseOfUneducated()
	{
		deleteAddedThirdTrainingExperienceDetailsRecordInCaseOfUneducatedButton.click();
	}
	//Edit Profile
	public void clickEditProfile()
	{
		editProfileButton.click();
	}
	public void clickOK()
	{
		okButton.click();
	}
}