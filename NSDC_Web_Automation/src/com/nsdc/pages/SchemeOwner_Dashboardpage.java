package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeOwner_Dashboardpage {
	WebDriver driver;

	@FindBy(xpath = "//div[p[contains(text(),'All Approval requests')]]")
	private WebElement allApprovalRequestsCard;
	@FindBy(xpath = "//div[p[contains(text(),'All Schemes')]]")
	private WebElement allSchemesCard;
	@FindBy(xpath = "//div[p[contains(text(),'Add a Scheme Admin')]]")
	private WebElement addASchemeAdminCard;
	@FindBy(xpath = "//div[p[contains(text(),'Assign to Scheme Admin')]]")
	private WebElement assignToSchemeAdminCard;
	@FindBy(xpath = "//div[p[contains(text(),'Scheme Retirement Approval Requests')]]")
	private WebElement schemeRetirementApprovalRequestsCard;
	@FindBy(xpath = "//div[p[contains(text(),'Instantialte Job Roles Approval Requests')]]")
	private WebElement instantialteJobRolesApprovalRequestsCard;
	@FindBy(xpath = "//span/span")
	private WebElement sOProfileButton;
	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	private WebElement sOLogOutButton;

	public SchemeOwner_Dashboardpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAllApprovalRequests() {
		allApprovalRequestsCard.click();
	}

	public void clickOnAllSchemes() {
		allSchemesCard.click();
	}

	public void clickOnAddASchemeAdmin() {
		addASchemeAdminCard.click();
	}

	public void clickOnAssignToSchemeAdmin() {
		assignToSchemeAdminCard.click();
	}

	public void clickOnSchemeRetirementApprovalRequests() {
		schemeRetirementApprovalRequestsCard.click();
	}

	public void clickOnInstantialteJobRolesApprovalRequests() {
		instantialteJobRolesApprovalRequestsCard.click();
	}

	public void clickOnSOProfile() {
		sOProfileButton.click();
	}

	public void clickOnSOLogOut() {
		sOLogOutButton.click();
	}

}
