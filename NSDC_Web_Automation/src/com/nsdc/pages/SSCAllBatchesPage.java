package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nsdc.generic.SelectDropDownList;

public class SSCAllBatchesPage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by ID']")
	private WebElement searchByIDTextBox;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextBox;
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement actionMenu;
	@FindBy(xpath="//span[contains(text(),'View Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Assign Master Trainer')]")
	private WebElement assignMasterTrainerButton;
	@FindBy(xpath="//span[contains(text(),'Assign Assessment Agency')]")
	private WebElement assignAssessmentAgencyButton;
	@FindBy(xpath="//select[@class='form-control ng-pristine ng-valid ng-touched']")
	private WebElement assignMasterTrainerDropDownList;
	@FindBy(xpath="//button[contains(text(),'Assign')]")
	private WebElement assignButton;
	@FindBy(xpath="(//span[contains(text(),'Assign')])[1]")
	private WebElement assignButton1;
	@FindBy(xpath="(//span[contains(text(),'Assign')])[2]")
	private WebElement assignButton2;
	@FindBy(xpath="//button[contains(text(),'Yes, assign it!')]")
	private WebElement assignItButton;
	//@FindBy(xpath="//button[contains(text(),'Pending')]")
	@FindBy(linkText="Pending")
	private WebElement  viewPendingBatchesButton;
	//@FindBy(xpath="//button[contains(text(),'Rejected')]")
	@FindBy(linkText="Rejected")
	private WebElement viewRejectedBatchesButton;
	//@FindBy(xpath="//button[contains(text(),'Rescheduled')]")
	@FindBy(linkText="Rescheduled")
	private WebElement viewRescheduledBatchesButton;
	//@FindBy(xpath="//button[contains(text(),'Cancelled')]")
	@FindBy(linkText="Cancelled")
	private WebElement viewCancelledBatches;
	//@FindBy(xpath="//button[contains(text(),'Published')]")
	@FindBy(linkText="Published")
	private WebElement viewPublisshedBatchesButton;
	//@FindBy(xpath="//button[contains(text(),'On-going')]")
	@FindBy(linkText="On-going")
	private WebElement viewOnGoingBatchesButton;
	//@FindBy(xpath="//button[contains(text(),'Completed')]")
	@FindBy(linkText="Completed")
	private WebElement viewCompletedBatchesButton;
	@FindBy(xpath="//span[contains(text(),'Re-Assign Training Centre')]")
	private WebElement reAssignTrainingCentreOption;
	@FindBy(xpath=" //span[contains(text(),' Rescheduled Batch')]")
	private WebElement resheduleBatchOption;
	@FindBy(linkText="Assign Batch")
	private WebElement assignBatchOption;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	@FindBy(xpath="//span[contains(text(),'Assign Master Trainer')]")
	private WebElement assignMasterTrainerOption;
	@FindBy(xpath="//span[contains(text(),'Assign Assessment Agency')]")
	private WebElement assignAssessmentAgencyOption;
	//@FindBy(xpath="(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]")
	@FindBy(xpath="(//select)[1]")
	private WebElement viewDetailsAssignMasterTrainerDropdownList;
	//@FindBy(xpath="(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
	@FindBy(xpath="(//select)[2]")
	private WebElement viewDetailsAssignAssessmentAgencyDropdownList;
	@FindBy(xpath="(//select)[2]")
	private WebElement assignOnlyMasterTrainerOptionDropdownList;
	@FindBy(xpath="(//select)[3]")
	private WebElement assignOnlyAssessmentAgencyOptionDropdownList;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[1]")
	private WebElement sedAssignButton1;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[2]")
	private WebElement sedAssignButton2;
	//Verifying Applied Trainer Batch applicants from SSC End after TC Approval
	@FindBy(xpath="//button[contains(text(),'Enrolled Candidates')]")
	private WebElement enrolledCandidatesSectionLink;
	@FindBy(xpath="//button[contains(text(),'Applied Candidates')]")
	private WebElement appliedCandidatesSectionLink;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchForAppliedApplicantTextField;
	@FindBy(xpath="//button[contains(text(),'erify & Approve')]")
	private WebElement verifyAndApproveTrainerBatchApplicantButton;
	@FindBy(linkText="Personal Information")
	private WebElement personalInformationOfTrainerBatchApplicantSectionLink;
	@FindBy(partialLinkText="Contact")
	private WebElement contactAndAddressOfTrainerBatchApplicantSectionLink;
	@FindBy(linkText="Education & Work")
	private WebElement educationAndWorkOfTrainerBatchApplicantSectionLink;
	@FindBy(xpath="(//button[@class='close'])[1]")
	private WebElement closeTrainerBatchApplicantVerificationPageButton;
	@FindBy(xpath="(//button[text()='Download'])[1]")
	private WebElement disabilityDocumentDownloadButton;
	@FindBy(xpath="//button[contains(text(),'Approve Candidate')]")
	private WebElement approveTrainerBatchApplicantButton;
	@FindBy(xpath="//button[contains(text(),'Reject Candidate')]")
	private WebElement rejectTrainerBatchApplicantButton;
	@FindBy(xpath="//textarea[@name='remarks']")
	private WebElement reasonForRejectingCandidateTextarea;
	@FindBy(linkText="View Details")
	private WebElement viewDetailsOfEnrolledTrainerBatchApplicantLink;
	@FindBy(xpath="(//button[contains(text(),'Reject Candidate')])[2]")
	private WebElement rejectingTrainerBatchApplicantFinalButton;
	@FindBy(xpath="(//a/span[2])[3]")
	private WebElement toTtoAtoMTtoMADashboardLink;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchForTrainingCentreTextBox;
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;		
	
	public SSCAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void enterSearchForBatchID(String batchID)
	{
		searchByIDTextBox.clear();
		searchByIDTextBox.sendKeys(batchID);
	}
	public void clickToCancel()
	{
		cancelButton.click();
	}
	
	public void enterSearchByWord(String search_By_Keyword) throws InterruptedException
	{
		searchByKeywordTextBox.clear();
		searchByKeywordTextBox.sendKeys(search_By_Keyword);
	}
	public void enterToSearchForTrainingCentreID(String trainingCentreID)
	{
		searchForTrainingCentreTextBox.clear();
		searchForTrainingCentreTextBox.sendKeys(trainingCentreID);
	}
	public void clickToSearch()
	{
		searchButton.click();
	}
	public void clickToViewActionMenuOptions()
	{
		actionMenu.click();
	}
	public void clicktoSelectViewBatchDetailsOption()
	{
		viewBatchDetailsOption.click();
	}
	
	public void clickAssignMasterTrainerButton()
	{
		assignMasterTrainerButton.click();
	}
	
	public void clickAssessmentAgencyButton()
	{
		assignAssessmentAgencyButton.click();
	}
	
	public void selectAssignMasterTrainerDropDownList(String assign_MasterTrainer)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignMasterTrainerDropDownList, assign_MasterTrainer);
	}
	
	public void clickAssignButton()
	{
		assignButton.click();
	}
	public void clickSEDAssignButton1()
	{
		sedAssignButton1.click();
	}
	public void clickSEDAssignButton2()
	{
		sedAssignButton2.click();
	}
	
	public void clickAssignItButton()
	{
		assignItButton.click();
	}
	public void clickToViewPendingBatches()
	{
		viewPendingBatchesButton.click();
	}
	public void clickToViewRejectedBatches()
	{
		viewRejectedBatchesButton.click();
	}
	public void clickToViewRescheduledBatches()
	{
		viewRescheduledBatchesButton.click();
	}
	public void clickToViewCancelledBatches()
	{
		viewCancelledBatches.click();
	}
	public void clickToViewPublishedBatches()
	{
		viewPublisshedBatchesButton.click();
	}
	public void clickToViewOnGoingBatches()
	{
		viewOnGoingBatchesButton.click();
	}
	public void clickToViewCompletedBatches()
	{
		viewCompletedBatchesButton.click();
	}
	public void clickToReAssignTrainingCentre()
	{
		reAssignTrainingCentreOption.click();
	}
	public void clickToReSchedueBatch()
	{
		resheduleBatchOption.click();
	}
	public void clickToAssignBatch()
	{
		assignBatchOption.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	public void clickToChooseAssignMasterTrainerOption()
	{
		assignMasterTrainerOption.click();
	}
	public void clickToChooseAssignAssessmentAgencyOption()
	{
		assignAssessmentAgencyOption.click();
	}
	public void selectMasterTrainerForSEDJobrole(String sedMasterTrainer)
	{
		SelectDropDownList.selectDropDownListByVisibleText(viewDetailsAssignMasterTrainerDropdownList, sedMasterTrainer);
	}
	public void selectAssessmentAgencyForSEDJobRole(String sedAssessmentAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(viewDetailsAssignAssessmentAgencyDropdownList, sedAssessmentAgency);
	}
	public void selectOnlyMasterTrainerForSEDJobrole(String sedMasterTrainer)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignOnlyMasterTrainerOptionDropdownList, sedMasterTrainer);
	}
	public void selectOnlyAssessmentAgencyForSEDJobRole(String sedAssessmentAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignOnlyAssessmentAgencyOptionDropdownList, sedAssessmentAgency);
	}
	public void clickToAssignMasterTrainer()
	{
		assignButton1.click();
	}
	public void clickToAssignAssessmentAgency()
	{
		//assignButton2.click();
		assignButton1.click();
	}
	public void clickToGoBack()
	{
		backButton.click();
	}
	//Verifying Trainer Batch Applicants from SSC End
	public void clickToGoToEnrolledCandidatesSection()
	{
		enrolledCandidatesSectionLink.click();
	}
	public void clickToGoToAppliedCandidatesSection()
	{
		appliedCandidatesSectionLink.click();
	}
	public void enterToSearchForBatchApplicants(String batchApplicant)
	{
		searchForAppliedApplicantTextField.clear();
		searchForAppliedApplicantTextField.sendKeys(batchApplicant);
	}
	public void clickToVerifyAndApproveTrainerBatchApplicant()
	{
		verifyAndApproveTrainerBatchApplicantButton.click();
	}
	public void clickToViewPersonalInformationOfTrainerBatchApplicant()
	{
		personalInformationOfTrainerBatchApplicantSectionLink.click();
	}
	public void clickToViewConatctAndAddressOfTrainerBatchApplicant()
	{
		contactAndAddressOfTrainerBatchApplicantSectionLink.click();
	}
	public void clickToViewEducationAndWorkOfTrainerBatchApplicant()
	{
		educationAndWorkOfTrainerBatchApplicantSectionLink.click();
	}
	public void clickToCloseTrainerBatchApplicantVerificationPage()
	{
		closeTrainerBatchApplicantVerificationPageButton.click();
	}
	public void clickToViewOrDownloadDisabilityDocumentOfTrainerBatchApplicant() throws InterruptedException
	{
		disabilityDocumentDownloadButton.click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.CONTROL,"w");
		Thread.sleep(2000);
	}
	public void clickToApproveTrainerBatchApplicant()
	{
		approveTrainerBatchApplicantButton.click();
	}
	public void clickToRejectTrainerBatchApplicant()
	{
		rejectTrainerBatchApplicantButton.click();
	}
	public void enterReasonForRejectingTrainerBatchApplicant(String reasonForRejectingTrainerBatchApplicant)
	{
		reasonForRejectingCandidateTextarea.clear();
		reasonForRejectingCandidateTextarea.sendKeys(reasonForRejectingTrainerBatchApplicant);
	}
	public void clickToRejectTrainerBatchApplicantFinal()
	{
		rejectingTrainerBatchApplicantFinalButton.click();
	}
	public void clickToViewDetailsOfEnrolledTrainerBatchApplicant()
	{
		viewDetailsOfEnrolledTrainerBatchApplicantLink.click();
	}
	public void verifyingPersonalInformationOfTrainerBatchApplicant(String name, String gender, String language, String religion, String category, String disability)
	{
		//verifying personal information of trainer batch applicant
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]")).getText().trim(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+gender+"')]")).getText().trim(), gender);
		//Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+assessorDateOfBirth+"')]")).getText().trim(), assessorDateOfBirth);
		if(language.equalsIgnoreCase("Kannada,English,Hindi"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Kannada')]")).getText().replaceAll(" ", "")+driver.findElement(By.xpath("//span[contains(text(),'English')]")).getText().replaceAll(" ", "")+driver.findElement(By.xpath("//span[contains(text(),'Hindi')]")).getText().replaceAll(" ", ""), language);
		}
		else if(language.equalsIgnoreCase("Kannada,Hindi"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Kannada')]")).getText().replaceAll(" ", "")+driver.findElement(By.xpath("//span[contains(text(),'Hindi')]")).getText().replaceAll(" ", ""), language);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Hindi')]")).getText().replaceAll(" ", ""), language);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div")).getText().trim(), religion);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div")).getText().trim(), category);
		if(disability.equalsIgnoreCase("none"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Disability (If Any):')]]/div")).getText().trim(), "No Data");
		}
		else 
		{
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Disability (If Any):')]]/div")).getText().trim(), "Download");
		}
		
	}
	public void verifyingConatctAndAddressOfTrainerBatchApplicant(String mobile, String email, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency)
	{
		
		//verifying Contact and Address of trainer batch applicant
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+email+"')]")).getText().trim(), email);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+address+"')]")).getText().trim(), address);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Near by Landmark:')]]/div")).getText().trim(), landmark);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode:')]]/div")).getText().trim(), pincode);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State/ Union Territory:')]]/div")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District/ City:')]]/div")).getText().trim(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil/ Mandal:')]]/div")).getText().trim(), mandal);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Parliamentary Constituency:')]]/div")).getText().trim(), parliamentaryConstituency);
	}
	public void verifyingEducationAndWorkOfTrainerBatchApplicant(String education1, String edu_details1, String education2, String edu_details2, String education3, String industrial_sector1, String industrialExperienceDetails1, String industrial_years1, String industrial_months1, String industrial_sector2, String industrialExperienceDetails2, String industrial_years2, String industrial_months2, String training_sector1, String trainingExperienceDetails1, String trainingExperienceYears1, String trainingExperienceMonths1, String training_sector2, String trainingExperienceDetails2, String trainingExperienceYears2, String trainingExperienceMonths2)
	{
		//verifying Education and Work Details of Trainer batch applicant
		
		if(education1.equalsIgnoreCase("uneducated") && education2.equalsIgnoreCase("uneducated") && education3.equalsIgnoreCase("uneducated"))
		{
			//verifying education details - in case of Un-Educated applicant
			Assert.assertTrue(driver.findElements(By.xpath("(//table[@class='table table-striped']/tbody)[2]/tr")).size()<2, "OMG! Education Record Present, eventhough applicant is uneducated");
			//verifying industrial experience
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrial_sector1+"')])[1]")).getText().trim(), industrial_sector1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrialExperienceDetails1+"')])[1]")).getText().trim(), industrialExperienceDetails1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[1]")).getText().replaceAll(" ", ""), industrial_years1+"."+industrial_months1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrial_sector2+"')])[1]")).getText().trim(), industrial_sector2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrialExperienceDetails2+"')])[2]")).getText().trim(), industrialExperienceDetails2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[3]")).getText().replaceAll(" ", ""), industrial_years2+"."+industrial_months2);
			//verifying training experience
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+training_sector1+"')])[2]")).getText().trim(), training_sector1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+trainingExperienceDetails1+"')])[1]")).getText().trim(), trainingExperienceDetails1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[5]")).getText().replaceAll(" ", ""), trainingExperienceYears1+"."+trainingExperienceMonths1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+training_sector2+"')])[1]")).getText().trim(), training_sector2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+trainingExperienceDetails2+"')])[2]")).getText().trim(), trainingExperienceDetails2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[7]")).getText().replaceAll(" ", ""), trainingExperienceYears2+"."+trainingExperienceMonths2);
		}
		else
		{
			//verifying education details
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education1+"']")).getText().trim(), education1);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+edu_details1+"']")).getText(), edu_details1);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+education2+"']")).getText().trim(), education2);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+edu_details2+"']")).getText().trim(), edu_details2);
			//verifying industrial experience
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrial_sector1+"')])[1]")).getText().trim(), industrial_sector1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrialExperienceDetails1+"')])[1]")).getText().trim(), industrialExperienceDetails1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[3]")).getText().replaceAll(" ", ""), industrial_years1+"."+industrial_months1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrial_sector2+"')])[1]")).getText().trim(), industrial_sector2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+industrialExperienceDetails2+"')])[2]")).getText().trim(), industrialExperienceDetails2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[5]")).getText().replaceAll(" ", ""), industrial_years2+"."+industrial_months2);
			//verifying training experience
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+training_sector1+"')])[2]")).getText().trim(), training_sector1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+trainingExperienceDetails1+"')])[1]")).getText().trim(), trainingExperienceDetails1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[7]")).getText().replaceAll(" ", ""), trainingExperienceYears1+"."+trainingExperienceMonths1);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+training_sector2+"')])[1]")).getText().trim(), training_sector2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+trainingExperienceDetails2+"')])[2]")).getText().trim(), trainingExperienceDetails2);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[span])[9]")).getText().replaceAll(" ", ""), trainingExperienceYears2+"."+trainingExperienceMonths2);
		}
	}
	public void clickToGoTotoTtoAtoMTtoMADashboard()
	{
		toTtoAtoMTtoMADashboardLink.click();
	}
}	
	
	
	
	
	
	
	
