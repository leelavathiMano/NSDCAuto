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
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 4, projectName);
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
		Thread.sleep(5000);
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
				newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 17, newEndDate);
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
				newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 17, newEndDate);
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
				
				tpfb.enterCourseName(newCourseName);
				tpfb.selectSector_AddCourse(newSector_AddCourse);
				tpfb.selectJobRoleMappingType(newJobRole);
				if(newJobRole.equals("QP-NOS"))
				{
					Thread.sleep(4000);
					tpfb.selectAssociatedQP_JobRoleNameI(newJobRoleName);
					newNsqfLevel = driver.findElement(By.xpath("(//input[@ng-reflect-name='nsqfLevel'])[2]")).getAttribute("value");
					ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 33, newNsqfLevel);
					tpfb.enterCourseDescription(newCourseDescription);
					tpfb.enterNameOfIssuedCertificate(newCertificateName);
					tpfb.selectMinimumAge(newMinimumAge);
					tpfb.selectMinimumEducationRequired(newMinimumEducation);
					tpfb.enterCourseDuration(newCourseDuration);
					Thread.sleep(2000);
					tpfb.enterNumberOfHoursPerDay(newNumberOfHours);
					tpfb.enterCourseFee(newCourseFee);
					tpfb.selectGradingPrefrences(newGradingPrefrences);
					
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
					
				}
				
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
					//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), newEndDate);
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
					//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), newEndDate);
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



@DataProvider
public Object[][] addTrainingCentre()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01");
}

