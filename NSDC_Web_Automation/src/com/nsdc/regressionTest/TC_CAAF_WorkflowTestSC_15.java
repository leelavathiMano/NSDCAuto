package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
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
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SA_DashboardPage;
import com.nsdc.pages.SA_ViewJobRoleRecommendationRequestPage;
import com.nsdc.pages.SSC_AccrediationAndAffiliationPage;
import com.nsdc.pages.SSC_AccrediationAndAffiliation_CAAFRequestPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.TC_ApprovalPage;
import com.nsdc.pages.TC_DashboardPage;
import com.nsdc.pages.TC_MySchemesPage;
import com.nsdc.pages.TrainingCentre_CAAF_Page;
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
		
//		Thread.sleep(3000);
//		atc.clickOnUploadMOU_BrowseFile();
//		Thread.sleep(3000);
//		UploadFile.upload(mOU_File);
//		Thread.sleep(3000);
//		atc.clickOnUploadMOU_UploadFile();
		Thread.sleep(3000);
		atc.clickOnSubmit();
		Thread.sleep(3000);
		atc.clickOnYesAddTrainingCentre();
		Thread.sleep(3000);
		atc.clickOnClose();
		tcID = driver.findElement(By.xpath("(//td[@data-field='RecordID']/span)[1]")).getText();
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "AddTrainingCentreSC15TC01", sno, 25, tcID);
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TC_CAAF_SC15TC02", sno, 1, tcID);
		ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC03", sno, 1, tcID);
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
			Thread.sleep(10000);
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
	public void cAAF_FormFillingTC_02(String sno, String tcUsername, String tcPassword, String newPassword, String confirmPassword, String nameOfTC, String tcType, String socialmedia, String websiteurl, String spocName, String spocEmail, String spocMobileNumber, String spocAltNumber, String centrePrincipalName, String centrePrincipalEmail, String centrePrincipalcontactNumber, String tcAddress, String tcLandmark, String tcPinCode, String tcState, String tcDistrict, String tcTehsil, String tcParliamentry, String tcAddressProof, String addressProofFile, String tcAreaClassificationCentre, String centreAtGroundFloor, String buildingStatus, String buildingConstruction, String transportSystem, String transportName, String buildingFace, String approachRoadWidth, String previousBuildingState, String buildingStateFile, String centreFloorType, String tcWallsType, String internetAvailablity, String firstAffiliationName, String firstAffiliationType, String firstAboutAffiliation, String secondAffiliationName, String secondAffiliationType, String secondAboutAffiliation, String thirdAffiliationName, String thirdAffiliationType, String thirdAboutAffiliation, String menResidentialArea, String totalAreaMenResidential, String roomsNumberMenResidential, String residentialCapacityMen, String remarkMenResidential, String womenResidentialArea, String totalAreaWomenResidential, String roomsNumberWomenResidential, String residentialCapacityWomen, String remarkWomenResidential, String safeDrinkingWater, String fireEquipmentAvailablity, String classRoomCarpetArea, String classroomRemark, String laboratoryCarpetArea, String laboratoryType, String laboratoryRemark, String hybridCarpetArea, String hybridLaboratoryType, String hybridRemark, String sector, String jobRollName, String secondJobRollName, String thirdJobRollName, String traineeToTrainerRatio, String parallelBatchesNumber, String jobRole, String additionalArea, String additionalCarpetArea, String coveredCarpetArea, String trainerID, String trainerAvailablity, String trainerResourceType, String first_Classroom, String first_Laboratory, String first_Hybrid, String second_Classroom, String second_Laboratory, String second_Hybrid, String firstCentreCarpetArea, String firstCentrWashroomType, String firstCentreAreaRemark, String secondCentreCarpetArea, String secondCentrWashroomType, String secondCentreAreaRemark, String thirdCentreCarpetArea, String thirdCentreAreaRemark, String fourthCentreCarpetArea, String fourthCentreAreaRemark, String fifthCentreAreaType, String fifthCentreCarpetArea, String fifthCentrWashroomType, String fifthCentreAreaRemark, String firstSupportStaffName, String firstCentreStaffHighestQualification, String firstResourceType, String firstCentreStaffRemark, String secondSupportStaffName, String secondCentreStaffHighestQualification, String secondResourceType, String secondCentreStaffRemark, String thirdSupportStaffName, String thirdCentreStaffHighestQualification, String thirdResourceType, String thirdCentreStaffRemark, String fourthSupportStaffType, String fourthSupportStaffName, String fourthCentreStaffHighestQualification, String fourthResourceType, String fourthCentreStaffRemark) throws Exception
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
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='trainingCentreName']")).getAttribute("value"), nameOfTC);
		caaf.selectTypeOfTrainingCentre(tcType);
		caaf.enterSocialmediaLinks(socialmedia);
		caaf.enterWebsiteUrl(websiteurl);
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='SPOCfirstName']")).getAttribute("value"), spocName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='SPOCEmail']")).getAttribute("value"), spocEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='SPOCmobileNumber']")).getAttribute("value"), spocMobileNumber);
		caaf.enterSpocAlternateNumber(spocAltNumber);
		caaf.enterCentrePrincipal_Name(centrePrincipalName);
		caaf.enterCentrePrincipal_EmailAddress(centrePrincipalEmail);
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
		caaf.selectTCAreaClassificationOfCentre(tcAreaClassificationCentre);
		caaf.selectIsEntireCentreAtGroundFloor(centreAtGroundFloor);
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		
		caaf.selectBuildingStatus(buildingStatus);
		caaf.selectTypeOfBuildingConstruction(buildingConstruction);
		caaf.selectProximityForPublicTransportSystem(transportSystem);
		caaf.enterNearestTransportName(transportName);
		caaf.selectBuildingFrontFace(buildingFace);
		caaf.enterApproachRoadWidth(approachRoadWidth);
		caaf.selectPreviousStateOfBuilding(previousBuildingState);
