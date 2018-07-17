package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
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
	public void smartBusinessTPRuleSetupTC_01(String sbUsername, String sbPassword, String registrationFee, String registrationFeeAmount, String unBlockingFee, String unBlockingFeeAmount, String gregistrationFee, String gregistrationFeeAmount, String gunBlockingFee, String gunBlockingFeeAmount, String blockAttemptNumber, String durationOfBlock, String daysForDesktopAssessment) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(sbUsername, sbPassword);
		
		SmartBusiness_DashboardPage sbd = new SmartBusiness_DashboardPage(driver);
		Thread.sleep(5000);
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
		sbtp.enterNumberOfBlockAttemptAllowedForTP(blockAttemptNumber);
		sbtp.enterDurationOfEachBlock(durationOfBlock);
		sbtp.enterNumberOfDaysForDesktopAssessmentComplition(daysForDesktopAssessment);
		sbtp.clickOnEffectiveDate();
		/*sbtp.clickOnCornerOfDateField();
		sbtp.clickOnLastDate();*/
		sbtp.clickOnCalenderIcon();
		effective_date = driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value");
		sbtp.clickOnSubmit();
		sbtp.clickOnOK();
		
		Thread.sleep(2000);
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
	public void smartBusinessTPRuleApprovalTC_02(String sdUsername, String sdPassword,String expectedregistrationFee, String expectedregistrationFeeAmount, String expectedunBlockingFee, String expectedunBlockingFeeAmount, String expectedgregistrationFee, String expectedgregistrationFeeAmount, String expectedgunBlockingFee, String expectedgunBlockingFeeAmount, String expectedblockAttemptNumber, String expecteddurationOfBlock, String expecteddaysForDesktopAssessment, String comments)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(sdUsername, sdPassword);
		
		SmartAdmin_DashboardPage sad = new SmartAdmin_DashboardPage(driver);
		Thread.sleep(7000);
		sad.clickReviewTPRegistrationSetUp();
		
		SmartAdmin_TPFormReviewPage sdtp = new SmartAdmin_TPFormReviewPage(driver);
		Thread.sleep(2000);
		if(expectedregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularRegistrationAmountIsRequired']")).getAttribute("value"), expectedregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularRegistrationAmount']")).getAttribute("value"), expectedregistrationFeeAmount);
		}
		else if(expectedregistrationFee.equals("No"))
		{
	    	Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularRegistrationAmountIsRequired']")).getAttribute("value"), expectedregistrationFee);
		}
		if(expectedunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularUnblockingAmount']")).getAttribute("value"), expectedunBlockingFeeAmount);
		}
		else if(expectedunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedunBlockingFee);
		}
		if(expectedgregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtRegistrationAmountIsRequired']")).getAttribute("value"), expectedgregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtRegistrationAmount']")).getAttribute("value"), expectedgregistrationFeeAmount);
		}
		else if(expectedgregistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtRegistrationAmountIsRequired']")).getAttribute("value"), expectedgregistrationFee);
		}
		if(expectedgunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedgunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtUnblockingAmount']")).getAttribute("value"), expectedgunBlockingFeeAmount);
		}
		else if(expectedgunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedgunBlockingFee);
		}
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfBlockAttempts']")).getAttribute("value"), expectedblockAttemptNumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='durationOfBlock']")).getAttribute("value"), expecteddurationOfBlock);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysToCompleteDesktopAssessment']")).getAttribute("value"), expecteddaysForDesktopAssessment);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value"), effective_date);

		
		Thread.sleep(2000);
		if(comments.equals("Approved Successful"))
		{
			sdtp.clickOnApproved_ReviewComments();
			sdtp.enterReviewComments(comments);
		}
		else if(comments.equals("Not Approved"))
		{
			Thread.sleep(2000);
			sdtp.clickOnNotApproved_ReviewComments();
			sdtp.enterReviewComments(comments);
		}
		sdtp.clickForSubmit();
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
	public void smartBusinessTPRuleApprovalTC_03(String nsdcUsername, String nsdcPassword, String expectedNSDCregistrationFee, String expectedNSDCregistrationFeeAmount, String expectedNSDCunBlockingFee, String expectedNSDCunBlockingFeeAmount, String expectedNSDCgregistrationFee, String expectedNSDCgregistrationFeeAmount, String expectedNSDCgunBlockingFee, String expectedNSDCgunBlockingFeeAmount, String expectedNSDCblockAttemptNumber, String expectedNSDCdurationOfBlock, String expectedNSDCdaysForDesktopAssessment, String reviewcomments)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(nsdcUsername, nsdcPassword);
		
		NSDCAdmin_DashboardPage nsd = new NSDCAdmin_DashboardPage(driver);
		Thread.sleep(7000);
		nsd.clickForReviewTPRegistrationSetup();
		
		NSDC_TPFormReviewPage nstp = new NSDC_TPFormReviewPage(driver);
		Thread.sleep(2000);
		if(expectedNSDCregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularRegistrationAmountIsRequired']")).getAttribute("value"), expectedNSDCregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularRegistrationAmount']")).getAttribute("value"), expectedNSDCregistrationFeeAmount);
		}
		else if(expectedNSDCregistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularRegistrationAmountIsRequired']")).getAttribute("value"), expectedNSDCregistrationFee);	
		}
		if(expectedNSDCunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularUnblockingAmount']")).getAttribute("value"), expectedNSDCunBlockingFeeAmount);
		}
		else if(expectedNSDCunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCunBlockingFee);
		}
		if(expectedNSDCgregistrationFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtRegistrationAmountIsRequired']")).getAttribute("value"), expectedNSDCgregistrationFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtRegistrationAmount']")).getAttribute("value"), expectedNSDCgregistrationFeeAmount);
		}
		else if(expectedNSDCgregistrationFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtRegistrationAmountIsRequired']")).getAttribute("value"), expectedNSDCgregistrationFee);
		}
		if(expectedNSDCgunBlockingFee.equals("Yes"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCgunBlockingFee);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtUnblockingAmount']")).getAttribute("value"), expectedNSDCgunBlockingFeeAmount);
		}
		else if(expectedNSDCgunBlockingFee.equals("No"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCgunBlockingFee);			
		}
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfBlockAttempts']")).getAttribute("value"), expectedNSDCblockAttemptNumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='durationOfBlock']")).getAttribute("value"), expectedNSDCdurationOfBlock);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysToCompleteDesktopAssessment']")).getAttribute("value"), expectedNSDCdaysForDesktopAssessment);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value"), effective_date);

		Thread.sleep(2000);
		if(reviewcomments.equals("Approved Successful"))
		{
			nstp.clickForApproved_ReviewComment();
			nstp.enterReviewComment(reviewcomments);
		}
		else if(reviewcomments.equals("Not Approved"))
		{
			Thread.sleep(2000);
			nstp.clickForNotApproved_ReviewComment();
			nstp.enterReviewComment(reviewcomments);
		}
		nstp.clickForSubmit();
		nstp.clickOnOK();
		
		Thread.sleep(2000);
		PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		
	}
	
	
	

}