@Test(dataProvider="addTrainingCentre", dependsOnMethods="resubmitAndReviewSchemeTC_03")
public void addTrainingCentreTC04(String sno, String tpUsername, String tpPassword, String projectName, String trainingCentreType, String trainingCentreName, String tcStatus, String ownership, String franchiseDocument, String startDate, String endDate, String bathesNumber, String studentNumber, String annualCapacity, String capacityUtilization, String governmentTieUp, String centreCapacity, String centreArea, String trainingRooms, String labNumber, String receptionArea, String waitingArea, String maleWashRooms, String femaleWashRooms, String unisexWashRooms, String airportDistance, String trainStationDistance, String cityCentreDistance, String tcAddress, String landmark, String pincode, String state, String district, String tehsil, String city, String parliamentryConstituency, String geoLocation, String spocName, String spocEmail, String spocMobile, String spocDesignation, String spocLandLine, String tcRoomPhotos, String laboratoryPhotos, String washRoomPhotos, String cafetariaPhotos, String sector, String course, String target, String secondTrainingCentreName, String secondSPOCEmail, String secondSPOCMobile,String thirdTrainingCentreName, String thirdSPOCEmail, String thirdSPOCMobile) throws Exception
{
	LoginPage lp = new LoginPage(driver);
	lp.clickLogin();
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(tpUsername, tpPassword);
	TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
	Thread.sleep(10000);
	tpdp.clickOnMySchemes();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
	TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
	Thread.sleep(3000);
	fbd.clickOnViewTrainingCentres();
	TP_FeeBased_ViewAllTrainingCentrePage fbtc = new TP_FeeBased_ViewAllTrainingCentrePage(driver);
	Thread.sleep(2000);
	fbtc.clickOnAddTrainingCentre();
	Thread.sleep(3000);
	fbtc.selectTrainingCentreType(trainingCentreType);
	fbtc.clickOnSaveAndContinue();
	TP_FeeBased_AddTrainingCentrePage fbad = new TP_FeeBased_AddTrainingCentrePage(driver);
	Thread.sleep(3000);
	fbad.enterTrainingCentreName(trainingCentreName);
	//fbad.selectTrainingCentreStatus(tcStatus);
	fbad.selectForCentreOwnerShip(ownership);
	if(ownership.equals("Franchise"))
	{
		Thread.sleep(3000);
		fbad.clickOnFranchiseDocuments_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(franchiseDocument);
		Thread.sleep(3000);
		fbad.clickOnFranchiseDocuments_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnStartDateForTCDuration();
		startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, startDate);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
		fbad.clickOnEndDateForTCDuration();
		endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 10, endDate);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
	}
	else
	{
		fbad.clickOnStartDateForTCDuration();
		startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, startDate);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
		fbad.clickOnEndDateForTCDuration();
		endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 10, endDate);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
	}
	
	fbad.enterNumberOfBatchesPerDay(bathesNumber);
	fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
	fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
	fbad.enterCapacityUtilization(capacityUtilization);
	fbad.selectForGovernmentTieUp(governmentTieUp);
	fbad.enterCentreCapacity(centreCapacity);
	fbad.entreCentreArea(centreArea);
	fbad.enterNumberOfTrainingRooms(trainingRooms);
	fbad.enterNumbersOfLabs(labNumber);
	fbad.enterReceptionAreaSize(receptionArea);
	fbad.enterWaitingAreaCapacity(waitingArea);
	fbad.enterNumberOfMaleWashRooms(maleWashRooms);
	fbad.enterNumberOfFemaleWashRooms(femaleWashRooms);
	fbad.enterNumberOfUnisexWashRooms(unisexWashRooms);
	fbad.enterDistanceFromNearestAirport(airportDistance);
	fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
	fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
	fbad.enterAddressOFTC(tcAddress);
	fbad.enterNearByLandmark(landmark);
	fbad.enterPincode(pincode);
	fbad.selectState(state);
	Thread.sleep(2000);
	fbad.selrctDistrict(district);
	Thread.sleep(2000);
	fbad.selectTehsil(tehsil);
	Thread.sleep(2000);
	fbad.selectCityOrVillage(city);
	Thread.sleep(2000);
	fbad.selectParliamentryConstituency(parliamentryConstituency);
	fbad.enterGeoLocation(geoLocation);
	//fbad.selectAddressProofType(addressProof);
	Thread.sleep(3000);
	fbad.clickOnAllFacilitiesCheckBoxes();
	Thread.sleep(2000);
	fbad.enterNameOfSPOC(spocName);
	fbad.enterEmailAddressOfSPOC(spocEmail);
	fbad.enterMobileNumberOfSPOC(spocMobile);
	fbad.enterDesignationOfSPOC(spocDesignation);
	fbad.enterLandLineNumberOfSPOC(spocLandLine);
	fbad.clickOnTrainingRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(tcRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnTrainingRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(laboratoryPhotos);
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(washRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(cafetariaPhotos);
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_UploadFile();
	Thread.sleep(10000);
	fbad.clickOnAddSectorTarget();
	Thread.sleep(3000);
	fbad.selectSector(sector);
	Thread.sleep(3000);
	//fbad.selectCourse(course);
	fbad.enterTarget(target);
	fbad.clickOnSubmit_SectorTarget();
	Thread.sleep(8000);
	fbad.clickOnSubmit();
	Thread.sleep(3000);
	fbad.clickOnYesAddTrainingCentre();
	Thread.sleep(3000);
	//fbad.clickOnOK();
	Thread.sleep(3000);
	fbd.clickOnViewTrainingCentres();
	//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+trainingCentreName+"']]]]//span[text()='Awating Approval']")).getText(), "Awating Approval");
	Thread.sleep(2000);
	fbtc.clickOnAddTrainingCentre();
	Thread.sleep(3000);
	fbtc.selectTrainingCentreType(trainingCentreType);
	fbtc.clickOnSaveAndContinue();
	Thread.sleep(3000);
	fbad.enterTrainingCentreName(secondTrainingCentreName);
	//fbad.selectTrainingCentreStatus(tcStatus);
	fbad.selectForCentreOwnerShip(ownership);
	fbad.clickOnStartDateForTCDuration();
	startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate);
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
	fbad.clickOnEndDateForTCDuration();
	endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate);
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
	fbad.enterNumberOfBatchesPerDay(bathesNumber);
	fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
	fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
	fbad.enterCapacityUtilization(capacityUtilization);
	fbad.selectForGovernmentTieUp(governmentTieUp);
	fbad.enterCentreCapacity(centreCapacity);
	fbad.entreCentreArea(centreArea);
	fbad.enterNumberOfTrainingRooms(trainingRooms);
	fbad.enterNumbersOfLabs(labNumber);
	fbad.enterReceptionAreaSize(receptionArea);
	fbad.enterWaitingAreaCapacity(waitingArea);
	fbad.enterNumberOfMaleWashRooms(maleWashRooms);
	fbad.enterNumberOfFemaleWashRooms(femaleWashRooms);
	fbad.enterNumberOfUnisexWashRooms(unisexWashRooms);
	fbad.enterDistanceFromNearestAirport(airportDistance);
	fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
	fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
	fbad.enterAddressOFTC(tcAddress);
	fbad.enterNearByLandmark(landmark);
	fbad.enterPincode(pincode);
	fbad.selectState(state);
	Thread.sleep(2000);
	fbad.selrctDistrict(district);
	Thread.sleep(2000);
	fbad.selectTehsil(tehsil);
	Thread.sleep(2000);
	fbad.selectCityOrVillage(city);
	Thread.sleep(2000);
	fbad.selectParliamentryConstituency(parliamentryConstituency);
	fbad.enterGeoLocation(geoLocation);
	//fbad.selectAddressProofType(addressProof);
	Thread.sleep(3000);
	fbad.clickOnAllFacilitiesCheckBoxes();
	Thread.sleep(2000);
	fbad.enterNameOfSPOC(spocName);
	fbad.enterEmailAddressOfSPOC(secondSPOCEmail);
	fbad.enterMobileNumberOfSPOC(secondSPOCMobile);
	fbad.enterDesignationOfSPOC(spocDesignation);
	fbad.enterLandLineNumberOfSPOC(spocLandLine);
	fbad.clickOnTrainingRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(tcRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnTrainingRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(laboratoryPhotos);
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(washRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(cafetariaPhotos);
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_UploadFile();
	Thread.sleep(10000);
	fbad.clickOnAddSectorTarget();
	Thread.sleep(3000);
	fbad.selectSector(sector);
	Thread.sleep(3000);
	//fbad.selectCourse(course);
	Thread.sleep(3000);
	fbad.enterTarget(target);
	fbad.clickOnSubmit_SectorTarget();
	Thread.sleep(8000);
	fbad.clickOnSubmit();
	Thread.sleep(3000);
	fbad.clickOnYesAddTrainingCentre();
	Thread.sleep(3000);
	//fbad.clickOnOK();
	Thread.sleep(3000);
	fbd.clickOnViewTrainingCentres();
	//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+trainingCentreName+"']]]]//span[text()='Awating Approval']")).getText(), "Awating Approval");
	Thread.sleep(2000);
	fbtc.clickOnAddTrainingCentre();
	Thread.sleep(3000);
	fbtc.selectTrainingCentreType(trainingCentreType);
	fbtc.clickOnSaveAndContinue();
	Thread.sleep(3000);
	fbad.enterTrainingCentreName(thirdTrainingCentreName);
	//fbad.selectTrainingCentreStatus(tcStatus);
	fbad.selectForCentreOwnerShip(ownership);
	fbad.clickOnStartDateForTCDuration();
	startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate);
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
	fbad.clickOnEndDateForTCDuration();
	endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate);
	//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
	fbad.enterNumberOfBatchesPerDay(bathesNumber);
	fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
	fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
	fbad.enterCapacityUtilization(capacityUtilization);
	fbad.selectForGovernmentTieUp(governmentTieUp);
	fbad.enterCentreCapacity(centreCapacity);
	fbad.entreCentreArea(centreArea);
	fbad.enterNumberOfTrainingRooms(trainingRooms);
	fbad.enterNumbersOfLabs(labNumber);
	fbad.enterReceptionAreaSize(receptionArea);
	fbad.enterWaitingAreaCapacity(waitingArea);
	fbad.enterNumberOfMaleWashRooms(maleWashRooms);
	fbad.enterNumberOfFemaleWashRooms(femaleWashRooms);
	fbad.enterNumberOfUnisexWashRooms(unisexWashRooms);
	fbad.enterDistanceFromNearestAirport(airportDistance);
	fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
	fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
	fbad.enterAddressOFTC(tcAddress);
	fbad.enterNearByLandmark(landmark);
	fbad.enterPincode(pincode);
	Thread.sleep(2000);
	fbad.selectState(state);
	Thread.sleep(2000);
	fbad.selrctDistrict(district);
	Thread.sleep(2000);
	fbad.selectTehsil(tehsil);
	Thread.sleep(2000);
	fbad.selectCityOrVillage(city);
	Thread.sleep(2000);
	fbad.selectParliamentryConstituency(parliamentryConstituency);
	fbad.enterGeoLocation(geoLocation);
	//fbad.selectAddressProofType(addressProof);
	Thread.sleep(3000);
	fbad.clickOnAllFacilitiesCheckBoxes();
	Thread.sleep(2000);
	fbad.enterNameOfSPOC(spocName);
	fbad.enterEmailAddressOfSPOC(thirdSPOCEmail);
	fbad.enterMobileNumberOfSPOC(thirdSPOCMobile);
	fbad.enterDesignationOfSPOC(spocDesignation);
	fbad.enterLandLineNumberOfSPOC(spocLandLine);
	fbad.clickOnTrainingRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(tcRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnTrainingRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(laboratoryPhotos);
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(washRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(cafetariaPhotos);
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_UploadFile();
	Thread.sleep(10000);
	fbad.clickOnAddSectorTarget();
	Thread.sleep(3000);
	fbad.selectSector(sector);
	Thread.sleep(3000);
	//fbad.selectCourse(course);
	Thread.sleep(3000);
	fbad.enterTarget(target);
	fbad.clickOnSubmit_SectorTarget();
	Thread.sleep(8000);
	fbad.clickOnSubmit();
	Thread.sleep(3000);
	fbad.clickOnYesAddTrainingCentre();
	Thread.sleep(3000);
	//fbad.clickOnOK();
	Thread.sleep(3000);
	fbd.clickOnViewTrainingCentres();
	//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+trainingCentreName+"']]]]//span[text()='Awating Approval']")).getText(), "Awating Approval");
	PostLoginPage plp = new PostLoginPage(driver);
	Thread.sleep(5000);
	plp.clickOnProfileLogo();
	Thread.sleep(2000);
	plp.clickOnLogout();
}

@DataProvider
public Object[][] cmaApproveTC()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02");
}

