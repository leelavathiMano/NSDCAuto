package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.NSDCAdmin_DashboardPage;
import com.nsdc.pages.NSDC_TCCAAFFormReviewPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SmartAdmin_DashboardPage;
import com.nsdc.pages.SmartAdmin_TCCAAFFormReviewPage;
import com.nsdc.pages.SmartBusiness_DashboardPage;
import com.nsdc.pages.SmartBusiness_TCSetupReviewPage;
import com.nsdc.testConfig.TestConfiguration;

public class SmartBusiness_TCRegistrationWorkflowTestSC_08 extends TestConfiguration
{
	public String effective_date;
	
	@DataProvider
	public Object[][] smartBusinessTCRegistrationRuleSetUpData()
	{
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCRuleSC08TC01");
    }
	
	@Test(dataProvider="smartBusinessTCRegistrationRuleSetUpData")
	public void smartBusinessTCRuleSetupTC_01(String sno, String sbUsername, String sbPassword, String raccrediationFee, String raccrediationFeeAmount, String rcontinuousMonitoringFee, String rconinuousMonitoringFeeAmount, String runBlockingFee, String runBlockingFeeAmount, String raffiliationFee, String raffiliationFeeAmount, String rAppealFee, String rAppealFeeAmount, String gaccrediationFee, String gaccrediationFeeAmount, String gcontinuousMonitoringFee, String gconinuousMonitoringFeeAmount, String gunBlockingFee, String gunBlockingFeeAmount, String gaffiliationFee, String gaffiliationFeeAmount, String gAppealFee, String gAppealFeeAmount, String first_TCType, String first_AccrediationFee, String first_AccreditationFeeAmount, String first_ContinuousMonitoringFee, String first_ContinousMonitoringFeeAmount, String first_UNBlockingFee, String first_UnblockingFeeAmount, String first_AffiliationFee, String first_AffiliationFeeAmount, String first_AppealFee, String first_AppealFeeAmount, String second_TCType, String second_AccrediationFee, String second_AccreditationFeeAmount, String second_ContinuousMonitoringFee, String second_ContinousMonitoringFeeAmount, String second_UNBlockingFee, String second_UnblockingFeeAmount, String second_AffiliationFee, String second_AffiliationFeeAmount, String second_AppealFee, String second_AppealFeeAmount, String third_TCType, String third_AccrediationFee, String third_AccreditationFeeAmount, String third_ContinuousMonitoringFee, String third_ContinousMonitoringFeeAmount, String third_UNBlockingFee, String third_UnblockingFeeAmount, String third_AffiliationFee, String third_AffiliationFeeAmount, String third_AppealFee, String third_AppealFeeAmount, String blockedAttemptAllowedNumber, String durationOfBlock, String advanceInspectionNotification, String onSiteInspection, String daysForReplyBackOnAssessment, String refundPercentageForOneweek, String refundPercentageForThreeWeek, String refundPercentageOnInspectionDate, String refundPercentageOnFirstDNR, String refundPercentageOnSecondDNR, String effective_date) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(sbUsername, sbPassword);
		SmartBusiness_DashboardPage sbd = new SmartBusiness_DashboardPage(driver);
		Thread.sleep(8000);
		sbd.clickOnTCRegistrationSetup();
		SmartBusiness_TCSetupReviewPage sbtc = new SmartBusiness_TCSetupReviewPage(driver);
		
