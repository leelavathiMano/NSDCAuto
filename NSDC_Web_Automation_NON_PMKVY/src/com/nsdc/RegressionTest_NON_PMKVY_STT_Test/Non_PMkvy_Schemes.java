package com.nsdc.RegressionTest_NON_PMKVY_STT_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_NON_PMKVY_Pages.AssessmentAgencyDashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.AssessmentAgencyViewBatchesPage;
import com.nsdc.Pages_NON_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_AddCourseRequestsPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_AddSectorRequestPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_CourseInfoPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_SectorInfoPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_TCRequestPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_TrainingCentreInfoPage;
import com.nsdc.Pages_NON_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_NON_PMKVY_Pages.FDA_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.FDA_OnboardingRequestPage;
import com.nsdc.Pages_NON_PMKVY_Pages.FDA_SelectedSchemePage;
import com.nsdc.Pages_NON_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_NON_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_NON_PMKVY_Pages.SSC_AssessmentsAndCertification_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.SSC_AssessmentsAndCertifications_ViewAllBatchesPage;
import com.nsdc.Pages_NON_PMKVY_Pages.SSC_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBasedProgramPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_AddCourseToSectorsPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_AddTrainingCentrePage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_AssessmentAgencyAndAssessorPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_AssessmentAgencyInfoPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_BatchDetailsPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_CreateBatchAddSectorTargetPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_EnrollCandidatesPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_ViewAllSectorAndCoursesPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_ViewAllTrainersPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_ViewAllTrainingCentrePage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_MySchemeDashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TrainingPartnerDashboardPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.UploadFile;
import com.nsdc.testConfig.TestConfiguration;