//		Thread.sleep(3000);
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
		Thread.sleep(3000);
		caaf.enterFirst_NameofAffiliation(secondAffiliationName);
		caaf.selectFirst_TypeOfAffiliation(secondAffiliationType);
		caaf.enterFirst_Affiliation_StartDate();
		caaf.enterFirst_Affiliation_EndDate();
		caaf.enterFirst_BriefAboutTheAffiliation(secondAboutAffiliation);
		Thread.sleep(3000);
		caaf.clickOnAddAnotherAffiliation();
		Thread.sleep(3000);
		caaf.enterFirst_NameofAffiliation(thirdAffiliationName);
		caaf.selectFirst_TypeOfAffiliation(thirdAffiliationType);
		caaf.enterFirst_Affiliation_StartDate();
		caaf.enterFirst_Affiliation_EndDate();
		caaf.enterFirst_BriefAboutTheAffiliation(thirdAboutAffiliation);
		Thread.sleep(3000);
		caaf.clickOnAddAnotherAffiliation();
		Thread.sleep(3000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("scroll(0, 900)");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+firstAffiliationName+"']")).getText(), firstAffiliationName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+firstAffiliationType+"']")).getText(), firstAffiliationType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+firstAboutAffiliation+"']")).getText(), firstAboutAffiliation);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+secondAffiliationName+"']")).getText(), secondAffiliationName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+secondAffiliationType+"']")).getText(), secondAffiliationType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+secondAboutAffiliation+"']")).getText(), secondAboutAffiliation);

		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdAffiliationName+"']")).getText(), thirdAffiliationName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdAffiliationType+"']")).getText(), thirdAffiliationType);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdAboutAffiliation+"']")).getText(), thirdAboutAffiliation);
		Thread.sleep(2000);
		caaf.clickOnRemove_ThirdAffiliation();

		
		caaf.selectMen_ResidentialAreaAvailable(menResidentialArea);
		if(menResidentialArea.equals("Yes"))
		{
			caaf.enterMen_TotalAreaOfResidential(totalAreaMenResidential);
			caaf.enterMen_NumberOfRooms(roomsNumberMenResidential);
			caaf.enterMen_ResidentialCapacity(residentialCapacityMen);
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
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(3000);
		caaf.clickOnAddClassRoom();
		Thread.sleep(3000);
		caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
		caaf.clickOnClassRoomEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterClassRoomRemark(classroomRemark);
		Thread.sleep(3000);
		caaf.clickOn_Add_ForClassRoom();
		Thread.sleep(3000);
		caaf.clickOnAddClassRoom();
		Thread.sleep(3000);
		caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
		caaf.clickOnClassRoomEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterClassRoomRemark(classroomRemark);
		Thread.sleep(3000);
		caaf.clickOn_Add_ForClassRoom();
		Thread.sleep(3000);
		caaf.clickOnAddClassRoom();
		Thread.sleep(3000);
		caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
		caaf.clickOnClassRoomEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterClassRoomRemark(classroomRemark);
		Thread.sleep(3000);
		caaf.clickOn_Add_ForClassRoom();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='CLASS_1 ']")).getText(), "CLASS_1");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='CLASS_2 ']")).getText(), "CLASS_2");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='CLASS_3 ']")).getText(), "CLASS_3");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 500)");
		Thread.sleep(10000);
		caaf.clickOnThird_Remove();
		
		
		Thread.sleep(3000);
		caaf.clickOnAddLaboratory();
		Thread.sleep(3000);
		caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
		caaf.selectLaboratoryType(laboratoryType);
		caaf.clickOnLaboratoryEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterLaboratoryRemark(laboratoryRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForLaboratory();
		Thread.sleep(3000);
		caaf.clickOnAddLaboratory();
		Thread.sleep(3000);
		caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
		caaf.selectLaboratoryType(laboratoryType);
		caaf.clickOnLaboratoryEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterLaboratoryRemark(laboratoryRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForLaboratory();
		Thread.sleep(3000);
		caaf.clickOnAddLaboratory();
		Thread.sleep(3000);
		caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
		caaf.selectLaboratoryType(laboratoryType);
		caaf.clickOnLaboratoryEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterLaboratoryRemark(laboratoryRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForLaboratory();
		Thread.sleep(3000);
		js.executeScript("scroll(0, 900)");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='LAB_1']")).getText(), "LAB_1");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='LAB_2']")).getText(), "LAB_2");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='LAB_3']")).getText(), "LAB_3");
		Thread.sleep(10000);
		caaf.clickOnFifth_Remove();
		
		
		Thread.sleep(3000);
		caaf.clickOnAddHybrid();
		Thread.sleep(3000);
		caaf.enterHybridCarpetArea(hybridCarpetArea);
		caaf.selectHybridLaboratoryType(hybridLaboratoryType);
		caaf.clickOnHybridEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterHybridRemark(hybridRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForHybrid();
		Thread.sleep(3000);
		caaf.clickOnAddHybrid();
		Thread.sleep(3000);
		caaf.enterHybridCarpetArea(hybridCarpetArea);
		caaf.selectHybridLaboratoryType(hybridLaboratoryType);
		caaf.clickOnHybridEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterHybridRemark(hybridRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForHybrid();
		Thread.sleep(3000);
		caaf.clickOnAddHybrid();
		Thread.sleep(3000);
		caaf.enterHybridCarpetArea(hybridCarpetArea);
		caaf.selectHybridLaboratoryType(hybridLaboratoryType);
		caaf.clickOnHybridEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterHybridRemark(hybridRemark);
		Thread.sleep(3000);
		caaf.clickOnAdd_ForHybrid();
		Thread.sleep(2000);
		js.executeScript("scroll(0, 900)");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='HYBRID_1']")).getText(), "HYBRID_1");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='HYBRID_2']")).getText(), "HYBRID_2");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='HYBRID_3']")).getText(), "HYBRID_3");
		Thread.sleep(10000);
		caaf.clickOnSeventh_Remove();
		
		
		Thread.sleep(3000);
		caaf.clickOnAddJobRole();
		Thread.sleep(3000);
		caaf.selectSectorForJobRole(sector);
		caaf.selectForJobRoleName(jobRollName);
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
		Thread.sleep(3000);
		caaf.clickOnAddJobRole();
		Thread.sleep(3000);
		caaf.selectSectorForJobRole(sector);
		caaf.selectForJobRoleName(secondJobRollName);
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
		Thread.sleep(3000);
		caaf.clickOnAddJobRole();
		Thread.sleep(3000);
		caaf.selectSectorForJobRole(sector);
		caaf.selectForJobRoleName(thirdJobRollName);
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
		Thread.sleep(3000);
		js.executeScript("scroll(0, 900)");
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+jobRollName+"'])[1]")).getText(), jobRollName);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+sector+"'])[1]")).getText(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+traineeToTrainerRatio+"'])[1]")).getText(), traineeToTrainerRatio);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+parallelBatchesNumber+"'])[1]")).getText(), parallelBatchesNumber);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+secondJobRollName+"']")).getText(), secondJobRollName);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+sector+"'])[2]")).getText(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+traineeToTrainerRatio+"'])[2]")).getText(), traineeToTrainerRatio);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+parallelBatchesNumber+"'])[2]")).getText(), parallelBatchesNumber);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+thirdJobRollName+"']")).getText(), thirdJobRollName);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+sector+"'])[3]")).getText(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+traineeToTrainerRatio+"'])[3]")).getText(), traineeToTrainerRatio);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text()='"+parallelBatchesNumber+"'])[3]")).getText(), parallelBatchesNumber);
		
		Thread.sleep(10000);
		caaf.clickOnNinth_Remove();
		

		
		
		Thread.sleep(3000);
		caaf.select_First_AssociatedClassroom(first_Classroom);
		caaf.select_First_AssociatedLaboratory(first_Laboratory);
		caaf.select_First_AssociatedHybrid(first_Hybrid);
		Thread.sleep(3000);
		caaf.select_Second_AssociatedClassroom(second_Classroom);
		caaf.select_Second_AssociatedLaboratory(second_Laboratory);
		caaf.select_Second_AssociatedHybrid(second_Hybrid);
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(5000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[1]")).getText(), "Reception");
		caaf.enter_FirstCentreArea_CarpetArea(firstCentreCarpetArea);
		caaf.select_FirstCentreArea_TypeOfWashRoom(firstCentrWashroomType);
		Thread.sleep(3000);
		caaf.clickOnFirstCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_FirstCentreArea_Remark(firstCentreAreaRemark);
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[2]")).getText(), "Placement & Entrepreneurship Cell");
		caaf.enter_SecondCentreArea_CarpetArea(secondCentreCarpetArea);
		caaf.select_SecondCentreArea_TypeOfWashRoom(secondCentrWashroomType);
		Thread.sleep(3000);
		caaf.clickOnSecondCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_SecondCentreArea_Remark(secondCentreAreaRemark);
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[3]")).getText(), "Male Washroom");
		caaf.enter_ThirdCentreArea_CarpetArea(thirdCentreCarpetArea);
		Thread.sleep(8000);
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
		caaf.select_FifthCentreArea_TypeOfWashRoom(fifthCentrWashroomType);
		Thread.sleep(3000);
		caaf.clickOnFifthCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enter_FifthCentreArea_Remark(fifthCentreAreaRemark);
		Thread.sleep(3000);
		caaf.clickForAddAnotherCentreType();
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[1]")).getAttribute("value"), "Placement Coordinator");
		caaf.enterFirst_NameOfSupportStaff(firstSupportStaffName);
		caaf.selectFirst_HighestQualificationForCentreStaff(firstCentreStaffHighestQualification);
		caaf.selectFirst_ResourceTypeOfCentreStaff(firstResourceType);
		caaf.enterFirst_RemarkForCentreStaff(firstCentreStaffRemark);
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.findElement(By.xpath("(//select[@id='type'])[2]")).getAttribute("value"), "");
		caaf.enterSecond_NameOfSupportStaff(secondSupportStaffName);
		caaf.selectSecond_HighestQualificationForCentreStaff(secondCentreStaffHighestQualification);
		caaf.selectSecond_ResourceTypeOfCentreStaff(secondResourceType);
		caaf.enterSecond_RemarkForCentreStaff(secondCentreStaffRemark);
		
		Thread.sleep(3000);
		caaf.enterThird_NameOfSupportStaff(thirdSupportStaffName);
		caaf.selectThird_HighestQualificationForCentreStaff(thirdCentreStaffHighestQualification);
		caaf.selectThird_ResourceTypeOfCentreStaff(thirdResourceType);
		caaf.enterThird_RemarkForCentreStaff(thirdCentreStaffRemark);
		
		Thread.sleep(3000);
		caaf.selectFourth_TypeOfSupportStaff(fourthSupportStaffType);
		caaf.enterFourth_NameOfSupportStaff(fourthSupportStaffName);
		caaf.selectFourth_HighestQualificationForCentreStaff(fourthCentreStaffHighestQualification);
		caaf.selectFourth_ResourceTypeOfCentreStaff(fourthResourceType);
		caaf.enterFourth_RemarkForCentreStaff(fourthCentreStaffRemark);
		
		caaf.clickForAddAnotherCentreStaff();
		
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickOn_OK_ForMobileApp();
		
