package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingCentreViewBatchesPage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByIdTextBox;
	@FindBy(xpath="(//tr[td[text()='20-07-2018 to 01-08-2018']]/td/div/div/a[@class='m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle'])[1]")
	private WebElement actionButton;
	@FindBy(xpath="(//span[contains(text(),'View Batch')])[2]")
	private WebElement viewBatchdetailsButton;
	@FindBy(xpath="(//span[contains(text(),'Accept/Reject Batch')])[1]")
	private WebElement acceptAndRejectButton;
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement acceptRadioButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	public TrainingCentreViewBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterBatchId(String search_By_Id)
	{
		searchByIdTextBox.clear();
		searchByIdTextBox.sendKeys(search_By_Id);
	}
	
	public void clickActionButton()
	{
		actionButton.click();
	}
	public void clickViewBatchdetailsButton()
	{
		viewBatchdetailsButton.click();
	}
	public void clickAcceptAndRejectButton()
	{
		acceptAndRejectButton.click();
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
	
}