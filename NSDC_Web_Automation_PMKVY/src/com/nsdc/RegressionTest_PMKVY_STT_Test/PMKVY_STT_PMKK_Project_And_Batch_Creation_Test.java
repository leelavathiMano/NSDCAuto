package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.AddTrainingCenterPage;
import com.nsdc.Pages_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_STTPMUpage;
import com.nsdc.Pages_PMKVY_Pages.STTPMKVY_TC_DashBoard;
import com.nsdc.Pages_PMKVY_Pages.STTPMU_All_TP_ProjectimplementingAgencyPage;
import com.nsdc.Pages_PMKVY_Pages.STTPMU_Pending_ViewDetailsPage;
import com.nsdc.Pages_PMKVY_Pages.STT_AddProject;
import com.nsdc.Pages_PMKVY_Pages.STT_BatchDetailPage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.testConfig.TestConfiguration;

public class PMKVY_STT_PMKK_Project_And_Batch_Creation_Test extends TestConfiguration {

	@DataProvider
	public Object[][] projectAndBatchCreation() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
				"ProjectAndBatchCreation");
	}

	@Test(dataProvider = "projectAndBatchCreation")
	public void Project_And_Batch_Creation(String srno, String userType, String name, String ProjectProposalID,
			String ProjecName, String aggrementDate, String StartDate, String EndDate, String TC_ID,
			String TargetValueInNum, String TargetValidityInNum, String SectorName, String JobRoleName,
			String TargetValue, String TargetValidityInNumInMonths, String FiletoUpload, String PUM_UserID,
			String PMU_Password, String Comments, String CommentsTextArea, String TC_Password, String BatchSize, 
			String AssociatedQP_JobRole, String TrainingHoursPerHour, String BatchInTiming, String BatchOutTiming
			,String BatchStartDate, String BatchEndDate, String Classroom,String Trainer,String AssesmentDate) throws Exception {

		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin(); //
		
		/*
		 * Thread.sleep(3000); BetaVersionOfSmartPage bsp = new
		 * BetaVersionOfSmartPage(driver); bsp.clickToClose(); // Thread.sleep(3000);
		 * EnterLoginPage elp = new EnterLoginPage(driver); elp.performlogin(userType,
		 * name); DashboardPage db = new DashboardPage(driver);
		 * db.ClickMySchemeOrPrograms(); MySchemeOrProjectPage msp = new
		 * MySchemeOrProjectPage(driver); msp.ClickApplySchemeProgram();
		 * SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
		 * ssp.ClickPageNumber4(); ssp.Click_STT_Actionbutton();
		 * ssp.ClickOn_STT_AddProject(); STT_AddProject ap = new STT_AddProject(driver);
		 * ap.EnterTheProjectProposalID(ProjectProposalID); // //
		 * ap.EnterTheProjecName(ProjecName); ap.ClickProjectType();
		 * ap.ClickAggrementDate(); ap.SelectAggrementDate(aggrementDate);
		 * ap.ClickStartDate(); ap.SelectProjectDurationStartDate(StartDate);
		 * ap.ClickEndDate(); ap.SelectProjectDurationEndDate(EndDate);
		 * ap.ClickAddButton(); AddTrainingCenterPage adc = new
		 * AddTrainingCenterPage(driver); adc.SelectTC_FromAddCustomerTable(srno);
		 * adc.ClickOnSaveChanges(); ap.EnterTargetValue(TargetValueInNum);
		 * ap.SelectTargetValidity(TargetValidityInNum); ap.SelectSector(SectorName);
		 * ap.SelectJobRoleName(JobRoleName); Thread.sleep(2000);
		 * ap.EnterTargetValueAgain(TargetValue);
		 * ap.SelectTargetValidityInMonths(TargetValidityInNumInMonths);
		 * 
		 * Thread.sleep(3000); ap.ClickSignedTermSheetBrowseBtn();
		 * UploadFile.upload(FiletoUpload); ap.ClickSignedTermSheetUploadBtn();
		 * 
		 * ap.ClickSignedAgreementBrowseBtn(); UploadFile.upload(FiletoUpload);
		 * ap.ClickSignedAgreementUploadBtn();
		 * 
		 * ap.ClickOtherSupportingBrowseBtn(); UploadFile.upload(FiletoUpload);
		 * ap.ClickOtherSupportingUploadBtn(); ap.ClickSectorAddButton();
		 * ap.ClickSaveAndSubmitBtn();
		 * 
		 * LogOutPage plp = new LogOutPage(driver); plp.clickOnProfileLogo();
		 * plp.clickOnLogout();
		 * 
		 * // Moving to PMU to approve the created project
		 * 
		 * lp.clickLogin(); // //BetaVersionOfSmartPage bsp = new
		 * BetaVersionOfSmartPage(driver);
		 * 
		 * bsp.clickToClose(); // lp.clickLogin();
		 * 
		 * //EnterLoginPage elp = new EnterLoginPage(driver);
		 * elp.performlogin(PUM_UserID, PMU_Password); PMKVY_STTPMUpage sttpmu = new
		 * PMKVY_STTPMUpage(driver); sttpmu.ClickOnViewAllSchemeAddRequests();
		 * STTPMU_All_TP_ProjectimplementingAgencyPage allTP = new
		 * STTPMU_All_TP_ProjectimplementingAgencyPage(driver);
		 * allTP.SelectAllTrainingPartnerTable(ProjectProposalID, srno);
		 * allTP.ClickOnViewDetails(); STTPMU_Pending_ViewDetailsPage SttpmuViewDet =
		 * new STTPMU_Pending_ViewDetailsPage(driver);
		 * SttpmuViewDet.SelectComments(Comments);
		 * SttpmuViewDet.EnterCommentsInTextArea(CommentsTextArea);
		 * SttpmuViewDet.ClickSubmitBtn();
		 */

		// LogOutPage plp = new LogOutPage(driver);
		// plp.clickOnProfileLogo();
		// plp.clickOnLogout();

		// Login with the TC which you had added
		
		  BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		  bsp.clickToClose(); 
		  // Thread.sleep(3000); 
		  EnterLoginPage elp = new  EnterLoginPage(driver); 
		  //lp.clickLogin(); 
		  elp.performlogin(TC_ID, PMU_Password); 
		  STTPMKVY_TC_DashBoard TCdb= new STTPMKVY_TC_DashBoard(driver);
		  TCdb.ClickMySchemeTab();
		  TCdb.SelectSchemeOfSTT(); 
		  TCdb.ClickOnViewDetails();
		  TCdb.SelectProjectIDThatsApproved(ProjectProposalID);
		  TCdb.ClickOnViewDetails();
		  TCdb.ClickViewAllBatches();
		  TCdb.ClickCreateBatchBtn();
		  STT_BatchDetailPage bdp=new STT_BatchDetailPage(driver);
		  bdp.EnterBatchSize(BatchSize);
		  bdp.SelectAssociatedQP(AssociatedQP_JobRole);
		  bdp.SelectTrainingHours(TrainingHoursPerHour);
		  bdp.TAB_FromTrainingHours();
		  bdp.EnterBatchInTime(BatchInTiming);
		  bdp.TAB_FromBatchUpTime();
		  bdp.EnterBatchOutTime(BatchOutTiming);
		  bdp.ClickAddBatchTiming();
		  bdp.ClickStartDate();
		  bdp.SelectBatchStartDate(BatchStartDate);
		 // bdp.ClickEndDate();
		 // bdp.SelectBatchEndDate(BatchEndDate);
		  bdp.SelectClassRoom(Classroom);
		  bdp.SelectTrainerName(Trainer);
		 // bdp.ClickAssessmentDate();
		 // bdp.SelectAssessemntDate(AssesmentDate);
		  bdp.ClickAssessmentLang();
		  bdp.ClickDisclaimer();
		  
		  
		// LogOutPage plp = new LogOutPage(driver);
		// plp.clickOnProfileLogo();
		// plp.clickOnLogout();

	}
}