//		Thread.sleep(3000);
//		caaf.clickOnSaveAndContinueToPayment();
//		Thread.sleep(3000);
//		caaf.clickOnOK();
//		Thread.sleep(3000);
//		caaf.clickOnLogOut();
		
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		caaf.clickOnLogout_Profile();
		
		
	}
	
	@DataProvider
	public Object[][] tcApproval()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC03");
	}
	
	@Test(dataProvider="tcApproval")
	public void approveTrainingCentreTC_03(String sno, String tc_ID, String password, String tc_Name, String tc_Type, String ha_Username, String recommendationLetter, String ia_Username, String stage, String assignTo, String daUsername, String tcName_ReviewComments, String tcType_ReviewComments, String centreDirector_ReviewComments, String address_ReviewComments, String area_ReviewComments, String centreAtGroundFloor_ReviewComments, String buildingStatus_ReviewComments, String buildingType_ReviewComments, String transport_ReviewComments, String nearestTransport_ReviewComments, String buildingFrontFace_ReviewComments, String approachRoad_ReviewComments, String buildingPreviousState_ReviewComments, String menResidential_ReviewComments, String womenResidential_ReviewComments, String diffrentlyAbledFacilities_ReviewComments, String hygiene_ReviewComments, String medical_ReviewComments, String carpetArea_ReviewComments, String coveredArea_ReviewComments, String classroomArea_ReviewComments, String classroomFacilities_ReviewComments, String labArea_ReviewComments, String labType_ReviewComments, String labFacilities_ReviewComments, String trainer_ReviewComments, String firstCentreArea_ReviewComments, String secondCentreArea_ReviewComments, String thirdCentreArea_ReviewComments, String fourthCentreArea_ReviewComments, String fifthCentreArea_ReviewComments, String firstCentreStaff_ReviewComments, String secondCentreStaff_ReviewComments, String finalStatus, String finalReviewComments, String finalStatusFile, String pmkkSPOKEUsername, String sector, String jobRoleName, String scheme, String schemeFile, String sa_Username, String ci_Username, String inspectionDate, String ssc_Username) throws Exception
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
				iatc.enterForSearch(tc_ID);
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='In-Process DA']")).getText(), "In-Process DA");
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
				datc.clickOnApply();
				Thread.sleep(3000);
				datc.clickOnAction();
				datc.clickOnViewQuickDetails();
				Thread.sleep(3000);
				datc.clickOnReview();
				TC_ApprovalPage datr = new TC_ApprovalPage(driver);
				Thread.sleep(3000);
				datr.select_First_ReviewComments(tcName_ReviewComments);
				datr.select_Second_ReviewComments(tcType_ReviewComments);
				datr.select_Third_ReviewComments(centreDirector_ReviewComments);
				datr.select_Fourth_ReviewComments(address_ReviewComments);
				datr.select_Fifth_ReviewComments(area_ReviewComments);
				datr.select_Sixth_ReviewComments(centreAtGroundFloor_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("scroll(900, 0)");
				datr.select_seventh_ReviewComments(buildingStatus_ReviewComments);
				datr.select_Eighth_ReviewComments(buildingType_ReviewComments);
				datr.select_Ninth_ReviewComments(transport_ReviewComments);
				datr.select_Tenth_ReviewComments(nearestTransport_ReviewComments);
				datr.select_Eleventh_ReviewComments(buildingFrontFace_ReviewComments);
				datr.select_Twelth_ReviewComments(approachRoad_ReviewComments);
				datr.select_Thirteen_ReviewComments(buildingPreviousState_ReviewComments);
				datr.select_Fourteen_ReviewComments(menResidential_ReviewComments);
				datr.select_Fifteen_ReviewComments(womenResidential_ReviewComments);
				datr.select_Sixteen_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				datr.select_Seventeen_ReviewComments(hygiene_ReviewComments);
				datr.select_Eighteen_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				Thread.sleep(3000);
				datr.select_Ninteen_ReviewComments(firstCentreArea_ReviewComments);
				datr.select_Twenty_ReviewComments(secondCentreArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(thirdCentreArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(fourthCentreArea_ReviewComments);
				datr.select_TwentyThree_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_TwentyFour_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_twentyFive_ReviewComments(secondCentreStaff_ReviewComments);
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
				datr.select_First_ReviewComments(tcName_ReviewComments);
				datr.select_Second_ReviewComments(tcType_ReviewComments);
				datr.select_Third_ReviewComments(centreDirector_ReviewComments);
				datr.select_Fourth_ReviewComments(address_ReviewComments);
				datr.select_Fifth_ReviewComments(area_ReviewComments);
				datr.select_Sixth_ReviewComments(centreAtGroundFloor_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("scroll(900, 0)");
				datr.select_seventh_ReviewComments(buildingStatus_ReviewComments);
				datr.select_Eighth_ReviewComments(buildingType_ReviewComments);
				datr.select_Ninth_ReviewComments(transport_ReviewComments);
				datr.select_Tenth_ReviewComments(nearestTransport_ReviewComments);
				datr.select_Eleventh_ReviewComments(buildingFrontFace_ReviewComments);
				datr.select_Twelth_ReviewComments(approachRoad_ReviewComments);
				datr.select_Thirteen_ReviewComments(buildingPreviousState_ReviewComments);
				datr.select_Fourteen_ReviewComments(menResidential_ReviewComments);
				datr.select_Fifteen_ReviewComments(womenResidential_ReviewComments);
				datr.select_Sixteen_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				datr.select_Seventeen_ReviewComments(hygiene_ReviewComments);
				datr.select_Eighteen_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				Thread.sleep(3000);
				datr.select_Ninteen_ReviewComments(firstCentreArea_ReviewComments);
				datr.select_Twenty_ReviewComments(secondCentreArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(thirdCentreArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(fourthCentreArea_ReviewComments);
				datr.select_TwentyThree_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_TwentyFour_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_twentyFive_ReviewComments(secondCentreStaff_ReviewComments);
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
				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='In-Process DA']")).getText(), "In-Process DA");
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
				datc.clickOnApply();
				Thread.sleep(3000);
				datc.clickOnAction();
				datc.clickOnViewQuickDetails();
				Thread.sleep(3000);
				datc.clickOnReview();
				TC_ApprovalPage datr = new TC_ApprovalPage(driver);
				Thread.sleep(3000);
				datr.select_First_ReviewComments(tcName_ReviewComments);
				datr.select_Second_ReviewComments(tcType_ReviewComments);
				datr.select_Third_ReviewComments(centreDirector_ReviewComments);
				datr.select_Fourth_ReviewComments(address_ReviewComments);
				datr.select_Fifth_ReviewComments(area_ReviewComments);
				datr.select_Sixth_ReviewComments(centreAtGroundFloor_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("scroll(900, 0)");
				datr.select_seventh_ReviewComments(buildingStatus_ReviewComments);
				datr.select_Eighth_ReviewComments(buildingType_ReviewComments);
				datr.select_Ninth_ReviewComments(transport_ReviewComments);
				datr.select_Tenth_ReviewComments(nearestTransport_ReviewComments);
				datr.select_Eleventh_ReviewComments(buildingFrontFace_ReviewComments);
				datr.select_Twelth_ReviewComments(approachRoad_ReviewComments);
				datr.select_Thirteen_ReviewComments(buildingPreviousState_ReviewComments);
				datr.select_Fourteen_ReviewComments(menResidential_ReviewComments);
				datr.select_Fifteen_ReviewComments(womenResidential_ReviewComments);
				datr.select_Sixteen_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				datr.select_Seventeen_ReviewComments(hygiene_ReviewComments);
				datr.select_Eighteen_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				Thread.sleep(3000);
				datr.select_Ninteen_ReviewComments(firstCentreArea_ReviewComments);
				datr.select_Twenty_ReviewComments(secondCentreArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(thirdCentreArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(fourthCentreArea_ReviewComments);
				datr.select_TwentyThree_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_TwentyFour_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_twentyFive_ReviewComments(secondCentreStaff_ReviewComments);
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
				datr.select_First_ReviewComments(tcName_ReviewComments);
				datr.select_Second_ReviewComments(tcType_ReviewComments);
				datr.select_Third_ReviewComments(centreDirector_ReviewComments);
				datr.select_Fourth_ReviewComments(address_ReviewComments);
				datr.select_Fifth_ReviewComments(area_ReviewComments);
				datr.select_Sixth_ReviewComments(centreAtGroundFloor_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_First();
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("scroll(900, 0)");
				datr.select_seventh_ReviewComments(buildingStatus_ReviewComments);
				datr.select_Eighth_ReviewComments(buildingType_ReviewComments);
				datr.select_Ninth_ReviewComments(transport_ReviewComments);
				datr.select_Tenth_ReviewComments(nearestTransport_ReviewComments);
				datr.select_Eleventh_ReviewComments(buildingFrontFace_ReviewComments);
				datr.select_Twelth_ReviewComments(approachRoad_ReviewComments);
				datr.select_Thirteen_ReviewComments(buildingPreviousState_ReviewComments);
				datr.select_Fourteen_ReviewComments(menResidential_ReviewComments);
				datr.select_Fifteen_ReviewComments(womenResidential_ReviewComments);
				datr.select_Sixteen_ReviewComments(diffrentlyAbledFacilities_ReviewComments);
				datr.select_Seventeen_ReviewComments(hygiene_ReviewComments);
				datr.select_Eighteen_ReviewComments(medical_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Second();
				Thread.sleep(3000);
				datr.clickOn_First_Action();
				datr.clickOn_First_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOn_Second_Action();
				datr.clickOn_Second_TakeAction();
				js.executeScript("scroll(900, 0)");
				datr.select_Ninteen_ReviewComments(carpetArea_ReviewComments);
				datr.select_Twenty_ReviewComments(coveredArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(classroomArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(classroomFacilities_ReviewComments);
				datr.select_TwentyThree_ReviewComments(labArea_ReviewComments);
				datr.select_TwentyFour_ReviewComments(labType_ReviewComments);
				datr.select_twentyFive_ReviewComments(labFacilities_ReviewComments);
				datr.select_TwentySix_ReviewComments(trainer_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnNext_ForJobRole();
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Third();
				Thread.sleep(3000);
				datr.select_Ninteen_ReviewComments(firstCentreArea_ReviewComments);
				datr.select_Twenty_ReviewComments(secondCentreArea_ReviewComments);
				datr.select_TwentyOne_ReviewComments(thirdCentreArea_ReviewComments);
				datr.select_TwentyTwo_ReviewComments(fourthCentreArea_ReviewComments);
				datr.select_TwentyThree_ReviewComments(fifthCentreArea_ReviewComments);
				Thread.sleep(3000);
				datr.clickOnSaveAndNext_Fourth();
				js.executeScript("scroll(900, 0)");
				Thread.sleep(3000);
				datr.select_TwentyFour_ReviewComments(firstCentreStaff_ReviewComments);
				datr.select_twentyFive_ReviewComments(secondCentreStaff_ReviewComments);
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
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//span[text()='"+sector+"']")).getText(), sector);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//b")).getText(), "Deemed Ready");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//a[contains(text(),'Apply for Scheme')]")).click();
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
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//span[text()='Fee Based']")).getText(), scheme);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//b")).getText(), "Scheme Approval Pending");
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
		//Thread.sleep(3000);
		//sav.selectTrainingCentreName(tc_Name);
		//sav.selectStatus(status);
		//sav.clickOnApply();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[contains(text(),'View Submitted CAAF')]")).click();
		sav.clickOnBack();
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[contains(text(),'View Job Role Details')]")).click();
		sav.clickOnBack();
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();		
		driver.findElement(By.xpath("//tr[td[span[text()='"+tc_Name+"']]]//a[contains(text(),'Approve/Reject')]")).click();
		Thread.sleep(3000);
		sav.clickOnApproved();
		Thread.sleep(3000);
		sav.clickOnSubmit();
		//Thread.sleep(3000);
		//sav.selectTrainingCentreName(tc_Name);
		//sav.selectStatus(status);
		//sav.clickOnApply();
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
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//b")).getText(), "Scheme Approved");
			Thread.sleep(3000);
			tcm.clickOnSubmitForInspection();
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
			ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC03", Integer.parseInt(sno), 54, inspectionDate);
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
			Assert.assertEquals(driver.findElement(By.xpath("//h5[text()='Proposed Inspection Date - 21-11-2018']")).getText().replace("Proposed Inspection Date - ", "").replace("-", "/"), inspectionDate);
			Thread.sleep(3000);
			tcm.clickOnAcceptProposedInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnSubmit_ForInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnOK();
				
		}
		
		else if(tc_Type.equals("PMKK") || tc_Type.equals("PMKK SPOKE"))
		{
			lp.clickLogin();
			elp.performlogin(tc_ID, password);
			Thread.sleep(8000);
			tcd.clickOnMyCAAFSubmit();
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+jobRoleName+" (AGR/Q0412)']]]//b")).getText(), "Scheme Approved");
			Thread.sleep(3000);
			tcm.clickOnSubmitForInspection();
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
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//span[text()='Inspection Request']")).getText(), "Inspection Request");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			driver.findElement(By.xpath("//tr[td[span[text()='"+tc_ID+"']]]//a[contains(text(),'Assign Inspection Date')]")).click();
			Thread.sleep(3000);
			pmir.selectForAssign_CentreInspector(ci_Username);
			pmir.enterForInspectionDate();
			Thread.sleep(3000);
			inspectionDate = driver.findElement(By.xpath("//input[@formcontrolname='inspectionDate']")).getAttribute("value");
			ReadWriteData.setExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TCApprovalSC15TC03", Integer.parseInt(sno), 54, inspectionDate);
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
			Assert.assertEquals(driver.findElement(By.xpath("//h5[text()='Proposed Inspection Date - 21-11-2018']")).getText().replace("Proposed Inspection Date - ", "").replace("-", "/"), inspectionDate);
			Thread.sleep(3000);
			tcm.clickOnAcceptProposedInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnSubmit_ForInspectionDate();
			Thread.sleep(3000);
			tcm.clickOnOK();
			
			
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
		
		
		
	
	
	}	
}
