package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSDCAdmin_DashboardPage {

	WebDriver driver;

	@FindBy(xpath = "//div[p[contains(text(),'User Management')]]")
	private WebElement userManagementCard;
	@FindBy(xpath = "//div[@ng-reflect-router-link='tcregistrationrules']")
	private WebElement tcRegistrationButton;
	@FindBy(xpath = "//div[@ng-reflect-router-link='tpregistrationrules']")
	private WebElement tpRegistrationButton;
	@FindBy(xpath = "//div[@class='m-widget17__items m-widget17__items-col4 clickable']")
	private WebElement schemeApproval_SOButton;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement oKButton;
	@FindBy(xpath = "//span[contains(text(),'NSDCADMIN1')]")
	private WebElement nSDCAdminProfileButton;
	@FindBy(xpath = "//span[contains(text(),'NSDCADMIN_000003')]")
	private WebElement nSDCAdminNewProfileButton;
	@FindBy(xpath = "//div[p[contains(text(),'Create Scheme')]]")
	private WebElement createSchemeCard;
	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	private WebElement nSDCLogOutButton;

	public NSDCAdmin_DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnUserManagement() {
		userManagementCard.click();
	}

	public void clickForReviewTCRegistrationSetup() {
		tcRegistrationButton.click();
	}

	public void clickForReviewTPRegistrationSetup() {
		tpRegistrationButton.click();
	}

	public void clickForSOSchemeApproval() {
		schemeApproval_SOButton.click();
	}

	public void clickOnCreateScheme() {
		createSchemeCard.click();
	}

	public void clickOnOK() {
		oKButton.click();
	}

	public void clickOnNSDCProfile() {
		nSDCAdminProfileButton.click();
	}

	public void clickOnNewNSDCProfile() {
		nSDCAdminNewProfileButton.click();
	}

	public void clickOnNSDCLogOut() {
		nSDCLogOutButton.click();
	}

}
