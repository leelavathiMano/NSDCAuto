package com.nsdc.RegressionTest_NON_PMKVY_STT_Test;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.UploadFile;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_DashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_TCRequestPage;
import com.nsdc.Pages_NON_PMKVY_Pages.CMA_TrainingCentreInfoPage;

import com.nsdc.testConfig.TestConfiguration;

public class Add_TC extends TestConfiguration {

//	@DataProvider
//	public Object[][] addTrainingCentre() {
//		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
//				"MySchemeAddTCSC15TC01");
//	}
//
//	@Test(dataProvider = "addTrainingCentre")
//	public void addTrainingCentreTC04(String sno, String tpUsername, String tpPassword, String projectName,
//			String trainingCentreType, String trainingCentreName, String ownership, String franchiseDocument,
//			String startDate, String endDate, String bathesNumber, String studentNumber, String annualCapacity,
//			String capacityUtilization, String governmentTieUp, String centreCapacity, String centreArea,
//			String trainingRooms, String labNumber, String receptionArea, String waitingArea, String maleWashRooms,
//			String femaleWashRooms, String unisexWashRooms, String airportDistance, String trainStationDistance,
//			String cityCentreDistance, String tcAddress, String landmark, String pincode, String state, String district,
//			String tehsil, String city, String parliamentryConstituency, String geoLocation, String addressProof,
//			String addressProofFile, String facility_Photos, String spocName, String spocEmail, String spocMobile,
//			String spocDesignation, String spocLandLine, String srNo_TCRoom, String tcRoomPhotos,
//			String laboratory_SrNo, String laboratoryPhotos, String maleWashRoom_SrNo, String maleWashRoomPhotos,
//			String femaleWashRoom_SrNo, String femaleWashRoomPhotos, String unisexWashRoom_SrNo,
//			String unisexWashRoomPhotos, String sector, String course, String target) throws Exception {
//		precondition();
//		LaunchPage lp = new LaunchPage(driver);
//		lp.clickLogin();
//		Thread.sleep(3000);
//		BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
//		bsp.clickToClose();
//		Thread.sleep(3000);
//		EnterLoginPage elp = new EnterLoginPage(driver);
//		elp.performlogin(tpUsername, tpPassword);
//		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
//		Thread.sleep(15000);
//		tpdp.clickOnMySchemes();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
//		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName +"']]]]//a[contains(text(),'View Details')]")).click();
//		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
//		Thread.sleep(5000);
//		fbd.clickOnViewTrainingCentres();
//		TP_FeeBased_ViewAllTrainingCentrePage fbtc = new TP_FeeBased_ViewAllTrainingCentrePage(driver);
//		Thread.sleep(10000);
//		fbtc.clickOnAddTrainingCentre();
//		Thread.sleep(3000);
//		fbtc.selectTrainingCentreType(trainingCentreType);
//		fbtc.clickOnSaveAndContinue();
//		TP_FeeBased_AddTrainingCentrePage fbad = new TP_FeeBased_AddTrainingCentrePage(driver);
//		Thread.sleep(3000);
//		fbad.enterTrainingCentreName(trainingCentreName);
//		Thread.sleep(3000);
//		fbad.clcikOnRuralLocation();
//		Thread.sleep(3000);
//		fbad.selectForCentreOwnerShip(ownership);
//		if (ownership.equals("Franchise")) {
//			Thread.sleep(5000);
//			fbad.clickOnFranchiseDocuments_BrowseFile();
//			Thread.sleep(5000);
//			UploadFile.upload(franchiseDocument);
//			Thread.sleep(5000);
//			fbad.clickOnFranchiseDocuments_UploadFile();
//			Thread.sleep(3000); 
//			//fbad.clickOnStartDateForTCDuration();
//			// startDate =driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
//			// ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01",Integer.parseInt(sno), 8, startDate);
//			// ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02",Integer.parseInt(sno), 8, startDate);
//			// fbad.clickOnEndDateForTCDuration();
//			// endDate =driver.findElement(By.xpath("//input[@placeholder='Select CloseDate']")).getAttribute("value");
//			// ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls","MySchemeAddTCSC15TC01",Integer.parseInt(sno), 9, endDate);
//			// ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls","CMAApproveTCSC15TC02",Integer.parseInt(sno), 9, endDate);
//		} 
//		else
//		{
//			// fbad.clickOnStartDateForTCDuration();
//			// startDate =driver.findElement(By.xpath("//input[@placeholder='SelectEffective Date']")).getAttribute("value"); 
//			//	ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01",Integer.parseInt(sno), 8, startDate); 
//			//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02",Integer.parseInt(sno), 8, startDate); 
//			//fbad.clickOnEndDateForTCDuration(); 
//			// endDate =driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"); 
////ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01",Integer.parseInt(sno), 9, endDate); 
//			//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02",Integer.parseInt(sno), 9, endDate);
//		}
//
//		// fbad.enterNumberOfBatchesPerDay(bathesNumber);
//		//fbad.enterMaximumNoOfStudentPerBatch(studentNumber); 
//		//fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
//		//fbad.enterCapacityUtilization(capacityUtilization); 
//		//fbad.selectForGovernmentTieUp(governmentTieUp);
//		Thread.sleep(3000);
//		fbad.entreCentreArea(centreArea); 
//		//fbad.enterCentreCapacity(centreCapacity);
//		fbad.selectNumberOfTrainingRooms(trainingRooms);
//		fbad.selectNumbersOfLabs(labNumber); 
//		//fbad.enterReceptionAreaSize(receptionArea);
//		//fbad.enterWaitingAreaCapacity(waitingArea);
//		fbad.selectNumberOfMaleWashRooms(maleWashRooms);
//		fbad.selectNumberOfFemaleWashRooms(femaleWashRooms);
//		fbad.selectNumberOfUnisexWashRooms(unisexWashRooms);
//		fbad.enterDistanceFromNearestAirport(airportDistance);
//		fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
//		fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
//		Thread.sleep(3000);
//		fbad.enterAddressOFTC(tcAddress);
//		Thread.sleep(3000);
//		fbad.enterNearByLandmark(landmark);
//		Thread.sleep(5000);
//		fbad.enterPincode(pincode);
//		Thread.sleep(3000);
//		fbad.selectState(state);
//		Thread.sleep(2000);
//		fbad.selrctDistrict(district);
//		Thread.sleep(2000);
//		fbad.selectTehsil(tehsil);
//		Thread.sleep(3000);
//		fbad.selectCityOrVillage(city);
//		Thread.sleep(2000);
//		fbad.selectParliamentryConstituency(parliamentryConstituency);
//		fbad.enterGeoLocation(geoLocation);
//		Thread.sleep(3000);
//		fbad.selectAddressProofType(addressProof);
//		Thread.sleep(3000);
//		fbad.clickOnAddressProof_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(addressProofFile);
//		Thread.sleep(3000);
//		fbad.clickOnAddressProof_UploadFile();
////		if (trainingCentreType.equals("Fixed")) {
////			List<WebElement> ele = driver.findElements(By.xpath("//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//label[@class='m-checkbox']"));
////			for (int i = 0; i < ele.size(); i++) {
////				Thread.sleep(3000);
////				WebElement chkbox = ele.get(i);
////				if ((i == 0) || (i == 9) || (i == 10) || (i == 15) || (i == 16) || (i == 17)) {
////					Thread.sleep(5000);
////					Assert.assertEquals(driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@type='checkbox'])["+(i + 1) +"]")).isSelected(), true);
////
////driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@type='checkbox'])["+ (i + 1) + "]")).click();
////					Thread.sleep(5000);
////					UploadFile.upload(facility_Photos);
////					Thread.sleep(5000);
////driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+ (i + 1) + "]")).click();
////
////				}
////				else {
////
////					Thread.sleep(5000);
////					chkbox.click();
////					Thread.sleep(5000);
////					driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@type='checkbox'])["+ (i + 1) + "]")).click();
////					Thread.sleep(5000);
////					UploadFile.upload(facility_Photos);
////					Thread.sleep(5000);
////					driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+ (i + 1) + "]")).click();
////
////				}
////			}
////
////		} 
////		else {
////			List<WebElement> ele = driver.findElements(By.xpath(
////					"//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//label[@class='m-checkbox']"));
////			for (int i = 0; i < ele.size(); i++) {
////				Thread.sleep(3000);
////				WebElement chkbox = ele.get(i);
////				Thread.sleep(5000);
////				chkbox.click();
////				Thread.sleep(5000);
////				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//input[@id='customFile'])["+ (i + 1) + "]")).click();
////				Thread.sleep(5000);
////				UploadFile.upload(facility_Photos);
////				Thread.sleep(5000);
////				driver.findElement(By.xpath("(//div[div[div[h4[text()='Facilities Available at the Centre:']]]]//button[contains(text(),'Upload')])["+ (i + 1) + "]")).click();
////
////			}
////
////		}
//
//		Thread.sleep(5000);
//		fbad.enterNameOfSPOC(spocName);
//		fbad.enterEmailAddressOfSPOC(spocEmail);
//		fbad.enterMobileNumberOfSPOC(spocMobile);
//		fbad.enterDesignationOfSPOC(spocDesignation);
//		fbad.enterLandLineNumberOfSPOC(spocLandLine);
//		Thread.sleep(3000);
//
//	
//		
//
//		fbad.clickOnAddSectorTarget();
//		Thread.sleep(3000);
//		fbad.selectSector(sector);
//		Thread.sleep(3000);
//		fbad.selectCourse(course);
//		fbad.enterTarget(target);
//		Thread.sleep(3000);
//		fbad.clickOnSubmit_SectorTarget();
//		Thread.sleep(3000);
//		
////		
//		fbad.clickOnSaveAndContinue();
//		Thread.sleep(15000);
//
////	
//
//		//Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='Training Centre 1']]]]//span[text()='Profile Pending'])[1]")).getText(), "Profile Pending");
//		LogOutPage plp = new LogOutPage(driver);
//		Thread.sleep(5000);
//		plp.clickOnProfileLogo();
//		Thread.sleep(2000);
//		plp.clickOnLogout();
//
//	}

