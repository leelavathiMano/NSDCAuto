package com.nsdc.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nsdc.generic.UploadFile;

public class AssessorMyProfilePage
{
	WebDriver driver;
	
	@FindBy(xpath="(//a[@class='m-menu__link m-menu__toggle'])[3]")
	//@FindBy(linkText="My Profile ")
	private WebElement myProfileLink;
	@FindBy(xpath="//span[@class='m-card-profile__name']")
	private WebElement profileNameText;
	@FindBy(linkText="Personal Information")
	private WebElement personalInformationLink;
	@FindBy(linkText="Contact & Address")
	private WebElement contactAndAddressLink;
	@FindBy(linkText="Education & Work")
	private WebElement educationAndWorkLink;
	@FindBy(linkText="My Associations")
	private WebElement myAssociationsLink;
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
	@FindBy(xpath="//div[label[contains(text(),'AADHAAR Number:')]]/div/label")
	private WebElement aadharNumberVerificationStatusText;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement browseFilebutton1;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadButton1;
	@FindBy(xpath="//div[label[contains(text(),'Select Applicant Category:')]]/div/select")
	private WebElement applicantCategoryMultiSelectDropdown;
	@FindBy(xpath="(//button[contains(text(),'v')])[1]")
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
	private WebElement addButton1;
	@FindBy(xpath="(//table)[1]/tbody/tr/td[2]")
	private WebElement educationAttainedTypeTableElement;
	@FindBy(xpath="(//table)[1]/tbody/tr/td[3]")
	private WebElement detailsOfEducationTableElement;
	@FindBy(xpath="(//table)[1]/tbody/tr/td[4]")
	private WebElement proofDocumentTableElement1;
	@FindBy(xpath="(//i[@title='remove'])[1]")
	private WebElement removeIcon1;
	//Industrial
	@FindBy(xpath="(//button[contains(text(),'Add')])[2]")
	private WebElement addButton2;
	@FindBy(xpath="(//table)[2]/tbody/tr/td[2]")
	private WebElement relevantSector1TableElement;
	@FindBy(xpath="(//table)[2]/tbody/tr/td[3]")
	private WebElement detailsOfIndustrialExperienceTableElement;
	@FindBy(xpath="(//table)[2]/tbody/tr/td[4]")
	private WebElement totalExperienceTableElement;
	@FindBy(xpath="(//table)[2]/tbody/tr/td[5]")
	private WebElement proofDocumentTableElement2;
	@FindBy(xpath="(//i[@title='remove'])[2]")
	private WebElement removeIcon2;
	//Training
	@FindBy(xpath="(//button[contains(text(),'Add')])[3]")
	private WebElement addButton3;
	@FindBy(xpath="(//table)[3]/tbody/tr/td[2]")
	private WebElement relevantSector2TableElement;
	@FindBy(xpath="(//table)[3]/tbody/tr/td[3]")
	private WebElement detailsOfTrainingExperienceTableElement;
	@FindBy(xpath="(//table)[3]/tbody/tr/td[4]")
	private WebElement totalTrainingExperienceTableElement;
	@FindBy(xpath="(//table)[3]/tbody/tr/td[5]")
	private WebElement proofDocumentTableElement3;
	@FindBy(xpath="(//i[@title='remove'])[3]")
	private WebElement removeIcon3;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement curriculumVitaeBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement curriculumVitaeUploadButton;
	@FindBy(xpath="(//button[contains(text(),'v')])[2]")
	private WebElement saveChangesButton2;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[2]")
	private WebElement cancelButton2;
	@FindBy(xpath="//button[text()='Search & Apply']")
	private WebElement searchAndAppluButton;
	
	
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
	public void clickBrowseFile()
	{
		browseFilebutton1.click();
	}
	public void clickUploadfile()
	{
		uploadButton1.click();
		
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
	public String getEducationAttainedType()
	{
		return educationAttainedTypeTableElement.getText();
	}
	public String getDetailsOfEducation()
	{
		return detailsOfEducationTableElement.getText();
	}
	public String getProofDocumentPresence()
	{
		return proofDocumentTableElement1.getText();
	}
	public String getIndustrialRelaventSector()
	{
		return relevantSector1TableElement.getText();
	}
	public String getIndustrialExperienceDetails()
	{
		return detailsOfIndustrialExperienceTableElement.getText();
	}
	public String getTotalIndustrialExperience()
	{
		return totalExperienceTableElement.getText();
	}
	public String getIndustrialExperienceProofDocPresence()
	{
		return proofDocumentTableElement2.getText();
	}
	public String getTrainingRelaventSector()
	{
		return relevantSector2TableElement.getText();
	}
	public String getTrainingExperienceDetails()
	{
		return detailsOfTrainingExperienceTableElement.getText();
	}
	public String getTotalTrainingExperience()
	{
		return totalTrainingExperienceTableElement.getText();
	}
	public String getTrainingProofDocPresence()
	{
		return proofDocumentTableElement3.getText();
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
	public void clickMyAssociations()
	{
		myAssociationsLink.click();
	}
	
}
