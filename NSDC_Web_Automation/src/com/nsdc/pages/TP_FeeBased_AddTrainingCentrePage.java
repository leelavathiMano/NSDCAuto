package com.nsdc.pages;

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
	@FindBy(id="search_places")
	private WebElement geo_LocationTextbox;
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
    @FindBy(xpath="//div[label[contains(text(),'Training Room Photos')]]//input[@id='customFile']")
    private WebElement trainingRoomPhotos_BrowseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Training Room Photos')]]//button[contains(text(),'Upload')]")
    private WebElement trainingRoomPhotos_UploadButton;
    @FindBy(xpath="//div[label[contains(text(),'Laboratory Room Photos')]]//input[@id='customFile']")
    private WebElement laboratoryRoomPhotos_BrowseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Laboratory Room Photos')]]//button[contains(text(),'Upload')]")
    private WebElement laboratoryRoomPhotos_UploadButton; 
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
    @FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
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
	
	public void enterNumberOfTrainingRooms(String trainingRooms)throws Exception
	{
		ClearTextUsingBackspace.clearAll(trainingRoomNumbersTextbox);
		Thread.sleep(2000);
		trainingRoomNumbersTextbox.sendKeys(trainingRooms);
	}
	
	public void enterNumbersOfLabs(String labNumber)throws Exception
	{
		ClearTextUsingBackspace.clearAll(labNumbersTextbox);
		Thread.sleep(2000);
		labNumbersTextbox.sendKeys(labNumber);
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
	
	public void enterNumberOfMaleWashRooms(String maleWashRooms)throws Exception
	{
		ClearTextUsingBackspace.clearAll(maleWashRoomNumbersTextbox);
		Thread.sleep(2000);
		maleWashRoomNumbersTextbox.sendKeys(maleWashRooms);
	}
	
	
	public void enterNumberOfFemaleWashRooms(String femaleWashRooms)throws Exception
	{
		ClearTextUsingBackspace.clearAll(femaleWashRoomNumbersTextbox);
		Thread.sleep(2000);
		femaleWashRoomNumbersTextbox.sendKeys(femaleWashRooms);
	}
	
	public void enterNumberOfUnisexWashRooms(String unisexWashRooms)throws Exception
	{
		ClearTextUsingBackspace.clearAll(unisexWashRoomNumbersTextbox);
		Thread.sleep(2000);
		unisexWashRoomNumbersTextbox.sendKeys(unisexWashRooms);
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
		Thread.sleep(3000);
		geo_LocationTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
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
		    List <WebElement> element = driver.findElements(By.xpath("//label[@class='m-checkbox m-checkbox--default col-md-6']/span"));
	    	for(int i=0;i<element.size();i++)
	    	{
	    		WebElement ele = element.get(i);
	    		ele.click();
	    	}
	    	
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

}
