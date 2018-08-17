package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.nsdc.generic.SelectDropDownList;

public class SSC_LocationBasedTC_TrainingBatchCreationPage 
{
	WebDriver driver;
	@FindBy(xpath="//select[@formcontrolname='subSector']")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='batchType']")
	private WebElement batchTypeDropdownList;
	@FindBy(xpath="//select[@formcontrolname='jobRole']")
	private WebElement jobRoleMultiSelectDropdownList;
	@FindBy(xpath="//input[@formcontrolname='batchFees']")
	private WebElement trainingFeesTextField;
	@FindBy(xpath="//select[@formcontrolname='batchSize']")
	private WebElement batchSizeDropdownLiast;
	@FindBy(xpath="(//input[@id='startDate'])[1]")
	private WebElement trainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[1]")
	private WebElement closeTrainingStartDateCalender;
	@FindBy(xpath="//div[@class='datepicker-days']")
	private WebElement datePicker;
	@FindBy(xpath="(//input[@id='endDate'])[1]")
	private WebElement trainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[2]")
	private WebElement closeTrainingEndDateCalender;
	@FindBy(xpath="(//input[@id='startDate'])[2]")
	private WebElement assessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[3]")
	private WebElement closeAssessmentStartDateCalender;
	@FindBy(xpath="(//input[@id='endDate'])[2]")
	private WebElement assessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[4]")
	private WebElement closeAssessmentEndDateCalender;
	@FindBy(xpath="//div[@formgroupname='batchDates']/div[2]/span")
	private WebElement autoUpdatedBatchStartDate;
	@FindBy(xpath="//div[@formgroupname='batchDates']/div[3]/span")
	private WebElement autoUpdatedBatchEndDate;
	@FindBy(xpath="//button[contains(text(),'Create Batch')]")
	private WebElement createBatchButton;
	@FindBy(xpath="//a[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	//serching for available location based training centre
	@FindBy(xpath="//input[@class='form-control ng-untouched ng-pristine']")
	private WebElement batchNameReadOnlyTextField;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateDropdownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subDistrict']")
	private WebElement subDistrictDropdownList;
	@FindBy(xpath="//button[text()='Search & Assign Training Centre']")
	private WebElement searchAndAssignTrainingCentreButton;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchTextBox;
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement actionDropdownMenu;
	@FindBy(linkText="View Details")
	private WebElement viewDetailsOptionLink;
	@FindBy(linkText="Assign Batch")
	private WebElement assignBatchOptionLink;
	@FindBy(xpath="(//button[text()='Assign'])[1]")
	private WebElement assignTrainingCentreButton1;
	@FindBy(xpath="(//button[text()='Back'])[1]")
	private WebElement backButton;
	@FindBy(xpath="(//button[text()='Assign'])[2]")
	private WebElement assignTrainingCentreButton2;
	
	
	public SSC_LocationBasedTC_TrainingBatchCreationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropdownList, subSector);
	}
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropdownList, batchType);
	}
	public void selectJobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleMultiSelectDropdownList, jobRole);
	}
	public void isFeesReadOnly()
	{
		Assert.assertFalse(trainingFeesTextField.isEnabled());
	}
	public void clickToViewFees()
	{
		trainingFeesTextField.click();
	}
	public void selectBatchSize(String batchSize)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchSizeDropdownLiast, batchSize);
	}
	public void selectTrainingStartDateForNewBatch()
	{
		//trainingStartDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(16));        date fields cannot be edited     
		trainingStartDateTextField.click();
		trainingStartDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ENTER);
	}
	public void selectTrainingStartDateForExistingBatch()
	{
		//trainingStartDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(16));   
		trainingStartDateTextField.click();
		trainingStartDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ENTER);
		
	}
	public void clickToCloseTrainingStartDateCalender()
	{
		closeTrainingStartDateCalender.click();
	}
	public void selectTrainingEndDateForNewBatch()
	{
		//trainingEndDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(25)); 
		trainingEndDateTextField.click();
		trainingEndDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.RIGHT,Keys.ENTER);
	}
	public void selectTrainingEndDateForExistingBatch()
	{	
		//trainingEndDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(16)); 
		trainingEndDateTextField.click();
		trainingEndDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ENTER);
	}
	public void clickToCloseTrainingEndDateCalender()
	{
		closeTrainingEndDateCalender.click();
	}
	public void selectAssessmentStartDateForNewBatch()
	{		
		//assessmentStartDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(25));
		assessmentStartDateTextField.click();
		assessmentStartDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.RIGHT,Keys.ENTER);
		
	}
	public void selectAssessmentStartDateForExistingBatch()
	{
		//assessmentStartDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(16));
		assessmentStartDateTextField.click();
		assessmentStartDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ENTER);
	}
	
	public void clickToCloseAssessmentStartDateCalender()
	{
		closeAssessmentStartDateCalender.click();
	}
	public void selectAssessmenEndDateForNewBatch()
	{
		//assessmentEndDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(25));
		assessmentEndDateTextField.click();
		assessmentEndDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.RIGHT,Keys.ENTER);
	}
	public void selectAssessmenEndDateForExistingBatch()
	{
		//assessmentEndDateTextField.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(16));
		assessmentEndDateTextField.click();
		assessmentEndDateTextField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ENTER);
	}
	
	public void clickToCloseAssessmentEndDateCalender()
	{
		closeAssessmentEndDateCalender.click();
	}
	public void clickToCreateBatch()
	{
		createBatchButton.click();
	}
	public void clickToCancelBatchCreation()
	{
		cancelButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	//searching for available location based tc
	public void isBatchNameReadOnly()
	{
		Assert.assertFalse(batchNameReadOnlyTextField.isEnabled());
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropdownList, state);
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropdownList, district);
	}
	public void selectSubDistrict(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrictDropdownList, subDistrict);
	}
	public void clickToSearchAndAssignTrainingCentre()
	{
		searchAndAssignTrainingCentreButton.click();
	}
	public void clickToCancelSearchAndAssignTrainingCentreStep()
	{
		cancelButton.click();
	}
	//Search Result Page - List Of available Training Centres
	public void enterToSearchForTrainingCentreID(String trainingCentreID)
	{
		searchTextBox.clear();
		searchTextBox.sendKeys(trainingCentreID);
	}
	public void clickActionMenu()
	{
		actionDropdownMenu.click();
	}
	public void clickViewDetails()
	{
		viewDetailsOptionLink.click();
	}
	public void clickAssignBatch()
	{
		assignBatchOptionLink.click();
	}
	public void clickToAssignTrainingCentre()
	{
		assignTrainingCentreButton1.click();
	}
	public void clickToGoBackToSearchforTrainingCentreResultPage()
	{
		backButton.click();
	}
	public void clickToAssignTrainingCentreFinal()
	{
		assignTrainingCentreButton2.click();
	}
}
