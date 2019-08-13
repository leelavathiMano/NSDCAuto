package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class Pmkvy_SpecialProjectCreationPage {
	WebDriver driver;
	//Project Details:
	@FindBy(xpath="//input[@placeholder='Enter project proposal id']")
	private WebElement ProjectProposalIDTextBox;
	@FindBy(xpath="//input[@placeholder='Enter project name']")
	private WebElement ProjecNameTextBox;
	@FindBy(xpath="(//label[input[@formcontrolname='projectType']])[1]")
	private WebElement ProjectTypeButton;
	@FindBy(xpath="(//label[input[@formcontrolname='projectType']])[2]")
	private WebElement NonGovernmenButton;
	@FindBy(xpath="(//label[input[@formcontrolname='projectType']])[3]")
	private WebElement GovernmentMOUButton;
	@FindBy(xpath="//select[@formcontrolname='registeredAs']")
	private WebElement RegisteredAsDropDownList;
	@FindBy(xpath="//input[@formcontrolname='proposingOrganisation']")
	private WebElement ProposingOrganisationNameTextBox;
	//Location

	@FindBy(xpath="//select[option[text()='Select State']]")
	private WebElement selectStateDropDownList;
	@FindBy(xpath="//select[option[text()='Select District']]")
	private WebElement selectDistrictDropDownList;
	@FindBy(xpath="//button[text()='Add']")
	private WebElement AddButton;
	//Upload Supporting Documents:

	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement IndemnityBondBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement IndemnityBondUploadButton;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement OtherSupportingDocumentsBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement OtherSupportingDocumentsUploadButton;
	@FindBy(xpath="//button[text()='Save & Submit']")
	private WebElement SaveAndSumbitButton;
	//ini
	public Pmkvy_SpecialProjectCreationPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	//setter and getter methods

	public void EnterTheProjectProposalID(String ProjectProposalID) 
	{
		ProjectProposalIDTextBox.sendKeys(ProjectProposalID);
	}
	public void EnterTheProjecName(String ProjecName)
	{
		ProjecNameTextBox.sendKeys(ProjecName);
	}
	
	public void ClickProjectType()
	{
		ProjectTypeButton.click();
	}
	public void selectRegisteredAslist(String registeredAs)
	{
		RegisteredAsDropDownList.click();
		SelectDropDownList.selectDropDownListByVisibleText(RegisteredAsDropDownList, registeredAs);
		
	}
	public void EnterProposingOrganisationName(String ProposingOrganisationName)
	{
		ProposingOrganisationNameTextBox.sendKeys(ProposingOrganisationName);
		
	}
	//location
	public void selectState(String State)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectStateDropDownList, State);
		
	}
	public void selectDistrict(String District)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectDistrictDropDownList, District);
		
	}
	public void clickAdd()
	{
		AddButton.click();
	}
	
	////Upload Supporting Documents:
	public void clickOnIndemnityBondBrowse()
	{
		IndemnityBondBrowseButton.click();
	}
	public void clickOnIndemnityBondUploadButton()
	{
		IndemnityBondUploadButton.click();
	}
	
	public void clickOnOtherSupportingDocumentsBrowse()
	{
		OtherSupportingDocumentsBrowseButton.click();
	}
	public void clickOnOtherSupportingDocumentsUpload()
	{
		OtherSupportingDocumentsUploadButton.click();
	}
	public void clickSaveAndSumbit()
	{
		SaveAndSumbitButton.click();
	}

}
