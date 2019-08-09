package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class SSC_BatchReSchedulePage
{
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement batchRescheduleSubmitButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	private WebElement trainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[1]")
	private WebElement closeTrainingStartDateCalenderIcon;
	@FindBy(xpath="//div[@class='datepicker-days']")
	private WebElement datePicker;
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	private WebElement trainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[2]")
	private WebElement closeTrainingEndDateCalenderIcon;
	//domain Job QP
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[1]")
	private WebElement domainTrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[3]")
	private WebElement closeDomainTrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[1]")
	private WebElement domainTrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[4]")
	private WebElement closeDomainTrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[1]")
	private WebElement domainAssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[5]")
	private WebElement closeDomainAssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[1]")
	private WebElement domainAssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[6]")
	private WebElement closeDomainAssessmentEndDateCalenderIcon;	
	//platform QP
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[2]")
	private WebElement platformTrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[7]")
	private WebElement closePlatformTrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[2]")
	private WebElement platformTrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[8]")
	private WebElement closePlatformTrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[2]")
	private WebElement platformAssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[9]")
	private WebElement closePlatformAssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[2]")
	private WebElement platformAssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[10]")
	private WebElement closePlatformAssessmentEndDateCalenderIcon;
	@FindBy(xpath="(//select[@class='custom-select'])[1]")
	private WebElement monthDropdownList;
	@FindBy(xpath="(//select[@class='custom-select'])[2]")
	private WebElement yearDropdownList;
		
	public SSC_BatchReSchedulePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void clickToSubmitRescheduledBatch()
	{
		batchRescheduleSubmitButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	//Batch Duration
	public void selectTrainingStartDateForBatch(String batchStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, batchStartDate, trainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseTrainingStartDateCalender()
	{
		closeTrainingStartDateCalenderIcon.click();
	}
	public void selectTrainingEndDateForNewBatch(String batchEndDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, batchEndDate, trainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectTrainingEndDateForExistingBatch(String batchEndDate) throws InterruptedException
	{	
		ToT_ToA_Batch_DatePicker.chooseDate(driver, batchEndDate, trainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseTrainingEndDateCalender()
	{
		closeTrainingEndDateCalenderIcon.click();
	}
	//Domain Training Dates
	public void selectDomainTrainingStartDate(String domainTrainingStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingStartDate, domainTrainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickTocloseDomainTrainingStartDateCalender()
	{
		closeDomainTrainingStartDateCalenderIcon.click();
	}
	public void selectDomainTrainingEndDateForNewBatch(String domainTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingEndDate, domainTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomainTrainingEndDateForExistingBatch(String domainTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingEndDate, domainTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomainTrainingEndDateCalender()
	{
		closeDomainTrainingEndDateCalenderIcon.click();
	}
	//Domain Assessment Dates
	public void selectDomainAssessmentStartDateForNewBatch(String domainAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentStartDate, domainAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomainAssessmentStartDateForExistingBatch(String domainAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentStartDate, domainAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomainAssessmentstartDateCalender()
	{
		closeDomainAssessmentStartDateCalenderIcon.click();
	}
	public void selectDomainAssessmentEndDateForNewBatch(String domainAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentEndDate, domainAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomainAssessmentEndDateForExistingBatch(String domainAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentEndDate, domainAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomainAssessmentEndDateCalender()
	{
		closeDomainAssessmentEndDateCalenderIcon.click();
	}
	//Platform Training Dates
	public void selectPlatformTrainingStartDate(String platformTrainingStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingStartDate, platformTrainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToclosePlatformTrainingStartDateCalender()
	{
		closePlatformTrainingStartDateCalenderIcon.click();
	}
	public void selectPlatformTrainingEndDateForNewBatch(String platformTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingEndDate, platformTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectPlatformTrainingEndDateForExistingBatch(String platformTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingEndDate, platformTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToClosePlatformTrainingEndDateCalender()
	{
		closePlatformTrainingEndDateCalenderIcon.click();
	}
	//Platform Assessment Dates
	public void selectPlatformAssessmentStartDateForNewBatch(String platformAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentStartDate, platformAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectPlatformAssessmentStartDateForExistingBatch(String platformAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentStartDate, platformAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToClosePlatformAssessmentstartDateCalender()
	{
		closePlatformAssessmentStartDateCalenderIcon.click();
	}
	public void selectPlatformAssessmentEndDateForNewBatch(String platformAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentEndDate, platformAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectPlatformAssessmentEndDateForExistingBatch(String platformAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentEndDate, platformAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToClosePlatformAssessmentEndDateCalender()
	{
		closePlatformAssessmentEndDateCalenderIcon.click();
	}
}