	@DataProvider
	public Object[][] cmaApproveTC() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls",
				"CMAApproveTCSC15TC02");
	}

	@Test(dataProvider = "cmaApproveTC")//, dependsOnMethods = "addTrainingCentreTC04"
	public void approveTrainingCentreTC_05(String sno, String cmaUsername, String cmaPassword, String tpID,
			String tcType, String status,String tcid, String expectedTCName, String expectedOwnership, String expectedStartDate,
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
			String numberofreviewandcomments,String review, String reviewComments,String CMAFacelitiesReview,
			String CMAComments) throws Exception {
		precondition();
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
		cmtc.EnterTPid(tpID);
		cmtc.selectType(tcType);
		cmtc.selectStatus(status);
		cmtc.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+ tcid+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='" + tcid + "']]]]//a[contains(text(),'Take Action')]")).click();

		CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
		Thread.sleep(15000);

//	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"),expectedTCName);
//		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='geographicalLocation'])[1]")).isSelected());
//	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"),expectedOwnership);
		if (expectedOwnership.equals("Franchise")) 
		{
			cmat.clickOnDownloadFranchiseDocuments();
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);

		} 
		else
		{
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
//			//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);	
		}
		
//	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"),expectedCentreArea);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"),expectedCentreCapacity);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"),expectedTrainingRooms);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"),expectedLabNumber);
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"),expectedMaleWashRooms);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"),expectedFemaleWashRooms);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"),expectedUnisexWashRooms);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"),expectedAirportDistance);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"),expectedTrainStationDistance);
//	s	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"),expectedCityCentreDistance);
//		
		Thread.sleep(3000);
		cmat.clickOnDownloadAddressProof();

		Thread.sleep(3000);
		//cmat.clickFor_Download_AllFacilities();
