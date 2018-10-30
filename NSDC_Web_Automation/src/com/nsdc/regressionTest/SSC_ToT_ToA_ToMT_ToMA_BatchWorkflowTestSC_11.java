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
import com.nsdc.pages.AssessorDashboardPage;
import com.nsdc.pages.AssessorViewBatchesPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LocationBasedTC_DashboardPage;
import com.nsdc.pages.LocationBasedTC_ViewBatchesPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
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
		sscTbcP.clickToCloseTrainingStartDateCalender();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.id("startDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 9, trainingStartDate);
		String trainingEndDate=driver.findElement(By.id("endDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 10, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(2000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(2000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(2000);
		sscTbcP.clickTocloseDomainTrainingStartDateCalender();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
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
		sscTbcP.clickToclosePlatformTrainingStartDateCalender();
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(2000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
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
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 1, createdBatchID);
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssccreate-new-batchbatch-assignment"+createdBatchID,"OMG!!! No show of Batch Assignment Page OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		//STEP 2 OF BATCH CREATION -> Assigning Training Centre  and Assigning To Batches
		Thread.sleep(4000);
		sscTbcP.selectStateFilter(state);
		Thread.sleep(2000);
		sscTbcP.selectDistrictFilter(district);
		Thread.sleep(2000);
		sscTbcP.enterTrainingCentreIDToSearch(tcID);
		Thread.sleep(4000);
		sscTbcP.clickToGetSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+tcID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tpName+"')]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Thread.sleep(2000);
		sscTbcP.clickToChooseResultedTrainingCentreToAssign(tcID);
		Thread.sleep(4000);
		sscTbcP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Training Centre Assigned\n"+createdBatchID+"\nis successfully assigned to   "+tcName+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Domain QP
		Thread.sleep(2000);
		sscTbcP.clickDomainMasterTrainerAction(domainJobRole);
		Thread.sleep(2000);
		sscTbcP.clickDomainAssignMasterTrainerOption();
		Thread.sleep(2000);
		sscTbcP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sscTbcP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sscTbcP.enterDomainMasterTrainerIDToSearch(dmasterTrainerID);
		Thread.sleep(2000);
		sscTbcP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+dmasterTrainerID+" for Domain QP -"+domainJobRoleCode);
		sscTbcP.clickToChooseDomainMasterTrainer();
		Thread.sleep(2000);
		sscTbcP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+createdBatchID+"\nis successfully assigned to   "+dmasterTrainerID+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+dmasterTrainerID+"')]")).getText().trim(), dmasterTrainerName+" ( "+dmasterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Platform QP
		sscTbcP.clickPlatformMasterTrainerAction(platformJobRole);
		Thread.sleep(2000);
		sscTbcP.clickPlatformAssignMasterTrainerOption();
		Thread.sleep(2000);
		sscTbcP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(2000);
		sscTbcP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(2000);
		sscTbcP.enterPlatformMasterTrainerIDToSearch(pmasterTrainerID);
		Thread.sleep(2000);
		sscTbcP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+pmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+pmasterTrainerID+" for Platform QP -"+platformJobRoleCode);
		sscTbcP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(2000);
		sscTbcP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+pmasterTrainerID+"')])[1]")).getText().trim(), pmasterTrainerName+" ( "+pmasterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Domain QP Assessment Agency
		sscTbcP.clickDomainAssessmentAgencyAction(domainJobRole);
		Thread.sleep(2000);
		sscTbcP.clickDomainAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sscTbcP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sscTbcP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sscTbcP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		Thread.sleep(2000);
		sscTbcP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dassessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+dassessmentAgencyID+" for Domain QP -"+domainJobRoleCode);
		sscTbcP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+dassessmentAgencyID+"')]")).getText().trim(), dassessmentAgencyName+" ( "+dassessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		//Assigning Platform QP Assessment Agency
		sscTbcP.clickPlatformAssessmentAgencyAction(platformJobRole);
		Thread.sleep(2000);
		sscTbcP.clickPlatformAssignAssessmentAgencyOption();
		Thread.sleep(2000);
		sscTbcP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(2000);
		sscTbcP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(2000);
		sscTbcP.enterPlatformAssessmentAgencyIDToSearch(passessmentAgencyID);
		Thread.sleep(2000);
		sscTbcP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+passessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+passessmentAgencyID+" for Platform QP -"+platformJobRoleCode);
		sscTbcP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+passessmentAgencyID+"')])[1]")).getText().trim(), passessmentAgencyName+" ( "+passessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		sscTbcP.clickSaveAsDraft();
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
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG! Batch - "+createdBatchID+" not found in All Batches Section of "+sscUsername+" !!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+tcID+"')]]")).getText().trim(), tcName+" ("+tcID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+state+"')]]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+district+"')]]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[7]")).getText().trim(), trainingStartDate+" - "+trainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Draft");
		//Submitting Batch 
		sscTbcP.clickBatchAction(createdBatchID);
		Thread.sleep(2000);
		sscTbcP.selectAssignOption(createdBatchID);
		Thread.sleep(2000);
		sscTbcP.clickToSubmitBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		sscTbcP.clickViewAllBatchesAfterBatchSubmission();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! navigation to All New Batches After Batch Submission is unsuccessful! OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		//After Batch Submission with status Pending For Publish
		sscTbcP.clickBatchAction(createdBatchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span/div/div/a/span")).getText().trim(), "View Details");
		sscTbcP.clickViewDetailsOption(createdBatchID);
		Thread.sleep(4000);
		//Verifying Batch Details
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-newbatch-datails"+createdBatchID,"OMG!!! navigation to view batch details page is unsuccessful OR Something is wrong! ");
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
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[4]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+dassessmentAgencyID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		//Verifying Assigned Platform QP Assessment Agency Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[4]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+passessmentAgencyID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 2,formatter.format(date));
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="sscBatchCreationTC_01")
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
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Pending for Publish");
		Thread.sleep(4000);
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.selectViewBatchDetailsOption(batchID);
		Thread.sleep(4000);
		//Asserting view Batch Details
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID+"batch","OMG!!! navigation to View Batch Details page is unsucessful OR Something went wrong! ");
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
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batchs","OMG!!! Go Back button of View Batch Details, navigation to View All Batches page is unsucessful OR Something went wrong! ");
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
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");	
		lTcVbP.clickOk();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!!! accepted batch - "+batchID+" should not be shown in pending batches section! OR Something is wrong! ");
		js.executeScript("window.scrollBy(0,-500)","");
		Thread.sleep(2000);
		//verifying Accepted Batches
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
		Assert.assertNotSame(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Accepted");
		lTcVbP.clikToGetBatchActionMenu(batchID);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]/div/div/div/div/div/div/ul/li/a/span")).size()==1," OMG!!! only view details option should be there!! OR Something changed! ");
		lTcVbP.selectViewBatchDetailsOption(batchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID+"batch","OMG!!! navigation to View Batch Details page is unsucessful OR Something went wrong! ");
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
		
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="trainingCentreBatchApprovalTC_02")
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
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Pending Requests Section of Master Trainer - "+pmasterTrainerID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state );
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			tVp.clickToSelectViewDetailsOption(batchID);
			Thread.sleep(2000);
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainerbatch-details-new"+batchID+"NEW"),"OMG!!! navigation to View Batch Details page is unsuccessful OR Something went wrong! ");
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
				//Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), platformJobRole);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), platformJobRoleCode);
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
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainerbatches-new"),"OMG!!! Go Back Button of View Batch Details, navigation to view all batches page is unsuccessful OR Something went wrong! ");
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
			Thread.sleep(2000);	
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 52, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 53, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 70, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 71, timeFormat.format(date));
			}
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");
			tVp.clickOk();
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in Pending Requests Section of Master Trainer - "+pmasterTrainerID);
			}
			//verifying accepted batches
			js.executeScript("window.scrollBy(0,-500)", "");
			Thread.sleep(2000);
			tVp.clickToGoToAcceptedBatchesSection();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+dmasterTrainerID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+pmasterTrainerID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state );
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Published");
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]//a/span")).size()==1," OMG!!! only view details option should be there!! OR Something changed! ");
			tVp.clickToSelectViewDetailsOption(batchID);
			Thread.sleep(2000);
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains(configuredURL.replaceAll("/", "")+"trainerbatch-details-new"+batchID+"ACCEPTED"),"OMG!!! navigation to View Batch Details page is unsuccessful OR Something went wrong! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector & Sub Sector')]]/td[3]")).getText().trim(), expectedSector+" | "+subSector);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
			if(i==1)
			{
				//Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), domainJobRoleCode);
			}
			else
			{
				//Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), platformJobRole);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), platformJobRoleCode);
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
		
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="trainingCentreBatchApprovalTC_02")
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
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+passessmentAgencyID+" Pending Requests section!!! ");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			}
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+" , "+state+"/"+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), "Pending for Acceptance");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), batchCreatedDate);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToSelectViewBatchDetailsOption();
			Thread.sleep(4000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batch-detailsNEW"+batchID);
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
				//Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]")).size()==0,"OMG!!! View Batch details - platform JobRole record should not be shown for domain job role assessment agency - "+dassessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( "+domainJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), "NA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentEndDate);
			}
			else
			{
				//Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]")).size()==0,"OMG!!! View Batch details - domain JobRole record should not be shown for platform job role assessment agency - "+passessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+"( "+platformJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), "NA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentEndDate);
			}
			aVp.clickToGoBack();
			Thread.sleep(4000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batches");
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+passessmentAgencyID+" Pending Requests section!!! ");
			}
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(4000);
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
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(),"You have successfully accepted "+batchID);
			aVp.clickOk();
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in pending section of - "+dassessmentAgencyID+" OR something is wrong! ");
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in pending section of - "+passessmentAgencyID+" OR something is wrong! ");
			}
			//verifying accepted batches & assigning assessors
			aVp.clickToViewAcceptedBatches();
			Thread.sleep(4000);
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			if(i==1)
			{
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+dassessmentAgencyID+" !!! ");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			}
			else
			{
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+passessmentAgencyID+" !!! ");
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+" , "+state+"/"+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), "Accepted");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), batchCreatedDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[9]")).getText().trim(), batchCreatedDate);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(4000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
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
				aVp.selectMasterAssessorForDomain(dmasterAssessorName+"("+dmasterAssessorID+")");
				Thread.sleep(2000);
			}
			else
			{
				aVp.selectMasterAssessorForPlatform(pmasterAssessorName+"("+pmasterAssessorID+")");
				Thread.sleep(2000);
			}
			aVp.clickToSubmitMasterAssessors();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned Assessor for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") - "+batchID);
			aVp.clickOk();
			Thread.sleep(4000);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 58, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 59, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 76, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 77, timeFormat.format(date));
			}
			//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), "Assigned Assessor");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), formatter.format(date));
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			//After Assigning Master Assessor
			aVp.clickToSelectViewBatchDetailsOption();
			Thread.sleep(4000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batch-detailsACCEPTED"+batchID);
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
				//Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]")).size()==0,"OMG!!! View Batch details - platform JobRole record should not be shown for domain job role assessment agency - "+dassessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( "+domainJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dmasterAssessorName+"("+dmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Pending");
			}
			else
			{
				//Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]")).size()==0,"OMG!!! View Batch details - domain JobRole record should not be shown for platform job role assessment agency - "+passessmentAgencyID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+"( "+platformJobRoleCode+" )");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().replaceAll(" ", ""), pmasterAssessorName+"("+pmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Pending");
			}
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
	
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="assessmentAgencyBatchApprovalAndAssigningAssessorsTC_04")
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
			
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			if(i==1)
			{
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")" );
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), dAssessmentStartDate+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), dassessmentAgencyRemarksDate);
			}
			else
			{
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")" );
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), pAssessmentStartDate+pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), passessmentAgencyRemarksDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+", "+state+","+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending for Acceptance");
			Thread.sleep(4000);
			maVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(4000);
			//View Batch Details Data Verification
			maVp.clickToSelectViewBatchDetailsOption(batchID);
			Thread.sleep(4000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""),configuredURL.replaceAll("/", "")+"assessormaster-assessorview-batch-details-newNEW"+batchID," OMG!!! View Batch Details page is not loaded or URL might have been changed!!! ");
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
				//Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]")).size()==0,"OMG!!! View Batch details - platform JobRole record should not be shown for domain job role master assessor - "+dmasterAssessorID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dmasterAssessorName+" ("+dmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			}
			else
			{
				//Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]")).size()==0,"OMG!!! View Batch details - domain JobRole record should not be shown for platform job role master assessor - "+pmasterAssessorID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+" ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pmasterAssessorName+" ("+pmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			}
			maVp.clickToGoBack();
			Thread.sleep(4000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessormaster-assessorview-batches-newNEW","OMG!!! Go Back button of view batch details does not navigated to pending requests batches section OR url might have been changed!!! ");
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
			Thread.sleep(4000);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			if(i==1)
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 64, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 65, timeFormat.format(date));
			}
			else
			{
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 82, formatter.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 83, timeFormat.format(date));
			}
			//Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim(),"Request Accepted Successfully");
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
			
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
			if(i==1)
			{
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")" );
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), dAssessmentStartDate+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), dassessmentAgencyRemarksDate);
			}
			else
			{
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")" );
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), pAssessmentStartDate+pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), passessmentAgencyRemarksDate);
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+", "+state+","+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Accepted");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[9]")).getText().trim(), formatter.format(date));
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
}	