@Test(dataProvider="cmaApproveTC", dependsOnMethods="addTrainingCentreTC04")
public void approveTrainingCentreTC_05(String cmaUsername, String cmaPassword, String tpID, String tcType, String status, String expectedTCName, String expectedTCStatus, String expectedOwnership, String expectedStartDate, String expectedEndDate, String expectedBathesNumber, String expectedStudentNumber, String expectedAnnualCapacity, String expectedCapacityUtilization, String expectedGovernmentTieUp, String expectedCentreCapacity, String expectedCentreArea, String expectedTrainingRooms, String expectedLabNumber, String expectedReceptionArea, String expectedWaitingArea, String expectedMaleWashRooms, String expectedFemaleWashRooms, String expectedUnisexWashRooms, String expectedAirportDistance, String expectedTrainStationDistance, String expectedCityCentreDistance, String expectedTCAddress, String expectedLandmark, String expectedPincode, String expectedState, String expectedDistrict, String expectedTehsil, String expectedCity, String expectedParliamentryConstituency, String expectedSPOCName, String expectedSPOCEmail, String expectedSPOCMobile, String expectedSPOCDesignation, String expectedSPOCLandLine, String review, String reviewComments, String expectedSecondTCName, String expectedSecondSPOCEmail, String expectedSecondSPOCMobile, String secondTCReview, String secondTCReviewComments, String expectedThirdTCName, String expectedThirdSPOCEmail, String expectedThirdSPOCMobile, String thirdTCReview, String thirdTCReviewComments) throws Exception
{
	LoginPage lp = new LoginPage(driver);
	lp.clickLogin();
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(cmaUsername, cmaPassword);
	CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
	Thread.sleep(8000);
	cmad.clickOnViewAllTCAddRequest();
	CMA_TCRequestPage cmtc = new CMA_TCRequestPage(driver);
	Thread.sleep(5000);
	cmtc.selectType(tcType);
	cmtc.selectStatus(status);
	cmtc.clickOnApply();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//a[contains(text(),'Take Action')]")).click();
	CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), expectedTCName);
	//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), expectedTCStatus);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), expectedOwnership);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), expectedBathesNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), expectedStudentNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), expectedAnnualCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), expectedCapacityUtilization);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), expectedGovernmentTieUp);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), expectedCentreCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), expectedCentreArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), expectedTrainingRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), expectedLabNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), expectedReceptionArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), expectedWaitingArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), expectedMaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), expectedFemaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), expectedUnisexWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), expectedAirportDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), expectedTrainStationDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), expectedCityCentreDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), expectedTCAddress);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), expectedLandmark);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), expectedPincode);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), expectedState);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), expectedDistrict);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), expectedTehsil);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), expectedCity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), expectedParliamentryConstituency);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), expectedSPOCName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), expectedSPOCEmail);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), expectedSPOCMobile);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), expectedSPOCDesignation);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), expectedSPOCLandLine);
	Thread.sleep(3000);
	cmat.clickOnDownloadTrainingRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadLaboratoryRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadWashRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
	Thread.sleep(3000);
	cmat.selectReview(review);
	cmat.enterReviewComments(reviewComments);
	cmat.clickOnSubmitResponse();
	cmat.clickOnOK();
	cmtc.selectType(tcType);
	Thread.sleep(3000);
	cmtc.clickOnApply();
	if(review.equals("Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
	}
	else if(review.equals("Not Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
	}
	else if(review.equals("Send Back"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
	}
	Thread.sleep(3000);
	cmtc.selectStatus(status);
	cmtc.clickOnApply();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//a[contains(text(),'Take Action')]")).click();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), expectedSecondTCName);
	//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), expectedTCStatus);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), expectedOwnership);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), expectedBathesNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), expectedStudentNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), expectedAnnualCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), expectedCapacityUtilization);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), expectedGovernmentTieUp);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), expectedCentreCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), expectedCentreArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), expectedTrainingRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), expectedLabNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), expectedReceptionArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), expectedWaitingArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), expectedMaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), expectedFemaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), expectedUnisexWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), expectedAirportDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), expectedTrainStationDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), expectedCityCentreDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), expectedTCAddress);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), expectedLandmark);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), expectedPincode);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), expectedState);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), expectedDistrict);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), expectedTehsil);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), expectedCity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), expectedParliamentryConstituency);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), expectedSPOCName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), expectedSecondSPOCEmail);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), expectedSecondSPOCMobile);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), expectedSPOCDesignation);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), expectedSPOCLandLine);
	Thread.sleep(3000);
	cmat.clickOnDownloadTrainingRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadLaboratoryRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadWashRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
	Thread.sleep(3000);
	cmat.selectReview(secondTCReview);
	cmat.enterReviewComments(secondTCReviewComments);
	cmat.clickOnSubmitResponse();
	cmat.clickOnOK();
	cmtc.selectType(tcType);
	Thread.sleep(3000);
	cmtc.clickOnApply();
	if(secondTCReview.equals("Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
	}
	else if(secondTCReview.equals("Not Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
	}
	else if(secondTCReview.equals("Send Back"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
	}
	Thread.sleep(3000);
	cmtc.selectStatus(status);
	cmtc.clickOnApply();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//a[contains(text(),'Take Action')]")).click();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), expectedThirdTCName);
	//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), expectedTCStatus);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), expectedOwnership);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), expectedBathesNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), expectedStudentNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), expectedAnnualCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), expectedCapacityUtilization);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), expectedGovernmentTieUp);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), expectedCentreCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), expectedCentreArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), expectedTrainingRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), expectedLabNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), expectedReceptionArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), expectedWaitingArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), expectedMaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), expectedFemaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), expectedUnisexWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), expectedAirportDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), expectedTrainStationDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), expectedCityCentreDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), expectedTCAddress);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), expectedLandmark);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), expectedPincode);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), expectedState);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), expectedDistrict);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), expectedTehsil);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), expectedCity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), expectedParliamentryConstituency);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), expectedSPOCName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), expectedThirdSPOCEmail);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), expectedThirdSPOCMobile);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), expectedSPOCDesignation);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), expectedSPOCLandLine);
	Thread.sleep(3000);
	cmat.clickOnDownloadTrainingRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadLaboratoryRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadWashRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
	Thread.sleep(3000);
	cmat.selectReview(thirdTCReview);
	cmat.enterReviewComments(thirdTCReviewComments);
	cmat.clickOnSubmitResponse();
	cmat.clickOnOK();
	cmtc.selectType(tcType);
	Thread.sleep(3000);
	cmtc.clickOnApply();
	if(thirdTCReview.equals("Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
	}
	else if(thirdTCReview.equals("Not Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
	}
	else if(thirdTCReview.equals("Send Back"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
	}
	
	
	PostLoginPage plp = new PostLoginPage(driver);
	Thread.sleep(3000);
	plp.clickOnProfileLogo();
	plp.clickOnLogout();

}

@DataProvider
public Object[][] resubmitAndReviewTC()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03");
}

@Test(dataProvider="resubmitAndReviewTC", dependsOnMethods="approveTrainingCentreTC_05")
public void resubmitAndReviewrainingCentreTC06(String sno, String tpUsername, String tpPassword, String projectName, String firstTCName, String firstTCReview, String secondTCName, String secondTCReview, String thirdTCName, String thirdTCReview, String newTrainingCentreName, String newTCStatus, String newOwnership, String newStartDate, String newEndDate, String newBathesNumber, String newStudentNumber, String newAnnualCapacity, String newCapacityUtilization, String newGovernmentTieUp, String newCentreCapacity, String newCentreArea, String newTrainingRooms, String newLabNumber, String newReceptionArea, String newWaitingArea, String newMaleWashRooms, String newFemaleWashRooms, String newUnisexWashRooms, String newAirportDistance, String newTrainStationDistance, String newCityCentreDistance, String newTCAddress, String newLandmark, String newPincode, String newState, String newDistrict, String newTehsil, String newCity, String newParliamentryConstituency, String geoLocation, String newSpocName, String newSpocEmail, String newSpocMobile, String newSpocDesignation, String newSpocLandLine, String newTCRoomPhotos, String newLaboratoryPhotos, String newWashRoomPhotos, String newCafetariaPhotos, String newSector, String newCourse, String newTarget, String cmaUsername, String cmaPassword, String tcType, String status, String review, String reviewComments)throws Exception
{
	LoginPage lp = new LoginPage(driver);
	lp.clickLogin();
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(tpUsername, tpPassword);
	TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
	Thread.sleep(8000);
	tpdp.clickOnMySchemes();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
	TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
	Thread.sleep(3000);
	fbd.clickOnViewTrainingCentres();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+firstTCName+"']]]]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+thirdTCName+"']]]]//span[text()='REJECTED']")).getText(), "REJECTED");
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+secondTCName+"']]]]//span[text()='Sent Back']")).getText(), "Sent Back");
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+secondTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+secondTCName+"']]]]//a[contains(text(),'View Details')]")).click();
	TP_FeeBased_AddTrainingCentrePage fbad = new TP_FeeBased_AddTrainingCentrePage(driver);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='review']")).getAttribute("value"), "Document Required");
	//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='comment']")).getAttribute("value"), "SENT BACK");
	Thread.sleep(3000);
	fbad.enterTrainingCentreName(newTrainingCentreName);
	//fbad.selectTrainingCentreStatus(newTCStatus);
	fbad.selectForCentreOwnerShip(newOwnership);
	fbad.clickOnStartDateForTCDuration();
	newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 13, newStartDate);
	fbad.clickOnEndDateForTCDuration();
	newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 14, newEndDate);
	Thread.sleep(3000);
	fbad.enterNumberOfBatchesPerDay(newBathesNumber);
	Thread.sleep(3000);
	fbad.enterMaximumNoOfStudentPerBatch(newStudentNumber);
	fbad.enterAnnualCapacityOfTrainingCentre(newAnnualCapacity);
	fbad.enterCapacityUtilization(newCapacityUtilization);
	fbad.selectForGovernmentTieUp(newGovernmentTieUp);
	fbad.enterCentreCapacity(newCentreCapacity);
	fbad.entreCentreArea(newCentreArea);
	fbad.enterNumberOfTrainingRooms(newTrainingRooms);
	fbad.enterNumbersOfLabs(newLabNumber);
	fbad.enterReceptionAreaSize(newReceptionArea);
	fbad.enterWaitingAreaCapacity(newWaitingArea);
	fbad.enterNumberOfMaleWashRooms(newMaleWashRooms);
	fbad.enterNumberOfFemaleWashRooms(newFemaleWashRooms);
	fbad.enterNumberOfUnisexWashRooms(newUnisexWashRooms);
	fbad.enterDistanceFromNearestAirport(newAirportDistance);
	fbad.enterDistanceFromNearestTrainStation(newTrainStationDistance);
	fbad.enterDistanceFromNearestCityCentre(newCityCentreDistance);
	fbad.enterAddressOFTC(newTCAddress);
	fbad.enterNearByLandmark(newLandmark);
	fbad.enterPincode(newPincode);
	fbad.selectState(newState);
	Thread.sleep(2000);
	fbad.selrctDistrict(newDistrict);
	Thread.sleep(2000);
	fbad.selectTehsil(newTehsil);
	Thread.sleep(2000);
	fbad.selectCityOrVillage(newCity);
	Thread.sleep(2000);
	fbad.selectParliamentryConstituency(newParliamentryConstituency);
	fbad.enterGeoLocation(geoLocation);
	//fbad.selectAddressProofType(addressProof);
	Thread.sleep(3000);
	//fbad.clickOnAllFacilitiesCheckBoxes();
	Thread.sleep(2000);
	fbad.enterNameOfSPOC(newSpocName);
	fbad.enterEmailAddressOfSPOC(newSpocEmail);
	fbad.enterMobileNumberOfSPOC(newSpocMobile);
	fbad.enterDesignationOfSPOC(newSpocDesignation);
	fbad.enterLandLineNumberOfSPOC(newSpocLandLine);
	fbad.clickOnTrainingRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(newTCRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnTrainingRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(newLaboratoryPhotos);
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(newWashRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnWashRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(newCafetariaPhotos);
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_UploadFile();
	Thread.sleep(10000);
	fbad.clickOnAddSectorTarget();
	Thread.sleep(3000);
	fbad.selectSector(newSector);
	//fbad.selectCourse(newCourse);
	Thread.sleep(3000);
	fbad.enterTarget(newTarget);
	fbad.clickOnSubmit_SectorTarget();
	Thread.sleep(5000);
	fbad.clickOnResubmit();
	Thread.sleep(3000);
	fbad.clickOnYesAddTrainingCentre();
	Thread.sleep(3000);
	fbad.clickOnOK();
	Thread.sleep(3000);
	//fbd.clickOnViewTrainingCentres();
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='RESUBMITTED']")).getText(), "RESUBMITTED");
	PostLoginPage plp = new PostLoginPage(driver);
	Thread.sleep(5000);
	plp.clickOnProfileLogo();
	Thread.sleep(2000);
	plp.clickOnLogout();
	
	lp.clickLogin();
	Thread.sleep(3000);
	elp.performlogin(cmaUsername, cmaPassword);
	CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
	Thread.sleep(8000);
	cmad.clickOnViewAllTCAddRequest();
	CMA_TCRequestPage cmtc = new CMA_TCRequestPage(driver);
	Thread.sleep(5000);
	cmtc.selectType(tcType);
	cmtc.selectStatus(status);
	cmtc.clickOnApply();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[contains(text(),'Take Action')]")).click();
	CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), newTrainingCentreName);
	//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), newTCStatus);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), newOwnership);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), newStartDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), newEndDate);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), newBathesNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), newStudentNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), newAnnualCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), newCapacityUtilization);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), newGovernmentTieUp);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), newCentreCapacity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), newCentreArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), newTrainingRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), newLabNumber);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), newReceptionArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), newWaitingArea);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), newMaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), newFemaleWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), newUnisexWashRooms);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), newAirportDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), newTrainStationDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), newCityCentreDistance);
	Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), newTCAddress);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), newLandmark);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), newPincode);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), newState);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), newDistrict);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), newTehsil);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), newCity);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), newParliamentryConstituency);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), newSpocName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), newSpocEmail);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), newSpocMobile);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), newSpocDesignation);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), newSpocLandLine);
	Thread.sleep(3000);
	cmat.clickOnDownloadTrainingRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadLaboratoryRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadWashRoomPhotos();
	Thread.sleep(3000);
	cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
	Thread.sleep(3000);
	cmat.selectReview(review);
	cmat.enterReviewComments(reviewComments);
	cmat.clickOnSubmitResponse();
	cmat.clickOnOK();
	cmtc.selectType(tcType);
	Thread.sleep(3000);
	cmtc.clickOnApply();
	if(review.equals("Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
	}
	else if(review.equals("Not Recommended"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
	}
	else if(review.equals("Send Back"))
	{
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
	}
	Thread.sleep(3000);
	plp.clickOnProfileLogo();
	plp.clickOnLogout();
	
	
}



@DataProvider
public Object[][] addSectorAndCourses()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSector&CoursSC15TC04");
}

