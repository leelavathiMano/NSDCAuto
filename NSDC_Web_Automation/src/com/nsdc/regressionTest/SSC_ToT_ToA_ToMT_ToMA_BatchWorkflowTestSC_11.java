package com.nsdc.regressionTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	String configBatchSector=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 28);
	@DataProvider
	public Object[][] sscBatchCreationData() throws Exception
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation");
	}
	
	@Test(dataProvider="sscBatchCreationData")
	public void sscBatchCreationTC_01(String serialNum,String createdBatchIDs, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime, String domainMasterTrainerState, String domainMasterTrainerDistrict, String platformMasterTrainerState, String platformMasterTrainerDistrict, String domainAssessementAgencyState, String domainAssessmentAgencyDistrict, String platformAssessmentAgencyState, String platformAssessemntAgencyDistrict, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ToT, ToA, ToMT,ToMA")));
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)", "");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]"))));
		sscDbP.clickCreateBatch();
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
//		sscTbcP.selectSubSector(subSector);
		sscTbcP.selectBatchType(batchType);
		sscTbcP.selectBatchCategory(batchCategory);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage.fileSave("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls");
		String configBatchStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 58);
		String configBatchEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 59);
		String configDomainTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 60);
		String configDomainTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 61);
		String configDomainAssessmentStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 62);
		String configDomainAssessmentEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 63);
		String configPlatformTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 64);
		String configPlatformTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 65);
		String configPlatformAssessemntStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 66);
		String configPlatformAssessemntEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 67);
		sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 9, trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 10, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
		//Sometimes platform job role will not be available
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")));
		driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
		if(driver.findElements(By.xpath("//label[text()='"+platformJobRole+"']")).size()==0)
		{
			js.executeScript("window.scrollBy(0,-1000)", "");
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("ToT, ToA, ToMT,ToMA")));
			driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
//			sscTbcP.selectSubSector(subSector);
			sscTbcP.selectBatchType(batchType);
			sscTbcP.selectBatchCategory(batchCategory);
			sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
			if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
			{
				sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
			}
			else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
			{
				sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
			}
			trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 9, trainingStartDate);
			trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 10, trainingEndDate);
			sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
			driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		else
		{
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		//Domain QP
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sscTbcP.clickToChooseDomainQP();
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate(configDomainTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch(configDomainTrainingEndDate);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch(configDomainAssessmentStartDate);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch(configDomainAssessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch(configDomainTrainingEndDate);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch(configDomainAssessmentStartDate);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch(configDomainAssessmentEndDate);
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
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate(configPlatformTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch(configPlatformTrainingEndDate);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch(configPlatformAssessemntStartDate);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch(configPlatformAssessemntEndDate);
			}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch(configPlatformTrainingEndDate);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch(configPlatformAssessemntStartDate);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch(configPlatformAssessemntEndDate);
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
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		sscTbcP.clickToGetInDetailBatchFees();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[td[p[contains(text(),'Fee Applicable for Program')]]]/td[2]")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Fee Applicable for Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Technical QP(0) X Rate(800)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'No. Of Additional Non-Technical QP(0) X Rate(600)')]]]/td[2]")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'Total Fee of the Program')]]]/td[2]")).getText().trim(), expectedBatchFees);
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sscTbcP.selectBatchSize(batchSize);
		sscTbcP.clickToCreateBatch();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 1, createdBatchID);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+") is successfully created");
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
//		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		//STEP 2 OF BATCH CREATION -> Assigning Training Centre  and Assigning To Batches
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		js.executeScript("window.scrollBy(0,500)", "");
		sVbP.selectStateFilter(state);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.selectDistrictFilter(district);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		sVbP.clickToGetSearchFilterResult();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+tcID+"')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tpName+"')]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		sVbP.clickToChooseResultedTrainingCentreToAssign();
		sVbP.clickToSubmitSelectedTrainingCentre();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Training Centre Assigned\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+tcName+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().contains(tcName));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Domain QP
		sVbP.clickDomainMasterTrainerAction(domainJobRole);
		sVbP.selectDomainAssignMasterTrainerOption();
		sVbP.enterDomainMasterTrainerIDToSearch(dmasterTrainerID);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+dmasterTrainerID+"')]")));
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+dmasterTrainerID+" for Domain QP -"+domainJobRoleCode);
		sVbP.clickToChooseDomainMasterTrainer();
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+dmasterTrainerID+"\nState : "+domainMasterTrainerState+"\nDistrict : "+domainMasterTrainerDistrict);
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+dmasterTrainerID+"')]")).getText().trim(), dmasterTrainerName+" ( "+dmasterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for Platform QP
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		sVbP.selectPlatformAssignMasterTrainerOption();
		sVbP.enterPlatformMasterTrainerIDToSearch(pmasterTrainerID);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+pmasterTrainerID+"')]")));
		sVbP.clickToChoosePlatformMasterTrainer();
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+pmasterTrainerID+"\nState : "+platformMasterTrainerState+"\nDistrict : "+platformMasterTrainerDistrict);
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+pmasterTrainerID+"')])[1]")).getText().trim(), pmasterTrainerName+" ( "+pmasterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[1]")).getText().trim(), "Assigned");
		//Assigning Domain QP Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole);
		sVbP.selectDomainAssignAssessmentAgencyOption();
		sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+dassessmentAgencyID+"')]")));
		sVbP.clickToChooseDomainAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Assessment Agency Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+dassessmentAgencyID+"\nState : "+domainAssessementAgencyState+"\nDistrict : "+domainAssessmentAgencyDistrict);
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+dassessmentAgencyID+"')]")).getText().trim(), dassessmentAgencyName+" ( "+dassessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		sVbP.selectPlatformAssignAssessmentAgencyOption();
		sVbP.enterPlatformAssessmentAgencyIDToSearch(passessmentAgencyID);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+passessmentAgencyID+"')]")));
		sVbP.clickToChoosePlatformAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Assessment Agency Assigned Successfully\n"+batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")\nis successfully assigned to   "+passessmentAgencyID+"\nState : "+platformAssessmentAgencyState+"\nDistrict : "+platformAssessemntAgencyDistrict);
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+passessmentAgencyID+"')])[1]")).getText().trim(), passessmentAgencyName+" ( "+passessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]]//span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		if(serialNum.equals("1"))
		{
			js.executeScript("window.scrollBy(0,500)", "");
			sVbP.clickSaveAsDraft();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
			Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']")).getText().trim(), "Saved as Draft");
			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().trim(), "success");
			sscTbcP.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			//checking presence of created batches of status draft
			js.executeScript("window.scrollBy(0,-500)", "");
			sscDbP.clickToTToAToMTToMA();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			sscDbP.clickAllBatches();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
			sAp.enterBatchIDToSearch(createdBatchID);
			sAp.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[1]")).getText().trim(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[3]")).getText().trim(), domainJobRole+"  ("+domainJobRoleCode+") - "+domainJobRoleVersion+", "+platformJobRole+"  ("+platformJobRoleCode+") - "+platformJobRoleVersion);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[7]")).getText().trim(), trainingStartDate+" - "+trainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Draft");
			//Submitting Batch 
			sscTbcP.clickBatchAction(createdBatchID);
			sscTbcP.selectAssignOption(createdBatchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			sVbP.clickConfirmation();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			sVbP.clickToSubmitBatch();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();  
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 2,formatter.format(date));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='swal2-title']/p/b")));
			Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
			sVbP.clickViewAllBatchesAfterBatchSubmission();
			//After Batch Submission with status Pending For Publish
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			sAp.enterBatchIDToSearch(createdBatchID);
			sAp.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Pending to be Published");
			sscTbcP.clickBatchAction(createdBatchID);
			sscTbcP.clickViewDetailsOption(createdBatchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
//			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
			//Verifying Assigned Domain QP Master Trainer Details
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[1]")).getText().trim(), domainJobRoleCode);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[2]")).getText().trim(), domainJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[4]")).getText().trim(), dmasterTrainerName+" ("+dmasterTrainerID+")");
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Pending");
			//Verifying Assigned Platform QP Master Trainer Details
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[1]")).getText().trim(), platformJobRoleCode);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[2]")).getText().trim(), platformJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[4]")).getText().trim(), pmasterTrainerName+" ("+pmasterTrainerID+")");
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Pending");
			//Verifying Assigned Domain QP Assessment Agency Details
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[1]")).getText().trim(), domainJobRoleCode);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[2]")).getText().trim(), domainJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[3]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[4]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Pending");
			//Verifying Assigned Platform QP Assessment Agency Details
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[1]")).getText().trim(), platformJobRoleCode);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[2]")).getText().trim(), platformJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[3]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[4]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Pending");
		}
		else
		{
			sVbP.clickConfirmation();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			sVbP.clickToSubmitBatch();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();  
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 2,formatter.format(date));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='swal2-title']/p/b")));
			Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
			sVbP.clickViewAllBatchesAfterBatchSubmission();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods="sscBatchCreationTC_01")
	public void trainingCentreBatchApprovalTC_02(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime, String domainMasterTrainerState, String domainMasterTrainerDistrict, String platformMasterTrainerState, String platformMasterTrainerDistrict, String domainAssessementAgencyState, String domainAssessmentAgencyDistrict, String platformAssessmentAgencyState, String platformAssessemntAgencyDistrict, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Pending for Publish");
		if(serialNum.equals("1"))
		{
			lTcVbP.clikToGetBatchActionMenu();
			lTcVbP.selectViewBatchDetailsOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
			lTcVbP.clickGoBack();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)","");
			lTcVbP.enterToSearchForBatchID(batchID);
			lTcVbP.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Accepting batch
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectAcceptBatchOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		lTcVbP.clickToAcceptBatch();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		lTcVbP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		if(serialNum.equals("1"))
		{
			Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! accepted batch - "+batchID+" should not be shown in pending batches section! OR Something is wrong! ");
			js.executeScript("window.scrollBy(0,-500)","");
			//verifying Accepted Batches
			lTcVbP.clickToViewAllAcceptedBatches();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)","");
			lTcVbP.enterToSearchForBatchID(batchID);
			lTcVbP.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+"),\n"+platformJobRole+" ("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText(), batchStartDate+" to "+batchEndDate);
			Assert.assertNotSame(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Accepted");
			lTcVbP.clikToGetBatchActionMenu();
			lTcVbP.selectViewBatchDetailsOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
		
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods="trainingCentreBatchApprovalTC_02")
	public void masterTrainerBatchApprovalTC_03(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime, String domainMasterTrainerState, String domainMasterTrainerDistrict, String platformMasterTrainerState, String platformMasterTrainerDistrict, String domainAssessementAgencyState, String domainAssessmentAgencyDistrict, String platformAssessmentAgencyState, String platformAssessemntAgencyDistrict, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		if(!pmasterTrainerID.equalsIgnoreCase(dmasterTrainerID))
		{
			for(int i=1;i<3;i++)
			{				
				if(i==1)
				{
					elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
				}
				else
				{
					lp.clickLogin();
					elp.performlogin(pmasterTrainerID, pmasterTrainerPassword);
				}
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
				tDp.clickToGetTrainerDashboard();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				tDp.clickAllBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
				tVp.clicktoGoPendingBatchesSection();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				tVp.enterBatchIDToSearch(batchID);
				tVp.clickToGetSearchFilterResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
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
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Pending to be Publish");
				if(serialNum.equals("1"))
				{
					tVp.clickToGetActionMenuOptions(batchID);
					tVp.clickToSelectViewDetailsOption(batchID);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")')]")).isDisplayed());
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector')]]/td[3]")).getText().trim(), expectedSector);
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
					tVp.clickGoBack();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					js.executeScript("window.scrollBy(0,200)", "");
					tVp.enterBatchIDToSearch(batchID);
					tVp.clickToGetSearchFilterResult();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				}
				tVp.clickToGetActionMenuOptions(batchID);
				tVp.clickToSelectAcceptBatchOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(i==1)
				{
					tVp.enterRemarksForAcceptingBatch(dmtBatchAcceptanceRemarks);
				}
				else
				{
					tVp.enterRemarksForAcceptingBatch(pmtBatchAcceptanceRemarks);
				}
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
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				tVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(serialNum.equals("1"))
				{
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
					tVp.clickToGoToAcceptedBatchesSection();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					js.executeScript("window.scrollBy(0,300)", "");
					tVp.enterBatchIDToSearch(batchID);
					tVp.clickToGetSearchFilterResult();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					if(i==1)
					{
						Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+dmasterTrainerID);
//						Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
//						Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate);
					}
					else
					{
						Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+pmasterTrainerID);
