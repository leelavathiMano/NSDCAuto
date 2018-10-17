package com.nsdc.regressionTest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class SSC_ToT_ToA_ToMT_ToMA_BatchWorkflowTestSC_11 extends TestConfiguration
{
	String existingOrNewExceptionalTC=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 0);
	String existingTCID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 1);
	String existingTCName=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 2);
	String exisitngTCPassword=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 3);
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	
	@DataProvider
	public Object[][] sscBatchCreationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation");
	}
	@Test(dataProvider="sscBatchCreationData")
	public void sscBatchCreationTC_01(String serialNum,String createdBatchIDs, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String platformJobRole, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tpName, String exceptionalTCName, String website, String capacity, String residentialFacilityAvailableFor, String exceptionalTCHeadName, String exceptionalTCHeadMobile, String exceptionalTCHeadEmail, String exceptionalTCSPOCName, String exceptionalTCSPOCMobile, String exceptionalTCSPOCEmail, String exceptionalTCSPOCID, String exceptionalTCAddress, String exceptionalTCLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String exceptionalTCPhoto, String exceptionalTCSupportDoc, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName, String masterTrainerPassword, String mtBatchAcceptanceRemarks, String masterTrainerRemarksDate, String masterTrainerRemarksTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String assessmentAgencyRemarksDate, String assessmentAgencyRemarksTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String masterAssessorRemarks, String masterAssesorRemarksDate, String masterAssessorRemarksTime) throws Exception
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
		Thread.sleep(6000);
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(4000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(4000);
		sscTbcP.selectBatchCategory(batchCategory);
		Thread.sleep(4000);
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
		Thread.sleep(4000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(4000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'RET/Q0101')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickTocloseDomainTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String domainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 13, domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 14, domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 15, domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 16, domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(4000);
		//Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'RET/Q0101')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickToclosePlatformTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 17, platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 18, platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 19, platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNum) , 20, platformAssessmentEndDate);
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
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssccreate-new-batchbatch-assignment"+createdBatchID,"OMG!!! No show of Batch Assignment Page OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		//STEP 2 OF BATCH CREATION -> Add Exceptional Training Centre  and Assigning To Batches
		String selectedTCOption=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 0);
		if(selectedTCOption.equalsIgnoreCase("CreateExceptionalTC"))
		{
			if(Integer.parseInt(serialNum)==1)
			{
				sscTbcP.clickAddExceptionalTC();
				Thread.sleep(4000);
				sscTbcP.enterTrainingPartnerName(tpName);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreName(exceptionalTCName);
				Thread.sleep(4000);
				sscTbcP.enterWebsite(website);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreCapacity(capacity);
				Thread.sleep(4000);
				if(residentialFacilityAvailableFor.equalsIgnoreCase("All"))
				{
					sscTbcP.selectResidentialFacilityAvailableForAll();

				}
				else if(residentialFacilityAvailableFor.equalsIgnoreCase("Male"))
				{
					sscTbcP.selectResidentialFacilityAvailableForOnlyMale();
				}
				else if(residentialFacilityAvailableFor.equalsIgnoreCase("Female"))
				{
					sscTbcP.selectResidentialFacilityAvailableForOnlyFemale();
				}
				else if(residentialFacilityAvailableFor.equalsIgnoreCase("Transgender"))
				{
					sscTbcP.selectResidentialFacilityAvailableForOnlyTransgender();
				}
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreHeadName(exceptionalTCHeadName);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreHeadMobile(exceptionalTCHeadMobile);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreHeadEmail(exceptionalTCHeadEmail);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreSPOCName(exceptionalTCSPOCName);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreSPOCMobile(exceptionalTCSPOCMobile);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreSPOCEmail(exceptionalTCSPOCEmail);
				Thread.sleep(4000);
				sscTbcP.clickToBrowseExceptionalTCSPOCIDProof();
				Thread.sleep(4000);
				UploadFile.upload(exceptionalTCSPOCID);
				Thread.sleep(4000);
				sscTbcP.clickToUploadExceptionalTCSPOCIDProof();
				Thread.sleep(8000);
				sscTbcP.enterExceptionalTCAddress(exceptionalTCAddress);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTCLandmark(exceptionalTCLandmark);
				Thread.sleep(4000);
			//	Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'India')]")).getAttribute("value").trim(), country);
				sscTbcP.selectExceptionalTCState(state);
				Thread.sleep(4000);
				sscTbcP.selectExsceptionalTCDistrict(district);
				Thread.sleep(4000);
				sscTbcP.selectExceptionalTCSubDistrict(subDistrict);
				Thread.sleep(4000);
				sscTbcP.selectExceptionalTCConstituency(constituency);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreGeoLocation(geoLocation);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentreVillage(village);
				Thread.sleep(4000);
				sscTbcP.enterExceptionalTrainingCentrePincode(pincode);
				Thread.sleep(4000);
				sscTbcP.clickToBrowseExceptionalTrainingCentrePhoto();
				Thread.sleep(4000);
				UploadFile.upload(exceptionalTCPhoto);
				Thread.sleep(4000);
				sscTbcP.clickToUploadExceptionalTrainingCentrePhoto();
				Thread.sleep(8000);
				sscTbcP.clickToBrowseExceptionalTrainingCentreSupportDoc();
				Thread.sleep(4000);
				UploadFile.upload(exceptionalTCSupportDoc);
				Thread.sleep(4000);
				sscTbcP.clickToUploadExceptionalTrainingCentreSupportDoc();
				Thread.sleep(8000);
				//Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='c-btn disabled'])[2]")).getAttribute("value").trim(), expectedSector);
				sscTbcP.selectExceptionalTrainingCentreSubSector(subSector);
				Thread.sleep(4000);
				sscTbcP.selectExceptionalTrainingCentreJobRole(domainJobRole);
				Thread.sleep(4000);
				sscTbcP.clickToAddJobRole();
				Thread.sleep(4000);
				Assert.assertEquals(driver.findElement(By.xpath("(//td/p[contains(text(),'"+expectedSector+"')])[1]")).getText().trim(), expectedSector);
				Assert.assertEquals(driver.findElement(By.xpath("(//td/p[contains(text(),'"+subSector+"')])[2]")).getText().trim(), subSector);
				Assert.assertEquals(driver.findElement(By.xpath("//td/p[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
				sscTbcP.clickToConfirmDeclaration();
				Thread.sleep(4000);
				sscTbcP.clickToFinallyCreateExceptionalTrainingCentre();
				Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast-message']")).size()==0,"OMG!!! Toast Message exists, Either Duplicate SPOC credentials OR Something went wrong! ");
				Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().contains("success"));
				String createdExceptionalTCID=driver.findElement(By.xpath("//div[@id='swal2-content']/p/b")).getText().trim();
				ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 6,createdExceptionalTCID);
				sscTbcP.clickOk();
				Thread.sleep(4000);
				sscTbcP.selectExceptionalTrainingCentreTypeFilter();
			}
		}
		Thread.sleep(4000);
		sscTbcP.selectStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDistrictFilter(district);
		Thread.sleep(4000);
		String exceptionalTCID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 6);
		Thread.sleep(4000);
		if(selectedTCOption.equalsIgnoreCase("CreateExceptionalTC"))
		{
			sscTbcP.enterTrainingCentreIDToSearch(exceptionalTCID);
		}
		else
		{
			sscTbcP.enterTrainingCentreIDToSearch(existingTCID);
		}
		Thread.sleep(6000);
		sscTbcP.clickToGetSearchFilterResult();
		Thread.sleep(6000);
		if(selectedTCOption.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+exceptionalTCID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+exceptionalTCID+"')]")).getText().trim(), exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+exceptionalTCName+"')]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+tpName+"')]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
			sscTbcP.clickToChooseResultedTrainingCentreToAssign(exceptionalTCID);
		}
		else
		{
			Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+existingTCID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+existingTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+existingTCID+"')]")).getText().trim(), existingTCID);
			sscTbcP.clickToChooseResultedTrainingCentreToAssign(existingTCID);
		}
		Thread.sleep(4000);
		sscTbcP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		if(selectedTCOption.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Training Centre Assigned\n"+createdBatchID+"\nis successfully assigned to   "+exceptionalTCName+"\nState : "+state+"\nDistrict : "+district);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(),"Training Centre Assigned\n"+createdBatchID+"\nis successfully assigned to   "+existingTCName+"\nState : "+state+"\nDistrict : "+district);
		}
		sscTbcP.clickOk();
		Thread.sleep(4000);
		if(selectedTCOption.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+exceptionalTCID+"')]")).getText().trim(), exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+exceptionalTCName+"')]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+existingTCID+"')]")).getText().trim(), existingTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+existingTCName+"')]")).getText().trim(), existingTCName);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
		//Assigning Master Trainer for domain and platform QP
		sscTbcP.clickDomainMasterTrainerAction();
		Thread.sleep(4000);
		sscTbcP.clickDomainAssignMasterTrainerOption();
		Thread.sleep(4000);
		sscTbcP.selectDomainMasterTrainerStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDomainMasterTrainerDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterDomainMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(4000);
		sscTbcP.clickToGetDomainMasterSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerID);
		sscTbcP.clickToChooseDomainMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedDomainMasterTrainer();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().trim(), "Master Trainer Assigned Successfully\n"+createdBatchID+"\nis successfully assigned to   "+masterTrainerID+"\nState : "+state+"\nDistrict : "+district);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerName+" ( "+masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
		sscTbcP.clickPlatformMasterTrainerAction();
		Thread.sleep(4000);
		sscTbcP.clickPlatformAssignMasterTrainerOption();
		Thread.sleep(4000);
		sscTbcP.selectPlatformMasterTrainerStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectPlatformMasterTrainerDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterPlatformMasterTrainerIDToSearch(masterTrainerID);
		Thread.sleep(4000);
		sscTbcP.clickToGetPlatformMasterSearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+masterTrainerID+"')]")).getText().trim(), masterTrainerID);
		sscTbcP.clickToChoosePlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'"+masterTrainerID+"')])[2]")).getText().trim(), masterTrainerName+" ( "+masterTrainerID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[2]")).getText().trim(), "Assigned");
		//Assigning Assessment Agency
		sscTbcP.clickDomainAssessmentAgencyAction();
		Thread.sleep(4000);
		sscTbcP.clickDomainAssignAssessmentAgencyOption();
		Thread.sleep(4000);
		sscTbcP.selectDomainAssessmentAgencyStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDomainAssessmentAgencyDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterDomainAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(4000);
		sscTbcP.clickToGetDomainAssessmentAgencySearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyID);
		sscTbcP.clickToChooseDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td/div/span[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[3]")).getText().trim(), "Assigned");
		//Assigning Platform QP Assessment Agency
		sscTbcP.clickPlatformAssessmentAgencyAction();
		Thread.sleep(4000);
		sscTbcP.clickPlatformAssignAssessmentAgencyOption();
		Thread.sleep(4000);
		sscTbcP.selectPlatformAssessmentAgencyStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectPlatformAssessmentAgencyDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterPlatformAssessmentAgencyIDToSearch(assessmentAgencyID);
		Thread.sleep(4000);
		sscTbcP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentAgencyID+"')]")).getText().trim(), assessmentAgencyID);
		sscTbcP.clickToChoosePlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		Thread.sleep(4000);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'assessmentAgencyID')])[2]")).getText().trim(), assessmentAgencyName+" ( "+assessmentAgencyID+" )");
		Assert.assertEquals(driver.findElement(By.xpath("(//td/div/span[contains(text(),'Assigned')])[4]")).getText().trim(), "Assigned");
		sscTbcP.clickSaveAsDraft();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']")).getText().trim(), "Saved as Draft");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().trim(), "success");
		sscTbcP.clickOk();
		Thread.sleep(4000);
		//checking presence of created batches of status draft
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(4000);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG! Batch - "+createdBatchID+" not found in All Batches Section of "+sscUsername+" !!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+exceptionalTCID+"')]]")).getText().trim(), exceptionalTCName+" ("+exceptionalTCID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+state+"')]]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[span[contains(text(),'"+district+"')]]")), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[7]")).getText().trim(), batchStartDate+" - "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Draft");
		//Submitting Batch 
		sscTbcP.clickBatchAction(createdBatchID);
		Thread.sleep(4000);
		sscTbcP.clickAssignOption(createdBatchID);
		Thread.sleep(4000);
		sscTbcP.clickToSubmitBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@id='swal2-title']/p/b")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+createdBatchID+")");
		sscTbcP.clickViewAllBatchesAfterBatchSubmission();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-new","OMG!!! navigation to All New Batches After Batch Submission is unsuccessful! OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		//After Batch Submission with status Pending For Publish
		sscTbcP.clickBatchAction(createdBatchID);
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span/div/div/a/span")).getText().trim(), "View Details");
		sscTbcP.clickViewDetailsOption(createdBatchID);
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"sscall-batches-newbatch-datails"+createdBatchID,"OMG!!! navigation to view batch details page is unsuccessful OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch ID')]]/td[3]")).getText().trim(), createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Name')]]/td[3]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		if(selectedTCOption.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Name of Training Centre')]]/td[3]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Training Partner')]]/td[3]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Mobile Number of TC')]]/td[3]")).getText().trim(), exceptionalTCSPOCMobile);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Email ID')]]/td[3]")).getText().trim(), exceptionalTCSPOCEmail);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Centre Address')]]/td[3]")).getText().trim(), exceptionalTCAddress);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Nearby Landmark')]]/td[3]")).getText().trim(), exceptionalTCLandmark);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Pincode')]]/td[3]")).getText().trim(), pincode);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'District')]]/td[3]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'State')]]/td[3]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Parliamentary')]]/td[3]")).getText().trim(), constituency);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Tehsil')]]/td[3]")).getText().trim(), subDistrict);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Name of Training Centre')]]/td[3]")).getText().trim(), existingTCName);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Status of Training Centre')]/span")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[4]")).getText().trim(), masterTrainerName+" ("+masterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+masterTrainerID+"')]]])[2]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[4]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[1]/td[5]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[4]")).getText().trim(), assessmentAgencyName+" ("+assessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[contains(text(),'"+assessmentAgencyID+"')]]])[2]/td[5]")).getText().trim(), "Pending");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 2,formatter.format(date));
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="sscBatchCreationTC_01")
	public void trainingCentreBatchApprovalTC_02(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String platformJobRole, String domainTrainingStartDate, String domainTrainingEndDate, String domainAssessmentStartDate, String domainAssessmentEndDate, String platformTrainingStartDate, String platformTrainingEndDate, String platformAssessmentStartDate, String platformAssessmentEndDate, String expectedBatchFees, String batchSize, String tpName, String exceptionalTCName, String website, String capacity, String residentialFacilityAvailableFor, String exceptionalTCHeadName, String exceptionalTCHeadMobile, String exceptionalTCHeadEmail, String exceptionalTCSPOCName, String exceptionalTCSPOCMobile, String exceptionalTCSPOCEmail, String exceptionalTCSPOCID, String exceptionalTCAddress, String exceptionalTCLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String exceptionalTCPhoto, String exceptionalTCSupportDoc, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName, String masterTrainerPassword, String mtBatchAcceptanceRemarks, String masterTrainerRemarksDate, String masterTrainerRemarksTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String assessmentAgencyRemarksDate, String assessmentAgencyRemarksTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String masterAssessorRemarks, String masterAssesorRemarksDate, String masterAssessorRemarksTime) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		String exceptionalTCID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 6);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			elp.performlogin(exceptionalTCID, "ekaushal");
			Thread.sleep(4000);
			RegistrationPage rp = new RegistrationPage(driver);
			rp.enterOldPassword("ekaushal");
	        rp.enterNewPassword("Qwerty@123");
	        rp.enterConfirmPassword("Qwerty@123");
	        rp.clickResetResubmit();
	        Thread.sleep(2000);
	        rp.clickConfirmationOkMessage();
	        elp.performlogin(exceptionalTCID, "Qwerty@123");
	        Thread.sleep(8000);
		}
		else
		{
			elp.performlogin(existingTCID, exisitngTCPassword);
			Thread.sleep(6000);
		}
		Thread.sleep(4000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[contains(text(),'"+batchStartDate+"')]")).getText(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText(), "Pending for Publish");
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu(batchID);
		Thread.sleep(2000);
		lTcVbP.clickToSelectViewBatchDetailsOption(batchID);
		Thread.sleep(4000);
		//Asserting view Batch Details
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID,"OMG!!! navigation to View Batch Details page is unsucessful OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID:')]]]/div[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Name:')]]]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Size:')]]]/div/div)[1]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]]/div/div)[2]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type:')]]]/div/div)")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
		Thread.sleep(2000);
		lTcVbP.clickgoBack();
		Thread.sleep(4000);
		//Accepting batch
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu(batchID);
		Thread.sleep(4000);
		lTcVbP.clickToSelectAcceptBatchOption(batchID);
		Thread.sleep(4000);
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		Thread.sleep(4000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");	
		lTcVbP.clickOk();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!!! accepted batch - "+batchID+" should not be shown in pending batches section! OR Something is wrong! ");
		js.executeScript("window.scrollBy(0,-200)","");
		Thread.sleep(2000);
		//verifying Accepted Batches
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertNotSame(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Accepted");
		lTcVbP.clikToViewActionMenu(batchID);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]/div/div/div/div/div/div/ul/li/a/span")).size()==1," OMG!!! only view details option should be there!! OR Something changed! ");
		lTcVbP.clickToSelectViewBatchDetailsOption(batchID);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainersview-batch-betails"+batchID,"OMG!!! navigation to View Batch Details page is unsucessful OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID:')]]]/div[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Name:')]]]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Size:')]]]/div/div)[1]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]]/div/div)[2]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type:')]]]/div/div)")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[2]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
		
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
		
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="trainingCentreBatchApprovalTC_02")
	public void masterTrainerBatchApprovalTC_03(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String platformJobRole, String domainTrainingStartDate, String domainTrainingEndDate, String domainAssessmentStartDate, String domainAssessmentEndDate, String platformTrainingStartDate, String platformTrainingEndDate, String platformAssessmentStartDate, String platformAssessmentEndDate, String expectedBatchFees, String batchSize, String tpName, String exceptionalTCName, String website, String capacity, String residentialFacilityAvailableFor, String exceptionalTCHeadName, String exceptionalTCHeadMobile, String exceptionalTCHeadEmail, String exceptionalTCSPOCName, String exceptionalTCSPOCMobile, String exceptionalTCSPOCEmail, String exceptionalTCSPOCID, String exceptionalTCAddress, String exceptionalTCLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String exceptionalTCPhoto, String exceptionalTCSupportDoc, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName, String masterTrainerPassword, String mtBatchAcceptanceRemarks, String masterTrainerRemarksDate, String masterTrainerRemarksTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String assessmentAgencyRemarksDate, String assessmentAgencyRemarksTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String masterAssessorRemarks, String masterAssesorRemarksDate, String masterAssessorRemarksTime) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(masterTrainerID, masterTrainerPassword);
		Thread.sleep(2000);
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
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		String exceptionalTCID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 6);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), exceptionalTCName+" ("+exceptionalTCID+")");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), existingTCName+" ("+existingTCID+")");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate+", "+platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Pending for Publish");
		tVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(2000);
		tVp.clickToSelectViewDetailsOption(batchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerbatch-details-new"+batchID+"NEW","OMG!!! navigation to View Batch Details page is unsuccessful OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector & Sub Sector')]]/td[3]")).getText().trim(), expectedSector+" | "+subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), "RET/Q0101");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[1]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[2]")).getText().trim(), exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[1]")).getText().trim(), existingTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[2]")).getText().trim(), existingTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		tVp.clickGoBackFromBatchDetails();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		tVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(4000);
		tVp.clickToSelectAcceptBatchOption(batchID);
		Thread.sleep(4000);
		tVp.enterRemarksForAcceptingBatch(mtBatchAcceptanceRemarks);
		Thread.sleep(4000);	
		tVp.clickToSubmit();
		Thread.sleep(2000);	
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 52, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 53, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Accepted Successfully");
		tVp.clickOk();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!!! accepted batch - "+batchID+" should not be shown in Pending Batch List! OR Something wrong! ");
		tVp.clickToGoToAcceptedBatchesSection();
		Thread.sleep(4000);
		//verifying accepted batches
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), exceptionalTCName+" ("+exceptionalTCID+")");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), existingTCName+" ("+existingTCID+")");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), state );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate+", "+platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Published");
		tVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]/td[9]/div/div/div/div/div/div/ul/li/a/span")).size()==1," OMG!!! only view details option should be there!! OR Something changed! ");
		tVp.clickToSelectViewDetailsOption(batchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerbatch-details-new"+batchID+"ACCEPTED","OMG!!! navigation to View Batch Details page is unsuccessful OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector & Sub Sector')]]/td[3]")).getText().trim(), expectedSector+" | "+subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Job Role Code')]]/td[3]")).getText().trim(), "RET/Q0101");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[1]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[2]")).getText().trim(), exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[1]")).getText().trim(), existingTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[2]")).getText().trim(), existingTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="masterTrainerBatchApprovalTC_03")
	public void assessmentAgencyBatchApprovalAndAssigningAssessorsTC_04(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String platformJobRole, String domainTrainingStartDate, String domainTrainingEndDate, String domainAssessmentStartDate, String domainAssessmentEndDate, String platformTrainingStartDate, String platformTrainingEndDate, String platformAssessmentStartDate, String platformAssessmentEndDate, String expectedBatchFees, String batchSize, String tpName, String exceptionalTCName, String website, String capacity, String residentialFacilityAvailableFor, String exceptionalTCHeadName, String exceptionalTCHeadMobile, String exceptionalTCHeadEmail, String exceptionalTCSPOCName, String exceptionalTCSPOCMobile, String exceptionalTCSPOCEmail, String exceptionalTCSPOCID, String exceptionalTCAddress, String exceptionalTCLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String exceptionalTCPhoto, String exceptionalTCSupportDoc, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName, String masterTrainerPassword, String mtBatchAcceptanceRemarks, String masterTrainerRemarksDate, String masterTrainerRemarksTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String assessmentAgencyRemarksDate, String assessmentAgencyRemarksTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String masterAssessorRemarks, String masterAssesorRemarksDate, String masterAssessorRemarksTime) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(assessmentAgencyID, assessmentAgencyPassword);
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
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of batch - "+batchID+" in "+assessmentAgencyID+" Pending Requests section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		String exceptionalTCID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 6);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+exceptionalTCName+"')]")).getText().trim(), exceptionalTCName+" , "+state+"/"+district);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+existingTCName+"')]")).getText().trim(), existingTCName+" , "+state+"/"+district);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+domainAssessmentStartDate+"')])[1]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+platformAssessmentStartDate+"')])[2]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//td[span[contains(text(),'Pending for Acceptance')]]")).getText().trim(), "Pending for Acceptance");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+batchCreatedDate+"')]")).getText().trim(), batchCreatedDate);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectViewBatchDetailsOption();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batch-detailsNEW"+batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(),batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[1]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[2]")).getText().trim(), exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[1]")).getText().trim(), existingTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[2]")).getText().trim(), existingTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}	
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( RET/Q0101 )");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), domainAssessmentStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), platformAssessmentStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), platformAssessmentEndDate);
		aVp.clickToGoBack();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batches");
		aVp.enterBatchIdToSearch(batchID);
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No no show of batch - "+batchID+" in Pending Requests Section");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectAcceptBatchOption();
		Thread.sleep(2000);
		aVp.enterRemarksForAcceptingBatch(aaBatchAcceptanceRemarks);
		Thread.sleep(2000);		
		aVp.clickToSubmitBatchAcceptance();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(),"You have successfully accepted "+batchID);
		aVp.clickOk();
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(batchID);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!!! accepted batch should not be shown in pending section OR something is wrong! ");
		//verifying accepted batches & assigning assessors
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		aVp.clickToViewAcceptedBatches();
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(batchID);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section!!! ");
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+exceptionalTCName+"')]")).getText().trim(), exceptionalTCName+" , "+state+"/"+district);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+existingTCName+"')]")).getText().trim(), existingTCName+" , "+state+"/"+district);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+domainAssessmentStartDate+"')])[1]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+platformAssessmentStartDate+"')])[2]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//td[span[contains(text(),'Pending for Acceptance')]]")).getText().trim(), "Pending for Acceptance");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+batchCreatedDate+"')]")).getText().trim(), batchCreatedDate);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToSelectAssignAssessorsOption();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch ID')]]]]/div[2]/span")).getText().trim(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Batch Name')]]]]/div[4]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[1]/span")).getText().trim(), exceptionalTCName);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[1]/span")).getText().trim(), existingTCName);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[strong[contains(text(),'Training Centre Name')]]]]/div[2]/div/div[2]/span")).getText().trim(), "State : "+state+", District : "+district);
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+domainAssessmentStartDate+"')])[1]")).getText().trim(), domainAssessmentStartDate+" To "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+platformAssessmentStartDate+"')])[1]")).getText().trim(), platformAssessmentStartDate+" To "+platformAssessmentEndDate);
		aVp.selectMasterAssessorForDomain(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.selectMasterAssessorForPlatform(masterAssessorName+"("+masterAssessorID+")");
		Thread.sleep(4000);
		aVp.clickToSubmitMasterAssessors();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "You have successfully assigned Assessor for the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") - "+batchID);
		aVp.clickOk();
		Thread.sleep(4000);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 58, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 59, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), "Assigned Assessor");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), formatter.format(date));
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		//After Assigning Master Assessor
		aVp.clickToSelectViewBatchDetailsOption();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batch-detailsACCEPTED"+batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(),batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[1]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[2]")).getText().trim(), exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[1]")).getText().trim(), existingTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[2]")).getText().trim(), existingTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}	
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"( RET/Q0101 )");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), masterAssessorName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), domainAssessmentStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Pending");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), masterAssessorName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), platformAssessmentStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), platformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Pending");
		Thread.sleep(2000);
		
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="assessmentAgencyBatchApprovalAndAssigningAssessorsTC_04")
	public void masterAssessorBatchApprovalTC_05(String serialNum,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String platformJobRole, String domainTrainingStartDate, String domainTrainingEndDate, String domainAssessmentStartDate, String domainAssessmentEndDate, String platformTrainingStartDate, String platformTrainingEndDate, String platformAssessmentStartDate, String platformAssessmentEndDate, String expectedBatchFees, String batchSize, String tpName, String exceptionalTCName, String website, String capacity, String residentialFacilityAvailableFor, String exceptionalTCHeadName, String exceptionalTCHeadMobile, String exceptionalTCHeadEmail, String exceptionalTCSPOCName, String exceptionalTCSPOCMobile, String exceptionalTCSPOCEmail, String exceptionalTCSPOCID, String exceptionalTCAddress, String exceptionalTCLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String exceptionalTCPhoto, String exceptionalTCSupportDoc, String tcBatchAcceptanceRemarks, String masterTrainerID, String masterTrainerName, String masterTrainerPassword, String mtBatchAcceptanceRemarks, String masterTrainerRemarksDate, String masterTrainerRemarksTime, String assessmentAgencyID, String assessmentAgencyName, String assessmentAgencyPassword, String aaBatchAcceptanceRemarks, String assessmentAgencyRemarksDate, String assessmentAgencyRemarksTime, String masterAssessorID, String masterAssessorName, String masterAssessorPassword, String masterAssessorRemarks, String masterAssesorRemarksDate, String masterAssessorRemarksTime) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
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
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		String exceptionalTCID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "Configurable-Fields", 1, 6);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), exceptionalTCName+"/"+state+" /"+district);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), existingTCName+"/"+state+" /"+district);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), domainAssessmentStartDate+domainAssessmentEndDate+" "+platformAssessmentStartDate+platformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), assessmentAgencyRemarksDate);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")));		                         
		maVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(4000);
		//View Batch Details Data Verification
		maVp.clickToSelectViewBatchDetailsOption(batchID);
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""),configuredURL.replaceAll("/", "")+"assessormaster-assessorview-batch-details-newNEW"+batchID," OMG!!! View Batch Details page is not loaded or URL might have been changed!!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[1]")).getText().trim(), exceptionalTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[2]")).getText().trim(), exceptionalTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[4]")).getText().trim(), tpName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+exceptionalTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[1]")).getText().trim(), existingTCName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[2]")).getText().trim(), existingTCID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[5]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[6]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+existingTCID+"')]]/td[7]")).getText().trim(), "Accepted");
		}
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[2]")).getText().trim(), domainJobRole+"(RET/Q0101)");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[3]")).getText().trim(), assessmentAgencyID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[4]")).getText().trim(), masterAssessorID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[3]")).getText().trim(), assessmentAgencyID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[4]")).getText().trim(), masterAssessorID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+platformJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
		maVp.clickToGoBack();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessormaster-assessorview-batches-newNEW","OMG!!! Go Back button does not navigated to pending requests batches section OR url might have been changed!!! ");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")));		                         
		Thread.sleep(2000);
		maVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(4000);
		maVp.clickToSelectAcceptBatchOption(batchID);
		Thread.sleep(4000);
		maVp.enterRemarksForAcceptingBatch(masterAssessorRemarks);
		Thread.sleep(4000);
		maVp.clickToSaveAndSubmitBatchAccceptance();
		Thread.sleep(4000);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 64, formatter.format(date));
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation", Integer.parseInt(serialNum), 65, LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute());
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim(),"Request Accepted Successfully");
		maVp.clickOk();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(4000);
		//verifying Accepted Batch
		maVp.clickToGoToAcceptedBatchesSection();
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")));
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[2]")).getText().trim(), batchType);
		if(existingOrNewExceptionalTC.equalsIgnoreCase("CreateExceptionalTC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), exceptionalTCName+"/"+state+" /"+district);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), existingTCName+"/"+state+" /"+district);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[5]")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), domainAssessmentStartDate+domainAssessmentEndDate+" "+platformAssessmentStartDate+platformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), assessmentAgencyRemarksDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), formatter.format(date));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	//Batch Rejection Flow Test Cases
	@DataProvider
	public Object[][] trainingCentreBatchRejectionData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection");
	}
	@Test(dataProvider="trainingCentreBatchRejectionData",dependsOnMethods="sscBatchCreationTC_01")
	public void trainingCentreBatchRejectionTC_06(String serialNo, String rejectedBatchIDs, String trainingCentreID,  String trainingCentrePassword, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String platformJobRole, String domainTrainingStartDate, String domainTrainingEndDate, String domainAssessmentStartDate, String domainAssessmentEndDate, String platformTrainingStartDate, String platformTrainingEndDate, String platformAssessmentStartDate, String platformAssessmentEndDate, String expectedBatchFees, String batchSize, String state, String district, String reasonForRejectingBatch, String rejectionRemarks) throws Exception
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
		Thread.sleep(6000);
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(4000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(4000);
		sscTbcP.selectBatchCategory(batchCategory);
		Thread.sleep(4000);
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection",Integer.parseInt(serialNo) , 10, trainingStartDate);
		String trainingEndDate=driver.findElement(By.id("endDates")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection",Integer.parseInt(serialNo) , 11, trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole);
		Thread.sleep(4000);
		sscTbcP.selectPlatformJobRole(platformJobRole);
		Thread.sleep(4000);
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'RET/Q0101')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+domainJobRole+"')]")).getText().trim(), domainJobRole);
		sscTbcP.selectDomainTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickTocloseDomainTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToCloseDomainAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String domainTrainingStartDatee=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDatee=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDatee=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDatee=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection", Integer.parseInt(serialNo) , 14, domainTrainingStartDatee);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection", Integer.parseInt(serialNo) , 15, domainTrainingEndDatee);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection", Integer.parseInt(serialNo) , 16, domainAssessmentStartDatee);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection", Integer.parseInt(serialNo) , 17, domainAssessmentEndDatee);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		Thread.sleep(4000);
		//Assert.assertTrue(driver.findElement(By.xpath("//td/b[contains(text(),'RET/Q0101')]")).isDisplayed(),"OMG!!! DomainJobRoleCode not displayed OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td/span/b[contains(text(),'"+platformJobRole+"')]")).getText().trim(), platformJobRole);
		sscTbcP.selectPlatformTrainingStartDate();
		Thread.sleep(4000);
		sscTbcP.clickToclosePlatformTrainingStartDateCalender();
		Thread.sleep(4000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Assessors - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Assessors"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformTrainingEndDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentstartDateCalender();
			Thread.sleep(4000);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch();
			Thread.sleep(4000);
			sscTbcP.clickToClosePlatformAssessmentEndDateCalender();
			Thread.sleep(4000);
		}
		String platformTrainingStartDatee=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDatee=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDatee=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDatee=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection",Integer.parseInt(serialNo) , 18, platformTrainingStartDatee);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection",Integer.parseInt(serialNo) , 19, platformTrainingEndDatee);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection",Integer.parseInt(serialNo) , 20, platformAssessmentStartDatee);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "TC-BatchRejection",Integer.parseInt(serialNo) , 21, platformAssessmentEndDatee);
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "BatchCreation",Integer.parseInt(serialNo) , 1, createdBatchID);
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssccreate-new-batchbatch-assignment"+createdBatchID,"OMG!!! No show of Batch Assignment Page OR Something is wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]")).getText().trim(), batchType+"/"+trainingStartDate+" to "+trainingEndDate+"("+createdBatchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[span[contains(text(),'Sector')]]]/div[3])[1]")).getText().trim(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Sub Sector')]]]/div[3]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Type')]]]/div[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]")).getText().trim(), trainingStartDate+" to "+trainingEndDate);
		//Assigning Training Centre
		Thread.sleep(4000);
		sscTbcP.selectStateFilter(state);
		Thread.sleep(4000);
		sscTbcP.selectDistrictFilter(district);
		Thread.sleep(4000);
		sscTbcP.enterTrainingCentreIDToSearch(trainingCentreID);
		Thread.sleep(6000);
		sscTbcP.clickToGetSearchFilterResult();
		Thread.sleep(6000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).size()==1,"OMG!!! No show of Searched training Centre - "+trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).getText().trim(), trainingCentreID);
		sscTbcP.clickToChooseResultedTrainingCentreToAssign(trainingCentreID);
		Thread.sleep(4000);
		sscTbcP.clickToSubmitSelectedTrainingCentre();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText().contains("Training Centre Assigned"));
		sscTbcP.clickOk();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).getText().trim(), trainingCentreID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//td/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(4000);
		//Assigned Location Based Training Centre Login To Reject Trainer Training Batch
		for(int i=0;i<4;i++)
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			lp.clickLogin();
			elp.performlogin(trainingCentreID, trainingCentrePassword);
			Thread.sleep(8000);
			LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
			lTcDp.clickToViewBatches();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,200)","");
			LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[text()='"+batchSize+"']")).getText(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[contains(text(),'"+batchStartDate+"')]")).getText(), trainingStartDate+" to "+trainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[7]")).getText(), "Pending for Publish");
			Thread.sleep(4000);
			lTcVbP.clikToViewActionMenu(createdBatchID);
			Thread.sleep(2000);
			lTcVbP.clickToSelectRejectBatchOption(createdBatchID);
			Thread.sleep(4000);
			lTcVbP.selectReasonForRejectingBatch(reasonForRejectingBatch);
			Thread.sleep(4000);
			lTcVbP.enterRemarksForRejectingBatch(rejectionRemarks);
			Thread.sleep(4000);
			lTcVbP.clickToRejectBatch();
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Request Rejected");	
			lTcVbP.clickOk();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!!! rejected batch - "+createdBatchID+" should not be shown in pending batches section! OR Something is wrong! ");
			js.executeScript("window.scrollBy(0,-200)","");
			Thread.sleep(2000);
			//verifying Rejected Batches
			lTcVbP.clickToViewAllRejectedBatches();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)","");
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==1,"OMG!!! rejected batch - "+createdBatchID+" is not shown in Rejected batches section! OR Something is wrong! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[text()='"+batchSize+"']")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertNotSame(driver.findElement(By.xpath("//tr[td[text()='"+createdBatchID+"']]/td[7]")).getText().trim(), "Rejected");
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			
			//SSC Reassigning Training Centre After Rejection
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			lp.clickLogin();
			elp.performlogin(sscUsername, sscPassword);
			Thread.sleep(10000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
			sscDbP.clickToTToAToMTToMA();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			sscDbP.clickAllBatches();
			Thread.sleep(4000);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[contains(text(),'Rejected')]")).getText().trim(), "Rejected");
			sscTbcP.clickBatchAction(createdBatchID);
			sscTbcP.clickViewDetailsOption(createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[p[contains(text(),'Status of Training Centre')]]/p[1]/span[1]")).getText().trim(), "Rejected");
			Assert.assertEquals(driver.findElement(By.xpath("//div[p[contains(text(),'Status of Training Centre')]]/p[3]")).getText().trim(), "Occupied for Training");
			sscTbcP.clickReassignTC();
			sscTbcP.selectStateFilter(state);
			sscTbcP.selectDistrictFilter(district);
			sscTbcP.enterTrainingCentreIDToSearch(trainingCentreID);
			sscTbcP.clickToGetSearchFilterResult();
			Assert.assertEquals(driver.findElements(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).size()==1, "OMG!!! No show of searched training centre - "+trainingCentreID);
			sscTbcP.clickToChooseResultedTrainingCentreToAssign(trainingCentreID);
			sscTbcP.clickToSubmitReAssignedTC();
			if(i==2)
			{
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim().equalsIgnoreCase("Cannot Assign Training Centre"));
				sscTbcP.clickToCancel();
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(),"Training Centre Assigned");	
				sscTbcP.clickOk();
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreID+"')]")).getText().trim(), trainingCentreID);
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+state+"')]")).getText().trim(), state);
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+district+"')]")).getText().trim(), district);
				Assert.assertEquals(driver.findElement(By.xpath("//td/span[contains(text(),'Assigned')]")).getText().trim(), "Assigned");
			}
			Thread.sleep(2000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
		
		}
	}
	/*
	@DataProvider
	public Object[][]masterTrainerBatchRejectionData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "MasterTrainerBatchRejection");
	}
	@Test(dataProvider="masterTrainerBatchRejectionData",dependsOnMethods="locationBasedTrainingCentreCreationForBatchWorkflowTC_01")
	public void masterTrainerBatchRejectionTC_07(String serialNo, String rejectedBatchIDs, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict, String trainingCentre, String trainingCentrePassword, String masterTrainerName, String masterTrainerID, String masterTrainerPassword) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(2000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!!Login Unsuccessfull OR its taking too much time!!! OR No Internet!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickCreateBatch();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(2000);
		sscTbcP.selectJobRole(jobRole);
		Thread.sleep(3000);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			sscTbcP.selectTrainingStartDateForNewBatch();
			sscTbcP.clickToCloseTrainingStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectTrainingEndDateForNewBatch();
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmentStartDateForNewBatch();
			sscTbcP.clickToCloseAssessmentStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmenEndDateForNewBatch();
			sscTbcP.clickToCloseAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			sscTbcP.selectTrainingStartDateForExistingBatch();
			sscTbcP.clickToCloseTrainingStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectTrainingEndDateForExistingBatch();
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmentStartDateForExistingBatch();
			sscTbcP.clickToCloseAssessmentStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmenEndDateForExistingBatch();
			sscTbcP.clickToCloseAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[1]")).getAttribute("value");
		String assessmentEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[2]")).getAttribute("value");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[1]/span")).getText(), trainingStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[2]/span")).getText(), assessmentEndDate);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(2000);
		String bacthCreationsuccessfulPopupText=driver.findElement(By.xpath("//div[@class='swal2-content']")).getText();
		String[]parts=bacthCreationsuccessfulPopupText.split(" ");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "MasterTrainerBatchRejection",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		sscTbcP.selectState(state);
		Thread.sleep(2000);
		sscTbcP.selectDistrict(district);
		Thread.sleep(2000);
		sscTbcP.selectSubDistrict(subDistrict);
		Thread.sleep(2000);
		sscTbcP.clickToSearchAndAssignTrainingCentre();
		Thread.sleep(2000);
		sscTbcP.enterToSearchForTrainingCentreID(trainingCentre);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+trainingCentre+"']")).size()==0, "OMG! The Training Centre - "+trainingCentre+" You Are Searching For This "+sscUsername+" Not Found In This Server!!! ");
		sscTbcP.clickActionMenu();
		Thread.sleep(2000);
		sscTbcP.clickAssignBatch();
		Thread.sleep(2000);
		sscTbcP.clickToAssignTrainingCentre();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Assigned Location Based Training Centre Login To Accept Trainer-Assessor Training Batch
		lp.clickLogin();
		elp.performlogin(trainingCentre, trainingCentrePassword);
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG! Batch - "+createdBatchID+" not found in Newly Assigned Section of "+trainingCentre+" !!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingStartDate.replaceAll("/", "-")+"')]")).getText(), trainingStartDate.replaceAll("/", "-")+" to "+assessmentEndDate.replaceAll("/", "-"));
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clickToSelectAcceptOrRejectBatchOption();
		Thread.sleep(2000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(2000);
		lTcVbP.clickToSaveAndSubmit();
		Thread.sleep(2000);
		lTcVbP.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		lp.clickLogin();
		Thread.sleep(2000);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sDp.clickAllBatches();
		Thread.sleep(2000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in Published Section of "+sscUsername+" !!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(4000);
		sBp.selectMasterTrainerForSEDJobrole(masterTrainerName);
		Thread.sleep(2000);
		sBp.clickToAssignMasterTrainer();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+masterTrainerID+".");
		sBp.clickOk();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Master Trainer Login To Reject Assigned Batch & SSC Login To Reassign Master Trainer
		for(int i=1;i<=3;i++)
		{
			lp.clickLogin();
			elp.performlogin(masterTrainerID, masterTrainerPassword);
			Thread.sleep(3000);
			TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
			tDp.clickToGetTrainerDashboard();
			Thread.sleep(2000);
			tDp.clickViewBatches();
			Thread.sleep(2000);
			TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
			tVp.clicktoGoToNewlyAssignedBatchesSection();
			Thread.sleep(4000);
			tVp.enterBatchStartDateToSearch(trainingStartDate);
			Thread.sleep(2000);
			tVp.clickToCloseBatchStartDateCalender();
			Thread.sleep(6000);
			tVp.enterBatchEndDateToSearch(assessmentEndDate);
			Thread.sleep(2000);
			tVp.clickToCloseBatchEndDateCalender();
			Thread.sleep(6000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! "+masterTrainerID+" No show of matching Batch - "+createdBatchID+" for Batch Dates: "+trainingStartDate+" to "+assessmentEndDate+" in Newly-Assigned Section");
			tVp.clickToViewFilterByBatchTypeListOptions();
			Thread.sleep(2000);
			ArrayList<WebElement>batchTypesFilter=(ArrayList<WebElement>)driver.findElements(By.xpath("(//ul[@class='lazyContainer'])[1]/span/li/label[2]"));
			for(int j=0;j<batchTypesFilter.size();j++)
			{
				while(batchTypesFilter.get(j).getText().equalsIgnoreCase(batchType))
				{
					batchTypesFilter.get(j).click();
					Thread.sleep(2000);
					tVp.clickToCloseFilterByBatchTypeList();
					Thread.sleep(2000);
					Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! Master Trainer - "+masterTrainerID+" No show of matching Batch - "+createdBatchID+" for Batch Type - "+batchType+" in Newly-Assigned Section");
				}
			}
			ArrayList<WebElement>resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[contains(text(),'"+createdBatchID+"')]"));
			Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! Master Trainer - "+masterTrainerID+" The Batch - "+createdBatchID+" is not found in NewLy-Assigned Section!!! ");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(), createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[3]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim().replaceAll("-", "/"), trainingStartDate+" to "+assessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span")).getText().trim(), "New");
			tVp.clickToGetActionMenuOptions(createdBatchID);
			Thread.sleep(2000);
			tVp.clickToChooseAcceptOrRejectBatchOption();
			Thread.sleep(2000);
			tVp.clickToRejectBatch();
			Thread.sleep(2000);
			tVp.enterRemarks("Batch Cannot Be Accepted As Its Not Contain Valid Details");
			tVp.clickToSaveAndSubmit();
			Thread.sleep(2000);
			tVp.clickOk();
			Thread.sleep(2000);
			//verifying rejected batch in Master Trainer Rejected Section
			js.executeScript("window.scrollBy(0,-500)", "");
			Thread.sleep(8000);
			tVp.clickToGoToRejectedBatchesSection();
			Thread.sleep(2000);
			resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[text()='"+createdBatchID+"']"));
			Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! Master Trainer - "+masterTrainerID+" The Batch - "+createdBatchID+" is not found in Rejected Section!!! ");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[8]")).getText().trim().replaceAll("-", "/"), trainingStartDate+" to "+assessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span")).getText().trim(), "New");
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			
			lp.clickLogin();
			Thread.sleep(2000);
			elp.performlogin(sscUsername, sscPassword);
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			sDp.clickAllBatches();
			Thread.sleep(2000);
			Thread.sleep(2000);
			sBp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			sBp.enterSearchForBatchID(createdBatchID);
			Thread.sleep(2000);
			sBp.clickToSearch();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in "+sscUsername+" Rejected Section!!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Master Trainer')])[1]")).getText().trim(), "Master Trainer");
			sBp.clickToViewActionMenuOptions();
			Thread.sleep(2000);
			sBp.clickToChooseReAssignMasterTrainerOption();
			Thread.sleep(2000);
			sBp.selectReAssignMasterTrainer(masterTrainerName);
			Thread.sleep(2000);
			sBp.clickToReassignSelectedMasterTrainer();
			Thread.sleep(2000);
			sBp.clickAssignItButton();
			Thread.sleep(2000);
			if(i==3)
			{
				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Cannot Assign Master Trainer"), "OMG!!! There is no toast message regarding Cannot Reassign Master Trainer for this Batch - "+createdBatchID+" as 3 times this batch got rejected by master trainer - "+masterTrainerID+" !!!!  ");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+masterTrainerID+".");
				sBp.clickOk();
				Thread.sleep(2000);
				//after Reassign, batch should not be listed in rejected section
				sBp.clickToViewRejectedBatches();
				Thread.sleep(2000);
				sBp.enterSearchForBatchID(createdBatchID);
				Thread.sleep(2000);
				sBp.clickToSearch();
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Should Not be Listed in "+sscUsername+" Rejected Section after Reassigning Master Trainer - "+masterTrainerID+" !!! ");
			}
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
	
	
	@DataProvider
	public Object[][] assessmentAgencyBatchRejectionData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssessmentAgencyBatchRejection");
	}
	@Test(dataProvider="assessmentAgencyBatchRejectionData",dependsOnMethods="locationBasedTrainingCentreCreationForBatchWorkflowTC_01")
	public void assessmentAgencyBatchRejectionTC_09(String serialNo, String rejectedBatchIDs, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict, String trainingCentre, String trainingCentrePassword, String assessmentAgency, String assessmentAgencyPassword) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(2000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickCreateBatch();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(2000);
		sscTbcP.selectJobRole(jobRole);
		Thread.sleep(3000);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		Thread.sleep(2000);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			sscTbcP.selectTrainingStartDateForNewBatch();
			sscTbcP.clickToCloseTrainingStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectTrainingEndDateForNewBatch();
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmentStartDateForNewBatch();
			sscTbcP.clickToCloseAssessmentStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmenEndDateForNewBatch();
			sscTbcP.clickToCloseAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			sscTbcP.selectTrainingStartDateForExistingBatch();
			sscTbcP.clickToCloseTrainingStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectTrainingEndDateForExistingBatch();
			sscTbcP.clickToCloseTrainingEndDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmentStartDateForExistingBatch();
			sscTbcP.clickToCloseAssessmentStartDateCalender();
			Thread.sleep(2000);
			sscTbcP.selectAssessmenEndDateForExistingBatch();
			sscTbcP.clickToCloseAssessmentEndDateCalender();
			Thread.sleep(2000);
		}
		String trainingStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[1]")).getAttribute("value");
		String assessmentEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[2]")).getAttribute("value");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[1]/span")).getText(), trainingStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[2]/span")).getText(), assessmentEndDate);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(2000);
		String bacthCreationsuccessfulPopupText=driver.findElement(By.xpath("//div[@class='swal2-content']")).getText();
		String[]parts=bacthCreationsuccessfulPopupText.split(" ");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssessmentAgencyBatchRejection",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		sscTbcP.selectState(state);
		Thread.sleep(2000);
		sscTbcP.selectDistrict(district);
		Thread.sleep(2000);
		sscTbcP.selectSubDistrict(subDistrict);
		Thread.sleep(2000);
		sscTbcP.clickToSearchAndAssignTrainingCentre();
		Thread.sleep(2000);
		sscTbcP.enterToSearchForTrainingCentreID(trainingCentre);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+trainingCentre+"']")).size()==0, "OMG! The Training Centre - "+trainingCentre+" You Are Searching For This "+sscUsername+" Not Found In This Server!!! ");
		sscTbcP.clickActionMenu();
		Thread.sleep(2000);
		sscTbcP.clickAssignBatch();
		Thread.sleep(2000);
		sscTbcP.clickToAssignTrainingCentre();
		Thread.sleep(2000);
		sscTbcP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Assigned Location Based Training Centre Login To Accept Trainer-Assessor Training Batch
		lp.clickLogin();
		elp.performlogin(trainingCentre, trainingCentrePassword);
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG! Batch - "+createdBatchID+" not found in Newly Assigned Section of "+trainingCentre+" !!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingStartDate.replaceAll("/", "-")+"')]")).getText(), trainingStartDate.replaceAll("/", "-")+" to "+assessmentEndDate.replaceAll("/", "-"));
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clickToSelectAcceptOrRejectBatchOption();
		Thread.sleep(2000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(2000);
		lTcVbP.clickToSaveAndSubmit();
		Thread.sleep(2000);
		lTcVbP.clickOk();
		Thread.sleep(4000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		lp.clickLogin();
		Thread.sleep(2000);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sDp.clickAllBatches();
		Thread.sleep(2000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in Published Section of "+sscUsername+" !!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(4000);
		sBp.selectAssessmentAgencyForSEDJobRole(assessmentAgency);
		Thread.sleep(2000);
		sBp.clickSEDAssignButton2();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+assessmentAgency+".");
		sBp.clickOk();
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
		//Assessment Agency Login To Reject Assigned Batch & SSC Login To Reassign Assessment Agency
		for(int i=1;i<=3;i++)
		{
			lp.clickLogin();
			elp.performlogin(assessmentAgency, assessmentAgencyPassword);
			Thread.sleep(3000);
			AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
			aDp.clickToViewBatches();
			Thread.sleep(2000);
			AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
			aVp.clickToViewNewlyAssignedBatches();
			Thread.sleep(2000);
			aVp.enterBatchIdToSearch(createdBatchID);
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! Assessment Agency - "+assessmentAgency+" The Batch - "+createdBatchID+" is not found in NewLy-Assigned Section!!! ");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(), createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingStartDate.replaceAll("/", "-")+"')]")).getText(), trainingStartDate.replaceAll("/", "-")+" to "+assessmentEndDate.replaceAll("/", "-"));
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToChooseAcceptOrRejectBatchOption();
			Thread.sleep(2000);
			aVp.clickToRejectBatch();
			Thread.sleep(2000);
			aVp.enterRemarks("Batch Cannot Be Accepted As Its Not Contain Valid Details");
			aVp.clickToSaveAndSubmit();
			Thread.sleep(2000);
			aVp.clickOk();
			Thread.sleep(2000);
			//verifying rejected batch in Assessment Agency Rejected Section
			js.executeScript("window.scrollBy(0,-500)", "");
			Thread.sleep(8000);
			aVp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			aVp.enterBatchIdToSearch(createdBatchID);
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!!! Assessment Agency - "+assessmentAgency+" The Batch - "+createdBatchID+" is not found in Rejected Section!!! ");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(), createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingStartDate.replaceAll("/", "-")+"')]")).getText(), trainingStartDate.replaceAll("/", "-")+" to "+assessmentEndDate.replaceAll("/", "-"));
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			
			lp.clickLogin();
			Thread.sleep(2000);
			elp.performlogin(sscUsername, sscPassword);
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			sDp.clickAllBatches();
			Thread.sleep(2000);
			Thread.sleep(2000);
			sBp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			sBp.enterSearchForBatchID(createdBatchID);
			Thread.sleep(2000);
			sBp.clickToSearch();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in "+sscUsername+" Rejected Section!!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Assessment Agency')])[1]")).getText().trim(), "Assessment Agency");
			sBp.clickToViewActionMenuOptions();
			Thread.sleep(2000);
			sBp.clickToChooseReAssignAssessmentAgencyOption();
			Thread.sleep(2000);
			sBp.selectReAssignAssignAssessmentAgency(assessmentAgency);
			Thread.sleep(2000);
			sBp.clickToReassignSelectedAssignAssessmentAgency();
			Thread.sleep(2000);
			sBp.clickAssignItButton();
			Thread.sleep(2000);
			if(i==3)
			{
				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Cannot Assign Assessment Agency"), "OMG!!! There is no toast message regarding Cannot Reassign Assessment Agency for this Batch - "+createdBatchID+" as 3 times this batch got rejected by master trainer - "+assessmentAgency+" !!!!  ");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+assessmentAgency+".");
				sBp.clickOk();
				Thread.sleep(2000);
				//after Reassign, batch should not be listed in rejected section
				sBp.clickToViewRejectedBatches();
				Thread.sleep(2000);
				sBp.enterSearchForBatchID(createdBatchID);
				Thread.sleep(2000);
				sBp.clickToSearch();
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Should Not be Listed in "+sscUsername+" Rejected Section after Reassigning Assessment Agency - "+assessmentAgency+" !!! ");
			}
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
	
	
	*/


	