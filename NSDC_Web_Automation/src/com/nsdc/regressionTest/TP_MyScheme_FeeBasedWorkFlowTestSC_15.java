package com.nsdc.regressionTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AssessmentAgencyDashboardPage;
import com.nsdc.pages.AssessmentAgencyViewBatchesPage;
import com.nsdc.pages.AssessmentAgency_BatchIDPage;
import com.nsdc.pages.CMA_AddCourseRequestsPage;
import com.nsdc.pages.CMA_AddSectorRequestPage;
import com.nsdc.pages.CMA_CourseInfoPage;
import com.nsdc.pages.CMA_DashboardPage;
import com.nsdc.pages.CMA_SectorInfoPage;
import com.nsdc.pages.CMA_TCRequestPage;
import com.nsdc.pages.CMA_TrainingCentreInfoPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSC_AssessmentsAndCertification_DashboardPage;
import com.nsdc.pages.SSC_AssessmentsAndCertifications_ViewAllBatchesPage;
import com.nsdc.pages.SSC_Certification_BatchIDPage;
import com.nsdc.pages.SSC_Certification_ViewAllBatches;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.TP_FeeBased_AddCourseToSectorsPage;
import com.nsdc.pages.TP_FeeBased_AddTrainingCentrePage;
import com.nsdc.pages.TP_FeeBased_AssessmentAgencyAndAssessorPage;
import com.nsdc.pages.TP_FeeBased_AssessmentAgencyInfoPage;
import com.nsdc.pages.TP_FeeBased_BatchDetailsPage;
import com.nsdc.pages.TP_FeeBased_CreateBatchAddSectorTargetPage;
import com.nsdc.pages.TP_FeeBased_DashboardPage;
import com.nsdc.pages.TP_FeeBased_EnrollCandidatesPage;
import com.nsdc.pages.TP_FeeBased_ViewAllSectorAndCoursesPage;
import com.nsdc.pages.TP_FeeBased_ViewAllTrainersPage;
import com.nsdc.pages.TP_FeeBased_ViewAllTrainingCentrePage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.pages.TrainingPartner_MyCandidatesPage;
import com.nsdc.testConfig.TestConfiguration;

public class TP_MyScheme_FeeBasedWorkFlowTestSC_15 extends TestConfiguration
{

