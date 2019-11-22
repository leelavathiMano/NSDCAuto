package com.nsdc.RegressionTest_NON_PMKVY_STT_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_NON_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_NON_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_NON_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_NON_PMKVY_Pages.LogOutPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_AddTrainingCentrePage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_FeeBased_ViewAllTrainingCentrePage;
import com.nsdc.Pages_NON_PMKVY_Pages.TrainingPartnerDashboardPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_TCRequestPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_TrainingCentreInfoPage;

import com.nsdc.testConfig.TestConfiguration;

public class Add_TC extends TestConfiguration {

	/*
	 * @DataProvider public Object[][] addTrainingCentre() { return
	 * ReadMultipleDataFromExcel.getExcelData(
	 * "./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01"); }
	 * 
	 * @Test(dataProvider = "addTrainingCentre") public void
	 * addTrainingCentreTC04(String sno, String tpUsername, String tpPassword,
	 * String projectName, String trainingCentreType, String trainingCentreName,
	 * String ownership, String franchiseDocument, String startDate, String endDate,
	 * String bathesNumber, String studentNumber, String annualCapacity, String
	 * capacityUtilization, String governmentTieUp, String centreCapacity, String
	 * centreArea, String trainingRooms, String labNumber, String receptionArea,
	 * String waitingArea, String maleWashRooms, String femaleWashRooms, String
	 * unisexWashRooms, String airportDistance, String trainStationDistance, String
	 * cityCentreDistance, String tcAddress, String landmark, String pincode, String
	 * state, String district, String tehsil, String city, String
	 * parliamentryConstituency, String geoLocation, String addressProof, String
	 * addressProofFile, String facility_Photos, String spocName, String spocEmail,
	 * String spocMobile, String spocDesignation, String spocLandLine, String
	 * srNo_TCRoom, String tcRoomPhotos, String laboratory_SrNo, String
	 * laboratoryPhotos, String maleWashRoom_SrNo, String maleWashRoomPhotos, String
	 * femaleWashRoom_SrNo, String femaleWashRoomPhotos, String unisexWashRoom_SrNo,
	 * String unisexWashRoomPhotos, String sector, String course, String target)
	 * throws Exception { LaunchPage lp = new LaunchPage(driver); lp.clickLogin();
	 * Thread.sleep(3000); BetaVersionOfSmartPage bsp = new
	 * BetaVersionOfSmartPage(driver); bsp.clickToClose(); Thread.sleep(3000);
	 * EnterLoginPage elp = new EnterLoginPage(driver); elp.performlogin(tpUsername,
	 * tpPassword); TrainingPartnerDashboardPage tpdp = new
	 * TrainingPartnerDashboardPage(driver); Thread.sleep(15000);
	 * tpdp.clickOnMySchemes(); Thread.sleep(5000); driver.findElement( By.
	 * xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"
	 * )) .click();
	 * driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
	 * Thread.sleep(5000); driver.findElement(By.xpath("//tr[td[span[span[text()='"
	 * + projectName +
	 * "']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"
	 * )).click(); driver.findElement( By.xpath("//tr[td[span[span[text()='" +
	 * projectName + "']]]]//a[contains(text(),'View Details')]")) .click();
	 * TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
	 * Thread.sleep(5000); fbd.clickOnViewTrainingCentres();
	 * TP_FeeBased_ViewAllTrainingCentrePage fbtc = new
	 * TP_FeeBased_ViewAllTrainingCentrePage(driver); Thread.sleep(2000);
	 * fbtc.clickOnAddTrainingCentre(); Thread.sleep(3000);
	 * fbtc.selectTrainingCentreType(trainingCentreType);
	 * fbtc.clickOnSaveAndContinue(); TP_FeeBased_AddTrainingCentrePage fbad = new
	 * TP_FeeBased_AddTrainingCentrePage(driver); Thread.sleep(3000);
	 * fbad.enterTrainingCentreName(trainingCentreName); Thread.sleep(3000);
	 * fbad.clcikOnRuralLocation(); Thread.sleep(3000);
	 * fbad.selectForCentreOwnerShip(ownership); if (ownership.equals("Franchise"))
	 * { Thread.sleep(5000); fbad.clickOnFranchiseDocuments_BrowseFile();
	 * Thread.sleep(5000); UploadFile.upload(franchiseDocument); Thread.sleep(5000);
	 * fbad.clickOnFranchiseDocuments_UploadFile(); Thread.sleep(3000); //
	 * fbad.clickOnStartDateForTCDuration(); // startDate =
	 * driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']"))
	 * .getAttribute("value"); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate); //
	 * fbad.clickOnEndDateForTCDuration(); // endDate =
	 * driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).
	 * getAttribute("value"); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate); } else { //
	 * fbad.clickOnStartDateForTCDuration(); // startDate =
	 * driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']"))
	 * .getAttribute("value"); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate); //
	 * fbad.clickOnEndDateForTCDuration(); // endDate =
	 * driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).
	 * getAttribute("value"); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate); //
	 * ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
	 * "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate); }
	 * 
	 * // fbad.enterNumberOfBatchesPerDay(bathesNumber); //
	 * fbad.enterMaximumNoOfStudentPerBatch(studentNumber); //
	 * fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity); //
	 * fbad.enterCapacityUtilization(capacityUtilization); //
	 * fbad.selectForGovernmentTieUp(governmentTieUp); Thread.sleep(3000);
	 * fbad.entreCentreArea(centreArea); //
	 * fbad.enterCentreCapacity(centreCapacity);
	 * fbad.selectNumberOfTrainingRooms(trainingRooms);
	 * fbad.selectNumbersOfLabs(labNumber); //
	 * fbad.enterReceptionAreaSize(receptionArea); //
	 * fbad.enterWaitingAreaCapacity(waitingArea);
	 * fbad.selectNumberOfMaleWashRooms(maleWashRooms);
	 * fbad.selectNumberOfFemaleWashRooms(femaleWashRooms);
	 * fbad.selectNumberOfUnisexWashRooms(unisexWashRooms);
	 * fbad.enterDistanceFromNearestAirport(airportDistance);
	 * fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
	 * fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
	 * Thread.sleep(3000); fbad.enterAddressOFTC(tcAddress); Thread.sleep(3000);
	 * fbad.enterNearByLandmark(landmark); Thread.sleep(5000);
	 * fbad.enterPincode(pincode); Thread.sleep(3000); fbad.selectState(state);
	 * Thread.sleep(2000); fbad.selrctDistrict(district); Thread.sleep(2000);
	 * fbad.selectTehsil(tehsil); Thread.sleep(3000);
	 * fbad.selectCityOrVillage(city); Thread.sleep(2000);
	 * fbad.selectParliamentryConstituency(parliamentryConstituency);
	 * fbad.enterGeoLocation(geoLocation); Thread.sleep(3000);
	 * fbad.selectAddressProofType(addressProof); Thread.sleep(3000);
	 * fbad.clickOnAddressProof_BrowseFile(); Thread.sleep(3000);
	 * UploadFile.upload(addressProofFile); Thread.sleep(3000);
	 * fbad.clickOnAddressProof_UploadFile(); if
	 * (trainingCentreType.equals("Fixed")) { List<WebElement> ele =
	 * driver.findElements(By.xpath(
	 * "//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//label[@class='m-checkbox']"
	 * )); for (int i = 0; i < ele.size(); i++) { Thread.sleep(3000); WebElement
	 * chkbox = ele.get(i); if ((i == 0) || (i == 9) || (i == 10) || (i == 15) || (i
	 * == 16) || (i == 17)) { Thread.sleep(5000);
	 * Assert.assertEquals(driver.findElement(By.xpath(
	 * "(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@type='checkbox'])["
	 * + (i + 1) + "]")) .isSelected(), true);
	 * 
	 * driver.findElement(By.
	 * xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@type='checkbox'])["
	 * +(i+1)+"]")).click(); Thread.sleep(5000); UploadFile.upload(facility_Photos);
	 * Thread.sleep(5000); driver.findElement(By.
	 * xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["
	 * +(i+1)+"]")).click();
	 * 
	 * } else {
	 * 
	 * Thread.sleep(5000); chkbox.click(); Thread.sleep(5000);
	 * driver.findElement(By.
	 * xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@type='checkbox'])["
	 * +(i+1)+"]")).click(); Thread.sleep(5000); UploadFile.upload(facility_Photos);
	 * Thread.sleep(5000); driver.findElement(By.
	 * xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["
	 * +(i+1)+"]")).click();
	 * 
	 * } }
	 * 
	 * } else { List<WebElement> ele = driver.findElements(By.xpath(
	 * "//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//label[@class='m-checkbox']"
	 * )); for (int i = 0; i < ele.size(); i++) { Thread.sleep(3000); WebElement
	 * chkbox = ele.get(i); Thread.sleep(5000); chkbox.click(); Thread.sleep(5000);
	 * driver.findElement(By.xpath(
	 * "(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@id='customFile'])["
	 * + (i + 1) + "]")) .click(); Thread.sleep(5000);
	 * UploadFile.upload(facility_Photos); Thread.sleep(5000);
	 * driver.findElement(By.xpath(
	 * "(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["
	 * + (i + 1) + "]")) .click();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * Thread.sleep(5000); fbad.enterNameOfSPOC(spocName);
	 * fbad.enterEmailAddressOfSPOC(spocEmail);
	 * fbad.enterMobileNumberOfSPOC(spocMobile);
	 * fbad.enterDesignationOfSPOC(spocDesignation);
	 * fbad.enterLandLineNumberOfSPOC(spocLandLine); Thread.sleep(3000);
	 * 
	 * // Old code for application
	 * 
	 * fbad.select_SrNo_TrainingRoomPhotos(srNo_TCRoom);
	 * fbad.clickOnTrainingRoomPhotos_BrowseFile(); Thread.sleep(3000);
	 * UploadFile.upload(tcRoomPhotos); Thread.sleep(3000);
	 * fbad.clickOnTrainingRoomPhotos_UploadFile(); Thread.sleep(3000);
	 * fbad.select_SrNo_Laboratory(laboratory_SrNo);
	 * fbad.clickOnLaboratoryPhotos_BrowseFile(); Thread.sleep(3000);
	 * UploadFile.upload(laboratoryPhotos); Thread.sleep(3000);
	 * fbad.clickOnLaboratoryPhotos_UploadFile(); Thread.sleep(3000);
	 * fbad.select_SrNo_ForMaleWashRoom(maleWashRoom_SrNo);
	 * fbad.clickOnMaleWashRoomPhotos_BrowseFile(); Thread.sleep(3000);
	 * UploadFile.upload(maleWashRoomPhotos); Thread.sleep(3000);
	 * fbad.clickOnMaleWashRoomPhotos_UploadFile(); Thread.sleep(3000);
	 * fbad.select_SrNo_ForFemaleWashRoom(femaleWashRoom_SrNo);
	 * fbad.clickOnFemaleWashRoomPhotos_BrowseFile(); Thread.sleep(3000);
	 * UploadFile.upload(femaleWashRoomPhotos); Thread.sleep(3000);
	 * fbad.clickOnFemaleWashRoomPhotos_UploadFile(); Thread.sleep(3000);
	 * fbad.select_SrNo_ForUnisexWashRoom(unisexWashRoom_SrNo);
	 * fbad.clickOnUnisexWashRoomPhotos_BrowseFile(); Thread.sleep(3000);
	 * UploadFile.upload(unisexWashRoomPhotos); Thread.sleep(3000);
	 * fbad.clickOnUnisexWashRoomPhotos_UploadFile();
	 * fbad.clickOnCafetariaPhotos_BrowseFile(); Thread.sleep(3000);
	 * UploadFile.upload(cafetariaPhotos); Thread.sleep(3000);
	 * fbad.clickOnCafetariaPhotos_UploadFile(); Thread.sleep(10000);
	 * Thread.sleep(3000);
	 * 
	 * 
	 * fbad.clickOnAddSectorTarget(); Thread.sleep(3000); fbad.selectSector(sector);
	 * Thread.sleep(3000); fbad.selectCourse(course); fbad.enterTarget(target);
	 * Thread.sleep(3000); fbad.clickOnSubmit_SectorTarget(); Thread.sleep(15000);
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("scroll(0, 900)"); fbad.clickOnSubmit(); Thread.sleep(3000);
	 * 
	 * fbad.clickOnYesAddTrainingCentre(); Thread.sleep(3000); // fbad.clickOnOK();
	 * Thread.sleep(8000); fbd.clickOnViewTrainingCentres();
	 * 
	 * Assert.assertEquals(driver .findElement(By.xpath(
	 * "(//tr[td[span[span[text()='Training Centre 1']]]]//span[text()='Profile Pending'])[1]"
	 * )) .getText(), "Profile Pending"); LogOutPage plp = new LogOutPage(driver);
	 * Thread.sleep(5000); plp.clickOnProfileLogo(); Thread.sleep(2000);
	 * plp.clickOnLogout();
	 * 
	 * }
	 */

