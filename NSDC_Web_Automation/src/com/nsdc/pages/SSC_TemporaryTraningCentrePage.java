package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class SSC_TemporaryTraningCentrePage
{
	WebDriver driver;
	@FindBy(xpath="//input[@formcontrolname='trainingCentreName']")
	private WebElement trainingCentreNameTextBox;
	@FindBy(xpath="//input[@formcontrolname='addressLine']")
	private WebElement addressLineTextBox;
	@FindBy(xpath="//input[@formcontrolname='landmark']")
	private WebElement landmarkTextBox;
	@FindBy(xpath="//input[@formcontrolname='pincode']")
	private WebElement pincodeTextBox;
	@FindBy(xpath="//input[@placeholder='Enter Village/Town/City']")
	private WebElement villageTownCityTextBox;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateDropdownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subDistrict']")
	private WebElement subDistrictDropdownList;
	@FindBy(xpath="//input[@formcontrolname='trainingCentreCapacity']")
	private WebElement trainingCentreCapacityTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Contact Person Name'])[1]")
	private WebElement contactPersonNameTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Email-ID'])[1]")
	private WebElement contactPersonEmailTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Mobile Number'])[1]")
	private WebElement contactPersonMobileNumberTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Contact Person Name'])[2]")
	private WebElement singlePointOfContactPersonNameTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Email-ID'])[2]")
	private WebElement singlePointOfContactPersonEmailTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Mobile Number'])[2]")
	private WebElement singlePointOfContactPersonMobileNumberTextBox;
	@FindBy(xpath="//button[contains(text(),'Add Sub Sector and Job Role')]")
	private WebElement addSubsectorAndJobRoleButton;
	@FindBy(xpath="//select[@formcontrolname='sector']")
	private WebElement sectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subSector']")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='jobRole']")
	private WebElement jobRoleMultiselectDropdownList;
	@FindBy(xpath="(//button[contains(text(),'Add')])[2]")
	private WebElement addButton;
	//added sector and job role delete button
	

	@FindBy(xpath="//div[label[input[@formcontrolname='confirmation']]]")
	private WebElement confirmationCheckBox;
	@FindBy(xpath="//button[contains(text(),'Create')]")
	private WebElement createButton;
	@FindBy(xpath="//a[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//div[h2[contains(text(),'Training Centre created successfully')]]")
	private WebElement successfullMsgPopup;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	
	public SSC_TemporaryTraningCentrePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void enterTrainingCentreNameTextBox(String trainingCentreName)
	{
		trainingCentreNameTextBox.clear();
		trainingCentreNameTextBox.sendKeys(trainingCentreName);
	}
	public void enterAdressLine(String addressLine)
	{
		addressLineTextBox.clear();
		addressLineTextBox.sendKeys(addressLine);
	}
	public void enterLandmark(String landmark)
	{
		landmarkTextBox.clear();
		landmarkTextBox.sendKeys(landmark);
	}
	public void enterPincode(String pincode)
	{
		pincodeTextBox.clear();
		pincodeTextBox.sendKeys(pincode);
	}
	public void enterVillageTownCity(String villageTownCity)
	{
		villageTownCityTextBox.clear();
		villageTownCityTextBox.sendKeys(villageTownCity);
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropdownList, state);
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropdownList, district);
	}
	public void selectSubDistrict(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrictDropdownList, subDistrict);
	}
	public void enterTrainingCentreCapacity(String trainingCentreCapacity)
	{
		trainingCentreCapacityTextBox.clear();
		trainingCentreCapacityTextBox.sendKeys(trainingCentreCapacity);
	}
	public void enterContactPersonName(String contactPersonName)
	{
		contactPersonNameTextBox.clear();
		contactPersonNameTextBox.sendKeys(contactPersonName);
	}
	public void enterContactPersonEmail(String contactPersonEmail)
	{
		contactPersonEmailTextBox.clear();
		contactPersonEmailTextBox.sendKeys(contactPersonEmail);
	}
	public void enterContactPersonMobileNumber(String contactPersonMobileNumber)
	{
		contactPersonMobileNumberTextBox.clear();
		contactPersonMobileNumberTextBox.sendKeys(contactPersonMobileNumber);
	}
	public void enterSinglePointOfContactPersonName(String singlePointOfContactPersonName)
	{
		singlePointOfContactPersonNameTextBox.clear();
		singlePointOfContactPersonNameTextBox.sendKeys(singlePointOfContactPersonName);
	}
	public void enterSinglePointOfContactPersonEmail(String singlePointOfContactPersonEmail)
	{
		singlePointOfContactPersonEmailTextBox.clear();
		singlePointOfContactPersonEmailTextBox.sendKeys(singlePointOfContactPersonEmail);
	}
	public void enterSinglePointOfContactPersonMobileNumber(String singlePointOfContactPersonMobileNumber)
	{
		singlePointOfContactPersonMobileNumberTextBox.clear();
		singlePointOfContactPersonMobileNumberTextBox.sendKeys(singlePointOfContactPersonMobileNumber);
	}
	public void clickAddSubsectorAndJobRoleButton()
	{
		addSubsectorAndJobRoleButton.click();
	}
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropdownList, sector);
	}
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropdownList,subSector);
	}
	public void selectJobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleMultiselectDropdownList,jobRole);
		
	}
	
	public void clickAddButton()
	{
		addButton.click();
	}
	//delete button
	
	public void clickConfirmation()
	{
		confirmationCheckBox.click();
	}
	public void clickCreate()
	{
		createButton.click();
	}
	public void clickCancel()
	{
		cancelButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
}
