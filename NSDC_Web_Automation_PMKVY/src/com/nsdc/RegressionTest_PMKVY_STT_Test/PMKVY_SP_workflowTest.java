package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
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
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.Pages_PMKVY_Pages.TP_SP_AdditionalRequiredPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMU_SelectedSchemepage;
import com.nsdc.generic.ReadMultipleDataFromExcel;

import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LaunchPage;
import com.nsdc.pages.LogOutPage;
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
			String tcName, String tcTarget, String advanceTrancheYes, String advancepayment, String duallogoImg,
			String review, String comments, String TCloginId, String TCpassword,
			String BatchSize,String AssociatedQP_JobRole,String tryingHours,String BatchInTiming,String batchoutTime,String batchStartDate
			,String trainerName,String language) throws Exception {

		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(username, password);
//		Thread.sleep(3000);
//		DashboardPage db = new DashboardPage(driver);
//		db.ClickMySchemeOrPrograms();
//		MySchemeOrProjectPage msp = new MySchemeOrProjectPage(driver);
//		msp.ClickApplySchemeProgram();
//		SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
//		Thread.sleep(3000);
//
//		ssp.ClickPageNumber3();
//
//		Thread.sleep(3000);
//		ssp.ClickOn_SP_Action();
//		ssp.ClickOn_SP_AddProject();
//
//		Pmkvy_SpecialProjectCreationPage sp = new Pmkvy_SpecialProjectCreationPage(driver);
//		Thread.sleep(2000);
//		sp.EnterTheProjectProposalID(projectproposalID);
//		Thread.sleep(2000);
//		sp.EnterTheProjecName(projectname);
//		sp.ClickProjectType();
//		sp.selectRegisteredAslist(registeredAs);
//		sp.EnterProposingOrganisationName(proposingorganisationName);
//		sp.selectState(state);
//		sp.selectDistrict(district);
//		Thread.sleep(3000);
//		sp.clickAdd();
//		sp.clickOnIndemnityBondBrowse();
//		Thread.sleep(3000);
//		UploadFile.upload(img1);
//		Thread.sleep(3000);
//
//		sp.clickOnIndemnityBondUploadButton();
//		Thread.sleep(3000);
//
//		// sp.clickOnOtherSupportingDocumentsBrowse(); //Thread.sleep(3000);
//		// UploadFile.upload(img2); //Thread.sleep(3000);
//
//		sp.clickOnOtherSupportingDocumentsUpload();
//		Thread.sleep(3000);
//		sp.clickSaveAndSumbit();
//		Thread.sleep(3000);
//		LogOutPage plp = new LogOutPage(driver);
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout(); // //
//		Thread.sleep(3000);
//		lp.clickLogin();
//		bsp.clickToClose();
//		elp.performlogin(loginId, password2);
//		PMKVY_SPPMUpage sppmu = new PMKVY_SPPMUpage(driver);
//		Thread.sleep(3000);
//		sppmu.ClickOnViewAllSchemeAddRequests();
//
//		STTPMU_All_TP_ProjectimplementingAgencyPage allPIA = new STTPMU_All_TP_ProjectimplementingAgencyPage(driver);
//		Thread.sleep(3000);
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
//		sssp.SelectProjectDurationEndDate(endDate);
//		Thread.sleep(3000);
//		sssp.SelectAdharRequirmentYes(Adhar);
//		sssp.SelectTrainerCertifiedYes(TrainerCertified);
//		sssp.SelectTypeofTrainingCentre(TypeofTrainingCentre);
//		sssp.SelectPlacementsRequirementYes(PlacementsRequirement);
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
//
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
//		addR.ClickOnDual_logoBrowse();
//		Thread.sleep(3000);
//		UploadFile.upload(duallogoImg);
//		Thread.sleep(3000);
//		addR.ClickOnDual_logoUpLoad();
//		Thread.sleep(3000);
//		addR.ClickSigned_TermSheetBrowse();
//		Thread.sleep(3000);
//		UploadFile.upload(img1);
//		Thread.sleep(3000);
//		addR.clickSigned_TermSheetUpLoad();
//		Thread.sleep(3000);
//		addR.SelectReview(review);
//		Thread.sleep(3000);
//		addR.ClickOnDownloadTermsheet();
//		Thread.sleep(3000);
//		addR.ClickSaveAndSubmit();
//
//		// Thread.sleep(3000); 
//		plp.clickOnProfileLogo();
//		plp.clickOnLogout(); ///
//		lp.clickLogin();
//		bsp.clickToClose();
//		elp.performlogin(loginId, password2);
//		Thread.sleep(3000);
//		sppmu.ClickOnViewAllSchemeAddRequests(); // //for Sp andSTT SAME PAGE ACTION BUTTON AND VIEW DETAILS
//		SPPMU_All_TP_ProjectimplementingAgencypage iap = new SPPMU_All_TP_ProjectimplementingAgencypage(driver);
//		Thread.sleep(3000);
//
//		iap.ClickOnAction();
//		iap.ClickOnViewDetails();
//		/// FOR tP AND SPPMU BOTHADDTIONAL REQ SAME PAGE AND XPATH ALSO
//		/// SAME(TP_SP_AdditionalRequiredPage)
//		Thread.sleep(3000);
//		addR.ClickSigned_TermSheetBrowse();
//		Thread.sleep(3000);
//		UploadFile.upload(img1);
//		Thread.sleep(3000);
//		addR.clickSigned_TermSheetUpLoad();
//		Thread.sleep(3000);
//		addR.SelectComments(comments);
//		addR.ClickSaveAndSubmit();
//		
//		// iap.ClickOnAction();
//
//		// iap.ClickOnViewGeneratedTermSheet();
//
//		plp.clickOnProfileLogo();
//		Thread.sleep(3000);
//		plp.clickOnLogout();

		
		LaunchPage lp = new LaunchPage(driver);
		
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(TCloginId, TCpassword);

		SP_TC_DashBoardpage tcd = new SP_TC_DashBoardpage(driver);

		tcd.ClickOnMyScheme();
		SP_TC_MyApprovedSchemeOrProgramPage spApp = new SP_TC_MyApprovedSchemeOrProgramPage(driver);

		spApp.ClickOnSPAction();
		spApp.CLickOnViewDetails();

		SP_TC_ViewDetailsPage pst = new SP_TC_ViewDetailsPage(driver);

		pst.ClickOnSPAction();
		pst.CLickOnViewDetails();
		pst.ClickOnView_All_Batches();

		pst.ClickOnCreateBatch();
		SP_TC_Batch_CreatePage tcbc=new SP_TC_Batch_CreatePage(driver);
		
		tcbc.EnterBatchSize(BatchSize);
		tcbc.SelectAssociatedQP(AssociatedQP_JobRole);
		
		tcbc.EnterTrainingHours(tryingHours);
		
		
		
		
	tcbc.TAB_FromTrainingHours();
	Thread.sleep(3000);
	
    tcbc.EnterBatchInTime(BatchInTiming);
   
	tcbc.TAB_FromBatchUpTime();
	Thread.sleep(3000);
	
   tcbc.EnterBatchOutTime(batchoutTime);
   Thread.sleep(3000);
	tcbc.ClickAddBatchTiming();
	Thread.sleep(3000);
	
	
	
	tcbc.ClickStartDate();
		tcbc.SelectBatchStartDate(batchStartDate);
		tcbc.ClickEndDate();
		//tcbc.SelectBatchEndDate(batchEndDate);
		tcbc.SelectTrainerName(trainerName);
		tcbc.SelectAssessmentLanguage(language);
		tcbc.ClickDisclaimer();
		
		
		tcbc.ClickOnSaveAndNext();

		
		
		
	}

}
