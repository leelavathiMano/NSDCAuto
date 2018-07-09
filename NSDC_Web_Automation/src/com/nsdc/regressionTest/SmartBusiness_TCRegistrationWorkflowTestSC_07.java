package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.NSDCAdmin_DashboardPage;
import com.nsdc.pages.NSDC_TCCAAFFormReviewPage;
import com.nsdc.pages.SmartAdmin_DashboardPage;
import com.nsdc.pages.SmartAdmin_TCCAAFFormReviewPage;
import com.nsdc.pages.SmartBusiness_DashboardPage;
import com.nsdc.pages.SmartBusiness_TCSetupReviewPage;
import com.nsdc.testConfig.TestConfiguration;

public class SmartBusiness_TCRegistrationWorkflowTestSC_07 extends TestConfiguration
{
	@DataProvider
	public Object[][] smartBusinessTCRegistrationRuleSetUpData()
	{
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCRuleSC07TC01");
    }
	
	@Test(dataProvider="smartBusinessTCRegistrationRuleSetUpData")
	public void smartBusinessTCRuleSetupTC_01(String sbUsername, String sbPassword, String raccrediationFee, String raccrediationFeeAmount, String rcontinuousMonitoringFee, String rconinuousMonitoringFeeAmount, String runBlockingFee, String runBlockingFeeAmount, String raffiliationFee, String raffiliationFeeAmount, String gaccrediationFee, String gaccrediationFeeAmount, String gcontinuousMonitoringFee, String gconinuousMonitoringFeeAmount, String gunBlockingFee, String gunBlockingFeeAmount, String gaffiliationFee, String gaffiliationFeeAmount, String blockedAttemptAllowedNumber, String durationOfBlock, String advanceInspectionNotification, String onSiteInspection, String daysForReplyBackOnAssessment, String refundPercentageForOneweek, String refundPercentageForThreeWeek, String refundPercentageOnInspectionDate, String refundPercentageOnFirstDNR, String refundPercentageOnSecondDNR) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
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
		sbtc.clickForEffectiveDate();
		sbtc.clickOnCornerOfDateField();
		sbtc.clickOnLastDate();
		sbtc.clickOnCalenderIconButton();
		sbtc.clickForSubmit();
		sbtc.clickForOK();
		
