package com.nsdc.RegressionTest_PMKVY_STT_Test;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_PMKVY_Pages.AddCampsPage;
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
import com.nsdc.Pages_PMKVY_Pages.Rpl_addTrainerpage;
import com.nsdc.Pages_PMKVY_Pages.SPPMU_All_TP_ProjectimplementingAgencypage;
import com.nsdc.Pages_PMKVY_Pages.SPPMU_Dashbordpage;
import com.nsdc.Pages_PMKVY_Pages.SPPMU_TrainingCentreDetaispage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_Batch_CreatePage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_DashBoardpage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_MyApprovedSchemeOrProgramPage;
import com.nsdc.Pages_PMKVY_Pages.SP_TC_ViewDetailsPage;
import com.nsdc.Pages_PMKVY_Pages.STTPMU_All_TP_ProjectimplementingAgencyPage;
import com.nsdc.Pages_PMKVY_Pages.STT_BatchDetailPage;
import com.nsdc.Pages_PMKVY_Pages.SelectSchemeOrProgramPage;

import com.nsdc.Pages_PMKVY_Pages.Sp_TrainingCentrePage;
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
			String batchStartDate, String trainerName, String language,String myTP,String canState,String Candistric) throws Exception {
		precondition();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
	LaunchPage lp = new LaunchPage(driver);
	Thread.sleep(3000);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	     bsp.clickToClose();
		Thread.sleep(3000);
  EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(username, password);
		Thread.sleep(3000);
	DashboardPage db = new DashboardPage(driver);
		db.ClickMySchemeOrPrograms();
		MySchemeOrProjectPage msp = new MySchemeOrProjectPage(driver);
		msp.ClickApplySchemeProgram();
		SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
		Thread.sleep(3000);

		ssp.ClickPageNumber2();
		//ssp.ClickPageNumber3();
		Thread.sleep(5000);
		ssp.ClickOn_SP_Action();
		Thread.sleep(3000);
		ssp.ClickOn_SP_AddProject();
//////////
		Pmkvy_SpecialProjectCreationPage sp = new Pmkvy_SpecialProjectCreationPage(driver);
		Thread.sleep(15000);
		sp.EnterTheProjectProposalID(projectproposalID);
		Thread.sleep(2000);
		sp.EnterTheProjecName(projectname);
		sp.ClickProjectType();
		sp.selectRegisteredAslist(registeredAs);
		sp.EnterProposingOrganisationName(proposingorganisationName);
		String numberOfLocations=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", 1, 1);
	 	int totalLocations=Integer.parseInt(numberOfLocations);
		
		for(int i=1;i<=totalLocations;i++)
		{
			String states=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", i, 2);
		sp.selectState(states);
		String districts =ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddLocation", i, 3);
		sp.selectDistrict(districts);
		Thread.sleep(3000);
		sp.clickAdd();
		}
//		sp.clickOnIndemnityBondBrowse();
//		Thread.sleep(3000);
//		UploadFile.upload(img1);
//		Thread.sleep(3000);
//
//		sp.clickOnIndemnityBondUploadButton();
//		Thread.sleep(3000);
//
		 sp.clickOnOtherSupportingDocumentsBrowse();
		Thread.sleep(3000);
		 UploadFile.upload(img2); 
		Thread.sleep(3000);
		sp.clickOnOtherSupportingDocumentsUpload();
		Thread.sleep(5000);
		sp.clickSaveAndSumbit();
		Thread.sleep(10000);
		sp.ClickonOK();
		Thread.sleep(5000);
		sp.ClickonOK();
		Thread.sleep(5000);
      LogOutPage plp = new LogOutPage(driver);
       Thread.sleep(3000);
		plp.clickOnProfileLogo();
		Thread.sleep(3000);
		plp.clickOnLogout(); // //
		Thread.sleep(3000);
		
	}
