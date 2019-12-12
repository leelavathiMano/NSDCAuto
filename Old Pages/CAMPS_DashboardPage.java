package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CAMPS_DashboardPage
{
	WebDriver driver;
	@FindBy(xpath="//p[contains(text(),'My Candidates')]")
	private WebElement myCandidatesCard;
	@FindBy(xpath="//p[text()='Register Candidates']")
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
	@FindBy(xpath="//span[contains(text(),'Register Candidate')]")
	private WebElement registerCandidate_InMyCandidateButton;
	
	public CAMPS_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
	public void clickOnRegisterCandidate_InViewMyCandidate()
	{
		registerCandidate_InMyCandidateButton.click();
	}
}