		if(raccrediationFee.equals("Yes"))
		{
			sbtc.selectForRegularTCAccrediationFee(raccrediationFee);
			sbtc.enterAmountForRegularTCAccrediationFee(raccrediationFeeAmount);
		}
		else if(raccrediationFee.equals("No"))
		{
			sbtc.selectForRegularTCAccrediationFee(raccrediationFee);
		}
		if(rcontinuousMonitoringFee.equals("Yes"))
		{
			sbtc.selectForRegularTCContinuousMonitoringFee(rcontinuousMonitoringFee);
			sbtc.enterAmountForRegularTCContinuousMonitoringFee(rconinuousMonitoringFeeAmount);
		}
		else if(rcontinuousMonitoringFee.equals("No"))
		{
			sbtc.selectForRegularTCContinuousMonitoringFee(rcontinuousMonitoringFee);
		}
		if(runBlockingFee.equals("Yes"))
		{
			sbtc.selectForRegularTCUNBlockingFee(runBlockingFee);
			sbtc.enterAmountForRegularTCUNBlockingFee(runBlockingFeeAmount);
		}
		else if(runBlockingFee.equals("No"))
		{
			sbtc.selectForRegularTCUNBlockingFee(runBlockingFee);			
		}
		if(raffiliationFee.equals("Yes"))
		{
			sbtc.selectForRegularTCAffiliationFeePerJobRole(raffiliationFee);
			sbtc.enterAmountForTCAffiliationFeePerJobRole(raffiliationFeeAmount);
		}
		else if(raffiliationFee.equals("No"))
		{
			sbtc.selectForRegularTCAffiliationFeePerJobRole(raffiliationFee);	
		}
		if(rAppealFee.equals("Yes"))
		{
			sbtc.select_First_AppealFee(rAppealFee);
			sbtc.enter_First_AppealAmount(rAppealFeeAmount);
		}
		else
		{
			sbtc.select_First_AppealFee(rAppealFee);
		}
		
		
		if(gaccrediationFee.equals("Yes"))
		{
			sbtc.selectForGovernmentTCAccrediationFee(gaccrediationFee);
			sbtc.enterAmountForGovernmentTCAccrediationFee(gaccrediationFeeAmount);
		}
		else if(gaccrediationFee.equals("No"))
		{
			sbtc.selectForGovernmentTCAccrediationFee(gaccrediationFee);	
		}
		if(gcontinuousMonitoringFee.equals("Yes"))
		{
			sbtc.selectForGovernmentTCContinuousMonitoringFee(gcontinuousMonitoringFee);
			sbtc.enterAmountForGovernmentTCContinuousMonitoringFee(gconinuousMonitoringFeeAmount);
		}
		else if(gcontinuousMonitoringFee.equals("No"))
		{
			sbtc.selectForGovernmentTCContinuousMonitoringFee(gcontinuousMonitoringFee);			
		}
		if(gunBlockingFee.equals("Yes"))
		{
			sbtc.selectForGovernmentTCUNBlockingFee(gunBlockingFee);
			sbtc.enterAmountForGovernmentTCUNBlockingFee(gunBlockingFeeAmount);
		}
		else if(gunBlockingFee.equals("No"))
		{
			sbtc.selectForGovernmentTCUNBlockingFee(gunBlockingFee);
		}
		if(gaffiliationFee.equals("Yes"))
		{
			sbtc.selectForGovernmentTCAffiliationFeePerJobRole(gaffiliationFee);
			sbtc.enterAmountForGovernmentTCAffiliationFeePerJobRole(gaffiliationFeeAmount);
		}
		else if(gaffiliationFee.equals("No"))
		{
			sbtc.selectForGovernmentTCAffiliationFeePerJobRole(gaffiliationFee);
		}
		if(gAppealFee.equals("Yes"))
		{
			sbtc.select_Second_AppealFee(gAppealFee);
			sbtc.enter_Second_AppealAmount(gAppealFeeAmount);
		}
		else
		{
			sbtc.select_Second_AppealFee(gAppealFee);
		}
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(900, 0)");
		Thread.sleep(3000);
		sbtc.clickOnAddAnotherTrainingCentreType();
		Thread.sleep(3000);
		sbtc.enterTrainingCentreType(first_TCType);
		if(first_AccrediationFee.equals("Yes"))
		{
			sbtc.selectFirst_TCAccrediationFee(first_AccrediationFee);
			Thread.sleep(3000);
			sbtc.enterAccrediatationFeeAmount(first_AccreditationFeeAmount);
		}
		else
		{
			sbtc.selectFirst_TCAccrediationFee(first_AccrediationFee);
		}
		if(first_ContinuousMonitoringFee.equals("Yes"))
		{
			sbtc.selectFirst_TCContinuousMonitoringFee(first_ContinuousMonitoringFee);
			Thread.sleep(3000);
			sbtc.enterContinousMonitoringFeeAmount(first_ContinousMonitoringFeeAmount);
		}
		else
		{
			sbtc.selectFirst_TCContinuousMonitoringFee(first_ContinuousMonitoringFee);			
		}
		if(first_UNBlockingFee.equals("Yes"))
		{
			sbtc.selectFirst_TCUNBlockingFee(first_UNBlockingFee);
			Thread.sleep(3000);
			sbtc.enterUnblockingFeeAmount(first_UnblockingFeeAmount);
		}
		else
		{
			sbtc.selectFirst_TCUNBlockingFee(first_UNBlockingFee);			
		}
		if(first_AffiliationFee.equals("Yes"))
		{
			sbtc.selectFirst_TCAffiliationFeePerJobRole(first_AffiliationFee);
			Thread.sleep(3000);
			sbtc.enterAffiliationFeeAmount(first_AffiliationFeeAmount);
		}
		else
		{
			sbtc.selectFirst_TCAffiliationFeePerJobRole(first_AffiliationFee);			
		}
		if(first_AppealFee.equals("Yes"))
		{
			sbtc.select_Third_AppealFee(first_AppealFee);
			sbtc.enter_Third_AppealAmount(first_AppealFeeAmount);
		}
		else
		{
			sbtc.select_Third_AppealFee(first_AppealFee);
		}
		
		
		Thread.sleep(3000);
		sbtc.clickOnSaveAndSubmit();
		JavascriptExecutor jvs = (JavascriptExecutor) driver;
		jvs.executeScript("scroll(900,0)");
		Thread.sleep(3000);
		sbtc.clickOnAddAnotherTrainingCentreType();
		Thread.sleep(3000);
		sbtc.enterTrainingCentreType(second_TCType);
		if(second_AccrediationFee.equals("Yes"))
		{
			sbtc.selectSecond_TCAccrediationFee(second_AccrediationFee);
			Thread.sleep(3000);
			sbtc.enterAccrediatationFeeAmount(second_AccreditationFeeAmount);
		}
		else
		{
			sbtc.selectSecond_TCAccrediationFee(second_AccrediationFee);
		}
		if(second_ContinuousMonitoringFee.equals("Yes"))
		{
			sbtc.selectSecond_TCContinuousMonitoringFee(second_ContinuousMonitoringFee);
			Thread.sleep(3000);
			sbtc.enterContinousMonitoringFeeAmount(second_ContinousMonitoringFeeAmount);
		}
		else
		{
			sbtc.selectSecond_TCContinuousMonitoringFee(second_ContinuousMonitoringFee);		
		}
		if(second_UNBlockingFee.equals("Yes"))
		{
			sbtc.selectSecond_TCUNBlockingFee(second_UNBlockingFee);
			Thread.sleep(3000);
			sbtc.enterUnblockingFeeAmount(second_UnblockingFeeAmount);
		}
		else
		{
			sbtc.selectSecond_TCUNBlockingFee(second_UNBlockingFee);		
		}
		if(second_AffiliationFee.equals("Yes"))
		{
			sbtc.selectSecond_TCAffiliationFeePerJobRole(second_AffiliationFee);
			Thread.sleep(3000);
			sbtc.enterAffiliationFeeAmount(second_AffiliationFeeAmount);
		}
		else
		{
			sbtc.selectSecond_TCAffiliationFeePerJobRole(second_AffiliationFee);		
		}
		if(second_AppealFee.equals("Yes"))
		{
			sbtc.select_Fourth_AppealFee(second_AppealFee);
			sbtc.enter_Fourth_AppealAmount(second_AppealFeeAmount);
		}
		else
		{
			sbtc.select_Fourth_AppealFee(second_AppealFee);
		}
		
		
		Thread.sleep(3000);
		sbtc.clickOnSaveAndSubmit();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("scroll(900,0)");
		Thread.sleep(3000);
		sbtc.clickOnAddAnotherTrainingCentreType();
		Thread.sleep(3000);
		sbtc.enterTrainingCentreType(third_TCType);
		if(third_AccrediationFee.equals("Yes"))
		{
			sbtc.selectThird_TCAccrediationFee(third_AccrediationFee);
			Thread.sleep(3000);
			sbtc.enterAccrediatationFeeAmount(third_AccreditationFeeAmount);
		}
		else
		{
			sbtc.selectThird_TCAccrediationFee(third_AccrediationFee);
		}
		if(third_ContinuousMonitoringFee.equals("Yes"))
		{
			sbtc.selectThird_TCContinuousMonitoringFee(third_ContinuousMonitoringFee);
			Thread.sleep(3000);
			sbtc.enterContinousMonitoringFeeAmount(third_ContinousMonitoringFeeAmount);
		}
		else
		{
			sbtc.selectThird_TCContinuousMonitoringFee(third_ContinuousMonitoringFee);	
		}
		if(third_UNBlockingFee.equals("Yes"))
		{
			sbtc.selectThird_TCUNBlockingFee(third_UNBlockingFee);
			Thread.sleep(3000);
			sbtc.enterUnblockingFeeAmount(third_UnblockingFeeAmount);
		}
		else
		{
			sbtc.selectThird_TCUNBlockingFee(third_UNBlockingFee);
		}
		if(third_AffiliationFee.equals("Yes"))
		{
			sbtc.selectThird_TCAffiliationFeePerJobRole(third_AffiliationFee);
			Thread.sleep(3000);
			sbtc.enterAffiliationFeeAmount(third_AffiliationFeeAmount);
		}
		else
		{
			sbtc.selectThird_TCAffiliationFeePerJobRole(third_AffiliationFee);	
		}
		if(third_AppealFee.equals("Yes"))
		{
			sbtc.select_Fifth_AppealFee(third_AppealFee);
			sbtc.enter_Fifth_AppealAmount(third_AppealFeeAmount);
		}
		else
		{
			sbtc.select_Fifth_AppealFee(third_AppealFee);
		}
		