@Test(dataProvider="addSectorAndCourses", dependsOnMethods="resubmitAndReviewrainingCentreTC06")
public void addSectorAndCourseTC07(String srno, String tpusername, String tppassword, String projectName, String addedSector, String sector, String trainingTarget, String undertakingFile, String affiliationCertificate, String secondSector, String thirdSector, String addedCourse, String courseName, String jobRole, String jobRoleName, String nsqfLevel, String courseDescription, String certificateName, String minimumAge, String minimumEducation, String courseDuration, String hourPerDay, String courseFee, String gradingPreference, String courseApprovalFile, String affiliationFile, String workOrderFile, String challanOfFeePaid, String stampPaper, String secondCourseName, String thirdCourseName) throws Exception
{
	LoginPage lp = new LoginPage(driver);
	lp.clickLogin();
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(tpusername, tppassword);
	TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
	Thread.sleep(8000);
	tpdp.clickOnMySchemes();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();		
	TP_FeeBased_DashboardPage tpfb = new TP_FeeBased_DashboardPage(driver);
	Thread.sleep(3000);
	tpfb.clickOnViewSectorAndCourses();
	TP_FeeBased_ViewAllSectorAndCoursesPage fbsc = new TP_FeeBased_ViewAllSectorAndCoursesPage(driver);
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+addedSector+"']]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
	Thread.sleep(5000);
	fbsc.clickOnAddSector();
	Thread.sleep(5000);
	fbsc.selectSector(sector);
	fbsc.enterProposedTrainingTarget(trainingTarget);
	fbsc.clickOnUndertakingDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(undertakingFile);
	Thread.sleep(3000);
	fbsc.clickOnUndertakingDocument_UploadFile();
	Thread.sleep(3000);
	fbsc.clickOnAffiliationCertificate_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(affiliationCertificate);
	Thread.sleep(3000);
	fbsc.clickOnAffiliationCertificate_UploadFile();
	Thread.sleep(3000);
	fbsc.clickOnSubmit();
	Thread.sleep(3000);
	fbsc.clickOnOK();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//span[text()='CREATED']")).getText(), "CREATED");
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//td[text()='"+trainingTarget+"']")).getText(), trainingTarget);
	Thread.sleep(3000);
	fbsc.clickOnAddSector();
	Thread.sleep(3000);
	fbsc.selectSector(secondSector);
	fbsc.enterProposedTrainingTarget(trainingTarget);
	fbsc.clickOnUndertakingDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(undertakingFile);
	Thread.sleep(3000);
	fbsc.clickOnUndertakingDocument_UploadFile();
	Thread.sleep(3000);
	fbsc.clickOnAffiliationCertificate_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(affiliationCertificate);
	Thread.sleep(3000);
	fbsc.clickOnAffiliationCertificate_UploadFile();
	Thread.sleep(3000);
	fbsc.clickOnSubmit();
	Thread.sleep(3000);
	fbsc.clickOnOK();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondSector+"']]//span[text()='CREATED']")).getText(), "CREATED");
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondSector+"']]//td[text()='"+trainingTarget+"']")).getText(), trainingTarget);
	Thread.sleep(3000);
	fbsc.clickOnAddSector();
	Thread.sleep(3000);
	fbsc.selectSector(thirdSector);
	Thread.sleep(3000);
	fbsc.enterProposedTrainingTarget(trainingTarget);
	fbsc.clickOnUndertakingDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(undertakingFile);
	Thread.sleep(3000);
	fbsc.clickOnUndertakingDocument_UploadFile();
	Thread.sleep(3000);
	fbsc.clickOnAffiliationCertificate_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(affiliationCertificate);
	Thread.sleep(3000);
	fbsc.clickOnAffiliationCertificate_UploadFile();
	Thread.sleep(3000);
	fbsc.clickOnSubmit();
	Thread.sleep(3000);
	fbsc.clickOnOK();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdSector+"']]//span[text()='CREATED']")).getText(), "CREATED");
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdSector+"']]//td[text()='"+trainingTarget+"']")).getText(), trainingTarget);
	
	fbsc.clickOnAddedCourse();
	Thread.sleep(3000);
	//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+addedCourse+"']]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
	Thread.sleep(3000);
	fbsc.clickOnAddCourse();
	TP_FeeBased_AddCourseToSectorsPage adc = new TP_FeeBased_AddCourseToSectorsPage(driver);
	
	adc.selectSector(addedSector);
	adc.selectJobRoleMappingType(jobRole);
	if(jobRole.equals("QP-NOS"))
	{
		adc.selectAssociatedQPOrJobRoleName(jobRoleName);
		Thread.sleep(3000);
		adc.enterCourseName(courseName);
		nsqfLevel = driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSector&CoursSC15TC04", Integer.parseInt(srno), 15, nsqfLevel);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveSector&CourseSC15TC05", Integer.parseInt(srno), 19, nsqfLevel);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(srno), 15, nsqfLevel);
		//adc.enterCourseDescription(courseDescription);
		adc.enterNameOfTheCertificateIssued(certificateName);
		//adc.selectMinimumAge(minimumAge);
	}
	else
	{
		adc.enterCourseName(courseName);
		adc.enterCourseDescription(courseDescription);
		adc.enterNameOfTheCertificateIssued(certificateName);
		adc.selectMinimumAge(minimumAge);
	}
	
	adc.selectMinimumEducationRequired(minimumEducation);
	adc.enterCourseDuration(courseDuration);
	adc.enterNumberOfHours(hourPerDay);
	adc.enterCourseFee(courseFee);
	adc.selectGradingPrefrences(gradingPreference);
	Thread.sleep(3000);
	adc.clickOnCourseApprovalDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(courseApprovalFile);
	Thread.sleep(3000);
	adc.clickOnCourseApprovalDocument_UploadFile();
	Thread.sleep(3000);
	adc.clickOnAffiliationCertificate_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(affiliationFile);
	Thread.sleep(3000);
	adc.clickOnAffiliationCertificate_UploadFile();
	Thread.sleep(3000);
	adc.clickOnWorkOrder_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(workOrderFile);
	Thread.sleep(3000);
	adc.clickOnWorkOrder_UploadFile();
	Thread.sleep(3000);
	adc.clickOnChallanOfFeePaid_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(challanOfFeePaid);
	Thread.sleep(3000);
	adc.clickOnChallanOfFeePaid_UploadFile();
	Thread.sleep(3000);
	adc.clickOnStampPaper_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(stampPaper);
	Thread.sleep(3000);
	adc.clickOnStampPaper_UploadFile();
	Thread.sleep(3000);
	adc.clickOnSubmit();
	Thread.sleep(3000);
	fbsc.clickOnAddedCourse();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//span[text()='CREATED']")).getText(), "CREATED");
	if(jobRole.equals("QP-NOS"))
	{
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+jobRoleName+"']")).getText(), jobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+nsqfLevel+"']")).getText(), nsqfLevel);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
	}
	else
	{
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
	}
	Thread.sleep(3000);
	fbsc.clickOnAddCourse();
	adc.selectSector(addedSector);
	adc.selectJobRoleMappingType(jobRole);
	if(jobRole.equals("QP-NOS"))
	{
		adc.selectAssociatedQPOrJobRoleName(jobRoleName);
		Thread.sleep(3000);
		adc.enterCourseName(secondCourseName);
		nsqfLevel = driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value");
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(srno), 13, nsqfLevel);
		//adc.enterCourseDescription(courseDescription);
		adc.enterNameOfTheCertificateIssued(certificateName);
		//adc.selectMinimumAge(minimumAge);
	}
	else
	{
		Thread.sleep(3000);
		adc.enterCourseName(secondCourseName);
		adc.enterCourseDescription(courseDescription);adc.enterNameOfTheCertificateIssued(certificateName);
		adc.selectMinimumAge(minimumAge);
	}
	
	adc.selectMinimumEducationRequired(minimumEducation);
	adc.enterCourseDuration(courseDuration);
	adc.enterNumberOfHours(hourPerDay);
	adc.enterCourseFee(courseFee);
	adc.selectGradingPrefrences(gradingPreference);
	Thread.sleep(3000);
	adc.clickOnCourseApprovalDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(courseApprovalFile);
	Thread.sleep(3000);
	adc.clickOnCourseApprovalDocument_UploadFile();
	Thread.sleep(3000);
	adc.clickOnAffiliationCertificate_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(affiliationFile);
	Thread.sleep(3000);
	adc.clickOnAffiliationCertificate_UploadFile();
	Thread.sleep(3000);
	adc.clickOnWorkOrder_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(workOrderFile);
	Thread.sleep(3000);
	adc.clickOnWorkOrder_UploadFile();
	Thread.sleep(3000);
	adc.clickOnChallanOfFeePaid_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(challanOfFeePaid);
	Thread.sleep(3000);
	adc.clickOnChallanOfFeePaid_UploadFile();
	Thread.sleep(3000);
	adc.clickOnStampPaper_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(stampPaper);
	Thread.sleep(3000);
	adc.clickOnStampPaper_UploadFile();
	Thread.sleep(3000);
	adc.clickOnSubmit();
	Thread.sleep(3000);
	fbsc.clickOnAddedCourse();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//span[text()='CREATED']")).getText(), "CREATED");
	if(jobRole.equals("QP-NOS"))
	{
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+jobRoleName+"']")).getText(), jobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+nsqfLevel+"']")).getText(), nsqfLevel);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
	}
	else
	{
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
	}
	Thread.sleep(3000);
	fbsc.clickOnAddCourse();
	adc.selectSector(addedSector);
	adc.selectJobRoleMappingType(jobRole);
	if(jobRole.equals("QP-NOS"))
	{
		adc.selectAssociatedQPOrJobRoleName(jobRoleName);
		adc.enterCourseName(thirdCourseName);
		nsqfLevel = driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value");
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(srno), 13, nsqfLevel);
		//adc.enterCourseDescription(courseDescription);
		adc.enterNameOfTheCertificateIssued(certificateName);
		//adc.selectMinimumAge(minimumAge);
		
	}
	else
	{
		adc.enterCourseName(thirdCourseName);
		adc.enterCourseDescription(courseDescription);
		adc.enterNameOfTheCertificateIssued(certificateName);
		adc.selectMinimumAge(minimumAge);
	}
	
	adc.selectMinimumEducationRequired(minimumEducation);
	adc.enterCourseDuration(courseDuration);
	adc.enterNumberOfHours(hourPerDay);
	adc.enterCourseFee(courseFee);
	adc.selectGradingPrefrences(gradingPreference);
	Thread.sleep(3000);
	adc.clickOnCourseApprovalDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(courseApprovalFile);
	Thread.sleep(3000);
	adc.clickOnCourseApprovalDocument_UploadFile();
	Thread.sleep(3000);
	adc.clickOnAffiliationCertificate_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(affiliationFile);
	Thread.sleep(3000);
	adc.clickOnAffiliationCertificate_UploadFile();
	Thread.sleep(3000);
	adc.clickOnWorkOrder_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(workOrderFile);
	Thread.sleep(3000);
	adc.clickOnWorkOrder_UploadFile();
	Thread.sleep(3000);
	adc.clickOnChallanOfFeePaid_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(challanOfFeePaid);
	Thread.sleep(3000);
	adc.clickOnChallanOfFeePaid_UploadFile();
	Thread.sleep(3000);
	adc.clickOnStampPaper_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(stampPaper);
	Thread.sleep(3000);
	adc.clickOnStampPaper_UploadFile();
	Thread.sleep(3000);
	adc.clickOnSubmit();
	Thread.sleep(3000);
	fbsc.clickOnAddedCourse();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//span[text()='CREATED']")).getText(), "CREATED");
	if(jobRole.equals("QP-NOS"))
	{
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+jobRoleName+"']")).getText(), jobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+nsqfLevel+"']")).getText(), nsqfLevel);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
	}
	else
	{
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
	}
	PostLoginPage  plp = new PostLoginPage(driver);
	Thread.sleep(3000);
	plp.clickOnProfileLogo();
	plp.clickOnLogout();
	
}

