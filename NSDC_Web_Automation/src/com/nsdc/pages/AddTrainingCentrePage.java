package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AddTrainingCentrePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='trainingCentreName']")
	private WebElement trainingCentreNameTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='address1']")
	private WebElement addressTextBox;
	@FindBy(xpath="//input[@formcontrolname='landmark']")
	private WebElement nearByLandmarkTextbox;
	@FindBy(xpath="//input[@formcontrolname='pincode']")
	private WebElement pincodeTextbox;
	@FindBy(xpath="//select[option[text()='Select the state/Union Territory']]")
	private WebElement stateDropDownList;
	@FindBy(xpath="//select[option[text()='Select District']]")
	private WebElement districtDropDownList;
	@FindBy(xpath="//select[option[text()='Select Tehsil/Mandal/Block']]")
	private WebElement tehsilDropDownList;
	@FindBy(xpath="//select[option[text()='Select City/Town/Village']]")
	private WebElement cityDropDownList;
	@FindBy(xpath="//select[option[text()='Select the Parliamentary Constituency']]")
	private WebElement parliamentryConstituencyDropDownList;
	@FindBy(id="search_places")
	private WebElement geoLocationTextbox;
	@FindBy(xpath="//select[option[text()='Select Address Proof Type']]")
	private WebElement addressProofDropDownList;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement addressProof_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement addressProof_UploadFileButton;
	
	@FindBy(xpath="//input[@placeholder='Enter Name of SPOC']")
	private WebElement SPOC_nameTextBox;
	@FindBy(xpath="//input[@placeholder='Enter Email Address of SPOC']")
	private WebElement SPOC_emailTextBox;
	@FindBy(xpath="//input[@placeholder='Enter Mobile Number of SPOC']")
	private WebElement SPOC_mobileNumberTextBox;
	
	@FindBy(xpath="//input[@placeholder='Enter Name of Centre Head']")
	private WebElement centreHead_NameTextbox;
	@FindBy(xpath="//input[@placeholder='Enter Email Address of Centre Head']")
	private WebElement centreHead_EmailTextbox;
	@FindBy(xpath="//input[@placeholder='Enter Mobile Number Of Centre Head']")
	private WebElement centreHead_MobileTextbox;
	
	@FindBy(xpath="//select[@formcontrolname='trainingCenterType']")
	private WebElement trainingCentreTypeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='pmkkHubId']")
	private WebElement pmkkHubIDTextbox;
	@FindBy(xpath="//button[text()='Verify']")
	private WebElement verifyButton;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement uploadMOU_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement uploadMOU_UploadFileButton;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='Yes, Add Training Centre']")
	private WebElement yesAddTrainingCentreButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancel_AddTCButton;
	@FindBy(xpath="//button[text()='Close']")
	private WebElement close_Button;
	
	
	public AddTrainingCentrePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void enterTrainingCentreName(String tcName)
	{
		trainingCentreNameTextBox.clear();
		trainingCentreNameTextBox.sendKeys(tcName);
	}
	
	public void enterAddress(String address)
	{
		addressTextBox.clear();
		addressTextBox.sendKeys(address);
	}
	
	public void enterNearByLandmark(String landmark)
	{
		nearByLandmarkTextbox.clear();
		nearByLandmarkTextbox.sendKeys(landmark);
	}
	
	public void enterPincode(String pincode)
	{
		pincodeTextbox.clear();
		pincodeTextbox.sendKeys(pincode);
	}
	
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
	}
	
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}
	
	public void selectTehsil(String tehsil)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tehsilDropDownList, tehsil);
	}
	
	public void selectCity(String city)
	{
		SelectDropDownList.selectDropDownListByVisibleText(cityDropDownList, city);
	}
	
	public void selectParliamentryConstituency(String parliamentryConstituency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(parliamentryConstituencyDropDownList, parliamentryConstituency);
	}
	
	public void enterGeoLocation(String geoLocation) throws Exception
	{
		geoLocationTextbox.clear();
		geoLocationTextbox.sendKeys(geoLocation);
        Thread.sleep(2000);
        geoLocationTextbox.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}
	
	public void selectAddressProof(String addressProof)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addressProofDropDownList, addressProof);
	}
	
	public void clickOnAddressProof_BrowseFile()
	{
		addressProof_BrowseFileButton.click();
	}
	
	public void clickOnAddressProof_UploadFile()
	{
		addressProof_UploadFileButton.click();
	}
	
	public void enterNameOfTheSPOC(String SPOC_name)
	{
		SPOC_nameTextBox.clear();
		SPOC_nameTextBox.sendKeys(SPOC_name);
	}
	
	public void enter_SPOC_EmailAddress(String emailAddress)
	{
		SPOC_emailTextBox.clear();
		SPOC_emailTextBox.sendKeys(emailAddress);
	}
	
	public void enter_SPOC_MobileNumber(String mobileNo)
	{
		SPOC_mobileNumberTextBox.clear();
		SPOC_mobileNumberTextBox.sendKeys(mobileNo);
	}
	
	public void enterCentreHeadName(String centreHeadName)
	{
		centreHead_NameTextbox.clear();
		centreHead_NameTextbox.sendKeys(centreHeadName);
	}
	
	public void enterCentreHeadEmailAddress(String centreHeadEmail)
	{
		centreHead_EmailTextbox.clear();
		centreHead_EmailTextbox.sendKeys(centreHeadEmail);
	}
	
	public void enterCentreHeadMobileNumber(String centreHeadMobile)
	{
		centreHead_MobileTextbox.clear();
		centreHead_MobileTextbox.sendKeys(centreHeadMobile);
	}
	
	public void selectTrainingCentreType(String TC_type)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingCentreTypeDropDownList, TC_type);
	}
	
	public void enterPMKK_HUB_ID(String pmkkHubID)
	{
		pmkkHubIDTextbox.clear();
		pmkkHubIDTextbox.sendKeys(pmkkHubID);
	}
	
	public void clickOnVerify()
	{
		verifyButton.click();
	}
	
	public void clickOnUploadMOU_BrowseFile()
	{
		uploadMOU_BrowseFileButton.click();
	}
	
	public void clickOnUploadMOU_UploadFile()
	{
		uploadMOU_UploadFileButton.click();
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
	
	public void clickOnCancel_AddTrainingCentreButton()
	{
		cancel_AddTCButton.click();
	}
	
	public void clickOnClose()
	{
		close_Button.click();
	}
	
	
}
