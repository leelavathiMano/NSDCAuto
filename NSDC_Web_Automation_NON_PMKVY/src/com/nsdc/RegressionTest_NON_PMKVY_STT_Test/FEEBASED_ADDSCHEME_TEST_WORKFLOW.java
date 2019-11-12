package com.nsdc.RegressionTest_NON_PMKVY_STT_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_NON_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_NON_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_NON_PMKVY_Pages.FDA_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.FDA_OnboardingRequestPage;
import com.nsdc.Pages_NON_PMKVY_Pages.FDA_SelectedSchemePage;
import com.nsdc.Pages_NON_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_NON_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBasedProgramPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_MySchemeDashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TrainingPartnerDashboardPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;

import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_AddTrainingCentrePage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_ViewAllTrainingCentrePage;
import com.nsdc.testConfig.TestConfiguration;

public class FEEBASED_ADDSCHEME_TEST_WORKFLOW extends TestConfiguration {
//	@DataProvider
//	public Object[][] addScheme_FeeBased()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", 
//				"FeeBasedAddSchemeSC14TC01");
//	}
//	
//	@Test(dataProvider="addScheme_FeeBased")
//	public void addSchemeTC_01(String sno, String tpUsername, String tpPassword, String schemeName, String financialModel, 
//			String fundedBy, String projectDuration, String agreementOrDisbursementDate,
//			String projectID, String projectName, String proposingOrganisation,
//			String implementingOrganisation, String promoterDetails, String target, String assessmentMode,
//			String startDate, String endDate, String loanAmount, String moratoriumPeriod, String loanduration, 
//			String interestRate, String signedTermsheetFile, String signedProposalFile, String otherSupportingFile,
//			String sector, String trainingTarget, String addSectorUndertakingFile, String affiliationCertificate, 
//			String courseName, String sector_AddCourse, String jobRole, String jobRoleName, String nsqfLevel,
//			String courseDescription, String certificateName, String minimumAge, String minimumEducation,
//			String courseDuration, String numberOfHours, String courseFee, String gradingPrefrences,
//			String courseApprovalFile, String affiliationFile, String workOrderFile, String challanFile,
//			String stampPaper, String state, String district, String tpWithProject) throws Exception
//	{
//		precondition();
//		int srno = Integer.parseInt(sno);
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpUsername, tpPassword);
//		TrainingPartnerDashboardPage tpd = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(5000);
//		tpd.clickOnMySchemes();
//		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
//		Thread.sleep(3000);
//		tpms.clickOnAddSchemeOrProgram();
//		Thread.sleep(5000);
//		
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+schemeName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//	driver.findElement(By.xpath("//tr[td[span[span[text()='"+schemeName+"']]]]//a[contains(text(),'Add Program')]")).click();
//		TP_FeeBasedProgramPage tpfb = new TP_FeeBasedProgramPage(driver);
//		Thread.sleep(3000);
//		//tpfb.clickOnCloseButton();
//		if(tpWithProject.equals("No"))
//		{
//			Thread.sleep(5000);
//			tpfb.selectFinancialModelType(financialModel);
//		}
//		else
//		{
//			Thread.sleep(1000);
//			tpfb.clickOnCloseButton();
//			Thread.sleep(5000);
//			tpfb.selectFinancialModelType(financialModel);
//		}
//		
//		
//		
//		if(financialModel.equals("Funded"))
//		{
//			Thread.sleep(3000);
//			
//			fundedBy = driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", srno, 5, fundedBy);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", srno, 6, fundedBy);			
//			projectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", srno, 6, projectDuration);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
//			
//			tpfb.clickOnSelectAgreementDate();
//			tpfb.clickOnSelectDisbursementDate();
//			tpfb.enterProjectProposalID(projectID);
//			
//			agreementOrDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select First Disbursement Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", srno, 7, agreementOrDisbursementDate);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", srno, 8, agreementOrDisbursementDate);			
//			Thread.sleep(3000);
//			tpfb.enterNameOfProject(projectName);
//		
//			
//		
//			proposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", srno, 10, proposingOrganisation);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", srno, 11, proposingOrganisation);	
//			Thread.sleep(3000);
//			
//			tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
//			tpfb.enterPromoterDetails(promoterDetails);
//			tpfb.enterProjectTarget(target);
//			tpfb.selectAssessmentMode(assessmentMode);
//			Thread.sleep(2000);
//			
//			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 15, startDate);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 16, startDate);
//			
//			Thread.sleep(3000);
//			tpfb.enterSanctionLoanAmount(loanAmount);
//			tpfb.selectMoratoriumPeriod(moratoriumPeriod);
//			tpfb.selectForLoanDuration(loanduration);
//			tpfb.selectForInterestRate(interestRate);
//			
//		}
//		
//		else
//		{
//			projectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", srno, 6, projectDuration);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
//			tpfb.clickOnSelectAgreementDate();
//			tpfb.enterProjectProposalID(projectID);
//			agreementOrDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select Agreement Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", srno, 7, agreementOrDisbursementDate);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", srno, 8, agreementOrDisbursementDate);			
//			Thread.sleep(3000);
//			tpfb.enterNameOfProject(projectName);
//	
//			
//			proposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", srno, 10, proposingOrganisation);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", srno, 11, proposingOrganisation);	
//			Thread.sleep(2000);
//			
//			tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
//			tpfb.enterPromoterDetails(promoterDetails);
//			tpfb.enterProjectTarget(target);
//			tpfb.selectAssessmentMode(assessmentMode);
//			Thread.sleep(1000);
//			tpfb.clickOnStartDateOfProject();
//			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 15, startDate);
//			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 16, startDate);
//			tpfb.clickOnSanctionLoanAmount();
//
//		}
//		
//		
//		Thread.sleep(3000);
//		endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
//		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 16, endDate);
//		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 17, endDate);
//		Thread.sleep(3000);
//		tpfb.clickOnSignedTermsheetBrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(signedTermsheetFile);
//		Thread.sleep(3000);
//		tpfb.clickOnSignedTermsheetUploadFile();
//		Thread.sleep(3000);
//		tpfb.clickOnSignedProposalBrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(signedProposalFile);
//		Thread.sleep(3000);
//		tpfb.clickOnSignedProposalUploadFile();
//		Thread.sleep(3000);
//		tpfb.clickOnSupportingDocumentBrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(otherSupportingFile);
//		Thread.sleep(3000);
//		tpfb.clickOnSupportingDocumentUploadFile();
//		Thread.sleep(3000);
//		tpfb.clickOnAddSector();
//		Thread.sleep(2000);
//		tpfb.selectSector(sector);
//		Thread.sleep(1000);
//		
//		tpfb.enterProposedTrainingTarget(trainingTarget);
//		Thread.sleep(2000);
//
//		tpfb.clickOnAdd_AddSector();
//	
//		Thread.sleep(3000);
//		
//		
//		tpfb.clickOnAddCourse();
//		Thread.sleep(3000);
//		
//		
//		tpfb.selectSector_AddCourse(sector_AddCourse);
//		tpfb.selectJobRoleMappingType(jobRole);
//		if(jobRole.equals("QP-NOS"))
//		{
//			Thread.sleep(3000);
//			tpfb.selectAssociatedQP_JobRoleNameI(jobRoleName);
//			tpfb.enterCourseName(courseName);
//			tpfb.enterNameOfIssuedCertificate(certificateName);
//		}
//		else 
//		{
//			Thread.sleep(4000);
//			tpfb.enterCourseName(courseName);
//			tpfb.enterCourseDescription(courseDescription);
//			tpfb.enterNameOfIssuedCertificate(certificateName);
//			tpfb.selectMinimumAge(minimumAge);
//		}
//		
//		tpfb.selectMinimumEducationRequired(minimumEducation);
//		tpfb.enterCourseDuration(courseDuration);
//		Thread.sleep(2000);
//		tpfb.enterNumberOfHoursPerDay(numberOfHours);
//		tpfb.enterCourseFee(courseFee);
//		tpfb.selectGradingPrefrences(gradingPrefrences);
//		Thread.sleep(3000);
//		tpfb.clickOnStampPapaer_BrowseFile();
//		Thread.sleep(2000);
//		UploadFile.upload(stampPaper);
//		Thread.sleep(3000);
//		tpfb.clickOnStampPape_UploadFile();
//		Thread.sleep(4000);
//		tpfb.clickOnAdd_AddCourse();
//	
//		Thread.sleep(2000);
//		tpfb.selectState_LocationForTC(state);
//		tpfb.selectDistricts_LocationForTC(district);
//		Thread.sleep(2000);
//		tpfb.clickOnAddForLocationOfTC();
//		Thread.sleep(3000);
//		
//		
//		String numberOfYears = ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "PlacementTarget", 1, 0);
//		
//		
//	 	int NumberOFyears=Integer.parseInt(numberOfYears);
//	 	
//		for(int i=1;i<=NumberOFyears;i++)
//		{
//			
//			String AmountSanctioned= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "PlacementTarget", i, 1);
//			
//			String TrainingTargets= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "PlacementTarget", i, 2);
//			String PlacementTargets= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "PlacementTarget", i, 3);
//			
//			
//			String NumberofCentre= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "PlacementTarget", i, 4);
//			String NumberofSectors= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "PlacementTarget", i, 5);
//			String NumberofCourse= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "PlacementTarget", i, 6);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).clear();
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).sendKeys(AmountSanctioned);
//			
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Training Targets')]/..//td//input)["+i+"]")).sendKeys(TrainingTargets);
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Placement Targets')]/..//td//input)["+i+"]")).sendKeys(PlacementTargets);
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Centre')]/..//td//input)["+i+"]")).sendKeys(NumberofCentre);
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Sector')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Course(s)')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
//		
//		}
//		
//		////
//		tpfb.clickOnSaveAndContinue();
//		Thread.sleep(3000);
//		tpfb.clickOnYes_AddScheme();
//		Thread.sleep(3000);
//		
//		
//		Thread.sleep(5000);
//		tpms.clickOnApprovalInProgress();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//span[text()='Approval in Progress']")).getText(), "Approval in Progress");
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//	}
//	
	///////////////////////////////////////////////////////////////////, dependsOnMethods="addSchemeTC_01"
	