//@Test(dataProvider = "CreateSpecialProjectData")

	public void ApproveProject(String username, String password, String projectproposalID, String projectname,
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
			String batchStartDate, String trainerName, String language,String myTP,String canState,String Candistric) throws Exception {
		precondition();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		
		LaunchPage lp = new LaunchPage(driver);
		Thread.sleep(3000);
		lp.clickLogin();
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	     bsp.clickToClose();
	     EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(loginId, password2);
		PMKVY_SPPMUpage sppmu = new PMKVY_SPPMUpage(driver);
		Thread.sleep(10000);
		sppmu.ClickOnViewAllSchemeAddRequests();
		STTPMU_All_TP_ProjectimplementingAgencyPage allPIA = new STTPMU_All_TP_ProjectimplementingAgencyPage(driver);
		Thread.sleep(10000);
		allPIA.ClickOnAction();
		Thread.sleep(3000);
		allPIA.ClickOnViewDetails();
		PMKVY_SPPMU_SelectedSchemepage sssp = new PMKVY_SPPMU_SelectedSchemepage(driver);
		Thread.sleep(10000);
		sssp.ClickAggrementDate();
		Thread.sleep(3000);
		sssp.SelectAggrementDate(agrementDate);

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
		//sssp.SelectTypeofTrainingCentre(TypeofTrainingCentre);
		//sssp.SelectPlacementsRequirementYes(PlacementsRequirement);
		sssp.SelectTypeOfEmployment(TypeOfEmployment);
		sssp.EnterTheMinimumPercentageofCandidatedtobeplacedTextBox(MinimumPercentageplaced);
		sssp.ClickPercentageAdd();
		sssp.SelectDisability(Disability);
		sssp.SelectReligion(Religion);
		sssp.SelectGender(Gender);
		sssp.SelectCategory(Category);
		sssp.EnterTheDiscountsOnBaseRate(DiscountsonBaseRate);
		//sssp.EnterBatchDuration(BatchDuration);
		sssp.SelectNumberOfTranches(NumberofTranches);
		sssp.SelecttrancheThreeToBepaid(Tranche3tobepaidwithoutPlacement);
		sssp.SelectDualLogoRequired(DualLogoRequired);
		sssp.EnterTheTargetBeneficiaries(TargetBeneficiaries);
		Thread.sleep(5000);
		
		sssp.ClickSaveAndSubmitButton();
	    Thread.sleep(2000);
	    Pmkvy_SpecialProjectCreationPage sp = new Pmkvy_SpecialProjectCreationPage(driver);
	    sp.ClickonOK();
		Thread.sleep(2000);
		String Sno=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", 1, 0);
	 	int totalSNo=Integer.parseInt(Sno);
	 	
		String numberOfSectors_jobroles=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", 1, 1);
	 	int total_sectors_jobRoles=Integer.parseInt(numberOfSectors_jobroles);
	 	
		for(int i=1;i<=total_sectors_jobRoles;i++)
		{
			Thread.sleep(10000);
			sssp.ClickOnAddSectorsAndjobRole();
			Thread.sleep(2000);
			
			String Sectors=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 2);
			String JobRoles=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 3);
			sssp.SelectSector(Sectors);
			Thread.sleep(1000);
			sssp.SelectjobRoleName(JobRoles);
			Thread.sleep(1000);
			
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
			String Targets=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
			Thread.sleep(2000);
			sssp.EnterSectorAndJobTarget(Targets);
			Thread.sleep(2000);
			sssp.ClickOnSavebutton();
			Thread.sleep(3000);
		}
		Thread.sleep(5000);
		sssp.ClickOnSaveAndSubmit();
		Thread.sleep(3000);
		sp.ClickonOK();
		Thread.sleep(5000);
		
		
		
		for(int i=1;i<=total_sectors_jobRoles;i++)
		{
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//i[@class='la la-pencil pencil-icon'])["+i+"]")).click();
			
			
		
			//String Qpcode=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 4);
			String Targets=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddsectorsAndJObRole _workflow", i, 7);
			Thread.sleep(2000);
			String Qpcode="Broadband Technician (TEL/Q0102)";
			sssp.SelectjobRoleQPCode(Qpcode);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Enter Target']")).sendKeys(Targets);
			
			Thread.sleep(2000);
			sssp.ClickOnSavebutton();
			Thread.sleep(3000);
		
		
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Save &')]")).click();
		Thread.sleep(2000);
		   sp.ClickonOK();
		Thread.sleep(5000);
		sssp.ClickOnSaveAndSubmit();
		Thread.sleep(7000);
		  sp.ClickonOK();
		  
		  Thread.sleep(5000);
		
		

		sssp.SelectAdvanceTranche(advanceTrancheYes);

				sssp.EnterpercentageOfAdvanceTextBox(advancepayment);
		
				sssp.ClickAmountTobeOfAdvance();
				Thread.sleep(3000);
				sssp.ClickAdvanceAdd();
		driver.findElement(By.xpath("//button[text()='Save & Submit']")).click();
			
				Thread.sleep(30000);
				sp.ClickonOK();
				Thread.sleep(30000);
				sssp.ClickOnAction();
				Thread.sleep(3000);
				sssp.ClickOnViewGenerated_Termsheet();
////////				
	LogOutPage plp = new LogOutPage(driver);
			     Thread.sleep(3000);
					plp.clickOnProfileLogo();
					Thread.sleep(3000);
					plp.clickOnLogout(); 
					Thread.sleep(3000);
					Thread.sleep(3000);
					
}		
	//@Test(dataProvider = "CreateSpecialProjectData")

	public void AdditionalDetailsRequriedTP(String username, String password, String projectproposalID, String projectname,
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
			String batchStartDate, String trainerName, String language,String myTP,String canState,String Candistric) throws Exception 
	{
		precondition();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		
		LaunchPage lp = new LaunchPage(driver);
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	
		  EnterLoginPage elp = new EnterLoginPage(driver);
		  DashboardPage db = new DashboardPage(driver);	
		  SelectSchemeOrProgramPage ssp = new SelectSchemeOrProgramPage(driver);
		  Pmkvy_SpecialProjectCreationPage sp = new Pmkvy_SpecialProjectCreationPage(driver);
			Thread.sleep(3000);
					lp.clickLogin();
					bsp.clickToClose();
					elp.performlogin(username, password);
					db.ClickMySchemeOrPrograms();
					Thread.sleep(3000);
					db.ClickOnApprovalInProgress();
					Thread.sleep(3000);
					ssp.ClickApprovalInProgress_SPAction();
					ssp.ClickApprovalInProgress_SP_ViewDetails();
					PMKVY_SP_ApprovalInprogress_Additionaldetails_Page addtionalpage = new PMKVY_SP_ApprovalInprogress_Additionaldetails_Page(
							driver);
					Thread.sleep(3000);
					addtionalpage.ClickOn_Action();
					addtionalpage.Click_AdditionalDetailsRequried_Action(); //
					//////// addtionalreqDetails //
					TP_SP_AdditionalRequiredPage addR = new TP_SP_AdditionalRequiredPage(driver);
					Thread.sleep(10000);
					
					
					driver.findElement(By.xpath("//button[text()='Next']")).click();//next button
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(30000);
					driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();//next button
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(30000);
					driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();//next button
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(30000);
					
					driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();//next button
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(30000);
					
//					addR.ClickOnDual_logoBrowse();
//					Thread.sleep(3000);
//					UploadFile.upload(duallogoImg);
//					Thread.sleep(3000);
//					addR.ClickOnDual_logoUpLoad();
//					Thread.sleep(3000);
					
					
					driver.findElement(By.xpath("(//input[@id='customFile'])[1]")).click();
					//addR.ClickOnTPSigned_TermSheetBrowse();
					Thread.sleep(3000);
					
					UploadFile.upload(SignedImg);
					Thread.sleep(3000);
					driver.findElement(By.xpath("(//button[contains(text(),'Upload')])[1]")).click();
					//addR.clickOnTPSigned_TermSheetUpLoad();
					Thread.sleep(3000);
					addR.ClickOnIndemnityBrowse();
					
					Thread.sleep(3000);
					UploadFile.upload(SignedImg);
					Thread.sleep(3000);
					addR.ClickOnIndemnityBrowseUpLoad();
					Thread.sleep(3000);
					addR.SelectReview(review);
					Thread.sleep(3000);
					addR.ClickOnDownloadTermsheet();
					Thread.sleep(3000);
					addR.ClickSaveAndSubmit();
			         Thread.sleep(5000);
			  	      sp.ClickonOK();
			  	       Thread.sleep(10000);
			  		LogOutPage plp = new LogOutPage(driver);
					plp.clickOnProfileLogo();
					 Thread.sleep(3000);
					plp.clickOnLogout(); 
					Thread.sleep(3000);
					 Thread.sleep(3000);
					 
					 
	}
	
	//@Test(dataProvider = "CreateSpecialProjectData")

	public void AdditionalDetailsRequriedForPMU(String username, String password, String projectproposalID, String projectname,
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
			String batchStartDate, String trainerName, String language,String myTP,String canState,String Candistric) throws Exception {
		precondition();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		LaunchPage lp = new LaunchPage(driver);
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	
		  EnterLoginPage elp = new EnterLoginPage(driver);
		  DashboardPage db = new DashboardPage(driver);	
		  Pmkvy_SpecialProjectCreationPage sp = new Pmkvy_SpecialProjectCreationPage(driver);
	
					 
					lp.clickLogin();
					Thread.sleep(3000);
					bsp.clickToClose();
					Thread.sleep(3000);
					elp.performlogin(loginId, password2);
					Thread.sleep(10000);
					PMKVY_SPPMUpage sppmu = new PMKVY_SPPMUpage(driver);
					sppmu.ClickOnViewAllSchemeAddRequests(); 
					Thread.sleep(5000);// //for Sp andSTT SAME PAGE ACTION BUTTON AND VIEW DETAILS
					SPPMU_All_TP_ProjectimplementingAgencypage iap = new SPPMU_All_TP_ProjectimplementingAgencypage(driver);
					Thread.sleep(5000);
	                 iap.ClickOnAction();
					Thread.sleep(3000);
					iap.ClickOnViewDetails();
					Thread.sleep(3000);
					WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save & Next']"));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();",saveButton );
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[contains(text(),'Save & Next')]")).click();
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[contains(text(),'Save & Next')]")).click();
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[contains(text(),'Save & Next')]")).click();
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(3000);
					TP_SP_AdditionalRequiredPage addR = new TP_SP_AdditionalRequiredPage(driver);
					Thread.sleep(10000);
					addR.ClickOnOther_TermSheetBrowse();
					Thread.sleep(3000);
					UploadFile.upload(SignedImg);
					Thread.sleep(5000);
					addR.clickOnOther_TermSheetUpLoad();
					Thread.sleep(3000);
					addR.ClickOnTPSigned_TermSheetBrowse();
					Thread.sleep(3000);
					
					UploadFile.upload(SignedImg);
					Thread.sleep(5000);
					addR. clickOnTPSigned_TermSheetUpLoad();
					Thread.sleep(5000);
					addR.SelectComments(comments);
					Thread.sleep(3000);
					addR.ClickSaveAndSubmit();
					Thread.sleep(3000);
					sp.ClickonOK();
					Thread.sleep(20000);
					LogOutPage plp = new LogOutPage(driver);
						plp.clickOnProfileLogo();
						Thread.sleep(3000);
						plp.clickOnLogout();
	}




	@DataProvider
	public Object[][] AddTrainingCenter()
	{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
	"AddTrainingCenterWorkflow_TC_02");
	}
						
