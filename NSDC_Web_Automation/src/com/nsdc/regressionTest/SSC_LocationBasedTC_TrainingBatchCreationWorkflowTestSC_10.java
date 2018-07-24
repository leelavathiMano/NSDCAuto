package com.nsdc.regressionTest;

import static org.testng.Assert.assertEquals;

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
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_LocationBasedTC_TrainingBatchCreationPage;
import com.nsdc.testConfig.TestConfiguration;
import com.sun.tools.javac.util.List;


public class SSC_LocationBasedTC_TrainingBatchCreationWorkflowTestSC_10 extends TestConfiguration
{
	@DataProvider
	public Object[][] sscLocationBasedTCTrainingBatchCreationWorkflowData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "BatchCreationTestSC10TC01");
	}
	
	@Test(dataProvider="sscLocationBasedTCTrainingBatchCreationWorkflowData")
	public void sscLocationBasedTCTrainingBatchCreationTC01(String serialNum,String createdBatchIDs,String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String jobRole, String expectedBatchFees, String batchSize, String state, String district, String subDistrict, String trainingCentreID,String actionMenuOptions) throws Exception
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
		sscTbcP.selectTrainingStartDate();
		//Thread.sleep(2000);
		sscTbcP.clickToCloseTrainingStartDateCalender();
		Thread.sleep(2000);
		sscTbcP.selectTrainingEndDate();
		//Thread.sleep(2000);
		sscTbcP.clickToCloseTrainingEndDateCalender();
		Thread.sleep(2000);
		sscTbcP.selectAssessmentStartDate();
		sscTbcP.clickToCloseAssessmentStartDateCalender();
		Thread.sleep(2000);
		sscTbcP.selectAssessmenEndDate();
		sscTbcP.clickToCloseAssessmentEndDateCalender();
		Thread.sleep(2000);
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
		ReadWriteData.setExcelData("./TestData/Workflow/SSC-LocationBasedTC-TrainingBatchCreationWorkflowData.xls", "SSC-LocationBasedTC-TrainingBatchCreationWorkflowDataTestSC10TC01",Integer.parseInt(serialNum) , 1, createdBatchID);
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
		sscTbcP.enterToSearchForTrainingCentreID("TC_000972");
		Thread.sleep(2000);
		sscTbcP.clickActionMenu();
		if(actionMenuOptions.equalsIgnoreCase("view details"))
		{
			sscTbcP.clickViewDetails();
			Thread.sleep(2000);
			sscTbcP.clickToAssignTrainingCentre();
			Thread.sleep(4000);
			
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
			
			sscTbcP.clickToAssignTrainingCentreFinal();
			Thread.sleep(2000);
			sscTbcP.clickOk();
			Thread.sleep(2000);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
			lp.clickLogin();
			elp.performlogin("TC_000972", "Qwerty@123");
			
		}
		
	}
	
	@Test
	public void sscViewDetailsAssigningMasterTrainerAndAssessmentAgencyForBatch() throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin("SSC_4", "Qwerty@123");
		Thread.sleep(2000);
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		Thread.sleep(11000);
		sscDbP.clickAllBatches();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://13.232.121.96/ssc/all-batches");
		//all displayed batches
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
		
		//div[contains(text(),'Apparel')]
		//div[contains(text(),'Apparel')]
		
		
		
	}
}
	
