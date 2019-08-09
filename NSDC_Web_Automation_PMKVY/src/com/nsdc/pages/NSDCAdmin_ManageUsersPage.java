package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSDCAdmin_ManageUsersPage {
	WebDriver driver;

	@FindBy(xpath = "//div[p[contains(text(),'Manage  SSC Admin')]]")
	private WebElement manageSSCAdminCard;
	@FindBy(xpath = "(//div[p[contains(text(),'Manage SSC Users')]])[1]")
	private WebElement manageSSCUsersCard;
	@FindBy(xpath = "//div[p[contains(text(),'Manage Candidate Admin')]]")
	private WebElement managecandidateAdminCard;
	@FindBy(xpath = "//div[p[contains(text(),'Manage Business Owners')]]")
	private WebElement manageBusinessOwnersCard;
	@FindBy(xpath = "//div[p[contains(text(),'Manage Rozgar Admin')]]")
	private WebElement manageRozgarAdminCard;

	public NSDCAdmin_ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageSSCAdmin() {
		manageSSCAdminCard.click();
	}

	public void clickOnManageSSCUsers() {
		manageSSCUsersCard.click();
	}

	public void clickOnManageCandidateAdmin() {
		managecandidateAdminCard.click();
	}

	public void clickOnManageBusinessOwners() {
		manageBusinessOwnersCard.click();
	}

	public void clickOnManageRozgarAdmin() {
		manageRozgarAdminCard.click();
	}

}