//						Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
//						Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
					}
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state );
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), district);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Published");
					tVp.clickToGetActionMenuOptions(batchID);
					tVp.clickToSelectViewDetailsOption(batchID);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector')]]/td[3]")).getText().trim(), expectedSector);
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
				}
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
		else
		{
			elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
			tDp.clickToGetTrainerDashboard();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tDp.clickAllBatches();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
			tVp.clicktoGoPendingBatchesSection();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			tVp.enterBatchIDToSearch(batchID);
			tVp.clickToGetSearchFilterResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+"),\n"+platformJobRole+"("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate+",\n"+pTrainingStartDate+" to "+pTrainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state );
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Pending to be Publish");
			tVp.clickToGetActionMenuOptions(batchID);
			tVp.clickToSelectViewDetailsOption(batchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")')]")).isDisplayed());
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector')]]/td[3]")).getText().trim(), expectedSector);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[2]")).getText().trim(), domainJobRoleCode);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[3]")).getText().trim(), platformJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[4]")).getText().trim(), platformJobRoleCode);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			tVp.clickGoBack();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)", "");
			tVp.enterBatchIDToSearch(batchID);
			tVp.clickToGetSearchFilterResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tVp.clickToGetActionMenuOptions(batchID);
			tVp.clickToSelectAcceptBatchOption(batchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tVp.enterRemarksForAcceptingBatch(dmtBatchAcceptanceRemarks);
			tVp.clickToSubmit();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 53, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 52, formatter.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 71, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 70, formatter.format(date));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			tVp.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
			//verifying accepted batches
			js.executeScript("window.scrollBy(0,-500)", "");
			tVp.clickToGoToAcceptedBatchesSection();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
			tVp.enterBatchIDToSearch(batchID);
			tVp.clickToGetSearchFilterResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,300)", "");
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+dmasterTrainerID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+"),\n"+platformJobRole+"("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), dTrainingStartDate+" to "+dTrainingEndDate+",\n"+pTrainingStartDate+" to "+pTrainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state );
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Published");
			tVp.clickToGetActionMenuOptions(batchID);
			tVp.clickToSelectViewDetailsOption(batchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector')]]/td[3]")).getText().trim(), expectedSector);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[2]")).getText().trim(), domainJobRoleCode);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[3]")).getText().trim(), platformJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[4]")).getText().trim(), platformJobRoleCode);
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
	public void assessmentAgencyBatchApprovalAndAssigningAssessorsTC_04(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime, String domainMasterTrainerState, String domainMasterTrainerDistrict, String platformMasterTrainerState, String platformMasterTrainerDistrict, String domainAssessementAgencyState, String domainAssessmentAgencyDistrict, String platformAssessmentAgencyState, String platformAssessemntAgencyDistrict, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		if(!passessmentAgencyID.equalsIgnoreCase(dassessmentAgencyID))
		{
			for(int i=1;i<3;i++)
			{
				if(i==1)
				{
					elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
				}
				else
				{
					lp.clickLogin();
					elp.performlogin(passessmentAgencyID, passessmentAgencyPassword);
				}
				WebDriverWait wait=new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//strong[contains(text(),'Assessment Requests')])[1]")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
				aDp.clickBatchAssessmentRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
				aVp.clickToViewPendingBatchRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)", "");
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(i==1)
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), batchID);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				}
				else
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+passessmentAgencyID+" Pending Requests section!!! ");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), batchID);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
				}
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "ToT/ToA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchCategory.replace("Batch", "").trim());
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), tcName+" , "+state+"/"+district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Pending for Acceptance");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), batchCreatedDate);
				aVp.clickToGetActionMenuOptions();
				aVp.clickToSelectViewBatchDetailsOption();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
				//view Accepted TC details option - data verification
				aVp.selectThisToViewDetailsOfAcceptedTC();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tcName")));
				Assert.assertEquals(driver.findElement(By.id("tcName")).getAttribute("value").trim(), tcName);
				Assert.assertEquals(driver.findElement(By.id("tcUserName")).getAttribute("value").trim(), tcID);
				Assert.assertEquals(driver.findElement(By.id("tpName")).getAttribute("value").trim(), tpName);
				Assert.assertEquals(driver.findElement(By.id("tpUserName")).getAttribute("value").trim(), "N/A");
				Assert.assertEquals(driver.findElement(By.id("address")).getAttribute("value").trim(), tcAddress);
				Assert.assertEquals(driver.findElement(By.id("landmark")).getAttribute("value").trim(), tcLandmark);
				Assert.assertEquals(driver.findElement(By.id("pincode")).getAttribute("value").trim(), pincode);
				Assert.assertEquals(driver.findElement(By.id("state")).getAttribute("value").trim(), state);
				Assert.assertEquals(driver.findElement(By.id("district")).getAttribute("value").trim(), district);
				Assert.assertEquals(driver.findElement(By.id("tehsil")).getAttribute("value").trim(), subDistrict);
				Assert.assertEquals(driver.findElement(By.id("village")).getAttribute("value").trim(), village);
				Assert.assertEquals(driver.findElement(By.id("parliamentaryConstituency")).getAttribute("value").trim(), constituency);
				Assert.assertEquals(driver.findElement(By.id("spocName")).getAttribute("value").trim(), tcSPOCName);
				Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value").trim(), tcSPOCEmail);
				Assert.assertEquals(driver.findElement(By.id("mobileNumber")).getAttribute("value").trim(), tcSPOCMobile);
				aVp.clickOkToCloseAcceptedTCDetailsView();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(i==1)
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
				}
				else
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+passessmentAgencyID+" Pending Requests section!!! ");
				}
				aVp.clickToGetActionMenuOptions();
				aVp.clickToSelectAcceptBatchOption();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(i==1)
				{
					aVp.enterRemarksForAcceptingBatch(daaBatchAcceptanceRemarks);
				}
				else
				{
					aVp.enterRemarksForAcceptingBatch(paaBatchAcceptanceRemarks);
				}
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
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted\nBatchId - "+batchID);
				aVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				js.executeScript("window.scrollBy(0,200)", "");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(i==1)
				{
					Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+dassessmentAgencyID+" !!! ");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), domainJobRole+"("+domainJobRoleCode+")");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				}
				else
				{
					Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+passessmentAgencyID+" !!! ");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), platformJobRole+"("+platformJobRoleCode+")");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
				}
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "ToT/ToA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchCategory.replace("Batch", "").trim());
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), tcName+" , "+state+"/"+district);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Accepted");
				if(i==1)
				{
					String assessmentAgencyActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 58);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), assessmentAgencyActionDate);
				}
				else
				{
					String assessmentAgencyActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 76);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), assessmentAgencyActionDate);
				}
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[11]")).getText().trim(), batchCreatedDate);
				aVp.clickToGetActionMenuOptions();
				aVp.clickToSelectAssignAssessorsOption();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
				Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned Assessor for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				aVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Assigned Assessor");
				aVp.clickToGetActionMenuOptions();
				//After Assigning Master Assessor
				aVp.clickToSelectViewBatchDetailsOption();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
				//view Accepted TC details option - data verification
				aVp.selectThisToViewDetailsOfAcceptedTC();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tcName")));
				Assert.assertEquals(driver.findElement(By.id("tcName")).getAttribute("value").trim(), tcName);
				Assert.assertEquals(driver.findElement(By.id("tcUserName")).getAttribute("value").trim(), tcID);
				Assert.assertEquals(driver.findElement(By.id("tpName")).getAttribute("value").trim(), tpName);
				Assert.assertEquals(driver.findElement(By.id("tpUserName")).getAttribute("value").trim(), "N/A");
				Assert.assertEquals(driver.findElement(By.id("address")).getAttribute("value").trim(), tcAddress);
				Assert.assertEquals(driver.findElement(By.id("landmark")).getAttribute("value").trim(), tcLandmark);
				Assert.assertEquals(driver.findElement(By.id("pincode")).getAttribute("value").trim(), pincode);
				Assert.assertEquals(driver.findElement(By.id("state")).getAttribute("value").trim(), state);
				Assert.assertEquals(driver.findElement(By.id("district")).getAttribute("value").trim(), district);
				Assert.assertEquals(driver.findElement(By.id("tehsil")).getAttribute("value").trim(), subDistrict);
				Assert.assertEquals(driver.findElement(By.id("village")).getAttribute("value").trim(), village);
				Assert.assertEquals(driver.findElement(By.id("parliamentaryConstituency")).getAttribute("value").trim(), constituency);
				Assert.assertEquals(driver.findElement(By.id("spocName")).getAttribute("value").trim(), tcSPOCName);
				Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value").trim(), tcSPOCEmail);
				Assert.assertEquals(driver.findElement(By.id("mobileNumber")).getAttribute("value").trim(), tcSPOCMobile);
				aVp.clickOkToCloseAcceptedTCDetailsView();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
		else
		{
			elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//strong[contains(text(),'Assessment Requests')])[1]")));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			aDp.clickBatchAssessmentRequests();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
			aVp.clickToViewPendingBatchRequests();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)", "");
			aVp.enterBatchIdToSearch(batchID);
			aVp.clickToApplySelectedSearchFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "ToT/ToA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchCategory.replace("Batch", "").trim());
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+") - "+domainJobRoleVersion+",\n"+platformJobRole+" ("+platformJobRoleCode+") - "+platformJobRoleVersion);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), tcName+" , "+state+"/"+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate+"\n"+pAssessmentStartDate+" to "+pAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Pending for Acceptance");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), batchCreatedDate);
			aVp.clickToGetActionMenuOptions();
			aVp.clickToSelectViewBatchDetailsOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
			//view Accepted TC details option - data verification
			aVp.selectThisToViewDetailsOfAcceptedTC();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tcName")));
			Assert.assertEquals(driver.findElement(By.id("tcName")).getAttribute("value").trim(), tcName);
			Assert.assertEquals(driver.findElement(By.id("tcUserName")).getAttribute("value").trim(), tcID);
			Assert.assertEquals(driver.findElement(By.id("tpName")).getAttribute("value").trim(), tpName);
			Assert.assertEquals(driver.findElement(By.id("tpUserName")).getAttribute("value").trim(), "");
			Assert.assertEquals(driver.findElement(By.id("address")).getAttribute("value").trim(), tcAddress);
			Assert.assertEquals(driver.findElement(By.id("landmark")).getAttribute("value").trim(), tcLandmark);
			Assert.assertEquals(driver.findElement(By.id("pincode")).getAttribute("value").trim(), pincode);
			Assert.assertEquals(driver.findElement(By.id("state")).getAttribute("value").trim(), state);
			Assert.assertEquals(driver.findElement(By.id("district")).getAttribute("value").trim(), district);
