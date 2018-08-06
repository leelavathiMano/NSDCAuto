package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationBasedTC_ViewBatchesPage
{
	WebDriver driver;
	@FindBy(xpath="//span[@class='m-menu__link-text']")
	private WebElement totToAToMTToMALink;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchForBatchIDTextfield;
	@FindBy(xpath="//a[@class='m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle']")
	private WebElement actionMenu;
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept/Reject Batch')]")
	private WebElement acceptOrRejectBatchOption;
	@FindBy(xpath="(//div[@class='atc-radio'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(xpath="(//div[@class='atc-radio'])[2]")
	private WebElement rejectBatchRadioButton;
	@FindBy(xpath="//textarea[@formcontrolname='remarks']")
	private WebElement remarksTextArea;
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	//@FindBy(xpath="//button[contains(text(),'Accepted')]")
	@FindBy(linkText="Accepted")
	private WebElement viewAllAcceptedBatchesButton;
	@FindBy(linkText="Ongoing")
	private WebElement viewAllOngoingBatchesLink;
	@FindBy(linkText="Completed")
	private WebElement viewAllCompletedBatchesLink;
	//@FindBy(xpath="//button[contains(text(),'Rejected')]")
	@FindBy(linkText="Rejected")
	private WebElement viewAllRejectedBatchesButton;
	public LocationBasedTC_ViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterToSearchForBatchID(String batchID)
	{
		searchForBatchIDTextfield.clear();
		searchForBatchIDTextfield.sendKeys(batchID);
	}
	public void clikToViewActionMenu()
	{
		actionMenu.click();
	}
	public void clickToSelectViewBatchDetailsOption()
	{
		viewBatchDetailsOption.click();
	}
	public void clickToSelectAcceptOrRejectBatchOption()
	{
		acceptOrRejectBatchOption.click();
	}
	public void clickToGoToDashboard()
	{
		totToAToMTToMALink.click();
	}
	public void clickToAcceptBatch()
	{
		acceptBatchRadioButton.click();
	}
	public void clickToRejectBatch()
	{
		rejectBatchRadioButton.click();
	}
	public void enterRemarks(String remarks)
	{
		remarksTextArea.clear();
		remarksTextArea.sendKeys(remarks);
	}
	public void clickToSaveAndSubmit()
	{
		saveAndSubmitButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	public void clickToViewAllAcceptedBatches()
	{
		viewAllAcceptedBatchesButton.click();
	}
	public void clickToViewAllRejectedBatches()
	{
		viewAllRejectedBatchesButton.click();
	}
}