public class Non_PMkvy_Schemes extends TestConfiguration 
{  
	
//	@DataProvider    
//	public Object[][] addScheme_FeeBased()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Non_pmkyy.xls", 
//				"FeeBasedAddSchemeSC14TC01");
//	}
//	
//	@Test(dataProvider="addScheme_FeeBased")
//	public void addSchemeTC_01(String sno, String tpUsername, String tpPassword, String NameofschemeName,
//			String Subscheme,String SelectedScheme, String financialModel, 
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
//			String stampPaper, String state, String district,
//		    String tpWithProject) throws Exception
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
//		// tpms.selectscheme( NameofschemeName,Subscheme);
//		
//		////////////////////////////////////////////////////////////////////
//		WebElement MySchemesListTable = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']"));
//		
//		List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));
//
//		int rows_count = rowstable.size();
//
//		for (int row = 1; row < rows_count; row++) {
//
//	 String nameofTheScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[2]")).getText();
//
//				String SUBScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr//td[span[span[text()='"+Subscheme+"']]]")).getText();
//				
//				if (nameofTheScheme.equals(NameofschemeName)&& SUBScheme.equals(Subscheme))
//				{
//					
//					
//					driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//				    driver.findElement(By.xpath("//tr[td[span[span[text()='"+Subscheme+"']]]]//a[contains(text(),'Add Program')]")).click();
//				    Thread.sleep(3000);
//				break;
//				}
//				
//			}
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='"+SelectedScheme+"']")).getText(), SelectedScheme);	
//		
////////////////////////////////////////////////////////////////////////////////////////////////
//	    
//		TP_FeeBasedProgramPage tpfb = new TP_FeeBasedProgramPage(driver);
//		Thread.sleep(3000);
//		tpfb.clickOnCloseButton();
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
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", srno, 7, fundedBy);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", srno, 6, fundedBy);			
//			projectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", srno, 8, projectDuration);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
//			
//			
//			////////
//			tpfb.clickOnAgreementDate();
//			//tpfb.SelectAgreementDate(agreementOrDisbursementDate);
//			tpfb.clickOnDisbursementDate();
//			//tpfb.SelectDisbursementDate(agreementOrDisbursementDate);
//			
//			
//			tpfb.enterProjectProposalID(projectID);
//			
//			agreementOrDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select First Disbursement Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", srno, 9, agreementOrDisbursementDate);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", srno, 8, agreementOrDisbursementDate);			
//			Thread.sleep(3000);
//			tpfb.enterNameOfProject(projectName);
//		
//			
//		
//			proposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", srno, 12, proposingOrganisation);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", srno, 11, proposingOrganisation);	
//			Thread.sleep(3000);
//			
//			tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
//			tpfb.enterPromoterDetails(promoterDetails);
//			tpfb.enterProjectTarget(target);
//			tpfb.selectAssessmentMode(assessmentMode);
//			Thread.sleep(2000);
//			
//			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 17, startDate);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 16, startDate);
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
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", srno, 7, projectDuration);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", srno, 7, projectDuration);
//			tpfb.clickOnAgreementDate();
//			
//			
//			
//			tpfb.enterProjectProposalID(projectID);
//			agreementOrDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select Agreement Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", srno, 8, agreementOrDisbursementDate);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", srno, 9, agreementOrDisbursementDate);			
//			Thread.sleep(3000);
//			tpfb.enterNameOfProject(projectName);
//	
//			
//			proposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", srno, 12, proposingOrganisation);
//			ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", srno, 11, proposingOrganisation);	
//			Thread.sleep(2000);
//			
//			tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
//			tpfb.enterPromoterDetails(promoterDetails);
//			tpfb.enterProjectTarget(target);
//			tpfb.selectAssessmentMode(assessmentMode);
//			Thread.sleep(1000);
//
//
//		}
//		
//		
//		Thread.sleep(3000);
//		endDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
//		ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC01", Integer.parseInt(sno), 18, endDate);
//		ReadWriteData.setExcelData("./TestData/Workflow/Non_pmkyy.xls", "FeeBasedAddSchemeSC14TC02", Integer.parseInt(sno), 17, endDate);
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
//		Thread.sleep(5000);
//		tpfb.clickOnStampPapaer_BrowseFile();
//		Thread.sleep(7000);
//		UploadFile.upload(stampPaper);
//		Thread.sleep(7000);
//		tpfb.clickOnStampPape_UploadFile();
//		Thread.sleep(7000);
//		tpfb.clickOnAdd_AddCourse();
//	
//		Thread.sleep(7000);
//		tpfb.selectState_LocationForTC(state);
//		Thread.sleep(3000);
//		tpfb.selectDistricts_LocationForTC(district);
//		Thread.sleep(7000);
//		tpfb.clickOnAddForLocationOfTC();
//		Thread.sleep(3000);
//		
//		
//		
//		if(financialModel.equals("Funded"))
//		{
//		String numberOfYears = ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", 1, 0);
//		
//		
//	 	int NumberOFyears=Integer.parseInt(numberOfYears);
//	 	
//		for(int i=1;i<=NumberOFyears;i++)
//		{
//			
//			String AmountSanctioned= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 1);
//			
//			String TrainingTargets= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 2);
//			String PlacementTargets= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 3);
//			
//			
//			String NumberofCentre= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 4);
//			String NumberofSectors= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 5);
//			String NumberofCourse= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 6);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).clear();
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).sendKeys(AmountSanctioned);
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Training Targets')]/..//td//input)["+i+"]")).clear();
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Training Targets')]/..//td//input)["+i+"]")).sendKeys(TrainingTargets);
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Placement Targets')]/..//td//input)["+i+"]")).clear();
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Placement Targets')]/..//td//input)["+i+"]")).sendKeys(PlacementTargets);
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Centre')]/..//td//input)["+i+"]")).clear();
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Centre')]/..//td//input)["+i+"]")).sendKeys(NumberofCentre);
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Sector')]/..//td//input)["+i+"]")).clear();
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Sector')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
//			
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Course(s)')]/..//td//input)["+i+"]")).clear();  
//			driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Course(s)')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
//		
//		}
//		}
//////		
//		else {
//			
//			String numberOfYears = ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", 1, 0);
//			
//			
//		 	int NumberOFyears=Integer.parseInt(numberOfYears);
//		 	
//			for(int i=1;i<=NumberOFyears;i++)
//			{
//				
//				//String AmountSanctioned= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 1);
//				
//				String TrainingTargets= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 2);
//				String PlacementTargets= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 3);
//				
//				
//				String NumberofCentre= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 4);
//				String NumberofSectors= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 5);
//				String NumberofCourse= ReadWriteData.getData("./TestData/Workflow/Non_pmkyy.xls", "PlacementTarget", i, 6);
//				Thread.sleep(1000);
//				//driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).clear();
//				
//				//driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Amount Sanctioned(in lakhs)')]/..//td//input)["+i+"]")).sendKeys(AmountSanctioned);
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Training Targets')]/..//td//input)["+i+"]")).clear();
//				
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Training Targets')]/..//td//input)["+i+"]")).sendKeys(TrainingTargets);
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Placement Targets')]/..//td//input)["+i+"]")).clear();
//				
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Placement Targets')]/..//td//input)["+i+"]")).sendKeys(PlacementTargets);
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Centre')]/..//td//input)["+i+"]")).clear();
//				
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Centre')]/..//td//input)["+i+"]")).sendKeys(NumberofCentre);
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Sector')]/..//td//input)["+i+"]")).clear();
//				
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Sector')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Course(s)')]/..//td//input)["+i+"]")).clear();
//				
//				driver.findElement(By.xpath("(//tbody//tr//th[contains(text(),'Number of Course(s)')]/..//td//input)["+i+"]")).sendKeys(NumberofSectors);
//			
//			}
//			}
//			
//		
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
//		////////
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(3000);
//		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//span[text()='Approval in Progress']")).getText(), "Approval in Progress");
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//	}
////	
//////////	/////////////////////////////////////////////////////////////////, dependsOnMethods="addSchemeTC_01"
//////
//	
//	@DataProvider
//	public Object[][] approveScheme()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Non_pmkyy.xls", 
//				"FeeBasedAddSchemeSC14TC02");
//	}
//	
//	@Test(dataProvider="approveScheme", dependsOnMethods="addSchemeTC_01")
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
//	precondition();
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
//		//List <WebElement> button = 
//				driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")).click();
////		int size = button.size();
////		WebElement ele = button.get(size-1);
////		ele.click();
//		//List <WebElement> ta =
//				driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')])[1]")).click();
////		int size1 = ta.size();
////		WebElement tab = ta.get(size1-1);
////		tab.click();
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
//		fss.selectReviewComments(comments);//not verified this field is  only disable
//	        Thread.sleep(2000);
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
//	            Thread.sleep(2000);
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
//					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='NOT APPROVED'])[1]")).getText(), "NOT APPROVED");
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
////
////////////////////////, dependsOnMethods="daApproveSchemeTC_02"
////
//	@DataProvider
//	public Object[][] resubmitAndReviewScheme()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Non_pmkyy.xls", 
//				"FeeBasedAddSchemeSC14TC03");
//	}
//
//	@Test(dataProvider="resubmitAndReviewScheme")
//	public void resubmitAndReviewSchemeTC_03(String sno, String tpUsername, String tpPassword, String daComments,
//			String oldProjectName, String daReviewComments, String newFinancialModel, String newFundedBy, 
//			String newProjectDuration, String newAgreementDate, String newDisbursementDate, String newProjectID,
//			String newProjectName, String newProposingOrganisation, String newImplementingOrganisation, String newPromoterDetails, 
//			String newTarget, String newAssessmentMode, String newStartDate, String newEndDate, String newProjectReview,String newProjectComments,
//			String newLoanAmount,
//			String newMoratoriumPeriod, String newLoanDuration, String newInterestRate, 
//			String newloanReview,String newloanDetailscomments,String newsupportdocumentReview,String newdocumentReviewcomments,
//			String newSignedTermsheetFile,
//			String newSignedProposalFile, String newOtherSupportingFile, String newSector, String newTrainingTarget, 
//			String newAddSectorUndertakingFile, String newAffiliationCertificate, String newCourseName, String newJobRole, 
//			String NewAssociatedQP,
//		    String newNsqfLevel, String newCourseDescription, String newCertificateName, String newMinimumAge,
//			String newMinimumEducation, String newCourseDuration, String newNumberOfHours, String newCourseFee, String newGradingPrefrences,
//			String newCourseApprovalFile, String newAffiliationFile, String newWorkOrderFile, String newChallanFile, String newStampPaper,
//			String newState, String newDistrict, String fDAUsername, String fDAPassword, String newComments, String newReviewComments) throws Exception
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
//		elp.performlogin(tpUsername, tpPassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(10000);
//		tpdp.clickOnMySchemes();
//		TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
//		Thread.sleep(3000);
//		if(daComments.equalsIgnoreCase("Approved"))
//		{
//			Thread.sleep(3000);
//			tpms.clickOnApprovedScheme();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+oldProjectName+"']]]]//span[text()='Approved']")).getText(), "Approved");
//		}
//		
//		else if(daComments.equalsIgnoreCase("Not Approved"))
//		{
//			Thread.sleep(3000);
//			tpms.clickOnApprovalInProgress();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[2]")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("(//a[contains(text(),'View Details')])[2]")).click();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+oldProjectName+"']]]]//span[text()='Send Back']")).getText(), "Send Back");
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("(//tr[td[span[span[text()='"+oldProjectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[2]")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("(//tr[td[span[span[text()='"+oldProjectName+"']]]]//a[contains(text(),'View Details')])[2]")).click();
//			TP_FeeBasedProgramPage  tpfb = new TP_FeeBasedProgramPage (driver);
////			Thread.sleep(3000);
////			tpfb.clickOnCloseButton();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='review']")).getAttribute("value"), daComments);//
//			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='comment']")).getAttribute("value"), daReviewComments);
//			Thread.sleep(3000);
//			tpfb.selectFinancialModelType(newFinancialModel);
//			if(newFinancialModel.equals("Funded"))
//			{
//				Thread.sleep(5000);
//				//tpfb.enterProjectFundedBy(fundedBy);
//				newFundedBy = driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 7, newFundedBy);
//				newProjectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 8, newProjectDuration);				
//				Thread.sleep(3000);
//				tpfb.clickOnSelectAgreementDate();
//				Thread.sleep(3000);
//				newAgreementDate=driver.findElement(By.xpath("//input[@placeholder='Select Agreement Date']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 9, newAgreementDate);
//				tpfb.clickOnSelectDisbursementDate();
//				newDisbursementDate = driver.findElement(By.xpath("//input[@placeholder='Select First Disbursement Date']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 10, newDisbursementDate);
//				Thread.sleep(3000);
//				tpfb.enterProjectProposalID(newProjectID);
//				tpfb.enterNameOfProject(newProjectName);
//			
//				newProposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 13, newProposingOrganisation);
//				Thread.sleep(5000);
//				tpfb.enterNameOfImplementingOrganisation(newImplementingOrganisation);
//				tpfb.enterPromoterDetails(newPromoterDetails);
//				tpfb.enterProjectTarget(newTarget);
//				tpfb.selectAssessmentMode(newAssessmentMode);
//				Thread.sleep(3000);
//				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 18, newStartDate);
//				//tpfb.clickOnEndDateOfProject();
//
//				
//				Thread.sleep(3000);
//				tpfb.enterSanctionLoanAmount(newLoanAmount);
//				tpfb.selectMoratoriumPeriod(newMoratoriumPeriod);
//				tpfb.selectForLoanDuration(newLoanDuration);
//				tpfb.selectForInterestRate(newInterestRate);
//				
//			}
//			
//			else
//			{
//				newProjectDuration = driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 8, newProjectDuration);				
//				tpfb.clickOnSelectAgreementDate();
//				newAgreementDate= driver.findElement(By.xpath("//input[@placeholder='Select Agreement Date']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 9, newAgreementDate);
//				Thread.sleep(3000);
//				tpfb.enterProjectProposalID(newProjectID);
//				tpfb.enterNameOfProject(newProjectName);
//		
//				//tpfb.enterNameOfImplementingOrganisation(implementingOrganisation);
//				newProposingOrganisation = driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 13, newProposingOrganisation);
//				Thread.sleep(5000);
//				//tpfb.enterNameOfProposingOrganisation(proposingOrganisation);
//				tpfb.enterNameOfImplementingOrganisation(newImplementingOrganisation);
//				tpfb.enterPromoterDetails(newPromoterDetails);
//				tpfb.enterProjectTarget(newTarget);
//				tpfb.selectAssessmentMode(newAssessmentMode);
//				Thread.sleep(3000);
//				tpfb.clickOnStartDateOfProject();
//				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value");
//				ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 18, newStartDate);
//				tpfb.clickOnSanctionLoanAmount();
//
//			}
//			
//			
//			Thread.sleep(3000);
//			newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/NON_PMKVY_SUBSCHEME_WORKFLOW1.xls", "FeeBasedAddSchemeSC14TC03", Integer.parseInt(sno), 19, newEndDate);
//			Thread.sleep(3000);
//			tpfb.clickOnSignedTermsheetBrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newSignedTermsheetFile);
//			Thread.sleep(3000);
//			tpfb.clickOnSignedTermsheetUploadFile();
//			Thread.sleep(3000);
//			tpfb.clickOnSignedProposalBrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newSignedProposalFile);
//			Thread.sleep(3000);
//			tpfb.clickOnSignedProposalUploadFile();
//			Thread.sleep(3000);
//			tpfb.clickOnSupportingDocumentBrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newOtherSupportingFile);
//			Thread.sleep(3000);
//			tpfb.clickOnSupportingDocumentUploadFile();
//			Thread.sleep(3000);
//			tpfb.clickOnAddSector();
//			Thread.sleep(2000);
//			tpfb.selectSector(newSector);
//			Thread.sleep(3000);
//			tpfb.enterProposedTrainingTarget(newTrainingTarget);
//			Thread.sleep(2000);
//			tpfb.clickOnAdd_AddSector();
//			String addedSector = driver.findElement(By.xpath("//td[text()='"+newSector+"']")).getText();
////			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow3.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(sno), 4, addedSector);
//			Thread.sleep(5000);
//			tpfb.clickOnAddCourse();
//			Thread.sleep(8000);
//			
//			
//			tpfb.selectSector_AddCourse(newSector);
//			tpfb.selectJobRoleMappingType(newJobRole);
//			if(newJobRole.equals("QP-NOS"))
//			{
//				Thread.sleep(3000);
//				tpfb.selectAssociatedQP_JobRoleNameI(NewAssociatedQP);
//				tpfb.enterCourseName(newCourseName);
//			tpfb.enterNameOfIssuedCertificate(newCertificateName);
//				
//				
//				
//			
//			}
//			else 
//			{
//				Thread.sleep(4000);
//				tpfb.enterCourseName(newCourseName);
//				tpfb.enterCourseDescription(newCourseDescription);
//				tpfb.enterNameOfIssuedCertificate(newCertificateName);
//				tpfb.selectMinimumAge(newMinimumAge);
//			}
//			
//			tpfb.selectMinimumEducationRequired(newMinimumEducation);
//			tpfb.enterCourseDuration(newCourseDuration);
//			Thread.sleep(2000);
//			tpfb.enterNumberOfHoursPerDay(newNumberOfHours);
//			tpfb.enterCourseFee(newCourseFee);
//			tpfb.selectGradingPrefrences(newGradingPrefrences);
//			Thread.sleep(3000);
////			
//			
//			
//		
//			tpfb.clickOnStampPapaer_BrowseFile();
//			Thread.sleep(5000);
//			UploadFile.upload(newStampPaper);
//			Thread.sleep(3000);
//			tpfb.clickOnStampPape_UploadFile();
//			Thread.sleep(4000);
//			tpfb.clickOnAdd_AddCourse();
//			Thread.sleep(3000);
//			Thread.sleep(3000);
//			tpfb.selectState_LocationForTC(newState);
//			tpfb.selectDistricts_LocationForTC(newDistrict);
//			Thread.sleep(3000);
//			tpfb.clickOnAddForLocationOfTC();
//			Thread.sleep(3000);
//			tpfb.clickOnResubmitForReviewAgain();
//			
//			Thread.sleep(5000);
//			tpms.clickOnApprovalInProgress();
//		
//			LogOutPage plp = new LogOutPage(driver);
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout();
//				///////////////////////////
//				lp.clickLogin();
//				Thread.sleep(3000);
//				//BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//				bsp.clickToClose();
//				Thread.sleep(3000);
//				elp.performlogin(fDAUsername, fDAPassword);
//				FDA_DashboardPage fdp = new FDA_DashboardPage(driver);
//				Thread.sleep(5000);
//				fdp.clickOnViewAllOnboardingRequest();
//				FDA_OnboardingRequestPage frp = new  FDA_OnboardingRequestPage(driver);
//				Thread.sleep(3000);
//				//frp.selectTPID(tpID);
//				frp.selectType(newFinancialModel);
//				frp.selectStatus("RESUBMITTED");
//				Thread.sleep(2000);
//				frp.clickOnApply();
//				Thread.sleep(4000);
//				
//				
//				List <WebElement> button = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpUsername+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
//				int size = button.size();
//				WebElement ele = button.get(size-1);
//				ele.click();
//				List <WebElement> ta = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpUsername+"']]]]//a[contains(text(),'Take Action')]"));
//				int size1 = ta.size();
//				WebElement tab = ta.get(size1-1);
//				tab.click();
//				FDA_SelectedSchemePage fss = new FDA_SelectedSchemePage(driver);
//				Thread.sleep(3000);
//
//				Assert.assertEquals(driver.findElement(By.xpath("//input[@id='typeOfPia']")).getAttribute("value"), newFinancialModel);
//				if(newFinancialModel.equals("Funded"))
//				{
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='fundedBy']")).getAttribute("value"), newFundedBy);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), newProjectDuration);
//					Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'First Disbursement Date:')]/..//input")).getAttribute("value"), newDisbursementDate);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), newProjectID);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), newProjectName);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), newProposingOrganisation);
//					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), newImplementingOrganisation);
//					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), newPromoterDetails);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), newTarget);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), newAssessmentMode);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), newStartDate);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), newEndDate);
//					fss.SelectProjectDetailReviewDropdownlist(newProjectReview);
//				    fss.EnterProjectDetailComment(newProjectComments);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sanctionLoanAmount']")).getAttribute("value"), newLoanAmount);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='moratoriumPeriod']")).getAttribute("value"), newMoratoriumPeriod);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='loanDuration']")).getAttribute("value"), newLoanDuration);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='interestRate']")).getAttribute("value"), newInterestRate);
//					fss.SelectloanDetailsReview(newloanReview);
//					Thread.sleep(1000);
//					fss.EnterloanDetailsCommentDropdownlist(newloanDetailscomments);
//					Thread.sleep(3000);
//				}
//				else
//				{
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectDuration']")).getAttribute("value"), newProjectDuration);
//					Assert.assertEquals(driver.findElement(By.xpath("(//input[@ng-reflect-name='agreementDate'])[2]")).getAttribute("value"), newAgreementDate);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='projectProposalId']")).getAttribute("value"), newProjectID);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"), newProjectName);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposingOrganisation']")).getAttribute("value"), newProposingOrganisation);
//					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='implementingOrganisation']")).getAttribute("value"), newImplementingOrganisation);
//					Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='promoterDetails']")).getAttribute("value"), newPromoterDetails);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='target']")).getAttribute("value"), newTarget);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@id='assessmentMode']")).getAttribute("value"), newAssessmentMode);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value"), newStartDate);
//					Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value"), newEndDate);
//				}
//				
//				Thread.sleep(3000);
//				fss.clickOnDownloadSignedTermsheet();
//				Thread.sleep(3000);
//				fss.clickOnDownloadSignedProposal();
//				Thread.sleep(3000);
//				fss.clickOnDownloadSupportingDocument();
//				
//				fss.SelectSupportDocumentReview(newsupportdocumentReview);
//				fss.EnterSupportDocumentReview(newdocumentReviewcomments);
//			
//				
//				
//				
//				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newSector+"']")).getText(), newSector);
//				Thread.sleep(3000);
////s			//s fss.clickOnSectors_ViewAttachedDocument();
////				Assert.assertEquals(driver.findElement(By.xpath("//p[text()='"+newCourseName+"']")).getText(), newCourseName);
////				Thread.sleep(3000);
////			//s	fss.clickOnCourses_ViewAttachedDocument();
////				if(newJobRole.equals("QP-NOS")) 
////				{
////					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+NewAssociatedQP+"']")).getText(), NewAssociatedQP);
////					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNsqfLevel+"']")).getText(), newNsqfLevel);
////					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNumberOfHours+"']")).getText(), newNumberOfHours);
////
////				}
////				else 
////				{
////					Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newNumberOfHours+"']")).getText(), newNumberOfHours);
////				}
////				
////				Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+newState+"']")).getText(), newState);
////				Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+newDistrict+"')]")).getText(), newDistrict);
////s				Thread.sleep(3000);
//				fss.selectReviewComments(newComments);
//				fss.enterReviewComments(newReviewComments);
//				Thread.sleep(3000);
//				fss.clickOnFirst_SubmitResponse();
//				Thread.sleep(3000);
//				fss.clickOnSecond_SubmitResponse();
//				//fss.clickOnOK();
//				//frp.selectTPID(tpID);
//				frp.selectType(newFinancialModel);
//				frp.selectStatus(newReviewComments);
//				Thread.sleep(2000);
//				frp.clickOnApply();
//				if(newComments.equals("Approved"))
//				{
//					Thread.sleep(3000);
//					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='APPROVED'])[1]")).getText(), "APPROVED");
//				}
//				else if(newComments.equals("Not Recommended"))
//				{
//					Thread.sleep(3000);
//					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='BLOCKED'])[1]")).getText(), "BLOCKED");
//				}
//				else if(newComments.equals("Not Approved"))
//				{
//					Thread.sleep(3000);
//					Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpUsername+"']]]]//span[text()='REJECTED'])[1]")).getText(), "REJECTED");
//				}
//				
//		
//			Thread.sleep(5000);
//		//	LogOutPage plp = new LogOutPage(driver);
//				plp.clickOnProfileLogo();
//			plp.clickOnLogout();
//		}		
//			
//	}
////////////////////////////subha
//
	@DataProvider
	public Object[][] addTrainingCentre() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
				"MySchemeAddTCSC15TC01");
	}

	@Test(dataProvider = "addTrainingCentre")//,dependsOnMethods="daApproveSchemeTC_02")
	public void addTrainingCentreTC04(String sno, String tpUsername, String tpPassword, String projectID,
			String trainingCentreType, String trainingCentreName, String ownership,String type,String CentreFacultyType,String franchiseDocument,
			String startDate, String endDate, String bathesNumber, String studentNumber, String annualCapacity,
			String capacityUtilization, String governmentTieUp, String centreCapacity, String centreArea,
			String trainingRooms, String labNumber, String receptionArea, String waitingArea, String maleWashRooms,
			String femaleWashRooms, String unisexWashRooms, String airportDistance, String trainStationDistance,
			String cityCentreDistance, String tcAddress, String landmark, String pincode, String state, String district,
			String tehsil, String city, String parliamentryConstituency, String geoLocation, String addressProof,
			String addressProofFile, String facility_Photos, String spocName, String spocEmail, String spocMobile,
			String spocDesignation, String spocLandLine, String srNo_TCRoom, String tcRoomPhotos,
			String laboratory_SrNo, String laboratoryPhotos, String maleWashRoom_SrNo, String maleWashRoomPhotos,
			String femaleWashRoom_SrNo, String femaleWashRoomPhotos, String unisexWashRoom_SrNo,
			String unisexWashRoomPhotos, String sector, String course, String target) throws Exception {
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
		Thread.sleep(15000);
		tpdp.clickOnMySchemes();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectID +"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(5000);
		fbd.clickOnViewTrainingCentres();
		TP_FeeBased_ViewAllTrainingCentrePage fbtc = new TP_FeeBased_ViewAllTrainingCentrePage(driver);
		Thread.sleep(10000);
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
		
		if (ownership.equalsIgnoreCase("Self Run"))
		{
			fbad.SelectType(type);
			Thread.sleep(3000);
			fbad.SelectcenterOwnershipType(CentreFacultyType);
		}
		else if (ownership.equals("Franchise"))
		{
			fbad.SelectcenterOwnershipType(CentreFacultyType);
			Thread.sleep(5000);
			fbad.clickOnFranchiseDocuments_BrowseFile();
			Thread.sleep(5000);
			UploadFile.upload(franchiseDocument);
			Thread.sleep(5000);
			fbad.clickOnFranchiseDocuments_UploadFile();
			Thread.sleep(3000); 
		}
		Thread.sleep(3000);
		fbad.entreCentreArea(centreArea); 
		fbad.selectNumberOfTrainingRooms(trainingRooms);
		fbad.selectNumbersOfLabs(labNumber); 
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
		Thread.sleep(5000);
		fbad.enterNameOfSPOC(spocName);
		fbad.enterEmailAddressOfSPOC(spocEmail);
		fbad.enterMobileNumberOfSPOC(spocMobile);
		fbad.enterDesignationOfSPOC(spocDesignation);
		fbad.enterLandLineNumberOfSPOC(spocLandLine);
		Thread.sleep(3000);
		fbad.clickOnAddSectorTarget();
		Thread.sleep(3000);
		fbad.selectSector(sector);
		Thread.sleep(3000);
		fbad.selectCourse(course);
		fbad.enterTarget(target);
		Thread.sleep(3000);
		fbad.clickOnSubmit_SectorTarget();
		Thread.sleep(3000);
		fbad.clickOnSaveAndContinue();
		Thread.sleep(15000);
		LogOutPage plp = new LogOutPage(driver);
		Thread.sleep(5000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();

	}
	
////
//	@DataProvider
//	public Object[][] cmaApproveTC() {
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
//				"CMAApproveTCSC15TC02");
//	} 
//
//	@Test(dataProvider = "cmaApproveTC")//,dependsOnMethods = "addTrainingCentreTC04")//, dependsOnMethods = "addTrainingCentreTC04"
//	public void approveTrainingCentreTC_05(String sno, String cmaUsername, String cmaPassword, String tpID,
//			String tcType, String status,String tcid, String expectedTCName, String expectedOwnership, 
//			String expectedStartDate,
//			String expectedEndDate, String expectedBathesNumber, String expectedStudentNumber,
//			String expectedAnnualCapacity, String expectedCapacityUtilization, String expectedGovernmentTieUp,
//			String expectedCentreCapacity, String expectedCentreArea, String expectedTrainingRooms,
//			String expectedLabNumber, String expectedReceptionArea, String expectedWaitingArea,
//			String expectedMaleWashRooms, String expectedFemaleWashRooms, String expectedUnisexWashRooms,
//			String expectedAirportDistance, String expectedTrainStationDistance, String expectedCityCentreDistance,
//			String expectedTCAddress, String expectedLandmark, String expectedPincode, String expectedState,
//			String expectedDistrict, String expectedTehsil, String expectedCity,
//			String expectedParliamentryConstituency, String expectedAddressProof, String expectedSPOCName,
//			String expectedSPOCEmail, String expectedSPOCMobile, String expectedSPOCDesignation,
//			String expectedSPOCLandLine, String expectedSector, String expectedCourseName, String expectedTarget,
//			String numberofreviewandcomments,String review,String reviewComments,String CMAFacelitiesReview,
//			String CMAComments
//			) throws Exception {
//		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(cmaUsername, cmaPassword);
//		CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
//		Thread.sleep(8000);
//		cmad.clickOnViewAllTCAddRequest();
//		CMA_TCRequestPage cmtc = new CMA_TCRequestPage(driver);
//		Thread.sleep(10000);
//		cmtc.EnterTPid(tpID);
//		cmtc.selectType(tcType);
//		cmtc.selectStatus(status);
//		cmtc.clickOnApply();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+ tcid+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='" + tcid + "']]]]//a[contains(text(),'Take Action')]")).click();
//
//		CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
//		Thread.sleep(15000);
//
////	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"),expectedTCName);
////		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='geographicalLocation'])[1]")).isSelected());
////	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"),expectedOwnership);
//		if (expectedOwnership.equals("Franchise")) 
//		{
//			cmat.clickOnDownloadFranchiseDocuments();
////			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
////			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);
//
//		} 
//		else
//		{
////			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
////			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);	
//		}
//		
////	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"),expectedCentreArea);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"),expectedCentreCapacity);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"),expectedTrainingRooms);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"),expectedLabNumber);
////		
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"),expectedMaleWashRooms);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"),expectedFemaleWashRooms);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"),expectedUnisexWashRooms);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"),expectedAirportDistance);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"),expectedTrainStationDistance);
////	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"),expectedCityCentreDistance);
////		
//		Thread.sleep(3000);
//		cmat.clickOnDownloadAddressProof();
//
//		Thread.sleep(3000);
//		//cmat.clickFor_Download_AllFacilities();
////	s	Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + expectedSector + "']")).getText(),expectedSector);
////		
////s		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + expectedTarget + "']")).getText(),expectedTarget);
//		
//		
//		cmat.selectReview(review);
//		cmat.enterReviewComments(reviewComments);
//		
//		
//		
//		int totalriviews=Integer.parseInt(numberofreviewandcomments);
//		for(int i=2;i<=totalriviews;i++)
//		{
//			Thread.sleep(1000);
//			WebElement reviewCommentsDropDownList = driver.findElement(By.xpath("(//select[@formcontrolname='review'])["+i+"]"));
//			 
//			SelectDropDownList.selectDropDownListByVisibleText(reviewCommentsDropDownList, CMAFacelitiesReview);
//			Thread.sleep(2000);
//			WebElement comments = driver.findElement(By.xpath("(//textarea[@formcontrolname='comment'])["+i+"]"));
//			comments.sendKeys(CMAComments);
//			
//		}
//		cmat.clickOnSubmitReview();
//		cmat.clickOnYES();
//		Thread.sleep(2000);
//		cmtc.selectType(tcType);
//		Thread.sleep(2000);
//		cmtc.selectStatus(reviewComments);
//		Thread.sleep(3000);
//		cmtc.clickOnApply();
//		if (review.equals("APPROVED")) 
//		{
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcid+"']]]]//span[text()='APPROVED']")).getText(), "APPROVED");
//		} 
//		else if (review.equals("NOT APPROVED"))
//		{
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='" +tcid+ "']]]]//span[text()='NOT APPROVED']")).getText(), "NOT APPROVED");
//		} 
//		else if (review.equals("Send Back"))
//		{
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='" +tcid+ "']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
//		}
//
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//
//	}



	

	
	
	
	
	
	
	
	
	
	
	
	//////////////////, dependsOnMethods="approveTrainingCentreTC_05".......resubmitandreview tc not checked

