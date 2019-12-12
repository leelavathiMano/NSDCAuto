package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeOwner_AddASchemeAdminPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@ng-reflect-name='fullName' and @placeholder='Enter full name']")
	private WebElement fullNameTextBox;
	@FindBy(xpath = "//input[@ng-reflect-name='email' and @placeholder='Enter email address']")
	private WebElement emailAddressTextBox;
	@FindBy(xpath = "//input[@ng-reflect-name='mobile' and @placeholder='Enter mobile number']")
	private WebElement mobileNumberTextBox;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath = "//span[contains(text(),' Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement okButton;

	public SchemeOwner_AddASchemeAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFullName(String full_Name) {
		fullNameTextBox.sendKeys(full_Name);
	}

	public void enterEmailAddress(String email_Address) {
		emailAddressTextBox.sendKeys(email_Address);
	}

	public void enterMobileNumber(String mobile_Number) {
		mobileNumberTextBox.sendKeys(mobile_Number);
	}

	public void clickOnSubmit() {
		submitButton.click();
	}

	public void clickOnCancel() {
		cancelButton.click();
	}

	public void clickOnOk() {
		okButton.click();
	}
}