//	s	Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + expectedSector + "']")).getText(),expectedSector);
//		
//s		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + expectedTarget + "']")).getText(),expectedTarget);
		
		
		cmat.selectReview(review);
		cmat.enterReviewComments(reviewComments);
		
		
		
		int totalriviews=Integer.parseInt(numberofreviewandcomments);
		for(int i=2;i<=totalriviews;i++)
		{
			Thread.sleep(1000);
			WebElement reviewCommentsDropDownList = driver.findElement(By.xpath("(//select[@formcontrolname='review'])["+i+"]"));
			 
			SelectDropDownList.selectDropDownListByVisibleText(reviewCommentsDropDownList, CMAFacelitiesReview);
			Thread.sleep(2000);
			WebElement comments = driver.findElement(By.xpath("(//textarea[@formcontrolname='comment'])["+i+"]"));
			comments.sendKeys(CMAComments);
			
		}
		cmat.clickOnSubmitReview();
		cmat.clickOnYES();
		Thread.sleep(2000);
		cmtc.selectType(tcType);
		Thread.sleep(2000);
		
		
		
		cmtc.selectStatus(review);
		Thread.sleep(3000);
		cmtc.clickOnApply();
		if (review.equals("APPROVED")) 
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+tcid+"']]]]//span[text()='APPROVED']")).getText(), "APPROVED");
		} 
		else if (review.equals("NOT APPROVED"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='" +tcid+ "']]]]//span[text()='NOT APPROVED']")).getText(), "NOT APPROVED");
		} 
		else if (review.equals("Send Back"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='" +tcid+ "']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
		}

		LogOutPage plp = new LogOutPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();

	}

}
