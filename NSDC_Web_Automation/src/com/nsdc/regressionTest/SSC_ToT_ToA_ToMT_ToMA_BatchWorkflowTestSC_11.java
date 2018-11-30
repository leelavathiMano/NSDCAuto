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
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AssessmentAgencyDashboardPage;
import com.nsdc.pages.AssessmentAgencyViewBatchesPage;
import com.nsdc.pages.AssessorDashboardPage;
import com.nsdc.pages.AssessorViewBatchesPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LocationBasedTC_DashboardPage;
import com.nsdc.pages.LocationBasedTC_ViewBatchesPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_BatchReSchedulePage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
import com.nsdc.pages.SSC_ViewBatchDetailsPage;
import com.nsdc.pages.TrainerApplicantDashboardPage;
import com.nsdc.pages.TrainerApplicantSearchAndApplyForAvailableBatchesPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class SSC_ToT_ToA_ToMT_ToMA_BatchWorkflowTestSC_11 extends TestConfiguration
{
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	
	@DataProvider
	public Object[][] sscBatchCreationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation");
	}
	@Test(dataProvider="sscBatchCreationData")
	public void sscBatchCreationTC_01(String serialNum,String createdBatchIDs, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime) throws Exception
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
		Thread.sleep(4000);
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
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 9, trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 10, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(2000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(2000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 15, domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 16, domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 17, domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 18, domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
			}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 19, platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 20, platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 21, platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 22, platformAssessmentEndDate);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.clickToGetInDetailBatchFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Fee Applicable for Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Technical QP(0) X Rate(800)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Non-Technical QP(0) X Rate(600)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Total Fee of the Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast-message']")).size()==0,"OMG!!! Toast Error Message present, Unable to create Batch! May be some data not entered OR Something went wrong! ");
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 1, createdBatchID);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+") is successfully created");
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssccreate-new-batchbatch-assignment"+createdBatchID,"OMG!!! No show of Batch Assignment Page OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		//STEP 2 OF BATCH CREATION -> Assigning Training Centre  and Assigning To Batches
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		Thread.sleep(4000);
		sVbP.selectStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		Thread.sleep(4000);
		sVbP.clickToGetSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+tcID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tpName+"')]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Thread.sleep(2000);
		sVbP.clickToChooseResultedTrainingCentreToAssign(tcID);
		Thread.sleep(4000);
		sVbP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Training Centre Assigned\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+tcName+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Domain QP
		Thread.sleep(2000);
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
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+dmasterTrainerID+" for Domain QP -"+domainJobRoleCode);
		sVbP.clickToChooseDomainMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+dmasterTrainerID+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+dmasterTrainerID+"')]")).getText().trim(), dmasterTrainerName+" ( "+dmasterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Platform QP
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
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+pmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+pmasterTrainerID+" for Platform QP -"+platformJobRoleCode);
		sVbP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+pmasterTrainerID+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+pmasterTrainerID+"')])[1]")).getText().trim(), pmasterTrainerName+" ( "+pmasterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
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
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dassessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+dassessmentAgencyID+" for Domain QP -"+domainJobRoleCode);
		sVbP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Assessment Agency Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+dassessmentAgencyName+"\nState : "+state+"\nDistrict :"+district);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+dassessmentAgencyID+"')]")).getText().trim(), dassessmentAgencyName+" ( "+dassessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
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
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+passessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+passessmentAgencyID+" for Platform QP -"+platformJobRoleCode);
		sVbP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Assessment Agency Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+passessmentAgencyName+"\nState : "+state+"\nDistrict :"+district);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+passessmentAgencyID+"')])[1]")).getText().trim(), passessmentAgencyName+" ( "+passessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		sVbP.clickSaveAsDraft();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']")).getText().trim(), "Saved as Draft");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().trim(), "success");
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//checking presence of created batches of status draft
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]")).size()==0,"OMG! Batch - "+createdBatchID+" not found in All Batches Section of "+sscUsername+" !!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[1]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+tcID+"')]]")).getText().trim(), tcName+" ("+tcID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+state+"')]]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+district+"')]]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[7]")).getText().trim(), trainingStartDate+" - "+trainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Draft");
		//Submitting Batch 
		sscTbcP.clickBatchAction(createdBatchID);
		Thread.sleep(2000);
		sscTbcP.selectAssignOption(createdBatchID);
		Thread.sleep(2000);
		sVbP.clickToSubmitBatch();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 2,formatter.format(date));
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		sVbP.clickViewAllBatchesAfterBatchSubmission();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		//After Batch Submission with status Pending For Publish
		sscTbcP.clickBatchAction(createdBatchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[9]/span/div/div/a/span")).getText().trim(), "View Details");
		sscTbcP.clickViewDetailsOption(createdBatchID);
		Thread.sleep(4000);
		//Verifying Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch ID')]]/td[3]")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Name')]]/td[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		//Verifying Assigned TC Details
		Assert.assertEquals(driver.findElement(By.xpath("//div[b[contains(text(),'Status of Training Centre')]]/span")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
		//Verifying Assigned Domain QP Master Trainer Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dmasterTrainerID+"')]]])[1]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dmasterTrainerID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dmasterTrainerID+"')]]])[1]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dmasterTrainerID+"')]]])[1]/td[4]")).getText().trim(), dmasterTrainerName+" ("+dmasterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dmasterTrainerID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		//Verifying Assigned Platform QP Master Trainer Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+pmasterTrainerID+"')]]])[1]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+pmasterTrainerID+"')]]])[1]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+pmasterTrainerID+"')]]])[1]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+pmasterTrainerID+"')]]])[1]/td[4]")).getText().trim(), pmasterTrainerName+" ("+pmasterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+pmasterTrainerID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		//Verifying Assigned Domain QP Assessment Agency Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[3]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[4]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		//Verifying Assigned Platform QP Assessment Agency Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[3]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[4]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods="sscBatchCreationTC_01")
	public void trainingCentreBatchApprovalTC_02(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime) throws Exception
	{
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
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Pending for Publish");
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectViewBatchDetailsOption(batchID);
		Thread.sleep(4000);
		//Asserting view Batch Details
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
		Thread.sleep(2000);
		lTcVbP.clickGoBack();
		Thread.sleep(4000);
		//Accepting batch
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectAcceptBatchOption(batchID);
		Thread.sleep(2000);
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		Thread.sleep(2000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		lTcVbP.clickOk();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! accepted batch - "+batchID+" should not be shown in pending batches section! OR Something is wrong! ");
		js.executeScript("window.scrollBy(0,-500)","");
		Thread.sleep(2000);
		//verifying Accepted Batches
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
		Assert.assertNotSame(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Accepted");
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectViewBatchDetailsOption(batchID);
		Thread.sleep(2000);
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
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
		
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods="trainingCentreBatchApprovalTC_02")
	public void masterTrainerBatchApprovalTC_03(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime) throws Exception
	{
		for(int i=1;i<3;i++)
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			LoginPage lp=new LoginPage(driver);
			lp.clickLogin();
			EnterLoginPage elp=new EnterLoginPage(driver);
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
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Pending Requests Section of Master Trainer - "+pmasterTrainerID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state );
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Pending for Publish");
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			tVp.clickToSelectViewDetailsOption(batchID);
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")')]")).isDisplayed());
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector & Sub Sector')]]/td[3]")).getText().trim(), expectedSector+" | "+subSector);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), domainJobRoleCode);
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), platformJobRole);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), platformJobRoleCode);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			tVp.clickGoBackFromBatchDetails();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(4000);
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
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 53, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 52, formatter.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 71, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 70, formatter.format(date));
			}
			Thread.sleep(4000);	
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			tVp.clickOk();
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in Pending Requests Section of Master Trainer - "+pmasterTrainerID);
			}
			//verifying accepted batches
			js.executeScript("window.scrollBy(0,-500)", "");
			Thread.sleep(2000);
			tVp.clickToGoToAcceptedBatchesSection();
			Thread.sleep(4000);
			tVp.clickToGoToAcceptedBatchesSection();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+dmasterTrainerID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+pmasterTrainerID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state );
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Published");
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			tVp.clickToSelectViewDetailsOption(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector & Sub Sector')]]/td[3]")).getText().trim(), expectedSector+" | "+subSector);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), domainJobRoleCode);
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), platformJobRole);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), platformJobRoleCode);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
		
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods="trainingCentreBatchApprovalTC_02")
	public void assessmentAgencyBatchApprovalAndAssigningAssessorsTC_04(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime) throws Exception
	{
		for(int i=1;i<3;i++)
		{
			LoginPage lp=new LoginPage(driver);
			lp.clickLogin();
			EnterLoginPage elp=new EnterLoginPage(driver);
			if(i==1)
			{
				elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
			}
			else
			{
				elp.performlogin(passessmentAgencyID, passessmentAgencyPassword);
			}
			Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
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
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+passessmentAgencyID+" Pending Requests section!!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			}
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" , "+state+"/"+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Pending for Acceptance");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), batchCreatedDate);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToSelectViewBatchDetailsOption();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(),batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]")).size()==0,"OMG!!! View Batch details - platform JobRole record should not be shown for domain job role assessment agency - "+dassessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( "+domainJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), "NA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]")).size()==0,"OMG!!! View Batch details - domain JobRole record should not be shown for platform job role assessment agency - "+passessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+"( "+platformJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), "NA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			}
			aVp.clickToGoBack();
			Thread.sleep(4000);
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			aVp.clickToApplySelectedSearchFilters();
			Thread.sleep(4000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+passessmentAgencyID+" Pending Requests section!!! ");
			}
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(4000);
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
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 59, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 58, formatter.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 77, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 76, formatter.format(date));
			}
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Request Accepted Successfully\nYou have successfully accepted\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			aVp.clickOk();
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in pending section of - "+dassessmentAgencyID+" OR something is wrong! ");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in pending section of - "+passessmentAgencyID+" OR something is wrong! ");
			}
			//verifying accepted batches & assigning assessors
			aVp.clickToViewAcceptedBatches();
			Thread.sleep(4000);
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			aVp.clickToApplySelectedSearchFilters();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+dassessmentAgencyID+" !!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+passessmentAgencyID+" !!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" , "+state+"/"+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Accepted");
			if(i==1)
			{
				String assessmentAgencyActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 58);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), assessmentAgencyActionDate);
			}
			else
			{
				String assessmentAgencyActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 76);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), assessmentAgencyActionDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), batchCreatedDate);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(4000);
			aVp.clickToSelectAssignAssessorsOption();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch ID')]]]]/div[2]/span")).getText().trim(),batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch Name')]]]]/div[4]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[1]/span")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[2]/span")).getText().trim(), "State : "+state+", District : "+district);
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[strong[contains(text(),'Job Role:')]]/span")).getText().trim(), domainJobRole);
				Assert.assertEquals(driver.findElement(By.xpath("//div[span[strong[contains(text(),'Proposed Dates')]]]/label")).getText().trim(), dAssessmentStartDate+" To "+dAssessmentEndDate);
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[strong[contains(text(),'Job Role:')]]/span")).getText().trim(), platformJobRole);
				Assert.assertEquals(driver.findElement(By.xpath("//div[span[strong[contains(text(),'Proposed Dates')]]]/label")).getText().trim(), pAssessmentStartDate+" To "+pAssessmentEndDate);
			}
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
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned Assessor for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			aVp.clickOk();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Assigned Assessor");
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			//After Assigning Master Assessor
			aVp.clickToSelectViewBatchDetailsOption();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(),batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]")).size()==0,"OMG!!! View Batch details - platform JobRole record should not be shown for domain job role assessment agency - "+dassessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( "+domainJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dmasterAssessorName+"("+dmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), "Pending");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]")).size()==0,"OMG!!! View Batch details - domain JobRole record should not be shown for platform job role assessment agency - "+passessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+"( "+platformJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().replaceAll(" ", ""), pmasterAssessorName+"("+pmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), "Pending");
			}
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
	
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods="assessmentAgencyBatchApprovalAndAssigningAssessorsTC_04")
	public void masterAssessorBatchApprovalTC_05(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime) throws Exception
	{
		for(int i=1; i<3;i++)
		{
			LoginPage lp=new LoginPage(driver);
			lp.clickLogin();
			EnterLoginPage elp=new EnterLoginPage(driver);
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
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Pending Requests Section!");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+pmasterAssessorID+" Pending Requests Section!");
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), "ToT/ToA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" - ("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+dAssessmentEndDate);
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), platformJobRole+" - ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), pAssessmentStartDate+pAssessmentEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" - "+state+","+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "For Assessment");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Pending for Acceptance");
			Thread.sleep(4000);
			maVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(4000);
			//View Batch Details Data Verification
			maVp.clickToSelectViewBatchDetailsOption(batchID);
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Name')]]]]/div[3]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch ID')]]]]/div[3]/span")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Size')]]]]/div[3]/span")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Date')]]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]")).size()==0,"OMG!!! View Batch details - platform JobRole record should not be shown for domain job role master assessor - "+dmasterAssessorID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dmasterAssessorName+" ("+dmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Pending");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]")).size()==0,"OMG!!! View Batch details - domain JobRole record should not be shown for platform job role master assessor - "+pmasterAssessorID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+" ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pmasterAssessorName+" ("+pmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Pending");
			}
			maVp.clickToGoBack();
			Thread.sleep(4000);
			Thread.sleep(4000);
			maVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(4000);
			maVp.clickToSelectAcceptBatchOption(batchID);
			Thread.sleep(4000);
			if(i==1)
			{
				maVp.enterRemarksForAcceptingBatch(dmasterAssessorRemarks);
			}
			else
			{
				maVp.enterRemarksForAcceptingBatch(pmasterAssessorRemarks);
			}
			Thread.sleep(4000);
			maVp.clickToSaveAndSubmitBatchAccceptance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 65, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 64, formatter.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 83, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 82, formatter.format(date));
			}
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			maVp.clickOk();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,-500)", "");
			Thread.sleep(4000);
			//verifying Accepted Batch
			maVp.clickToGoToAcceptedBatchesSection();
			Thread.sleep(4000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Accepted Section!");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+pmasterAssessorID+" Accepted Section!");
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), "ToT/ToA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" - ("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+dAssessmentEndDate);
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), platformJobRole+" - ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), pAssessmentStartDate+pAssessmentEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" - "+state+","+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "For Assessment");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Accepted");
			if(i==1)
			{
				String masterAssessorActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 64);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), masterAssessorActionDate);
			}
			else
			{
				String masterAssessorActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 82);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), masterAssessorActionDate);
			}
			maVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(4000);
			maVp.clickToSelectViewBatchDetailsOption(batchID);
			Thread.sleep(4000);
			if(i==1)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			}
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
	
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods= {"masterAssessorBatchApprovalTC_05","masterTrainerBatchApprovalTC_03"})
	public void sscVerifyingAllAprovedBatchesTC_06(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime) throws Exception
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
		Thread.sleep(4000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! Navigation to All Batches New PAge is unsuccessfull OR its taking too much time to load!!! ");
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.clickToViewAllPublishedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"/"+domainJobRoleCode+", "+platformJobRole+"/"+platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Published");
		sAp.clickToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		sAp.selectViewDetailsOption(batchID);
		Thread.sleep(4000);
		//Verifying Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch ID')]]/td[3]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Name')]]/td[3]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		//Verifying Accepted Training Centre Details
		Assert.assertEquals(driver.findElement(By.xpath("//div[b[contains(text(),'Status of Training Centre')]]/span")).getText().trim(), "Accepted");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
		//Verifying Accepted Domain Master Trainer Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[3]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[4]")).getText().trim(), dmasterTrainerName+" ("+dmasterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Accepted");
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		sVbP.selectViewDomainMasterTrainerCommentsOption(domainJobRoleCode);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Master Trainer')]]")).getText().trim(), "Comments by Master Trainer on "+dmasterTrainerRemarksDate+" at "+dmasterTrainerRemarksTime.toLowerCase()+": "+dmtBatchAcceptanceRemarks);
		sVbP.clickToCloseDomainMasterTrainerViewCommentsWindow();
		Thread.sleep(2000);
		//Verifying Accepted Platform Master Trainer Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[3]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[4]")).getText().trim(), pmasterTrainerName+" ("+pmasterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Accepted");
		sVbP.selectViewPlatformMasterTrainerCommentsOption(platformJobRoleCode);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Master Trainer')]]")).getText().trim(), "Comments by Master Trainer on "+pmasterTrainerRemarksDate+" at "+pmasterTrainerRemarksTime.toLowerCase()+": "+pmtBatchAcceptanceRemarks);
		sVbP.clickToClosePlatformMasterTrainerViewCommentsWindow();
		Thread.sleep(2000);
		//Verifying Accepted Domain Assessment Agency And Master Assessor Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[3]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[4]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Accepted");
		sVbP.selectViewDomainAssessmentAgencyCommentsOption(domainJobRoleCode);
		Thread.sleep(2000);
		//Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Assessment Agency')]]")).getText().trim(), "Comments by Assessment Agency on "+dassessmentAgencyRemarksDate+" at "+dassessmentAgencyRemarksTime.toLowerCase()+": "+daaBatchAcceptanceRemarks);
		sVbP.clickToCloseDomainAssessmentAgencyViewCommentsWindow();
		Thread.sleep(2000);
		//Verifying Accepted Platform Assessment Agency And Master Assessor Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[3]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[4]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Accepted");
		sVbP.selectViewPlatformAssessmentAgencyCommentsOption(platformJobRoleCode);
		Thread.sleep(2000);
		//Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Assessment Agency')]]")).getText().trim(), "Comments by Assessment Agency on "+passessmentAgencyRemarksDate+" at "+passessmentAgencyRemarksTime.toLowerCase()+": "+paaBatchAcceptanceRemarks);
		sVbP.clickToClosePlatformAssessmentAgencyViewCommentsWindow();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
		
	//Batch Rejection Flow Test Cases
	@DataProvider
	public Object[][] batchRejectionData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection");
	}
	@Test(dataProvider="batchRejectionData")
	public void rejectionBatchCreationTC_07(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole1, String domainJobRoleCode1, String domainJobRole2, String domainJobRoleCode2, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String domainJobRole2Fees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String d1masterTrainerID, String d1masterTrainerName, String d1masterTrainerPassword, String d1mtReasonForRejection, String d1mtBatchRejectionRemarks, String d1mtRemarksDate, String d1mtRemarksTime, String d2masterTrainerID, String d2masterTrainerName, String d2masterTrainerPassword, String d2mtReasonForRejection, String d2mtBatchRejectionRemarks, String d2mtRemarksDate, String d2mtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate) throws Exception
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
		Thread.sleep(4000);
		sscDbP.clickCreateBatch();
		Thread.sleep(6000);
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
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 9, trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 10, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole1);
		Thread.sleep(2000);
		sscTbcP.selectDomainJobRole(domainJobRole2);
		Thread.sleep(2000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(2000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode1+"')]")).isDisplayed(),"OMG!!! Domain QP Code not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole1+"')]")).getText().trim(), domainJobRole1);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 17, domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 18, domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 19, domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 20, domainAssessmentEndDate);
		//Domain JobRole 2 Dates
		sscTbcP.selectDomain2TrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomain2TrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomain2AssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomain2AssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomain2TrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomain2AssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomain2AssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		//Platform QP
		sscTbcP.clickToChooserPlatformQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+platformJobRoleCode+"')]")).isDisplayed(),"OMG!!! Platform QP Code not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectrPlatformTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectrPlatformTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectrPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectrPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectrPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectrPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.selectrPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 21, platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 22, platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 23, platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 24, platformAssessmentEndDate);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.clickToGetInDetailBatchFees();
		Thread.sleep(2000);
		int oneDomainAndOnePlatformQpFees=Integer.parseInt(expectedBatchFees)-Integer.parseInt(domainJobRole2Fees);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Fee Applicable for Program')]]]/td[2]")).getText().trim(), Integer.toString(oneDomainAndOnePlatformQpFees));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Technical QP(1) X Rate(800)')]]]/td[2]")).getText().trim(), domainJobRole2Fees);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Non-Technical QP(0) X Rate(600)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Total Fee of the Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(4000);
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 1, createdBatchID);
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		//STEP 2 OF BATCH CREATION -> Assigning Training Centre  and Assigning To Batches
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		Thread.sleep(4000);
		sVbP.selectStateFilter(state);
		Thread.sleep(4000);
		sVbP.selectDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		Thread.sleep(4000);
		sVbP.clickToGetSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+tcID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tpName+"')]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Thread.sleep(2000);
		sVbP.clickToChooseResultedTrainingCentreToAssign(tcID);
		Thread.sleep(4000);
		sVbP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Domain QP 1
		Thread.sleep(2000);
		sVbP.clickDomainMasterTrainerAction(domainJobRole1);
		Thread.sleep(2000);
		sVbP.selectDomainAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainMasterTrainerIDToSearch(d1masterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+d1masterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+d1masterTrainerID+" for Domain QP -"+domainJobRoleCode1);
		sVbP.clickToChooseDomainMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+d1masterTrainerID+"')]")).getText().trim(), d1masterTrainerName+" ( "+d1masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode1+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Domain QP 2
		Thread.sleep(2000);
		sVbP.clickDomainMasterTrainerAction(domainJobRole2);
		Thread.sleep(2000);
		sVbP.selectDomain2AssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainMasterTrainerIDToSearch(d2masterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+d2masterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+d2masterTrainerID+" for Domain QP -"+domainJobRole2);
		sVbP.clickToChooseDomainMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+d2masterTrainerID+"')]")).getText().trim(), d2masterTrainerName+" ( "+d2masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode2+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Platform QP
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectrPlatformAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformMasterTrainerIDToSearch(pmasterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+pmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+pmasterTrainerID+" for Platform QP -"+platformJobRoleCode);
		sVbP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+pmasterTrainerID+"')])[1]")).getText().trim(), pmasterTrainerName+" ( "+pmasterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Domain QP 1 Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole1);
		Thread.sleep(2000);
		sVbP.selectDomain1AssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dassessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+dassessmentAgencyID+" for Domain QP -"+domainJobRoleCode1);
		sVbP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+dassessmentAgencyID+"')])[1]")).getText().trim(), dassessmentAgencyName+" ( "+dassessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode1+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		//Assigning Domain QP 2 Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole2);
		Thread.sleep(2000);
		sVbP.selectDomain2AssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dassessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+dassessmentAgencyID+" for Domain QP -"+domainJobRoleCode2);
		sVbP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+dassessmentAgencyID+"')])[2]")).getText().trim(), dassessmentAgencyName+" ( "+dassessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode2+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectrPlatformAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformAssessmentAgencyIDToSearch(passessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+passessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+passessmentAgencyID+" for Platform QP -"+platformJobRoleCode);
		sVbP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+passessmentAgencyID+"')]")).getText().trim(), passessmentAgencyName+" ( "+passessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		sVbP.clickToSubmitBatch();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 2,formatter.format(date));
		Thread.sleep(4000);
		sVbP.clickViewAllBatchesAfterBatchSubmission();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void trainingCentreBatchRejectionTC_08(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole1, String domainJobRoleCode1, String domainJobRole2, String domainJobRoleCode2, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String domainJobRole2Fees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String d1masterTrainerID, String d1masterTrainerName, String d1masterTrainerPassword, String d1mtReasonForRejection, String d1mtBatchRejectionRemarks, String d1mtRemarksDate, String d1mtRemarksTime, String d2masterTrainerID, String d2masterTrainerName, String d2masterTrainerPassword, String d2mtReasonForRejection, String d2mtBatchRejectionRemarks, String d2mtRemarksDate, String d2mtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate) throws Exception
	{
		if(serialNum.equals("1"))
		{
			for(int i=1;i<4;i++)
			{
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(tcID, tcPassword);
				Thread.sleep(8000);
				LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(4000);
				Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
				lTcDp.clickToViewBatches();
				Thread.sleep(4000);
				Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batchs","OMG!!! View All Batches Card, navigation to Pending Requests section is unsuccessful OR Something went wrong! ");
				js.executeScript("window.scrollBy(0,200)","");
				Thread.sleep(2000);
				LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Pending Requests section! OR Something is wrong! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(),batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole1+" ("+domainJobRoleCode1+"),\n"+domainJobRole2+" ("+domainJobRoleCode2+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Pending for Publish");
				Thread.sleep(4000);
				lTcVbP.clikToGetBatchActionMenu(batchID);
				Thread.sleep(2000);
				lTcVbP.selectRejectBatchOption(batchID);
				Thread.sleep(4000);
				lTcVbP.selectReasonForRejectingBatch(tcReasonForRejectingBatch);
				Thread.sleep(4000);
				lTcVbP.enterRemarksForRejectingBatch(tcRejectionRemarks);
				Thread.sleep(4000);
				lTcVbP.clickToRejectBatch();
				Thread.sleep(4000);
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Request Rejected\nYou have rejected request for\nBatch - "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");	
				lTcVbP.clickOk();
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! Rejected Batch - "+batchID+" should not be shown in pending batches section! OR Something is wrong! ");
				js.executeScript("window.scrollBy(0,-500)","");
				Thread.sleep(2000);
				//verifying Rejected Batches
				lTcVbP.clickToViewAllRejectedBatches();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,200)","");
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! rejected batch - "+batchID+" is not shown in Rejected batches section! OR Something is wrong! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(),batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole1+" ("+domainJobRoleCode1+"),\n"+domainJobRole2+" ("+domainJobRoleCode2+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Rejected");
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
				//SSC Reassigning Training Centre After Rejection
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
				lp.clickLogin();
				elp.performlogin(sscUsername, sscPassword);
				Thread.sleep(12000);
				Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
				SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
				sscDbP.clickToTToAToMTToMA();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				sscDbP.clickAllBatches();
				Thread.sleep(4000);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rejected");
				SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
				sAp.clickToGetBatchActionMenu(batchID);
				Thread.sleep(2000);
				sAp.selectViewDetailsOption(batchID);
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[b[contains(text(),'Status of Training Centre')]]]]//span[1]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[b[contains(text(),'Status of Training Centre')]]]]//p[2]")).getText().trim(), tcReasonForRejectingBatch);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[b[contains(text(),'Status of Training Centre')]]]]//p[4]")).getText().trim(), tcRejectionRemarks);
				SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
				sVbP.clickReassignTC();
				Thread.sleep(2000);
				sVbP.selectStateFilter(state);
				Thread.sleep(2000);
				sVbP.selectDistrictFilter(district);
				Thread.sleep(2000);
				sVbP.enterReAssignTrainingCentreIDToSearch(tcID);
				Thread.sleep(2000);
				sVbP.clickToGetSearchFilterResult();
				Thread.sleep(2000);
				sVbP.clickToChooseResultedTrainingCentreToAssign(tcID);
				Thread.sleep(2000);
				sVbP.clickToSubmitReAssignedTC();
				Thread.sleep(2000);
				if(i==3)
				{
					Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim().equalsIgnoreCase("Cannot Assign Training Centre"));
					sVbP.clickToCancel();
				}
				else
				{
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Training Centre Assigned\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")\nis successfully assigned to   "+tcName+"\nState : "+state+"\nDistrict : "+district);	
					sVbP.clickOk();
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
				}
				Thread.sleep(2000);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
			}
		}
	}
	
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void masterTrainerBatchRejectionTC_09(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole1, String domainJobRoleCode1, String domainJobRole2, String domainJobRoleCode2, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String domainJobRole2Fees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String d1masterTrainerID, String d1masterTrainerName, String d1masterTrainerPassword, String d1mtReasonForRejection, String d1mtBatchRejectionRemarks, String d1mtRemarksDate, String d1mtRemarksTime, String d2masterTrainerID, String d2masterTrainerName, String d2masterTrainerPassword, String d2mtReasonForRejection, String d2mtBatchRejectionRemarks, String d2mtRemarksDate, String d2mtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate) throws Exception
	{
		if(serialNum.equals("2"))
		{
			for(int i=1;i<4;i++)
			{
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(d1masterTrainerID, d1masterTrainerPassword);
				Thread.sleep(4000);
				TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
				tDp.clickToGetTrainerDashboard();
				Thread.sleep(2000);
				tDp.clickAllBatches();
				Thread.sleep(4000);
				TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
				tVp.clicktoGoPendingBatchesSection();
				Thread.sleep(2000);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Pending Requests Section of Master Trainer - "+d1masterTrainerID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), domainJobRole1+"("+domainJobRoleCode1+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state );
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Pending for Publish");
				tVp.clickToGetActionMenuOptions(batchID);
				Thread.sleep(2000);
				tVp.clickToSelectRejectBatchOption(batchID);
				Thread.sleep(4000);
				tVp.selectReasonForRejectingBatch(d1mtReasonForRejection);
				Thread.sleep(2000);	
				tVp.enterRemarksForRejectingBatch(d1mtBatchRejectionRemarks);
				Thread.sleep(4000);	
				tVp.clickToSubmitBatchRejection();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 58, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 57, formatter.format(date));
				Thread.sleep(4000);	
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Request Rejected\nYou have rejected request for\nBatch - "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				tVp.clickOk();
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Rejected Batch - "+batchID+" should not be shown in Pending Requests Section of Master Trainer - "+d1masterTrainerID);
				//verifying rejected batches
				js.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(2000);
				tVp.clickToGoToRejectedBatchesSection();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,300)", "");
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Rejected Section of Master Trainer - "+d1masterTrainerID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state );
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), district);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
				tVp.clickToGetActionMenuOptions(batchID);
				Thread.sleep(2000);
				tVp.clickToSelectViewDetailsOption(batchID);
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector & Sub Sector')]]/td[3]")).getText().trim(), expectedSector+" | "+subSector);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole1);
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role Code')]]/td[3])[1]")).getText().trim(), domainJobRoleCode1);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Pending");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
				//SSC Re-Assiging Master Trainer
				lp.clickLogin();
				Thread.sleep(2000);
				elp.performlogin(sscUsername, sscPassword);
				Thread.sleep(3000);
				Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
				sDp.clickAllBatches();
				Thread.sleep(4000);
				SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
				sBp.clickToViewAllPendingBatches();
				Thread.sleep(2000);
				Assert.assertFalse(driver.findElements(By.xpath("//td[1][contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in "+sscUsername+" Pending Section!!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rejected");
				Thread.sleep(2000);
				sBp.clickToGetBatchActionMenu(batchID);
				Thread.sleep(2000);
				sBp.selectViewDetailsOption(batchID);
				Thread.sleep(2000);
				SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
				Assert.assertEquals(driver.findElement(By.xpath("//div[b[contains(text(),'Status of Training Centre')]]/span")).getText().trim(), "Pending");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode1+"')]])[1]/td[5]")).getText().trim(), "Rejected");
				sVbP.selectViewDomainMasterTrainerCommentsOption(domainJobRole1);
				Thread.sleep(2000);
				String masterTrainerRejectCommentsDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 57);
				String masterTrainerRejectCommentsTime=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 58);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Rejection Reason')]]")).getText().trim(), "Rejection Reason: "+d1mtReasonForRejection);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Master Trainer')]]")).getText().trim(), "Comments by Master Trainer on "+masterTrainerRejectCommentsDate+" at "+masterTrainerRejectCommentsTime.toLowerCase()+": "+d1mtBatchRejectionRemarks);
				sVbP.clickToCloseDomainMasterTrainerViewCommentsWindow();
				Thread.sleep(2000);
				sVbP.selectReAssignDomainMasterTrainerOption(domainJobRoleCode1);
				Thread.sleep(2000);
				sVbP.selectReAssignMasterTrainerState(state);
				Thread.sleep(2000);
				sVbP.selectReAssignMasterTrainerDistrict(district);
				Thread.sleep(2000);
				sVbP.enterDomainMasterTrainerIDToSearch(d1masterTrainerID);
				Thread.sleep(2000);
				sVbP.clickToGetSearchFilterResult();
				Thread.sleep(2000);
				sVbP.clickToChooseReAssignDomainMasterTrainer();
				Thread.sleep(2000);
				sVbP.clickToFinallyReAsssignSelectedDomainMasterTrainer();
				Thread.sleep(2000);
				if(i==3)
				{
					Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().equals("Cannot Assign Master Trainer"), "OMG!!! There is no toast message regarding Cannot Reassign Master Trainer for this Batch - "+batchID+" as 3 times this batch got rejected by master trainer - "+d1masterTrainerID+" !!!!  ");
					sVbP.clickToCancel();
					Thread.sleep(4000);
				}
				else
				{
					//Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), batchID+"\nis successfully assigned to   "+d1masterTrainerID+"\nState : "+state+"\nDistrict : "+district);
					sVbP.clickOk();
					Thread.sleep(2000);
					//after Reassign, batch status should not be rejected
					js.executeScript("window.scrollBy(0,-1000)", "");
					Thread.sleep(4000);
					sDp.clickToTToAToMTToMA();
					Thread.sleep(4000);
					sDp.clickAllBatches();
					Thread.sleep(4000);
					sBp.clickToViewAllPendingBatches();
					Thread.sleep(4000);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
				}
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
			}
		}
	}
		
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void assessmentAgencyBatchRejectionTC_10(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole1, String domainJobRoleCode1, String domainJobRole2, String domainJobRoleCode2, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String domainJobRole2Fees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String d1masterTrainerID, String d1masterTrainerName, String d1masterTrainerPassword, String d1mtReasonForRejection, String d1mtBatchRejectionRemarks, String d1mtRemarksDate, String d1mtRemarksTime, String d2masterTrainerID, String d2masterTrainerName, String d2masterTrainerPassword, String d2mtReasonForRejection, String d2mtBatchRejectionRemarks, String d2mtRemarksDate, String d2mtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate) throws Exception
	{
		if(serialNum.equals("3"))
		{
			for(int i=1;i<4;i++)
			{
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
				Thread.sleep(2000);
				JavascriptExecutor js=(JavascriptExecutor)driver;
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
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole1+"("+domainJobRoleCode1+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" , "+state+"/"+district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Pending for Acceptance");
				if(i==1)
				{
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), batchCreatedDate);
				}
				else
				{
					String reAssignedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 101);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), reAssignedDate);
				}
				aVp.clickToGetActionMenuOptions();
				Thread.sleep(2000);
				aVp.clickToSelectRejectBatchOption();
				Thread.sleep(4000);
				aVp.selectReasonForRejectingBatch(daaReasonForRejectingBatch);
				Thread.sleep(2000);
				aVp.enterRemarksForRejctingBatch(daaRejectionRemarks);
				Thread.sleep(4000);
				aVp.clickToSubmitBatchRejection();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 72, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 71, formatter.format(date));
				Thread.sleep(4000);	
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Rejected\nYou have rejected request for\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				aVp.clickOk();
				Thread.sleep(4000);	
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Rejected Batch - "+batchID+" should not be shown in pending section of - "+dassessmentAgencyID+" OR something is wrong! ");
				//verifying rejected batches
				js.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(2000);
				aVp.clickToViewRejectedBatches();
				Thread.sleep(4000);
				aVp.enterBatchIdToSearch(batchID);
				Thread.sleep(2000);
				aVp.clickToApplySelectedSearchFilters();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+dassessmentAgencyID+" !!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" , "+state+"/"+district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				String rejectedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 71);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), rejectedDate);
				if(i==1)
				{
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), batchCreatedDate);
				}
				else
				{
					String reAssignedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 101);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), reAssignedDate);
				}
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
				//SSC ReAssiging AA
				lp.clickLogin();
				Thread.sleep(2000);
				elp.performlogin(sscUsername, sscPassword);
				Thread.sleep(8000);
				Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
				sDp.clickAllBatches();
				Thread.sleep(4000);
				SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
				sBp.clickToViewAllPendingBatches();
				Thread.sleep(2000);
				Assert.assertFalse(driver.findElements(By.xpath("//td[1][contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in "+sscUsername+" Pending Section!!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rejected");
				sBp.clickToGetBatchActionMenu(batchID);
				Thread.sleep(2000);
				sBp.selectViewDetailsOption(batchID);
				Thread.sleep(2000);
				SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode1+"')]])[2]/td[5]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode2+"')]])[2]/td[5]")).getText().trim(), "Rejected");
				sVbP.selectViewDomainAssessmentAgencyCommentsOption(domainJobRoleCode1);
				Thread.sleep(2000);
				String rejectectionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 71);
				String rejectionTime=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 72);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Rejection Reason')]]")).getText().trim(), "Rejection Reason: "+daaReasonForRejectingBatch);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Assessment Agency')]]")).getText().trim(), "Comments by Assessment Agency on "+rejectectionDate+" at "+rejectionTime.toLowerCase()+": "+daaRejectionRemarks);
				//Domain Job Role 1 - Assessment Agency
				sVbP.clickToCloseDomainAssessmentAgencyViewCommentsWindow();
				Thread.sleep(2000);
				sVbP.selectReAssignDomainAssessmentAgencyOption(domainJobRoleCode1);
				Thread.sleep(2000);
				sVbP.selectReAssignAssessmentAgencyState(state);
				Thread.sleep(2000);
				sVbP.selectReAssignAssessmentAgencyDistrict(district);
				Thread.sleep(2000);
				sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
				Thread.sleep(2000);
				sVbP.clickToGetSearchFilterResult();
				Thread.sleep(2000);
				sVbP.clickToChooseReAssignDomainAssessmentAgency();
				Thread.sleep(2000);
				sVbP.clickToFinallyReAsssignSelectedDomainAssessmentAgency();
				Thread.sleep(2000);
				if(i==3)
				{
					Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().equals("Cannot Assign Assessment Agency"), "OMG!!! There is no toast message regarding Cannot Reassign Assessment Agency for this Batch - "+batchID+" as 3 times this batch got rejected by Assessment Agency - "+dassessmentAgencyID+" !");
					sVbP.clickToCancel();
					Thread.sleep(2000);
				}
				else
				{
					//Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), batchID+"\nis successfully assigned to   "+dassessmentAgencyName+"\nState : "+state+"\nDistrict :"+district);
					sBp.clickOk();
					Thread.sleep(4000);
					//ReAssigning Assessment Agency For Domain Job Role 2
					sVbP.selectReAssignAssessmentAgencyOptionForDomainJobRole2(domainJobRoleCode2);
					Thread.sleep(2000);
					sVbP.selectReAssignDomainJobRole2AssessmentAgencyState(state);
					Thread.sleep(2000);
					sVbP.selectReAssignDomainJobRole2AssessmentAgencyDistrict(district);
					Thread.sleep(2000);
					sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
					Thread.sleep(2000);
					sVbP.clickToGetDomainJobRole2AssessmentAgencyFilterResult();
					Thread.sleep(2000);
					sVbP.clickToChooseReAssignDomainJobrole2AssessmentAgency();
					Thread.sleep(2000);
					sVbP.clickToFinallyReAsssignSelectedDomainJobRole2AssessmentAgency();
					ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 101, formatter.format(date));
					Thread.sleep(2000);
					//Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), batchID+"\nis successfully assigned to   "+dassessmentAgencyName+"\nState : "+state+"\nDistrict :"+district);
					sBp.clickOk();
					Thread.sleep(2000);
					//after Reassign, batch status should not be rejected
					js.executeScript("window.scrollBy(0,-500)", "");
					Thread.sleep(2000);
					sDp.clickToTToAToMTToMA();
					Thread.sleep(4000);
					sDp.clickAllBatches();
					Thread.sleep(2000);
					sBp.clickToViewAllPendingBatches();
					Thread.sleep(4000);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
				}
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
			}
		}
	}
	
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void masterAssessorBatchRejectionTC_11(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole1, String domainJobRoleCode1, String domainJobRole2, String domainJobRoleCode2, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String domainJobRole2Fees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String d1masterTrainerID, String d1masterTrainerName, String d1masterTrainerPassword, String d1mtReasonForRejection, String d1mtBatchRejectionRemarks, String d1mtRemarksDate, String d1mtRemarksTime, String d2masterTrainerID, String d2masterTrainerName, String d2masterTrainerPassword, String d2mtReasonForRejection, String d2mtBatchRejectionRemarks, String d2mtRemarksDate, String d2mtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate) throws Exception
	{
		if(serialNum.equals("4"))
		{
			for(int i=1; i<4;i++)
			{
				if(i==1)
				{
					LoginPage lp=new LoginPage(driver);
					lp.clickLogin();
					EnterLoginPage elp=new EnterLoginPage(driver);
					elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
					Thread.sleep(2000);
					JavascriptExecutor js=(JavascriptExecutor)driver;
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
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
					js.executeScript("window.scrollBy(0,200)", "");
					Thread.sleep(2000);
					aVp.clickToGetActionMenuOptions();
					Thread.sleep(2000);
					aVp.clickToSelectAcceptBatchOption();
					Thread.sleep(2000);
					aVp.enterRemarksForAcceptingBatch("Accepted By DAA");
					Thread.sleep(2000);		
					aVp.clickToSubmitBatchAcceptance();
					Thread.sleep(2000);
					aVp.clickOk();
					Thread.sleep(2000);
					//verifying accepted batches & assigning assessors
					aVp.clickToViewAcceptedBatches();
					Thread.sleep(4000);
					aVp.enterBatchIdToSearch(batchID);
					Thread.sleep(2000);
					aVp.clickToApplySelectedSearchFilters();
					Thread.sleep(4000);
					js.executeScript("window.scrollBy(0,200)", "");
					Thread.sleep(2000);
					aVp.clickToGetActionMenuOptions();
					Thread.sleep(4000);
					aVp.clickToSelectAssignAssessorsOption();
					Thread.sleep(4000);
					aVp.selectMasterAssessorForDomain1(dmasterAssessorName+"("+dmasterAssessorID+")");
					Thread.sleep(2000);
					aVp.selectMasterAssessorForDomain2(dmasterAssessorName+"("+dmasterAssessorID+")");
					Thread.sleep(2000);
					aVp.clickToSubmitMasterAssessors();
					Thread.sleep(4000);
					aVp.clickOk();
					Thread.sleep(4000);
					PostLoginPage plp=new PostLoginPage(driver);
					plp.clickOnProfileLogo();
					Thread.sleep(2000);
					plp.clickOnLogout();
					Thread.sleep(2000);
				}
				//Assigned Master Assessor Rejecting Batch
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				Thread.sleep(2000);
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
				Thread.sleep(8000);
				AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
				maDp.clickToGetAssessorDashboard();
				Thread.sleep(2000);
				maDp.clickBatchAssessmentRequests();
				Thread.sleep(4000);
				AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
				maVp.clicktoGoToPendingRequestsSection();
				Thread.sleep(4000);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Pending Requests Section!");
				Thread.sleep(4000);
				maVp.clickToGetActionMenuOptions(batchID);
				Thread.sleep(2000);
				maVp.clickToSelectRejectBatchOption(batchID);
				Thread.sleep(4000);
				maVp.selectReasonForRejectingBatch(dmaReasonForRejectingBatch);
				Thread.sleep(2000);
				maVp.enterRemarksForRejectingBatch(dmaRejectionRemarks);
				Thread.sleep(2000);
				maVp.clickToSaveAndSubmitBatchRejection();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 79, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 78, formatter.format(date));
				Thread.sleep(4000);	
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Request Rejected\nYou have rejected request for\nBatch - "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				maVp.clickOk();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(4000);
				//verifying Rejected Batch
				maVp.clickToGoToRejectedBatchesSection();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(4000);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Rejected Section!");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), "ToT/ToA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole1+" - ("+domainJobRoleCode1+"), "+domainJobRole2+" - ("+domainJobRoleCode2+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" - "+state+","+district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "For Assessment");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+dAssessmentEndDate+" "+dAssessmentStartDate+dAssessmentEndDate);
				String rejectedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 78);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), rejectedDate);
				//View Batch Details - Rejected Status for Master Assessor
				maVp.clickToGetActionMenuOptions(batchID);
				Thread.sleep(2000);
				maVp.clickToSelectViewBatchDetailsOption(batchID);
				Thread.sleep(4000);
				//Rejected Batch Details Verification
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Name')]]]]/div[3]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch ID')]]]]/div[3]/span")).getText().trim(), batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Size')]]]]/div[3]/span")).getText().trim(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Date')]]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]")).size()==0,"OMG!!! View Batch details - platform JobRole record should not be shown for domain job role master assessor - "+dmasterAssessorID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[2]")).getText().trim(), domainJobRole1+" ("+domainJobRoleCode1+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[3]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[4]")).getText().trim(), dmasterAssessorName+" ("+dmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[6]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole2+"')]]/td[2]")).getText().trim(), domainJobRole2+" ("+domainJobRoleCode2+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole2+"')]]/td[3]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole2+"')]]/td[4]")).getText().trim(), dmasterAssessorName+" ("+dmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole2+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole2+"')]]/td[6]")).getText().trim(), "Rejected");
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(4000);
				//ReAssigning Master Assessor By Assessment Agency
				lp.clickLogin();
				elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,200)", "");
				Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagency","Login Unsuccessful!!! ");
				Thread.sleep(4000);
				AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
				aDp.clickBatchAssessmentRequests();
				Thread.sleep(2000);
				AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
				aVp.clickToViewAcceptedBatches();
				Thread.sleep(4000);
				aVp.enterBatchIdToSearch(batchID);
				Thread.sleep(2000);
				aVp.clickToApplySelectedSearchFilters();
				Thread.sleep(4000);
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Accepted Requests section!!! ");
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Rejected by Assessor");
				aVp.clickToGetActionMenuOptions();
				Thread.sleep(4000);
				aVp.clickToSelectViewBatchDetailsOption();
				Thread.sleep(4000);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[5]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole2+"')]]/td[5]")).getText().trim(), "Rejected");
				aVp.clickToGetActionMenuOptions();
				Thread.sleep(2000);
				aVp.selectViewCommentsOfMasterAssessorOption();
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Comments by Assessor on')]]]]/div[1]")).getText().trim(), "Comments by Assessor on "+rejectedDate+" :");
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Comments by Assessor on')]]]]/div[2]")).getText().trim(), dmaRejectionRemarks);
				aVp.clickToCloseViewComments();
				Thread.sleep(4000);
				aVp.clickToGetActionMenuOptions();
				Thread.sleep(4000);
				aVp.selectReAssignMasterAssessorOption();
				Thread.sleep(4000);
				//Verifying Batch Details
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch ID')]]]]/div[2]/span")).getText().trim(),batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch Name')]]]]/div[4]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//div[span[strong[contains(text(),'Training Centre Name')]]]")).getText().trim(), "Training Centre Name & Location : "+tcName);
				Assert.assertEquals(driver.findElement(By.xpath("//div[strong[contains(text(),'State')]]")).getText().trim(), "State : "+state);
				Assert.assertEquals(driver.findElement(By.xpath("//div[span[strong[contains(text(),'District')]]]")).getText().trim(), "District : "+district);
				Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+domainJobRoleCode1+"')]")).getText().trim(), domainJobRoleCode1);
				Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+dAssessmentStartDate+" to')]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				aVp.selectReAssignMasterAssessorForDomain(dmasterAssessorName, dmasterAssessorID);
				Thread.sleep(2000);
				aVp.clickToSubmitReAssignedMasterAssessor();
				Thread.sleep(4000);
				if(i==3)
				{
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Cannot Assign Assessor");
					aVp.clickToCancel();
				}
				else
				{
					Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned "+dmasterAssessorName+" ("+dmasterAssessorID+") for the "+batchID);
					aVp.clickOk();
					Thread.sleep(4000);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[3]")).getText().trim(), dmasterAssessorName+"("+dmasterAssessorID+")");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole1+"')]]/td[5]")).getText().trim(), "Pending");
				}
				Thread.sleep(4000);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(4000);
			}
		}
	}
	
	@DataProvider
	public Object[][] rescheduleCancelBatchData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel");
	}
	@Test(dataProvider="rescheduleCancelBatchData")
	public void rescheduleCancelBatchCreationTC_12(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments) throws Exception
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
		Thread.sleep(4000);
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
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 9, trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 10, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(2000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(2000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 15, domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 16, domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 17, domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 18, domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 19, platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 20, platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 21, platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 22, platformAssessmentEndDate);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast-message']")).size()==0,"OMG!!! Toast Error Message present, Unable to create Batch! May be some data not entered OR Something went wrong! ");
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 1, createdBatchID);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//STEP 2 OF BATCH CREATION -> Assigning Training Centre  and Assigning To Batches
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		Thread.sleep(4000);
		sVbP.selectStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		Thread.sleep(4000);
		sVbP.clickToGetSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+tcID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+tcID);
		Thread.sleep(2000);
		sVbP.clickToChooseResultedTrainingCentreToAssign(tcID);
		Thread.sleep(4000);
		sVbP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		//Assigning Master Trainer for Domain QP
		Thread.sleep(2000);
		sVbP.clickDomainMasterTrainerAction(domainJobRole);
		Thread.sleep(2000);
		sVbP.selectDomainAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterDomainMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseDomainMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectPlatformAssignMasterTrainerOption();
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(2000);
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
		sVbP.enterDomainAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		Thread.sleep(2000);
		sVbP.selectPlatformAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sVbP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sVbP.enterPlatformAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(2000);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		sVbP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(2000);
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		sVbP.clickToSubmitBatch();
		Thread.sleep(4000);
		sVbP.clickOkForBatchSubmission();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel", Integer.parseInt(serialNum), 2,formatter.format(date));
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="rescheduleCancelBatchCreationTC_12")
	public void rescheduleCancelBatchApprovalTC_13(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments) throws Exception
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
		lTcVbP.enterRemarksForAcceptingBatch("TC Accepted Batch");
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
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(masterTrainerID, masterTrainerPassword);
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
		tVp.enterRemarksForAcceptingBatch("MT Accepted Batch");
		Thread.sleep(4000);	
		tVp.clickToSubmit();
		Thread.sleep(2000);	
		tVp.clickOk();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//Assigned Assessment Agency Login to Accept and assigning master assessors for a batch
		lp.clickLogin();
		elp.performlogin(assessmentAgencyID, assessmentAgencyPassword);
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
		aVp.enterRemarksForAcceptingBatch("AA Accepetd Batch");
		Thread.sleep(2000);		
		aVp.clickToSubmitBatchAcceptance();
		Thread.sleep(2000);
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
		aVp.selectMasterAssessorForDomain1(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(2000);
		aVp.selectMasterAssessorForDomain2(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(2000);
		aVp.clickToSubmitMasterAssessors();
		Thread.sleep(4000);
		aVp.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//Master Assessor Login to Accept Batches
		lp.clickLogin();
		elp.performlogin(masterAssessorID, masterAssessorPassword);
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
		maVp.enterRemarksForAcceptingBatch("MA Accepted Batch ");
		Thread.sleep(2000);
		maVp.clickToSaveAndSubmitBatchAccceptance();
		Thread.sleep(4000);
		maVp.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="rescheduleCancelBatchApprovalTC_13")
	public void sscRejectingBatchRescheduleRequestTC_14(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments) throws Exception
	{
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
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectRaiseRescheduleRequestOption(batchID);
		Thread.sleep(4000);
		lTcVbP.clickToBrowseForBatchRescheduleSupportingDocument();
		Thread.sleep(4000);
		UploadFile.upload(batchRescheduleSupportingDocument);
		Thread.sleep(4000);
		lTcVbP.clickToUploadBatchRescheduleSupportingDocument();
		Thread.sleep(6000);
		lTcVbP.enterCommentsForBatchReschedule(batchRescheduleComments);
		Thread.sleep(4000);
		lTcVbP.clickToSubmitBatchreschedule();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Reschedule request Raised");
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Reschedule request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been sent to SSC.");
		lTcVbP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Reschedule");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//SSC Rejecting Batch Reschedule
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! Navigation to All Batches New PAge is unsuccessfull OR its taking too much time to load!!! ");
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.clickToViewAllPublishedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"/"+domainJobRoleCode+", "+platformJobRole+"/"+platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Reschedule");
		sAp.clickToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		sAp.selectApproveOrRejectRescheduleRequestOption(batchID);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchRescheduleSupportingDocument+"')])[1]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[1]")).getText().trim(), batchRescheduleComments);
		sAp.clickToRejectBatchRescheduleRequest();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Request Rejected");
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Reschedule request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") "+batchID+" has been rejected");
		sAp.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Published");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//TC checking status of Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(tcID, tcPassword);
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Published");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
	}
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscRejectingBatchRescheduleRequestTC_14")
	public void sscApprovingBatchRescheduleRequestButNotUpdatingBatchDurationTC_15(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments) throws Exception
	{
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
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectRaiseRescheduleRequestOption(batchID);
		Thread.sleep(4000);
		lTcVbP.clickToBrowseForBatchRescheduleSupportingDocument();
		Thread.sleep(4000);
		UploadFile.upload(batchRescheduleSupportingDocument);
		Thread.sleep(4000);
		lTcVbP.clickToUploadBatchRescheduleSupportingDocument();
		Thread.sleep(6000);
		lTcVbP.enterCommentsForBatchReschedule(batchRescheduleComments);
		Thread.sleep(4000);
		lTcVbP.clickToSubmitBatchreschedule();
		Thread.sleep(4000);
		lTcVbP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Reschedule");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//SSC Approving Batch Reschedule and not changing Dates
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! Navigation to All Batches New PAge is unsuccessfull OR its taking too much time to load!!! ");
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.clickToViewAllPublishedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"/"+domainJobRoleCode+", "+platformJobRole+"/"+platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Reschedule");
		sAp.clickToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		sAp.selectApproveOrRejectRescheduleRequestOption(batchID);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchRescheduleSupportingDocument+"')])[1]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[1]")).getText().trim(), batchRescheduleComments);
		sAp.clickToApproveBatchRescheduleRequest();
		Thread.sleep(2000);
		sAp.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='sector']")).getAttribute("value").trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='subSector'])[1]")).getAttribute("value").trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='subSector'])[2]")).getAttribute("value").trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='reAssessmentBatch']")).getAttribute("value").trim(), batchCategory);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='batchstart']")).getAttribute("value").trim(), batchStartDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='batchendDate']")).getAttribute("value").trim(), batchEndDate.replaceAll("-", "/"));
		Assert.assertTrue(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+domainJobRoleCode+"')]]]//input[@type='radio']")).isSelected());
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+domainJobRoleCode+"')]]]/td[2]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+domainJobRoleCode+"')]]]/td[3]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='trainingStart'])[1]")).getAttribute("value").trim(), dTrainingStartDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='trainingEnd'])[1]")).getAttribute("value").trim(), dTrainingEndDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='assesmentStart'])[1]")).getAttribute("value").trim(), dAssessmentStartDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='assesmentEnd'])[1]")).getAttribute("value").trim(), dAssessmentEndDate.replaceAll("-", "/"));
		Assert.assertTrue(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+platformJobRoleCode+"')]]]//input[@type='radio']")).isSelected());
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+platformJobRoleCode+"')]]]/td[2]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+platformJobRoleCode+"')]]]/td[3]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='trainingStart'])[2]")).getAttribute("value").trim(), pTrainingStartDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='trainingEnd'])[2]")).getAttribute("value").trim(), pTrainingEndDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='assessmentStart'])[1]")).getAttribute("value").trim(), pAssessmentStartDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='assessmentEnd'])[1]")).getAttribute("value").trim(), pAssessmentEndDate.replaceAll("-", "/"));
		SSC_BatchReSchedulePage sRp=new SSC_BatchReSchedulePage(driver);
		sRp.clickToSubmitRescheduledBatch();
		Thread.sleep(4000);
		sRp.clickOk();
		Thread.sleep(4000);
		sAp.clickToViewAllPublishedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rescheduled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//TC checking status of ReScheduled Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(tcID, tcPassword);
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Rescheduled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscApprovingBatchRescheduleRequestButNotUpdatingBatchDurationTC_15")
	public void sscApprovingBatchRescheduleRequestAndUpdatingBatchDurationTC_16(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments) throws Exception
	{
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
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectRaiseRescheduleRequestOption(batchID);
		Thread.sleep(4000);
		lTcVbP.clickToBrowseForBatchRescheduleSupportingDocument();
		Thread.sleep(4000);
		UploadFile.upload(batchRescheduleSupportingDocument);
		Thread.sleep(4000);
		lTcVbP.clickToUploadBatchRescheduleSupportingDocument();
		Thread.sleep(6000);
		lTcVbP.enterCommentsForBatchReschedule(batchRescheduleComments);
		Thread.sleep(4000);
		lTcVbP.clickToSubmitBatchreschedule();
		Thread.sleep(4000);
		lTcVbP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Reschedule");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//Now SSC Will Approve Reschedule request and Changes the batch dates
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! Navigation to All Batches New PAge is unsuccessfull OR its taking too much time to load!!! ");
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.clickToViewAllPublishedBatches();		
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"/"+domainJobRoleCode+", "+platformJobRole+"/"+platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Reschedule");
		sAp.clickToGetBatchActionMenu(batchID);
		Thread.sleep(2000);		
		sAp.selectApproveOrRejectRescheduleRequestOption(batchID);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchRescheduleSupportingDocument+"')])[1]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[1]")).getText().trim(), batchRescheduleComments);
		sAp.clickToApproveBatchRescheduleRequest();
		Thread.sleep(2000);	
		sAp.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-newreschedule-batch"+batchID,"OMG!!! Navigation to Reschedule Batch Page is unsuccessful OR Something went wrong! ");
		SSC_BatchReSchedulePage sRp=new SSC_BatchReSchedulePage(driver);		
		sRp.selectTrainingStartDateForBatch();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sRp.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sRp.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String rTrainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 38, rTrainingStartDate);
		String rTrainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 39, rTrainingEndDate);
		//Domain QP		
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sRp.selectDomainTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sRp.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sRp.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sRp.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}		
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sRp.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sRp.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sRp.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
		}
		String rDomainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String rDomainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String rDomainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String rDomainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 40, rDomainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 41, rDomainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 42, rDomainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 43, rDomainAssessmentEndDate);
		//Platform QP
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sRp.selectPlatformTrainingStartDate();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sRp.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sRp.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sRp.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
		}		
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sRp.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sRp.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sRp.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
		}		
		String rPlatformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String rPlatformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String rPlatformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String rPlatformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 44, rPlatformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 45, rPlatformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 46, rPlatformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 47, rPlatformAssessmentEndDate);
		sRp.clickToSubmitRescheduledBatch();
		Thread.sleep(4000);
		sRp.clickOk();
		Thread.sleep(4000);
		sAp.clickToViewAllPublishedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rTrainingStartDate+" - "+rTrainingEndDate);
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rescheduled");
		sAp.clickToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		sAp.selectViewDetailsOption(batchID);
		Thread.sleep(4000);
		//Verifying Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch ID')]]/td[3]")).getText().trim(), batchID);
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Name')]]/td[3]")).getText().trim(), batchType+"/"+rTrainingStartDate+" to "+rTrainingEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), rTrainingStartDate+" to "+rTrainingEndDate);
		//Verifying Accepted Training Centre Details
		Assert.assertEquals(driver.findElement(By.xpath("//div[b[contains(text(),'Status of Training Centre')]]/span")).getText().trim(), "Accepted");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
		//Verifying Accepted Domain Master Trainer Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[3]")).getText().trim(), rDomainTrainingStartDate+" to "+rDomainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Accepted");
		//Verifying Accepted Platform Master Trainer Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[3]")).getText().trim(), rPlatformTrainingStartDate+" to "+rPlatformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Accepted");
		//Verifying Accepted Domain Assessment Agency And Master Assessor Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[3]")).getText().trim(), rDomainAssessmentStartDate+" to "+rDomainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Accepted");
		//Verifying Accepted Platform Assessment Agency And Master Assessor Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[3]")).getText().trim(), rPlatformAssessmentStartDate+" to "+rPlatformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Accepted");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//TC checking status of ReScheduled Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(tcID, tcPassword);
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rTrainingStartDate+" to "+rTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Rescheduled");
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectViewBatchDetailsOption(batchID);
		Thread.sleep(4000);
		//Asserting view Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID:')]]]/label[2]")).getText().trim(), batchID);
		//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Name:')]]]/label[2]")).getText().trim(), batchType+"/"+rTrainingStartDate+" to "+rTrainingEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Size:')]]]/label[2]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Date')]]]/label[2]")).getText().trim(), rTrainingStartDate.replaceAll("-", "/")+" to "+rTrainingEndDate.replaceAll("-", "/"));
		//Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Type:')]]]/label[2]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[2]")).getText(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[3]")).getText(), rDomainTrainingStartDate+" to "+rDomainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleCode+"')]]/td[4]")).getText(), rDomainAssessmentStartDate+" to "+rDomainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRoleCode+"')]]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText(), rPlatformTrainingStartDate+" to "+rPlatformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText(), rPlatformAssessmentStartDate+" to "+rPlatformAssessmentEndDate);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscApprovingBatchRescheduleRequestAndUpdatingBatchDurationTC_16")
	public void sscRejectingBatchCancellationRequestTC_17(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments) throws Exception
	{
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
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectRaiseCancellationRequest(batchID);
		Thread.sleep(4000);
		lTcVbP.clickToBrowseForBatchCancellationSupportingDocument();
		Thread.sleep(4000);
		UploadFile.upload(batchCancellationSupportingDocument);
		Thread.sleep(4000);
		lTcVbP.clickToUploadBatchCancellationSupportingDocument();
		Thread.sleep(6000);
		lTcVbP.enterCommentsForBatchCancellation(batchCancellationComments);
		Thread.sleep(4000);
		lTcVbP.clickToSubmitBatchCancellation();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Cancellation Request Raised\nCancellation request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been sent to SSC");
		lTcVbP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rescheduledBatchStartDate+" to "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Cancellation");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//SSC Rejecting Cancellation Request
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! Navigation to All Batches New PAge is unsuccessfull OR its taking too much time to load!!! ");
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.clickToViewAllPublishedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"/"+domainJobRoleCode+", "+platformJobRole+"/"+platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Cancellation");
		sAp.clickToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		sAp.selectApproveOrRejectCancellationRequestOption(batchID);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchCancellationSupportingDocument+"')])[2]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[2]")).getText().trim(), batchCancellationComments);
		sAp.clickToRejectBatchCancellationRequest();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Rejected\nCancellation request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") "+batchID+" has been rejected");
		sAp.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rescheduled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//TC checking status of Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(tcID, tcPassword);
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rescheduledBatchStartDate+" to "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Rescheduled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscRejectingBatchCancellationRequestTC_17")
	public void sscApprovingBatchCancellationRequestTC_18(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments) throws Exception
	{
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
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectRaiseCancellationRequest(batchID);
		Thread.sleep(4000);
		lTcVbP.clickToBrowseForBatchCancellationSupportingDocument();
		Thread.sleep(4000);
		UploadFile.upload(batchCancellationSupportingDocument);
		Thread.sleep(4000);
		lTcVbP.clickToUploadBatchCancellationSupportingDocument();
		Thread.sleep(6000);
		lTcVbP.enterCommentsForBatchCancellation(batchCancellationComments);
		Thread.sleep(4000);
		lTcVbP.clickToSubmitBatchCancellation();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Cancellation Request Raised\nCancellation request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been sent to SSC");
		lTcVbP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rescheduledBatchStartDate+" to "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Cancellation");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//SSC Approving Cancellation Request
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! Navigation to All Batches New PAge is unsuccessfull OR its taking too much time to load!!! ");
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.clickToViewAllPublishedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"/"+domainJobRoleCode+", "+platformJobRole+"/"+platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Cancellation");
		sAp.clickToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		sAp.selectApproveOrRejectCancellationRequestOption(batchID);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchCancellationSupportingDocument+"')])[2]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[2]")).getText().trim(), batchCancellationComments);
		sAp.clickToApproveBatchCancellationRequest();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Batch Cancelled Successfully!!\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been cancelled");
		sAp.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Cancelled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//TC checking status of Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(tcID, tcPassword);
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rescheduledBatchStartDate+" to "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Cancelled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
	}
	
	//Batch Full Test Case
	@DataProvider
    public Object[][] totApplicantsData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants");
    }
    @Test(dataProvider="totApplicantsData", dependsOnMethods={"masterAssessorBatchApprovalTC_05", "masterTrainerBatchApprovalTC_03"})
    public void batchFullTC_19(String serialNum,String createdTrainerID,String userType, String name, String email, String mobile, String emailOTP, String mobileOTP,String oldPassword, String newPassword, String confirmPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String education3, String edu_details3, String edu_document3, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String industrial_sector3, String industrial_years3, String industrial_months3, String industrialExperienceDetails3, String industriesDetails3, String industrialDocument3, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String training_sector3, String trainingExperienceYears3, String trainingExperienceMonths3, String trainingExperienceDetails3, String trainingDocument3, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String preferredSector3, String preferredSubSector3, String preferredJobRole3, String preferredJobRoleCode3, String preferredState3, String preferredDistrict3, String preferredSubDistrict3, String paymentMode, String bankName, String paymentReferenceNumber, String paymentDate, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1")||serialNum.equals("2"))
	   	{
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", 1, 1);
 	   		String tcID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 0);
			String tcPassword=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 1);
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   		LoginPage lp=new LoginPage(driver);
 	   		lp.clickLogin();
 	   		EnterLoginPage elp=new EnterLoginPage(driver);
 	   		//Applicant Applying for batch
			elp.performlogin(createdTrainerID, "Qwerty@123");
			Thread.sleep(8000);
			TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerapplicant"," Login Unsuccessfull!! OR Its taking too much time to load!!! ");
			tDp.clickToGetApplicantDashboard();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(4000);
			tDp.clickSearchAndApplyforAvailableBatches();
			Thread.sleep(4000);
			TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
			tSp.selectState(state);
			Thread.sleep(2000);
			tSp.selectSector(preferredSector1);
			Thread.sleep(4000);
			tSp.clickSearch();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			tSp.clickToGetBatchActionMenu(batchID);
			Thread.sleep(4000);
			tSp.selectApplyToBatch(batchID);
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully");
			tSp.clickOK();  
			Thread.sleep(4000);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(6000);
 	   		//TC Approving Applicants
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
 	   		Thread.sleep(4000);
 	   		tcVp.clickToGetApplicantActionMenu(createdTrainerID);
 	   		Thread.sleep(4000);
 	   		tcVp.selectEnrollApplicantOption(createdTrainerID);
 	   		Thread.sleep(4000);
 	   		if(serialNum.equals("2"))
 	   		{
 	   			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Can not enroll more candidates than batch size, please check total number of enrolled / approved candidates count");
 	   		}
 	   		else
 	   		{
 	   			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved successfully"),"OMG!!! Applicant Enroll Successfull Popup Text not displayed OR Something went wrong! ");
 	   			tcVp.clickOk();
 	   			Thread.sleep(4000);
 	   		}
 	   		plp.clickOnProfileLogo();
 	   		Thread.sleep(2000);
 	   		plp.clickOnLogout();
 	   		Thread.sleep(6000);
 	   	}
	}
    
    @Test(dataProvider="sscBatchCreationData", dependsOnMethods="batchFullTC_19")
    public void sendBackBatchTC_20(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime) throws Exception
    {
    	if(serialNum.equals("1"))
    	{
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
        	LoginPage lp=new LoginPage(driver);
        	lp.clickLogin();
        	Thread.sleep(2000);
     	   	EnterLoginPage elp=new EnterLoginPage(driver);
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
     	   	tcVp.clickToGoToEnrolledApplicantsSection();
     	   	Thread.sleep(4000);
     	   	String applicantID =ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 1);
     	   	String applicantName =ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 3);
     	   	String applicantEmail =ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 4);
     	   	String applicantMobile =ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 1, 5);
     	   	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]")).size()==1,"OMG!!! No show of Enrolled Assessor Applicant - "+applicantID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
     	   	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+applicantID+"']")).getText().trim(), applicantID);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[contains(text(),'"+applicantName+"')]")).getText().trim(), applicantName);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[contains(text(),'"+applicantEmail+"')]")).getText().trim(), applicantEmail);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[contains(text(),'"+applicantMobile+"')]")).getText().trim(), applicantMobile);
     	   	//Sending Batch To SSC For Approval
     	   	tcVp.clickToSendBatchForApproval();
     	   	Thread.sleep(4000);
     	   	Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Submitted for Approval");
     	   	Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been submitted for approval to SSC");
     	   	tcVp.clickOk();
     	   	Thread.sleep(4000);
     	   	tcVp.clickToViewAllAcceptedBatches();
     	   	Thread.sleep(4000);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Submitted for Approval");
     	   	PostLoginPage plp=new PostLoginPage(driver);
     	   	plp.clickOnProfileLogo();
	   		Thread.sleep(2000);
	   		plp.clickOnLogout();
	   		Thread.sleep(6000);
     	   	//SSC Sending Back Batch
     	   	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
      	 	lp.clickLogin();
      	 	elp.performlogin(sscUsername, sscPassword);
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
      	 	sVp.clickToGoToEnrolledApplicantsSection();
      	 	Thread.sleep(2000);
      	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantID+"']]")).size()==1,"OMG!!! No show of TC Approved Trainer Applicant - "+applicantID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[2]")).getText().trim(), applicantID);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[3]")).getText().trim(), applicantName);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[4]")).getText().trim(), applicantEmail);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[5]")).getText().trim(), applicantMobile);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[6]")).getText().trim(), "Paid");
      	 	sVp.clickToGoToApprovedApplicantsSection();
      	 	Thread.sleep(4000);
      	 	//Send Back
      	 	sVp.clickToSendBackBatch();
      	 	Thread.sleep(4000);
      	 	sVp.enterRemarksForSendBackBatch("Sending Back This Batch as these applicants are unpaid");
      	 	Thread.sleep(2000);
      	 	sVp.clickToSubmitSendBackBatch();
      	 	Thread.sleep(4000);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Batch Sent Back\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") Batch sent back successfully");
      	 	sVp.clickOk();
      	 	Thread.sleep(4000);
      	 	sAp.clickToViewAllPublishedBatches();
      	 	Thread.sleep(4000);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(),"Sent Back");
      	 	plp.clickOnProfileLogo();
      	 	Thread.sleep(2000);
      	 	plp.clickOnLogout();
      	 	Thread.sleep(6000);
      	 	//TC Checking Sent Back Batch
      	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
        	lp.clickLogin();
        	Thread.sleep(2000);
     	   	elp.performlogin(tcID, tcPassword);
     	   	Thread.sleep(6000);
     	   	js.executeScript("window.scrollBy(0,200)","");
     	   	Thread.sleep(4000);
     	   	tcDp.clickToViewBatches();
     	   	Thread.sleep(2000);
     	   	tcVp.clickToViewAllAcceptedBatches();
     	   	Thread.sleep(4000);
     	   	Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchID);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");   
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), batchSize);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Sent Back by SSC");
     	   	tcVp.clikToGetBatchActionMenu(batchID);
     	   	Thread.sleep(2000);
     	   	tcVp.selectReEnrollApplicantsOption(batchID);
     	   	Thread.sleep(4000);
     	   	tcVp.clickToGoToAppliedApplicantsSection();
     	   	Thread.sleep(4000);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//div[p[b[contains(text(),'Batch Status')]]]//span")).getText().trim(), "Rejected");
     	   	Assert.assertEquals(driver.findElement(By.xpath("//div[p[b[contains(text(),'Rejected Reason')]]]//p[3]")).getText().trim(), "Sending Back This Batch as these applicants are unpaid");
     	   	plp.clickOnProfileLogo();
     	 	Thread.sleep(2000);
     	 	plp.clickOnLogout();
     	 	Thread.sleep(2000);
     	}
    }
}		