package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ToT, ToA, ToMT,ToMA")));
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"ssc","!!! Login Unsuccessfull OR its taking too much time to load!!! ");
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.clickAllBatches();
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
		sAp.enterBatchIDToSearch(batchID);
		sAp.clickToGetSearchResult();
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
		sAp.clickToGetBatchActionMenu(batchID);
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'Assign')]")).click();	
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Add Exceptional Training Centre
		SSC_ExceptionalTraningCentreCreationPage eTCp=new SSC_ExceptionalTraningCentreCreationPage(driver);
		eTCp.clickAddExceptionalTC();
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
		eTCp.enterTrainingPartnerName(tpName);
		eTCp.enterExceptionalTrainingCentreName(exceptionalTCName);
		eTCp.enterWebsite(website);
		eTCp.enterExceptionalTrainingCentreCapacity(capacity);
		if(!smartID.equalsIgnoreCase("N/A"))
		{
			eTCp.enterSmartIDforExceptionalTC(smartID);
		}
		eTCp.selectResidentialFacilityAvailableForAll();
		eTCp.enterExceptionalTrainingCentreHeadName(exceptionalTCHeadName);
		eTCp.enterExceptionalTrainingCentreHeadMobile(exceptionalTCHeadMobile);
		eTCp.enterExceptionalTrainingCentreHeadEmail(exceptionalTCHeadEmail);
		eTCp.enterExceptionalTrainingCentreSPOCName(exceptionalTCSPOCName);
		eTCp.enterExceptionalTrainingCentreSPOCMobile(exceptionalTCSPOCMobile);
		eTCp.enterExceptionalTrainingCentreSPOCEmail(exceptionalTCSPOCEmail);
		Thread.sleep(2000);
		eTCp.clickToBrowseExceptionalTCSPOCIDProof();
		UploadFile.upload(exceptionalTCSPOCID);
		eTCp.clickToUploadExceptionalTCSPOCIDProof();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
		if(!exceptionalTCAddress.equalsIgnoreCase("N/A"))
		{
			eTCp.enterExceptionalTCAddress(exceptionalTCAddress);
		}
		if(!exceptionalTCLandmark.equalsIgnoreCase("N/A"))
		{
			eTCp.enterExceptionalTCLandmark(exceptionalTCLandmark);
		}
		Assert.assertTrue(driver.findElement(By.xpath("//div[span[span[contains(text(),'"+country+"')]]]")).getAttribute("class").contains("disabled"),"OMG!!! Country dropdown is not disabled OR Something went wrong! ");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'"+country+"')]")).getText().trim(), country);
		eTCp.selectExceptionalTCState(state);
		Thread.sleep(4000);
		eTCp.selectExsceptionalTCDistrict(district);
		Thread.sleep(4000);
		if(!subDistrict.equalsIgnoreCase("N/A"))
		{
			eTCp.selectExceptionalTCSubDistrict(subDistrict);
			Thread.sleep(4000);
		}
		if(!constituency.equalsIgnoreCase("N/A"))
		{
			eTCp.selectExceptionalTCConstituency(constituency);
			Thread.sleep(4000);
		}
		eTCp.enterExceptionalTrainingCentreGeoLocation(geoLocation);
		if(!village.equalsIgnoreCase("N/A"))
		{
			eTCp.enterExceptionalTrainingCentreVillage(village);
		}
		eTCp.enterExceptionalTrainingCentrePincode(pincode);
		eTCp.clickToBrowseExceptionalTrainingCentrePhoto();
		UploadFile.uploadingFiveExceptionalTC_Photos(exceptionalTCPhoto);
		eTCp.clickToUploadExceptionalTrainingCentrePhoto();
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
		eTCp.clickToBrowseExceptionalTrainingCentreSupportDoc();
		UploadFile.upload(exceptionalTCSupportDoc);
		eTCp.clickToUploadExceptionalTrainingCentreSupportDoc();
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
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
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("swal2-title")));
			Assert.assertTrue(driver.findElement(By.id("swal2-content")).getText().contains("success"),"OMG!!! Something went wrong! After clicking Add Button!");
			String createdExceptionalTCID=driver.findElement(By.xpath("//div[@id='swal2-content']/p/b")).getText().trim();
			ReadWriteData.setExcelData("./TestData/Workflow/SSC_ExceptionalTrainingCentre-Workflow.xls", "ExceptionalTC-Creation", Integer.parseInt(serialNum), 1, createdExceptionalTCID);
			SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
			sscTbcP.clickOk();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			lp.clickLogin();
			elp.performlogin(createdExceptionalTCID, "ekaushal");
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
			RegistrationPage rp = new RegistrationPage(driver);
			rp.enterOldPassword("ekaushal");
		    rp.enterNewPassword("Qwerty@123");
		    rp.enterConfirmPassword("Qwerty@123");
		    rp.clickResetResubmit();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
		    rp.clickConfirmationOkMessage();
		    elp.performlogin(createdExceptionalTCID, "Qwerty@123");
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
		    plp.clickOnProfileLogo();
		    Thread.sleep(2000);
		    plp.clickOnLogout();
		    Thread.sleep(2000);
		}
		else
		{
			eTCp.clickToAssignCurrentlyCreatingExceptionalTrainingCentre();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("swal2-title")));
			Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("Assigned Successfully"),"OMG!!! Something went wrong! After clicking Assign Button!");
			eTCp.clickOK();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'EXPTC_')]]/td[span[contains(text(),'Assigned')]]")).getText().trim(), "Assigned");
			String createdExceptionalTCID=driver.findElement(By.xpath("//td[contains(text(),'EXPTC_')]")).getText().trim();
			ReadWriteData.setExcelData("./TestData/Workflow/SSC_ExceptionalTrainingCentre-Workflow.xls", "ExceptionalTC-Creation", Integer.parseInt(serialNum), 1,createdExceptionalTCID);
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			lp.clickLogin();
			elp.performlogin(createdExceptionalTCID, "ekaushal");
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
			RegistrationPage rp = new RegistrationPage(driver);
			rp.enterOldPassword("ekaushal");
			rp.enterNewPassword("Qwerty@123");
			rp.enterConfirmPassword("Qwerty@123");
			rp.clickResetResubmit();
			Thread.sleep(2000);
			rp.clickConfirmationOkMessage();
			elp.performlogin(createdExceptionalTCID, "Qwerty@123");
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			Thread.sleep(2000);
		} 
	}
}