//	@Test(dataProvider="AddTrainingCenter")//,dependsOnMethods="Addspecialprojectdata_01")
	public void AddTC_TC_02(String username, String password,String tcloginid,String trainingType,String processType,
			String tcName,String address,String landmark,String pincode,String state,String district,String ParliamentaryConsistuency,
			String geolaction,String Spocname,String emailid,String mobilenumber,String sector,String jobrole ,String target,String mobileOtp,String emailOtp)throws Exception
	{
	precondition();
	//int srno = Integer.parseInt(sno);
	
//	String randomNumbers = RandomStringUtils.randomNumeric(5);
//	String phNo = "49393"+randomNumbers;	
//	System.out.println(phNo);
//	 String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
//	    String email = "";
//	    String temp = RandomStringUtils.random(17, allowedChars);
//	    email = temp.substring(0, temp.length() - 9) + "@testdata.com";
//	System.out.println(email);	
	
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//	Thread.sleep(3000);
	
    LaunchPage lp = new LaunchPage(driver);
    Thread.sleep(3000);
	lp.clickLogin();
	Thread.sleep(3000);
	BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	bsp.clickToClose();
	Thread.sleep(3000);
    EnterLoginPage elp = new EnterLoginPage(driver);
	elp.performlogin(username, password);
	Thread.sleep(3000);
	DashboardPage db = new DashboardPage(driver);
	db.ClickMySchemeOrPrograms();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//tr[td[span[span[text()='"+trainingType+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
    driver.findElement(By.xpath("//tr[td[span[span[text()='"+trainingType+"']]]]//a[contains(text(),'View Details')]")).click();
    Thread.sleep(3000);
						    
	Sp_TrainingCentrePage tc=new Sp_TrainingCentrePage(driver);
	Thread.sleep(3000);
	tc.ClickOnSPAction();
	tc.ClickOnViewDetails();
	Thread.sleep(3000);
	 tc.ClickonViewTC();
	Thread.sleep(3000);
	tc.ClickOnAdd_TC();
	Thread.sleep(4000);
	tc.SelectProcessType(processType);
	tc.ClickOnSaveAndContinueButton();
	Thread.sleep(7000);
	tc.trainingCentreName(tcName);
	tc.EnterAddress(address);
	tc.Enterlandmark(landmark);
	tc.EnterPincode(pincode);
	tc.SelectState(state);
	tc.selectDistrict(district);
	tc.SelectParliamentaryConsistuency(ParliamentaryConsistuency);
	Thread.sleep(3000);
	tc.EnterGeolaction(geolaction);
	Thread.sleep(3000);
	tc.ClickOncurrentlocation();
	tc.EnterPrimarySpocName(Spocname);
	Thread.sleep(1000);
	tc.EnterEmailid(emailid);
	Thread.sleep(2000);
	tc.EntercontactNumber(mobilenumber);
	Thread.sleep(2000);
	tc.ClickOnAddSectorTarget();
	Thread.sleep(1000);
	tc.SelectSector(sector);
	Thread.sleep(1000);
	tc.SelectJobRole(jobrole);
	tc.EnterTrainingTarget(target);
	Thread.sleep(3000);
	tc.ClickonSubmit();
	Thread.sleep(3000);
	tc.ClickOnGenerateOtp();
	Thread.sleep(3000);
	tc.EnterMobileOtp(mobileOtp);
	Thread.sleep(3000);
	tc.EnterEmailOtp(emailOtp);
	Thread.sleep(3000);
	tc.ClickOnVerifyOtp();					    
	  String Tc_ID = driver.findElement(By.xpath("//h2[@id='swal2-title']")).getText();//h2[@id='swal2-title']
	  String arr[] = Tc_ID.split(" "); 
	  String Tc_ID1 = arr[arr.length-1];
	  String Tc_ID2 = Tc_ID1.replace("(", "");
	  String TC_loginID =Tc_ID2.replace(")", "");
	   ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddTrainingCenterWorkflow_TC_02", 1, 2, TC_loginID);
	   ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "ApproveTrainingCenter_TC_03", 1, 2, TC_loginID);
	   Thread.sleep(3000);
	   ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "AddTrainner_TC_04", 1, 1, TC_loginID);
	   ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "CreateBatchWorkflow_Tc_04", 1, 0, TC_loginID);
	   Thread.sleep(3000);
	   tc.ClickOnClose();
	   LogOutPage plp = new LogOutPage(driver);
     Thread.sleep(3000);
		plp.clickOnProfileLogo();
		Thread.sleep(3000);
		plp.clickOnLogout(); 
	   }

	
	@DataProvider
	public Object[][] approveTrainingCenter()
	{
	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
	"ApproveTrainingCenter_TC_03");
	}
						
	//@Test(dataProvider="approveTrainingCenter")//,dependsOnMethods="AddTC_TC_02")
	public void ApproveTrainingCenter_03(String username, String password,String tc_loginId,
			String status,String comments)throws Exception
	{
	precondition();
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//	Thread.sleep(3000);
	 LaunchPage lp = new LaunchPage(driver);
	 Thread.sleep(3000);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
	    EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(username, password);
		Thread.sleep(3000);
		SPPMU_Dashbordpage pmu= new SPPMU_Dashbordpage(driver);
		pmu.ClickOnViewAllTC_addRequest();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tc_loginId+"']]]]//a[i[@class='la la-ellipsis-h']])")).click();
	    driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tc_loginId+"']]]]//a[contains(text(),'Take Action')])")).click();
	    SPPMU_TrainingCentreDetaispage tcPage= new SPPMU_TrainingCentreDetaispage(driver);
	    Thread.sleep(3000);
	    tcPage.SelectStatus(status);
	   tcPage.EnterTheComments(comments);
	   Thread.sleep(3000);
	    tcPage.ClickOnSubmit();
	    Thread.sleep(3000);
	    tcPage.ClickOnOK();
	    
	    LogOutPage plp = new LogOutPage(driver);
	     Thread.sleep(3000);
			plp.clickOnProfileLogo();
			Thread.sleep(3000);
			plp.clickOnLogout();
	}