@DataProvider
public Object[][] approveSectorAndCourses()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveSector&CourseSC15TC05");
}

@Test(dataProvider="approveSectorAndCourses", dependsOnMethods="addSectorAndCourseTC07")
public void approveSectorAndCourseTC08(String sno, String cmaUsername, String cmaPassword, String status, String tpID, String expectedSector, String expectedTrainingTarget, String sectorReviewComments, String sectorComments, String expectedSecondSector, String secondSectorReviewComments, String secondSectorComments, String expectedThirdSector, String thirdSectorReviewComments, String thirdSectorComments,  String expectedCourseName, String expectedAddedSector, String expectedJobRoleMappingType, String expectedJobRoleName, String expectedNSQFLevel, String expectedCourseDescription, String expectedIssuedCertificateName, String expectedMinimumAge, String expectedMinimumEducation, String expectedCourseDuration, String expectedNumberOfHours, String expectedCourseFee, String expectedGradingPrefrences, String courseReviewComments, String courseComments, String expectedSecondCourseName, String secondCourseReviewComments, String secondCourseComments, String expectedThirdCourseName, String thirdCourseReviewComments, String thirdCourseComments)throws Exception
{
	LoginPage lp = new LoginPage(driver);
	Thread.sleep(3000);
	lp.clickLogin();
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(cmaUsername, cmaPassword);
	CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
	Thread.sleep(8000);
	cmad.clickOnViewAllSector();
	CMA_AddSectorRequestPage cmas = new CMA_AddSectorRequestPage(driver);
	Thread.sleep(3000);
	cmas.selectStatus(status);
	cmas.enterTPID(tpID);
	Thread.sleep(5000);
	cmas.clickOnApply();
	Thread.sleep(3000);
	List <WebElement> button = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
	int size = button.size();
	WebElement ele = button.get(size-1);
	ele.click();
	Thread.sleep(3000);
	List<WebElement> sec = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
	int size1 = sec.size();
	WebElement tab = sec.get(size1-1);
	tab.click();
	CMA_SectorInfoPage cmsi = new CMA_SectorInfoPage(driver);
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedSector);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposedTrainingTarget']")).getAttribute("value"), expectedTrainingTarget);
	cmsi.clickOnDownloadSectorApprovalButton();
	cmsi.clickOnDownloadAffiliationCertificateFromSSC();
	cmsi.selectReviewComments(sectorReviewComments);
	cmsi.enterReviewComents_ForSector(sectorComments);
	cmsi.clickOnSubmitResponse();
	Thread.sleep(3000);
	cmas.selectStatus(sectorComments);
	cmas.enterTPID(tpID);
	Thread.sleep(10000);
	cmas.clickOnApply();
	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='"+sectorComments+"'])[1]")).getText(), sectorComments);
	Thread.sleep(3000);
	cmas.selectStatus(status);
	Thread.sleep(8000);
	cmas.clickOnApply();
	Thread.sleep(3000);
	List <WebElement> buton = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
	int siz = buton.size();
	WebElement el = buton.get(siz-1);
	Thread.sleep(5000);
	el.click();
	Thread.sleep(3000);
	List<WebElement> se = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
	int siz1 = se.size();
	WebElement ta = se.get(siz1-1);
	Thread.sleep(5000);
	ta.click();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedSecondSector);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposedTrainingTarget']")).getAttribute("value"), expectedTrainingTarget);
	cmsi.clickOnDownloadSectorApprovalButton();
	cmsi.clickOnDownloadAffiliationCertificateFromSSC();
	cmsi.selectReviewComments(secondSectorReviewComments);
	cmsi.enterReviewComents_ForSector(secondSectorComments);
	cmsi.clickOnSubmitResponse();
	Thread.sleep(3000);
	cmas.selectStatus(secondSectorComments);
	cmas.enterTPID(tpID);
	Thread.sleep(8000);
	cmas.clickOnApply();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='"+secondSectorComments+"'])[1]")).getText(), secondSectorComments);
	Thread.sleep(3000);
	cmas.selectStatus(status);
	Thread.sleep(8000);
	cmas.clickOnApply();
	Thread.sleep(3000);
	List <WebElement> butn = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
	int sz = butn.size();
	WebElement elm = butn.get(sz-1);
	Thread.sleep(5000);
	elm.click();
	Thread.sleep(3000);
	List<WebElement> sez = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
	int sz1 = sez.size();
	WebElement tak = sez.get(sz1-1);
	Thread.sleep(5000);
	tak.click();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedThirdSector);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposedTrainingTarget']")).getAttribute("value"), expectedTrainingTarget);
	cmsi.clickOnDownloadSectorApprovalButton();
	cmsi.clickOnDownloadAffiliationCertificateFromSSC();
	cmsi.selectReviewComments(thirdSectorReviewComments);
	cmsi.enterReviewComents_ForSector(thirdSectorComments);
	cmsi.clickOnSubmitResponse();
	Thread.sleep(3000);
	cmas.selectStatus(thirdSectorComments);
	cmas.enterTPID(tpID);
	Thread.sleep(8000);
	cmas.clickOnApply();
	Thread.sleep(5000);
	Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='"+thirdSectorComments+"'])[1]")).getText(), thirdSectorComments);
	
	Thread.sleep(10000);
	cmad.clickOnDashboard();
	Thread.sleep(8000);
	cmad.clickOnViewAllCourseAddRequest();
	CMA_AddCourseRequestsPage cmac = new CMA_AddCourseRequestsPage(driver);
	cmac.selectStatus(status);
	cmac.enterTPID(tpID);
	Thread.sleep(8000);
	cmac.clickOnApply();
	Thread.sleep(5000);
	List<WebElement> cou = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
	int size2 = cou.size();
	WebElement act = cou.get(size2-1);
	act.click();
	Thread.sleep(3000);
	List<WebElement> crs = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
	int size3 = crs.size();
	WebElement tap = crs.get(size3-1);
	tap.click();
	CMA_CourseInfoPage cmci = new CMA_CourseInfoPage(driver);
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='course']")).getAttribute("value"), expectedCourseName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedAddedSector);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleMappingType']")).getAttribute("value"), expectedJobRoleMappingType);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleName']")).getAttribute("value"), expectedJobRoleName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
	//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value"), expectedCourseDescription);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
	//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumAge']")).getAttribute("value"), expectedMinimumAge);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumEducationRequiredValue']")).getAttribute("value"), expectedMinimumEducation);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseDurationInDays']")).getAttribute("value"), expectedCourseDuration);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='hoursPerDay']")).getAttribute("value"), expectedNumberOfHours);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseFee']")).getAttribute("value"), expectedCourseFee);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='gradingPreferences']")).getAttribute("value"), expectedGradingPrefrences);
	cmci.clickOnDownloadCourseApprovalDocument();
	cmci.clickOnDownloadAffiliationCertificateFromSSC();
	cmci.clickOnDownloadWorkOrder();
	cmci.clciOnDownloadChallanOfFeePaid();
	cmci.clickOnDownloadStampPaperWithSelfDeclaration();
	cmci.selectReviewComments(courseReviewComments);
	cmci.enterComments(courseComments);
	cmci.clickOnSubmitResponse();
	cmac.selectStatus(courseComments);
	cmac.enterTPID(tpID);
	Thread.sleep(8000);
	cmac.clickOnApply();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+expectedCourseName+"']]]]//span[text()='"+courseComments+"']")).getText(), courseComments);
	Thread.sleep(3000);
	cmac.selectStatus(status);
	Thread.sleep(8000);
	cmac.clickOnApply();
	Thread.sleep(3000);
	List<WebElement> cour = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
	int siz2 = cour.size();
	WebElement actn = cour.get(siz2-1);
	Thread.sleep(5000);
	actn.click();
	Thread.sleep(3000);
	List<WebElement> crse = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
	int siz3 = crse.size();
	WebElement tapm = crse.get(siz3-1);
	Thread.sleep(5000);
	tapm.click();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='course']")).getAttribute("value"), expectedSecondCourseName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedAddedSector);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleMappingType']")).getAttribute("value"), expectedJobRoleMappingType);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleName']")).getAttribute("value"), expectedJobRoleName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
	//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value"), expectedCourseDescription);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
	//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumAge']")).getAttribute("value"), expectedMinimumAge);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumEducationRequiredValue']")).getAttribute("value"), expectedMinimumEducation);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseDurationInDays']")).getAttribute("value"), expectedCourseDuration);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='hoursPerDay']")).getAttribute("value"), expectedNumberOfHours);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseFee']")).getAttribute("value"), expectedCourseFee);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='gradingPreferences']")).getAttribute("value"), expectedGradingPrefrences);
	cmci.clickOnDownloadCourseApprovalDocument();
	cmci.clickOnDownloadAffiliationCertificateFromSSC();
	cmci.clickOnDownloadWorkOrder();
	cmci.clciOnDownloadChallanOfFeePaid();
	cmci.clickOnDownloadStampPaperWithSelfDeclaration();
	cmci.selectReviewComments(secondCourseReviewComments);
	cmci.enterComments(secondCourseComments);
	cmci.clickOnSubmitResponse();
	cmac.selectStatus(secondCourseComments);
	Thread.sleep(3000);
	cmac.enterTPID(tpID);
	Thread.sleep(8000);
	cmac.clickOnApply();
	Thread.sleep(5000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondCourseName+"']]]]//span[text()='"+secondCourseComments+"']")).getText(), secondCourseComments);
	Thread.sleep(3000);
	cmac.selectStatus(status);
	Thread.sleep(8000);
	cmac.clickOnApply();
	Thread.sleep(3000);
	List<WebElement> cours = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
	int sze2 = cours.size();
	WebElement acti = cours.get(sze2-1);
	Thread.sleep(5000);
	acti.click();
	Thread.sleep(3000);
	List<WebElement> crss = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
	int sze3 = crss.size();
	WebElement tapk = crss.get(sze3-1);
	Thread.sleep(5000);
	tapk.click();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='course']")).getAttribute("value"), expectedThirdCourseName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedAddedSector);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleMappingType']")).getAttribute("value"), expectedJobRoleMappingType);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleName']")).getAttribute("value"), expectedJobRoleName);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
	//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value"), expectedCourseDescription);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
	//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumAge']")).getAttribute("value"), expectedMinimumAge);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumEducationRequiredValue']")).getAttribute("value"), expectedMinimumEducation);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseDurationInDays']")).getAttribute("value"), expectedCourseDuration);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='hoursPerDay']")).getAttribute("value"), expectedNumberOfHours);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseFee']")).getAttribute("value"), expectedCourseFee);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='gradingPreferences']")).getAttribute("value"), expectedGradingPrefrences);
	cmci.clickOnDownloadCourseApprovalDocument();
	cmci.clickOnDownloadAffiliationCertificateFromSSC();
	cmci.clickOnDownloadWorkOrder();
	cmci.clciOnDownloadChallanOfFeePaid();
	cmci.clickOnDownloadStampPaperWithSelfDeclaration();
	cmci.selectReviewComments(thirdCourseReviewComments);
	cmci.enterComments(thirdCourseComments);
	cmci.clickOnSubmitResponse();
	cmac.selectStatus(thirdCourseComments);
	cmac.enterTPID(tpID);
	Thread.sleep(8000);
	cmac.clickOnApply();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdCourseName+"']]]]//span[text()='"+thirdCourseComments+"']")).getText(), thirdCourseComments);
	Thread.sleep(3000);
	PostLoginPage plp = new PostLoginPage(driver);
	Thread.sleep(3000);
	plp.clickOnProfileLogo();
	plp.clickOnLogout();
}