		Thread.sleep(2000);
		sbd.clickOnSmartBusiness1Profile();
		sbd.clickOnSmartBusinessLogOut();
		
		
		
	}
	
	
	@DataProvider
    public Object[][] tcRuleSetupSmartAdminApproval()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCApprovalSC07TC02");
    }
    
    @Test(dataProvider="tcRuleSetupSmartAdminApproval", dependsOnMethods="smartBusinessTCRuleSetupTC_01")
    public void smartBusinessTCRuleApprovalTC_02(String sdUsername, String sdPassword, String expectedRaccrediationFee, String expectedRaccrediationFeeAmount, String expectedRcontinuousMonitoringFee, String expectedRconinuousMonitoringFeeAmount, String expectedRunBlockingFee, String expectedRunBlockingFeeAmount, String expectedRaffiliationFee, String expectedRaffiliationFeeAmount, String expectedGaccrediationFee, String expectedGaccrediationFeeAmount, String expectedGcontinuousMonitoringFee, String expectedGconinuousMonitoringFeeAmount, String expectedGunBlockingFee, String expectedGunBlockingFeeAmount, String expectedGaffiliationFee, String expectedGaffiliationFeeAmount, String expectedBlockedAttemptAllowedNumber, String expectedDurationOfBlock, String expectedAdvanceInspectionNotification, String expectedOnSiteInspection, String expectedDaysForReplyBackOnAssessment, String expectedRefundPercentageForOneweek, String expectedRefundPercentageForThreeWeek, String expectedRefundPercentageOnInspectionDate, String expectedRefundPercentageOnFirstDNR, String expectedRefundPercentageOnSecondDNR, String comments) throws Exception
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.clickLogin();
    	EnterLoginPage elp = new EnterLoginPage(driver);
    	elp.performlogin(sdUsername, sdPassword);
    	
    	SmartAdmin_DashboardPage sad = new SmartAdmin_DashboardPage(driver);
    	Thread.sleep(8000);
    	sad.clickForReviewTCRegistrationSetUp();
    	
    	SmartAdmin_TCCAAFFormReviewPage sdtc = new SmartAdmin_TCCAAFFormReviewPage(driver);
    	Thread.sleep(2000);
    	if(expectedRaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAccredationAmountIsRequired']")).getAttribute("value"), expectedRaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtAccredationAmount']")).getAttribute("value"), expectedRaccrediationFeeAmount);
    	}
    	else if(expectedRaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAccredationAmountIsRequired']")).getAttribute("value"), expectedRaccrediationFee);	
    	}
    	if(expectedRcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedRcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtContinuousMonitoringAmount']")).getAttribute("value"), expectedRconinuousMonitoringFeeAmount);
    	}
    	else if(expectedRcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedRcontinuousMonitoringFee);
    	}
    	if(expectedRunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedRunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtUnblockingAmount']")).getAttribute("value"), expectedRunBlockingFeeAmount);
    	}
    	else if(expectedRunBlockingFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedRunBlockingFee);		
    	}
    	if(expectedRaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAffilationAmountIsRequired']")).getAttribute("value"), expectedRaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtAffilationAmount']")).getAttribute("value"), expectedRaffiliationFeeAmount);
    	}
    	else if(expectedRaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAffilationAmountIsRequired']")).getAttribute("value"), expectedRaffiliationFee);   		
    	}
    	if(expectedGaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAccredationAmountIsRequired']")).getAttribute("value"), expectedGaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularAccredationAmount']")).getAttribute("value"), expectedGaccrediationFeeAmount);
    	}
    	else if(expectedGaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAccredationAmountIsRequired']")).getAttribute("value"), expectedGaccrediationFee);
    	}
    	if(expectedGcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedGcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularContinuousMonitoringAmount']")).getAttribute("value"), expectedGconinuousMonitoringFeeAmount);
    	}
    	else if(expectedGcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedGcontinuousMonitoringFee);
    	}
    	if(expectedGunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedGunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularUnblockingAmount']")).getAttribute("value"), expectedGunBlockingFeeAmount);
    	}
    	else if(expectedGunBlockingFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedGunBlockingFee);
    	}
    	if(expectedGaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAffilationAmountIsRequired']")).getAttribute("value"), expectedGaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularAffilationAmount']")).getAttribute("value"), expectedGaffiliationFeeAmount);
    	}
    	else if(expectedGaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAffilationAmountIsRequired']")).getAttribute("value"), expectedGaffiliationFee);	
    	}
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

    	Thread.sleep(2000);
    	if(comments.equals("Approved Successful"))
    	{
    		sdtc.clickForApprove_ReviewComments();
    		sdtc.enterReviewComments(comments);
    	}
    	else if(comments.equals("Not Approved"))
    	{
    		sdtc.clickForNotApprove_ReviewComments();
    		sdtc.enterReviewComments(comments);
    	}
    	
    	sdtc.clickForSubmit();
    	sdtc.clickOnOK();
    	
    	Thread.sleep(2000);
    	sad.clickOnSmartAdminProfile();
    	sad.clickOnSmartAdminLogOut();
    }
    
    
    @DataProvider
    public Object[][] tcRuleSetupNSDCApproval()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SmartBusiness-Workflow.xls", "SmartBusinessTCApprovalSC07TC03");
    }
    
    @Test(dataProvider="tcRuleSetupNSDCApproval", dependsOnMethods="smartBusinessTCRuleApprovalTC_02")
    public void smartBusinessTCRuleApprovalTC_03(String nsdcUsername, String nsdcPassword, String expectedNSDCRaccrediationFee, String expectedNSDCRaccrediationFeeAmount, String expectedNSDCRcontinuousMonitoringFee, String expectedNSDCRconinuousMonitoringFeeAmount, String expectedNSDCRunBlockingFee, String expectedNSDCRunBlockingFeeAmount, String expectedNSDCRaffiliationFee, String expectedNSDCRaffiliationFeeAmount, String expectedNSDCGaccrediationFee, String expectedNSDCGaccrediationFeeAmount, String expectedNSDCGcontinuousMonitoringFee, String expectedNSDCGconinuousMonitoringFeeAmount, String expectedNSDCGunBlockingFee, String expectedNSDCGunBlockingFeeAmount, String expectedNSDCGaffiliationFee, String expectedNSDCGaffiliationFeeAmount, String expectedNSDCBlockedAttemptAllowedNumber, String expectedNSDCDurationOfBlock, String expectedNSDCAdvanceInspectionNotification, String expectedNSDCOnSiteInspection, String expectedNSDCDaysForReplyBackOnAssessment, String expectedNSDCRefundPercentageForOneweek, String expectedNSDCRefundPercentageForThreeWeek, String expectedNSDCRefundPercentageOnInspectionDate, String expectedNSDCRefundPercentageOnFirstDNR, String expectedNSDCRefundPercentageOnSecondDNR, String reviewComments) throws Exception
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.clickLogin();
    	EnterLoginPage elp = new EnterLoginPage(driver);
    	elp.performlogin(nsdcUsername, nsdcPassword);
    	
    	NSDCAdmin_DashboardPage nsd = new NSDCAdmin_DashboardPage(driver);
    	Thread.sleep(8000);
    	nsd.clickForReviewTCRegistrationSetup();
    	
    	NSDC_TCCAAFFormReviewPage nstc = new NSDC_TCCAAFFormReviewPage(driver);
    	Thread.sleep(2000);
    	if(expectedNSDCRaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAccredationAmountIsRequired']")).getAttribute("value"), expectedNSDCRaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtAccredationAmount']")).getAttribute("value"), expectedNSDCRaccrediationFeeAmount);
    	}
    	else if(expectedNSDCRaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAccredationAmountIsRequired']")).getAttribute("value"), expectedNSDCRaccrediationFee);
    	}
    	if(expectedNSDCRcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedNSDCRcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtContinuousMonitoringAmount']")).getAttribute("value"), expectedNSDCRconinuousMonitoringFeeAmount);
    	}
    	else if(expectedNSDCRcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedNSDCRcontinuousMonitoringFee);	
    	}
    	if(expectedNSDCRunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCRunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtUnblockingAmount']")).getAttribute("value"), expectedNSDCRunBlockingFeeAmount);
    	}
    	else if(expectedNSDCRunBlockingFee.equals("No"))
    	{
        	Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCRunBlockingFee);    		
    	}
    	if(expectedNSDCRaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAffilationAmountIsRequired']")).getAttribute("value"), expectedNSDCRaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='govtAffilationAmount']")).getAttribute("value"), expectedNSDCRaffiliationFeeAmount);
    	}
    	else if(expectedNSDCRaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='govtAffilationAmountIsRequired']")).getAttribute("value"), expectedNSDCRaffiliationFee);
    	}
    	if(expectedNSDCGaccrediationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAccredationAmountIsRequired']")).getAttribute("value"), expectedNSDCGaccrediationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularAccredationAmount']")).getAttribute("value"), expectedNSDCGaccrediationFeeAmount);
    	}
    	else if(expectedNSDCGaccrediationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAccredationAmountIsRequired']")).getAttribute("value"), expectedNSDCGaccrediationFee);
    	}
    	if(expectedNSDCGcontinuousMonitoringFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedNSDCGcontinuousMonitoringFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularContinuousMonitoringAmount']")).getAttribute("value"), expectedNSDCGconinuousMonitoringFeeAmount);
    	}
    	else if(expectedNSDCGcontinuousMonitoringFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularContinuousMonitoringAmountIsRequired']")).getAttribute("value"), expectedNSDCGcontinuousMonitoringFee); 		
    	}
    	if(expectedNSDCGunBlockingFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCGunBlockingFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularUnblockingAmount']")).getAttribute("value"), expectedNSDCGunBlockingFeeAmount);
    	}
    	else if(expectedNSDCGunBlockingFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularUnblockingAmountIsRequired']")).getAttribute("value"), expectedNSDCGunBlockingFee);
    	}
    	if(expectedNSDCGaffiliationFee.equals("Yes"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAffilationAmountIsRequired']")).getAttribute("value"), expectedNSDCGaffiliationFee);
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='regularAffilationAmount']")).getAttribute("value"), expectedNSDCGaffiliationFeeAmount);
    	}
    	else if(expectedNSDCGaffiliationFee.equals("No"))
    	{
    		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='regularAffilationAmountIsRequired']")).getAttribute("value"), expectedNSDCGaffiliationFee);
    	}
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

    	
    	Thread.sleep(2000);
    	if(reviewComments.equals("Approved Successful"))
    	{
    		nstc.clickForApprove_ReviewComment();
    		nstc.enterReviewComment(reviewComments);
    	}
    	else if(reviewComments.equals("Not Approved"))
    	{
    		nstc.clickForNotApprove_ReviewComment();
    		nstc.enterReviewComment(reviewComments);
    	}
    	nstc.clickForSubmit();
    	nstc.clickOnOK();
    	
    	Thread.sleep(2000);
    	nsd.clickOnNSDCProfile();
    	nsd.clickOnNSDCLogOut();
    
    }
    
}