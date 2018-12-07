package com.nsdc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.ClearTextUsingBackspace;
import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class TrainingCentre_CAAF_Page

{
    WebDriver driver;
    
    @FindBy(xpath="//input[@id='trainingPartnerName']")
    private WebElement tpNameTextbox;
    @FindBy(xpath="//input[@id='trainingCentreName']")
    private WebElement tcNameTextbox;
    @FindBy(xpath="//select[@id='typeOfTrainingCenter']")
    private WebElement tcTypeDropDownList;
    @FindBy(xpath="//input[@id='socialMediaLink']")
    private WebElement socialMediaTextbox;
    @FindBy(xpath="//input[@id='websiteURL']")
    private WebElement websiteTextbox;
    
    @FindBy(xpath="//input[@id='SPOCfirstName']")
    private WebElement spocNameTextbox;
    @FindBy(xpath="//input[@id='SPOCEmail']")
    private WebElement spocEmailTextbox;
    @FindBy(xpath="//input[@id='SPOCmobileNumber']")
    private WebElement spocMobileNumberTextbox;
    @FindBy(xpath="//input[@id='SPOCaltNumber']")
    private WebElement spocAlternateNumberTextbox;
    @FindBy(xpath="//input[@placeholder='Enter full name of Centre Principal/Director']")
    private WebElement centrePrincipal_NameTextbox;
    @FindBy(xpath="//input[@placeholder='Enter Email Address of Centre Principal/ Director']")
    private WebElement centrePrincipal_EmailAddressTextBox;
    @FindBy(xpath="//input[@id='contactNo']")
    private WebElement centrePrincipal_ContactNumberTextbox;
    
    @FindBy(xpath="//textarea[@placeholder='Enter Address']")
    private WebElement tcAddressTextbox;
    @FindBy(xpath="//input[@id='landmark']")
    private WebElement tCNearByLandmarkTextbox;
    @FindBy(xpath="//input[@id='pincode']")
    private WebElement tcPinCodeTextbox;
    @FindBy(xpath="//select[@id='state']")
    private WebElement tcStateDropDownList;
    @FindBy(xpath="//select[@id='district']")
    private WebElement tcDistrictDropDownList;
    @FindBy(xpath="//select[@id='tehsil']")
    private WebElement tcTehsilDropDownList;
    //@FindBy(xpath="//select[@id='city']")
    //private WebElement tcCityOrVillageDropDownList;
    @FindBy(xpath="//select[@id='parliamentaryConstituency']")
    private WebElement tcParliamentryDropDownList;
    @FindBy(xpath="//select[@id='addressProofType']")
    private WebElement tcAddressProofTypeDropDownList;
    @FindBy(xpath="//input[@id='customFile']")
    private WebElement tcAddressProof_BrowseFileButton;
    @FindBy(xpath="//button[@class='btn btn-outline-success']")
    private WebElement tcAddressProof_UploadFileButton;
    @FindBy(xpath="//select[@id='areaClassificationCentre']")
    private WebElement tcAreaClassificationOfCentreDropDownList;
    @FindBy(xpath="//select[@id='isCenterAtGroundFloor']")
    private WebElement entireCentreatGroundFloorDropDownList;
    
    
    //Page2
    @FindBy(xpath="//select[@id='buildingStatus']")
    private WebElement buildingStatusDropDownList;
    @FindBy(xpath="//select[@id='buildingConstrictionType']")
    private WebElement buildingConstructionDropDownList;
    @FindBy(xpath="//select[@id='proximityTOPublicTransportSystem']")
    private WebElement publicTransportSystemDropDownList;
    @FindBy(xpath="//input[@id='nearestTransportName']")
    private WebElement nearestTransportNameTextbox;
    @FindBy(xpath="//select[@id='frontFaceOfBuilding']")
    private WebElement buildingFrontFaceDropDownList;
    @FindBy (xpath="//input[@id='approachRoadToCentreWidth']")
    private WebElement approachRoadWidthTextbox;
    @FindBy(xpath="//select[@id='previousStateOfBuilding']")
    private WebElement buildingPreviousStateDropDownList;
    @FindBy (xpath="(//input[@id='customFile'])[1]")
    private WebElement buildingPreviousState_BrowseFileButton;
    @FindBy (xpath="(//button[contains(text(),'Upload')])[1]")
    private WebElement buildingPreviousState_UploadButton;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[1]")
    private WebElement  facility_SecurityGuardCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[2]")
    private WebElement facility_WellConditionCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[3]")
    private WebElement facility_BiometricCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[4]")
    private WebElement facility_WallAndRoofConditionCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[5]")
    private WebElement facility_GreeneryCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[6]")
    private WebElement facility_CentreFloorConditionCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[7]")
    private WebElement facility_CentreFloorTiledCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[8]")
    private WebElement facility_InternetCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[9]")
    private WebElement facility_PowerBackupCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[10]")
    private WebElement facility_TCFunctionalCheckBox;
    @FindBy(xpath="//select[@id='typeOfCentreFloor']")
    private WebElement typeOfCentreFloorDropDownList;
    @FindBy(xpath="//select[@id='typeOfTrainingCentreWalls']")
    private WebElement typeOfTrainingCentreWallsDropDownList;
    @FindBy(id="availabilityOfInternet")
    private WebElement availablityOfInternetDropDownlist;
    
    @FindBy(xpath="(//input[@placeholder='Enter the Name of the Affiliation'])[1]")
    private WebElement first_AffiliationNameTextbox;
    @FindBy(xpath="(//select[@formcontrolname='type'])[1]")
    private WebElement first_AffiliationTypeDropDownList;
    @FindBy(xpath="//input[@placeholder='Start Date']")
    private WebElement first_Affiliation_StartDateTextbox;
    @FindBy(xpath="//input[@placeholder='End Date']")
    private WebElement first_Affiliation_EndDateTextbox;
    @FindBy(xpath="(//textarea[@formcontrolname='breifDetails'])[1]")
    private WebElement first_BriefAboutAffiliationTextbox;
    @FindBy(xpath="//button[contains(text(),'Add Another Affiliation')]")
    private WebElement addAnotherAffiliationButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[1]")
    private WebElement remove_FirstAffiliationButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[2]")
    private WebElement remove_SecondAffiliationButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[3]")
    private WebElement remove_ThirdAffiliationButton;
    
    @FindBy(xpath="//select[@id='menAvailability']")
    private WebElement residentialArea_MenDropDownList;
    @FindBy(xpath="//input[@id='menTotalArea']")
    private WebElement totalArea_MenResidentialTextbox;
    @FindBy(xpath="//input[@id='menNumberOfRooms']")
    private WebElement rooms_MenResidentialTextbox;
    @FindBy(xpath="//input[@id='menResidentialCapacity']")
    private WebElement capacity_MenResidentialTextbox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[11]")
    private WebElement menResidential_CCTVCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[12]")
    private WebElement menResidential_WardenCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[13]")
    private WebElement menResidential_MessCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[14]")
    private WebElement menResidential_SecurityCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[15]")
    private WebElement menResidential_BackupCheckBox;
    @FindBy(xpath="//input[@id='menRemarks']")
    private WebElement remark_MenResidentialTextbox;
    @FindBy(xpath="//select[@id='womenAvailability']")
    private WebElement residentialArea_WomenDropDownList;
    @FindBy(xpath="//input[@id='womenTotalArea']")
    private WebElement totalArea_WomenResidentialTextbox;
    @FindBy(xpath="//input[@id='womenNumberOfRooms']")
    private WebElement rooms_WomenResidentialTextbox;
    @FindBy(xpath="//input[@id='womenResidentialFacility']")
    private WebElement capacity_WomenResidentialTextbox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[16]")
    private WebElement womenResidential_CCTVCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[17]")
    private WebElement womenResidential_WardenCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[18]")
    private WebElement womenResidential_MessCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[19]")
    private WebElement womenResidential_SecurityCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[20]")
    private WebElement womenResidential_BackupCheckBox;
    @FindBy(xpath="//input[@id='womenRemarks']")
    private WebElement remark_WomenResidentialTextbox;
    
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[1]")
    private WebElement facility_DiffrentialyAbled_WashRoomCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[2]")
    private WebElement facility_DiffrentialyAbled_RampsCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[3]")
    private WebElement facility_DiffrentialyAbled_LiftsCheckBox;
    //@FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[4]")
    //private WebElement facility_MaleWashRoomCheckBox;
    //@FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[5]")
    //private WebElement facility_FemaleWashRoomCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[4]")
    private WebElement facility_HousekeepingStaffCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[5]")
    private WebElement facility_CleanAndHygieneWashRoomCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[6]")
    private WebElement facility_InspectionCardCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[7]")
    private WebElement facility_DrinkingWaterCheckBox;
    @FindBy(id="safeDrinkingWater")
    private WebElement safeDrinkingWaterDropDownList;
    @FindBy(xpath="//select[@id='fireEquipment']")
    private WebElement fireEquipmentAvailablityDropDownList;
    //@FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[10]")
    //private WebElement display_FirstAidKitCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[8]")
    private WebElement display_WallMountedFirstAidKitCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[9]")
    private WebElement display_FireSafetyInstructionCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[10]")
    private WebElement firstAidKit_EmergencyTelephoneNumberCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[11]")
    private WebElement firstAidKit_SterileGauzePadsCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[12]")
    private WebElement firstAidKit_MedicineCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[13]")
    private WebElement firstAidKit_RollerBandagesCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[14]")
    private WebElement firstAidKit_AdhesiveBandagesCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-12']/span)[15]")
    private WebElement firstAidKit_ThermometerCheckBox;
    
    /*@FindBy(xpath="(//select[@formcontrolname='programName'])[1]")
    private WebElement first_ProgramOfferedDropDownList;
    @FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[1]")
    private WebElement first_NsqfApprovedCheckBox;
    @FindBy(xpath="//button[@class='btn btn-outline-info']")
    private WebElement addAnotherProgramOfferedButton;
    @FindBy(xpath="(//select[@formcontrolname='programName'])[2]")
    private WebElement second_ProgramOfferedDropDownList;
    @FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[2]")
    private WebElement second_NsqfApprovedCheckBox;
    @FindBy(xpath="(//select[@formcontrolname='programName'])[3]")
    private WebElement third_ProgramOfferedDropDownList;
    @FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[3]")
    private WebElement third_NsqfApprovedCheckBox;
    @FindBy(xpath="(//select[@formcontrolname='programName'])[4]")
    private WebElement fourth_ProgramOfferedDropDownList;
    @FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[4]")
    private WebElement fourth_NsqfApprovedCheckBox;
    @FindBy(xpath="(//select[@formcontrolname='programName'])[5]")
    private WebElement fifth_ProgramOfferedDropDownList;
    @FindBy(xpath="(//label[input[@formcontrolname='nsqfApproved']]/span)[5]")
    private WebElement fifth_NsqfApprovedCheckBox;*/
   
    /*@FindBy(xpath="(//input[@placeholder='Enter the Name of the Affiliation'])[2]")
    private WebElement second_AffiliationNameTextbox;
    @FindBy(xpath="(//select[@formcontrolname='type'])[2]")
    private WebElement second_AffiliationTypeDropDownList;
    @FindBy(xpath="(//input[@name='reviewDate'])[2]")
    private WebElement second_AffiliationValidityTextbox;
    @FindBy(xpath="(//div[input[@name='reviewDate']]/div/span/i)[2]")
    private WebElement second_AffiliationValidityCalenderButton;
    @FindBy(xpath="(//textarea[@formcontrolname='breifDetails'])[2]")
    private WebElement second_BriefAboutAffiliationTextbox;
    @FindBy(xpath="(//input[@placeholder='Enter the Name of the Affiliation'])[3]")
    private WebElement third_AffiliationNameTextbox;
    @FindBy(xpath="(//select[@formcontrolname='type'])[3]")
    private WebElement third_AffiliationTypeDropDownList;
    @FindBy(xpath="(//input[@name='reviewDate'])[3]")
    private WebElement third_AffiliationValidityTextbox;
    @FindBy(xpath="(//div[input[@name='reviewDate']]/div/span/i)[3]")
    private WebElement third_AffiliationValidityCalenderButton;
    @FindBy(xpath="(//textarea[@formcontrolname='breifDetails'])[3]")
    private WebElement third_BriefAboutAffiliationTextbox;*/
    
    
    
    /*@FindBy(xpath="//input[@id='totalTrainingCentreArea']")
    private WebElement totalTCAreaTextbox;
    @FindBy(xpath="//input[@id='pmkvyCenterID']")
    private WebElement pMKVYCentreIdTextbox;*/
    @FindBy(xpath="//button[contains(text(),'Save & Next')]")
    private WebElement saveAndNextButton;
    @FindBy(xpath="//button[text()='Save As Draft']")
    private WebElement saveAsDraftButton;
    
    //Page3
    
    //@FindBy(xpath="//select[@id='classSerialNumber']")
    //private WebElement classRoomSerialNumberDropDownList;
    @FindBy(xpath="//span[text()='Add Classroom']")
    private WebElement addClassRoomButton;
    @FindBy(xpath="//input[@id='classroomCarpetArea']")
    private WebElement classRoomCarpetAreaTextbox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[4]")
    private WebElement classRoomProjectorCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[5]")
    private WebElement classRoomAirConditionerCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[6]")
    private WebElement classRoomCCTVCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[7]")
    private WebElement classRoomAdequateLightCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[8]")
    private WebElement classRoomExhaustFanCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[1]")
    private WebElement classRoomSecuredElectricWireCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[9]")
    private WebElement classRoomWellVantilatedCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[2]")
    private WebElement classRoomAvailablityOfDustbinCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[10]")
    private WebElement classRoomCleanNdHygenicCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[3]")
    private WebElement classRoomEmergencyNumberDisplayedCheckBox;
    @FindBy(xpath="//textarea[@id='classroomRemarks']")
    private WebElement classRoomRemarkTextbox;
    @FindBy(xpath="(//button[text()='Add'])[1]")
    private WebElement add_ClassRoom_Button;
    @FindBy(xpath="(//button[text()='Cancel'])[1]")
    private WebElement cancel_ClassRoom_Button;
    
    @FindBy(xpath="(//i[@title='remove'])[1]")
    private WebElement first_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[2]")
    private WebElement second_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[3]")
    private WebElement third_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[4]")
    private WebElement fourth_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[5]")
    private WebElement fifth_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[6]")
    private WebElement sixth_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[7]")
    private WebElement seventh_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[8]")
    private WebElement eighth_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[9]")
    private WebElement ninth_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[10]")
    private WebElement tenth_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[11]")
    private WebElement eleventh_RemoveButton;
    @FindBy(xpath="(//i[@title='remove'])[12]")
    private WebElement twelth_RemoveButton;
    
    @FindBy(xpath="//span[text()='Add Laboratory']")
    private WebElement addLaboratoryButton;
  //@FindBy(xpath="//select[@id='labSerialNumebr']")
    //private WebElement laboratorySerialNumberDropDownList;
    @FindBy(xpath="//input[@id='labcarpetArea']")
    private WebElement laboratoryCarpetAreaTextbox;
    @FindBy(xpath="//select[@id='type']")
    private WebElement laboratoryTypeDropDownList;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[14]")
    private WebElement laboratoryProjectorCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[15]")
    private WebElement laboratoryAirConditionerCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[16]")
    private WebElement laboratoryCCTVCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[17]")
    private WebElement laboratoryAdequateLightCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[18]")
    private WebElement laboratoryExhaustFanCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[11]")
    private WebElement laboratorySecuredElectricWireCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[19]")
    private WebElement laboratoryWellVantilatedCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[12]")
    private WebElement laboratoryAvailablityOfDustbinCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[20]")
    private WebElement laboratoryCleanNdHygenicCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[13]")
    private WebElement laboratoryEmergencyNumberDisplayedCheckBox;
    @FindBy(xpath="//textarea[@id='labremarks']")
    private WebElement laboratoryRemarkTextbox;
    @FindBy(xpath="(//button[text()='Add'])[2]")
    private WebElement add_Laboratory_Button;
    @FindBy(xpath="(//button[text()='Cancel'])[2]")
    private WebElement cancel_Laboratory_Button;
    
    @FindBy(xpath="//span[text()='Add Hybrid']")
    private WebElement addHybridButton;
    //@FindBy(xpath="//select[@id='hybridserialNumber']")
    //private WebElement hybridSerialNumberDropDownList;
    @FindBy(xpath="(//input[@id='carpetArea'])[1]")
    private WebElement hybridCarpetAreaTextbox;
    @FindBy(xpath="//select[@id='hybridType']")
    private WebElement hybridLaboratoryTypeDropDownList;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[24]")
    private WebElement hybridProjectorCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[25]")
    private WebElement hybridAirConditionerCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[26]")
    private WebElement hybridCCTVCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[27]")
    private WebElement hybridAdequateLightCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[28]")
    private WebElement hybridExhaustFanCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[21]")
    private WebElement hybridSecuredElectricWireCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[29]")
    private WebElement hybridWellVantilatedCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[22]")
    private WebElement hybridAvailablityOfDustbinCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[30]")
    private WebElement hybridCleanNdHygenicCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-md-6']/span)[23]")
    private WebElement hybridEmergencyNumberDisplayedCheckBox;
    @FindBy(xpath="//textarea[@id='remarks']")
    private WebElement hybridRemarkTextbox;
    @FindBy(xpath="(//button[text()='Add'])[3]")
    private WebElement add_Hybrid_Button;
    @FindBy(xpath="(//button[text()='Cancel'])[3]")
    private WebElement cancel_Hybrid_Button;
    
    @FindBy(xpath="//span[text()='Add Job Role']")
    private WebElement addJobRoleButton;
    @FindBy(xpath="//select[@id='sector']")
    private WebElement sectorDropDownList;
    //@FindBy(xpath="//select[@id='subSectorName']")
    //private WebElement skillSubSectorDropDownList;
    @FindBy(xpath="//select[option[text()='Select Job Role Name']]")
    private WebElement jobRoleNameDropDownList;
    @FindBy(xpath="//select[@id='trainerToTraineeRatio']")
    private WebElement traineeToTrainerRatioDropDownList;
    @FindBy(xpath="//select[@id='parallelBranchesInADay']")
    private WebElement parallelBathcesNumberDropDownList;
    @FindBy(xpath="//textarea[@id='jobDescription']")
    private WebElement aboutJobRoleTextbox;
    //@FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[1]")
    //private WebElement jobRole_ClassroomCheckBox;
    //@FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[2]")
    //private WebElement jobRole_LaboratoryCheckBox;
    //@FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[3]")
    //private WebElement jobRole_HybridCheckBox;
    @FindBy(xpath="//select[@id='infrastructureNeeded']")
    private WebElement additionalAreaRequiredDropDownList;
    @FindBy(xpath="(//input[@id='carpetArea'])[2]")
    private WebElement additionalCarpetAreaTextbox;
    @FindBy(xpath="//input[@id='additionalCoveredCarpetArea']")
    private WebElement additionalCoveredCarpetAreaTextbox;
    @FindBy(xpath="//input[@id='userName']")
    private WebElement trainerIDTextbox;
    @FindBy(xpath="//select[@id='availabilityOfTrainer']")
    private WebElement trainerAvailablityDropDownList;
    @FindBy(xpath="//select[@id='typeOfResource']")
    private WebElement trainerResourceTypeDropDownList;
    @FindBy(xpath="(//button[text()='Add'])[4]")
    private WebElement add_JobRole_Button;
    @FindBy(xpath="(//button[text()='Cancel'])[4]")
    private WebElement cancel_JobRole_Button;
    
    @FindBy(xpath="(//select[option[text()='Select Classroom']])[1]")
    private WebElement associateClassroom_First_DropDownList;
    @FindBy(xpath="(//select[option[text()='Select Laboratory']])[1]")
    private WebElement associatedLaboratory_First_DropDownList;
    @FindBy(xpath="(//select[option[text()='Select Hybrid']])[1]")
    private WebElement associatedHybrid_First_DropDownList;
    @FindBy(xpath="(//select[option[text()='Select Classroom']])[2]")
    private WebElement associateClassroom_Second_DropDownList;
    @FindBy(xpath="(//select[option[text()='Select Laboratory']])[2]")
    private WebElement associatedLaboratory_Second_DropDownList;
    @FindBy(xpath="(//select[option[text()='Select Hybrid']])[2]")
    private WebElement associatedHybrid_Second_DropDownList;
    @FindBy(xpath="(//input[@formcontrolname='availabilityQuantity'])[1]")
    private WebElement first_AvailableQuantity_EquipmentTextbox;
    @FindBy(xpath="(//input[@formcontrolname='availabilityQuantity'])[2]")
    private WebElement second_AvailableQuantity_EquipmentTextbox;
    @FindBy(xpath="(//input[@formcontrolname='availabilityQuantity'])[3]")
    private WebElement third_AvailableQuantity_EquipmentTextbox;
    @FindBy(xpath="(//input[@formcontrolname='availabilityQuantity'])[4]")
    private WebElement fourth_AvailableQuantity_EquipmentTextbox;
    @FindBy(xpath="(//input[@formcontrolname='remarks'])[1]")
    private WebElement first_Remark_ForEquipmentTextbox;
    @FindBy(xpath="(//input[@formcontrolname='remarks'])[2]")
    private WebElement second_Remark_ForEquipmentTextbox;
    @FindBy(xpath="(//input[@formcontrolname='remarks'])[3]")
    private WebElement third_Remark_ForEquipmentTextbox;
    @FindBy(xpath="(//input[@formcontrolname='remarks'])[4]")
    private WebElement fourth_Remark_ForEquipmentTextbox;
    
    @FindBy(xpath="//button[contains(text(),'Next')]")
    private WebElement nextButton;
    
    /*@FindBy(xpath="//select[@id='classroomAvailableForOtherJobRole']")
    private WebElement classRoomAvailablityforJobRoleDropDownList;
    @FindBy(xpath="//select[@id='labjobRoleName']")
    private WebElement laboratoryAvailablityforJobRoleDropDownList;
    @FindBy(xpath="//select[@id='jobRoleName']")
    private WebElement hybridAvailableforJobRoleDropDownList;*/
    
    /*@FindBy(xpath="//select[@id='userName']")
    private WebElement trainerSerialNumberDropDownList;
    @FindBy(xpath="//input[@id='trainerName']")
    private WebElement trainerNameTextbox;
    @FindBy(xpath="//input[@id='aadhaarNumber']")
    private WebElement trainerAdharNumberTextbox;
    @FindBy(xpath="//button[contains(text(),'Verify')]")
    private WebElement verifyAadharNumberButton;
    @FindBy(xpath="//select[@id='trainerSSCCertified']")
    private WebElement trainer_SSCCertifiedDropDownList;
    @FindBy(xpath="//select[@id='highestQualification']")
    private WebElement trainerHighestQualificationDropDownList;
    @FindBy(xpath="//select[@id='minimumQualification']")
    private WebElement trainerMinimumQualificationDropDownList;
    @FindBy(xpath="//select[@id='trainerCertifiedInEntrepreneurshipByNiesbudOrSimilarAgency']")
    private WebElement trainerNIESBUDCertifiedDropDownList;
    @FindBy(xpath="//input[@id='agencyNameFromWhereEntrepreneurshipCertificationObtained']")
    private WebElement trainerAgencyNameTextbox;
    @FindBy(xpath="//input[@id='phone']")
    private WebElement trainerMobileNumberTextbox;
    @FindBy(xpath="//textarea[@id='remarks']")
    private WebElement remark_TrainerTextbox;
    @FindBy(xpath="(//select[@formcontrolname='sector'])[1]")
    private WebElement trainerrelevantSectorDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='years'])[1]")
    private WebElement trainerRelevantSectorExperienceInYearDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='months'])[1]")
    private WebElement trainerRelevantSectorExperienceInMonthsDropDownList;
    @FindBy(xpath="//button[text()='Add Sector Related Experience']")
    private WebElement relevantSectorExperience_AddButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[1]")
    private WebElement relevantSectorExperience_FirstDeleteButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[2]")
    private WebElement relevantSectorExperience_SecondDeleteButton;
    @FindBy(xpath="(//select[@formcontrolname='sector'])[2]")
    private WebElement teachingRelevantSectorDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='years'])[2]")
    private WebElement year_TeachingExperienceDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='months'])[2]")
    private WebElement month_TeachingExperienceDropDownList;
    @FindBy(xpath="//button[text()='Add Teaching Industrial Experience']")
    private WebElement teachingExperience_AddButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[3]")
    private WebElement teachingExperienceFirst_DeleteButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[4]")
    private WebElement teachingExperienceSecond_DeleteButton;
    @FindBy(xpath="//textarea[@id='address1']")
    private WebElement trainerAddressTextbox;
    @FindBy(xpath="//input[@placeholder='Enter Area Name']")
    private WebElement trainerGeoLocationTextbox;
    @FindBy(xpath="//input[@id='landmark']")
    private WebElement trainerLandmarkTextbox;
    @FindBy(xpath="//input[@id='pincode']")
    private WebElement trainerPinCodeTextbox;
    @FindBy(xpath="//select[@id='state']")
    private WebElement trainerStateDropDownList;
    @FindBy(xpath="//select[@id='district']")
    private WebElement trainerDistrictDropDownList;
    @FindBy(xpath="//select[@id='tehsil']")
    private WebElement trainerTehsilDropDownList;
    @FindBy(xpath="//select[@id='city']")
    private WebElement trainerCityOrVillageDropDownList;
    @FindBy(xpath="//select[@id='parliamentaryConstituency']")
    private WebElement trainerParliamentryDropDownList;
    @FindBy(id="addressProofType")
    private WebElement trainerAddressProofTypeDropDownList;
    @FindBy(xpath="//input[@id='customFile']")
    private WebElement trainerAddressProof_BrowseFileButton;
    @FindBy(xpath="//button[contains(text(),'Upload')]")
    private WebElement trainerAddressProof_UploadButton;
    @FindBy(xpath="//button[text()='Download Address Proof:']")
    private WebElement downloadAddressProofButton;
    @FindBy(xpath="//input[@placeholder='Enter Available Quantity']")
    private WebElement equipmentAvailableQuantityTexbox;
    @FindBy(xpath="//input[@placeholder='Enter Remarks']")
    private WebElement equipmentRemarkTextbox;
    
    @FindBy(xpath="(//button[contains(text(),'Edit')])[1]")
    private WebElement edit_FirstJobRoleButton;
    @FindBy(xpath="(//button[contains(text(),'Edit')])[2]")
    private WebElement edit_SecondJobRoleButton;
    @FindBy(xpath="(//button[contains(text(),'Edit')])[3]")
    private WebElement edit_ThirdJobRoleButton;
    @FindBy(xpath="//button[contains(text(),'Add More Job Role')]")
    private WebElement addMoreJobRolebutton;
    @FindBy(xpath="//button[contains(text(),'Proceed')]")
    private WebElement proceedButton;*/
    
    //Page4
    @FindBy(xpath="(//select[option[text()='Select Centre Area Type']])[1]")
    private WebElement centreAreaType_FirstDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Carpet Area(In Sq.ft)'])[1]")
    private WebElement centreCarpetArea_FirstTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashRoom'])[1]")
    private WebElement centreArea_FirstWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[1]")
    private WebElement cctv_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[2]")
    private WebElement exhaustFan_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[3]")
    private WebElement wellVentilated_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[4]")
    private WebElement cleanAndHygenic_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[5]")
    private WebElement airConditioner_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[6]")
    private WebElement securedElectricWires_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[7]")
    private WebElement dustbinAvailablity_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[1]")
    private WebElement centreArea_FirstRemarkTextbox;
    
    
    //@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
    //private WebElement CentreArea_SaveAndContinueButton;
    
    @FindBy(xpath="(//select[option[text()='Select Centre Area Type']])[2]")
    private WebElement centreAreaType_SecondDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Carpet Area(In Sq.ft)'])[2]")
    private WebElement centreCarpetArea_SecondTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashRoom'])[2]")
    private WebElement centreArea_SecondWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[8]")
    private WebElement cctv_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[9]")
    private WebElement exhaustFan_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[10]")
    private WebElement wellVentilated_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[11]")
    private WebElement cleanAndHygien_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[12]")
    private WebElement airConditioner_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[13]")
    private WebElement securedElectricWires_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[14]")
    private WebElement dustbinAvailablity_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[2]")
    private WebElement centreArea_SecondRemarkTextbox;
    
    @FindBy(xpath="(//select[option[text()='Select Centre Area Type']])[3]")
    private WebElement centreAreaType_ThirdDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Carpet Area(In Sq.ft)'])[3]")
    private WebElement centreCarpetArea_ThirdTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashRoom'])[3]")
    private WebElement centreArea_ThirdWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[15]")
    private WebElement cctv_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[16]")
    private WebElement exhaustFan_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[17]")
    private WebElement wellVentilated_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[18]")
    private WebElement cleanAndHygien_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[19]")
    private WebElement airConditioner_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[20]")
    private WebElement securedElectricWires_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[21]")
    private WebElement dustbinAvailablity_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[3]")
    private WebElement centreArea_ThirdRemarkTextbox;
    
    @FindBy(xpath="(//select[option[text()='Select Centre Area Type']])[4]")
    private WebElement centreAreaType_FourthDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Carpet Area(In Sq.ft)'])[4]")
    private WebElement centreCarpetArea_FourthTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashRoom'])[4]")
    private WebElement centreArea_FourthWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[22]")
    private WebElement cctv_FourthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[23]")
    private WebElement exhaustFan_FourthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[24]")
    private WebElement wellVentilated_FourthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[25]")
    private WebElement cleanAndHygien_FourthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[26]")
    private WebElement airConditioner_FourthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[27]")
    private WebElement securedElectricWires_FourthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[28]")
    private WebElement dustbinAvailablity_FourthCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[4]")
    private WebElement centreArea_FourthRemarkTextbox;
    
    @FindBy(xpath="//select[option[text()='Select Centre Area Type']]")
    private WebElement centreAreaType_FifthDropDownList;
    @FindBy(xpath="//input[@placeholder='Enter Carpet Area (in Sq. Ft)']")
    private WebElement centreCarpetArea_FifthTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashRoom'])[1]")
    private WebElement centreArea_FifthWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[29]")
    private WebElement cctv_FifthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[30]")
    private WebElement exhaustFan_FifthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[31]")
    private WebElement wellVentilated_FifthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[32]")
    private WebElement cleanAndHygien_FifthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[33]")
    private WebElement airConditioner_FifthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[34]")
    private WebElement securedElectricWires_FifthCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[35]")
    private WebElement dustbinAvailablity_FifthCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[5]")
    private WebElement centreArea_FifthRemarkTextbox;
    @FindBy(xpath="//button[contains(text(),'Add Centre Area Type')]")
    private WebElement addAnotherCentreTypeButton;
    
    //Page5
    @FindBy(xpath="(//inputt[@id='type'])[1]")
    private WebElement first_CentreSupportStaff_TypeDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Name of Support Staff'])[1]")
    private WebElement first_CentreSupportStaff_NameTextbox;
    @FindBy(xpath="(//select[@id='highestQualification'])[1]")
    private WebElement first_CentreStaff_highestQualificationDropDownList;
    @FindBy(xpath="(//select[@id='typeOfResource'])[1]")
    private WebElement first_CentreStaff_ResourceTypeDropDownList;
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[1]")
    private WebElement first_CentreStaff_RemarkTextbox;
    @FindBy(xpath="//button[contains(text(),'Add Centre Staff Details')]")
    private WebElement centreStaff_AddButton;
    //@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
    //private WebElement centreStaff_SaveAndContinueButton;
    @FindBy(xpath="(//select[@id='type'])[2]")
    private WebElement second_CentreSupportStaff_TypeDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Name of Support Staff'])[2]")
    private WebElement second_CentreSupportStaff_NameTextbox;
    @FindBy(xpath="(//select[@id='highestQualification'])[2]")
    private WebElement second_CentreStaff_highestQualificationDropDownList;
    @FindBy(xpath="(//select[@id='typeOfResource'])[2]")
    private WebElement second_CentreStaff_ResourceTypeDropDownList;
    //@FindBy(xpath="(//textarea[@placeholder='Enter brief about the Job Role'])")
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[2]")
    private WebElement second_CentreStaff_RemarkTextbox;
    @FindBy(xpath="(//select[@id='type'])[3]")
    private WebElement third_CentreSupportStaff_TypeDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Name of Support Staff'])[3]")
    private WebElement third_CentreSupportStaff_NameTextbox;
    @FindBy(xpath="(//select[@id='highestQualification'])[3]")
    private WebElement third_CentreStaff_highestQualificationDropDownList;
    @FindBy(xpath="(//select[@id='typeOfResource'])[3]")
    private WebElement third_CentreStaff_ResourceTypeDropDownList;
    @FindBy(xpath="(//textarea[@placeholder='Enter Remarks'])[3]")
    private WebElement third_CentreStaff_RemarkTextbox;
    @FindBy(xpath="(//select[@id='type'])[4]")
    private WebElement fourth_CentreSupportStaff_TypeDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Name of Support Staff'])[4]")
    private WebElement fourth_CentreSupportStaff_NameTextbox;
    @FindBy(xpath="(//select[@id='highestQualification'])[4]")
    private WebElement fourth_CentreStaff_highestQualificationDropDownList;
    @FindBy(xpath="(//select[@id='typeOfResource'])[4]")
    private WebElement fourth_CentreStaff_ResourceTypeDropDownList;
    @FindBy(xpath="//textarea[@id='remarks']")
    private WebElement fourth_CentreStaff_RemarkTextbox;
    
    @FindBy(css=".form-control.m-input--solid.mobile-number-input")
    private WebElement mobileNumber_ForMobileApplicationTextBox;
    @FindBy(xpath="//b[contains(text(),'Get Application Link')]")
    private WebElement getApplicationLinkButton;
    
    @FindBy(xpath="//button[contains(text(),'Save & Continue to Payment')]")
    private WebElement payment_SaveAndContinueButton;
    @FindBy(xpath="//button[contains(text(),'Previous')]")
    private WebElement previousButton;
    @FindBy(xpath="//button[text()='OK']")
    private WebElement oKButton;
    @FindBy(xpath="//button[text()='Logout']")
    private WebElement logOutButton;
    @FindBy(xpath="//button[text()='Download Submitted Form']")
    private WebElement downloadSubmittedFormButton;
    
    @FindBy(xpath="//button[contains(text(),'Ok')]")
    private WebElement ok_MobileApp_Button;
    @FindBy(xpath="//button[contains(text(),'Cancel')]")
    private WebElement cancel_MobileApp_Button;
    
    @FindBy(linkText="Logout")
    private WebElement logout_ProfileButton;
    
    
    public TrainingCentre_CAAF_Page(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public void enterTpName(String tpName)
    {
    	tpNameTextbox.clear();
        tpNameTextbox.sendKeys(tpName);
    }
    
    public void enterTcName(String tcName)
    {
    	tcNameTextbox.clear();
        tcNameTextbox.sendKeys(tcName);
    }
    
    public void selectTypeOfTrainingCentre(String tcType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tcTypeDropDownList, tcType);
    }
    
    public void enterSocialmediaLinks(String socialmedia)
    {
    	socialMediaTextbox.clear();
        socialMediaTextbox.sendKeys(socialmedia);
    }
    
    public void enterWebsiteUrl(String websiteurl)
    {
    	websiteTextbox.clear();
        websiteTextbox.sendKeys(websiteurl);
    }
    
    public void enterSpocName(String spocName)
    {
    	spocNameTextbox.clear();
        spocNameTextbox.sendKeys(spocName);
    }
    
    public void enterSpocEmail(String spocEmail)
    {
    	spocEmailTextbox.clear();
        spocEmailTextbox.sendKeys(spocEmail);
    }
    
    public void enterSpocMobileNumber(String spocMobileNumber)
    {
    	spocMobileNumberTextbox.clear();
        spocMobileNumberTextbox.sendKeys(spocMobileNumber);
    }
    
    public void enterSpocAlternateNumber(String spocAltNumber)
    {
    	spocAlternateNumberTextbox.clear();
        spocAlternateNumberTextbox.sendKeys(spocAltNumber);
    }
    
    public void enterCentrePrincipal_Name(String centrePrincipalName)
    {
    	centrePrincipal_NameTextbox.clear();
        centrePrincipal_NameTextbox.sendKeys(centrePrincipalName);
    }
    
    public void enterCentrePrincipal_EmailAddress(String centrePrincipalEmail)
    {
    	centrePrincipal_EmailAddressTextBox.clear();
        centrePrincipal_EmailAddressTextBox.sendKeys(centrePrincipalEmail);
    }
    
    public void enterCentrePrincipal_ContactNumber(String centrePrincipalcontactNumber)
    {
    	centrePrincipal_ContactNumberTextbox.clear();
        centrePrincipal_ContactNumberTextbox.sendKeys(centrePrincipalcontactNumber);
    }
    
    public void enterTC_Address(String tcAddress)
    {
    	tcAddressTextbox.clear();
        tcAddressTextbox.sendKeys(tcAddress);
    }
    
    public void enterTC_NearByLandmark(String tcLandmark)
    {
    	tCNearByLandmarkTextbox.clear();
        tCNearByLandmarkTextbox.sendKeys(tcLandmark);
    }
    
    public void enterTC_PinCode(String tcPinCode)throws Exception
    {
    	ClearTextUsingBackspace.clearAll(tcPinCodeTextbox);
    	Thread.sleep(2000);
        tcPinCodeTextbox.sendKeys(tcPinCode);
    }
    
    public void selectTC_State(String tcState)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tcStateDropDownList, tcState);
    }
    
    public void selectTC_District(String tcDistrict)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tcDistrictDropDownList, tcDistrict);
    }
    
    public void selectTC_Tehsil(String tcTehsil)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tcTehsilDropDownList, tcTehsil);
    }
    
   /* public void selectTC_CityOrVillage(String tcCity)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(tcCityOrVillageDropDownList, tcCity);
    }*/
    
    public void selectTC_ParliamentryConstituency(String tcParliamentry)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tcParliamentryDropDownList, tcParliamentry);
    }
    
    public void selectTC_AddressProofType(String tcAddressProof)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tcAddressProofTypeDropDownList, tcAddressProof);
    }
    
    public void clickOnTC_AddressProof_BrowseFile()
    {
        tcAddressProof_BrowseFileButton.click();
    }
    
    public void clickOnTC_AddresssProof_UploadFile()
    {
        tcAddressProof_UploadFileButton.click();
    }
    
    public void selectTCAreaClassificationOfCentre(String tcAreaClassificationCentre)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tcAreaClassificationOfCentreDropDownList, tcAreaClassificationCentre);
    }
    
    public void selectIsEntireCentreAtGroundFloor(String centreAtGroundFloor)
    {
        SelectDropDownList.selectDropDownListByVisibleText(entireCentreatGroundFloorDropDownList, centreAtGroundFloor);
    }
    
    public void selectBuildingStatus(String buildingState)
    {
        SelectDropDownList.selectDropDownListByVisibleText(buildingStatusDropDownList, buildingState);
    }
    
    public void selectTypeOfBuildingConstruction(String buildingConstruction)
    {
        SelectDropDownList.selectDropDownListByVisibleText(buildingConstructionDropDownList, buildingConstruction);
    }
    
    public void selectProximityForPublicTransportSystem(String transportSystem)
    {
        SelectDropDownList.selectDropDownListByVisibleText(publicTransportSystemDropDownList, transportSystem);
    }
    
    public void enterNearestTransportName(String transportName)
    {
    	nearestTransportNameTextbox.clear();
    	nearestTransportNameTextbox.sendKeys(transportName);
    }
    
    public void selectBuildingFrontFace(String buildingFace)
    {
        SelectDropDownList.selectDropDownListByVisibleText(buildingFrontFaceDropDownList, buildingFace);
    }
    
    public void enterApproachRoadWidth(String approachRoadWidth)throws Exception
    {
    	ClearTextUsingBackspace.clearAll(approachRoadWidthTextbox);
    	Thread.sleep(2000);
        approachRoadWidthTextbox.sendKeys(approachRoadWidth);
    }
    
    public void selectPreviousStateOfBuilding(String previousBuildingState)
    {
        SelectDropDownList.selectDropDownListByVisibleText(buildingPreviousStateDropDownList, previousBuildingState);
    }
    
    public void clickOnBuildingPreviousState_BrowseFile()
    {
    	buildingPreviousState_BrowseFileButton.click();
    }
    
    public void clickOnBuildingPreviousState_UploadFile()
    {
        buildingPreviousState_UploadButton.click();
    }
    
    public void clickOnAllFacilitiesCheckBoxes()
    {
        List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
    	for(int i=0;i<5;i++)
    	{
    		WebElement ele = element.get(i);
    		ele.click();
    	}
    	
    }
    
    public void clickOnFacility_SecurityGuard()
    {
        facility_SecurityGuardCheckBox.click();
    }
    
    public void clickOnFacility_WellCondition()
    {
        facility_WellConditionCheckBox.click();
    }
    
    public void clickOnFacility_Biometric()
    {
        facility_BiometricCheckBox.click();
    }
    
    public void clickOnFacility_WallsAndRoofCondition()
    {
        facility_WallAndRoofConditionCheckBox.click();
    }
    
    public void clickOnFacility_Greenery()
    {
        facility_GreeneryCheckBox.click();
    }
    
    public void clickOnFacility_CentreFloorCondition()
    {
        facility_CentreFloorConditionCheckBox.click();
    }
    
    public void clickOnFacility_TiledCentreFloorCondition()
    {
        facility_CentreFloorTiledCheckBox.click();
    }
    
    public void clickOnFacility_InternetAvailablity()
    {
        facility_InternetCheckBox.click();
    }
    
    public void clickOnFacility_PowerBackup()
    {
        facility_PowerBackupCheckBox.click();
    }
    
    public void clickFacility_TrainingCentreFunctional()
    {
        facility_TCFunctionalCheckBox.click();
    }
    
    public void selectTypeOfCentreFloor(String centreFloorType)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(typeOfCentreFloorDropDownList, centreFloorType);
    }
    
    public void selectTypeOfTrainingCentreWalls(String tcWallsType)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(typeOfTrainingCentreWallsDropDownList, tcWallsType);
    }
    
    public void selectAvailablityOfInternet(String internetAvailablity)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(availablityOfInternetDropDownlist, internetAvailablity);
    }
    
    public void enterFirst_NameofAffiliation(String firstAffiliationName)
    {
    	first_AffiliationNameTextbox.clear();
        first_AffiliationNameTextbox.sendKeys(firstAffiliationName);
    }
    
    public void selectFirst_TypeOfAffiliation(String firstAffiliationType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(first_AffiliationTypeDropDownList, firstAffiliationType);
    }
    
    public void enterFirst_Affiliation_StartDate()
    {
    	first_Affiliation_StartDateTextbox.click();
    	first_Affiliation_StartDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
    }
    
    public void enterFirst_Affiliation_EndDate()
    {
    	first_Affiliation_EndDateTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
    }
    
    public void enterFirst_BriefAboutTheAffiliation(String firstAboutAffiliation)
    {
    	first_BriefAboutAffiliationTextbox.clear();
        first_BriefAboutAffiliationTextbox.sendKeys(firstAboutAffiliation);
    }
    
    public void clickOnAddAnotherAffiliation()
    {
    	addAnotherAffiliationButton.click();
    }
    
    public void clickOnRemove_FirstAffiliation()
    {
    	remove_FirstAffiliationButton.click();
    }
    
    public void clickOnRemove_SecondAffiliation()
    {
    	remove_SecondAffiliationButton.click();
    }
    
    public void clickOnRemove_ThirdAffiliation()
    {
    	remove_ThirdAffiliationButton.click();
    }
    
    public void selectMen_ResidentialAreaAvailable(String menResidentialArea)
    {
        SelectDropDownList.selectDropDownListByVisibleText(residentialArea_MenDropDownList, menResidentialArea);
    }
    
    public void enterMen_TotalAreaOfResidential(String totalAreaMenResidential)
    {
    	totalArea_MenResidentialTextbox.clear();
        totalArea_MenResidentialTextbox.sendKeys(totalAreaMenResidential);
    }
    
    public void enterMen_NumberOfRooms(String roomsNumberMenResidential)
    {
    	rooms_MenResidentialTextbox.clear();
        rooms_MenResidentialTextbox.sendKeys(roomsNumberMenResidential);
    }
    
    public void enterMen_ResidentialCapacity(String residentialCapacityMen)
    {
    	capacity_MenResidentialTextbox.clear();
        capacity_MenResidentialTextbox.sendKeys(residentialCapacityMen);
    }
    
    public void clickOnMenResidentialArea_EquippedWithAll()
    {
    	List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
     	for(int i=5;i<9;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickCCTV_MenResidential()
    {
        menResidential_CCTVCheckBox.click();
    }
    
    public void clickWarden_MenResidential()
    {
        menResidential_WardenCheckBox.click();
    }
    
    public void clickMess_MenResidential()
    {
        menResidential_MessCheckBox.click();
    }
    
    public void clickSecurityforMenResidential()
    {
        menResidential_SecurityCheckBox.click();
    }
    
    public void clickBackup_MenResidential()
    {
        menResidential_BackupCheckBox.click();
    }
    
    public void enterRemark_MenResidential(String remarkMenResidential)
    {
    	remark_MenResidentialTextbox.clear();
        remark_MenResidentialTextbox.sendKeys(remarkMenResidential);
    }
    
    public void selectWomen_ResidentialAreaAvailable(String womenResidentialArea)
    {
        SelectDropDownList.selectDropDownListByVisibleText(residentialArea_WomenDropDownList, womenResidentialArea);
    }
    
    public void enterWomen_TotalAreaOfResidential(String totalAreaWomenResidential)
    {
    	totalArea_WomenResidentialTextbox.clear();
        totalArea_WomenResidentialTextbox.sendKeys(totalAreaWomenResidential);
    }
    
    public void enterWomen_NumberOfRoomsForResidential(String roomsNumberWomenResidential)
    {
    	rooms_WomenResidentialTextbox.clear();
        rooms_WomenResidentialTextbox.sendKeys(roomsNumberWomenResidential);
    }
    
    public void enterWomen_ResidentialCapacity(String residentialCapacityWomen)
    {
    	capacity_WomenResidentialTextbox.clear();
        capacity_WomenResidentialTextbox.sendKeys(residentialCapacityWomen);
    }
    
    public void clickOnWomenResidentialArea_EquippedWithAll()
    {
    	List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
     	for(int i=9;i<13;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickCCTV_WomenResidential()
    {
        womenResidential_CCTVCheckBox.click();
    }
    
    public void clickWarden_WomenResidential()
    {
        womenResidential_WardenCheckBox.click();
    }
    
    public void clickMess_WomenResidential()
    {
        womenResidential_MessCheckBox.click();
    }
    
    public void clickSecurity_WomenResidential()
    {
        womenResidential_SecurityCheckBox.click();
    }
    
    public void clickBackup_WomenResidential()
    {
        womenResidential_BackupCheckBox.click();
    }
    
    public void enterRemark_WomenResidential(String remarkWomenResidential)
    {
        remark_WomenResidentialTextbox.sendKeys(remarkWomenResidential);
    }
    
    public void clickOnDiffrentlyAbled_AllFacilities() 
    {
    	List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-12']/span"));
     	for(int i=0;i<3;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickForDiffrentialyAbled_FunctionalWashRoomFacility()
    {
        facility_DiffrentialyAbled_WashRoomCheckBox.click();
    }
    
    public void clickForDiffrentlyAbled_RampsAtEntranceFacility()
    {
        facility_DiffrentialyAbled_RampsCheckBox.click();
    }
    
    public void clickForDiffrentlyAbled_LiftsFacility()
    {
        facility_DiffrentialyAbled_LiftsCheckBox.click();
    }
    
    public void clickOnAllFacilities_MaintainingHygieneAndSanitation()
    {
    	List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-12']/span"));
     	for(int i=3;i<6;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    /*public void clickForFunctionalMaleWashRoomFacility()
    {
        facility_MaleWashRoomCheckBox.click();
    }
    
    public void clickForFnctionalFemaleWashRoomFacility()
    {
        facility_FemaleWashRoomCheckBox.click();
    }*/
    
    public void clickForHousekeepingStaffFacility()
    {
        facility_HousekeepingStaffCheckBox.click();
    }
    
    public void clickForCleanAndHygenicWashRoomFacility()
    {
        facility_CleanAndHygieneWashRoomCheckBox.click();
    }
    
    public void clickForDailyInspectionCardFacility()
    {
        facility_InspectionCardCheckBox.click();
    }
    
    public void clickForSafeDrinkingWaterFacility()
    {
        facility_DrinkingWaterCheckBox.click();
    }
    
    
    public void clickOnAllFacilities_ForMedicalAndSafety()
    {
    	List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-12']/span"));
     	for(int i=6;i<20;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void selectForSafeDrinkingWater(String drinkingDater)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(safeDrinkingWaterDropDownList, drinkingDater);
    }
    
    public void selectforFireFightingEquipmentAvailablity(String fireEquipmentAvailablity)
    {
        SelectDropDownList.selectDropDownListByVisibleText(fireEquipmentAvailablityDropDownList, fireEquipmentAvailablity);
    }
    
    /*public void clickforAreaDisplay_FirstAidKit()
    {
        display_FirstAidKitCheckBox.click();
    }*/
    
    public void clickforAreaDisplay_FirstAidKitWallMounted()
    {
        display_WallMountedFirstAidKitCheckBox.click();
    }
    
    public void clickforAreaDisplay_FireSafetyInstruction()
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
    
    
    /*public void selectForFirstOfferedProgram(String firstProgramName)
    {
        SelectDropDownList.selectDropDownListByVisibleText(first_ProgramOfferedDropDownList, firstProgramName);
    }
    
    public void clickOnFirstNsqfApproved()
    {
        first_NsqfApprovedCheckBox.click();
    }
    
    public void clickOnAnotherProgramOffered()
    {
        addAnotherProgramOfferedButton.click();
    }
    
    public void selectForSecondOfferedProgram(String secondProgramName)
    {
        SelectDropDownList.selectDropDownListByVisibleText(second_ProgramOfferedDropDownList, secondProgramName);
    }
    
    public void clickOnSecondNsqfApproved()
    {
        second_NsqfApprovedCheckBox.click();
    }
    
    public void selectThirdOfferedProgram(String thirdProgramName)
    {
        SelectDropDownList.selectDropDownListByVisibleText(third_ProgramOfferedDropDownList, thirdProgramName);
    }
    
    public void clickOnThirdNsqfApproved()
    {
       third_NsqfApprovedCheckBox.click();
    }
    
    public void selectFourthProgramOffered(String fourthProgramName)
    {
        SelectDropDownList.selectDropDownListByVisibleText(fourth_ProgramOfferedDropDownList, fourthProgramName);
    }
    
    public void clickOnFourthNsqfApproved()
    {
        fourth_NsqfApprovedCheckBox.click();
    }
    
    public void selectFifthOfferedProgram(String fifthProgramName)
    {
        SelectDropDownList.selectDropDownListByVisibleText(fifth_ProgramOfferedDropDownList, fifthProgramName);
    }
    
    public void clickOnFifthNsqfApproved()
    {
        fifth_NsqfApprovedCheckBox.click();
    }
    
    public void enterSecond_NameofAffiliation(String secondAffiliationName)
    {
    	second_AffiliationNameTextbox.clear();
        second_AffiliationNameTextbox.sendKeys(secondAffiliationName);
    }
    
    public void selectSecond_TypeOfAffiliation(String secondAffiliationType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(second_AffiliationTypeDropDownList, secondAffiliationType);
    }
    
    public void clickOnSecond_ValidityOfAffiliation()
    {
        second_AffiliationValidityTextbox.click();
        second_AffiliationValidityTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);

    }
    
    public void clickOnSecond_AffiliationValidityCalender()
    {
        second_AffiliationValidityCalenderButton.click();
    }
    
    public void enterSecond_BriefAboutTheAffiliation(String secondAboutAffiliation)
    {
    	second_BriefAboutAffiliationTextbox.clear();
        second_BriefAboutAffiliationTextbox.sendKeys(secondAboutAffiliation);
    }
    
    public void enterThird_NameofAffiliation(String thirdAffiliationName)
    {
    	third_AffiliationNameTextbox.clear();
        third_AffiliationNameTextbox.sendKeys(thirdAffiliationName);
    }
    
    public void selectThird_TypeOfAffiliation(String thirdAffiliationType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(third_AffiliationTypeDropDownList, thirdAffiliationType);
    }
    
    public void clickOnThird_ValidityOfAffiliation()
    {
        third_AffiliationValidityTextbox.click();
        third_AffiliationValidityTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);

    }
    
    public void clickOnThird_AffiliationValidityCalender()
    {
        third_AffiliationValidityCalenderButton.click();
    }
    
    public void enterThird_BriefAboutTheAffiliation(String thirdAboutAffiliation)
    {
    	third_BriefAboutAffiliationTextbox.clear();
        third_BriefAboutAffiliationTextbox.sendKeys(thirdAboutAffiliation);
    }*/
    
    
    
    /*public void enterTotalTCArea(String tcTotalArea)
    {
    	totalTCAreaTextbox.clear();
        totalTCAreaTextbox.sendKeys(tcTotalArea);
    }
    
    public void enterPMKVYCentreId(String pMKVYCentreId)
    {
    	pMKVYCentreIdTextbox.clear();
        pMKVYCentreIdTextbox.sendKeys(pMKVYCentreId);
    }*/
    
    public void clickOnSaveAndNext()
    {
        saveAndNextButton.click();
    }
    
    public void clickOnSaveAsDraft()
    {
        saveAsDraftButton.click();
    }
    
    //Page3
    
    /*public void selectClassRoomSerialNumber(String serialNumber)
    {
        SelectDropDownList.selectDropDownListByVisibleText(classRoomSerialNumberDropDownList, serialNumber);
    }*/
    
    public void clickOnAddClassRoom()
    {
    	addClassRoomButton.click();
    }
    
    public void enterClassRoomCarpetArea(String classRoomCarpetArea)
    {
    	classRoomCarpetAreaTextbox.clear();
    	classRoomCarpetAreaTextbox.sendKeys(classRoomCarpetArea);
    }
    
    public void clickOnClassRoomEquippedwith_ALL()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
     	for(int i=0;i<10;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    	
    }
    
    
    public void clickOnProjector_ClassRoom()
    {
        classRoomProjectorCheckBox.click();
    }
    
    public void clickOnAirConditioner_ClassRoom()
    {
        classRoomAirConditionerCheckBox.click();
    }
    
    public void clickOnCCTV_ClassRoom()
    {
        classRoomCCTVCheckBox.click();
    }
    
    public void clickOnAdequateLight_ClassRoom()
    {
        classRoomAdequateLightCheckBox.click();
    }
    
    public void clickOnExhaustFan_ClassRoom()
    {
        classRoomExhaustFanCheckBox.click();
    }
    
    public void clickOnSecuredElectricWire_ClassRoom()
    {
        classRoomSecuredElectricWireCheckBox.click();
    }
    
    public void clickOnWellVantilated_ClassRoom()
    {
        classRoomWellVantilatedCheckBox.click();
    }
    
    public void clickOnAvailiblityOfDustbin_ClassRoom()
    {
        classRoomAvailablityOfDustbinCheckBox.click();
    }
    
    public void clickOnCleanAndHygenic_ClassRoom()
    {
        classRoomCleanNdHygenicCheckBox.click();
    }
    
    public void clickOnEmergencyNumberDisplayed_ClassRoom()
    {
        classRoomEmergencyNumberDisplayedCheckBox.click();
    }
    
    public void enterClassRoomRemark(String remark)
    {
    	classRoomRemarkTextbox.clear();
        classRoomRemarkTextbox.sendKeys(remark);
    }
    
    public void clickOn_Add_ForClassRoom()
    {
    	add_ClassRoom_Button.click();
    }
    
    public void clickOn_Cancel_ForClassRoom()
    {
    	cancel_ClassRoom_Button.click();
    }
    
    public void clickOnFirst_Remove()
    {
    	first_RemoveButton.click();
    }
    
    public void clickOnSecond_Remove()
    {
    	second_RemoveButton.click();
    }
    
    public void clickOnThird_Remove()
    {
    	third_RemoveButton.click();
    }
    
    public void clickOnFourth_Remove()
    {
    	fourth_RemoveButton.click();
    }
    
    public void clickOnFifth_Remove()
    {
    	fifth_RemoveButton.click();
    }
    
    public void clickOnSixth_Remove()
    {
    	sixth_RemoveButton.click();
    }
    
    public void clickOnSeventh_Remove()
    {
    	seventh_RemoveButton.click();
    }
    
    public void clickOnEighth_Remove()
    {
    	eighth_RemoveButton.click();
    }
    
    public void clickOnNinth_Remove()
    {
    	ninth_RemoveButton.click();
    }
    
    public void clickOnTenth_Remove()
    {
    	tenth_RemoveButton.click();
    }
    
    public void clickOnEleventh_Remove()
    {
    	eleventh_RemoveButton.click();
    }
    
    public void clickOnTwelth_Remove()
    {
    	twelth_RemoveButton.click();
    }
    
    public void clickOnAddLaboratory()
    {
    	addLaboratoryButton.click();
    }
    
    /*public void selectLaboratorySerialNumber(String laboratorySerialNumber)
    {
        SelectDropDownList.selectDropDownListByVisibleText(laboratorySerialNumberDropDownList, laboratorySerialNumber);
    }*/
    
    public void enterLaboratoryCarpetArea(String laboratoryCarpetArea)
    {
    	laboratoryCarpetAreaTextbox.clear();
        laboratoryCarpetAreaTextbox.sendKeys(laboratoryCarpetArea);
    }
    
    public void selectLaboratoryType(String laboratoryType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(laboratoryTypeDropDownList, laboratoryType);
    }
    
    public void clickOnLaboratoryEquippedwith_ALL()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
     	for(int i=10;i<20;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    	
    }
    
    
    public void clickOnLaboratoryProjector()
    {
        laboratoryProjectorCheckBox.click();
    }
    
    public void clickOnLaboratoryAirConditioner()
    {
        laboratoryAirConditionerCheckBox.click();
    }
    
    public void clickOnLaboratoryCCTV()
    {
        laboratoryCCTVCheckBox.click();
    }
    
    public void clickOnLaboratoryAdequateLight()
    {
        laboratoryAdequateLightCheckBox.click();
    }
    
    public void clickOnLaboratoryExhaustFand()
    {
        laboratoryExhaustFanCheckBox.click();
    }
    
    public void clickOnLabboratorySecuredElectricWire()
    {
        laboratorySecuredElectricWireCheckBox.click();
    }
    
    public void clickOnLaboratoryWellVantilated()
    {
        laboratoryWellVantilatedCheckBox.click();
    }
    
    public void clickOnLaboratoryAvailiblityOfDustbin()
    {
        laboratoryAvailablityOfDustbinCheckBox.click();
    }
    
    public void clickOnLaboratoryCleanNdHygenic()
    {
        laboratoryCleanNdHygenicCheckBox.click();
    }
    
    public void clickOnLaboratoryEmergencyNumberDisplayed()
    {
        laboratoryEmergencyNumberDisplayedCheckBox.click();
    }
    
    public void enterLaboratoryRemark(String laboratoryremark)
    {
    	laboratoryRemarkTextbox.clear();
    	laboratoryRemarkTextbox.sendKeys(laboratoryremark);
    }
    
    public void clickOnAdd_ForLaboratory()
    {
    	add_Laboratory_Button.click();
    }
    
    public void clickOnCancel_ForLaboratory()
    {
    	cancel_Laboratory_Button.click();
    }
    
    public void clickOnAddHybrid()
    {
    	addHybridButton.click();
    }
    
    /*public void selectHybridSerialNumber(String hybridSerialNumber)
    {
        SelectDropDownList.selectDropDownListByVisibleText(hybridSerialNumberDropDownList, hybridSerialNumber);
    }*/
    
    public void enterHybridCarpetArea(String hybridCarpetArea)
    {
    	hybridCarpetAreaTextbox.clear();
        hybridCarpetAreaTextbox.sendKeys(hybridCarpetArea);
    }
    
    public void selectHybridLaboratoryType(String hybridLaboratoryType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(hybridLaboratoryTypeDropDownList, hybridLaboratoryType);
    }
    
    public void clickOnHybridEquippedwith_ALL()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
     	for(int i=20;i<30;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    	
    }
    
    public void clickOnHybrid_Projector()
    {
        hybridProjectorCheckBox.click();
    }
    
    public void clickOnHybrid_AirConditioner()
    {
        hybridAirConditionerCheckBox.click();
    }
    
    public void clickOnHybrid_CCTV()
    {
        hybridCCTVCheckBox.click();
    }
    
    public void clickOnHybrid_AdequateLight()
    {
        hybridAdequateLightCheckBox.click();
    }
    
    public void clickOnHybrid_ExhaustFand()
    {
        hybridExhaustFanCheckBox.click();
    }
    
    public void clickOnHybrid_SecuredElectricWire()
    {
        hybridSecuredElectricWireCheckBox.click();
    }
    
    public void clickOnHybrid_WellVantilated()
    {
        hybridWellVantilatedCheckBox.click();
    }
    
    public void clickOnHybrid_AvailiblityOfDustbin()
    {
        hybridAvailablityOfDustbinCheckBox.click();
    }
    
    public void clickOnHybrid_CleanNdHygenic()
    {
        hybridCleanNdHygenicCheckBox.click();
    }
    
    public void clickOnHybrid_EmergencyNumberDisplayed()
    {
        hybridEmergencyNumberDisplayedCheckBox.click();
    }
    
    public void enterHybridRemark(String hybridremark)
    {
    	hybridRemarkTextbox.clear();
        hybridRemarkTextbox.sendKeys(hybridremark);
    }
    
    public void clickOnAdd_ForHybrid()
    {
    	add_Hybrid_Button.click();
    }
    
    public void clickOnCancel_ForHybrid()
    {
    	cancel_Hybrid_Button.click();
    } 
    
    public void clickOnAddJobRole()
    {
    	addJobRoleButton.click();
    }
    
    public void selectSectorForJobRole(String sector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
    }
    
    /*public void selectSkillSubSector(String skillSubSector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(skillSubSectorDropDownList, skillSubSector);
    }*/
    
    public void selectForJobRoleName(String jobRollName)
    {
        SelectDropDownList.selectDropDownListByVisibleText(jobRoleNameDropDownList, jobRollName);
    }
    
    public void selectForTraineeToTrainerRatio(String traineeToTrainerRatio)
    {
        SelectDropDownList.selectDropDownListByVisibleText(traineeToTrainerRatioDropDownList, traineeToTrainerRatio);
    }
    
    public void selectParallelBathcesNumber(String parallelBatchesNumber)
    {
        SelectDropDownList.selectDropDownListByVisibleText(parallelBathcesNumberDropDownList, parallelBatchesNumber);
    }
    
    public void enterBriefAboutJobRole(String jobRole)
    {
        aboutJobRoleTextbox.sendKeys(jobRole);
    }
    
    public void clickOnJobRoleUsingAll()
    {
    	List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
    	for(int i=0;i<element.size();i++)
    	{
    		WebElement ele = element.get(i);
    		ele.click();
    	}
    }
    
    /*public void clickOnClassroom_JobRole()
    {
        jobRole_ClassroomCheckBox.click();
    }
    
    public void clickOnLaboratory_JobRole()
    {
        jobRole_LaboratoryCheckBox.click();
    }
    
    public void clickOnHybrid_JobRole()
    {
        jobRole_HybridCheckBox.click();
    }*/
    
    public void selectAdditionalAreaRequiredForJobRole(String additionalArea)
    {
        SelectDropDownList.selectDropDownListByVisibleText(additionalAreaRequiredDropDownList, additionalArea);
    }
    
    public void enterAdditionalAreaCarpetArea(String additionalCarpetArea)
    {
    	additionalCarpetAreaTextbox.clear();
        additionalCarpetAreaTextbox.sendKeys(additionalCarpetArea);
    }
    
    public void enterAdditionalCoveredCarpetArea(String coveredCarpetArea)
    {
    	additionalCoveredCarpetAreaTextbox.clear();
    	additionalCoveredCarpetAreaTextbox.sendKeys(coveredCarpetArea);
    }
    
    public void enterTrainerID(String trainerID)
    {
    	trainerIDTextbox.clear();
    	trainerIDTextbox.sendKeys(trainerID);
    }
    
    public void selectTrainerAvailablity(String trainerAvailablity)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerAvailablityDropDownList, trainerAvailablity);
    }
    
    public void selectTrainerResourceType(String trainerResourceType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerResourceTypeDropDownList, trainerResourceType);
    }
    
    public void clickOnAdd_ForJobRole()
    {
    	add_JobRole_Button.click();
    }
    
    public void clickOnCancel_ForJobRole()
    {
    	cancel_JobRole_Button.click();
    } 
    
    public void select_First_AssociatedClassroom(String classroom)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(associateClassroom_First_DropDownList, classroom);
    }
    
    public void select_First_AssociatedLaboratory(String laboratory)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(associatedLaboratory_First_DropDownList, laboratory);
    }
    
    public void select_First_AssociatedHybrid(String hybrid)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(associatedHybrid_First_DropDownList, hybrid);
    }
    
    public void select_Second_AssociatedClassroom(String classroom)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(associateClassroom_Second_DropDownList, classroom);
    }
    
    public void select_Second_AssociatedLaboratory(String laboratory)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(associatedLaboratory_Second_DropDownList, laboratory);
    }
    
    public void select_Second_AssociatedHybrid(String hybrid)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(associatedHybrid_Second_DropDownList, hybrid);
    }
    
    public void enter_First_AvailableQuantityForEquipment(String firstQuantity)
    {
    	first_AvailableQuantity_EquipmentTextbox.clear();
    	first_AvailableQuantity_EquipmentTextbox.sendKeys(firstQuantity);
    }
    
    public void enter_Second_AvailableQuantityForEquipment(String secondQuantity)
    {
    	second_AvailableQuantity_EquipmentTextbox.clear();
    	second_AvailableQuantity_EquipmentTextbox.sendKeys(secondQuantity);
    }
    
    public void enter_Third_AvailableQuantityForEquipment(String thirdQuantity)
    {
    	third_AvailableQuantity_EquipmentTextbox.clear();
    	third_AvailableQuantity_EquipmentTextbox.sendKeys(thirdQuantity);
    }
    
    public void enter_Fourth_AvailableQuantityForEquipment(String fourthQuantity)
    {
    	fourth_AvailableQuantity_EquipmentTextbox.clear();
    	fourth_AvailableQuantity_EquipmentTextbox.sendKeys(fourthQuantity);
    }
    
    public void enter_First_Remark_ForEquipment(String firstRemark)
    {
    	first_Remark_ForEquipmentTextbox.clear();
    	first_Remark_ForEquipmentTextbox.sendKeys(firstRemark);
    }
    
    public void enter_Second_Remark_ForEquipment(String secondRemark)
    {
    	second_Remark_ForEquipmentTextbox.clear();
    	second_Remark_ForEquipmentTextbox.sendKeys(secondRemark);
    }
    
    public void enter_Third_Remark_ForEquipment(String thirdRemark)
    {
    	third_Remark_ForEquipmentTextbox.clear();
    	third_Remark_ForEquipmentTextbox.sendKeys(thirdRemark);
    }
    
    public void enter_Fourth_Remark_ForEquipment(String fourthRemark)
    {
    	fourth_Remark_ForEquipmentTextbox.clear();
    	fourth_Remark_ForEquipmentTextbox.sendKeys(fourthRemark);
    }
    
    public void clickOnNext()
    {
    	nextButton.click();
    }
    
    /*public void selectClassRoomAvailablityForOtherJobRole(String classRoomAvailablity)
    {
        SelectDropDownList.selectDropDownListByVisibleText(classRoomAvailablityforJobRoleDropDownList, classRoomAvailablity);
    }
    
    
    
    public void selectLaboratoryAvailablityForJobRole(String laboratoryAvailablity)
    {
        SelectDropDownList.selectDropDownListByVisibleText(laboratoryAvailablityforJobRoleDropDownList, laboratoryAvailablity);
    }
    
    
    
    public void selectHybridAvailableForOtherJobRole(String hybridAvailable)
    {
        SelectDropDownList.selectDropDownListByVisibleText(hybridAvailableforJobRoleDropDownList, hybridAvailable);
    }*/
    
    /*public void selectTrainerSerialNumber(String trainerSerialNumber)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerSerialNumberDropDownList, trainerSerialNumber);
    }
    
    public void enterTrainerName(String trainerName)
    {
    	trainerNameTextbox.clear();
        trainerNameTextbox.sendKeys(trainerName);
    }
    
    public void enterTrainerAadharNumber(String trainerAdharNumber)
    {
    	trainerAdharNumberTextbox.clear();
        trainerAdharNumberTextbox.sendKeys(trainerAdharNumber);
    }
    
    public void clickOnVerifyAadharNumber()
    {
    	verifyAadharNumberButton.click();
    }
    
    public void selectTrainerCertifiedBySSC(String trainerSSCCertified)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainer_SSCCertifiedDropDownList, trainerSSCCertified);
    }
    
    public void selectTrainerHighestQualification(String trinerHighestQualification)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerHighestQualificationDropDownList, trinerHighestQualification);
    }
    
    public void selectTrainerMinimumQualification(String trianerMinimumQualification)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerMinimumQualificationDropDownList, trianerMinimumQualification);
    }
    
    public void selectIsTrainerNIESBUDCertified(String trainerNIESBUDCertified)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerNIESBUDCertifiedDropDownList, trainerNIESBUDCertified);
    }
    
    public void enterTrainerAgencyName(String agencyName)
    {
    	trainerAgencyNameTextbox.clear();
        trainerAgencyNameTextbox.sendKeys(agencyName);
    }
    
    public void enterTrainerMobileNumber(String trainerMobileNumber)
    {
    	trainerMobileNumberTextbox.clear();
        trainerMobileNumberTextbox.sendKeys(trainerMobileNumber);
    }
    
    public void enterTrainersRemark(String trainerRemark)
    {
    	remark_TrainerTextbox.clear();
    	remark_TrainerTextbox.sendKeys(trainerRemark);
    }
    
    public void selectTrainerRelevantSector(String trainerRelevantSector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerrelevantSectorDropDownList, trainerRelevantSector);
    }
    
    public void selectTrainerRelevantExperienceInYear(String relevantSectorExperienceInYear)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerRelevantSectorExperienceInYearDropDownList, relevantSectorExperienceInYear);
    }
    
    public void selectTrainerRelevantSectorExperienceInMonths(String relevantSectorExperienceInMonths)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerRelevantSectorExperienceInMonthsDropDownList, relevantSectorExperienceInMonths);
    }
    
    public void clickforAddRelevantSectorExperience()
    {
        relevantSectorExperience_AddButton.click();
    }
    
    public void clickOnDelete_FirstRelevantSectorExperience()
    {
        relevantSectorExperience_FirstDeleteButton.click();
    }
    
    public void clickOnDelete_SecondRelevantSectorExperience()
    {
        relevantSectorExperience_SecondDeleteButton.click();
    }
    
    public void selectTeachingRelevantSectorExperience(String teachingRelevantSector)
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
    
    public void clickOnAddforTeachingIndustrialExperience()
    {
        teachingExperience_AddButton.click();
    }
    
    public void clickOnDelete_FirstTeachingExperience()
    {
        teachingExperienceFirst_DeleteButton.click();
    }
    
    public void clickOnDelete_SecondTeachingExperience()
    {
        teachingExperienceSecond_DeleteButton.click();
    }
    
    public void enterTrainerAddress(String trainerAddress)
    {
    	trainerAddressTextbox.clear();
        trainerAddressTextbox.sendKeys(trainerAddress);
    }
    
    
    
    public void enterTrainerNearbyLandmark(String trainerLandmark)
    {
    	trainerLandmarkTextbox.clear();
        trainerLandmarkTextbox.sendKeys(trainerLandmark);
    }
    
    public void enterTrianerPinCode(String trainerPinCode)
    {
    	trainerPinCodeTextbox.clear();
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
    
    public void selectTrainerCityOrVillage(String trainerCity)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(trainerCityOrVillageDropDownList, trainerCity);
    }
    
    public void selectTrainerParliamentryConstituency(String trainerParliamentry)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainerParliamentryDropDownList, trainerParliamentry);
    }
    
    public void selectTrainersAddressProofType(String addressProofType)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(trainerAddressProofTypeDropDownList, addressProofType);
    }
    
    public void clickOnTrainerAddressProof_BrowseFile()
    {
    	trainerAddressProof_BrowseFileButton.click();
    }
    
    public void clickOnTrainerAddressProof_UploadFile()
    {
    	trainerAddressProof_UploadButton.click();
    }
    
    public void clickOnDownloadAddressProof()
    {
    	downloadAddressProofButton.click();
    	FilePreview.closeWindow(driver);
    }
    
    public void enterEquipmentAvailableQuantity(String quantityAvailable)
    {
        equipmentAvailableQuantityTexbox.sendKeys(quantityAvailable);
    }
    
    public void enterEquipmentRemark(String equipmentRemark)
    {
        equipmentRemarkTextbox.sendKeys(equipmentRemark);
    }
    
    
    public void clickOnEdit_FirstJobRole()
    {
    	edit_FirstJobRoleButton.click();
    }
    
    public void clickOnEdit_SecondJobRole()
    {
    	edit_SecondJobRoleButton.click();
    }
    
    public void clickOnEdit_ThirdJobRole()
    {
    	edit_ThirdJobRoleButton.click();
    }
    
    public void clickOnAddMoreJobRole()
    {
    	addMoreJobRolebutton.click();
    }
    
    public void clickOnProceed()
    {
    	proceedButton.click();
    }*/
    
    public void selectFirst_TypeOfCentreArea(String firstCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_FirstDropDownList, firstCentreAreaType);
    }
    
    public void enter_FirstCentreArea_CarpetArea(String firstCentreCarpetArea)
    {
    	centreCarpetArea_FirstTexbox.clear();
        centreCarpetArea_FirstTexbox.sendKeys(firstCentreCarpetArea);
    }
    
    public void select_FirstCentreArea_TypeOfWashRoom(String firstCentrWashroomType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreArea_FirstWashRoomTypeDropDownList, firstCentrWashroomType);
    }
    
    public void clickOnFirstCentreArea_EquippedWithAll()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<7;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickOn_FirstCentreArea_CCTV()
    {
        cctv_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOn_FirstCentreArea_ExhaustFan()
    {
    	exhaustFan_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOn_FirstCentreArea_WellVentilated()
    {
    	wellVentilated_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOn_FirstCentreArea_CleanAndHygenic()
    {
    	cleanAndHygenic_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOn_FirstCentreArea_AirConditioner()
    {
    	airConditioner_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOn_FirstCentreArea_SecuredElectricWires()
    {
    	securedElectricWires_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOn_FirstCentreArea_DustbinAvailablity()
    {
    	dustbinAvailablity_FirstCentreAreaCheckBox.click();
    }
    
    public void enter_FirstCentreArea_Remark(String firstCentreAreaRemark)
    {
    	centreArea_FirstRemarkTextbox.clear();
        centreArea_FirstRemarkTextbox.sendKeys(firstCentreAreaRemark);
    }
    
    public void clickForAddAnotherCentreType()
    {
        addAnotherCentreTypeButton.click();
    }
    
    /*public void clickForCentreAreaSaveAndContinue()
    {
        CentreArea_SaveAndContinueButton.click();
    }*/
    
    public void selectSecond_TypeOfCentreArea(String secondCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_SecondDropDownList, secondCentreAreaType);
    }
    
    public void enter_SecondCentreArea_CarpetArea(String secondCentreCarpetArea)
    {
    	centreCarpetArea_SecondTexbox.clear();
        centreCarpetArea_SecondTexbox.sendKeys(secondCentreCarpetArea);
    }
    
    public void select_SecondCentreArea_TypeOfWashRoom(String secondCentrWashroomType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreArea_SecondWashRoomTypeDropDownList, secondCentrWashroomType);
    }
    
    public void clickOnSecondCentreArea_EquippedWithAll()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<7;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickOn_SecondCentreArea_CCTV()
    {
        cctv_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOn_SecondCentreArea_ExhaustFan()
    {
    	exhaustFan_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOn_SecondCentreArea_WellVentilated()
    {
    	wellVentilated_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOn_SecondCentreArea_CleanAndHygenic()
    {
    	cleanAndHygien_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOn_SecondCentreArea_AirConditioner()
    {
    	airConditioner_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOn_SecondCentreArea_SecuredElectricWires()
    {
    	securedElectricWires_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOn_SecondCentreArea_DustbinAvailablity()
    {
    	dustbinAvailablity_SecondCentreAreaCheckBox.click();
    }
    
    public void enter_SecondCentreArea_Remark(String secondCentreAreaRemark)
    {
    	centreArea_SecondRemarkTextbox.clear();
        centreArea_SecondRemarkTextbox.sendKeys(secondCentreAreaRemark);
    }
    
    public void selectThird_TypeOfCentreArea(String thirdCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_ThirdDropDownList, thirdCentreAreaType);
    }
    
    public void enter_ThirdCentreArea_CarpetArea(String thirdCentreCarpetArea)
    {
    	centreCarpetArea_ThirdTexbox.clear();
        centreCarpetArea_ThirdTexbox.sendKeys(thirdCentreCarpetArea);
    }
    
    public void select_ThirdCentreArea_TypeOfWashRoom(String thirdCentrWashroomType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreArea_ThirdWashRoomTypeDropDownList, thirdCentrWashroomType);
    }
    
    public void clickOnThirdCentreArea_EquippedWithAll()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=1;i<7;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickOn_ThirdCentreArea_CCTV()
    {
        cctv_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOn_ThirdCentreArea_ExhaustFan()
    {
    	exhaustFan_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOn_ThirdCentreArea_WellVentilated()
    {
    	wellVentilated_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOn_ThirdCentreArea_CleanAndHygenic()
    {
    	cleanAndHygien_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOn_ThirdCentreArea_AirConditioner()
    {
    	airConditioner_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOn_ThirdCentreArea_SecuredElectricWires()
    {
    	securedElectricWires_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOn_ThirdCentreArea_DustbinAvailablity()
    {
    	dustbinAvailablity_ThirdCentreAreaCheckBox.click();
    }
    
    public void enter_ThirdCentreArea_Remark(String thirdCentreAreaRemark)
    {
    	centreArea_ThirdRemarkTextbox.clear();
        centreArea_ThirdRemarkTextbox.sendKeys(thirdCentreAreaRemark);
    }
    
    public void selectFourth_TypeOfCentreArea(String fourthCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_FourthDropDownList, fourthCentreAreaType);
    }
    
    public void enter_FourthCentreArea_CarpetArea(String fourthCentreCarpetArea)
    {
    	centreCarpetArea_FourthTexbox.clear();
        centreCarpetArea_FourthTexbox.sendKeys(fourthCentreCarpetArea);
    }
    
    public void select_FourthCentreArea_TypeOfWashRoom(String fourthCentrWashroomType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreArea_FourthWashRoomTypeDropDownList, fourthCentrWashroomType);
    }
    
    public void clickOnFourthCentreArea_EquippedWithAll()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=2;i<8;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickOn_FourthCentreArea_CCTV()
    {
        cctv_FourthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FourthCentreArea_ExhaustFan()
    {
    	exhaustFan_FourthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FourthCentreArea_WellVentilated()
    {
    	wellVentilated_FourthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FourthCentreArea_CleanAndHygenic()
    {
    	cleanAndHygien_FourthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FourthCentreArea_AirConditioner()
    {
    	airConditioner_FourthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FourthCentreArea_SecuredElectricWires()
    {
    	securedElectricWires_FourthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FourthCentreArea_DustbinAvailablity()
    {
    	dustbinAvailablity_FourthCentreAreaCheckBox.click();
    }
    
    public void enter_FourthCentreArea_Remark(String fourthCentreAreaRemark)
    {
    	centreArea_FourthRemarkTextbox.clear();
        centreArea_FourthRemarkTextbox.sendKeys(fourthCentreAreaRemark);
    }
    
    public void selectFifth_TypeOfCentreArea(String fifthCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_FifthDropDownList, fifthCentreAreaType);
    }
    
    public void enter_FifthCentreArea_CarpetArea(String fifthCentreCarpetArea)
    {
    	centreCarpetArea_FifthTexbox.clear();
        centreCarpetArea_FifthTexbox.sendKeys(fifthCentreCarpetArea);
    }
    
    public void select_FifthCentreArea_TypeOfWashRoom(String fifthCentrWashroomType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreArea_FifthWashRoomTypeDropDownList, fifthCentrWashroomType);
    }
    
    public void clickOnFifthCentreArea_EquippedWithAll()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=2;i<9;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickOn_FifthCentreArea_CCTV()
    {
        cctv_FifthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FifthCentreArea_ExhaustFan()
    {
    	exhaustFan_FifthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FifthCentreArea_WellVentilated()
    {
    	wellVentilated_FifthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FifthCentreArea_CleanAndHygenic()
    {
    	cleanAndHygien_FifthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FifthCentreArea_AirConditioner()
    {
    	airConditioner_FifthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FifthCentreArea_SecuredElectricWires()
    {
    	securedElectricWires_FifthCentreAreaCheckBox.click();
    }
    
    public void clickOn_FifthCentreArea_DustbinAvailablity()
    {
    	dustbinAvailablity_FifthCentreAreaCheckBox.click();
    }
    
    public void enter_FifthCentreArea_Remark(String fifthCentreAreaRemark)
    {
    	centreArea_FifthRemarkTextbox.clear();
        centreArea_FifthRemarkTextbox.sendKeys(fifthCentreAreaRemark);
    }
   
    
    
    
    
    
    public void selectFirst_TypeOfSupportStaff(String firstSupportStaffType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(first_CentreSupportStaff_TypeDropDownList, firstSupportStaffType);
    }
    
    public void enterFirst_NameOfSupportStaff(String firstSupportStaffName)
    {
    	first_CentreSupportStaff_NameTextbox.clear();
        first_CentreSupportStaff_NameTextbox.sendKeys(firstSupportStaffName);
    }
    
    public void selectFirst_HighestQualificationForCentreStaff(String firstCentreStaffHighestQualification)
    {
        SelectDropDownList.selectDropDownListByVisibleText(first_CentreStaff_highestQualificationDropDownList, firstCentreStaffHighestQualification);
    }
    
    public void selectFirst_ResourceTypeOfCentreStaff(String firstResourceType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(first_CentreStaff_ResourceTypeDropDownList, firstResourceType);
    }
    
    public void enterFirst_RemarkForCentreStaff(String firstCentreStaffRemark)
    {
    	first_CentreStaff_RemarkTextbox.clear();
        first_CentreStaff_RemarkTextbox.sendKeys(firstCentreStaffRemark);
    }
    
    public void clickForAddAnotherCentreStaff()
    {
        centreStaff_AddButton.click();
    }
    
    /*public void clickForSaveAndContinueForCentreStaff()
    {
        centreStaff_SaveAndContinueButton.click();
    }*/
    
    public void selectSecond_TypeOfSupportStaff(String secondSupportStaffType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(second_CentreSupportStaff_TypeDropDownList, secondSupportStaffType);
    }
    
    public void enterSecond_NameOfSupportStaff(String secondSupportStaffName)
    {
    	second_CentreSupportStaff_NameTextbox.clear();
        second_CentreSupportStaff_NameTextbox.sendKeys(secondSupportStaffName);
    }
    
    public void selectSecond_HighestQualificationForCentreStaff(String secondCentreStaffHighestQualification)
    {
        SelectDropDownList.selectDropDownListByVisibleText(second_CentreStaff_highestQualificationDropDownList, secondCentreStaffHighestQualification);
    }
    
    public void selectSecond_ResourceTypeOfCentreStaff(String secondResourceType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(second_CentreStaff_ResourceTypeDropDownList, secondResourceType);
    }
    
    public void enterSecond_RemarkForCentreStaff(String secondCentreStaffRemark)
    {
    	second_CentreStaff_RemarkTextbox.clear();
        second_CentreStaff_RemarkTextbox.sendKeys(secondCentreStaffRemark);
    }
    
    public void selectThird_TypeOfSupportStaff(String thirdSupportStaffType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(third_CentreSupportStaff_TypeDropDownList, thirdSupportStaffType);
    }
    
    public void enterThird_NameOfSupportStaff(String thirdSupportStaffName)
    {
    	third_CentreSupportStaff_NameTextbox.clear();
        third_CentreSupportStaff_NameTextbox.sendKeys(thirdSupportStaffName);
    }
    
    public void selectThird_HighestQualificationForCentreStaff(String thirdCentreStaffHighestQualification)
    {
        SelectDropDownList.selectDropDownListByVisibleText(third_CentreStaff_highestQualificationDropDownList, thirdCentreStaffHighestQualification);
    }
    
    public void selectThird_ResourceTypeOfCentreStaff(String thirdResourceType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(third_CentreStaff_ResourceTypeDropDownList, thirdResourceType);
    }
    
    public void enterThird_RemarkForCentreStaff(String thirdCentreStaffRemark)
    {
    	third_CentreStaff_RemarkTextbox.clear();
        third_CentreStaff_RemarkTextbox.sendKeys(thirdCentreStaffRemark);
    }
    
    public void selectFourth_TypeOfSupportStaff(String fourthSupportStaffType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(fourth_CentreSupportStaff_TypeDropDownList, fourthSupportStaffType);
    }
    
    public void enterFourth_NameOfSupportStaff(String fourthSupportStaffName)
    {
    	fourth_CentreSupportStaff_NameTextbox.clear();
        fourth_CentreSupportStaff_NameTextbox.sendKeys(fourthSupportStaffName);
    }
    
    public void selectFourth_HighestQualificationForCentreStaff(String fourthCentreStaffHighestQualification)
    {
        SelectDropDownList.selectDropDownListByVisibleText(fourth_CentreStaff_highestQualificationDropDownList, fourthCentreStaffHighestQualification);
    }
    
    public void selectFourth_ResourceTypeOfCentreStaff(String fourthResourceType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(fourth_CentreStaff_ResourceTypeDropDownList, fourthResourceType);
    }
    
    public void enterFourth_RemarkForCentreStaff(String fourthCentreStaffRemark)
    {
    	fourth_CentreStaff_RemarkTextbox.clear();
    	fourth_CentreStaff_RemarkTextbox.sendKeys(fourthCentreStaffRemark);
    }
    
    
    public void enterMobileNumberForMobileApplication(String mobileNumber)
    {
    	mobileNumber_ForMobileApplicationTextBox.clear();
        mobileNumber_ForMobileApplicationTextBox.sendKeys(mobileNumber);
    }
    
    public void clickToGetApplicationLink()
    {
        getApplicationLinkButton.click();
    }
    
    public void clickOnSaveAndContinueToPayment()
    {
        payment_SaveAndContinueButton.click();
    }
    
    public void clickOnPrevious()
    {
    	previousButton.click();
    }
    
    public void clickOnOK()
    {
    	oKButton.click();
    }
    
    public void clickOnLogOut()
    {
    	logOutButton.click();
    }
    
    public void clickOnDownloadSubmittedForm()
    {
    	downloadSubmittedFormButton.click();
    }
    
    public void clickOn_OK_ForMobileApp()
    {
    	ok_MobileApp_Button.click();
    }
    public void clickOn_Cancel_ForMobileApp()
    {
    	cancel_MobileApp_Button.click();
    }
    
    public void clickOnLogout_Profile()
    {
    	logout_ProfileButton.click();
    }
    
    
    
}