//	@DataProvider
//	public Object[][] approveScheme()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02");
//	}
//	
//	@Test(dataProvider="approveScheme")
//	public void daApproveSchemeTC_02(String srno, String fDAUsername, String fDAPassword, String tpID, 
//			String expectedFinancialModelType, String status, String expectedFundedBy, String expectedProjectDuration,
//			String AggrementOrdisbursementDate,  String expectedProjectID, String expectedProjectName,
//			String expectedProposingOrganisation, String expectedImplementingOrganisation,  String expectedPromoterDetails, 
//			String expectedProjectTarget, String expectedAssessmentMode, String expectedStartDate, String expectedEndDate, 
//			String ProjectReview,String ProjectComments,
//			String expectedSanctionLoanAmount, String expectedMoratoriumPeriod, String expectedLoanDuration, 
//			String expectedInterestRate,String loanReview,String loanDetailscomments, 
//			String supportdocumentReview,String documentReviewcomments,
//			String expectedSector, String expectedCourseName, String expectedJobRoleMappingType ,
//			String expectedAssociatedQP, String expectedNSQFLevel, String expectedProposedHour, String expectedState,
//			String expectedDistrict, String comments, String reviewComments) throws Exception
//	{
//		
//		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(fDAUsername, fDAPassword);
//		FDA_DashboardPage fdp = new FDA_DashboardPage(driver);
//		Thread.sleep(5000);
//		fdp.clickOnViewAllOnboardingRequest();
//		FDA_OnboardingRequestPage frp = new  FDA_OnboardingRequestPage(driver);
//		Thread.sleep(3000);
//		
//		frp.selectType(expectedFinancialModelType);
//		frp.selectStatus(status);
//		Thread.sleep(2000);
//		frp.clickOnApply();
//		Thread.sleep(4000);
//		
//		
//		List <WebElement> button = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
//		int size = button.size();
//		WebElement ele = button.get(size-1);
//		ele.click();
//		List <WebElement> ta = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
//		int size1 = ta.size();
//		WebElement tab = ta.get(size1-1);
//		tab.click();
//		FDA_SelectedSchemePage fss = new FDA_SelectedSchemePage(driver);
//		Thread.sleep(3000);
//
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), expectedFinancialModelType);
//		if(expectedFinancialModelType.equals("Funded"))
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value"), expectedFundedBy);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), expectedProjectDuration);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), expectedProjectID);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), expectedProjectName);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
//			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), expectedImplementingOrganisation);
//			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), expectedPromoterDetails);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), expectedAssessmentMode);
//			Thread.sleep(2000);
//			fss.SelectProjectDetailReviewDropdownlist(ProjectReview);
//			fss.EnterProjectDetailComment(ProjectComments);
//			
//			
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sanctionLoanAmount']")).getAttribute("value"), expectedSanctionLoanAmount);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='moratoriumPeriod']")).getAttribute("value"), expectedMoratoriumPeriod);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='loanDuration']")).getAttribute("value"), expectedLoanDuration);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='interestRate']")).getAttribute("value"), expectedInterestRate);
//			
//			
//			fss.SelectloanDetailsReview(loanReview);
//			Thread.sleep(1000);
//			fss.EnterloanDetailsCommentDropdownlist(loanDetailscomments);
//			Thread.sleep(3000);
//		}
//		else
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), expectedProjectDuration);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), expectedProjectID);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), expectedProjectName);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
//			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), expectedImplementingOrganisation);
//			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), expectedPromoterDetails);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), expectedAssessmentMode);
//			
//		}
//		Thread.sleep(3000);
//		fss.clickOnDownloadSignedTermsheet();
//		Thread.sleep(3000);
//		fss.clickOnDownloadSignedProposal();
//		Thread.sleep(3000);
//		fss.clickOnDownloadSupportingDocument();
//		
//		fss.SelectSupportDocumentReview(supportdocumentReview);
//		fss.EnterSupportDocumentReview(documentReviewcomments);
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedSector+"']")).getText(), expectedSector);
//		Thread.sleep(3000);
////		
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedState+"']")).getText(), expectedState);
//		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+expectedDistrict+"')]")).getText(), expectedDistrict);
//		Thread.sleep(3000);
//		
//		//s  fss.selectReviewComments(comments);//not verified this field is  only disable
//		fss.enterReviewComments(reviewComments);
//		Thread.sleep(3000);
//		fss.clickOnFirst_SubmitResponse();
//		Thread.sleep(2000);
//		fss.clickOnSecond_SubmitResponse();
//		//////////////////
//		//fss.clickOnOK();
//				//frp.selectTPID(tpID);
//		        Thread.sleep(2000);
//				frp.selectType(expectedFinancialModelType);
//				frp.selectStatus(reviewComments);
//				Thread.sleep(2000);
//				frp.clickOnApply();
//				if(comments.equals("Approved"))
//				{
//					Thread.sleep(3000);
//					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
//				}
//				else if(comments.equals("Not Recommended"))
//				{
//					Thread.sleep(3000);
//					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
//				}
//				else if(comments.equals("Not Approved"))
//				{
//					Thread.sleep(3000);
//					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
//				}
//		Thread.sleep(5000);
//		LogOutPage plp = new LogOutPage(driver);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//		
//		
//		
//	}
//

