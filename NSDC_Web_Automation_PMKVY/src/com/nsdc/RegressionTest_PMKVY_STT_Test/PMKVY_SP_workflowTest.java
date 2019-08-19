package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.DashboardPage;
import com.nsdc.Pages_PMKVY_Pages.MySchemeOrProjectPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMUpage;
import com.nsdc.Pages_PMKVY_Pages.Pmkvy_SpecialProjectCreationPage;
import com.nsdc.Pages_PMKVY_Pages.SPPMU_All_TP_ProjectimplementingAgencypage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;
import com.nsdc.Pages_PMKVY_Pages.PMKVY_SPPMU_SelectedSchemepage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LaunchPage;
import com.nsdc.pages.LogOutPage;
import com.nsdc.testConfig.TestConfiguration;

public class PMKVY_SP_workflowTest extends TestConfiguration {
	@DataProvider
	public Object[][] CreateSpecialProjectData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls","Sp-workflow-data");
	}

	@Test(dataProvider = "CreateSpecialProjectData")

	public void Addspecialprojectdata_01(String username, String password, String value, String projectproposalID,
			String projectname, String registeredAs, String proposingorganisationName, String state, String district,
			String img1, String img2,String loginId,String password2, String agrementDate,String StartDate,String endDate,String Adhar,
			String TrainerCertified,String TypeofTrainingCentre,String PlacementsRequirement,String TypeOfEmployment,String MinimumPercentageplaced,
			String Disability,String Religion,String Gender,String Category, String DiscountsonBaseRate,String BatchDuration,String NumberofTranches,
			String Tranche3tobepaidwithoutPlacement,String DualLogoRequired,String TargetBeneficiaries,String Sector,String JobRole,String Target,
			String locationState,String locationDistrict,String jobrole1,String targetvalue1,String Jobrole2,
			String targetvalue2,String advanceTrancheYes,String advancepayment ) throws Exception {

		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		// Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		// Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(username, password);
		Thread.sleep(3000);
		DashboardPage db = new DashboardPage(driver);
		db.ClickMySchemeOrPrograms();
		MySchemeOrProjectPage msp=new MySchemeOrProjectPage(driver);
		msp.ClickApplySchemeProgram();
		SelectSchemeOrProgramPage ssp= new SelectSchemeOrProgramPage(driver);
		Thread.sleep(3000);

		ssp.ClickPageNumber3();
//ssp.selectValue(value);
		Thread.sleep(3000);
   ssp.ClickOn_SP_Action();
   ssp.ClickOn_SP_AddProject();
   
   Pmkvy_SpecialProjectCreationPage sp=new Pmkvy_SpecialProjectCreationPage(driver);
   Thread.sleep(2000);
sp.EnterTheProjectProposalID(projectproposalID);
sp.EnterTheProjecName(projectname);
sp.ClickProjectType();
sp.selectRegisteredAslist(registeredAs);
sp.EnterProposingOrganisationName(proposingorganisationName);
sp.selectState(state);
sp.selectDistrict(district);
Thread.sleep(3000);
sp.clickAdd();
sp.clickOnIndemnityBondBrowse();
Thread.sleep(3000);
UploadFile.upload(img1);
Thread.sleep(3000);

sp.clickOnIndemnityBondUploadButton();
Thread.sleep(3000);

//sp.clickOnOtherSupportingDocumentsBrowse();
//Thread.sleep(3000);
//UploadFile.upload(img2);
//Thread.sleep(3000);

sp.clickOnOtherSupportingDocumentsUpload();
Thread.sleep(3000);
sp.clickSaveAndSumbit();
Thread.sleep(3000);
LogOutPage plp = new LogOutPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		//
		Thread.sleep(3000);
		lp.clickLogin();
		bsp.clickToClose();
		elp.performlogin(loginId, password2);
		PMKVY_SPPMUpage sppmu=new PMKVY_SPPMUpage(driver);
		Thread.sleep(3000);
		sppmu.ClickOnViewAllSchemeAddRequests();
		
		SPPMU_All_TP_ProjectimplementingAgencypage allPIA=new SPPMU_All_TP_ProjectimplementingAgencypage(driver);
		Thread.sleep(3000);
		allPIA.ClickOnAction();
		Thread.sleep(3000);
		allPIA.ClickOnViewDetails();
		PMKVY_SPPMU_SelectedSchemepage sssp=new PMKVY_SPPMU_SelectedSchemepage(driver);
		Thread.sleep(3000);
		sssp.ClickAggrementDate();
	Thread.sleep(3000);
	sssp.SelectAggrementDate(agrementDate);
		Thread.sleep(3000);
		sssp.ClickStartDate();
	Thread.sleep(3000);
	sssp.SelectProjectDurationStartDate(StartDate);
	Thread.sleep(3000);
	sssp.ClickEndDate();
	Thread.sleep(3000);
		sssp.SelectProjectDurationEndDate(endDate);
	Thread.sleep(3000);
		sssp.SelectAdharRequirmentYes(Adhar);
		sssp.SelectTrainerCertifiedYes(TrainerCertified);
		sssp.SelectTypeofTrainingCentre(TypeofTrainingCentre);
		sssp.SelectPlacementsRequirementYes(PlacementsRequirement);
		sssp.SelectTypeOfEmployment(TypeOfEmployment);
		sssp.EnterTheMinimumPercentageofCandidatedtobeplacedTextBox(MinimumPercentageplaced);
		sssp.SelectDisability(Disability);
		sssp.SelectReligion(Religion);
		sssp.SelectGender(Gender);
		sssp.SelectCategory(Category);
		sssp.EnterTheDiscountsOnBaseRate(DiscountsonBaseRate);
		sssp.EnterBatchDuration(BatchDuration);
		sssp.SelectNumberOfTranches(NumberofTranches);
		sssp.SelecttrancheThreeToBepaid(Tranche3tobepaidwithoutPlacement);
		sssp.SelectDualLogoRequired(DualLogoRequired);
		sssp.EnterTheTargetBeneficiaries(TargetBeneficiaries);
		//addsector and job roles
		String numberofSectors=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "Sp-workflow-data", 1, 28);
	 	int sectors=Integer.parseInt(numberofSectors);
		
		for(int i=1;i<=sectors;i++)
	{
		sssp.SelectSector(Sector);
		sssp.SelectjobRoleName(JobRole);
		Thread.sleep(3000);
		sssp.EnterSectorAndJobTarget(Target);
		Thread.sleep(3000);
		sssp.ClickOnSectorAndJobRoleAdd();
		}
		
		
		
	//////////////	
		
		sssp.SelectlocationState(locationState);
		sssp.Selectlocationdistrict(locationDistrict);
		Thread.sleep(3000);
		sssp.ClicklocationAddButton();
		sssp.SelectJobRoleTargetDistribution1(jobrole1);
		sssp.EnterTargetDistribution1(targetvalue1);
		sssp.SelectJobRoleTargetDistribution2(Jobrole2);
		sssp.EnterTargetDistribution2(targetvalue2);
		sssp.SelectAdvanceTranche(advanceTrancheYes);
		sssp.EnterTheMinimumPercentageofCandidatedtobeplacedTextBox(advancepayment);
		sssp.ClickAmountTobeOfAdvance();
		Thread.sleep(3000);
		sssp.ClickAdvanceAdd();
		sssp.ClickSaveAndSubmitButton();
		
		
		
		
		
		
	}
	
	 
	

}