//	
//	/////////////////
	@DataProvider
	public Object[][] AddTrainer()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
				"AddTrainner_TC_04");
	}
	
	//@Test(dataProvider="AddTrainer")//,dependsOnMethods="ApproveTrainingCenter_03")
	public void addTrainer_TC_04(String sno,String loginid,String oldpassword,String newPassword,
			String confirmPassword,String trainerName,String trainerEmail,String Phonenumber,String aadharnumber,String img,String fromDate,
			String toDate,String jobroles,String mobileOtp,String emailOtp)throws Exception
	{
		precondition();
		int srno = Integer.parseInt(sno);
//		String randomNumbers = RandomStringUtils.randomNumeric(5);
//		String phNo = "49393"+randomNumbers;	
//		System.out.println(phNo);
//		 String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
//		    String email = "";
//		    String temp = RandomStringUtils.random(17, allowedChars);
//		    email = temp.substring(0, temp.length() - 9) + "@testdata.com";
//		System.out.println(email);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		LaunchPage lp = new LaunchPage(driver);
		Thread.sleep(3000);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
	     bsp.clickToClose();
	     EnterLoginPage elp = new EnterLoginPage(driver);
			elp.performlogin(loginid,oldpassword);
			Thread.sleep(2000);
			elp.EnteroldPassword(oldpassword);
			elp.Enternewpassword(newPassword);
			Thread.sleep(2000);
			elp.EnterConfirmPassword(confirmPassword);
			elp.ClickOnResetAndRelogin();
			Thread.sleep(3000);
			elp.ClickOnOK();
			Thread.sleep(3000);
			 bsp.clickToClose();
			 elp.performlogin(loginid,newPassword);
			 Thread.sleep(3000);
			 
			 //////////
			 SP_TC_DashBoardpage tcd = new SP_TC_DashBoardpage(driver);
		        Thread.sleep(2000);
				tcd.ClickOnMyScheme();
				Thread.sleep(5000);
				tcd.ClickOnViewScheme();
				SP_TC_MyApprovedSchemeOrProgramPage spApp = new SP_TC_MyApprovedSchemeOrProgramPage(driver);
				 Thread.sleep(2000);
				spApp.ClickOnSPAction();
				 Thread.sleep(2000);
				spApp.CLickOnViewDetails();
				 Thread.sleep(2000);
				SP_TC_ViewDetailsPage pst = new SP_TC_ViewDetailsPage(driver);
				pst.ClickOnSPAction();
				Thread.sleep(3000);
				pst.CLickOnViewDetails();
			 
			 /////////////
			
				
				
				Rpl_addTrainerpage trainer=new Rpl_addTrainerpage(driver);
				Thread.sleep(5000);
				trainer.ClickOnViewTrainers();
				Thread.sleep(10000);
				trainer.ClickOnAddTrainer();
				Thread.sleep(3000);
				trainer.EnterName(trainerName);
				trainer.EnterEmail(trainerEmail);
				trainer.EnterPhoneNumber(Phonenumber);
				trainer.ClickOnAdhaarRadio();
				Thread.sleep(2000);
				trainer.EnterThePanOrAadharNumber(aadharnumber);
				Thread.sleep(2000);
				trainer.ClickOnPanUploadBrowser();
				Thread.sleep(2000);
				UploadFile.upload(img);
				Thread.sleep(5000);
				trainer.ClickOnPanUploadButton();
				Thread.sleep(5000);
				trainer.ClickOnFromDate();
				Thread.sleep(2000);
				trainer.SelectFromDate(fromDate);
				trainer.ClickOnToDate();
				Thread.sleep(2000);
				trainer.SelectTODate(toDate);
				trainer.ClickOnassociatedDocumentsBrowser();
				Thread.sleep(2000);
				UploadFile.upload(img);
				Thread.sleep(5000);
				trainer.ClickOnassociatedDocumentUpload();
				Thread.sleep(2000);
				trainer.SelectAssociatedJobRoles(jobroles);
				Thread.sleep(2000);
				trainer.ClickOnGenerateOtp();
				Thread.sleep(2000);
				trainer.EnterMobileOtp(mobileOtp);
				Thread.sleep(2000);
				trainer.EnterEmailOtp(emailOtp);
				Thread.sleep(2000);
				trainer. ClickOnVerifyOtp();
				Thread.sleep(2000);
				String trainerID=driver.findElement(By.xpath("(//tbody//tr//td[2]//span)[2]")).getText();
				Thread.sleep(2000);
				 ReadWriteData.setExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls", "CreateBatchWorkflow_Tc_04", 1, 9, trainerID);
				 
//				  LogOutPage plp = new LogOutPage(driver);
//				     Thread.sleep(3000);
//					plp.clickOnProfileLogo();
//					 Thread.sleep(3000);
//					plp.clickOnLogout(); 
}  
	@DataProvider
	public Object[][] CreateBatch() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls",
				"CreateBatchWorkflow_Tc_04");
	}