		Thread.sleep(3000);
		sbtc.clickOnSaveAndSubmit();
		Thread.sleep(3000);
		sbtc.clickOnThird_TCType_Remove();
		Thread.sleep(3000);
		
		sbtc.enterNumberOfBlockedAttemptsAllowedForTC(blockedAttemptAllowedNumber);
		sbtc.enterDurationOfEachBlockForTC(durationOfBlock);
		sbtc.enterAdvanceInspectionNotificationInDaysForTC(advanceInspectionNotification);
		sbtc.enterOnSiteInspectionIndaysForDeemedReadyTC(onSiteInspection);
		sbtc.enterNumberOfDaysForInspectionAgencyToReplyBackOnAssessment(daysForReplyBackOnAssessment);
		sbtc.enterRefundPercentageOnCentreInspectionRefusalBeforeOneWeek(refundPercentageForOneweek);
		sbtc.enterRefundPercentageONCentreInspectionRefusalBeforeThreeWeek(refundPercentageForThreeWeek);
		sbtc.enterRefundPercentageForCentreInspectionRefusalOnInspectionDate(refundPercentageOnInspectionDate);
		sbtc.enterRefundPercentageOnFirstDNRIfTCNotReapply(refundPercentageOnFirstDNR);
		sbtc.enterRefundPercentageOnSecondDNRIfTCNotReapply(refundPercentageOnSecondDNR);
		Thread.sleep(2000);
		sbtc.clickForEffectiveDate();
		sbtc.clickOnCalenderIconButton();
		effective_date = driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCRuleSC08TC01", Integer.parseInt(sno), 66, effective_date);
		ReadWriteData.setExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCApprovalSC08TC02", Integer.parseInt(sno), 55, effective_date);
		ReadWriteData.setExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCApprovalSC08TC03", Integer.parseInt(sno), 44, effective_date);
		Thread.sleep(3000);
		sbtc.clickForSubmit();
		Thread.sleep(3000);
		sbtc.clickOnYes();
		Thread.sleep(3000);
		sbtc.clickForOK();
		Thread.sleep(3000);
		PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	
	@DataProvider
    public Object[][] tcRuleSetupSmartAdminApproval()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCApprovalSC08TC02");
    }
    
    @Test(dataProvider="tcRuleSetupSmartAdminApproval", dependsOnMethods="smartBusinessTCRuleSetupTC_01")
    public void smartBusinessTCRuleApprovalTC_02(String sno, String sdUsername, String sdPassword, String expectedRaccrediationFee, String expectedRaccrediationFeeAmount, String expectedRcontinuousMonitoringFee, String expectedRconinuousMonitoringFeeAmount, String expectedRunBlockingFee, String expectedRunBlockingFeeAmount, String expectedRaffiliationFee, String expectedRaffiliationFeeAmount, String expectedRAppealFee, String expectedRAppealFeeAmount, String expectedGaccrediationFee, String expectedGaccrediationFeeAmount, String expectedGcontinuousMonitoringFee, String expectedGconinuousMonitoringFeeAmount, String expectedGunBlockingFee, String expectedGunBlockingFeeAmount, String expectedGaffiliationFee, String expectedGaffiliationFeeAmount, String expectedGAppealFee, String expectedGAppealFeeAmount, String first_TCType, String expectedFirst_AccrediationFee, String expectedFirst_AccreditationFeeAmount, String expectedFirst_ContinuousMonitoringFee, String expectedFirst_ContinousMonitoringFeeAmount, String expectedFirst_UNBlockingFee, String expectedFirst_UnblockingFeeAmount, String expectedFirst_AffiliationFee, String expectedFirst_AffiliationFeeAmount, String expectedFirst_AppealFee, String expectedFirst_AppealFeeAmount, String second_TCType, String expectedSecond_AccrediationFee, String expectedSecond_AccreditationFeeAmount, String expectedSecond_ContinuousMonitoringFee, String expectedSecond_ContinousMonitoringFeeAmount, String expectedSecond_UNBlockingFee, String expectedSecond_UnblockingFeeAmount, String expectedSecond_AffiliationFee, String expectedSecond_AffiliationFeeAmount, String expectedSecond_AppealFee, String expectedSecond_AppealFeeAmount, String expectedBlockedAttemptAllowedNumber, String expectedDurationOfBlock, String expectedAdvanceInspectionNotification, String expectedOnSiteInspection, String expectedDaysForReplyBackOnAssessment, String expectedRefundPercentageForOneweek, String expectedRefundPercentageForThreeWeek, String expectedRefundPercentageOnInspectionDate, String expectedRefundPercentageOnFirstDNR, String expectedRefundPercentageOnSecondDNR, String effective_date, String comments) throws Exception
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.clickLogin();
    	Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
    	EnterLoginPage elp = new EnterLoginPage(driver);
    	elp.performlogin(sdUsername, sdPassword);
    	SmartAdmin_DashboardPage sad = new SmartAdmin_DashboardPage(driver);
    	Thread.sleep(10000);
    	sad.clickForReviewTCRegistrationSetUp();
    	SmartAdmin_TCCAAFFormReviewPage sdtc = new SmartAdmin_TCCAAFFormReviewPage(driver);
    	Thread.sleep(2000);
    	if(expectedRaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[1]")).getAttribute("value"), expectedRaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='accredationAmount']")).getAttribute("value"), expectedRaccrediationFeeAmount);
    	}
    	else if(expectedRaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[1]")).getAttribute("value"), expectedRaccrediationFee);	
    	}
    	if(expectedRcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[1]")).getAttribute("value"), expectedRcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='continuousMonitoringAmount']")).getAttribute("value"), expectedRconinuousMonitoringFeeAmount);
    	}
    	else if(expectedRcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[1]")).getAttribute("value"), expectedRcontinuousMonitoringFee);
    	}
    	if(expectedRunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedRunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedRunBlockingFeeAmount);
    	}
    	else if(expectedRunBlockingFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedRunBlockingFee);		
    	}
    	if(expectedRaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[1]")).getAttribute("value"), expectedRaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='affilationAmount']")).getAttribute("value"), expectedRaffiliationFeeAmount);
    	}
    	else if(expectedRaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[1]")).getAttribute("value"), expectedRaffiliationFee);   		
    	}
    	if(expectedRAppealFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[1]")).getAttribute("value"), expectedRAppealFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='appealAmount']")).getAttribute("value"), expectedRAppealFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[1]")).getAttribute("value"), expectedRAppealFee);
    	}
    	
    	
    	if(expectedGaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[2]")).getAttribute("value"), expectedGaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='accredationAmount']")).getAttribute("value"), expectedGaccrediationFeeAmount);
    	}
    	else if(expectedGaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[2]")).getAttribute("value"), expectedGaccrediationFee);
    	}
    	if(expectedGcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[2]")).getAttribute("value"), expectedGcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='continuousMonitoringAmount']")).getAttribute("value"), expectedGconinuousMonitoringFeeAmount);
    	}
    	else if(expectedGcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[2]")).getAttribute("value"), expectedGcontinuousMonitoringFee);
    	}
    	if(expectedGunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedGunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedGunBlockingFeeAmount);
    	}
    	else if(expectedGunBlockingFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedGunBlockingFee);
    	}
    	if(expectedGaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[2]")).getAttribute("value"), expectedGaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='affilationAmount']")).getAttribute("value"), expectedGaffiliationFeeAmount);
    	}
    	else if(expectedGaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[2]")).getAttribute("value"), expectedGaffiliationFee);	
    	}
    	if(expectedGAppealFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[2]")).getAttribute("value"), expectedGAppealFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='appealAmount']")).getAttribute("value"), expectedGAppealFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[2]")).getAttribute("value"), expectedGAppealFee);  		
    	}
    	
    	
    	if(expectedFirst_AccrediationFee.equals("Yes")) 
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_AccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='accredationAmount']")).getAttribute("value"), expectedFirst_AccreditationFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_AccrediationFee);   		
    	}
    	if(expectedFirst_ContinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_ContinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='continuousMonitoringAmount']")).getAttribute("value"), expectedFirst_ContinousMonitoringFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_ContinuousMonitoringFee);   		
    	}
    	if(expectedFirst_UNBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_UNBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedFirst_UnblockingFeeAmount);    		
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_UNBlockingFee);
    	}
    	if(expectedFirst_AffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_AffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='affilationAmount']")).getAttribute("value"), expectedFirst_AffiliationFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_AffiliationFee);   		
    	}
    	if(expectedFirst_AppealFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_AppealFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='appealAmount']")).getAttribute("value"), expectedFirst_AppealFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[3]")).getAttribute("value"), expectedFirst_AppealFee);    		
    	}
    	
    	
    	
    	if(expectedSecond_AccrediationFee.equals("Yes")) 
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_AccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'4. Training Centre Type "+second_TCType+"')]]//input[@formcontrolname='accredationAmount']")).getAttribute("value"), expectedSecond_AccreditationFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_AccrediationFee);   		
    	}
    	if(expectedSecond_ContinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_ContinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'4. Training Centre Type "+second_TCType+"')]]//input[@formcontrolname='continuousMonitoringAmount']")).getAttribute("value"), expectedSecond_ContinousMonitoringFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_ContinuousMonitoringFee);   		
    	}
    	if(expectedSecond_UNBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_UNBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'4. Training Centre Type "+second_TCType+"')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedSecond_UnblockingFeeAmount);    		
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_UNBlockingFee);
    	}
    	if(expectedSecond_AffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_AffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'4. Training Centre Type "+second_TCType+"')]]//input[@formcontrolname='affilationAmount']")).getAttribute("value"), expectedSecond_AffiliationFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_AffiliationFee);   		
    	}
    	if(expectedSecond_AppealFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_AppealFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'4. Training Centre Type "+second_TCType+"')]]//input[@formcontrolname='appealAmount']")).getAttribute("value"), expectedSecond_AppealFeeAmount);    		
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[4]")).getAttribute("value"), expectedSecond_AppealFee);    		
    	}
    	
    	Thread.sleep(3000);
    	sdtc.clickOnSecond_TCType_Remove();
    	Thread.sleep(3000);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfBlockAttempts']")).getAttribute("value"), expectedBlockedAttemptAllowedNumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='durationOfBlock']")).getAttribute("value"), expectedDurationOfBlock);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysInAdvanceInspectionDateNotifications']")).getAttribute("value"), expectedAdvanceInspectionNotification);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysForOnsiteInspectionAfterDeemedReady']")).getAttribute("value"), expectedOnSiteInspection);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysForInspectionAgencyReplyBackOnAssessment']")).getAttribute("value"), expectedDaysForReplyBackOnAssessment);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='percentageOnRefusalOfCenterInspection']")).getAttribute("value"), expectedRefundPercentageForOneweek);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='percentageOnRefusalOfCenterInspection1']")).getAttribute("value"), expectedRefundPercentageForThreeWeek);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='percentageOnRefusalOfCenterInspection2']")).getAttribute("value"), expectedRefundPercentageOnInspectionDate);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='refundOnDNRIfTCDoesnotReapply']")).getAttribute("value"), expectedRefundPercentageOnFirstDNR);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='refundOnSecondDNRIfTCDoesnotReapply']")).getAttribute("value"), expectedRefundPercentageOnSecondDNR);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value"), effective_date);

    	Thread.sleep(3000);
    	if(comments.equals("Approved Successfully"))
    	{
    		Thread.sleep(3000);
    		sdtc.clickForApprove_ReviewComments();
    		sdtc.enterReviewComments(comments);
    	}
    	else if(comments.equals("Not Approved"))
    	{
    		Thread.sleep(3000);
    		sdtc.clickForNotApprove_ReviewComments();
    		sdtc.enterReviewComments(comments);
    	}
    	Thread.sleep(3000);
    	sdtc.clickForSubmit();
    	Thread.sleep(3000);
    	sdtc.clickOnYes();
    	Thread.sleep(3000);
    	sdtc.clickOnOK();
    	Thread.sleep(3000);
    	PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
    }
    
    @DataProvider
    public Object[][] tcRuleSetupNSDCApproval()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCApprovalSC08TC03");
    }
    
    @Test(dataProvider="tcRuleSetupNSDCApproval", dependsOnMethods="smartBusinessTCRuleApprovalTC_02")
    public void smartBusinessTCRuleApprovalTC_03(String sno, String nsdcUsername, String nsdcPassword, String expectedNSDCRaccrediationFee, String expectedNSDCRaccrediationFeeAmount, String expectedNSDCRcontinuousMonitoringFee, String expectedNSDCRconinuousMonitoringFeeAmount, String expectedNSDCRunBlockingFee, String expectedNSDCRunBlockingFeeAmount, String expectedNSDCRaffiliationFee, String expectedNSDCRaffiliationFeeAmount, String expectedNSDCRappealFee, String expectedNSDCRappealFeeAmount, String expectedNSDCGaccrediationFee, String expectedNSDCGaccrediationFeeAmount, String expectedNSDCGcontinuousMonitoringFee, String expectedNSDCGconinuousMonitoringFeeAmount, String expectedNSDCGunBlockingFee, String expectedNSDCGunBlockingFeeAmount, String expectedNSDCGaffiliationFee, String expectedNSDCGaffiliationFeeAmount, String expectedNSDCGappealFee, String expectedNSDCGappealFeeAmount, String first_TCType, String expectedNSDCFirst_AccrediationFee, String expectedNSDCFirst_AccreditationFeeAmount, String expectedNSDCFirst_ContinuousMonitoringFee, String expectedNSDCFirst_ContinousMonitoringFeeAmount, String expectedNSDCFirst_UNBlockingFee, String expectedNSDCFirst_UnblockingFeeAmount, String expectedNSDCFirst_AffiliationFee, String expectedNSDCFirst_AffiliationFeeAmount, String expectedNSDCFirst_AppealFee, String expectedNSDCFirst_AppealFeeAmount, String expectedNSDCBlockedAttemptAllowedNumber, String expectedNSDCDurationOfBlock, String expectedNSDCAdvanceInspectionNotification, String expectedNSDCOnSiteInspection, String expectedNSDCDaysForReplyBackOnAssessment, String expectedNSDCRefundPercentageForOneweek, String expectedNSDCRefundPercentageForThreeWeek, String expectedNSDCRefundPercentageOnInspectionDate, String expectedNSDCRefundPercentageOnFirstDNR, String expectedNSDCRefundPercentageOnSecondDNR, String effective_date, String reviewComments) throws Exception
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.clickLogin();
    	Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
    	EnterLoginPage elp = new EnterLoginPage(driver);
    	elp.performlogin(nsdcUsername, nsdcPassword);
    	NSDCAdmin_DashboardPage nsd = new NSDCAdmin_DashboardPage(driver);
    	Thread.sleep(10000);
    	nsd.clickForReviewTCRegistrationSetup();
    	NSDC_TCCAAFFormReviewPage nstc = new NSDC_TCCAAFFormReviewPage(driver);
    	Thread.sleep(2000);
    	if(expectedNSDCRaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='accredationAmount']")).getAttribute("value"), expectedNSDCRaccrediationFeeAmount);
    	}
    	else if(expectedNSDCRaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRaccrediationFee);
    	}
    	if(expectedNSDCRcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='continuousMonitoringAmount']")).getAttribute("value"), expectedNSDCRconinuousMonitoringFeeAmount);
    	}
    	else if(expectedNSDCRcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRcontinuousMonitoringFee);	
    	}
    	if(expectedNSDCRunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedNSDCRunBlockingFeeAmount);
    	}
    	else if(expectedNSDCRunBlockingFee.equals("No"))
    	{
        	Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRunBlockingFee);    		
    	}
    	if(expectedNSDCRaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='affilationAmount']")).getAttribute("value"), expectedNSDCRaffiliationFeeAmount);
    	}
    	else if(expectedNSDCRaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRaffiliationFee);
    	}
    	if(expectedNSDCRappealFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRappealFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'1. Training Centre Type Reg')]]//input[@formcontrolname='appealAmount']")).getAttribute("value"), expectedNSDCRappealFeeAmount);   		
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[1]")).getAttribute("value"), expectedNSDCRappealFee);   		
    	}
    	
    	
    	if(expectedNSDCGaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='accredationAmount']")).getAttribute("value"), expectedNSDCGaccrediationFeeAmount);
    	}
    	else if(expectedNSDCGaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGaccrediationFee);
    	}
    	if(expectedNSDCGcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='continuousMonitoringAmount']")).getAttribute("value"), expectedNSDCGconinuousMonitoringFeeAmount);
    	}
    	else if(expectedNSDCGcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGcontinuousMonitoringFee); 		
    	}
    	if(expectedNSDCGunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedNSDCGunBlockingFeeAmount);
    	}
    	else if(expectedNSDCGunBlockingFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGunBlockingFee);
    	}
    	if(expectedNSDCGaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='affilationAmount']")).getAttribute("value"), expectedNSDCGaffiliationFeeAmount);
    	}
    	else if(expectedNSDCGaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGaffiliationFee);
    	}
    	if(expectedNSDCGappealFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGappealFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'2. Training Centre Type Govenment')]]//input[@formcontrolname='appealAmount']")).getAttribute("value"), expectedNSDCGappealFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[2]")).getAttribute("value"), expectedNSDCGappealFee);    		
    	}
    	
    	
    	if(expectedNSDCFirst_AccrediationFee.equals("Yes")) 
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_AccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='accredationAmount']")).getAttribute("value"), expectedNSDCFirst_AccreditationFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='accredationAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_AccrediationFee);   		
    	}
    	if(expectedNSDCFirst_ContinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_ContinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='continuousMonitoringAmount']")).getAttribute("value"), expectedNSDCFirst_ContinousMonitoringFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_ContinuousMonitoringFee);   		
    	}
    	if(expectedNSDCFirst_UNBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_UNBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='unblockingAmount']")).getAttribute("value"), expectedNSDCFirst_UnblockingFeeAmount);    		
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_UNBlockingFee);
    	}
    	if(expectedNSDCFirst_AffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_AffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='affilationAmount']")).getAttribute("value"), expectedNSDCFirst_AffiliationFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='affilationAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_AffiliationFee);   		
    	}
    	if(expectedNSDCFirst_AppealFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_AppealFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'3. Training Centre Type "+first_TCType+"')]]//input[@formcontrolname='appealAmount']")).getAttribute("value"), expectedNSDCFirst_AppealFeeAmount);
    	}
    	else
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='appealAmountIsRequired'])[3]")).getAttribute("value"), expectedNSDCFirst_AppealFee);

    	}
    	
    	Thread.sleep(3000);
    	nstc.clickOnFirst_TCType_Remove();
    	Thread.sleep(3000);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfBlockAttempts']")).getAttribute("value"), expectedNSDCBlockedAttemptAllowedNumber);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='durationOfBlock']")).getAttribute("value"), expectedNSDCDurationOfBlock);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysInAdvanceInspectionDateNotifications']")).getAttribute("value"), expectedNSDCAdvanceInspectionNotification);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysForOnsiteInspectionAfterDeemedReady']")).getAttribute("value"), expectedNSDCOnSiteInspection);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='noOfDaysForInspectionAgencyReplyBackOnAssessment']")).getAttribute("value"), expectedNSDCDaysForReplyBackOnAssessment);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='percentageOnRefusalOfCenterInspection']")).getAttribute("value"), expectedNSDCRefundPercentageForOneweek);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='percentageOnRefusalOfCenterInspection1']")).getAttribute("value"), expectedNSDCRefundPercentageForThreeWeek);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='percentageOnRefusalOfCenterInspection2']")).getAttribute("value"), expectedNSDCRefundPercentageOnInspectionDate);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='refundOnDNRIfTCDoesnotReapply']")).getAttribute("value"), expectedNSDCRefundPercentageOnFirstDNR);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='refundOnSecondDNRIfTCDoesnotReapply']")).getAttribute("value"), expectedNSDCRefundPercentageOnSecondDNR);
    	Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Pick your Date']")).getAttribute("value"), effective_date);
    	Thread.sleep(3000);
    	if(reviewComments.equals("Approved Successfully"))
    	{
    		nstc.clickForApprove_ReviewComment();
    		nstc.enterReviewComment(reviewComments);
    	}
    	else if(reviewComments.equals("Not Approved"))
    	{
    		nstc.clickForNotApprove_ReviewComment();
    		nstc.enterReviewComment(reviewComments);
    	}
    	Thread.sleep(3000);
    	nstc.clickForSubmit();
    	Thread.sleep(3000);
    	nstc.clickOnYes();
    	Thread.sleep(3000);
    	nstc.clickOnOK();
    	Thread.sleep(2000);
    	PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
    }
    
}