package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SmartAdmin_CreateUserPage {
	WebDriver driver;

	@FindBy(xpath = "//select[@formcontrolname='type']")
	private WebElement userTypeDropDownList;
	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	private WebElement fullNameTextbox;
	@FindBy(xpath = "//input[@formcontrolname='email']")
	private WebElement emailAddressTexbox;
	@FindBy(xpath = "//input[@formcontrolname='mobile']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelButton;

	public SmartAdmin_CreateUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectUserType(String userType) {
		SelectDropDownList.selectDropDownListByVisibleText(userTypeDropDownList, userType);
	}

	public void enterFullName(String fullName) {
		fullNameTextbox.clear();
		fullNameTextbox.sendKeys(fullName);
	}

	public void enterEmailAddress(String email) {
		emailAddressTexbox.clear();
		emailAddressTexbox.sendKeys(email);
	}

	public void enterMobileNumber(String mobileNumber) {
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(mobileNumber);
	}

	public void clickOnSubmit() {
		submitButton.click();
	}

	public void clickOnClose() {
		closeButton.click();
	}

	public void clickOnYes() {
		yesButton.click();
	}

	public void clickOnCancel() {
		cancelButton.click();
	}

}
