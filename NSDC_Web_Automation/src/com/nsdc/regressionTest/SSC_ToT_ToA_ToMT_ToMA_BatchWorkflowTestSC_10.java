package com.nsdc.regressionTest;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.SelectDropDownList;
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
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_LocationBasedTC_TrainingBatchCreationPage;
import com.nsdc.pages.SSC_LocationBasedTraningCentreCreationPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class SSC_ToT_ToA_ToMT_ToMA_BatchWorkflowTestSC_10 extends TestConfiguration
{
	String locationBasedTrainingCentreName=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 3);
	String locationBasedTrainingCentreSPOCName=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 15);
	String locationBasedTrainingCentreSPOCMobile=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","ConfigurableFields", 1, 1);
	String locationBasedTrainingCentreSPOCEmail=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","ConfigurableFields", 1, 0);
	String locationBasedTrainingCentreAddress=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 4);
	String locationBasedTrainingCentreNearByLandmark=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 5);
	String locationBasedTrainingCentrePincode=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 6);
	String locationBasedTrainingCentreState=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 8);
	String locationBasedTrainingCentreDistrict=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 9);
	String locationBasedTrainingCentreTehsil=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC", 1, 10);
	String locationBasedTrainingCentreHeadName=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "CreateLocationBasedTC", 1, 12); 
	String locationBasedTrainingCentreHeadPhone=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "CreateLocationBasedTC", 1, 14); 
	String locationBasedTrainingCentreHeadEmail=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "CreateLocationBasedTC", 1, 13); 
	String locationBasedTrainingCentreCapacity=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "CreateLocationBasedTC", 1, 11); 
	@DataProvider
	public Object[][] locationBasedTrainingCentreCreationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC");
	}
	@Test(dataProvider="locationBasedTrainingCentreCreationData")
	public void locationBasedTrainingCentreCreationForBatchWorkflowTC_01(String sscUsername, String sscPassword, String tempTcId, String trainingCentreName, String addressLine, String landmark, String pincode, String villageTownCity, String state, String district, String subDistrict, String trainingCentreCapacity, String contactPersonName, String contactPersonEmail, String contactPersonMobileNumber, String singlePointOfContactPersonName, String singlePointOfContactPersonEmail, String singlePointOfContactPersonMobileNumber,String expectedSector,String subSector,String jobRole) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(6000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickCreateTemporaryTrainingCentre();
		Thread.sleep(4000);
		SSC_LocationBasedTraningCentreCreationPage sscTtCP=new SSC_LocationBasedTraningCentreCreationPage(driver);
		sscTtCP.enterTrainingCentreNameTextBox(trainingCentreName);
		Thread.sleep(2000);
		sscTtCP.enterAdressLine(addressLine);
		Thread.sleep(2000);
		sscTtCP.enterLandmark(landmark);
		Thread.sleep(2000);
		sscTtCP.enterPincode(pincode);
		Thread.sleep(2000);
		sscTtCP.enterVillageTownCity(villageTownCity);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Country')]]]/div[2]")).getText(), "India");
		sscTtCP.selectState(state);
		Thread.sleep(2000);
		sscTtCP.selectDistrict(district);
		Thread.sleep(4000);
		sscTtCP.selectSubDistrict(subDistrict);
		Thread.sleep(2000);
		sscTtCP.enterTrainingCentreCapacity(trainingCentreCapacity);
		Thread.sleep(2000);
		sscTtCP.enterContactPersonName(contactPersonName);
		Thread.sleep(2000);
		sscTtCP.enterContactPersonEmail(contactPersonEmail);
		Thread.sleep(2000);
		sscTtCP.enterContactPersonMobileNumber(contactPersonMobileNumber);
		Thread.sleep(2000);
		sscTtCP.enterSinglePointOfContactPersonName(singlePointOfContactPersonName);
		Thread.sleep(2000);
		sscTtCP.enterSinglePointOfContactPersonEmail(singlePointOfContactPersonEmail);
		Thread.sleep(2000);
		sscTtCP.enterSinglePointOfContactPersonMobileNumber(singlePointOfContactPersonMobileNumber);
		Thread.sleep(2000);
		//adding SubSectors & Job Roles
		sscTtCP.clickAddSubsectorAndJobRoleButton();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='form-group m-form__group row']/div[3]")).getText(),expectedSector);
		sscTtCP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTtCP.selectJobRole(jobRole);
		Thread.sleep(2000);
		sscTtCP.clickAddButton();
		Thread.sleep(2000);
		sscTtCP.clickConfirmation();
		Thread.sleep(2000);
		sscTtCP.clickCreate();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//div[@id='toast-container']/div/div")).size()==0, "OMG!!! Toast Message Present, May be because of Duplicate Email or Mobile!!! ");
		//This assertion is based on the difference in url while creating temporary training centre and after successfull creation of temporary training centre
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc", "TRAINING CENTRE NOT CREATED : May be something went wrong!!! ");
		String createdTCID=driver.findElement(By.id("swal2-title")).getText();
		//getting created TC_ID and Writing into Excel
		String[] parts=createdTCID.split(" ");
		String trainingCentreID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","CreateLocationBasedTC",1,2, trainingCentreID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","LocationBasedTC-BatchRejection",1,13, trainingCentreID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","MasterTrainerBatchRejection",1,13, trainingCentreID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls","AssessmentAgencyBatchRejection",1,13, trainingCentreID);
		Thread.sleep(2000);
		sscTtCP.clickOk();
		Thread.sleep(2000);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		lp.clickLogin();
		Thread.sleep(2000);
		elp.performlogin(trainingCentreID, "ekaushal");
		Thread.sleep(2000);
		RegistrationPage rp = new RegistrationPage(driver);
		//plz do not change passwords, as this will affect other test cases
		rp.enterOldPassword("ekaushal");
		rp.enterNewPassword("Qwerty@123"); 
		rp.enterConfirmPassword("Qwerty@123");
		rp.clickResetResubmit();
		Thread.sleep(2000);
		rp.clickConfirmationOkMessage();
		Thread.sleep(2000);
		elp.performlogin(trainingCentreID,"Qwerty@123");
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] sscBatchCreationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "ToT-ToA-ToMT-ToMA-BatchCreation");
	}
	@Test(dataProvider="sscBatchCreationData",dependsOnMethods="locationBasedTrainingCentreCreationForBatchWorkflowTC_01")
	public void sscBatchCreationTC_02(String serialNum,String createdBatchIDs,String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict, String actionMenuOptions) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(6000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickCreateBatch();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(2000);
		sscTbcP.selectJobRole(jobRole);
		Thread.sleep(3000);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		Thread.sleep(4000);
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
		String expectedTrainingStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[1]")).getAttribute("value");
		String expectedTrainingStartDateHipen=expectedTrainingStartDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval",Integer.parseInt(serialNum) , 5, expectedTrainingStartDateHipen);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssigningMTandAA",Integer.parseInt(serialNum) , 7, expectedTrainingStartDateHipen);
		String expectedTrainingEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String trainingEndDateHipen=expectedTrainingEndDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval",Integer.parseInt(serialNum) , 6, trainingEndDateHipen);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssigningMTandAA",Integer.parseInt(serialNum) , 8, trainingEndDateHipen);
		String expectedAssessmentStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[2]")).getAttribute("value").replaceAll("/", "-");		
		String assessmentStartDateHipen=expectedAssessmentStartDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval",Integer.parseInt(serialNum) , 7, assessmentStartDateHipen);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssigningMTandAA",Integer.parseInt(serialNum) , 9, assessmentStartDateHipen);
		String expectedAssessmentEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[2]")).getAttribute("value");
		String expectedAssessmentEndDateHipen=expectedAssessmentEndDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval",Integer.parseInt(serialNum) , 8, expectedAssessmentEndDateHipen);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssigningMTandAA",Integer.parseInt(serialNum) , 10, expectedAssessmentEndDateHipen);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[1]/span")).getText(), expectedTrainingStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[2]/span")).getText(), expectedAssessmentEndDate);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(2000);
		String bacthCreationsuccessfulPopupText=driver.findElement(By.xpath("//div[@class='swal2-content']")).getText();
		String[]parts=bacthCreationsuccessfulPopupText.split(" ");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "ToT-ToA-ToMT-ToMA-BatchCreation",Integer.parseInt(serialNum) , 1, createdBatchID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval",Integer.parseInt(serialNum) , 2, createdBatchID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssigningMTandAA",Integer.parseInt(serialNum) , 2, createdBatchID);
		sscTbcP.clickOk();
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		sscTbcP.selectState(state);
		Thread.sleep(2000);
		sscTbcP.selectDistrict(district);
		Thread.sleep(2000);
		sscTbcP.selectSubDistrict(subDistrict);
		Thread.sleep(4000);
		sscTbcP.clickToSearchAndAssignTrainingCentre();
		Thread.sleep(2000);
		String locationBasedtrainingCentreID=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "CreateLocationBasedTC", 1, 2);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval", Integer.parseInt(serialNum), 0,locationBasedtrainingCentreID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval", Integer.parseInt(serialNum), 1,"Qwerty@123");
		Thread.sleep(4000);
		sscTbcP.enterToSearchForTrainingCentreID(locationBasedtrainingCentreID);
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+locationBasedtrainingCentreID+"']")).size()==0, "OMG! The Training Centre - "+locationBasedtrainingCentreID+" You Are Searching For Not Found for This "+sscUsername+" In This Server!!! ");
		sscTbcP.clickActionMenu();
		if(actionMenuOptions.equalsIgnoreCase("view details"))
		{
			sscTbcP.clickViewDetails();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(), locationBasedTrainingCentreName);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreAddress+"')]")).getText().trim(), locationBasedTrainingCentreAddress);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreDistrict+"')]")).getText().trim(), locationBasedTrainingCentreDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreState+"')]")).getText().trim(), locationBasedTrainingCentreState);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentrePincode+"')]")).getText().trim(), locationBasedTrainingCentrePincode);
			Assert.assertEquals(driver.findElement(By.xpath("//div[label/strong[contains(text(),'Target Number of Capacity:')]]/div[contains(text(),'"+locationBasedTrainingCentreCapacity+"')]")).getText().trim(), locationBasedTrainingCentreCapacity);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreHeadName+"')]")).getText().trim(), locationBasedTrainingCentreHeadName);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreHeadPhone+"')]")).getText().trim(), locationBasedTrainingCentreHeadPhone);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreHeadEmail+"')]")).getText().trim(), locationBasedTrainingCentreHeadEmail);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreSPOCName+"')]")).getText().trim(), locationBasedTrainingCentreSPOCName);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreSPOCMobile+"')]")).getText().trim(), locationBasedTrainingCentreSPOCMobile);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+locationBasedTrainingCentreSPOCEmail+"')]")).getText().trim(), locationBasedTrainingCentreSPOCEmail);
			sscTbcP.clickToAssignTrainingCentre();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//strong[text()='Batch - Announcement']")).click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[text()='Sector:']]/div[3]")).getText().trim(), expectedSector);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Sub Sector:')]]/div[3]")).getText().trim(), subSector);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Batch Type')]]/div[3]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Job Role:')]]/div[3]/span")).getText().trim(), jobRole);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Fee:')]]/div[3]")).getText().trim(), expectedBatchFees);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Batch Size')]]/div[3]")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Batch Name')]]/div[3]")).getText().trim(), batchType+"/"+expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen+"("+createdBatchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Training:')]]/div[3]")).getText().trim(), expectedTrainingStartDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Training:')]]/div[4]")).getText().trim(), expectedTrainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Assessment')]]/div[3]")).getText().trim(), expectedAssessmentStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Assessment')]]/div[4]")).getText().trim(), expectedAssessmentEndDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Batch Dates')]]/div[3]")).getText().trim(), expectedTrainingStartDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Batch Dates')]]/div[4]")).getText().trim(), expectedAssessmentEndDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'State')]]/div[3]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'District')]]/div[3]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row padingtopBottom-10'][div[2]/strong[contains(text(),'Sub District')]]/div[3]")).getText().trim(), subDistrict);
			sscTbcP.clickToAssignTrainingCentreFinal();
			Thread.sleep(2000);
			sscTbcP.clickOk();
			Thread.sleep(2000);
		}
		else if(actionMenuOptions.equalsIgnoreCase("assign batch"))
		{
			sscTbcP.clickAssignBatch();
			Thread.sleep(4000);
			sscTbcP.clickToAssignTrainingCentre();
			Thread.sleep(2000);
			sscTbcP.clickOk();
			Thread.sleep(2000);
		}
		//checking presence of created batches
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickAllBatches();
		Thread.sleep(2000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		sBp.enterSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG! Batch - "+createdBatchID+" not found in All Batches Section of "+sscUsername+" !!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedAssessmentEndDateHipen+"')]")).getText().trim(), expectedAssessmentEndDateHipen);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+expectedTrainingStartDateHipen+"')])[1]")).getText().trim(), expectedTrainingStartDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+expectedAssessmentEndDateHipen+"')])[2]")).getText().trim(), expectedAssessmentEndDateHipen);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
		sBp.clickToViewPendingBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG! Batch - "+createdBatchID+" not found in Pending Section!!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedAssessmentEndDateHipen+"')]")).getText().trim(), expectedAssessmentEndDateHipen);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+expectedTrainingStartDateHipen+"')])[1]")).getText().trim(), expectedTrainingStartDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+expectedAssessmentEndDateHipen+"')])[2]")).getText().trim(), expectedAssessmentEndDateHipen);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
		
		//before approval from assign TC - Checking assigning of master trainer and assessment agency as it should not happen
		Thread.sleep(2000);
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Training Centre Name:')]]/td[2]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Address:')]]/td[2]")).getText().trim(), locationBasedTrainingCentreAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'City:')]]/td[2]")).getText().trim(), locationBasedTrainingCentreDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'State:')]]/td[2]")).getText().trim(), locationBasedTrainingCentreState);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Head of Training Centre:')]]/td[2]")).getText().trim(), locationBasedTrainingCentreHeadName);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Phone:')]]/td[2])[1]")).getText().trim(), locationBasedTrainingCentreHeadPhone);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Email:')]]/td[2])[1]")).getText().trim(), locationBasedTrainingCentreHeadEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Single Point of Contact Person:')]]/td[2]")).getText().trim(), locationBasedTrainingCentreSPOCName);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Phone:')]]/td[2])[2]")).getText().trim(), locationBasedTrainingCentreSPOCMobile);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Email:')]]/td[2])[2]")).getText().trim(), locationBasedTrainingCentreSPOCEmail);
		String masterTrainerName=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "ConfigurableFields", 1, 4);
		sBp.selectMasterTrainerForSEDJobrole(masterTrainerName);
		Thread.sleep(2000);
		sBp.clickToAssignMasterTrainer();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Can not assign Master Trainer, Batch is pending for approval from Training Centre"), "there is no toast message regarding assigning master trainer before TC Approving the respected batch");
		Thread.sleep(6000);
		String assessmentAgency=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "ConfigurableFields", 1, 7);
		SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-valid']")), assessmentAgency);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Assign')])[2]")).click();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Can not assign Assesment Agency, Batch is pending for approval from Training Centre"), "there is no toast message regarding assigning assessment agency before TC Approving the respected batch");
		Thread.sleep(2000);
		
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][]locationBasedTrainingCentreBatchApprovalData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchApproval");
	}
	@Test(dataProvider="locationBasedTrainingCentreBatchApprovalData",dependsOnMethods="sscBatchCreationTC_02")
	public void locationBasedTrainingCentreBatchApprovalTC_03(String locationBasedTrainingCentre,String locationBasedTrainingCentrePassword,String createdBatchID, String batchType, String batchSize, String trainingStartDate, String trainingEndDate, String assessmentStartDate, String assessmentEndDate, String jobRole, String expectedSector, String expectedBatchFees) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(locationBasedTrainingCentre, locationBasedTrainingCentrePassword);
		Thread.sleep(6000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!! Batch - "+createdBatchID+" not found in Newly Assigned Section of - "+locationBasedTrainingCentre+" !!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingStartDate+"')]")).getText(), trainingStartDate+" to "+assessmentEndDate);
		Assert.assertNotSame(driver.findElement(By.xpath("//span[contains(text(),'new')]")).getText(), "new");
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clickToSelectViewBatchDetailsOption();
		Thread.sleep(2000);
		//Asserting Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//span/b[contains(text(),'"+jobRole+"')]")).getText(), jobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//div/b[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div/b[contains(text(),'"+expectedBatchFees+"')]")).getText(), expectedBatchFees);
		Assert.assertEquals(driver.findElement(By.xpath("//div/b[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div/b[contains(text(),'"+batchType+"')]")).getText(), batchType);
		lTcVbP.clickToGoToDashboard();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)","");
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(2000);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG! Batch - "+createdBatchID+" not found in Newly Assigned Section of "+locationBasedTrainingCentre+" !!! ");		
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clickToSelectAcceptOrRejectBatchOption();
		Thread.sleep(2000);
		lTcVbP.clickToAcceptBatch();
		Thread.sleep(2000);
		lTcVbP.clickToSaveAndSubmit();
		Thread.sleep(2000);
		lTcVbP.clickOk();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-200)","");
		Thread.sleep(2000);
		//verifying Accepted Batches
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(2000);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG! Batch - "+createdBatchID+" not found in Accepted Batches Section of "+locationBasedTrainingCentre+" !!! ");		
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		Assert.assertTrue(driver.findElement(By.xpath("//th[4]")).getText().trim().equalsIgnoreCase("Candidates Applied"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[4]")).getText().trim(), "0");
		Assert.assertTrue(driver.findElement(By.xpath("//th[5]")).getText().trim().equalsIgnoreCase("Candidates Enrolled"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[5]")).getText().trim(), "0/"+batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingStartDate+"')]")).getText(), trainingStartDate+" to "+assessmentEndDate);
		Assert.assertTrue(driver.findElement(By.xpath("//td/span[contains(text(),'new')]")).getText().trim().equalsIgnoreCase("new"));
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(3000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		ArrayList<WebElement> actionMenuOptions=(ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='m-dropdown__content'])[2]/ul/li/a/span"));
		for(int i=0;i<actionMenuOptions.size();i++)
		{
			Assert.assertNotEquals(actionMenuOptions.get(i).getText(),"Accept/Reject Batch");
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] locationBasedTrainingCentreBatchRejectionData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchRejection");
	}
	@Test(dataProvider="locationBasedTrainingCentreBatchRejectionData",dependsOnMethods="locationBasedTrainingCentreCreationForBatchWorkflowTC_01")
	public void locationBasedTrainingCentreBatchRejectionTC_04(String serialNo, String rejectedBatchIDs, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict, String trainingCentre, String trainingCentrePassword) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(6000);
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
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "LocationBasedTC-BatchRejection",Integer.parseInt(serialNo),1,createdBatchID);
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
		//Assigned Location Based Training Centre Login To Reject Trainer Training Batch
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(trainingCentre, trainingCentrePassword);
		Thread.sleep(6000);
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
		lTcVbP.clickToRejectBatch();
		Thread.sleep(2000);
		lTcVbP.enterRemarks("Batch - "+createdBatchID+" Is Not Having Valid Details, So Rejecting This Batch!!!! ");
		Thread.sleep(2000);
		lTcVbP.clickToSaveAndSubmit();
		Thread.sleep(2000);
		lTcVbP.clickOk();
		Thread.sleep(4000);
		lTcVbP.clickToViewAllRejectedBatches();
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in Rejected Section of "+trainingCentre+" !!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//Reassigning Location Based Training Centre By SSC Max Limit=2, variable i=1 (1st Time Reassigning Location Based TC), when i=3 SSC "cannot assign TC" toast message should display
		for(int i=1;i<=3;i++)
		{
			lp.clickLogin();
			Thread.sleep(2000);
			elp.performlogin(sscUsername, sscPassword);
			Thread.sleep(6000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
			SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			sDp.clickAllBatches();
			Thread.sleep(2000);
			SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
			sBp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			sBp.enterSearchForBatchID(createdBatchID);
			Thread.sleep(2000);
			sBp.clickToSearch();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in Rejected Section of "+sscUsername+" !!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(), "Training Centre");
			sBp.clickToViewActionMenuOptions();
			Thread.sleep(2000);
			sBp.clickToReAssignTrainingCentre();
			Thread.sleep(2000);
			sBp.enterToSearchForTrainingCentreID(trainingCentre);
			Thread.sleep(2000);
			sBp.clickToViewActionMenuOptions();
			Thread.sleep(2000);
			sBp.clickToAssignBatch();
			Thread.sleep(2000);
			sBp.clickAssignButton();
			Thread.sleep(2000);
			if(i==3)
			{
				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Cannot Assign Training Centre"), "OMG!!! There is no toast message regarding Cannot Reassign Location Based TC for this Batch - "+createdBatchID+" as 3 times this batch got rejected by respected Training Centre!!!!  ");
				sBp.clickToCancel();
				Thread.sleep(2000);
			}
			else
			{
				sBp.clickOk();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,200)", "");
				sDp.clickAllBatches();
				Thread.sleep(2000);			
				sBp.clickToViewRejectedBatches();
				Thread.sleep(2000);
				sBp.enterSearchForBatchID(createdBatchID);
				Thread.sleep(2000);
				sBp.clickToSearch();
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).size()==0,"OMG!!! ReassignedTC Batch "+createdBatchID+" should not be listed in Rejected section of "+sscUsername+" !!!");
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
				lp.clickLogin();
				elp.performlogin(trainingCentre, trainingCentrePassword);
				Thread.sleep(20000);
				Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainingcentretraining-of-trainers");
				js.executeScript("window.scrollBy(0,200)","");
				lTcDp.clickToViewLocationBasedTrainingBatches();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,200)","");
				lTcVbP.enterToSearchForBatchID(createdBatchID);
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
				lTcVbP.clikToViewActionMenu();
				Thread.sleep(2000);
				lTcVbP.clikToViewActionMenu();
				Thread.sleep(2000);
				lTcVbP.clickToSelectAcceptOrRejectBatchOption();
				Thread.sleep(2000);
				lTcVbP.clickToRejectBatch();
				Thread.sleep(2000);
				lTcVbP.enterRemarks("This Batch - "+createdBatchID+" Is Not Having Valid Details, So Rejecting This Batch!!!! ");
				Thread.sleep(2000);
				lTcVbP.clickToSaveAndSubmit();
				Thread.sleep(2000);
				lTcVbP.clickOk();
				Thread.sleep(4000);
				lTcVbP.clickToViewAllRejectedBatches();
				Thread.sleep(4000);
				Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+createdBatchID+"']")).size()==0,"OMG!! Batch ID - "+createdBatchID+" Not Found in Rejected Section of "+trainingCentre+" !!! ");
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			}
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
	@DataProvider
	public Object[][] sscAssignMasterTrainerAndAssessmentAgencyForBatchData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "AssigningMTandAA");
	}
	@Test(dataProvider="sscAssignMasterTrainerAndAssessmentAgencyForBatchData",dependsOnMethods="locationBasedTrainingCentreBatchApprovalTC_03")
	public void sscAssigningMasterTrainerAndAssessmentAgencyForBatchTC_05(String sscUserName, String sscPassword, String batchID, String batchType, String sector, String jobRole, String batchSize, String batchStartDate, String batchEndDate, String assessmentStartDate, String assessmentEndDate, String actionsMenuOption, String masterTrainerName, String masterTrainerID, String masterTrainerPassword, String masterTrainerActions, String assessmentAgency, String assessmentAgencyPassword, String assessmentAgencyActions, String trainerBatchMasterAssessorID, String trainerBatchMasterAssessorName, String trainerBatchMasterAssessorPassword, String assessorBatchMasterAssessorID, String assessorBatchMasterAssessorName, String assessorBatchMasterAssessorPassword) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(6000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		PostLoginPage plp=new PostLoginPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(batchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in Published Section of "+sscUserName+" !!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentEndDate+"')]")).getText().trim(), assessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+batchStartDate+"')])[1]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+assessmentEndDate+"')])[2]")).getText().trim(), assessmentEndDate);
		}
		String locationBasedTrainingCentreName=ReadWriteData.getData("./TestData/Workflow/SSC-ToT-ToA-ToMT-ToMA-Batch-Workflow.xls", "CreateLocationBasedTC", 1, 3);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(),locationBasedTrainingCentreName);
		Assert.assertTrue(driver.findElement(By.xpath("//th[7]")).getText().trim().equalsIgnoreCase("Enrolled Candidates/Applied Candidates"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), "0/0");
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
		sBp.selectAssessmentAgencyForSEDJobRole(assessmentAgency);
		Thread.sleep(2000);
		sBp.clickToAssignAssessmentAgency();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+assessmentAgency+".");
		sBp.clickOk();
		Thread.sleep(2000);
		sBp.clickToGoBack();
		Thread.sleep(4000);
		sBp.clickToViewPendingBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(batchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in Pending Section of "+sscUserName+" !!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentEndDate+"')]")).getText().trim(), assessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+batchStartDate+"')])[1]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+assessmentEndDate+"')])[2]")).getText().trim(), assessmentEndDate);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(),locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().trim(), "Master Trainer, Assessment Agency");
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="sscAssignMasterTrainerAndAssessmentAgencyForBatchData",dependsOnMethods="sscAssigningMasterTrainerAndAssessmentAgencyForBatchTC_05")
	public void masterTrainerBatchApprovalTC_06(String sscUserName, String sscPassword, String batchID, String batchType, String sector, String jobRole, String batchSize, String batchStartDate, String batchEndDate, String assessmentStartDate, String assessmentEndDate, String actionsMenuOption, String masterTrainerName, String masterTrainerID, String masterTrainerPassword, String masterTrainerActions, String assessmentAgency, String assessmentAgencyPassword, String assessmentAgencyActions, String trainerBatchMasterAssessorID, String trainerBatchMasterAssessorName, String trainerBatchMasterAssessorPassword, String assessorBatchMasterAssessorID, String assessorBatchMasterAssessorName, String assessorBatchMasterAssessorPassword) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(masterTrainerID, masterTrainerPassword);
		Thread.sleep(2000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
		tDp.clickToGetTrainerDashboard();
		Thread.sleep(2000);
		tDp.clickViewBatches();
		Thread.sleep(2000);
		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
		tVp.clicktoGoToNewlyAssignedBatchesSection();
		Thread.sleep(2000);
		tVp.enterBatchStartDateToSearch(batchStartDate);
		Thread.sleep(2000);
		tVp.clickToCloseBatchStartDateCalender();
		Thread.sleep(2000);
		tVp.enterBatchEndDateToSearch(assessmentEndDate);
		Thread.sleep(2000);
		tVp.clickToCloseBatchEndDateCalender();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of matching Batch - "+batchID+" for Batch Dates: "+batchStartDate+" to "+assessmentEndDate+" in Newly-Assigned Section of "+masterTrainerID+" !!! ");
		tVp.enterTrainingCentreNameToSearch(locationBasedTrainingCentreName);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of matching Batch - "+batchID+" found for this training centre - "+locationBasedTrainingCentreName+" in Newly-Assigned Section of "+masterTrainerID+" !!! ");
		tVp.clickToViewFilterByBatchTypeListOptions();
		Thread.sleep(2000);
		ArrayList<WebElement>batchTypesFilter=(ArrayList<WebElement>)driver.findElements(By.xpath("(//ul[@class='lazyContainer'])[1]/span/li/label[2]"));
		for(int i=0;i<batchTypesFilter.size();i++)
		{
			while(batchTypesFilter.get(i).getText().equalsIgnoreCase(batchType))
			{
				batchTypesFilter.get(i).click();
				Thread.sleep(2000);
				tVp.clickToCloseFilterByBatchTypeList();
				Thread.sleep(2000);
				Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! Batch - "+batchID+" of Type - "+batchType+" is not found in Newly-Assigned Section of "+masterTrainerID+" !!!");
			}
		}
		ArrayList<WebElement>resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[contains(text(),'"+batchID+"')]"));
		Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! The Batch - "+batchID+" is not found in NewLy-Assigned Section of "+masterTrainerID+" !!! ");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), locationBasedTrainingCentreState );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), locationBasedTrainingCentreDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), batchStartDate+" to "+assessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[9]/span")).getText().trim(), "New");
		tVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(2000);
		if(masterTrainerActions.equalsIgnoreCase("view details"))
		{
			tVp.clickToChooseViewBatchDetailsOption();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"trainerbatch-details"+batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Entered Name of Training Centre']")).getAttribute("value").trim(), locationBasedTrainingCentreSPOCName);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Entered Mobile Number of the Training Centre SPOC']")).getAttribute("value").trim(), locationBasedTrainingCentreSPOCMobile);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Entered Email Address of the Training Centre SPOC']")).getAttribute("value").trim(), locationBasedTrainingCentreSPOCEmail);
			Assert.assertEquals(driver.findElement(By.xpath("//textarea[@placeholder='Entered full Address of the Training Centre']")).getAttribute("value").trim(), locationBasedTrainingCentreAddress);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Entered the Nearby Landmark to the above mentioned address']")).getAttribute("value").trim(), locationBasedTrainingCentreNearByLandmark);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Entered the Pincode']")).getAttribute("value").trim(), locationBasedTrainingCentrePincode);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Selected State/Union Territory']")).getAttribute("value").trim(), locationBasedTrainingCentreState);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Selected District/City']")).getAttribute("value").trim(), locationBasedTrainingCentreDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Selected Tehsil/Mandal']")).getAttribute("value").trim(), locationBasedTrainingCentreTehsil);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+jobRole+"')]")).getText().trim(), jobRole);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+sector+"')]")).getText().trim(), sector);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+batchStartDate+" to "+assessmentEndDate+"')]")).getText().trim(), batchStartDate+" to "+assessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
			tVp.clickViewAllBatchesToGoBackFromBatchDetails();
			Thread.sleep(2000);
			tVp.enterBatchStartDateToSearch(batchStartDate);
			Thread.sleep(2000);
			tVp.clickToCloseBatchStartDateCalender();
			Thread.sleep(2000);
			tVp.enterBatchEndDateToSearch(assessmentEndDate);
			Thread.sleep(2000);
			tVp.clickToCloseBatchEndDateCalender();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of Batch - "+batchID+" of Dates: "+batchStartDate+" to "+assessmentEndDate+" in Newly-Assigned Section of "+masterTrainerID+" !!!");
			tVp.enterTrainingCentreNameToSearch(locationBasedTrainingCentreName);
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of Batch - "+batchID+" of training centre - "+locationBasedTrainingCentreName+" in Newly-Assigned Section "+masterTrainerID+" !!!");
			tVp.clickToViewFilterByBatchTypeListOptions();
			Thread.sleep(2000);
			batchTypesFilter=(ArrayList<WebElement>)driver.findElements(By.xpath("(//ul[@class='lazyContainer'])[1]/span/li/label[2]"));
			for(int i=0;i<batchTypesFilter.size();i++)
			{
				while(batchTypesFilter.get(i).getText().equalsIgnoreCase(batchType))
				{
					batchTypesFilter.get(i).click();
					Thread.sleep(2000);
					tVp.clickToCloseFilterByBatchTypeList();
					Thread.sleep(2000);
					Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! Batch - "+batchID+" of Type - "+batchType+" is not found in Newly-Assigned Section of "+masterTrainerID+" !!!");
				}
			}
			resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[contains(text(),'"+batchID+"')]"));
			Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! The Batch - "+batchID+" is not found in NewLy-Assigned Section of "+masterTrainerID+" !!! ");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			tVp.clickToGetActionMenuOptions(batchID);
			Thread.sleep(2000);
			tVp.clickToChooseAcceptOrRejectBatchOption();
			Thread.sleep(2000);
			tVp.clickToAcceptBatch();
			Thread.sleep(2000);
			tVp.clickToSaveAndSubmit();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
			tVp.clickOk();
			Thread.sleep(2000);
		}
		else if(masterTrainerActions.equalsIgnoreCase("accept"))
		{
			tVp.clickToChooseAcceptOrRejectBatchOption();
			Thread.sleep(2000);
			tVp.clickToAcceptBatch();
			Thread.sleep(2000);
			tVp.clickToSaveAndSubmit();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
			tVp.clickOk();
			Thread.sleep(2000);
		}
		//verifying accepted batches
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(8000);
		tVp.clickToGoToAcceptAndOngoingBatchesSection();
		Thread.sleep(2000);
		resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[text()='"+batchID+"']"));
		Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! The Batch - "+batchID+" is not found in Accepted & On-Going Section of "+masterTrainerID+" !!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[3]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[4]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[6]")).getText().trim(), locationBasedTrainingCentreState );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[7]")).getText().trim(), locationBasedTrainingCentreDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), batchStartDate+" to "+assessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[9]/span")).getText().trim(), "New");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//SSC Login To Check Master Trainer Approved Batches and Change of Master Trainer should not be allowed once approved
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(6000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(batchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in Published Section of "+sscUserName+" !!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentEndDate+"')]")).getText().trim(), assessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+batchStartDate+"')])[1]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+assessmentEndDate+"')])[2]")).getText().trim(), assessmentEndDate);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(),locationBasedTrainingCentreName);
		Assert.assertTrue(driver.findElement(By.xpath("//th[7]")).getText().trim().equalsIgnoreCase("Enrolled Candidates/Applied Candidates"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), "0/0");
		Thread.sleep(2000);
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(4000);
		sBp.selectMasterTrainerForSEDJobrole(masterTrainerName);
		Thread.sleep(2000);
		sBp.clickToChangeAssignedMasterTrainer();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Master Trainer has already accepted the request"), "there is no toast message regarding changing of master trainer in case of respected master trainer batch approval");
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
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
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
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
	
	@Test(dataProvider="sscAssignMasterTrainerAndAssessmentAgencyForBatchData",dependsOnMethods="sscAssigningMasterTrainerAndAssessmentAgencyForBatchTC_05")
	public void assessmentAgencyBatchApprovalAndAssigningAssessorsTC_08(String sscUserName, String sscPassword, String batchID, String batchType, String sector, String jobRole, String batchSize, String batchStartDate, String batchEndDate, String assessmentStartDate, String assessmentEndDate, String actionsMenuOption, String masterTrainerName, String masterTrainerID, String masterTrainerPassword, String masterTrainerActions, String assessmentAgency, String assessmentAgencyPassword, String assessmentAgencyActions, String trainerBatchMasterAssessorID, String trainerBatchMasterAssessorName, String trainerBatchMasterAssessorPassword, String assessorBatchMasterAssessorID, String assessorBatchMasterAssessorName, String assessorBatchMasterAssessorPassword) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(assessmentAgency, assessmentAgencyPassword);
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagency","Login Unsuccessful!!! ");
		AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
		Thread.sleep(4000);
		aDp.clickToViewBatches();
		Thread.sleep(2000);
		AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
		aVp.clickToViewNewlyAssignedBatches();
		Thread.sleep(2000);
		aVp.enterBatchIdToSearch(batchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of batch - "+batchID+" in "+assessmentAgency+" Newly Assigned section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+assessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/span")).getText().trim(), "BATCH CREATED");
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(2000);
		if(assessmentAgencyActions.equalsIgnoreCase("view details"))
		{
			aVp.clickToChooseViewBatchDetailsOption();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batchesview-batch-detailsNEW"+batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+jobRole+"')]")).getText().trim(), jobRole);
			Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+sector+"')]")).getText().trim(), sector);
			Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
			if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+batchEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+assessmentStartDate+"')]")).getText().trim(), assessmentStartDate+" to "+assessmentEndDate);
			}
			else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'"+batchStartDate+"')])[1]")).getText().trim(), batchStartDate+" to "+batchEndDate);
				Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'"+assessmentStartDate+"')])[2]")).getText().trim(), assessmentStartDate+" to "+assessmentEndDate);
			}
			//Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreSPOCName+"')]")).getText().trim(), locationBasedTrainingCentreSPOCName);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreSPOCMobile+"')]")).getText().trim(), locationBasedTrainingCentreSPOCMobile);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreSPOCEmail+"')]")).getText().trim(), locationBasedTrainingCentreSPOCEmail);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreAddress+"')]")).getText().trim(), locationBasedTrainingCentreAddress);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreNearByLandmark+"')]")).getText().trim(), locationBasedTrainingCentreNearByLandmark);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentrePincode+"')]")).getText().trim(), locationBasedTrainingCentrePincode);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreState+"')]")).getText().trim(), locationBasedTrainingCentreState);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreDistrict+"')]")).getText().trim(), locationBasedTrainingCentreDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreTehsil+"')]")).getText().trim(), locationBasedTrainingCentreTehsil);
			aVp.clickToGoBack();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batchesNEW");
			aVp.enterBatchIdToSearch(batchID);
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No no show of batch - "+batchID+" in Newly-Assigned Section");
			js.executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(2000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(4000);
			aVp.clickToGetActionMenuOptions();
			Thread.sleep(2000);
			aVp.clickToChooseAcceptOrRejectBatchOption();
			Thread.sleep(2000);
			aVp.clickToAcceptBatch();
			Thread.sleep(2000);
			aVp.clickToSaveAndSubmit();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
			aVp.clickOk();
			Thread.sleep(2000);
		}
		else if(assessmentAgencyActions.equalsIgnoreCase("accept"))
		{
			aVp.clickToChooseAcceptOrRejectBatchOption();
			Thread.sleep(2000);
			aVp.clickToAcceptBatch();
			Thread.sleep(2000);
			aVp.clickToSaveAndSubmit();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
			aVp.clickOk();
			Thread.sleep(2000);
		}
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
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//th[4]")).getText().trim(), "Candidates Applied");
		Assert.assertEquals(driver.findElement(By.xpath("//td[4]")).getText().trim(), "0","OMG!!!! Candidates applied count should be 0 as no one applied for this batch - "+batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//th[5]")).getText().trim(), "Candidates Enrolled");
		Assert.assertEquals(driver.findElement(By.xpath("//td[5]")).getText().replaceAll(" ", ""), "0/"+batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+assessmentEndDate );
		Assert.assertEquals(driver.findElement(By.xpath("//tr/span")).getText().trim(), "BATCH CREATED");
		Thread.sleep(2000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(2000);
		aVp.clickToChooseAssignAssessorsActionMenuOption();
		Thread.sleep(2000);
		ArrayList<WebElement>assessorsListed=(ArrayList<WebElement>)driver.findElements(By.xpath("//select[@formcontrolname='assessor']/option"));
		Assert.assertTrue(assessorsListed.size()>1,"Sorry!!!! there are no assessors available for: "+assessmentAgency+"<-> "+batchID+" batch!!! ");
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer"))
		{
			aVp.selectAssessorsToBeAssignedForBatches(trainerBatchMasterAssessorID);
		}
		else if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Training of Master Assessor")) 
		{
			aVp.selectAssessorsToBeAssignedForBatches(assessorBatchMasterAssessorID);
		}
		Thread.sleep(2000);
		aVp.clickToSaveAndSubmit();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Assessor Assigned Successfully Message Popup Not Displayed");
		aVp.clickOk();
		Thread.sleep(2000);
		//verifying assigned assessorID in view batch details page
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		aVp.clickToViewAcceptedBatches();
		Thread.sleep(4000);
		aVp.enterBatchIdToSearch(batchID);
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! The Batch - "+batchID+" is not found in Accepted Section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToGetActionMenuOptions();
		Thread.sleep(4000);
		aVp.clickToChooseViewBatchDetailsOption();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessmentagencyview-batchesview-batch-detailsACCEPTED"+batchID);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer"))
		{
			Assert.assertTrue(driver.findElement(By.xpath("//span/b[contains(text(),'"+trainerBatchMasterAssessorName+"')]")).getText().contains(trainerBatchMasterAssessorName));
		}
		else if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Training of Master Assessor")) 
		{
			Assert.assertTrue(driver.findElement(By.xpath("//span/b[contains(text(),'"+assessorBatchMasterAssessorName+"')]")).getText().contains(assessorBatchMasterAssessorName));
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		//SSC Login To Check Assessment Agency Approved Batches and Change of Assessment Agency should not be allowed once approved
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		lp.clickLogin();
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(6000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!!Login Unsuccessfull OR may took more time to login!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(batchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).size()==0,"OMG!! Batch ID - "+batchID+" Not Found in Published Section of "+sscUserName+" !!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+assessmentEndDate+"')]")).getText().trim(), assessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+batchStartDate+"')])[1]")).getText().trim(), batchStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'"+assessmentEndDate+"')])[2]")).getText().trim(), assessmentEndDate);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(),locationBasedTrainingCentreName);
		Assert.assertTrue(driver.findElement(By.xpath("//th[7]")).getText().trim().equalsIgnoreCase("Enrolled Candidates/Applied Candidates"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().replaceAll(" ", ""), "0/0");
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(4000);
		sBp.selectAssessmentAgencyForSEDJobRole(assessmentAgency);
		Thread.sleep(2000);
		sBp.clickToChangeAssignedAssessmentAgency();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Assessment Agency has already accepted the request"), "there is no toast message regarding changing of assessment agency in case of respected assessment agency batch approval");
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
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
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
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
	
	@Test(dataProvider="sscAssignMasterTrainerAndAssessmentAgencyForBatchData",dependsOnMethods="sscAssigningMasterTrainerAndAssessmentAgencyForBatchTC_05")
	public void masterAssessorBatchApprovalTC_10(String sscUserName, String sscPassword, String batchID, String batchType, String sector, String jobRole, String batchSize, String batchStartDate, String batchEndDate, String assessmentStartDate, String assessmentEndDate, String actionsMenuOption, String masterTrainerName, String masterTrainerID, String masterTrainerPassword, String masterTrainerActions, String assessmentAgency, String assessmentAgencyPassword, String assessmentAgencyActions, String trainerBatchMasterAssessorID, String trainerBatchMasterAssessorName, String trainerBatchMasterAssessorPassword, String assessorBatchMasterAssessorID, String assessorBatchMasterAssessorName, String assessorBatchMasterAssessorPassword) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer"))
		{
			elp.performlogin(trainerBatchMasterAssessorID, trainerBatchMasterAssessorPassword);
		}
		else if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Training of Master Assessor"))
		{
			elp.performlogin(assessorBatchMasterAssessorID, assessorBatchMasterAssessorPassword);
		}
		Thread.sleep(2000);
		AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
		maDp.clickToGetTrainerDashboard();
		Thread.sleep(2000);
		maDp.clickViewBatches();
		Thread.sleep(2000);
		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
		maVp.clicktoGoToNewlyAssignedBatchesSection();
		Thread.sleep(4000);
		maVp.enterBatchStartDateToSearch(batchStartDate);
		Thread.sleep(2000);
		maVp.clickToCloseBatchStartDateCalender();
		Thread.sleep(4000);
		maVp.enterBatchEndDateToSearch(assessmentEndDate);
		Thread.sleep(2000);
		maVp.clickToCloseBatchEndDateCalender();
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of matching Batch - "+batchID+" for Batch Dates: "+batchStartDate+" to "+assessmentEndDate+" in Newly-Assigned Section!!! ");
		ArrayList<WebElement>resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[contains(text(),'"+batchID+"')]"));
		Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! The Batch - "+batchID+" is not found in NewLy-Assigned Section!!! ");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+locationBasedTrainingCentreState+"')]")).getText().trim(), locationBasedTrainingCentreState);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+locationBasedTrainingCentreDistrict+"')]")).getText().trim(), locationBasedTrainingCentreDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")));		                         
		maVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(4000);
		//View Batch Details Data Verification
		maVp.clickToChooseViewBatchDetailsOption(batchID);
		Thread.sleep(4000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""),configuredURL.replaceAll("/", "")+"assessormaster-assessorview-batch-detailsNEW"+batchID," Sorry!!! View Batch Details page is not loaded or URL might have been changed!!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//span/b[contains(text(),'"+jobRole+"')]")).getText().trim(), jobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//div/b[contains(text(),'"+sector+"')]")).getText().trim(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("//span/b[contains(text(),'"+masterTrainerName+"')]")).getText().trim(), masterTrainerName);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//span/b[contains(text(),'"+trainerBatchMasterAssessorName+"')]")).getText().trim(), trainerBatchMasterAssessorName);
		}
		else if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Training of Master Assessor"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//span/b[contains(text(),'"+assessorBatchMasterAssessorName+"')]")).getText().trim(), assessorBatchMasterAssessorName);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//div/b[text()='"+batchSize+"']")).getText().trim(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div/b[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Assessor-New"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+batchStartDate+"')]")).getText().trim(),batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+assessmentStartDate+"')]")).getText().trim(), assessmentStartDate+" to "+assessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Master Assessor")||batchType.equalsIgnoreCase("Training of Assessor-Existing"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'"+batchStartDate+"')])[1]")).getText().trim(),batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'"+assessmentStartDate+"')])[2]")).getText().trim(), assessmentStartDate+" to "+assessmentEndDate);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreSPOCName+"')]")).getText().trim(), locationBasedTrainingCentreSPOCName);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreSPOCMobile+"')]")).getText().trim(), locationBasedTrainingCentreSPOCMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreSPOCEmail+"')]")).getText().trim(), locationBasedTrainingCentreSPOCEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreAddress+"')]")).getText().trim(), locationBasedTrainingCentreAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreNearByLandmark+"')]")).getText().trim(), locationBasedTrainingCentreNearByLandmark);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentrePincode+"')]")).getText().trim(), locationBasedTrainingCentrePincode);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreState+"')]")).getText().trim(), locationBasedTrainingCentreState);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreDistrict+"')]")).getText().trim(), locationBasedTrainingCentreDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+locationBasedTrainingCentreTehsil+"')]")).getText().trim(), locationBasedTrainingCentreTehsil);
		maVp.clickToGoBack();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"assessormaster-assessorview-batchesNEW","Sorry!!! Go Back button does not navigated to newly assigned batches section OR url might have been changed!!! ");
		maVp.enterBatchStartDateToSearch(batchStartDate);
		Thread.sleep(2000);
		maVp.clickToCloseBatchStartDateCalender();
		Thread.sleep(4000);
		maVp.enterBatchEndDateToSearch(assessmentEndDate);
		Thread.sleep(2000);
		maVp.clickToCloseBatchEndDateCalender();
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of matching Batch - "+batchID+" for Batch Dates: "+batchStartDate+" to "+assessmentEndDate+" in Newly-Assigned Section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]")));		                         
		maVp.clickToGetActionMenuOptions(batchID);
		Thread.sleep(4000);
		maVp.clickToChooseAcceptOrRejectBatchOption(batchID);
		Thread.sleep(2000);
		maVp.clickToAcceptBatch();
		Thread.sleep(2000);
		maVp.clickToSaveAndSubmit();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().toLowerCase().trim().contains("success"), "Sorry!! Accepted Successfully Message Popup Not Displayed");
		maVp.clickOk();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(4000);
		maVp.clickToGoToAcceptedAndOngoingBatchesSection();
		Thread.sleep(4000);
		maVp.enterBatchStartDateToSearch(batchStartDate);
		Thread.sleep(2000);
		maVp.clickToCloseBatchStartDateCalender();
		Thread.sleep(2000);
		maVp.enterBatchEndDateToSearch(assessmentEndDate);
		Thread.sleep(2000);
		maVp.clickToCloseBatchEndDateCalender();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.xpath("//td[text()='"+batchID+"']")).size()==0,"OMG!!! No show of matching Batch - "+batchID+" for Batch Dates: "+batchStartDate+" to "+assessmentEndDate+" in Accepted & Ongoing Section!!! ");
		resultedBatchIDs=(ArrayList<WebElement>)driver.findElements(By.xpath("//tr/td[text()='"+batchID+"']"));
		Assert.assertTrue(resultedBatchIDs.size()!=0,"OMG!!! The Batch - "+batchID+" is not found in Accepted & Ongoing Section!!! ");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+locationBasedTrainingCentreState+"')]")).getText().trim(), locationBasedTrainingCentreState);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+locationBasedTrainingCentreDistrict+"')]")).getText().trim(), locationBasedTrainingCentreDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[contains(text(),'"+batchStartDate+"')]")).getText().trim(), batchStartDate+" to "+batchEndDate);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
}

	