	@DataProvider
	public Object[][] cmaApproveTC() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
				"CMAApproveTCSC15TC02");
	}

	@Test(dataProvider = "cmaApproveTC", dependsOnMethods = "addTrainingCentreTC04")
	public void approveTrainingCentreTC_05(String sno, String cmaUsername, String cmaPassword, String tpID,
			String tcType, String status, String expectedTCName, String expectedOwnership, String expectedStartDate,
			String expectedEndDate, String expectedBathesNumber, String expectedStudentNumber,
			String expectedAnnualCapacity, String expectedCapacityUtilization, String expectedGovernmentTieUp,
			String expectedCentreCapacity, String expectedCentreArea, String expectedTrainingRooms,
			String expectedLabNumber, String expectedReceptionArea, String expectedWaitingArea,
			String expectedMaleWashRooms, String expectedFemaleWashRooms, String expectedUnisexWashRooms,
			String expectedAirportDistance, String expectedTrainStationDistance, String expectedCityCentreDistance,
			String expectedTCAddress, String expectedLandmark, String expectedPincode, String expectedState,
			String expectedDistrict, String expectedTehsil, String expectedCity,
			String expectedParliamentryConstituency, String expectedAddressProof, String expectedSPOCName,
			String expectedSPOCEmail, String expectedSPOCMobile, String expectedSPOCDesignation,
			String expectedSPOCLandLine, String expectedSector, String expectedCourseName, String expectedTarget,
			String review, String reviewComments) throws Exception {
		LaunchPage lp = new LaunchPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
		bsp.clickToClose();
		Thread.sleep(3000);
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(cmaUsername, cmaPassword);
		CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
		Thread.sleep(8000);
		cmad.clickOnViewAllTCAddRequest();
		CMA_TCRequestPage cmtc = new CMA_TCRequestPage(driver);
		Thread.sleep(10000);
		cmtc.selectType(tcType);
		cmtc.selectStatus(status);
		cmtc.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='" + expectedTCName
				+ "']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//tr[td[span[span[text()='" + expectedTCName + "']]]]//a[contains(text(),'Take Action')]"))
				.click();

		CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
		Thread.sleep(15000);

		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"),
				expectedTCName);
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='geographicalLocation'])[1]")).isSelected());
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"),
				expectedOwnership);
		if (expectedOwnership.equals("Franchise")) {
			cmat.clickOnDownloadFranchiseDocuments();
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);

		} else {
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
//			Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);	
		}
		// Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"),
		// expectedBathesNumber);
		// Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"),
		// expectedStudentNumber);
		// Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"),
		// expectedAnnualCapacity);
		// Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"),
		// expectedCapacityUtilization);
		// Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"),
		// expectedGovernmentTieUp);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"),
				expectedCentreArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"),
				expectedCentreCapacity);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"),
				expectedTrainingRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"),
				expectedLabNumber);
		// Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"),
		// expectedReceptionArea);
		// Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"),
		// expectedWaitingArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"),
				expectedMaleWashRooms);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"),
				expectedFemaleWashRooms);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"),
				expectedUnisexWashRooms);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"),
				expectedAirportDistance);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"),
				expectedTrainStationDistance);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"),
				expectedCityCentreDistance);
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//		Thread.sleep(8000);
//		cmtc.selectType(tcType);
//		cmtc.selectStatus(status);
//		cmtc.clickOnApply();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//a[contains(text(),'Take Action')]")).click();
//		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("scroll(0, 500)");
//		Thread.sleep(5000);
//		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), expectedTCAddress);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), expectedLandmark);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), expectedPincode);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), expectedState);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), expectedDistrict);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), expectedTehsil);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), expectedCity);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), expectedParliamentryConstituency);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='addressProofType']")).getAttribute("value"), expectedAddressProof);
		Thread.sleep(3000);
		cmat.clickOnDownloadAddressProof();

		Thread.sleep(3000);
		cmat.clickFor_Download_AllFacilities();