//	@Test(dataProvider = "CreateBatch")//,dependsOnMethods="addTrainer_TC_04")

	public void CreateBatch_04(String TCloginId, String oldpassword,String newPassword, String BatchSize,
			String AssociatedQP_JobRole, String tryingHours, String BatchInTiming, String batchoutTime,
			String batchStartDate, String trainerName, String language,String myTP,String canState,String Candistric) 
		throws Exception {
		precondition();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
//		Thread.sleep(3000);
		LaunchPage lp = new LaunchPage(driver);
		Thread.sleep(3000);
				lp.clickLogin();
				Thread.sleep(3000);	
			BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
				bsp.clickToClose();
				Thread.sleep(3000);
				EnterLoginPage elp = new EnterLoginPage(driver);
				
			elp.performlogin(TCloginId,newPassword);
				 Thread.sleep(3000);
				SP_TC_DashBoardpage tcd = new SP_TC_DashBoardpage(driver);
		        Thread.sleep(2000);
				tcd.ClickOnMyScheme();
				Thread.sleep(5000);
				tcd.ClickOnViewScheme();
				SP_TC_MyApprovedSchemeOrProgramPage spApp = new SP_TC_MyApprovedSchemeOrProgramPage(driver);
				 Thread.sleep(2000);
				spApp.ClickOnSPAction();
				 Thread.sleep(2000);
				spApp.CLickOnViewDetails();
				 Thread.sleep(2000);
				SP_TC_ViewDetailsPage pst = new SP_TC_ViewDetailsPage(driver);
				pst.ClickOnSPAction();
				Thread.sleep(3000);
				pst.CLickOnViewDetails();
				Thread.sleep(3000);
				pst.ClickOnView_All_Batches();
				Thread.sleep(7000);
				pst.ClickOnCreateBatch();
				Thread.sleep(3000);
				SP_TC_Batch_CreatePage tcbc = new SP_TC_Batch_CreatePage(driver);
				Thread.sleep(2000);
				tcbc.EnterBatchSize(BatchSize);
				Thread.sleep(2000);
				tcbc.SelectAssociatedQP(AssociatedQP_JobRole);
				Thread.sleep(2000);
				tcbc.EnterTrainingHours(tryingHours);
				Thread.sleep(2000);
				tcbc.TAB_FromTrainingHours();
				Thread.sleep(2000);
				tcbc.ClickTrainingHours();
			    tcbc.TAB_FromTrainingHours();
			    tcbc.BatchinTimeSelect(BatchInTiming);
			    tcbc.BatchoutTimeSelect(batchoutTime);
			//	 tcbc.EnterBatchInTime(BatchInTiming);
			//	tcbc.TAB_FromBatchUpTime();
			//	 tcbc.EnterBatchOutTime(batchoutTime);
				tcbc.ClickAddBatchTiming(); 
				 Thread.sleep(1000); 
				 tcbc.ClickStartDate();
				 tcbc.SelectBatchStartDate(batchStartDate);
				// tcbc.ClickEndDate(); 
				 //tcbc.SelectBatchEndDate(batchEndDate);
				tcbc.SelectTrainerName(trainerName);
				tcbc.SelectAssessmentLanguage(language);
				 tcbc.ClickDisclaimer(); 
					Thread.sleep(5000);
				tcbc.ClickOnSaveAndNext();
				Thread.sleep(5000);
				tcbc.ClickOnOKButton();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
//		       
			
			
			
		//	
//				Thread.sleep(3000);
			TrainingCalenderPage tcp = new TrainingCalenderPage(driver);
//				//tcp.ClickThreeDots();
//				String SP="Other Holiday";
//				Thread.sleep(3000);
//				tcp.ClickDayAndDate();
//				Thread.sleep(3000);
//				tcp.SelectDayAndDate(DayAndDate);
//				Thread.sleep(3000);
//				tcp.SelectSessionPlanned(SessionPlan);
//				if(SessionPlan.equals(SP))
//				{
//				tcp.EnterDescription(Description);
//				}
//				else
//				{
//					tcp.SelectNOSTaught(NOSTaught);
//					tcp.TAB_FromNOSTaught();
//					tcp.EnterStartTime(StartTime);
//					Thread.sleep(3000);
//					tcp.TAB_BatchIntime();
//					tcp.EnterEndTime(EndTime);
//					tcp.EnterDescription(Description);
//				}
//				tcp.ClickAddSession();
			
			
			
		    	Thread.sleep(3000);
				tcp.ClickSaveBtn();
				Thread.sleep(3000);
				tcp.ClickOnOKButton();
				Thread.sleep(3000);
				
				//tcp.SelectSourceOfRegistration(myTP);
				
				
//				ListofEligibleCandiatePage enrollcandite= new ListofEligibleCandiatePage(driver);
//				Thread.sleep(3000);
////				enrollcandite.SelectState(canState);
////				enrollcandite.Selectdistric(Candistric);
////				enrollcandite.ClickOnApply();
//				enrollcandite.ClickOnCandiateIdCheckBox();//up to working fine
//				String modelOfBandL="Self";
//				String numCAN=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls","NumberOFenrollcandidates", 1, 0);
//			 	int numberOfcan =Integer.parseInt(numCAN);
//			 	for(int i=1;i<=numberOfcan;i++)	
//				{    
//			 		Thread.sleep(3000);
//					WebElement BandLOpted = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[14]//span"));
//					JavascriptExecutor executor2= (JavascriptExecutor) driver;
//					executor2.executeScript("arguments[0].click();",BandLOpted );
//			 		
//					
//			 		Thread.sleep(1000);
//			 	WebElement modeofBk = driver.findElement(By.xpath("(//select[@formcontrolname='modeOfBkl'])["+i+"]"));
//			 		  Select sel=new Select(modeofBk);
//			 				  sel.selectByVisibleText(modelOfBandL);
//			 				 Thread.sleep(1000);
//				
//				}
//			 	Thread.sleep(3000);
//			 	enrollcandite.ClickonEnrollCandidates();
//			 	Thread.sleep(3000);
//				enrollcandite.ClickOnOKButton();
//				Thread.sleep(3000);
//			 	enrollcandite.ClickonSubmitToEnrollcandidatesButton();
//			 	Thread.sleep(3000);
//			 	enrollcandite.ClickonYesButton();
//				Thread.sleep(3000);
////			 	enrollcandite.ClickOnOKButton();
////				Thread.sleep(3000);
//				enrollcandite.ClickOnSubmit_To_SSC();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
//			 	//enrollcandite.ClickOnOKButton();
//			 	
//			 	Thread.sleep(3000);
//			 	driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
//			 	enrollcandite.ClickOnOKButton();
////			 	Thread.sleep(3000);
////			 	enrollcandite.ClickOnOKButton();
//		
////			 	 Thread.sleep(7000); 
////			plp.clickOnProfileLogo();
////					plp.clickOnLogout(); 
	
	
	
}
	
	
} 



