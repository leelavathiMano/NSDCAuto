package com.nsdc.RegressionTest_NON_PMKVY_STT_Test;

import java.util.List;

import org.openqa.selenium.By;
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


import com.nsdc.testConfig.TestConfiguration;

public class FEEBASED_ADDSCHEME_TEST_WORKFLOW extends TestConfiguration {
	@DataProvider
	public Object[][] addScheme_FeeBased()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", 
				"FeeBasedAddSchemeSC14TC01");
	}
	
	@Test(dataProvider="addScheme_FeeBased")
	public void addSchemeTC_01(String sno, String tpUsername, String tpPassword, String schemeName, String financialModel, 
			String fundedBy, String projectDuration, String agreementOrDisbursementDate,
			String projectID, String projectName, String proposingOrganisation,
			String implementingOrganisation, String promoterDetails, String target, String assessmentMode,
			String startDate, String endDate, String loanAmount, String moratoriumPeriod, String loanduration, 
			String interestRate, String signedTermsheetFile, String signedProposalFile, String otherSupportingFile,
			String sector, String trainingTarget, String addSectorUndertakingFile, String affiliationCertificate, 
			String courseName, String sector_AddCourse, String jobRole, String jobRoleName, String nsqfLevel,
			String courseDescription, String certificateName, String minimumAge, String minimumEducation,
			String courseDuration, String numberOfHours, String courseFee, String gradingPrefrences,
			String courseApprovalFile, String affiliationFile, String workOrderFile, String challanFile,
			String stampPaper, String state, String district, String tpWithProject) throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpd = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(10000);
		tpd.clickOnMySchemes();
		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
		Thread.sleep(3000);
		tpms.clickOnAddSchemeOrProgram();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+schemeName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+schemeName+"']]]]//a[contains(text(),'Add Program')]")).click();
		TP_FeeBasedProgramPage tpfb = new TP_FeeBasedProgramPage(driver);
		Thread.sleep(3000);
		tpfb.clickOnCloseButton();
		if(tpWithProject.equals("No"))
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
			
			fundedBy = driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", srno, 5, fundedBy);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", srno, 6, fundedBy);			
			projectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", srno, 6, projectDuration);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
			
			tpfb.clickOnSelectAgreementDate();
			tpfb.clickOnSelectDisbursementDate();
			tpfb.enterProjectProposalID(projectID);
			
			agreementOrDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select First Disbursement Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", srno, 7, agreementOrDisbursementDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", srno, 8, agreementOrDisbursementDate);			
			Thread.sleep(3000);
			tpfb.enterNameOfProject(projectName);
		
			
		
			proposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", srno, 10, proposingOrganisation);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", srno, 11, proposingOrganisation);	
			Thread.sleep(5000);
			
			tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
			tpfb.enterPromoterDetails(promoterDetails);
			tpfb.enterProjectTarget(target);
			tpfb.selectAssessmentMode(assessmentMode);
			Thread.sleep(3000);
			
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 15, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 16, startDate);
			
			Thread.sleep(3000);
			tpfb.enterSanctionLoanAmount(loanAmount);
			tpfb.selectMoratoriumPeriod(moratoriumPeriod);
			tpfb.selectForLoanDuration(loanduration);
			tpfb.selectForInterestRate(interestRate);
			
		}
		
		else
		{
			projectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", srno, 6, projectDuration);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
			tpfb.clickOnSelectAgreementDate();
			tpfb.enterProjectProposalID(projectID);
			agreementOrDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select Agreement Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", srno, 7, agreementOrDisbursementDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", srno, 8, agreementOrDisbursementDate);			
			Thread.sleep(3000);
			tpfb.enterNameOfProject(projectName);
	
			
			proposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", srno, 10, proposingOrganisation);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", srno, 11, proposingOrganisation);	
			Thread.sleep(5000);
			
			tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
			tpfb.enterPromoterDetails(promoterDetails);
			tpfb.enterProjectTarget(target);
			tpfb.selectAssessmentMode(assessmentMode);
			Thread.sleep(3000);
			tpfb.clickOnStartDateOfProject();
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 15, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 16, startDate);
			tpfb.clickOnSanctionLoanAmount();

		}
		
		
		Thread.sleep(3000);
		endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 16, endDate);
		ReadWriteData.setExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 17, endDate);
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

		tpfb.clickOnAdd_AddSector();
	
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
		tpfb.clickOnStampPapaer_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(stampPaper);
		Thread.sleep(3000);
		tpfb.clickOnStampPape_UploadFile();
		Thread.sleep(4000);
		tpfb.clickOnAdd_AddCourse();
	
		Thread.sleep(3000);
		tpfb.selectState_LocationForTC(state);
		tpfb.selectDistricts_LocationForTC(district);
		Thread.sleep(3000);
		tpfb.clickOnAddForLocationOfTC();
		Thread.sleep(3000);
		
		
		String numberOfYears = ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "PlacementTarget", 1, 0);
		
		
	 	int NumberOFyears=Integer.parseInt(numberOfYears);
	 	
		for(int i=1;i<=NumberOFyears;i++)
		{
			
			String AmountSanctioned= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "PlacementTarget", i, 1);
			
			String TrainingTargets= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "PlacementTarget", i, 2);
			String PlacementTargets= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "PlacementTarget", i, 3);
			
			
			String NumberofCentre= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "PlacementTarget", i, 4);
			String NumberofSectors= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "PlacementTarget", i, 5);
			String NumberofCourse= ReadWriteData.getData("./TestData/Workflow/FeeBased_AddScheme-Workflow1.xls", "PlacementTarget", i, 6);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).sendKeys(AmountSanctioned);
			Thread.sleep(2000);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Training Targets')]/..//td//input)["+i+"]")).sendKeys(TrainingTargets);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Placement Targets')]/..//td//input)["+i+"]")).sendKeys(PlacementTargets);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Centre')]/..//td//input)["+i+"]")).sendKeys(NumberofCentre);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Sector')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Course(s)')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
		
		}
		
		////
		tpfb.clickOnSaveAndContinue();
		Thread.sleep(3000);
		tpfb.clickOnYes_AddScheme();
		Thread.sleep(3000);
		
		
		Thread.sleep(5000);
		tpms.clickOnApprovalInProgress();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//span[text()='Approval in Progress']")).getText(), "Approval in Progress");
		LogOutPage plp = new LogOutPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	///////////////////////////////////////////////////////////////////
	
	@DataProvider
	public Object[][] approveScheme()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/FeeBased_AddScheme-Workflow2.xls", "FeeBasedAddSchemeSC14TC02");
	}
	
	@Test(dataProvider="approveScheme")
	public void daApproveSchemeTC_02(String srno, String fDAUsername, String fDAPassword, String tpID, 
			String expectedFinancialModelType, String status, String expectedFundedBy, String expectedProjectDuration,
			String AggrementOrdisbursementDate,  String expectedProjectID, String expectedProjectName,
			String expectedProposingOrganisation, String expectedImplementingOrganisation,  String expectedPromoterDetails, 
			String expectedProjectTarget, String expectedAssessmentMode, String expectedStartDate, String expectedEndDate, 
			String ProjectReview,String ProjectComments,
			String expectedSanctionLoanAmount, String expectedMoratoriumPeriod, String expectedLoanDuration, 
			String expectedInterestRate,String loanReview,String loanDetailscomments, 
			String supportdocumentReview,String documentReviewcomments,
			String expectedSector, String expectedCourseName, String expectedJobRoleMappingType ,
			String expectedAssociatedQP, String expectedNSQFLevel, String expectedProposedHour, String expectedState,
			String expectedDistrict, String comments, String reviewComments) throws Exception
	{
		
		precondition();
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(fDAUsername, fDAPassword);
		FDA_DashboardPage fdp = new FDA_DashboardPage(driver);
		Thread.sleep(10000);
		fdp.clickOnViewAllOnboardingRequest();
		FDA_OnboardingRequestPage frp = new  FDA_OnboardingRequestPage(driver);
		Thread.sleep(3000);
		
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
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), expectedImplementingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), expectedPromoterDetails);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), expectedAssessmentMode);
			Thread.sleep(2000);
			fss.SelectProjectDetailReviewDropdownlist(ProjectReview);
			fss.EnterProjectDetailComment(ProjectComments);
			
			
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sanctionLoanAmount']")).getAttribute("value"), expectedSanctionLoanAmount);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='moratoriumPeriod']")).getAttribute("value"), expectedMoratoriumPeriod);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='loanDuration']")).getAttribute("value"), expectedLoanDuration);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='interestRate']")).getAttribute("value"), expectedInterestRate);
			
			
			fss.SelectloanDetailsReview(loanReview);
			Thread.sleep(1000);
			fss.EnterloanDetailsCommentDropdownlist(loanDetailscomments);
			Thread.sleep(3000);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), expectedProjectDuration);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), expectedProjectID);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), expectedProjectName);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), expectedProposingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), expectedImplementingOrganisation);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), expectedPromoterDetails);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), expectedProjectTarget);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), expectedAssessmentMode);
			
		}
		Thread.sleep(3000);
		fss.clickOnDownloadSignedTermsheet();
		Thread.sleep(3000);
		fss.clickOnDownloadSignedProposal();
		Thread.sleep(3000);
		fss.clickOnDownloadSupportingDocument();
		
		fss.SelectSupportDocumentReview(supportdocumentReview);
		fss.EnterSupportDocumentReview(documentReviewcomments);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedSector+"']")).getText(), expectedSector);
		Thread.sleep(3000);
//		
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedState+"']")).getText(), expectedState);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+expectedDistrict+"')]")).getText(), expectedDistrict);
		Thread.sleep(3000);
		
		fss.selectReviewComments(comments);
		fss.enterReviewComments(reviewComments);
		Thread.sleep(3000);
		fss.clickOnFirst_SubmitResponse();
		Thread.sleep(2000);
		fss.clickOnSecond_SubmitResponse();
		Thread.sleep(3000);
		//fss.clickOnOK();
		//frp.selectTPID(tpID);
		frp.selectType(expectedFinancialModelType);
		frp.selectStatus(reviewComments);
		Thread.sleep(2000);
		frp.clickOnApply();
		if(comments.equals("Approved"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
		}
		else if(comments.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
		}
		else if(comments.equals("Not Approved"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
		}
		Thread.sleep(5000);
		LogOutPage plp = new LogOutPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		
		
	}
}


	
	
