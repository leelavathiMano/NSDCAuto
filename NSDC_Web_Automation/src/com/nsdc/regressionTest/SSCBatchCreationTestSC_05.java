package com.nsdc.regressionTest;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.SSCBatchAnnouncementPage;
import com.nsdc.pages.SSCDashboardPage;
import com.nsdc.pages.TrainingCentreDashboardPage;
import com.nsdc.pages.TrainingCentreViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class SSCBatchCreationTestSC_05 extends TestConfiguration {
	
	
	 @DataProvider
	    public Object[][] ssc_BatchCreation()
	    {
	        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/BatchCreation-Workflow.xls", "SSCSC04TC04");
	    }
	  
	    @Test(dataProvider="ssc_BatchCreation")
	    public void createBatch(String subSector,String batchType, String jobRole,String batchSize,String training_from, String training_to,String assessment_from,String assessment_to,String state,String district,String sub_district,String training_Centre_Id) throws Exception
	    {		
		    Thread.sleep(2000);
		    LoginPage lp = new LoginPage(driver);
		    lp.clickLogin();
		    EnterLoginPage elp = new EnterLoginPage(driver);
		    elp.performlogin("SSC_4", "ekaushal");
		    Thread.sleep(11000);
			SSCDashboardPage sdp = new SSCDashboardPage(driver);
			sdp.clickCreateBatchCard();
			Thread.sleep(4000);
			SSCBatchAnnouncementPage sbap = new SSCBatchAnnouncementPage(driver);
			sbap.selectSubSector(subSector);
			sbap.selectBatchType(batchType);
			sbap.selectJobRoleDropDownList(jobRole);
			sbap.selectBatchSizeDropDownList(batchSize);
			sbap.enterTrainingFromDate(training_from);
			Thread.sleep(5000);
			sbap.enterTrainingToDate(training_to);
			Thread.sleep(5000);
			sbap.enterAssessmentFromDate(assessment_from);
			Thread.sleep(5000);
			sbap.enterAssessmentToDate(assessment_to);
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m-form__help'])[3]")).getText(), training_from);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m-form__help'])[4]")).getText(), assessment_to);
			Thread.sleep(2000);
			sbap.clickCreateBatchButton();
			Assert.assertEquals(driver.findElement(By.xpath("//input[@ng-reflect-model='Apparel']")).getAttribute("value"),"Apparel");
			Assert.assertEquals(driver.findElement(By.xpath("//input[@ng-reflect-model='Garment Manufacturing']")).getAttribute("value"),subSector);
			sbap.selectStateDropDownList(state);
			sbap.selectDistrictDropDownList(district);
			sbap.selectSubDistrictDropDownList(sub_district);
			Thread.sleep(3000);
			sbap.clickSearchButton();
			Thread.sleep(3000);
			sbap.enterTrainingCentreID(training_Centre_Id);
			sbap.clickActionButton();
			Thread.sleep(2000);
			sbap.clickAssignBatchButton();
			Thread.sleep(2000);
			sbap.clickAssignButton();
			Thread.sleep(2000);
			//Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='You have Assigned the Training Centre for Training batch announcement Successfully.']")).getText(), "You have Assigned the Training Centre for Training batch announcement Successfully.");
			sbap.clickOkButton();
		}
	     
	    @DataProvider
	    public Object[][] tc_acceptBatches()
	    {
	        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/BatchCreation-Workflow.xls", "TCSC04TC05");
	    }
	  
	    @Test(dataProvider="tc_acceptBatches")
	    public void trainingCentreAcceptsBatch(String search_By_Id) throws Exception
	    {
		    Thread.sleep(2000);
		    LoginPage lp = new LoginPage(driver);
		    lp.clickLogin();
		    EnterLoginPage elp = new EnterLoginPage(driver);
		    elp.performlogin("TC_000024", "ekaushal");
		    Thread.sleep(11000);
			TrainingCentreDashboardPage tcdp = new TrainingCentreDashboardPage(driver);
			tcdp.clickViewBatchCard();
			Thread.sleep(4000);
			TrainingCentreViewBatchesPage tcvbp =new TrainingCentreViewBatchesPage(driver);
			tcvbp.enterBatchId(search_By_Id);
			Thread.sleep(7000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("scroll(0, 600)");
			tcvbp.clickActionButton();
			Thread.sleep(8000);
			tcvbp.clickViewBatchdetailsButton();
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Batch Job Role')]]/div/div/span[contains(text(),'JHG')]")).getText(), "JHG");
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Associated Skill Sector Council')]]/div[contains(text(),'Apparel')]")).getText(), "Apparel");
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Assigned Master Trainer:')]]/div/span[contains(text(),'Master Trainer Data Unavailable')]")).getText(),"Master Trainer Data Unavailable");
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Assigned Master Assessor:')]]/div/span[contains(text(),'Assessor Data Unavailable')]")).getText(),"Master Assessor Data Unavailable");
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Training Fees to Be Paid:')]]/div[contains(text(),'7000')]")).getText(),"7000");
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Batch Size:')]]/div[contains(text(),'3)]")).getText(),"3");
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Candidates Enrolled:')]]/div/span[contains(text(),'0')]")).getText(),"0");
			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Batch Type:')]]/div[contains(text(),'Training of Assessor-New')]")).getAttribute("value"),"Training of Assessor-New");
			Thread.sleep(5000);
            driver.navigate().back();
            Thread.sleep(3000);
            tcvbp.clickAcceptAndRejectButton();
            Thread.sleep(2000);
            tcvbp.clickAcceptRadioButton();
            Thread.sleep(2000);
            tcvbp.clickSaveAndSubmitButton();
            Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Updated Successfully']")).getText(),"Updated Successfully");
            tcvbp.clickOkButton();
	    }


}