//////////////////, dependsOnMethods="daApproveSchemeTC_02"

	@DataProvider
	public Object[][] resubmitAndReviewScheme()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", 
				"FeeBasedAddSchemeSC14TC03");
	}

	@Test(dataProvider="resubmitAndReviewScheme")
	public void resubmitAndReviewSchemeTC_03(String sno, String tpUsername, String tpPassword, String daComments,
			String oldProjectName, String daReviewComments, String newFinancialModel, String newFundedBy, 
			String newProjectDuration, String newAgreementDate, String newDisbursementDate, String newProjectID,
			String newProjectName, String newProposingOrganisation, String newImplementingOrganisation, String newPromoterDetails, 
			String newTarget, String newAssessmentMode, String newStartDate, String newEndDate, String newLoanAmount,
			String newMoratoriumPeriod, String newLoanDuration, String newInterestRate, String newSignedTermsheetFile,
			String newSignedProposalFile, String newOtherSupportingFile, String newSector, String newTrainingTarget, 
			String newAddSectorUndertakingFile, String newAffiliationCertificate, String newCourseName, String newJobRole, 
			String NewAssociatedQP,
		 String newNsqfLevel, String newCourseDescription, String newCertificateName, String newMinimumAge,
			String newMinimumEducation, String newCourseDuration, String newNumberOfHours, String newCourseFee, String newGradingPrefrences,
			String newCourseApprovalFile, String newAffiliationFile, String newWorkOrderFile, String newChallanFile, String newStampPaper,
			String newState, String newDistrict, String fDAUsername, String fDAPassword, String newComments, String newReviewComments) throws Exception
	{
		
		precondition();
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(10000);
		tpdp.clickOnMySchemes();
		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
		Thread.sleep(3000);
		if(daComments.equalsIgnoreCase("Approved"))
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
		
		else if(daComments.equalsIgnoreCase("Not Approved"))
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
			TP_FeeBasedProgramPage  tpfb = new TP_FeeBasedProgramPage (driver);
//			Thread.sleep(3000);
//			tpfb.clickOnCloseButton();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='review']")).getAttribute("value"), daComments);//
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='comment']")).getAttribute("value"), daReviewComments);
			Thread.sleep(3000);
			tpfb.selectFinancialModelType(newFinancialModel);
			if(newFinancialModel.equals("Funded"))
			{
				Thread.sleep(5000);
				//tpfb.enterProjectFundedBy(fundedBy);
				newFundedBy = driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 7, newFundedBy);
				newProjectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 8, newProjectDuration);				
				Thread.sleep(3000);
				tpfb.clickOnSelectAgreementDate();
				Thread.sleep(3000);
				newAgreementDate=driver.findElement(By.xpath("//input[@placeholder='Select Agreement Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 9, newAgreementDate);
				tpfb.clickOnSelectDisbursementDate();
				newDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select First Disbursement Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 10, newDisbursementDate);
				Thread.sleep(3000);
				tpfb.enterProjectProposalID(newProjectID);
				tpfb.enterNameOfProject(newProjectName);
			
				newProposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 13, newProposingOrganisation);
				Thread.sleep(5000);
				tpfb.enterNameOfImplementingOrganisation(newImplementingOrganisation);
				tpfb.enterPromoterDetails(newPromoterDetails);
				tpfb.enterProjectTarget(newTarget);
				tpfb.selectAssessmentMode(newAssessmentMode);
				Thread.sleep(3000);
				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 18, newStartDate);
				//tpfb.clickOnEndDateOfProject();

				
				Thread.sleep(3000);
				tpfb.enterSanctionLoanAmount(newLoanAmount);
				tpfb.selectMoratoriumPeriod(newMoratoriumPeriod);
				tpfb.selectForLoanDuration(newLoanDuration);
				tpfb.selectForInterestRate(newInterestRate);
				
			}
			
			else
			{
				newProjectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 8, newProjectDuration);				
				tpfb.clickOnSelectAgreementDate();
				newAgreementDate= driver.findElement(By.xpath("//input[@placeholder='Select Agreement Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 9, newAgreementDate);
				Thread.sleep(3000);
				tpfb.enterProjectProposalID(newProjectID);
				tpfb.enterNameOfProject(newProjectName);
		
				//tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
				newProposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 13, newProposingOrganisation);
				Thread.sleep(5000);
				//tpfb.enterNameOfProposingOrganisation(proposingOrganisation);
				tpfb.enterNameOfImplementingOrganisation(newImplementingOrganisation);
				tpfb.enterPromoterDetails(newPromoterDetails);
				tpfb.enterProjectTarget(newTarget);
				tpfb.selectAssessmentMode(newAssessmentMode);
				Thread.sleep(3000);
				tpfb.clickOnStartDateOfProject();
				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
				ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 18, newStartDate);
				tpfb.clickOnSanctionLoanAmount();

			}
			
			
			Thread.sleep(3000);
			newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow3.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 19, newEndDate);
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
			Thread.sleep(2000);
			tpfb.clickOnAdd_AddSector();
			String addedSector = driver.findElement(By.xpath("//td[text()='"+newSector+"']")).getText();
