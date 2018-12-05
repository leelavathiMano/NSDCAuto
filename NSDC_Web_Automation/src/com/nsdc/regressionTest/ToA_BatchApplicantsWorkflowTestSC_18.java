package com.nsdc.regressionTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.pages.AssessmentAgencyDashboardPage;
import com.nsdc.pages.AssessmentAgencyViewBatchesPage;
import com.nsdc.pages.AssessorApplicantDashboardPage;
import com.nsdc.pages.AssessorApplicantSearchAndApplyForAvailableBatchesPage;
import com.nsdc.pages.AssessorApplicantViewBatchesPage;
import com.nsdc.pages.AssessorDashboardPage;
import com.nsdc.pages.AssessorViewBatchesPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LocationBasedTC_DashboardPage;
import com.nsdc.pages.LocationBasedTC_ViewBatchesPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
import com.nsdc.pages.SSC_ViewBatchDetailsPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class ToA_BatchApplicantsWorkflowTestSC_18 extends TestConfiguration
{
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	String batchSector=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 0);
	String batchSubSector=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 1);
	String batchDomainJobRole=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 2);
	String batchDomainJobRoleCode=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 3);
	String sscID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 21);
	String sscPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 22);
	String batchType=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 4);
	String batchFees=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 5);
	String domainJobRole=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 2);
	String domainJobRoleCode=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 3);
	String platformJobRole=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 6);
	String platformJobRoleCode=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 7);
	String tcID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 8);
	String tcPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 10);
	String tcName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 9);
	String tcTPName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 11);
	String tcSPOCMobile=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 12);
	String tcSPOCEmail=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 13);
	String tcAddress=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 14);
	String tcLandmark=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 15);
	String tcPinCode=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 16);
	String tcMandal=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 17);
	String tcDistrict=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 18);
	String tcState=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 19);
	String tcParlimentaryConstituency=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 20);
	String domainMasterTrainerID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 23);
	String domainMasterTrainerName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 24);
	String domainMasterTrainerPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 25);
	String platformMasterTrainerID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 26);
	String platformMasterTrainerName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 27);
   	String platformMasterTrainerPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 28);
	String domainAssessmentAgencyID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 29);
	String domainAssessmentAgencyName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 30);
	String domainAssessmentAgencyPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 31);
	String platformAssessmentAgencyID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 32);
	String platformAssessmentAgencyName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 33);   
   	String platformAssessmentAgencyPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 34);
	String domainMasterAssessorID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 35); 
	String domainMasterAssessorName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 36); 
   	String domainMasterAssessorPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 37);
	String platformMasterAssessorID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 38); 
	String platformMasterAssessorName=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 39); 
   	String platformMasterAssessorPassword=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 40);
	@DataProvider()
    public Object[][] toaBatchData()
    {
    	return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches");
    }
	
    @Test(dataProvider="toaBatchData")
    public void toaBatchCreationTC_01(String serialNo,String createdBatchIDs, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickCreateBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(2000);
		sscTbcP.selectBatchCategory(batchCategory);
		Thread.sleep(2000);
		sscTbcP.selectTrainingStartDateForBatch();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),9,trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),10,trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(2000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(2000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String domainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),15,domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),16,domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),17,domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),18,domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(2000);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),19,platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),20,platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),21,platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),22,platformAssessmentEndDate);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast-message']")).size()==0,"OMG!!! Toast error Message present, Unable to create Batch! May be some data not entered OR Something went wrong! ");
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		Thread.sleep(4000);
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		sVbP.selectStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		Thread.sleep(2000);
		sVbP.clickToGetSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseResultedTrainingCentreToAssign(tcID);
		Thread.sleep(2000);
		sVbP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Master Trainer for domain QP
		sVbP.clickDomainMasterTrainerAction(domainJobRole);
		Thread.sleep(2000);
		sVbP.selectDomainAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainMasterTrainerIDToSearch(dmasterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseDomainMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Platform QP Master Trainer
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectPlatformAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformMasterTrainerIDToSearch(pmasterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Domain QP Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole);
		Thread.sleep(2000);
		sVbP.selectDomainAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectPlatformAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformAssessmentAgencyIDToSearch(passessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		sVbP.clickToSubmitBatch();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches",Integer.parseInt(serialNo),2,formatter.format(date));
		Thread.sleep(4000);
		sVbP.clickOkForBatchSubmission();
		Thread.sleep(4000);
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
    }
    
    @Test(dataProvider="toaBatchData", dependsOnMethods="toaBatchCreationTC_01")
    public void toaBatchApprovalTC_02(String serialNo, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime) throws Exception
    {
    	//Assigned TC Login to Accept Batch
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		Thread.sleep(6000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectAcceptBatchOption(batchID);
		Thread.sleep(2000);
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		Thread.sleep(2000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(4000);
		lTcVbP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//Assigned Master Trainer Login To Accept the Batch
		for(int i=1;i<3;i++)
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			lp.clickLogin();
			if(i==1)
			{
				elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
			}
			else
			{
				elp.performlogin(pmasterTrainerID, pmasterTrainerPassword);
			}
			Thread.sleep(4000);
			TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
			tDp.clickToGetTrainerDashboard();
			Thread.sleep(2000);
			tDp.clickAllBatches();
			Thread.sleep(4000);
			TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
			tVp.clicktoGoPendingBatchesSection();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			tVp.clickToSelectAcceptBatchOption(batchID);
			Thread.sleep(4000);
			if(i==1)
			{
				tVp.enterRemarksForAcceptingBatch(dmtBatchAcceptanceRemarks);
			}
			else
			{
				tVp.enterRemarksForAcceptingBatch(pmtBatchAcceptanceRemarks);
			}
			Thread.sleep(4000);	
			tVp.clickToSubmit();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 43, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 44, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 49, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 50, timeFormat.format(date));
			}
			Thread.sleep(4000);	
			tVp.clickOk();
			Thread.sleep(2000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(4000);
		}
		//Assigned Assessment Agency Login to Accept and assigning master assessors for a batch
		for(int i=1;i<3;i++)
		{
			lp.clickLogin();
			if(i==1)
			{
				elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
			}
			else
			{
				elp.performlogin(passessmentAgencyID, passessmentAgencyPassword);
			}
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)", "");
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagency","Login Unsuccessful!!! ");
			AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
			Thread.sleep(4000);
			aDp.clickBatchAssessmentRequests();
			Thread.sleep(2000);
			AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
			aVp.clickToViewPendingBatchRequests();
			Thread.sleep(2000);
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			aVp.clickToApplySelectedSearchFilters();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToSelectAcceptBatchOption();
			Thread.sleep(2000);
			if(i==1)
			{
				aVp.enterRemarksForAcceptingBatch(daaBatchAcceptanceRemarks);
			}
			else
			{
				aVp.enterRemarksForAcceptingBatch(paaBatchAcceptanceRemarks);
			}
			Thread.sleep(2000);		
			aVp.clickToSubmitBatchAcceptance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 55, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 56, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 61, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 62, timeFormat.format(date));
			}
			Thread.sleep(4000);
			aVp.clickOk();
			Thread.sleep(2000);
			//assigning assessors
			aVp.clickToViewAcceptedBatches();
			Thread.sleep(4000);
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			aVp.clickToApplySelectedSearchFilters();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToSelectAssignAssessorsOption();
			Thread.sleep(4000);
			if(i==1)
			{
				aVp.selectMasterAssessorForDomain1(dmasterAssessorName+"("+dmasterAssessorID+")");
				Thread.sleep(2000);
			}
			else
			{
				aVp.selectMasterAssessorForPlatform(pmasterAssessorName+"("+pmasterAssessorID+")");
				Thread.sleep(2000);
			}
			aVp.clickToSubmitMasterAssessors();
			Thread.sleep(4000);
			aVp.clickOk();
			Thread.sleep(4000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(4000);
		}
		//Master Assessor Login to Accept Batches
		for(int i=1; i<3;i++)
		{
			lp.clickLogin();
			if(i==1)
			{
				elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
			}
			else
			{
				elp.performlogin(pmasterAssessorID, pmasterAssessorPassword);
			}
			Thread.sleep(8000);
			AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
			maDp.clickToGetAssessorDashboard();
			Thread.sleep(2000);
			maDp.clickBatchAssessmentRequests();
			Thread.sleep(4000);
			AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
			maVp.clicktoGoToPendingRequestsSection();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			maVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			maVp.clickToSelectAcceptBatchOption(batchID);
			Thread.sleep(4000);
			if(i==1)
			{
				maVp.enterRemarksForAcceptingBatch(dmaRemarks);
			}
			else
			{
				maVp.enterRemarksForAcceptingBatch(pmaRemarks);
			}
			maVp.clickToSaveAndSubmitBatchAccceptance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 67, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 68, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 73, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", Integer.parseInt(serialNo), 74, timeFormat.format(date));
			}
			Thread.sleep(4000);
			maVp.clickOk();
			Thread.sleep(4000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
   }
   @DataProvider
   public Object[][] toaApplicantsData()
   {
       return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-BatchApplicants");
   }   
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="toaBatchApprovalTC_02")
   public void toaApplicantsSearchAndApplyForAvailableBatchTC_03(String serialNum,String assessorID, String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
	   LoginPage lp=new LoginPage(driver);
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
	   String domainTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 15);
	   String domainTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 16);
	   String domainAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 17);
	   String domainAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 18);
	   String platformTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 19);
	   String platformTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 20);
	   String platformAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 21);
	   String platformAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 22);
	   lp.clickLogin();
	   Thread.sleep(2000);
	   elp.performlogin(assessorID, "Qwerty@123");
	   Thread.sleep(10000);
	   AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
	   aDp.clickToGetApplicantDashboard();
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)", "");
	   Thread.sleep(4000);
	   aDp.clickSearchAndApplyforAvailableBatches();
	   Thread.sleep(4000);
	   AssessorApplicantSearchAndApplyForAvailableBatchesPage aSp=new AssessorApplicantSearchAndApplyForAvailableBatchesPage(driver);
	   if(serialNum.equals("1"))