@DataProvider
public Object[][] linkTrainer()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06");
}

@Test(dataProvider="linkTrainer", dependsOnMethods="approveSectorAndCourseTC08")
public void linkTrainerTC09(String sno, String tpUsername, String tpPassword, String projectName, String trainerSDMSID, String trainerName, String tcName, String supportingDocument, String mobileOTP, String emailOTP, String trainersEmail, String trainersMobile)throws Exception
{
	LoginPage lp = new LoginPage(driver);
	lp.clickLogin();
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(tpUsername, tpPassword);
	TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
	Thread.sleep(8000);
	tpdp.clickOnMySchemes();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
	TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
	Thread.sleep(5000);
	fbd.clickOnViewTrainers();
	TP_FeeBased_ViewAllTrainersPage vat = new TP_FeeBased_ViewAllTrainersPage(driver);
	Thread.sleep(3000);
	vat.clickOnLinkNewTrainer();
	Thread.sleep(3000);
	vat.enterTrainerSDMSID(trainerSDMSID);
	Thread.sleep(3000);

	vat.selectAssociatedTrainingCentreName(tcName);
	vat.clickOnStartDateForValidity();
	vat.clickOnEndDateForValidity();
	Thread.sleep(3000);
	vat.clickOnSupportingDocument_BrowseFileButton();
	Thread.sleep(3000);
	UploadFile.upload(supportingDocument);
	Thread.sleep(3000);
	vat.clickOnSuppoertingDocument_UploadFileButton();
	Thread.sleep(3000);
	trainerName = driver.findElement(By.xpath("//input[@id='nameOfTheTrainer']")).getAttribute("value");
	Thread.sleep(3000);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 5, trainerName);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 16, trainerName);
	Thread.sleep(5000);
	vat.clickOnGenerateOTP();
	Thread.sleep(3000);
	vat.enterMobileOTP(mobileOTP);
	vat.enterEmailOTP(emailOTP);
	vat.clickOnVerifyOTP();
	vat.clickOnOK();
	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+trainerName+"']")).getText(), trainerName);
	Thread.sleep(3000);
	trainersEmail = driver.findElement(By.xpath("(//tr[td[text()='"+trainerName+"']]/td)[3]")).getText();
	Thread.sleep(3000);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 10, trainersEmail);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 17, trainersEmail);
	Thread.sleep(3000);
	trainersMobile = driver.findElement(By.xpath("(//tr[td[text()='"+trainerName+"']]/td)[4]")).getText();
	Thread.sleep(3000);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 11, trainersMobile);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 18, trainersMobile);
	PostLoginPage plp = new PostLoginPage(driver);
	Thread.sleep(3000);
	plp.clickOnProfileLogo();
	plp.clickOnLogout();
	
}


