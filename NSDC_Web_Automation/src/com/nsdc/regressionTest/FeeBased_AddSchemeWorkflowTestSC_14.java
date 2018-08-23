package com.nsdc.regressionTest;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.FDA_DashboardPage;
import com.nsdc.pages.FDA_OnboardingRequestPage;
import com.nsdc.pages.FDA_SelectedSchemePage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.TP_FeeBasedProgramPage;
import com.nsdc.pages.TP_MySchemeDashboardPage;
import com.nsdc.pages.TP_SelectSchemePage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class FeeBased_AddSchemeWorkflowTestSC_14 extends TestConfiguration
{
	
	@DataProvider
	public Object[][] addScheme_FeeBased()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01");
	}
	
	@Test(dataProvider="addScheme_FeeBased")
	public void addSchemeTC_01(String sno, String tpUsername, String tpPassword, String startDate, String endDate, String projectName, String proposingOrganisation, String implementingOrganisation, String financialModel, String fundedBy, String target, String promoterDetails, String loanAmount, String moratoriumPeriod, String loanduration, String interestRate, String signedTermsheetFile, String signedProposalFile, String otherSupportingFile, String sector, String trainingTarget, String addSectorSupportingFile, String courseName, String sector_AddCourse, String jobRole, String jobRoleName, String nsqfLevel, String courseDescription, String certificateName, String minimumAge, String minimumEducation, String courseDuration, String numberOfHours, String courseFee, String gradingPrefrences, String courseApprovalFile) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpd = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(5000);
		tpd.clickOnMySchemes();
		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
		Thread.sleep(3000);
		tpms.clickOnAddSchemeOrProgram();
		TP_SelectSchemePage tpss = new TP_SelectSchemePage(driver);
		Thread.sleep(5000);
		tpss.clickOnSelectFeeBased();
		TP_FeeBasedProgramPage tpfb = new TP_FeeBasedProgramPage(driver);
		Thread.sleep(3000);
		tpfb.clickOnStartDateOfProject();
		startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 3, startDate);
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 6, startDate);
		tpfb.clickOnEndDateOfProject();
		endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 4, endDate);
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 7, endDate);
		tpfb.enterNameOfProject(projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 3, projectName);
		tpfb.enterNameOfProposingOrganisation(proposingOrganisation);
		tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
		tpfb.selectFinancialModelType(financialModel);
		if(financialModel.equals("Funded"))
		{
			tpfb.enterProjectFundedBy(fundedBy);
			tpfb.enterProjectTarget(target);
			tpfb.enterPromoterDetails(promoterDetails);
			tpfb.enterSanctionLoanAmount(loanAmount);
			tpfb.selectMoratoriumPeriod(moratoriumPeriod);
			tpfb.selectForLoanDuration(loanduration);
			tpfb.selectForInterestRate(interestRate);
		}
		else if(financialModel.equals("Non-Funded"))
		{
			tpfb.enterProjectTarget(target);
			tpfb.enterPromoterDetails(promoterDetails);
		}
		Thread.sleep(3000);
		tpfb.clickOnSignedTermsheetBrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(signedTermsheetFile);
		Thread.sleep(3000);
		tpfb.clickOnSignedTermsheetUploadFile();
		Thread.sleep(3000);
		tpfb.clickOnSignedProposalBrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(signedProposalFile);
		Thread.sleep(3000);
		tpfb.clickOnSignedProposalUploadFile();
		Thread.sleep(3000);
		tpfb.clickOnSupportingDocumentBrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(otherSupportingFile);
		Thread.sleep(3000);
		tpfb.clickOnSupportingDocumentUploadFile();
		Thread.sleep(3000);
		tpfb.clickOnAddSector();
		Thread.sleep(2000);
		tpfb.selectSector(sector);
		tpfb.enterProposedTrainingTarget(trainingTarget);
		Thread.sleep(2000);
		tpfb.clickOnSupportingDocumentForAddSector_BrowseButton();
		Thread.sleep(3000);
		UploadFile.upload(addSectorSupportingFile);
		Thread.sleep(3000);
		tpfb.clickOnSupportingDocumentForAddSector_UploadButton();
		Thread.sleep(4000);
		tpfb.clickOnAdd_AddSector();
		Thread.sleep(3000);
		tpfb.clickOnAddCourse();
		Thread.sleep(2000);
		tpfb.enterCourseName(courseName);
		tpfb.selectSector_AddCourse(sector_AddCourse);
		tpfb.selectJobRoleMappingType(jobRole);
		if(jobRole.equals("QP-NOS"))
		{
			Thread.sleep(2000);
			tpfb.selectAssociatedQP_JobRoleNameI(jobRoleName);
			nsqfLevel = driver.findElement(By.xpath("(//input[@ng-reflect-name='nsqfLevel'])[2]")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 26, nsqfLevel);
			tpfb.enterCourseDescription(courseDescription);
			tpfb.enterNameOfIssuedCertificate(certificateName);
			tpfb.selectMinimumAge(minimumAge);
			tpfb.selectMinimumEducationRequired(minimumEducation);
			tpfb.enterCourseDuration(courseDuration);
			Thread.sleep(2000);
			tpfb.enterNumberOfHoursPerDay(numberOfHours);
			tpfb.enterCourseFee(courseFee);
			tpfb.selectGradingPrefrences(gradingPrefrences);
			Thread.sleep(3000);
			tpfb.clickForCourseApprovalDocument_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(courseApprovalFile);
			Thread.sleep(3000);
			tpfb.clickOnCourseApprovalDocument_UploadFile();
			Thread.sleep(4000);
			tpfb.clickOnAdd_AddCourse();
			Thread.sleep(3000);
			tpfb.clickOnSaveAndContinue();
			Thread.sleep(3000);
			tpfb.clickOnYes_AddScheme();
			Thread.sleep(3000);
			tpfb.clickOnOK();
		}
		else
		{
			tpfb.enterCourseDescription(courseDescription);
			tpfb.enterNameOfIssuedCertificate(certificateName);
			tpfb.selectMinimumAge(minimumAge);
			tpfb.selectMinimumEducationRequired(minimumEducation);
			tpfb.enterCourseDuration(courseDuration);
			Thread.sleep(2000);
			tpfb.enterNumberOfHoursPerDay(numberOfHours);
			tpfb.enterCourseFee(courseFee);
			tpfb.selectGradingPrefrences(gradingPrefrences);
			Thread.sleep(3000);
			tpfb.clickForCourseApprovalDocument_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(courseApprovalFile);
			Thread.sleep(3000);
			tpfb.clickOnCourseApprovalDocument_UploadFile();
			Thread.sleep(4000);
			tpfb.clickOnAdd_AddCourse();
			Thread.sleep(3000);
			tpfb.clickOnSaveAndContinue();
			Thread.sleep(3000);
			tpfb.clickOnYes_AddScheme();
			Thread.sleep(3000);
			tpfb.clickOnOK();
		}
		
		Thread.sleep(3000);
		tpms.clickOnApprovalInProgress();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[div[h4[contains(text(),'"+projectName+"')]]]]]/div/p[text()='Approval In Progress']")).getText(), "Approval In Progress");
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	@DataProvider
	public Object[][] approveScheme()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02");
	}
	
	@Test(dataProvider="approveScheme", dependsOnMethods="addSchemeTC_01")
	public void daApproveSchemeTC_02(String srno, String fDAUsername, String fDAPassword, String tpID, String type, String status, String expectedStartDate, String expectedEndDate, String expectedProjectName, String expectedProposingOrganisation, String expectedImplementingOrganisation, String expectedFinancialModelType, String expectedFundedBy, String expectedProjectTarget, String expectedPromoterDetails, String expectedSanctionLoanAmount, String expectedMoratoriumPeriod, String expectedLoanDuration, String expectedInterestRate, String expectedSector, String expectedCourseName, String expectedJobRoleMappingType ,String expectedAssociatedQP, String expectedNSQFLevel, String expectedProposedHour, String comments, String reviewComments) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(fDAUsername, fDAPassword);
		FDA_DashboardPage fdp = new FDA_DashboardPage(driver);
		Thread.sleep(5000);
		fdp.clickOnViewAllOnboardingRequest();
		FDA_OnboardingRequestPage frp = new  FDA_OnboardingRequestPage(driver);
		Thread.sleep(3000);
		frp.selectTPID(tpID);
		frp.selectType(type);
		frp.selectStatus(status);
		Thread.sleep(2000);
		frp.clickOnApply();
		Thread.sleep(4000);
		List <WebElement> button = driver.findElements(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int size = button.size();
		WebElement ele = button.get(size-1);
		ele.click();
		List <WebElement> ta = driver.findElements(By.xpath("//a[contains(text(),'Take Action')]"));
		int size1 = ta.size();
		WebElement tab = ta.get(size1-1);
		tab.click();
		//frp.clickOnAction();
		//frp.clickOnTakeAction();
		FDA_SelectedSchemePage fss = new FDA_SelectedSchemePage(driver);
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), expectedStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), expectedEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), expectedProjectName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value"), expectedImplementingOrganisation);
		if(expectedFinancialModelType.equals("Funded"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), expectedFinancialModelType);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value"), expectedFundedBy);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), expectedPromoterDetails);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sanctionLoanAmount']")).getAttribute("value"), expectedSanctionLoanAmount);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='moratoriumPeriod']")).getAttribute("value"), expectedMoratoriumPeriod);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='loanDuration']")).getAttribute("value"), expectedLoanDuration);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='interestRate']")).getAttribute("value"), expectedInterestRate);
		}
		else if(expectedFinancialModelType.equals("Non-Funded"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), expectedFinancialModelType);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
		}
		
		Thread.sleep(3000);
		fss.clickOnDownloadSignedTermsheet();
		Thread.sleep(3000);
		fss.clickOnDownloadSignedProposal();
		Thread.sleep(3000);
		fss.clickOnDownloadSupportingDocument();
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedSector+"']")).getText(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedCourseName+"']")).getText(), expectedCourseName);
		if(expectedJobRoleMappingType.equals("QP-NOS")) 
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedAssociatedQP+"']")).getText(), expectedAssociatedQP);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedNSQFLevel+"']")).getText(), expectedNSQFLevel);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedProposedHour+"']")).getText(), expectedProposedHour);

		}
		else 
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedProposedHour+"']")).getText(), expectedProposedHour);
		}
		
		fss.selectReviewComments(comments);
		fss.enterReviewComments(reviewComments);
		Thread.sleep(3000);
		fss.clickOnFirst_SubmitResponse();
		Thread.sleep(3000);
		fss.clickOnSecond_SubmitResponse();
		fss.clickOnOK();
		frp.selectTPID(tpID);
		frp.selectType(type);
		frp.selectStatus(reviewComments);
		Thread.sleep(2000);
		frp.clickOnApply();
		if(comments.equals("Recommended"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
		}
		else if(comments.equals("Not Recommended"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
		}
		else if(comments.equals("Document Required"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
		}
		Thread.sleep(3000);
		PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		
		
	}
	
	
	@DataProvider
	public Object[][] resubmitAndReviewScheme()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03");
	}
	
	@Test(dataProvider="resubmitAndReviewScheme", dependsOnMethods="daApproveSchemeTC_02")
	public void resubmitAndReviewSchemeTC_03(String srno, String tpusername, String tppassword, String daComments, String daReviewComments, String newStartDate, String newEndDate, String oldProjectName, String newProjectName, String newProposedOrganisation, String newImplementingOrganisation, String newFinancialModelType, String newFundedBy, String newProjectTarget, String newPromoterDetails, String newSanctionLoanAmount, String newMoratoriumPeriod, String newLoanDuration, String newInterestRate, String newSignedTermsheetFile, String newSignedProposalFile, String newOtherSupportingFile, String newSector, String newGTrainingTarget, String newAddSectorSupportingFile, String newCourseName, String newSector_AddCourse, String newJobRole, String newJobRoleName, String newnsqfLevel, String newCourseDescription, String newCertificateName, String newMinimumAge, String newMinimumEducation, String newCourseDuration, String newNumberOfHours, String newCourseFee, String newGradingPrefrences, String newCourseApprovalFile, String fDausername, String fDApassword, String newComment, String newReviewComment) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpusername, tppassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(5000);
		tpdp.clickOnMySchemes();
		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
		Thread.sleep(3000);
		if(daComments.equals("Recommended"))
		{
			Thread.sleep(3000);
			tpms.clickOnApprovedScheme();
			//Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[div[h4[contains(text(),'Fee Based - "+oldProjectName+"')]]]]]//p[text()='Target']")).getText(), "Target");
		}
		else if(daComments.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			tpms.clickOnRejectedScheme();
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[div[h4[contains(text(),'Fee Based - "+oldProjectName+"')]]]]]//p[text()='BLOCKED']")).getText(), "BLOCKED");
		}
		else if(daComments.equals("Document Required"))
		{
			Thread.sleep(3000);
			tpms.clickOnApprovalInProgress();
			tpms.clickOnViewDetails();
			TP_FeeBasedProgramPage tpfb = new TP_FeeBasedProgramPage(driver);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@ng-reflect-model='DAREJECTED']")).getAttribute("value"), "DAREJECTED");
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@ng-reflect-model='REJECTED']")).getAttribute("value"), daReviewComments);
			tpfb.clickForNewStartDateOfProject();
			newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(srno), 5, newStartDate);
			tpfb.clickForNewEndDateOfProject();
			newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(srno), 6, newEndDate);
			tpfb.enterNameOfProject(newProjectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(srno), 3, newProjectName);			
			tpfb.enterNameOfProposingOrganisation(newProposedOrganisation);
			tpfb.enterNameOfImplementingOrganisation(newImplementingOrganisation);
			tpfb.selectFinancialModelType(newFinancialModelType);
			if(newFinancialModelType.equals("Funded"))
			{
				tpfb.enterProjectFundedBy(newFundedBy);
				tpfb.enterProjectTarget(newProjectTarget);
				tpfb.enterPromoterDetails(newPromoterDetails);
				tpfb.enterSanctionLoanAmount(newSanctionLoanAmount);
				tpfb.selectMoratoriumPeriod(newMoratoriumPeriod);
				tpfb.selectForLoanDuration(newLoanDuration);
				tpfb.selectForInterestRate(newInterestRate);
			}
			else if(newFinancialModelType.equals("Non-Funded"))
			{
				tpfb.enterProjectTarget(newProjectTarget);
				tpfb.enterPromoterDetails(newPromoterDetails);
			}
			Thread.sleep(3000);
			tpfb.clickOnSignedTermsheetBrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(newSignedTermsheetFile);
			Thread.sleep(3000);
			tpfb.clickOnSignedTermsheetUploadFile();
			Thread.sleep(3000);
			tpfb.clickOnSignedProposalBrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(newSignedProposalFile);
			Thread.sleep(3000);
			tpfb.clickOnSignedProposalUploadFile();
			Thread.sleep(3000);
			tpfb.clickOnSupportingDocumentBrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(newOtherSupportingFile);
			Thread.sleep(3000);
			tpfb.clickOnSupportingDocumentUploadFile();
			Thread.sleep(3000);
			tpfb.clickOnAddSector();
			Thread.sleep(2000);
			tpfb.selectSector(newSector);
			tpfb.enterProposedTrainingTarget(newGTrainingTarget);
			Thread.sleep(2000);
			tpfb.clickOnSupportingDocumentForAddSector_BrowseButton();
			Thread.sleep(3000);
			UploadFile.upload(newAddSectorSupportingFile);
			Thread.sleep(3000);
			tpfb.clickOnSupportingDocumentForAddSector_UploadButton();
			Thread.sleep(4000);
			tpfb.clickOnAdd_AddSector();
			Thread.sleep(3000);
			tpfb.clickOnAddCourse();
			Thread.sleep(2000);
			tpfb.enterCourseName(newCourseName);
			tpfb.selectSector_AddCourse(newSector_AddCourse);
			tpfb.selectJobRoleMappingType(newJobRole);
			if(newJobRole.equals("QP-NOS"))
			{
				Thread.sleep(2000);
				tpfb.selectAssociatedQP_JobRoleNameI(newJobRoleName);
				newnsqfLevel = driver.findElement(By.xpath("(//input[@ng-reflect-name='nsqfLevel'])[2]")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(srno), 29, newnsqfLevel);
				tpfb.enterCourseDescription(newCourseDescription);
				tpfb.enterNameOfIssuedCertificate(newCertificateName);
				tpfb.selectMinimumAge(newMinimumAge);
				tpfb.selectMinimumEducationRequired(newMinimumEducation);
				tpfb.enterCourseDuration(newCourseDuration);
				Thread.sleep(2000);
				tpfb.enterNumberOfHoursPerDay(newNumberOfHours);
				tpfb.enterCourseFee(newCourseFee);
				tpfb.selectGradingPrefrences(newGradingPrefrences);
				Thread.sleep(3000);
				tpfb.clickForCourseApprovalDocument_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newCourseApprovalFile);
				Thread.sleep(3000);
				tpfb.clickOnCourseApprovalDocument_UploadFile();
				Thread.sleep(4000);
				tpfb.clickOnAdd_AddCourse();
				Thread.sleep(3000);
				tpfb.clickOnResubmitForReviewAgain();
				Thread.sleep(3000);
				tpfb.clickOnOK();
				Thread.sleep(3000);
				tpms.clickOnApprovalInProgress();
			}
			else
			{
				tpfb.enterCourseDescription(newCourseDescription);
				tpfb.enterNameOfIssuedCertificate(newCertificateName);
				tpfb.selectMinimumAge(newMinimumAge);
				tpfb.selectMinimumEducationRequired(newMinimumEducation);
				tpfb.enterCourseDuration(newCourseDuration);
				Thread.sleep(2000);
				tpfb.enterNumberOfHoursPerDay(newNumberOfHours);
				tpfb.enterCourseFee(newCourseFee);
				tpfb.selectGradingPrefrences(newGradingPrefrences);
				Thread.sleep(3000);
				tpfb.clickForCourseApprovalDocument_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newCourseApprovalFile);
				Thread.sleep(3000);
				tpfb.clickOnCourseApprovalDocument_UploadFile();
				Thread.sleep(4000);
				tpfb.clickOnAdd_AddCourse();
				Thread.sleep(3000);
				tpfb.clickOnResubmitForReviewAgain();
				Thread.sleep(3000);
				tpfb.clickOnOK();
				Thread.sleep(3000);
				tpms.clickOnApprovalInProgress();
			}
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[div[h4[contains(text(),'"+newProjectName+"')]]]]]/div/p[text()='Approval In Progress']")).getText(), "Approval In Progress");
			PostLoginPage plp = new PostLoginPage(driver);
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			
			lp.clickLogin();
			elp.performlogin(fDausername, fDApassword);
			FDA_DashboardPage fdp = new FDA_DashboardPage(driver);
			Thread.sleep(3000);
			fdp.clickOnViewAllOnboardingRequest();
			FDA_OnboardingRequestPage frp = new  FDA_OnboardingRequestPage(driver);
			Thread.sleep(3000);
			frp.selectTPID(tpusername);
			frp.selectType(newFinancialModelType);
			frp.selectStatus("RESUBMITTED");
			Thread.sleep(2000);
			frp.clickOnApply();
			Thread.sleep(4000);
			List <WebElement> button = driver.findElements(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
			int size = button.size();
			WebElement ele = button.get(size-1);
			ele.click();
			List <WebElement> ta = driver.findElements(By.xpath("//a[contains(text(),'Take Action')]"));
			int size1 = ta.size();
			WebElement tab = ta.get(size1-1);
			tab.click();
			FDA_SelectedSchemePage fss = new FDA_SelectedSchemePage(driver);
			Thread.sleep(3000);
			
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), newStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), newEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), newProjectName);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), newProposedOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value"), newImplementingOrganisation);
			if(newFinancialModelType.equals("Funded"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), newFinancialModelType);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value"), newFundedBy);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), newProjectTarget);
				Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), newPromoterDetails);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sanctionLoanAmount']")).getAttribute("value"), newSanctionLoanAmount);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='moratoriumPeriod']")).getAttribute("value"), newMoratoriumPeriod);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='loanDuration']")).getAttribute("value"), newLoanDuration);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='interestRate']")).getAttribute("value"), newInterestRate);
			}
			else if(newFinancialModelType.equals("Non-Funded"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), newFinancialModelType);
				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), newProjectTarget);
			}
			
			Thread.sleep(3000);
			fss.clickOnDownloadSignedTermsheet();
			Thread.sleep(3000);
			fss.clickOnDownloadSignedProposal();
			Thread.sleep(3000);
			fss.clickOnDownloadSupportingDocument();
			
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newSector+"']")).getText(), newSector);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newCourseName+"']")).getText(), newCourseName);
			if(newJobRole.equals("QP-NOS")) 
			{
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newJobRoleName+"']")).getText(), newJobRoleName);
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newnsqfLevel+"']")).getText(), newnsqfLevel);
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNumberOfHours+"']")).getText(), newNumberOfHours);

			}
			else 
			{
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNumberOfHours+"']")).getText(), newNumberOfHours);
			}
			
			fss.selectReviewComments(newComment);
			fss.enterReviewComments(newReviewComment);
			Thread.sleep(3000);
			fss.clickOnFirst_SubmitResponse();
			Thread.sleep(3000);
			fss.clickOnSecond_SubmitResponse();
			fss.clickOnOK();
			frp.selectTPID(tpusername);
			frp.selectType(newFinancialModelType);
			frp.selectStatus(newReviewComment);
			Thread.sleep(2000);
			frp.clickOnApply();
			if(newComment.equals("Recommended"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
			}
			else if(newComment.equals("Not Recommended"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
			}
			else if(newComment.equals("Document Required"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
			}
			
			
		}
		
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
	}
	
	
	
	

}