//			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow3.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(sno), 4, addedSector);
			Thread.sleep(5000);
			tpfb.clickOnAddCourse();
			Thread.sleep(8000);
			
			
			tpfb.selectSector_AddCourse(newSector);
			tpfb.selectJobRoleMappingType(newJobRole);
			if(newJobRole.equals("QP-NOS"))
			{
				Thread.sleep(3000);
				tpfb.selectAssociatedQP_JobRoleNameI(NewAssociatedQP);
				tpfb.enterCourseName(newCourseName);
			tpfb.enterNameOfIssuedCertificate(newCertificateName);
				
				
				
			
			}
			else 
			{
				Thread.sleep(4000);
				tpfb.enterCourseName(newCourseName);
				tpfb.enterCourseDescription(newCourseDescription);
				tpfb.enterNameOfIssuedCertificate(newCertificateName);
				tpfb.selectMinimumAge(newMinimumAge);
			}
			
			tpfb.selectMinimumEducationRequired(newMinimumEducation);
			tpfb.enterCourseDuration(newCourseDuration);
			Thread.sleep(2000);
			tpfb.enterNumberOfHoursPerDay(newNumberOfHours);
			tpfb.enterCourseFee(newCourseFee);
			tpfb.selectGradingPrefrences(newGradingPrefrences);
			Thread.sleep(3000);