@DataProvider
public Object[][] addAssessmentAgencyAndLinkAssessor()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07");
}

@Test(dataProvider="addAssessmentAgencyAndLinkAssessor", dependsOnMethods="linkTrainerTC09")
public void addAssessmentAgencyAndLinkAssessorTC10(String srno, String tpUsername, String tpPassword, String projectName, String assessmentAgencyName, String supportingDocumentFile, String assessmentAgencyAddress, String landmark, String pincode, String state, String district, String tehsil, String parliamentryConstoituency, String geoLocation, String firstName, String lastName, String email, String mobileNumber, String asseementAgencyID,  String assessorID, String assessorName, String assessmentAgency, String supportingDocument_Assessor, String mobileOTP, String emailOTP)throws Exception
{
	LoginPage lp = new LoginPage(driver);
	lp.clickLogin();
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(tpUsername, tpPassword);
	TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
	Thread.sleep(8000);
	tpdp.clickOnMySchemes();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
	TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
	Thread.sleep(5000);
	fbd.clickOnViewAssessmentAgencyAndAssessors();
	TP_FeeBased_AssessmentAgencyAndAssessorPage tpaa = new TP_FeeBased_AssessmentAgencyAndAssessorPage(driver);
	Thread.sleep(3000);
	tpaa.clickOnAddAssessmentAgency();
	TP_FeeBased_AssessmentAgencyInfoPage aai = new TP_FeeBased_AssessmentAgencyInfoPage(driver);
	Thread.sleep(3000);
	aai.enterAssessmentAgencyName(assessmentAgencyName);
	aai.enterStartDate();
	aai.enterEndDate();
	aai.clickOnSupportingDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(supportingDocumentFile);
	Thread.sleep(3000);
	aai.clickOnSupportingDocument_UploadButton();
	Thread.sleep(3000);
	aai.enterAddressOfAssessmentAgency(assessmentAgencyAddress);
	aai.enterNearByLandmark(landmark);
	aai.enterPincode(pincode);
	aai.selectState(state);
	aai.selectDistrict(district);
	aai.selectTehsilOrBlock(tehsil);
	aai.selectParliamentryConstituency(parliamentryConstoituency);
	Thread.sleep(2000);
	aai.enterGeoLocation(geoLocation);
	Thread.sleep(3000);
	aai.enterFirstNameOfSPOC(firstName);
	aai.enterLastNameOfSPOC(lastName);
	aai.enterEmailAddressOfSPOC(email);
	aai.enterMobileNumberOfSPOC(mobileNumber);
	aai.clickOnSubmit();
	asseementAgencyID = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().replace("Assessment Agency ", "").replace(" successfully added.", "");
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07", Integer.parseInt(srno), 18, asseementAgencyID);
	aai.clickOnOK();
	Thread.sleep(3000);
	tpaa.clickOnLinkAssessor();
	Thread.sleep(3000);
	tpaa.enterAssessorSDMSID(assessorID);
	Thread.sleep(3000);
	tpaa.selectAssessmentAgencyAligned(assessmentAgency);
	tpaa.clickOnStartDateForValidity();
	tpaa.clickOnEndDateForValidity();
	Thread.sleep(3000);
	tpaa.clickOnSupportingDocument_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(supportingDocument_Assessor);
	Thread.sleep(3000);
	tpaa.clickOnSupportingDocument_UploadFile();
	Thread.sleep(5000);
	assessorName = driver.findElement(By.xpath("//input[@id='nameOfAssessor']")).getAttribute("value");
	Thread.sleep(3000);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07", Integer.parseInt(srno), 20, assessorName);
	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(srno), 29, assessorName);
	Thread.sleep(5000);
	tpaa.clickOnGenerateOTP();
	Thread.sleep(3000);
	tpaa.enterMobileOTP(mobileOTP);
	tpaa.enterEmailOTP(emailOTP);
	tpaa.clickOnVerifyOTP();
	Thread.sleep(3000);
	tpaa.clickOnOK();
	
	PostLoginPage plp = new PostLoginPage(driver);
	Thread.sleep(3000);
	plp.clickOnProfileLogo();
	plp.clickOnLogout();
	
	
}

}
