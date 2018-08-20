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
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LocationBasedTC_DashboardPage;
import com.nsdc.pages.LocationBasedTC_ViewBatchesPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_LocationBasedTC_TrainingBatchCreationPage;
import com.nsdc.testConfig.TestConfiguration;

public class SSC_LocationBasedTC_TrainingBatchCreationWorkflowTestSC_10 extends TestConfiguration
{
	@DataProvider
	public Object[][] sscLocationBasedTCTrainingBatchCreationWorkflowData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "BatchCreationTestSC10TC01");
	}
	@Test(dataProvider="sscLocationBasedTCTrainingBatchCreationWorkflowData")
	public void sscLocationBasedTCTrainingBatchCreationTC01(String serialNum,String createdBatchIDs,String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict, String actionMenuOptions) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl(), configuredURL+"/ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum),0,sscUsername);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum),1,sscPassword);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickCreateBatch();
		Thread.sleep(2000);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 10, expectedSector);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum) , 4, expectedSector);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 3, batchType);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum) , 3, batchType);
		Thread.sleep(2000);
		sscTbcP.selectJobRole(jobRole);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 9, jobRole);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum) , 5, jobRole);
		Thread.sleep(3000);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 11, expectedBatchFees);
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 4, batchSize);
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 5, expectedTrainingStartDateHipen);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum) , 6, expectedTrainingStartDateHipen);
		String expectedTrainingEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String trainingEndDateHipen=expectedTrainingEndDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 6, trainingEndDateHipen);
		String expectedAssessmentStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[2]")).getAttribute("value").replaceAll("/", "-");		
		String assessmentStartDateHipen=expectedAssessmentStartDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 7, assessmentStartDateHipen);
		String expectedAssessmentEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[2]")).getAttribute("value");
		String expectedAssessmentEndDateHipen=expectedAssessmentEndDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 8, expectedAssessmentEndDateHipen);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum) , 7, expectedAssessmentEndDateHipen);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[1]/span")).getText(), expectedTrainingStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[2]/span")).getText(), expectedAssessmentEndDate);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(2000);
		String bacthCreationsuccessfulPopupText=driver.findElement(By.xpath("//div[@class='swal2-content']")).getText();
		String[]parts=bacthCreationsuccessfulPopupText.split(" ");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "BatchCreationTestSC10TC01",Integer.parseInt(serialNum) , 1, createdBatchID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 2, createdBatchID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum) , 2, createdBatchID);
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
		
		//sscTbcP.enterToSearchForTrainingCentreID(trainingCentreID);
		String locationBasedtrainingCentreID=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls", "SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 3);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls","LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 0, locationBasedtrainingCentreID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls","LocationBasedTC-BatchApprovalSC10TC02",Integer.parseInt(serialNum) , 1, "Qwerty@123");
		String locationBasedTrainingCentreName=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls", "SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 4);
		sscTbcP.enterToSearchForTrainingCentreID(locationBasedtrainingCentreID);
		Thread.sleep(4000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2, "Sorry! The Training Centre - "+locationBasedtrainingCentreID+" You Are Searching For Not Found In This Server!!! ");
		sscTbcP.clickActionMenu();
		if(actionMenuOptions.equalsIgnoreCase("view details"))
		{
			sscTbcP.clickViewDetails();
			Thread.sleep(2000);
			sscTbcP.clickToAssignTrainingCentre();
			Thread.sleep(4000);
		/*	driver.findElement(By.xpath("//strong[text()='Batch - Announcement']")).click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[2]/div[3]")).getText(), subSector);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[3]/div[3]")).getText(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[4]/div[3]")).getText(), jobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[5]/div[3]")).getText(), expectedBatchFees);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[6]/div[3]")).getText(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[7]/div[3]")).getText(), batchType+"/"+expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen+"("+createdBatchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[8]/div[3]")).getText(), expectedTrainingStartDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[8]/div[4]")).getText(), expectedTrainingEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[9]/div[3]")).getText(), expectedAssessmentStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[9]/div[4]")).getText(), expectedAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[10]/div[3]")).getText(), expectedTrainingStartDate);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[10]/div[4]")).getText(), expectedAssessmentEndDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[11]/div[3]")).getText(), state);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[12]/div[3]")).getText(), district);
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='row padingtopBottom-10'])[13]/div[3]")).getText(), subDistrict);
		*/
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
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry! Batch - "+createdBatchID+" not found in All Batches Section!!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
		sBp.clickToViewPendingBatches();
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry! Batch - "+createdBatchID+" not found in Pending Section!!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+locationBasedTrainingCentreName+"')]")).getText().trim(), locationBasedTrainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
		
		//before approval from assign TC - Checking assigning of master trainer and assessment agency as it should not happen
		Thread.sleep(2000);
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(2000);
		String masterTrainerName=ReadWriteData.getData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04", 1, 9);
		sBp.selectMasterTrainerForSEDJobrole(masterTrainerName);
		Thread.sleep(2000);
		sBp.clickToAssignMasterTrainer();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Can not assign Master Trainer, Batch is pending for approval from Training Centre"), "there is no toast message regarding assigning master trainer before TC Approving the respected batch");
		Thread.sleep(6000);
		String assessmentAgency=ReadWriteData.getData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04", 1, 13);
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
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchApprovalSC10TC02");
	}
	@Test(dataProvider="locationBasedTrainingCentreBatchApprovalData",dependsOnMethods="sscLocationBasedTCTrainingBatchCreationTC01")
	public void locationBasedTrainingCentreBatchApprovalTC02(String locationBasedTrainingCentre,String locationBasedTrainingCentrePassword,String createdBatchID, String batchType, String batchSize, String trainingStartDate, String trainingEndDate, String assessmentStartDate, String assessmentEndDate, String jobRole, String expectedSector, String expectedBatchFees) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(locationBasedTrainingCentre, locationBasedTrainingCentrePassword);
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		//SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
		//Thread.sleep(2000);
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry! Batch not found in Newly Assigned Section!!! ");		
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
		//SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
		//Thread.sleep(2000);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry! Batch - "+createdBatchID+" not found in Newly Assigned Section!!! ");		
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
		lTcVbP.clickToViewAllAcceptedBatches();
		Thread.sleep(2000);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry! Batch - "+createdBatchID+" not found in Accepted Batches Section!!! ");		
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
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
	//Batch Rejection flow
	@DataProvider
	public Object[][] locationBasedTrainingCentreBatchRejectionData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "LocationBasedTC-BatchRejectionSC10TC03");
	}
	@Test(dataProvider="locationBasedTrainingCentreBatchRejectionData")
	public void locationBasedTrainingCentreBatchRejectionTC03(String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict, String trainingCentre, String trainingCentrePassword) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl(), configuredURL+"/ssc","Login Unsuccessfull");
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
		//sscTbcP.enterToSearchForTrainingCentreID(trainingCentreID);
		sscTbcP.enterToSearchForTrainingCentreID(trainingCentre);
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2, "Sorry! The Training Centre - "+trainingCentre+" You Are Searching For Not Found In This Server!!! ");
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
		lp.clickLogin();
		elp.performlogin(trainingCentre, trainingCentrePassword);
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		//SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
		//Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry! Batch not found in Newly Assigned Section!!! ");		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingStartDate.replaceAll("/", "-")+"')]")).getText(), trainingStartDate.replaceAll("/", "-")+" to "+assessmentEndDate.replaceAll("/", "-"));
		//Assert.assertNotSame(driver.findElement(By.xpath("//span[contains(text(),'BATCH CREATED')]")).getText(), "BATCH CREATED");
		Assert.assertNotSame(driver.findElement(By.xpath("//tr/td[7]/span")).getText(), "new");
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(4000);
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
		//lTcVbP.enterToSearchForBatchID(createdBatchID);
		//Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry!! Batch ID - "+createdBatchID+" Not Found in Rejected Section!!! ");
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
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), configuredURL+"/ssc","Login Unsuccessfull");
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
			Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry!! Batch ID - "+createdBatchID+" Not Found in Rejected Section!!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
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
				SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
				Thread.sleep(2000);
				sBp.enterSearchForBatchID(createdBatchID);
				Thread.sleep(2000);
				sBp.clickToSearch();
				Thread.sleep(2000);
				Assert.assertTrue(driver.findElements(By.tagName("tr")).size()<2,"ReassignedTC Batch "+createdBatchID+" should not be listed in Rejected section");
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				Thread.sleep(2000);
				lp.clickLogin();
				elp.performlogin(trainingCentre, trainingCentrePassword);
				Thread.sleep(2000);
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
				//SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
				//Thread.sleep(2000);
				//lTcVbP.enterToSearchForBatchID(createdBatchID);
				//Thread.sleep(2000);
				Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry!! Batch ID - "+createdBatchID+" Not Found in Rejected Section!!! ");
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
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04");
	}
	@Test(dataProvider="sscAssignMasterTrainerAndAssessmentAgencyForBatchData",dependsOnMethods="locationBasedTrainingCentreBatchApprovalTC02")
	public void sscAssigningMasterTrainerAndAssessmentAgencyForBatchTC04(String sscUserName, String sscPassword, String batchID, String batchType, String sector, String jobRole, String batchStartDate, String assessmentEndDate, String actionsMenuOption, String masterTrainerName, String masterTrainerID, String masterTrainerPassword, String masterTrainerActions, String assessmentAgency, String assessmentAgencyPassword) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(2000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl(), configuredURL+"/ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		PostLoginPage plp=new PostLoginPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl(), configuredURL+"/ssc/all-batches");
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
		Thread.sleep(2000);
		sBp.enterSearchForBatchID(batchID);
		Thread.sleep(2000);
		sBp.clickToSearch();
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry!! Batch ID - "+batchID+" Not Found in Published Section!!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
		//Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Self')]")).getText(),"Self","No show of Batch Status!!! ");
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		if(actionsMenuOption.equalsIgnoreCase("view details"))
		{
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
			Thread.sleep(2000);
			sBp.clickToViewPublishedBatches();
			Thread.sleep(2000);
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Thread.sleep(2000);
			sBp.enterSearchForBatchID(batchID);
			Thread.sleep(2000);
			sBp.clickToSearch();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry!! Batch ID - "+batchID+" Not Found in Published Section!!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span[1]")).getText().trim()+driver.findElement(By.xpath("//td[7]/span[2]")).getText().trim(), "Master Trainer,Assessment Agency");
		}
		else if(actionsMenuOption.equalsIgnoreCase("assign master trainer and assessment agency"))
		{
			//choosing assign master trainer option
			sBp.clickToChooseAssignMasterTrainerOption();
			Thread.sleep(2000);
			sBp.selectOnlyMasterTrainerForSEDJobrole(masterTrainerName);
			Thread.sleep(2000);
			sBp.clickSEDAssignButton1();
			Thread.sleep(2000);
			sBp.clickAssignItButton();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+masterTrainerID+".");
			sBp.clickOk();
			Thread.sleep(2000);
			sBp.enterSearchForBatchID(batchID);
			Thread.sleep(2000);
			sBp.clickToSearch();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry!! Batch ID - "+batchID+" Not Found in Published Section!!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span[1]")).getText(),"Master Trainer");
			//choosing assign assessment agency option
			sBp.clickToViewActionMenuOptions();
			Thread.sleep(2000);
			sBp.clickToChooseAssignAssessmentAgencyOption();
			Thread.sleep(2000);
			sBp.selectOnlyAssessmentAgencyForSEDJobRole(assessmentAgency);
			Thread.sleep(2000);
			sBp.clickSEDAssignButton2();
			Thread.sleep(2000);
			sBp.clickAssignItButton();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+assessmentAgency+".");
			sBp.clickOk();
			Thread.sleep(2000);
			sBp.enterSearchForBatchID(batchID);
			Thread.sleep(2000);
			sBp.clickToSearch();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry!! Batch ID - "+batchID+" Not Found in Published Section!!! ");
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span[1]")).getText().trim()+driver.findElement(By.xpath("//td[7]/span[2]")).getText().trim(), "Master Trainer,Assessment Agency");
		}
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
}
	