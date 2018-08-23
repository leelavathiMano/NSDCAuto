package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.TP_AddTrainingCentrePage;
import com.nsdc.pages.TrainingCentre_CAAF_Page;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class TC_CAAFWorkflowTextSC_16 extends TestConfiguration
{
	@DataProvider
	public Object[][] addTrainingCentre()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "AddTrainingCentre_TPSC16TC01");
	}
	
	@Test(dataProvider="addTrainingCentre")
	public void addTrainingCentreTC_01(String tpUsername, String tpPassword, String tcName, String tcAddress, String spocName, String spocEmail, String spocMobileNumber, String tcType, String tcState, String schemeAssociated, String holdingAgency, String recommendationLetter) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		elp.performlogin(tpUsername, tpPassword);
		TrainingPartnerDashboardPage tpdp = new TrainingPartnerDashboardPage(driver);
		Thread.sleep(5000);
		tpdp.clickOnAddATrainingCentre();
		TP_AddTrainingCentrePage tptc = new TP_AddTrainingCentrePage(driver);
		Thread.sleep(3000);
		tptc.enterTrainingCentreName(tcName);
		tptc.enterTrainingCentreAddress(tcAddress);
		tptc.enterNameOfTheSPOC(spocName);
		tptc.enterEmailAddressOfSPOC(spocEmail);
		tptc.enterMobileNumberOfSPOC(spocMobileNumber);
		tptc.selectTrainingCentreType(tcType);
		if(tcType.equals("SCHEME"))
		{
			tptc.selectStateForSchemeTC(tcState);
			tptc.selectSchemeAssociated(schemeAssociated);
			tptc.selectHoldingAgencyAssigned(holdingAgency);
			Thread.sleep(3000);
			tptc.clickOnRecommendationLetter_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(recommendationLetter);
			Thread.sleep(3000);
			tptc.clickOnRecommendationLetter_UploadFile();
			Thread.sleep(3000);
			tptc.clickOnSaveAndNext();
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Training Centre is created successfully')]")).getText(), "Training Centre is created successfully");
		}
		else 
		{
			Thread.sleep(3000);
			tptc.clickOnSaveAndNext();
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Training Centre is created successfully')]")).getText(), "Training Centre is created successfully");
		}
		PostLoginPage plp = new PostLoginPage(driver);
		Thread.sleep(3000);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	@DataProvider
	public Object[][] tc_CAAFRegistrationData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TC_CAAF-Workflow.xls", "TC_CAAFDataSC16TC02");
	}
	
	@Test(dataProvider="tc_CAAFRegistrationData")
	public void tc_CAAFRegistrationTC_02(String tcUsername, String password, String newPassword, String confirmPassword, String tcType, String socialmedia, String websiteurl, String buildingStatus, String buildingConstruction, String transportSystem, String transportName, String buildingFace, String approachRoadWidth, String previousBuildingState, String buildingStateFile, String firstProgramName, String secondProgramName, String thirdProgramName, String spocAltNumber, String centrePrincipalName, String centrePrincipalEmail, String centrePrincipalcontactNumber, String firstAffiliationName, String firstAffiliationType, String firstAboutAffiliation, String secondAffiliationName, String secondAffiliationType, String secondAboutAffiliation, String thirdAffiliationName, String thirdAffiliationType, String thirdAboutAffiliation, String tcAddress, String tcLandmark, String tcPinCode, String tcState, String tcDistrict, String tcTehsil, String tcCity, String tcParliamentry, String tcAddressProof, String addressProofFile, String tcAreaClassificationCentre, String centreAtGroundFloor, String tcTotalArea, String pMKVYCentreId, String skillSector, String skillSubSector, String jobRoleName, String traineeToTrainerRatio, String parallelBatchesNumber, String aboutJobRole, String additionalArea, String additionalCarpetArea, String coveredCarpetArea, String classRoomCarpetArea, String classRoomRemark, String classRoomAvailablity, String laboratoryCarpetArea, String laboratoryType, String laboratoryRemark, String laboratoryAvailablity, String hybridCarpetArea, String hybridLaboratoryType, String hybridRemark, String hybridAvailablity, String trainerSerialNumber, String trainerName, String trainerAdharNumber, String trainerSSCCertified, String trainerHighestQualification, String trianerMinimumQualification, String trainerNIESBUDCertified, String agencyName, String trainerAvailablity, String trainerResourceType, String trainerMobileNumber, String trainerRemark, String trainerRelevantSector, String relevantSectorExperienceInYear, String relevantSectorExperienceInMonths, String secondTrainerRelevantSector, String secondRelevantSectorExperienceInYear, String secondRelevantSectorExperienceInMonths, String teachingRelevantSector, String teachingExperienceInYears, String teachingExperienceInMonths, String secondTeachingRelevantSector, String secondTeachingExperienceInYears, String secondTeachingExperienceInMonths, String trainerAddress, String trainerLandmark, String trainerPinCode, String trainerState, String trainerDistrict, String trainerTehsil, String trainerCity, String trainerParliamentry, String trainerAddressProofType, String trainerAddressProofFile, String quantityAvailable, String equipmentRemark, String secondSkillSector, String secondSkillSubSector, String secondJobRoleName, String classroomSerialNumber, String laboratorySerialNumber, String hybridSerialNumber, String secondAadharNumber, String thirdSkillSector, String thirdSkillSubSector, String thirdJobRoleName, String thirdAadharNumber, String firstCentreAreaType, String firstCentreCarpetArea, String firstCentrWashroomType, String firstCentreAreaRemark, String secondCentreAreaType, String secondCentreCarpetArea, String secondCentreWashroomType, String secondCentreAreaRemark, String thirdCentreAreaType, String thirdCentreCarpetArea, String thirdCentrWashroomType, String thirdCentreAreaRemark, String menResidentialArea, String totalAreaMenResidential, String roomsNumberMenResidential, String residentialCapacityMen, String remarkMenResidential, String womenResidentialArea, String totalAreaWomenResidential, String roomsNumberWomenResidential, String residentialCapacityWomen, String remarkWomenResidential, String fireEquipmentAvailablity, String firstSupportStaffType, String firstSupportStaffName, String firstCentreStaffHighestQualification, String firstResourceType, String firstCentreStaffRemark, String secondSupportStaffType, String secondSupportStaffName, String secondCentreStaffHighestQualification, String secondResourceType, String secondCentreStaffRemark, String thirdSupportStaffType, String thirdSupportStaffName, String thirdCentreStaffHighestQualification, String thirdResourceType, String thirdCentreStaffRemark) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		EnterLoginPage elp = new EnterLoginPage(driver);
		/*elp.performlogin(tcUsername, password);
		Thread.sleep(3000);
		RegistrationPage rp = new RegistrationPage(driver);
		rp.enterOldPassword(password);
		rp.enterNewPassword(newPassword);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickResetResubmit();
		Thread.sleep(3000);
		rp.clickConfirmationOkMessage();*/
		
		elp.performlogin(tcUsername, confirmPassword);
		Thread.sleep(3000);
		TrainingCentre_CAAF_Page caaf = new TrainingCentre_CAAF_Page(driver);
		Thread.sleep(3000);
		caaf.selectTypeOfTrainingCentre(tcType);
		caaf.enterSocialmediaLinks(socialmedia);
		caaf.enterWebsiteUrl(websiteurl);
		caaf.clickOnAllFacilitiesCheckBoxes();
		caaf.selectBuildingStatus(buildingStatus);
		caaf.selectTypeOfBuildingConstruction(buildingConstruction);
		caaf.selectProximityForPublicTransportSystem(transportSystem);
		caaf.enterNearestTransportName(transportName);
		caaf.selectBuildingFrontFace(buildingFace);
		caaf.enterApproachRoadWidth(approachRoadWidth);
		caaf.selectPreviousStateOfBuilding(previousBuildingState);
		Thread.sleep(8000);
		caaf.clickOnBuildingPreviousState_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(buildingStateFile);
		Thread.sleep(3000);
		caaf.clickOnBuildingPreviousState_UploadFile();
		caaf.selectForFirstOfferedProgram(firstProgramName);
		Thread.sleep(2000);
		caaf.clickOnFirstNsqfApproved();
		caaf.clickOnAnotherProgramOffered();
		Thread.sleep(3000);
		caaf.selectForSecondOfferedProgram(secondProgramName);
		caaf.clickOnSecondNsqfApproved();
		caaf.clickOnAnotherProgramOffered();
		Thread.sleep(3000);
		caaf.selectThirdOfferedProgram(thirdProgramName);
		caaf.clickOnThirdNsqfApproved();
		caaf.enterSpocAlternateNumber(spocAltNumber);
		caaf.enterCentrePrincipal_Name(centrePrincipalName);
		caaf.enterCentrePrincipal_EmailAddress(centrePrincipalEmail);
		caaf.enterCentrePrincipal_ContactNumber(centrePrincipalcontactNumber);
		caaf.enterFirst_NameofAffiliation(firstAffiliationName);
		caaf.selectFirst_TypeOfAffiliation(firstAffiliationType);
		caaf.clickOnFirst_ValidityOfAffiliation();
		caaf.enterFirst_BriefAboutTheAffiliation(firstAboutAffiliation);
		Thread.sleep(11000);
		caaf.clickOnAddAnotherAffiliation();
		Thread.sleep(8000);
		caaf.enterSecond_NameofAffiliation(secondAffiliationName);
		caaf.selectSecond_TypeOfAffiliation(secondAffiliationType);
		caaf.clickOnSecond_ValidityOfAffiliation();
		caaf.enterSecond_BriefAboutTheAffiliation(secondAboutAffiliation);
		Thread.sleep(11000);
		caaf.clickOnAddAnotherAffiliation();
		Thread.sleep(8000);
		caaf.enterThird_NameofAffiliation(thirdAffiliationName);
		caaf.selectThird_TypeOfAffiliation(thirdAffiliationType);
		caaf.clickOnThird_ValidityOfAffiliation();
		caaf.enterThird_BriefAboutTheAffiliation(thirdAboutAffiliation);
		caaf.enterTC_Address(tcAddress);
		caaf.enterTC_NearByLandmark(tcLandmark);
		caaf.enterTC_PinCode(tcPinCode);
		caaf.selectTC_State(tcState);
		caaf.selectTC_District(tcDistrict);
		caaf.selectTC_Tehsil(tcTehsil);
		caaf.selectTC_CityOrVillage(tcCity);
		caaf.selectTC_ParliamentryConstituency(tcParliamentry);
		caaf.selectTC_AddressProofType(tcAddressProof);
		Thread.sleep(5000);
		caaf.clickOnTC_AddressProof_BrowseFile();
		Thread.sleep(3000);
		UploadFile.upload(addressProofFile);
		Thread.sleep(3000);
		caaf.clickOnTC_AddresssProof_UploadFile();
		Thread.sleep(3000);
		caaf.selectTCAreaClassificationOfCentre(tcAreaClassificationCentre);
		caaf.selectIsEntireCentreAtGroundFloor(centreAtGroundFloor);
		caaf.enterTotalTCArea(tcTotalArea);
		caaf.enterPMKVYCentreId(pMKVYCentreId);
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		
		caaf.selectSkillSector(skillSector);
		caaf.selectSkillSubSector(skillSubSector);
		caaf.selectForJobRoleName(jobRoleName);
		caaf.selectForTraineeToTrainerRatio(traineeToTrainerRatio);
		caaf.selectParallelBathcesNumber(parallelBatchesNumber);
		caaf.enterBriefAboutJobRole(aboutJobRole);
		caaf.clickOnJobRoleUsingAll();
		//caaf.clickOnClassroom_JobRole();
		//caaf.clickOnLaboratory_JobRole();
		//caaf.clickOnHybrid_JobRole();
		caaf.selectAdditionalAreaRequiredForJobRole(additionalArea);
		if(additionalArea.equals("Yes"))
		{
			caaf.enterAdditionalAreaCarpetArea(additionalCarpetArea);
			caaf.enterAdditionalCoveredCarpetArea(coveredCarpetArea);
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		else 
		{
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		
		
		caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
		caaf.clickOnClassRoomEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterClassRoomRemark(classRoomRemark);
		caaf.selectClassRoomAvailablityForOtherJobRole(classRoomAvailablity);
		caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
		caaf.selectLaboratoryType(laboratoryType);
		caaf.clickOnLaboratoryEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterLaboratoryRemark(laboratoryRemark);
		caaf.selectLaboratoryAvailablityForJobRole(laboratoryAvailablity);
		caaf.enterHybridCarpetArea(hybridCarpetArea);
		caaf.selectHybridLaboratoryType(hybridLaboratoryType);
		caaf.clickOnHybridEquippedwith_ALL();
		Thread.sleep(3000);
		caaf.enterHybridRemark(hybridRemark);
		caaf.selectHybridAvailableForOtherJobRole(hybridAvailablity);
		Thread.sleep(5000);
		caaf.clickOnNext();
		
		caaf.selectTrainerSerialNumber(trainerSerialNumber);
		if(trainerSerialNumber.equals("Create New Trainer"))
		{
			caaf.enterTrainerName(trainerName);
			Thread.sleep(3000);
			caaf.enterTrainerAadharNumber(trainerAdharNumber);
			caaf.clickOnVerifyAadharNumber();
			caaf.selectTrainerCertifiedBySSC(trainerSSCCertified);
			caaf.selectTrainerHighestQualification(trainerHighestQualification);
			caaf.selectTrainerMinimumQualification(trianerMinimumQualification);
			caaf.selectIsTrainerNIESBUDCertified(trainerNIESBUDCertified);
			caaf.enterTrainerAgencyName(agencyName);
			caaf.selectTrainerAvailablity(trainerAvailablity);
			caaf.selectTrainerResourceType(trainerResourceType);
			caaf.enterTrainerMobileNumber(trainerMobileNumber);
			caaf.enterTrainersRemark(trainerRemark);
			caaf.selectTrainerRelevantSector(trainerRelevantSector);
			caaf.selectTrainerRelevantExperienceInYear(relevantSectorExperienceInYear);
			caaf.selectTrainerRelevantSectorExperienceInMonths(relevantSectorExperienceInMonths);
			caaf.clickforAddRelevantSectorExperience();
			caaf.selectTrainerRelevantSector(secondTrainerRelevantSector);
			caaf.selectTrainerRelevantExperienceInYear(secondRelevantSectorExperienceInYear);
			caaf.selectTrainerRelevantSectorExperienceInMonths(secondRelevantSectorExperienceInMonths);
			caaf.clickforAddRelevantSectorExperience();
			caaf.selectTeachingRelevantSectorExperience(teachingRelevantSector);
			caaf.selectTeachingExperienceInYears(teachingExperienceInYears);
			caaf.selectTeachingExperienceInMonths(teachingExperienceInMonths);
			caaf.clickOnAddforTeachingIndustrialExperience();
			caaf.selectTeachingRelevantSectorExperience(secondTeachingRelevantSector);
			caaf.selectTeachingExperienceInYears(secondTeachingExperienceInYears);
			caaf.selectTeachingExperienceInMonths(secondTeachingExperienceInMonths);
			caaf.clickOnAddforTeachingIndustrialExperience();
			caaf.enterTrainerAddress(trainerAddress);
			caaf.enterTrainerNearbyLandmark(trainerLandmark);
			caaf.enterTrianerPinCode(trainerPinCode);
			caaf.selectTrainerState(trainerState);
			caaf.selectTrainerDistrict(trainerDistrict);
			caaf.selectTrainerTehsil(trainerTehsil);
			caaf.selectTrainerCityOrVillage(trainerCity);
			caaf.selectTrainerParliamentryConstituency(trainerParliamentry);
			caaf.selectTrainersAddressProofType(trainerAddressProofType);
			Thread.sleep(3000);
			caaf.clickOnTrainerAddressProof_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(trainerAddressProofFile);
			Thread.sleep(3000);
			caaf.clickOnTrainerAddressProof_UploadFile();
			if((skillSector.equals("Agriculture")) && (skillSubSector.equals("Farm Machinery")) && (jobRoleName.equals("QP name 31")))
			{
				Thread.sleep(3000);
				caaf.enterEquipmentAvailableQuantity(quantityAvailable);
				caaf.enterEquipmentRemark(equipmentRemark);
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
			else
			{
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
		}
		else 
		{
			Thread.sleep(3000);
			caaf.clickOnDownloadAddressProof();
			if((secondSkillSector.equals("Agriculture")) && (secondSkillSubSector.equals("Farm Machinery")) && (secondJobRoleName.equals("QP name 31")))
			{
				caaf.enterEquipmentAvailableQuantity(quantityAvailable);
				caaf.enterEquipmentRemark(equipmentRemark);
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}	
			else 
			{
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
		}
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+jobRoleName+"')]")).getText(), jobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+skillSector+"')]")).getText(), skillSector);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+skillSubSector+"')]")).getText(), skillSubSector);
		Thread.sleep(3000);
		caaf.clickOnAddMoreJobRole();
		
		caaf.selectSkillSector(secondSkillSector);
		caaf.selectSkillSubSector(secondSkillSubSector);
		caaf.selectForJobRoleName(secondJobRoleName);
		caaf.selectForTraineeToTrainerRatio(traineeToTrainerRatio);
		caaf.selectParallelBathcesNumber(parallelBatchesNumber);
		caaf.enterBriefAboutJobRole(aboutJobRole);
		caaf.clickOnJobRoleUsingAll();
		//caaf.clickOnClassroom_JobRole();
		//caaf.clickOnLaboratory_JobRole();
		//caaf.clickOnHybrid_JobRole();
		caaf.selectAdditionalAreaRequiredForJobRole(additionalArea);
		if(additionalArea.equals("Yes"))
		{
			caaf.enterAdditionalAreaCarpetArea(additionalCarpetArea);
			caaf.enterAdditionalCoveredCarpetArea(coveredCarpetArea);
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		else
		{
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		
		caaf.selectClassRoomSerialNumber(classroomSerialNumber);
		if(classroomSerialNumber.equals("Create New ClassRoom"))
		{
			caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
			caaf.clickOnClassRoomEquippedwith_ALL();
			Thread.sleep(3000);
			caaf.enterClassRoomRemark(classRoomRemark);
			caaf.selectClassRoomAvailablityForOtherJobRole(classRoomAvailablity);
			caaf.selectLaboratorySerialNumber(laboratorySerialNumber);
		}
		else
		{
			caaf.selectLaboratorySerialNumber(laboratorySerialNumber);
		}
		
		if(laboratorySerialNumber.equals("Create New Laboratory"))
		{
			caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
			caaf.selectLaboratoryType(laboratoryType);
			caaf.clickOnLaboratoryEquippedwith_ALL();
			Thread.sleep(3000);
			caaf.enterLaboratoryRemark(laboratoryRemark);
			caaf.selectLaboratoryAvailablityForJobRole(laboratoryAvailablity);
			caaf.selectHybridSerialNumber(hybridSerialNumber);
		}
		else
		{
			caaf.selectHybridSerialNumber(hybridSerialNumber);
		}
		
		if(hybridSerialNumber.equals("Create New Hybrid"))
		{
			caaf.enterHybridCarpetArea(hybridCarpetArea);
			caaf.selectHybridLaboratoryType(hybridLaboratoryType);
			caaf.clickOnHybridEquippedwith_ALL();
			Thread.sleep(3000);
			caaf.enterHybridRemark(hybridRemark);
			caaf.selectHybridAvailableForOtherJobRole(hybridAvailablity);
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		else
		{
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		caaf.selectTrainerSerialNumber(trainerSerialNumber);
		if(trainerSerialNumber.equals("Create New Trainer"))
		{
			caaf.enterTrainerName(trainerName);
			caaf.enterTrainerAadharNumber(secondAadharNumber);
			caaf.clickOnVerifyAadharNumber();
			caaf.selectTrainerCertifiedBySSC(trainerSSCCertified);
			caaf.selectTrainerHighestQualification(trainerHighestQualification);
			caaf.selectTrainerMinimumQualification(trianerMinimumQualification);
			caaf.selectIsTrainerNIESBUDCertified(trainerNIESBUDCertified);
			caaf.enterTrainerAgencyName(agencyName);
			caaf.selectTrainerAvailablity(trainerAvailablity);
			caaf.selectTrainerResourceType(trainerResourceType);
			caaf.enterTrainerMobileNumber(trainerMobileNumber);
			caaf.enterTrainersRemark(trainerRemark);
			caaf.selectTrainerRelevantSector(trainerRelevantSector);
			caaf.selectTrainerRelevantExperienceInYear(relevantSectorExperienceInYear);
			caaf.selectTrainerRelevantSectorExperienceInMonths(relevantSectorExperienceInMonths);
			caaf.clickforAddRelevantSectorExperience();
			caaf.selectTrainerRelevantSector(secondTrainerRelevantSector);
			caaf.selectTrainerRelevantExperienceInYear(secondRelevantSectorExperienceInYear);
			caaf.selectTrainerRelevantSectorExperienceInMonths(secondRelevantSectorExperienceInMonths);
			caaf.clickforAddRelevantSectorExperience();
			caaf.selectTeachingRelevantSectorExperience(teachingRelevantSector);
			caaf.selectTeachingExperienceInYears(teachingExperienceInYears);
			caaf.selectTeachingExperienceInMonths(teachingExperienceInMonths);
			caaf.clickOnAddforTeachingIndustrialExperience();
			caaf.selectTeachingRelevantSectorExperience(secondTeachingRelevantSector);
			caaf.selectTeachingExperienceInYears(secondTeachingExperienceInYears);
			caaf.selectTeachingExperienceInMonths(secondTeachingExperienceInMonths);
			caaf.clickOnAddforTeachingIndustrialExperience();
			caaf.enterTrainerAddress(trainerAddress);
			caaf.enterTrainerNearbyLandmark(trainerLandmark);
			caaf.enterTrianerPinCode(trainerPinCode);
			caaf.selectTrainerState(trainerState);
			caaf.selectTrainerDistrict(trainerDistrict);
			caaf.selectTrainerTehsil(trainerTehsil);
			caaf.selectTrainerCityOrVillage(trainerCity);
			caaf.selectTrainerParliamentryConstituency(trainerParliamentry);
			caaf.selectTrainersAddressProofType(trainerAddressProofType);
			Thread.sleep(3000);
			caaf.clickOnTrainerAddressProof_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(trainerAddressProofFile);
			Thread.sleep(3000);
			caaf.clickOnTrainerAddressProof_UploadFile();
			if((secondSkillSector.equals("Agriculture")) && (secondSkillSubSector.equals("Farm Machinery")) && (secondJobRoleName.equals("QP name 31")))
			{
				Thread.sleep(3000);
				caaf.enterEquipmentAvailableQuantity(quantityAvailable);
				caaf.enterEquipmentRemark(equipmentRemark);
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
			else 
			{
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
		}
		else 
		{
			Thread.sleep(3000);
			caaf.clickOnDownloadAddressProof();
			if((secondSkillSector.equals("Agriculture")) && (secondSkillSubSector.equals("Farm Machinery")) && (secondJobRoleName.equals("QP name 31")))
			{
				caaf.enterEquipmentAvailableQuantity(quantityAvailable);
				caaf.enterEquipmentRemark(equipmentRemark);
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}	
			else 
			{
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
		}
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+secondJobRoleName+"')]")).getText(), secondJobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+secondSkillSector+"')]")).getText(), secondSkillSector);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+secondSkillSubSector+"')]")).getText(), secondSkillSubSector);
		Thread.sleep(3000);
		caaf.clickOnAddMoreJobRole();
		
		caaf.selectSkillSector(thirdSkillSector);
		caaf.selectSkillSubSector(thirdSkillSubSector);
		caaf.selectForJobRoleName(thirdJobRoleName);
		caaf.selectForTraineeToTrainerRatio(traineeToTrainerRatio);
		caaf.selectParallelBathcesNumber(parallelBatchesNumber);
		caaf.enterBriefAboutJobRole(aboutJobRole);
		caaf.clickOnJobRoleUsingAll();
		//caaf.clickOnClassroom_JobRole();
		//caaf.clickOnLaboratory_JobRole();
		//caaf.clickOnHybrid_JobRole();
		caaf.selectAdditionalAreaRequiredForJobRole(additionalArea);
		if(additionalArea.equals("Yes"))
		{
			caaf.enterAdditionalAreaCarpetArea(additionalCarpetArea);
			caaf.enterAdditionalCoveredCarpetArea(coveredCarpetArea);
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		else 
		{
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		
		
		caaf.selectClassRoomSerialNumber(classroomSerialNumber);
		if(classroomSerialNumber.equals("Create New ClassRoom"))
		{
			caaf.enterClassRoomCarpetArea(classRoomCarpetArea);
			caaf.clickOnClassRoomEquippedwith_ALL();
			Thread.sleep(3000);
			caaf.enterClassRoomRemark(classRoomRemark);
			caaf.selectClassRoomAvailablityForOtherJobRole(classRoomAvailablity);
			caaf.selectLaboratorySerialNumber(laboratorySerialNumber);
			
		}
		else 
		{
			caaf.selectLaboratorySerialNumber(laboratorySerialNumber);
		}
		if(laboratorySerialNumber.equals("Create New Laboratory"))
		{
			caaf.enterLaboratoryCarpetArea(laboratoryCarpetArea);
			caaf.selectLaboratoryType(laboratoryType);
			caaf.clickOnLaboratoryEquippedwith_ALL();
			Thread.sleep(3000);
			caaf.enterLaboratoryRemark(laboratoryRemark);
			caaf.selectLaboratoryAvailablityForJobRole(laboratoryAvailablity);
			caaf.selectHybridSerialNumber(hybridSerialNumber);
		}
		else 
		{
			caaf.selectHybridSerialNumber(hybridSerialNumber);
		}
		
		if(hybridSerialNumber.equals("Create New Hybrid"))
		{
			caaf.enterHybridCarpetArea(hybridCarpetArea);
			caaf.selectHybridLaboratoryType(hybridLaboratoryType);
			caaf.clickOnHybridEquippedwith_ALL();
			Thread.sleep(3000);
			caaf.enterHybridRemark(hybridRemark);
			caaf.selectHybridAvailableForOtherJobRole(hybridAvailablity);
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		else 
		{
			Thread.sleep(3000);
			caaf.clickOnNext();
		}
		
		caaf.selectTrainerSerialNumber(trainerSerialNumber);
		if(trainerSerialNumber.equals("Create New Trainer"))
		{
			caaf.enterTrainerName(trainerName);
			caaf.enterTrainerAadharNumber(thirdAadharNumber);
			caaf.clickOnVerifyAadharNumber();
			caaf.selectTrainerCertifiedBySSC(trainerSSCCertified);
			caaf.selectTrainerHighestQualification(trainerHighestQualification);
			caaf.selectTrainerMinimumQualification(trianerMinimumQualification);
			caaf.selectIsTrainerNIESBUDCertified(trainerNIESBUDCertified);
			caaf.enterTrainerAgencyName(agencyName);
			caaf.selectTrainerAvailablity(trainerAvailablity);
			caaf.selectTrainerResourceType(trainerResourceType);
			caaf.enterTrainerMobileNumber(trainerMobileNumber);
			caaf.enterTrainersRemark(trainerRemark);
			caaf.selectTrainerRelevantSector(trainerRelevantSector);
			caaf.selectTrainerRelevantExperienceInYear(relevantSectorExperienceInYear);
			caaf.selectTrainerRelevantSectorExperienceInMonths(relevantSectorExperienceInMonths);
			caaf.clickforAddRelevantSectorExperience();
			caaf.selectTrainerRelevantSector(secondTrainerRelevantSector);
			caaf.selectTrainerRelevantExperienceInYear(secondRelevantSectorExperienceInYear);
			caaf.selectTrainerRelevantSectorExperienceInMonths(secondRelevantSectorExperienceInMonths);
			caaf.clickforAddRelevantSectorExperience();
			caaf.selectTeachingRelevantSectorExperience(teachingRelevantSector);
			caaf.selectTeachingExperienceInYears(teachingExperienceInYears);
			caaf.selectTeachingExperienceInMonths(teachingExperienceInMonths);
			caaf.clickOnAddforTeachingIndustrialExperience();
			caaf.selectTeachingRelevantSectorExperience(secondTeachingRelevantSector);
			caaf.selectTeachingExperienceInYears(secondTeachingExperienceInYears);
			caaf.selectTeachingExperienceInMonths(secondTeachingExperienceInMonths);
			caaf.clickOnAddforTeachingIndustrialExperience();
			caaf.enterTrainerAddress(trainerAddress);
			caaf.enterTrainerNearbyLandmark(trainerLandmark);
			caaf.enterTrianerPinCode(trainerPinCode);
			caaf.selectTrainerState(trainerState);
			caaf.selectTrainerDistrict(trainerDistrict);
			caaf.selectTrainerTehsil(trainerTehsil);
			caaf.selectTrainerCityOrVillage(trainerCity);
			caaf.selectTrainerParliamentryConstituency(trainerParliamentry);
			caaf.selectTrainersAddressProofType(trainerAddressProofType);
			Thread.sleep(3000);
			caaf.clickOnTrainerAddressProof_BrowseFile();
			Thread.sleep(3000);
			UploadFile.upload(trainerAddressProofFile);
			Thread.sleep(3000);
			caaf.clickOnTrainerAddressProof_UploadFile();
			if((thirdSkillSector.equals("Agriculture")) && (thirdSkillSubSector.equals("Farm Machinery")) && (thirdJobRoleName.equals("QP name 31")))
			{
				Thread.sleep(3000);
				caaf.enterEquipmentAvailableQuantity(quantityAvailable);
				caaf.enterEquipmentRemark(equipmentRemark);
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
			else
			{
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
		}
		else 
		{
			Thread.sleep(3000);
			caaf.clickOnDownloadAddressProof();
			if((secondSkillSector.equals("Agriculture")) && (secondSkillSubSector.equals("Farm Machinery")) && (secondJobRoleName.equals("QP name 31")))
			{
				caaf.enterEquipmentAvailableQuantity(quantityAvailable);
				caaf.enterEquipmentRemark(equipmentRemark);
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}	
			else 
			{
				Thread.sleep(3000);
				caaf.clickOnSaveAndNext();
			}
		}
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+thirdJobRoleName+"')]")).getText(), thirdJobRoleName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+thirdSkillSector+"')]")).getText(), thirdSkillSector);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+thirdSkillSubSector+"')]")).getText(), thirdSkillSubSector);
		Thread.sleep(3000);
		caaf.clickOnProceed();
		
		caaf.selectFirst_TypeOfCentreArea(firstCentreAreaType);
		caaf.enterFirst_CarpetAreaforCentre(firstCentreCarpetArea);
		caaf.selectFirst_TypeOfCentreWashRoom(firstCentrWashroomType);
		caaf.clickOnFirstCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enterFirst_CentreAreaRemark(firstCentreAreaRemark);
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickForAddAnotherCentreType();
		Thread.sleep(3000);
		caaf.selectSecond_TypeOfCentreArea(secondCentreAreaType);
		caaf.enterSecond_CarpetAreaforCentre(secondCentreCarpetArea);
		caaf.selectSecond_TypeOfCentreWashRoom(secondCentreWashroomType);
		caaf.clickOnSecondCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enterSecond_CentreAreaRemark(secondCentreAreaRemark);
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickForAddAnotherCentreType();
		caaf.selectThird_TypeOfCentreArea(thirdCentreAreaType);
		caaf.enterThird_CarpetAreaforCentre(thirdCentreCarpetArea);
		caaf.selectThird_TypeOfCentreWashRoom(thirdCentrWashroomType);
		caaf.clickOnThirdCentreArea_EquippedWithAll();
		Thread.sleep(3000);
		caaf.enterThird_CentreAreaRemark(thirdCentreAreaRemark);
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickForCentreAreaSaveAndContinue();
		
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
			caaf.clickOnSaveAndNext();
		}
		else 
		{
			Thread.sleep(3000);
			caaf.clickOnSaveAndNext();
		}
		
		Thread.sleep(3000);
		caaf.clickOnDiffrentlyAbled_AllFacilities();
		Thread.sleep(3000);
		caaf.clickOnAllFacilities_MaintainingHygieneAndSanitation();
		Thread.sleep(3000);
		caaf.selectforFireFightingEquipmentAvailablity(fireEquipmentAvailablity);
		Thread.sleep(3000);
		caaf.clickOnAllFacilities_ForMedicalAndSafety();
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		
		caaf.selectFirst_TypeOfSupportStaff(firstSupportStaffType);
		caaf.enterFirst_NameOfSupportStaff(firstSupportStaffName);
		caaf.selectFirst_HighestQualificationForCentreStaff(firstCentreStaffHighestQualification);
		caaf.selectFirst_ResourceTypeOfCentreStaff(firstResourceType);
		caaf.enterFirst_RemarkForCentreStaff(firstCentreStaffRemark);
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickForAddAnotherCentreStaff();
		caaf.selectSecond_TypeOfSupportStaff(secondSupportStaffType);
		caaf.enterSecond_NameOfSupportStaff(secondSupportStaffName);
		caaf.selectSecond_HighestQualificationForCentreStaff(secondCentreStaffHighestQualification);
		caaf.selectSecond_ResourceTypeOfCentreStaff(secondResourceType);
		caaf.enterSecond_RemarkForCentreStaff(secondCentreStaffRemark);
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickForAddAnotherCentreStaff();
		caaf.selectThird_TypeOfSupportStaff(thirdSupportStaffType);
		caaf.enterThird_NameOfSupportStaff(thirdSupportStaffName);
		caaf.selectThird_HighestQualificationForCentreStaff(thirdCentreStaffHighestQualification);
		caaf.selectThird_ResourceTypeOfCentreStaff(thirdResourceType);
		caaf.enterThird_RemarkForCentreStaff(thirdCentreStaffRemark);
		Thread.sleep(3000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickForSaveAndContinueForCentreStaff();
		
		Thread.sleep(5000);
		caaf.clickOnSaveAndNext();
		Thread.sleep(3000);
		caaf.clickOnSaveAndContinueToPayment();
		Thread.sleep(3000);
		caaf.clickOnOK();
		Thread.sleep(5000);
		caaf.clickOnLogOut();
		
		
		
	}

}