//			Assert.assertEquals(driver.findElement(By.id("tehsil")).getAttribute("value").trim(), subDistrict);
//			Assert.assertEquals(driver.findElement(By.id("village")).getAttribute("value").trim(), village);
			Assert.assertEquals(driver.findElement(By.id("parliamentaryConstituency")).getAttribute("value").trim(), constituency);
			Assert.assertEquals(driver.findElement(By.id("spocName")).getAttribute("value").trim(), tcSPOCName);
			Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value").trim(), tcSPOCEmail);
			Assert.assertEquals(driver.findElement(By.id("mobileNumber")).getAttribute("value").trim(), tcSPOCMobile);
			aVp.clickOkToCloseAcceptedTCDetailsView();
			//Domain and Platform Job Role details
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( "+domainJobRoleCode+" )");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), "NA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+"( "+platformJobRoleCode+" )");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), "NA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			js.executeScript("window.scrollBy(0,-1000)", "");
			Thread.sleep(2000);
			aVp.clickToGoBack();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			aVp.enterBatchIdToSearch(batchID);
			aVp.clickToApplySelectedSearchFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
			aVp.clickToGetActionMenuOptions();
			aVp.clickToSelectAcceptBatchOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			aVp.enterRemarksForAcceptingBatch(daaBatchAcceptanceRemarks);
			aVp.clickToSubmitBatchAcceptance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 59, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 58, formatter.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 77, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 76, formatter.format(date));
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted\nBatchId - "+batchID);
			aVp.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Accepted Batch - "+batchID+" should not be shown in pending section of - "+dassessmentAgencyID+" OR something is wrong! ");
			//verifying accepted batches & assigning assessors
			aVp.clickToViewAcceptedBatches();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			aVp.enterBatchIdToSearch(batchID);
			aVp.clickToApplySelectedSearchFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)", "");
			Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+dassessmentAgencyID+" !!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "ToT/ToA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchCategory.replace("Batch", "").trim());
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+") - "+domainJobRoleVersion+",\n"+platformJobRole+" ("+platformJobRoleCode+") - "+platformJobRoleVersion);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), tcName+" , "+state+"/"+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate+"\n"+pAssessmentStartDate+" to "+pAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Accepted");
			String assessmentAgencyActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 58);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), assessmentAgencyActionDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[11]")).getText().trim(), batchCreatedDate);
			aVp.clickToGetActionMenuOptions();
			aVp.clickToSelectAssignAssessorsOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch ID')]]]]/div[2]/span")).getText().trim(),batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch Name')]]]]/div[4]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[1]/span")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[2]/span")).getText().trim(), "State : "+state+", District : "+district);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[strong[contains(text(),'Job Role:')]]/span)[1]")).getText().trim(), domainJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[span[strong[contains(text(),'Proposed Dates')]]]/label)[1]")).getText().trim(), dAssessmentStartDate+" To "+dAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[strong[contains(text(),'Job Role:')]]/span)[2]")).getText().trim(), platformJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[span[strong[contains(text(),'Proposed Dates')]]]/label)[2]")).getText().trim(), pAssessmentStartDate+" To "+pAssessmentEndDate);
			aVp.selectMasterAssessorForDomain1(dmasterAssessorName+"("+dmasterAssessorID+")");
			Thread.sleep(2000);
			aVp.selectMasterAssessorForDomain2(pmasterAssessorName+"("+pmasterAssessorID+")");
			aVp.clickToSubmitMasterAssessors();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned Assessor for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			aVp.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Assigned Assessor");
			aVp.clickToGetActionMenuOptions();
			//After Assigning Master Assessor
			aVp.clickToSelectViewBatchDetailsOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
			//view Accepted TC details option - data verification
			if(serialNum.equalsIgnoreCase("1"))
			{
				aVp.selectThisToViewDetailsOfAcceptedTC();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tcName")));
				Assert.assertEquals(driver.findElement(By.id("tcName")).getAttribute("value").trim(), tcName);
				Assert.assertEquals(driver.findElement(By.id("tcUserName")).getAttribute("value").trim(), tcID);
				Assert.assertEquals(driver.findElement(By.id("tpName")).getAttribute("value").trim(), tpName);
				Assert.assertEquals(driver.findElement(By.id("tpUserName")).getAttribute("value").trim(), "");
				Assert.assertEquals(driver.findElement(By.id("address")).getAttribute("value").trim(), tcAddress);
				Assert.assertEquals(driver.findElement(By.id("landmark")).getAttribute("value").trim(), tcLandmark);
				Assert.assertEquals(driver.findElement(By.id("pincode")).getAttribute("value").trim(), pincode);
				Assert.assertEquals(driver.findElement(By.id("state")).getAttribute("value").trim(), state);
				Assert.assertEquals(driver.findElement(By.id("district")).getAttribute("value").trim(), district);
//				Assert.assertEquals(driver.findElement(By.id("tehsil")).getAttribute("value").trim(), subDistrict);
//				Assert.assertEquals(driver.findElement(By.id("village")).getAttribute("value").trim(), village);
				Assert.assertEquals(driver.findElement(By.id("parliamentaryConstituency")).getAttribute("value").trim(), constituency);
				Assert.assertEquals(driver.findElement(By.id("spocName")).getAttribute("value").trim(), tcSPOCName);
				Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value").trim(), tcSPOCEmail);
				Assert.assertEquals(driver.findElement(By.id("mobileNumber")).getAttribute("value").trim(), tcSPOCMobile);
				aVp.clickOkToCloseAcceptedTCDetailsView();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			}
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( "+domainJobRoleCode+" )");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dmasterAssessorName+"("+dmasterAssessorID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), "Pending");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+"( "+platformJobRoleCode+" )");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), pmasterAssessorName+" ("+pmasterAssessorID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), "Pending");
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
		}
		
	}
	
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods="assessmentAgencyBatchApprovalAndAssigningAssessorsTC_04")
	public void masterAssessorBatchApprovalTC_05(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime, String domainMasterTrainerState, String domainMasterTrainerDistrict, String platformMasterTrainerState, String platformMasterTrainerDistrict, String domainAssessementAgencyState, String domainAssessmentAgencyDistrict, String platformAssessmentAgencyState, String platformAssessemntAgencyDistrict, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		if(!pmasterAssessorID.equalsIgnoreCase(dmasterAssessorID))
		{
			for(int i=1; i<3;i++)
			{				
				if(i==1)
				{
					elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
				}
				else
				{
					elp.performlogin(pmasterAssessorID, pmasterAssessorPassword);
				}
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
				maDp.clickToGetAssessorDashboard();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				maDp.clickBatchAssessmentRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
				maVp.clicktoGoToPendingRequestsSection();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				maVp.enterBatchIDToSearch(batchID);
				maVp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				if(i==1)
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Pending Requests Section!");
				}
				else
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+pmasterAssessorID+" Pending Requests Section!");
				}
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), "ToT/ToA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "Regular");
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
				maVp.clickToGetActionMenuOptions(batchID);
				//View Batch Details Data Verification
				maVp.clickToSelectViewBatchDetailsOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				maVp.enterBatchIDToSearch(batchID);
				maVp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				maVp.clickToGetActionMenuOptions(batchID);
				maVp.clickToSelectAcceptBatchOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(i==1)
				{
					maVp.enterRemarksForAcceptingBatch(dmasterAssessorRemarks);
				}
				else
				{
					maVp.enterRemarksForAcceptingBatch(pmasterAssessorRemarks);
				}
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") BatchId - "+batchID);
				maVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,-500)", "");
				//verifying Accepted Batch
				maVp.clickToGoToAcceptedBatchesSection();
				maVp.enterBatchIDToSearch(batchID);
				maVp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				if(i==1)
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Accepted Section!");
				}
				else
				{
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+pmasterAssessorID+" Accepted Section!");
				}
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), "ToT/ToA");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "Regular");
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
				maVp.clickToSelectViewBatchDetailsOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
		else
		{
			elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
			maDp.clickToGetAssessorDashboard();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			maDp.clickBatchAssessmentRequests();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
			maVp.clicktoGoToPendingRequestsSection();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			maVp.enterBatchIDToSearch(batchID);
			maVp.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Pending Requests Section!");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), "ToT/ToA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "Regular");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" - ("+domainJobRoleCode+"),\n"+platformJobRole+" - ("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" - "+state+","+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "For Assessment");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+" "+dAssessmentEndDate+",\n"+pAssessmentStartDate+" "+pAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Pending for Acceptance");
			maVp.clickToGetActionMenuOptions(batchID);
			//View Batch Details Data Verification
			maVp.clickToSelectViewBatchDetailsOption(batchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dmasterAssessorName+" ("+dmasterAssessorID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Pending");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+" ("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pmasterAssessorName+" ("+pmasterAssessorID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Pending");
			maVp.clickToGoBack();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			maVp.enterBatchIDToSearch(batchID);
			maVp.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			maVp.clickToGetActionMenuOptions(batchID);
			maVp.clickToSelectAcceptBatchOption(batchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			maVp.enterRemarksForAcceptingBatch(dmasterAssessorRemarks);
			maVp.clickToSaveAndSubmitBatchAccceptance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 65, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 64, formatter.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 83, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 82, formatter.format(date));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Accepted Successfully\nYou have successfully accepted\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") BatchId - "+batchID);
			maVp.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,-500)", "");
			//verifying Accepted Batch
			maVp.clickToGoToAcceptedBatchesSection();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			maVp.enterBatchIDToSearch(batchID);
			maVp.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Accepted Section!");
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+pmasterAssessorID+" Accepted Section!");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), "ToT/ToA");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), "Regular");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), domainJobRole+" - ("+domainJobRoleCode+"),\n"+platformJobRole+" - ("+platformJobRoleCode+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), tcName+" - "+state+","+district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "For Assessment");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), dAssessmentStartDate+" "+dAssessmentEndDate+",\n"+pAssessmentStartDate+" "+pAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Accepted");
			String masterAssessorActionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 64);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), masterAssessorActionDate);
			maVp.clickToGetActionMenuOptions(batchID);
			maVp.clickToSelectViewBatchDetailsOption(batchID);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
		}
	}
	
	@Test(dataProvider="sscBatchCreationData", dependsOnMethods= {"masterAssessorBatchApprovalTC_05","masterTrainerBatchApprovalTC_03"})
	public void sscVerifyingAllAprovedBatchesTC_06(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime, String domainMasterTrainerState, String domainMasterTrainerDistrict, String platformMasterTrainerState, String platformMasterTrainerDistrict, String domainAssessementAgencyState, String domainAssessmentAgencyDistrict, String platformAssessmentAgencyState, String platformAssessemntAgencyDistrict, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickAllBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.clickToViewAllPublishedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sAp.enterBatchIDToSearch(batchID);
		sAp.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), domainJobRole+"/"+domainJobRoleCode+", "+platformJobRole+"/"+platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Published");
		sAp.clickToGetBatchActionMenu(batchID);
		sAp.selectViewDetailsOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Master Trainer')]]")).getText().trim(), "Comments by Master Trainer on "+dmasterTrainerRemarksDate+" at "+dmasterTrainerRemarksTime.toLowerCase()+": "+dmtBatchAcceptanceRemarks);
		sVbP.clickToCloseDomainMasterTrainerViewCommentsWindow();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Verifying Accepted Platform Master Trainer Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[3]")).getText().trim(), pTrainingStartDate+" to "+pTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[4]")).getText().trim(), pmasterTrainerName+" ("+pmasterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Accepted");
		sVbP.selectViewPlatformMasterTrainerCommentsOption(platformJobRoleCode);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Master Trainer')]]")).getText().trim(), "Comments by Master Trainer on "+pmasterTrainerRemarksDate+" at "+pmasterTrainerRemarksTime.toLowerCase()+": "+pmtBatchAcceptanceRemarks);
		sVbP.clickToClosePlatformMasterTrainerViewCommentsWindow();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Verifying Accepted Domain Assessment Agency And Master Assessor Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[1]")).getText().trim(), domainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[3]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[4]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Accepted");
		sVbP.selectViewDomainAssessmentAgencyCommentsOption(domainJobRoleCode);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Assessment Agency')]]")).getText().trim(), "Comments by Assessment Agency on "+dassessmentAgencyRemarksDate+" at "+dassessmentAgencyRemarksTime.toLowerCase()+": "+daaBatchAcceptanceRemarks);
		sVbP.clickToCloseDomainAssessmentAgencyViewCommentsWindow();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Verifying Accepted Platform Assessment Agency And Master Assessor Details
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[1]")).getText().trim(), platformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[3]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[4]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Accepted");
		sVbP.selectViewPlatformAssessmentAgencyCommentsOption(platformJobRoleCode);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Assessment Agency')]]")).getText().trim(), "Comments by Assessment Agency on "+passessmentAgencyRemarksDate+" at "+passessmentAgencyRemarksTime.toLowerCase()+": "+paaBatchAcceptanceRemarks);
		sVbP.clickToClosePlatformAssessmentAgencyViewCommentsWindow();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
	public void rejectionBatchCreationTC_07(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtReasonForRejection, String dmtBatchRejectionRemarks, String dmtRemarksDate, String dmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ToT, ToA, ToMT,ToMA")));
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]"))));
		sscDbP.clickCreateBatch();
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectBatchType(batchType);
		sscTbcP.selectBatchCategory(batchCategory);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage.fileSave("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls");
		String configBatchStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 58);
		String configBatchEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 59);
		String configDomainTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 60);
		String configDomainTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 61);
		String configDomainAssessmentStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 62);
		String configDomainAssessmentEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 63);
		String configPlatformTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 64);
		String configPlatformTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 65);
		String configPlatformAssessemntStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 66);
		String configPlatformAssessemntEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 67);
		sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 9, trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 10, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
		//Sometimes platform job role will not be available
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")));
		driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
		if(driver.findElements(By.xpath("//label[text()='"+platformJobRole+"']")).size()==0)
		{
			js.executeScript("window.scrollBy(0,-1000)", "");
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("ToT, ToA, ToMT,ToMA")));
			driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