//	@DataProvider
//	public Object[][] resubmitAndReviewTC()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03");
//	}
//
//	@Test(dataProvider="resubmitAndReviewTC")
//	public void resubmitAndReviewTrainingCentreTC06(String sno, String tpUsername,
//			String tpPassword, String projectName, String tcName, String tcReview,
//			String newTrainingCentreName, String newOwnership, String franchiseDocument,
//			String newStartDate, String newEndDate, String newBathesNumber, String newStudentNumber,
//			String newAnnualCapacity, String newCapacityUtilization, String newGovernmentTieUp, 
//			String newCentreCapacity, String newCentreArea, String newTrainingRooms, String newLabNumber,
//			String newReceptionArea, String newWaitingArea, String newMaleWashRooms, String newFemaleWashRooms,
//			String newUnisexWashRooms, String newAirportDistance, String newTrainStationDistance, 
//			String newCityCentreDistance, String newTCAddress, String newLandmark, String newPincode, 
//			String newState, String newDistrict, String newTehsil, String newCity,
//			String newParliamentryConstituency, String geoLocation, String newAddressProof,
//			String addressProofFile,  String facility_Photos, String newSpocName, String newSpocEmail,
//			String newSpocMobile, String newSpocDesignation, String newSpocLandLine, String srNo_TCRoom,
//			String newTCRoomPhotos, String laboratory_SrNo, String newLaboratoryPhotos,String maleWashRoom_SrNo, 
//			String newMaleWashRoomPhotos, String femaleWashRoom_SrNo, String newFemaleWashRoomPhotos,
//			String unisexWashRoom_SrNo, String newUnisexWashRoomPhotos, String newSector, String newCourse,
//			String newTarget, String cmaUsername, String cmaPassword, String tcType, String status, String review,
//			String reviewComments)throws Exception
//	{
//		precondition();
////		int srno = Integer.parseInt(sno);
//		LaunchPage lp = new LaunchPage(driver); 
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpUsername, tpPassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(10000);
//		tpdp.clickOnMySchemes();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
//		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
//		Thread.sleep(3000);
//		fbd.clickOnViewTrainingCentres();
//		Thread.sleep(3000);
//		if(tcReview.equals("Recommended"))
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcName+"']]]]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
//			
//		}
//		else if(tcReview.equals("Not Recommended"))
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcName+"']]]]//span[text()='REJECTED']")).getText(), "REJECTED");			
//		}
//		else if(tcReview.equals("Send Back"))
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcName+"']]]]//span[text()='Sent Back']")).getText(), "Sent Back");
//			
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcName+"']]]]//a[contains(text(),'View Details')]")).click();
//			TP_FeeBased_AddTrainingCentrePage fbad = new TP_FeeBased_AddTrainingCentrePage(driver);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='review']")).getAttribute("value"), "Document Required");
//			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='comment']")).getAttribute("value"), "SENT BACK");
//			
//			Thread.sleep(3000);
//			fbad.enterTrainingCentreName(newTrainingCentreName);
//			Thread.sleep(3000);
//			fbad.clcikOnRuralLocation();
//			Thread.sleep(3000);
//			fbad.selectForCentreOwnerShip(newOwnership);
//			if(newOwnership.equals("Franchise"))
//			{
//				Thread.sleep(5000);
//				fbad.clickOnFranchiseDocuments_BrowseFile();
//				Thread.sleep(5000);
//				UploadFile.upload(franchiseDocument);
//				Thread.sleep(5000);
//				fbad.clickOnFranchiseDocuments_UploadFile();
//				Thread.sleep(3000);
////				fbad.clickOnStartDateForTCDuration();
////				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
////				ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 9, newStartDate);
////				fbad.clickOnEndDateForTCDuration();
////				newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
////				ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 10, newEndDate);
//			}
//			else
//			{
////				fbad.clickOnStartDateForTCDuration();
////				newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
////				ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 9, newStartDate);
////				fbad.clickOnEndDateForTCDuration();
////				newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
////				ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 10, newEndDate);
//			}
//			
////			fbad.enterNumberOfBatchesPerDay(bathesNumber);
////			fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
////			fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
////			fbad.enterCapacityUtilization(capacityUtilization);
////			fbad.selectForGovernmentTieUp(governmentTieUp);
//			Thread.sleep(3000);
//			fbad.entreCentreArea(newCentreArea);
//			fbad.enterCentreCapacity(newCentreCapacity);
//			fbad.selectNumberOfTrainingRooms(newTrainingRooms);
//			fbad.selectNumbersOfLabs(newLabNumber);
////			fbad.enterReceptionAreaSize(receptionArea);
////			fbad.enterWaitingAreaCapacity(waitingArea);
//			fbad.selectNumberOfMaleWashRooms(newMaleWashRooms);
//			fbad.selectNumberOfFemaleWashRooms(newFemaleWashRooms);
//			fbad.selectNumberOfUnisexWashRooms(newUnisexWashRooms);
//			fbad.enterDistanceFromNearestAirport(newAirportDistance);
//			fbad.enterDistanceFromNearestTrainStation(newTrainStationDistance);
//			fbad.enterDistanceFromNearestCityCentre(newCityCentreDistance);
//			Thread.sleep(3000);
//			fbad.enterAddressOFTC(newTCAddress);
//			Thread.sleep(3000);
//			fbad.enterNearByLandmark(newLandmark);
//			Thread.sleep(5000);
//			fbad.enterPincode(newPincode);
//			Thread.sleep(3000);
//			fbad.selectState(newState);
//			Thread.sleep(2000);
//			fbad.selrctDistrict(newDistrict);
//			Thread.sleep(2000);
//			fbad.selectTehsil(newTehsil);
//			Thread.sleep(3000);
//			fbad.selectCityOrVillage(newCity);
//			Thread.sleep(2000);
//			fbad.selectParliamentryConstituency(newParliamentryConstituency);
//			fbad.enterGeoLocation(geoLocation);
//			Thread.sleep(3000);
//			fbad.selectAddressProofType(newAddressProof);
//			Thread.sleep(3000);
//			fbad.clickOnAddressProof_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(addressProofFile);
//			Thread.sleep(3000);
//			fbad.clickOnAddressProof_UploadFile();
//			if(tcType.equals("Fixed"))
//			{
//				Thread.sleep(5000);
//				List<WebElement> ele = driver.findElements(By.xpath("//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@id='customFile']"));
//				for(int i=0;i<ele.size();i++)
//				{
//					WebElement brws = ele.get(i);
//					Thread.sleep(3000);
//					brws.click();
//					Thread.sleep(5000);
//					UploadFile.upload(facility_Photos);
//					Thread.sleep(5000);
//					driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+(i+1)+"]")).click();
//				}
//
//			}
//			else
//			{
//				Thread.sleep(5000);
//				List<WebElement> ele = driver.findElements(By.xpath("//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@id='customFile']"));
//				for(int i=0;i<ele.size();i++)
//				{
//					WebElement brws = ele.get(i);
//					Thread.sleep(3000);
//					brws.click();
//					Thread.sleep(5000);
//					UploadFile.upload(facility_Photos);
//					Thread.sleep(5000);
//					driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+(i+1)+"]")).click();
//				}
//
//			}
//			Thread.sleep(5000);
//			fbad.enterNameOfSPOC(newSpocName);
//			fbad.enterEmailAddressOfSPOC(newSpocEmail);
//			fbad.enterMobileNumberOfSPOC(newSpocMobile);
//			fbad.enterDesignationOfSPOC(newSpocDesignation);
//			fbad.enterLandLineNumberOfSPOC(newSpocLandLine);
//			Thread.sleep(3000);
//			fbad.select_SrNo_TrainingRoomPhotos(srNo_TCRoom);
//			fbad.clickOnTrainingRoomPhotos_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newTCRoomPhotos);
//			Thread.sleep(3000);
//			fbad.clickOnTrainingRoomPhotos_UploadFile();
//			Thread.sleep(3000);
//			fbad.select_SrNo_Laboratory(laboratory_SrNo);
//			fbad.clickOnLaboratoryPhotos_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newLaboratoryPhotos);
//			Thread.sleep(3000);
//			fbad.clickOnLaboratoryPhotos_UploadFile();
//			Thread.sleep(3000);
//			fbad.select_SrNo_ForMaleWashRoom(maleWashRoom_SrNo);
//			fbad.clickOnMaleWashRoomPhotos_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newMaleWashRoomPhotos);
//			Thread.sleep(3000);
//			fbad.clickOnMaleWashRoomPhotos_UploadFile();
//			Thread.sleep(3000);
//			fbad.select_SrNo_ForFemaleWashRoom(femaleWashRoom_SrNo);
//			fbad.clickOnFemaleWashRoomPhotos_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newFemaleWashRoomPhotos);
//			Thread.sleep(3000);
//			fbad.clickOnFemaleWashRoomPhotos_UploadFile();
//			Thread.sleep(3000);
//			fbad.select_SrNo_ForUnisexWashRoom(unisexWashRoom_SrNo);
//			fbad.clickOnUnisexWashRoomPhotos_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(newUnisexWashRoomPhotos);
//			Thread.sleep(3000);
//			fbad.clickOnUnisexWashRoomPhotos_UploadFile();
//			/*fbad.clickOnCafetariaPhotos_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(cafetariaPhotos);
//			Thread.sleep(3000);
//			fbad.clickOnCafetariaPhotos_UploadFile();
//			Thread.sleep(10000);*/
//			Thread.sleep(3000);
//			fbad.clickOnAddSectorTarget();
//			Thread.sleep(3000);
//			fbad.selectSector(newSector);
//			Thread.sleep(3000);
//			//fbad.selectCourse(newCourse);
//			fbad.enterTarget(newTarget);
//			Thread.sleep(3000);
//			fbad.clickOnSubmit_SectorTarget();
//			Thread.sleep(12000);
//			fbad.clickOnResubmit();
//			Thread.sleep(3000);
//			fbad.clickOnYesAddTrainingCentre();
//			Thread.sleep(3000);
//			fbad.clickOnOK();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='RESUBMITTED']")).getText(), "RESUBMITTED");
//			LogOutPage plp = new LogOutPage(driver);
//			Thread.sleep(5000);
//			plp.clickOnProfileLogo();
//			Thread.sleep(2000);
//			plp.clickOnLogout();
//			
//			
//			lp.clickLogin();
//			Thread.sleep(3000);
//			//BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//			bsp.clickToClose();
//			Thread.sleep(3000);
//			Thread.sleep(3000);
//			elp.performlogin(cmaUsername, cmaPassword);
//			CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
//			Thread.sleep(8000);
//			cmad.clickOnViewAllTCAddRequest();
//			CMA_TCRequestPage cmtc = new CMA_TCRequestPage(driver);
//			Thread.sleep(5000);
//			cmtc.selectType(tcType);
//			cmtc.selectStatus(status);
//			cmtc.clickOnApply();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).sendKeys(Keys.ENTER);
//			Thread.sleep(5000);
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[@class='dropdown-item']")).click();
//			Thread.sleep(5000);
//			CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), newTrainingCentreName);
//			Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='geographicalLocation'])[1]")).isSelected());
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), newOwnership);
//			if(newOwnership.equals("Franchise"))
//			{
//				cmat.clickOnDownloadFranchiseDocuments();
//				//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), newStartDate);
//				//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), newEndDate);
//				
//			}
//			else
//			{
////				Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), newStartDate);
////				Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), newEndDate);	
//			}
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), newBathesNumber);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), newStudentNumber);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), newAnnualCapacity);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), newCapacityUtilization);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), newGovernmentTieUp);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), newCentreArea);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), newCentreCapacity);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), newTrainingRooms);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), newLabNumber);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), newReceptionArea);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), newWaitingArea);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), newMaleWashRooms);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), newFemaleWashRooms);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), newUnisexWashRooms);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), newAirportDistance);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), newTrainStationDistance);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), newCityCentreDistance);
////			Thread.sleep(5000);
////			driver.navigate().refresh();
////			Thread.sleep(8000);
////			cmtc.selectType(tcType);
////			cmtc.selectStatus(status);
////			cmtc.clickOnApply();
////			Thread.sleep(10000);
////			driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
////			Thread.sleep(3000);
////			driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[contains(text(),'Take Action')]")).click();
////			Thread.sleep(3000);
////			JavascriptExecutor js = (JavascriptExecutor) driver;
////			js.executeScript("scroll(0, 500)");
////			Thread.sleep(3000);
////			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), newTCAddress);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), newLandmark);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), newPincode);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), newState);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), newDistrict);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), newTehsil);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), newCity);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), newParliamentryConstituency);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='addressProofType']")).getAttribute("value"), newAddressProof);
//			Thread.sleep(3000);
//			cmat.clickOnDownloadAddressProof();
//		
//			Thread.sleep(3000);
//			cmat.clickFor_Download_AllFacilities();
//			
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), newSpocName);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), newSpocEmail);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), newSpocMobile);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), newSpocDesignation);
////			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), newSpocLandLine);
////			
////			Thread.sleep(3000);
////			cmat.clickOn_Preview_TrainingRoomPhotos();
////			cmat.clickOn_ClosePreview();
////			Thread.sleep(3000);
////			cmat.clickOn_Preview_LaboratoryRoomPhotos();
////			cmat.clickOn_ClosePreview();
////			Thread.sleep(3000);
////			cmat.clickOn_Preview_MaleWashRoomPhotos();
////			cmat.clickOn_ClosePreview();
////			Thread.sleep(3000);
////			cmat.clickOn_Preview_FemaleWashRoomPhotos();
////			cmat.clickOn_ClosePreview();
////			Thread.sleep(3000);
////			cmat.clickOn_Preview_UnisexWasRoomPhotos();
////			cmat.clickOn_ClosePreview();
////			Thread.sleep(3000);
//		
//			Assert.assertEquals(driver.findElement(By.xpath("//span[text()='"+newSector+"']")).getText(), newSector);
//			//Assert.assertEquals(driver.findElement(By.xpath("//span[text()='"+newCourse+"']")).getText(), newCourse);
//			Assert.assertEquals(driver.findElement(By.xpath("//span[text()='"+newTarget+"']")).getText(), newTarget);
//
//			cmat.selectReview(review);
//			cmat.enterReviewComments(reviewComments);
//			cmat.clickOnSubmitResponse();
//			cmat.clickOnOK();
//			cmtc.selectType(tcType);
//			Thread.sleep(3000);
//			cmtc.clickOnApply();
//			if(review.equals("Recommended"))
//			{
//				Thread.sleep(3000);
//				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
//			}
//			else if(review.equals("Not Recommended"))
//			{
//				Thread.sleep(3000);
//				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
//			}
//			else if(review.equals("Send Back"))
//			{
//				Thread.sleep(3000);
//				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
//			}
//			
//		}
//			
//		LogOutPage plp = new LogOutPage(driver);
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout();
//
//	
//}	
//addsector working fine,,,,,depends=TC05