//			
			
			
		
			tpfb.clickOnStampPapaer_BrowseFile();
			Thread.sleep(5000);
			UploadFile.upload(newStampPaper);
			Thread.sleep(3000);
			tpfb.clickOnStampPape_UploadFile();
			Thread.sleep(4000);
			tpfb.clickOnAdd_AddCourse();
			Thread.sleep(3000);
	//
			String addedCourse = driver.findElement(By.xpath("//p[text()='"+newCourseName+"']")).getText();
			//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow3.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(sno), 8, addedCourse);
			Thread.sleep(3000);
			tpfb.selectState_LocationForTC(newState);
			tpfb.selectDistricts_LocationForTC(newDistrict);
			Thread.sleep(3000);
			tpfb.clickOnAddForLocationOfTC();
			Thread.sleep(3000);
			tpfb.clickOnResubmitForReviewAgain();
			
			Thread.sleep(5000);
			tpms.clickOnApprovalInProgress();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newProjectName+"']]]]//span[text()='Resubmitted']")).getText(), "Resubmitted");
			LogOutPage plp = new LogOutPage(driver);
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
				
				lp.clickLogin();
				Thread.sleep(3000);
				//BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
				bsp.clickToClose();
				Thread.sleep(3000);
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
					Assert.assertEquals(driver.findElement(By.xpath("(//input[@ng-reflect-name='firstDisbursementDate'])[2]")).getAttribute("value"), newDisbursementDate);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), newProjectID);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), newProjectName);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), newProposingOrganisation);
					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), newImplementingOrganisation);
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
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), newProjectDuration);
					Assert.assertEquals(driver.findElement(By.xpath("(//input[@ng-reflect-name='agreementDate'])[2]")).getAttribute("value"), newAgreementDate);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), newProjectID);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), newProjectName);
					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), newProposingOrganisation);
					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), newImplementingOrganisation);
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
				Assert.assertEquals(driver.findElement(By.xpath("//p[text()='"+newCourseName+"']")).getText(), newCourseName);
				Thread.sleep(3000);
				fss.clickOnCourses_ViewAttachedDocument();
				if(newJobRole.equals("QP-NOS")) 
				{
					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+NewAssociatedQP+"']")).getText(), NewAssociatedQP);
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
				if(newComments.equals("Approved"))
				{
					Thread.sleep(3000);
					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
				}
				else if(newComments.equals("Not Recommended"))
				{
					Thread.sleep(3000);
					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
				}
				else if(newComments.equals("Not Approved"))
				{
					Thread.sleep(3000);
					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
				}
				
		}
				Thread.sleep(5000);
				LogOutPage plp = new LogOutPage(driver);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
		}		
			

				

