package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_ViewAllSectorAndCoursesPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="(//button[@class='btn m-btn--pill btn-primary'])[1]")
	private WebElement addSectorButton;
	@FindBy(xpath="(//button[@class='btn m-btn--pill btn-primary'])[2]")
	private WebElement addCourseButton;
	@FindBy(xpath="//a[contains(text(),'Added Sectors')]")
	private WebElement addedSectorButton;
	@FindBy(xpath="//a[contains(text(),'Added Courses')]")
	private WebElement addedCourseButton;
	@FindBy(id="generalSearch")
	private WebElement searchTextbox;
	@FindBy(xpath="//select[@id='sector']")
	private WebElement sectorDropDownList;
	@FindBy(id="proposedTrainingTarget")
	private WebElement proposedTrainingTargetTextbox;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement undertakingDocument_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement undertakingDocument_UploadFileButton;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement affiliationCertificate_BrowseFileButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement affiliationCertificate_UploadFileButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	
	public TP_FeeBased_ViewAllSectorAndCoursesPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnAddSector()
	{
		addSectorButton.click();
	}
	
	public void clickOnAddCourse()
	{
		addCourseButton.click();
	}
	
	public void clickOnAddedSector()
	{
		addedSectorButton.click();
	}
	
	public void clickOnAddedCourse()
	{
		addedCourseButton.click();
	}
	
	public void enterForSearch(String search)
	{
		searchTextbox.clear();
		searchTextbox.sendKeys(search);	
	}
	
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	}
	
	public void enterProposedTrainingTarget(String trainingTarget)
	{
		proposedTrainingTargetTextbox.clear();
		proposedTrainingTargetTextbox.sendKeys(trainingTarget);
	}
	
	public void clickOnUndertakingDocument_BrowseFile()
	{
		undertakingDocument_BrowseFileButton.click();
	}
	
	public void clickOnUndertakingDocument_UploadFile()
	{
		undertakingDocument_UploadFileButton.click();
	}
	
	public void clickOnAffiliationCertificate_BrowseFile()
	{
		affiliationCertificate_BrowseFileButton.click();
	}
	
	public void clickOnAffiliationCertificate_UploadFile()
	{
		affiliationCertificate_UploadFileButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}
	

}
