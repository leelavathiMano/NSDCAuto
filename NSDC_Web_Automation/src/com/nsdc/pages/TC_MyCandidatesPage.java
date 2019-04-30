package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_MyCandidatesPage
{
	WebDriver driver;
	@FindBy(linkText="Register Candidate")
	private WebElement registerCandidateLink;
	@FindBy(xpath="(//label[@class='m-radio'])[1]")
	private WebElement bulkExcelSheetUploadRadioButton;
	@FindBy(xpath="(//label[@class='m-radio'])[2]")
	private WebElement registerIndividualCandidateRadioButton;
	@FindBy(xpath="//input[@formcontrolname='excelFile']")
	private WebElement excelFileBrowseButton;
	@FindBy(linkText="Download Template")
	private WebElement downloadTemplateLink;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'Register')]")
	private WebElement registerButton;
	@FindBy(xpath="//input[@formcontrolname='candidateId']")
	private WebElement searchByCandidateIDTextField;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applyFiltersButton;
	@FindBy(xpath="(//label[input[@type='checkbox']]/span)[2]")
	private WebElement candidateRecordCheckbox;
	@FindBy(xpath="//button[contains(text(),'Download Report')]")
	private WebElement downloadReportForSelectedCandidatesButton;
	@FindBy(xpath="//input[@formcontrolname='keyword']")
	private WebElement searchByKeywordsTextField;
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement registeredCandidateActionLink;
	@FindBy(linkText="View Details")
	private WebElement registeredCandidateViewDetailsOptionLink;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	
	public TC_MyCandidatesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickRegisterCandidate()
	{
		registerCandidateLink.click();
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
	public void clickToDownloadTemplate()
	{
	downloadTemplateLink.click();
	}
	public void clickClose()
	{
		closeButton.click();
	}
	public void clickRegister()
	{
		registerButton.click();
	}
	public void enterCandidateIDToSearch(String candidateID)
	{
		searchByCandidateIDTextField.clear();
		searchByCandidateIDTextField.sendKeys(candidateID);
	}
	public void clickToApplySearchFilters()
	{
		applyFiltersButton.click();
	}
	public void clickToSelectCreatedCandidateRecord()
	{
		candidateRecordCheckbox.click();
	}
	public void clickToDownloadReportForSelectedCandidates()
	{
		downloadReportForSelectedCandidatesButton.click();
	}
	public void enterKeywordsToSearch(String keywordToSearch)
	{
		searchByKeywordsTextField.clear();
		searchByKeywordsTextField.sendKeys(keywordToSearch);
	}
	public void clickToGetRegisteredCandidateActionMenu()
	{
		registeredCandidateActionLink.click();
	}
	public void selectRegisteredCandidateViewDetailsOption()
	{
		registeredCandidateViewDetailsOptionLink.click();
	}
	public void clickGoBack()
	{
		goBackButton.click();
	}
}