/*	   {
		   aSp.clickMyPreferences();
		   Thread.sleep(4000);
		   aSp.clickToGetMyPreferenceActionMenu(preferredSector1);
		   Thread.sleep(2000);
		   aSp.selectSearchAgainstPreference(preferredSector1);
		   Thread.sleep(4000);
		   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! Search Against My Preference is not resulting batch - "+batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(domainJobRole));
		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(platformJobRole));
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), city);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
		   //have to select batch action
		   Thread.sleep(2000);
		   aSp.clickToGetBatchActionMenu(batchID);
		   Thread.sleep(2000);
		   aSp.selectViewBatchDetails(batchID);
		   Thread.sleep(4000);
		   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicantview-batch-detailsBATCH%20CREATED"+batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), batchSector);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), batchSubSector);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[1]")).getText().trim(), batchFees);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Name of Training Center')]]])/div[1]")).getText().trim(), tcName);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
		   Thread.sleep(4000);
		   aSp.clickGoBack();
		   Thread.sleep(4000);
		   aSp.clickToGetBatchActionMenu(batchID);
		   Thread.sleep(2000);
		   aSp.selectApplyToBatch(batchID);
		   Thread.sleep(2000);
		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully");
		   aSp.clickOK();
		   Thread.sleep(2000);
	   }
	   else if(serialNum.equals("2"))
	   {
		   aSp.selectState(state);
		   Thread.sleep(2000);
		   aSp.selectDistrict(city);
		   Thread.sleep(2000);
		   aSp.selectSubDistrict(mandal);
		   Thread.sleep(2000);
		   aSp.selectSector(preferredSector1);
		   Thread.sleep(2000);
		   aSp.selectSubSector(preferredSubSector1);
		   Thread.sleep(2000);
		   aSp.selectjobRole(domainJobRole);
		   Thread.sleep(6000);
		   aSp.selectBatchType(batchType);
		   Thread.sleep(2000);
		   aSp.enterBatchStartDate(batchStartDate);
		   Thread.sleep(6000);
		   aSp.clickToCloseBatchStartDateCalender();
		   Thread.sleep(2000);
		   aSp.enterBatchEndDate(batchEndDate);
		   Thread.sleep(6000);
		   aSp.clickToCloseBatchEndDateCalender();
		   Thread.sleep(2000);
		   aSp.enterSearchKeyword(tcName);
		   Thread.sleep(2000);
		   aSp.clickSearch();
		   Thread.sleep(2000);
		   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! No show of Batch - "+batchID+" searching by entering all fields! ");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(domainJobRole));
		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().contains(platformJobRole));
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), city);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate+" - "+batchEndDate);	
		   Thread.sleep(4000);
		   aSp.clickToGetBatchActionMenu(batchID);
		   Thread.sleep(2000);
		   aSp.selectApplyToBatch(batchID);
		   Thread.sleep(2000);
		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully !!");
		   aSp.clickOK();
	   }	   
	   else
	   {
*/		   	aSp.selectState(state);
			Thread.sleep(2000);
			aSp.selectSector(preferredSector1);
			Thread.sleep(4000);
			aSp.clickSearch();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"), "+platformJobRole+" ("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), city);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));	
			aSp.clickToGetBatchActionMenu(batchID);
			Thread.sleep(4000);
			aSp.selectApplyToBatch(batchID);
			Thread.sleep(8000);
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully");
			aSp.clickOK();   
