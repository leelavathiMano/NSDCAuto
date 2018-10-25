package com.nsdc.regressionTest;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.AlertFunctionality;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AssessmentAgencyDashboardPage;
import com.nsdc.pages.AssessmentAgencyViewBatchesPage;
import com.nsdc.pages.AssessmentAgency_BatchIDPage;
import com.nsdc.pages.CMA_AddCourseRequestsPage;
import com.nsdc.pages.CMA_AddSectorRequestPage;
import com.nsdc.pages.CMA_CourseInfoPage;
import com.nsdc.pages.CMA_DashboardPage;
import com.nsdc.pages.CMA_SectorInfoPage;
import com.nsdc.pages.CMA_TCRequestPage;
import com.nsdc.pages.CMA_TrainingCentreInfoPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.FDA_DashboardPage;
import com.nsdc.pages.FDA_OnboardingRequestPage;
import com.nsdc.pages.FDA_SelectedSchemePage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSC_AssessmentsAndCertification_DashboardPage;
import com.nsdc.pages.SSC_AssessmentsAndCertifications_ViewAllBatchesPage;
import com.nsdc.pages.SSC_Certification_BatchIDPage;
import com.nsdc.pages.SSC_Certification_ViewAllBatches;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.TP_FeeBasedProgramPage;
import com.nsdc.pages.TP_FeeBased_AddCourseToSectorsPage;
import com.nsdc.pages.TP_FeeBased_AddTrainingCentrePage;
import com.nsdc.pages.TP_FeeBased_AssessmentAgencyAndAssessorPage;
import com.nsdc.pages.TP_FeeBased_AssessmentAgencyInfoPage;
import com.nsdc.pages.TP_FeeBased_BatchDetailsPage;
import com.nsdc.pages.TP_FeeBased_CreateBatchAddSectorTargetPage;
import com.nsdc.pages.TP_FeeBased_DashboardPage;
import com.nsdc.pages.TP_FeeBased_EnrollCandidatesPage;
import com.nsdc.pages.TP_FeeBased_ViewAllSectorAndCoursesPage;
import com.nsdc.pages.TP_FeeBased_ViewAllTrainersPage;
import com.nsdc.pages.TP_FeeBased_ViewAllTrainingCentrePage;
import com.nsdc.pages.TP_MySchemeDashboardPage;
import com.nsdc.pages.TP_SelectSchemePage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.pages.TrainingPartner_MyCandidatesPage;
import com.nsdc.testConfig.TestConfiguration;

public class FeeBased_AddSchemeWorkflowTestSC_14 extends TestConfiguration
{
	
