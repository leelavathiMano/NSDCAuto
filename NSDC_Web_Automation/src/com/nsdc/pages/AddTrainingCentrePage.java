package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AddTrainingCentrePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='nameOfTc']")
	private WebElement trainingCentreNameTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='address']")
	private WebElement addressTextBox;
	@FindBy(xpath="//input[@formcontrolname='nameOfSpoc']")
	private WebElement SPOC_nameTextBox;
	@FindBy(xpath="//input[@formcontrolname='emailOfSpoc']")
	private WebElement SPOC_emailTextBox;
	@FindBy(xpath="//input[@formcontrolname='mobileOfSpoc']")
	private WebElement SPOC_mobileNumberTextBox;
	@FindBy(xpath="//select[@formcontrolname='trainingCenterType']")
	private WebElement trainingCentreTypeDropDownList;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateDropDownList;
	@FindBy(xpath="//select[@formcontrolname='schemeAssociated']")
	private WebElement schemeAssociatedDropDownList;
	@FindBy(xpath="//select[@formcontrolname='holdingAgency']")
	private WebElement holdingAgencyAssignedDropDownList;
	@FindBy(id="customFile")
	private WebElement uploadRecommendationLetter_browseButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement recommendationLetter_uploadButton;
	@FindBy(xpath="//button[contains(text(),'Save & Next')]")
	private WebElement saveAndNextButton;
	
	public AddTrainingCentrePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void enterTrainingCentreName(String TPname)
	{
		trainingCentreNameTextBox.clear();
		trainingCentreNameTextBox.sendKeys(TPname);
	}
	
	public void enterAddress(String address)
	{
		addressTextBox.clear();
		addressTextBox.sendKeys(address);
	}
	
	public void enterNameOfTheSPOC(String SPOC_name)
	{
		SPOC_nameTextBox.clear();
		SPOC_nameTextBox.sendKeys(SPOC_name);
	}
	
	public void enterEmailAddress(String emailAddress)
	{
		SPOC_emailTextBox.clear();
		SPOC_emailTextBox.sendKeys(emailAddress);
	}
	
	public void enterMobileNumber(String mobileNo)
	{
		SPOC_mobileNumberTextBox.clear();
		SPOC_mobileNumberTextBox.sendKeys(mobileNo);
	}
	
	public void selectTrainingCentreType(String TC_type)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingCentreTypeDropDownList, TC_type);
	}
	
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
	}
	
	public void selectSchemeAssociated(String scheme)
	{
		SelectDropDownList.selectDropDownListByVisibleText(schemeAssociatedDropDownList, scheme);
	}
	
	public void selectHoldingAgencyAssigned(String holdingAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(holdingAgencyAssignedDropDownList, holdingAgency);
	}
	
	public void clickOnBrowseToUploadRecommendationLetter()
	{
		uploadRecommendationLetter_browseButton.click();
	}
	
	public void clickOnUploadToUploadRecommendationLetter()
	{
		recommendationLetter_uploadButton.click();
	}
	
	public void clickOnSaveAndNext()
	{
		saveAndNextButton.click();
	}
}
