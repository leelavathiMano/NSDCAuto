package com.nsdc.regressionTest;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.SSCBatchAnnouncementPage;
import com.nsdc.pages.SSCDashboardPage;
import com.nsdc.pages.TrainerBatchDetailsPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainingCentreDashboardPage;
import com.nsdc.pages.TrainingCentreViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class SSCBatchCreationTestSC_05 extends TestConfiguration {
	
	public String id;

	 @DataProvider
	    public Object[][] ssc_BatchCreation()
	    {
	        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/BatchCreation-Workflow.xls", "SSCSC04TC04");
	    }
	  
	    @Test(dataProvider="ssc_BatchCreation")
	    public void createBatch(String sno,String subSector,String batchType, String jobRole,String batchSize,String training_from, String training_to,String assessment_from,String assessment_to,String state,String district,String sub_district,String training_Centre_Id,String Batchid) throws Exception
	    {		
		    Thread.sleep(2000);
		    LoginPage lp = new LoginPage(driver);
		    lp.clickLogin();
		    EnterLoginPage elp = new EnterLoginPage(driver);
		    elp.performlogin("SSC_4", "Qwerty@123");
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
			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			//Date date = new Date();
			//System.out.println(dateFormat.format(date));
			//Calendar cal= Calendar.getInstance();
			//cal.add(Calendar.DATE, 15);
			Thread.sleep(3000);
			sbap.enterTrainingToDate(training_to);
			Thread.sleep(3000);
			sbap.enterAssessmentFromDate(assessment_from);
			Thread.sleep(3000);
			sbap.enterAssessmentToDate(assessment_to);
			Thread.sleep(3000);
			if(batchType.equals("Training of Trainer-New") || batchType.equals("Training of Assessor-New")) 
			{
			Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m-form__help'])[3]")).getText(), training_from);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m-form__help'])[4]")).getText(), assessment_to);
			Thread.sleep(2000);
			}
			else if(batchType.equals("Training of Trainer-Existing") || batchType.equals("Training of Assessor-Existing")) 
			{
			Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m-form__help'])[2]")).getText(), training_from);
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='m-form__help'])[3]")).getText(), assessment_to);
			Thread.sleep(2000);
			}
			sbap.clickCreateBatchButton();
			String batchid = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText();
			id = batchid.replace("Batch Id - ", "");
			System.out.println(id);
			Thread.sleep(2000);
			ReadWriteData.setExcelData("./TestData/Workflow/BatchCreation-Workflow.xls", "SSCSC04TC04", Integer.parseInt(sno), 13, id);
			Thread.sleep(2000);
			sbap.clickOkBatchIdButton();
			//Assert.assertEquals(driver.findElement(By.xpath("//input[@ng-reflect-model='Apparel']")).getAttribute("value"),"Apparel");
			//Assert.assertEquals(driver.findElement(By.xpath("//input[@ng-reflect-model='Garment Manufacturing']")).getAttribute("value"),subSector);
			sbap.selectStateDropDownList(state);
			sbap.selectDistrictDropDownList(district);
			sbap.selectSubDistrictDropDownList(sub_district);
			Thread.sleep(3000);
			sbap.clickSearchButton();
			Thread.sleep(8000);
			sbap.clickLastPageButton();
			Thread.sleep(9000);
			sbap.enterTrainingCentreID(training_Centre_Id);
			Thread.sleep(3000);
			sbap.clickActionButton();
			Thread.sleep(2000);
			sbap.clickAssignBatchButton();
			Thread.sleep(2000);
			sbap.clickAssignButton();
			Thread.sleep(2000);
			//Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'You have Assigned the Training Centre for Training batch announcement Successfully.')]")).getText(), "You have Assigned the Training Centre for Training batch announcement Successfully.\r\n" + 
		    //"Please wait while we get response from Training Centre");
			 sbap.clickOkButton();
             Thread.sleep(3000);
             SSCDashboardPage sdp1 = new SSCDashboardPage(driver);
 			 sdp1.clickAllBatchesCard();
             sbap.clickLogoutLogoButton();
             Thread.sleep(3000);
             sbap.clickLogoutButton();
			 Thread.sleep(2000);
			 LoginPage lp1 = new LoginPage(driver);
			 lp1.clickLogin();
			 EnterLoginPage elp1 = new EnterLoginPage(driver);
			 elp1.performlogin("TC_000024", "Qwerty@123");
			 Thread.sleep(11000);
			 TrainingCentreDashboardPage tcdp = new TrainingCentreDashboardPage(driver);
				tcdp.clickViewBatchCard();
				Thread.sleep(4000);
				TrainingCentreViewBatchesPage tcvbp =new TrainingCentreViewBatchesPage(driver);
				tcvbp.enterBatchId(id);
				Thread.sleep(7000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("scroll(0, 600)");
				tcvbp.clickActionForNewlyAssignedButton();
				Thread.sleep(8000);
				tcvbp.clickViewBatchdetailsForNewlyAssignedButton();
				Thread.sleep(5000);
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Batch Job Role')]]/div/div/span[contains(text(),'JHG')]")).getText(), "JHG");
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Associated Skill Sector Council')]]/div[contains(text(),'Apparel')]")).getText(), "Apparel");
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Assigned Master Trainer:')]]/div/span[contains(text(),'Master Trainer Data Unavailable')]")).getText(),"Master Trainer Data Unavailable");
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Assigned Master Assessor:')]]/div/span[contains(text(),'Assessor Data Unavailable')]")).getText(),"Master Assessor Data Unavailable");
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Training Fees to Be Paid:')]]/div[contains(text(),'7000')]")).getText(),"7000");
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Batch Size:')]]/div[contains(text(),'3)]")).getText(),"3");
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Candidates Enrolled:')]]/div/span[contains(text(),'0')]")).getText(),"0");
				//Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Batch Type:')]]/div[contains(text(),'Training of Assessor-New')]")).getAttribute("value"),"Training of Assessor-New");
				//Thread.sleep(5000);
	            driver.navigate().back();
	            Thread.sleep(3000);
	            tcvbp.clickActionForNewlyAssignedButton();
				Thread.sleep(8000);
	            tcvbp.clickAcceptOrRejectButton();
	            Thread.sleep(3000);
	            tcvbp.clickAcceptRadioButton();
	            Thread.sleep(2000);
	            tcvbp.clickSaveAndSubmitButton();
	            Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Updated Successfully']")).getText(),"Updated Successfully");
	            tcvbp.clickOkButton();
	            tcvbp.clickLogoutLogoButton();
	             Thread.sleep(3000);
	             tcvbp.clickLogoutButton();
				
				 
				 
		}
	    @DataProvider
	    public Object[][] Trainer_BatchAcceptance()
	    {
	        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/BatchCreation-Workflow.xls", "TRSC04TC06");
	    }
	  
	    @Test(dataProvider="Trainer_BatchAcceptance")
	    public void TrainerAppliedForBatch(String state,String district,String subDistrict, String sector,String subSector,String jobRole, String batchType,String batchStatus,String batch_StartDate,String batch_EndDate) throws Exception
	    {	
		    Thread.sleep(2000);
			 LoginPage lp11 = new LoginPage(driver);
			 lp11.clickLogin();
			 EnterLoginPage elp11 = new EnterLoginPage(driver);
			 elp11.performlogin("TR29", "Qwerty@123");
			 Thread.sleep(11000);
			 TrainerDashboardPage trdp = new TrainerDashboardPage(driver);
			 trdp.clickSearchAndApplyCard();
			 Thread.sleep(3000);
			 TrainerBatchDetailsPage tbp = new TrainerBatchDetailsPage(driver);
			 tbp.selectState(state);
			 tbp.selectDistrict(district);
			 tbp.selectSubDistrict(subDistrict);
			 tbp.selectSector(sector);
			 tbp.selectSubSector(subSector);
			 tbp.selectJobRole(jobRole);
			 tbp.selectBatchType(batchType);
			 tbp.selectBatchStatus(batchStatus);
			 tbp.enterBatchStartDate(batch_StartDate);
			 tbp.enterBatchEndDate(batch_EndDate);
			 tbp.clickSearchButton();
			 Thread.sleep(3000);
			 String Search_by_keyword = ReadWriteData.getData("./TestData/Workflow/BatchCreation-Workflow.xls", "SSCSC04TC04", 1, 13);
			 System.out.println(Search_by_keyword);
			 tbp.enterSearchByKeyword(Search_by_keyword);
			 Thread.sleep(3000);
			 tbp.clickActionButton();
			 Thread.sleep(3000);
			 tbp.clickApplyToTheBatchButton();
			 Thread.sleep(3000);
			 Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Applied to the Batch Successfully']")).getText(),"Applied to the Batch Successfully");
			 tbp.clickOkButton();
			 Thread.sleep(3000);
	    }
	     
	    @Test()
	    public void TrainingCentreApprovedTrainer() throws Exception 
	    {Thread.sleep(2000);
		 LoginPage lp1 = new LoginPage(driver);
		 lp1.clickLogin();
		 EnterLoginPage elp1 = new EnterLoginPage(driver);
		 elp1.performlogin("TC_000024", "Qwerty@123");
		 Thread.sleep(11000);
		 TrainingCentreDashboardPage tcdp = new TrainingCentreDashboardPage(driver);
			tcdp.clickViewBatchCard();
			Thread.sleep(4000);
			TrainingCentreViewBatchesPage tcvbp =new TrainingCentreViewBatchesPage(driver);
			tcvbp.clickAcceptedTab();
			 String search_By_Id = ReadWriteData.getData("./TestData/Workflow/BatchCreation-Workflow.xls", "SSCSC04TC04", 1, 13);
			 System.out.println(search_By_Id);
			 tcvbp.enterBatchIdForAccepted(search_By_Id);
			 Thread.sleep(4000);
			 tcvbp.clickActionForAcceptedButton();
			 Thread.sleep(2000);
			 tcvbp.clickViewBatchDetailsForAcceptedTab();
			 Thread.sleep(2000);
			 tcvbp.clickAppliedCandidatesTab();
			 Thread.sleep(4000);
			 tcvbp.clickVerifyAndApproveButton();
			 Thread.sleep(4000);
			 tcvbp.clickEducationAndWorkTab();
			 Thread.sleep(3000);
			 tcvbp.clickApprovedCandidatesButton();
			 Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Candidate approved successfully']")).getText(),"Candidate approved successfully");
			tcvbp.clickOkForApprovingCandidatesButton();
			 Thread.sleep(3000);
			 tcvbp.clickLogoutLogoButton();
             Thread.sleep(3000);
             tcvbp.clickLogoutButton();
             Thread.sleep(2000);
 		    LoginPage lp = new LoginPage(driver);
 		    lp.clickLogin();
 		    EnterLoginPage elp = new EnterLoginPage(driver);
 		    elp.performlogin("SSC_4", "Qwerty@123");
 		    Thread.sleep(11000);
 			SSCDashboardPage sdp = new SSCDashboardPage(driver);
 			sdp.clickAllBatchesCard();
			 
	    }
	  

}
