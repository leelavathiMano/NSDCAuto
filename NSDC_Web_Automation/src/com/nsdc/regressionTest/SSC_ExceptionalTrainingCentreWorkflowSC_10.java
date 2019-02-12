package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ExceptionalTraningCentreCreationPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
import com.nsdc.testConfig.TestConfiguration;

public class SSC_ExceptionalTrainingCentreWorkflowSC_10 extends TestConfiguration
{
	@DataProvider
	public Object[][] sscTemporaryTrainingCentreCreationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SSC_ExceptionalTrainingCentre-Workflow.xls","ExceptionalTC-Creation");
	}
	@Test(dataProvider="sscTemporaryTrainingCentreCreationData")
	public void createExceptionalTraningCentreTC_01(String serialNum, String exceptionalTCID, String sscUsername, String sscPassword, String batchID, String tpName, String exceptionalTCName, String website, String capacity, String smartID, String residentialFacilityAvailableFor, String exceptionalTCHeadName, String exceptionalTCHeadMobile, String exceptionalTCHeadEmail, String exceptionalTCSPOCName, String exceptionalTCSPOCMobile, String exceptionalTCSPOCEmail, String exceptionalTCSPOCID, String exceptionalTCAddress, String exceptionalTCLandmark, String country, String state, String district, String subDistrict, String constituency, String geoLocation, String village, String pincode, String exceptionalTCPhoto, String exceptionalTCSupportDoc, String sector, String subSector, String jobRole) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		Thread.sleep(20000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickToTToAToMTToMA();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		sscDbP.clickAllBatches();
		Thread.sleep(5000);
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.enterBatchIDToSearch(batchID);
		Thread.sleep(5000);
		sAp.clickToGetSearchResult();
		Thread.sleep(5000);
		sAp.clickToGetBatchActionMenu(batchID);
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'Assign')]")).click();	
		Thread.sleep(5000);
		//Add Exceptional Training Centre
		SSC_ExceptionalTraningCentreCreationPage eTCp=new SSC_ExceptionalTraningCentreCreationPage(driver);
		eTCp.clickAddExceptionalTC();
		Thread.sleep(4000);
		eTCp.enterTrainingPartnerName(tpName);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreName(exceptionalTCName);
		Thread.sleep(4000);
		eTCp.enterWebsite(website);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreCapacity(capacity);
		Thread.sleep(4000);
		eTCp.enterSmartIDforExceptionalTC(smartID);
		Thread.sleep(3000);
		eTCp.selectResidentialFacilityAvailableForAll();
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreHeadName(exceptionalTCHeadName);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreHeadMobile(exceptionalTCHeadMobile);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreHeadEmail(exceptionalTCHeadEmail);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreSPOCName(exceptionalTCSPOCName);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreSPOCMobile(exceptionalTCSPOCMobile);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreSPOCEmail(exceptionalTCSPOCEmail);
		Thread.sleep(4000);
		eTCp.clickToBrowseExceptionalTCSPOCIDProof();
		Thread.sleep(4000);
		UploadFile.upload(exceptionalTCSPOCID);
		Thread.sleep(4000);
		eTCp.clickToUploadExceptionalTCSPOCIDProof();
		Thread.sleep(8000);
		eTCp.enterExceptionalTCAddress(exceptionalTCAddress);
		Thread.sleep(4000);
		eTCp.enterExceptionalTCLandmark(exceptionalTCLandmark);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[span[span[contains(text(),'"+country+"')]]]")).getAttribute("class").contains("disabled"),"OMG!!! Country dropdown is not disabled OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+country+"')]")).getText().trim(), country);
		eTCp.selectExceptionalTCState(state);
		Thread.sleep(4000);
		eTCp.selectExsceptionalTCDistrict(district);
		Thread.sleep(4000);
		eTCp.selectExceptionalTCSubDistrict(subDistrict);
		Thread.sleep(4000);
		eTCp.selectExceptionalTCConstituency(constituency);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreGeoLocation(geoLocation);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentreVillage(village);
		Thread.sleep(4000);
		eTCp.enterExceptionalTrainingCentrePincode(pincode);
		Thread.sleep(4000);
		eTCp.clickToBrowseExceptionalTrainingCentrePhoto();
		Thread.sleep(4000);
		UploadFile.uploadingFiveExceptionalTC_Photos(exceptionalTCPhoto);
		Thread.sleep(4000);
		eTCp.clickToUploadExceptionalTrainingCentrePhoto();
		Thread.sleep(8000);
		eTCp.clickToBrowseExceptionalTrainingCentreSupportDoc();
		Thread.sleep(4000);
		UploadFile.upload(exceptionalTCSupportDoc);
		Thread.sleep(4000);
		eTCp.clickToUploadExceptionalTrainingCentreSupportDoc();
		Thread.sleep(8000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[span[span[contains(text(),'"+sector+"')]]]")).getAttribute("class").contains("disabled"),"OMG!!! Sector dropdown is not disabled OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//span[span[contains(text(),'"+sector+"')]]")).getText().trim(), sector);
		eTCp.selectExceptionalTrainingCentreSubSector(subSector);
		Thread.sleep(4000);
		eTCp.selectExceptionalTrainingCentreJobRole(jobRole);
		Thread.sleep(4000);
		eTCp.clickToAddJobRole();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[p[contains(text(),'"+jobRole+"')]]]")).size()==1,"OMG!!! No show of Added JobRole record OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'"+sector+"')]]]//td[1]")).getText().trim(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'"+sector+"')]]]//td[2]")).getText().trim(), subSector);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'"+sector+"')]]]//td[3]")).getText().trim(), jobRole);
		//Deleting Added JobRole
		if(serialNum.equals("1"))
		{
			eTCp.clickToDeleteAddedJobRole();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[p[contains(text(),'"+jobRole+"')]]]")).size()==0,"OMG!!! Deleted JobRole record present OR Something went wrong! ");
			//Again Adding Deleted JobRole
			eTCp.selectExceptionalTrainingCentreSubSector(subSector);
			Thread.sleep(4000);
			eTCp.selectExceptionalTrainingCentreJobRole(jobRole);
			Thread.sleep(4000);
			eTCp.clickToAddJobRole();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[p[contains(text(),'"+jobRole+"')]]]")).size()==1,"OMG!!! No show of Added JobRole record OR Something went wrong! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'"+sector+"')]]]//td[1]")).getText().trim(), sector);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'"+sector+"')]]]//td[2]")).getText().trim(), subSector);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[p[contains(text(),'"+sector+"')]]]//td[3]")).getText().trim(), jobRole);
		}
		eTCp.clickToConfirmDeclaration();
		Thread.sleep(4000);
		if(serialNum.equals("1")) //Assigning Created Exceptional TC Directly to a Batch
		{
			eTCp.clickToFinallyCreateExceptionalTrainingCentre();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast-message']")).size()==0,"OMG!!! Add - Toast Message exists, Either Duplicate SPOC credentials OR Something went wrong! ");
			Assert.assertTrue(driver.findElements(By.id("swal2-title")).size()!=0,"OMG!!! Something went wrong! After clicking Add Button!");
			Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().contains("success"));
			String createdExceptionalTCID=driver.findElement(By.xpath("//div[@id='swal2-content']/p/b")).getText().trim();
			ReadWriteData.setExcelData("./TestData/Workflow/SSC_ExceptionalTrainingCentre-Workflow.xls", "ExceptionalTC-Creation", Integer.parseInt(serialNum), 1, createdExceptionalTCID);
			SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
			sscTbcP.clickOk();
			Thread.sleep(4000);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(4000);
			lp.clickLogin();
			elp.performlogin(createdExceptionalTCID, "ekaushal");
			Thread.sleep(4000);
			RegistrationPage rp = new RegistrationPage(driver);
			rp.enterOldPassword("ekaushal");
		    rp.enterNewPassword("Qwerty@123");
		    rp.enterConfirmPassword("Qwerty@123");
		    rp.clickResetResubmit();
		    Thread.sleep(2000);
		    rp.clickConfirmationOkMessage();
		    elp.performlogin(createdExceptionalTCID, "Qwerty@123");
		    Thread.sleep(8000);
		    plp.clickOnProfileLogo();
		    Thread.sleep(2000);
		    plp.clickOnLogout();
		    Thread.sleep(2000);
		}
		else
		{
			eTCp.clickToAssignCurrentlyCreatingExceptionalTrainingCentre();
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElements(By.xpath("//div[@class='toast-message']")).size()==0,"OMG!!! Assign - Toast Message exists, Either Duplicate SPOC credentials OR Something went wrong! ");
			Assert.assertTrue(driver.findElements(By.id("swal2-title")).size()!=0,"OMG!!! Something went wrong! After clicking Assign Button!");
			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("Assigned Successfully"));
			eTCp.clickOK();
			Thread.sleep(4000);
			Assert.assertTrue(driver.getCurrentUrl().replaceAll("/", "").contains("batch-assignment"),"OMG!!! Assign Just Created TC Button is not naviogated to Batch Assignment Page OR Something is wrong! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'EXPTC_')]]/td[span[contains(text(),'Assigned')]]")).getText().trim(), "Assigned");
			String createdExceptionalTCID=driver.findElement(By.xpath("//td[contains(text(),'EXPTC_')]")).getText().trim();
			ReadWriteData.setExcelData("./TestData/Workflow/SSC_ExceptionalTrainingCentre-Workflow.xls", "ExceptionalTC-Creation", Integer.parseInt(serialNum), 1,createdExceptionalTCID);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(4000);
			lp.clickLogin();
			elp.performlogin(createdExceptionalTCID, "ekaushal");
			Thread.sleep(4000);
			RegistrationPage rp = new RegistrationPage(driver);
			rp.enterOldPassword("ekaushal");
			rp.enterNewPassword("Qwerty@123");
			rp.enterConfirmPassword("Qwerty@123");
			rp.clickResetResubmit();
			Thread.sleep(2000);
			rp.clickConfirmationOkMessage();
			elp.performlogin(createdExceptionalTCID, "Qwerty@123");
			Thread.sleep(8000);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		} 
	}
}