@DataProvider
public Object[][] addTrainingCentre()
{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01");
}

@Test(dataProvider="addTrainingCentre")
public void addTrainingCentreTC04(String sno, String tpUsername, String tpPassword, String projectName, String trainingCentreType, String trainingCentreName, String ownership, String franchiseDocument, String startDate, String endDate, String bathesNumber, String studentNumber, String annualCapacity, String capacityUtilization, String governmentTieUp, String centreCapacity, String centreArea, String trainingRooms, String labNumber, String receptionArea, String waitingArea, String maleWashRooms, String femaleWashRooms, String unisexWashRooms, String airportDistance, String trainStationDistance, String cityCentreDistance, String tcAddress, String landmark, String pincode, String state, String district, String tehsil, String city, String parliamentryConstituency, String geoLocation, String addressProof, String addressProofFile, String facility_Photos, String spocName, String spocEmail, String spocMobile, String spocDesignation, String spocLandLine, String srNo_TCRoom, String tcRoomPhotos, String laboratory_SrNo, String laboratoryPhotos, String maleWashRoom_SrNo, String maleWashRoomPhotos, String femaleWashRoom_SrNo, String femaleWashRoomPhotos, String unisexWashRoom_SrNo, String unisexWashRoomPhotos, String sector, String course, String target) throws Exception
{
	LaunchPage lp = new LaunchPage(driver);
	lp.clickLogin();
	Thread.sleep(3000);
	BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	bsp.clickToClose();
	Thread.sleep(3000);
	EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(tpUsername, tpPassword);
	TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
	Thread.sleep(15000);
	tpdp.clickOnMySchemes();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
	TP_FeeBasedProgramPage fbd = new TP_FeeBasedProgramPage(driver);
	Thread.sleep(5000);
	//fbd.clickOnViewTrainingCentres();
	TP_FeeBased_ViewAllTrainingCentrePage fbtc = new TP_FeeBased_ViewAllTrainingCentrePage(driver);
	Thread.sleep(2000);
	fbtc.clickOnAddTrainingCentre();
	Thread.sleep(3000);
	fbtc.selectTrainingCentreType(trainingCentreType);
	fbtc.clickOnSaveAndContinue();
	TP_FeeBased_AddTrainingCentrePage fbad = new TP_FeeBased_AddTrainingCentrePage(driver);
	Thread.sleep(3000);
	fbad.enterTrainingCentreName(trainingCentreName);
	Thread.sleep(3000);
	fbad.clcikOnRuralLocation();
	Thread.sleep(3000);
	fbad.selectForCentreOwnerShip(ownership);
	if(ownership.equals("Franchise"))
	{
		Thread.sleep(5000);
		fbad.clickOnFranchiseDocuments_BrowseFile();
		Thread.sleep(5000);
		UploadFile.upload(franchiseDocument);
		Thread.sleep(5000);
		fbad.clickOnFranchiseDocuments_UploadFile();
		Thread.sleep(3000);
//		fbad.clickOnStartDateForTCDuration();
//		startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
//		fbad.clickOnEndDateForTCDuration();
//		endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
	}
	else
	{
//		fbad.clickOnStartDateForTCDuration();
//		startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
//		fbad.clickOnEndDateForTCDuration();
//		endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
	}
	
//	fbad.enterNumberOfBatchesPerDay(bathesNumber);
//	fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
//	fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
//	fbad.enterCapacityUtilization(capacityUtilization);
//	fbad.selectForGovernmentTieUp(governmentTieUp);
	Thread.sleep(3000);
	fbad.entreCentreArea(centreArea);
	fbad.enterCentreCapacity(centreCapacity);
	fbad.selectNumberOfTrainingRooms(trainingRooms);
	fbad.selectNumbersOfLabs(labNumber);
//	fbad.enterReceptionAreaSize(receptionArea);
//	fbad.enterWaitingAreaCapacity(waitingArea);
	fbad.selectNumberOfMaleWashRooms(maleWashRooms);
	fbad.selectNumberOfFemaleWashRooms(femaleWashRooms);
	fbad.selectNumberOfUnisexWashRooms(unisexWashRooms);
	fbad.enterDistanceFromNearestAirport(airportDistance);
	fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
	fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
	Thread.sleep(3000);
	fbad.enterAddressOFTC(tcAddress);
	Thread.sleep(3000);
	fbad.enterNearByLandmark(landmark);
	Thread.sleep(5000);
	fbad.enterPincode(pincode);
	Thread.sleep(3000);
	fbad.selectState(state);
	Thread.sleep(2000);
	fbad.selrctDistrict(district);
	Thread.sleep(2000);
	fbad.selectTehsil(tehsil);
	Thread.sleep(3000);
	fbad.selectCityOrVillage(city);
	Thread.sleep(2000);
	fbad.selectParliamentryConstituency(parliamentryConstituency);
	fbad.enterGeoLocation(geoLocation);
	Thread.sleep(3000);
	fbad.selectAddressProofType(addressProof);
	Thread.sleep(3000);
	fbad.clickOnAddressProof_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(addressProofFile);
	Thread.sleep(3000);
	fbad.clickOnAddressProof_UploadFile();
	if(trainingCentreType.equals("Fixed"))
	{
		List<WebElement> ele = driver.findElements(By.xpath("//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//label[@class='m-checkbox']"));
		for(int i=0;i<ele.size();i++)
		{
			Thread.sleep(3000);
			WebElement chkbox = ele.get(i);
			if((i==9) || (i==10) || (i==15) || (i==16) || (i==17))
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@id='customFile'])["+(i+1)+"]")).click();
				Thread.sleep(5000);
				UploadFile.upload(facility_Photos);
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+(i+1)+"]")).click();
			}
			else
			{
				Thread.sleep(5000);
				chkbox.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@id='customFile'])["+(i+1)+"]")).click();
				Thread.sleep(5000);
				UploadFile.upload(facility_Photos);
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+(i+1)+"]")).click();
				
			}
		}

	}
	else
	{
		List<WebElement> ele = driver.findElements(By.xpath("//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//label[@class='m-checkbox']"));
		for(int i=0;i<ele.size();i++)
		{
				Thread.sleep(3000);
				WebElement chkbox = ele.get(i);
				Thread.sleep(5000);
				chkbox.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@id='customFile'])["+(i+1)+"]")).click();
				Thread.sleep(5000);
				UploadFile.upload(facility_Photos);
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+(i+1)+"]")).click();
				
		}

	}
	
	
	
	Thread.sleep(5000);
	fbad.enterNameOfSPOC(spocName);
	fbad.enterEmailAddressOfSPOC(spocEmail);
	fbad.enterMobileNumberOfSPOC(spocMobile);
	fbad.enterDesignationOfSPOC(spocDesignation);
	fbad.enterLandLineNumberOfSPOC(spocLandLine);
	Thread.sleep(3000);
	fbad.select_SrNo_TrainingRoomPhotos(srNo_TCRoom);
	fbad.clickOnTrainingRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(tcRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnTrainingRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.select_SrNo_Laboratory(laboratory_SrNo);
	fbad.clickOnLaboratoryPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(laboratoryPhotos);
	Thread.sleep(3000);
	fbad.clickOnLaboratoryPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.select_SrNo_ForMaleWashRoom(maleWashRoom_SrNo);
	fbad.clickOnMaleWashRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(maleWashRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnMaleWashRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.select_SrNo_ForFemaleWashRoom(femaleWashRoom_SrNo);
	fbad.clickOnFemaleWashRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(femaleWashRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnFemaleWashRoomPhotos_UploadFile();
	Thread.sleep(3000);
	fbad.select_SrNo_ForUnisexWashRoom(unisexWashRoom_SrNo);
	fbad.clickOnUnisexWashRoomPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(unisexWashRoomPhotos);
	Thread.sleep(3000);
	fbad.clickOnUnisexWashRoomPhotos_UploadFile();
	/*fbad.clickOnCafetariaPhotos_BrowseFile();
	Thread.sleep(3000);
	UploadFile.upload(cafetariaPhotos);
	Thread.sleep(3000);
	fbad.clickOnCafetariaPhotos_UploadFile();
	Thread.sleep(10000);*/
	Thread.sleep(3000);
	fbad.clickOnAddSectorTarget();
	Thread.sleep(3000);
	fbad.selectSector(sector);
	Thread.sleep(3000);
	fbad.selectCourse(course);
	fbad.enterTarget(target);
	Thread.sleep(3000);
	fbad.clickOnSubmit_SectorTarget();
	Thread.sleep(15000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("scroll(0, 900)");
	fbad.clickOnSubmit();
	Thread.sleep(3000);
	fbad.clickOnYesAddTrainingCentre();
	Thread.sleep(3000);
	//fbad.clickOnOK();
	Thread.sleep(8000);
	fbd.clickOnViewTrainingCentres();
	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+trainingCentreName+"']]]]//span[text()='Awating Approval']")).getText(), "Awating Approval");
	LogOutPage plp = new LogOutPage(driver);
	Thread.sleep(5000);
	plp.clickOnProfileLogo();
	Thread.sleep(2000);
	plp.clickOnLogout();

}
}

	
	
