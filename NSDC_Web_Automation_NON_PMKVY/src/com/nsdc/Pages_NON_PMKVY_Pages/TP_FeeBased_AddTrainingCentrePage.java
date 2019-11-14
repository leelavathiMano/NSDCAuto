package com.nsdc.Pages_NON_PMKVY_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.ClearTextUsingBackspace;
import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_AddTrainingCentrePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='trainingCentreName']")
	private WebElement trainingCentreNameTextbox;
	@FindBy(id="activeStatus")
	private WebElement trainingCentreStatusDropDownList;
	@FindBy(id="ownership")
	private WebElement centreOwnerShipDropDownList;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement franchiseDocuments_BrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement franchiseDocuments_UploadButton;
	@FindBy(xpath="//input[@placeholder='Select Effective Date']")
	private WebElement tcDuration_StartDateButton;
	@FindBy(xpath="//input[@placeholder='Select Close Date']")
	private WebElement tcDuration_EndDateButton;
	@FindBy(xpath="(//i[@class='la la-angle-right'])[1]")
	private WebElement forwordMonthButton;
	@FindBy(xpath="(//td[text()='1'])[2]")
	private WebElement selectDateButton;
	@FindBy(id="noOfBatchesPerDay")
	private WebElement batchesPerDayTextbox;
	@FindBy(id="maximumStudentsPerBatch")
	private WebElement batchCapacityTextbox;
	@FindBy(id="annualCentreTrainingCapacity")
	private WebElement annualTrainingCentreCapacityTextbox;
	@FindBy(id="capacityUtilization")
	private WebElement capacityUtilizationTextbox;
	@FindBy(id="governmentTieUp")
	private WebElement governmentTieUpDropDownList;
	@FindBy(id="totalCapacity")
	private WebElement centreCapacityTextbox;
	@FindBy(id="centreCarpetArea")
	private WebElement centreAreaTextbox;
	@FindBy(xpath="//select[@id='totalNumberOfTrainingRooms']")
	private WebElement trainingRoomNumbersDropDownList;
	@FindBy(xpath="//select[@id='totalNumberOfLabs']")
	private WebElement labNumbersDropDownList;
	@FindBy(id="receptionCarpetArea")
	private WebElement receptionAreaTextbox;
	@FindBy(id="waitingAreaCapacity")
	private WebElement waitingAreaCapacityTextbox;
	@FindBy(xpath="//select[@id='numberOfMaleWashRooms']")
	private WebElement maleWashRoomNumbersDropDownList;
	@FindBy(xpath="//select[@id='numberOfFemaleWashRooms']")
	private WebElement femaleWashRoomNumbersDropDownList;
	@FindBy(xpath="//select[@id='numberOfTransGenderWashRooms']")
	private WebElement unisexWashRoomNumbersDropDownList;
	@FindBy(id="distanceFromNearestAirport")
	private WebElement distanceFromAirportTextbox;
	@FindBy(id="distanceFromNearestTrainStation")
	private WebElement distanceFromTrainStationTextbox;
	@FindBy(id="distanceFromNearestCityCenter")
	private WebElement distanceFromCityCentreTextbox;
	@FindBy(id="address1")
	private WebElement tcAddressTextbox;
	@FindBy(id="landmark")
	private WebElement nearbyLandmarkTextbox;
	@FindBy(xpath="//input[@id='pincode']")
	private WebElement pincodeTextbox;
	@FindBy(id="state")
	private WebElement selectStateDropDownList;
	@FindBy(id="district")
	private WebElement districtDropDownlist;
	@FindBy(id="tehsil")
	private WebElement tehsilDropDownList;
	@FindBy(id="city")
	private WebElement cityOrVillageDropDownList;
	@FindBy(id="parliamentaryConstituency")
	private WebElement parliamentryConstituencyDropDownList;
	@FindBy(id="search_places")
	private WebElement geo_LocationTextbox;
	@FindBy(id="addressProofType")
	private WebElement addressProofTypeDropDownList;
	@FindBy(xpath="//div[label[@for='addressProof']]//input[@id='customFile']")
	private WebElement addressProof_BrowseFileButton;
	@FindBy(xpath="//div[label[@for='addressProof']]//button[contains(text(),'Upload')]")
	private WebElement addressProof_UploadFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='internalConnectivity']]]]]]//span")
	private WebElement internetConectivity_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='library']]]]]]//span")
	private WebElement library_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='cafetariaDiningRoom']]]]]]//span")
	private WebElement cafeteria_FacilitycheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='parkingFacility']]]]]]//span")
	private WebElement parking_FacilityCheckbox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='powerBackupFacility']]]]]]//span")
	private WebElement powerBackup_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='firstAidKitAvailability']]]]]]//span")
	private WebElement firstAidKitAvailablity_FacilityCheckbox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='residentialTraining']]]]]]//span")
	private WebElement residentialTraining_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='biometricTrainingAttendance']]]]]]//span")
	private WebElement biometricTraineeAttendance_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='avVideoConFacility']]]]]]//span")
	private WebElement avOrVideoCon_FacilitycheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='staffRoom']]]]]]//span")
	private WebElement staffRoom_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='physicalDisabledFriendly']]]]]]//span")
	private WebElement physicalDisabledFriendly_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='threePhasePowerConnection']]]]]]//span")
	private WebElement threePhasePowerConnection_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='counsellingRoomPlacementCell']]]]]]//span")
	private WebElement counsellingRoom_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='fireSafetyEquipment']]]]]]//span")
	private WebElement fireSafetyEquipment_FacilitycheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='cctvFacility']]]]]]//span")
	private WebElement cctv_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingCentralFacade']]]]]]//span")
	private WebElement nsdcBranding_FacilityCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingCentreReception']]]]]]//span")
	private WebElement nsdcBrandingReceptionCheckBox;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingClassroom']]]]]]//span")
	private WebElement nsdcBrandingClassroomCheckBox;
	
	@FindBy(xpath="//div[div[div[div[label[input[@value='internalConnectivity']]]]]]//input[@id='customFile']")
	private WebElement internetConectivity_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='internalConnectivity']]]]]]//button[contains(text(),'Upload')]")
	private WebElement internetConectivity_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='library']]]]]]//input[@id='customFile']")
	private WebElement library_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='library']]]]]]//button[contains(text(),'Upload')]")
	private WebElement library_UploadButton;	
	@FindBy(xpath="//div[div[div[div[label[input[@value='cafetariaDiningRoom']]]]]]//input[@id='customFile']")
	private WebElement cafetaria_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='cafetariaDiningRoom']]]]]]//button[contains(text(),'Upload')]")
	private WebElement cafetaria_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='parkingFacility']]]]]]//input[@id='customFile']")
	private WebElement parkingFacility_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='parkingFacility']]]]]]//button[contains(text(),'Upload')]")
	private WebElement parkingFacility_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='powerBackupFacility']]]]]]//input[@id='customFile']")
	private WebElement powerBackupFacility_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='powerBackupFacility']]]]]]//button[contains(text(),'Upload')]")
	private WebElement powerBackupFacility_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='firstAidKitAvailability']]]]]]//input[@id='customFile']")
	private WebElement firstAidKitAvailablity_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='firstAidKitAvailability']]]]]]//button[contains(text(),'Upload')]")
	private WebElement firstAidKitAvailablity_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='residentialTraining']]]]]]//input[@id='customFile']")
	private WebElement residentialTraining_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='residentialTraining']]]]]]//button[contains(text(),'Upload')]")
	private WebElement residentialTraining_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='biometricTrainingAttendance']]]]]]//input[@id='customFile']")
	private WebElement biometricTrainingAttandence_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='biometricTrainingAttendance']]]]]]//button[contains(text(),'Upload')]")
	private WebElement biometricTrainingAttandence_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='avVideoConFacility']]]]]]//input[@id='customFile']")
	private WebElement avVideoFacility_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='avVideoConFacility']]]]]]//button[contains(text(),'Upload')]")
	private WebElement avVideoFacility_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='staffRoom']]]]]]//input[@id='customFile']")
	private WebElement staffRoom_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='staffRoom']]]]]]//button[contains(text(),'Upload')]")
	private WebElement staffRoom_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='physicalDisabledFriendly']]]]]]//input[@id='customFile']")
	private WebElement physicalDisabledFriendly_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='physicalDisabledFriendly']]]]]]//button[contains(text(),'Upload')]")
	private WebElement physicalDisabledFriendly_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='threePhasePowerConnection']]]]]]//input[@id='customFile']")
	private WebElement threePhasePowerConnection_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='threePhasePowerConnection']]]]]]//button[contains(text(),'Upload')]")
	private WebElement threePhasePowerConnection_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='fireSafetyEquipment']]]]]]//input[@id='customFile']")
	private WebElement fireSafetyEquipment_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='fireSafetyEquipment']]]]]]//button[contains(text(),'Upload')]")
	private WebElement fireSafetyEquipment_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='counsellingRoomPlacementCell']]]]]]//input[@id='customFile']")
	private WebElement counsellingRoom_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='counsellingRoomPlacementCell']]]]]]//button[contains(text(),'Upload')]")
	private WebElement counsellingRoom_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='cctvFacility']]]]]]//input[@id='customFile']")
	private WebElement cctvFacility_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='cctvFacility']]]]]]//button[contains(text(),'Upload')]")
	private WebElement cctvFacility_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingCentralFacade']]]]]]//input[@id='customFile']")
	private WebElement nsdcBranding_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingCentralFacade']]]]]]//button[contains(text(),'Upload')]")
	private WebElement nsdcBranding_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingCentreReception']]]]]]//input[@id='customFile']")
	private WebElement nsdcBrandingReception_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingCentreReception']]]]]]//button[contains(text(),'Upload')]")
	private WebElement nsdcBrandingReception_UploadButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingClassroom']]]]]]//input[@id='customFile']")
	private WebElement nsdcBrandingClassroom_BrowseFileButton;
	@FindBy(xpath="//div[div[div[div[label[input[@value='nsdcBrandingClassroom']]]]]]//button[contains(text(),'Upload')]")
	private WebElement nsdcBrandingClassroom_UploadButton;
	
	
	
	
    @FindBy(id="firstName")
    private WebElement spocNameTextbox;
    @FindBy(id="email")
    private WebElement spocEmailAddressTextbox;
    @FindBy(id="mobileNumber")
    private WebElement spocMobileNumberTextbox;
    @FindBy(id="centreSPOCDesignation")
    private WebElement spocDesignationTextbox;
    @FindBy(id="landline")
    private WebElement spocLandLineNumberTextbox;
    @FindBy(xpath="//div[label[@for='trainingRoomPhotos']]//select[@id='dropDown']")
    private WebElement trainingRoomPhotos_DropDownList;
    @FindBy(xpath="//div[label[contains(text(),'Training Room Photos')]]//input[@id='customFile']")
    private WebElement trainingRoomPhotos_BrowseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Training Room Photos')]]//button[contains(text(),'Upload')]")
    private WebElement trainingRoomPhotos_UploadButton;
    @FindBy(xpath="//div[label[@for='laboratoryRoomPhotos']]//select[@id='dropDown']")
    private WebElement laboratoryRoomPhotos_DropDownList;
    @FindBy(xpath="//div[label[contains(text(),'Laboratory Room Photos')]]//input[@id='customFile']")
    private WebElement laboratoryRoomPhotos_BrowseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Laboratory Room Photos')]]//button[contains(text(),'Upload')]")
    private WebElement laboratoryRoomPhotos_UploadButton; 
    @FindBy(xpath="//div[label[@for='maleWashroomRoomPhotos']]//select[@id='dropDown']")
    private WebElement maleWashRoomPhotos_DropDownList;
    @FindBy(xpath="//div[label[contains(text(),'Male Washroom Photos:')]]//input[@id='customFile']")
    private WebElement maleWashRoomPhotos_BrowseButton;
    @FindBy(xpath="//div[label[contains(text(),'Male Washroom Photos:')]]//button[contains(text(),'Upload')]")
    private WebElement maleWashRoomPhotos_UploadButton;
    @FindBy(xpath="//div[label[@for='femaleWashroomRoomPhotos']]//select[@id='dropDown']")
    private WebElement femaleWashRoomPhotos_DropDownList;
    @FindBy(xpath="//div[label[contains(text(),'Female Washroom Photos:')]]//input[@id='customFile']")
    private WebElement femaleWashRoomPhotos_BrowseButton;
    @FindBy(xpath="//div[label[contains(text(),'Female Washroom Photos:')]]//button[contains(text(),'Upload')]")
    private WebElement femaleWashRoomPhotos_UploadButton;
    @FindBy(xpath="//div[label[@for='unisexWashroomRoomPhotos']]//select[@id='dropDown']")
    private WebElement unisexWashRoomPhotos_DropDownList;
    @FindBy(xpath="//div[label[contains(text(),'Unisex Washroom Photos:')]]//input[@id='customFile']")
    private WebElement unisexWashRoomPhotos_BrowseButton;
    @FindBy(xpath="//div[label[contains(text(),'Unisex Washroom Photos:')]]//button[contains(text(),'Upload')]")
    private WebElement unisexWashRoom_UploadButton;
    
    @FindBy(xpath="//div[label[contains(text(),'Washroom Room Photos')]]//input[@id='customFile']")
    private WebElement washRoomPhotos_BrowseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Washroom Room Photos')]]//button[contains(text(),'Upload')]")
    private WebElement washRoomPhotos_UploadFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Cafetaria/Dining Room Photos')]]//input[@id='customFile']")
    private WebElement cafeteriaPhotos_BrowseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Cafetaria/Dining Room Photos')]]//button[contains(text(),'Upload')]")
    private WebElement cafeteriaPhotos_UploadFileButton;
    @FindBy(xpath="//button[contains(text(),'Add Sector Targets')]")
    private WebElement addSectorTargetButton;
    @FindBy(xpath="//select[@id='sector']")
    private WebElement sectorDropDownList;
    @FindBy(xpath="//select[@id='course']")
    private WebElement courseDropDownList;
    @FindBy(xpath="//input[@id='target']")
    private WebElement targetTextbox;
    @FindBy(xpath="//button[text()='Submit']")
    private WebElement submit_SectorTargetButton;
    @FindBy(xpath="//button[text()='Cancel']")
    private WebElement cancel_SectorTargetButton;
    @FindBy(xpath="(//button[contains(text(),'Save & Continue')])[1]")
    private WebElement submitButton;
    @FindBy(xpath="(//button[contains(text(),'Cancel')])[2]")
    private WebElement cancelButton;
    @FindBy(xpath="//button[text()='Yes']")
    private WebElement yesAddTrainingCentreButton;
    @FindBy(xpath="(//button[text()='Cancel'])[2]")
    private WebElement cancelAddTrainingCentreButton;
    @FindBy(xpath="//button[text()='OK']")
    private WebElement oKButton;
    @FindBy(xpath="//button[contains(text(),'Resubmit')]")
    private WebElement resubmitButton;
    
    @FindBy(xpath="(//label[input[@name='geographicalLocation']]//span)[1]")
    private WebElement ruralLocation_RadioButton;
    @FindBy(xpath="(//label[input[@name='geographicalLocation']]//span)[2]")
    private WebElement urbanLocation_RadioButton;

	
    public TP_FeeBased_AddTrainingCentrePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    
	public void enterTrainingCentreName(String trainingCentreName)
	{
		trainingCentreNameTextbox.clear();
		trainingCentreNameTextbox.sendKeys(trainingCentreName);
	}
	
	public void selectTrainingCentreStatus(String tcStatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingCentreStatusDropDownList, tcStatus);
	}
	
	public void selectForCentreOwnerShip(String ownership)
	{
		SelectDropDownList.selectDropDownListByVisibleText(centreOwnerShipDropDownList, ownership);
	}
	
	public void clickOnFranchiseDocuments_BrowseFile()
	{
		franchiseDocuments_BrowseButton.click();
	}
	
	public void clickOnFranchiseDocuments_UploadFile()
	{
		franchiseDocuments_UploadButton.click();
	}
	
	public void clickOnStartDateForTCDuration()
	{
		tcDuration_StartDateButton.click();
		tcDuration_StartDateButton.sendKeys(Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDateForTCDuration()throws Exception
	{
		for(int i=0;i<12;i++)
		{
			forwordMonthButton.click();
			
		}
		selectDateButton.click();
		Thread.sleep(5000);
		tcDuration_EndDateButton.sendKeys(Keys.TAB);
	}
	
	public void enterNumberOfBatchesPerDay(String bathesNumber)throws Exception
	{
		ClearTextUsingBackspace.clearAll(batchesPerDayTextbox);
		Thread.sleep(2000);
		batchesPerDayTextbox.sendKeys(bathesNumber);
	}
	
	public void enterMaximumNoOfStudentPerBatch(String studentNumber)throws Exception
	{
		ClearTextUsingBackspace.clearAll(batchCapacityTextbox);
		Thread.sleep(3000);
		batchCapacityTextbox.sendKeys(studentNumber);
	}
	
	public void enterAnnualCapacityOfTrainingCentre(String annualCapacity)throws Exception
	{
		ClearTextUsingBackspace.clearAll(annualTrainingCentreCapacityTextbox);
		Thread.sleep(2000);
		annualTrainingCentreCapacityTextbox.sendKeys(annualCapacity);
	}
	
	public void enterCapacityUtilization(String capacityUtilization)throws Exception
	{
		ClearTextUsingBackspace.clearAll(capacityUtilizationTextbox);
		Thread.sleep(2000);
		capacityUtilizationTextbox.sendKeys(capacityUtilization);
	}
	
	public void selectForGovernmentTieUp(String governmentTieUp)
	{
		SelectDropDownList.selectDropDownListByVisibleText(governmentTieUpDropDownList, governmentTieUp);
	}
	
	public void enterCentreCapacity(String centreCapacity)throws Exception
	{
		ClearTextUsingBackspace.clearAll(centreCapacityTextbox);
		Thread.sleep(2000);
		centreCapacityTextbox.sendKeys(centreCapacity);
	}
	
	public void entreCentreArea(String centreArea)throws Exception
	{
		ClearTextUsingBackspace.clearAll(centreAreaTextbox);
		Thread.sleep(2000);
		centreAreaTextbox.sendKeys(centreArea);
	}
	
	public void selectNumberOfTrainingRooms(String trainingRooms)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingRoomNumbersDropDownList, trainingRooms);
	}
	
	public void selectNumbersOfLabs(String labNumber)
	{
		SelectDropDownList.selectDropDownListByVisibleText(labNumbersDropDownList, labNumber);
	}
	
	public void enterReceptionAreaSize(String receptionArea)throws Exception
	{
		ClearTextUsingBackspace.clearAll(receptionAreaTextbox);
		Thread.sleep(2000);
		receptionAreaTextbox.sendKeys(receptionArea);
	}
	
	public void enterWaitingAreaCapacity(String waitingArea)throws Exception
	{
		ClearTextUsingBackspace.clearAll(waitingAreaCapacityTextbox);
		Thread.sleep(2000);
		waitingAreaCapacityTextbox.sendKeys(waitingArea);
	}
	
	public void selectNumberOfMaleWashRooms(String maleWashRooms)
	{
		SelectDropDownList.selectDropDownListByVisibleText(maleWashRoomNumbersDropDownList, maleWashRooms);
	}
	
	
	public void selectNumberOfFemaleWashRooms(String femaleWashRooms)
	{
		SelectDropDownList.selectDropDownListByVisibleText(femaleWashRoomNumbersDropDownList, femaleWashRooms);
	}
	
	public void selectNumberOfUnisexWashRooms(String unisexWashRooms)
	{
		SelectDropDownList.selectDropDownListByVisibleText(unisexWashRoomNumbersDropDownList, unisexWashRooms);
	}
	
	public void enterDistanceFromNearestAirport(String airportDistance)throws Exception
	{
		ClearTextUsingBackspace.clearAll(distanceFromAirportTextbox);
		Thread.sleep(2000);
		distanceFromAirportTextbox.sendKeys(airportDistance);
	}
	
	public void enterDistanceFromNearestTrainStation(String trainStationDistance)throws Exception
	{
		ClearTextUsingBackspace.clearAll(distanceFromTrainStationTextbox);
		Thread.sleep(2000);
		distanceFromTrainStationTextbox.sendKeys(trainStationDistance);
	}
	
	public void enterDistanceFromNearestCityCentre(String cityCentreDistance)throws Exception
	{
		ClearTextUsingBackspace.clearAll(distanceFromCityCentreTextbox);
		Thread.sleep(2000);
		distanceFromCityCentreTextbox.sendKeys(cityCentreDistance);
	}
	
	public void enterAddressOFTC(String tcAddress)
	{
		ClearTextUsingBackspace.clearAll(tcAddressTextbox);
		tcAddressTextbox.sendKeys(tcAddress);
	}
	
	public void enterNearByLandmark(String landmark)
	{
		ClearTextUsingBackspace.clearAll(nearbyLandmarkTextbox);
		nearbyLandmarkTextbox.sendKeys(landmark);
	}
	
	public void enterPincode(String pincode)
	{
		ClearTextUsingBackspace.clearAll(pincodeTextbox);
		pincodeTextbox.sendKeys(pincode);
	}
	
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectStateDropDownList, state);
	}
	
	public void selrctDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownlist, district);
	}
	
	public void selectTehsil(String tehsil)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tehsilDropDownList, tehsil);
	}
	
	public void selectCityOrVillage(String city)
	{
		SelectDropDownList.selectDropDownListByVisibleText(cityOrVillageDropDownList, city);
	}
	
	public void selectParliamentryConstituency(String parliamentryConstituency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(parliamentryConstituencyDropDownList, parliamentryConstituency);
	}
	
	public void enterGeoLocation(String geoLocation)throws Exception
	{
		ClearTextUsingBackspace.clearAll(geo_LocationTextbox);
		geo_LocationTextbox.sendKeys(geoLocation);
		Thread.sleep(5000);
		geo_LocationTextbox.sendKeys(Keys.ENTER);
	}
	
	public void selectAddressProofType(String addressProof)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addressProofTypeDropDownList, addressProof);
	}
	
	public void clickOnAddressProof_BrowseFile()
	{
		addressProof_BrowseFileButton.click();
	}
	
	public void clickOnAddressProof_UploadFile()
	{
		addressProof_UploadFileButton.click();
	}
	
	public void clickOnInternetConectivityFacility()
	{
		internetConectivity_FacilityCheckBox.click();
	}
	
	public void clickOnLibraryFacility()
	{
		library_FacilityCheckBox.click();
	}
	
	public void clickOnCafeteriaFacility()
	{
		cafeteria_FacilitycheckBox.click();
	}
	
	public void clickOnParkingFacility()
	{
		parking_FacilityCheckbox.click();
	}
	
	public void clickOnPowerBackupFacility()
	{
		powerBackup_FacilityCheckBox.click();
	}
	
	public void clickOnFirstAidKitAvailablityFacility()
	{
		firstAidKitAvailablity_FacilityCheckbox.click();
	}
	
	public void clickOnResidentialTrainingFacility()
	{
		residentialTraining_FacilityCheckBox.click();
	}
	
	public void clickOnBiometricTraineeAttendanceFacility()
	{
		biometricTraineeAttendance_FacilityCheckBox.click();
	}
	
	public void clickOnAVOrVideoConFacility()
	{
		avOrVideoCon_FacilitycheckBox.click();
	}
	
	public void clickOnStaffRoomFacility()
	{
		staffRoom_FacilityCheckBox.click();
	}
	
	public void clickOnPhysicalDisabledFriendlyFacility()
	{
		physicalDisabledFriendly_FacilityCheckBox.click();
	}
	
	public void clickOnThreePhasePowerConnectionFacility()
	{
		threePhasePowerConnection_FacilityCheckBox.click();
	}
	
	public void clickOnCounsellingRoomFacility()
	{
		counsellingRoom_FacilityCheckBox.click();
	}
	
	public void clickOnFireSafetyEquipmentFacility()
	{
		fireSafetyEquipment_FacilitycheckBox.click();
	}
	
	public void clickOnCCTVFacility()
	{
		cctv_FacilityCheckBox.click();
	}
	
	public void clickOnNSDCBrandingFacility()
	{
		nsdcBranding_FacilityCheckBox.click();
	}
	
	public void clickOnNSDCBrandingReception()
	{
		nsdcBrandingReceptionCheckBox.click();
	}
	
	public void clickOnNSDCBrandingClassroom()
	{
		nsdcBrandingClassroomCheckBox.click();
	}
	
	 public void clickOnAllFacilitiesCheckBoxes()
	    {
		    List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
	    	for(int i=0;i<element.size();i++)
	    	{
	    		WebElement ele = element.get(i);
	    		ele.click();
	    	}
	    	
	    }
	 
	 
	 public void clickOnInternetConnectivity_BrowseFile()
	 {
		 internetConectivity_BrowseFileButton.click();
	 }
	 
	 public void clickOnInternetConnectivity_UploadFile()
	 {
		 internetConectivity_UploadButton.click();
	 }
	 
	 public void clickOnLibrary_BrowseFile()
	 {
		 library_BrowseFileButton.click();
	 }
	 
	 public void clickOnLibrary_UploadFile()
	 {
		 library_UploadButton.click();
	 }
	 
	 public void clickOnCafetaria_BrowseFile()
	 {
		 cafetaria_BrowseFileButton.click();
	 }
	 
	 public void clickOnCafetaria_UploadFile()
	 {
		 cafetaria_UploadButton.click();
	 }
	 
	 public void clickOnParkingFacility_BrowseFile()
	 {
		 parkingFacility_BrowseFileButton.click();
	 }
	 
	 public void clickOnParkingFacility_UploadFile()
	 {
		 parkingFacility_UploadButton.click();
	 }
	 
	 public void clickOnPowerBackupFacility_BrowseFile()
	 {
		 powerBackupFacility_BrowseFileButton.click();
	 }
	 
	 public void clickOnPowerBackupFacility_UploadFile()
	 {
		 powerBackupFacility_UploadButton.click();
	 }
	 
	 public void clickOnFirstAidKitAvailablity_BrowseFile()
	 {
		 firstAidKitAvailablity_BrowseFileButton.click();
	 }
	 
	 public void clickOnFirstAidKitAvailablity_UploadFile()
	 {
		 firstAidKitAvailablity_UploadButton.click();
	 }
	 
	 public void clickOnResidentialTraining_BrowseFile()
	 {
		 residentialTraining_BrowseFileButton.click();
	 }
	 
	 public void clickOnResidentialTraining_UploadFile()
	 {
		 residentialTraining_UploadButton.click();
	 }
	 
	 public void clickOnBiometricTrainingAttendance_BrowseFile()
	 {
		 biometricTrainingAttandence_BrowseFileButton.click();
	 }
	 
	 public void clickOnBiometricTrainingAttendance_UploadFile()
	 {
		 biometricTrainingAttandence_UploadButton.click();
	 }
	 
	 public void clickOnAVOrVideoConFacility_BrowseFile()
	 {
		 avVideoFacility_BrowseFileButton.click();
	 }
	 
	 public void clickOnAVOrVideoConFacility_UploadFile()
	 {
		 avVideoFacility_UploadButton.click();
	 }
	 
	 public void clickOnStaffRoom_BrowseFile()
	 {
		 staffRoom_BrowseFileButton.click();
	 }
	 
	 public void clickOnStaffRoom_UploadFile()
	 {
		 staffRoom_UploadButton.click();
	 }
	 
	 public void clickOnPhysicalDisabledFriendly_BrowseFile()
	 {
		 physicalDisabledFriendly_BrowseFileButton.click();
	 }
	 
	 public void clickOnPhysicalDisabledFriendly_UploadFile()
	 {
		 physicalDisabledFriendly_UploadButton.click();
	 }
	 
	 public void clickOnThreePhasePowerConnection_BrowseFile()
	 {
		 threePhasePowerConnection_BrowseFileButton.click();
	 }
	 
	 public void clickOnThreePhasePowerConnection_UploadFile()
	 {
		 threePhasePowerConnection_UploadButton.click();
	 }
	 
	 public void clickOnFireSafetyEquipment_BrowseFile()
	 {
		 fireSafetyEquipment_BrowseFileButton.click();
	 }
	 
	 public void clickOnFireSafetyEquipment_UploadFile()
	 {
		 fireSafetyEquipment_UploadButton.click();
	 }
	 
	 public void clickOnCounsellingRoom_BrowseFile()
	 {
		 counsellingRoom_BrowseFileButton.click();
	 }
	 
	 public void clickOnCounsellingRoom_UploadFile()
	 {
		 counsellingRoom_UploadButton.click();
	 }
	 
	 public void clickOnCCTVFacility_BrowseFile()
	 {
		 cctvFacility_BrowseFileButton.click();
	 }
	 
	 public void clickOnCCTVFacility_UploadFile()
	 {
		 cctvFacility_UploadButton.click();
	 }
	 
	 public void clickOnNSDCBranding_BrowseFile()
	 {
		 nsdcBranding_BrowseFileButton.click();
	 }
	 
	 public void clickOnNSDCBranding_UploadFile()
	 {
		 nsdcBranding_UploadButton.click();
	 }
	 
	 public void clickOnNSDCReception_BrowseFile()
	 {
		 nsdcBrandingReception_BrowseFileButton.click();
	 }
	 
	 public void clickOnNSDCReception_UploadFile()
	 {
		 nsdcBrandingReception_UploadButton.click();
	 }
	 
	 public void clickOnNSDCClassroom_BrowseFile()
	 {
		 nsdcBrandingClassroom_BrowseFileButton.click();
	 }
	 
	 public void clickOnNSDCClassroom_UploadFile()
	 {
		 nsdcBrandingClassroom_UploadButton.click();
	 }
	 
	 public void enterNameOfSPOC(String spocName)
	 {
		 ClearTextUsingBackspace.clearAll(spocNameTextbox);
		 spocNameTextbox.sendKeys(spocName);
	 }
	 
	 public void enterEmailAddressOfSPOC(String spocEmail)
	 {
		 ClearTextUsingBackspace.clearAll(spocEmailAddressTextbox);
		 spocEmailAddressTextbox.sendKeys(spocEmail);
	 }
	 
	 public void enterMobileNumberOfSPOC(String spocMobile)
	 {
		 ClearTextUsingBackspace.clearAll(spocMobileNumberTextbox);
		 spocMobileNumberTextbox.sendKeys(spocMobile);
	 }
	 
	 public void enterDesignationOfSPOC(String spocDesignation)
	 {
		 ClearTextUsingBackspace.clearAll(spocDesignationTextbox);
		 spocDesignationTextbox.sendKeys(spocDesignation);
	 }
	 
	 public void enterLandLineNumberOfSPOC(String spocLandLine)
	 {
		 ClearTextUsingBackspace.clearAll(spocLandLineNumberTextbox);
		 spocLandLineNumberTextbox.sendKeys(spocLandLine);
	 }
	 
	 public void select_SrNo_TrainingRoomPhotos(String srNo_TCRoom)
	 {
		 SelectDropDownList.selectDropDownListByVisibleText(trainingRoomPhotos_DropDownList, srNo_TCRoom);
	 }
	 
	 public void clickOnTrainingRoomPhotos_BrowseFile()
	 {
		 trainingRoomPhotos_BrowseFileButton.click();
	 }
	 
	 public void clickOnTrainingRoomPhotos_UploadFile()
	 {
		 trainingRoomPhotos_UploadButton.click();
	 }
	 
	 public void select_SrNo_Laboratory(String laboratory_SrNo)
	 {
		 SelectDropDownList.selectDropDownListByVisibleText(laboratoryRoomPhotos_DropDownList, laboratory_SrNo);
	 }
	 
	 public void clickOnLaboratoryPhotos_BrowseFile()
	 {
		 laboratoryRoomPhotos_BrowseFileButton.click();
	 }
	 
	 public void clickOnLaboratoryPhotos_UploadFile()
	 {
		 laboratoryRoomPhotos_UploadButton.click();
	 }
	 
	 public void select_SrNo_ForMaleWashRoom(String maleWashRoom_SrNo)
	 {
		 SelectDropDownList.selectDropDownListByVisibleText(maleWashRoomPhotos_DropDownList, maleWashRoom_SrNo);
	 }
	 
	 public void clickOnMaleWashRoomPhotos_BrowseFile()
	 {
		 maleWashRoomPhotos_BrowseButton.click();
	 }
	 
	 public void clickOnMaleWashRoomPhotos_UploadFile()
	 {
		 maleWashRoomPhotos_UploadButton.click();
	 }
	 
	 public void select_SrNo_ForFemaleWashRoom(String femaleWashRoom_SrNo)
	 {
		 SelectDropDownList.selectDropDownListByVisibleText(femaleWashRoomPhotos_DropDownList, femaleWashRoom_SrNo);
	 }
	 
	 public void clickOnFemaleWashRoomPhotos_BrowseFile()
	 {
		 femaleWashRoomPhotos_BrowseButton.click();
	 }
	 
	 public void clickOnFemaleWashRoomPhotos_UploadFile()
	 {
		 femaleWashRoomPhotos_UploadButton.click();
	 }
	 
	 public void select_SrNo_ForUnisexWashRoom(String unisexWashRoom_SrNo)
	 {
		 SelectDropDownList.selectDropDownListByVisibleText(unisexWashRoomPhotos_DropDownList, unisexWashRoom_SrNo);
	 }
	 
	 public void clickOnUnisexWashRoomPhotos_BrowseFile()
	 {
		 unisexWashRoomPhotos_BrowseButton.click();
	 }
	 
	 public void clickOnUnisexWashRoomPhotos_UploadFile()
	 {
		 unisexWashRoom_UploadButton.click();
	 }
	 
	 public void clickOnWashRoomPhotos_BrowseFile()
	 {
		 washRoomPhotos_BrowseFileButton.click();
	 }
	 
	 public void clickOnWashRoomPhotos_UploadFile()
	 {
		 washRoomPhotos_UploadFileButton.click();
	 }
	 
	 public void clickOnCafetariaPhotos_BrowseFile()
	 {
		 cafeteriaPhotos_BrowseFileButton.click();
	 }
	 
	 public void clickOnCafetariaPhotos_UploadFile()
	 {
		 cafeteriaPhotos_UploadFileButton.click();
	 }
	 
	 public void clickOnAddSectorTarget()
	 {
		 addSectorTargetButton.click();
	 }
	 
	 public void selectSector(String sector)
	 {
		 SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	 }
	 
	 public void selectCourse(String course)
	 {
		 SelectDropDownList.selectDropDownListByVisibleText(courseDropDownList, course);
	 }
	 
	 public void enterTarget(String target)
	 {
		 targetTextbox.clear();
		 targetTextbox.sendKeys(target);
	 }
	 
	 public void clickOnSubmit_SectorTarget()
	 {
		 submit_SectorTargetButton.click();
	 }
	 
	 public void clickOnCancel_SectorTarget()
	 {
		 cancel_SectorTargetButton.click();
	 }
	 
	 public void clickOnSubmit()
	 {
		 submitButton.click();
	 }
	 
	 public void clickOnCancel()
	 {
		 cancelButton.click();
	 }
	 
	 public void clickOnYesAddTrainingCentre()
	 {
		 yesAddTrainingCentreButton.click();
	 }
	 
	 public void clickOnCancelAddTrainingCentre()
	 {
		 cancelAddTrainingCentreButton.click();
	 }
	 
	 public void clickOnOK()
	 {
		 oKButton.click();
	 }
	 
	 public void clickOnResubmit()
	 {
		 resubmitButton.click();
	 }
	 
	 public void clcikOnRuralLocation()
	 {
		 ruralLocation_RadioButton.click();
	 }
	 
	 public void clcikOnUrbanLocation()
	 {
		 urbanLocation_RadioButton.click();
	 }

}
