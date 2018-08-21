package com.nsdc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(id="totalNumberOfTrainingRooms")
	private WebElement trainingRoomNumbersTextbox;
	@FindBy(id="totalNumberOfLabs")
	private WebElement labNumbersTextbox;
	@FindBy(id="receptionCarpetArea")
	private WebElement receptionAreaTextbox;
	@FindBy(id="waitingAreaCapacity")
	private WebElement waitingAreaCapacityTextbox;
	@FindBy(id="numberOfMaleWashRooms")
	private WebElement maleWashRoomNumbersTextbox;
	@FindBy(id="numberOfFemaleWashRooms")
	private WebElement femaleWashRoomNumbersTextbox;
	@FindBy(id="numberOfTransGenderWashRooms")
	private WebElement unisexWashRoomNumbersTextbox;
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
	@FindBy(id="pincode")
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
	@FindBy(id="addressProofType")
	private WebElement addressProofTypeDropDownList;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[1]")
	private WebElement internetConectivity_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[2]")
	private WebElement library_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[3]")
	private WebElement cafeteria_FacilitycheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[4]")
	private WebElement parking_FacilityCheckbox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[5]")
	private WebElement powerBackup_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[6]")
	private WebElement firstAidKitAvailablity_FacilityCheckbox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[7]")
	private WebElement residentialTraining_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[8]")
	private WebElement biometricTraineeAttendance_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[9]")
	private WebElement avOrVideoCon_FacilitycheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[10]")
	private WebElement staffRoom_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[11]")
	private WebElement physicalDisabledFriendly_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[12]")
	private WebElement threePhasePowerConnection_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[13]")
	private WebElement counsellingRoom_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[14]")
	private WebElement fireSafetyEquipment_FacilitycheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[15]")
	private WebElement cctv_FacilityCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox m-checkbox--default col-6']/span)[16]")
	private WebElement nsdcBranding_FacilityCheckBox;
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
    @FindBy(xpath="(//input[@id='customFile'])[1]")
    private WebElement trainingRoomPhotos_BrowseFileButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
    private WebElement trainingRoomPhotos_UploadButton;
    @FindBy(xpath="(//input[@id='customFile'])[2]")
    private WebElement laboratoryRoomPhotos_BrowseFileButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
    private WebElement laboratoryRoomPhotos_UploadButton; 
    @FindBy(xpath="(//input[@id='customFile'])[3]")
    private WebElement washRoomPhotos_BrowseFileButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
    private WebElement washRoomPhotos_UploadFileButton;
    @FindBy(xpath="(//input[@id='customFile'])[4]")
    private WebElement cafeteriaPhotos_BrowseFileButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[4]")
    private WebElement cafeteriaPhotos_UploadFileButton;
    @FindBy(xpath="//button[contains(text(),'Save')]")
    private WebElement saveButton;
    @FindBy(xpath="//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;
    @FindBy(xpath="//button[text()='Yes, Add Training Centre']")
    private WebElement yesAddTrainingCentreButton;
    @FindBy(xpath="//button[text()='Cancel']")
    private WebElement cancelAddTrainingCentreButton;
    @FindBy(xpath="//button[text()='OK']")
    private WebElement oKButton;

	
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
	
	public void clickOnStartDateForTCDuration()
	{
		tcDuration_StartDateButton.click();
		tcDuration_StartDateButton.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnEndDateForTCDuration()
	{
		for(int i=0;i<12;i++)
		{
			forwordMonthButton.click();
			
		}
		selectDateButton.click();
		batchesPerDayTextbox.click();
	}
	
	public void enterNumberOfBatchesPerDay(String bathesNumber)
	{
		batchesPerDayTextbox.clear();
		batchesPerDayTextbox.sendKeys(bathesNumber);
	}
	
	public void enterMaximumNoOfStudentPerBatch(String studentNumber)
	{
		batchCapacityTextbox.clear();
		batchCapacityTextbox.sendKeys(studentNumber);
	}
	
	public void enterAnnualCapacityOfTrainingCentre(String annualCapacity)
	{
		annualTrainingCentreCapacityTextbox.clear();
		annualTrainingCentreCapacityTextbox.sendKeys(annualCapacity);
	}
	
	public void enterCapacityUtilization(String capacityUtilization)
	{
		capacityUtilizationTextbox.clear();
		capacityUtilizationTextbox.sendKeys(capacityUtilization);
	}
	
	public void selectForGovernmentTieUp(String governmentTieUp)
	{
		SelectDropDownList.selectDropDownListByVisibleText(governmentTieUpDropDownList, governmentTieUp);
	}
	
	public void enterCentreCapacity(String centreCapacity)
	{
		centreCapacityTextbox.clear();
		centreCapacityTextbox.sendKeys(centreCapacity);
	}
	
	public void entreCentreArea(String centreArea)
	{
		centreAreaTextbox.clear();
		centreAreaTextbox.sendKeys(centreArea);
	}
	
	public void enterNumberOfTrainingRooms(String trainingRooms)
	{
		trainingRoomNumbersTextbox.clear();
		trainingRoomNumbersTextbox.sendKeys(trainingRooms);
	}
	
	public void enterNumbersOfLabs(String labNumber)
	{
		labNumbersTextbox.clear();
		labNumbersTextbox.sendKeys(labNumber);
	}
	
	public void enterReceptionAreaSize(String receptionArea)
	{
		receptionAreaTextbox.clear();
		receptionAreaTextbox.sendKeys(receptionArea);
	}
	
	public void enterWaitingAreaCapacity(String waitingArea)
	{
		waitingAreaCapacityTextbox.clear();
		waitingAreaCapacityTextbox.sendKeys(waitingArea);
	}
	
	public void enterNumberOfMaleWashRooms(String maleWashRooms)
	{
		maleWashRoomNumbersTextbox.clear();
		maleWashRoomNumbersTextbox.sendKeys(maleWashRooms);
	}
	
	
	public void enterNumberOfFemaleWashRooms(String femaleWashRooms)
	{
		femaleWashRoomNumbersTextbox.clear();
		femaleWashRoomNumbersTextbox.sendKeys(femaleWashRooms);
	}
	
	public void enterNumberOfUnisexWashRooms(String unisexWashRooms)
	{
		unisexWashRoomNumbersTextbox.clear();
		unisexWashRoomNumbersTextbox.sendKeys(unisexWashRooms);
	}
	
	public void enterDistanceFromNearestAirport(String airportDistance)
	{
		distanceFromAirportTextbox.clear();
		distanceFromAirportTextbox.sendKeys(airportDistance);
	}
	
	public void enterDistanceFromNearestTrainStation(String trainStationDistance)
	{
		distanceFromTrainStationTextbox.clear();
		distanceFromTrainStationTextbox.sendKeys(trainStationDistance);
	}
	
	public void enterDistanceFromNearestCityCentre(String cityCentreDistance)
	{
		distanceFromCityCentreTextbox.clear();
		distanceFromCityCentreTextbox.sendKeys(cityCentreDistance);
	}
	
	public void enterAddressOFTC(String tcAddress)
	{
		tcAddressTextbox.clear();
		tcAddressTextbox.sendKeys(tcAddress);
	}
	
	public void enterNearByLandmark(String landmark)
	{
		nearbyLandmarkTextbox.clear();
		nearbyLandmarkTextbox.sendKeys(landmark);
	}
	
	public void enterPincode(String pincode)
	{
		pincodeTextbox.clear();
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
	
	public void selectAddressProofType(String addressProof)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addressProofTypeDropDownList, addressProof);
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
	
	 public void clickOnAllFacilitiesCheckBoxes()
	    {
		    List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-6']/span"));
	    	for(int i=0;i<element.size();i++)
	    	{
	    		WebElement ele = element.get(i);
	    		ele.click();
	    	}
	    	
	    }
	 
	 public void enterNameOfSPOC(String spocName)
	 {
		 spocNameTextbox.clear();
		 spocNameTextbox.sendKeys(spocName);
	 }
	 
	 public void enterEmailAddressOfSPOC(String spocEmail)
	 {
		 spocEmailAddressTextbox.clear();
		 spocEmailAddressTextbox.sendKeys(spocEmail);
	 }
	 
	 public void enterMobileNumberOfSPOC(String spocMobile)
	 {
		 spocMobileNumberTextbox.clear();
		 spocMobileNumberTextbox.sendKeys(spocMobile);
	 }
	 
	 public void enterDesignationOfSPOC(String spocDesignation)
	 {
		 spocDesignationTextbox.clear();
		 spocDesignationTextbox.sendKeys(spocDesignation);
	 }
	 
	 public void enterLandLineNumberOfSPOC(String spocLandLine)
	 {
		 spocLandLineNumberTextbox.clear();
		 spocLandLineNumberTextbox.sendKeys(spocLandLine);
	 }
	 
	 public void clickOnTrainingRoomPhotos_BrowseFile()
	 {
		 trainingRoomPhotos_BrowseFileButton.click();
	 }
	 
	 public void clickOnTrainingRoomPhotos_UploadFile()
	 {
		 trainingRoomPhotos_UploadButton.click();
	 }
	 
	 public void clickOnLaboratoryPhotos_BrowseFile()
	 {
		 laboratoryRoomPhotos_BrowseFileButton.click();
	 }
	 
	 public void clickOnLaboratoryPhotos_UploadFile()
	 {
		 laboratoryRoomPhotos_UploadButton.click();
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
	 
	 public void clickOnSave()
	 {
		 saveButton.click();
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

}
