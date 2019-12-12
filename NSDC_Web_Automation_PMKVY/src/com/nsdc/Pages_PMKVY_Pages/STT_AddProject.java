package com.nsdc.Pages_PMKVY_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;
import com.nsdc.testConfig.TestConfiguration;

public class STT_AddProject extends TestConfiguration {

	WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//input[@placeholder='Enter project proposal id']")
	private WebElement ProjectProposalIDEditBox;
	@FindBy(xpath="//input[@placeholder='Enter project name']")
	private WebElement ProjecNameTextBox;
	@FindBy(xpath="//label[input[@formcontrolname='projectType']][1]")
	private WebElement ProjectTypeButton;
	@FindBy(xpath="//input[@placeholder='Select Agreement Date']")
	private WebElement AggrementDate;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement SectorAddButton;
	
	@FindBy(xpath="//div[input[@placeholder='Select Start Date']]")
	private WebElement ProjectDurationStartDate;
	
	@FindBy(xpath="//div[input[@placeholder='Select End Date']]")
	private WebElement ProjectDurationEndDate;
	
	@FindBy(xpath="//div[@class='m-subheader']")
	private WebElement SubHeader;
	@FindBy(xpath="//select[@class='custom-select'][1]")
	private WebElement monthDropdownList;
	@FindBy(xpath="//select[@class='custom-select'][2]")
	private WebElement yearDropdownList;
	
	@FindBy(xpath="//button[@data-target='#AddTrainingCentres']")
	private WebElement AddButton;
	
	@FindBy(xpath="//input[@placeholder='Target Value']")
	private WebElement TargetValue;
	
	@FindBy(xpath="//*[@_ngcontent-c16 and @formcontrolname='targetValidity']")
	private WebElement TargetValidity;
	
	@FindBy(xpath="//select[@formcontrolname='sector']")
	private WebElement SectorList;
	
	@FindBy(xpath="//select[@formcontrolname='qpCode']")
	private WebElement JobRoleNameList;
	
	@FindBy(xpath="//input[@placeholder='Enter Target']")
	private WebElement EnterTarget;
	
	@FindBy(xpath="//select[@_ngcontent-c19 and @formcontrolname='targetValidity']")
	private WebElement TargetValidityInMonths;
	
	@FindBy(xpath="//label[contains(text(),'Signed Termsheet')]//following-sibling::div[1]//input")
	private WebElement SignedTermSheetBrowseBtn;
	
	@FindBy(xpath="//label[contains(text(),'Signed Agreement')]//following-sibling::div[1]//input")
	private WebElement SignedAgreementBrowseBtn;
	
	@FindBy(xpath="//label[contains(text(),'Other Supporting')]//following-sibling::div[1]//input")
	private WebElement OtherSupportingBrowseBtn;
	
	
	@FindBy(xpath="//label[contains(text(),'Signed Termsheet')]//following-sibling::div[1]//button")
	private WebElement SignedTermSheetUploadBtn;
	
	@FindBy(xpath="//label[contains(text(),'Signed Agreement')]//following-sibling::div[1]//button")
	private WebElement SignedAgreementUploadBtn;
	
	@FindBy(xpath="//label[contains(text(),'Other Supporting')]//following-sibling::div[1]//button")
	private WebElement OtherSupportingUploadBtn;
	
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement SaveAndSubmit;
	
	
	//label[contains(text(),'Signed Agreement')]//following-sibling::div[1]//input
	
	public STT_AddProject(WebDriver driver) {
		this.driver = driver;
		//AjaxElementLocatorFactory AjaxWait= new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void EnterTheProjectProposalID(String ProjectProposalID) throws InterruptedException 
	{
		//WebElement ProjectIDEditBox=wait.until(ExpectedConditions.elementToBeClickable(ProjectProposalIDEditBox));
		
		ProjectProposalIDEditBox.sendKeys(ProjectProposalID);
	}
	public void EnterTheProjecName(String ProjecName)
	{
		ProjecNameTextBox.sendKeys(ProjecName);
	}
	
	public void ClickProjectType() throws InterruptedException
	{
		Thread.sleep(2000);
		ProjectTypeButton.click();
	}
	
	public void ClickAggrementDate() throws InterruptedException 
	{
		  Thread.sleep(2000);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", AggrementDate);
	}
	
	
	
	public void SelectAggrementDate(String aggrementDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, aggrementDate, AggrementDate, monthDropdownList, yearDropdownList);
	}
	
	public void ClickStartDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(ProjectDurationStartDate).click().build().perform();
	}
	
	
	
	public void SelectProjectDurationStartDate(String StartDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, StartDate, ProjectDurationStartDate, monthDropdownList, yearDropdownList);
	}
	
	public void ClickEndDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(ProjectDurationEndDate).click().build().perform();
	}
	
	public void SelectProjectDurationEndDate(String EndDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, EndDate, ProjectDurationEndDate, monthDropdownList, yearDropdownList);
	}
	
	public void ClickAddButton()
	{
		AddButton.click();
	}
	
	public void EnterTargetValue(String TargetValueInNum)
	{
		TargetValue.sendKeys(TargetValueInNum);
	}
	public void SelectTargetValidity(String TargetValidityInNum)
	{	
		SelectDropDownList.selectDropDownListByValue(TargetValidity,TargetValidityInNum);
	}
	
	public void SelectSector(String Sector)
	{
		SelectDropDownList.selectDropDownListByValue(SectorList,Sector);
	}
	
	public void SelectJobRoleName(String JobRoleName)
	{
		SelectDropDownList.selectDropDownListByValue(JobRoleNameList ,JobRoleName);
	}
	
	public void EnterTargetValueAgain(String TargetValue)
	{
		EnterTarget.sendKeys(TargetValue);
	}
	
	public void SelectTargetValidityInMonths(String TargetValidityInNumInMonths)
	{	
		SelectDropDownList.selectDropDownListByValue(TargetValidityInMonths,TargetValidityInNumInMonths);
	}
	
	public void ClickSectorAddButton() throws InterruptedException
	{
		
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SectorAddButton);
		//SectorAddButton.click();
	}
	
	
	public void ClickSignedTermSheetBrowseBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		SignedTermSheetBrowseBtn.click();
		Thread.sleep(2000);
	}
	
	public void ClickSignedAgreementBrowseBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		SignedAgreementBrowseBtn.click();
		Thread.sleep(2000);
	}
	public void ClickOtherSupportingBrowseBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		OtherSupportingBrowseBtn.click();
		Thread.sleep(2000);
	}
	
	public void ClickSignedTermSheetUploadBtn() throws InterruptedException
	{	
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SignedTermSheetUploadBtn);
		//SignedTermSheetUploadBtn.click();
	}
	
	public void ClickSignedAgreementUploadBtn() throws InterruptedException
	{
		
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SignedAgreementUploadBtn);
		//SignedAgreementUploadBtn.click();
		
	}
	public void ClickOtherSupportingUploadBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", OtherSupportingUploadBtn);
		//OtherSupportingUploadBtn.click();
	}
	
	public void ClickSaveAndSubmitBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SaveAndSubmit);
}
}