//			sscTbcP.selectSubSector(subSector);
			sscTbcP.selectBatchType(batchType);
			sscTbcP.selectBatchCategory(batchCategory);
			sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
			if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
			{
				sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
			}
			else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
			{
				sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
			}
			trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 9, trainingStartDate);
			trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 10, trainingEndDate);
			sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
			driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		else
		{
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(4000);
		sscTbcP.selectDomainTrainingStartDate(configDomainTrainingStartDate);
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch(configDomainTrainingEndDate);
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch(configDomainAssessmentStartDate);
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch(configDomainAssessmentEndDate);
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch(configDomainTrainingEndDate);
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch(configDomainAssessmentStartDate);
			Thread.sleep(2000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch(configDomainAssessmentEndDate);
			Thread.sleep(2000);
		}
		String domainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 15, domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 16, domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 17, domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 18, domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(2000);
		sscTbcP.selectPlatformTrainingStartDate(configPlatformTrainingStartDate);
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch(configPlatformTrainingEndDate);
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch(configPlatformAssessemntStartDate);
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch(configPlatformAssessemntEndDate);
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch(configPlatformTrainingEndDate);
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch(configPlatformAssessemntStartDate);
			Thread.sleep(2000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch(configPlatformAssessemntEndDate);
			Thread.sleep(2000);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 19, platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 20, platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 21, platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection",Integer.parseInt(serialNum) , 22, platformAssessmentEndDate);
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
		//STEP 2 OF BATCH CREATION -> Assigning Training Centre  and Assigning To Batches
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		js.executeScript("window.scrollBy(0,500)", "");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.selectStateFilter(state);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.selectDistrictFilter(district);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		sVbP.clickToGetSearchFilterResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.clickToChooseResultedTrainingCentreToAssign();
		sVbP.clickToSubmitSelectedTrainingCentre();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Master Trainer for Domain QP
		sVbP.clickDomainMasterTrainerAction(domainJobRole);
		sVbP.selectDomainAssignMasterTrainerOption();
		sVbP.enterDomainMasterTrainerIDToSearch(dmasterTrainerID);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+dmasterTrainerID+" for Domain QP -"+domainJobRoleCode);
		sVbP.clickToChooseDomainMasterTrainer();
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Master Trainer for Platform QP
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		sVbP.selectPlatformAssignMasterTrainerOption();
		sVbP.enterPlatformMasterTrainerIDToSearch(pmasterTrainerID);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+pmasterTrainerID+"')]")).size()==1,"OMG!!! No show of Searched Master Trainer  - "+pmasterTrainerID+" for Platform QP -"+platformJobRoleCode);
		sVbP.clickToChoosePlatformMasterTrainer();
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Domain QP Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole);
		sVbP.selectDomainAssignAssessmentAgencyOption();
		sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+dassessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+dassessmentAgencyID+" for Domain QP -"+domainJobRoleCode);
		sVbP.clickToChooseDomainAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		sVbP.selectPlatformAssignAssessmentAgencyOption();
		sVbP.enterPlatformAssessmentAgencyIDToSearch(passessmentAgencyID);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+passessmentAgencyID+"')]")).size()==1,"OMG!!! No show of Searched Assessment Agency  - "+passessmentAgencyID+" for Platform QP -"+platformJobRoleCode);
		sVbP.clickToChoosePlatformAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.clickConfirmation();
		Thread.sleep(2000);
		sVbP.clickToSubmitBatch();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 2,formatter.format(date));
		Thread.sleep(4000);
		sVbP.clickViewAllBatchesAfterBatchSubmission();
		Thread.sleep(5000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void trainingCentreBatchRejectionTC_08(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtReasonForRejection, String dmtBatchRejectionRemarks, String dmtRemarksDate, String dmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		if(serialNum.equals("4"))
		{
			for(int i=1;i<4;i++)
			{
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(tcID, tcPassword);
				WebDriverWait wait=new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
				LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				lTcDp.clickToViewBatches();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,200)","");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
				lTcVbP.enterToSearchForBatchID(batchID);
				lTcVbP.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Pending Requests section! OR Something is wrong! ");
				lTcVbP.clikToGetBatchActionMenu();
				lTcVbP.selectRejectBatchOption();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				lTcVbP.selectReasonForRejectingBatch(tcReasonForRejectingBatch);
				lTcVbP.enterRemarksForRejectingBatch(tcRejectionRemarks);
				lTcVbP.clickToRejectBatch();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Request Rejected\nYou have rejected request for\nBatch - "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");	
				lTcVbP.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! Rejected Batch - "+batchID+" should not be shown in pending batches section! OR Something is wrong! ");
				js.executeScript("window.scrollBy(0,-500)","");
				//verifying Rejected Batches
				lTcVbP.clickToViewAllRejectedBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)","");
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! rejected batch - "+batchID+" is not shown in Rejected batches section! OR Something is wrong! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Rejected");
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
				//SSC Reassigning Training Centre After Rejection
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
				lp.clickLogin();
				elp.performlogin(sscUsername, sscPassword);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
				SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
				sscDbP.clickToTToAToMTToMA();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)", "");
				sscDbP.clickAllBatches();
				SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sAp.enterBatchIDToSearch(batchID);
				sAp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rejected");
				sAp.clickToGetBatchActionMenu(batchID);
				sAp.selectViewDetailsOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[b[contains(text(),'Status of Training Centre')]]]]//span[1]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[b[contains(text(),'Status of Training Centre')]]]]//p[2]")).getText().trim(), tcReasonForRejectingBatch);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[div[b[contains(text(),'Status of Training Centre')]]]]//p[4]")).getText().trim(), tcRejectionRemarks);
				SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
				sVbP.clickReassignTC();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.selectStateFilter(state);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.selectDistrictFilter(district);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.enterReAssignTrainingCentreIDToSearch(tcID);
				sVbP.clickToGetSearchFilterResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.clickToChooseResultedTCToReAssign();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.clickToSubmitReAssignedTC();
				if(i==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
					Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim().equalsIgnoreCase("Cannot Assign Training Centre"));
					sVbP.clickToCancel();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				}
				else
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Training Centre Assigned\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")\nis successfully assigned to   "+tcName+"\nState : "+state+"\nDistrict : "+district);	
					sVbP.clickOk();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcID+"')]")).getText().trim(), tcID);
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tcName+"')]")).getText().trim(), tcName);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tpName);
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
					Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
				}
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
	}
	
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void masterTrainerBatchRejectionTC_09(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtReasonForRejection, String dmtBatchRejectionRemarks, String dmtRemarksDate, String dmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		if(serialNum.equals("3"))
		{
			for(int i=1;i<4;i++)
			{
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
				TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
				tDp.clickToGetTrainerDashboard();
				WebDriverWait wait=new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				tDp.clickAllBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
				tVp.clicktoGoPendingBatchesSection();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				tVp.enterBatchIDToSearch(batchID);
				tVp.clickToGetSearchFilterResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
				tVp.clickToGetActionMenuOptions(batchID);
				tVp.clickToSelectRejectBatchOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				tVp.selectReasonForRejectingBatch(dmtReasonForRejection);
				Thread.sleep(2000);	
				tVp.enterRemarksForRejectingBatch(dmtBatchRejectionRemarks);
				tVp.clickToSubmitBatchRejection();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 55, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 54, formatter.format(date));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Request Rejected\nYou have rejected request for\nBatch - "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				tVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Rejected Batch - "+batchID+" should not be shown in Pending Requests Section of Master Trainer - "+dmasterTrainerID);
				//verifying rejected batches
				js.executeScript("window.scrollBy(0,-500)", "");
				tVp.clickToGoToRejectedBatchesSection();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,300)", "");
				tVp.enterBatchIDToSearch(batchID);
				tVp.clickToGetSearchFilterResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Rejected Section of Master Trainer - "+dmasterTrainerID);
				tVp.clickToGetActionMenuOptions(batchID);
				tVp.clickToSelectViewDetailsOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector')]]/td[3]")).getText().trim(), expectedSector);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role Code')]]/td[3])[1]")).getText().trim(), domainJobRoleCode);
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
				//SSC Re-Assiging Master Trainer
				lp.clickLogin();
				Thread.sleep(2000);
				elp.performlogin(sscUsername, sscPassword);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
				js.executeScript("window.scrollBy(0,200)", "");
				SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
				sDp.clickAllBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
				sBp.clickToViewAllPendingBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sBp.enterBatchIDToSearch(batchID);
				sBp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertFalse(driver.findElements(By.xpath("//td[1][contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in "+sscUsername+" Pending Section!!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rejected");
				sBp.clickToGetBatchActionMenu(batchID);
				sBp.selectViewDetailsOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
				Assert.assertEquals(driver.findElement(By.xpath("//div[b[contains(text(),'Status of Training Centre')]]/span")).getText().trim(), "Pending");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Pending");
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[5]")).getText().trim(), "Rejected");
				sVbP.selectViewDomainMasterTrainerCommentsOption(domainJobRole);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				String masterTrainerRejectCommentsDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 54);
				String masterTrainerRejectCommentsTime=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 55);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Rejection Reason')]]")).getText().trim(), "Rejection Reason: "+dmtReasonForRejection);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Master Trainer')]]")).getText().trim(), "Comments by Master Trainer on "+masterTrainerRejectCommentsDate+" at "+masterTrainerRejectCommentsTime.toLowerCase()+": "+dmtBatchRejectionRemarks);
				sVbP.clickToCloseDomainMasterTrainerViewCommentsWindow();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.selectReAssignDomainMasterTrainerOption(domainJobRoleCode);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.enterDomainMasterTrainerIDToSearch(dmasterTrainerID);
				sVbP.clickToGetSearchFilterResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.clickToChooseReAssignDomainMasterTrainer();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.clickToFinallyReAsssignSelectedDomainMasterTrainer();
				if(i==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
					Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().equals("Cannot Assign Master Trainer"), "OMG!!! There is no toast message regarding Cannot Reassign Master Trainer for this Batch - "+batchID+" as 3 times this batch got rejected by master trainer - "+dmasterTrainerID+" !!!!  ");
					sVbP.clickToCancel();
					Thread.sleep(4000);
				}
				else
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
					sVbP.clickOk();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
					//after Reassign, batch status should not be rejected
					js.executeScript("window.scrollBy(0,-1000)", "");
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sVbP.clickGoBack();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sBp.clickToViewAllPendingBatches();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sBp.enterBatchIDToSearch(batchID);
					sBp.clickToGetSearchResult();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending to be Published");
				}
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
	}
		
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void assessmentAgencyBatchRejectionTC_10(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtReasonForRejection, String dmtBatchRejectionRemarks, String dmtRemarksDate, String dmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		if(serialNum.equals("2"))
		{
			for(int i=1;i<4;i++)
			{
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
				WebDriverWait wait=new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
				aDp.clickBatchAssessmentRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
				aVp.clickToViewPendingBatchRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
				js.executeScript("window.scrollBy(0,200)", "");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Pending for Acceptance");
				if(i==1)
				{
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), batchCreatedDate);
				}
				else
				{
					String reAssignedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 91);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), reAssignedDate);
				}
				aVp.clickToGetActionMenuOptions();
				aVp.clickToSelectRejectBatchOption();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				aVp.selectReasonForRejectingBatch(daaReasonForRejectingBatch);
				Thread.sleep(2000);
				aVp.enterRemarksForRejctingBatch(daaRejectionRemarks);
				Thread.sleep(4000);
				aVp.clickToSubmitBatchRejection();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 62, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 61, formatter.format(date));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Rejected\nYou have rejected request for\nBatchId - "+batchID);
				aVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG!!! Rejected Batch - "+batchID+" should not be shown in pending section of - "+dassessmentAgencyID+" OR something is wrong! ");
				//verifying rejected batches
				js.executeScript("window.scrollBy(0,-500)", "");
				aVp.clickToViewRejectedBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)", "");
				Assert.assertTrue(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==1,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section of - "+dassessmentAgencyID+" !!! ");
				String rejectedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 61);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), rejectedDate);
				if(i==1)
				{
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[11]")).getText().trim(), batchCreatedDate);
				}
				else
				{
					String reAssignedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 91);
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[11]")).getText().trim(), reAssignedDate);
				}
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
				//SSC ReAssiging AA
				lp.clickLogin();
				Thread.sleep(2000);
				elp.performlogin(sscUsername, sscPassword);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
				js.executeScript("window.scrollBy(0,200)", "");
				SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
				sDp.clickAllBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
				sBp.clickToViewAllPendingBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sBp.enterBatchIDToSearch(batchID);
				sBp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertFalse(driver.findElements(By.xpath("//td[1][contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in "+sscUsername+" Pending Section!!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rejected");
				sBp.clickToGetBatchActionMenu(batchID);
				sBp.selectViewDetailsOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
				Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[5]")).getText().trim(), "Rejected");
				sVbP.selectViewDomainAssessmentAgencyCommentsOption(domainJobRoleCode);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				String rejectectionDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 61);
				String rejectionTime=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 62);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Rejection Reason')]]")).getText().trim(), "Rejection Reason: "+daaReasonForRejectingBatch);
				Assert.assertEquals(driver.findElement(By.xpath("//p[b[contains(text(),'Comments by Assessment Agency')]]")).getText().trim(), "Comments by Assessment Agency on "+rejectectionDate+" at "+rejectionTime.toLowerCase()+": "+daaRejectionRemarks);
				//Domain Job Role - Assessment Agency
				sVbP.clickToCloseDomainAssessmentAgencyViewCommentsWindow();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.selectReAssignDomainAssessmentAgencyOption(domainJobRoleCode);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
				sVbP.clickToGetSearchFilterResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				sVbP.clickToChooseReAssignDomainAssessmentAgency();
				Thread.sleep(2000);
				sVbP.clickToFinallyReAsssignSelectedDomainAssessmentAgency();
				if(i==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
					Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().equals("Cannot Assign Assessment Agency"), "OMG!!! There is no toast message regarding Cannot Reassign Assessment Agency for this Batch - "+batchID+" as 3 times this batch got rejected by Assessment Agency - "+dassessmentAgencyID+" !");
					sVbP.clickToCancel();
					Thread.sleep(2000);
				}
				else
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
					sBp.clickOk();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
					//ReAssigning Assessment Agency For platform Job Role
					sVbP.selectReAssignAssessmentAgencyOptionForJobRole(platformJobRoleCode);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
					sVbP.clickToGetDomainJobRoleAssessmentAgencyFilterResult();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sVbP.clickToChooseReAssignDomainJobroleAssessmentAgency();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sVbP.clickToFinallyReAsssignSelectedDomainJobRoleAssessmentAgency();
					ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 91, formatter.format(date));
					sBp.clickOk();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
					//after Reassign, batch status should not be rejected
					js.executeScript("window.scrollBy(0,-1000)", "");
					sDp.clickToTToAToMTToMA();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sDp.clickAllBatches();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sBp.clickToViewAllPendingBatches();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					sBp.enterBatchIDToSearch(batchID);
					sBp.clickToGetSearchResult();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending to be Published");
				}
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
	}
	
	@Test(dataProvider="batchRejectionData", dependsOnMethods="rejectionBatchCreationTC_07")
	public void masterAssessorBatchRejectionTC_11(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcReasonForRejectingBatch, String tcRejectionRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtReasonForRejection, String dmtBatchRejectionRemarks, String dmtRemarksDate, String dmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaReasonForRejectingBatch, String daaRejectionRemarks, String daaRemarksDate, String daaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaReasonForRejectingBatch, String dmaRejectionRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtReasonForRejectingBatch, String pmtBatchRejectiRemarks, String pmtRemarksDate, String pmtRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaReasonForRejectingBatch, String paaBatchRejectionRemarks, String paaRemarksDate, String paaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaReasonForRejectingBatch, String pmaRejectionRemarks, String pmaRemarksDate, String pmaRemarksTime, String assessmentAgencyReAssignedDate, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		if(serialNum.equals("1"))
		{
			for(int i=1; i<4;i++)
			{
				WebDriverWait wait=new WebDriverWait(driver, 30);
				if(i==1)
				{
					LoginPage lp=new LoginPage(driver);
					lp.clickLogin();
					EnterLoginPage elp=new EnterLoginPage(driver);
					elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,200)", "");
					AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
					aDp.clickBatchAssessmentRequests();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
					aVp.clickToViewPendingBatchRequests();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					aVp.enterBatchIdToSearch(batchID);
					aVp.clickToApplySelectedSearchFilters();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Pending Requests section!!! ");
					js.executeScript("window.scrollBy(0,200)", "");
					aVp.clickToGetActionMenuOptions();
					aVp.clickToSelectAcceptBatchOption();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					aVp.enterRemarksForAcceptingBatch("Accepted By DAA");
					aVp.clickToSubmitBatchAcceptance();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					aVp.clickOk();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					//verifying accepted batches & assigning assessors
					aVp.clickToViewAcceptedBatches();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					aVp.enterBatchIdToSearch(batchID);
					aVp.clickToApplySelectedSearchFilters();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					js.executeScript("window.scrollBy(0,200)", "");
					aVp.clickToGetActionMenuOptions();
					aVp.clickToSelectAssignAssessorsOption();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					aVp.selectMasterAssessorForDomain1(dmasterAssessorName+"("+dmasterAssessorID+")");
					aVp.selectMasterAssessorForDomain2(dmasterAssessorName+"("+dmasterAssessorID+")");
					aVp.clickToSubmitMasterAssessors();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					aVp.clickOk();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
					PostLoginPage plp=new PostLoginPage(driver);
					plp.clickOnProfileLogo();
					Thread.sleep(2000);
					plp.clickOnLogout();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
				}
				//Assigned Master Assessor Rejecting Batch
				LoginPage lp=new LoginPage(driver);
				lp.clickLogin();
				Thread.sleep(2000);
				EnterLoginPage elp=new EnterLoginPage(driver);
				elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
				maDp.clickToGetAssessorDashboard();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				maDp.clickBatchAssessmentRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
				maVp.clicktoGoToPendingRequestsSection();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)", "");
				maVp.enterBatchIDToSearch(batchID);
				maVp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Pending Requests Section!");
				maVp.clickToGetActionMenuOptions(batchID);
				maVp.clickToSelectRejectBatchOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				maVp.selectReasonForRejectingBatch(dmaReasonForRejectingBatch);
				maVp.enterRemarksForRejectingBatch(dmaRejectionRemarks);
				maVp.clickToSaveAndSubmitBatchRejection();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 69, timeFormat.format(date));
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 68, formatter.format(date));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Request Rejected\nYou have rejected request for\nBatch - "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") BatchId - "+batchID);
				maVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				js.executeScript("window.scrollBy(0,-500)", "");
				//verifying Rejected Batch
				maVp.clickToGoToRejectedBatchesSection();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				js.executeScript("window.scrollBy(0,250)", "");
				maVp.enterBatchIDToSearch(batchID);
				maVp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in Master Assessor - "+dmasterAssessorID+" Rejected Section!");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "For Assessment");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Rejected");
				String rejectedDate=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchRejection", Integer.parseInt(serialNum), 68);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[10]")).getText().trim(), rejectedDate);
				//View Batch Details - Rejected Status for Master Assessor
				maVp.clickToGetActionMenuOptions(batchID);
				maVp.clickToSelectViewBatchDetailsOption(batchID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
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
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+" ("+domainJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dassessmentAgencyName+" ("+dassessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), dmasterAssessorName+" ("+dmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole+" ("+platformJobRoleCode+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), passessmentAgencyName+" ("+passessmentAgencyID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), pmasterAssessorName+" ("+pmasterAssessorID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Rejected");
				PostLoginPage plp=new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
				//ReAssigning Master Assessor By Assessment Agency
				lp.clickLogin();
				elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				js.executeScript("window.scrollBy(0,200)", "");
				AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
				aDp.clickBatchAssessmentRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
				aVp.clickToViewAcceptedBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of batch - "+batchID+" in "+dassessmentAgencyID+" Accepted Requests section!!! ");
				js.executeScript("window.scrollBy(0,200)", "");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]")).getText().trim(), "Rejected by Assessor");
				aVp.clickToGetActionMenuOptions();
				aVp.clickToSelectViewBatchDetailsOption();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), "Rejected");
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), "Rejected");
				aVp.clickToGetJobRoleActionMenu(domainJobRole);
				aVp.selectViewCommentsOption(domainJobRole);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Comments by Assessor on')]]]]/div[1]")).getText().trim(), "Comments by Assessor on "+rejectedDate+" :");
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Comments by Assessor on')]]]]/div[2]")).getText().trim(), dmaRejectionRemarks);
				aVp.clickToCloseViewComments();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				aVp.clickToGetJobRoleActionMenu(domainJobRole);
				aVp.selectReAssignMasterAssessorOption(domainJobRole);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				//Verifying Batch Details
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch ID')]]]]/div[2]/span")).getText().trim(),batchID);
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch Name')]]]]/div[4]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
				Assert.assertEquals(driver.findElement(By.xpath("//div[span[strong[contains(text(),'Training Centre Name')]]]")).getText().trim(), "Training Centre Name & Location : "+tcName);
				Assert.assertEquals(driver.findElement(By.xpath("//div[strong[contains(text(),'State')]]")).getText().trim(), "State : "+state);
				Assert.assertEquals(driver.findElement(By.xpath("//div[span[strong[contains(text(),'District')]]]")).getText().trim(), "District : "+district);
				Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+domainJobRoleCode+"')]")).getText().trim(), domainJobRoleCode);
				Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+dAssessmentStartDate+" to')]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
				aVp.selectReAssignMasterAssessorForDomain1(dmasterAssessorName, dmasterAssessorID);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));	
				aVp.clickToSubmitReAssignedMasterAssessor();
				if(i==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Cannot Assign Assessor");
					aVp.clickToCancel();
					Thread.sleep(6000);
				}
				else
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-content")));
					Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned "+dmasterAssessorName+" ("+dmasterAssessorID+") for the "+batchID);
					aVp.clickOk();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), dmasterAssessorName+"("+dmasterAssessorID+")");
					Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), "Pending");
				}
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
	}
	
	//Re-Shedule Cancel
	@DataProvider
	public Object[][] rescheduleCancelBatchData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel");
	}
	@Test(dataProvider="rescheduleCancelBatchData")
	public void rescheduleCancelBatchCreationTC_12(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String tcState, String tcDistrict, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)", "");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]"))));
		sscDbP.clickCreateBatch();
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
//		sscTbcP.selectSubSector(subSector);
		sscTbcP.selectBatchType(batchType);
		sscTbcP.selectBatchCategory(batchCategory);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage.fileSave("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls");
		String configBatchStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 58);
		String configBatchEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 59);
		String configDomainTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 60);
		String configDomainTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 61);
		String configDomainAssessmentStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 62);
		String configDomainAssessmentEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 63);
		String configPlatformTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 64);
		String configPlatformTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 65);
		String configPlatformAssessemntStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 66);
		String configPlatformAssessemntEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 67);
		sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 9, trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 10, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
		//Sometimes platform job role will not be available
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")));
		driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
		if(driver.findElements(By.xpath("//label[text()='"+platformJobRole+"']")).size()==0)
		{
			js.executeScript("window.scrollBy(0,-1000)", "");
			driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
//			sscTbcP.selectSubSector(subSector);
			sscTbcP.selectBatchType(batchType);
			sscTbcP.selectBatchCategory(batchCategory);
			sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
			if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
			{
				sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
			}
			else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
			{
				sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
			}
			trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 9, trainingStartDate);
			trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 10, trainingEndDate);
			sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
			driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		else
		{
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		sscTbcP.selectDomainTrainingStartDate(configDomainTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch(configDomainTrainingEndDate);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch(configDomainAssessmentStartDate);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch(configDomainAssessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch(configDomainTrainingEndDate);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch(configDomainAssessmentStartDate);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch(configDomainAssessmentEndDate);
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
		sscTbcP.selectPlatformTrainingStartDate(configPlatformTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch(configPlatformTrainingEndDate);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch(configPlatformAssessemntStartDate);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch(configPlatformAssessemntEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch(configPlatformTrainingEndDate);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch(configPlatformAssessemntStartDate);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch(configPlatformAssessemntEndDate);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 19, platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 20, platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 21, platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 22, platformAssessmentEndDate);
		sscTbcP.selectBatchSize(batchSize);
		sscTbcP.clickToCreateBatch();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 1, createdBatchID);
		sscTbcP.clickOk();
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		js.executeScript("window.scrollBy(0,500)", "");
		sVbP.selectStateFilter(tcState);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.selectDistrictFilter(tcDistrict);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		sVbP.clickToGetSearchFilterResult();
		sVbP.clickToChooseResultedTrainingCentreToAssign();
		sVbP.clickToSubmitSelectedTrainingCentre();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Master Trainer for domain QP
		sVbP.clickDomainMasterTrainerAction(domainJobRole);
		sVbP.selectDomainAssignMasterTrainerOption();
		sVbP.enterDomainMasterTrainerIDToSearch(masterTrainerID);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		sVbP.clickToChooseDomainMasterTrainer();
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Platform QP Master Trainer
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		sVbP.selectPlatformAssignMasterTrainerOption();
		sVbP.enterPlatformMasterTrainerIDToSearch(masterTrainerID);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		sVbP.clickToChoosePlatformMasterTrainer();
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Domain QP Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole);
		sVbP.selectDomainAssignAssessmentAgencyOption();
		sVbP.enterDomainAssessmentAgencyIDToSearch(assessmentAgencyID);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		sVbP.clickToChooseDomainAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		sVbP.selectPlatformAssignAssessmentAgencyOption();
		sVbP.enterPlatformAssessmentAgencyIDToSearch(assessmentAgencyID);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		sVbP.clickToChoosePlatformAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,500)", "");
		sVbP.clickConfirmation();
		sVbP.clickToSubmitBatch();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel", Integer.parseInt(serialNum), 2,formatter.format(date));
		sVbP.clickOkForBatchSubmission();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="rescheduleCancelBatchCreationTC_12")
	public void rescheduleCancelBatchApprovalTC_13(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String tcState, String tcDistrict, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		//Assigned TC Login to Accept Batch
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectAcceptBatchOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clickToAcceptBatch();
		lTcVbP.clickOk();
		PostLoginPage plp=new PostLoginPage(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		plp.clickOnProfileLogo();
		Thread.sleep(1000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//Assigned Master Trainer Login To Accept the Batch
		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(masterTrainerID, masterTrainerPassword);
		tDp.clickToGetTrainerDashboard();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tDp.clickAllBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)", "");
		tVp.enterBatchIDToSearch(batchID);
		tVp.clickToGetSearchFilterResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tVp.clickToGetActionMenuOptions(batchID);
		tVp.clickToSelectAcceptBatchOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		tVp.clickToSubmit();
		tVp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//Assigned Assessment Agency accepting batch
		lp.clickLogin();
		elp.performlogin(assessmentAgencyID, assessmentAgencyPassword);
		AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
		aDp.clickBatchAssessmentRequests();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
		aVp.enterBatchIdToSearch(batchID);
		aVp.clickToApplySelectedSearchFilters();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)", "");
		aVp.clickToGetActionMenuOptions();
		aVp.clickToSelectAcceptBatchOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		aVp.clickToSubmitBatchAcceptance();
		aVp.clickOk();
		//assigning assessors
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		aVp.clickToViewAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		aVp.enterBatchIdToSearch(batchID);
		aVp.clickToApplySelectedSearchFilters();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)", "");
		aVp.clickToGetActionMenuOptions();
		aVp.clickToSelectAssignAssessorsOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		aVp.selectMasterAssessorForDomain1(masterAssessorName+"("+masterAssessorID+")");
		aVp.selectMasterAssessorForDomain2(masterAssessorName+"("+masterAssessorID+")");
		aVp.clickToSubmitMasterAssessors();
		aVp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//Master Assessor Login to Accept Batches
		lp.clickLogin();
		elp.performlogin(masterAssessorID, masterAssessorPassword);
		AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
		maDp.clickToGetAssessorDashboard();
		js.executeScript("window.scrollBy(0,500)", "");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		maDp.clickBatchAssessmentRequests();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
		maVp.enterBatchIDToSearch(batchID);
		maVp.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)", "");
		maVp.clickToGetActionMenuOptions(batchID);
		maVp.clickToSelectAcceptBatchOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		maVp.clickToSaveAndSubmitBatchAccceptance();
		maVp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="rescheduleCancelBatchApprovalTC_13")
	public void sscRejectingBatchRescheduleRequestTC_14(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String tcState, String tcDistrict, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.clickToViewAllAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectRaiseRescheduleRequestOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clickToBrowseForBatchRescheduleSupportingDocument();
		Thread.sleep(2000);
		UploadFile.upload(batchRescheduleSupportingDocument);
		Thread.sleep(2000);
		lTcVbP.clickToUploadBatchRescheduleSupportingDocument();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
		lTcVbP.enterCommentsForBatchReschedule(batchRescheduleComments);
		lTcVbP.clickToSubmitBatchreschedule();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Reschedule request Raised");
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Reschedule request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been sent to SSC.");
		lTcVbP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Reschedule");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//SSC Rejecting Batch Reschedule
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   	 	lp.clickLogin();
   	 	elp.performlogin(sscUsername, sscPassword);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
   	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
   	 	sDp.clickAllBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
   	 	sAp.clickToViewAllPublishedBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Reschedule");
		sAp.clickToGetBatchActionMenu(batchID);
		sAp.selectApproveOrRejectRescheduleRequestOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchRescheduleSupportingDocument+"')])[1]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[1]")).getText().trim(), batchRescheduleComments);
		sAp.clickToRejectBatchRescheduleRequest();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Request Rejected");
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Reschedule request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") "+batchID+" has been rejected");
		sAp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Published");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscRejectingBatchRescheduleRequestTC_14")
	public void sscApprovingBatchRescheduleRequestButNotUpdatingBatchDurationTC_15(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String tcState, String tcDistrict, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.clickToViewAllAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Published");
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectRaiseRescheduleRequestOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clickToBrowseForBatchRescheduleSupportingDocument();
		Thread.sleep(2000);
		UploadFile.upload(batchRescheduleSupportingDocument);
		Thread.sleep(2000);
		lTcVbP.clickToUploadBatchRescheduleSupportingDocument();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
		lTcVbP.enterCommentsForBatchReschedule(batchRescheduleComments);
		lTcVbP.clickToSubmitBatchreschedule();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Reschedule request Raised");
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Reschedule request for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been sent to SSC.");
		lTcVbP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Reschedule");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//SSC Approving Batch Reschedule Request but not changing training dates.
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   	 	lp.clickLogin();
   	 	elp.performlogin(sscUsername, sscPassword);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
   	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
   	 	sDp.clickAllBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockMsg.blockPage")));
   	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
   	 	sAp.clickToViewAllPublishedBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Reschedule");
		sAp.clickToGetBatchActionMenu(batchID);
		sAp.selectApproveOrRejectRescheduleRequestOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchRescheduleSupportingDocument+"')])[1]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[1]")).getText().trim(), batchRescheduleComments);
		sAp.clickToApproveBatchRescheduleRequest();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sAp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='sector']")).getAttribute("value").trim(), expectedSector);