////		LaunchPage lp = new LaunchPage(driver);
//
//		lp.clickLogin();
//		Thread.sleep(3000);
//	
//		
////		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		//
//		
////		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(TCloginId, TCpassword);
//
//		SP_TC_DashBoardpage tcd = new SP_TC_DashBoardpage(driver);
//        Thread.sleep(2000);
//		tcd.ClickOnMyScheme();
//		Thread.sleep(5000);
//		tcd.ClickOnViewScheme();
//		SP_TC_MyApprovedSchemeOrProgramPage spApp = new SP_TC_MyApprovedSchemeOrProgramPage(driver);
//		 Thread.sleep(2000);
//		spApp.ClickOnSPAction();
//		 Thread.sleep(2000);
//		spApp.CLickOnViewDetails();
//		 Thread.sleep(2000);
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
//	    
//	//	 tcbc.EnterBatchInTime(BatchInTiming);
//	//	tcbc.TAB_FromBatchUpTime();
//	//	 tcbc.EnterBatchOutTime(batchoutTime);
//		
//		
//		
//		
//		tcbc.ClickAddBatchTiming(); 
//		 Thread.sleep(1000); 
//		 tcbc.ClickStartDate();
//		 tcbc.SelectBatchStartDate(batchStartDate);
//		// tcbc.ClickEndDate(); 
//		 //tcbc.SelectBatchEndDate(batchEndDate);
//		tcbc.SelectTrainerName(trainerName);
//		tcbc.SelectAssessmentLanguage(language);
//		 tcbc.ClickDisclaimer(); 
//		tcbc.ClickOnSaveAndNext();
//		tcbc.ClickOnOKButton();
//       
//	
//	
//	
////	
////		Thread.sleep(3000);
//	TrainingCalenderPage tcp = new TrainingCalenderPage(driver);
////		//tcp.ClickThreeDots();
////		String SP="Other Holiday";
////		Thread.sleep(3000);
////		tcp.ClickDayAndDate();
////		Thread.sleep(3000);
////		tcp.SelectDayAndDate(DayAndDate);
////		Thread.sleep(3000);
////		tcp.SelectSessionPlanned(SessionPlan);
////		if(SessionPlan.equals(SP))
////		{
////		tcp.EnterDescription(Description);
////		}
////		else
////		{
////			tcp.SelectNOSTaught(NOSTaught);
////			tcp.TAB_FromNOSTaught();
////			tcp.EnterStartTime(StartTime);
////			Thread.sleep(3000);
////			tcp.TAB_BatchIntime();
////			tcp.EnterEndTime(EndTime);
////			tcp.EnterDescription(Description);
////		}
////		tcp.ClickAddSession();
//	
//	
//	
//    	Thread.sleep(3000);
//		tcp.ClickSaveBtn();
//		Thread.sleep(3000);
//		tcp.ClickOnOKButton();
//		Thread.sleep(3000);
//		
//		tcp.SelectSourceOfRegistration(myTP);
//		
//		
//		ListofEligibleCandiatePage enrollcandite= new ListofEligibleCandiatePage(driver);
//		Thread.sleep(3000);
//		enrollcandite.SelectState(canState);
//		enrollcandite.Selectdistric(Candistric);
//		enrollcandite.ClickOnApply();
//		enrollcandite.ClickOnCandiateIdCheckBox();//up to working fine
//		String modelOfBandL="Self";
//		String numCAN=ReadWriteData.getData("./TestData/Workflow/PMKVY_SP/pmkvy-specialproject-workflow.xls","NumberOFenrollcandidates", 1, 0);
//	 	int numberOfcan =Integer.parseInt(numCAN);
//	 	for(int i=1;i<=numberOfcan;i++)	
//		{    
//	 		Thread.sleep(3000);
//			WebElement BandLOpted = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[14]//span"));
//			JavascriptExecutor executor2= (JavascriptExecutor) driver;
//			executor2.executeScript("arguments[0].click();",BandLOpted );
//	 		
//			
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
//		enrollcandite.ClickOnOKButton();
//		Thread.sleep(3000);
//	 	enrollcandite.ClickonSubmitToEnrollcandidatesButton();
//	 	Thread.sleep(3000);
//	 	enrollcandite.ClickonYesButton();
//		Thread.sleep(3000);
////	 	enrollcandite.ClickOnOKButton();
////		Thread.sleep(3000);
//		enrollcandite.ClickOnSubmit_To_SSC();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
//	 	//enrollcandite.ClickOnOKButton();
//	 	
//	 	Thread.sleep(3000);
//	 	driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
//	 	enrollcandite.ClickOnOKButton();
////	 	Thread.sleep(3000);
////	 	enrollcandite.ClickOnOKButton();
//
////	 	 Thread.sleep(7000); 
////	plp.clickOnProfileLogo();
////			plp.clickOnLogout(); 
//	}

	


//}
