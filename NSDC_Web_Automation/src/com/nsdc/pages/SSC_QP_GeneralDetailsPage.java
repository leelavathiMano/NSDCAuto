package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SSC_QP_GeneralDetailsPage 
{
	WebDriver driver;
	@FindBy(xpath="//select[@formcontrolname='countryDesc']")
	private WebElement countryOfOriginDropDownList;
	@FindBy(xpath="//select[@formcontrolname='subSectorName']")
	private WebElement subSectorDropDownList;
	@FindBy(xpath="//select[@formcontrolname='occupationDesc']")
	private WebElement occupationDropDownList;
	@FindBy(xpath="//input[@formcontrolname='alignedTo']")
	private WebElement alignedToNCO_CodeTextBox;
	@FindBy(xpath="//select[@formcontrolname='nsqfLevel']")
	private WebElement NSQF_LevelDropDownList;
	@FindBy(xpath="//input[@formcontrolname='nsqfJstfcn']")
	private WebElement justificationOfNSQF_LevelTextBox;
	@FindBy(xpath="//input[@formcontrolname='jobRole']")
	private WebElement QPNameTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='jobRoleDesc']")
	private WebElement briefDescriptionTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='personalAttrs']")
	private WebElement personalAttributesTextBox;
	
	@FindBy(xpath="//div[label[contains(text(),'Minimum Education Qualification 1')]]/div/select[@formcontrolname='minEduQualDesc']")
	private WebElement minimumEducationQualification1_DropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Minimum Education Qualification 1')]]/div/input[@formcontrolname='minSpecialization']")
	private WebElement qualificationSpecialization1_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'Minimum Education Qualification 2')]]/div/select[@formcontrolname='minEduQualDesc']")
	private WebElement minimumEducationQualification2_DropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Minimum Education Qualification 2')]]/div/input[@formcontrolname='minSpecialization']")
	private WebElement qualificationSpecialization2_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'Minimum Education Qualification 3')]]/div/select[@formcontrolname='minEduQualDesc']")
	private WebElement minimumEducationQualification3_DropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Minimum Education Qualification 3')]]/div/input[@formcontrolname='minSpecialization']")
	private WebElement qualificationSpecialization3_TextBox;
	
	@FindBy(xpath="//select[@formcontrolname='maxEduQualDesc']")
	private WebElement minimumEducationQualificationForTrainingInSchoolDropDownList;
	@FindBy(xpath="//input[@formcontrolname='preReqLicenseTrngDesc']")
	private WebElement preRequisiteLicenceOrTrainingTextBox;
	@FindBy(xpath="//input[@formcontrolname='minJobEntryAge']")
	private WebElement minimumJobEntryAgeTextBox;
	
	@FindBy(xpath="//div[label[contains(text(),'Experience 1')]]/div/select[@formcontrolname='expReqDesc']")
	private WebElement experience1_DropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Experience 1')]]/div/input[@formcontrolname='minSpecialization']")
	private WebElement experienceSpecialization1_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'Experience 2')]]/div/select[@formcontrolname='expReqDesc']")
	private WebElement experience2_DropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Experience 2')]]/div/input[@formcontrolname='minSpecialization']")
	private WebElement experienceSpecialization2_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'Experience 3')]]/div/select[@formcontrolname='expReqDesc']")
	private WebElement experience3_DropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Experience 3')]]/div/input[@formcontrolname='minSpecialization']")
	private WebElement experienceSpecialization3_TextBox;
	
	@FindBy(xpath="//textarea[@formcontrolname='perfCriteria']")
	private WebElement remarksTextBox;
	@FindBy(xpath="//select[@formcontrolname='ctgryDesc']")
	private WebElement costCommonNormsCategoryDropDownList;
	@FindBy(xpath="//select[@formcontrolname='bucketDesc']")
	private WebElement bucketDropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Technical/Non-Technical')]]/div/select[@formcontrolname='paramDesc']")
	private WebElement technicalOrNonTechnicalDropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Manufacturing/Services')]]/div/select[@formcontrolname='paramDesc']")
	private WebElement manufacturingOrServicesDropDownList;
	@FindBy(xpath="//div[label[contains(text(),'Organized/Unorganized')]]/div/select[@formcontrolname='paramDesc']")
	private WebElement organizedOrUnorganizedDropDownList;
	@FindBy(xpath="//input[@type='file']")
	private WebElement QP_Image_BrowseButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement uploadButton;
	@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
	private WebElement saveAndContinueButton;
	@FindBy(xpath="//button[contains(text(),'Save As Draft')]")
	private WebElement saveAsDraftButton;
	
	public SSC_QP_GeneralDetailsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void selectCountryOfOrigin(String country)
	{
		SelectDropDownList.selectDropDownListByVisibleText(countryOfOriginDropDownList, country);
	}
	
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropDownList, subSector);
	}
	
	public void selectOccupation(String occupation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(occupationDropDownList, occupation);
	}
	
	public void enterAlignedToNCO_Code(String code)
	{
		alignedToNCO_CodeTextBox.clear();
		alignedToNCO_CodeTextBox.sendKeys(code);
	}
	
	public void selectNSQF_Level(String level)
	{
		SelectDropDownList.selectDropDownListByVisibleText(NSQF_LevelDropDownList, level);
	}
	
	public void enterJustificationOfNSQF_Level(String justification)
	{
		justificationOfNSQF_LevelTextBox.clear();
		justificationOfNSQF_LevelTextBox.sendKeys(justification);
	}
	
	public void enterQP_Name(String name)
	{
		QPNameTextBox.clear();
		QPNameTextBox.sendKeys(name);
	}
	
	public void enterBriefDescription(String brief)
	{
		briefDescriptionTextBox.clear();
		briefDescriptionTextBox.sendKeys(brief);
	}
	
	public void enterPersonalAttributes(String attributes)
	{
		personalAttributesTextBox.clear();
		personalAttributesTextBox.sendKeys(attributes);
	}
	
	
	
	
	public void selectMinimumEducationQualification1ForJob(String qualification1)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumEducationQualification1_DropDownList, qualification1);
	}
	
	public void enterQualificationSpecialization1ForJob(String job1_specialization)
	{
		qualificationSpecialization1_TextBox.clear();
		qualificationSpecialization1_TextBox.sendKeys(job1_specialization);
	}
	
	public void selectMinimumEducationQualification2ForJob(String qualification2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumEducationQualification2_DropDownList, qualification2);
	}
	
	public void enterQualificationSpecialization2ForJob(String job2_specialization)
	{
		qualificationSpecialization2_TextBox.clear();
		qualificationSpecialization2_TextBox.sendKeys(job2_specialization);
	}
	
	public void selectMinimumEducationQualification3ForJob(String qualification3)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumEducationQualification3_DropDownList, qualification3);
	}
	
	public void enterQualificationSpecialization3ForJob(String job3_specialization)
	{
		qualificationSpecialization3_TextBox.clear();
		qualificationSpecialization3_TextBox.sendKeys(job3_specialization);
	}
	
	
	public void selectMinimumEducationQualificationForTrainingInSchool(String training)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumEducationQualificationForTrainingInSchoolDropDownList, training);
	}
	
	public void enterPreRequisiteLicenceOrTraining(String licence)
	{
		preRequisiteLicenceOrTrainingTextBox.clear();
		preRequisiteLicenceOrTrainingTextBox.sendKeys(licence);
	}
	
	public void enterMinimumJobEntryAge(String age)
	{
		minimumJobEntryAgeTextBox.clear();
		minimumJobEntryAgeTextBox.sendKeys(age);
	}
	
	
	
	public void selectExperience1(String experienceRequired1)
	{
		SelectDropDownList.selectDropDownListByVisibleText(experience1_DropDownList, experienceRequired1);
	}
	
	public void enterExperienceSpecialization1(String experienceSpecialization1)
	{
		experienceSpecialization1_TextBox.clear();
		experienceSpecialization1_TextBox.sendKeys(experienceSpecialization1);
	}
	
	public void selectExperience2(String experienceRequired2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(experience2_DropDownList, experienceRequired2);
	}
	
	public void enterExperienceSpecialization2(String experienceSpecialization2)
	{
		experienceSpecialization2_TextBox.clear();
		experienceSpecialization2_TextBox.sendKeys(experienceSpecialization2);
	}
	
	public void selectExperience3(String experienceRequired3)
	{
		SelectDropDownList.selectDropDownListByVisibleText(experience3_DropDownList, experienceRequired3);
	}
	
	public void enterExperienceSpecialization3(String experienceSpecialization3)
	{
		experienceSpecialization3_TextBox.clear();
		experienceSpecialization3_TextBox.sendKeys(experienceSpecialization3);
	}
	
	
	
	public void enterRemarks(String remarks)
	{
		remarksTextBox.clear();
		remarksTextBox.sendKeys(remarks);
	}
	
	public void selectCostCommonNormsCategory(String normsCategory)
	{
		SelectDropDownList.selectDropDownListByVisibleText(costCommonNormsCategoryDropDownList, normsCategory);
	}
	
	public void selectBucket(String bucket)
	{
		SelectDropDownList.selectDropDownListByVisibleText(bucketDropDownList, bucket);
	}
	
	public void selectTechnicalOrNonTechnical(String tech)
	{
		SelectDropDownList.selectDropDownListByVisibleText(technicalOrNonTechnicalDropDownList, tech);
	}
	
	public void selectManufacturingOrServices(String service)
	{
		SelectDropDownList.selectDropDownListByVisibleText(manufacturingOrServicesDropDownList, service);
	}
	
	public void selectOrganizedOrUnorganized(String org)
	{
		SelectDropDownList.selectDropDownListByVisibleText(organizedOrUnorganizedDropDownList, org);
	}
	
	public void clickOnBrowseForQP_image()
	{
		QP_Image_BrowseButton.click();
	}
	
	public void clickOnuploadForQP_image()
	{
		uploadButton.click();
	}
	
	public void clickOnSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	
	public void clickOnSaveAsDraft()
	{
		saveAsDraftButton.click();
	}
} 	
