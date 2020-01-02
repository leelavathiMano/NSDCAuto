package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_PMKVY_Pages.ListofEligibleCandiatePage;
import com.nsdc.Pages_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMUpage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SP_ApprovalInprogress_Additionaldetails_Page;
import com.nsdc.Pages_PMKVY_Pages.Pmkvy_SpecialProjectCreationPage;
import com.nsdc.Pages_PMKVY_Pages.SPPMU_All_TP_ProjectimplementingAgencypage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_Batch_CreatePage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_DashBoardpage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_MyApprovedSchemeOrProgramPage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_ViewDetailsPage;
import com.nsdc.Pages_PMKVY_Pages.STTPMU_All_TP_ProjectimplementingAgencyPage;
import com.nsdc.Pages_PMKVY_Pages.STT_BatchDetailPage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.Pages_PMKVY_Pages.TP_SP_AdditionalRequiredPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMU_SelectedSchemepage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.TrainingCalenderPage;
import com.nsdc.generic.UploadFile;



import com.nsdc.testConfig.TestConfiguration;

public class PMKVY_SP_workflowTest extends TestConfiguration {
	@DataProvider
	public Object[][] CreateSpecialProjectData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
				"Sp-workflow-data");
	}

	@Test(dataProvider = "CreateSpecialProjectData")

	public void Addspecialprojectdata_01(String username, String password, String projectproposalID, String projectname,
			String registeredAs, String proposingorganisationName, String state, String district, String img1,
			String img2, String loginId, String password2, String agrementDate, String StartDate, String endDate,
			String Adhar, String TrainerCertified, String TypeofTrainingCentre, String PlacementsRequirement,
			String TypeOfEmployment, String MinimumPercentageplaced, String Disability, String Religion, String Gender,
			String Category, String DiscountsonBaseRate, String BatchDuration, String NumberofTranches,
			String Tranche3tobepaidwithoutPlacement, String DualLogoRequired, String TargetBeneficiaries,
			String numberofsectors, String Sector, String JobRole, String Target, String locationState,
			String locationDistrict, String jobrole1, String targetvalue1, String Jobrole2, String targetvalue2,
			String tcName, String tcTarget, String advanceTrancheYes, String advancepayment, String DualImg,
			String review, String SignedImg, String comments, String TCloginId, String TCpassword, String BatchSize,
			String AssociatedQP_JobRole, String tryingHours, String BatchInTiming, String batchoutTime,
			String batchStartDate, String trainerName, String language,String canState,String Candistric) throws Exception {

		precondition();
		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
      EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(username, password);
//		Thread.sleep(3000);
		DashboardPage db = new DashboardPage(driver);
//		db.ClickMySchemeOrPrograms();
//		MySchemeOrProjectPage msp = new MySchemeOrProjectPage(driver);
//		msp.ClickApplySchemeProgram();
		SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
//		Thread.sleep(3000);
//
//		ssp.ClickPageNumber3();
//
//		Thread.sleep(3000);
//		ssp.ClickOn_SP_Action();
//		ssp.ClickOn_SP_AddProject();
////
		Pmkvy_SpecialProjectCreationPage sp = new Pmkvy_SpecialProjectCreationPage(driver);
//		Thread.sleep(15000);
//		sp.EnterTheProjectProposalID(projectproposalID);
//		Thread.sleep(2000);
//		sp.EnterTheProjecName(projectname);
//		sp.ClickProjectType();
//		sp.selectRegisteredAslist(registeredAs);
//		sp.EnterProposingOrganisationName(proposingorganisationName);
//		String numberOfLocations=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", 1, 1);
//	 	int totalLocations=Integer.parseInt(numberOfLocations);
//		
//		for(int i=1;i<=totalLocations;i++)
//		{
//			String states=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", i, 2);
//		sp.selectState(states);
//		String districts =ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", i, 3);
//		sp.selectDistrict(districts);
//		Thread.sleep(3000);
//		sp.clickAdd();
//		}
////		sp.clickOnIndemnityBondBrowse();
////		Thread.sleep(3000);
////		UploadFile.upload(img1);
////		Thread.sleep(3000);
////
////		sp.clickOnIndemnityBondUploadButton();
////		Thread.sleep(3000);
////
//		 sp.clickOnOtherSupportingDocumentsBrowse();
//		Thread.sleep(3000);
//		 UploadFile.upload(img2); 
//		Thread.sleep(3000);
//
//		sp.clickOnOtherSupportingDocumentsUpload();
//		Thread.sleep(3000);
//		
//		sp.clickSaveAndSumbit();
//		Thread.sleep(3000);
//		
//		sp.ClickonOK();
//		Thread.sleep(3000);
//		sp.ClickonOK();
//    LogOutPage plp = new LogOutPage(driver);
//     Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		Thread.sleep(3000);
//		plp.clickOnLogout(); // //
//		Thread.sleep(3000);
//		lp.clickLogin();
//		bsp.clickToClose();
//		elp.performlogin(loginId, password2);
		PMKVY_SPPMUpage sppmu = new PMKVY_SPPMUpage(driver);
//		Thread.sleep(10000);
//		sppmu.ClickOnViewAllSchemeAddRequests();
//
//		STTPMU_All_TP_ProjectimplementingAgencyPage allPIA = new STTPMU_All_TP_ProjectimplementingAgencyPage(driver);
//		Thread.sleep(10000);
//		allPIA.ClickOnAction();
//		Thread.sleep(3000);
//		allPIA.ClickOnViewDetails();
//		PMKVY_SPPMU_SelectedSchemepage sssp = new PMKVY_SPPMU_SelectedSchemepage(driver);
//		Thread.sleep(3000);
//		sssp.ClickAggrementDate();
//		Thread.sleep(3000);
//		sssp.SelectAggrementDate(agrementDate);
//
//		sssp.ClickStartDate();
//		sssp.SelectProjectDurationStartDate(StartDate);
//
//		sssp.ClickEndDate();
//		
//		Thread.sleep(3000);
//		sssp.SelectProjectDurationEndDate(endDate);
//	
//		Thread.sleep(3000);
//		sssp.SelectAdharRequirmentYes(Adhar);
//		sssp.SelectTrainerCertifiedYes(TrainerCertified);
//		//sssp.SelectTypeofTrainingCentre(TypeofTrainingCentre);
//	//	sssp.SelectPlacementsRequirementYes(PlacementsRequirement);
//		sssp.SelectTypeOfEmployment(TypeOfEmployment);
//		sssp.EnterTheMinimumPercentageofCandidatedtobeplacedTextBox(MinimumPercentageplaced);
//		sssp.ClickPercentageAdd();
//		sssp.SelectDisability(Disability);
//		sssp.SelectReligion(Religion);
//		sssp.SelectGender(Gender);
//		sssp.SelectCategory(Category);
//		sssp.EnterTheDiscountsOnBaseRate(DiscountsonBaseRate);
//		sssp.EnterBatchDuration(BatchDuration);
//		sssp.SelectNumberOfTranches(NumberofTranches);
//		sssp.SelecttrancheThreeToBepaid(Tranche3tobepaidwithoutPlacement);
//		sssp.SelectDualLogoRequired(DualLogoRequired);
//		sssp.EnterTheTargetBeneficiaries(TargetBeneficiaries);
//		Thread.sleep(3000);
//		
//		sssp.ClickSaveAndSubmitButton();
//	    Thread.sleep(2000);
//	    sp.ClickonOK();
//		Thread.sleep(2000);
//		String Sno=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", 1, 0);
//	 	int totalSNo=Integer.parseInt(Sno);
//	 	
//		String numberOfSectors_jobroles=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", 1, 1);
//	 	int total_sectors_jobRoles=Integer.parseInt(numberOfSectors_jobroles);
//	 	
//		for(int i=1;i<=total_sectors_jobRoles;i++)
//		{
//			Thread.sleep(10000);
//			sssp.ClickOnAddSectorsAndjobRole();
//			Thread.sleep(2000);
//			
//			String Sectors=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 2);
//			String JobRoles=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 3);
//			sssp.SelectSector(Sectors);
//			Thread.sleep(1000);
//			sssp.SelectjobRoleName(JobRoles);
//			Thread.sleep(1000);
//			
//			 String Qpcode = driver.findElement(By.xpath("//input[@class='form-control m-input']")).getAttribute("value");
//			 ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow",  i, 4, Qpcode);
//			 
//			 
//			 
//			 String NSQfLevel = driver.findElement(By.xpath("//input[@placeholder='NSQF Level']")).getAttribute("value");
//			 ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow",  i, 5, NSQfLevel);
//			 
//			 String trainingHours = driver.findElement(By.xpath("//input[@formcontrolname='proposedHours']")).getAttribute("value");
//			 ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow",  i, 6, trainingHours);
//			
//			
//			
//			String Targets=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
//			Thread.sleep(2000);
//			sssp.EnterSectorAndJobTarget(Targets);
//			Thread.sleep(2000);
//			sssp.ClickOnSavebutton();
//			Thread.sleep(3000);
//		}
//		Thread.sleep(5000);
//		sssp.ClickOnSaveAndSubmit();
//		Thread.sleep(5000);
//		
//		
//		
//		for(int i=1;i<=total_sectors_jobRoles;i++)
//		{
//			Thread.sleep(10000);
//			driver.findElement(By.xpath("(//i[@class='la la-pencil pencil-icon'])["+i+"]")).click();
//			
//			
//		
//			String JobRoles=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 3);
//			String Targets=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
//			Thread.sleep(2000);
//			sssp.SelectjobRoleQPCode(JobRoles);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//input[@placeholder='Enter Target']")).sendKeys(Targets);
//			
//			Thread.sleep(2000);
//			sssp.ClickOnSavebutton();
//			Thread.sleep(3000);
//		
//		
//		}
//		
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[contains(text(),'Save &')]")).click();
//		Thread.sleep(2000);
//		   sp.ClickonOK();
//		Thread.sleep(2000);
//		sssp.ClickOnSaveAndSubmit();
//		Thread.sleep(2000);
//		
//		
//		
//		
//		sssp.SelectAdvanceTranche(advanceTrancheYes);
//
//				sssp.EnterpercentageOfAdvanceTextBox(advancepayment);
//		
//				sssp.ClickAmountTobeOfAdvance();
//				Thread.sleep(3000);
//				sssp.ClickAdvanceAdd();
//		
//				sssp.ClickSaveAndSubmitButton();
//				Thread.sleep(3000);
//				sp.ClickonOK();
//				Thread.sleep(2000);
//				sssp.ClickOnAction();
//				Thread.sleep(3000);
//				sssp.ClickOnViewGenerated_Termsheet();
//				
				LogOutPage plp = new LogOutPage(driver);
//			     Thread.sleep(3000);
//					plp.clickOnProfileLogo();
//					Thread.sleep(3000);
//					plp.clickOnLogout(); 
//					Thread.sleep(3000);
				
		
			////////////
					lp.clickLogin();
					bsp.clickToClose();
					elp.performlogin(username, password);
					db.ClickMySchemeOrPrograms();
					Thread.sleep(3000);
					db.ClickOnApprovalInProgress();
					
					ssp.ClickApprovalInProgress_SPAction();
					ssp.ClickApprovalInProgress_SP_ViewDetails();
					PMKVY_SP_ApprovalInprogress_Additionaldetails_Page addtionalpage = new PMKVY_SP_ApprovalInprogress_Additionaldetails_Page(
							driver);
					Thread.sleep(3000);
					addtionalpage.ClickOn_Action();
					addtionalpage.Click_AdditionalDetailsRequried_Action(); //
					//////// addtionalreqDetails //
					TP_SP_AdditionalRequiredPage addR = new TP_SP_AdditionalRequiredPage(driver);
					Thread.sleep(3000);
//					addR.ClickOnDual_logoBrowse();
//					Thread.sleep(3000);
//					UploadFile.upload(duallogoImg);
//					Thread.sleep(3000);
//					addR.ClickOnDual_logoUpLoad();
//					Thread.sleep(3000);
//					addR.ClickOnTPSigned_TermSheetBrowse();
//					Thread.sleep(3000);
//					UploadFile.upload(SignedImg);
//					Thread.sleep(3000);
//					addR.clickOnTPSigned_TermSheetUpLoad();
//					Thread.sleep(3000);
//					addR.SelectReview(review);
//					Thread.sleep(3000);
//					addR.ClickOnDownloadTermsheet();
					Thread.sleep(3000);
					addR.ClickSaveAndSubmit();
			         Thread.sleep(3000);
			  	   sp.ClickonOK();
					
					plp.clickOnProfileLogo();
					plp.clickOnLogout(); 
					///
					lp.clickLogin();
					Thread.sleep(3000);
					bsp.clickToClose();
					Thread.sleep(3000);
					elp.performlogin(loginId, password2);
					Thread.sleep(10000);
					sppmu.ClickOnViewAllSchemeAddRequests(); 
					Thread.sleep(5000);// //for Sp andSTT SAME PAGE ACTION BUTTON AND VIEW DETAILS
					SPPMU_All_TP_ProjectimplementingAgencypage iap = new SPPMU_All_TP_ProjectimplementingAgencypage(driver);
					Thread.sleep(5000);
			
					iap.ClickOnAction();
					iap.ClickOnViewDetails();
					/// FOR tP AND SPPMU BOTHADDTIONAL REQ SAME PAGE AND XPATH ALSO
					/// SAME(TP_SP_AdditionalRequiredPage)
					Thread.sleep(3000);
					addR.ClickOnOther_TermSheetBrowse();
					Thread.sleep(3000);
					UploadFile.upload(SignedImg);
					Thread.sleep(10000);
					addR.clickOnOther_TermSheetUpLoad();
					Thread.sleep(3000);
					
					addR.ClickOnSigned_TermSheetBrowse();
					Thread.sleep(10000);
					UploadFile.upload(SignedImg);
					Thread.sleep(10000);
					addR.clickOnSigned_TermSheetUpLoad();
					Thread.sleep(3000);
					
					
					addR.SelectComments(comments);
					addR.ClickSaveAndSubmit();
					Thread.sleep(10000);
					
					 Thread.sleep(3000); 
						plp.clickOnProfileLogo();
						plp.clickOnLogout();
					
					
					
				
		
//		sssp.SelectSector(Sector);
//		sssp.SelectjobRoleName(JobRole);
//		Thread.sleep(3000);
//		sssp.EnterSectorAndJobTarget(Target);
//		Thread.sleep(3000);
//		sssp.ClickOnSectorAndJobRoleAdd();
//
//		// sssp.SelectlocationState(locationState);
//		// sssp.Selectlocationdistrict(locationDistrict);
//		// sssp.ClicklocationAddButton();
//		sssp.SelectJobRoleTargetDistribution1(jobrole1);
//
//		sssp.EnterTargetDistribution1(targetvalue1);
//		sssp.SelectTCName(tcName);
//		sssp.EnterTcTarget(tcTarget);
//
//		sssp.ClickAddTcTargetButton(); //
//		// sssp.SelectJobRoleTargetDistribution2(Jobrole2);
//		// sssp.EnterTargetDistribution2(targetvalue2);
//		sssp.SelectAdvanceTranche(advanceTrancheYes);
//
//		sssp.EnterpercentageOfAdvanceTextBox(advancepayment);
//
//		sssp.ClickAmountTobeOfAdvance();
//		Thread.sleep(3000);
//		sssp.ClickAdvanceAdd();
//
//		sssp.ClickSaveAndSubmitButton();
//		Thread.sleep(3000);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout(); // // ///////////////////
//		lp.clickLogin();
//		bsp.clickToClose();
//		elp.performlogin(username, password);
//		db.ClickMySchemeOrPrograms();
//		ssp.ClickApprovalInProgress_SPAction();
//		ssp.ClickApprovalInProgress_SP_ViewDetails();
//		PMKVY_SP_ApprovalInprogress_Additionaldetails_Page addtionalpage = new PMKVY_SP_ApprovalInprogress_Additionaldetails_Page(
//				driver);
//		Thread.sleep(3000);
//		addtionalpage.ClickOn_Action();
//		addtionalpage.Click_AdditionalDetailsRequried_Action(); //
//		//////// addtionalreqDetails //
//		TP_SP_AdditionalRequiredPage addR = new TP_SP_AdditionalRequiredPage(driver);
//		Thread.sleep(3000);
////		addR.ClickOnDual_logoBrowse();
////		Thread.sleep(3000);
////		UploadFile.upload(duallogoImg);
////		Thread.sleep(3000);
////		addR.ClickOnDual_logoUpLoad();
////		Thread.sleep(3000);
//		addR.ClickOnTPSigned_TermSheetBrowse();
//		Thread.sleep(3000);
//		UploadFile.upload(SignedImg);
//		Thread.sleep(3000);
//		addR.clickOnTPSigned_TermSheetUpLoad();
//		Thread.sleep(3000);
//		addR.SelectReview(review);
//		Thread.sleep(3000);
//		addR.ClickOnDownloadTermsheet();
//		Thread.sleep(3000);
//		addR.ClickSaveAndSubmit();
//         Thread.sleep(10000);
//		// Thread.sleep(3000); 
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout(); 
//		///
//		lp.clickLogin();
//		Thread.sleep(3000);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		elp.performlogin(loginId, password2);
//		Thread.sleep(10000);
//		sppmu.ClickOnViewAllSchemeAddRequests(); 
//		Thread.sleep(5000);// //for Sp andSTT SAME PAGE ACTION BUTTON AND VIEW DETAILS
//		SPPMU_All_TP_ProjectimplementingAgencypage iap = new SPPMU_All_TP_ProjectimplementingAgencypage(driver);
//		Thread.sleep(5000);
//
//		iap.ClickOnAction();
//		iap.ClickOnViewDetails();
//		/// FOR tP AND SPPMU BOTHADDTIONAL REQ SAME PAGE AND XPATH ALSO
//		/// SAME(TP_SP_AdditionalRequiredPage)
//		Thread.sleep(3000);
//		addR.ClickOnOther_TermSheetBrowse();
//		Thread.sleep(3000);
//		UploadFile.upload(SignedImg);
//		Thread.sleep(10000);
//		addR.clickOnOther_TermSheetUpLoad();
//		Thread.sleep(3000);
//		
//		addR.ClickOnSigned_TermSheetBrowse();
//		Thread.sleep(10000);
//		UploadFile.upload(SignedImg);
//		Thread.sleep(10000);
//		addR.clickOnSigned_TermSheetUpLoad();
//		Thread.sleep(3000);
//		
//		
//		addR.SelectComments(comments);
//		addR.ClickSaveAndSubmit();
//		Thread.sleep(10000);
//		
//		 Thread.sleep(3000); 
//			plp.clickOnProfileLogo();
//			plp.clickOnLogout(); 
		
		
		
		
		//LaunchPage lp = new LaunchPage(driver);

//		lp.clickLogin();
//		Thread.sleep(3000);
		//BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
		//EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(TCloginId, TCpassword);
//
//		SP_TC_DashBoardpage tcd = new SP_TC_DashBoardpage(driver);
//        Thread.sleep(2000);
//		tcd.ClickOnMyScheme();
//		Thread.sleep(2000);
//		tcd.ClickOnViewScheme();
//		SP_TC_MyApprovedSchemeOrProgramPage spApp = new SP_TC_MyApprovedSchemeOrProgramPage(driver);
//
//		spApp.ClickOnSPAction();
//		spApp.CLickOnViewDetails();
//
//		SP_TC_ViewDetailsPage pst = new SP_TC_ViewDetailsPage(driver);
//		pst.ClickOnSPAction();
//		Thread.sleep(3000);
//		pst.CLickOnViewDetails();
//		Thread.sleep(3000);
//		pst.ClickOnView_All_Batches();
//		Thread.sleep(7000);
//		pst.ClickOnCreateBatch();
//		Thread.sleep(3000);
//		SP_TC_Batch_CreatePage tcbc = new SP_TC_Batch_CreatePage(driver);
//		Thread.sleep(2000);
//		tcbc.EnterBatchSize(BatchSize);
//		Thread.sleep(2000);
//		tcbc.SelectAssociatedQP(AssociatedQP_JobRole);
//		//
//		Thread.sleep(2000);
//		tcbc.EnterTrainingHours(tryingHours);
//		Thread.sleep(2000);
//		tcbc.TAB_FromTrainingHours();
//		Thread.sleep(2000);
//		tcbc.ClickTrainingHours();
//	    tcbc.TAB_FromTrainingHours();
//	    
//	    tcbc.BatchinTimeSelect(BatchInTiming);
//	    tcbc.BatchoutTimeSelect(batchoutTime);
//	    
	    
//		 tcbc.EnterBatchInTime(BatchInTiming);
//		tcbc.TAB_FromBatchUpTime();
//		 tcbc.EnterBatchOutTime(batchoutTime);
		
		
		
		
//		tcbc.ClickAddBatchTiming(); 
//		 Thread.sleep(1000); 
//		 tcbc.ClickStartDate();
//		 tcbc.SelectBatchStartDate(batchStartDate);
//		 tcbc.ClickEndDate(); 
//		 //tcbc.SelectBatchEndDate(batchEndDate);
//		tcbc.SelectTrainerName(trainerName);
//		tcbc.SelectAssessmentLanguage(language);
//		 tcbc.ClickDisclaimer(); 
//		tcbc.ClickOnSaveAndNext();
//		tcbc.ClickOnOKButton();
       
	
	
	
//	
//		Thread.sleep(3000);
//	TrainingCalenderPage tcp = new TrainingCalenderPage(driver);
//		//tcp.ClickThreeDots();
//		String SP="Other Holiday";
//		Thread.sleep(3000);
//		tcp.ClickDayAndDate();
//		Thread.sleep(3000);
//		tcp.SelectDayAndDate(DayAndDate);
//		Thread.sleep(3000);
//		tcp.SelectSessionPlanned(SessionPlan);
//		if(SessionPlan.equals(SP))
//		{
//		tcp.EnterDescription(Description);
//		}
//		else
//		{
//			tcp.SelectNOSTaught(NOSTaught);
//			tcp.TAB_FromNOSTaught();
//			tcp.EnterStartTime(StartTime);
//			Thread.sleep(3000);
//			tcp.TAB_BatchIntime();
//			tcp.EnterEndTime(EndTime);
//			tcp.EnterDescription(Description);
//		}
//		tcp.ClickAddSession();
	
	
	
//    	Thread.sleep(3000);
//		tcp.ClickSaveBtn();
//		Thread.sleep(3000);
//		tcp.ClickOnOKButton();
//		Thread.sleep(3000);
//		///////////////////////////////////////////
//		
//		
//		
//		
//		
//		ListofEligibleCandiatePage enrollcandite= new ListofEligibleCandiatePage(driver);
//		Thread.sleep(3000);
//		
//		
//		enrollcandite.SelectState(canState);
//		enrollcandite.Selectdistric(Candistric);
//		enrollcandite.ClickOnApply();
//		enrollcandite.ClickOnCandiateIdCheckBox();
//		String modelOfBandL="Self";
//		
//		
//		
//		String numCAN=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls","NumberOFenrollcandidates", 1, 0);
//	 	int numberOfcan =Integer.parseInt(numCAN);
//	 	for(int i=1;i<=numberOfcan;i++)	
//		{    
//	 		driver.findElement(By.xpath("//tbody//tr["+i+"]//td[13]//span")).click();
//	 		Thread.sleep(1000);
//	 	WebElement modeofBk = driver.findElement(By.xpath("(//select[@formcontrolname='modeOfBkl'])["+i+"]"));
//	 		  Select sel=new Select(modeofBk);
//	 				  sel.selectByVisibleText(modelOfBandL);
//	 				 Thread.sleep(1000);
//		
//		}
//	 	Thread.sleep(3000);
//	 	enrollcandite.ClickonEnrollCandidates();
//	 	Thread.sleep(3000);
//	 	enrollcandite.ClickonSubmitToEnrollcandidatesButton();
//	 	Thread.sleep(3000);
//	 	enrollcandite.ClickonYesButton();
//		Thread.sleep(3000);
//	 	enrollcandite.ClickOnOKButton();
//		Thread.sleep(3000);
//		enrollcandite.ClickOnSubmit_To_SSC();
//		Thread.sleep(3000);
//	 	enrollcandite.ClickOnOKButton();
//	 	
//	 	Thread.sleep(3000);
//	 	enrollcandite.ClickOnOKButton();
//	 	Thread.sleep(3000);
//	 	enrollcandite.ClickOnOKButton();
//
//	 	 Thread.sleep(3000); 
//	plp.clickOnProfileLogo();
//			plp.clickOnLogout(); 
	}


}
