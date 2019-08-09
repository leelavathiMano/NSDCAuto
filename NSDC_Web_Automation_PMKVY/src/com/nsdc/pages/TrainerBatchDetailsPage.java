package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TrainerBatchDetailsPage
{
	WebDriver driver;
	
	@FindBy(xpath="//select[@title='Select State']")
	private WebElement stateDropDownList;
	@FindBy(xpath="//select[@title='Select District']")
	private WebElement districtDropDownList;
	@FindBy(xpath="//select[@title='Select Sub-District']")
	private WebElement subDistrictDropDownList;
	@FindBy(xpath="//select[@title='Select Sector']")
	private WebElement sectorDropDownList;
	@FindBy(xpath="//select[@title='Select Sub-Sector']")
	private WebElement subSectorDropDownList;
	@FindBy(xpath="//select[@title='Select Job Role']")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="//select[@title='Select Batch Type']")
	private WebElement batchTypeDropDownList;
	@FindBy(xpath="//select[@title='Select Batch Status']")
	private WebElement batchStatusDropDownList;
	@FindBy(xpath="//input[@id='totApplicantStartDate']")
	private WebElement batchStartDateTextBox;
	@FindBy(xpath="(//span[@class='input-group-text'])[1]")
	private WebElement batchStartDateButton;
	@FindBy(xpath="//input[@id='totApplicantEndDate']")
	private WebElement batchEndDateTextBox;
	@FindBy(xpath="(//span[@class='input-group-text'])[2]")
	private WebElement batchEndDateButton;
	@FindBy(xpath="//span[contains(text(),'View Batches')]")
	private WebElement viewBatchesCard;
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(xpath="//a[contains(text(),'View all Batches')]")
	private WebElement viewAllBatchesButton;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement SearchByKeywordTextbox;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement actionButton;
	@FindBy(xpath="//a[text()='Apply to the batch']")
	private WebElement applyToTheBatchButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	public TrainerBatchDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}
	public void selectSubDistrict(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrictDropDownList, subDistrict);
	}
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	}
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropDownList, subSector);
	}
	public void selectJobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropDownList, jobRole);
	}
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropDownList, batchType);
	}
	public void selectBatchStatus(String batchStatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchStatusDropDownList, batchStatus);
	}
	
	public void enterBatchStartDate(String batch_StartDate) throws Exception
	{
		batchStartDateTextBox.clear();
		Thread.sleep(2000);
		batchStartDateTextBox.sendKeys(batch_StartDate);
		Thread.sleep(2000);
		batchStartDateButton.click();
	}
	public void enterBatchEndDate(String batch_EndDate) throws Exception
	{
		batchEndDateTextBox.clear();
		Thread.sleep(2000);
		batchEndDateTextBox.sendKeys(batch_EndDate);
		Thread.sleep(2000);
		batchEndDateButton.click();
	}
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public void clickButton()
	{
		viewAllBatchesButton.click();
	}
	public void enterSearchByKeyword(String Search_by_keyword) throws Exception
	{
		SearchByKeywordTextbox.clear();
		SearchByKeywordTextbox.sendKeys(Search_by_keyword);
	}
	public void clickActionButton()
	{
		actionButton.click();
	}
	public void clickApplyToTheBatchButton()
	{
		applyToTheBatchButton.click();
	}
	public void clickOkButton()
	{
		okButton.click();
	}
}