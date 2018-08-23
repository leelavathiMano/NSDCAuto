package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_AddTrainingCentrePage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='nameOfTc']")
	private WebElement trainingCentreNameTextbox;
	@FindBy(xpath="//textarea[@formcontrolname='address']")
	private WebElement trainingCentreAddressTextbox;
	@FindBy(xpath="//input[@formcontrolname='nameOfSpoc']")
	private WebElement spocNameTextbox;
	@FindBy(xpath="//input[@formcontrolname='emailOfSpoc']")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="//input[@formcontrolname='mobileOfSpoc']")
	private WebElement mobileNumberTextbox;
	@FindBy(xpath="//select[@formcontrolname='trainingCenterType']")
	private WebElement trainingCentreTypeDropDownList;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement tcStateDropDownList;
	@FindBy(xpath="//select[@formcontrolname='schemeAssociated']")
	private WebElement schemeAssociatedDropDownList;
	@FindBy(xpath="//select[@formcontrolname='holdingAgency']")
	private WebElement holdingAgencyAsssignedDropDownList;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement recommendationLetter_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement recommendationLetter_UploadFileButton;
	@FindBy(xpath="//button[contains(text(),'Save & Next')]")
	private WebElement saveAndNextButton;
	
	
	public TP_AddTrainingCentrePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTrainingCentreName(String tcName)
	{
		trainingCentreNameTextbox.clear();
		trainingCentreNameTextbox.sendKeys(tcName);
	}
	
	public void enterTrainingCentreAddress(String tcAddress)
	{
		trainingCentreAddressTextbox.clear();
		trainingCentreAddressTextbox.sendKeys(tcAddress);
	}
	
	public void enterNameOfTheSPOC(String spocName)
	{
		spocNameTextbox.clear();
		spocNameTextbox.sendKeys(spocName);
	}
	
	public void enterEmailAddressOfSPOC(String spocEmail)
	{
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys(spocEmail);
	}
	
	public void enterMobileNumberOfSPOC(String spocMobileNumber)
	{
		mobileNumberTextbox.clear();
		mobileNumberTextbox.sendKeys(spocMobileNumber);
	}
	
	public void selectTrainingCentreType(String tcType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingCentreTypeDropDownList, tcType);
	}
	
	public void selectStateForSchemeTC(String tcState)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcStateDropDownList, tcState);
	}
	
	public void selectSchemeAssociated(String schemeAssociated)
	{
		SelectDropDownList.selectDropDownListByVisibleText(schemeAssociatedDropDownList, schemeAssociated);
	}
	
	public void selectHoldingAgencyAssigned(String holdingAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(holdingAgencyAsssignedDropDownList, holdingAgency);
	}
	
	public void clickOnRecommendationLetter_BrowseFile()
	{
		recommendationLetter_BrowseFileButton.click();
	}
	
	public void clickOnRecommendationLetter_UploadFile()
	{
		recommendationLetter_UploadFileButton.click();
	}
	
	public void clickOnSaveAndNext()
	{
		saveAndNextButton.click();
	}

}
