package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.UploadFile;

public class SchemeAdmin_UpdateSchemeDetailsPage {
	WebDriver driver;

	@FindBy(xpath = "//textarea[@placeholder='Enter the Description of the Scheme']")
	private WebElement descriptionOftheSchemeTextArea;
	@FindBy(xpath = "//textarea[@placeholder='Enter the documents required for the scheme']")
	private WebElement documentsRequiredTextArea;
	@FindBy(xpath = "//textarea[@placeholder='Enter the pre-requisite to scheme']")
	private WebElement prerequisiteToSchemeTextArea;
	@FindBy(id = "customFile")
	private WebElement uploadSchemeIconBrowseButton;
	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	private WebElement uploadSchemeIconUploadButton;
	@FindBy(xpath = "//select[@title='Select Disability']")
	private WebElement disabilityForTheSchemeDropDownList;
	@FindBy(xpath = "//select[@title='Select Gender']")
	private WebElement selectGenderCateredDropDownList;
	@FindBy(xpath = "//select[@title='Select Caste']")
	private WebElement selectCasteDropDownList;
	@FindBy(xpath = "//select[@title='Select Religion']")
	private WebElement selectReligionDropDownlist;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveAndcontinueButton;
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previous1Button;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement cancel1Button;

	// Update Scheme Details Second Page

	@FindBy(xpath = "//select[@id='exampleSelect1' and @formcontrolname='moduleType']")
	private WebElement typeOfProjectImplementingAgencyDropDownList;
	@FindBy(xpath = "//select[@id='onBoardingProcess']")
	private WebElement trainingCentreRegistrationProcessDrivenByDropDownList;
	@FindBy(xpath = "//input[@placeholder='Enter registration fee']")
	private WebElement registrationFeeTextBox;
	@FindBy(xpath = "//select[@placeholder='Select scheme type' and @ng-reflect-name='tpType']")
	private WebElement typeOfTrainingPartnerOrPIADropDownList;
	@FindBy(xpath = "//select[@ng-reflect-name='registrationFeetype']")
	private WebElement schemeRegistrationFeeDropDownlist;
	@FindBy(xpath = "//input[@placeholder='If yes, Enter amount need to be paid']")
	private WebElement schemeRegistrationAmountTextBox;
	@FindBy(xpath = "//select[@ng-reflect-name='additionalDocumentsRequired']")
	private WebElement additionalDocumentsRequiredDropDownlist;
	@FindBy(xpath = "//button[contains(text(),'Save and add another Training Partner Type')]")
	private WebElement saveAndAddAnotherTrainingPartnerTypeButton;
	@FindBy(xpath = "//select[@ng-reflect-name='targetAllocationRequired']")
	private WebElement targetAllocationRequiredDropDownList;
	@FindBy(xpath = "//select[@formcontrolname='allocationProhibitionFor']")
	private WebElement targetAllocationProhibitionForDropDownList;
	@FindBy(xpath = "//select[@formcontrolname='allocatedAtLevel']")
	private WebElement targetAllocatedAtLevelDropDownList;
	@FindBy(xpath = "//input[@ng-reflect-name='rulesEffectiveFrom']")
	private WebElement schemeRuleEffectiveDateCalenderButton;
	@FindBy(xpath = "(//button[contains(text(),'Save')])[2]")
	private WebElement saveAndContinue1Button;
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previous2Button;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement cancel2Button;
	@FindBy(xpath = "//td/span")
	private WebElement deleteTypeButton;

	// Update Scheme Details Third Page

	@FindBy(xpath = "//select[@formcontrolname='state']")
	private WebElement locationSpecificityDropDownList;
	@FindBy(xpath = "//select[@formcontrolname='districts']")
	private WebElement selectDistrictDropDownlist;
	@FindBy(xpath = "//label[input[@formcontrolname='aadhaarMandatory']]//span")
	private WebElement aadhaarMandatoryCheckBox;
	@FindBy(xpath = "//label[input[@formcontrolname='specialStateStudentWithoutAadhaarAllowed']]//span")
	private WebElement specialStateStudentWithoutAadhaarAllowedCheckBox;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement addButton;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement cancel3Button;
	@FindBy(xpath = "//button[contains(text(),'Save And Continue')]")
	private WebElement saveAndContinue2Button;
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previous3Button;
	@FindBy(xpath = "//td/div")
	private WebElement deleteCandidateRulesButton;

	// Update Scheme Details Fourth Page

	@FindBy(xpath = "//button[contains(text(),'Edit Scheme Value')]")
	private WebElement editSchemeValueButton;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement okButton;

	public SchemeAdmin_UpdateSchemeDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterDescriptionOftheScheme(String description_Of_the_Scheme) {
		descriptionOftheSchemeTextArea.clear();
		descriptionOftheSchemeTextArea.sendKeys(description_Of_the_Scheme);
	}

	public void enterDocumentsRequired(String documents_Required) {
		documentsRequiredTextArea.clear();
		documentsRequiredTextArea.sendKeys(documents_Required);
	}

	public void enterPrerequisiteToScheme(String prerequisite_To_Scheme) {
		prerequisiteToSchemeTextArea.clear();
		prerequisiteToSchemeTextArea.sendKeys(prerequisite_To_Scheme);
	}

