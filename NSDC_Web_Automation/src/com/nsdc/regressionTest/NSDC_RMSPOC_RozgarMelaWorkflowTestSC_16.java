package com.nsdc.regressionTest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.NSDC_RozgarMelaSPOC_CreateRozgarMelaPage;
import com.nsdc.pages.NSDC_RozgarMelaSPOC_DashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class NSDC_RMSPOC_RozgarMelaWorkflowTestSC_16 extends TestConfiguration
{
	@DataProvider
	public Object[][] createRozgarMelaData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela");
	}
	@Test(dataProvider="createRozgarMelaData")
	public void createRozgarMelaTC_01(String serialNum, String cretaedRozgarMelaID, String rmspocID, String rmspocPassword, String rozgarMelaName, String typeOfRozgarMela, String targetAudience, String chiefGuestTitle, String chiefGuestSalutation, String chiefGuestName, String eligibilityCriteria, String startDate, String endDate, String startTime, String endTime, String address, String landmark, String pincode, String state, String district, String tehsil, String village, String parlimentaryConstituency, String geoLocation, String additionalRemarks, String alignTC, String alignSSC, String statusFilterOption) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(rmspocID, rmspocPassword);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
		while(ele.size()!=0)
		{
			Assert.assertFalse(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().trim().contains("Deactiv"),"OMG!!! RozgarSPOC - "+rmspocID+" Account Deactivated. Kindly contact NSDC Admin! ");
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		NSDC_RozgarMelaSPOC_DashboardPage rmDp=new NSDC_RozgarMelaSPOC_DashboardPage(driver);
		rmDp.clickCreateRozgarMelas();
		NSDC_RozgarMelaSPOC_CreateRozgarMelaPage rmCp=new NSDC_RozgarMelaSPOC_CreateRozgarMelaPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains("create-rozgar"));
		if(driver.findElements(By.id("name")).size()==0)
		{
			driver.navigate().refresh();
		}
		rmCp.enterRozgarMelaName(rozgarMelaName);
		Assert.assertEquals(driver.findElement(By.id("typeOfMela")).getAttribute("value").trim(), typeOfRozgarMela);
		rmCp.selectTargetAudience(targetAudience);
		rmCp.selectChiefGuestTitle(chiefGuestTitle);
		rmCp.selectChiefGuestSalutation(chiefGuestSalutation);
		rmCp.enterChiefGuestName(chiefGuestName);
		rmCp.selectEligibilityCriteria(eligibilityCriteria);
		rmCp.chooseRozgarMelaStartDate();
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.chooseRozgarMelaEndDate();
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.enterRozgarMelaStartTime(startTime);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.enterRozgarMelaEndTime(endTime);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.enterRozgarMelaAddress(address);
		int rowNum=Integer.parseInt(serialNum);
		String startDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela", rowNum, 11, startDateHipen);
		String endDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela", rowNum, 12, endDateHipen);
		if(!landmark.equalsIgnoreCase("N/A"))
		{
			rmCp.enterLandmark(landmark);
		}
		rmCp.enterPincode(pincode);
		rmCp.selectState(state);
		rmCp.selectDistrict(district);
		if(!tehsil.equalsIgnoreCase("N/A"))
		{
			rmCp.selectTehsil(tehsil);
		}
		if(!village.equalsIgnoreCase("N/A"))
		{
			rmCp.selectVillage(village);
		}
		if(!parlimentaryConstituency.equalsIgnoreCase("N/A"))
		{
			rmCp.selectParlimentaryConstituency(parlimentaryConstituency);
		}
		
		if(!additionalRemarks.equalsIgnoreCase("N/A"))
		{
			rmCp.enterAdditionalRemarks(additionalRemarks);
		}
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Next')]")).isEnabled(), "OMG!!! Next Button is disabled, something is wrong!!! ");
		rmCp.clickToCreateMelaAndAlignTrainingCentre();
		wait.until(ExpectedConditions.urlContains("align-training-centres"));
		Assert.assertTrue(driver.getCurrentUrl().contains("align-training-centres"),"OMG!!! Navigation to Align Training Centre page is unsuccessful OR Something wrong! ");
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickToSelectAllTrainingCentres();
		rmCp.clickToAlignSelectedTrainingCentres();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("aligned"));
		rmCp.clickOK();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("swal2-title")));
		js.executeScript("window.scrollBy(0,-1000)", "");
		rmCp.clickSaveAndAlignSSCs();
		wait.until(ExpectedConditions.urlContains("align-ssc"));
		Assert.assertTrue(driver.getCurrentUrl().contains("align-ssc"),"OMG!!! Navigation to Align SSCs page is unsuccessful OR Something wrong! ");
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickToSelectAllSSCs();
		rmCp.clickToAlignSelectedSSCs();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("aligned"));
		rmCp.clickOK();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save & Create Rozgar Mela')]")));
		js.executeScript("window.scrollBy(0,-1000)", "");
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Save & Create Rozgar Mela')]")).isEnabled(),"OMG!!! Save & Create Rozgar Mela, button should be enabled after selecting SSCs! ");
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickToSaveAndCreateRozgarMela();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),'You have successfully created a')]/span)[2]")));
		Assert.assertTrue(driver.getCurrentUrl().contains("create-rozgar-mela-success"),"OMG!!! Navigation to Create Rozgar Mela Success page is unsuccessful OR Something wrong! ");
		String createdRozgarMelaID=driver.findElement(By.xpath("(//p[contains(text(),'You have successfully created a')]/span)[2]")).getText().trim().replace('"', ' ').replaceAll(" ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela", rowNum, 1, createdRozgarMelaID);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickAnnounceToStakeholders();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Notification has been sent to stakeholders");
		rmCp.clickOK();
		wait.until(ExpectedConditions.urlContains("view-rozgar-melas"));
		Assert.assertTrue(driver.getCurrentUrl().contains("view-rozgar-melas"),"OMG!!! Navigation to View Rozgar Melas page is unsuccessful OR Something wrong! ");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
}