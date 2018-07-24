package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SSCBatchAnnouncementPage
{
	WebDriver driver;
	@FindBy(xpath="//p[text()='Create Batch']")
	private WebElement createBatchCard;
	@FindBy(xpath="//select[@ng-reflect-name='subSector']")
	private WebElement subSectorDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='batchType']")
	private WebElement batchTypeDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='jobRole']")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='batchSize']")
	private WebElement batchSizeDropDownList;
	@FindBy(id="startDate")
	private WebElement trainingFromTextBox;
	@FindBy(xpath="(//span[@class='input-group-text'])[1]")
	private WebElement trainingTextFromButton;
	@FindBy(id="endDate")
	private WebElement trainingToTextBox;
	@FindBy(xpath="(//span[@class='input-group-text'])[2]")
	private WebElement trainingTextToButton;
	@FindBy(xpath="(//input[@id='startDate'])[2]")
	private WebElement assessmentFromTextBox;
	@FindBy(xpath="(//span[@class='input-group-text'])[3]")
	private WebElement assessmentTextFromButton;
	@FindBy(xpath="(//span[@class='input-group-text'])[3]")
    private WebElement assessmentTextFromOneButton;
	@FindBy(xpath="(//input[@id='endDate'])[2]")
	private WebElement assessmentToTextBox;
	@FindBy(xpath="(//span[@class='input-group-text'])[4]")
	private WebElement assessmentTextToButton;
	@FindBy(xpath="(//span[@class='input-group-text'])[6]")
    private WebElement assessmentTextToOneButton;
	@FindBy(xpath="//button[text()='Create Batch']")
	private WebElement createBatchButton;
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okBatchIDButton;
	@FindBy(xpath="//select[@formcontrolname='state']")
    private WebElement stateDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='district']")
    private WebElement districtDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='subDistrict']")
    private WebElement subDistrictDropDownList;
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(xpath="//a[contains(text(),'»')]")
	private WebElement lastPageButton;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextBox;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement actionButton;
	@FindBy(xpath="//a[@href='/ssc/create-batch/training-centre-details/TC_000024']")
	private WebElement viewDetailsButton;
	@FindBy(xpath="//a[text()='Assign Batch']")
	private WebElement assignBatchButton;
	@FindBy(xpath="//button[text()='Assign']")
	private WebElement assignButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	@FindBy(xpath="//img[@class='m--img-rounded m--marginless m--img-centered']")
	private WebElement logoutLogoButton;
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	private WebElement logoutButton;
	
	public SSCBatchAnnouncementPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropDownList, subSector);
	}
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropDownList, batchType);
	}
	public void selectJobRoleDropDownList(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropDownList, jobRole);
	}
	
	public void selectBatchSizeDropDownList(String batchSize)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchSizeDropDownList, batchSize);
	}
	
	public void enterTrainingFromDate(String training_from) throws Exception
	{
		trainingFromTextBox.clear();
		Thread.sleep(2000);
		trainingFromTextBox.sendKeys(training_from);
		Thread.sleep(3000);
	    trainingTextFromButton.click();
		
	}	
	
	public void enterTrainingToDate(String training_to) throws Exception
	{
		trainingToTextBox.clear();
		Thread.sleep(2000);
		trainingToTextBox.sendKeys(training_to);
		Thread.sleep(3000);
		trainingTextToButton.click();
	}	
	
	public void enterAssessmentFromDate(String assessment_from) throws Exception
	{
		assessmentFromTextBox.clear();
		Thread.sleep(2000);
		assessmentFromTextBox.sendKeys(assessment_from);
		Thread.sleep(3000);
		assessmentTextFromButton.click();
	}
	
	
	public void enterAssessmentToDate(String assessment_to) throws Exception
	{
		assessmentToTextBox.clear();
		Thread.sleep(2000);
		assessmentToTextBox.sendKeys(assessment_to);
		Thread.sleep(3000);
		assessmentTextToButton.click();
	}
	
	public void clickCreateBatchButton()
	{
		createBatchButton.click();
	}
	 
	public void clickCancelButton()
	{
		cancelButton.click();
	}
	public void clickOkBatchIdButton()
	{
		okBatchIDButton.click();
	}
	
	public void selectStateDropDownList(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
	}
	
	public void selectDistrictDropDownList(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}
	
	
	public void selectSubDistrictDropDownList(String sub_district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrictDropDownList, sub_district);
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	 
	public void clickLastPageButton() throws Exception
	{
		lastPageButton.click();
		Thread.sleep(3000);
		lastPageButton.click();
	}
	
	public void enterTrainingCentreID(String training_Centre_Id) throws Exception
	{
		
		searchByKeywordTextBox.sendKeys(training_Centre_Id);
	}	
	
	public void clickActionButton()
	{
		actionButton.click();
	}
	 
	public void clickAssignBatchButton()
	{
		assignBatchButton.click();
	}
	
	public void clickAssignButton()
	{
		assignButton.click();
	}
	
	public void clickOkButton()
	{
		okButton.click();
	}
	public void clickLogoutLogoButton()
	{
		logoutLogoButton.click();
	}
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
	
	
}