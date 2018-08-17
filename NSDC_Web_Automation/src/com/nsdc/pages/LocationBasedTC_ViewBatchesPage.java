package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import sun.swing.SwingAccessor.KeyStrokeAccessor;

public class LocationBasedTC_ViewBatchesPage
{
	WebDriver driver;
	@FindBy(xpath="//span[@class='m-menu__link-text']")
	private WebElement totToAToMTToMALink;
	@FindBy(xpath="//input[@placeholder='Search by Batch ID']")
	private WebElement searchForBatchIDTextfield;
	@FindBy(xpath="//a[@class='m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle']")
	private WebElement actionMenu;
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept/Reject Batch')]")
	private WebElement acceptOrRejectBatchOption;
	@FindBy(xpath="(//div[@class='atc-radio'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(xpath="(//div[@class='atc-radio'])[2]")
	private WebElement rejectBatchRadioButton;
	@FindBy(xpath="//textarea[@formcontrolname='remarks']")
	private WebElement remarksTextArea;
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	//@FindBy(xpath="//button[contains(text(),'Accepted')]")
	@FindBy(linkText="Accepted")
	private WebElement viewAllAcceptedBatchesButton;
	@FindBy(linkText="Ongoing")
	private WebElement viewAllOngoingBatchesLink;
	@FindBy(linkText="Completed")
	private WebElement viewAllCompletedBatchesLink;
	//@FindBy(xpath="//button[contains(text(),'Rejected')]")
	@FindBy(linkText="Rejected")
	private WebElement viewAllRejectedBatchesButton;
	//view batch details option resulted page
	@FindBy(linkText="Batch Details")
	private WebElement batchDetailsSectionLink;
	@FindBy(linkText="Enrolled Candidates")
	private WebElement enrolledCandidatesSectionLink;
	@FindBy(linkText="Applied Candidates")
	private WebElement appliedCandidatesSectionLink;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchForAppliedApplicantTextField;
	@FindBy(xpath="//button[contains(text(),'Verify & Approve')]")
	private WebElement verifyAndApproveTrainerBatchApplicantButton;
	//trainer batch applicant verification page elements
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
			
	public LocationBasedTC_ViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterToSearchForBatchID(String batchID) throws InterruptedException
	{
		searchForBatchIDTextfield.clear();
		Thread.sleep(2000);
		searchForBatchIDTextfield.sendKeys(batchID);
	}
	public void clikToViewActionMenu()
	{
		actionMenu.click();
	}
	public void clickToSelectViewBatchDetailsOption()
	{
		viewBatchDetailsOption.click();
	}
	public void clickToSelectAcceptOrRejectBatchOption()
	{
		acceptOrRejectBatchOption.click();
	}
	public void clickToGoToDashboard()
	{
		totToAToMTToMALink.click();
	}
	public void clickToAcceptBatch()
	{
		acceptBatchRadioButton.click();
	}
	public void clickToRejectBatch()
	{
		rejectBatchRadioButton.click();
	}
	public void enterRemarks(String remarks)
	{
		remarksTextArea.clear();
		remarksTextArea.sendKeys(remarks);
	}
	public void clickToSaveAndSubmit()
	{
		saveAndSubmitButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	public void clickToViewAllAcceptedBatches()
	{
		viewAllAcceptedBatchesButton.click();
	}
	public void clickToViewAllRejectedBatches()
	{
		viewAllRejectedBatchesButton.click();
	}
	public void clickToGoToBatchDetailsSection()
	{
		batchDetailsSectionLink.click();
	}
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
}