	@DataProvider
	public Object[][] addTrainingCentre()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01");
	}
	
	@Test(dataProvider="addTrainingCentre")
	public void addTrainingCentreTC01(String sno, String tpUsername, String tpPassword, String projectName, String trainingCentreType, String trainingCentreName, String tcStatus, String ownership, String franchiseDocument, String startDate, String endDate, String bathesNumber, String studentNumber, String annualCapacity, String capacityUtilization, String governmentTieUp, String centreCapacity, String centreArea, String trainingRooms, String labNumber, String receptionArea, String waitingArea, String maleWashRooms, String femaleWashRooms, String unisexWashRooms, String airportDistance, String trainStationDistance, String cityCentreDistance, String tcAddress, String landmark, String pincode, String state, String district, String tehsil, String city, String parliamentryConstituency, String geoLocation, String spocName, String spocEmail, String spocMobile, String spocDesignation, String spocLandLine, String tcRoomPhotos, String laboratoryPhotos, String washRoomPhotos, String cafetariaPhotos, String sector, String course, String target, String secondTrainingCentreName, String secondSPOCEmail, String secondSPOCMobile,String thirdTrainingCentreName, String thirdSPOCEmail, String thirdSPOCMobile) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(10000);
		tpdp.clickOnMySchemes();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(3000);
		fbd.clickOnViewTrainingCentres();
		TP_FeeBased_ViewAllTrainingCentrePage fbtc = new TP_FeeBased_ViewAllTrainingCentrePage(driver);
		Thread.sleep(2000);
		fbtc.clickOnAddTrainingCentre();
		Thread.sleep(3000);
		fbtc.selectTrainingCentreType(trainingCentreType);
		fbtc.clickOnSaveAndContinue();
		TP_FeeBased_AddTrainingCentrePage fbad = new TP_FeeBased_AddTrainingCentrePage(driver);
		Thread.sleep(3000);
		fbad.enterTrainingCentreName(trainingCentreName);
		//fbad.selectTrainingCentreStatus(tcStatus);
		fbad.selectForCentreOwnerShip(ownership);
		if(ownership.equals("Franchise"))
		{
			Thread.sleep(3000);
			fbad.clickOnFranchiseDocuments_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(franchiseDocument);
			Thread.sleep(3000);
			fbad.clickOnFranchiseDocuments_UploadFile();
			Thread.sleep(3000);
			fbad.clickOnStartDateForTCDuration();
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
			fbad.clickOnEndDateForTCDuration();
			endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 10, endDate);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
		}
		else
		{
			fbad.clickOnStartDateForTCDuration();
			startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, startDate);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
			fbad.clickOnEndDateForTCDuration();
			endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 10, endDate);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
		}
		
		fbad.enterNumberOfBatchesPerDay(bathesNumber);
		fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
		fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
		fbad.enterCapacityUtilization(capacityUtilization);
		fbad.selectForGovernmentTieUp(governmentTieUp);
		fbad.enterCentreCapacity(centreCapacity);
		fbad.entreCentreArea(centreArea);
		fbad.enterNumberOfTrainingRooms(trainingRooms);
		fbad.enterNumbersOfLabs(labNumber);
		fbad.enterReceptionAreaSize(receptionArea);
		fbad.enterWaitingAreaCapacity(waitingArea);
		fbad.enterNumberOfMaleWashRooms(maleWashRooms);
		fbad.enterNumberOfFemaleWashRooms(femaleWashRooms);
		fbad.enterNumberOfUnisexWashRooms(unisexWashRooms);
		fbad.enterDistanceFromNearestAirport(airportDistance);
		fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
		fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
		fbad.enterAddressOFTC(tcAddress);
		fbad.enterNearByLandmark(landmark);
		fbad.enterPincode(pincode);
		fbad.selectState(state);
		Thread.sleep(2000);
		fbad.selrctDistrict(district);
		Thread.sleep(2000);
		fbad.selectTehsil(tehsil);
		Thread.sleep(2000);
		fbad.selectCityOrVillage(city);
		Thread.sleep(2000);
		fbad.selectParliamentryConstituency(parliamentryConstituency);
		fbad.enterGeoLocation(geoLocation);
		//fbad.selectAddressProofType(addressProof);
		Thread.sleep(3000);
		fbad.clickOnAllFacilitiesCheckBoxes();
		Thread.sleep(2000);
		fbad.enterNameOfSPOC(spocName);
		fbad.enterEmailAddressOfSPOC(spocEmail);
		fbad.enterMobileNumberOfSPOC(spocMobile);
		fbad.enterDesignationOfSPOC(spocDesignation);
		fbad.enterLandLineNumberOfSPOC(spocLandLine);
		fbad.clickOnTrainingRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(tcRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnTrainingRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(laboratoryPhotos);
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(washRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(cafetariaPhotos);
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_UploadFile();
		Thread.sleep(10000);
		fbad.clickOnAddSectorTarget();
		Thread.sleep(3000);
		fbad.selectSector(sector);
		Thread.sleep(3000);
		//fbad.selectCourse(course);
		fbad.enterTarget(target);
		fbad.clickOnSubmit_SectorTarget();
		Thread.sleep(8000);
		fbad.clickOnSubmit();
		Thread.sleep(3000);
		fbad.clickOnYesAddTrainingCentre();
		Thread.sleep(3000);
		//fbad.clickOnOK();
		Thread.sleep(3000);
		fbd.clickOnViewTrainingCentres();
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+trainingCentreName+"']]]]//span[text()='Awating Approval']")).getText(), "Awating Approval");
		Thread.sleep(2000);
		fbtc.clickOnAddTrainingCentre();
		Thread.sleep(3000);
		fbtc.selectTrainingCentreType(trainingCentreType);
		fbtc.clickOnSaveAndContinue();
		Thread.sleep(3000);
		fbad.enterTrainingCentreName(secondTrainingCentreName);
		//fbad.selectTrainingCentreStatus(tcStatus);
		fbad.selectForCentreOwnerShip(ownership);
		fbad.clickOnStartDateForTCDuration();
		startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate);
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
		fbad.clickOnEndDateForTCDuration();
		endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate);
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
		fbad.enterNumberOfBatchesPerDay(bathesNumber);
		fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
		fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
		fbad.enterCapacityUtilization(capacityUtilization);
		fbad.selectForGovernmentTieUp(governmentTieUp);
		fbad.enterCentreCapacity(centreCapacity);
		fbad.entreCentreArea(centreArea);
		fbad.enterNumberOfTrainingRooms(trainingRooms);
		fbad.enterNumbersOfLabs(labNumber);
		fbad.enterReceptionAreaSize(receptionArea);
		fbad.enterWaitingAreaCapacity(waitingArea);
		fbad.enterNumberOfMaleWashRooms(maleWashRooms);
		fbad.enterNumberOfFemaleWashRooms(femaleWashRooms);
		fbad.enterNumberOfUnisexWashRooms(unisexWashRooms);
		fbad.enterDistanceFromNearestAirport(airportDistance);
		fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
		fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
		fbad.enterAddressOFTC(tcAddress);
		fbad.enterNearByLandmark(landmark);
		fbad.enterPincode(pincode);
		fbad.selectState(state);
		Thread.sleep(2000);
		fbad.selrctDistrict(district);
		Thread.sleep(2000);
		fbad.selectTehsil(tehsil);
		Thread.sleep(2000);
		fbad.selectCityOrVillage(city);
		Thread.sleep(2000);
		fbad.selectParliamentryConstituency(parliamentryConstituency);
		fbad.enterGeoLocation(geoLocation);
		//fbad.selectAddressProofType(addressProof);
		Thread.sleep(3000);
		fbad.clickOnAllFacilitiesCheckBoxes();
		Thread.sleep(2000);
		fbad.enterNameOfSPOC(spocName);
		fbad.enterEmailAddressOfSPOC(secondSPOCEmail);
		fbad.enterMobileNumberOfSPOC(secondSPOCMobile);
		fbad.enterDesignationOfSPOC(spocDesignation);
		fbad.enterLandLineNumberOfSPOC(spocLandLine);
		fbad.clickOnTrainingRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(tcRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnTrainingRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(laboratoryPhotos);
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(washRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(cafetariaPhotos);
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_UploadFile();
		Thread.sleep(10000);
		fbad.clickOnAddSectorTarget();
		Thread.sleep(3000);
		fbad.selectSector(sector);
		Thread.sleep(3000);
		//fbad.selectCourse(course);
		Thread.sleep(3000);
		fbad.enterTarget(target);
		fbad.clickOnSubmit_SectorTarget();
		Thread.sleep(8000);
		fbad.clickOnSubmit();
		Thread.sleep(3000);
		fbad.clickOnYesAddTrainingCentre();
		Thread.sleep(3000);
		//fbad.clickOnOK();
		Thread.sleep(3000);
		fbd.clickOnViewTrainingCentres();
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+trainingCentreName+"']]]]//span[text()='Awating Approval']")).getText(), "Awating Approval");
		Thread.sleep(2000);
		fbtc.clickOnAddTrainingCentre();
		Thread.sleep(3000);
		fbtc.selectTrainingCentreType(trainingCentreType);
		fbtc.clickOnSaveAndContinue();
		Thread.sleep(3000);
		fbad.enterTrainingCentreName(thirdTrainingCentreName);
		//fbad.selectTrainingCentreStatus(tcStatus);
		fbad.selectForCentreOwnerShip(ownership);
		fbad.clickOnStartDateForTCDuration();
		startDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 8, startDate);
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 8, startDate);
		fbad.clickOnEndDateForTCDuration();
		endDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddTCSC15TC01", Integer.parseInt(sno), 9, endDate);
		//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02", Integer.parseInt(sno), 9, endDate);
		fbad.enterNumberOfBatchesPerDay(bathesNumber);
		fbad.enterMaximumNoOfStudentPerBatch(studentNumber);
		fbad.enterAnnualCapacityOfTrainingCentre(annualCapacity);
		fbad.enterCapacityUtilization(capacityUtilization);
		fbad.selectForGovernmentTieUp(governmentTieUp);
		fbad.enterCentreCapacity(centreCapacity);
		fbad.entreCentreArea(centreArea);
		fbad.enterNumberOfTrainingRooms(trainingRooms);
		fbad.enterNumbersOfLabs(labNumber);
		fbad.enterReceptionAreaSize(receptionArea);
		fbad.enterWaitingAreaCapacity(waitingArea);
		fbad.enterNumberOfMaleWashRooms(maleWashRooms);
		fbad.enterNumberOfFemaleWashRooms(femaleWashRooms);
		fbad.enterNumberOfUnisexWashRooms(unisexWashRooms);
		fbad.enterDistanceFromNearestAirport(airportDistance);
		fbad.enterDistanceFromNearestTrainStation(trainStationDistance);
		fbad.enterDistanceFromNearestCityCentre(cityCentreDistance);
		fbad.enterAddressOFTC(tcAddress);
		fbad.enterNearByLandmark(landmark);
		fbad.enterPincode(pincode);
		Thread.sleep(2000);
		fbad.selectState(state);
		Thread.sleep(2000);
		fbad.selrctDistrict(district);
		Thread.sleep(2000);
		fbad.selectTehsil(tehsil);
		Thread.sleep(2000);
		fbad.selectCityOrVillage(city);
		Thread.sleep(2000);
		fbad.selectParliamentryConstituency(parliamentryConstituency);
		fbad.enterGeoLocation(geoLocation);
		//fbad.selectAddressProofType(addressProof);
		Thread.sleep(3000);
		fbad.clickOnAllFacilitiesCheckBoxes();
		Thread.sleep(2000);
		fbad.enterNameOfSPOC(spocName);
		fbad.enterEmailAddressOfSPOC(thirdSPOCEmail);
		fbad.enterMobileNumberOfSPOC(thirdSPOCMobile);
		fbad.enterDesignationOfSPOC(spocDesignation);
		fbad.enterLandLineNumberOfSPOC(spocLandLine);
		fbad.clickOnTrainingRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(tcRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnTrainingRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(laboratoryPhotos);
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(washRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(cafetariaPhotos);
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_UploadFile();
		Thread.sleep(10000);
		fbad.clickOnAddSectorTarget();
		Thread.sleep(3000);
		fbad.selectSector(sector);
		Thread.sleep(3000);
		//fbad.selectCourse(course);
		Thread.sleep(3000);
		fbad.enterTarget(target);
		fbad.clickOnSubmit_SectorTarget();
		Thread.sleep(8000);
		fbad.clickOnSubmit();
		Thread.sleep(3000);
		fbad.clickOnYesAddTrainingCentre();
		Thread.sleep(3000);
		//fbad.clickOnOK();
		Thread.sleep(3000);
		fbd.clickOnViewTrainingCentres();
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+trainingCentreName+"']]]]//span[text()='Awating Approval']")).getText(), "Awating Approval");
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(5000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
	
	@DataProvider
	public Object[][] cmaApproveTC()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveTCSC15TC02");
	}
	
	@Test(dataProvider="cmaApproveTC")
	public void approveTrainingCentreTC_02(String cmaUsername, String cmaPassword, String tpID, String tcType, String status, String expectedTCName, String expectedTCStatus, String expectedOwnership, String expectedStartDate, String expectedEndDate, String expectedBathesNumber, String expectedStudentNumber, String expectedAnnualCapacity, String expectedCapacityUtilization, String expectedGovernmentTieUp, String expectedCentreCapacity, String expectedCentreArea, String expectedTrainingRooms, String expectedLabNumber, String expectedReceptionArea, String expectedWaitingArea, String expectedMaleWashRooms, String expectedFemaleWashRooms, String expectedUnisexWashRooms, String expectedAirportDistance, String expectedTrainStationDistance, String expectedCityCentreDistance, String expectedTCAddress, String expectedLandmark, String expectedPincode, String expectedState, String expectedDistrict, String expectedTehsil, String expectedCity, String expectedParliamentryConstituency, String expectedSPOCName, String expectedSPOCEmail, String expectedSPOCMobile, String expectedSPOCDesignation, String expectedSPOCLandLine, String review, String reviewComments, String expectedSecondTCName, String expectedSecondSPOCEmail, String expectedSecondSPOCMobile, String secondTCReview, String secondTCReviewComments, String expectedThirdTCName, String expectedThirdSPOCEmail, String expectedThirdSPOCMobile, String thirdTCReview, String thirdTCReviewComments) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(cmaUsername, cmaPassword);
		CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
		Thread.sleep(8000);
		cmad.clickOnViewAllTCAddRequest();
		CMA_TCRequestPage cmtc = new CMA_TCRequestPage(driver);
		Thread.sleep(5000);
		cmtc.selectType(tcType);
		cmtc.selectStatus(status);
		cmtc.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//a[contains(text(),'Take Action')]")).click();
		CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), expectedTCName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), expectedTCStatus);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), expectedOwnership);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), expectedBathesNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), expectedStudentNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), expectedAnnualCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), expectedCapacityUtilization);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), expectedGovernmentTieUp);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), expectedCentreCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), expectedCentreArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), expectedTrainingRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), expectedLabNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), expectedReceptionArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), expectedWaitingArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), expectedMaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), expectedFemaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), expectedUnisexWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), expectedAirportDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), expectedTrainStationDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), expectedCityCentreDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), expectedTCAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), expectedLandmark);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), expectedPincode);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), expectedState);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), expectedDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), expectedTehsil);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), expectedCity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), expectedParliamentryConstituency);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), expectedSPOCName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), expectedSPOCEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), expectedSPOCMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), expectedSPOCDesignation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), expectedSPOCLandLine);
		Thread.sleep(3000);
		cmat.clickOnDownloadTrainingRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadLaboratoryRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadWashRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
		Thread.sleep(3000);
		cmat.selectReview(review);
		cmat.enterReviewComments(reviewComments);
		cmat.clickOnSubmitResponse();
		cmat.clickOnOK();
		cmtc.selectType(tcType);
		Thread.sleep(3000);
		cmtc.clickOnApply();
		if(review.equals("Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
		}
		else if(review.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
		}
		else if(review.equals("Send Back"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedTCName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
		}
		Thread.sleep(3000);
		cmtc.selectStatus(status);
		cmtc.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//a[contains(text(),'Take Action')]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), expectedSecondTCName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), expectedTCStatus);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), expectedOwnership);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), expectedBathesNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), expectedStudentNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), expectedAnnualCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), expectedCapacityUtilization);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), expectedGovernmentTieUp);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), expectedCentreCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), expectedCentreArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), expectedTrainingRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), expectedLabNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), expectedReceptionArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), expectedWaitingArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), expectedMaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), expectedFemaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), expectedUnisexWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), expectedAirportDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), expectedTrainStationDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), expectedCityCentreDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), expectedTCAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), expectedLandmark);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), expectedPincode);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), expectedState);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), expectedDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), expectedTehsil);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), expectedCity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), expectedParliamentryConstituency);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), expectedSPOCName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), expectedSecondSPOCEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), expectedSecondSPOCMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), expectedSPOCDesignation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), expectedSPOCLandLine);
		Thread.sleep(3000);
		cmat.clickOnDownloadTrainingRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadLaboratoryRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadWashRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
		Thread.sleep(3000);
		cmat.selectReview(secondTCReview);
		cmat.enterReviewComments(secondTCReviewComments);
		cmat.clickOnSubmitResponse();
		cmat.clickOnOK();
		cmtc.selectType(tcType);
		Thread.sleep(3000);
		cmtc.clickOnApply();
		if(secondTCReview.equals("Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
		}
		else if(secondTCReview.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
		}
		else if(secondTCReview.equals("Send Back"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondTCName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
		}
		Thread.sleep(3000);
		cmtc.selectStatus(status);
		cmtc.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//a[contains(text(),'Take Action')]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), expectedThirdTCName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), expectedTCStatus);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), expectedOwnership);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), expectedStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), expectedEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), expectedBathesNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), expectedStudentNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), expectedAnnualCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), expectedCapacityUtilization);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), expectedGovernmentTieUp);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), expectedCentreCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), expectedCentreArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), expectedTrainingRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), expectedLabNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), expectedReceptionArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), expectedWaitingArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), expectedMaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), expectedFemaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), expectedUnisexWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), expectedAirportDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), expectedTrainStationDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), expectedCityCentreDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), expectedTCAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), expectedLandmark);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), expectedPincode);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), expectedState);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), expectedDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), expectedTehsil);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), expectedCity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), expectedParliamentryConstituency);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), expectedSPOCName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), expectedThirdSPOCEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), expectedThirdSPOCMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), expectedSPOCDesignation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), expectedSPOCLandLine);
		Thread.sleep(3000);
		cmat.clickOnDownloadTrainingRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadLaboratoryRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadWashRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
		Thread.sleep(3000);
		cmat.selectReview(thirdTCReview);
		cmat.enterReviewComments(thirdTCReviewComments);
		cmat.clickOnSubmitResponse();
		cmat.clickOnOK();
		cmtc.selectType(tcType);
		Thread.sleep(3000);
		cmtc.clickOnApply();
		if(thirdTCReview.equals("Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
		}
		else if(thirdTCReview.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
		}
		else if(thirdTCReview.equals("Send Back"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdTCName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
		}
		
		
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();

	}
	
	@DataProvider
	public Object[][] resubmitAndReviewTC()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03");
	}
	
	@Test(dataProvider="resubmitAndReviewTC")
	public void resubmitAndReviewrainingCentreTC03(String sno, String tpUsername, String tpPassword, String projectName, String firstTCName, String firstTCReview, String secondTCName, String secondTCReview, String thirdTCName, String thirdTCReview, String newTrainingCentreName, String newTCStatus, String newOwnership, String newStartDate, String newEndDate, String newBathesNumber, String newStudentNumber, String newAnnualCapacity, String newCapacityUtilization, String newGovernmentTieUp, String newCentreCapacity, String newCentreArea, String newTrainingRooms, String newLabNumber, String newReceptionArea, String newWaitingArea, String newMaleWashRooms, String newFemaleWashRooms, String newUnisexWashRooms, String newAirportDistance, String newTrainStationDistance, String newCityCentreDistance, String newTCAddress, String newLandmark, String newPincode, String newState, String newDistrict, String newTehsil, String newCity, String newParliamentryConstituency, String geoLocation, String newSpocName, String newSpocEmail, String newSpocMobile, String newSpocDesignation, String newSpocLandLine, String newTCRoomPhotos, String newLaboratoryPhotos, String newWashRoomPhotos, String newCafetariaPhotos, String newSector, String newCourse, String newTarget, String cmaUsername, String cmaPassword, String tcType, String status, String review, String reviewComments)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(8000);
		tpdp.clickOnMySchemes();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(3000);
		fbd.clickOnViewTrainingCentres();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+firstTCName+"']]]]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+thirdTCName+"']]]]//span[text()='REJECTED']")).getText(), "REJECTED");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+secondTCName+"']]]]//span[text()='Sent Back']")).getText(), "Sent Back");
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+secondTCName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+secondTCName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_AddTrainingCentrePage fbad = new TP_FeeBased_AddTrainingCentrePage(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='review']")).getAttribute("value"), "Document Required");
		//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='comment']")).getAttribute("value"), "SENT BACK");
		Thread.sleep(3000);
		fbad.enterTrainingCentreName(newTrainingCentreName);
		//fbad.selectTrainingCentreStatus(newTCStatus);
		fbad.selectForCentreOwnerShip(newOwnership);
		fbad.clickOnStartDateForTCDuration();
		newStartDate = driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 13, newStartDate);
		fbad.clickOnEndDateForTCDuration();
		newEndDate = driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "ResubmitAndReviewTCSC15TC03", Integer.parseInt(sno), 14, newEndDate);
		Thread.sleep(3000);
		fbad.enterNumberOfBatchesPerDay(newBathesNumber);
		Thread.sleep(3000);
		fbad.enterMaximumNoOfStudentPerBatch(newStudentNumber);
		fbad.enterAnnualCapacityOfTrainingCentre(newAnnualCapacity);
		fbad.enterCapacityUtilization(newCapacityUtilization);
		fbad.selectForGovernmentTieUp(newGovernmentTieUp);
		fbad.enterCentreCapacity(newCentreCapacity);
		fbad.entreCentreArea(newCentreArea);
		fbad.enterNumberOfTrainingRooms(newTrainingRooms);
		fbad.enterNumbersOfLabs(newLabNumber);
		fbad.enterReceptionAreaSize(newReceptionArea);
		fbad.enterWaitingAreaCapacity(newWaitingArea);
		fbad.enterNumberOfMaleWashRooms(newMaleWashRooms);
		fbad.enterNumberOfFemaleWashRooms(newFemaleWashRooms);
		fbad.enterNumberOfUnisexWashRooms(newUnisexWashRooms);
		fbad.enterDistanceFromNearestAirport(newAirportDistance);
		fbad.enterDistanceFromNearestTrainStation(newTrainStationDistance);
		fbad.enterDistanceFromNearestCityCentre(newCityCentreDistance);
		fbad.enterAddressOFTC(newTCAddress);
		fbad.enterNearByLandmark(newLandmark);
		fbad.enterPincode(newPincode);
		fbad.selectState(newState);
		Thread.sleep(2000);
		fbad.selrctDistrict(newDistrict);
		Thread.sleep(2000);
		fbad.selectTehsil(newTehsil);
		Thread.sleep(2000);
		fbad.selectCityOrVillage(newCity);
		Thread.sleep(2000);
		fbad.selectParliamentryConstituency(newParliamentryConstituency);
		fbad.enterGeoLocation(geoLocation);
		//fbad.selectAddressProofType(addressProof);
		Thread.sleep(3000);
		//fbad.clickOnAllFacilitiesCheckBoxes();
		Thread.sleep(2000);
		fbad.enterNameOfSPOC(newSpocName);
		fbad.enterEmailAddressOfSPOC(newSpocEmail);
		fbad.enterMobileNumberOfSPOC(newSpocMobile);
		fbad.enterDesignationOfSPOC(newSpocDesignation);
		fbad.enterLandLineNumberOfSPOC(newSpocLandLine);
		fbad.clickOnTrainingRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(newTCRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnTrainingRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(newLaboratoryPhotos);
		Thread.sleep(3000);
		fbad.clickOnLaboratoryPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(newWashRoomPhotos);
		Thread.sleep(3000);
		fbad.clickOnWashRoomPhotos_UploadFile();
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(newCafetariaPhotos);
		Thread.sleep(3000);
		fbad.clickOnCafetariaPhotos_UploadFile();
		Thread.sleep(10000);
		fbad.clickOnAddSectorTarget();
		Thread.sleep(3000);
		fbad.selectSector(newSector);
		//fbad.selectCourse(newCourse);
		Thread.sleep(3000);
		fbad.enterTarget(newTarget);
		fbad.clickOnSubmit_SectorTarget();
		Thread.sleep(5000);
		fbad.clickOnResubmit();
		Thread.sleep(3000);
		fbad.clickOnYesAddTrainingCentre();
		Thread.sleep(3000);
		fbad.clickOnOK();
		Thread.sleep(3000);
		//fbd.clickOnViewTrainingCentres();
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='RESUBMITTED']")).getText(), "RESUBMITTED");
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(5000);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
		
		lp.clickLogin();
		Thread.sleep(3000);
		elp.performlogin(cmaUsername, cmaPassword);
		CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
		Thread.sleep(8000);
		cmad.clickOnViewAllTCAddRequest();
		CMA_TCRequestPage cmtc = new CMA_TCRequestPage(driver);
		Thread.sleep(5000);
		cmtc.selectType(tcType);
		cmtc.selectStatus(status);
		cmtc.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//a[contains(text(),'Take Action')]")).click();
		CMA_TrainingCentreInfoPage cmat = new CMA_TrainingCentreInfoPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), newTrainingCentreName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='activeStatus']")).getAttribute("value"), newTCStatus);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='ownership']")).getAttribute("value"), newOwnership);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Effective Date']")).getAttribute("value"), newStartDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Select Close Date']")).getAttribute("value"), newEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='noOfBatchesPerDay']")).getAttribute("value"), newBathesNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='maximumStudentsPerBatch']")).getAttribute("value"), newStudentNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='annualCentreTrainingCapacity']")).getAttribute("value"), newAnnualCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='capacityUtilization']")).getAttribute("value"), newCapacityUtilization);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='governmentTieUp']")).getAttribute("value"), newGovernmentTieUp);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalCapacity']")).getAttribute("value"), newCentreCapacity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreCarpetArea']")).getAttribute("value"), newCentreArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfTrainingRooms']")).getAttribute("value"), newTrainingRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='totalNumberOfLabs']")).getAttribute("value"), newLabNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='receptionCarpetArea']")).getAttribute("value"), newReceptionArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='waitingAreaCapacity']")).getAttribute("value"), newWaitingArea);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfMaleWashRooms']")).getAttribute("value"), newMaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfFemaleWashRooms']")).getAttribute("value"), newFemaleWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='numberOfTransGenderWashRooms']")).getAttribute("value"), newUnisexWashRooms);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestAirport']")).getAttribute("value"), newAirportDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestTrainStation']")).getAttribute("value"), newTrainStationDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='distanceFromNearestCityCenter']")).getAttribute("value"), newCityCentreDistance);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='address1']")).getAttribute("value"), newTCAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landmark']")).getAttribute("value"), newLandmark);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='pincode']")).getAttribute("value"), newPincode);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"), newState);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='district']")).getAttribute("value"), newDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='tehsil']")).getAttribute("value"), newTehsil);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"), newCity);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='parliamentaryConstituency']")).getAttribute("value"), newParliamentryConstituency);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"), newSpocName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), newSpocEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='mobileNumber']")).getAttribute("value"), newSpocMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='centreSPOCDesignation']")).getAttribute("value"), newSpocDesignation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='landline']")).getAttribute("value"), newSpocLandLine);
		Thread.sleep(3000);
		cmat.clickOnDownloadTrainingRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadLaboratoryRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadWashRoomPhotos();
		Thread.sleep(3000);
		cmat.clickOnDownloadCafetariaOrDinningRoomPhotos();
		Thread.sleep(3000);
		cmat.selectReview(review);
		cmat.enterReviewComments(reviewComments);
		cmat.clickOnSubmitResponse();
		cmat.clickOnOK();
		cmtc.selectType(tcType);
		Thread.sleep(3000);
		cmtc.clickOnApply();
		if(review.equals("Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
		}
		else if(review.equals("Not Recommended"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='NOT RECOMMENDED']")).getText(), "NOT RECOMMENDED");			
		}
		else if(review.equals("Send Back"))
		{
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+newTrainingCentreName+"']]]]//span[text()='SENT BACK']")).getText(), "SENT BACK");
		}
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		
	}
	
	
	
	@DataProvider
	public Object[][] addSectorAndCourses()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSector&CoursSC15TC04");
	}
	
	@Test(dataProvider="addSectorAndCourses")
	public void addSectorAndCourseTC04(String srno, String tpusername, String tppassword, String projectName, String addedSector, String sector, String trainingTarget, String undertakingFile, String affiliationCertificate, String secondSector, String thirdSector, String addedCourse, String courseName, String jobRole, String jobRoleName, String nsqfLevel, String courseDescription, String certificateName, String minimumAge, String minimumEducation, String courseDuration, String hourPerDay, String courseFee, String gradingPreference, String courseApprovalFile, String affiliationFile, String workOrderFile, String challanOfFeePaid, String stampPaper, String secondCourseName, String thirdCourseName) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpusername, tppassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(8000);
		tpdp.clickOnMySchemes();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();		
		TP_FeeBased_DashboardPage tpfb = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(3000);
		tpfb.clickOnViewSectorAndCourses();
		TP_FeeBased_ViewAllSectorAndCoursesPage fbsc = new TP_FeeBased_ViewAllSectorAndCoursesPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+addedSector+"']]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
		Thread.sleep(5000);
		fbsc.clickOnAddSector();
		Thread.sleep(5000);
		fbsc.selectSector(sector);
		fbsc.enterProposedTrainingTarget(trainingTarget);
		fbsc.clickOnUndertakingDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(undertakingFile);
		Thread.sleep(3000);
		fbsc.clickOnUndertakingDocument_UploadFile();
		Thread.sleep(3000);
		fbsc.clickOnAffiliationCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationCertificate);
		Thread.sleep(3000);
		fbsc.clickOnAffiliationCertificate_UploadFile();
		Thread.sleep(3000);
		fbsc.clickOnSubmit();
		Thread.sleep(3000);
		fbsc.clickOnOK();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//span[text()='CREATED']")).getText(), "CREATED");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//td[text()='"+trainingTarget+"']")).getText(), trainingTarget);
		Thread.sleep(3000);
		fbsc.clickOnAddSector();
		Thread.sleep(3000);
		fbsc.selectSector(secondSector);
		fbsc.enterProposedTrainingTarget(trainingTarget);
		fbsc.clickOnUndertakingDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(undertakingFile);
		Thread.sleep(3000);
		fbsc.clickOnUndertakingDocument_UploadFile();
		Thread.sleep(3000);
		fbsc.clickOnAffiliationCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationCertificate);
		Thread.sleep(3000);
		fbsc.clickOnAffiliationCertificate_UploadFile();
		Thread.sleep(3000);
		fbsc.clickOnSubmit();
		Thread.sleep(3000);
		fbsc.clickOnOK();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondSector+"']]//span[text()='CREATED']")).getText(), "CREATED");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondSector+"']]//td[text()='"+trainingTarget+"']")).getText(), trainingTarget);
		Thread.sleep(3000);
		fbsc.clickOnAddSector();
		Thread.sleep(3000);
		fbsc.selectSector(thirdSector);
		Thread.sleep(3000);
		fbsc.enterProposedTrainingTarget(trainingTarget);
		fbsc.clickOnUndertakingDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(undertakingFile);
		Thread.sleep(3000);
		fbsc.clickOnUndertakingDocument_UploadFile();
		Thread.sleep(3000);
		fbsc.clickOnAffiliationCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationCertificate);
		Thread.sleep(3000);
		fbsc.clickOnAffiliationCertificate_UploadFile();
		Thread.sleep(3000);
		fbsc.clickOnSubmit();
		Thread.sleep(3000);
		fbsc.clickOnOK();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdSector+"']]//span[text()='CREATED']")).getText(), "CREATED");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdSector+"']]//td[text()='"+trainingTarget+"']")).getText(), trainingTarget);
		
		fbsc.clickOnAddedCourse();
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+addedCourse+"']]//span[text()='RECOMMENDED']")).getText(), "RECOMMENDED");
		Thread.sleep(3000);
		fbsc.clickOnAddCourse();
		TP_FeeBased_AddCourseToSectorsPage adc = new TP_FeeBased_AddCourseToSectorsPage(driver);
		
		adc.selectSector(addedSector);
		adc.selectJobRoleMappingType(jobRole);
		if(jobRole.equals("QP-NOS"))
		{
			adc.selectAssociatedQPOrJobRoleName(jobRoleName);
			Thread.sleep(3000);
			adc.enterCourseName(courseName);
			nsqfLevel = driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSector&CoursSC15TC04", Integer.parseInt(srno), 15, nsqfLevel);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveSector&CourseSC15TC05", Integer.parseInt(srno), 19, nsqfLevel);
			ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(srno), 15, nsqfLevel);
			//adc.enterCourseDescription(courseDescription);
			adc.enterNameOfTheCertificateIssued(certificateName);
			//adc.selectMinimumAge(minimumAge);
		}
		else
		{
			adc.enterCourseName(courseName);
			adc.enterCourseDescription(courseDescription);
			adc.enterNameOfTheCertificateIssued(certificateName);
			adc.selectMinimumAge(minimumAge);
		}
		
		adc.selectMinimumEducationRequired(minimumEducation);
		adc.enterCourseDuration(courseDuration);
		adc.enterNumberOfHours(hourPerDay);
		adc.enterCourseFee(courseFee);
		adc.selectGradingPrefrences(gradingPreference);
		Thread.sleep(3000);
		adc.clickOnCourseApprovalDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(courseApprovalFile);
		Thread.sleep(3000);
		adc.clickOnCourseApprovalDocument_UploadFile();
		Thread.sleep(3000);
		adc.clickOnAffiliationCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationFile);
		Thread.sleep(3000);
		adc.clickOnAffiliationCertificate_UploadFile();
		Thread.sleep(3000);
		adc.clickOnWorkOrder_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(workOrderFile);
		Thread.sleep(3000);
		adc.clickOnWorkOrder_UploadFile();
		Thread.sleep(3000);
		adc.clickOnChallanOfFeePaid_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(challanOfFeePaid);
		Thread.sleep(3000);
		adc.clickOnChallanOfFeePaid_UploadFile();
		Thread.sleep(3000);
		adc.clickOnStampPaper_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(stampPaper);
		Thread.sleep(3000);
		adc.clickOnStampPaper_UploadFile();
		Thread.sleep(3000);
		adc.clickOnSubmit();
		Thread.sleep(3000);
		fbsc.clickOnAddedCourse();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//span[text()='CREATED']")).getText(), "CREATED");
		if(jobRole.equals("QP-NOS"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+jobRoleName+"']")).getText(), jobRoleName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+nsqfLevel+"']")).getText(), nsqfLevel);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+courseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
		}
		Thread.sleep(3000);
		fbsc.clickOnAddCourse();
		adc.selectSector(addedSector);
		adc.selectJobRoleMappingType(jobRole);
		if(jobRole.equals("QP-NOS"))
		{
			adc.selectAssociatedQPOrJobRoleName(jobRoleName);
			Thread.sleep(3000);
			adc.enterCourseName(secondCourseName);
			nsqfLevel = driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value");
			//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(srno), 13, nsqfLevel);
			//adc.enterCourseDescription(courseDescription);
			adc.enterNameOfTheCertificateIssued(certificateName);
			//adc.selectMinimumAge(minimumAge);
		}
		else
		{
			Thread.sleep(3000);
			adc.enterCourseName(secondCourseName);
			adc.enterCourseDescription(courseDescription);adc.enterNameOfTheCertificateIssued(certificateName);
			adc.selectMinimumAge(minimumAge);
		}
		
		adc.selectMinimumEducationRequired(minimumEducation);
		adc.enterCourseDuration(courseDuration);
		adc.enterNumberOfHours(hourPerDay);
		adc.enterCourseFee(courseFee);
		adc.selectGradingPrefrences(gradingPreference);
		Thread.sleep(3000);
		adc.clickOnCourseApprovalDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(courseApprovalFile);
		Thread.sleep(3000);
		adc.clickOnCourseApprovalDocument_UploadFile();
		Thread.sleep(3000);
		adc.clickOnAffiliationCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationFile);
		Thread.sleep(3000);
		adc.clickOnAffiliationCertificate_UploadFile();
		Thread.sleep(3000);
		adc.clickOnWorkOrder_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(workOrderFile);
		Thread.sleep(3000);
		adc.clickOnWorkOrder_UploadFile();
		Thread.sleep(3000);
		adc.clickOnChallanOfFeePaid_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(challanOfFeePaid);
		Thread.sleep(3000);
		adc.clickOnChallanOfFeePaid_UploadFile();
		Thread.sleep(3000);
		adc.clickOnStampPaper_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(stampPaper);
		Thread.sleep(3000);
		adc.clickOnStampPaper_UploadFile();
		Thread.sleep(3000);
		adc.clickOnSubmit();
		Thread.sleep(3000);
		fbsc.clickOnAddedCourse();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//span[text()='CREATED']")).getText(), "CREATED");
		if(jobRole.equals("QP-NOS"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+jobRoleName+"']")).getText(), jobRoleName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+nsqfLevel+"']")).getText(), nsqfLevel);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+secondCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
		}
		Thread.sleep(3000);
		fbsc.clickOnAddCourse();
		adc.selectSector(addedSector);
		adc.selectJobRoleMappingType(jobRole);
		if(jobRole.equals("QP-NOS"))
		{
			adc.selectAssociatedQPOrJobRoleName(jobRoleName);
			adc.enterCourseName(thirdCourseName);
			nsqfLevel = driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value");
			//ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "MySchemeAddSectorSC15TC03", Integer.parseInt(srno), 13, nsqfLevel);
			//adc.enterCourseDescription(courseDescription);
			adc.enterNameOfTheCertificateIssued(certificateName);
			//adc.selectMinimumAge(minimumAge);
			
		}
		else
		{
			adc.enterCourseName(thirdCourseName);
			adc.enterCourseDescription(courseDescription);
			adc.enterNameOfTheCertificateIssued(certificateName);
			adc.selectMinimumAge(minimumAge);
		}
		
		adc.selectMinimumEducationRequired(minimumEducation);
		adc.enterCourseDuration(courseDuration);
		adc.enterNumberOfHours(hourPerDay);
		adc.enterCourseFee(courseFee);
		adc.selectGradingPrefrences(gradingPreference);
		Thread.sleep(3000);
		adc.clickOnCourseApprovalDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(courseApprovalFile);
		Thread.sleep(3000);
		adc.clickOnCourseApprovalDocument_UploadFile();
		Thread.sleep(3000);
		adc.clickOnAffiliationCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(affiliationFile);
		Thread.sleep(3000);
		adc.clickOnAffiliationCertificate_UploadFile();
		Thread.sleep(3000);
		adc.clickOnWorkOrder_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(workOrderFile);
		Thread.sleep(3000);
		adc.clickOnWorkOrder_UploadFile();
		Thread.sleep(3000);
		adc.clickOnChallanOfFeePaid_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(challanOfFeePaid);
		Thread.sleep(3000);
		adc.clickOnChallanOfFeePaid_UploadFile();
		Thread.sleep(3000);
		adc.clickOnStampPaper_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(stampPaper);
		Thread.sleep(3000);
		adc.clickOnStampPaper_UploadFile();
		Thread.sleep(3000);
		adc.clickOnSubmit();
		Thread.sleep(3000);
		fbsc.clickOnAddedCourse();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//span[text()='CREATED']")).getText(), "CREATED");
		if(jobRole.equals("QP-NOS"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+jobRoleName+"']")).getText(), jobRoleName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+nsqfLevel+"']")).getText(), nsqfLevel);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+thirdCourseName+"']]//td[text()='"+hourPerDay+"']")).getText(), hourPerDay);
		}
		PostLoginPage  plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
	}
	
	@DataProvider
	public Object[][] approveSectorAndCourses()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CMAApproveSector&CourseSC15TC05");
	}
	
	@Test(dataProvider="approveSectorAndCourses")
	public void approveSectorAndCourseTC05(String sno, String cmaUsername, String cmaPassword, String status, String tpID, String expectedSector, String expectedTrainingTarget, String sectorReviewComments, String sectorComments, String expectedSecondSector, String secondSectorReviewComments, String secondSectorComments, String expectedThirdSector, String thirdSectorReviewComments, String thirdSectorComments,  String expectedCourseName, String expectedAddedSector, String expectedJobRoleMappingType, String expectedJobRoleName, String expectedNSQFLevel, String expectedCourseDescription, String expectedIssuedCertificateName, String expectedMinimumAge, String expectedMinimumEducation, String expectedCourseDuration, String expectedNumberOfHours, String expectedCourseFee, String expectedGradingPrefrences, String courseReviewComments, String courseComments, String expectedSecondCourseName, String secondCourseReviewComments, String secondCourseComments, String expectedThirdCourseName, String thirdCourseReviewComments, String thirdCourseComments)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(cmaUsername, cmaPassword);
		CMA_DashboardPage cmad = new CMA_DashboardPage(driver);
		Thread.sleep(8000);
		cmad.clickOnViewAllSector();
		CMA_AddSectorRequestPage cmas = new CMA_AddSectorRequestPage(driver);
		Thread.sleep(3000);
		cmas.selectStatus(status);
		cmas.enterTPID(tpID);
		Thread.sleep(5000);
		cmas.clickOnApply();
		Thread.sleep(3000);
		List <WebElement> button = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int size = button.size();
		WebElement ele = button.get(size-1);
		ele.click();
		Thread.sleep(3000);
		List<WebElement> sec = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
		int size1 = sec.size();
		WebElement tab = sec.get(size1-1);
		tab.click();
		CMA_SectorInfoPage cmsi = new CMA_SectorInfoPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposedTrainingTarget']")).getAttribute("value"), expectedTrainingTarget);
		cmsi.clickOnDownloadSectorApprovalButton();
		cmsi.clickOnDownloadAffiliationCertificateFromSSC();
		cmsi.selectReviewComments(sectorReviewComments);
		cmsi.enterReviewComents_ForSector(sectorComments);
		cmsi.clickOnSubmitResponse();
		Thread.sleep(3000);
		cmas.selectStatus(sectorComments);
		cmas.enterTPID(tpID);
		Thread.sleep(10000);
		cmas.clickOnApply();
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='"+sectorComments+"'])[1]")).getText(), sectorComments);
		Thread.sleep(3000);
		cmas.selectStatus(status);
		Thread.sleep(8000);
		cmas.clickOnApply();
		Thread.sleep(3000);
		List <WebElement> buton = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int siz = buton.size();
		WebElement el = buton.get(siz-1);
		Thread.sleep(5000);
		el.click();
		Thread.sleep(3000);
		List<WebElement> se = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
		int siz1 = se.size();
		WebElement ta = se.get(siz1-1);
		Thread.sleep(5000);
		ta.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedSecondSector);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposedTrainingTarget']")).getAttribute("value"), expectedTrainingTarget);
		cmsi.clickOnDownloadSectorApprovalButton();
		cmsi.clickOnDownloadAffiliationCertificateFromSSC();
		cmsi.selectReviewComments(secondSectorReviewComments);
		cmsi.enterReviewComents_ForSector(secondSectorComments);
		cmsi.clickOnSubmitResponse();
		Thread.sleep(3000);
		cmas.selectStatus(secondSectorComments);
		cmas.enterTPID(tpID);
		Thread.sleep(8000);
		cmas.clickOnApply();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='"+secondSectorComments+"'])[1]")).getText(), secondSectorComments);
		Thread.sleep(3000);
		cmas.selectStatus(status);
		Thread.sleep(8000);
		cmas.clickOnApply();
		Thread.sleep(3000);
		List <WebElement> butn = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int sz = butn.size();
		WebElement elm = butn.get(sz-1);
		Thread.sleep(5000);
		elm.click();
		Thread.sleep(3000);
		List<WebElement> sez = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
		int sz1 = sez.size();
		WebElement tak = sez.get(sz1-1);
		Thread.sleep(5000);
		tak.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedThirdSector);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='proposedTrainingTarget']")).getAttribute("value"), expectedTrainingTarget);
		cmsi.clickOnDownloadSectorApprovalButton();
		cmsi.clickOnDownloadAffiliationCertificateFromSSC();
		cmsi.selectReviewComments(thirdSectorReviewComments);
		cmsi.enterReviewComents_ForSector(thirdSectorComments);
		cmsi.clickOnSubmitResponse();
		Thread.sleep(3000);
		cmas.selectStatus(thirdSectorComments);
		cmas.enterTPID(tpID);
		Thread.sleep(8000);
		cmas.clickOnApply();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[span[span[text()='"+tpID+"']]]]//span[text()='"+thirdSectorComments+"'])[1]")).getText(), thirdSectorComments);
		
		Thread.sleep(10000);
		cmad.clickOnDashboard();
		Thread.sleep(8000);
		cmad.clickOnViewAllCourseAddRequest();
		CMA_AddCourseRequestsPage cmac = new CMA_AddCourseRequestsPage(driver);
		cmac.selectStatus(status);
		cmac.enterTPID(tpID);
		Thread.sleep(8000);
		cmac.clickOnApply();
		Thread.sleep(5000);
		List<WebElement> cou = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int size2 = cou.size();
		WebElement act = cou.get(size2-1);
		act.click();
		Thread.sleep(3000);
		List<WebElement> crs = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
		int size3 = crs.size();
		WebElement tap = crs.get(size3-1);
		tap.click();
		CMA_CourseInfoPage cmci = new CMA_CourseInfoPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='course']")).getAttribute("value"), expectedCourseName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedAddedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleMappingType']")).getAttribute("value"), expectedJobRoleMappingType);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleName']")).getAttribute("value"), expectedJobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
		//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value"), expectedCourseDescription);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumAge']")).getAttribute("value"), expectedMinimumAge);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumEducationRequiredValue']")).getAttribute("value"), expectedMinimumEducation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseDurationInDays']")).getAttribute("value"), expectedCourseDuration);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='hoursPerDay']")).getAttribute("value"), expectedNumberOfHours);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseFee']")).getAttribute("value"), expectedCourseFee);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='gradingPreferences']")).getAttribute("value"), expectedGradingPrefrences);
		cmci.clickOnDownloadCourseApprovalDocument();
		cmci.clickOnDownloadAffiliationCertificateFromSSC();
		cmci.clickOnDownloadWorkOrder();
		cmci.clciOnDownloadChallanOfFeePaid();
		cmci.clickOnDownloadStampPaperWithSelfDeclaration();
		cmci.selectReviewComments(courseReviewComments);
		cmci.enterComments(courseComments);
		cmci.clickOnSubmitResponse();
		cmac.selectStatus(courseComments);
		cmac.enterTPID(tpID);
		Thread.sleep(8000);
		cmac.clickOnApply();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+expectedCourseName+"']]]]//span[text()='"+courseComments+"']")).getText(), courseComments);
		Thread.sleep(3000);
		cmac.selectStatus(status);
		Thread.sleep(8000);
		cmac.clickOnApply();
		Thread.sleep(3000);
		List<WebElement> cour = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int siz2 = cour.size();
		WebElement actn = cour.get(siz2-1);
		Thread.sleep(5000);
		actn.click();
		Thread.sleep(3000);
		List<WebElement> crse = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
		int siz3 = crse.size();
		WebElement tapm = crse.get(siz3-1);
		Thread.sleep(5000);
		tapm.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='course']")).getAttribute("value"), expectedSecondCourseName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedAddedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleMappingType']")).getAttribute("value"), expectedJobRoleMappingType);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleName']")).getAttribute("value"), expectedJobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
		//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value"), expectedCourseDescription);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumAge']")).getAttribute("value"), expectedMinimumAge);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumEducationRequiredValue']")).getAttribute("value"), expectedMinimumEducation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseDurationInDays']")).getAttribute("value"), expectedCourseDuration);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='hoursPerDay']")).getAttribute("value"), expectedNumberOfHours);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseFee']")).getAttribute("value"), expectedCourseFee);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='gradingPreferences']")).getAttribute("value"), expectedGradingPrefrences);
		cmci.clickOnDownloadCourseApprovalDocument();
		cmci.clickOnDownloadAffiliationCertificateFromSSC();
		cmci.clickOnDownloadWorkOrder();
		cmci.clciOnDownloadChallanOfFeePaid();
		cmci.clickOnDownloadStampPaperWithSelfDeclaration();
		cmci.selectReviewComments(secondCourseReviewComments);
		cmci.enterComments(secondCourseComments);
		cmci.clickOnSubmitResponse();
		cmac.selectStatus(secondCourseComments);
		Thread.sleep(3000);
		cmac.enterTPID(tpID);
		Thread.sleep(8000);
		cmac.clickOnApply();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedSecondCourseName+"']]]]//span[text()='"+secondCourseComments+"']")).getText(), secondCourseComments);
		Thread.sleep(3000);
		cmac.selectStatus(status);
		Thread.sleep(8000);
		cmac.clickOnApply();
		Thread.sleep(3000);
		List<WebElement> cours = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']"));
		int sze2 = cours.size();
		WebElement acti = cours.get(sze2-1);
		Thread.sleep(5000);
		acti.click();
		Thread.sleep(3000);
		List<WebElement> crss = driver.findElements(By.xpath("//tr[td[span[span[text()='"+tpID+"']]]]//a[contains(text(),'Take Action')]"));
		int sze3 = crss.size();
		WebElement tapk = crss.get(sze3-1);
		Thread.sleep(5000);
		tapk.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='course']")).getAttribute("value"), expectedThirdCourseName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sectorName']")).getAttribute("value"), expectedAddedSector);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleMappingType']")).getAttribute("value"), expectedJobRoleMappingType);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='jobRoleName']")).getAttribute("value"), expectedJobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
		//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='description']")).getAttribute("value"), expectedCourseDescription);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='issuedCertificateName']")).getAttribute("value"), expectedIssuedCertificateName);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumAge']")).getAttribute("value"), expectedMinimumAge);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='minimumEducationRequiredValue']")).getAttribute("value"), expectedMinimumEducation);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseDurationInDays']")).getAttribute("value"), expectedCourseDuration);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='hoursPerDay']")).getAttribute("value"), expectedNumberOfHours);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='courseFee']")).getAttribute("value"), expectedCourseFee);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='gradingPreferences']")).getAttribute("value"), expectedGradingPrefrences);
		cmci.clickOnDownloadCourseApprovalDocument();
		cmci.clickOnDownloadAffiliationCertificateFromSSC();
		cmci.clickOnDownloadWorkOrder();
		cmci.clciOnDownloadChallanOfFeePaid();
		cmci.clickOnDownloadStampPaperWithSelfDeclaration();
		cmci.selectReviewComments(thirdCourseReviewComments);
		cmci.enterComments(thirdCourseComments);
		cmci.clickOnSubmitResponse();
		cmac.selectStatus(thirdCourseComments);
		cmac.enterTPID(tpID);
		Thread.sleep(8000);
		cmac.clickOnApply();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[span[text()='"+expectedThirdCourseName+"']]]]//span[text()='"+thirdCourseComments+"']")).getText(), thirdCourseComments);
		Thread.sleep(3000);
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	
	@DataProvider
	public Object[][] linkTrainer()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06");
	}
	
	@Test(dataProvider="linkTrainer")
	public void linkTrainerTC06(String sno, String tpUsername, String tpPassword, String projectName, String trainerSDMSID, String trainerName, String tcName, String supportingDocument, String mobileOTP, String emailOTP, String trainersEmail, String trainersMobile)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(8000);
		tpdp.clickOnMySchemes();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(5000);
		fbd.clickOnViewTrainers();
		TP_FeeBased_ViewAllTrainersPage vat = new TP_FeeBased_ViewAllTrainersPage(driver);
		Thread.sleep(3000);
		vat.clickOnLinkNewTrainer();
		Thread.sleep(3000);
		vat.enterTrainerSDMSID(trainerSDMSID);
		Thread.sleep(3000);

		vat.selectAssociatedTrainingCentreName(tcName);
		vat.clickOnStartDateForValidity();
		vat.clickOnEndDateForValidity();
		Thread.sleep(3000);
		vat.clickOnSupportingDocument_BrowseFileButton();
		Thread.sleep(3000);
		UploadFile.upload(supportingDocument);
		Thread.sleep(3000);
		vat.clickOnSuppoertingDocument_UploadFileButton();
		Thread.sleep(3000);
		trainerName = driver.findElement(By.xpath("//input[@id='nameOfTheTrainer']")).getAttribute("value");
		Thread.sleep(3000);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 5, trainerName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 16, trainerName);
		Thread.sleep(5000);
		vat.clickOnGenerateOTP();
		Thread.sleep(3000);
		vat.enterMobileOTP(mobileOTP);
		vat.enterEmailOTP(emailOTP);
		vat.clickOnVerifyOTP();
		vat.clickOnOK();
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+trainerName+"']")).getText(), trainerName);
		Thread.sleep(3000);
		trainersEmail = driver.findElement(By.xpath("(//tr[td[text()='"+trainerName+"']]/td)[3]")).getText();
		Thread.sleep(3000);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 10, trainersEmail);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 17, trainersEmail);
		Thread.sleep(3000);
		trainersMobile = driver.findElement(By.xpath("(//tr[td[text()='"+trainerName+"']]/td)[4]")).getText();
		Thread.sleep(3000);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "TPFeeBasedLinkTrainerSC15TC06", Integer.parseInt(sno), 11, trainersMobile);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 18, trainersMobile);
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
	}
	
	
	@DataProvider
	public Object[][] addAssessmentAgencyAndLinkAssessor()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07");
	}
	
	@Test(dataProvider="addAssessmentAgencyAndLinkAssessor")
	public void addAssessmentAgencyAndLinkAssessorTC07(String srno, String tpUsername, String tpPassword, String projectName, String assessmentAgencyName, String supportingDocumentFile, String assessmentAgencyAddress, String landmark, String pincode, String state, String district, String tehsil, String parliamentryConstoituency, String geoLocation, String firstName, String lastName, String email, String mobileNumber, String asseementAgencyID,  String assessorID, String assessorName, String assessmentAgency, String supportingDocument_Assessor, String mobileOTP, String emailOTP)throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(8000);
		tpdp.clickOnMySchemes();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(5000);
		fbd.clickOnViewAssessmentAgencyAndAssessors();
		TP_FeeBased_AssessmentAgencyAndAssessorPage tpaa = new TP_FeeBased_AssessmentAgencyAndAssessorPage(driver);
		Thread.sleep(3000);
		tpaa.clickOnAddAssessmentAgency();
		TP_FeeBased_AssessmentAgencyInfoPage aai = new TP_FeeBased_AssessmentAgencyInfoPage(driver);
		Thread.sleep(3000);
		aai.enterAssessmentAgencyName(assessmentAgencyName);
		aai.enterStartDate();
		aai.enterEndDate();
		aai.clickOnSupportingDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(supportingDocumentFile);
		Thread.sleep(3000);
		aai.clickOnSupportingDocument_UploadButton();
		Thread.sleep(3000);
		aai.enterAddressOfAssessmentAgency(assessmentAgencyAddress);
		aai.enterNearByLandmark(landmark);
		aai.enterPincode(pincode);
		aai.selectState(state);
		aai.selectDistrict(district);
		aai.selectTehsilOrBlock(tehsil);
		aai.selectParliamentryConstituency(parliamentryConstoituency);
		Thread.sleep(2000);
		aai.enterGeoLocation(geoLocation);
		Thread.sleep(3000);
		aai.enterFirstNameOfSPOC(firstName);
		aai.enterLastNameOfSPOC(lastName);
		aai.enterEmailAddressOfSPOC(email);
		aai.enterMobileNumberOfSPOC(mobileNumber);
		aai.clickOnSubmit();
		asseementAgencyID = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().replace("Assessment Agency ", "").replace(" successfully added.", "");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07", Integer.parseInt(srno), 18, asseementAgencyID);
		aai.clickOnOK();
		Thread.sleep(3000);
		tpaa.clickOnLinkAssessor();
		Thread.sleep(3000);
		tpaa.enterAssessorSDMSID(assessorID);
		Thread.sleep(3000);
		tpaa.selectAssessmentAgencyAligned(assessmentAgency);
		tpaa.clickOnStartDateForValidity();
		tpaa.clickOnEndDateForValidity();
		Thread.sleep(3000);
		tpaa.clickOnSupportingDocument_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(supportingDocument_Assessor);
		Thread.sleep(3000);
		tpaa.clickOnSupportingDocument_UploadFile();
		Thread.sleep(5000);
		assessorName = driver.findElement(By.xpath("//input[@id='nameOfAssessor']")).getAttribute("value");
		Thread.sleep(3000);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "AddAssessmentAgencySC15TC07", Integer.parseInt(srno), 20, assessorName);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(srno), 29, assessorName);
		Thread.sleep(5000);
		tpaa.clickOnGenerateOTP();
		Thread.sleep(3000);
		tpaa.enterMobileOTP(mobileOTP);
		tpaa.enterEmailOTP(emailOTP);
		tpaa.clickOnVerifyOTP();
		Thread.sleep(3000);
		tpaa.clickOnOK();
		
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		
	}
	
	
	@DataProvider
	public Object[][] createBatchAndEnrollCandidates()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08");
	}
	
	@Test(dataProvider="createBatchAndEnrollCandidates")
	public void createBatchAndEnrollCandidateTC08(String sno, String tpUsername, String tpPassword, String candidateRegistrationFile, String projectName, String tcName, String sector, String course, String target, String batchName, String batchSize, String batchType, String courseName, String expectedSector, String expectedAssociatedQP, String expectedNSQFLevel, String trainerName, String expectedTrainersEmail, String expectedTrainersMobile, String assessmentMode, String trainingFee, String feePaidBy, String batchID, String candidateList, String sscUsername, String sscPassword, String assessmentAgencyID, String aaPassword, String assessorID, String asPassword, String assessmentAgency, String assessor, String certificateFile, String offerLetter, String appointmentLetter, String salarySlip) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(20000);
		//tpdp.clickOnRegisterCandidate();
		//Thread.sleep(2000);
		//tpdp.clickOnRegisterCandidate();
		tpdp.clickMyCandidates();
		/*Thread.sleep(3000);
		tpdp.clickToChooseBulkExcelSheetUpload();
		Thread.sleep(3000);
		tpdp.clickForExcelFileBrowse();
		Thread.sleep(3000);
		UploadFile.upload(candidateRegistrationFile);
		Thread.sleep(3000);
		tpdp.clickRegister();
		Thread.sleep(3000);*/
		TrainingPartner_MyCandidatesPage tpmc = new TrainingPartner_MyCandidatesPage(driver);
		Thread.sleep(3000);
		/*tpmc.clickRegisterCandidate();
		Thread.sleep(3000);
		tpmc.clickForExcelFileBrowse();
		Thread.sleep(3000);
		UploadFile.upload(candidateList);
		Thread.sleep(3000);
		tpmc.clickRegister();*/
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@class='m-checkbox m-checkbox--solid m-checkbox--state-brand']/span")).click();
		Thread.sleep(5000);
		tpmc.clickToDownloadReportForSelectedCandidates();
		Thread.sleep(10000);
		tpdp.clickOnDashboard();
		Thread.sleep(10000);
		tpdp.clickOnMySchemes();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();		
		TP_FeeBased_DashboardPage tpfb = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(3000);
		tpfb.clickOnViewTrainingCentres();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+tcName+"']]]]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+tcName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+tcName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_CreateBatchAddSectorTargetPage cbas = new TP_FeeBased_CreateBatchAddSectorTargetPage(driver);
		Thread.sleep(5000);
		/*cbas.clickOnAddSectorTargets();
		cbas.selectSector(sector);
		cbas.selectCourse(course);
		cbas.enterTarget(target);
		cbas.clickOnSubmit();*/
		Thread.sleep(5000);
		cbas.clickOnAssignedSectorTargets();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+sector+"']")).getText(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//td[text()='"+course+"']")).getText(), course);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+sector+"']]//td[text()='"+target+"']")).getText(), target);
		Thread.sleep(5000);
		cbas.clickOnCreateBatch();
		TP_FeeBased_BatchDetailsPage fbd = new TP_FeeBased_BatchDetailsPage(driver);
		Thread.sleep(3000);
		fbd.enterBatchName(batchName);
		Thread.sleep(3000);
		fbd.enterBatchSize(batchSize);
		Thread.sleep(3000);
		fbd.clickOnStartDate_BatchDuration();
		fbd.clickOnEndDate_BatchDuration();
		fbd.selectBatchType(batchType);
		fbd.selectCourseName(courseName);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Sector']")).getAttribute("value"), expectedSector);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='qpCode']")).getAttribute("value"), expectedAssociatedQP);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='nsqfLevel']")).getAttribute("value"), expectedNSQFLevel);
		Thread.sleep(3000);
		fbd.selectTrainerName(trainerName);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).getAttribute("value"), expectedTrainersEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).getAttribute("value"), expectedTrainersMobile);
		fbd.clickOnStartDate_TrainingDuration();
		fbd.clickOnEndDate_TrainingDuration();
		Thread.sleep(3000);
		fbd.clickOnStartDate_AssessmentDuration();
		fbd.clickOnEndDate_AssessmentDuration();
		Thread.sleep(3000);
		fbd.selectAssessmentMode(assessmentMode);
		fbd.enterTrainingFee(trainingFee);
		Thread.sleep(3000);
		fbd.selectFeePaidBy(feePaidBy);
		Thread.sleep(3000);
		fbd.clickOnSaveAndSubmitBatch();
		Thread.sleep(3000);
		fbd.clickOnYesCreateBatch();
		Thread.sleep(3000);
		batchID = driver.findElement(By.xpath("//div[@id='swal2-content']")).getText().replace("Batch ID - ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "CreateBatch&EnrollCandSC15TC08", Integer.parseInt(sno), 22, batchID);
		ReadWriteData.setExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "GenerateCertificationSC15TC09", Integer.parseInt(sno), 5, batchID);
		fbd.clickOnEnrollCandidates();
		TP_FeeBased_EnrollCandidatesPage fec = new TP_FeeBased_EnrollCandidatesPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-badge m-badge--info m-badge--wide status-badge']")).getText(), "Enroll Candidates");
		Thread.sleep(3000);
		fec.clickOnUploadCandidateList();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "Candidate Enrollment");
		Thread.sleep(3000);
		fec.clickOnCandidateList_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(candidateList);
		Thread.sleep(3000);
		fec.clickOnSubmit();
		//Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("//span[@class='m-badge m-badge--info m-badge--wide status-badge']")).getText(), "EnrollCandidates");
		Thread.sleep(8000);
		fec.clickOnReUploadCandidateList();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "enrollment");
		fec.clickOnSubmit();
		Thread.sleep(3000);
		fec.clickOnEnrollCandidates();
		Thread.sleep(8000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='attendance']")).getText(), "Attendance");
		Thread.sleep(5000);
		fec.clickOnUploadDetails();
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[1]")).getAttribute("value"), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[1]")).getAttribute("value"), "attendance");
		Thread.sleep(3000);
		fec.clickOnCandidateList_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(candidateList);
		Thread.sleep(3000);
		fec.clickOnSubmit();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='assessment']")).getText(), "Assessment");
		Thread.sleep(4000);
		fec.clickOnSubmitForAssessment();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[2]")).getAttribute("value"), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[2]")).getAttribute("value"), "assessment");
		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='assessmentMode']")).getAttribute("value").substring(3), assessmentMode);
		if(assessmentMode.equals("SSC"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='sector']")).getAttribute("value"), expectedSector);
			Thread.sleep(3000);
			fec.clickOnSubmit_AssessmentDetails();
			PostLoginPage plp = new PostLoginPage(driver);
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			lp.clickLogin();
			elp.performlogin(sscUsername, sscPassword);
			SSC_DashboardPage ssc = new SSC_DashboardPage(driver);
			Thread.sleep(5000);
			ssc.clickOnAssessmentsAndCertification();
			SSC_AssessmentsAndCertification_DashboardPage sac = new SSC_AssessmentsAndCertification_DashboardPage(driver);
			Thread.sleep(3000);
			sac.clickOnAssessmentsButton();
			SSC_AssessmentsAndCertifications_ViewAllBatchesPage svb = new SSC_AssessmentsAndCertifications_ViewAllBatchesPage(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[div[span[text()='"+batchID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[div[span[text()='"+batchID+"']]]]//a[contains(text(),'Accept')]")).click();
			Thread.sleep(3000);
			svb.clickOnAssessment_StartDate();
			svb.clickOnAssessment_EndDate();
			Thread.sleep(3000);
			svb.clickOnSubmit();
			Thread.sleep(3000);
			svb.clickOnOK();
			Thread.sleep(3000);
			svb.clickOnAccepted();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[div[span[text()='"+batchID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[div[span[text()='"+batchID+"']]]]//a[contains(text(),'Assign Assessment Agency')]")).click();
			svb.selectAssessmentAgency(assessmentAgencyID);
			svb.clickOnSubmit_ApproveMarksheet();
			Thread.sleep(3000);
			svb.clickOnOK();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			lp.clickLogin();
			elp.performlogin(assessmentAgencyID, aaPassword);
			AssessmentAgencyDashboardPage aad = new AssessmentAgencyDashboardPage(driver);
			Thread.sleep(3000);
			aad.clickOnFeeBasedAssessmentRequest();
			AssessmentAgencyViewBatchesPage avb = new AssessmentAgencyViewBatchesPage(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Accept/Reject Batch')]")).click();
			Thread.sleep(3000);
			avb.clickToAcceptBatch();
			avb.clickToSaveAndSubmit();
			Thread.sleep(3000);
			avb.clickOk();
			Thread.sleep(3000);
			avb.clickToViewAcceptedBatches();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Assign Assessor')]")).click();
			Thread.sleep(3000);
			avb.selectAssessorsToBeAssignedForBatches(assessorID);
			Thread.sleep(2000);
			avb.clickToSaveAndSubmit();
			Thread.sleep(3000);
			avb.clickOk();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			/*lp.clickLogin();
			elp.performlogin(assessorID, asPassword);
			AssessorDashboardPage adp = new AssessorDashboardPage(driver);
			Thread.sleep(5000);
			adp.clickToGetTrainerDashboard();
			Thread.sleep(5000);
			adp.clickViewBatches();
			AssessorViewBatchesPage asvb = new AssessorViewBatchesPage(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Accept/Reject Batch')]")).click();
			Thread.sleep(3000);
			asvb.clickToAcceptBatch();
			asvb.clickToSaveAndSubmit();
			Thread.sleep(3000);
			asvb.clickOk();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();*/
			
		}
		else
		{
			Thread.sleep(3000);
			fec.selectAssessmentAgencyName(assessmentAgency);
			fec.selectAssessor(assessor);
			Thread.sleep(3000);
			fec.clickOnSubmit_AssessmentDetails();
			Thread.sleep(3000);
			fec.clickOnUploadDetails();
			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='batchId'])[2]")).getAttribute("value"), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='stage'])[2]")).getAttribute("value"), "assessment");
			Thread.sleep(3000);
			fec.clickOnCandidateList_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(candidateList);
			Thread.sleep(3000);
			fec.clickOnSubmit();
			Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Placement']")).getText(), "Placement");
			Thread.sleep(3000);
			fec.clickOnAction_FirstCandidate();
			Thread.sleep(3000);
			fec.clickOnUploadCertificate_FirstCandidate();
			Thread.sleep(3000);
			fec.clickOnCertificate();
			Thread.sleep(3000);
			fec.clickOnCertificate_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(certificateFile);
			Thread.sleep(8000);
			fec.clickOnCertificate_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSubmit_CandidateCertificate();
			Thread.sleep(3000);
			fec.clickOnAction_FirstCandidate();
			Thread.sleep(3000);
			fec.clickOnUploadPlacementDocument_FirstCandidate();
			Thread.sleep(3000);
			fec.clickOnOfferLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(offerLetter);
			Thread.sleep(5000);
			fec.clickOnOfferLetter_UploadFile();
			Thread.sleep(3000);
			fec.clickOnAppointmentLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(appointmentLetter);
			Thread.sleep(5000);
			fec.clickOnAppointmentLetter_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSalarySlip_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(salarySlip);
			Thread.sleep(5000);
			fec.clickOnSalarySlip_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSubmit_PlacementDocument();
			Thread.sleep(5000);
			fec.clickOnAction_SecondCandidate();
			Thread.sleep(3000);
			fec.clickOnUploadCertificate_SecondCandidate();
			Thread.sleep(3000);
			fec.clickOnCertificate();
			Thread.sleep(3000);
			fec.clickOnCertificate_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(certificateFile);
			Thread.sleep(5000);
			fec.clickOnCertificate_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSubmit_CandidateCertificate();
			Thread.sleep(3000);
			fec.clickOnAction_SecondCandidate();
			Thread.sleep(3000);
			fec.clickOnUploadPlacementDocument_SecondCandidate();
			Thread.sleep(3000);
			fec.clickOnOfferLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(offerLetter);
			Thread.sleep(5000);
			fec.clickOnOfferLetter_UploadFile();
			Thread.sleep(3000);
			fec.clickOnAppointmentLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(appointmentLetter);
			Thread.sleep(5000);
			fec.clickOnAppointmentLetter_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSalarySlip_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(salarySlip);
			Thread.sleep(5000);
			fec.clickOnSalarySlip_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSubmit_PlacementDocument();
			Thread.sleep(5000);
			fec.clickOnAction_ThirdCandidate();
			Thread.sleep(3000);
			fec.clickOnUploadCertificate_ThirdCandidate();
			Thread.sleep(3000);
			fec.clickOnCertificate();
			Thread.sleep(3000);
			fec.clickOnCertificate_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(certificateFile);
			Thread.sleep(5000);
			fec.clickOnCertificate_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSubmit_CandidateCertificate();
			Thread.sleep(3000);
			fec.clickOnAction_ThirdCandidate();
			Thread.sleep(3000);
			fec.clickOnUploadPlacementDocument_ThirdCandidate();
			Thread.sleep(3000);
			fec.clickOnOfferLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(offerLetter);
			Thread.sleep(5000);
			fec.clickOnOfferLetter_UploadFile();
			Thread.sleep(3000);
			fec.clickOnAppointmentLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(appointmentLetter);
			Thread.sleep(5000);
			fec.clickOnAppointmentLetter_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSalarySlip_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(salarySlip);
			Thread.sleep(5000);
			fec.clickOnSalarySlip_UploadFile();
			Thread.sleep(3000);
			fec.clickOnSubmit_PlacementDocument();
			/*Thread.sleep(12000);
			fec.clickOnBack();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchID+"']")).getText(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+batchName+"']")).getText(), batchName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+courseName+"']")).getText(), courseName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+expectedAssociatedQP+"']")).getText(), expectedAssociatedQP);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[text()='certification']")).getText(), "certification");*/
			Thread.sleep(3000);		
			PostLoginPage plp = new PostLoginPage(driver);
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			
		}
		
	
	}
	
	
	@DataProvider
	public Object[][] acceptBatch()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TP_MyScheme-Workflow.xls", "GenerateCertificationSC15TC09");
	}
	
	@Test(dataProvider="acceptBatch")
	public void acceptBatchTC08(String sno, String aaUserName, String aaPassword, String username_SSC, String password_SSC, String batchID, String tpUsername, String tpPassword, String projectName, String tcName, String certificateFile, String offerLetter, String appointmentLetter, String salarySlip)throws Exception
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(aaUserName, aaPassword);
		AssessmentAgencyDashboardPage aad = new AssessmentAgencyDashboardPage(driver);
		Thread.sleep(3000);
		aad.clickOnFeeBasedAssessmentRequest();
		AssessmentAgencyViewBatchesPage aab = new AssessmentAgencyViewBatchesPage(driver);
		Thread.sleep(3000);
		aab.clickToViewCompletedBatches();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[contains(text(),'Accept/Reject Marksheet')]")).click();
		AssessmentAgency_BatchIDPage abi = new AssessmentAgency_BatchIDPage(driver);
		Thread.sleep(3000);
		abi.clickOnEnrolledCandidatesDetails();
		Thread.sleep(3000);
		abi.clickOnAllMarksheetForBatchApproval();
		Thread.sleep(3000);
		abi.clickOnAcceptBatchMarksheet();
		Thread.sleep(3000);
		abi.clickOnSaveAndSubmit();
		Thread.sleep(3000);
		abi.clickOnOK();
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		lp.clickLogin();
		elp.performlogin(username_SSC, password_SSC);
		SSC_DashboardPage sscd = new SSC_DashboardPage(driver);
		Thread.sleep(5000);
		sscd.clickOnAssessmentsAndCertification();
		SSC_AssessmentsAndCertification_DashboardPage ssac = new SSC_AssessmentsAndCertification_DashboardPage(driver);
		Thread.sleep(3000);
		ssac.clickOnCertificationsRequestsButton();
		SSC_Certification_ViewAllBatches ssvb = new SSC_Certification_ViewAllBatches(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+batchID+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+batchID+"']]]]//a[contains(text(),'View Batch Details')]")).click();
		SSC_Certification_BatchIDPage sscb = new SSC_Certification_BatchIDPage(driver);
		Thread.sleep(3000);
		sscb.clickOnEnrolledCandidates();
		Thread.sleep(3000);
		sscb.clickForGenerateCertificate();
		Thread.sleep(3000);
		sscd.clickOnAssessmentsAndCertification();
		Thread.sleep(3000);
		ssac.clickOnCertificationsRequestsButton();
		Thread.sleep(3000);
		ssvb.clickOnCertificationCompleted();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='"+batchID+"']")).getText(), batchID);
		
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		lp.clickLogin();
		elp.performlogin(tpUsername, tpPassword);
		
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(8000);
		tpdp.clickOnMySchemes();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		//driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+" - Fee Based']]]]//a[contains(text(),'View Scheme Details')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+projectName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_DashboardPage fbd = new TP_FeeBased_DashboardPage(driver);
		Thread.sleep(5000);
		fbd.clickOnViewTrainingCentres();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[div[span[text()='"+tcName+"']]]]//span[text()='ACCEPTED']")).getText(), "ACCEPTED");
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+tcName+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[div[span[text()='"+tcName+"']]]]//a[contains(text(),'View Details')]")).click();
		TP_FeeBased_CreateBatchAddSectorTargetPage cbas = new TP_FeeBased_CreateBatchAddSectorTargetPage(driver);
		Thread.sleep(5000);
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[text()='']")), "");
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[text()='1528']]//a[text()=' View Batch Details']")).click();
		TP_FeeBased_EnrollCandidatesPage fec = new TP_FeeBased_EnrollCandidatesPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Placement']")).getText(), "Placement");
		Thread.sleep(3000);
		fec.clickOnAction_FirstCandidate();
		Thread.sleep(3000);
		fec.clickOnUploadCertificate_FirstCandidate();
		Thread.sleep(3000);
		fec.clickOnCertificate();
		Thread.sleep(3000);
		fec.clickOnCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(certificateFile);
		Thread.sleep(8000);
		fec.clickOnCertificate_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSubmit_CandidateCertificate();
		Thread.sleep(3000);
		fec.clickOnAction_FirstCandidate();
		Thread.sleep(3000);
		fec.clickOnUploadPlacementDocument_FirstCandidate();
		Thread.sleep(3000);
		fec.clickOnOfferLetter_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(offerLetter);
		Thread.sleep(5000);
		fec.clickOnOfferLetter_UploadFile();
		Thread.sleep(3000);
		fec.clickOnAppointmentLetter_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(appointmentLetter);
		Thread.sleep(5000);
		fec.clickOnAppointmentLetter_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSalarySlip_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(salarySlip);
		Thread.sleep(5000);
		fec.clickOnSalarySlip_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSubmit_PlacementDocument();
		Thread.sleep(5000);
		fec.clickOnAction_SecondCandidate();
		Thread.sleep(3000);
		fec.clickOnUploadCertificate_SecondCandidate();
		Thread.sleep(3000);
		fec.clickOnCertificate();
		Thread.sleep(3000);
		fec.clickOnCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(certificateFile);
		Thread.sleep(5000);
		fec.clickOnCertificate_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSubmit_CandidateCertificate();
		Thread.sleep(3000);
		fec.clickOnAction_SecondCandidate();
		Thread.sleep(3000);
		fec.clickOnUploadPlacementDocument_SecondCandidate();
		Thread.sleep(3000);
		fec.clickOnOfferLetter_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(offerLetter);
		Thread.sleep(5000);
		fec.clickOnOfferLetter_UploadFile();
		Thread.sleep(3000);
		fec.clickOnAppointmentLetter_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(appointmentLetter);
		Thread.sleep(5000);
		fec.clickOnAppointmentLetter_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSalarySlip_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(salarySlip);
		Thread.sleep(5000);
		fec.clickOnSalarySlip_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSubmit_PlacementDocument();
		Thread.sleep(5000);
		fec.clickOnAction_ThirdCandidate();
		Thread.sleep(3000);
		fec.clickOnUploadCertificate_ThirdCandidate();
		Thread.sleep(3000);
		fec.clickOnCertificate();
		Thread.sleep(3000);
		fec.clickOnCertificate_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(certificateFile);
		Thread.sleep(5000);
		fec.clickOnCertificate_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSubmit_CandidateCertificate();
		Thread.sleep(3000);
		fec.clickOnAction_ThirdCandidate();
		Thread.sleep(3000);
		fec.clickOnUploadPlacementDocument_ThirdCandidate();
		Thread.sleep(3000);
		fec.clickOnOfferLetter_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(offerLetter);
		Thread.sleep(5000);
		fec.clickOnOfferLetter_UploadFile();
		Thread.sleep(3000);
		fec.clickOnAppointmentLetter_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(appointmentLetter);
		Thread.sleep(5000);
		fec.clickOnAppointmentLetter_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSalarySlip_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(salarySlip);
		Thread.sleep(5000);
		fec.clickOnSalarySlip_UploadFile();
		Thread.sleep(3000);
		fec.clickOnSubmit_PlacementDocument();
		/*Thread.sleep(12000);
		fec.clickOnBack();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+batchID+"']")).getText(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+batchName+"']")).getText(), batchName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+courseName+"']")).getText(), courseName);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//td[text()='"+expectedAssociatedQP+"']")).getText(), expectedAssociatedQP);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//span[text()='certification']")).getText(), "certification");*/
		
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}
