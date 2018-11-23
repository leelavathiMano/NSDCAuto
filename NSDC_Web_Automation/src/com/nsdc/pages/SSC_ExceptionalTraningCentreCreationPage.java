package com.nsdc.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_ExceptionalTraningCentreCreationPage
{
	WebDriver driver;	
	@FindBy(xpath="//button[contains(text(),'Add Exclusive ToT/ToA Centre')]")
	private WebElement addExceptionalTCButton;
	@FindBy(xpath="//input[@formcontrolname='trainingPartnerName']")
	private WebElement trainingPartnerNameTextField;
	@FindBy(xpath="//input[@formcontrolname='trainingCenterName']")
	private WebElement exceptionalTrainingCentreNameTextField;
	@FindBy(xpath="//input[@formcontrolname='website']")
	private WebElement websiteTextField;
	@FindBy(xpath="//input[@formcontrolname='trainingCenterCapacity']")
	private WebElement trainingCentreCapacityTextField;
	@FindBy(xpath="(//label[input[@type='checkbox']])[1]")
	private WebElement residentialFacilityAvailableForMaleCheckBox;
	@FindBy(xpath="(//label[input[@type='checkbox']])[2]")
	private WebElement residentialFacilityAvailableForFemaleCheckBox;
	@FindBy(xpath="(//label[input[@type='checkbox']])[3]")
	private WebElement residentialFacilityAvailableForTransgenderCheckBox;
	@FindBy(xpath="(//input[@formcontrolname='contactPersonName'])[1]")
	private WebElement exceptionalTrainingCentreHeadNameTextField;
	@FindBy(xpath="(//input[@formcontrolname='phoneNumber'])[1]")
	private WebElement exceptionalTrainingCentreHeadMobileNumberTextField;
	@FindBy(xpath="(//input[@formcontrolname='emailId'])[1]")
	private WebElement exceptionalTrainingCentreHeadEmailTextField;
	@FindBy(xpath="(//input[@formcontrolname='contactPersonName'])[2]")
	private WebElement exceptionalTrainingCentreSPOCNameTextField;
	@FindBy(xpath="(//input[@formcontrolname='phoneNumber'])[2]")
	private WebElement exceptionalTrainingCentreSPOCMobileNumberTextField;
	@FindBy(xpath="(//input[@formcontrolname='emailId'])[2]")
	private WebElement exceptionalTrainingCentreSPOCEmailTextField;
	@FindBy(id="customFile")
	private WebElement spocIDProofBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadButton1;
	@FindBy(xpath="//input[@formcontrolname='addressLine']")
	private WebElement addressTextField;
	@FindBy(xpath="//input[@formcontrolname='landmark']")
	private WebElement landmarkTextField;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state']/div)[3]")
	private WebElement exceptionalTrainingCentreStateList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district']/div)[3]")
	private WebElement exceptionalTrainingCentreDistrictList;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='subDistrict']/div")
	private WebElement exceptionalTrainingCentreSubDistrictList;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='constituency']/div")
	private WebElement exceptionalTrainingCentreConstituencyList;
	@FindBy(id="search_places")
	private WebElement exceptionalTrainingCentreGeoLocationTextField;
	@FindBy(xpath="//input[@formcontrolname='village']")
	private WebElement exceptionalTrainingCentreVillageTextField;
	@FindBy(xpath="//input[@formcontrolname='pincode']")
	private WebElement exceptionalTrainingCentrePincodeTextField;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement exceptionalTrainingCentrePhotoBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement uploadButton2;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement exceptionalTrainingCentreSupportDocBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement uploadButton3;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='subSector']/div")
	private WebElement subSectorList;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='jobRole']/div")
	private WebElement jobRoleList;
	@FindBy(xpath="(//button[text()='Add'])[1]")
	private WebElement addJobRoleButton;
	@FindBy(xpath="//button[i[@class='fa fa-trash-o']]")
	private WebElement deleteAddedJobRoleButton;
	@FindBy(xpath="//label[input[@formcontrolname='confirmation']]")
	private WebElement confirmationCheckbox;
	@FindBy(xpath="(//button[text()='Add'])[2]")
	private WebElement addExceptionalTrainingCentreFinalButton;
	@FindBy(xpath="(//button[text()='Assign'])[1]")
	private WebElement assignCurrentlyCreatingExceptionalTrainingCentreButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement closeButton;
	
	public SSC_ExceptionalTraningCentreCreationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickAddExceptionalTC()
	{
		addExceptionalTCButton.click();
	}
	public void enterTrainingPartnerName(String tpName)
	{
		trainingPartnerNameTextField.clear();
		trainingPartnerNameTextField.sendKeys(tpName);
	}
	public void enterExceptionalTrainingCentreName(String exceptionalTCName)
	{
		exceptionalTrainingCentreNameTextField.clear();
		exceptionalTrainingCentreNameTextField.sendKeys(exceptionalTCName);
	}
	public void enterWebsite(String website)
	{
		websiteTextField.clear();
		websiteTextField.sendKeys(website);
	}
	public void enterExceptionalTrainingCentreCapacity(String capacity)
	{
		trainingCentreCapacityTextField.clear();
		trainingCentreCapacityTextField.sendKeys(capacity);
	}
	public void selectResidentialFacilityAvailableForAll()
	{
		residentialFacilityAvailableForMaleCheckBox.click();
		residentialFacilityAvailableForFemaleCheckBox.click();
		residentialFacilityAvailableForTransgenderCheckBox.click();
	}
	public void selectResidentialFacilityAvailableForOnlyMale()
	{
		residentialFacilityAvailableForMaleCheckBox.click();
	}
	public void selectResidentialFacilityAvailableForOnlyFemale()
	{
		residentialFacilityAvailableForFemaleCheckBox.click();
	}
	public void selectResidentialFacilityAvailableForOnlyTransgender()
	{
		residentialFacilityAvailableForTransgenderCheckBox.click();
	}
	public void enterExceptionalTrainingCentreHeadName(String exceptionalTCHeadName)
	{
		exceptionalTrainingCentreHeadNameTextField.clear();
		exceptionalTrainingCentreHeadNameTextField.sendKeys(exceptionalTCHeadName);
	}
	public void enterExceptionalTrainingCentreHeadMobile(String exceptionalTCHeadMobile)
	{
		exceptionalTrainingCentreHeadMobileNumberTextField.clear();
		exceptionalTrainingCentreHeadMobileNumberTextField.sendKeys(exceptionalTCHeadMobile);
	}
	public void enterExceptionalTrainingCentreHeadEmail(String exceptionalTCHeadEmail)
	{
		exceptionalTrainingCentreHeadEmailTextField.clear();
		exceptionalTrainingCentreHeadEmailTextField.sendKeys(exceptionalTCHeadEmail);
	}
	public void enterExceptionalTrainingCentreSPOCName(String exceptionalTCSPOCName)
	{
		exceptionalTrainingCentreSPOCNameTextField.clear();
		exceptionalTrainingCentreSPOCNameTextField.sendKeys(exceptionalTCSPOCName);
	}
	public void enterExceptionalTrainingCentreSPOCMobile(String exceptionalTCSPOCMobile)
	{
		exceptionalTrainingCentreSPOCMobileNumberTextField.clear();
		exceptionalTrainingCentreSPOCMobileNumberTextField.sendKeys(exceptionalTCSPOCMobile);
	}
	public void enterExceptionalTrainingCentreSPOCEmail(String exceptionalTCSPOCEmail)
	{
		exceptionalTrainingCentreSPOCEmailTextField.clear();
		exceptionalTrainingCentreSPOCEmailTextField.sendKeys(exceptionalTCSPOCEmail);
	}
	public void clickToBrowseExceptionalTCSPOCIDProof()
	{
		spocIDProofBrowseButton.click();
	}
	public void clickToUploadExceptionalTCSPOCIDProof()
	{
		uploadButton1.click();
	}
	public void enterExceptionalTCAddress(String exceptionalTCAddress)
	{
		addressTextField.clear();
		addressTextField.sendKeys(exceptionalTCAddress);
	}
	public void enterExceptionalTCLandmark(String exceptionalTCLandmark)
	{
		landmarkTextField.clear();
		landmarkTextField.sendKeys(exceptionalTCLandmark);
	}
	public void selectExceptionalTCState(String exceptionalTCState)
	{
		exceptionalTrainingCentreStateList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+exceptionalTCState+"')])[2]")).click();
	}
	public void selectExsceptionalTCDistrict(String exceptionalTCDistrict)
	{
		exceptionalTrainingCentreDistrictList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionalTCDistrict+"')]")).click();
	}
	public void selectExceptionalTCSubDistrict(String exceptionTCSubDistrict)
	{
		exceptionalTrainingCentreSubDistrictList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionTCSubDistrict+"')]")).click();
	}
	public void selectExceptionalTCConstituency(String exceptionTCConstituency)
	{
		exceptionalTrainingCentreConstituencyList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionTCConstituency+"')]")).click();
	}
	public void enterExceptionalTrainingCentreGeoLocation(String exceptionalTCGeoLocation) throws InterruptedException
	{
		exceptionalTrainingCentreGeoLocationTextField.clear();
		exceptionalTrainingCentreGeoLocationTextField.sendKeys(exceptionalTCGeoLocation);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//li/a/span[contains(text(),'"+exceptionalTCGeoLocation+"')])[1]")).click();
	}
	public void enterExceptionalTrainingCentreVillage(String exceptionalTCVillage)
	{
		exceptionalTrainingCentreVillageTextField.clear();
		exceptionalTrainingCentreVillageTextField.sendKeys(exceptionalTCVillage);
	}
	public void enterExceptionalTrainingCentrePincode(String exceptionalTCPincode)
	{
		exceptionalTrainingCentrePincodeTextField.clear();
		exceptionalTrainingCentrePincodeTextField.sendKeys(exceptionalTCPincode);
	}
	public void clickToBrowseExceptionalTrainingCentrePhoto()
	{
		exceptionalTrainingCentrePhotoBrowseButton.click();
	}
	public void clickToUploadExceptionalTrainingCentrePhoto()
	{
		uploadButton2.click();
	}
	public void clickToBrowseExceptionalTrainingCentreSupportDoc()
	{
		exceptionalTrainingCentreSupportDocBrowseButton.click();
	}
	public void clickToUploadExceptionalTrainingCentreSupportDoc()
	{
		uploadButton3.click();
	}
	public void selectExceptionalTrainingCentreSubSector(String exceptionalTCSubSector) throws InterruptedException
	{
		subSectorList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+exceptionalTCSubSector+"')])[1]")).click();
	}
	public void selectExceptionalTrainingCentreJobRole(String exceptionalTCJobRole) throws InterruptedException
	{
		jobRoleList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionalTCJobRole+"')]")).click();
	}
	public void clickToAddJobRole()
	{
		addJobRoleButton.click();
	}
	public void clickToDeleteAddedJobRole()
	{
		deleteAddedJobRoleButton.click();
	}
	public void clickToConfirmDeclaration()
	{
		confirmationCheckbox.click();
	}
	public void clickToFinallyCreateExceptionalTrainingCentre()
	{
		addExceptionalTrainingCentreFinalButton.click();
	}
	public void clickToAssignCurrentlyCreatingExceptionalTrainingCentre()
	{
		assignCurrentlyCreatingExceptionalTrainingCentreButton.click();
	}
	public void clickOK()
	{
		okButton.click();
	}
	public void clickClose()
	{
		closeButton.click();
	}
}
