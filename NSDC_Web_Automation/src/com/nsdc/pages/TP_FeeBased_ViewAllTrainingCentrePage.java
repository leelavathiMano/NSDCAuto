package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_ViewAllTrainingCentrePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="//button[@class='btn m-btn--pill btn-primary']")
	private WebElement addTrainingCentreButton;
	@FindBy(xpath="//select[@id='trainingCenterType']")
	private WebElement trainingCentreTypeDropDownList;
	@FindBy(xpath="//button[text()='Save and Continue']")
	private WebElement saveAndContinueButton;
	@FindBy(xpath="//button[text()='Close']")
	private WebElement closeButton;
	
	
	public TP_FeeBased_ViewAllTrainingCentrePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnAddTrainingCentre()
	{
		addTrainingCentreButton.click();
	}
	
	public void selectTrainingCentreType(String trainingCentreType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingCentreTypeDropDownList, trainingCentreType);
	}
	
	public void clickOnSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}

}
