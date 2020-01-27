package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_FeeBased_CreateBatchAddSectorTargetPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="//button[contains(text(),' All Batches')]")
	private WebElement allBatchesButton;
	@FindBy(xpath="//button[contains(text(),'Assigned Sector')]")
	private WebElement assignedSectorTargetsButton;
	@FindBy(xpath="//input[@id='fullDate']")
	private WebElement batchStartDateTextbox;
	@FindBy(xpath="//input[@placeholder='End date']")
	private WebElement batchEndDateTextbox;
	@FindBy(xpath="//select[@formcontrolname='stage']")
	private WebElement stageDropDownList;
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchBatchIDTextbox;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applyButton;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	private WebElement resetButton;
	@FindBy(xpath="(//button[@class='btn btn-outline-info'])[1]")
	private WebElement addSectorTargetButton;
	@FindBy(xpath="//button[@class='btn btn-primary blue-btn']")
	private WebElement createBatchButton;
	@FindBy(xpath="//select[@id='sector']")
	private WebElement sectorDropDownList;
	@FindBy(xpath="//select[@id='course']")
	private WebElement courseDropDownList;
	@FindBy(xpath="//input[@id='target']")
	private WebElement targetTextbox;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	
	
	public TP_FeeBased_CreateBatchAddSectorTargetPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnAllBatches()
	{
		allBatchesButton.click();
	}
	
	public void clickOnAssignedSectorTargets()
	{
		assignedSectorTargetsButton.click();
	}
	
	public void enterBatchStartDate(String startDate)
	{
		batchStartDateTextbox.clear();
		batchStartDateTextbox.sendKeys(startDate);
	}
	
	public void enterBatchEndDate(String endDate)
	{
		batchEndDateTextbox.clear();
		batchEndDateTextbox.sendKeys(endDate);
	}
	
	public void selectStage(String stage)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stageDropDownList, stage);
	}
	
	public void enterForSearchBatchID(String batchID)
	{
		searchBatchIDTextbox.clear();
		searchBatchIDTextbox.sendKeys(batchID);
	}
	
	public void clcikOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnReset()
	{
		resetButton.click();
	}
	
	public void clickOnAddSectorTargets()
	{
		addSectorTargetButton.click();
	}
	
	public void clickOnCreateBatch()
	{
		createBatchButton.click();
	}
	
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropDownList, sector);
	}
	
	public void selectCourse(String course)
	{
		SelectDropDownList.selectDropDownListByVisibleText(courseDropDownList, course);
	}
	
	public void enterTarget(String target)
	{
		targetTextbox.clear();
		targetTextbox.sendKeys(target);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}

}
