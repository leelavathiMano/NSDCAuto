package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingCentreViewBatchesPage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordForNewlyAssignedTextBox;
	@FindBy(xpath="(//tr[td[text()='20-08-2018 to 11-09-2018']]/td/div/div/a[@class='m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle'])[1]")
	private WebElement actionForNewlyAssignedButton;
	@FindBy(xpath="//span[contains(text(),'View Batch')]")
	private WebElement viewBatchdetailsForNewlyAssignedButton;
	@FindBy(xpath="//span[contains(text(),'Accept/Reject Batch')]")
	private WebElement acceptOrRejectBatchButton;
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="(//label[@class='m-radio'])[1]")
	private WebElement acceptRadioButton;
	@FindBy(xpath="(//label[@class='m-radio'])[2]")
	private WebElement rejectRadioButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	@FindBy(xpath="//img[@class='m--img-rounded m--marginless m--img-centered']")
	private WebElement logoutLogoButton;
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	private WebElement logoutButton;
	@FindBy(xpath="//a[contains(text(),'Accepted')]")
	private WebElement acceptedTab;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordForAcceptedTextBox;
	@FindBy(xpath="//i[@class='la la-ellipsis-h']")
	private WebElement actionForAcceptedButton;
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsForAcceptedButton;
	@FindBy(xpath="//i[@class='la la-bell-o']")
	private WebElement appliedCandidatesTab;
	@FindBy(xpath="//button[contains(text(),'Verify & Approve')]")
	private WebElement verifyAndApproveButton;
	@FindBy(xpath="(//i[@class='la la-bell-o'])[2]")
	private WebElement educationAndWorkTab;
	@FindBy(xpath="//button[contains(text(),'Approve Candidate')]")
	private WebElement approvedCandidatesButton;
	@FindBy(xpath="(//button[contains(text(),'Reject Candidate')])[1]")
	private WebElement rejectedCandidatesButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okForApprovingCandidatesButton;
	
	public TrainingCentreViewBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterBatchId(String search_By_Id)
	{
		searchByKeywordForNewlyAssignedTextBox.clear();
		searchByKeywordForNewlyAssignedTextBox.sendKeys(search_By_Id);
	}
	
	public void clickActionForNewlyAssignedButton()
	{
		actionForNewlyAssignedButton.click();
	}
	public void clickViewBatchdetailsForNewlyAssignedButton()
	{
		viewBatchdetailsForNewlyAssignedButton.click();
	}
	public void clickAcceptOrRejectButton()
	{
		acceptOrRejectBatchButton.click();
	}
	public void clickSaveAndSubmitButton()
	{
		saveAndSubmitButton.click();
	}
	public void clickAcceptRadioButton()
	{
		acceptRadioButton.click();
	}
	public void clickOkButton()
	{
		okButton.click();
	}
	public void clickLogoutLogoButton()
	{
		logoutLogoButton.click();
	}
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
	public void clickAcceptedTab()
	{
		acceptedTab.click();
	}
	public void enterBatchIdForAccepted(String search_By_Id)
	{
		searchByKeywordForAcceptedTextBox.clear();
		searchByKeywordForAcceptedTextBox.sendKeys(search_By_Id);
	}
	public void clickActionForAcceptedButton()
	{
		actionForAcceptedButton.click();
	}
	public void clickViewBatchDetailsForAcceptedTab()
	{
		viewBatchDetailsForAcceptedButton.click();
	}
	public void clickAppliedCandidatesTab()
	{
		appliedCandidatesTab.click();
	}
	public void clickVerifyAndApproveButton()
	{
		verifyAndApproveButton.click();
	}
	public void clickEducationAndWorkTab()
	{
		educationAndWorkTab.click();
	}
	
	
	public void clickApprovedCandidatesButton()
	{
		approvedCandidatesButton.click();
	}
	public void clickrejectedCandidatesTab()
	{
		rejectedCandidatesButton.click();
	}
	public void clickOkForApprovingCandidatesButton()
	{
		okForApprovingCandidatesButton.click();
	}
}