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
	public void sscLocationBasedTCTrainingBatchCreationTC01(String serialNum,String createdBatchIDs,String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict,String actionMenuOptions) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(10000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://13.232.121.96/ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		sscDbP.clickCreateBatch();
		Thread.sleep(2000);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 8, expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(2000);
		sscTbcP.selectBatchType(batchType);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 3, batchType);
		Thread.sleep(2000);
		sscTbcP.selectJobRole(jobRole);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 7, jobRole);
		Thread.sleep(3000);
		sscTbcP.isFeesReadOnly();
		sscTbcP.clickToViewFees();
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 9, expectedBatchFees);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		Thread.sleep(2000);
		sscTbcP.selectBatchSize(batchSize);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 4, batchSize);
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 5, expectedTrainingStartDateHipen);
		String expectedTrainingEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String expectedAssessmentStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[2]")).getAttribute("value").replaceAll("/", "-");		
		String expectedAssessmentEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[2]")).getAttribute("value");
		String expectedAssessmentEndDateHipen=expectedAssessmentEndDate.replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 6, expectedAssessmentEndDateHipen);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[1]/span")).getText(), expectedTrainingStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[2]/span")).getText(), expectedAssessmentEndDate);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(2000);
		String bacthCreationsuccessfulPopupText=driver.findElement(By.xpath("//div[@class='swal2-content']")).getText();
		String[]parts=bacthCreationsuccessfulPopupText.split(" ");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "BatchCreationTestSC10TC01",Integer.parseInt(serialNum) , 1, createdBatchID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 2, createdBatchID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "ReAssigningTCForRejectedBatchesSC10TC03",Integer.parseInt(serialNum) , 3, createdBatchID);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04",Integer.parseInt(serialNum) , 2, createdBatchID);
		
		if(batchType.equalsIgnoreCase("Training of Assessor-New")||batchType.equalsIgnoreCase("Training of Assessor-Existing")||batchType.equalsIgnoreCase("Training of Master Assessor"))
		{
			ReadWriteData.setExcelData("./TestData/Workflow/Assessor-Workflow.xls","AssessorBatchesForTestSC04TC03",Integer.parseInt(serialNum) , 0, createdBatchID);
		}
		else if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Training of Master Trainer"))
		{
			ReadWriteData.setExcelData("./TestData/Workflow/Trainer-Workflow.xls","TrainerBatchesForTestSC03TC03",Integer.parseInt(serialNum) , 0, createdBatchID);
		}
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
		String trainingCentre=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls", "SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 3);
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls","TrainingCentreAcceptOrRejectBatchesSC10TC02",Integer.parseInt(serialNum) , 0, trainingCentre);
		String trainingCentreName=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls", "SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 4);
		sscTbcP.enterToSearchForTrainingCentreID(trainingCentre);
		Thread.sleep(4000);
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
		SSCAllBatchesPage sscAbP=new SSCAllBatchesPage(driver);
		sscAbP.enterSearchByWord(createdBatchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
		sscAbP.clickToViewPendingBatches();
		Thread.sleep(2000);
		sscAbP.enterSearchByWord(createdBatchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText().trim(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText().trim(), expectedTrainingStartDateHipen);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+trainingCentreName+"')]")).getText().trim(), trainingCentreName);
		Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
		
		//before approval from assign TC - Checking assigning of master trainer and assessment agency as it should not happen
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewActionMenuOptions();
		Thread.sleep(2000);
		sBp.clicktoSelectViewBatchDetailsOption();
		Thread.sleep(2000);
		String masterTrainerName=ReadWriteData.getData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04", 1, 4);
		sBp.selectMasterTrainerForSEDJobrole(masterTrainerName);
		Thread.sleep(2000);
		sBp.clickToAssignMasterTrainer();
		Thread.sleep(2000);
		sBp.clickAssignItButton();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().equals("Can not assign Master Trainer, Batch is pending for approval from Training Centre"), "there is no toast message regarding assigning master trainer before TC Approving the respected batch");
		Thread.sleep(6000);
		String assessmentAgency=ReadWriteData.getData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04", 1, 6);
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
	public Object[][]trainingCentreAcceptOrRejectBatchWorkflowData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "TrainingCentreAcceptOrRejectBatchesSC10TC02");
	}
	@Test(dataProvider="trainingCentreAcceptOrRejectBatchWorkflowData",dependsOnMethods="sscLocationBasedTCTrainingBatchCreationTC01")
	public void trainingCentreAcceptingOrRejectingBatchesTC02(String trainingCentre,String trainingCentrePassword,String createdBatchID, String batchType, String batchSize, String expectedTrainingStartDateHipen, String expectedAssessmentEndDateHipen, String jobRole, String expectedSector, String expectedBatchFees, String LocationBasedTC_AcceptOrRejectBatch, String remarks) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(trainingCentre, trainingCentrePassword);
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		if(driver.findElements(By.tagName("tr")).size()<2)
		{
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Assert.assertFalse(driver.findElements(By.tagName("tr")).size()<2,"Sorry! Batch not found in Newly Assigned Section, may be its already accepted, On-going, Completed, Rejected or it does not exist!!!!! ");		
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+expectedTrainingStartDateHipen+"')]")).getText(), expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen);
			Assert.assertNotSame(driver.findElement(By.xpath("//span[contains(text(),'BATCH CREATED')]")).getText(), "BATCH CREATED");
		}
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		ArrayList<WebElement>actionMenuOptions=(ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='m-dropdown__content'])[2]/ul/li/a/span"));
		for(int i=0;i<actionMenuOptions.size();i++)
		{
			if(actionMenuOptions.get(i).getText().equals("View Batch Details"))
			{
				Assert.assertEquals(actionMenuOptions.get(i).getText(),"View Batch Details","its not a View Batch Details option");
			}
			else if(actionMenuOptions.get(i).getText().equals("Accept/Reject Batch"))
			{
				Assert.assertEquals(actionMenuOptions.get(i).getText(),"Accept/Reject Batch","its not a AcceptOrRejectOption");
			}
		}
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
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		lTcVbP.clickToSelectAcceptOrRejectBatchOption();
		Thread.sleep(2000);
		if(LocationBasedTC_AcceptOrRejectBatch.equalsIgnoreCase("accept"))
		{
			lTcVbP.clickToAcceptBatch();
			Thread.sleep(2000);
			lTcVbP.clickToSaveAndSubmit();
			Thread.sleep(2000);
			lTcVbP.clickOk();
			Thread.sleep(2000);
			lTcVbP.clickToViewAllAcceptedBatches();
			Thread.sleep(2000);
			lTcVbP.enterToSearchForBatchID(createdBatchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			lTcVbP.clikToViewActionMenu();
			Thread.sleep(2000);
			lTcVbP.clikToViewActionMenu();
			Thread.sleep(2000);
			actionMenuOptions=(ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='m-dropdown__content'])[2]/ul/li/a/span"));
			for(int i=0;i<actionMenuOptions.size();i++)
			{
				Assert.assertNotEquals(actionMenuOptions.get(i).getText(),"Accept/Reject Batch");
			}
			lTcVbP.clickToSelectViewBatchDetailsOption();	
			
		}
		else if(LocationBasedTC_AcceptOrRejectBatch.equalsIgnoreCase("reject"))
		{
			lTcVbP.clickToRejectBatch();
			Thread.sleep(2000);
			lTcVbP.enterRemarks(remarks);
			Thread.sleep(2000);
			lTcVbP.clickToSaveAndSubmit();
			Thread.sleep(2000);
			lTcVbP.clickOk();
			Thread.sleep(2000);
			lTcVbP.clickToViewAllRejectedBatches();
			Thread.sleep(2000);
			lTcVbP.clickToViewAllRejectedBatches();
			Thread.sleep(4000);
			lTcVbP.enterToSearchForBatchID(createdBatchID);
			Thread.sleep(4000);
			if(driver.findElements(By.tagName("tr")).size()<2)
			{
				SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
				Thread.sleep(2000);
				Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
				lTcVbP.clikToViewActionMenu();
				actionMenuOptions=(ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='m-dropdown__content'])[2]/ul/li/a/span"));
				for(int i=0;i<actionMenuOptions.size();i++)
				{
					Assert.assertNotEquals(actionMenuOptions.get(i).getText(),"Accept/Reject Batch");
				}
				lTcVbP.clickToSelectViewBatchDetailsOption();
			}
			else
			{
				System.out.println("Training Centre - "+trainingCentre+"Rejected Batches - No show of rejected batch : "+createdBatchID);
			}
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] reAssignLocationBasedTCForBatchesData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "ReAssigningTCForRejectedBatchesSC10TC03");
	}
	@Test(dataProvider="reAssignLocationBasedTCForBatchesData",dependsOnMethods="trainingCentreAcceptingOrRejectingBatchesTC02")
	public void reaasigningLocationBasedTCForAllRejectedBatchesTC03(String sscUserName, String sscPassword,String batchAcceptOrRejectByLocationBasedTC,String batchID,String reAssignYesOrNo,String reScheduleYesOrNo) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://13.232.121.96/ssc","Login Unsuccessfull");
		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sDp.clickAllBatches();
		Thread.sleep(2000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		if(batchAcceptOrRejectByLocationBasedTC.equalsIgnoreCase("reject") && reAssignYesOrNo.equalsIgnoreCase("yes")&&reScheduleYesOrNo.equalsIgnoreCase("no"))
		{
			sBp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Training Centre')]")).getText().trim(),"Training Centre");
			sBp.clickToViewActionMenuOptions();
			sBp.clickToReAssignTrainingCentre();
			Thread.sleep(2000);
			String reAssignTrainingCentre=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls", "SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 3);
			sBp.enterSearchByWord(reAssignTrainingCentre);
			Thread.sleep(2000);
			sBp.clickToViewActionMenuOptions();
			Thread.sleep(2000);
			sBp.clickToAssignBatch();
			Thread.sleep(2000);
			sBp.clickAssignButton();
			Thread.sleep(2000);
			sBp.clickOk();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)", "");
			sDp.clickAllBatches();
			Thread.sleep(2000);			
			sBp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.tagName("tr")).size()<2,"ReassignedTC Batch "+batchID+" should not be listed in Rejected section");
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			
			lp.clickLogin();
			elp.performlogin(reAssignTrainingCentre, "Qwerty@123");
			Thread.sleep(2000);
			LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
			js.executeScript("window.scrollBy(0,200)","");
			lTcDp.clickToViewLocationBasedTrainingBatches();
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,200)","");
			LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
			lTcVbP.enterToSearchForBatchID(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
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
			lTcVbP.clickToViewAllAcceptedBatches();
			Thread.sleep(2000);
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Thread.sleep(2000);
			lTcVbP.enterToSearchForBatchID(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
			lTcVbP.clickToViewAllRejectedBatches();
			Thread.sleep(2000);
			lTcVbP.enterToSearchForBatchID(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
			
		}
		else if(batchAcceptOrRejectByLocationBasedTC.equalsIgnoreCase("reject") && reAssignYesOrNo.equalsIgnoreCase("no")&&reScheduleYesOrNo.equalsIgnoreCase("yes"))
		{
			sBp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Training Centre')]")).getText(),"Training Centre");
			sBp.clickToViewActionMenuOptions();
			sBp.clickToReSchedueBatch();
			Thread.sleep(2000);
			
		}
		else if(batchAcceptOrRejectByLocationBasedTC.equalsIgnoreCase("accept") && reAssignYesOrNo.equalsIgnoreCase("no")&&reScheduleYesOrNo.equalsIgnoreCase("no"))
		{
			sBp.clickToViewPublishedBatches();
			Thread.sleep(2000);
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Self')]")).getText(),"Self");
		}
		else
		{
			System.out.println("please check the input excel sheet - ReAssigningTCForRejectedBatchesSC10TC02, for reassign and reshedule values(*rejected batches can be reassigned Or rescheduled - not both)");
		}
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] sscAssignMasterTrainerAndAssessmentAgencyForBatchData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC04");
	}
	@Test(dataProvider="sscAssignMasterTrainerAndAssessmentAgencyForBatchData")//,dependsOnMethods="reaasigningLocationBasedTCForAllRejectedBatchesTC03")
	public void sscAssigningMasterTrainerAndAssessmentAgencyForBatchTC04(String sscUserName, String sscPassword, String batchID,String actionsMenuOption, String masterTrainerName, String masterTrainerID, String assessmentAgency) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://13.232.121.96/ssc","Login Unsuccessfull");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		PostLoginPage plp=new PostLoginPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://13.232.121.96/ssc/all-batches");
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
		Thread.sleep(2000);
		sBp.enterSearchByWord(batchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Self')]")).getText(),"Self");
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
			SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")), "40");
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span[1]")).getText().trim()+driver.findElement(By.xpath("//td[7]/span[2]")).getText().trim(), "Master Trainer,Assessment Agency");
		}
		else if(actionsMenuOption.equalsIgnoreCase("assign master trainer"))
		{
			sBp.clickToChooseAssignMasterTrainerOption();
			Thread.sleep(2000);
			sBp.selectMasterTrainerForSEDJobrole(masterTrainerName);
			Thread.sleep(2000);
			sBp.clickSEDAssignButton1();
			Thread.sleep(2000);
			sBp.clickAssignItButton();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+masterTrainerID+".");
			sBp.clickOk();
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span[1]")).getText(),"Master Trainer");
		}
		else if(actionsMenuOption.equalsIgnoreCase("assign assessment agency"))
		{
			sBp.clickToChooseAssignAssessmentAgencyOption();
			Thread.sleep(2000);
			sBp.selectAssessmentAgencyForSEDJobRole(assessmentAgency);
			Thread.sleep(2000);
			sBp.clickSEDAssignButton2();
			Thread.sleep(2000);
			sBp.clickAssignItButton();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText(), "Batch Assigned to "+assessmentAgency+".");
			sBp.clickOk();
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span[1]")).getText(),"Assessment Agency");
		}
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
}
	
