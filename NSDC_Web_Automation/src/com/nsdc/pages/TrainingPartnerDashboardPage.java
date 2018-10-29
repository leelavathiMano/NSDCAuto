package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TrainingPartnerDashboardPage 
{
	WebDriver driver;
	@FindBy(linkText="Other - Rozgar Mela")
	private WebElement otherRozgarMelaLink;
	@FindBy(xpath="//p[text()='Change My SPOC']")
	private WebElement changeMySPOCButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement dashboardButton;
	@FindBy(xpath="//div[@routerlink='./my-schemes']")
	private WebElement mySchemesButton;
	
	//TP - Candidates
	@FindBy(xpath="//p[contains(text(),'My Candidates')]")
	private WebElement myCandidatesCard;
	@FindBy(xpath="//div[p[text()='Register Candidates']]")
	private WebElement registerCandidateButton;
	@FindBy(xpath="(//label[@class='m-radio'])[1]")
	private WebElement bulkExcelSheetUploadRadioButton;
	@FindBy(xpath="(//label[@class='m-radio'])[2]")
	private WebElement registerIndividualCandidateRadioButton;
	@FindBy(xpath="//input[@formcontrolname='excelFile']")
	private WebElement excelFileBrowseButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'Register')]")
	private WebElement registerButton;
	
	@FindBy(xpath="//div[p[text()='Add a Training Centre']]")
	private WebElement addTrainingCentreButton;
	@FindBy(xpath="//div[p[text()='View Training Centres']]")
	private WebElement viewTrainingCentreButton;
	@FindBy(xpath="//select[@formcontrolname='processType']")
	private WebElement processTypeDropDownList;
	@FindBy(xpath="//select[@formcontrolname='trainingCenterType']")
	private WebElement trainingCentreTypeDropDownList;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'Save and Continue')]")
	private WebElement saveAndContinueButton;

	public TrainingPartnerDashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOtherRozgarMela()
	{
		otherRozgarMelaLink.click();
	}
	
	public void clickOnChangeMySPOC()
	{
		changeMySPOCButton.click();
	}
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}
	
	public void clickOnMySchemes()
	{
		mySchemesButton.click();
	}
	
	public void clickMyCandidates()
	{
		myCandidatesCard.click();
	}
	
	public void clickOnRegisterCandidate()
	{
		registerCandidateButton.click();
	}
	
	public void clickToChooseBulkExcelSheetUpload()
	{
		bulkExcelSheetUploadRadioButton.click();
	}
	public void clickToChooseIndividualCandidateRegistration()
	{
		registerIndividualCandidateRadioButton.click();
	}
	public void clickForExcelFileBrowse()
	{
		excelFileBrowseButton.click();
	}
	
	public void clickClose()
	{
		closeButton.click();
	}
	public void clickRegister()
	{
		registerButton.click();
	}
	
	public void clickOnAddTrainingCentre()
	{
		addTrainingCentreButton.click();
	}
	
	public void clickOnViewTrainingCentre()
	{
		viewTrainingCentreButton.click();
	}
	
	public void selectForProcessType(String processType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(processTypeDropDownList, processType);
	}
	
	public void selectTrainingCentreType(String tcType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainingCentreTypeDropDownList, tcType);
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	
	
}	
	

	

	


