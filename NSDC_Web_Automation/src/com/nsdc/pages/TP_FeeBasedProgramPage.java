package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBasedProgramPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Select Start Date']")
	private WebElement startDateOfProjectTextbox;
	@FindBy(xpath="(//span[@class='input-group-text'])[1]")
	private WebElement startDateCalenderButton;
	@FindBy(xpath="//input[@placeholder='Select End Date']")
	private WebElement endDateOfProjectTextbox;
	@FindBy(xpath="(//span[@class='input-group-text'])[2]")
	private WebElement endDateCalenderButton;
	@FindBy(xpath="//label[contains(text(),'Duration of the Project:')]")
	private WebElement projectDurationButton;
	@FindBy(xpath="//input[@placeholder='Enter Project Name']")
	private WebElement projectNameTextbox;
	@FindBy(id="proposingOrganisation")
	private WebElement proposingOrganisationNameTextbox;
	@FindBy(id="implementingOrganisation")
	private WebElement implementingOrganisationNameTextbox;
	@FindBy(xpath="//select[option[text()='Select Financial Model Type']]")
	private WebElement financialModelTypeDropDownList;
	@FindBy(xpath="//input[@placeholder='Select project funded by']")
	private WebElement fundedByTextbox;
	@FindBy(id="target")
	private WebElement targetTextbox;
	@FindBy(id="promoterDetails")
	private WebElement promoterDetailsTextbox;
	@FindBy(id="sanctionLoanAmount")
	private WebElement sanctionLoanAmountTextbox;
	@FindBy(xpath="//select[@ng-reflect-name='moratoriumPeriod']")
	private WebElement moratoriumPeriodDropDownList;
	@FindBy(id="loanDuration")
	private WebElement loanDurationDropDownList;
	@FindBy(id="interestRate")
	private WebElement interestRateDropDownList;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement signedTermsheet_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement signedTermsheet_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement signedProposal_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement signedProposal_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement supportingDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement supportingDocument_UploadFileButton;
	@FindBy(xpath="//button[contains(text(),'Add Sector')]")
	private WebElement addSectorButton;
	@FindBy(xpath="//button[contains(text(),'Add Course to the added sector')]")
	private WebElement addCourseButton;
	@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
	private WebElement saveAndContinueButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton;
	@FindBy(id="sector")
	private WebElement sectorDropDownList;
	@FindBy(id="proposedTrainingTarget")
	private WebElement proposedTrainingTargetTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[5]")
	private WebElement supportingDocument_AddSector_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[5]")
	private WebElement supportingDocument_AddSector_UploadButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[3]")
	private WebElement cancel_AddSectorButton;
	@FindBy(xpath="(//button[contains(text(),'Add')])[4]")
	private WebElement add_AddSectorButton;
	@FindBy(xpath="//input[@placeholder='Enter Course Name']")
	private WebElement courseNameTextbox;
	@FindBy(id="sectorName")
	private WebElement sector_AddCourseDropDownList;
	@FindBy(id="jobRoleMappingType")
	private WebElement jobRoleMappingTypeDropDownList;
	@FindBy(id="jobRoleName")
	private WebElement associatedQPDropDownList;
	@FindBy(id="nsqfLevel")
	private WebElement nsqfLevelTextbox;
	@FindBy(xpath="//textarea[@placeholder='Enter Course Description']")
	private WebElement courseDescriptionTextbox;
	@FindBy(id="issuedCertificateName")
	private WebElement issuedCertificateNameTexbox;
	@FindBy(id="minimumAge")
	private WebElement minimumAgeDropDownList;
	@FindBy(id="minimumEducationRequired")
	private WebElement minimumEducationRequiredDropDownList;
	@FindBy(id="courseDurationInDays")
	private WebElement courseDurationTextbox;
	@FindBy(id="hoursPerDay")
	private WebElement numberOfHoursTextbox;
	@FindBy(id="courseFee")
	private WebElement courseFeeTextbox;
	@FindBy(id="gradingPreferences")
	private WebElement gradingPrefrencesDropDownList;
	@FindBy(xpath="(//input[@id='customFile'])[4]")
	private WebElement courseApprovalDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[4]")
	private WebElement courseApprovalDocument_UploadFileButton;
	@FindBy(xpath="(//button[text()='Add'])[1]")
	private WebElement add_AddCourseButton;
	@FindBy(xpath="(//button[text()='Cancel'])[2]")
	private WebElement cancel_AddCourseButton;
	@FindBy(xpath="//button[contains(text(),'Yes, Add Scheme')]")
	private WebElement addSchemeButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[4]")
	private WebElement cancelSchemeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement oKButton;
	@FindBy(xpath="//button[text()='Re-Submit for Review Again']")
	private WebElement reSubmitForReviewAgainButton;
	
	
	public TP_FeeBasedProgramPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnStartDateOfProject()throws Exception
	{
		startDateOfProjectTextbox.click();
		Thread.sleep(2000);
		startDateOfProjectTextbox.sendKeys(Keys.ENTER, Keys.TAB);
		//Thread.sleep(5000);
		//projectDurationButton.click();
	}
	
	public void clickForNewStartDateOfProject()throws Exception
	{
		startDateOfProjectTextbox.click();
		Thread.sleep(2000);
		startDateOfProjectTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDateOfProject()throws Exception
	{
		endDateOfProjectTextbox.click();
		Thread.sleep(2000);
		endDateOfProjectTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
		//Thread.sleep(2000);
		//projectDurationButton.click();
	}
	
	public void clickForNewEndDateOfProject()throws Exception
	{
		//endDateOfProjectTextbox.click();
		Thread.sleep(2000);
		endDateOfProjectTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void enterNameOfProject(String projectName)
	{
		projectNameTextbox.clear();
		projectNameTextbox.sendKeys(projectName);
	}

	public void enterNameOfProposingOrganisation(String proposedOrganisation)
	{
		proposingOrganisationNameTextbox.clear();
		proposingOrganisationNameTextbox.sendKeys(proposedOrganisation);
	}
	
	public void enterNameOfImplementingOrganisation(String implementingOrganisation)
	{
		implementingOrganisationNameTextbox.clear();
		implementingOrganisationNameTextbox.sendKeys(implementingOrganisation);
	}
	
	public void selectFinancialModelType(String financialModel)
	{
		SelectDropDownList.selectDropDownListByVisibleText(financialModelTypeDropDownList, financialModel);
	}
	
	public void enterProjectFundedBy(String fundedBy)
	{
		fundedByTextbox.clear();
		fundedByTextbox.sendKeys(fundedBy);
	}
	
	public void enterProjectTarget(String target)
	{
		targetTextbox.clear();
		targetTextbox.sendKeys(target);
	}
	
	public void enterPromoterDetails(String promoterDetails)
	{
		promoterDetailsTextbox.clear();
		promoterDetailsTextbox.sendKeys(promoterDetails);
	}
	
	public void enterSanctionLoanAmount(String loanAmount)
	{
		sanctionLoanAmountTextbox.clear();
		sanctionLoanAmountTextbox.sendKeys(loanAmount);
	}
	
	public void selectMoratoriumPeriod(String moratoriumPeriod)
	{
		SelectDropDownList.selectDropDownListByVisibleText(moratoriumPeriodDropDownList, moratoriumPeriod);
	}
	
	public void selectForLoanDuration(String loanduration)
	{
		SelectDropDownList.selectDropDownListByVisibleText(loanDurationDropDownList, loanduration);
	}
	
	public void selectForInterestRate(String interestRate)
	{
		SelectDropDownList.selectDropDownListByVisibleText(interestRateDropDownList, interestRate);
	}
	
	public void clickOnSignedTermsheetBrowseFile()
	{
		signedTermsheet_BrowseFileButton.click();
	}
	
	public void clickOnSignedTermsheetUploadFile()
	{
		signedTermsheet_UploadFileButton.click();
	}
	
	public void clickOnSignedProposalBrowseFile()
	{
		signedProposal_BrowseFileButton.click();
	}
	
	public void clickOnSignedProposalUploadFile()
	{
		signedProposal_UploadFileButton.click();
	}
	
	public void clickOnSupportingDocumentBrowseFile()
	{
		supportingDocument_BrowseFileButton.click();
	}
	
	public void clickOnSupportingDocumentUploadFile()
	{
		supportingDocument_UploadFileButton.click();
	}
	
	public void clickOnAddSector()
	{
		addSectorButton.click();
	}
	
	public void clickOnAddCourse()
	{
		addCourseButton.click();
	}
	
	public void clickOnSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	}
	
	public void enterProposedTrainingTarget(String trainingTarget)
	{
		proposedTrainingTargetTextbox.clear();
		proposedTrainingTargetTextbox.sendKeys(trainingTarget);
	}
	
	public void clickOnSupportingDocumentForAddSector_BrowseButton()
	{
		supportingDocument_AddSector_BrowseFileButton.click();
	}
	
	public void clickOnSupportingDocumentForAddSector_UploadButton()
	{
		supportingDocument_AddSector_UploadButton.click();
	}
	public void clickOnCancel_AddSector()
	{
		cancel_AddSectorButton.click();
	}
	
	public void clickOnAdd_AddSector()
	{
		add_AddSectorButton.click();
	}
	
	public void enterCourseName(String courseName)
	{
		courseNameTextbox.clear();
		courseNameTextbox.sendKeys(courseName);
	}
	
	public void selectSector_AddCourse(String sector_AddCourse)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sector_AddCourseDropDownList, sector_AddCourse);
	}
	
	public void selectJobRoleMappingType(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleMappingTypeDropDownList, jobRole);
	}
	
	public void selectAssociatedQP_JobRoleNameI(String jobRoleName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(associatedQPDropDownList, jobRoleName);
	}
	
	public void enterNSQFLevel(String nsqflevel)
	{
		nsqfLevelTextbox.clear();
		nsqfLevelTextbox.sendKeys(nsqflevel);
	}
	
	public void enterCourseDescription(String courseDescription)
	{
		courseDescriptionTextbox.clear();
		courseDescriptionTextbox.sendKeys(courseDescription);
	}
	
	public void enterNameOfIssuedCertificate(String certificateName)
	{
		issuedCertificateNameTexbox.clear();
		issuedCertificateNameTexbox.sendKeys(certificateName);
	}
	
	public void selectMinimumAge(String minimumAge)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumAgeDropDownList, minimumAge);
	}
	
	public void selectMinimumEducationRequired(String minimumEducation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(minimumEducationRequiredDropDownList, minimumEducation);
	}
	
	public void enterCourseDuration(String courseDuration)
	{
		courseDurationTextbox.clear();
		courseDurationTextbox.sendKeys(courseDuration);
	}
	
	public void enterNumberOfHoursPerDay(String numberOfHours)
	{
		numberOfHoursTextbox.clear();
		numberOfHoursTextbox.sendKeys(numberOfHours);
	}
	
	public void enterCourseFee(String courseFee)
	{
		courseFeeTextbox.clear();
		courseFeeTextbox.sendKeys(courseFee);
	}
	
	public void selectGradingPrefrences(String gradingPrefrences)
	{
		SelectDropDownList.selectDropDownListByVisibleText(gradingPrefrencesDropDownList, gradingPrefrences);
	}
	
	public void clickForCourseApprovalDocument_BrowseFile()
	{
		courseApprovalDocument_BrowseFileButton.click();
	}
	
	public void clickOnCourseApprovalDocument_UploadFile()
	{
		courseApprovalDocument_UploadFileButton.click();
	}
	
	public void clickOnAdd_AddCourse()
	{
		add_AddCourseButton.click();
	}
	
	public void clickOnCancel_AddCourse()
	{
		cancel_AddCourseButton.click();
	}
	
	public void clickOnYes_AddScheme()
	{
		addSchemeButton.click();
	}
	
	public void clickOnCancelScheme()
	{
		cancelSchemeButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}
	
	public void clickOnResubmitForReviewAgain()
	{
		reSubmitForReviewAgainButton.click();
	}

}
