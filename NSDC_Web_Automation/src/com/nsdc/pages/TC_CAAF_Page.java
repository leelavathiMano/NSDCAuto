package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nsdc.generic.SelectDropDownList;
import com.sun.org.apache.bcel.internal.generic.Select;

public class TC_CAAF_Page 

	{
		WebDriver driver;

		@FindBy(xpath="(//input[@ng-reflect-name='name'])[1]")
		private WebElement tpnameTextbox;
		@FindBy(xpath="//input[@ng-reflect-name='trainingCentreName']")
		private WebElement tcnameTextbox;
		@FindBy(xpath="//select[@ng-reflect-name='name']")
		private WebElement tcDropDownList;
		@FindBy(xpath="//input[@formcontrolname='socialMediaLink']")
		private WebElement socialmediaTextbox;
		@FindBy(xpath="//input[@ng-reflect-name='websiteURL']")
		private WebElement websiteTextbox;
		@FindBy(xpath="//select[@formcontrolname='buildingStatus']")
		private WebElement buildingstatusDropDownList;
		@FindBy(xpath="//select[@formcontrolname='buildingConstrictionType']")
		private WebElement buildingconstructionDropDownList;
		@FindBy(xpath="//select[@formcontrolname='proximityTOPublicTransportSystem']")
		private WebElement transportsystemDropDownList;
		@FindBy(xpath="//input[@formcontrolname='nearestTransportName']")
		private WebElement transportnameTextbox;
		@FindBy(xpath="//select[@formcontrolname='frontFaceOfBuilding']")
		private WebElement buildingfaceDropDownList;
		@FindBy (xpath="//input[@formcontrolname='approachRoadToCentreWidth']")
		private WebElement approachroadwidthTextbox;
		@FindBy(xpath="//select[@formcontrolname='previousStateOfBuilding']")
		private WebElement buildingstateDropDownList;
		@FindBy (xpath="(//div[input[@id='customFile']]/label)[1]")
		private WebElement buildingstate_BrowseFileButton;
		@FindBy (xpath="(//button[@class='btn btn-outline-success'])[1]")
		private WebElement buildingstate_UploadButton;
		@FindBy(xpath="//label[input[@ng-reflect-name='securityGaurds']]/span")
		private WebElement  facility_securityguardCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='tcWellPlasteredAndCondition']]/span")
		private WebElement facility_wellconditionCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='biometricAttendanceSystem']]/span")
		private WebElement facility_biometricCeckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='tcWallsAndRoofTinCondition']]/span")
		private WebElement facility_wallsandroofconditionCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='greeneryInTheSurrounding']]/span")
		private WebElement facility_greeneryCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='centreFloorCementenAndFurnishe']]/span")
		private WebElement facility_centrefloorconditionCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='centreFloorIsTiled']]/span")
		private WebElement facility_centrefloortiledCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='internetAvailibility']]/span")
		private WebElement facility_internetCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='adequatePowerBackup']]/span")
		private WebElement facility_powerbackupCheckBox;
		@FindBy(xpath="//label[input[@ng-reflect-name='isTrainingCentreFunctional']]/span")
		private WebElement facility_tcfunctionCheckBox;
		@FindBy(xpath="//select[@formcontrolname='programName']")
		private WebElement programDropDownList;
		@FindBy(xpath="//label[input[@formcontrolname='nsqfApproved']]/span")
		private WebElement nsqfCheckBox;
		@FindBy(xpath="//button[@class='btn btn-outline-info']")
		private WebElement clickToAnotherProgramOfferedButton;
		@FindBy(xpath="(//select[@formcontrolname='programName'])[1]")
		private WebElement degreeDropDownList;
		@FindBy(xpath="//label[input[@formcontrolname='nsqfApproved']]/span")
		private WebElement degreeNsqfCheckBox;
		@FindBy(xpath="(//select[@formcontrolname='programName'])[2]")
		private WebElement vocationalDropDownList;
		@FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[2]")
		private WebElement vocationalNsqfcheckBox;
		@FindBy(xpath="(//select[@formcontrolname='programName'])[3]")
		private WebElement privateDropDownList;
		@FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[3]")
		private WebElement privateNsqfCheckBox;
		@FindBy(xpath="(//select[@formcontrolname='programName'])[4]")
		private WebElement othersProgramDropDownList;
		@FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[4]")
		private WebElement othersNsqfCheckBox;
		@FindBy(xpath="//input[@formcontrolname='firstName']")
		private WebElement spocnameTextbox;
		@FindBy(xpath="(//input[@ng-reflect-name='email'])[1]")
		private WebElement spocemailTextbox;
		@FindBy(xpath="//input[@ng-reflect-name='mobileNumber']")
		private WebElement spocmobileNumberTextbox;
		@FindBy(xpath="//input[@ng-reflect-name='altNumber']")
		private WebElement spocaltNumberTextbox;
		@FindBy(xpath="(//input[@ng-reflect-name='name'])[2]")
		private WebElement centrePrincipalNameTextbox;
		@FindBy(xpath="(//input[@formcontrolname='email'])[2]")
		private WebElement centrePrincipalEmailTextBox;
		@FindBy(xpath="//input[@formcontrolname='contactNo']")
		private WebElement centrePrincipalContactNumberTextbox;
		@FindBy(xpath="//input[@placeholder='Enter the Name of the Affiliation']")
		private WebElement affiliationNameTextbox;
		@FindBy(xpath="(//select[@formcontrolname='type'])[1]")
		private WebElement affiliationTypeDropDownList;
		@FindBy(xpath="//input[@name='reviewDate']")
		private WebElement affiliationValidityTextbox;
		@FindBy(xpath="//div[input[@name='reviewDate']]/div/span/i")
		private WebElement affiliationCalenderButton;
		@FindBy(xpath="//textarea[@formcontrolname='breifDetails']")
		private WebElement aboutAffiliationTextbox;
		@FindBy(xpath="//textarea[@formcontrolname='addressLine']")
		private WebElement tcOrganizationAddressTextbox;
		@FindBy(xpath="//input[@id='search_places']")
		private WebElement tcgeoLocationTextbox;
		@FindBy(xpath="//input[@formcontrolname='landmark']")
		private WebElement tclandmarkTextbox;
		@FindBy(xpath="//input[@formcontrolname='pincode']")
		private WebElement tcPinCodeTextbox;
		@FindBy(xpath="//select[@name='state']")
		private WebElement tcStateDropDownList;
		@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[2]")
		private WebElement tcDistrictDropDownList;
		@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[3]")
		private WebElement tcTehsilDropDownList;
		@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[4]")
		private WebElement tcParliamentryDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='type'])[2]")
		private WebElement tcAddressproofDropDownList;
		@FindBy(xpath="(//div[input[@id='customFile']]/label)[5]")
		private WebElement tcAddressProof_BrowseFileButton;
		@FindBy(xpath="(//button[@class='btn btn-outline-success'])[2]")
		private WebElement tcAddressProof_UploadFileButton;
		@FindBy(xpath="//select[@formcontrolname='areaClassificationCentre']")
		private WebElement tcAreaClassificationCentreDropDownList;
		@FindBy(xpath="//select[@formcontrolname='isCenterAtGroundFloor']")
		private WebElement entireCentreatGroundFloorDropDownList;
		@FindBy(xpath="//input[@formcontrolname='totalTrainingCentreArea']")
		private WebElement totalTcAreaTextbox;
		@FindBy(xpath="//input[@formcontrolname='pmkvyCenterID']")
		private WebElement pMKVYCentreIdTextbox;
		@FindBy(xpath="//button[@class='btn btn-next']")
		private WebElement savendNextButton;
		@FindBy(xpath="//button[@class='btn btn-outline-info ']")
		private WebElement saveasDraftButton;
		
		@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[1]")
		private WebElement skillSectorDropDownList;
		@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[2]")
		private WebElement skillSubSectorDropDownList;
		@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[3]")
		private WebElement jobRoleNameDropDownList;
		@FindBy(xpath="//select[@formcontrolname='trainerToTraineeRatio']")
		private WebElement traineeToTrainerRatioDropDownList;
		@FindBy(xpath="//select[@formcontrolname='parallelBranchesInADay']")
		private WebElement parallelBathcesNumberDropDownList;
		@FindBy(xpath="//textarea[@formcontrolname='jobDescription']")
		private WebElement jobRoleTextbox;
		@FindBy(xpath="//label[input[@formcontrolname='classroom']]/span")
		private WebElement classroomCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='laboratory']]/span")
		private WebElement laboratoryCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='hybrid']]/span")
		private WebElement hybridCheckBox;
		@FindBy(xpath="//select[@formcontrolname='infrastructureNeeded']")
		private WebElement additionalAreaRequiredDropDownList;
		@FindBy(xpath="//input[@formcontrolname='carpetArea']")
		private WebElement additionalCarpetAreaTextbox;
		
		@FindBy(xpath="(//select[@formcontrolname='serialNumber'])[1]")
		private WebElement classroomserialNumberDropDownList;
		@FindBy(xpath="(//input[@formcontrolname='carpetArea'])[1]")
		private WebElement classroomCarpetAreaTextbox;
		@FindBy(xpath="(//label[input[@formcontrolname='projector']]/span)[1]")
		private WebElement classRoomProjectorCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='airConditioner']]/span)[1]")
		private WebElement classRoomAirConditionerCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='cctv']]/span)[1]")
		private WebElement classRoomCCTVCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='adequateLight']]/span)[1]")
		private WebElement classRoomAdequateLightCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='exhaustFan']]/span)[1]")
		private WebElement classRoomExhaustFanCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='securedElectricWiresAndSwitchBoard']]/span)[1]")
		private WebElement classRoomSecuredElectricWireCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='roomWellVentilated']]/span)[1]")
		private WebElement classRoomWellVantilatedCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='dusibinAvailibility']]/span)[1]")
		private WebElement classRoomAvailablityOfDustbinCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='cleanAndHygienic']]/span)[1]")
		private WebElement classRoomCleanNdHygenicCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='availabilityOfEmergencyContact']]/span)[1]")
		private WebElement classRoomEmergencyNumberDisplayedCheckBox;
		@FindBy(xpath="(//textarea[@formcontrolname='remarks'])[1]")
		private WebElement classRoomRemarkTextbox;
		@FindBy(xpath="(//select[@formcontrolname='jobRoleName'])[1]")
		private WebElement classRoomavailablityforJobRoleDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='serialNumber'])[2]")
		private WebElement laboratorySerialNumberDropDownList;
		@FindBy(xpath="(//input[@formcontrolname='carpetArea'])[2]")
		private WebElement laboratoryCarpetAreaTextbox;
		@FindBy(xpath="//select[@formcontrolname='type']")
		private WebElement laboratoryTypeDropDownList;
		@FindBy(xpath="(//label[input[@formcontrolname='projector']]/span)[2]")
		private WebElement laboratoryProjectorCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='airConditioner']]/span)[2]")
		private WebElement laboratoryAirConditionerCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='cctv']]/span)[2]")
		private WebElement laboratoryCCTVCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='adequateLight']]/span)[2]")
		private WebElement laboratoryAdequateLightCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='exhaustFan']]/span)[2]")
		private WebElement laboratoryExhaustFanCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='securedElectricWiresAndSwitchBoard']]/span)[2]")
		private WebElement laboratorySecuredElectricWireCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='roomWellVentilated']]/span)[2]")
		private WebElement laboratoryWellVantilatedCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='dusibinAvailibility']]/span)[2]")
		private WebElement laboratoryAvailablityOfDustbinCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='cleanAndHygienic']]/span)[2]")
		private WebElement laboratoryCleanNdHygenicCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='availabilityOfEmergencyContact']]/span)[2]")
		private WebElement laboratoryEmergencyNumberDisplayedCheckBox;
		@FindBy(xpath="(//textarea[@id='m_autosize_1'])[2]")
		private WebElement laboratoryRemarkTextbox;
		@FindBy(xpath="(//select[@formcontrolname='jobRoleName'])[2]")
		private WebElement laboratoryAvailablityforJobRoleDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='serialNumber'])[3]")
		private WebElement hybridSerialNumberDropDownList;
		@FindBy(xpath="(//input[@formcontrolname='carpetArea'])[3]")
		private WebElement hybridCarpetAreaTextbox;
		@FindBy(xpath="//select[@formcontrolname='laboratoryTypeIncluded']")
		private WebElement hybridLaboratoryTypeDropDownList;
		@FindBy(xpath="(//label[input[@formcontrolname='projector']]/span)[3]")
		private WebElement hybridProjectorCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='airConditioner']]/span)[3]")
		private WebElement hybridAirConditionerCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='cctv']]/span)[3]")
		private WebElement hybridCCTVCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='adequateLight']]/span)[3]")
		private WebElement hybridAdequateLightCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='exhaustFan']]/span)[3]")
		private WebElement hybridExhaustFanCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='securedElectricWiresAndSwitchBoard']]/span)[3]")
		private WebElement hybridSecuredElectricWireCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='roomWellVentilated']]/span)[3]")
		private WebElement hybridWellVantilatedCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='dusibinAvailibility']]/span)[3]")
		private WebElement hybridAvailablityOfDustbinCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='cleanAndHygienic']]/span)[3]")
		private WebElement hybridCleanNdHygenicCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='availabilityOfEmergencyContact']]/span)[3]")
		private WebElement hybridEmergencyNumberDisplayedCheckBox;
		@FindBy(xpath="(//textarea[@formcontrolname='remarks'])[3]")
		private WebElement hybridRemarkTextbox;
		@FindBy(xpath="(//select[@formcontrolname='jobRoleName'])[3]")
		private WebElement hybridAvailablityforJobRoleDropDownList;
		
		@FindBy(xpath="//select[@formcontrolname='userName']")
		private WebElement trainerSerialNumberDropDownList;
		@FindBy(xpath="//input[@formcontrolname='name']")
		private WebElement trainerNameTextbox;
		@FindBy(xpath="//input[@formcontrolname='value']")
		private WebElement trainerAdharNumberTextbox;
		@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[2]")
		private WebElement trainerSSCCertifiedDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='education'])[1]")
		private WebElement trainerHighestQualificationDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='education'])[2]")
		private WebElement trainerMinimumQualificationDropDownList;
		@FindBy(xpath="//select[@formcontrolname='isCertified']")
		private WebElement trainerNIESBUDCertifiedDropDownList;
		@FindBy(xpath="//input[@formcontrolname='agencyName']")
		private WebElement trainerAgencyNameTextbox;
		@FindBy(xpath="//select[@formcontrolname='availability']")
		private WebElement trainerAvailablityDropDownList;
		@FindBy(xpath="//select[@formcontrolname='resourcetype']")
		private WebElement trainerResourceTypeDropDownList;
		@FindBy(xpath="//input[@formcontrolname='phone']")
		private WebElement trainerMobileNumberTextbox;
		@FindBy(xpath="(//select[@formcontrolname='sector'])[1]")
		private WebElement trainerrelevantSectorDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='years'])[1]")
		private WebElement 	trainerRelevantSectorExperienceInYearDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='months'])[1]")
		private WebElement trainerRelevantSectorExperienceInMonthsDropDownList;
		@FindBy(xpath="(//input[@id='customFile'])[1]")
		private WebElement relevantSectorExperience_BrowseButton;
		@FindBy(xpath="//button[@class='btn btn-outline-success']")
		private WebElement relevantSectorExperience_UploadButton;
		@FindBy(xpath="//button[text()='Add Sector Related Experience']")
		private WebElement relevantSectorExperience_AddButton;
		@FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[1]")
		private WebElement relevantSectorExperiencefirst_DeleteButton;
		@FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[2]")
		private WebElement relevantSectorExperienceSecond_DeleteButton;
		@FindBy(xpath="(//select[@formcontrolname='sector'])[2]")
		private WebElement teachingRelevantSectorDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='years'])[2]")
		private WebElement year_TeachingExperienceDropDownList;
		@FindBy(xpath="(//select[@formcontrolname='months'])[2]")
		private WebElement month_TeachingExperienceDropDownList;
		@FindBy(xpath="(//input[@id='customFile'])[2]")
		private WebElement teachingExperience_BrowseFileButton;
		@FindBy(xpath="(//button[@class='btn btn-outline-success'])[2]")
		private WebElement teachingExperience_UploadButton;
		@FindBy(xpath="//button[text()='Add Teaching Industrial Experience']")
		private WebElement teachingExperience_AddButton;
		@FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[3]")
		private WebElement teachingExperienceFirst_DeleteButton;
		@FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[4]")
		private WebElement teachingExperienceSecond_DeleteButton;
		@FindBy(xpath="//textarea[@placeholder='Enter full address of the organization ']")
		private WebElement trainerOrganizationAddressTextbox;
		@FindBy(xpath="//input[@placeholder='Enter Area Name']")
		private WebElement trainerGeoLocationTextbox;
		@FindBy(xpath="//input[@formcontrolname='landmark']")
		private WebElement trainerLandmarkTextbox;
		@FindBy(xpath="//input[@formcontrolname='pincode']")
		private WebElement trainerPinCodeTextbox;
		@FindBy(xpath="//select[@formcontrolname='state']")
		private WebElement trainerStateDropDownList;
		@FindBy(xpath="//select[@formcontrolname='district']")
		private WebElement trainerDistrictDropDownList;
		@FindBy(xpath="//select[@formcontrolname='mandal']")
		private WebElement trainerTehsilDropDownList;
		@FindBy(xpath="//select[@formcontrolname='parliamentConstituency']")
		private WebElement trainerParliamentryDropDownList;
		@FindBy(xpath="//textarea[@formcontrolname='remarks']")
		private WebElement trainerRemarkTextbox;
		@FindBy(xpath="//input[@placeholder='Enter Available Quantity']")
		private WebElement equipmentAvailableQuantityTexbox;
		@FindBy(xpath="//input[@placeholder='Enter Remarks']")
		private WebElement equipmentRemarkTextbox;
		@FindBy(xpath="//button[contains(text(),'Add Another Job Role')]")
		private WebElement anotherJobRole_AddButton;
		@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
		private WebElement jobRole_SaveNdContinueButton;
		
		@FindBy(xpath="//select[@formcontrolname='type']")
		private WebElement centreAreaTypeDropDownList;
		@FindBy(xpath="//input[@placeholder='Enter Carpet Area (In Sq.Ft.)']")
		private WebElement centreCarpetAreaTexbox;
		@FindBy(xpath="//select[@formcontrolname='typeOfWashRoom']")
		private WebElement centre_WashRoomTypeDropDownList;
		@FindBy(xpath="//label[input[@formcontrolname='cctv']]/span")
		private WebElement centreArea_CCTVCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='airConditioner']]/span")
		private WebElement centreArea_AirConditionerCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='exhaustFan']]/span")
		private WebElement centreArea_ExhaustFanCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='securedElectricWiresAndSwitchBoard']]/span")
		private WebElement centreArea_SecuredElectricWireCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='wellVentilated']]/span")
		private WebElement centreArea_wellVentilatedCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='dusibinAvailibility']]/span")
		private WebElement centreArea_DustbinAvailablityCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='cleanAndHygienic']]/span")
		private WebElement centreArea_CleanAndHygienCheckBox;
		@FindBy(xpath="//textarea[@formcontrolname='remarks']")
		private WebElement centreAreaRemarkTextbox;
		@FindBy(xpath="//button[contains(text(),'Add Another Centre Area Details')]")
		private WebElement CentreArea_AddDetailsButton;
		@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
		private WebElement CentreArea_SaveAndContinueButton;
		
		@FindBy(xpath="(//select[@formcontrolname='availability'])[1]")
		private WebElement residentialArea_MenDropDownList;
		@FindBy(xpath="(//input[@formcontrolname='totalArea'])[1]")
		private WebElement totalArea_MenResidentialTextbox;
		@FindBy(xpath="(//input[@formcontrolname='numberOfRooms'])[1]")
		private WebElement rooms_MenResidentialTextbox;
		@FindBy(xpath="(//input[@formcontrolname='capacity'])[1]")
		private WebElement capacity_MenResidentialTextbox;
		@FindBy(xpath="(//label[input[@formcontrolname='cctv']]/span)[1]")
		private WebElement menResidential_CCTVCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='warden']]/span)[1]")
		private WebElement menResidential_WardenCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='mess']]/span)[1]")
		private WebElement menResidential_MessCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='allTImeSecurity']]/span)[1]")
		private WebElement menResidential_SecurityCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='backup']]/span)[1]")
		private WebElement menResidential_BackupCheckBox;
		@FindBy(xpath="(//textarea[@formcontrolname='remarks'])[1]")
		private WebElement remark_MenResidentialTextbox;
		@FindBy(xpath="(//select[@formcontrolname='availability'])[2]")
		private WebElement residentialArea_WomenDropDownList;
		@FindBy(xpath="(//input[@formcontrolname='totalArea'])[2]")
		private WebElement totalArea_WomenResidentialTextbox;
		@FindBy(xpath="(//input[@formcontrolname='numberOfRooms'])[2]")
		private WebElement rooms_WomenResidentialTextbox;
		@FindBy(xpath="(//input[@formcontrolname='capacity'])[2]")
		private WebElement capacity_WomenResidentialTextbox;
		@FindBy(xpath="(//label[input[@formcontrolname='cctv']]/span)[2]")
		private WebElement womenResidential_CCTVCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='femaleWarden']]/span)")
		private WebElement womenResidential_WardenCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='mess']]/span)[2]")
		private WebElement womenResidential_MessCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='allTImeSecurity']]/span)[2]")
		private WebElement womenResidential_SecurityCheckBox;
		@FindBy(xpath="(//label[input[@formcontrolname='backup']]/span)[2]")
		private WebElement womenResidential_BackupCheckBox;
		@FindBy(xpath="(//textarea[@formcontrolname='remarks'])[2]")
		private WebElement remark_WomenResidentialTextbox;
		
		@FindBy(xpath="//label[input[@formcontrolname='washroom']]/span")
		private WebElement facility_DiffrentialyAbled_WashRoomCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='rampsAtCentreEntrance']]/span")
		private WebElement facility_DiffrentialyAbled_RampsCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='liftIncaseOfFloors']]/span")
		private WebElement facility_DiffrentialyAbled_LiftsCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='maleWashroom']]/span")
		private WebElement facility_MaleWashRoomCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='femaleWashroom']]/span")
		private WebElement facility_FemaleWashRoomCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='dedicatedHouseKeepingStaff']]/span")
		private WebElement facility_HousekeepingStaffCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='washroomsCleanAndHygiene']]/span")
		private WebElement facility_CleanAndHygieneWashRoomCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='dailyInspectionChecklistInWashroom']]/span")
		private WebElement facility_InspectionCardCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='safeDrinkingWater']]/span")
		private WebElement facility_DrinkingWaterCheckBox;
		@FindBy(xpath="//select[@formcontrolname='fireEquipment']")
		private WebElement fireEquipmentAvailablityDropDownList;
		@FindBy(xpath="//label[input[@formcontrolname='fireEquipment']]/span")
		private WebElement display_FirstAidKitCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='firstAidKitWallMounted']]/span")
		private WebElement display_WallMountedFirstAidKitCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='fireSafetyInstruction']]/span")
		private WebElement display_FireSafetyInstructionCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='emergencyTelephoneNumber']]/span")
		private WebElement firstAidKit_EmergencyTelephoneNumberCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='sterileGauzePadsAvailability']]/span")
		private WebElement firstAidKit_SterileGauzePadsCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='medicinesLikePainKiller']]/span")
		private WebElement firstAidKit_MedicineCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='rollerBandages']]/span")
		private WebElement firstAidKit_RollerBandagesCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='adhesiveBandages']]/span")
		private WebElement firstAidKit_AdhesiveBandagesCheckBox;
		@FindBy(xpath="//label[input[@formcontrolname='thermometer']]/span")
		private WebElement firstAidKit_ThermometerCheckBox;
		
		@FindBy(xpath="//select[@formcontrolname='type']")
		private WebElement centreSupportstaff_TypeDropDownList;
		@FindBy(xpath="//input[@placeholder='Enter Name of Support Staff']")
		private WebElement centresupportStaff_NameTextbox;
		@FindBy(xpath="//select[@formcontrolname='highestQualification']")
		private WebElement centreStaff_highestQualificationDropDownList;
		@FindBy(xpath="//select[@formcontrolname='typeOfResource']")
		private WebElement centreStaff_resourceTypeDropDownList;
		@FindBy(xpath="//textarea[@formcontrolname='remarks']")
		private WebElement centreStaff_RemarkTextbox;
		@FindBy(xpath="//button[contains(text(),'Add Another Centre Staff')]")
		private WebElement centreStaff_AddButton;
		@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
		private WebElement centreStaff_saveAndContinueButton;
		
		@FindBy(css=".form-control.m-input.ng-untouched.ng-pristine")
		private WebElement mobileNumber_ForMobileApplicationTextBox;
		@FindBy(xpath="//span[contains(text(),'Get Application Link')]")
		private WebElement getApplicationLinkButton;
		
		@FindBy(xpath="//label[input[@type='checkbox']]/span")
		private WebElement declaration_CheckBox;
		@FindBy(xpath="//button[contains(text(),'Save & Continue to Payment')]")
		private WebElement payment_SaveAndContinueButton;
	
		
		public void enterTpName(String tpName)
		{
			tpnameTextbox.sendKeys(tpName);
		}

		public void enterTcName(String tcName)
		{
			tcnameTextbox.sendKeys(tcName);
		}

		public void selectTrainingCentre(String tcName)
		{
			SelectDropDownList.selectDropDownListByVisibleText(tcDropDownList, tcName);
		}

		public void enterSocialmediaName(String socialmediaName)
		{
			socialmediaTextbox.sendKeys(socialmediaName);
		}

		public void enterWebsiteurl(String websiteurl)
		{
			websiteTextbox.sendKeys(websiteurl);
		}

		public void selectBuildingStatus(String buildingState)
		{
			SelectDropDownList.selectDropDownListByVisibleText(buildingstatusDropDownList, buildingState);
		}

		public void selectbuildingconstruction(String buildingConstruction)
		{
			SelectDropDownList.selectDropDownListByVisibleText(buildingconstructionDropDownList, buildingConstruction);
		}

		public void selectTransportSystem(String transportSystem)
		{
			SelectDropDownList.selectDropDownListByVisibleText(transportsystemDropDownList, transportSystem);
		}

		public void enterTransportName(String transportName)
		{
			transportnameTextbox.sendKeys(transportName);
		}

		public void selectBuildingface(String buildingFace)
		{
			SelectDropDownList.selectDropDownListByVisibleText(buildingfaceDropDownList, buildingFace);
		}

		public void enterApproachRoadWidth(String approachRoadWidth)
		{
			approachroadwidthTextbox.sendKeys(approachRoadWidth);
		}

		public void selectBuildingState(String buildingState)
		{
			SelectDropDownList.selectDropDownListByVisibleText(buildingstateDropDownList, buildingState);
		}

		public void clickBrowseFileForBuildingState()
		{
			buildingstate_BrowseFileButton.click();
		}

		public void clickUploadButtonBuildingState()
		{
			buildingstate_UploadButton.click();
		}

		public void clickFacility_Securityguard()
		{
			facility_securityguardCheckBox.click();
		}

		public void clickfacility_WellCondition()
		{
			facility_wellconditionCheckBox.click();
		}

		public void clickFacility_Biometric()
		{
			facility_biometricCeckBox.click();
		}

		public void clickFacility_WallsAndRoofCondition()
		{
			facility_wallsandroofconditionCheckBox.click();
		}

		public void clickFacility_Greenery()
		{
			facility_greeneryCheckBox.click();
		}

		public void clickFacility_centreFloorCondition()
		{
			facility_centrefloorconditionCheckBox.click();
		}

		public void clickFacility_CentreFloorTiledCondition()
		{
			facility_centrefloortiledCheckBox.click();
		}

		public void clickFacility_InternetAvailablity()
		{
			facility_internetCheckBox.click();
		}

		public void clickFacility_PowerBackup()
		{
			facility_powerbackupCheckBox.click();
		}

		public void clickFacility_TrainingCentreFunctional()
		{
			facility_tcfunctionCheckBox.click();
		}

		public void selectProgram(String programName)
		{
			SelectDropDownList.selectDropDownListByVisibleText(programDropDownList, programName);
		}

		public void clickNsqf()
		{
			nsqfCheckBox.click();
		}

		public void clickAnotherProgramOffered()
		{
			clickToAnotherProgramOfferedButton.click();
		}

		public void selectDegreeProgram(String degreeProgram)
		{
			SelectDropDownList.selectDropDownListByVisibleText(degreeDropDownList, degreeProgram);
		}

		public void clickDegreeNsqf()
		{
			degreeNsqfCheckBox.click();
		}

		public void selectVocationalProgram(String vocationalProgram)
		{
			SelectDropDownList.selectDropDownListByVisibleText(vocationalDropDownList, vocationalProgram);
		}

		public void clickVocationalNsqf()
		{
			vocationalNsqfcheckBox.click();
		}

		public void selectPrivateProgram(String privateProgram)
		{
			SelectDropDownList.selectDropDownListByVisibleText(privateDropDownList, privateProgram);
		}

		public void clickPrivateNsqf()
		{
			privateNsqfCheckBox.click();
		}

		public void selectOthersProgram(String othersProgram)
		{
			SelectDropDownList.selectDropDownListByVisibleText(othersProgramDropDownList, othersProgram);
		}

		public void clickOthersNsqf()
		{
			othersNsqfCheckBox.click();
		}

		public void enterSpocName(String spocName)
		{
			spocnameTextbox.sendKeys(spocName);
		}

		public void enterSpocEmail(String spocEmail)
		{
			spocemailTextbox.sendKeys(spocEmail);
		}

		public void enterSpocMobileNumber(String spocMobileNumber)
		{
			spocmobileNumberTextbox.sendKeys(spocMobileNumber);
		}

		public void enterSpocAltNumber(String spocAltNumber)
		{
			spocaltNumberTextbox.sendKeys(spocAltNumber);
		}

		public void enterCentrePrincipalName(String centrePrincipalName)
		{
			centrePrincipalNameTextbox.sendKeys(centrePrincipalName);
		}

		public void enterCentrePrincipalEmail(String centrePrincipalEmail)
		{
			centrePrincipalEmailTextBox.sendKeys(centrePrincipalEmail);
		}
		
		public void enterCentrePrincipalContactNumber(String centrePrincipalcontactNumber)
		{
			centrePrincipalContactNumberTextbox.sendKeys(centrePrincipalcontactNumber);
		}
		
		public void enterAffiliationName(String affiliationName)
		{
			affiliationNameTextbox.sendKeys(affiliationName);
		}

		public void selectAffiliationType(String affiliationType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(affiliationTypeDropDownList, affiliationType);
		}

		public void enteraffiliAtionValidity(String affiliationValidity)
		{
			affiliationValidityTextbox.sendKeys(affiliationValidity);
		}

		public void clickAffiliationCalender()
		{
			affiliationCalenderButton.click();
		}

		public void enterAboutAffiliation(String aboutaffiliation)
		{
			aboutAffiliationTextbox.sendKeys(aboutaffiliation);
		}

		public void enterTcOrganizationAddress(String tcOrganizationAddress)
		{
			tcOrganizationAddressTextbox.sendKeys(tcOrganizationAddress);
		}

		public void enterTcGeoLocation(String tcgeoLocation)
		{
			tcgeoLocationTextbox.sendKeys(tcgeoLocation);
		}

		public void enterTcLandmark(String tcLandmark)
		{
			tclandmarkTextbox.sendKeys(tcLandmark);
		}

		public void enterTcPinCode(String tcPinCode)
		{
			tcPinCodeTextbox.sendKeys(tcPinCode);
		}

		public void selectTcState(String tcState)
		{
			SelectDropDownList.selectDropDownListByVisibleText(tcStateDropDownList, tcState);
		}

		public void selectTcDistrict(String tcDistrict)
		{
			SelectDropDownList.selectDropDownListByVisibleText(tcDistrictDropDownList, tcDistrict);
		}

		public void selectTcTehsil(String tcTehsil)
		{
			SelectDropDownList.selectDropDownListByVisibleText(tcTehsilDropDownList, tcTehsil);
		}

		public void selectTcParliamentry(String tcParliamentry)
		{
			SelectDropDownList.selectDropDownListByVisibleText(tcParliamentryDropDownList, tcParliamentry);
		}

		public void selectTcAddressProof(String tcAddressProof)
		{
			SelectDropDownList.selectDropDownListByVisibleText(tcAddressproofDropDownList, tcAddressProof);
		}

		public void clickBrowseFileforTcAddressProof()
		{
			tcAddressProof_BrowseFileButton.click();
		}

		public void clickUploadFileforTcAddresssProof()
		{
			tcAddressProof_UploadFileButton.click();
		}

		public void selectTcAreaClassificationCentre(String tcAreaClassificationCentre)
		{
			SelectDropDownList.selectDropDownListByVisibleText(tcAreaClassificationCentreDropDownList, tcAreaClassificationCentre);
		}

		public void selectIsEntireCentreatGroundFloor(String centreatGroundFloor)
		{
			SelectDropDownList.selectDropDownListByVisibleText(entireCentreatGroundFloorDropDownList, centreatGroundFloor);
		}

		public void enterTcTotalArea(String tcTotalArea)
		{
			totalTcAreaTextbox.sendKeys(tcTotalArea);
		}

		public void enterPMKVYCentreId(String pMKVYCentreId) 
		{
			pMKVYCentreIdTextbox.sendKeys(pMKVYCentreId);
		}

		public void clickSavendNext()
		{
			savendNextButton.click();
		}

		public void clickSaveasDraft()
		{
			saveasDraftButton.click();
		}

		public void selectSkillSector(String skillSector)
		{
			SelectDropDownList.selectDropDownListByVisibleText(skillSectorDropDownList, skillSector);
		}

		public void selectSkillSubSector(String skillSubSector)
		{
			SelectDropDownList.selectDropDownListByVisibleText(skillSubSectorDropDownList, skillSubSector);
		}

		public void selectJobRoleName(String jobRollName)
		{
			SelectDropDownList.selectDropDownListByVisibleText(jobRoleNameDropDownList, jobRollName);
		}

		public void selectTraineeToTrainerRatio(String traineeToTrainerRatio)
		{
			SelectDropDownList.selectDropDownListByVisibleText(traineeToTrainerRatioDropDownList, traineeToTrainerRatio);
		}

		public void selectParallelBathcesNumber(String parallelBatchesNumber)
		{
			SelectDropDownList.selectDropDownListByVisibleText(parallelBathcesNumberDropDownList, parallelBatchesNumber);
		}

		public void enterJobRole(String jobRole)
		{
			jobRoleTextbox.sendKeys(jobRole);
		}

		public void clickClassroom()
		{
			classroomCheckBox.click();
		}

		public void clickLaboratory()
		{
			laboratoryCheckBox.click();
		}

		public void clickHybrid()
		{
			hybridCheckBox.click();
		}

		public void selectAdditionalAreaRequired(String additionalarea)
		{
			SelectDropDownList.selectDropDownListByVisibleText(additionalAreaRequiredDropDownList, additionalarea);
		}

		public void enterAdditionalCarpetArea(String additionalCarpetArea)
		{
			additionalCarpetAreaTextbox.sendKeys(additionalCarpetArea);
		}
		public void selectClassroomSerialNumber(String serialNumber)
		{
			SelectDropDownList.selectDropDownListByVisibleText(classroomserialNumberDropDownList, serialNumber);
		}

		public void enterClassRoomCarpetArea(String classRoomCarpetArea)
		{
			classroomCarpetAreaTextbox.sendKeys(classRoomCarpetArea);
		}

		public void clickClasRoomProjector()
		{
			classRoomProjectorCheckBox.click();
		}

		public void clickClassRoomAirConditioner()
		{
			classRoomAirConditionerCheckBox.click();
		}

		public void clickClassRoomCCTV()
		{
			classRoomCCTVCheckBox.click();
		}

		public void clickClassRoomAdequateLight()
		{
			classRoomAdequateLightCheckBox.click();
		}

		public void clickClassRoomExhaustFand()
		{
			classRoomExhaustFanCheckBox.click();
		}

		public void clickClassRoomSecuredElectricWire()
		{
			classRoomSecuredElectricWireCheckBox.click();
		}

		public void clickClassRoomWellVantilated()
		{
			classRoomWellVantilatedCheckBox.click();
		}

		public void clickClassRoomAvailiblityOfDustbin()
		{
			classRoomAvailablityOfDustbinCheckBox.click();
		}

		public void clickClassRoomCleanNdHygenic()
		{
			classRoomCleanNdHygenicCheckBox.click();
		}

		public void clickClassRoomEmergencyNumberDisplayed()
		{
			classRoomEmergencyNumberDisplayedCheckBox.click();
		}

		public void enterClassRoomRemark(String remark)
		{
			classRoomRemarkTextbox.sendKeys(remark);
		}

		public void selectClassRoomAvailablityForJobRole(String classRoomAvailablity)
		{
			SelectDropDownList.selectDropDownListByVisibleText(classRoomavailablityforJobRoleDropDownList, classRoomAvailablity);
		}

		public void selectLaboratorySerialNumber(String laboratorySerialNumber)
		{
			SelectDropDownList.selectDropDownListByVisibleText(laboratorySerialNumberDropDownList, laboratorySerialNumber);
		}

		public void enterLaboratoryCarpetArea(String laboratoryCarpetArea)
		{
			laboratoryCarpetAreaTextbox.sendKeys(laboratoryCarpetArea);
		}

		public void selectTypeOfLaboratory(String laboratoryType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(laboratoryTypeDropDownList, laboratoryType);
		}

		public void clickLaboratoryProjector()
		{
			laboratoryProjectorCheckBox.click();
		}

		public void clickLaboratoryAirConditioner()
		{
			laboratoryAirConditionerCheckBox.click();
		}

		public void clickLaboratoryCCTV()
		{
			laboratoryCCTVCheckBox.click();
		}

		public void clickLaboratoryAdequateLight()
		{
			laboratoryAdequateLightCheckBox.click();
		}

		public void clickLaboratoryExhaustFand()
		{
			laboratoryExhaustFanCheckBox.click();
		}

		public void clickLabboratorySecuredElectricWire()
		{
			laboratorySecuredElectricWireCheckBox.click();
		}

		public void clickLaboratoryWellVantilated()
		{
			laboratoryWellVantilatedCheckBox.click();
		}

		public void clickLaboratoryAvailiblityOfDustbin()
		{
			laboratoryAvailablityOfDustbinCheckBox.click();
		}

		public void clickLaboratoryCleanNdHygenic()
		{
			laboratoryCleanNdHygenicCheckBox.click();
		}

		public void clickLaboratoryEmergencyNumberDisplayed()
		{
			laboratoryEmergencyNumberDisplayedCheckBox.click();
		}

		public void enterLaboratoryRemark(String laboratoryremark)
		{
			classRoomRemarkTextbox.sendKeys(laboratoryremark);
		}

		public void selectLaboratoryAvailablityForJobRole(String laboratoryAvailablity)
		{
			SelectDropDownList.selectDropDownListByVisibleText(laboratoryAvailablityforJobRoleDropDownList, laboratoryAvailablity);
		}

		public void selectHybridSerialNumber(String hybridSerialNumber)
		{
			SelectDropDownList.selectDropDownListByVisibleText(hybridSerialNumberDropDownList, hybridSerialNumber);
		}

		public void enterHybridCarpetArea(String hybridCarpetArea)
		{
			hybridCarpetAreaTextbox.sendKeys(hybridCarpetArea);
		}

		public void selectTypeOfHybridLaboratory(String hybridLaboratoryType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(hybridLaboratoryTypeDropDownList, hybridLaboratoryType);
		}

		public void clickHybridProjector()
		{
			hybridProjectorCheckBox.click();
		}

		public void clickHybridAirConditioner()
		{
			hybridAirConditionerCheckBox.click();
		}

		public void clickHybridCCTV()
		{
			hybridCCTVCheckBox.click();
		}

		public void clickHybridAdequateLight()
		{
			hybridAdequateLightCheckBox.click();
		}

		public void clickHybridExhaustFand()
		{
			hybridExhaustFanCheckBox.click();
		}

		public void clickCHybridSecuredElectricWire()
		{
			hybridSecuredElectricWireCheckBox.click();
		}

		public void clickHybridWellVantilated()
		{
			hybridWellVantilatedCheckBox.click();
		}
		
		public void clickHybridAvailiblityOfDustbin()
		{
			hybridAvailablityOfDustbinCheckBox.click();
		}
		
		public void clickHybridCleanNdHygenic()
		{
			hybridCleanNdHygenicCheckBox.click();
		}
		
		public void clickHybridEmergencyNumberDisplayed()
		{
			hybridEmergencyNumberDisplayedCheckBox.click();
		}

		public void enterHybridRemark(String hybridremark)
		{
			hybridRemarkTextbox.sendKeys(hybridremark);
		}
		
		public void selecHybridAvailablityForJobRole(String hybridAvailablity)
		{
			SelectDropDownList.selectDropDownListByVisibleText(hybridAvailablityforJobRoleDropDownList, hybridAvailablity);
		}
		
		public void selectTrainerSerialNumber(String trainerSerialNumber)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerSerialNumberDropDownList, trainerSerialNumber);
		}
		
		public void enterTrainerName(String trainerName)
		{
			trainerNameTextbox.sendKeys(trainerName);
		}
		
		public void enterTrainerAdharNumber(String trainerAdharNumber)
		{
			trainerAdharNumberTextbox.sendKeys(trainerAdharNumber);
		}
		
		public void selectTrainerSSCCertified(String trainerSSCCertified)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerSSCCertifiedDropDownList, trainerSSCCertified);
		}
		
		public void selectTrainerHighestQualification(String trinerHighestQualification)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerHighestQualificationDropDownList, trinerHighestQualification);
		}
		
		public void selectTrainerMinimumQualification(String trianerMinimumQualification)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerMinimumQualificationDropDownList, trianerMinimumQualification);
		}
		
		public void selectTrainerNIESBUDCertified(String trainerNIESBUDCertified)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerNIESBUDCertifiedDropDownList, trainerNIESBUDCertified);
		}
		
		public void enterTrainerAgencyName(String agencyName)
		{
			trainerAgencyNameTextbox.sendKeys(agencyName);
		}
		
		public void selectTrainerAvailablity(String trainerAvailablity)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerAvailablityDropDownList, trainerAvailablity);
		}
		
		public void selectTrainerResourceType(String trainerResourceType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerResourceTypeDropDownList, trainerResourceType);
		}
		
		public void enterTrainerMobileNumber(String trainerMobileNumber)
		{
			trainerMobileNumberTextbox.sendKeys(trainerMobileNumber);
		}
		
		public void selectTrainerRelevantSector(String trainerRelevantSector)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerrelevantSectorDropDownList, trainerRelevantSector);
		}
		
		public void selectTrainerRelevantExperienceYear(String relevantSectorExperienceYear)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerRelevantSectorExperienceInYearDropDownList, relevantSectorExperienceYear);
		}
		
		public void selectTrainerRelevantSectorExperienceMonths(String relevantSectorExperienceMonths)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerRelevantSectorExperienceInMonthsDropDownList, relevantSectorExperienceMonths);
		}
		
		public void clickBrowseFileforTrainerRelevantSectorExperierienceFile()
		{
			relevantSectorExperience_BrowseButton.click();
		}
		
		public void clickUploadButtonforTrainerRelevantSectorExperienceFile()
		{
			relevantSectorExperience_UploadButton.click();
		}

		public void clickforAddRelevantSectorExperience()
		{
			relevantSectorExperience_AddButton.click();
		}

		public void clickFirstRelevantSectorExperienceDeleteButton()
		{
			relevantSectorExperiencefirst_DeleteButton.click();
		}

		public void clickSecondRelevantSectorExperienceDeleteButton()
		{
			relevantSectorExperienceSecond_DeleteButton.click();
		}
		
		public void selectTeachingRelevantExperience(String teachingRelevantSector)
		{
			SelectDropDownList.selectDropDownListByVisibleText(teachingRelevantSectorDropDownList, teachingRelevantSector);
		}
		
		public void selectTeachingExperienceInYears(String teachingExperienceInYears)
		{
			SelectDropDownList.selectDropDownListByVisibleText(year_TeachingExperienceDropDownList, teachingExperienceInYears);
		}
		
		public void selectTeachingExperienceInMonths(String teachingExperienceInMonths)
		{
			SelectDropDownList.selectDropDownListByVisibleText(month_TeachingExperienceDropDownList, teachingExperienceInMonths);
		}
		
		public void clickBrowseButtonforTeachinExperience()
		{
			teachingExperience_BrowseFileButton.click();
		}
		
		public void clickUploadButtonforTeachingExperience()
		{
			teachingExperience_UploadButton.click();
		}
		
		public void clickAddforTeachingExperience()
		{
			teachingExperience_AddButton.click();
		}
		
		public void clickDeleteforFirstTeachingExperience()
		{
			teachingExperienceFirst_DeleteButton.click();
		}
		
		public void clickDeleteforSecondTeachingExperience()
		{
			teachingExperienceSecond_DeleteButton.click();
		}

		public void enterTrainerAddressOfOrganization(String trainerOrganizationAddress)
		{
			trainerOrganizationAddressTextbox.sendKeys(trainerOrganizationAddress);
		}
		
		public void enterTrainerGeoLocation(String trainerGeoLocation)
		{
			trainerGeoLocationTextbox.sendKeys(trainerGeoLocation);
		}
		
		public void enterTrainerLandmark(String trainerLandmark)
		{
			trainerLandmarkTextbox.sendKeys(trainerLandmark);
		}
		
		public void entertrianerPinCode(String trainerPinCode)
		{
			trainerPinCodeTextbox.sendKeys(trainerPinCode);
		}
		
		public void selectTrainerState(String trainerState)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerStateDropDownList, trainerState);
		}
		
		public void selectTrainerDistrict(String trainerDistrict)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerDistrictDropDownList, trainerDistrict);
		}
		
		public void selectTrainerTehsil(String trainerTehsil)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerTehsilDropDownList, trainerTehsil);
		}
		
		public void selectTrainerParliamentry(String trainerParliamentry)
		{
			SelectDropDownList.selectDropDownListByVisibleText(trainerParliamentryDropDownList, trainerParliamentry);
		}
		
		public void enterTrainerRemark(String trainerRemark)
		{
			trainerRemarkTextbox.sendKeys(trainerRemark);
		}
		
		public void enterQuantityOfAvailableEquipment(String quantityAvailable)
		{
			equipmentAvailableQuantityTexbox.sendKeys(quantityAvailable);
		}
		
		public void enterEquipmentRemark(String equipmentRemark)
		{
			equipmentRemarkTextbox.sendKeys(equipmentRemark);
		}
		
		public void clickForAddJobRole9()
		{
			anotherJobRole_AddButton.click();
		}
		
		public void clickSaveNdContinueForJobRole()
		{
			jobRole_SaveNdContinueButton.click();
		}
		
		public void selectTypeOfCentreArea(String centreAreaType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(centreAreaTypeDropDownList, centreAreaType);
		}
		
		public void enterCarpetAreaforCentre(String centreCarpetArea)
		{
			centreCarpetAreaTexbox.sendKeys(centreCarpetArea);
		}
		
		public void selectTypeOfCentreWashRoom(String centrWashroomType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(centre_WashRoomTypeDropDownList, centrWashroomType);
		}
		
		public void clickCentreAreaCCTV()
		{
			centreArea_CCTVCheckBox.click();
		}
		
		public void clickCentreAreaAirConditioner()
		{
			centreArea_AirConditionerCheckBox.click();
		}
		
		public void clickCentreAreaExhaustFan()
		{
			centreArea_ExhaustFanCheckBox.click();
		}
		
		public void clickCentreAreaSecuredElectricWire()
		{
			centreArea_SecuredElectricWireCheckBox.click();
		}
		
		public void clickCentreAreaWellVentilated()
		{
			centreArea_wellVentilatedCheckBox.click();
		}
		
		public void clickCentreAreaDustbinAvailablity()
		{
			centreArea_DustbinAvailablityCheckBox.click();
		}
		
		public void clickCentreAreaCleanAndHygien()
		{
			centreArea_CleanAndHygienCheckBox.click();
		}

		public void enterCentreAreaRemark(String centreAreaRemark)
		{
			centreAreaRemarkTextbox.sendKeys(centreAreaRemark);
		}
		
		public void clickForAddCentreAreaDetails()
		{
			CentreArea_AddDetailsButton.click();
		}
		
		public void clickForCentreAreaSaveAndContinue()
		{
			CentreArea_SaveAndContinueButton.click();
		}
		
		public void selectResidentialAreaForMen(String menResidentialArea)
		{
			SelectDropDownList.selectDropDownListByVisibleText(residentialArea_MenDropDownList, menResidentialArea);
		}
		
		public void enterTotalAreaOfMenResidential(String totalAreaMenResidential)
		{
			totalArea_MenResidentialTextbox.sendKeys(totalAreaMenResidential);
		}
		
		public void enterTotalRoomsForMenResidential(String roomsNumberMenResidential)
		{
			rooms_MenResidentialTextbox.sendKeys(roomsNumberMenResidential);
		}
		
		public void enterResidentialCapacityForMen(String residentialCapacityMen)
		{
			capacity_MenResidentialTextbox.sendKeys(residentialCapacityMen);
		}
		
		public void clickCCTVforMenResidential()
		{
			menResidential_CCTVCheckBox.click();
		}
		
		public void clickWardenforMenResidential()
		{
			menResidential_WardenCheckBox.click();
		}
		
		public void clickMessforMenResidential()
		{
			menResidential_MessCheckBox.click();
		}
		
		public void clickSecurityforMenResidential()
		{
			menResidential_SecurityCheckBox.click();
		}
		
		public void clickBackupforMenResidential()
		{
			menResidential_BackupCheckBox.click();
		}

		public void enterRemarkForMenResidential(String remarkMenResidential)
		{
			remark_MenResidentialTextbox.sendKeys(remarkMenResidential);
		}
		
		public void selectResidentialAreaForWomen(String womenResidentialArea)
		{
			SelectDropDownList.selectDropDownListByVisibleText(residentialArea_WomenDropDownList, womenResidentialArea);
		}
		
		public void enterTotalAreaOfWomenResidential(String totalAreaWomenResidential)
		{
			totalArea_WomenResidentialTextbox.sendKeys(totalAreaWomenResidential);
		}
		
		public void enterTotalRoomsForWomenResidential(String roomsNumberWomenResidential)
		{
			rooms_WomenResidentialTextbox.sendKeys(roomsNumberWomenResidential);
		}

		public void enterResidentialCapacityForWomen(String residentialCapacityWomen)
		{
			capacity_WomenResidentialTextbox.sendKeys(residentialCapacityWomen);
		}

		public void clickCCTVforWomenResidential()
		{
			womenResidential_CCTVCheckBox.click();
		}
		
		public void clickWardenforWomenResidential()
		{
			womenResidential_WardenCheckBox.click();
		}
		
		public void clickMessforWomenResidential()
		{
			womenResidential_MessCheckBox.click();
		}
		
		public void clickSecurityforWomenResidential()
		{
			womenResidential_SecurityCheckBox.click();
		}
		
		public void clickBackupforWomenResidential()
		{
			womenResidential_BackupCheckBox.click();
		}
		
		public void enterRemarkForWomenResidential(String remarkWomenResidential)
		{
			remark_WomenResidentialTextbox.sendKeys(remarkWomenResidential);
		}
		
		public void clickForDiffrentialyAbledWashRoomFacility()
		{
			facility_DiffrentialyAbled_WashRoomCheckBox.click();
		}
		
		public void clickForDiffrentialyAbledRampsFacility()
		{
			facility_DiffrentialyAbled_RampsCheckBox.click();
		}
		
		public void clickForDiffrentialyAbledLiftsFacility()
		{
			facility_DiffrentialyAbled_LiftsCheckBox.click();
		}
		
		public void clickForMaleWashRoomFacility()
		{
			facility_MaleWashRoomCheckBox.click();
		}

		public void clickForFemaleWashRoomFacility()
		{
			facility_FemaleWashRoomCheckBox.click();
		}
		
		public void clickForHousekeepingStaffFacility()
		{
			facility_HousekeepingStaffCheckBox.click();
		}

		public void clickForCleanAndHygieneWashRoomFacility()
		{
			facility_CleanAndHygieneWashRoomCheckBox.click();
		}
		
		public void clickForInspectionCardFacility()
		{
			facility_InspectionCardCheckBox.click();
		}
		
		public void clickForDrinkingWaterFacility()
		{
			facility_DrinkingWaterCheckBox.click();
		}
		
		public void selectforFireFightingEquipment(String fireEquipmentAvailablity)
		{
			SelectDropDownList.selectDropDownListByVisibleText(fireEquipmentAvailablityDropDownList, fireEquipmentAvailablity);
		}
		
		public void clickforDisplayFirstAidKit()
		{
			display_FirstAidKitCheckBox.click();
		}
		
		public void clickforDisplayFirstAidKitWallMounted()
		{
			display_WallMountedFirstAidKitCheckBox.click();
		}
		
		public void clickforDisplayFireSafetyInstruction()
		{
			display_FireSafetyInstructionCheckBox.click();
		}
		
		public void clickForEmergencyTelephoneNumber()
		{
			firstAidKit_EmergencyTelephoneNumberCheckBox.click();
		}
		
		public void clickForSterilGauzePads()
		{
			firstAidKit_SterileGauzePadsCheckBox.click();
		}
		
		public void clickForMedicineLikePainKiller()
		{
			firstAidKit_MedicineCheckBox.click();
		}
		
		public void clickForRollerBandages()
		{
			firstAidKit_RollerBandagesCheckBox.click();
		}
		
		public void clickForAdhesiveBandages()
		{
			firstAidKit_AdhesiveBandagesCheckBox.click();
		}
		
		public void clickForThermometer()
		{
			firstAidKit_ThermometerCheckBox.click();
		}
		
		public void selectforCentreSupportStaff(String supportStaffType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(centreSupportstaff_TypeDropDownList, supportStaffType);
		}
		
		public void enterNameOfCentreSupportStaff(String supportStaffName)
		{
			centresupportStaff_NameTextbox.sendKeys(supportStaffName);
		}
		
		public void selectHighestQualificationForCentreStaff(String centreStaffHighestQualification)
		{
			SelectDropDownList.selectDropDownListByVisibleText(centreStaff_highestQualificationDropDownList, centreStaffHighestQualification);
		}
		
		public void selectResourceTypeOfCentreStaff(String resourceType)
		{
			SelectDropDownList.selectDropDownListByVisibleText(centreStaff_resourceTypeDropDownList, resourceType);
		}
		
		public void enterRemarkForCentreStaff(String centreStaffRemark)
		{
			centreStaff_RemarkTextbox.sendKeys(centreStaffRemark);
		}
		
		public void clickForAddCentreStaff()
		{
			centreStaff_AddButton.click();
		}
		
		public void clickForSaveAndContinueCentreStaff()
		{
			centreStaff_saveAndContinueButton.click();
		}
		
		public void enterMobileNumberForMobileApplication(String mobileNumber)
		{
			mobileNumber_ForMobileApplicationTextBox.sendKeys(mobileNumber);
		}

		public void clickToGetApplicationLink()
		{
			getApplicationLinkButton.click();
		}

		public void clickForDeclaration()
		{
			declaration_CheckBox.click();
		}

		public void clickForPayment()
		{
			payment_SaveAndContinueButton.click();
		}
		
	}