//	   }
	   Thread.sleep(4000);
	   js.executeScript("window.scrollBy(0,-1000)", "");
	   Thread.sleep(4000);
	   aSp.clickViewMyBatches();
	   Thread.sleep(4000);
	   Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG! No show of applied batch - "+batchID+" in View Batches <-> My Batches Section!!! ");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), state+"/"+city);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+") , "+platformJobRole+" ("+platformJobRoleCode+")");  
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), "Applied");
	   //Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), formatter.format(date));
	   //Accepted Batch - View Details Data Verification
	   aSp.clickToGetAcceptedBatchActionMenu(batchID);
	   Thread.sleep(2000);
	   aSp.selectAcceptedBatchViewDetailsOption(batchID);
	   Thread.sleep(4000);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim().replaceAll("/", "-"), batchStartDate+" to "+batchEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), batchSector);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), batchSubSector);
	   //Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[1]")).getText().trim(), batchFees);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Training Center')]]]/div[1]")).getText().trim(), tcName);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Training Partner')]]]/div[2]")).getText().trim(), tcTPName);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mobile Number')]]]/div[1]")).getText().trim(), tcSPOCMobile);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Email ID')]]]/div[2]")).getText().trim(), tcSPOCEmail);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Center Address')]]]/div[1]")).getText().trim(), tcAddress);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Nearby Landmark')]]]/div[2]")).getText().trim(), tcLandmark);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Pincode')]]]/div[1]")).getText().trim(), tcPinCode);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'District')]]]/div[2]")).getText().trim(), tcDistrict);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'State')]]]/div[1]")).getText().trim(), tcState);
	   //Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Parliamentary')]]]/div[2]")).getText().trim(), tcParlimentaryConstituency);
	   //Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mandal')]]]/div[1]")).getText().trim(), tcMandal);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[1]")).getText().trim(), domainJobRoleCode);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[2]")).getText().trim(), domainJobRole);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[1]")).getText().trim(), platformJobRoleCode);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[2]")).getText().trim(), platformJobRole);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
	   PostLoginPage plp=new PostLoginPage(driver);
	   plp.clickOnProfileLogo();
	   Thread.sleep(2000);
	   plp.clickOnLogout();
	   Thread.sleep(4000);
   }
   //Assessor Applicants Approval Process From Location Based TC and SSC
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="toaApplicantsSearchAndApplyForAvailableBatchTC_03")
   public void tcApprovingToA_ApplicantsTC_04(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   LoginPage lp=new LoginPage(driver);
	   lp.clickLogin();
	   Thread.sleep(2000);
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
	   String batchSize=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 24);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
	   elp.performlogin(tcID, tcPassword);
	   Thread.sleep(6000);
	   LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)","");
	   Thread.sleep(4000);
	   tcDp.clickToViewBatches();
	   Thread.sleep(2000);
	   LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
	   tcVp.clickToViewAllAcceptedBatches();
	   Thread.sleep(4000);
	   Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");   
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), batchSize);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Published");
	   tcVp.clikToGetBatchActionMenu(batchID);
	   Thread.sleep(2000);
	   tcVp.selectEnrollApplicantsOption(batchID);
	   Thread.sleep(4000);
	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+assessorID+"']]")).size()==1,"OMG!!! No show of Assessor Applicant - "+assessorID+" who has applied for the Batch - "+batchID+" OR Something went wrong! ");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), assessorID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), name);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), email);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[5]")).getText().trim(), mobile);
	   tcVp.clickToGetApplicantActionMenu(assessorID);
	   Thread.sleep(4000);
	   tcVp.selectViewDetailsOfApplicantOption(assessorID);
	   Thread.sleep(4000);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
	   if(!education1.equalsIgnoreCase("uneducated"))
	   {
		   Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
	   }
	   else
	   {
		   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
	   }
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
	   //tcVp.clickGoBack(); 
	   driver.navigate().back();
	   Thread.sleep(4000);
	   if(serialNum.equals("1"))
	   {
		   tcVp.clickToSelectApplicantToBeEnrolled(assessorID);
		   Thread.sleep(2000);
		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]//input[@name='Checkbox']")).isSelected(),"OMG!!! checkbox not selected for assessor applicant - "+assessorID);
		   tcVp.clickToEnrollAllSelectedApplicants();
		   Thread.sleep(4000);
		   tcVp.clickToFinallyEnrollSelectedApplicants();
 		   Thread.sleep(4000);
	   }
	   else
	   {
		   tcVp.clickToGetApplicantActionMenu(assessorID);
		   Thread.sleep(4000);
		   tcVp.selectEnrollApplicantOption(assessorID);
		   Thread.sleep(4000);
		  // Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Applicant enrolled successfully\nYou have successfully enrolled to the "+batchID);
		   tcVp.clickOk();
		   Thread.sleep(4000);
	   }
	   tcVp.clickToGoToAppliedApplicantsSection();
	   Thread.sleep(2000);
	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! Enrolled Assessor Applicant - "+assessorID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
	   tcVp.clickToGoToEnrolledApplicantsSection();
	   Thread.sleep(4000);
	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==1,"OMG!!! No show of Enrolled Assessor Applicant - "+assessorID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
	   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+assessorID+"']")).getText().trim(), assessorID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[contains(text(),'"+name+"')]")).getText().trim(), name);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[contains(text(),'"+email+"')]")).getText().trim(), email);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
	   //Sending Batch To SSC For Approval
	   if(serialNum.equals("5"))
	   {
		   tcVp.clickToSendBatchForApproval();
		   Thread.sleep(4000);
		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Submitted for Approval");
		   Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been submitted for approval to SSC");
		   tcVp.clickOk();
		   Thread.sleep(4000);
		   tcVp.clickToViewAllAcceptedBatches();
		   Thread.sleep(4000);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Submitted for Approval");
	   }
	   else
	   {
		   tcVp.clickToGetApplicantActionMenu(assessorID);
		   Thread.sleep(4000);
		   tcVp.selectViewDetailsOfApplicantOption(assessorID);
		   Thread.sleep(4000);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
		   if(!education1.equalsIgnoreCase("uneducated"))
		   {
			   Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
			   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
			   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
			   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
		   }
		   else
		   {
			   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
		   }
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
	   }
	   PostLoginPage plp=new PostLoginPage(driver);
	   plp.clickOnProfileLogo();
	   Thread.sleep(2000);
	   plp.clickOnLogout();
	   Thread.sleep(2000);
   }
   //Applicant Adding Fees Payment Details After TC Approval
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="tcApprovingToA_ApplicantsTC_04")
   public void batchFeesPaymentByToA_ApplicnatsTC_05(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   LoginPage lp=new LoginPage(driver);
	   lp.clickLogin();
	   Thread.sleep(2000);
	   EnterLoginPage elp=new EnterLoginPage(driver);
	   elp.performlogin(assessorID, "Qwerty@123");
	   Thread.sleep(10000);
	   AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
	   Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
	   aDp.clickToGetApplicantDashboard();
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)", "");
	   Thread.sleep(4000);
	   aDp.clickViewBatches();
	   Thread.sleep(4000);
	   String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
	   //String batchCreatedDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 2);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
	   String domainTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 15);
	   String domainTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 16);
	   String domainAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 17);
	   String domainAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 18);
	   String platformTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 19);
	   String platformTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 20);
	   String platformAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 21);
	   String platformAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 22);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), state+"/"+city);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+") , "+platformJobRole+" ("+platformJobRoleCode+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), "Enrolled");
	   //Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), batchCreatedDate);
	   AssessorApplicantViewBatchesPage aVp=new AssessorApplicantViewBatchesPage(driver);
	   aVp.clickToGetEnrolledBatchActionMenu(batchID);
	   Thread.sleep(2000);
	   aVp.selectAddPaymentDetailsForEnrolledBatchOption(batchID);
	   Thread.sleep(4000);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Applicant ID')]]])[1]/div[1]")).getText().trim(), assessorID);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Applicant Name')]]])[1]/div[2]")).getText().trim(), name);
	   aVp.selectPaymentMode(paymentMode);
	   Thread.sleep(2000);
	   if(!paymentMode.equalsIgnoreCase("cash"))
	   {
		   aVp.selectBankName(bankName);
	   }
	   Thread.sleep(2000);
	   aVp.enterPaymentReferenceNumber(paymentReferenceNumber);
	   Thread.sleep(2000);
	   aVp.selectDateOfPayment();
	   String dateOfPayment=driver.findElement(By.xpath("//input[@formcontrolname='dateOfPayment']")).getAttribute("value");
	   ReadWriteData.setExcelData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "toaApplicantsData", Integer.parseInt(serialNum), 97, dateOfPayment);
	   Assert.assertFalse(driver.findElement(By.xpath("//input[@formcontrolname='amount']")).isEnabled(),"OMG!!! Fees TextField should be disabled OR Something went wrong!");
	   Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='amount']")).getAttribute("value").trim(), batchFees);
	   aVp.enterPaymentRemarks(paymentRemarks);
	   Thread.sleep(2000);
	   aVp.clickToSubmitPaymentDetails();
	   Thread.sleep(2000);
	  // Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Payment Details Added Successfully !!");
	  // Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Payment details has been added to the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
	   aVp.clickOK();
	   Thread.sleep(2000);
	   aVp.clickToGetEnrolledBatchActionMenu(batchID);
	   Thread.sleep(2000);
	   aVp.selectViewDetailsForEnrolledBatchOption(batchID);
	   Thread.sleep(4000);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim().replaceAll("/", "-"), batchStartDate+" to "+batchEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), batchSector);
	   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), batchSubSector);
	   //Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[1]")).getText().trim(), batchFees);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Training Center')]]]/div[1]")).getText().trim(), tcName);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Training Partner')]]]/div[2]")).getText().trim(), tcTPName);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mobile Number')]]]/div[1]")).getText().trim(), tcSPOCMobile);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Email ID')]]]/div[2]")).getText().trim(), tcSPOCEmail);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Center Address')]]]/div[1]")).getText().trim(), tcAddress);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Nearby Landmark')]]]/div[2]")).getText().trim(), tcLandmark);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Pincode')]]]/div[1]")).getText().trim(), tcPinCode);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'District')]]]/div[2]")).getText().trim(), tcDistrict);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'State')]]]/div[1]")).getText().trim(), tcState);
	   //Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Parliamentary')]]]/div[2]")).getText().trim(), tcParlimentaryConstituency);
	   //Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mandal')]]]/div[1]")).getText().trim(), tcMandal);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[1]")).getText().trim(), domainJobRoleCode);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[2]")).getText().trim(), domainJobRole);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[1]")).getText().trim(), platformJobRoleCode);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[2]")).getText().trim(), platformJobRole);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[1]")).getText().trim(), paymentMode);
	   if(!paymentMode.equalsIgnoreCase("cash"))
	   {
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Bank')]]]/div[2]")).getText().trim(), bankName);
	   }
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[1]")).getText().trim(), dateOfPayment.replaceAll("/", "-"));
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[1]")).getText().trim(), batchFees);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
	   PostLoginPage plp=new PostLoginPage(driver);
	   plp.clickOnProfileLogo();
	   Thread.sleep(2000);
	   plp.clickOnLogout();
	   Thread.sleep(2000);
   }
   
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="batchFeesPaymentByToA_ApplicnatsTC_05")
   public void sscApprovingToA_ApplicantsTC_06(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
  	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
  	 	LoginPage lp=new LoginPage(driver);
  	 	lp.clickLogin();
  	 	EnterLoginPage elp=new EnterLoginPage(driver);
  	 	elp.performlogin(sscID, sscPassword);
  	 	Thread.sleep(10000);
  	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
  	 	JavascriptExecutor js=(JavascriptExecutor)driver;
  	 	js.executeScript("window.scrollBy(0,200)", "");
  	 	Thread.sleep(4000);
  	 	sDp.clickAllBatches();
  	 	Thread.sleep(4000);
  	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
  	 	sAp.clickToViewAllPublishedBatches();
  	 	Thread.sleep(4000);
  	 	String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
  	 	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
   	 	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Submitted for Approval");
  	 	sAp.clickToGetBatchActionMenu(batchID);
  	 	Thread.sleep(2000);
  	 	sAp.selectApproveApplicantsOption(batchID);
  	 	Thread.sleep(4000);
  	 	SSC_ViewBatchDetailsPage sVp=new SSC_ViewBatchDetailsPage(driver);
  	 	sVp.clickToGoToEnrolledApplicantsSection();
  	 	Thread.sleep(2000);
  	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+assessorID+"']]")).size()==1,"OMG!!! No show of TC Approved Assessor Applicant - "+assessorID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), assessorID);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), name);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), email);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[5]")).getText().trim(), mobile);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[6]")).getText().trim(), "Paid");
  	 	sVp.clickToGetApplicantActionMenu(assessorID);
  	 	Thread.sleep(2000);
  	 	sVp.selectViewDetailsOfApplicantOption(assessorID);
  	 	Thread.sleep(2000);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
  	 	if(!education1.equalsIgnoreCase("uneducated"))
  	 	{
  	 		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
  	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
  	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
  	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
  	 	}
  	 	else
  	 	{
  	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
  	 	}
  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
  	 	//Verifying Fees Payment Details
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Received");
  	 	sVp.clickToViewPaymentDetails();
  	 	Thread.sleep(4000);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID')]]]/div[2]")).getText().trim(), batchID);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[2]")).getText().trim(), paymentMode);
  	 	if(!paymentMode.equalsIgnoreCase("cash"))
  	 	{
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of the Bank')]]]/div[2]")).getText().trim(), bankName);
  	 	}
  	 	//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[2]")).getText().trim(), paymentDate);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[2]")).getText().trim(), batchFees);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
  	 	sVp.clickOk();
  	 	Thread.sleep(4000);
  	 	js.executeScript("window.scrollBy(0,-1000)", "");
  	 	Thread.sleep(4000);
  	 	//sVp.clickGoBack(); 
  	 	driver.navigate().back();
  	 	Thread.sleep(4000);
  	 	sVp.clickToGoToEnrolledApplicantsSection();
  	 	Thread.sleep(4000);
  	 	if(serialNum.equals("1"))
  	 	{
  	 		sVp.clickToSelectApplicantToBeApproved(assessorID);
  	 		Thread.sleep(2000);
  	 		sVp.clickToApproveAllSelectedApplicants();
  	 		Thread.sleep(4000);
  	 		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! SSSC Approved Applicant - "+assessorID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
  	 	}
  	 	else
  	 	{
  	 		sVp.clickToGetApplicantActionMenu(assessorID);
  	 		Thread.sleep(2000);
  	 		sVp.selectApproveOfApplicantOption(assessorID);
  	 		Thread.sleep(4000);
  	 		//Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applicant Approved!!\nApplicant successfully approved");
  	 		sVp.clickOk();
  	 		Thread.sleep(4000);
  	 		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! SSSC Approved Applicant - "+assessorID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
  	 	}
  	 	js.executeScript("window.scrollBy(0,-1000)", "");
  	 	Thread.sleep(4000);
  	 	sVp.clickToGoToApprovedApplicantsSection();
  	 	Thread.sleep(4000);
  	 	//Verifying SSC Approved Applicants
  	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+assessorID+"']]")).size()==1,"OMG!!! No show of SSC Approved Assessor Applicant - "+assessorID+" in Approved Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), assessorID);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), name);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), email);
  	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[5]")).getText().trim(), mobile);
  	 	if(serialNum.equals("5"))
	 	{
   	 		sVp.clickToApproveBatch();
   	 		Thread.sleep(4000);
   	 		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("Batch Approved Successfully\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")"));
   	 		sVp.clickOk();
   	 		Thread.sleep(4000);
   	 		sAp.clickToViewAllPublishedBatches();
   	 		Thread.sleep(4000);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(),"Approved");
   	 		sAp.clickToGetBatchActionMenu(batchID);
   	 		Thread.sleep(2000);
   	 		sAp.selectViewDetailsOption(batchID);
   	 		Thread.sleep(4000);
   	 		sVp.clickToGoToApprovedApplicantsSection();
   	 		Thread.sleep(4000);
   	 		sVp.clickToApproveBatch();
   	 		Thread.sleep(2000);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Batch is already approved");
	 	}
  	 	else
  	 	{
  	 		sVp.clickToGetApplicantActionMenu(assessorID);
  	  	 	Thread.sleep(2000);
  	  	 	sVp.selectViewDetailsOfApplicantOption(assessorID);
  	  	 	Thread.sleep(2000);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
  	  	 	if(!education1.equalsIgnoreCase("uneducated"))
  	  	 	{
  	  	 		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
  	  	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
  	  	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
  	  	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
  	  	 	}
  	  	 	else
  	  	 	{
  	  	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
  	  	 	}
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
  	  	 	//Verifying Fees Payment Details
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Received");
  	  	 	sVp.clickToViewPaymentDetails();
  	  	 	Thread.sleep(4000);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID')]]]/div[2]")).getText().trim(), batchID);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[2]")).getText().trim(), paymentMode);
  	  	 	if(!paymentMode.equalsIgnoreCase("cash"))
  	  	 	{
  	  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of the Bank')]]]/div[2]")).getText().trim(), bankName);
  	  	 	}
  	  	 	//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[2]")).getText().trim(), paymentDate);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[2]")).getText().trim(), batchFees);
  	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
  	  	 	sVp.clickOk();
  	  	 	Thread.sleep(4000);
  	  	 	js.executeScript("window.scrollBy(0,-1000)", "");
  	  	 	Thread.sleep(4000);
  	 	}
  	 	PostLoginPage plp=new PostLoginPage(driver);
  	 	plp.clickOnProfileLogo();
  	 	Thread.sleep(2000);
  	 	plp.clickOnLogout();
  	 	Thread.sleep(2000);
   } 
   
   //display of SSC approved Batch & Applicants details for TC, Master Trainer, Assessment Agency and Master Assessor
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="sscApprovingToA_ApplicantsTC_06")
   public void trainingCentreVerifyingSSCApprovedBatchAndApplicantsTC_07(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
   		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   	LoginPage lp=new LoginPage(driver);
 	   	lp.clickLogin();
 	   	EnterLoginPage elp=new EnterLoginPage(driver);
 	   	String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
 	   	String batchSize=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 24);
 	   	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
 	   	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
 	   	String dTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 15);
 	   	String dTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 16);
 	   	String dAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 17);
 	   	String dAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 18);
 		String pTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 19);
 	   	String pTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 20);
 	   	String pAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 21);
 	   	String pAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 22);
 	   	elp.performlogin(tcID, tcPassword);
 	   	Thread.sleep(2000);
 	   	LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
 	   	JavascriptExecutor js=(JavascriptExecutor)driver;
 	   	js.executeScript("window.scrollBy(0,200)","");
 	   	Thread.sleep(4000);
 	   	tcDp.clickToViewBatches();
 	   	Thread.sleep(2000);
 	   	LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
 	   	tcVp.clickToViewAllAcceptedBatches();
 	   	Thread.sleep(4000);
 	   	Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
 	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Approved");
 	   	tcVp.clikToGetBatchActionMenu(batchID);
 	   	Thread.sleep(4000);
 	   	tcVp.selectViewBatchDetailsOption(batchID);
 	   	Thread.sleep(4000);
 	   	tcVp.clickToGoToBatchDetailsSection();
 		Thread.sleep(2000);
 		//Verifying Batch Details
 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID:')]]]/label[2]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Name:')]]]/label[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Size:')]]]/label[2]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Date')]]]/label[2]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Type:')]]]/label[2]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[2]")).getText(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[3]")).getText(), dTrainingStartDate+" to "+dTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[4]")).getText(), dAssessmentStartDate+" to "+dAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText(), pTrainingStartDate+" to "+pTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText(), pAssessmentStartDate+" to "+pAssessmentEndDate);
 		//Verifying Applicants Details
		tcVp.clickToGoToEnrolledApplicantsSection();
		Thread.sleep(4000);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[1]")).getText().trim(), assessorID);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), name);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), email);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), mobile);
 	   	tcVp.clickToGetApplicantActionMenu(assessorID);
 	   	Thread.sleep(4000);
 	   	tcVp.selectViewDetailsOfApplicantOption(assessorID);
 	   	Thread.sleep(4000);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
 	   	if(!education1.equalsIgnoreCase("uneducated"))
 	   	{
 	   		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
 	   		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
 	   		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
 	   	}
 	   	else
 	   	{
 	   		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
 	   	}
 	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
 	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
 	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
 	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
 	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
 	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
 	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
 	   	PostLoginPage plp=new PostLoginPage(driver);
 	   	plp.clickOnProfileLogo();
 	   	Thread.sleep(2000);
 	   	plp.clickOnLogout();
 	   	Thread.sleep(2000);
 	}
   
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="sscApprovingToA_ApplicantsTC_06")
   public void masterTrainerVerifyingSSCApprovedBatchAndApplicantsTC_08(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
   		String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
   		String batchSize=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 24);
   		String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
   		String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
   		for(int i=1;i<3;i++)
   		{
   			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   			LoginPage lp=new LoginPage(driver);
   			lp.clickLogin();
   			EnterLoginPage elp=new EnterLoginPage(driver);
   			if(i==1)
   			{
   				elp.performlogin(domainMasterTrainerID, domainMasterTrainerPassword);
   			}
   			else
   			{
   				elp.performlogin(platformMasterTrainerID, platformMasterTrainerPassword);
   			}
   			Thread.sleep(10000);
   			TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
   			tDp.clickToGetTrainerDashboard();
   			Thread.sleep(2000);
   			tDp.clickAllBatches();
   			Thread.sleep(4000);
   			TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
   			tVp.clickToGoToAcceptedBatchesSection();
   			Thread.sleep(2000);
   			JavascriptExecutor js=(JavascriptExecutor)driver;
   			js.executeScript("window.scrollBy(0,200)", "");
   			Thread.sleep(2000);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Approved");
   			tVp.clickToGetActionMenuOptions(batchID);
   			Thread.sleep(2000);
   			tVp.clickToSelectViewDetailsOption(batchID);
   			Thread.sleep(4000);
   			tVp.clickToGoToBatchDetailsSection();
   			Thread.sleep(2000);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector & Sub Sector')]]/td[3]")).getText().trim(), batchSector+" | "+batchSubSector);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
   			if(i==1)
   			{
   				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
   				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[2]")).getText().trim(), domainJobRoleCode);
   			}
   			else
   			{
   				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), platformJobRole);
   				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[2]")).getText().trim(), platformJobRoleCode);
   			}
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
   			//Applicant Details Verification
   			tVp.clickToGoToApprovedApplicantsSection();
   			Thread.sleep(4000);
   			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[1]")).getText().trim(), assessorID);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), name);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), email);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), mobile);
      	 	tVp.clickToGetApplicantActionMenu(assessorID);
      	 	Thread.sleep(2000);
      	 	tVp.selectViewDetailsOfApplicantOption(assessorID);
      	 	Thread.sleep(2000);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
      	 	if(!education1.equalsIgnoreCase("uneducated"))
      	 	{
      	 		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
      	 	}
      	 	else
      	 	{
      	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
      	 	}
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
      	 	PostLoginPage plp=new PostLoginPage(driver);
      	 	plp.clickOnProfileLogo();
      	 	Thread.sleep(2000);
      	 	plp.clickOnLogout();
      	 	Thread.sleep(6000);
   		}
   }
   
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="sscApprovingToA_ApplicantsTC_06")
   public void assessmentAgencyVerifyingSSCApprovedBatchAndApplicantsTC_09(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
	   	String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
   		String batchSize=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 24);
   		String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
   		String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
   		String dAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 17);
   		String dAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 18);
   		String pAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 21);
   		String pAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 22);
   		for(int i=1;i<3;i++)
   		{
   			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   			LoginPage lp=new LoginPage(driver);
   			lp.clickLogin();
   			EnterLoginPage elp=new EnterLoginPage(driver);
   			if(i==1)
   			{
   				elp.performlogin(domainAssessmentAgencyID, domainAssessmentAgencyPassword);
   			}
   			else
   			{
   				elp.performlogin(platformAssessmentAgencyID, platformAssessmentAgencyPassword);
   			}
   			Thread.sleep(8000);
   			JavascriptExecutor js=(JavascriptExecutor)driver;
   			js.executeScript("window.scrollBy(0,200)", "");
   			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagency","Login Unsuccessful!!! ");
   			AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
   			Thread.sleep(4000);
   			aDp.clickBatchAssessmentRequests();
   			Thread.sleep(2000);
   			AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
   			aVp.clickToViewAcceptedBatches();
   			Thread.sleep(2000);
   			aVp.enterBatchIdToSearch(batchID);
   			Thread.sleep(2000);
   			aVp.clickToApplySelectedSearchFilters();
			Thread.sleep(4000);
   			js.executeScript("window.scrollBy(0,200)", "");
   			Thread.sleep(2000);
   			aVp.clickToGetActionMenuOptions();
   			Thread.sleep(2000);
   			aVp.clickToSelectViewBatchDetailsOption();
   			Thread.sleep(2000);
   			aVp.clickToGoToBatchDetailsSection();
   			Thread.sleep(2000);
   			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(),batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( "+domainJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), domainMasterAssessorName+"("+domainMasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+"( "+platformJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), platformMasterAssessorName+" ("+platformMasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			}
			//Applicants Details Verification
			aVp.clickToGoToApprovedApplicantsSection();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), name);
      /* 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), email);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), assessorID);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[5]")).getText().trim(), mobile);
      */ 	aVp.clickToGetApplicantActionMenu(assessorID);
      	 	Thread.sleep(2000);
      	 	aVp.selectViewDetailsOfApplicantOption(assessorID);
      	 	Thread.sleep(2000);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
      	 	if(!education1.equalsIgnoreCase("uneducated"))
      	 	{
      	 		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
      	 	}
      	 	else
      	 	{
      	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
      	 	}
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
      	 	PostLoginPage plp=new PostLoginPage(driver);
      	 	plp.clickOnProfileLogo();
      	 	Thread.sleep(2000);
      	 	plp.clickOnLogout();
      	 	Thread.sleep(6000);
   		}
   }
   
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="sscApprovingToA_ApplicantsTC_06")
   public void masterAssessorVerifyingSSCApprovedBatchAndApplicantsTC_10(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
   	  	String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 1);
   	  	String batchSize=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 24);
   	  	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 9);
   	  	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 10);
   	  	String dAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 17);
   	  	String dAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 18);
   	  	String pAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 21);
   	  	String pAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 1, 22);
   	  	for(int i=1; i<3;i++)
   	  	{
   	  		LoginPage lp=new LoginPage(driver);
   	  		lp.clickLogin();
   	  		EnterLoginPage elp=new EnterLoginPage(driver);
   	  		if(i==1)
   	  		{
   	  			elp.performlogin(domainMasterAssessorID, domainMasterAssessorPassword);
   	  		}
   	  		else
   	  		{
   	  			elp.performlogin(platformMasterAssessorID, platformMasterAssessorPassword);
   	  		}
   	  		Thread.sleep(8000);
   	  		AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
   	  		maDp.clickToGetAssessorDashboard();
   	  		Thread.sleep(2000);
   	  		maDp.clickBatchAssessmentRequests();
   	  		Thread.sleep(4000);
   	  		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
   	  		maVp.clickToGoToAcceptedBatchesSection();
   	  		Thread.sleep(4000);
   	  		JavascriptExecutor js=(JavascriptExecutor)driver;
   	  		js.executeScript("window.scrollBy(0,200)", "");
   	  		Thread.sleep(2000);
   	  		maVp.clickToGetActionMenuOptions(batchID);
   	  		Thread.sleep(2000);
   	  		maVp.clickToSelectViewBatchDetailsOption(batchID);
   	  		Thread.sleep(4000);
   	  		maVp.clickToGoToBatchDetailsSection();
   	  		Thread.sleep(2000);
   	  		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Name')]]]]/div[3]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch ID')]]]]/div[3]/span")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Size')]]]]/div[3]/span")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Date')]]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), domainMasterAssessorName+" ("+domainMasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+" ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), platformMasterAssessorName+" ("+platformMasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			}
			//Applicants Details Verification
			maVp.clickToGoToApprovedApplicantsSection();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), assessorID);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), name);
      	// 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), email);
      	// 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[5]")).getText().trim(), mobile);
      	 	maVp.clickToGetApplicantActionMenu(assessorID);
      	 	Thread.sleep(2000);
      	 	maVp.selectViewDetailsOfApplicantOption(assessorID);
      	 	Thread.sleep(2000);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
      	 	if(!education1.equalsIgnoreCase("uneducated"))
      	 	{
      	 		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
      	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
      	 	}
      	 	else
      	 	{
      	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
      	 	}
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
      	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
      	 	PostLoginPage plp=new PostLoginPage(driver);
      	 	plp.clickOnProfileLogo();
      	 	Thread.sleep(2000);
      	 	plp.clickOnLogout();
      	 	Thread.sleep(6000);
   	  	}
   }
   //Applicants Rejection Test Cases
   @Test(dataProvider="toaApplicantsData", dependsOnMethods="toaBatchApprovalTC_02")
   public void tcRejectingToA_ApplicantsTC_11(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   {
	   	if(serialNum.equals("1"))
	   	{
	   	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 2, 1);
			LoginPage lp=new LoginPage(driver);
			lp.clickLogin();
			Thread.sleep(2000);
			EnterLoginPage elp=new EnterLoginPage(driver);
			//Applicant Applying for batch
			elp.performlogin(assessorID, "Qwerty@123");
			Thread.sleep(8000);
			AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
			aDp.clickToGetApplicantDashboard();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(4000);
			aDp.clickSearchAndApplyforAvailableBatches();
			Thread.sleep(4000);
			AssessorApplicantSearchAndApplyForAvailableBatchesPage aSp=new AssessorApplicantSearchAndApplyForAvailableBatchesPage(driver);
			aSp.selectState(state);
			Thread.sleep(2000);
			aSp.selectSector(preferredSector1);
			Thread.sleep(4000);
			aSp.clickSearch();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			aSp.clickToGetBatchActionMenu(batchID);
			Thread.sleep(4000);
			aSp.selectApplyToBatch(batchID);
			Thread.sleep(8000);
			aSp.clickOK();  
			Thread.sleep(4000);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
			//TC Rejecting Applicant
			lp.clickLogin();
			Thread.sleep(2000);
			elp.performlogin(tcID, tcPassword);
			Thread.sleep(8000);
			LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
			js.executeScript("window.scrollBy(0,200)","");
			Thread.sleep(4000);
			tcDp.clickToViewBatches();
			Thread.sleep(4000);
			LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
			tcVp.clickToViewAllAcceptedBatches();
			Thread.sleep(4000);
			Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
			tcVp.clikToGetBatchActionMenu(batchID);
			Thread.sleep(4000);
			tcVp.selectEnrollApplicantsOption(batchID);
			Thread.sleep(4000);
			tcVp.clickToGetApplicantActionMenu(assessorID);
			Thread.sleep(4000);
			tcVp.selectRejectApplicantOption(assessorID);
			Thread.sleep(4000);
			tcVp.selectReasonForRejectingApplicant();
			Thread.sleep(4000);
			tcVp.enterRemarksForRejectingApplicant();
			Thread.sleep(4000);
			tcVp.clickToRejectApplicant();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applicant Rejected");
			tcVp.clickOk();
			Thread.sleep(2000);
			tcVp.clickToGoToAppliedApplicantsSection();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! Rejected Assessor Applicant - "+assessorID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
			tcVp.clickToGoToEnrolledApplicantsSection();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! Rejected Assessor Applicant - "+assessorID+" Present in Enrolled Applicants Section!!! OR Something went wrong! ");
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
   	}
   
   	@Test(dataProvider="toaApplicantsData", dependsOnMethods="tcRejectingToA_ApplicantsTC_11")
   	public void sscRejectingToA_ApplicantsTC_12(String serialNum,String assessorID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
   	{
   		if(serialNum.equals("2"))
	   	{
	   	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/ToA_BatchApplicants-Workflow.xls", "ToA-Batches", 2, 1);
	   		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   		LoginPage lp=new LoginPage(driver);
	   		lp.clickLogin();
	   		Thread.sleep(2000);
	   		EnterLoginPage elp=new EnterLoginPage(driver);
	   		//Applicant Applying for batch
			elp.performlogin(assessorID, "Qwerty@123");
			Thread.sleep(8000);
			AssessorApplicantDashboardPage aDp=new AssessorApplicantDashboardPage(driver);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessorapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
			aDp.clickToGetApplicantDashboard();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(4000);
			aDp.clickSearchAndApplyforAvailableBatches();
			Thread.sleep(4000);
			AssessorApplicantSearchAndApplyForAvailableBatchesPage aSp=new AssessorApplicantSearchAndApplyForAvailableBatchesPage(driver);
			aSp.selectState(state);
			Thread.sleep(2000);
			aSp.selectSector(preferredSector1);
			Thread.sleep(4000);
			aSp.clickSearch();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			aSp.clickToGetBatchActionMenu(batchID);
			Thread.sleep(4000);
			aSp.selectApplyToBatch(batchID);
			Thread.sleep(4000);
			aSp.clickOK();  
			Thread.sleep(4000);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
	   		//TC Approving Applicant
			lp.clickLogin();
			Thread.sleep(2000);
	   		elp.performlogin(tcID, tcPassword);
	   		Thread.sleep(8000);
	   		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
	   		js.executeScript("window.scrollBy(0,200)","");
	   		Thread.sleep(4000);
	   		tcDp.clickToViewBatches();
	   		Thread.sleep(2000);
	   		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
	   		tcVp.clickToViewAllAcceptedBatches();
	   		Thread.sleep(4000);
	   		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
	   		tcVp.clikToGetBatchActionMenu(batchID);
	   		Thread.sleep(4000);
	   		tcVp.selectEnrollApplicantsOption(batchID);
	   		Thread.sleep(6000);
	   		tcVp.clickToGetApplicantActionMenu(assessorID);
	   		Thread.sleep(4000);
	   		tcVp.selectEnrollApplicantOption(assessorID);
	   		Thread.sleep(4000);
	   		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved successfully"),"OMG!!! Applicant Enroll Successfull Popup Text not displayed OR Something went wrong! ");
	   		tcVp.clickOk();
	   		Thread.sleep(4000);
	   		tcVp.clickToGoToEnrolledApplicantsSection();
	   		Thread.sleep(4000);
	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==1,"OMG!!! No show of Enrolled Assessor Applicant - "+assessorID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
	   		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+assessorID+"']")).getText().trim(), assessorID);
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[contains(text(),'"+name+"')]")).getText().trim(), name);
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[contains(text(),'"+email+"')]")).getText().trim(), email);
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
	   		//Sending Batch To SSC For Approval
	 	    tcVp.clickToSendBatchForApproval();
	 	    Thread.sleep(4000);
	 	    Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Submitted for Approval");
	 	    tcVp.clickOk();
	 		Thread.sleep(4000);
	   		plp.clickOnProfileLogo();
	   		Thread.sleep(2000);
	   		plp.clickOnLogout();
	   		Thread.sleep(6000);
	   		//SSC Rejecting Enrolled Applicant
	   		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   		lp.clickLogin();
	   		elp.performlogin(sscID, sscPassword);
	   		Thread.sleep(10000);
	   		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
	   		js.executeScript("window.scrollBy(0,200)", "");
	   		Thread.sleep(4000);
	   		sDp.clickAllBatches();
	   		Thread.sleep(4000);
	   		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
	   		sAp.clickToViewAllPublishedBatches();
	   		Thread.sleep(6000);
	   		sAp.clickToGetBatchActionMenu(batchID);
	   		Thread.sleep(2000);
	   		sAp.selectApproveApplicantsOption(batchID);
	   		Thread.sleep(4000);
	   		SSC_ViewBatchDetailsPage sVp=new SSC_ViewBatchDetailsPage(driver);
	   		sVp.clickTogoToBatchDetailsSection();
	   		Thread.sleep(2000);
	   		sVp.clickToGoToEnrolledApplicantsSection();
	   		Thread.sleep(2000);
	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+assessorID+"']]")).size()==1,"OMG!!! No show of TC Approved Assessor Applicant - "+assessorID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[2]")).getText().trim(), assessorID);
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[3]")).getText().trim(), name);
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[4]")).getText().trim(), email);
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[5]")).getText().trim(), mobile);
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+assessorID+"']]/td[6]")).getText().trim(), "Unpaid");
	   		sVp.clickToGetApplicantActionMenu(assessorID);
	   		Thread.sleep(2000);
	   		sVp.selectViewDetailsOfApplicantOption(assessorID);
	   		Thread.sleep(2000);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().trim(), language);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
	   		if(!education1.equalsIgnoreCase("uneducated"))
	   		{
	   			Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
	   			Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
	   			Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
	   			Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
	   		}
	   		else
      	 	{
	   			Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Education Details')]]/div")).getText().contains("Uneducated"));
      	 	}
	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
	   		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
	   		//Verifying UnPaid Fees Details
	   		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Not Received");
	   		//sVp.clickGoBack(); 
	   		driver.navigate().back();
	   		Thread.sleep(4000);
	   		sVp.clickToGoToEnrolledApplicantsSection();
	   		Thread.sleep(4000);
	   		sVp.clickToGetApplicantActionMenu(assessorID);
  	 		Thread.sleep(2000);
  	 		sVp.selectRejectApplicantOption(assessorID);
  	 		Thread.sleep(4000);
  	 		sVp.selectReasonForRejectingApplicant();
  	 		Thread.sleep(4000);
  	 		sVp.enterRemarksForRejectingApplicant();
  	 		Thread.sleep(4000);
  	 		sVp.clickToRejectApplicant();
  	 		Thread.sleep(4000);
  	 		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().trim().contains("Applicant Rejected"));
  	 		sVp.clickOk();
  	 		Thread.sleep(4000);
  	 		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+assessorID+"')]]")).size()==0,"OMG!!! SSC Rejected Applicant - "+assessorID+" should not be displayed in Enrolled Applicants Section OR Something went wrong!");
  	 	 	js.executeScript("window.scrollBy(0,-1000)", "");
  	 	 	Thread.sleep(4000);
  	 	 	sVp.clickToGoToApprovedApplicantsSection();
  	 	 	Thread.sleep(4000);
  	 	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+assessorID+"']]")).size()==0,"OMG!!! SSC Rejected Applicant - "+assessorID+" Present in Approved Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
  	 	 	plp.clickOnProfileLogo();
	 	 	Thread.sleep(2000);
	 	 	plp.clickOnLogout();
	 	 	Thread.sleep(6000);
	   	}
   	}
}