	@DataProvider
	public Object[][] addScheme_FeeBased()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01");
	}
	
	@Test(dataProvider="addScheme_FeeBased")
	public void addSchemeTC_01(String sno, String tpUsername, String tpPassword, String schemeName, String financialModel, String fundedBy, String projectDuration, String projectID, String projectName, String implementingOrganisation, String proposingOrganisation, String promoterDetails, String target, String assessmentMode, String startDate, String endDate, String loanAmount, String moratoriumPeriod, String loanduration, String interestRate, String signedTermsheetFile, String signedProposalFile, String otherSupportingFile, String sector, String trainingTarget, String addSectorUndertakingFile, String affiliationCertificate, String courseName, String sector_AddCourse, String jobRole, String jobRoleName, String nsqfLevel, String courseDescription, String certificateName, String minimumAge, String minimumEducation, String courseDuration, String numberOfHours, String courseFee, String gradingPrefrences, String courseApprovalFile, String affiliationFile, String workOrderFile, String challanFile, String stampPaper, String state, String district) throws Exception
	{
		int srno = Integer.parseInt(sno);
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpd = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(10000);
		tpd.clickOnMySchemes();
		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
		Thread.sleep(3000);
		tpms.clickOnAddSchemeOrProgram();
		//TP_SelectSchemePage tpss = new TP_SelectSchemePage(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+schemeName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+schemeName+"']]]]//a[contains(text(),'Add Program')]")).click();
		TP_FeeBasedProgramPage tpfb = new TP_FeeBasedProgramPage(driver);
		Thread.sleep(3000);
		//tpfb.clickOnCloseButton();
		if(srno == 1)
		{
			Thread.sleep(5000);
			tpfb.selectFinancialModelType(financialModel);
		}
		else
		{
			Thread.sleep(3000);
			tpfb.clickOnCloseButton();
			Thread.sleep(5000);
			tpfb.selectFinancialModelType(financialModel);
		}
		if(financialModel.equals("Funded"))
		{
			Thread.sleep(5000);
			tpfb.enterProjectFundedBy(fundedBy);
			projectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", srno, 6, projectDuration);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
			tpfb.enterProjectProposalID(projectID);
			Thread.sleep(3000);
			tpfb.enterNameOfProject(projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSector&CoursSC15TC04", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 5, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "GenerateCertificationSC15TC09", Integer.parseInt(sno), 8, projectName);
		
			//tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
			implementingOrganisation = driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", srno, 9, implementingOrganisation);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", srno, 10, implementingOrganisation);	
			Thread.sleep(5000);
			tpfb.enterNameOfProposingOrganisation(proposingOrganisation);
			tpfb.enterPromoterDetails(promoterDetails);
			tpfb.enterProjectTarget(target);
			tpfb.selectAssessmentMode(assessmentMode);
			Thread.sleep(3000);
			tpfb.clickOnStartDateOfProject();
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 14, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 15, startDate);
			//tpfb.clickOnEndDateOfProject();
			Thread.sleep(3000);
			tpfb.enterSanctionLoanAmount(loanAmount);
			tpfb.selectMoratoriumPeriod(moratoriumPeriod);
			tpfb.selectForLoanDuration(loanduration);
			tpfb.selectForInterestRate(interestRate);
			
		}
		
		else
		{
			projectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", srno, 6, projectDuration);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
			tpfb.enterProjectProposalID(projectID);
			Thread.sleep(3000);
			tpfb.enterNameOfProject(projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSector&CoursSC15TC04", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 3, projectName);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "GenerateCertificationSC15TC09", Integer.parseInt(sno), 8, projectName);
		
			//tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
			implementingOrganisation = driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", srno, 9, implementingOrganisation);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", srno, 10, implementingOrganisation);	
			Thread.sleep(5000);
			tpfb.enterNameOfProposingOrganisation(proposingOrganisation);
			tpfb.enterPromoterDetails(promoterDetails);
			tpfb.enterProjectTarget(target);
			tpfb.selectAssessmentMode(assessmentMode);
			Thread.sleep(3000);
			tpfb.clickOnStartDateOfProject();
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 14, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 15, startDate);
			tpfb.clickOnSanctionLoanAmount();
			//tpfb.clickOnEndDateOfProject();
			//endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
			//ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 15, endDate);
			//ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 16, endDate);
		}
		
		/*if(a != 1)
		{
			Thread.sleep(3000);
			tpfb.clickOnCloseButton();
			Thread.sleep(8000);
			tpfb.clickOnStartDateOfProject();
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 4, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 6, startDate);
			tpfb.clickOnEndDateOfProject();
			endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 5, endDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 7, endDate);
		}
		else 
		{
			Thread.sleep(5000);
			tpfb.clickOnStartDateOfProject();
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 4, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 6, startDate);
			tpfb.clickOnEndDateOfProject();
			endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 5, endDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 7, endDate);
			
		}
		
		tpfb.enterProjectProposalID(projectID);
		tpfb.enterNameOfProject(projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 3, projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSector&CoursSC15TC04", Integer.parseInt(sno), 3, projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 3, projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 3, projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07", Integer.parseInt(sno), 3, projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 3, projectName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "GenerateCertificationSC15TC09", Integer.parseInt(sno), 8, projectName);

		//tpfb.enterNameOfProposingOrganisation(proposingOrganisation);
		tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
		tpfb.selectFinancialModelType(financialModel);
		if(financialModel.equals("Funded"))
		{
			tpfb.enterProjectFundedBy(fundedBy);
			tpfb.enterProjectTarget(target);
			tpfb.selectAssessmentMode(assessmentMode);
			tpfb.enterPromoterDetails(promoterDetails);
			tpfb.enterSanctionLoanAmount(loanAmount);
			tpfb.selectMoratoriumPeriod(moratoriumPeriod);
			tpfb.selectForLoanDuration(loanduration);
			tpfb.selectForInterestRate(interestRate);
		}
		else if(financialModel.equals("Non-Funded"))
		{
			tpfb.enterProjectTarget(target);
			tpfb.selectAssessmentMode(assessmentMode);
			tpfb.enterPromoterDetails(promoterDetails);
		}*/
		
		Thread.sleep(3000);
		endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 15, endDate);
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 16, endDate);
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
		Thread.sleep(3000);
		tpfb.enterProposedTrainingTarget(trainingTarget);
		Thread.sleep(4000);
		tpfb.clickOnUndertakingDocumentForAddSector_Browse();
		Thread.sleep(3000);
		UploadFile.upload(addSectorUndertakingFile);
		Thread.sleep(3000);
		tpfb.clickOnUndertakingDocumentForAddSector_Upload();
		Thread.sleep(3000);
		tpfb.clickOnAffiliationCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationCertificate);
		Thread.sleep(3000);
		tpfb.clickOnAffiliationCertificate_UploadFile();
		Thread.sleep(4000);
		tpfb.clickOnAdd_AddSector();
		String addedSector = driver.findElement(By.xpath("//td[text()='"+sector+"']")).getText();
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(sno), 4, addedSector);
		Thread.sleep(5000);
		tpfb.clickOnAddCourse();
		Thread.sleep(8000);
		
		
		tpfb.selectSector_AddCourse(sector_AddCourse);
		tpfb.selectJobRoleMappingType(jobRole);
		if(jobRole.equals("QP-NOS"))
		{
			Thread.sleep(4000);
			tpfb.selectAssociatedQP_JobRoleNameI(jobRoleName);
			tpfb.enterCourseName(courseName);
			nsqfLevel = driver.findElement(By.xpath("(//input[@ng-reflect-name='nsqfLevel'])[2]")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 31, nsqfLevel);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 25, nsqfLevel);
			tpfb.enterNameOfIssuedCertificate(certificateName);
		}
		else 
		{
			Thread.sleep(4000);
			tpfb.enterCourseName(courseName);
			tpfb.enterCourseDescription(courseDescription);
			tpfb.enterNameOfIssuedCertificate(certificateName);
			tpfb.selectMinimumAge(minimumAge);
		}
		
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
		Thread.sleep(3000);
		tpfb.clickOnAffiliationCertificate_Course_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationFile);
		Thread.sleep(3000);
		tpfb.clickOnAffiliationCertificate_Course_UploadFile();
		Thread.sleep(3000);
		tpfb.clickOnWorkOrder_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(workOrderFile);
		Thread.sleep(3000);
		tpfb.clickOnWorkOrder_UploadFile();
		Thread.sleep(3000);
		tpfb.clickOnChallanOfFeePaid_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(challanFile);
		Thread.sleep(3000);
		tpfb.clickOnChallanOfFeePaid_UploadFile();
		Thread.sleep(3000);
		tpfb.clickOnStampPapaer_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(stampPaper);
		Thread.sleep(3000);
		tpfb.clickOnStampPape_UploadFile();
		Thread.sleep(4000);
		tpfb.clickOnAdd_AddCourse();
		Thread.sleep(3000);
		String addedCourse = driver.findElement(By.xpath("//p[text()='"+courseName+"']")).getText();
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(sno), 8, addedCourse);
		Thread.sleep(3000);
		tpfb.selectState_LocationForTC(state);
		tpfb.selectDistricts_LocationForTC(district);
		Thread.sleep(3000);
		tpfb.clickOnAddForLocationOfTC();
		Thread.sleep(3000);
		tpfb.clickOnSaveAndContinue();
		Thread.sleep(3000);
		tpfb.clickOnYes_AddScheme();
		Thread.sleep(3000);
		//tpfb.clickOnOK();
		
		Thread.sleep(5000);
		tpms.clickOnApprovalInProgress();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//span[text()='Approval in Progress']")).getText(), "Approval in Progress");
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
	public void daApproveSchemeTC_02(String srno, String fDAUsername, String fDAPassword, String tpID, String expectedFinancialModelType, String status, String expectedFundedBy, String expectedProjectDuration,  String expectedProjectID, String expectedProjectName, String expectedImplementingOrganisation, String expectedProposingOrganisation,  String expectedPromoterDetails, String expectedProjectTarget, String expectedAssessmentMode, String expectedStartDate, String expectedEndDate, String expectedSanctionLoanAmount, String expectedMoratoriumPeriod, String expectedLoanDuration, String expectedInterestRate, String expectedSector, String expectedCourseName, String expectedJobRoleMappingType ,String expectedAssociatedQP, String expectedNSQFLevel, String expectedProposedHour, String expectedState, String expectedDistrict, String comments, String reviewComments) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(fDAUsername, fDAPassword);
		FDA_DashboardPage fdp = new FDA_DashboardPage(driver);
		Thread.sleep(10000);
		fdp.clickOnViewAllOnboardingRequest();
		FDA_OnboardingRequestPage frp = new  FDA_OnboardingRequestPage(driver);
		Thread.sleep(3000);
		//frp.selectTPID(tpID);
		frp.selectType(expectedFinancialModelType);
		frp.selectStatus(status);
		Thread.sleep(2000);
		frp.clickOnApply();
		Thread.sleep(4000);
		
		
		List <WebElement> button = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int size = button.size();
		WebElement ele = button.get(size-1);
		ele.click();
		List <WebElement> ta = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
		int size1 = ta.size();
		WebElement tab = ta.get(size1-1);
		tab.click();
		FDA_SelectedSchemePage fss = new FDA_SelectedSchemePage(driver);
		Thread.sleep(3000);

		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), expectedFinancialModelType);
		if(expectedFinancialModelType.equals("Funded"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value"), expectedFundedBy);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), expectedProjectDuration);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), expectedProjectID);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), expectedProjectName);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value"), expectedImplementingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), expectedPromoterDetails);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), expectedAssessmentMode);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), expectedStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), expectedEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sanctionLoanAmount']")).getAttribute("value"), expectedSanctionLoanAmount);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='moratoriumPeriod']")).getAttribute("value"), expectedMoratoriumPeriod);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='loanDuration']")).getAttribute("value"), expectedLoanDuration);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='interestRate']")).getAttribute("value"), expectedInterestRate);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), expectedProjectID);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), expectedProjectName);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value"), expectedImplementingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), expectedPromoterDetails);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), expectedAssessmentMode);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), expectedStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), expectedEndDate);
		}
		
		
		/*Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), expectedStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), expectedEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), expectedProjectID);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), expectedProjectName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
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
		}*/
		
		Thread.sleep(3000);
		fss.clickOnDownloadSignedTermsheet();
		Thread.sleep(3000);
		fss.clickOnDownloadSignedProposal();
		Thread.sleep(3000);
		fss.clickOnDownloadSupportingDocument();
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedSector+"']")).getText(), expectedSector);
		Thread.sleep(3000);
		fss.clickOnSectors_ViewAttachedDocument();
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='"+expectedCourseName+"']")).getText(), expectedCourseName);
		Thread.sleep(3000);
		fss.clickOnCourses_ViewAttachedDocument();
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
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedState+"']")).getText(), expectedState);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+expectedDistrict+"')]")).getText(), expectedDistrict);
		Thread.sleep(3000);
		fss.selectReviewComments(comments);
		fss.enterReviewComments(reviewComments);
		Thread.sleep(3000);
		fss.clickOnFirst_SubmitResponse();
		Thread.sleep(3000);
		fss.clickOnSecond_SubmitResponse();
		//fss.clickOnOK();
		//frp.selectTPID(tpID);
		frp.selectType(expectedFinancialModelType);
		frp.selectStatus(reviewComments);
		Thread.sleep(2000);
		frp.clickOnApply();
		if(comments.equals("Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
		}
		else if(comments.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
		}
		else if(comments.equals("Document Required"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
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
	public void resubmitAndReviewSchemeTC_03(String sno, String tpUsername, String tpPassword, String daComments, String oldProjectName, String daReviewComments, String newFinancialModel, String newFundedBy, String newProjectDuration, String newProjectID, String newProjectName, String newImplementingOrganisation, String newProposingOrganisation, String newPromoterDetails, String newTarget, String newAssessmentMode, String newStartDate, String newEndDate, String newLoanAmount, String newMoratoriumPeriod, String newLoanDuration, String newInterestRate, String newSignedTermsheetFile, String newSignedProposalFile, String newOtherSupportingFile, String newSector, String newTrainingTarget, String newAddSectorUndertakingFile, String newAffiliationCertificate, String newCourseName, String newSector_AddCourse, String newJobRole, String newJobRoleName, String newNsqfLevel, String newCourseDescription, String newCertificateName, String newMinimumAge, String newMinimumEducation, String newCourseDuration, String newNumberOfHours, String newCourseFee, String newGradingPrefrences, String newCourseApprovalFile, String newAffiliationFile, String newWorkOrderFile, String newChallanFile, String newStampPaper, String newState, String newDistrict, String fDAUsername, String fDAPassword, String newComments, String newReviewComments) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(10000);
		tpdp.clickOnMySchemes();
		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
		Thread.sleep(3000);
		if(daComments.equals("Recommended"))
		{
			Thread.sleep(3000);
			tpms.clickOnApprovedScheme();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+oldProjectName+"']]]]//span[text()='Approved']")).getText(), "Approved");
		}
		else if(daComments.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			tpms.clickOnRejectedScheme();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+oldProjectName+"']]]]//span[text()='Rejected']")).getText(), "Rejected");
		}
		else if(daComments.equals("Document Required"))
		{
			Thread.sleep(3000);
			tpms.clickOnApprovalInProgress();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+oldProjectName+"']]]]//span[text()='Send Back']")).getText(), "Send Back");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[span[text()='"+oldProjectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[span[text()='"+oldProjectName+"']]]]//a[contains(text(),'View Details')]")).click();
			TP_FeeBasedProgramPage tpfb = new TP_FeeBasedProgramPage(driver);
			Thread.sleep(3000);
			//tpfb.clickOnCloseButton();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@ng-reflect-model='DAREJECTED']")).getAttribute("value"), "DAREJECTED");
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@ng-reflect-model='REJECTED']")).getAttribute("value"), daReviewComments);
			Thread.sleep(3000);
			tpfb.selectFinancialModelType(newFinancialModel);
			if(newFinancialModel.equals("Funded"))
			{
				Thread.sleep(5000);
				tpfb.enterProjectFundedBy(newFundedBy);
				newProjectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 8, newProjectDuration);
				tpfb.enterProjectProposalID(newProjectID);
				Thread.sleep(3000);
				tpfb.enterNameOfProject(newProjectName);
				//tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
				newImplementingOrganisation = driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 11, newImplementingOrganisation);
				tpfb.enterNameOfProposingOrganisation(newProposingOrganisation);
				tpfb.enterPromoterDetails(newPromoterDetails);
				tpfb.enterProjectTarget(newTarget);
				tpfb.selectAssessmentMode(newAssessmentMode);
				Thread.sleep(3000);
				tpfb.clickOnStartDateOfProject();
				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 16, newStartDate);
				//tpfb.clickForNewEndDateOfProject();
				tpfb.enterSanctionLoanAmount(newLoanAmount);
				tpfb.selectMoratoriumPeriod(newMoratoriumPeriod);
				tpfb.selectForLoanDuration(newLoanDuration);
				tpfb.selectForInterestRate(newInterestRate);
			}
			
			else
			{
				newProjectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 8, newProjectDuration);
				tpfb.enterProjectProposalID(newProjectID);
				Thread.sleep(3000);
				tpfb.enterNameOfProject(newProjectName);
				//tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
				newImplementingOrganisation = driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 11, newImplementingOrganisation);	
				tpfb.enterNameOfProposingOrganisation(newProposingOrganisation);
				tpfb.enterPromoterDetails(newPromoterDetails);
				tpfb.enterProjectTarget(newTarget);
				tpfb.selectAssessmentMode(newAssessmentMode);
				Thread.sleep(3000);
				tpfb.clickOnStartDateOfProject();
				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 16, newStartDate);
				//tpfb.clickOnEndDateOfProject();
				Thread.sleep(3000);
				tpfb.clickOnSanctionLoanAmount();
				//newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
				//ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 17, newEndDate);
			}
			
				Thread.sleep(3000);
				newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 17, newEndDate);
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
				Thread.sleep(3000);
				tpfb.enterProposedTrainingTarget(newTrainingTarget);
				Thread.sleep(4000);
				tpfb.clickOnUndertakingDocumentForAddSector_Browse();
				Thread.sleep(3000);
				UploadFile.upload(newAddSectorUndertakingFile);
				Thread.sleep(3000);
				tpfb.clickOnUndertakingDocumentForAddSector_Upload();
				Thread.sleep(3000);
				tpfb.clickOnAffiliationCertificate_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newAffiliationCertificate);
				Thread.sleep(3000);
				tpfb.clickOnAffiliationCertificate_UploadFile();
				Thread.sleep(4000);
				tpfb.clickOnAdd_AddSector();
				Thread.sleep(5000);
				tpfb.clickOnAddCourse();
				Thread.sleep(8000);
				
				tpfb.selectSector_AddCourse(newSector_AddCourse);
				tpfb.selectJobRoleMappingType(newJobRole);
				if(newJobRole.equals("QP-NOS"))
				{
					Thread.sleep(4000);
					tpfb.selectAssociatedQP_JobRoleNameI(newJobRoleName);
					tpfb.enterCourseName(newCourseName);
					newNsqfLevel = driver.findElement(By.xpath("(//input[@ng-reflect-name='nsqfLevel'])[2]")).getAttribute("value");
					ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 33, newNsqfLevel);
					tpfb.enterNameOfIssuedCertificate(newCertificateName);
				}
				else 
				{
					Thread.sleep(4000);
					tpfb.enterCourseName(newCourseName);
					tpfb.enterCourseDescription(newCourseDescription);
					tpfb.enterNameOfIssuedCertificate(newCertificateName);
					tpfb.selectMinimumAge(newMinimumEducation);
				}
					
				tpfb.selectMinimumEducationRequired(newMinimumEducation);
				tpfb.enterCourseDuration(newCourseDuration);
				Thread.sleep(2000);
				tpfb.enterNumberOfHoursPerDay(newNumberOfHours);
				tpfb.enterCourseFee(newCourseFee);
				tpfb.selectGradingPrefrences(newGradingPrefrences);
				Thread.sleep(3000);
				Thread.sleep(3000);
				tpfb.clickForCourseApprovalDocument_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newCourseApprovalFile);
				Thread.sleep(3000);
				tpfb.clickOnCourseApprovalDocument_UploadFile();
				Thread.sleep(3000);
				tpfb.clickOnAffiliationCertificate_Course_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newAffiliationFile);
				Thread.sleep(3000);
				tpfb.clickOnAffiliationCertificate_Course_UploadFile();
				Thread.sleep(3000);
				tpfb.clickOnWorkOrder_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newWorkOrderFile);
				Thread.sleep(3000);
				tpfb.clickOnWorkOrder_UploadFile();
				Thread.sleep(3000);
				tpfb.clickOnChallanOfFeePaid_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newChallanFile);
				Thread.sleep(3000);
				tpfb.clickOnChallanOfFeePaid_UploadFile();
				Thread.sleep(3000);
				tpfb.clickOnStampPapaer_BrowseFile();
				Thread.sleep(3000);
				UploadFile.upload(newStampPaper);
				Thread.sleep(3000);
				tpfb.clickOnStampPape_UploadFile();
				Thread.sleep(4000);
				tpfb.clickOnAdd_AddCourse();
				Thread.sleep(3000);
				tpfb.selectState_LocationForTC(newState);
				tpfb.selectDistricts_LocationForTC(newDistrict);
				Thread.sleep(3000);
				tpfb.clickOnAddForLocationOfTC();
				Thread.sleep(3000);
				tpfb.clickOnResubmitForReviewAgain();
				Thread.sleep(3000);
				//tpfb.clickOnYes_AddScheme();
				Thread.sleep(3000);
				//tpfb.clickOnOK();
				
				Thread.sleep(5000);
				tpms.clickOnApprovalInProgress();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
				Thread.sleep(3000);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newProjectName+"']]]]//span[text()='Resubmitted']")).getText(), "Resubmitted");
				PostLoginPage plp = new PostLoginPage(driver);
				Thread.sleep(3000);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
				
				lp.clickLogin();
				elp.performlogin(fDAUsername, fDAPassword);
				FDA_DashboardPage fdp = new FDA_DashboardPage(driver);
				Thread.sleep(5000);
				fdp.clickOnViewAllOnboardingRequest();
				FDA_OnboardingRequestPage frp = new  FDA_OnboardingRequestPage(driver);
				Thread.sleep(3000);
				//frp.selectTPID(tpID);
				frp.selectType(newFinancialModel);
				frp.selectStatus("RESUBMITTED");
				Thread.sleep(2000);
				frp.clickOnApply();
				Thread.sleep(4000);
				
				
				List <WebElement> button = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpUsername+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
				int size = button.size();
				WebElement ele = button.get(size-1);
				ele.click();
				List <WebElement> ta = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpUsername+"']]]]//a[contains(text(),'Take Action')]"));
				int size1 = ta.size();
				WebElement tab = ta.get(size1-1);
				tab.click();
				FDA_SelectedSchemePage fss = new FDA_SelectedSchemePage(driver);
				Thread.sleep(3000);

				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), newFinancialModel);
				if(newFinancialModel.equals("Funded"))
				{
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value"), newFundedBy);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), newProjectDuration);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), newProjectID);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), newProjectName);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value"), newImplementingOrganisation);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), newProposingOrganisation);
					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), newPromoterDetails);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), newTarget);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), newAssessmentMode);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), newStartDate);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), newEndDate);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sanctionLoanAmount']")).getAttribute("value"), newLoanAmount);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='moratoriumPeriod']")).getAttribute("value"), newMoratoriumPeriod);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='loanDuration']")).getAttribute("value"), newLoanDuration);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='interestRate']")).getAttribute("value"), newInterestRate);
				}
				else
				{
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), newProjectID);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), newProjectName);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='implementingOrganisation']")).getAttribute("value"), newImplementingOrganisation);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), newProposingOrganisation);
					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), newPromoterDetails);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), newTarget);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), newAssessmentMode);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), newStartDate);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), newEndDate);
				}
				Thread.sleep(3000);
				fss.clickOnDownloadSignedTermsheet();
				Thread.sleep(3000);
				fss.clickOnDownloadSignedProposal();
				Thread.sleep(3000);
				fss.clickOnDownloadSupportingDocument();
				
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newSector+"']")).getText(), newSector);
				Thread.sleep(3000);
				fss.clickOnSectors_ViewAttachedDocument();
				//Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newCourseName+"']")).getText(), newCourseName);
				Thread.sleep(3000);
				fss.clickOnCourses_ViewAttachedDocument();
				Thread.sleep(3000);
				fss.clickOnSecondSector_ViewAttachedDocument();
				Thread.sleep(3000);
				fss.clickOnSecondCourses_ViewAttachedDocument();
				Thread.sleep(3000);
				
				if(newJobRole.equals("QP-NOS")) 
				{
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newJobRoleName+"']")).getText(), newJobRoleName);
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNsqfLevel+"']")).getText(), newNsqfLevel);
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNumberOfHours+"']")).getText(), newNumberOfHours);

				}
				else 
				{
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNumberOfHours+"']")).getText(), newNumberOfHours);
				}
				
				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newState+"']")).getText(), newState);
				Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+newDistrict+"')]")).getText(), newDistrict);
				Thread.sleep(3000);
				fss.selectReviewComments(newComments);
				fss.enterReviewComments(newReviewComments);
				Thread.sleep(3000);
				fss.clickOnFirst_SubmitResponse();
				Thread.sleep(3000);
				fss.clickOnSecond_SubmitResponse();
				//fss.clickOnOK();
				//frp.selectTPID(tpID);
				frp.selectType(newFinancialModel);
				frp.selectStatus(newReviewComments);
				Thread.sleep(2000);
				frp.clickOnApply();
				if(newComments.equals("Recommended"))
				{
					Thread.sleep(3000);
					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
				}
				else if(newComments.equals("Not Recommended"))
				{
					Thread.sleep(3000);
					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
				}
				else if(newComments.equals("Document Required"))
				{
					Thread.sleep(3000);
					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
				}
				
		}
				PostLoginPage plp = new PostLoginPage(driver);
				Thread.sleep(3000);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
				
				
	}
}