//	@DataProvider
//	public Object[][] addSector()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", 
//				"MySchemeAddSectorSC15TC04");
//	}
//
//	@Test(dataProvider="addSector")//, dependsOnMethods="resubmitAndReviewTrainingCentreTC06")
//	public void addSectorTC07(String srno, String tpusername, String tppassword, String projectName,
//			String addedSector, String sector, String trainingTarget,
//			String undertakingFile, String affiliationCertificate) throws Exception
//	{
//		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpusername, tppassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(10000);
//		tpdp.clickOnMySchemes();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();		
//		TP_FeeBased_DashboardPage tpfb = new TP_FeeBased_DashboardPage(driver);
//		Thread.sleep(3000);
//		tpfb.clickOnViewSectorAndCourses();
//		TP_FeeBased_ViewAllSectorAndCoursesPage fbsc = new TP_FeeBased_ViewAllSectorAndCoursesPage(driver);
//		Thread.sleep(3000);
//		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+addedSector+"']]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
//		Thread.sleep(5000);
//		fbsc.clickOnAddSector();
//		Thread.sleep(8000);
//		fbsc.selectSector(sector);
//		Thread.sleep(3000);
//		fbsc.enterProposedTrainingTarget(trainingTarget);
//		Thread.sleep(3000);
//		fbsc.clickOnUndertakingDocument_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(undertakingFile);
//		
//		Thread.sleep(3000);
//		fbsc.clickOnUndertakingDocument_UploadFile();
//		Thread.sleep(3000);
//		fbsc.clickOnAffiliationCertificate_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(affiliationCertificate);
//		Thread.sleep(3000);
//		fbsc.clickOnAffiliationCertificate_UploadFile();
//		Thread.sleep(3000);
//		fbsc.clickOnSubmit();
//		Thread.sleep(3000);
//		fbsc.clickOnOK();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//span[text()='CREATED']")).getText(), "CREATED");
//		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//td[text()='"+trainingTarget+"']")).getText(), trainingTarget);
//		
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(5000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//		
//	}
///////// working fine approveSector
//	@DataProvider
//	public Object[][] approveSector()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", 
//				"CMAApproveSectorSC15TC06");
//	}
//
//	@Test(dataProvider="approveSector")//, dependsOnMethods="addSectorTC07")
//	public void approveSectorTC08(String sno, String cmaUsername, String cmaPassword, String status, 
//			String tpID, String expectedSector, String expectedTrainingTarget,
//			String sectorReviewComments, String sectorComments)throws Exception
//	{
//		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//		Thread.sleep(3000);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(cmaUsername, cmaPassword);
//		CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
//		Thread.sleep(8000);
//		cmad.clickOnViewAllSector();
//		CMA_AddSectorRequestPage cmas = new CMA_AddSectorRequestPage(driver);
//		Thread.sleep(3000);
//		cmas.selectStatus(status);
//		cmas.enterTPID(tpID);
//		Thread.sleep(5000);
//		cmas.clickOnApply();
//		Thread.sleep(3000);
//		List <WebElement> button = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
//		int size = button.size();
//		WebElement ele = button.get(size-1);
//		ele.click();
//		Thread.sleep(3000);
//		List<WebElement> sec = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
//		int size1 = sec.size();
//		WebElement tab = sec.get(size1-1);
//		tab.click();
//		CMA_SectorInfoPage cmsi = new CMA_SectorInfoPage(driver);
//		Thread.sleep(3000);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedSector);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposedTrainingTarget']")).getAttribute("value"), expectedTrainingTarget);
//		cmsi.clickOnDownloadSectorApprovalButton();
//		cmsi.clickOnDownloadAffiliationCertificateFromSSC();
//		Thread.sleep(10000);
//		cmsi.selectReviewComments(sectorReviewComments);
//		cmsi.enterReviewComents_ForSector(sectorComments);
//		cmsi.clickOnSubmitResponse();
//		Thread.sleep(3000);
//		cmas.selectStatus(sectorComments);
//		cmas.enterTPID(tpID);
//		Thread.sleep(5000);
//		cmas.clickOnApply();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='"+sectorComments+"'])[1]")).getText(), sectorComments);
//		
//		Thread.sleep(2000);
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//		
//	}
//	/////////////add course fine
////	
//	@DataProvider
//	public Object[][] addCourses()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
//				"MySchemeAddCoursSC15TC05");
//	}
//
//	@Test(dataProvider="addCourses")//,dependsOnMethods="approveSectorTC08"
//	public void addCourseTC09(String srno, String tpusername, String tppassword,String projectName, String sector,
//			String addedCourse, String jobRole,String jobRoleName, String courseName, String nsqfLevel, 
//			String courseDescription, String certificateName, String minimumAge, String minimumEducation, 
//			String courseDuration, String hourPerDay, String courseFee, String gradingPreference, String stampPaper) throws Exception
//	{
//		
//		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//	
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpusername, tppassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(10000);
//		tpdp.clickOnMySchemes();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();		
//		TP_FeeBased_DashboardPage tpfb = new TP_FeeBased_DashboardPage(driver);
//		Thread.sleep(3000);
//		tpfb.clickOnViewSectorAndCourses();
//		TP_FeeBased_ViewAllSectorAndCoursesPage fbsc = new TP_FeeBased_ViewAllSectorAndCoursesPage(driver);
//		Thread.sleep(5000);
//		
//		fbsc.clickOnAddedCourse();
//		Thread.sleep(3000);
//		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+addedCourse+"']]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
//		Thread.sleep(3000);
//		fbsc.clickOnAddCourse();
//		TP_FeeBased_AddCourseToSectorsPage adc = new TP_FeeBased_AddCourseToSectorsPage(driver);
//		
//		adc.selectSector(sector);
//		adc.selectJobRoleMappingType(jobRole);
//		if(jobRole.equals("QP-NOS"))
//		{
//			Thread.sleep(3000);
//			adc.selectAssociatedQPOrJobRoleName(jobRoleName);
//			Thread.sleep(3000);
//			adc.enterCourseName(courseName);
//			nsqfLevel = driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value");
//			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddCoursSC15TC05", Integer.parseInt(srno), 9, nsqfLevel);
//			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveCourseSC15TC07", Integer.parseInt(srno), 9, nsqfLevel);
//			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC010", Integer.parseInt(srno), 16, nsqfLevel);
//			//adc.enterCourseDescription(courseDescription);
//			adc.enterNameOfTheCertificateIssued(certificateName);
//			//adc.selectMinimumAge(minimumAge);
//		}
//		else
//		{
//			adc.enterCourseName(courseName);
//			adc.enterCourseDescription(courseDescription);
//			adc.enterNameOfTheCertificateIssued(certificateName);
//			adc.selectMinimumAge(minimumAge);
//		}
//		
//		adc.selectMinimumEducationRequired(minimumEducation);
//		String education = adc.selectFirstMinimumEducation();
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddCoursSC15TC05", Integer.parseInt(srno), 13, education);
//		adc.enterCourseDuration(courseDuration);
//		adc.enterNumberOfHours(hourPerDay);
//		adc.enterCourseFee(courseFee);
//		adc.selectGradingPrefrences(gradingPreference);
//		Thread.sleep(3000);
//	//
//		adc.clickOnStampPaper_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(stampPaper);
//		Thread.sleep(3000);
//		adc.clickOnStampPaper_UploadFile();
//		Thread.sleep(3000);
//		adc.clickOnSubmit();
//		Thread.sleep(3000);
//		fbsc.clickOnAddedCourse();
//		Thread.sleep(3000);
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//span[text()='CREATED']")).getText(), "CREATED");
////		if(jobRole.equals("QP-NOS"))
////		{
////			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+jobRoleName+"']")).getText(), jobRoleName);
////			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+nsqfLevel+"']")).getText(), nsqfLevel);
////			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
////		}
////		else
////		{
////			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
////		}
//		LogOutPage plp = new LogOutPage(driver);
//		  
//		Thread.sleep(5000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//		
//	}
////it's working fine approve course	
//	@DataProvider
//	public Object[][] approveCourses()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", 
//				"CMAApproveCourseSC15TC07");
//	}
//
//	@Test(dataProvider="approveCourses")//,dependsOnMethods="addCourseTC09"
//	public void approveCourseTC10(String sno, String cmaUsername, String cmaPassword, String status, String tpID, 
//			String expectedSector,String expectedCourseName, String expectedJobRoleMappingType,
//			String expectedJobRoleName, String expectedNSQFLevel, String expectedCourseDescription, 
//			String expectedIssuedCertificateName, String expectedMinimumAge, String expectedMinimumEducation,
//			String expectedCourseDuration, String expectedNumberOfHours, String expectedCourseFee, 
//			String expectedGradingPrefrences, String qpNosCentre, String courseReviewComments, 
//			String courseComments)throws Exception
//	{
//		
//		precondition();
//	LaunchPage lp = new LaunchPage(driver);
//		Thread.sleep(3000);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(cmaUsername, cmaPassword);
//		CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
//		Thread.sleep(12000);
//		cmad.clickOnDashboard();
//		Thread.sleep(8000);
//		cmad.clickOnViewAllCourseAddRequest();
//		CMA_AddCourseRequestsPage cmac = new CMA_AddCourseRequestsPage(driver);
//		//cmac.selectStatus(status);
//		Thread.sleep(3000);
//		cmac.enterTPID(tpID);
//		Thread.sleep(3000);
//		cmac.clickOnApply();
//		Thread.sleep(3000);
//		List<WebElement> cou = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
//		int size2 = cou.size();
//		WebElement act = cou.get(size2-1);
//		act.click();
//		Thread.sleep(5000);
//		List<WebElement> crs = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
//		int size3 = crs.size();
//		WebElement tap = crs.get(size3-1);
////		JavascriptExecutor executor = (JavascriptExecutor)driver;
////		Thread.sleep(10000);
////		executor.executeScript("arguments[0].click();",tap );
//		
//		  tap.click();
//		CMA_CourseInfoPage cmci = new CMA_CourseInfoPage(driver);
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='course']")).getAttribute("value"), expectedCourseName);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedSector);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleMappingType']")).getAttribute("value").replace(" ", ""), expectedJobRoleMappingType.replace(" ", ""));
//		if(expectedJobRoleMappingType.equals("QP-NOS"))
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleName']")).getAttribute("value"), expectedJobRoleName);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
//
//		}
//		else
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value"), expectedCourseDescription);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumAge']")).getAttribute("value"), expectedMinimumAge);
//
//		}
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseDurationInHours']")).getAttribute("value"), expectedCourseDuration);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='hoursPerDay']")).getAttribute("value"), expectedNumberOfHours);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseFee']")).getAttribute("value"), expectedCourseFee);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='gradingPreferences']")).getAttribute("value"), expectedGradingPrefrences);
//		cmci.clickOnDownloadStampPaperWithSelfDeclaration();
//		Thread.sleep(3000);
//		cmci.selectQPNosAlignedCentre(qpNosCentre);
//		Thread.sleep(3000);
//		cmci.selectReviewComments(courseReviewComments);
//		cmci.enterComments(courseComments);
//		cmci.clickOnSubmitResponse();
//		Thread.sleep(7000);
//		cmac.enterTPID(tpID);
//		Thread.sleep(3000);
//		cmac.clickOnApply();
//		Thread.sleep(5000);
//		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedCourseName+"']]]]//span[text()='"+courseComments+"']")).getText(), courseComments);
//		
//		Thread.sleep(5000);
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//	}
////
//////
//	@DataProvider
//	public Object[][] linkTrainer()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
//				"TPFeeBasedLinkTrainerSC15TC08");
//	}
//
//	@Test(dataProvider="linkTrainer")//, dependsOnMethods="approveCourseTC10"
//	public void linkTrainerTC11(String sno, String tpUsername, String tpPassword, String projectName, 
//			String trainerSDMSID, String trainerName, String tcName,String StartDate,String EndDate, String supportingDocument, String mobileOTP,
//			String emailOTP, String trainersEmail, String trainersMobile)throws Exception
//	{
//		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpUsername, tpPassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(10000);
//		tpdp.clickOnMySchemes();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
//		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
//		Thread.sleep(5000);
//		fbd.clickOnViewTrainers();
//		TP_FeeBased_ViewAllTrainersPage vat = new TP_FeeBased_ViewAllTrainersPage(driver);
//		Thread.sleep(3000);
//		vat.clickOnLinkNewTrainer();
//		Thread.sleep(3000);
//		vat.enterTrainerSDMSID(trainerSDMSID);
//		Thread.sleep(3000);
//
//		vat.EnterAssociatedTrainingCentreName(tcName);
//		Thread.sleep(3000);
//		vat.ClickStartDate();
//		Thread.sleep(1000);
//		vat.SelectBatchStartDate(StartDate);
//		Thread.sleep(1000);
//		vat.ClickEndDate();
//		vat.SelectBatchEndDate(EndDate);
////		
//		Thread.sleep(3000);
//		vat.clickOnSupportingDocument_BrowseFileButton();
//		Thread.sleep(3000);
//		UploadFile.upload(supportingDocument);
//		Thread.sleep(3000);
//		vat.clickOnSuppoertingDocument_UploadFileButton();
//		Thread.sleep(3000);
//		trainerName = driver.findElement(By.xpath("//input[@placeholder='Enter Trainer Name']")).getAttribute("value");
//		Thread.sleep(3000);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC08", Integer.parseInt(sno), 5, trainerName);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC010", Integer.parseInt(sno), 16, trainerName);
//		Thread.sleep(5000);
//		vat.clickOnGenerateOTP();
//		Thread.sleep(3000);
//		vat.enterMobileOTP(mobileOTP);
//		vat.enterEmailOTP(emailOTP);
//		vat.clickOnVerifyOTP();
//		vat.clickOnOK();
//		//this is not checked
////s		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+trainerName+"']")).getText(), trainerName);
////		Thread.sleep(3000);
////		trainersEmail = driver.findElement(By.xpath("(//tr[td[text()='"+trainerName+"']]/td)[3]")).getText();
////		Thread.sleep(3000);
////		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC08", Integer.parseInt(sno), 10, trainersEmail);
////		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC010", Integer.parseInt(sno), 17, trainersEmail);
////		Thread.sleep(3000);
////		trainersMobile = driver.findElement(By.xpath("(//tr[td[text()='"+trainerName+"']]/td)[4]")).getText();
////		Thread.sleep(3000);
////		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC08", Integer.parseInt(sno), 11, trainersMobile);
////	s	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC010", Integer.parseInt(sno), 18, trainersMobile);
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//		
//	}