//		Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='subSector'])[1]")).getAttribute("value").trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='subSector']")).getAttribute("value").trim(), batchType);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Batch Rescheduled Successfully!!");
		sRp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sAp.clickToViewAllPublishedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rescheduled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscApprovingBatchRescheduleRequestButNotUpdatingBatchDurationTC_15")
	public void sscApprovingBatchRescheduleRequestAndUpdatingBatchDurationTC_16(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String tcState, String tcDistrict, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.clickToViewAllAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Rescheduled");
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectRaiseRescheduleRequestOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clickToBrowseForBatchRescheduleSupportingDocument();
		Thread.sleep(2000);
		UploadFile.upload(batchRescheduleSupportingDocument);
		Thread.sleep(2000);
		lTcVbP.clickToUploadBatchRescheduleSupportingDocument();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
		lTcVbP.enterCommentsForBatchReschedule(batchRescheduleComments);
		lTcVbP.clickToSubmitBatchreschedule();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Reschedule request Raised");
		lTcVbP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//Now SSC Will Approve Reschedule request and Changes the batch dates
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   	 	lp.clickLogin();
   	 	elp.performlogin(sscUsername, sscPassword);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
   	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
   	 	sDp.clickAllBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockMsg.blockPage")));
   	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
   	 	sAp.clickToViewAllPublishedBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Reschedule");
		sAp.clickToGetBatchActionMenu(batchID);
		sAp.selectApproveOrRejectRescheduleRequestOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchRescheduleSupportingDocument+"')])[1]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[1]")).getText().trim(), batchRescheduleComments);
		sAp.clickToApproveBatchRescheduleRequest();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sAp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		SSC_BatchReSchedulePage sRp=new SSC_BatchReSchedulePage(driver);
		String configRescheduleBatchStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 68);
		String configRescheduleBatchEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 69);
		String configRescheduleDomainTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 70);
		String configRescheduleDomainTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 71);
		String configRescheduleDomainAssessmentStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 72);
		String configRescheduleDomainAssessmentEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 73);
		String configReschedulePlatformTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 74);
		String configReschedulePlatformTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 75);
		String configReschedulePlatformAssessemntStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 76);
		String configReschedulePlatformAssessemntEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 77);
		sRp.selectTrainingStartDateForBatch(configRescheduleBatchStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sRp.selectTrainingEndDateForNewBatch(configRescheduleBatchEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sRp.selectTrainingEndDateForExistingBatch(configRescheduleBatchEndDate);
		}
		String rTrainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 38, rTrainingStartDate);
		String rTrainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchReSchedule-Cancel",Integer.parseInt(serialNum) , 39, rTrainingEndDate);
		//Domain QP		
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'"+domainJobRoleCode+"')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sRp.selectDomainTrainingStartDate(configRescheduleDomainTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sRp.selectDomainTrainingEndDateForNewBatch(configRescheduleDomainTrainingEndDate);
			sRp.selectDomainAssessmentStartDateForNewBatch(configRescheduleDomainAssessmentStartDate);
			sRp.selectDomainAssessmentEndDateForNewBatch(configRescheduleDomainAssessmentEndDate);
		}		
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sRp.selectDomainTrainingEndDateForExistingBatch(configRescheduleDomainTrainingEndDate);
			sRp.selectDomainAssessmentStartDateForExistingBatch(configRescheduleDomainAssessmentStartDate);
			sRp.selectDomainAssessmentEndDateForExistingBatch(configRescheduleDomainAssessmentEndDate);
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
		sRp.selectPlatformTrainingStartDate(configReschedulePlatformTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sRp.selectPlatformTrainingEndDateForNewBatch(configReschedulePlatformTrainingEndDate);
			sRp.selectPlatformAssessmentStartDateForNewBatch(configReschedulePlatformAssessemntStartDate);
			sRp.selectPlatformAssessmentEndDateForNewBatch(configReschedulePlatformAssessemntEndDate);
		}		
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sRp.selectPlatformTrainingEndDateForExistingBatch(configReschedulePlatformTrainingEndDate);
			sRp.selectPlatformAssessmentStartDateForExistingBatch(configReschedulePlatformAssessemntStartDate);
			sRp.selectPlatformAssessmentEndDateForExistingBatch(configReschedulePlatformAssessemntEndDate);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Batch Rescheduled Successfully!!");
		sRp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sAp.clickToViewAllPublishedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rTrainingStartDate+" - "+rTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rescheduled");
		sAp.clickToGetBatchActionMenu(batchID);
		sAp.selectViewDetailsOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Verifying Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch ID')]]/td[3]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Name')]]/td[3]")).getText().trim(), batchType+"/"+rTrainingStartDate+" to "+rTrainingEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), rTrainingStartDate+" to "+rTrainingEndDate);
		//Verifying Accepted Training Centre Details
		Assert.assertEquals(driver.findElement(By.xpath("//div[b[contains(text(),'Status of Training Centre')]]/span")).getText().trim(), "Accepted");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//TC checking status of ReScheduled Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(tcID, tcPassword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clickToViewAllAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rTrainingStartDate+" to "+rTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Rescheduled");
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectViewBatchDetailsOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Asserting view Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID:')]]]/label[2]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Name:')]]]/label[2]")).getText().trim(), batchType+"/"+rTrainingStartDate+" to "+rTrainingEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Size:')]]]/label[2]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Date')]]]/label[2]")).getText().trim(), rTrainingStartDate.replaceAll("-", "/")+" to "+rTrainingEndDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Type:')]]]/label[2]")).getText(), batchType);
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
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscApprovingBatchRescheduleRequestAndUpdatingBatchDurationTC_16")
	public void sscRejectingBatchCancellationRequestTC_17(String serialNum, String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.clickToViewAllAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectRaiseCancellationRequest();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clickToBrowseForBatchCancellationSupportingDocument();
		Thread.sleep(2000);
		UploadFile.upload(batchCancellationSupportingDocument);
		Thread.sleep(2000);
		lTcVbP.clickToUploadBatchCancellationSupportingDocument();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
		lTcVbP.enterCommentsForBatchCancellation(batchCancellationComments);
		lTcVbP.clickToSubmitBatchCancellation();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Cancellation Request Raised\nCancellation request for the "+batchType+"/"+rescheduledBatchStartDate+" to "+rescheduledBatchEndDate+"("+batchID+") has been sent to SSC");
		lTcVbP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rescheduledBatchStartDate+" to "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Cancellation");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//SSC Rejecting Cancellation Request
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   	 	lp.clickLogin();
   	 	elp.performlogin(sscUsername, sscPassword);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
   	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
   	 	sDp.clickAllBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockMsg.blockPage")));
   	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
   	 	sAp.clickToViewAllPublishedBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Cancellation");
		sAp.clickToGetBatchActionMenu(batchID);
		sAp.selectApproveOrRejectCancellationRequestOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchCancellationSupportingDocument+"')])[2]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[2]")).getText().trim(), batchCancellationComments);
		sAp.clickToRejectBatchCancellationRequest();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Request Rejected\nCancellation request for the "+batchType+"/"+rescheduledBatchStartDate+" to "+rescheduledBatchEndDate+"("+batchID+") "+batchID+" has been rejected");
		sAp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Rescheduled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="rescheduleCancelBatchData", dependsOnMethods="sscRejectingBatchCancellationRequestTC_17")
	public void sscApprovingBatchCancellationRequestTC_18(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String masterTrainerID, String masterTrainerPassword, String assessmentAgencyID, String assessmentAgencyPassword, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String state, String district, String batchRescheduleSupportingDocument, String batchRescheduleComments, String rescheduledBatchStartDate, String rescheduledBatchEndDate, String rescheduledDomainTrainingStartDate, String rescheduledDomainTrainingEndDate, String rescheduledDomainAssessmentStartDate, String rescheduledDomainAssessmentEndDate, String rescheduledPlatformTrainingStartDate, String rescheduledPlatformTrainingEndDate, String rescheduledPlatformAssessmentStartDate, String rescheduledPlatformAssessmentEndDate, String batchCancellationSupportingDocument, String batchCancellationComments, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.clickToViewAllAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Rescheduled");
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectRaiseCancellationRequest();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clickToBrowseForBatchCancellationSupportingDocument();
		Thread.sleep(2000);
		UploadFile.upload(batchCancellationSupportingDocument);
		Thread.sleep(2000);
		lTcVbP.clickToUploadBatchCancellationSupportingDocument();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
		lTcVbP.enterCommentsForBatchCancellation(batchCancellationComments);
		lTcVbP.clickToSubmitBatchCancellation();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Cancellation Request Raised\nCancellation request for the "+batchType+"/"+rescheduledBatchStartDate+" to "+rescheduledBatchEndDate+"("+batchID+") has been sent to SSC");
		lTcVbP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rescheduledBatchStartDate+" to "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Requested for Cancellation");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//SSC Approving Cancellation Request
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   	 	lp.clickLogin();
   	 	elp.performlogin(sscUsername, sscPassword);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
   	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
   	 	sDp.clickAllBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockMsg.blockPage")));
   	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
   	 	sAp.clickToViewAllPublishedBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Requested for Cancellation");
		sAp.clickToGetBatchActionMenu(batchID);
		sAp.selectApproveOrRejectCancellationRequestOption(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("(//button[contains(text(),'"+batchCancellationSupportingDocument+"')])[2]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//div[b[contains(text(),'Rejected Reason')]]/p)[2]")).getText().trim(), batchCancellationComments);
		sAp.clickToApproveBatchCancellationRequest();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Batch Cancelled Successfully!!\n"+batchType+"/"+rescheduledBatchStartDate+" to "+rescheduledBatchEndDate+"("+batchID+") has been cancelled");
		sAp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), rescheduledBatchStartDate+" - "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Cancelled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//TC checking status of Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(tcID, tcPassword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clickToViewAllAcceptedBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), rescheduledBatchStartDate+" to "+rescheduledBatchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Cancelled");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	//Batch Full Test Case
	@DataProvider
    public Object[][] totApplicantsData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants");
    }
    @Test(dataProvider="totApplicantsData", dependsOnMethods={"masterAssessorBatchApprovalTC_05", "masterTrainerBatchApprovalTC_03"})
    public void batchFullTC_19(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1")||serialNum.equals("2"))
	   	{
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", 1, 1);
			String tcID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 4);
			String tcPassword=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 5);
			String tcState=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 19);
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   		LoginPage lp=new LoginPage(driver);
 	   		lp.clickLogin();
 	   		EnterLoginPage elp=new EnterLoginPage(driver);
 	   		//Applicant Applying for batch
 	   		elp.performlogin(trainerID, applicantPassword);
 	   		TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
 	   		tDp.clickToGetApplicantDashboard();
 	   		WebDriverWait wait=new WebDriverWait(driver, 20);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tDp.clickSearchAndApplyforAvailableBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
 	   		tSp.selectState(tcState);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tSp.selectSector(configBatchSector);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tSp.clickSearch();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			tSp.clickToGetBatchActionMenu(batchID);
			tSp.selectApplyToBatch(batchID);
			tSp.clickOK();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
 	   		//TC Approving Applicants
			lp.clickLogin();
 	   		elp.performlogin(tcID, tcPassword);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
 	   		tcDp.clickToViewBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
 	   		tcVp.clickToViewAllAcceptedBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tcVp.enterToSearchForBatchID(batchID);
 	   		tcVp.clickToGetSearchResult();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
 	   		tcVp.clikToGetBatchActionMenu();
 	   		tcVp.selectEnrollApplicantsOption();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tcVp.clickToGetApplicantActionMenu(trainerID);
 	   		tcVp.selectEnrollApplicantOption(trainerID);
 	   		if(serialNum.equals("2"))
 	   		{
 	   			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
 	   			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Can not enroll more candidates than batch size, please check total number of enrolled / approved candidates count");
 	   		}
 	   		else
 	   		{
 	   			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 	   			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("approved successfully"),"OMG!!! Applicant Enroll Successfull Popup Text not displayed OR Something went wrong! ");
 	   			tcVp.clickOk();
 	   			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
 	   		}
 	   		plp.clickOnProfileLogo();
 	   		Thread.sleep(2000);
 	   		plp.clickOnLogout();
 	   	}
	}
    
    @Test(dataProvider="sscBatchCreationData", dependsOnMethods="batchFullTC_19")
    public void sendBackBatchTC_20(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcPassword, String tpName, String tcName, String website, String capacity, String tcHeadName, String tcHeadMobile, String tcHeadEmail, String tcSPOCName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmasterTrainerRemarksDate, String dmasterTrainerRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String dassessmentAgencyRemarksDate, String dassessmentAgencyRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmasterAssessorRemarks, String dmasterAssesorRemarksDate, String dmasterAssessorRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmasterTrainerRemarksDate, String pmasterTrainerRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String passessmentAgencyRemarksDate, String passessmentAgencyRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmasterAssessorRemarks, String pmasterAssesorRemarksDate, String pmasterAssessorRemarksTime, String domainMasterTrainerState, String domainMasterTrainerDistrict, String platformMasterTrainerState, String platformMasterTrainerDistrict, String domainAssessementAgencyState, String domainAssessmentAgencyDistrict, String platformAssessmentAgencyState, String platformAssessemntAgencyDistrict, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
    {
    	if(serialNum.equals("1"))
    	{
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
        	LoginPage lp=new LoginPage(driver);
        	lp.clickLogin();
     	   	EnterLoginPage elp=new EnterLoginPage(driver);
	   		elp.performlogin(tcID, tcPassword);
	   		WebDriverWait wait=new WebDriverWait(driver, 30);
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
	   		tcDp.clickToViewBatches();
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
	   		tcVp.clickToViewAllAcceptedBatches();
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		tcVp.enterToSearchForBatchID(batchID);
 	   		tcVp.clickToGetSearchResult();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
	   		tcVp.clikToGetBatchActionMenu();
	   		tcVp.selectEnrollApplicantsOption();
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
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
     	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
     	   	tcVp.clickOk();
     	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
     	   	PostLoginPage plp=new PostLoginPage(driver);
     	   	plp.clickOnProfileLogo();
	   		plp.clickOnLogout();
	   		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
     	   	//SSC Sending Back Batch
     	   	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
      	 	lp.clickLogin();
      	 	elp.performlogin(sscUsername, sscPassword);
      	 	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
      	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
      	 	sDp.clickAllBatches();
      	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
      	 	sAp.clickToViewAllPublishedBatches();
      	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	sAp.enterBatchIDToSearch(batchID);
      	 	sAp.clickToGetSearchResult();
      	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Submitted for Approval");
      	 	sAp.clickToGetBatchActionMenu(batchID);
      	 	sAp.selectApproveApplicantsOption(batchID);
      	 	SSC_ViewBatchDetailsPage sVp=new SSC_ViewBatchDetailsPage(driver);
      	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	sVp.clickToGoToEnrolledApplicantsSection();
      	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantID+"']]")).size()==1,"OMG!!! No show of TC Approved Trainer Applicant - "+applicantID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[2]")).getText().trim(), applicantID);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[3]")).getText().trim(), applicantName);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[4]")).getText().trim(), applicantEmail);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[5]")).getText().trim(), applicantMobile);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID+"']]/td[6]")).getText().trim(), "Unpaid");
      	 	sVp.clickToGoToApprovedApplicantsSection();
      	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	//Send Back
      	 	sVp.clickToSendBackBatch();
      	 	sVp.enterRemarksForSendBackBatch("Sending Back This Batch as these applicants are unpaid");
      	 	sVp.clickToSubmitSendBackBatch();
      	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal2-contentwrapper']")));
      	 	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Batch Sent Back\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") Batch sent back successfully");
      	 	sVp.clickOk();
      		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	sAp.clickToViewAllPublishedBatches();
      		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      		sAp.enterBatchIDToSearch(batchID);
      		sAp.clickToGetSearchResult();
      		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(),"Sent Back");
      	 	plp.clickOnProfileLogo();
      	 	plp.clickOnLogout();
      	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
      	 	//TC Checking Sent Back Batch
      	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
        	lp.clickLogin();
	   		elp.performlogin(tcID, tcPassword);
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		tcDp.clickToViewBatches();
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		tcVp.clickToViewAllAcceptedBatches();
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		tcVp.enterToSearchForBatchID(batchID);
 	   		tcVp.clickToGetSearchResult();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
     	   	Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
     	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Sent Back by SSC");
     	   	tcVp.clikToGetBatchActionMenu();
     	   	tcVp.selectReEnrollApplicantsOption();
     	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
     	   	Assert.assertEquals(driver.findElement(By.xpath("//div[p[b[contains(text(),'Batch Status')]]]//span")).getText().trim(), "Rejected");
     	   	Assert.assertEquals(driver.findElement(By.xpath("//div[p[b[contains(text(),'Rejected Reason')]]]//p[3]")).getText().trim(), "Sending Back This Batch as these applicants are unpaid");
     	   	plp.clickOnProfileLogo();
     	 	plp.clickOnLogout();
     	}
    }
}