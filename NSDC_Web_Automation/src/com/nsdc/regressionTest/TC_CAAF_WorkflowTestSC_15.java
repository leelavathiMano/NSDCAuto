package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AddTrainingCentrePage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PMKKSPOC_AccrediationAndAffiliationPage;
import com.nsdc.pages.PMKKSPOC_DashboardPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class TC_CAAF_WorkflowTestSC_15 extends TestConfiguration
{
	@DataProvider
	public Object[][] addTrainingCentre()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "AddTrainingCentreSC15TC01");
	}
	
	@Test(dataProvider="addTrainingCentre")
	public void addTrainingCentreTC_01(String srno, String tpUsername, String tpPassword, String processType, String tcType, String tcName, String tcAddress, String landmark, String pincode, String state, String district, String tehsil, String city, String parliamentryConstituency, String geoLocation, String addressProof, String addressProofFile, String SPOC_Name, String SPOC_EmailAddress, String spoc_MobileNumber, String centreHeadName, String centreHeadEmail, String centreHeadMobile, String pmkkHubID, String mOU_File, String tcID, String pmkkSPOC_ID, String pmkkSPOC_Password, String reviewComment)throws Exception
	{
		int sno = Integer.parseInt(srno);
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(10000);
		tpdp.clickOnAddTrainingCentre();
		Thread.sleep(4000);
		tpdp.selectForProcessType(processType);
		tpdp.selectTrainingCentreType(tcType);
		tpdp.clickOnSaveAndContinue();
		AddTrainingCentrePage atc = new AddTrainingCentrePage(driver);
		Thread.sleep(3000);
		atc.enterTrainingCentreName(tcName);
		atc.enterAddress(tcAddress);
		atc.enterNearByLandmark(landmark);
		atc.enterPincode(pincode);
		atc.selectState(state);
		atc.selectDistrict(district);
		atc.selectTehsil(tehsil);
		atc.selectCity(city);
		atc.selectParliamentryConstituency(parliamentryConstituency);
		atc.enterGeoLocation(geoLocation);
		atc.selectAddressProof(addressProof);
		atc.clickOnAddressProof_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(addressProofFile);
		Thread.sleep(3000);
		atc.clickOnAddressProof_UploadFile();
		Thread.sleep(3000);
		atc.enterNameOfTheSPOC(SPOC_Name);
		atc.enter_SPOC_EmailAddress(SPOC_EmailAddress);
		atc.enter_SPOC_MobileNumber(spoc_MobileNumber);
		atc.enterCentreHeadName(centreHeadName);
		atc.enterCentreHeadEmailAddress(centreHeadEmail);
		atc.enterCentreHeadMobileNumber(centreHeadMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='trainingCenterType']")).getAttribute("value").substring(3), tcType);
		if(tcType.equals("PMKK SPOKE"))
		{
			atc.enterPMKK_HUB_ID(pmkkHubID);
			atc.clickOnVerify();
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='processType']")).getAttribute("value"), "Accreditation & Affiliation");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='processType']")).getAttribute("value"), "Accreditation & Affiliation");
		}
		
		Thread.sleep(3000);
		atc.clickOnUploadMOU_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(mOU_File);
		Thread.sleep(3000);
		atc.clickOnUploadMOU_UploadFile();
		Thread.sleep(3000);
		atc.clickOnSubmit();
		Thread.sleep(3000);
		atc.clickOnYesAddTrainingCentre();
		Thread.sleep(3000);
		atc.clickOnClose();
		tcID = driver.findElement(By.xpath("(//td[@data-field='RecordID']/span)[1]")).getText();
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "AddTrainingCentreSC15TC01", sno, 25, tcID);
		if(tcType.equals("Government") || tcType.equals("NON PMKK"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[contains(text(),'"+tcID+"')]]]//span[text()='Registered']")).getText(), "Registered");
			PostLoginPage plp = new PostLoginPage(driver);
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[contains(text(),'"+tcID+"')]]]//span[text()='Awaiting PMKk SPOC Approval']")).getText(), "Awaiting PMKk SPOC Approval");
			PostLoginPage plp = new PostLoginPage(driver);
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			lp.clickLogin();
			elp.performlogin(pmkkSPOC_ID, pmkkSPOC_Password);
			PMKKSPOC_DashboardPage pmkk = new PMKKSPOC_DashboardPage(driver);
			Thread.sleep(5000);
			pmkk.clickOnaddingTCRequest();
			PMKKSPOC_AccrediationAndAffiliationPage acaf = new PMKKSPOC_AccrediationAndAffiliationPage(driver);
			//Thread.sleep(3000);
			//acaf.enterSearchForKeyword(tcID);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tcID+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[span[text()='"+tcID+"']]]//a[contains(text(),'Approve/Reject')]")).click();
			Thread.sleep(3000);
			acaf.clickOnApproved();
			acaf.enterReviewComments(reviewComment);
			Thread.sleep(3000);
			acaf.clickOnSubmit();
			Thread.sleep(3000);
			acaf.clickOnOK();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
		}
	
	}

}
