package com.nsdc.regressionTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.MobileHandlers;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.mobile.ui.object.LoginScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_CentreArea_UploadImagesScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_Clasroom_UploadImagesScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_DashboardScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_Facilities_UploadImagesScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_GeneralDetails_UploadImagesScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_Lab_UploadImagesScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_Residential_UploadImagesScreen;
import com.nsdc.mobile.ui.object.TC_CAAF_Trainers_UploadImagesScreen;
import com.nsdc.mobile.ui.object.UsersScreen;
import com.nsdc.pages.AddTrainingCentrePage;
import com.nsdc.pages.DA_DashboardPage;
import com.nsdc.pages.DA_TCRequestPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.HA_DashboardPage;
import com.nsdc.pages.HA_GovtTCRequestPage;
import com.nsdc.pages.IA_TC_AssessmentRequestPage;
import com.nsdc.pages.InspectionAgency_DashboardPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PMKKSPOC_AccrediationAndAffiliationPage;
import com.nsdc.pages.PMKKSPOC_AssignedInspectionRequestPage;
import com.nsdc.pages.PMKKSPOC_DashboardPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.QC_AllAssignedInspectionRequestPage;
import com.nsdc.pages.QC_DashboardPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SA_DashboardPage;
import com.nsdc.pages.SA_ViewJobRoleRecommendationRequestPage;
import com.nsdc.pages.SSC_AccrediationAndAffiliationPage;
import com.nsdc.pages.SSC_AccrediationAndAffiliation_CAAFRequestPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.TC_ApprovalPage;
import com.nsdc.pages.TC_CAAF_BillingInformationPage;
import com.nsdc.pages.TC_DashboardPage;
import com.nsdc.pages.TC_MySchemesPage;
import com.nsdc.pages.TrainingCentre_CAAF_Page;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.testConfig.CreateAppiumDriver;
import com.nsdc.testConfig.TestConfiguration;

