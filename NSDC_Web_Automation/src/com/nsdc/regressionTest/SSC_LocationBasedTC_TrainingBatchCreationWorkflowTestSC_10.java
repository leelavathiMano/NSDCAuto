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
	
	@Test(dataProvider="sscLocationBasedTCTrainingBatchCreationWorkflowData",priority=1)
	public void sscLocationBasedTCTrainingBatchCreationTC01(String serialNum,String createdBatchIDs,String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict,String actionMenuOptions, String LocationBasedTC_AcceptOrRejectBatch, String remarks) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(2000);
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(2000);
		sscDbP.clickCreateBatch();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='form-group m-form__group row']/div[2]")).getText(), expectedSector);
		SSC_LocationBasedTC_TrainingBatchCreationPage sscTbcP=new SSC_LocationBasedTC_TrainingBatchCreationPage(driver);
		sscTbcP.selectSubSector(subSector);
		Thread.sleep(4000);
		sscTbcP.selectBatchType(batchType);
		Thread.sleep(2000);
		sscTbcP.selectJobRole(jobRole);
		Thread.sleep(2000);
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
		
		String expectedTrainingStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[1]")).getAttribute("value");
		String expectedTrainingStartDateHipen=expectedTrainingStartDate.replaceAll("/", "-");
		String expectedTrainingEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String expectedAssessmentStartDate=driver.findElement(By.xpath("(//input[@id='startDate'])[2]")).getAttribute("value").replaceAll("/", "-");		
		String expectedAssessmentEndDate=driver.findElement(By.xpath("(//input[@id='endDate'])[2]")).getAttribute("value");
		String expectedAssessmentEndDateHipen=expectedAssessmentEndDate.replaceAll("/", "-");
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[2]/span")).getText(), expectedTrainingStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@formgroupname='batchDates']/div[3]/span")).getText(), expectedAssessmentEndDate);
		sscTbcP.clickToCreateBatch();
		Thread.sleep(2000);
		String bacthCreationsuccessfulPopupText=driver.findElement(By.xpath("//div[@class='swal2-content']")).getText();
		String[]parts=bacthCreationsuccessfulPopupText.split(" ");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "BatchCreationTestSC10TC01",Integer.parseInt(serialNum) , 1, createdBatchID);
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
		String trainingCentre=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls", "SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 3);
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
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		lp.clickLogin();
		elp.performlogin(trainingCentre, "Qwerty@123");
		Thread.sleep(2000);
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		Thread.sleep(4000);
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchType+"')]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchSize+"']")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen+"']")).getText(), expectedTrainingStartDateHipen+" to "+expectedAssessmentEndDateHipen);
		Assert.assertNotSame(driver.findElement(By.xpath("//span[contains(text(),'BATCH CREATED')]")).getText(), "BATCH CREATED");
		Thread.sleep(4000);
		lTcVbP.clikToViewActionMenu();
		Thread.sleep(2000);
		ArrayList<WebElement>checkObsenceOfAcceptOrRejectBatchMenuOptions=(ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='m-dropdown__content'])[2]/ul/li/a/span"));
		for(int i=0;i<checkObsenceOfAcceptOrRejectBatchMenuOptions.size();i++)
		{
			if(checkObsenceOfAcceptOrRejectBatchMenuOptions.get(i).getText().equals("View Batch Details"))
			{
				Assert.assertNotEquals(checkObsenceOfAcceptOrRejectBatchMenuOptions.get(i).getText(),"Accept/Reject Batch","its a AcceptOrRejectOption");
			}
			else if(checkObsenceOfAcceptOrRejectBatchMenuOptions.get(i).getText().equals("Accept/Reject Batch"))
			{
				Assert.assertEquals(checkObsenceOfAcceptOrRejectBatchMenuOptions.get(i).getText(),"Accept/Reject Batch","its not a AcceptOrRejectOption");
			}
			
		}
		lTcVbP.clickToSelectViewBatchDetailsOption();
		Thread.sleep(2000);
		//Asserting Batch Details
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+jobRole+"')]")).getText(), jobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedSector+"')]")).getText(), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+expectedBatchFees+"')]")).getText(), expectedBatchFees);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='tab-content'])[2]/div[6]/div[2]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'"+batchType+"')]")).getText(), batchType);
		lTcVbP.clickToGoToDashboard();
		Thread.sleep(2000);
		lTcDp.clickToViewLocationBasedTrainingBatches();
		Thread.sleep(2000);
		lTcVbP.enterToSearchForBatchID(createdBatchID);
		js.executeScript("window.scrollBy(0,200)","");
		lTcVbP.clikToViewActionMenu();
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
			checkObsenceOfAcceptOrRejectBatchMenuOptions=(ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='m-dropdown__content'])[2]/ul/li/a/span"));
			for(int i=0;i<checkObsenceOfAcceptOrRejectBatchMenuOptions.size();i++)
			{
				Assert.assertNotEquals(checkObsenceOfAcceptOrRejectBatchMenuOptions.get(i).getText(),"Accept/Reject Batch");
			}
			lTcVbP.clickToSelectViewBatchDetailsOption();	
			//Again Login As SSC_4 to check For the status of Accepted and Rejected Batches by Location Based TC
			Thread.sleep(2000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			lp.clickLogin();
			Thread.sleep(2000);
			elp.performlogin(sscUsername, sscPassword);
			Thread.sleep(2000);
			sscDbP.clickAllBatches();
			Thread.sleep(2000);
			SSCAllBatchesPage sscAbP=new SSCAllBatchesPage(driver);
			sscAbP.enterSearchByWord(createdBatchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Self')]")).getText(),"Self");
			sscAbP.clickToViewPendingBatches();
			Thread.sleep(2000);
			sscAbP.enterSearchByWord(createdBatchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Self')]")).getText(),"Self");
			sscAbP.clickToViewPublishedBatches();
			Thread.sleep(2000);
			sscAbP.enterSearchByWord(createdBatchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Self')]")).getText(),"Self");
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
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
			Thread.sleep(4000);
			lTcVbP.enterToSearchForBatchID(createdBatchID);
			Thread.sleep(4000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			lTcVbP.clikToViewActionMenu();
			checkObsenceOfAcceptOrRejectBatchMenuOptions=(ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='m-dropdown__content'])[2]/ul/li/a/span"));
			for(int i=0;i<checkObsenceOfAcceptOrRejectBatchMenuOptions.size();i++)
			{
				Assert.assertNotEquals(checkObsenceOfAcceptOrRejectBatchMenuOptions.get(i).getText(),"Accept/Reject Batch");
			}
			lTcVbP.clickToSelectViewBatchDetailsOption();
			//Again Login As SSC_4 to check For the status-Training Centre of Rejected Batches by Location Based TC
			Thread.sleep(2000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			lp.clickLogin();
			Thread.sleep(2000);
			elp.performlogin(sscUsername, sscPassword);
			Thread.sleep(2000);
			sscDbP.clickAllBatches();
			Thread.sleep(2000);
			SSCAllBatchesPage sscAbP=new SSCAllBatchesPage(driver);
			sscAbP.enterSearchByWord(createdBatchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
			sscAbP.clickToViewPendingBatches();
			Thread.sleep(2000);
			sscAbP.enterSearchByWord(createdBatchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Training Centre')]")).getText().trim(),"Training Centre");
			sscAbP.clickToViewRejectedBatches();
			Thread.sleep(2000);
			sscAbP.enterSearchByWord(createdBatchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+createdBatchID+"')]")).getText(),createdBatchID);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[contains(text(),'Training Centre')])[1]")).getText().trim(),"Training Centre");
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		}
	}
	
	@DataProvider
	public Object[][] reAssignLocationBasedTCForBatchesData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "ReAssigningTCForRejectedBatchesSC10TC02");
	}
	@Test(dataProvider="reAssignLocationBasedTCForBatchesData",dependsOnMethods="sscLocationBasedTCTrainingBatchCreationTC01")
	public void reaasigningLocationBasedTCForAllRejectedBatches(String sscUserName, String sscPassword,String batchAcceptOrRejectByLocationBasedTC,String batchID,String reAssignYesOrNo,String reScheduleYesOrNo) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(2000);
		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
		Thread.sleep(8000);
		sDp.clickAllBatches();
		Thread.sleep(2000);
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		if(batchAcceptOrRejectByLocationBasedTC.equalsIgnoreCase("reject") && reAssignYesOrNo.equalsIgnoreCase("yes")&&reScheduleYesOrNo.equalsIgnoreCase("no"))
		{
			sBp.clickToViewRejectedBatches();
			Thread.sleep(2000);
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Training Centre')]")).getText().trim(),"Training Centre");
			sBp.clickActionButton();
			sBp.clickToReAssignTrainingCentre();
			Thread.sleep(2000);
			String reAssignTrainingCentre=ReadWriteData.getData("./TestData/Workflow/SSC_TemporaryTrainingCentreCreationData.xls", "SSC_TemporaryTrainingCentreCreationSC09TC01", 1, 3);
			sBp.enterSearchByWord(reAssignTrainingCentre);
			Thread.sleep(2000);
			sBp.clickActionButton();
			Thread.sleep(2000);
			sBp.clickToAssignBatch();
			Thread.sleep(2000);
			sBp.clickAssignButton();
			Thread.sleep(2000);
			sBp.clickOk();
			Thread.sleep(2000);
			try 
			{
				sBp.clickToViewRejectedBatches();
				Thread.sleep(2000);
				sBp.enterSearchByWord(batchID);
				Thread.sleep(2000);
				driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).isEmpty();
				
			}catch(Exception e)
			{
				System.out.println("Batch ID - "+batchID+"still present in Rejected Section after Re Assignning Training Centre");
			}
			
			Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+batchID+"')]")).isEmpty(), "Batch ID - "+batchID+"still present in Rejected Section after Re Assignning Training Centre");
			
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			
			lp.clickLogin();
			elp.performlogin(reAssignTrainingCentre, "Qwerty@123");
			Thread.sleep(2000);
			LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
			Thread.sleep(4000);
			lTcDp.clickToViewLocationBasedTrainingBatches();
			Thread.sleep(4000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)","");
			LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
			lTcVbP.enterToSearchForBatchID(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
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
			Thread.sleep(2000);
			lTcVbP.clickToViewAllAcceptedBatches();
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
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Training Centre')]")).getText(),"Training Centre");
			sBp.clickActionButton();
			sBp.clickToReSchedueBatch();
			Thread.sleep(2000);
			
		}
		else if(batchAcceptOrRejectByLocationBasedTC.equalsIgnoreCase("accept") && reAssignYesOrNo.equalsIgnoreCase("no")&&reScheduleYesOrNo.equalsIgnoreCase("no"))
		{
			sBp.clickToViewPublishedBatches();
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
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "AssigningMasterTrainerAndAssessmentAgencySC10TC03");
	}
	@Test(dataProvider="sscAssignMasterTrainerAndAssessmentAgencyForBatchData")//,dependsOnMethods="reaasigningLocationBasedTCForAllRejectedBatches")
	public void sscAssigningMasterTrainerAndAssessmentAgencyForBatch(String sscUserName, String sscPassword, String batchID,String actionsMenuOption, String masterTrainerName, String masterTrainerID, String assessmentAgency) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUserName, sscPassword);
		Thread.sleep(2000);
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		PostLoginPage plp=new PostLoginPage(driver);
		Thread.sleep(10000);
		sscDbP.clickAllBatches();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://13.232.121.96/ssc/all-batches");
		SSCAllBatchesPage sBp=new SSCAllBatchesPage(driver);
		Thread.sleep(2000);
		sBp.clickToViewPublishedBatches();
		Thread.sleep(2000);
		sBp.enterSearchByWord(batchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+batchID+"')]")).getText(),batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Self')]")).getText(),"Self");
		sBp.clickActionButton();
		Thread.sleep(2000);
		if(actionsMenuOption.equalsIgnoreCase("view details"))
		{
			sBp.clickViewBatchButton();
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
			sBp.enterSearchByWord(batchID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span/span[1]")).getText()+driver.findElement(By.xpath("//td[7]/span/span[2]")).getText(), "Master Trainer,Assessment Agency");
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
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span/span[1]")).getText(),"Master Trainer");
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
			Assert.assertEquals(driver.findElement(By.xpath("//td[7]/span/span[1]")).getText(),"Assessment Agency");
		}
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
		
	/*	all displayed batches
		List<WebElement>batches=(List<WebElement>) driver.findElements(By.xpath("//table[@class='table table-bordered table-margin']/tbody/tr/td"));
		ArrayList<String>batchIDs = new ArrayList<String>();
		for(int i=0;i<batches.size();i++)
		{
			batchIDs.add(batches.get(i).getText());
			System.out.println(batches.get(i).getText());
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)","");
		driver.findElement(By.xpath("(//a[@class='m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle'])[2]")).click();
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='m-nav'])[1]/li[1]")).click();
		String viewDetailsLink=driver.getCurrentUrl();
		String[] partss=viewDetailsLink.split("/");
		String batchID=partss[partss.length-1];
		System.out.println("selected Batch ID is: "+batchID);
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[3]/tr[1]/td[2]")).getText(),"TP38");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[3]/tr[2]/td[2]")).getText(), "TC_000024");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[3]/tr[4]/td[2]")).getText(), "Sit perferendis deleniti conse");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[3]/tr[5]/td[2]")).getText(), "NICOBARS");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[3]/tr[6]/td[2]")).getText(), "ANDAMAN AND NICOBAR ISLANDS");
		//Training Centre setails
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[4]/tr[1]/td[2]")).getText(), "vvvvvvv");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[4]/tr[2]/td[2]")).getText(), "4555555555");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[4]/tr[3]/td[2]")).getText(), "cv@gmail.com");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[4]/tr[4]/td[2]")).getText(), "priya");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[4]/tr[5]/td[2]")).getText(), "1234567890");
		Assert.assertEquals(driver.findElement(By.xpath("(//table[@class='table']/tbody)[4]/tr[6]/td[2]")).getText(), "priya@priya.priya");
		SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]")), "Priya Tripathi");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Yes, assign it!']")).click();
		Thread.sleep(2000);
		String assignedMasterTrainerPopupText=driver.findElement(By.id("swal2-content")).getText();
		String[] parts=assignedMasterTrainerPopupText.split(" ");
		String assignedMasterTrainerID=parts[parts.length-1];
		System.out.println("assigned Master Trainer is: "+assignedMasterTrainerID);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		SelectDropDownList.selectDropDownListByVisibleText(driver.findElement(By.xpath("(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")), "AA_000001");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Yes, assign it!']")).click();
		Thread.sleep(2000);
		String assignedAssessmentAgencyPopupText=driver.findElement(By.id("swal2-content")).getText();
		String[] parts1=assignedMasterTrainerPopupText.split(" ");
		String assignedAssessmentAgencyID=parts[parts1.length-1];
		System.out.println("assigned Assessment Agency is: "+assignedAssessmentAgencyID);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Back']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search by keyword']")).sendKeys(batchID);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//table[@class='table table-bordered table-margin']/tbody/tr[1]/td[7]")).getText(),"Master Trainer, Assessment Agency");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	*/
	}
}
	
