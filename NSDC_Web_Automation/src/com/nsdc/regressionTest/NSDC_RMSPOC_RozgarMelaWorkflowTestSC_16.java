package com.nsdc.regressionTest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import com.nsdc.pages.NSDC_RozgarMelaSPOC_ViewRozgarMelasPage;
import com.nsdc.testConfig.TestConfiguration;

public class NSDC_RMSPOC_RozgarMelaWorkflowTestSC_16 extends TestConfiguration
{
	@DataProvider
	public Object[][] createRozgarMelaData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela");
	}
	@Test(dataProvider="createRozgarMelaData")
	public void createRozgarMelaTC_01(String serialNum, String cretaedRozgarMelaID, String rmspocID, String rmspocPassword, String rozgarMelaName, String typeOfRozgarMela, String targetAudience, String chiefGuestTitle, String chiefGuestName, String startDate, String endDate, String startTime, String endTime, String address, String landmark, String pincode, String state, String district, String tehsil, String village, String parlimentaryConstituency, String geoLocation, String additionalRemarks, String alignTC, String alignSSC, String statusFilterOption) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(rmspocID, rmspocPassword);
		Thread.sleep(2000);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
		while(ele.size()!=0)
		{
			Assert.assertFalse(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().trim().contains("Deactiv"),"OMG!!! RozgarSPOC - "+rmspocID+" Account Deactivated. Kindly contact NSDC Admin! ");
		}
		Thread.sleep(4000);
		String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"rozgarmelaspoc","Login Unsuccessfull");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		NSDC_RozgarMelaSPOC_DashboardPage rmDp=new NSDC_RozgarMelaSPOC_DashboardPage(driver);
		rmDp.clickCreateRozgarMelas();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"rozgarmelaspoccreate-rozgar-mela");
		NSDC_RozgarMelaSPOC_CreateRozgarMelaPage rmCp=new NSDC_RozgarMelaSPOC_CreateRozgarMelaPage(driver);
		rmCp.enterRozgarMelaName(rozgarMelaName);
		Thread.sleep(2000);
		rmCp.selectTypeOfRozgarMela(typeOfRozgarMela);
		Thread.sleep(2000);
		rmCp.selectTargetAudience(targetAudience);
		Thread.sleep(2000);
		rmCp.selectChiefGuestTitle(chiefGuestTitle);
		Thread.sleep(2000);
		rmCp.enterChiefGuestName(chiefGuestName);
		Thread.sleep(2000);
		rmCp.chooseRozgarMelaStartDate();
		Thread.sleep(2000);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		Thread.sleep(2000);
		rmCp.chooseRozgarMelaEndDate();
		Thread.sleep(2000);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		Thread.sleep(2000);
		rmCp.enterRozgarMelaStartTime(startTime);
		Thread.sleep(2000);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		Thread.sleep(2000);
		rmCp.enterRozgarMelaEndTime(endTime);
		Thread.sleep(2000);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		Thread.sleep(2000);
		rmCp.enterRozgarMelaAddress(address);
		Thread.sleep(2000);
		int rowNum=Integer.parseInt(serialNum);
		String startDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela", rowNum, 9, startDateHipen);
		String endDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela", rowNum, 10, endDateHipen);
		rmCp.enterLandmark(landmark);
		Thread.sleep(2000);
		rmCp.enterPincode(pincode);
		Thread.sleep(2000);
		rmCp.selectState(state);
		Thread.sleep(2000);
		rmCp.selectDistrict(district);
		Thread.sleep(2000);
		rmCp.selectTehsil(tehsil);
		Thread.sleep(2000);
		rmCp.selectVillage(village);
		Thread.sleep(2000);
		rmCp.selectParlimentaryConstituency(parlimentaryConstituency);
		Thread.sleep(2000);
		rmCp.enterGeoLocation(geoLocation);
		Thread.sleep(2000);
		rmCp.clickDisplayedGeoLocationSugestions(geoLocation);
		Thread.sleep(2000);
		rmCp.enterAdditionalRemarks(additionalRemarks);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Create Mela & Align Training Centre')]")).isEnabled(), "OMG!!! CreateMelaAndAlignTrainingCentre Button is disabled, something is wrong!!! ");
		rmCp.clickToCreateMelaAndAlignTrainingCentre();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"rozgarmelaspoccreate-rozgar-melaalign-training-centres","OMG!!! Navigation to Align Training Centre page is unsuccessful OR Something wrong! ");
		rmCp.clickToSelectAllTrainingCentres();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'Selected 10 TCs:')]")).getText().trim(), "Selected 10 TCs:");
		rmCp.clickToAlignSelectedTrainingCentres();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Selected Training Centre has been aligned");
		rmCp.clickOK();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='card col-md-4 margin-right-card card-two']/div[@class='numeric-style']")).getText().trim(), "10");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='card col-md-4 margin-right-card card-two']/div[@class='card-text']/p[1]")).getText().trim(), "Participating Training Centres");
		rmCp.clickSaveAndAlignSSCs();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"rozgarmelaspoccreate-rozgar-melaalign-training-centresalign-ssc","OMG!!! Navigation to Align SSCs page is unsuccessful OR Something wrong! ");
		Assert.assertFalse(driver.findElement(By.xpath("//button[contains(text(),'Save & Create Rozgar Mela')]")).isEnabled(),"OMG!!! Save & Create Rozgar Mela, button should be disabled before selecting SSCs! ");
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'Selected 0 SSCs')]")).getText().trim(), "Selected 0 SSCs:");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='card col-md-4 margin-right-card card-two']/div[@class='numeric-style']")).getText().trim(), "0");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='card col-md-4 margin-right-card card-two']/div[@class='card-text']/p[1]")).getText().trim(), "Participating SSC");
		rmCp.clickToSelectAllSSCs();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'Selected 10 SSCs')]")).getText().trim(), "Selected 10 SSCs:");
		rmCp.clickToAlignSelectedSSCs();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "SSC has been aligned !");
		rmCp.clickOK();
		Thread.sleep(4000);
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@class='card col-md-4 margin-right-card card-two']/div[@class='numeric-style']")).getText().trim(), "10");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='card col-md-4 margin-right-card card-two']/div[@class='card-text']/p[1]")).getText().trim(), "Participating SSC");
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Save & Create Rozgar Mela')]")).isEnabled(),"OMG!!! Save & Create Rozgar Mela, button should be enabled after selecting SSCs! ");
		rmCp.clickToSaveAndCreateRozgarMela();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"rozgarmelaspoccreate-rozgar-melaalign-training-centresalign-ssccreate-rozgar-mela-success","OMG!!! Navigation to Create Rozgar Mela Success page is unsuccessful OR Something wrong! ");
		String createdRozgarMelaID=driver.findElement(By.xpath("//p[contains(text(),'You have successfully created a Rozgar Mela with')]/span")).getText().trim().replace('"', ' ').replaceAll(" ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "CreateRozgarMela", rowNum, 1, createdRozgarMelaID);
		rmCp.clickAnnounceToStakeholders();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"rozgarmelaspocview-rozgar-melas","OMG!!! Navigation to View Rozgar Melas page is unsuccessful OR Something wrong! ");
		NSDC_RozgarMelaSPOC_ViewRozgarMelasPage rmVp=new NSDC_RozgarMelaSPOC_ViewRozgarMelasPage(driver);
		rmVp.clickTireOne();
		Thread.sleep(2000);
		rmVp.selectStateFilterOption(state);
		Thread.sleep(4000);
		rmVp.clickToApplyFilters();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+state+"')]")).size()!=0,"OMG!!! Created RozgarMela - "+createdRozgarMelaID+" of State - "+state+" Not Resulted for State Filter! ");
		rmVp.selectDistrictFilterOption(district);
		Thread.sleep(4000);
		rmVp.clickToApplyFilters();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+district+"')]")).size()!=0,"OMG!!! Created RozgarMela - "+createdRozgarMelaID+" of State - "+district+" Not Resulted for District Filter! ");
	/*	rmVp.selectStatusFilterOption(statusFilterOption);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+statusFilterOption+"')]")).size()!=0,"OMG!!! Created RozgarMela - "+createdRozgarMelaID+" of Status - "+statusFilterOption+" Not Resulted for Status Filter! ");
		rmVp.enterStartDateFilter(startDate);
		rmVp.enterEndDateFilter(endDate);
		Thread.sleep(2000);
		rmVp.clickToApplyFilters();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+startDate+" - "+endDate+"')]")).size()!=0,"OMG!!! Created RozgarMela - "+createdRozgarMelaID+" of Duration - "+startDate+" to "+endDate+" Not Resulted for Date Filters! ");
		rmVp.enterRozgarMelaNameToSearch(rozgarMelaName);
		Thread.sleep(2000);
		rmVp.clickToApplyFilters();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(),'"+rozgarMelaName+"')]")).size()!=0,"OMG!!! Created RozgarMela - "+createdRozgarMelaID+" Not Resulted for Search By Rozgar Mela Name! ");
	*/	Assert.assertEquals(driver.findElement(By.xpath("//th[1]")).getText().trim(), "Mela ID");
		Assert.assertEquals(driver.findElement(By.xpath("//td[1]")).getText().trim(), createdRozgarMelaID);
		Assert.assertEquals(driver.findElement(By.xpath("//th[2]")).getText().trim(), "Rozgar Mela Name");
		Assert.assertEquals(driver.findElement(By.xpath("//td[2]")).getText().trim(), rozgarMelaName);
		Assert.assertEquals(driver.findElement(By.xpath("//th[5]")).getText().trim(), "State");
		Assert.assertEquals(driver.findElement(By.xpath("//td[5]")).getText().trim(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//th[6]")).getText().trim(), "District");
		Assert.assertEquals(driver.findElement(By.xpath("//td[6]")).getText().trim(), district);
		Assert.assertEquals(driver.findElement(By.xpath("//th[7]")).getText().trim(), "Start Date-End Date");
		Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText().trim(), startDateHipen+" - "+endDateHipen);
		rmVp.clickActionMenu();
		Thread.sleep(2000);
		rmVp.clickToChooseViewDetailsOption();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl().replaceAll("/", ""), configuredURL.replaceAll("/", "")+"rozgarmelaspocview-rozgar-melasview-rozgar-mela","OMG!!! Navigation to View Details Of Rozgar Mela page is unsuccessful OR Something wrong! ");
		rmVp.clickToViewMelaDetails();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[span[contains(text(),'Mela Name:')]]/span[2]")).getText().trim().equalsIgnoreCase(rozgarMelaName));
		Assert.assertTrue(driver.findElement(By.xpath("//div[span[contains(text(),'Type of Rozgar Mela:')]]/span[2]")).getText().trim().equalsIgnoreCase(typeOfRozgarMela));
		Assert.assertTrue(driver.findElement(By.xpath("//div[span[contains(text(),'Target Audience:')]]/span[2]")).getText().trim().equalsIgnoreCase(targetAudience));
		Assert.assertTrue(driver.findElement(By.xpath("//div[span[contains(text(),'Chief Guest Expected:')]]/span[2]")).getText().trim().equalsIgnoreCase(chiefGuestName+" ("+chiefGuestTitle+")"));
		//Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Mela Dates')]]/span[2]")).getText().trim(), startDateHipen+" TO "+endDateHipen);
		Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Mela Daily Timings')]]/span[2]")).getText().trim(), startTime+" TO "+endTime);
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'Address of the Organisation:')]]/div[2]")).getText().trim().equalsIgnoreCase(address+", "+village+", "+state+", "+tehsil+", "+district+", "+state+" - "+pincode));
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'Nearby Landmark:')]]/div[2]")).getText().trim().equalsIgnoreCase(landmark));
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'Pincode:')]]/div[2]")).getText().trim().equalsIgnoreCase(pincode));
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'State/Union Territory:')]]/div[2]")).getText().trim().equalsIgnoreCase(state));
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'District:')]]/div[2]")).getText().trim().equalsIgnoreCase(district));
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'Tehsil / Mandal/ Block:')]]/div[2]")).getText().trim().equalsIgnoreCase(tehsil));
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'Parliamentary Consistuency:')]]/div[2]")).getText().trim().equalsIgnoreCase(parlimentaryConstituency));
		Assert.assertTrue(driver.findElement(By.xpath("//div[div[contains(text(),'City/Town/Village:')]]/div[2]")).getText().trim().equalsIgnoreCase(village));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] rescheduleRozgarMelaData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/RMSPOC_RozgarMela-Workflow.xls", "Re-ScheduleRozgarMela");
	}
	@Test(dataProvider="rescheduleRozgarMelaData")
	public void reScheduleRozgarMelaTC_02()
	{
		
	}
}
