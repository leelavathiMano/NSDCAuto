package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.TP_SPOCChangePage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class TPSPOCChangeWorkflowTestSC_10 extends TestConfiguration
{
	@DataProvider
	public Object[][] tpSPOCProfileData()
	{
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TPSPOCChange-Workflow.xls", "TPSPOCChangeSC10TC01");
    }
	
	@Test(dataProvider="tpSPOCProfileData")
	public void tpSPOCInfoTC_01(String tpUsername, String tpPassword, String spocName, String spocEmail, String spocMobileNumber, String mobileOTP, String emailOTP)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		
		TrainingPartnerDashboardPage tpd = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(5000);
		tpd.clickOnChangeMySPOC();
		
		TP_SPOCChangePage tpsp = new TP_SPOCChangePage(driver);
		tpsp.enterTP_SPOCFullName(spocName);
		tpsp.enterTP_SPOCEmailAddress(spocEmail);
		tpsp.enterTP_SPOCMobileNumber(spocMobileNumber);
		Thread.sleep(2000);
		tpsp.clickOnSaveAndNext();
		Thread.sleep(2000);
		tpsp.enterTPIDTextbox(tpUsername);
		tpsp.enterPassword(tpPassword);
		Thread.sleep(2000);
		tpsp.clickOnVerify();
		tpsp.enterMobileOTP(mobileOTP);
		tpsp.enterEmailOTPTextbox(emailOTP);
		Thread.sleep(2000);
		tpsp.clickOnVerify();
		Thread.sleep(2000);
		tpsp.clickOnOk();
		
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	@DataProvider
	public Object[][] tpSPOCChangeProfileData()
	{
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TPSPOCChange-Workflow.xls", "TPSPOCChangeSC10TC02");
    }
	
	@Test(dataProvider="tpSPOCChangeProfileData", dependsOnMethods="tpSPOCInfoTC_01")
	public void tpSPOCChangeTC_02(String tPUsername, String tPPassword, String sPOCName, String oldemail, String oldmobileNumber, String spocMobileOTP, String spocEmailOTP, String newSPOCEmail, String newSPOCMobileNumber)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tPUsername, tPPassword);
		
		TrainingPartnerDashboardPage tpd = new  TrainingPartnerDashboardPage(driver);
		Thread.sleep(5000);
		tpd.clickOnChangeMySPOC();
		
		TP_SPOCChangePage tps = new TP_SPOCChangePage(driver);
		tps.enterTP_SPOCFullName(sPOCName);
		tps.enterTP_SPOCEmailAddress(oldemail);
		String email = driver.findElement(By.xpath("//input[@formcontrolname='email']")).getAttribute("value");
		tps.enterTP_SPOCMobileNumber(oldmobileNumber);
		String mobileNumber = driver.findElement(By.xpath("//input[@formcontrolname='mobileNumber']")).getAttribute("value");
		Thread.sleep(2000);
		tps.clickOnSaveAndNext();
		Thread.sleep(2000);
		tps.enterTPIDTextbox(tPUsername);
		tps.enterPassword(tPPassword);
		Thread.sleep(2000);
		tps.clickOnVerify();
		Thread.sleep(2000);
		tps.enterMobileOTP(spocMobileOTP);
		tps.enterEmailOTPTextbox(spocEmailOTP);
		Thread.sleep(2000);
		tps.clickOnVerify();
		Thread.sleep(2000);

		if(email.equals(oldemail) || mobileNumber.equals(oldmobileNumber)) 
		{
			//Assert.assertEquals(By.xpath(""), );
			Thread.sleep(2000);
			tps.clickOnCancel();
			tps.enterTP_SPOCEmailAddress(newSPOCEmail);
			tps.enterTP_SPOCMobileNumber(newSPOCMobileNumber);
			Thread.sleep(2000);
			tps.clickOnSaveAndNext();
			Thread.sleep(2000);
			tps.enterTPIDTextbox(tPUsername);
			tps.enterPassword(tPPassword);
			Thread.sleep(2000);
			tps.clickOnVerify();
			Thread.sleep(5000);
			tps.enterMobileOTP(spocMobileOTP);
			tps.enterEmailOTPTextbox(spocEmailOTP);
			Thread.sleep(2000);
			tps.clickOnVerify();
			Thread.sleep(2000);
			tps.clickOnOk();
			
		}
		
		else
		{
			tps.enterTP_SPOCEmailAddress(newSPOCEmail);
			tps.enterTP_SPOCMobileNumber(newSPOCMobileNumber);
			Thread.sleep(2000);
			tps.clickOnSaveAndNext();
			Thread.sleep(2000);
			tps.enterTPIDTextbox(tPUsername);
			tps.enterPassword(tPPassword);
			Thread.sleep(2000);
			tps.clickOnVerify();
			tps.enterMobileOTP(spocMobileOTP);
			tps.enterEmailOTPTextbox(spocEmailOTP);
			Thread.sleep(2000);
			tps.clickOnVerify();
			tps.clickOnOk();
		}
		
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(2000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		

	}
}
