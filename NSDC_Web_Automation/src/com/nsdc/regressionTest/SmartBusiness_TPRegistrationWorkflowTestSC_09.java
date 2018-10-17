package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.NSDCAdmin_DashboardPage;
import com.nsdc.pages.NSDC_TPFormReviewPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SmartAdmin_DashboardPage;
import com.nsdc.pages.SmartAdmin_TPFormReviewPage;
import com.nsdc.pages.SmartBusiness_DashboardPage;
import com.nsdc.pages.SmartBusiness_TPSetupReviewPage;
import com.nsdc.testConfig.TestConfiguration;

public class SmartBusiness_TPRegistrationWorkflowTestSC_09 extends TestConfiguration
{
	public String effective_date;
	
	@DataProvider
	public Object[][] smartBusinessTPRegistrationRuleSetUpData()
	{
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTPRuleSC09TC04");
    }
	
	@Test(dataProvider="smartBusinessTPRegistrationRuleSetUpData")
	public void smartBusinessTPRuleSetupTC_01(String sno, String sbUsername, String sbPassword, String registrationFee, String registrationFeeAmount, String unBlockingFee, String unBlockingFeeAmount, String gregistrationFee, String gregistrationFeeAmount, String gunBlockingFee, String gunBlockingFeeAmount, String first_TPType, String first_RegistrationFee, String first_RegistrationFeeAmount, String first_UNBlockingFee, String first_UNBlockingFeeAmount, String second_TPType, String second_RegistrationFee, String second_RegistrationFeeAmount, String second_UNBlockingFee, String second_UNBlockingFeeAmount, String third_TPType, String third_RegistrationFee, String third_RegistrationFeeAmount, String third_UNBlockingFee, String third_UNBlockingFeeAmount, String blockAttemptNumber, String durationOfBlock, String daysForDesktopAssessment, String effective_date) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(sbUsername, sbPassword);
		SmartBusiness_DashboardPage sbd = new SmartBusiness_DashboardPage(driver);
		Thread.sleep(8000);
		sbd.clickOnTPRegistrationSetup();
		SmartBusiness_TPSetupReviewPage sbtp = new SmartBusiness_TPSetupReviewPage(driver);
		if(registrationFee.equals("Yes")) 
		{
			sbtp.selectRegistrationFeeForRegularTP(registrationFee);
			sbtp.enterRegistrationFeeAmountForRegularTP(registrationFeeAmount);
		}
		else if(registrationFee.equals("No"))
		{
			sbtp.selectRegistrationFeeForRegularTP(registrationFee);
		}
		if(unBlockingFee.equals("Yes"))
		{
			sbtp.selectUNBlockingFeeForRegularTP(unBlockingFee);
			sbtp.enterUNBlockingFeeAmountForRegularTP(unBlockingFeeAmount);	
		}
		else if(unBlockingFee.equals("No"))
		{
			sbtp.selectUNBlockingFeeForRegularTP(unBlockingFee);
		}
		if(gregistrationFee.equals("Yes"))
		{
			sbtp.selectRegistrationFeeForGovernmentTP(gregistrationFee);
			sbtp.enterRegistrationFeeAmountForGovernmentTP(gregistrationFeeAmount);
		}
		else if(gregistrationFee.equals("No"))
		{
			sbtp.selectRegistrationFeeForGovernmentTP(gregistrationFee);
		}
		if(gunBlockingFee.equals("Yes"))
		{
			sbtp.selectUNBlockingFeeForGovernmentTP(gunBlockingFee);
			sbtp.enterUNBlockingFeeAmountForGovernmentTP(gunBlockingFeeAmount);
		}
		else if(gunBlockingFee.equals("No"))
		{
			sbtp.selectUNBlockingFeeForGovernmentTP(gunBlockingFee);
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(900, 0)");
		sbtp.clickOnAddAnotherTP();
		Thread.sleep(3000);
		sbtp.enterTrainingPartnerType(first_TPType);
		if(first_RegistrationFee.equals("Yes"))
		{
			sbtp.selectFirst_TPRegistrationFee(first_RegistrationFee);
			Thread.sleep(3000);
			//sbtp.enterFirst_TPRegistrationFeeAmount(first_RegistrationFeeAmount);
			sbtp.enterRegistrationFeeAmount(first_RegistrationFeeAmount);
		}
		else
		{
			sbtp.selectFirst_TPRegistrationFee(first_RegistrationFee);
		}
		if(first_UNBlockingFee.equals("Yes"))
		{
			sbtp.selectFirst_TPUNBlockingFee(first_UNBlockingFee);
			Thread.sleep(3000);
			//sbtp.enterFirst_TPUNBlockingFeeAmount(first_UNBlockingFeeAmount);
			sbtp.enterUnblockingFeeAmount(first_UNBlockingFeeAmount);
		}
		else
		{
			sbtp.selectFirst_TPUNBlockingFee(first_UNBlockingFee);
		}
		Thread.sleep(3000);
		sbtp.clickOnSaveAndSubmit();
		JavascriptExecutor jvs = (JavascriptExecutor) driver;
		jvs.executeScript("scroll(900, 0)");
		Thread.sleep(3000);
		sbtp.clickOnAddAnotherTP();
		Thread.sleep(3000);
		sbtp.enterTrainingPartnerType(second_TPType);
		if(second_RegistrationFee.equals("Yes"))
		{
			sbtp.selectSecond_TPRegistrationFee(second_RegistrationFee);
			Thread.sleep(3000);
			//sbtp.enterSecond_TPRegistrationFeeAmount(second_RegistrationFeeAmount);
			sbtp.enterRegistrationFeeAmount(second_RegistrationFeeAmount);
		}
		else
		{
			sbtp.selectSecond_TPRegistrationFee(second_RegistrationFee);
		}
		if(second_UNBlockingFee.equals("Yes"))
		{
			sbtp.selectSecond_TPUNBlockingFee(second_UNBlockingFee);
			Thread.sleep(3000);
			//sbtp.enterSecond_TPUNBlockingFeeAmount(second_UNBlockingFeeAmount);
			sbtp.enterUnblockingFeeAmount(second_UNBlockingFeeAmount);
		}
		else
		{
			sbtp.selectSecond_TPUNBlockingFee(second_UNBlockingFee);
		}
		Thread.sleep(3000);
		sbtp.clickOnSaveAndSubmit();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("scroll(900, 0)");
		Thread.sleep(3000);
		sbtp.clickOnAddAnotherTP();
		Thread.sleep(3000);
		sbtp.enterTrainingPartnerType(third_TPType);
		if(third_RegistrationFee.equals("Yes"))
		{
			sbtp.selectThird_TPRegistrationFee(third_RegistrationFee);
			Thread.sleep(3000);
			//sbtp.enterThird_TPRegistrationFeeAmount(third_RegistrationFeeAmount);
			sbtp.enterRegistrationFeeAmount(third_RegistrationFeeAmount);
		}
		else
		{
			sbtp.selectThird_TPRegistrationFee(third_RegistrationFee);
		}
		if(third_UNBlockingFee.equals("Yes"))
		{
			sbtp.selectThird_TPUNBlockingFee(third_UNBlockingFee);
			Thread.sleep(3000);
			//sbtp.enterThird_TPUNBlockingFeeAmount(third_UNBlockingFeeAmount);
			sbtp.enterUnblockingFeeAmount(third_UNBlockingFeeAmount);
		}
		else
		{
			sbtp.selectThird_TPUNBlockingFee(third_UNBlockingFee);
		}
		Thread.sleep(3000);
		sbtp.clickOnSaveAndSubmit();
		Thread.sleep(3000);
		sbtp.clickOnFifth_RemoveTrainingPartnerType();
		
		sbtp.enterNumberOfBlockAttemptAllowedForTP(blockAttemptNumber);
		sbtp.enterDurationOfEachBlock(durationOfBlock);
		sbtp.enterNumberOfDaysForDesktopAssessmentComplition(daysForDesktopAssessment);
		sbtp.clickOnEffectiveDate();
		sbtp.clickOnCalenderIcon();
		Thread.sleep(3000);
		effective_date = driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTPRuleSC09TC04", Integer.parseInt(sno), 29, effective_date);
		ReadWriteData.setExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTPRuleSC09TC05", Integer.parseInt(sno), 24, effective_date);
		ReadWriteData.setExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTPRuleSC09TC06", Integer.parseInt(sno), 19, effective_date);
		Thread.sleep(3000);
		sbtp.clickOnSubmit();
		Thread.sleep(3000);
		sbtp.clickOnYes();
		Thread.sleep(3000);
		sbtp.clickOnOK();
		Thread.sleep(3000);
		PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	@DataProvider
	public Object[][] tpRuleSetupSmartAdminApproval()
	{
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTPRuleSC09TC05");
    }
	
	@Test(dataProvider="tpRuleSetupSmartAdminApproval", dependsOnMethods="smartBusinessTPRuleSetupTC_01")
	public void smartBusinessTPRuleApprovalTC_02(String sno, String sdUsername, String sdPassword,String expectedregistrationFee, String expectedregistrationFeeAmount, String expectedunBlockingFee, String expectedunBlockingFeeAmount, String expectedgregistrationFee, String expectedgregistrationFeeAmount, String expectedgunBlockingFee, String expectedgunBlockingFeeAmount, String firstTP, String expectedFirst_RegistrationFee, String expectedFirst_RegistrationFeeAmount, String expectedFirst_UNBlockingFee, String expectedFirst_UNBlockingFeeAmount, String secondTP, String expectedSecond_RegistrationFee, String expectedSecond_RegistrationFeeAmount, String expectedSecond_UNBlockingFee, String expectedSecond_UNBlockingFeeAmount, String expectedblockAttemptNumber, String expecteddurationOfBlock, String expecteddaysForDesktopAssessment, String effective_Date, String comments)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(sdUsername, sdPassword);
		SmartAdmin_DashboardPage sad = new SmartAdmin_DashboardPage(driver);
		Thread.sleep(7000);
		sad.clickReviewTPRegistrationSetUp();
		SmartAdmin_TPFormReviewPage sdtp = new SmartAdmin_TPFormReviewPage(driver);
		Thread.sleep(3000);
		if(expectedregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[1]")).getAttribute("value"), expectedregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Parter Type Reg')]]//input[@formcontrolname='registrationAmount']")).getAttribute("value"), expectedregistrationFeeAmount);
		}
		else if(expectedregistrationFee.equals("No"))
		{
	    	Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[1]")).getAttribute("value"), expectedregistrationFee);
		}
		if(expectedunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Parter Type Reg')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedunBlockingFeeAmount);
		}
		else if(expectedunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedunBlockingFee);
		}
		if(expectedgregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[2]")).getAttribute("value"), expectedgregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Parter Type Govt')]]//input[@formcontrolname='registrationAmount']")).getAttribute("value"), expectedgregistrationFeeAmount);
		}
		else if(expectedgregistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[2]")).getAttribute("value"), expectedgregistrationFee);
		}
		if(expectedgunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedgunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Parter Type Govt')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedgunBlockingFeeAmount);
		}
		else if(expectedgunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedgunBlockingFee);
		}
		if(expectedFirst_RegistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_RegistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Parter Type "+firstTP+"')]]//input[@formcontrolname='registrationAmount']")).getAttribute("value"), expectedFirst_RegistrationFeeAmount);
		}
		else if(expectedFirst_RegistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_RegistrationFee);	
		}
		if(expectedFirst_UNBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_UNBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Parter Type "+firstTP+"')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedFirst_UNBlockingFeeAmount);			
		}
		else if(expectedFirst_UNBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_UNBlockingFee);			
		}
		if(expectedSecond_RegistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_RegistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'4. Training Parter Type "+secondTP+"')]]//input[@formcontrolname='registrationAmount']")).getAttribute("value"), expectedSecond_RegistrationFeeAmount);
		}
		else if(expectedSecond_RegistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_RegistrationFee);	
		}
		if(expectedSecond_UNBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_UNBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'4. Training Parter Type "+secondTP+"')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedSecond_UNBlockingFeeAmount);			
		}
		else if(expectedSecond_UNBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_UNBlockingFee);
		}
		Thread.sleep(3000);
		sdtp.clickOnRemoveFourth_TPType();
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfBlockAttempts']")).getAttribute("value"), expectedblockAttemptNumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='durationOfBlock']")).getAttribute("value"), expecteddurationOfBlock);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysToCompleteDesktopAssessment']")).getAttribute("value"), expecteddaysForDesktopAssessment);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value"), effective_Date);
		Thread.sleep(2000);
		if(comments.equals("Approved Successfully"))
		{
			sdtp.clickOnApproved_ReviewComments();
			sdtp.enterReviewComments(comments);
		}
		else if(comments.equals("Not Approved"))
		{
			Thread.sleep(3000);
			sdtp.clickOnNotApproved_ReviewComments();
			sdtp.enterReviewComments(comments);
		}
		Thread.sleep(3000);
		sdtp.clickForSubmit();
		Thread.sleep(3000);
		sdtp.clickOnYes();
		Thread.sleep(3000);
		sdtp.clickOnOK();
		Thread.sleep(2000);
		PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();	
	}
	
	@DataProvider
	public Object[][] tpRuleSetupNSDCApproval()
	{
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTPRuleSC09TC06");
    }
	
	@Test(dataProvider="tpRuleSetupNSDCApproval", dependsOnMethods="smartBusinessTPRuleApprovalTC_02")
	public void smartBusinessTPRuleApprovalTC_03(String sno, String nsdcUsername, String nsdcPassword, String expectedNSDCregistrationFee, String expectedNSDCregistrationFeeAmount, String expectedNSDCunBlockingFee, String expectedNSDCunBlockingFeeAmount, String expectedNSDCgregistrationFee, String expectedNSDCgregistrationFeeAmount, String expectedNSDCgunBlockingFee, String expectedNSDCgunBlockingFeeAmount, String firstTP, String expectedNSDCFirst_RegistrationFee, String expectedNSDCFirst_RegistrationFeeAmount, String expectedNSDCFirst_UNBlockingFee, String expectedNSDCFirst_UNBlockingFeeAmount, String expectedNSDCblockAttemptNumber, String expectedNSDCdurationOfBlock, String expectedNSDCdaysForDesktopAssessment, String effective_Date, String reviewcomments)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(nsdcUsername, nsdcPassword);
		NSDCAdmin_DashboardPage nsd = new NSDCAdmin_DashboardPage(driver);
		Thread.sleep(10000);
		nsd.clickForReviewTPRegistrationSetup();
		NSDC_TPFormReviewPage nstp = new NSDC_TPFormReviewPage(driver);
		Thread.sleep(2000);
		if(expectedNSDCregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Parter Type Reg')]]//input[@formcontrolname='registrationAmount']")).getAttribute("value"), expectedNSDCregistrationFeeAmount);
		}
		else if(expectedNSDCregistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCregistrationFee);	
		}
		if(expectedNSDCunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Parter Type Reg')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedNSDCunBlockingFeeAmount);
		}
		else if(expectedNSDCunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCunBlockingFee);
		}
		if(expectedNSDCgregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCgregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Parter Type Govt')]]//input[@formcontrolname='registrationAmount']")).getAttribute("value"), expectedNSDCgregistrationFeeAmount);
		}
		else if(expectedNSDCgregistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCgregistrationFee);
		}
		if(expectedNSDCgunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCgunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Parter Type Govt')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedNSDCgunBlockingFeeAmount);
		}
		else if(expectedNSDCgunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCgunBlockingFee);			
		}
		if(expectedNSDCFirst_RegistrationFee.equals("yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_RegistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Parter Type "+firstTP+"')]]//input[@formcontrolname='registrationAmount']")).getAttribute("value"), expectedNSDCFirst_RegistrationFeeAmount);			
		}
		else if(expectedNSDCFirst_RegistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='registrationAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_RegistrationFee);	
		}
		if(expectedNSDCFirst_UNBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_UNBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Parter Type "+firstTP+"')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedNSDCFirst_UNBlockingFeeAmount);						
		}
		else if(expectedNSDCFirst_UNBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_UNBlockingFee);	
		}
		Thread.sleep(3000);
		nstp.clickOnRemoveThird_TPType();
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfBlockAttempts']")).getAttribute("value"), expectedNSDCblockAttemptNumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='durationOfBlock']")).getAttribute("value"), expectedNSDCdurationOfBlock);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysToCompleteDesktopAssessment']")).getAttribute("value"), expectedNSDCdaysForDesktopAssessment);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value"), effective_Date);

		Thread.sleep(2000);
		if(reviewcomments.equals("Approved Successfully"))
		{
			nstp.clickForApproved_ReviewComment();
			nstp.enterReviewComment(reviewcomments);
		}
		else if(reviewcomments.equals("Not Approved"))
		{
			Thread.sleep(3000);
			nstp.clickForNotApproved_ReviewComment();
			nstp.enterReviewComment(reviewcomments);
		}
		Thread.sleep(3000);
		nstp.clickForSubmit();
		Thread.sleep(3000);
		nstp.clickOnYes();
		Thread.sleep(3000);
		nstp.clickOnOK();
		Thread.sleep(2000);
		PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	
	

}