public class TC_CAAF_WorkflowTestSC_15 extends TestConfiguration
{
	public  static String  tcID;
	
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
		Thread.sleep(15000);
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
		Thread.sleep(3000);
		atc.selectDistrict(district);
		atc.selectTehsil(tehsil);
		atc.selectCity(city);
		atc.selectParliamentryConstituency(parliamentryConstituency);
		atc.enterGeoLocation(geoLocation);
		Thread.sleep(3000);
		atc.selectAddressProof(addressProof);
		atc.clickOnAddressProof_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(addressProofFile);
		Thread.sleep(3000);
		atc.clickOnAddressProof_UploadFile();
		Thread.sleep(10000);
		atc.enterNameOfTheSPOC(SPOC_Name);
		Thread.sleep(3000);
		atc.enter_SPOC_EmailAddress(SPOC_EmailAddress);
		atc.enter_SPOC_MobileNumber(spoc_MobileNumber);
		Thread.sleep(3000);
		atc.enterCentreHeadName(centreHeadName);
		atc.enterCentreHeadEmailAddress(centreHeadEmail);
		atc.enterCentreHeadMobileNumber(centreHeadMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='trainingCenterType']")).getAttribute("value").substring(3), tcType);
		if(tcType.equals("Government") || tcType.equals("NON PMKK"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='processType']")).getAttribute("value"), "Accreditation & Affiliation");			
		}
		else if(tcType.equals("PMKK"))
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='processType']")).getAttribute("value"), "Accreditation & Affiliation");
			Thread.sleep(3000);
			atc.clickOnUploadMOU_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(mOU_File);
			Thread.sleep(3000);
			atc.clickOnUploadMOU_UploadFile();
			Thread.sleep(3000);
		}
		else if(tcType.equals("PMKK SPOKE"))
		{
			atc.enterPMKK_HUB_ID(pmkkHubID);
			atc.clickOnVerify();
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='processType']")).getAttribute("value"), "Accreditation & Affiliation");
			Thread.sleep(3000);
			atc.clickOnUploadMOU_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(mOU_File);
			Thread.sleep(3000);
			atc.clickOnUploadMOU_UploadFile();
		}
		/*if(tcType.equals("PMKK SPOKE"))
		{
			atc.enterPMKK_HUB_ID(pmkkHubID);
			atc.clickOnVerify();
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='processType']")).getAttribute("value"), "Accreditation & Affiliation");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='processType']")).getAttribute("value"), "Accreditation & Affiliation");
		}*/
		

		Thread.sleep(3000);
		atc.clickOnSubmit();
		Thread.sleep(3000);
		atc.clickOnYesAddTrainingCentre();
		Thread.sleep(3000);
		atc.clickOnClose();
		tcID = driver.findElement(By.xpath("(//td[@data-field='RecordID']/span)[1]")).getText();
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "AddTrainingCentreSC15TC01", sno, 25, tcID);
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TC_CAAF_SC15TC02", sno, 1, tcID);
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TC_CAAF_BillPaymentSC15TC03", sno, 1, tcID);
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC04", sno, 1, tcID);
		if(tcType.equals("Government") || tcType.equals("NON PMKK"))
		{
			//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[contains(text(),'"+tcID+"')]]]//span[text()='Registered']")).getText(), "Registered");
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
			Thread.sleep(15000);
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
	
	@DataProvider
	public Object[][] tc_CAAF_FormFilling()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TC_CAAF_SC15TC02");
	}
	
	@Test(dataProvider="tc_CAAF_FormFilling")
	public void cAAF_FormFillingTC_02(String sno, String tcUsername, String tcPassword, String newPassword, String confirmPassword, String nameOfTC, String tcType, String socialmedia, String websiteurl, String spocName, String spocEmail, String spocMobileNumber, String spocAltNumber, String centrePrincipalName, String centrePrincipalEmail, String centrePrincipalcontactNumber, String tcAddress, String tcLandmark, String tcPinCode, String tcState, String tcDistrict, String tcTehsil, String tcParliamentry, String tcAddressProof, String addressProofFile, String tcAreaClassificationCentre, String centreAtGroundFloor, String buildingStatus, String buildingConstruction, String transportSystem, String transportName, String buildingFace, String approachRoadWidth, String previousBuildingState, String buildingStateFile, String centreFloorType, String tcWallsType, String internetAvailablity, String firstAffiliationName, String firstAffiliationType, String firstAboutAffiliation, String secondAffiliationName, String secondAffiliationType, String secondAboutAffiliation, String thirdAffiliationName, String thirdAffiliationType, String thirdAboutAffiliation, String menResidentialArea, String totalAreaMenResidential, String roomsNumberMenResidential, String residentialCapacityMen, String maleWardenAvailablity, String remarkMenResidential, String womenResidentialArea, String totalAreaWomenResidential, String roomsNumberWomenResidential, String residentialCapacityWomen, String remarkWomenResidential, String safeDrinkingWater, String fireEquipmentAvailablity, String classRoomCarpetArea, String classroomRemark, String laboratoryOpenArea, String laboratoryCoveredArea,  String laboratoryCarpetArea, String laboratoryType, String laboratoryRemark, String hybridOpenArea, String hybridCoveredArea, String hybridCarpetArea, String hybridLaboratoryType, String hybridRemark, String firstSector, String firstJobRoleName, String secondSector, String secondJobRoleName, String thirdJobRoleName, String traineeToTrainerRatio, String parallelBatchesNumber, String jobRole, String additionalArea, String additionalCarpetArea, String coveredCarpetArea, String trainerID, String trainerAvailablity, String trainerResourceType, String first_Classroom, String first_Laboratory, String first_Hybrid, String second_Classroom, String second_Laboratory, String second_Hybrid, String firstQuantity, String firstRemark, String secondQuantity, String secondRemark, String thirdQuantity, String thirdRemark, String fourthQuantity, String fourthRemark, String fifthQuantity, String fifthRemark, String firstCentreCarpetArea, String firstCentrWashroomType, String firstCentreAreaRemark, String secondCentreCarpetArea, String secondCentrWashroomType, String secondCentreAreaRemark, String thirdCentreCarpetArea, String thirdCentreAreaRemark, String fourthCentreCarpetArea, String fourthCentreAreaRemark, String fifthCentreAreaType, String fifthCentreCarpetArea, String fifthCentrWashroomType, String fifthCentreAreaRemark, String firstSupportStaffName, String firstCentreStaffHighestQualification, String experience, String firstResourceType, String firstCentreStaffRemark, String secondSupportStaffName, String secondCentreStaffHighestQualification, String secondResourceType, String secondCentreStaffRemark, String thirdSupportStaffName, String thirdCentreStaffHighestQualification, String thirdResourceType, String thirdCentreStaffRemark, String fourthSupportStaffType, String fourthSupportStaffName, String fourthCentreStaffHighestQualification, String fourthResourceType, String fourthCentreStaffRemark) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tcUsername, tcPassword);
        RegistrationPage rp = new RegistrationPage(driver);
        Thread.sleep(2000);
        rp.enterOldPassword(tcPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        
        elp.performlogin(tcUsername, confirmPassword);
		Thread.sleep(3000);
		
		TrainingCentre_CAAF_Page caaf = new TrainingCentre_CAAF_Page(driver);
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), nameOfTC);
		Thread.sleep(3000);
		caaf.selectTypeOfTrainingCentre(tcType);
		Thread.sleep(3000);
		caaf.enterSocialmediaLinks(socialmedia);
		Thread.sleep(3000);
		caaf.enterWebsiteUrl(websiteurl);
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='SPOCfirstName']")).getAttribute("value"), spocName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='SPOCEmail']")).getAttribute("value"), spocEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='SPOCmobileNumber']")).getAttribute("value"), spocMobileNumber);
		Thread.sleep(3000);
		caaf.enterSpocAlternateNumber(spocAltNumber);
		Thread.sleep(3000);
		caaf.enterCentrePrincipal_Name(centrePrincipalName);
		Thread.sleep(3000);
		caaf.enterCentrePrincipal_EmailAddress(centrePrincipalEmail);
		Thread.sleep(3000);
		caaf.enterCentrePrincipal_ContactNumber(centrePrincipalcontactNumber);
		
		caaf.enterTC_Address(tcAddress);
		caaf.enterTC_NearByLandmark(tcLandmark);
		caaf.enterTC_PinCode(tcPinCode);
		caaf.selectTC_State(tcState);
		caaf.selectTC_District(tcDistrict);
		caaf.selectTC_Tehsil(tcTehsil);
		caaf.selectTC_ParliamentryConstituency(tcParliamentry);
		caaf.selectTC_AddressProofType(tcAddressProof);
		Thread.sleep(3000);
		caaf.clickOnTC_AddressProof_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(addressProofFile);
		Thread.sleep(3000);
		caaf.clickOnTC_AddresssProof_UploadFile();
		Thread.sleep(3000);
		caaf.selectTCAreaClassificationOfCentre(tcAreaClassificationCentre);
		caaf.selectIsEntireCentreAtGroundFloor(centreAtGroundFloor);
		Thread.sleep(10000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(5000);
		caaf.selectBuildingStatus(buildingStatus);
		caaf.selectTypeOfBuildingConstruction(buildingConstruction);
		caaf.selectProximityForPublicTransportSystem(transportSystem);
		caaf.enterNearestTransportName(transportName);
		caaf.selectBuildingFrontFace(buildingFace);
		caaf.enterApproachRoadWidth(approachRoadWidth);
		caaf.selectPreviousStateOfBuilding(previousBuildingState);
		Thread.sleep(3000);
		
//		caaf.clickOnBuildingPreviousState_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(buildingStateFile);
//		Thread.sleep(3000);
//		caaf.clickOnBuildingPreviousState_UploadFile();
		
		Thread.sleep(3000);
		caaf.clickOnAllFacilitiesCheckBoxes();
		Thread.sleep(3000);
		caaf.selectTypeOfCentreFloor(centreFloorType);
		caaf.selectTypeOfTrainingCentreWalls(tcWallsType);
		caaf.selectAvailablityOfInternet(internetAvailablity);
		Thread.sleep(3000);
		caaf.enterFirst_NameofAffiliation(firstAffiliationName);
		caaf.selectFirst_TypeOfAffiliation(firstAffiliationType);
		caaf.enterFirst_Affiliation_StartDate();
		caaf.enterFirst_Affiliation_EndDate();
		caaf.enterFirst_BriefAboutTheAffiliation(firstAboutAffiliation);
		Thread.sleep(3000);
		caaf.clickOnAddAnotherAffiliation();
//		Thread.sleep(3000);
//		caaf.enterFirst_NameofAffiliation(secondAffiliationName);
//		caaf.selectFirst_TypeOfAffiliation(secondAffiliationType);
//		caaf.enterFirst_Affiliation_StartDate();
//		caaf.enterFirst_Affiliation_EndDate();
//		caaf.enterFirst_BriefAboutTheAffiliation(secondAboutAffiliation);
//		Thread.sleep(3000);
//		caaf.clickOnAddAnotherAffiliation();
//		Thread.sleep(3000);
//		caaf.enterFirst_NameofAffiliation(thirdAffiliationName);
//		caaf.selectFirst_TypeOfAffiliation(thirdAffiliationType);
//		caaf.enterFirst_Affiliation_StartDate();
//		caaf.enterFirst_Affiliation_EndDate();
//		caaf.enterFirst_BriefAboutTheAffiliation(thirdAboutAffiliation);
//		Thread.sleep(3000);
//		caaf.clickOnAddAnotherAffiliation();
//		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("scroll(0, 900)");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+firstAffiliationName+"']")).getText(), firstAffiliationName);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+firstAffiliationType+"']")).getText(), firstAffiliationType);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+firstAboutAffiliation+"']")).getText(), firstAboutAffiliation);
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+secondAffiliationName+"']")).getText(), secondAffiliationName);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+secondAffiliationType+"']")).getText(), secondAffiliationType);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+secondAboutAffiliation+"']")).getText(), secondAboutAffiliation);
//
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdAffiliationName+"']")).getText(), thirdAffiliationName);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdAffiliationType+"']")).getText(), thirdAffiliationType);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdAboutAffiliation+"']")).getText(), thirdAboutAffiliation);
//		Thread.sleep(2000);
//		caaf.clickOnRemove_ThirdAffiliation();

		
		caaf.selectMen_ResidentialAreaAvailable(menResidentialArea);
		if(menResidentialArea.equals("Yes"))
		{
			Thread.sleep(3000);
			caaf.enterMen_TotalAreaOfResidential(totalAreaMenResidential);
			Thread.sleep(3000);
			caaf.enterMen_NumberOfRooms(roomsNumberMenResidential);
			caaf.enterMen_ResidentialCapacity(residentialCapacityMen);
			caaf.selectForMaleWardenAvailablity(maleWardenAvailablity);
			caaf.clickOnMenResidentialArea_EquippedWithAll();
			Thread.sleep(3000);
			caaf.enterRemark_MenResidential(remarkMenResidential);
			
			caaf.selectWomen_ResidentialAreaAvailable(womenResidentialArea);
		}
		else
		{
			caaf.selectWomen_ResidentialAreaAvailable(womenResidentialArea);
		}
		
		if(womenResidentialArea.equals("Yes"))
		{
			caaf.enterWomen_TotalAreaOfResidential(totalAreaWomenResidential);
			caaf.enterWomen_NumberOfRoomsForResidential(roomsNumberWomenResidential);
			caaf.enterWomen_ResidentialCapacity(residentialCapacityWomen);
			caaf.clickOnWomenResidentialArea_EquippedWithAll();
			Thread.sleep(3000);
			caaf.enterRemark_WomenResidential(remarkWomenResidential);
			Thread.sleep(3000);
			caaf.clickOnDiffrentlyAbled_AllFacilities();
		}
		else
		{
			caaf.clickOnDiffrentlyAbled_AllFacilities();
		}
		
		Thread.sleep(3000);
		caaf.selectForSafeDrinkingWater(safeDrinkingWater);
		Thread.sleep(3000);
		caaf.clickOnAllFacilities_MaintainingHygieneAndSanitation();
		Thread.sleep(3000);
		//caaf.selectforFireFightingEquipmentAvailablity(fireEquipmentAvailablity);
		Thread.sleep(3000);
		caaf.clickOnAllFacilities_ForMedicalAndSafety();
		Thread.sleep(10000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(8000);
		caaf.clickOnAddClassRoom();
		Thread.sleep(3000);
		caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
		caaf.clickOnClassRoomEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterClassRoomRemark(classroomRemark);
		Thread.sleep(3000);
		caaf.clickOn_Add_ForClassRoom();
//		Thread.sleep(3000);
//		caaf.clickOnAddClassRoom();
//		Thread.sleep(3000);
//		caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
//		caaf.clickOnClassRoomEquippedwith_ALL();
//		Thread.sleep(3000);
//			caaf.clickOnSecuredElectricWire_ClassRoom();
//			Thread.sleep(3000);
//		caaf.enterClassRoomRemark(classroomRemark);
//		Thread.sleep(3000);
//		caaf.clickOn_Add_ForClassRoom();
//		Thread.sleep(3000);
//		caaf.clickOnAddClassRoom();
//		Thread.sleep(3000);
//		caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
//		caaf.clickOnClassRoomEquippedwith_ALL();
//		Thread.sleep(3000);
//			caaf.clickOnSecuredElectricWire_ClassRoom();
//			Thread.sleep(3000);
//		caaf.enterClassRoomRemark(classroomRemark);
//		Thread.sleep(3000);
//		caaf.clickOn_Add_ForClassRoom();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='CLASS_1 ']")).getText(), "CLASS_1");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='CLASS_2 ']")).getText(), "CLASS_2");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='CLASS_3 ']")).getText(), "CLASS_3");
//		js.executeScript("scroll(0, 500)");
//		Thread.sleep(10000);
//		caaf.clickOnThird_Remove();
		
		
		Thread.sleep(3000);
		caaf.clickOnAddLaboratory();
		Thread.sleep(3000);
		//caaf.enterLaboratoryOpenArea(laboratoryOpenArea);
		//caaf.enterLaboratoryCoveredArea(laboratoryCoveredArea);
		caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
		caaf.selectLaboratoryType(laboratoryType);
		caaf.clickOnLaboratoryEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterLaboratoryRemark(laboratoryRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForLaboratory();
//		Thread.sleep(3000);
//		caaf.clickOnAddLaboratory();
//		Thread.sleep(3000);
//		caaf.enterLaboratoryOpenArea(laboratoryOpenArea);
//		caaf.enterLaboratoryCoveredArea(laboratoryCoveredArea);
//		caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
//		caaf.selectLaboratoryType(laboratoryType);
//		caaf.clickOnLaboratoryEquippedwith_ALL();
//		Thread.sleep(3000);
//			caaf.clickOnLabboratorySecuredElectricWire();
//			Thread.sleep(3000);
//		caaf.enterLaboratoryRemark(laboratoryRemark);
//		Thread.sleep(3000);
//		caaf.clickOnAdd_ForLaboratory();
//		Thread.sleep(3000);
//		caaf.clickOnAddLaboratory();
//		Thread.sleep(3000);
//		caaf.enterLaboratoryOpenArea(laboratoryOpenArea);
//		caaf.enterLaboratoryCoveredArea(laboratoryCoveredArea);
//		caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
//		caaf.selectLaboratoryType(laboratoryType);
//		caaf.clickOnLaboratoryEquippedwith_ALL();
//		Thread.sleep(3000);
//			caaf.clickOnLabboratorySecuredElectricWire();
//			Thread.sleep(3000);
//		caaf.enterLaboratoryRemark(laboratoryRemark);
//		Thread.sleep(3000);
//		caaf.clickOnAdd_ForLaboratory();
//		Thread.sleep(3000);
//		js.executeScript("scroll(0, 900)");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='LAB_1']")).getText(), "LAB_1");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='LAB_2']")).getText(), "LAB_2");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='LAB_3']")).getText(), "LAB_3");
//		Thread.sleep(10000);
//		caaf.clickOnFifth_Remove();
		
		
		Thread.sleep(3000);
		caaf.clickOnAddHybrid();
		Thread.sleep(3000);
		//caaf.enterHybridOpenArea(hybridOpenArea);
		//caaf.enterHybridCoveredArea(hybridCoveredArea);
		caaf.enterHybridCarpetArea(hybridCarpetArea);
		caaf.selectHybridLaboratoryType(hybridLaboratoryType);
		caaf.clickOnHybridEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterHybridRemark(hybridRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForHybrid();
//		Thread.sleep(3000);
//		caaf.clickOnAddHybrid();
//		Thread.sleep(3000);
//		caaf.enterHybridOpenArea(hybridOpenArea);
//		caaf.enterHybridCoveredArea(hybridCoveredArea);
//		caaf.enterHybridCarpetArea(hybridCarpetArea);
//		caaf.selectHybridLaboratoryType(hybridLaboratoryType);
//		caaf.clickOnHybridEquippedwith_ALL();
//			Thread.sleep(3000);
//			caaf.clickOnHybrid_SecuredElectricWire();
//		Thread.sleep(3000);
//		caaf.enterHybridRemark(hybridRemark);
//		Thread.sleep(3000);
//		caaf.clickOnAdd_ForHybrid();
//		Thread.sleep(3000);
//		caaf.clickOnAddHybrid();
//		Thread.sleep(3000);
//		caaf.enterHybridOpenArea(hybridOpenArea);
//		caaf.enterHybridCoveredArea(hybridCoveredArea);
//		caaf.enterHybridCarpetArea(hybridCarpetArea);
//		caaf.selectHybridLaboratoryType(hybridLaboratoryType);
//		caaf.clickOnHybridEquippedwith_ALL();
//			Thread.sleep(3000);
//			caaf.clickOnHybrid_SecuredElectricWire();
//		Thread.sleep(3000);
//		caaf.enterHybridRemark(hybridRemark);
//		Thread.sleep(3000);
//		caaf.clickOnAdd_ForHybrid();
//		Thread.sleep(2000);
//		js.executeScript("scroll(0, 900)");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='HYBRID_1']")).getText(), "HYBRID_1");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='HYBRID_2']")).getText(), "HYBRID_2");
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='HYBRID_3']")).getText(), "HYBRID_3");
//		Thread.sleep(10000);
//		caaf.clickOnSeventh_Remove();
		
		
		Thread.sleep(5000);
		caaf.clickOnAddJobRole();
		Thread.sleep(3000);
		caaf.selectSectorForJobRole(firstSector);
		caaf.selectForJobRoleName(firstJobRoleName);
		caaf.selectForTraineeToTrainerRatio(traineeToTrainerRatio);
		caaf.selectParallelBathcesNumber(parallelBatchesNumber);
		caaf.enterBriefAboutJobRole(jobRole);
		caaf.selectAdditionalAreaRequiredForJobRole(additionalArea);
		if(additionalArea.equals("Yes"))
		{
			caaf.enterAdditionalAreaCarpetArea(additionalCarpetArea);
			caaf.enterAdditionalCoveredCarpetArea(coveredCarpetArea);
			caaf.enterTrainerID(trainerID);
		}
		else
		{
			caaf.enterTrainerID(trainerID);
		}
		
		caaf.selectTrainerAvailablity(trainerAvailablity);
		caaf.selectTrainerResourceType(trainerResourceType);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForJobRole();
//		Thread.sleep(3000);
//		caaf.clickOnAddJobRole();
//		Thread.sleep(3000);
//		caaf.selectSectorForJobRole(secondSector);
//		caaf.selectForJobRoleName(secondJobRoleName);
//		caaf.selectForTraineeToTrainerRatio(traineeToTrainerRatio);
//		caaf.selectParallelBathcesNumber(parallelBatchesNumber);
//		caaf.enterBriefAboutJobRole(jobRole);
//		caaf.selectAdditionalAreaRequiredForJobRole(additionalArea);
//		if(additionalArea.equals("Yes"))
//		{
//			caaf.enterAdditionalAreaCarpetArea(additionalCarpetArea);
//			caaf.enterAdditionalCoveredCarpetArea(coveredCarpetArea);
//			caaf.enterTrainerID(trainerID);
//		}
//		else
//		{
//			caaf.enterTrainerID(trainerID);
//		}
//		
//		caaf.selectTrainerAvailablity(trainerAvailablity);
//		caaf.selectTrainerResourceType(trainerResourceType);
//		Thread.sleep(3000);
//		caaf.clickOnAdd_ForJobRole();
//		Thread.sleep(3000);
//		caaf.clickOnAddJobRole();
//		Thread.sleep(3000);
//		caaf.selectSectorForJobRole(firstSector);
//		caaf.selectForJobRoleName(thirdJobRoleName);
//		caaf.selectForTraineeToTrainerRatio(traineeToTrainerRatio);
//		caaf.selectParallelBathcesNumber(parallelBatchesNumber);
//		caaf.enterBriefAboutJobRole(jobRole);
//		caaf.selectAdditionalAreaRequiredForJobRole(additionalArea);
//		if(additionalArea.equals("Yes"))
//		{
//			caaf.enterAdditionalAreaCarpetArea(additionalCarpetArea);
//			caaf.enterAdditionalCoveredCarpetArea(coveredCarpetArea);
//			caaf.enterTrainerID(trainerID);
//		}
//		else
//		{
//			caaf.enterTrainerID(trainerID);
//		}
//		
//		caaf.selectTrainerAvailablity(trainerAvailablity);
//		caaf.selectTrainerResourceType(trainerResourceType);
//		Thread.sleep(3000);
//		caaf.clickOnAdd_ForJobRole();
//		Thread.sleep(3000);
//		//JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("scroll(0, 900)");
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+firstJobRoleName+"'])[1]")).getText(), firstJobRoleName);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+firstSector+"'])[1]")).getText(), firstSector);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+traineeToTrainerRatio+"'])[1]")).getText(), traineeToTrainerRatio);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+parallelBatchesNumber+"'])[1]")).getText(), parallelBatchesNumber);
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+secondJobRoleName+"')]")).getText(), secondJobRoleName);
//		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+secondSector+"')]")).getText(), secondSector);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+traineeToTrainerRatio+"'])[2]")).getText(), traineeToTrainerRatio);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+parallelBatchesNumber+"'])[2]")).getText(), parallelBatchesNumber);
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdJobRoleName+"']")).getText(), thirdJobRoleName);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+firstSector+"'])[2]")).getText(), firstSector);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+traineeToTrainerRatio+"'])[3]")).getText(), traineeToTrainerRatio);
//		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+parallelBatchesNumber+"'])[3]")).getText(), parallelBatchesNumber);
//		
//		Thread.sleep(10000);
//		caaf.clickOnNinth_Remove();
		
		Thread.sleep(3000);
		caaf.select_First_AssociatedClassroom(first_Classroom);
		caaf.select_First_AssociatedLaboratory(first_Laboratory);
		caaf.select_First_AssociatedHybrid(first_Hybrid);
