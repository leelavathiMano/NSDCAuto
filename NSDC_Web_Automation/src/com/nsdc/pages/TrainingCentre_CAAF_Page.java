package com.nsdc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[1]")
    private WebElement  facility_SecurityGuardCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[2]")
    private WebElement facility_WellConditionCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[3]")
    private WebElement facility_BiometricCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[4]")
    private WebElement facility_WallAndRoofConditionCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[5]")
    private WebElement facility_GreeneryCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[6]")
    private WebElement facility_CentreFloorConditionCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[7]")
    private WebElement facility_CentreFloorTiledCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[8]")
    private WebElement facility_InternetCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[9]")
    private WebElement facility_PowerBackupCheckBox;
    @FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[10]")
    private WebElement facility_TCFunctionalCheckBox;
    @FindBy(xpath="(//select[@formcontrolname='programName'])[1]")
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
    private WebElement fifth_NsqfApprovedCheckBox;
    @FindBy(xpath="//input[@id='SPOCfirstName']")
    private WebElement spocNameTextbox;
    @FindBy(xpath="//input[@id='SPOCEmail']")
    private WebElement spocEmailTextbox;
    @FindBy(xpath="//input[@id='SPOCmobileNumber']")
    private WebElement spocMobileNumberTextbox;
    @FindBy(xpath="//input[@id='SPOCaltNumber']")
    private WebElement spocAlternateNumberTextbox;
    @FindBy(xpath="//input[@placeholder='Enter full name Name of Centre Principal/Director']")
    private WebElement centrePrincipal_NameTextbox;
    @FindBy(xpath="//input[@placeholder='Enter Email Address of Centre Principal/ Director']")
    private WebElement centrePrincipal_EmailAddressTextBox;
    @FindBy(xpath="//input[@id='contactNo']")
    private WebElement centrePrincipal_ContactNumberTextbox;
    @FindBy(xpath="(//input[@placeholder='Enter the Name of the Affiliation'])[1]")
    private WebElement first_AffiliationNameTextbox;
    @FindBy(xpath="(//select[@formcontrolname='type'])[1]")
    private WebElement first_AffiliationTypeDropDownList;
    @FindBy(xpath="(//input[@name='reviewDate'])[1]")
    private WebElement first_AffiliationValidityTextbox;
    @FindBy(xpath="(//div[input[@name='reviewDate']]/div/span/i)[1]")
    private WebElement first_AffiliationValidityCalenderButton;
    @FindBy(xpath="(//textarea[@formcontrolname='breifDetails'])[1]")
    private WebElement first_BriefAboutAffiliationTextbox;
    @FindBy(xpath="//button[contains(text(),'Add Another Affiliation')]")
    private WebElement addAnotherAffiliationButton;
    @FindBy(xpath="(//input[@placeholder='Enter the Name of the Affiliation'])[2]")
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
    private WebElement third_BriefAboutAffiliationTextbox;
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
    @FindBy(xpath="//select[@id='city']")
    private WebElement tcCityOrVillageDropDownList;
    @FindBy(xpath="//select[@id='parliamentaryConstituency']")
    private WebElement tcParliamentryDropDownList;
    @FindBy(xpath="//select[@id='addressProofType']")
    private WebElement tcAddressProofTypeDropDownList;
    @FindBy(xpath="(//input[@id='customFile'])[2]")
    private WebElement tcAddressProof_BrowseFileButton;
    @FindBy(xpath="(//button[@class='btn btn-outline-success'])[2]")
    private WebElement tcAddressProof_UploadFileButton;
    @FindBy(xpath="//select[@id='areaClassificationCentre']")
    private WebElement tcAreaClassificationOfCentreDropDownList;
    @FindBy(xpath="//select[@id='isCenterAtGroundFloor']")
    private WebElement entireCentreatGroundFloorDropDownList;
    @FindBy(xpath="//input[@id='totalTrainingCentreArea']")
    private WebElement totalTCAreaTextbox;
    @FindBy(xpath="//input[@id='pmkvyCenterID']")
    private WebElement pMKVYCentreIdTextbox;
    @FindBy(xpath="//button[contains(text(),'Save & Next')]")
    private WebElement saveAndNextButton;
    @FindBy(xpath="//button[text()='Save As Draft']")
    private WebElement saveAsDraftButton;
    
    @FindBy(xpath="//select[@id='sector']")
    private WebElement skillSectorDropDownList;
    @FindBy(xpath="//select[@id='subSectorName']")
    private WebElement skillSubSectorDropDownList;
    @FindBy(xpath="//select[option[text()='Select Job Role Name']]")
    private WebElement jobRoleNameDropDownList;
    @FindBy(xpath="//select[@id='trainerToTraineeRatio']")
    private WebElement traineeToTrainerRatioDropDownList;
    @FindBy(xpath="//select[@id='parallelBranchesInADay']")
    private WebElement parallelBathcesNumberDropDownList;
    @FindBy(xpath="//textarea[@id='jobDescription']")
    private WebElement jobRoleTextbox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[1]")
    private WebElement jobRole_ClassroomCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[2]")
    private WebElement jobRole_LaboratoryCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[3]")
    private WebElement jobRole_HybridCheckBox;
    @FindBy(xpath="//select[@id='infrastructureNeeded']")
    private WebElement additionalAreaRequiredDropDownList;
    @FindBy(xpath="//input[@id='carpetArea']")
    private WebElement additionalCarpetAreaTextbox;
    @FindBy(xpath="//input[@id='additionalCoveredCarpetArea']")
    private WebElement additionalCoveredCarpetAreaTextbox;
    @FindBy(xpath="//button[contains(text(),'Next')]")
    private WebElement nextButton;
    
    @FindBy(xpath="//select[@id='classSerialNumber']")
    private WebElement classRoomSerialNumberDropDownList;
    @FindBy(xpath="//input[@id='classroomCarpetArea']")
    private WebElement classRoomCarpetAreaTextbox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[1]")
    private WebElement classRoomProjectorCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[2]")
    private WebElement classRoomAirConditionerCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[3]")
    private WebElement classRoomCCTVCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[4]")
    private WebElement classRoomAdequateLightCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[5]")
    private WebElement classRoomExhaustFanCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[6]")
    private WebElement classRoomSecuredElectricWireCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[7]")
    private WebElement classRoomWellVantilatedCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[8]")
    private WebElement classRoomAvailablityOfDustbinCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[9]")
    private WebElement classRoomCleanNdHygenicCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[10]")
    private WebElement classRoomEmergencyNumberDisplayedCheckBox;
    @FindBy(xpath="//textarea[@id='classroomRemarks']")
    private WebElement classRoomRemarkTextbox;
    @FindBy(xpath="//select[@id='classroomAvailableForOtherJobRole']")
    private WebElement classRoomAvailablityforJobRoleDropDownList;
    @FindBy(xpath="//select[@id='labSerialNumebr']")
    private WebElement laboratorySerialNumberDropDownList;
    @FindBy(xpath="//input[@id='labcarpetArea']")
    private WebElement laboratoryCarpetAreaTextbox;
    @FindBy(xpath="//select[@id='type']")
    private WebElement laboratoryTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[11]")
    private WebElement laboratoryProjectorCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[12]")
    private WebElement laboratoryAirConditionerCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[13]")
    private WebElement laboratoryCCTVCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[14]")
    private WebElement laboratoryAdequateLightCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[15]")
    private WebElement laboratoryExhaustFanCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[16]")
    private WebElement laboratorySecuredElectricWireCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[17]")
    private WebElement laboratoryWellVantilatedCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[18]")
    private WebElement laboratoryAvailablityOfDustbinCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[19]")
    private WebElement laboratoryCleanNdHygenicCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[20]")
    private WebElement laboratoryEmergencyNumberDisplayedCheckBox;
    @FindBy(xpath="//textarea[@id='labremarks']")
    private WebElement laboratoryRemarkTextbox;
    @FindBy(xpath="//select[@id='labjobRoleName']")
    private WebElement laboratoryAvailablityforJobRoleDropDownList;
    @FindBy(xpath="//select[@id='hybridserialNumber']")
    private WebElement hybridSerialNumberDropDownList;
    @FindBy(xpath="//input[@id='carpetArea']")
    private WebElement hybridCarpetAreaTextbox;
    @FindBy(xpath="//select[@id='hybridType']")
    private WebElement hybridLaboratoryTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[21]")
    private WebElement hybridProjectorCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[22]")
    private WebElement hybridAirConditionerCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[23]")
    private WebElement hybridCCTVCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[24]")
    private WebElement hybridAdequateLightCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[25]")
    private WebElement hybridExhaustFanCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[26]")
    private WebElement hybridSecuredElectricWireCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[27]")
    private WebElement hybridWellVantilatedCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[28]")
    private WebElement hybridAvailablityOfDustbinCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[29]")
    private WebElement hybridCleanNdHygenicCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[30]")
    private WebElement hybridEmergencyNumberDisplayedCheckBox;
    @FindBy(xpath="//textarea[@id='remarks']")
    private WebElement hybridRemarkTextbox;
    @FindBy(xpath="//select[@id='jobRoleName']")
    private WebElement hybridAvailableforJobRoleDropDownList;
    
    @FindBy(xpath="//select[@id='userName']")
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
    @FindBy(xpath="//select[@id='availabilityOfTrainer']")
    private WebElement trainerAvailablityDropDownList;
    @FindBy(xpath="//select[@id='typeOfResource']")
    private WebElement trainerResourceTypeDropDownList;
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
    private WebElement proceedButton;
    
    @FindBy(xpath="(//select[@id='centreAreaType'])[1]")
    private WebElement centreAreaType_FirstDropDownList;
    @FindBy(xpath="(//input[@id='carpetArea'])[1]")
    private WebElement centreCarpetArea_FirstTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashroom'])[1]")
    private WebElement centreArea_FirstWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[1]")
    private WebElement cctv_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[2]")
    private WebElement airConditioner_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[3]")
    private WebElement exhaustFan_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[4]")
    private WebElement securedElectricWire_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[5]")
    private WebElement wellVentilated_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[6]")
    private WebElement dustbinAvailablity_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[7]")
    private WebElement cleanAndHygien_FirstCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@id='remarks(optional)'])[1]")
    private WebElement centreArea_FirstRemarkTextbox;
    @FindBy(xpath="//button[contains(text(),'Add Another Centre Type')]")
    private WebElement addAnotherCentreTypeButton;
    @FindBy(xpath="//button[contains(text(),'Save & Continue')]")
    private WebElement CentreArea_SaveAndContinueButton;
    @FindBy(xpath="(//select[@id='centreAreaType'])[2]")
    private WebElement centreAreaType_SecondDropDownList;
    @FindBy(xpath="(//input[@id='carpetArea'])[2]")
    private WebElement centreCarpetArea_SecondTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashroom'])[2]")
    private WebElement centreArea_SecondWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[8]")
    private WebElement cctv_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[9]")
    private WebElement airConditioner_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[10]")
    private WebElement exhaustFan_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[11]")
    private WebElement securedElectricWire_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[12]")
    private WebElement wellVentilated_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[13]")
    private WebElement dustbinAvailablity_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[14]")
    private WebElement cleanAndHygien_SecondCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@id='remarks(optional)'])[2]")
    private WebElement centreArea_SecondRemarkTextbox;
    @FindBy(xpath="(//select[@id='centreAreaType'])[3]")
    private WebElement centreAreaType_ThirdDropDownList;
    @FindBy(xpath="(//input[@id='carpetArea'])[3]")
    private WebElement centreCarpetArea_ThirdTexbox;
    @FindBy(xpath="(//select[@id='typeOfWashroom'])[3]")
    private WebElement centreArea_ThirdWashRoomTypeDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[15]")
    private WebElement cctv_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[16]")
    private WebElement airConditioner_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[17]")
    private WebElement exhaustFan_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[18]")
    private WebElement securedElectricWire_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[19]")
    private WebElement wellVentilated_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[20]")
    private WebElement dustbinAvailablity_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[21]")
    private WebElement cleanAndHygien_ThirdCentreAreaCheckBox;
    @FindBy(xpath="(//textarea[@id='remarks(optional)'])[3]")
    private WebElement centreArea_ThirdRemarkTextbox;
    
    @FindBy(xpath="//select[@id='menAvailability']")
    private WebElement residentialArea_MenDropDownList;
    @FindBy(xpath="//input[@id='menTotalArea']")
    private WebElement totalArea_MenResidentialTextbox;
    @FindBy(xpath="//input[@id='menNumberOfRooms']")
    private WebElement rooms_MenResidentialTextbox;
    @FindBy(xpath="//input[@id='menResidentialCapacity']")
    private WebElement capacity_MenResidentialTextbox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[1]")
    private WebElement menResidential_CCTVCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[2]")
    private WebElement menResidential_WardenCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[3]")
    private WebElement menResidential_MessCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[4]")
    private WebElement menResidential_SecurityCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[5]")
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
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[6]")
    private WebElement womenResidential_CCTVCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[7]")
    private WebElement womenResidential_WardenCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[8]")
    private WebElement womenResidential_MessCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[9]")
    private WebElement womenResidential_SecurityCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[10]")
    private WebElement womenResidential_BackupCheckBox;
    @FindBy(xpath="//input[@id='womenRemarks']")
    private WebElement remark_WomenResidentialTextbox;
    
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[1]")
    private WebElement facility_DiffrentialyAbled_WashRoomCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[2]")
    private WebElement facility_DiffrentialyAbled_RampsCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[3]")
    private WebElement facility_DiffrentialyAbled_LiftsCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[4]")
    private WebElement facility_MaleWashRoomCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[5]")
    private WebElement facility_FemaleWashRoomCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[6]")
    private WebElement facility_HousekeepingStaffCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[7]")
    private WebElement facility_CleanAndHygieneWashRoomCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[8]")
    private WebElement facility_InspectionCardCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[9]")
    private WebElement facility_DrinkingWaterCheckBox;
    @FindBy(xpath="//select[@id='fireEquipment']")
    private WebElement fireEquipmentAvailablityDropDownList;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[10]")
    private WebElement display_FirstAidKitCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[11]")
    private WebElement display_WallMountedFirstAidKitCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[12]")
    private WebElement display_FireSafetyInstructionCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[13]")
    private WebElement firstAidKit_EmergencyTelephoneNumberCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[14]")
    private WebElement firstAidKit_SterileGauzePadsCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[15]")
    private WebElement firstAidKit_MedicineCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[16]")
    private WebElement firstAidKit_RollerBandagesCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[17]")
    private WebElement firstAidKit_AdhesiveBandagesCheckBox;
    @FindBy(xpath="(//label[input[@class='ng-untouched ng-pristine ng-valid']]/span)[18]")
    private WebElement firstAidKit_ThermometerCheckBox;
    
    @FindBy(xpath="(//select[@id='type'])[1]")
    private WebElement first_CentreSupportStaff_TypeDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Name of Support Staff'])[1]")
    private WebElement first_CentreSupportStaff_NameTextbox;
    @FindBy(xpath="(//select[@id='highestQualification'])[1]")
    private WebElement first_CentreStaff_highestQualificationDropDownList;
    @FindBy(xpath="(//select[@id='typeOfResource'])[1]")
    private WebElement first_CentreStaff_ResourceTypeDropDownList;
    @FindBy(xpath="(//textarea[@id='remarks'])[1]")
    private WebElement first_CentreStaff_RemarkTextbox;
    @FindBy(xpath="//button[contains(text(),'Add Another Centre Staff')]")
    private WebElement centreStaff_AddButton;
    @FindBy(xpath="//button[contains(text(),'Save & Continue')]")
    private WebElement centreStaff_SaveAndContinueButton;
    @FindBy(xpath="(//select[@id='type'])[2]")
    private WebElement second_CentreSupportStaff_TypeDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Name of Support Staff'])[2]")
    private WebElement second_CentreSupportStaff_NameTextbox;
    @FindBy(xpath="(//select[@id='highestQualification'])[2]")
    private WebElement second_CentreStaff_highestQualificationDropDownList;
    @FindBy(xpath="(//select[@id='typeOfResource'])[2]")
    private WebElement second_CentreStaff_ResourceTypeDropDownList;
    @FindBy(xpath="(//textarea[@id='remarks'])[2]")
    private WebElement second_CentreStaff_RemarkTextbox;
    @FindBy(xpath="(//select[@id='type'])[3]")
    private WebElement third_CentreSupportStaff_TypeDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Name of Support Staff'])[3]")
    private WebElement third_CentreSupportStaff_NameTextbox;
    @FindBy(xpath="(//select[@id='highestQualification'])[3]")
    private WebElement third_CentreStaff_highestQualificationDropDownList;
    @FindBy(xpath="(//select[@id='typeOfResource'])[3]")
    private WebElement third_CentreStaff_ResourceTypeDropDownList;
    @FindBy(xpath="(//textarea[@id='remarks'])[3]")
    private WebElement third_CentreStaff_RemarkTextbox;
    
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
    
    public void enterApproachRoadWidth(String approachRoadWidth)
    {
    	approachRoadWidthTextbox.clear();
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
        List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-6']"));
    	for(int i=0;i<element.size();i++)
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
    
    public void selectForFirstOfferedProgram(String firstProgramName)
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
    
    public void enterFirst_NameofAffiliation(String firstAffiliationName)
    {
    	first_AffiliationNameTextbox.clear();
        first_AffiliationNameTextbox.sendKeys(firstAffiliationName);
    }
    
    public void selectFirst_TypeOfAffiliation(String firstAffiliationType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(first_AffiliationTypeDropDownList, firstAffiliationType);
    }
    
    public void clickOnFirst_ValidityOfAffiliation()
    {
        first_AffiliationValidityTextbox.click();
        first_AffiliationValidityTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
    }
    
    public void clickOnFirst_AffiliationValidityCalender()
    {
        first_AffiliationValidityCalenderButton.click();
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
    
    public void enterTC_PinCode(String tcPinCode)
    {
    	tcPinCodeTextbox.clear();
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
    
    public void selectTC_CityOrVillage(String tcCity)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(tcCityOrVillageDropDownList, tcCity);
    }
    
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
    
    public void enterTotalTCArea(String tcTotalArea)
    {
    	totalTCAreaTextbox.clear();
        totalTCAreaTextbox.sendKeys(tcTotalArea);
    }
    
    public void enterPMKVYCentreId(String pMKVYCentreId)
    {
    	pMKVYCentreIdTextbox.clear();
        pMKVYCentreIdTextbox.sendKeys(pMKVYCentreId);
    }
    
    public void clickOnSaveAndNext()
    {
        saveAndNextButton.click();
    }
    
    public void clickOnSaveAsDraft()
    {
        saveAsDraftButton.click();
    }
    
    public void selectSkillSector(String skillSector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(skillSectorDropDownList, skillSector);
    }
    
    public void selectSkillSubSector(String skillSubSector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(skillSubSectorDropDownList, skillSubSector);
    }
    
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
        jobRoleTextbox.sendKeys(jobRole);
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
    
    public void clickOnClassroom_JobRole()
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
    }
    
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
    
    public void clickOnNext()
    {
    	nextButton.click();
    }
    
    public void selectClassRoomSerialNumber(String serialNumber)
    {
        SelectDropDownList.selectDropDownListByVisibleText(classRoomSerialNumberDropDownList, serialNumber);
    }
    
    public void enterClassRoomCarpetArea(String classRoomCarpetArea)
    {
    	classRoomCarpetAreaTextbox.clear();
    	classRoomCarpetAreaTextbox.sendKeys(classRoomCarpetArea);
    }
    
    public void clickOnClassRoomEquippedwith_ALL()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
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
    
    public void selectClassRoomAvailablityForOtherJobRole(String classRoomAvailablity)
    {
        SelectDropDownList.selectDropDownListByVisibleText(classRoomAvailablityforJobRoleDropDownList, classRoomAvailablity);
    }
    
    public void selectLaboratorySerialNumber(String laboratorySerialNumber)
    {
        SelectDropDownList.selectDropDownListByVisibleText(laboratorySerialNumberDropDownList, laboratorySerialNumber);
    }
    
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
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<10;i++)
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
    	hybridCarpetAreaTextbox.clear();
        hybridCarpetAreaTextbox.sendKeys(hybridCarpetArea);
    }
    
    public void selectHybridLaboratoryType(String hybridLaboratoryType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(hybridLaboratoryTypeDropDownList, hybridLaboratoryType);
    }
    
    public void clickOnHybridEquippedwith_ALL()
    {
    	 List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<10;i++)
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
    
    public void selectHybridAvailableForOtherJobRole(String hybridAvailable)
    {
        SelectDropDownList.selectDropDownListByVisibleText(hybridAvailableforJobRoleDropDownList, hybridAvailable);
    }
    
    public void selectTrainerSerialNumber(String trainerSerialNumber)
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
    }
    
    public void selectFirst_TypeOfCentreArea(String firstCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_FirstDropDownList, firstCentreAreaType);
    }
    
    public void enterFirst_CarpetAreaforCentre(String firstCentreCarpetArea)
    {
    	centreCarpetArea_FirstTexbox.clear();
        centreCarpetArea_FirstTexbox.sendKeys(firstCentreCarpetArea);
    }
    
    public void selectFirst_TypeOfCentreWashRoom(String firstCentrWashroomType)
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
    
    public void clickOnFirst_CentreAreaCCTV()
    {
        cctv_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOnFirst_CentreAreaAirConditioner()
    {
        airConditioner_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOnFirst_CentreAreaExhaustFan()
    {
        exhaustFan_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOnFirst_CentreAreaSecuredElectricWire()
    {
        securedElectricWire_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOnFirst_CentreAreaWellVentilated()
    {
        wellVentilated_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOnFirst_CentreAreaDustbinAvailablity()
    {
        dustbinAvailablity_FirstCentreAreaCheckBox.click();
    }
    
    public void clickOnFirst_CentreAreaCleanAndHygien()
    {
        cleanAndHygien_FirstCentreAreaCheckBox.click();
    }
    
    public void enterFirst_CentreAreaRemark(String firstCentreAreaRemark)
    {
    	centreArea_FirstRemarkTextbox.clear();
        centreArea_FirstRemarkTextbox.sendKeys(firstCentreAreaRemark);
    }
    
    public void clickForAddAnotherCentreType()
    {
        addAnotherCentreTypeButton.click();
    }
    
    public void clickForCentreAreaSaveAndContinue()
    {
        CentreArea_SaveAndContinueButton.click();
    }
    
    public void selectSecond_TypeOfCentreArea(String secondCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_SecondDropDownList, secondCentreAreaType);
    }
    
    public void enterSecond_CarpetAreaforCentre(String secondCentreCarpetArea)
    {
    	centreCarpetArea_SecondTexbox.clear();
        centreCarpetArea_SecondTexbox.sendKeys(secondCentreCarpetArea);
    }
    
    public void selectSecond_TypeOfCentreWashRoom(String secondCentrWashroomType)
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
    
    public void clickOnSecond_CentreAreaCCTV()
    {
        cctv_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOnSecond_CentreAreaAirConditioner()
    {
        airConditioner_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOnSecond_CentreAreaExhaustFan()
    {
        exhaustFan_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOnSecond_CentreAreaSecuredElectricWire()
    {
        securedElectricWire_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOnSecond_CentreAreaWellVentilated()
    {
        wellVentilated_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOnSecond_CentreAreaDustbinAvailablity()
    {
        dustbinAvailablity_SecondCentreAreaCheckBox.click();
    }
    
    public void clickOnSecond_CentreAreaCleanAndHygien()
    {
        cleanAndHygien_SecondCentreAreaCheckBox.click();
    }
    
    public void enterSecond_CentreAreaRemark(String secondCentreAreaRemark)
    {
    	centreArea_SecondRemarkTextbox.clear();
        centreArea_SecondRemarkTextbox.sendKeys(secondCentreAreaRemark);
    }
    
    public void selectThird_TypeOfCentreArea(String thirdCentreAreaType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreAreaType_ThirdDropDownList, thirdCentreAreaType);
    }
    
    public void enterThird_CarpetAreaforCentre(String thirdCentreCarpetArea)
    {
    	centreCarpetArea_ThirdTexbox.clear();
        centreCarpetArea_ThirdTexbox.sendKeys(thirdCentreCarpetArea);
    }
    
    public void selectThird_TypeOfCentreWashRoom(String thirdCentrWashroomType)
    {
        SelectDropDownList.selectDropDownListByVisibleText(centreArea_ThirdWashRoomTypeDropDownList, thirdCentrWashroomType);
    }
    
    public void clickOnThirdCentreArea_EquippedWithAll()
    {
    	List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<7;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickOnThird_CentreAreaCCTV()
    {
        cctv_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOnThird_CentreAreaAirConditioner()
    {
        airConditioner_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOnThird_CentreAreaExhaustFan()
    {
        exhaustFan_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOnThird_CentreAreaSecuredElectricWire()
    {
        securedElectricWire_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOnThird_CentreAreaWellVentilated()
    {
        wellVentilated_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOnThird_CentreAreaDustbinAvailablity()
    {
        dustbinAvailablity_ThirdCentreAreaCheckBox.click();
    }
    
    public void clickOnThird_CentreAreaCleanAndHygien()
    {
        cleanAndHygien_ThirdCentreAreaCheckBox.click();
    }
    
    public void enterThird_CentreAreaRemark(String thirdCentreAreaRemark)
    {
    	centreArea_ThirdRemarkTextbox.clear();
        centreArea_ThirdRemarkTextbox.sendKeys(thirdCentreAreaRemark);
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
    	List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<5;i++)
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
    	List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<5;i++)
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
    	List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
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
    	List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<6;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void clickForFunctionalMaleWashRoomFacility()
    {
        facility_MaleWashRoomCheckBox.click();
    }
    
    public void clickForFnctionalFemaleWashRoomFacility()
    {
        facility_FemaleWashRoomCheckBox.click();
    }
    
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
    	List <WebElement> element = driver.findElements(By.xpath("//label[input[@class='ng-untouched ng-pristine ng-valid']]/span"));
     	for(int i=0;i<9;i++)
     	{
     		WebElement ele = element.get(i);
     		ele.click();
     	}
    }
    
    public void selectforFireFightingEquipmentAvailablity(String fireEquipmentAvailablity)
    {
        SelectDropDownList.selectDropDownListByVisibleText(fireEquipmentAvailablityDropDownList, fireEquipmentAvailablity);
    }
    
    public void clickforAreaDisplay_FirstAidKit()
    {
        display_FirstAidKitCheckBox.click();
    }
    
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
    
    public void clickForSaveAndContinueForCentreStaff()
    {
        centreStaff_SaveAndContinueButton.click();
    }
    
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
    
    
    
}

