package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class NSDCAdmin_AddBusinessOwnerPage {
	WebDriver driver;

	@FindBy(id = "firstName")
	private WebElement nameOfTheUserTextBox;
	@FindBy(id = "mobile")
	private WebElement mobileNumberTextBox;
	@FindBy(id = "email")
	private WebElement emailIdTextBox;
	@FindBy(xpath = "//textarea[@id='address1']")
	private WebElement addressTextArea;
	@FindBy(xpath = "//input[@id='landmark']")
	private WebElement nearByLandmarkTextBox;
	@FindBy(id = "pincode")
	private WebElement pincodeTextBox;
	@FindBy(id = "state")
	private WebElement stateOrUnionTerritoryDropDownList;
	@FindBy(id = "district")
	private WebElement districtDropDownList;
	@FindBy(id = "tehsil")
	private WebElement tehsilOrMandalOrBlockDropDownList;
	@FindBy(id = "city")
	private WebElement cityOrVillageOrTownDropDownList;
	@FindBy(id = "parliamentaryConstituency")
	private WebElement parliamentaryConstituencyDropDownList;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement okButton;

	public NSDCAdmin_AddBusinessOwnerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterNameOfTheUser(String name_Of_User) {
		nameOfTheUserTextBox.clear();
		nameOfTheUserTextBox.sendKeys(name_Of_User);
	}

	public void enterMobileNumber(String mobile_Number) {
		mobileNumberTextBox.clear();
		mobileNumberTextBox.sendKeys(mobile_Number);
	}

	public void enterEmailId(String email_Id) {
		emailIdTextBox.clear();
		emailIdTextBox.sendKeys(email_Id);
	}

	public void enterAddress(String address) {
		addressTextArea.clear();
		addressTextArea.sendKeys(address);
	}

	public void enterNearByLandmark(String near_By_Landmark) {
		nearByLandmarkTextBox.clear();
		nearByLandmarkTextBox.sendKeys(near_By_Landmark);
	}

	public void enterPincode(String pincode) {
		pincodeTextBox.clear();
		pincodeTextBox.sendKeys(pincode);
	}

	public void selectStateOrUnionTerritory(String state_Or_Union_Territory) {
		SelectDropDownList.selectDropDownListByVisibleText(stateOrUnionTerritoryDropDownList, state_Or_Union_Territory);
	}

	public void selectDistrict(String district) {
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}

	public void selectTehsilOrMandalOrBlock(String tehsil_Or_Mandal_Or_Block) {
		SelectDropDownList.selectDropDownListByVisibleText(tehsilOrMandalOrBlockDropDownList,
				tehsil_Or_Mandal_Or_Block);
	}

	public void selectCityOrVillageOrTown(String city_Or_Village_Or_Town) {
		SelectDropDownList.selectDropDownListByVisibleText(cityOrVillageOrTownDropDownList, city_Or_Village_Or_Town);
	}

	public void selectParliamentaryConstituency(String parliamentary_Constituency) {
		SelectDropDownList.selectDropDownListByVisibleText(parliamentaryConstituencyDropDownList,
				parliamentary_Constituency);
	}

	public void clickOnSubmit() {
		submitButton.click();
	}

	public void clickOnOk() {
		okButton.click();
	}

}