//		Thread.sleep(3000);
//		caaf.select_Second_AssociatedClassroom(second_Classroom);
//		caaf.select_Second_AssociatedLaboratory(second_Laboratory);
//		caaf.select_Second_AssociatedHybrid(second_Hybrid);
		
		if((firstJobRoleName.equals("AGRICULTURE")) && secondJobRoleName.equals("APPAREL"))
		{
			caaf.enter_First_AvailableQuantityForEquipment(firstQuantity);
			caaf.enter_First_Remark_ForEquipment(firstRemark);
			caaf.enter_Second_AvailableQuantityForEquipment(secondQuantity);
			caaf.enter_Second_Remark_ForEquipment(secondRemark);
			caaf.enter_Third_AvailableQuantityForEquipment(thirdQuantity);
			caaf.enter_Third_Remark_ForEquipment(thirdRemark);
//			caaf.enter_Fourth_AvailableQuantityForEquipment(fourthQuantity);
//			caaf.enter_Fourth_Remark_ForEquipment(fourthRemark);
//			caaf.enter_Fifth_AvailableQuantityForEquipment(fifthQuantity);
//			caaf.enter_Fifth_Remark_ForEquipment(fifthRemark);
			Thread.sleep(5000);
			caaf.clickOnSaveAndNext();
		}
		else
		{
			Thread.sleep(5000);
			caaf.clickOnSaveAndNext();
		}
		
		
		Thread.sleep(8000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[1]")).getText(), "Reception");
		caaf.enter_FirstCentreArea_CarpetArea(firstCentreCarpetArea);
		//caaf.select_FirstCentreArea_TypeOfWashRoom(firstCentrWashroomType);
		Thread.sleep(3000);
		caaf.clickOnFirstCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_FirstCentreArea_Remark(firstCentreAreaRemark);
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[2]")).getText(), "Placement & Entrepreneurship Cell");
		caaf.enter_SecondCentreArea_CarpetArea(secondCentreCarpetArea);
		//caaf.select_SecondCentreArea_TypeOfWashRoom(secondCentrWashroomType);
		Thread.sleep(3000);
		caaf.clickOnSecondCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_SecondCentreArea_Remark(secondCentreAreaRemark);
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[3]")).getText(), "Male Washroom");
		caaf.enter_ThirdCentreArea_CarpetArea(thirdCentreCarpetArea);
		Thread.sleep(3000);
		caaf.clickOnThirdCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_ThirdCentreArea_Remark(thirdCentreAreaRemark);
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[4]")).getText(), "Female Washroom");
		caaf.enter_FourthCentreArea_CarpetArea(fourthCentreCarpetArea);
		Thread.sleep(3000);
		caaf.clickOnFourthCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_FourthCentreArea_Remark(fourthCentreAreaRemark);
		
		Thread.sleep(3000);
		caaf.selectFifth_TypeOfCentreArea(fifthCentreAreaType);
		caaf.enter_FifthCentreArea_CarpetArea(fifthCentreCarpetArea);
		//caaf.select_FifthCentreArea_TypeOfWashRoom(fifthCentrWashroomType);
		Thread.sleep(3000);
		caaf.clickOnFifthCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_FifthCentreArea_Remark(fifthCentreAreaRemark);
		Thread.sleep(3000);
		caaf.clickForAddAnotherCentreType();
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[1]")).getAttribute("value"), "Placement Coordinator");
		caaf.enterFirst_NameOfSupportStaff(firstSupportStaffName);
		caaf.selectFirst_HighestQualificationForCentreStaff(firstCentreStaffHighestQualification);
		caaf.enterExpeience(experience);
		caaf.selectFirst_ResourceTypeOfCentreStaff(firstResourceType);
		caaf.enterFirst_RemarkForCentreStaff(firstCentreStaffRemark);
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[2]")).getAttribute("value"), "");
		caaf.selectSecond_TypeOfSupportStaff(fourthSupportStaffType);
		caaf.enterSecond_NameOfSupportStaff(secondSupportStaffName);
		caaf.selectSecond_HighestQualificationForCentreStaff(secondCentreStaffHighestQualification);
		caaf.enterExpeience(experience);
		caaf.selectSecond_ResourceTypeOfCentreStaff(secondResourceType);
		caaf.enterSecond_RemarkForCentreStaff(secondCentreStaffRemark);
		
//		Thread.sleep(3000);
//		caaf.enterThird_NameOfSupportStaff(thirdSupportStaffName);
//		caaf.selectThird_HighestQualificationForCentreStaff(thirdCentreStaffHighestQualification);
//		caaf.selectThird_ResourceTypeOfCentreStaff(thirdResourceType);
//		caaf.enterThird_RemarkForCentreStaff(thirdCentreStaffRemark);
//		
//		Thread.sleep(3000);
//		caaf.selectFourth_TypeOfSupportStaff(fourthSupportStaffType);
//		caaf.enterFourth_NameOfSupportStaff(fourthSupportStaffName);
//		caaf.selectFourth_HighestQualificationForCentreStaff(fourthCentreStaffHighestQualification);
//		caaf.selectFourth_ResourceTypeOfCentreStaff(fourthResourceType);
//		caaf.enterFourth_RemarkForCentreStaff(fourthCentreStaffRemark);
		
		caaf.clickForAddAnotherCentreStaff();
		
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickOn_OK_ForMobileApp();

		
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		caaf.clickOnLogout_Profile();
				
	}
	
	
	@DataProvider
	public Object[][] tc_CAAF_BillPayment()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TC_CAAF_BillPaymentSC15TC03");
	}
	
	@Test(dataProvider="tc_CAAF_BillPayment",enabled=false)
	public void tc_CAAF_MobileUploadTC_03(String sno, String tcUsername, String tcPassword, String city, String Country, String paymentMethod, String creditCardNumber, String month_CreditCard, String year_CreditCard, String cvv_CreditCard, String debitCardNumber, String month_DebitCard, String year_DebitCard, String cvv_DebitCard, String bankName) throws Exception
	{
        appDriver = CreateAppiumDriver.getDriverInstance();
		
		int srno = Integer.parseInt(sno);
		
		//String emailID = "TC_003787";//ReadWriteData.getData("./TestData/Workflow/TC_CAAF-Workflow.xls", "AddTrainingCentreSC15TC01", srno, 1);
		//String password = ReadWriteData.getData("./TestData/Workflow/TC_CAAF-Workflow.xls", "AddTrainingCentreSC15TC01", srno, 2);
		
		UsersScreen us = new UsersScreen(appDriver);
		//us.getTrainingCentreButton().click();
		
		LoginScreen ls = new LoginScreen(appDriver);
		ls.getEmailTextbox().sendKeys(tcUsername);
		ls.getPasswordTextbox().sendKeys(tcPassword);
		ls.getLoginButton().click();
		
		TC_CAAF_DashboardScreen sd = new TC_CAAF_DashboardScreen(appDriver);
		sd.getGeneralDeatilsButton().click();
		sd.getEnableGPSButton().click();
		
		TC_CAAF_GeneralDetails_UploadImagesScreen gd_uis = new TC_CAAF_GeneralDetails_UploadImagesScreen(appDriver);
		List <WebElement> elements = gd_uis.getUpLoadFileButtons();
		for(int i=0; i<elements.size(); i++)
		{
			WebElement e1 = elements.get(i);
			if(i==0)
			{
				e1.click();
				gd_uis.getDeviceStorageAccessButton().click();
				MobileHandlers.clickPicture(appDriver);
			}
			else if(i==9)
			{
				MobileHandlers.scrollScreen(appDriver);
				MobileHandlers.scrollScreen(appDriver);
				e1.click();
				MobileHandlers.clickPicture(appDriver);
			}
			else
			{
				e1.click();
				MobileHandlers.clickPicture(appDriver);
			}
					
		}		
		gd_uis.getSubmitButton().click();
		gd_uis.getOkButton().click();
		
		sd.getTrainersButton().click();
		
		TC_CAAF_Trainers_UploadImagesScreen trainer_uis = new TC_CAAF_Trainers_UploadImagesScreen(appDriver);
		List <WebElement> trainerButtons = trainer_uis.getTrainerButtons();
		
		for(int i=1; i<trainerButtons.size(); i++)
		{
			WebElement e1 = trainerButtons.get(i);
			e1.click();
			
			trainer_uis.getProfilePicButton().click();
			MobileHandlers.clickPicture(appDriver);	
			
			List <WebElement> uploadButtons = trainer_uis.getUploadFileButtons();
			for(int j=0; j<uploadButtons.size(); j++)
			{
				WebElement e2 = uploadButtons.get(j);
				e2.click();
				if(j==2)
				{
					MobileHandlers.scrollScreen(appDriver);
					MobileHandlers.scrollScreen(appDriver);
					MobileHandlers.scrollScreen(appDriver);
					trainer_uis.getHighestQualificationButton().click();
					MobileHandlers.clickPicture(appDriver);	
					e2.click();
				}
				MobileHandlers.clickPicture(appDriver);	
			}
			
			trainer_uis.getSubmitButton().click();
			trainer_uis.getOkButton().click();
			
			if(i<trainerButtons.size()-1)
			{
				sd.getTrainersButton().click();
			}
		}
		
		sd.getClassroomButton().click();
		
		TC_CAAF_Clasroom_UploadImagesScreen classroom_uis = new TC_CAAF_Clasroom_UploadImagesScreen(appDriver);
		List <WebElement> classroomButtons = classroom_uis.getClassroomButtons();
		
		for(int i=1; i<classroomButtons.size(); i++)
		{
			WebElement e1 = classroomButtons.get(i);
			e1.click();
			MobileHandlers.scrollScreen(appDriver);
			
			List <WebElement> uploadButtons = classroom_uis.getUploadFileButtons();
			for(int j=0; j<uploadButtons.size(); j++)
			{
				WebElement e2 = uploadButtons.get(j);
				e2.click();
				MobileHandlers.clickPicture(appDriver);	
			}
			
			List <WebElement> uploadVideoButtons = classroom_uis.getUploadVideoButtons();
			for(int k=0; k<uploadVideoButtons.size(); k++)
			{
				WebElement e3 = uploadVideoButtons.get(k);
				e3.click();
				MobileHandlers.recordVideo(appDriver);
				MobileHandlers.scrollScreen(appDriver);
			}
			
			classroom_uis.getSubmitButton().click();
			classroom_uis.getOkButton().click();
			
			if(i<classroomButtons.size()-1)
			{
				sd.getClassroomButton().click();
			}
		}
		
		sd.getLaboratoryDetailsButton().click();
		
		TC_CAAF_Lab_UploadImagesScreen lab_uis = new TC_CAAF_Lab_UploadImagesScreen(appDriver);
		List <WebElement> labButtons = lab_uis.getLabButtons();
		
		for(int i=1; i<labButtons.size(); i++)
		{
			WebElement e1 = labButtons.get(i);
			e1.click();
			MobileHandlers.scrollScreen(appDriver);
			
			List <WebElement> uploadButtons = lab_uis.getUploadFileButtons();
			for(int j=0; j<uploadButtons.size(); j++)
			{
				WebElement e2 = uploadButtons.get(j);
				e2.click();
				MobileHandlers.clickPicture(appDriver);	
			}
			
			List <WebElement> uploadVideoButtons = lab_uis.getUploadVideoButtons();
			for(int k=0; k<uploadVideoButtons.size(); k++)
			{
				WebElement e3 = uploadVideoButtons.get(k);
				e3.click();
				MobileHandlers.recordVideo(appDriver);
				MobileHandlers.scrollScreen(appDriver);
			}
			
			lab_uis.getSubmitButton().click();
			lab_uis.getOkButton().click();
			
			if(i<labButtons.size()-1)
			{
				sd.getLaboratoryDetailsButton().click();
			}
		}
		
		sd.getCentreAreaButton().click();
		
		TC_CAAF_CentreArea_UploadImagesScreen centreArea_uis = new TC_CAAF_CentreArea_UploadImagesScreen(appDriver);
		List <WebElement> facilitiesButtons = centreArea_uis.getFacilitiesButtons();
		
		for(int i=1; i<facilitiesButtons.size(); i++)
		{
			WebElement e1 = facilitiesButtons.get(i);
			e1.click();
			MobileHandlers.scrollScreen(appDriver);
			
			List <WebElement> uploadButtons = centreArea_uis.getUploadFileButtons();
			for(int j=0; j<uploadButtons.size(); j++)
			{
				WebElement e2 = uploadButtons.get(j);
				e2.click();
				MobileHandlers.clickPicture(appDriver);	
			}
			
			List <WebElement> uploadVideoButtons = centreArea_uis.getUploadVideoButtons();
			for(int k=0; k<uploadVideoButtons.size(); k++)
			{
				WebElement e3 = uploadVideoButtons.get(k);
				e3.click();
				MobileHandlers.recordVideo(appDriver);
				MobileHandlers.scrollScreen(appDriver);
			}
			
			centreArea_uis.getSubmitButton().click();
			centreArea_uis.getOkButton().click();
			
			if(i<facilitiesButtons.size()-1)
			{
				sd.getCentreAreaButton().click();
			}
		}
		
		sd.getResidentialFacilitiesButton().click();
		
		TC_CAAF_Residential_UploadImagesScreen residential_uis = new TC_CAAF_Residential_UploadImagesScreen(appDriver);
		residential_uis.getOkButton().click();
		residential_uis.getAddButton().click();
		residential_uis.getFacilityDecriptionTextbox().sendKeys("Facility description");
		
		List <WebElement> uploadButtons1 = residential_uis.getUploadFileButtons();
		for(int i=0; i<uploadButtons1.size(); i++)
		{
			WebElement e1 = uploadButtons1.get(i);
			e1.click();
			MobileHandlers.clickPicture(appDriver);
		}
		
		MobileHandlers.scrollScreen(appDriver);
		MobileHandlers.scrollScreen(appDriver);
		
		List <WebElement> uploadVideoButtons1 = residential_uis.getUploadVideoButtons();
		for(int j=0; j<uploadVideoButtons1.size(); j++)
		{
			WebElement e2 = uploadVideoButtons1.get(j);
			e2.click();
			MobileHandlers.recordVideo(appDriver);
			MobileHandlers.scrollScreen(appDriver);
		}
		
		residential_uis.getSubmitButton().click();
		residential_uis.getOkButton().click();
		
		sd.getFacilitiesButton().click();
		
		TC_CAAF_Facilities_UploadImagesScreen facilities_uis = new TC_CAAF_Facilities_UploadImagesScreen(appDriver);
		
		List <WebElement> uploadButtons2 = facilities_uis.getUploadFileButtons();
		for(int i=0; i<uploadButtons2.size(); i++)
		{
			if(i==3)
			{
				MobileHandlers.scrollScreen(appDriver);
				MobileHandlers.scrollScreen(appDriver);
				MobileHandlers.scrollScreen(appDriver);
			}
			WebElement e1 = uploadButtons2.get(i);
			e1.click();
			MobileHandlers.clickPicture(appDriver);	
		}
		
		facilities_uis.getSubmitButton().click();
		facilities_uis.getOkButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tcUsername, tcPassword);
		TrainingCentre_CAAF_Page caaf = new TrainingCentre_CAAF_Page(driver);
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickOnSaveAndContinueToPayment();
		TC_CAAF_BillingInformationPage tcbi = new TC_CAAF_BillingInformationPage(driver);
		tcbi.enterCity(city);
		tcbi.selectCountry(Country);
		Thread.sleep(3000);
		if(paymentMethod.equals("Credit Card"))
		{
			tcbi.clickOnCreditCard();
			Thread.sleep(3000);
			tcbi.enterCreditCardNumber(creditCardNumber);
			tcbi.selectMonth_ForCreditCard(month_CreditCard);
			tcbi.selectYear_ForCreditCard(year_CreditCard);
			tcbi.enterCVVForCreditCard(cvv_CreditCard);
			Thread.sleep(3000);
			tcbi.clickOnMakePaymentForCreditCard();
		}
		else if(paymentMethod.equals("Debit Card"))
		{
			tcbi.clickOnDebitCard();
			Thread.sleep(3000);
			tcbi.enterDebitCardNumber(debitCardNumber);
			tcbi.selectMonth_ForDebitCard(month_DebitCard);
			tcbi.selectYear_ForDebitCard(year_DebitCard);
			tcbi.enterCVVForDebitCard(cvv_DebitCard);
			Thread.sleep(3000);
			tcbi.clickOnMakePaymentForDebitCard();
		}
		else if(paymentMethod.equals("Net Banking"))
		{
			tcbi.clickOnNetBanking();
			Thread.sleep(3000);
			tcbi.selectBankName(bankName);
			Thread.sleep(3000);
			tcbi.clickOnMakePaymentForNetBanking();
		}
		Thread.sleep(3000);
		tcbi.clickOnReturnToTheMerchantSite();
		Thread.sleep(3000);
		caaf.clickOnContinue();
		Thread.sleep(3000);
		caaf.clickOnOK();
		Thread.sleep(3000);
		caaf.clickOnLogOut();
		
		
	}
	
	
	
	
	
	@DataProvider
	public Object[][] tcApproval()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC04");
	}
	
	@Test(dataProvider="tcApproval", enabled=false)
	public void approveTrainingCentreTC_04(String sno, String tc_ID, String password, String tc_Name, String tc_Type, String ha_Username, String recommendationLetter, String ia_Username, String stage, String assignTo, String daUsername, String tcName_ReviewComments, String tcType_ReviewComments, String centreDirector_ReviewComments, String address_ReviewComments, String area_ReviewComments, String centreAtGroundFloor_ReviewComments, String buildingStatus_ReviewComments, String buildingType_ReviewComments, String transport_ReviewComments, String nearestTransport_ReviewComments, String buildingFrontFace_ReviewComments, String approachRoad_ReviewComments, String buildingPreviousState_ReviewComments, String menResidential_ReviewComments, String womenResidential_ReviewComments, String diffrentlyAbledFacilities_ReviewComments, String hygiene_ReviewComments, String medical_ReviewComments, String floorArea_JobRole_ReviewComments, String coveredArea_JobRole_ReviewComments, String classroomArea_ReviewComments, String classroomFacilities_ReviewComments, String labOpenArea_ReviewComments, String labCoverdArea_ReviewComments, String labArea_ReviewComments, String labType_ReviewComments, String labFacilities_ReviewComments, String equipmentDetails_ReviewComments, String trainer_ReviewComments, String firstCentreArea_ReviewComments, String secondCentreArea_ReviewComments, String thirdCentreArea_ReviewComments, String fourthCentreArea_ReviewComments, String fifthCentreArea_ReviewComments, String firstCentreStaff_ReviewComments, String secondCentreStaff_ReviewComments, String finalStatus, String finalReviewComments, String finalStatusFile, String pmkkSPOKEUsername, String sector, String jobRoleName, String scheme, String schemeFile, String sa_Username,  String city, String Country, String paymentMethod, String creditCardNumber, String month_CreditCard, String year_CreditCard, String cvv_CreditCard, String debitCardNumber, String month_DebitCard, String year_DebitCard, String cvv_DebitCard, String bankName,String ci_Username, String inspectionDate, String qc_Username, String ssc_Username) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		if(tc_Type.equals("Government"))
		{
			elp.performlogin(ha_Username, password);
			HA_DashboardPage had = new HA_DashboardPage(driver);
			Thread.sleep(8000);
			had.clickOnGovtTCRequest();
			Thread.sleep(3000);
			HA_GovtTCRequestPage htc = new HA_GovtTCRequestPage(driver);
			Thread.sleep(3000);
			htc.enterForSearchByKeyword(tc_ID);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			/*driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'View Submitted CAAF')]")).click();
			//Assert.assertEquals(driver.findElement(By.xpath("")), "");
			//htc.clickOnBack();
			//htc.enterForSearchByKeyword(tc_ID);*/
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Approve/Reject')]")).click();
			Thread.sleep(3000);
			htc.clickOnApprovedRadioButton();
			Thread.sleep(3000);
			htc.clickOnUploadRecommendationLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(recommendationLetter);
			Thread.sleep(3000);
			htc.clickOnUploadRecommendationLetter_UploadButton();
			Thread.sleep(5000);
			htc.clickOnSubmit();
			Thread.sleep(3000);
			htc.clickOnOK();
			Thread.sleep(3000);
			htc.enterForSearchByKeyword(tc_ID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='Appproved']")).getText(), "Appproved");
			
			Thread.sleep(3000);
			PostLoginPage plp = new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
		}
		else if(tc_Type.equals("NON PMKK"))
		{
			elp.performlogin(ia_Username, password);
			InspectionAgency_DashboardPage iad = new InspectionAgency_DashboardPage(driver);
			Thread.sleep(8000);
			iad.clickOnViewAllAssessmentRequest();
			IA_TC_AssessmentRequestPage iatc = new IA_TC_AssessmentRequestPage(driver);
			Thread.sleep(3000);
			iatc.clickOnViewAllTCRequest();
			Thread.sleep(3000);
			iatc.enterForSearch(tc_ID);
			iatc.selectStage(stage);
			//iatc.enterDateForAssign();
			iatc.clickOnApply();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			if(assignTo.equals("Assign To DA"))
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Assign To DA')]")).click();
				Thread.sleep(3000);
				iatc.selectAssignTo_DA(daUsername);
				Thread.sleep(3000);
				iatc.clickOnAssign();
				//iatc.enterForSearch(tc_ID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='In-Process DA']")).getText(), "In-Process DA");
				PostLoginPage plp = new PostLoginPage(driver);
				Thread.sleep(3000);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
				
				lp.clickLogin();
				elp.performlogin(daUsername, password);
				DA_DashboardPage dap = new DA_DashboardPage(driver);
				Thread.sleep(10000);
				dap.clickOnViewAllAssessmentRequest();
				DA_TCRequestPage datc = new DA_TCRequestPage(driver);
				Thread.sleep(5000);
				datc.clickOnViewAllTCRequest();
				Thread.sleep(3000);
				datc.enterForSearch(tc_ID);
				//datc.selectstage(stage);
				datc.clickOnApply();
				Thread.sleep(3000);
				datc.clickOnAction();
				datc.clickOnViewQuickDetails();
				Thread.sleep(3000);
				datc.clickOnReview();
				
				TC_ApprovalPage datr = new TC_ApprovalPage(driver);
				Thread.sleep(3000);
				datr.clickOn_First_PreviewAttachedProofDocument();
				Thread.sleep(3000);
				datr.select_First_ReviewComments(address_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				
				Thread.sleep(3000);
				datr.select_Second_ReviewComments(approachRoad_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FrontView_Image();
				datr.clickOn_LeftView_Image();
				datr.clickOn_RightView_Image();
				datr.clickOn_InternetConectivity_Image();
				datr.clickOn_PowerBackup_Image();
				Thread.sleep(3000);
				datr.select_Third_ReviewComments(menResidential_ReviewComments);
				datr.select_Fourth_ReviewComments(womenResidential_ReviewComments);
				datr.select_Fifth_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_DifferentyAbledWashroom_Image();
				datr.clickOn_Ramp_Image();
				datr.clickOn_Lift_Image();
				Thread.sleep(3000);
				datr.select_Sixth_ReviewComments(hygiene_ReviewComments);
				datr.select_Seventh_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(firstCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Ninth_ReviewComments(secondCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Tenth_ReviewComments(thirdCentreArea_ReviewComments);
				datr.clickOn_FirstView_ThirdImage();
				datr.clickOn_SecondView_ThirdImage();
				Thread.sleep(3000);
				datr.select_Eleventh_ReviewComments(fourthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FourthImage();
				datr.clickOn_SecondView_FourthImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FifthImage();
				datr.clickOn_SecondView_FifthImage();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				
				//js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_Thirteen_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_Fourteen_ReviewComments(secondCentreStaff_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fifth();
				
				Thread.sleep(3000);
				datr.selectFinalReviewStatus(finalStatus);
				datr.enterFinalStatusReviewComments(finalReviewComments);
				Thread.sleep(3000);
				datr.clickOnBrowseFile_ForFinalStatus();
				Thread.sleep(3000);
				UploadFile.upload(finalStatusFile);
				Thread.sleep(3000);
				datr.clickOnUploadFile_ForFinalStatus();
				Thread.sleep(3000);
				datr.clickOnSaveAndContinue();
				Thread.sleep(3000);
				datr.clickOnOK();
				
				Thread.sleep(3000);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
			}
			else
			{
				driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Take Action')]")).click();
				
				TC_ApprovalPage datr = new TC_ApprovalPage(driver);
				Thread.sleep(3000);
				datr.clickOn_First_PreviewAttachedProofDocument();
				Thread.sleep(3000);
				datr.select_First_ReviewComments(address_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				
				Thread.sleep(3000);
				datr.select_Second_ReviewComments(approachRoad_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FrontView_Image();
				datr.clickOn_LeftView_Image();
				datr.clickOn_RightView_Image();
				datr.clickOn_InternetConectivity_Image();
				datr.clickOn_PowerBackup_Image();
				Thread.sleep(3000);
				datr.select_Third_ReviewComments(menResidential_ReviewComments);
				datr.select_Fourth_ReviewComments(womenResidential_ReviewComments);
				datr.select_Fifth_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_DifferentyAbledWashroom_Image();
				datr.clickOn_Ramp_Image();
				datr.clickOn_Lift_Image();
				Thread.sleep(3000);
				datr.select_Sixth_ReviewComments(hygiene_ReviewComments);
				datr.select_Seventh_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(firstCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Ninth_ReviewComments(secondCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Tenth_ReviewComments(thirdCentreArea_ReviewComments);
				datr.clickOn_FirstView_ThirdImage();
				datr.clickOn_SecondView_ThirdImage();
				Thread.sleep(3000);
				datr.select_Eleventh_ReviewComments(fourthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FourthImage();
				datr.clickOn_SecondView_FourthImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FifthImage();
				datr.clickOn_SecondView_FifthImage();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				
				//js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_Thirteen_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_Fourteen_ReviewComments(secondCentreStaff_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fifth();
				
				Thread.sleep(3000);
				datr.selectFinalReviewStatus(finalStatus);
				datr.enterFinalStatusReviewComments(finalReviewComments);
				Thread.sleep(3000);
				datr.clickOnBrowseFile_ForFinalStatus();
				Thread.sleep(3000);
				UploadFile.upload(finalStatusFile);
				Thread.sleep(3000);
				datr.clickOnUploadFile_ForFinalStatus();
				Thread.sleep(3000);
				datr.clickOnSaveAndContinue();
				Thread.sleep(3000);
				datr.clickOnOK();
				PostLoginPage plp = new PostLoginPage(driver);
				Thread.sleep(3000);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
			}
			
			
		}
		
		else if(tc_Type.equals("PMKK") || tc_Type.equals("PMKK SPOKE"))
		{
			elp.performlogin(pmkkSPOKEUsername, password);
			PMKKSPOC_DashboardPage pmkk = new PMKKSPOC_DashboardPage(driver);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0, 900)");
			Thread.sleep(8000);
			pmkk.clickOnViewAllAssessmentRequest();
			PMKKSPOC_AssignedInspectionRequestPage pmir = new PMKKSPOC_AssignedInspectionRequestPage(driver);
			Thread.sleep(3000);
			pmir.enterForSearch(tc_ID);
			pmir.selectStage(stage);
			//iatc.enterDateForAssign();
			pmir.clickOnApply();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			if(assignTo.equals("Assign To DA"))
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Assign To DA')]")).click();
				Thread.sleep(3000);
				pmir.selectAssignTo_DA(daUsername);
				Thread.sleep(3000);
				pmir.clickOnAssign();
				pmir.enterForSearch(tc_ID);
				//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='In-Process DA']")).getText(), "In-Process DA");
				PostLoginPage plp = new PostLoginPage(driver);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
				
				lp.clickLogin();
				elp.performlogin(daUsername, password);
				DA_DashboardPage dap = new DA_DashboardPage(driver);
				Thread.sleep(10000);
				dap.clickOnViewAllAssessmentRequest();
				DA_TCRequestPage datc = new DA_TCRequestPage(driver);
				Thread.sleep(5000);
				datc.clickOnViewAllTCRequest();
				Thread.sleep(3000);
				datc.enterForSearch(tc_ID);
				//datc.selectstage(stage);
				Thread.sleep(3000);
				datc.clickOnApply();
				Thread.sleep(3000);
				datc.clickOnAction();
				datc.clickOnTakeAction();
//				datc.clickOnViewQuickDetails();
//				Thread.sleep(3000);
//				datc.clickOnReview();
				
				
				TC_ApprovalPage datr = new TC_ApprovalPage(driver);
				Thread.sleep(3000);
				datr.clickOn_First_PreviewAttachedProofDocument();
				Thread.sleep(3000);
				datr.select_First_ReviewComments(address_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				
				Thread.sleep(3000);
				datr.select_Second_ReviewComments(approachRoad_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FrontView_Image();
				datr.clickOn_LeftView_Image();
				datr.clickOn_RightView_Image();
				datr.clickOn_InternetConectivity_Image();
				datr.clickOn_PowerBackup_Image();
				Thread.sleep(3000);
				datr.select_Third_ReviewComments(menResidential_ReviewComments);
				datr.select_Fourth_ReviewComments(womenResidential_ReviewComments);
				datr.select_Fifth_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_DifferentyAbledWashroom_Image();
				datr.clickOn_Ramp_Image();
				datr.clickOn_Lift_Image();
				Thread.sleep(3000);
				datr.select_Sixth_ReviewComments(hygiene_ReviewComments);
				datr.select_Seventh_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(firstCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Ninth_ReviewComments(secondCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Tenth_ReviewComments(thirdCentreArea_ReviewComments);
				datr.clickOn_FirstView_ThirdImage();
				datr.clickOn_SecondView_ThirdImage();
				Thread.sleep(3000);
				datr.select_Eleventh_ReviewComments(fourthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FourthImage();
				datr.clickOn_SecondView_FourthImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FifthImage();
				datr.clickOn_SecondView_FifthImage();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				
				//js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_Thirteen_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_Fourteen_ReviewComments(secondCentreStaff_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fifth();
				
				Thread.sleep(3000);
				datr.selectFinalReviewStatus(finalStatus);
				datr.enterFinalStatusReviewComments(finalReviewComments);
				Thread.sleep(3000);
				datr.clickOnBrowseFile_ForFinalStatus();
				Thread.sleep(3000);
				UploadFile.upload(finalStatusFile);
				Thread.sleep(3000);
				datr.clickOnUploadFile_ForFinalStatus();
				Thread.sleep(3000);
				datr.clickOnSaveAndContinue();
				Thread.sleep(3000);
				datr.clickOnOK();

				Thread.sleep(3000);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
				
			}
			else
			{
				driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Take Action')]")).click();
				TC_ApprovalPage datr = new TC_ApprovalPage(driver);
				Thread.sleep(3000);
				datr.clickOn_First_PreviewAttachedProofDocument();
				Thread.sleep(3000);
				datr.select_First_ReviewComments(address_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				
				Thread.sleep(3000);
				datr.select_Second_ReviewComments(approachRoad_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FrontView_Image();
				datr.clickOn_LeftView_Image();
				datr.clickOn_RightView_Image();
				datr.clickOn_InternetConectivity_Image();
				datr.clickOn_PowerBackup_Image();
				Thread.sleep(3000);
				datr.select_Third_ReviewComments(menResidential_ReviewComments);
				datr.select_Fourth_ReviewComments(womenResidential_ReviewComments);
				datr.select_Fifth_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_DifferentyAbledWashroom_Image();
				datr.clickOn_Ramp_Image();
				datr.clickOn_Lift_Image();
				Thread.sleep(3000);
				datr.select_Sixth_ReviewComments(hygiene_ReviewComments);
				datr.select_Seventh_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
				datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
				datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
				datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
				datr.select_Thirteen_ReviewComments(labType_ReviewComments);
				datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
				//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
				datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_SSCCertificate_Image();
				datr.clickOn_HighestQualification_Image();
				datr.clickOn_NIESBUD_Image();
				datr.clickOn_IndustrialExperience_Image();
				Thread.sleep(10000);
				datr.clickOnNext_ForJobRole();
				
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				
				Thread.sleep(3000);
				datr.select_Eighth_ReviewComments(firstCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FirstImage();
				datr.clickOn_SecondView_FirstImage();
				Thread.sleep(3000);
				datr.select_Ninth_ReviewComments(secondCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_SecondImage();
				datr.clickOn_SecondView_SecondImage();
				Thread.sleep(3000);
				datr.select_Tenth_ReviewComments(thirdCentreArea_ReviewComments);
				datr.clickOn_FirstView_ThirdImage();
				datr.clickOn_SecondView_ThirdImage();
				Thread.sleep(3000);
				datr.select_Eleventh_ReviewComments(fourthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FourthImage();
				datr.clickOn_SecondView_FourthImage();
				Thread.sleep(3000);
				datr.select_Twelth_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOn_FirstView_FifthImage();
				datr.clickOn_SecondView_FifthImage();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				
				//js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_Thirteen_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_Fourteen_ReviewComments(secondCentreStaff_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fifth();
				
				Thread.sleep(3000);
				datr.selectFinalReviewStatus(finalStatus);
				datr.enterFinalStatusReviewComments(finalReviewComments);
				Thread.sleep(3000);
				datr.clickOnBrowseFile_ForFinalStatus();
				Thread.sleep(3000);
				UploadFile.upload(finalStatusFile);
				Thread.sleep(3000);
				datr.clickOnUploadFile_ForFinalStatus();
				Thread.sleep(3000);
				datr.clickOnSaveAndContinue();
				Thread.sleep(3000);
				datr.clickOnOK();
				PostLoginPage plp = new PostLoginPage(driver);
				Thread.sleep(3000);
				plp.clickOnProfileLogo();
				plp.clickOnLogout();
			}
			
		
			
		}
		
		
		lp.clickLogin();
		elp.performlogin(tc_ID, password);
		TC_DashboardPage tcd = new TC_DashboardPage(driver);
		Thread.sleep(8000);
		tcd.clickOnMyCAAFSubmit();
		TC_MySchemesPage tcm = new TC_MySchemesPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//span[text()='"+sector+"']")).getText(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//b")).getText(), "Deemed Ready");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//a[contains(text(),'Apply for Scheme')]")).click();
		Thread.sleep(3000);
		tcm.selectScheme_ForJobRoleName(scheme);
		tcm.clickOnBrowseFileForScheme();
		Thread.sleep(3000);
		UploadFile.upload(schemeFile);
		Thread.sleep(3000);
		tcm.clickOnUploadFileForScheme();
		Thread.sleep(3000);
		tcm.clickOnSubmit();
		Thread.sleep(3000);
		tcm.clickOnOK();
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//span[text()='Fee Based']")).getText(), scheme);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//b")).getText(), "Scheme Approval Pending");
		Thread.sleep(3000);
		Thread.sleep(3000);
		PostLoginPage plp = new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		lp.clickLogin();
		elp.performlogin(sa_Username, password);
		SA_DashboardPage sad = new SA_DashboardPage(driver);
		Thread.sleep(8000);
		sad.clickOnJobRoleSchemeRecommendationRequest();
		SA_ViewJobRoleRecommendationRequestPage sav = new SA_ViewJobRoleRecommendationRequestPage(driver);
		Thread.sleep(3000);
		sav.enterTrainingCentreName(tc_Name);
		sav.selectStatus(stage);
		sav.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[contains(text(),'View Submitted CAAF')]")).click();
		//sav.clickOnBack();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[contains(text(),'View Job Role Details')]")).click();
		Thread.sleep(5000);
		sav.clickOnGoBack();
		Thread.sleep(3000);
		sav.enterTrainingCentreName(tc_Name);
		sav.selectStatus(stage);
		sav.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();		
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[contains(text(),'Approve/Reject')]")).click();
		Thread.sleep(3000);
		sav.clickOnApproved();
		Thread.sleep(3000);
		sav.clickOnSubmit();
		Thread.sleep(3000);
		sav.clickOnOK();
		Thread.sleep(3000);
		sav.clickOnReset();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//span[text()='Approved']")).getText(), "Approved");
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
		
		if(tc_Type.equals("NON PMKK"))
		{
			lp.clickLogin();
			elp.performlogin(tc_ID, password);
			Thread.sleep(8000);
			tcd.clickOnMyCAAFSubmit();
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//b")).getText(), "Scheme Approved");
			Thread.sleep(3000);
			tcm.clickOnSubmitForInspection();
			
			TC_CAAF_BillingInformationPage tcbi = new TC_CAAF_BillingInformationPage(driver);
			tcbi.enterCity(city);
			tcbi.selectCountry(Country);
			Thread.sleep(3000);
			if(paymentMethod.equals("Credit Card"))
			{
				tcbi.clickOnCreditCard();
				Thread.sleep(3000);
				tcbi.enterCreditCardNumber(creditCardNumber);
				tcbi.selectMonth_ForCreditCard(month_CreditCard);
				tcbi.selectYear_ForCreditCard(year_CreditCard);
				tcbi.enterCVVForCreditCard(cvv_CreditCard);
				Thread.sleep(3000);
				tcbi.clickOnMakePaymentForCreditCard();
			}
			else if(paymentMethod.equals("Debit Card"))
			{
				tcbi.clickOnDebitCard();
				Thread.sleep(3000);
				tcbi.enterDebitCardNumber(debitCardNumber);
				tcbi.selectMonth_ForDebitCard(month_DebitCard);
				tcbi.selectYear_ForDebitCard(year_DebitCard);
				tcbi.enterCVVForDebitCard(cvv_DebitCard);
				Thread.sleep(3000);
				tcbi.clickOnMakePaymentForDebitCard();
			}
			else if(paymentMethod.equals("Net Banking"))
			{
				tcbi.clickOnNetBanking();
				Thread.sleep(3000);
				tcbi.selectBankName(bankName);
				Thread.sleep(3000);
				tcbi.clickOnMakePaymentForNetBanking();
			}
			Thread.sleep(3000);
			tcbi.clickOnReturnToTheMerchantSite();
			Thread.sleep(5000);
			tcbi.clickOnContinue();
			
			Thread.sleep(3000);
			tcm.clickOnOK();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			
			lp.clickLogin();
			elp.performlogin(ia_Username, password);
			InspectionAgency_DashboardPage iad = new InspectionAgency_DashboardPage(driver);
			Thread.sleep(8000);
			iad.clickOnViewAllAssessmentRequest();
			IA_TC_AssessmentRequestPage iatc = new IA_TC_AssessmentRequestPage(driver);
			Thread.sleep(3000);
			iatc.clickOnViewAllTCRequest();
			Thread.sleep(3000);
			iatc.enterForSearch(tc_ID);
			Thread.sleep(3000);
			iatc.clickOnApply();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='Inspection Request']")).getText(), "Inspection Request");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Assign Inspection Date')]")).click();
			Thread.sleep(3000);
			iatc.selectForAssign_CentreInspector(ci_Username);
			iatc.enterForInspectionDate();
			Thread.sleep(3000);
			inspectionDate = driver.findElement(By.xpath("//input[@formcontrolname='inspectionDate']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC03", Integer.parseInt(sno), 69, inspectionDate);
			Thread.sleep(3000);
			iatc.clickOnAssign_ForCI();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			
			lp.clickLogin();
			elp.performlogin(tc_ID, password);
			Thread.sleep(8000);
			tcd.clickOnMyCAAFSubmit();
			Thread.sleep(8000);
			tcm.clickOnAcceptInspectionDate();
			Assert.assertEquals(driver.findElement(By.xpath("(//div[div[h5[contains(text(),'Accept/Reject Inspection Date')]]]//h5)[2]")).getText().replace("Proposed Inspection Date - ", "").replace("-", "/"), inspectionDate);
			Thread.sleep(3000);
			tcm.clickOnAcceptProposedInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnSubmit_ForInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnOK();
			
			lp.clickLogin();
			elp.performlogin(qc_Username, password);
			QC_DashboardPage qcd = new QC_DashboardPage(driver);
			Thread.sleep(8000);
			qcd.clickOnViewAllAssessmentRequest();
			QC_AllAssignedInspectionRequestPage qca = new QC_AllAssignedInspectionRequestPage(driver);
			Thread.sleep(4000);
			qca.enterForSearchByKeyword(tc_ID);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[text()='"+tc_ID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[text()='"+tc_ID+"']]//a[contains(text(),'Take Action')]")).click();
			
			TC_ApprovalPage datr = new TC_ApprovalPage(driver);
			Thread.sleep(3000);
			datr.clickOn_First_PreviewAttachedProofDocument();
			Thread.sleep(3000);
			datr.select_First_ReviewComments(address_ReviewComments);
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_First();
			
			Thread.sleep(3000);
			datr.select_Second_ReviewComments(approachRoad_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FrontView_Image();
			datr.clickOn_LeftView_Image();
			datr.clickOn_RightView_Image();
			datr.clickOn_InternetConectivity_Image();
			datr.clickOn_PowerBackup_Image();
			Thread.sleep(3000);
			datr.select_Third_ReviewComments(menResidential_ReviewComments);
			datr.select_Fourth_ReviewComments(womenResidential_ReviewComments);
			datr.select_Fifth_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_DifferentyAbledWashroom_Image();
			datr.clickOn_Ramp_Image();
			datr.clickOn_Lift_Image();
			Thread.sleep(3000);
			datr.select_Sixth_ReviewComments(hygiene_ReviewComments);
			datr.select_Seventh_ReviewComments(medical_ReviewComments);
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Second();
			
			Thread.sleep(3000);
			datr.clickOn_First_Action();
			datr.clickOn_First_TakeAction();
			
			Thread.sleep(3000);
			datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
			datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
			datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
			datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FirstImage();
			datr.clickOn_SecondView_FirstImage();
			Thread.sleep(3000);
			datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
			datr.select_Thirteen_ReviewComments(labType_ReviewComments);
			datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
			//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_SecondImage();
			datr.clickOn_SecondView_SecondImage();
			Thread.sleep(3000);
			datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
			datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_SSCCertificate_Image();
			datr.clickOn_HighestQualification_Image();
			datr.clickOn_NIESBUD_Image();
			datr.clickOn_IndustrialExperience_Image();
			Thread.sleep(10000);
			datr.clickOnNext_ForJobRole();
			
			Thread.sleep(3000);
			datr.clickOn_Second_Action();
			datr.clickOn_Second_TakeAction();
			
			Thread.sleep(3000);
			datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
			datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
			datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
			datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FirstImage();
			datr.clickOn_SecondView_FirstImage();
			Thread.sleep(3000);
			datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
			datr.select_Thirteen_ReviewComments(labType_ReviewComments);
			datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
			//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_SecondImage();
			datr.clickOn_SecondView_SecondImage();
			Thread.sleep(3000);
			datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
			datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_SSCCertificate_Image();
			datr.clickOn_HighestQualification_Image();
			datr.clickOn_NIESBUD_Image();
			datr.clickOn_IndustrialExperience_Image();
			Thread.sleep(10000);
			datr.clickOnNext_ForJobRole();
			
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Third();
			
			Thread.sleep(3000);
			datr.select_Eighth_ReviewComments(firstCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FirstImage();
			datr.clickOn_SecondView_FirstImage();
			Thread.sleep(3000);
			datr.select_Ninth_ReviewComments(secondCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_SecondImage();
			datr.clickOn_SecondView_SecondImage();
			Thread.sleep(3000);
			datr.select_Tenth_ReviewComments(thirdCentreArea_ReviewComments);
			datr.clickOn_FirstView_ThirdImage();
			datr.clickOn_SecondView_ThirdImage();
			Thread.sleep(3000);
			datr.select_Eleventh_ReviewComments(fourthCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FourthImage();
			datr.clickOn_SecondView_FourthImage();
			Thread.sleep(3000);
			datr.select_Twelth_ReviewComments(fifthCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FifthImage();
			datr.clickOn_SecondView_FifthImage();
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Fourth();
			
			//js.executeScript("scroll(900, 0)");
			Thread.sleep(3000);
			datr.select_Thirteen_ReviewComments(firstCentreStaff_ReviewComments);
			datr.select_Fourteen_ReviewComments(secondCentreStaff_ReviewComments);
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Fifth();
			
			Thread.sleep(3000);
			datr.selectFinalReviewStatus(finalStatus);
			datr.enterFinalStatusReviewComments(finalReviewComments);
			Thread.sleep(3000);
			datr.clickOnBrowseFile_ForFinalStatus();
			Thread.sleep(3000);
			UploadFile.upload(finalStatusFile);
			Thread.sleep(3000);
			datr.clickOnUploadFile_ForFinalStatus();
			Thread.sleep(3000);
			datr.clickOnSaveAndContinue();
			Thread.sleep(3000);
			datr.clickOnOK();

			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
						
		}
		
		else if(tc_Type.equals("PMKK") || tc_Type.equals("PMKK SPOKE"))
		{
			lp.clickLogin();
			elp.performlogin(tc_ID, password);
			Thread.sleep(8000);
			tcd.clickOnMyCAAFSubmit();
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0239)']]]//b")).getText(), "Scheme Approved");
			Thread.sleep(3000);
			tcm.clickOnSubmitForInspection();
			
			TC_CAAF_BillingInformationPage tcbi = new TC_CAAF_BillingInformationPage(driver);
			tcbi.enterCity(city);
			tcbi.selectCountry(Country);
			Thread.sleep(3000);
			if(paymentMethod.equals("Credit Card"))
			{
				tcbi.clickOnCreditCard();
				Thread.sleep(3000);
				tcbi.enterCreditCardNumber(creditCardNumber);
				tcbi.selectMonth_ForCreditCard(month_CreditCard);
				tcbi.selectYear_ForCreditCard(year_CreditCard);
				tcbi.enterCVVForCreditCard(cvv_CreditCard);
				Thread.sleep(3000);
				tcbi.clickOnMakePaymentForCreditCard();
			}
			else if(paymentMethod.equals("Debit Card"))
			{
				tcbi.clickOnDebitCard();
				Thread.sleep(3000);
				tcbi.enterDebitCardNumber(debitCardNumber);
				tcbi.selectMonth_ForDebitCard(month_DebitCard);
				tcbi.selectYear_ForDebitCard(year_DebitCard);
				tcbi.enterCVVForDebitCard(cvv_DebitCard);
				Thread.sleep(3000);
				tcbi.clickOnMakePaymentForDebitCard();
			}
			else if(paymentMethod.equals("Net Banking"))
			{
				tcbi.clickOnNetBanking();
				Thread.sleep(3000);
				tcbi.selectBankName(bankName);
				Thread.sleep(3000);
				tcbi.clickOnMakePaymentForNetBanking();
			}
			Thread.sleep(3000);
			tcbi.clickOnReturnToTheMerchantSite();
			Thread.sleep(5000);
			tcbi.clickOnContinue();
			
			Thread.sleep(3000);
			tcm.clickOnOK();
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			
			lp.clickLogin();
			elp.performlogin(pmkkSPOKEUsername, password);
			PMKKSPOC_DashboardPage pmkk = new PMKKSPOC_DashboardPage(driver);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0, 900)");
			Thread.sleep(8000);
			pmkk.clickOnViewAllAssessmentRequest();
			PMKKSPOC_AssignedInspectionRequestPage pmir = new PMKKSPOC_AssignedInspectionRequestPage(driver);
			Thread.sleep(3000);
			pmir.enterForSearch(tc_ID);
			Thread.sleep(3000);
			pmir.clickOnApply();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='Inspection Request']")).getText(), "Inspection Request");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Assign Inspection Date')]")).click();
			Thread.sleep(3000);
			pmir.selectForAssign_CentreInspector(ci_Username);
			Thread.sleep(3000);
			pmir.enterForInspectionDate();
			Thread.sleep(3000);
			inspectionDate = driver.findElement(By.xpath("//input[@formcontrolname='inspectionDate']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC03", Integer.parseInt(sno), 69, inspectionDate);
			Thread.sleep(3000);
			pmir.clickOnAssign_ForCI();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='Inspection Date Assigned']")).getText(), "Inspection Date Assigned");
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			
			lp.clickLogin();
			elp.performlogin(tc_ID, password);
			Thread.sleep(8000);
			tcd.clickOnMyCAAFSubmit();
			Thread.sleep(8000);
			tcm.clickOnAcceptInspectionDate();
			//Assert.assertEquals(driver.findElement(By.xpath("(//div[div[h5[contains(text(),'Accept/Reject Inspection Date')]]]//h5)[2]")).getText().replace("Proposed Inspection Date - ", "").replace("-", "/"), inspectionDate);
			Thread.sleep(3000);
			tcm.clickOnAcceptProposedInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnSubmit_ForInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnOK();
			
			lp.clickLogin();
			elp.performlogin(qc_Username, password);
			
			QC_DashboardPage qcd = new QC_DashboardPage(driver);
			Thread.sleep(8000);
			qcd.clickOnViewAllAssessmentRequest();
			QC_AllAssignedInspectionRequestPage qca = new QC_AllAssignedInspectionRequestPage(driver);
			Thread.sleep(4000);
			qca.enterForSearchByKeyword(tc_ID);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[text()='"+tc_ID+"']]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[text()='"+tc_ID+"']]//a[contains(text(),'Take Action')]")).click();
			
			TC_ApprovalPage datr = new TC_ApprovalPage(driver);
			Thread.sleep(3000);
			datr.clickOn_First_PreviewAttachedProofDocument();
			Thread.sleep(3000);
			datr.select_First_ReviewComments(address_ReviewComments);
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_First();
			
			Thread.sleep(3000);
			datr.select_Second_ReviewComments(approachRoad_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FrontView_Image();
			datr.clickOn_LeftView_Image();
			datr.clickOn_RightView_Image();
			datr.clickOn_InternetConectivity_Image();
			datr.clickOn_PowerBackup_Image();
			Thread.sleep(3000);
			datr.select_Third_ReviewComments(menResidential_ReviewComments);
			datr.select_Fourth_ReviewComments(womenResidential_ReviewComments);
			datr.select_Fifth_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_DifferentyAbledWashroom_Image();
			datr.clickOn_Ramp_Image();
			datr.clickOn_Lift_Image();
			Thread.sleep(3000);
			datr.select_Sixth_ReviewComments(hygiene_ReviewComments);
			datr.select_Seventh_ReviewComments(medical_ReviewComments);
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Second();
			
			Thread.sleep(3000);
			datr.clickOn_First_Action();
			datr.clickOn_First_TakeAction();
			
			Thread.sleep(3000);
			datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
			datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
			datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
			datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FirstImage();
			datr.clickOn_SecondView_FirstImage();
			Thread.sleep(3000);
			datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
			datr.select_Thirteen_ReviewComments(labType_ReviewComments);
			datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
			//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_SecondImage();
			datr.clickOn_SecondView_SecondImage();
			Thread.sleep(3000);
			datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
			datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_SSCCertificate_Image();
			datr.clickOn_HighestQualification_Image();
			datr.clickOn_NIESBUD_Image();
			datr.clickOn_IndustrialExperience_Image();
			Thread.sleep(10000);
			datr.clickOnNext_ForJobRole();
			
			Thread.sleep(3000);
			datr.clickOn_Second_Action();
			datr.clickOn_Second_TakeAction();
			
			Thread.sleep(3000);
			datr.select_Eighth_ReviewComments(floorArea_JobRole_ReviewComments);
			datr.select_Ninth_ReviewComments(coveredArea_JobRole_ReviewComments);
			datr.select_Tenth_ReviewComments(classroomArea_ReviewComments);
			datr.select_Eleventh_ReviewComments(classroomFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FirstImage();
			datr.clickOn_SecondView_FirstImage();
			Thread.sleep(3000);
			datr.select_Twelth_ReviewComments(labOpenArea_ReviewComments);
			datr.select_Thirteen_ReviewComments(labType_ReviewComments);
			datr.select_Fourteen_ReviewComments(labFacilities_ReviewComments);
			//datr.select_Sixteen_ReviewComments(labFacilities_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_SecondImage();
			datr.clickOn_SecondView_SecondImage();
			Thread.sleep(3000);
			datr.select_Fifteen_ReviewComments(equipmentDetails_ReviewComments);
			datr.select_Sixteen_ReviewComments(trainer_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_SSCCertificate_Image();
			datr.clickOn_HighestQualification_Image();
			datr.clickOn_NIESBUD_Image();
			datr.clickOn_IndustrialExperience_Image();
			Thread.sleep(10000);
			datr.clickOnNext_ForJobRole();
			
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Third();
			
			Thread.sleep(3000);
			datr.select_Eighth_ReviewComments(firstCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FirstImage();
			datr.clickOn_SecondView_FirstImage();
			Thread.sleep(3000);
			datr.select_Ninth_ReviewComments(secondCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_SecondImage();
			datr.clickOn_SecondView_SecondImage();
			Thread.sleep(3000);
			datr.select_Tenth_ReviewComments(thirdCentreArea_ReviewComments);
			datr.clickOn_FirstView_ThirdImage();
			datr.clickOn_SecondView_ThirdImage();
			Thread.sleep(3000);
			datr.select_Eleventh_ReviewComments(fourthCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FourthImage();
			datr.clickOn_SecondView_FourthImage();
			Thread.sleep(3000);
			datr.select_Twelth_ReviewComments(fifthCentreArea_ReviewComments);
			Thread.sleep(3000);
			datr.clickOn_FirstView_FifthImage();
			datr.clickOn_SecondView_FifthImage();
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Fourth();
			
			//js.executeScript("scroll(900, 0)");
			Thread.sleep(3000);
			datr.select_Thirteen_ReviewComments(firstCentreStaff_ReviewComments);
			datr.select_Fourteen_ReviewComments(secondCentreStaff_ReviewComments);
			Thread.sleep(3000);
			datr.clickOnSaveAndNext_Fifth();
			
			Thread.sleep(3000);
			datr.selectFinalReviewStatus(finalStatus);
			datr.enterFinalStatusReviewComments(finalReviewComments);
			Thread.sleep(3000);
			datr.clickOnBrowseFile_ForFinalStatus();
			Thread.sleep(3000);
			UploadFile.upload(finalStatusFile);
			Thread.sleep(3000);
			datr.clickOnUploadFile_ForFinalStatus();
			Thread.sleep(3000);
			datr.clickOnSaveAndContinue();
			Thread.sleep(3000);
			datr.clickOnOK();
			
			Thread.sleep(3000);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
			
			
		}
		
		lp.clickLogin();
		elp.performlogin(ssc_Username, password);
		SSC_DashboardPage ssdp = new SSC_DashboardPage(driver);
		Thread.sleep(8000);
		ssdp.clickOnAccrediationAndAffiliation();
		SSC_AccrediationAndAffiliationPage ssa = new SSC_AccrediationAndAffiliationPage(driver);
		Thread.sleep(5000);
		ssa.clickOnAllAffiliationsCAAF();
		SSC_AccrediationAndAffiliation_CAAFRequestPage ssca = new SSC_AccrediationAndAffiliation_CAAFRequestPage(driver);
		Thread.sleep(3000);
		ssca.enterSearchByKeywords(tc_ID);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+tc_ID+"']]//td[text()='New Request']")).getText(), "New Request");
		driver.findElement(By.xpath("//tr[td[text()='"+tc_ID+"']]//a")).click();
		driver.findElement(By.xpath("//tr[td[text()='"+tc_ID+"']]//a[text()='Action Affilations']")).click();
		
		tcID = ReadWriteData.getData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC04", Integer.parseInt(sno), 1);
		
	}	
	
		
}