	public void clickBrowseFile() throws Exception {
		uploadSchemeIconBrowseButton.click();
		Thread.sleep(3000);
	}

	public void clickUploadFile() throws InterruptedException {
		uploadSchemeIconUploadButton.click();
		Thread.sleep(3000);
	}

	public void selectDisabilityForthescheme(String disability) {
		SelectDropDownList.selectDropDownListByVisibleText(disabilityForTheSchemeDropDownList, disability);
	}

	public void selectGenderCatered(String gender) {
		SelectDropDownList.selectDropDownListByVisibleText(selectGenderCateredDropDownList, gender);
	}

	public void selectCaste(String caste) {
		SelectDropDownList.selectDropDownListByVisibleText(selectCasteDropDownList, caste);
	}

	public void selectReligion(String religion) {
		SelectDropDownList.selectDropDownListByVisibleText(selectReligionDropDownlist, religion);
	}

	public void clickOnSchemeRuleSetupEffectiveDateFromCalender() throws InterruptedException {
		Thread.sleep(4000);
		schemeRuleEffectiveDateCalenderButton.click();
		Thread.sleep(4000);
	}

	public void clickOnSaveAndSubmit() {
		saveAndcontinueButton.click();
	}

	public void clickOnPrevious() {
		previous1Button.click();
	}

	public void clickOnCancel() {
		cancel1Button.click();
	}

	// Update Scheme Details Second Page

	public void selectTypeOfProjectImplementingAgency(String type_Of_Project_Implementing_Agency) {
		SelectDropDownList.selectDropDownListByVisibleText(typeOfProjectImplementingAgencyDropDownList,type_Of_Project_Implementing_Agency);
	}

	public void selectTrainingCentreRegistrationProcessDrivenBy(String training_Centre_Registration_Process_Driven_By) {
		SelectDropDownList.selectDropDownListByVisibleText(trainingCentreRegistrationProcessDrivenByDropDownList,training_Centre_Registration_Process_Driven_By);
	}

	public void enterRegistrationFee(String registration_Fee) {
		registrationFeeTextBox.clear();
		registrationFeeTextBox.sendKeys(registration_Fee);
	}

	public void selectTypeOfTrainingPartnerOrPIA(String type_Of_Training_Partner_Or_PIA) {
		SelectDropDownList.selectDropDownListByVisibleText(typeOfTrainingPartnerOrPIADropDownList,type_Of_Training_Partner_Or_PIA);
	}

	public void selectSchemeRegistrationFee(String scheme_Registration_Fee) {
		SelectDropDownList.selectDropDownListByVisibleText(schemeRegistrationFeeDropDownlist, scheme_Registration_Fee);
	}

	public void enterSchemeRegistrationAmount(String scheme_Registration_Amount) {
		schemeRegistrationAmountTextBox.clear();
		schemeRegistrationAmountTextBox.sendKeys(scheme_Registration_Amount);
	}

	public void selectAdditionalDocumentsRequired(String additional_Documents_Required) {
		SelectDropDownList.selectDropDownListByVisibleText(additionalDocumentsRequiredDropDownlist,additional_Documents_Required);
	}

	public void clickOnSaveAndAddAnotherTrainingPartnerType() {
		saveAndAddAnotherTrainingPartnerTypeButton.click();
	}

	public void clickOnDeleteType() {
		deleteTypeButton.click();
	}

	public void selectTargetAllocationRequired(String target_Allocation_Required) {
		SelectDropDownList.selectDropDownListByVisibleText(targetAllocationRequiredDropDownList,target_Allocation_Required);
	}

	public void selectTargetAllocationProhibitionFor(String target_Allocation_Prohibition_For) {
		SelectDropDownList.selectDropDownListByVisibleText(targetAllocationProhibitionForDropDownList,target_Allocation_Prohibition_For);
	}

	public void selectTargetAllocatedAtLevel(String target_Allocated_At_Level) {
		SelectDropDownList.selectDropDownListByVisibleText(targetAllocatedAtLevelDropDownList,target_Allocated_At_Level);
	}

	public void clickOnSaveAndContinue1() {
		saveAndContinue1Button.click();
	}

	// Update Scheme Details Third Page

	public void selectLocationSpecificity(String location_Specificity) {
		SelectDropDownList.selectDropDownListByVisibleText(locationSpecificityDropDownList, location_Specificity);
	}

	public void selectDistrict(String select_District) {
		SelectDropDownList.selectDropDownListByVisibleText(selectDistrictDropDownlist, select_District);
	}

	public void clickOnAadhaarMandatory() throws InterruptedException {
		aadhaarMandatoryCheckBox.click();
		Thread.sleep(3000);
	}

	public void clickOnSpecialStateStudentWithoutAadhaarAllowed() throws InterruptedException {
		specialStateStudentWithoutAadhaarAllowedCheckBox.click();
		Thread.sleep(3000);
	}

	public void clickOnAdd() {
		addButton.click();
	}

	public void clickOnSaveAndContinue2() {
		saveAndContinue2Button.click();
	}

	public void clickOnDeleteCandidateRules() {
		deleteCandidateRulesButton.click();
	}

	public void clickOnEditSchemeValue() {
		editSchemeValueButton.click();
	}

	public void clickOnSubmit() {
		submitButton.click();
	}

	public void clickOnOk() {
		okButton.click();
	}
}