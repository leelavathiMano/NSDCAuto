package com.nsdc.Pages_PMKVY_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class STT_BatchDetailPage {

	WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//div[@class=\"col-xl-6\"][2]//child::div[1]//child::div[2]//descendant::div[3]")
	private WebElement MySchemesAndPrograms;

	@FindBy(xpath = "//input[@placeholder='Enter Batch Size']")
	private WebElement BatchSize;

	@FindBy(xpath = "//select[@formcontrolname='qpCode']")
	private WebElement AssociatedQP;

	@FindBy(xpath = "//select[@formcontrolname='trainingHoursPerDay']")
	private WebElement TrainingHours;

	@FindBy(xpath = "//input[@placeholder='Select Start Time']")
	private WebElement BatchIntime;

	@FindBy(xpath = "//input[@placeholder='Select End Time']")
	private WebElement BatchOutTime;

	@FindBy(xpath = "//div[input[@placeholder='Select Start Date']]")
	private WebElement BatchStartDate;

	@FindBy(xpath = "//div[input[@placeholder='Select End Date']]")
	private WebElement BatchEndDate;

	@FindBy(xpath = "//select[@class='custom-select'][1]")
	private WebElement monthDropdownList;
	@FindBy(xpath = "//select[@class='custom-select'][2]")
	private WebElement yearDropdownList;

	@FindBy(xpath = "//select[@formcontrolname='classRoom']")
	private WebElement ClassRoom;

	@FindBy(xpath = "//select[@formcontrolname='userName']")
	private WebElement TrainerName;

	@FindBy(xpath = "(//button[@_ngcontent-c30])[3]")
	private WebElement AssessmentDate;

	@FindBy(xpath = "//select[@formcontrolname='preferredAssessmentLanguage']")
	private WebElement AssessmentLang;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement Disclaimer;

	@FindBy(xpath = "(//div[@class='swal2-contentwrapper']//b)[1]")
	private WebElement BatchCreated;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement AddBatchTime;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement SaveBtn; 
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement Successfull_OK_Btn;
	

	public STT_BatchDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void EnterBatchSize(String BatchSizeInNumber) throws InterruptedException {
		Thread.sleep(3000);
		BatchSize.sendKeys(BatchSizeInNumber);
	}

	public void SelectAssociatedQP(String AssociatedQP_JobRole) {
		SelectDropDownList.selectDropDownListByVisibleText(AssociatedQP, AssociatedQP_JobRole);
	}

	public void SelectTrainingHours(String TrainingHoursPerHour) {
		SelectDropDownList.selectDropDownListByVisibleText(TrainingHours, TrainingHoursPerHour);
	}

	public void EnterBatchInTime(String BatchInTiming) {
		BatchIntime.sendKeys(BatchInTiming);
	}

	public void EnterBatchOutTime(String BatchOutTiming) {
		BatchOutTime.sendKeys(BatchOutTiming);
	}

	public void TAB_FromTrainingHours() throws InterruptedException {
		Thread.sleep(2000);
		TrainingHours.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}

	public void TAB_FromBatchUpTime() throws InterruptedException {
		Thread.sleep(2000);
		BatchIntime.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}
	
	public void KeyDown_FromBatchUpTime() throws InterruptedException {
		Thread.sleep(2000);
		
		BatchIntime.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
	}
	
	public void KeyDown_FromBatchEndTime() throws InterruptedException {
		Thread.sleep(2000);
		BatchEndDate.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
	}
	
	

	public void ClickStartDate() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(BatchStartDate).click().build().perform();
	}

	public void SelectBatchStartDate(String StartDate) throws InterruptedException {
		Thread.sleep(2000);
		ToT_ToA_Batch_DatePicker.chooseDate(driver, StartDate, BatchStartDate, monthDropdownList, yearDropdownList);
	}

	public void ClickEndDate() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(BatchEndDate).click().build().perform();
	}

	public void SelectBatchEndDate(String EndDate) throws InterruptedException {
		Thread.sleep(2000);
		ToT_ToA_Batch_DatePicker.chooseDate(driver, EndDate, BatchEndDate, monthDropdownList, yearDropdownList);
	}

	public void SelectClassRoom(String Classroom) {
		SelectDropDownList.selectDropDownListByVisibleText(ClassRoom, Classroom);
	}

	public void SelectTrainerName(String Trainer) {
		SelectDropDownList.selectDropDownListByValue(TrainerName, Trainer);
	
	}

	public void ClickAssessmentDate() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(AssessmentDate).click().build().perform();
	}

	public void SelectAssessemntDate(String AssesmentDate) throws InterruptedException {
		ToT_ToA_Batch_DatePicker.chooseDate(driver, AssesmentDate, AssessmentDate, monthDropdownList, yearDropdownList);
	}

	public void SelectAssessmentLang(String AssesmentLang) throws Exception {

		Thread.sleep(2000);
		SelectDropDownList.selectDropDownListByVisibleText(AssessmentLang, AssesmentLang);
		
	}

	public void ClickDisclaimer() throws Exception {

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Disclaimer);
	}
	
	
	public void ClickSave() throws Exception {

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SaveBtn);
	}
	
	public void ClickAddBatchTiming() throws Exception {

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", AddBatchTime);
	}
	
	public void StoreBatchName()
	{
		String str1=BatchCreated.getText();
		System.out.println(str1);
	}

	public void Click() throws Exception {
		/*
		 * Actions actions = new Actions(driver); Thread.sleep(2000);
		 * actions.moveToElement(MySchemesAndPrograms).click().build().perform();
		 */
		// wait.until(ExpectedConditions.visibilityOf(MySchemesAndPrograms)).click();
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", MySchemesAndPrograms);

		// wait.until(ExpectedConditions.elementToBeClickable(MySchemesAndPrograms)).click();
	}
	
	public void ClickOkBtn() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",Successfull_OK_Btn);
	}
	
	public void TimeSelect(String BatchInTiming) throws InterruptedException
	{
		String parts[]=BatchInTiming.split(":");
		String day=parts[0];
		int hour=Integer.parseInt(day);
		//TrainingHours.sendKeys(Keys.TAB);
		for(int i=1;i<=hour;i++)
		{
			Thread.sleep(2000);
			BatchIntime.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
		}
		BatchIntime.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		BatchIntime.sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		BatchIntime.sendKeys(Keys.TAB);
		if(parts[2].equals("PM"))
		{
			BatchEndDate.sendKeys(Keys.ARROW_DOWN);
		}
	
	}
}