//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), expectedSPOCName);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), expectedSPOCEmail);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), expectedSPOCMobile);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), expectedSPOCDesignation);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), expectedSPOCLandLine);
//		
//		Thread.sleep(3000);
//		cmat.clickOn_Preview_TrainingRoomPhotos();
//		cmat.clickOn_ClosePreview();
//		Thread.sleep(3000);
//		cmat.clickOn_Preview_LaboratoryRoomPhotos();
//		cmat.clickOn_ClosePreview();
//		Thread.sleep(3000);
//		cmat.clickOn_Preview_MaleWashRoomPhotos();
//		cmat.clickOn_ClosePreview();
//		Thread.sleep(3000);
//		cmat.clickOn_Preview_FemaleWashRoomPhotos();
//		cmat.clickOn_ClosePreview();
//		Thread.sleep(3000);
//		cmat.clickOn_Preview_UnisexWasRoomPhotos();
//		cmat.clickOn_ClosePreview();
//		Thread.sleep(3000);

		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + expectedSector + "']")).getText(),
				expectedSector);
		// Assert.assertEquals(driver.findElement(By.xpath("//span[text()='"+expectedCourseName+"']")).getText(),
		// expectedCourseName);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + expectedTarget + "']")).getText(),
				expectedTarget);

		cmat.selectReview(review);
		cmat.enterReviewComments(reviewComments);
		cmat.clickOnSubmitResponse();
		cmat.clickOnOK();
		cmtc.selectType(tcType);
		Thread.sleep(3000);
		cmtc.selectStatus(reviewComments);
		Thread.sleep(3000);
		cmtc.clickOnApply();
		if (review.equals("Recommended")) {
			Thread.sleep(3000);
			Assert.assertEquals(driver
					.findElement(By
							.xpath("//tr[td[span[span[text()='" + expectedTCName + "']]]]//span[text()='RECOMMENDED']"))
					.getText(), "RECOMMENDED");
		} else if (review.equals("Not Recommended")) {
			Thread.sleep(3000);
			Assert.assertEquals(driver
					.findElement(By.xpath(
							"//tr[td[span[span[text()='" + expectedTCName + "']]]]//span[text()='NOT RECOMMENDED']"))
					.getText(), "NOT RECOMMENDED");
		} else if (review.equals("Send Back")) {
			Thread.sleep(3000);
			Assert.assertEquals(driver
					.findElement(
							By.xpath("//tr[td[span[span[text()='" + expectedTCName + "']]]]//span[text()='SENT BACK']"))
					.getText(), "SENT BACK");
		}

		LogOutPage plp = new LogOutPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();

	}

}
