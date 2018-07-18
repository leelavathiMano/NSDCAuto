package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_QP_AddCompulsoryNOSsPage 
{
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'Save & Continue to Assessment Criteria')]")
	private WebElement saveAndContinueToAssessmentCriteriaButton;
	@FindBy(css=".card.nav-link.active.show")
	private WebElement searchAndLinkNOS_Tab;
	@FindBy(xpath="//input[@placeholder='Search by NOS Code']")
	private WebElement NOS_CodeSearchBox;
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement ActionButton;
	@FindBy(xpath="//a[contains(text(),'Link As Compulsory NOSs')]")
	private WebElement linkAsCompulsoryNOSsButton;
	@FindBy(xpath="//div[h5[contains(text(),'While adding the')]]/button[@class='close']")
	private WebElement cancelButton;
	@FindBy(xpath="//div[div/form[@class='ng-untouched ng-pristine ng-valid']]/div/button[contains(text(),'Done')]")
	private WebElement doneButton;
	
	@FindBy(xpath="//a[@data-target='#m_modal_elective_nos']")
	private WebElement linkToElectivesButton;
	@FindBy(xpath="(//div[label[@for='recipient-name']]/input[@id='name'])[1]")
	private WebElement nameOfTheElectiveTextBox;
	@FindBy(xpath="(//div[label[contains(text(),'Enter Brief description of the Elective')]]/textarea[@formcontrolname='description'])[1]")
	private WebElement briefDescriptionOfTheElectiveTextBox;
	
	////////
	@FindBy(xpath="//a[@data-target='#m_modal_optional_nos']")
	private WebElement linkToOptionsButton;
	
	@FindBy(xpath="(//div[@class='card nav-link'])[1]")
	private WebElement compulsoryNOSs_Tab;
	@FindBy(xpath="(//div[@class='card nav-link'])[2]")
	private WebElement addedElectives_Tab;
	@FindBy(xpath="(//div[@class='card nav-link'])[3]")
	private WebElement addedOptions_Tab;
	
	public SSC_QP_AddCompulsoryNOSsPage(WebDriver driver)
	{
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void clickOnSaveAndContinueToAssessmentCriteria()
	{
		saveAndContinueToAssessmentCriteriaButton.click();
	}
	
	public void clickOnSearchAndLinkNOS()
	{
		searchAndLinkNOS_Tab.click();
	}
	
	public void enterNOS_CodeInSearchBox(String NOS_code)
	{
		NOS_CodeSearchBox.clear();
		NOS_CodeSearchBox.sendKeys(NOS_code);
	}
	
	public void clickOnSearch()
	{
		searchButton.click();
	}
	
	public void clickOnAction()
	{
		ActionButton.click();
	}
	
	public void clickOnLinkAsCompulsoryNOSs()
	{
		linkAsCompulsoryNOSsButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnDone()
	{
		doneButton.click();
	}
	
	public void clickOnLinkToElectives()
	{
		linkToElectivesButton.click();
	}
	
	public void clickOnLinkToOptions()
	{
		linkToOptionsButton.click();
	}
	
	
	
	public void clickOnCompulsoryNOSs()
	{
		compulsoryNOSs_Tab.click();
	}
	
	public void clickOnAddedElectives()
	{
		addedElectives_Tab.click();
	}
	
	public void clickOnAddedOptions()
	{
		addedOptions_Tab.click();
	}
}