//
//	@DataProvider
//	public Object[][] addAssessmentAgencyAndLinkAssessor()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC09");
//	}
//
//	@Test(dataProvider="addAssessmentAgencyAndLinkAssessor")//, dependsOnMethods="linkTrainerTC11"
//	public void addAssessmentAgencyAndLinkAssessorTC12(String srno, String tpUsername, String tpPassword,
//			String projectName, String assessmentAgencyName, String supportingDocumentFile, 
//			String assessmentAgencyAddress, String landmark, String pincode, String state, String district, 
//			String tehsil, String parliamentryConstoituency, String geoLocation, String firstName, String lastName,
//			String email, String mobileNumber, String asseementAgencyID,  String assessorID, String assessorName, 
//			String assessmentAgency, String supportingDocument_Assessor, String mobileOTP, String emailOTP)throws Exception
//	{
//		precondition();
//	LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpUsername, tpPassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(20000);
//		tpdp.clickOnMySchemes();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
//		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
//		Thread.sleep(5000);
//		fbd.clickOnViewAssessmentAgencyAndAssessors();
//		TP_FeeBased_AssessmentAgencyAndAssessorPage tpaa = new TP_FeeBased_AssessmentAgencyAndAssessorPage(driver);
//		Thread.sleep(3000);
//		tpaa.clickOnAddAssessmentAgency();
//		TP_FeeBased_AssessmentAgencyInfoPage aai = new TP_FeeBased_AssessmentAgencyInfoPage(driver);
//		Thread.sleep(3000);
//		aai.enterAssessmentAgencyName(assessmentAgencyName);
//		aai.enterStartDate();
//		aai.enterEndDate();
//		aai.clickOnSupportingDocument_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(supportingDocumentFile);
//		Thread.sleep(3000);
//		aai.clickOnSupportingDocument_UploadButton();
//		Thread.sleep(3000);
//		aai.enterAddressOfAssessmentAgency(assessmentAgencyAddress);
//		aai.enterNearByLandmark(landmark);
//		aai.enterPincode(pincode);
//		aai.selectState(state);
//		aai.selectDistrict(district);
//		aai.selectTehsilOrBlock(tehsil);
//		aai.selectParliamentryConstituency(parliamentryConstoituency);
//		Thread.sleep(2000);
//		aai.enterGeoLocation(geoLocation);
//		Thread.sleep(3000);
//		aai.enterFirstNameOfSPOC(firstName);
//		aai.enterLastNameOfSPOC(lastName);
//		aai.enterEmailAddressOfSPOC(email);
//		aai.enterMobileNumberOfSPOC(mobileNumber);
//		aai.clickOnSubmit();
//		aai.ClickOnOKbutton();
//		
//		
//		
//		
//		
//		
//		
//		
////		asseementAgencyID = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().replace("Assessment Agency ", "").replace(" successfully added.", "");
////		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC09", Integer.parseInt(srno), 18, asseementAgencyID);
////		aai.clickOnOK();
//		Thread.sleep(3000);
//		tpaa.clickOnLinkAssessor();
//		Thread.sleep(3000);
//		tpaa.enterAssessorSDMSID(assessorID);
//		Thread.sleep(3000);
//		tpaa.selectAssessmentAgencyAligned(assessmentAgency);
//		tpaa.clickOnStartDateForValidity();
//		tpaa.clickOnEndDateForValidity();
//		Thread.sleep(3000);
//		tpaa.clickOnSupportingDocument_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(supportingDocument_Assessor);
//		Thread.sleep(3000);
//		tpaa.clickOnSupportingDocument_UploadFile();
//		Thread.sleep(5000);
//		assessorName = driver.findElement(By.xpath("//input[@id='nameOfAssessor']")).getAttribute("value");
//		Thread.sleep(3000);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC09", Integer.parseInt(srno), 20, assessorName);
//		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC010", Integer.parseInt(srno), 33, assessorName);
//		Thread.sleep(5000);
//		tpaa.clickOnGenerateOTP();
//		Thread.sleep(3000);
//		tpaa.enterMobileOTP(mobileOTP);
//		tpaa.enterEmailOTP(emailOTP);
//		tpaa.clickOnVerifyOTP();
//		Thread.sleep(3000);
//		tpaa.clickOnOK();
//		LogOutPage plp = new LogOutPage(driver);
//		
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout();
//		
//		
//	}
////	
//	
////create batch also working fine	    
//	@DataProvider
//	public Object[][] createBatchAndEnrollCandidates()
//	{
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", 
//				"CreateBatch&EnrollCandSC15TC010");
//	}
//
//	@Test(dataProvider="createBatchAndEnrollCandidates")//, dependsOnMethods="addAssessmentAgencyAndLinkAssessorTC12", enabled=false
//	public void createBatchAndEnrollCandidateTC13(String sno, String tpUsername, String tpPassword, 
//			String candidateRegistrationFile, String pageNo, String projectName, String tcid ,String tcName, String sector,
//			String course, String target, String batchName,  String batchType,String batchSize,String Skillingcategory, String courseName, 
//			String expectedSector, String expectedAssociatedQP, String expectedNSQFLevel, String trainerName,
//			String expectedTrainersEmail, String expectedTrainersMobile, String assessmentMode, String trainingFee, 
//			String feePaidBy, String batchID, String firstStage, String candidateList, String secondStage, 
//			String sscUsername, String sscPassword, String sectorCode, String assessmentAgency, String aaPassword, 
//			String remarksForAcceptingBatch, String assessorID, String asPassword, String assessmentAgencyID, 
//			String assessor, String thirdStage, String fourthStage, String certificateFile, String placementDocument,
//			String appointmentLetter, String salarySlip, String undertakingDocument) throws Exception
//	{
//		precondition();
//	   LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//    	Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpUsername, tpPassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//////b
//		
//		Thread.sleep(10000);
//		tpdp.clickOnMySchemes();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();		
//		TP_FeeBased_DashboardPage tpfb = new TP_FeeBased_DashboardPage(driver);
//		Thread.sleep(3000);
//		tpfb.clickOnViewTrainingCentres();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcid+"']]]]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcid+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcid+"']]]]//a[contains(text(),'View Details')]")).click();
//		TP_FeeBased_CreateBatchAddSectorTargetPage cbas = new TP_FeeBased_CreateBatchAddSectorTargetPage(driver);
//		Thread.sleep(5000);
//	   cbas.clickOnAddSectorTargets();
//		Thread.sleep(3000);
//		cbas.selectSector(sector);
//		cbas.selectCourse(course);
//		cbas.enterTarget(target);
//		cbas.clickOnSubmit();
//		Thread.sleep(5000);
//		cbas.clickOnAssignedSectorTargets();
//		Thread.sleep(3000);
//		//Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+sector+"']")).getText(), sector);
//		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//td[text()='"+course+"']")).getText(), course);
//		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//td[text()='"+target+"']")).getText(), target);
//		
//		cbas.clickOnCreateBatch();
//		TP_FeeBased_BatchDetailsPage fbd = new TP_FeeBased_BatchDetailsPage(driver);
//		Thread.sleep(10000);
//		fbd.enterBatchName(batchName);
//		Thread.sleep(3000);
//		fbd.clickOnStartDate_BatchDuration();
//		fbd.clickOnEndDate_BatchDuration();
//		Thread.sleep(5000);
//		fbd.selectBatchType(batchType);
//		Thread.sleep(3000);
//		fbd.enterBatchSize(batchSize);
//		Thread.sleep(3000);
//		fbd.SelectSkillingcategory(Skillingcategory);
//		
//		Thread.sleep(2000);
//		
//		fbd.selectCourseName(courseName);
//		Thread.sleep(3000);
//		
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Sector']")).getAttribute("value"), expectedSector);
////		//Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='qpCode']")).getAttribute("value"), expectedAssociatedQP);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
////		Thread.sleep(3000);
//		fbd.selectTrainerName(trainerName);
////		Thread.sleep(3000);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).getAttribute("value"), expectedTrainersEmail);
////		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).getAttribute("value"), expectedTrainersMobile);
////		fbd.clickOnStartDate_TrainingDuration();
////		fbd.clickOnEndDate_TrainingDuration();
//		Thread.sleep(2000);
//		fbd.clickOnStartDate_AssessmentDuration();
//		fbd.clickOnEndDate_AssessmentDuration();
//		Thread.sleep(3000);
//		fbd.selectAssessmentMode(assessmentMode);
//		fbd.enterTrainingFee(trainingFee);
//		Thread.sleep(3000);
//		fbd.selectFeePaidBy(feePaidBy);
//		Thread.sleep(3000);
//		fbd.clickOnSaveAndSubmitBatch();
//		Thread.sleep(3000);
//		fbd.clickOnYesCreateBatch();
//		Thread.sleep(3000);
//		batchID = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().replace("Batch ID - ", "");
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC010", Integer.parseInt(sno), 23, batchID);
//		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "GenerateCertificationSC15TC011", Integer.parseInt(sno), 5, batchID);
//		fbd.clickOnEnrollCandidates();
//		TP_FeeBased_EnrollCandidatesPage fec = new TP_FeeBased_EnrollCandidatesPage(driver);
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-badge m-badge--info m-badge--wide status-badge']")).getText(), "Enroll Candidates");
//		
//		
////	s	driver.findElement(By.xpath("(//a[i[@class='la la-ellipsis-h']])[1]")).click();
////		
////		driver.findElement(By.xpath("(//a[text()=' View Batch Details'])[1]")).click();
////	s	
//		Thread.sleep(3000);
//		fec.selectStage(firstStage);
//		Thread.sleep(3000);
//		fec.clickOnUploadCandidateList();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
//		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "Candidate Enrollment");
//		Thread.sleep(3000);
//		fec.clickOnCandidateList_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(candidateList);
//		Thread.sleep(3000);
//		fec.clickOnSubmit();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-badge m-badge--info m-badge--wide status-badge']")).getText(), "Enroll Candidates");
//		
////	s	Thread.sleep(8000);
////		fec.clickOnReUploadCandidateList();
////		Thread.sleep(3000);
////		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
////		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "enrollment");
////		fec.clickOnSubmit();
////		Thread.sleep(3000);
////		fec.clickOnEnrollCandidates();
////		Thread.sleep(8000);
////	s	Assert.assertEquals(driver.findElement(By.xpath("//span[text()='attendance']")).getText(), "Attendance");
//		
//		Thread.sleep(5000);
//		fec.selectStage(secondStage);
//		Thread.sleep(3000);
//		fec.clickOnUploadDetails();
//		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
//		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "attendance");
//		Thread.sleep(3000);
//		fec.clickOnCandidateList_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(candidateList);
//		Thread.sleep(3000);
//		fec.clickOnSubmit();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='assessment']")).getText(), "Assessment");
//		
//		Thread.sleep(4000);
//		fec.clickOnSubmitForAssessment();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[2]")).getAttribute("value"), batchID);
//		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[2]")).getAttribute("value"), "assessment");
//		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='assessmentMode']")).getAttribute("value"), assessmentMode);
//	if(assessmentMode.equals("SSC"))
//		{
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='sector']")).getAttribute("value"), expectedSector);
//			Thread.sleep(3000);
//			fec.clickOnSubmit_AssessmentDetails();
//			LogOutPage plp = new LogOutPage(driver);
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout();
//	
//			
//			
//			
//			
//			
//			lp.clickLogin();
//			bsp.clickToClose();
//			elp.performlogin(sscUsername, sscPassword);
//			SSC_DashboardPage ssc = new SSC_DashboardPage(driver);
//			Thread.sleep(5000);
//			ssc.clickOnAssessmentsAndCertification();
//			SSC_AssessmentsAndCertification_DashboardPage sac = new SSC_AssessmentsAndCertification_DashboardPage(driver);
//			Thread.sleep(3000);
//			sac.clickOnAssessmentsButton();
//			SSC_AssessmentsAndCertifications_ViewAllBatchesPage svb = new SSC_AssessmentsAndCertifications_ViewAllBatchesPage(driver);
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+batchID+"']]]]//span[contains(text(),'"+sectorCode+"')]")).getText().substring(0, 3), sectorCode);
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+batchID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+batchID+"']]]]//a[contains(text(),'Accept')]")).click();
//			Thread.sleep(3000);
//			svb.clickOnAssessment_StartDate();
//			svb.clickOnAssessment_EndDate();
//			Thread.sleep(3000);
//			svb.clickOnSubmit();
//			Thread.sleep(3000);
//			svb.clickOnOK();
//			Thread.sleep(3000);
//			svb.clickOnAccepted();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+batchID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			driver.findElement(By.xpath("//tr[td[span[span[text()='"+batchID+"']]]]//a[contains(text(),'Assign Assessment Agency')]")).click();
//			svb.selectAssessmentAgency(assessmentAgency);
//			svb.clickOnSubmit_ApproveMarksheet();
//			Thread.sleep(5000);
//			svb.clickOnOK();
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout();
//			lp.clickLogin();
//			elp.performlogin(assessmentAgencyID, aaPassword);
//			AssessmentAgencyDashboardPage aad = new AssessmentAgencyDashboardPage(driver);
//			Thread.sleep(3000);
//			aad.clickOnAssessmentRequest();
//			AssessmentAgencyViewBatchesPage avb = new AssessmentAgencyViewBatchesPage(driver);
//			Thread.sleep(3000);
//			avb.enterBatchIdToSearch(batchID);
//			Thread.sleep(3000);
//			avb.clickToApplySelectedSearchFilters();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn ellipsis-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Accept Batch')]")).click();
////			Thread.sleep(3000);
////			avb.clickToAcceptBatch();
////			avb.clickToSaveAndSubmit();
//			Thread.sleep(3000);
//			avb.enterRemarksForAcceptingBatch(remarksForAcceptingBatch);
//			Thread.sleep(3000);
//			avb.clickToSubmitBatchAcceptance();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Request Accepted Successfully')]")).getText(), "Request Accepted Successfully");
//			Assert.assertEquals(driver.findElement(By.xpath("//b[text()='BatchId - "+batchID+"']")).getText(), "BatchId - "+batchID+"");
//			Thread.sleep(3000);
//			avb.clickOk();
//			Thread.sleep(3000);
//			avb.clickToViewAcceptedBatches();
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn ellipsis-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Assign Assessor')]")).click();
//			Thread.sleep(3000);
//			avb.selectMasterAssessorForDomain1(assessorID);
//			Thread.sleep(2000);
//			avb.clickOnSubmit_ForAssessor();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'Assigned Successfully')]")).getText(), "Assigned Successfully");
//			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),' You have successfully assigned Assessor for the')]//b")).getText(), batchName);
//			Thread.sleep(3000);
//			avb.clickOk();
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout();
//			/*lp.clickLogin();
//			elp.performlogin(assessorID, asPassword);
//			AssessorDashboardPage adp = new AssessorDashboardPage(driver);
//			Thread.sleep(5000);
//			adp.clickToGetTrainerDashboard();
//			Thread.sleep(5000);
//			adp.clickViewBatches();
//			AssessorViewBatchesPage asvb = new AssessorViewBatchesPage(driver);
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Accept/Reject Batch')]")).click();
//			Thread.sleep(3000);
//			asvb.clickToAcceptBatch();
//			asvb.clickToSaveAndSubmit();
//			Thread.sleep(3000);
//			asvb.clickOk();
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout();*/
//			
//		}
//		else
//		{
//			Thread.sleep(3000);
//			//fec.selectAssessmentAgencyName(assessmentAgency);
//			fec.selectAssessor(assessor);
//			Thread.sleep(3000);
//			fec.clickOnSubmit_AssessmentDetails();
//			Thread.sleep(3000);
//			fec.selectStage(thirdStage);
//			Thread.sleep(3000);
//			fec.clickOnUploadDetails();
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchId']")).getAttribute("value"), batchID);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='stage']")).getAttribute("value"), "Assessment & Certification Details");
//			Thread.sleep(3000);
//			fec.clickOnCandidateList_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(candidateList);
//			Thread.sleep(3000);
//			fec.clickOnSubmit();
//			//Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Placement']")).getText(), "Placement");
//			Thread.sleep(3000);
//			fec.selectStage(fourthStage);
//			Thread.sleep(3000);
//			fec.clickOnUploadCandidateList();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "Placement Details");
//			Thread.sleep(3000);
//			fec.clickOnCandidateList_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(candidateList);
//			Thread.sleep(3000);
//			fec.clickOnSubmit();
//			Thread.sleep(10000);
//
//			Thread.sleep(3000);
//			fec.clickOnAction_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUploadPlacementDocument_FirstCandidate();
////			Thread.sleep(3000);
////			fec.clickOnPlacementDocument_BrowseFile();
////			Thread.sleep(3000);
////			UploadFile.upload(placementDocument);
////			Thread.sleep(5000);
////			fec.clickOnPlacementDocument_UploadFile();
////			Thread.sleep(3000);
////			fec.clickOnAppointmentLetter_BrowseFile();
////			Thread.sleep(3000);
////			UploadFile.upload(appointmentLetter);
////			Thread.sleep(5000);
////			fec.clickOnAppointmentLetter_UploadFile();
////			Thread.sleep(3000);
////			fec.clickOnSalarySlip_BrowseFile();
////			Thread.sleep(3000);
////			UploadFile.upload(salarySlip);
////			Thread.sleep(5000);
////			fec.clickOnSalarySlip_UploadFile();
//			Thread.sleep(3000);
//			fec.clickOnUndertakingDocument_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(undertakingDocument);
//			Thread.sleep(3000);
//			fec.clickOnUndertakingDocument_UploadFile();
//			Thread.sleep(3000);
//			fec.clickOnSubmit_PlacementDocument();
//			Thread.sleep(3000);
//			fec.clickOnUploadCandidateList();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "First Placement Tracking Status");
//			Thread.sleep(3000);
//			
//			
//			fec.clickOnCandidateList_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(candidateList);
//			Thread.sleep(3000);
//			fec.clickOnSubmit();
//			Thread.sleep(3000);
//			fec.clickOnAction_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUploadPlacementDocument_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUndertakingDocument_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(undertakingDocument);
//			Thread.sleep(3000);
//			fec.clickOnUndertakingDocument_UploadFile();
//			Thread.sleep(3000);
//			fec.clickOnSubmit_PlacementDocument();
//			Thread.sleep(3000);
//			fec.clickOnUploadCandidateList();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "Second Placement Tracking Status");
//			Thread.sleep(3000);
//			fec.clickOnCandidateList_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(candidateList);
//			Thread.sleep(3000);
//			fec.clickOnSubmit();
//			Thread.sleep(3000);
//			fec.clickOnAction_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUploadPlacementDocument_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUndertakingDocument_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(undertakingDocument);
//			Thread.sleep(3000);
//			fec.clickOnUndertakingDocument_UploadFile();
//			Thread.sleep(3000);
//			fec.clickOnSubmit_PlacementDocument();
//			Thread.sleep(3000);
//			fec.clickOnUploadCandidateList();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
//			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "Third Placement Tracking Status");
//			Thread.sleep(3000);
//			fec.clickOnCandidateList_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(candidateList);
//			Thread.sleep(3000);
//			fec.clickOnSubmit();
//			Thread.sleep(3000);
//			fec.clickOnAction_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUploadPlacementDocument_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUndertakingDocument_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(undertakingDocument);
//			Thread.sleep(3000);
//			fec.clickOnPlacementDocument_UploadFile();
//			Thread.sleep(3000);
//			fec.clickOnSubmit_PlacementDocument();
//			
//			fec.clickOnAction_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnUploadCertificate_FirstCandidate();
//			Thread.sleep(3000);
//			fec.clickOnCertificate_BrowseFile();
//			Thread.sleep(3000);
//			UploadFile.upload(certificateFile);
//			Thread.sleep(8000);
//			fec.clickOnCertificate_UploadFile();
//			Thread.sleep(3000);
//			fec.clickOnSubmit_CandidateCertificate();
//			
//			JavascriptExecutor jvs = (JavascriptExecutor) driver;
//			jvs.executeScript("scroll(900,0)");
//			Thread.sleep(10000);
//			fec.clickOnBack();
//			Thread.sleep(3000);
//			fec.clickOnBack();
//			Thread.sleep(3000);
//			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchID+"']")).getText(), batchID);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+batchName+"']")).getText(), batchName);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+courseName+"']")).getText(), courseName);
//			//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+expectedAssociatedQP+"']")).getText(), expectedAssociatedQP);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[text()='"+batchSize+"']")).getText(), batchSize);
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[span[text()='completed']]")).getText(), "Completed");
//			Thread.sleep(3000);		
//			LogOutPage plp = new LogOutPage(driver);
//			Thread.sleep(3000);
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout();
//			
//		}
//		

	}


	


	
	






