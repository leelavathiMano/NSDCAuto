package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSDCAdmin_ManageBusinessOwnersPage {
	WebDriver driver;

	@FindBy(xpath = "//div[button[contains(text(),'Add Business Owner')]]")
	private WebElement addBusinessOwnerButton;
	@FindBy(xpath = "//input[@id='Search' or @name='KeywordSearch']")
	private WebElement searchByBOUsernameTextBox;
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	private WebElement resetButton;
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement nsdcAdminDashboardButton;

	public NSDCAdmin_ManageBusinessOwnersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddBusinessOwner() {
		addBusinessOwnerButton.click();
	}

	public void enterBoUsername(String bo_Username) {
		searchByBOUsernameTextBox.sendKeys(bo_Username);
	}

	public void clickOnSearch() {
		searchButton.click();
	}

	public void clickOnReset() {
		resetButton.click();
	}

	public void clickOnNsdcAdminDashboard() {
		nsdcAdminDashboardButton.click();
	}

}
