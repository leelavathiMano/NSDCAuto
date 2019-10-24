package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class SP_TC_Batch_CreatePage
{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Enter Batch Size']")
	private WebElement BatchSize;

	@FindBy(xpath = "//select[@formcontrolname='qpCode']")
	private WebElement AssociatedQP;

	@FindBy(xpath = "//input[@formcontrolname='trainingHoursPerDay']")
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


	@FindBy(xpath = "//select[@formcontrolname='userName']")
	private WebElement TrainerName;

	@FindBy(xpath = "(//button[@_ngcontent-c30])[3]")
	private WebElement AssessmentDate;

	@FindBy(xpath = "//select[@formcontrolname='preferredAssessmentLanguage']")
	private WebElement AssessmentLang;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement Disclaimer;
	
	@FindBy(xpath = "//button[text()='Save & Next']")
	private WebElement SaveAndNextButton;
	
	@FindBy(xpath = "(//div[@class='swal2-contentwrapper']//b)[1]")
	private WebElement BatchCreated;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement AddBatchTime;
	@FindBy(xpath ="//button[text()='OK']")
	private WebElement OkButton;
	public SP_TC_Batch_CreatePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	public void EnterBatchSize(String BatchSizeInNumber) throws InterruptedException 
	{
		Thread.sleep(2000);
		BatchSize.sendKeys(BatchSizeInNumber);
	}

	public void SelectAssociatedQP(String AssociatedQP_JobRole) {
		SelectDropDownList.selectDropDownListByVisibleText(AssociatedQP, AssociatedQP_JobRole);
	}

//

	public void EnterTrainingHours(String tryingHours) throws InterruptedException
	{
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(TrainingHours).click().sendKeys(tryingHours).build().perform();
		Thread.sleep(2000);
	}
	
	public void ClickTrainingHours() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", TrainingHours);
	}
	
	
	
	public void EnterBatchInTime(String BatchInTiming) throws InterruptedException 
	{
		
		
		//Thread.sleep(2000);
		BatchIntime.sendKeys(BatchInTiming);
		//Thread.sleep(2000);

	}

	public void EnterBatchOutTime(String BatchOutTiming) throws InterruptedException 
	{
		
		//Thread.sleep(2000);
	    BatchOutTime.sendKeys(BatchOutTiming);
	    //Thread.sleep(2000);
	}

	public void TAB_FromTrainingHours() throws InterruptedException 
	{
		Thread.sleep(5000);
		TrainingHours.sendKeys(Keys.TAB);
		Thread.sleep(2000);
 	}	

	public void TAB_FromBatchUpTime() throws InterruptedException {
		Thread.sleep(5000);
		BatchIntime.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}

	public void ClickStartDate() throws InterruptedException
	{
		Thread.sleep(2000);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(BatchStartDate).click().build().perform();
		BatchStartDate.click();
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



	public void SelectTrainerName(String Trainer) {
		SelectDropDownList.selectDropDownListByVisibleText(TrainerName, Trainer);
	}

	public void ClickAssessmentDate() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(AssessmentDate).click().build().perform();
	}

	public void SelectAssessemntDate(String AssesmentDate) throws InterruptedException {
		ToT_ToA_Batch_DatePicker.chooseDate(driver, AssesmentDate, AssessmentDate, monthDropdownList, yearDropdownList);
	}

//	public void ClickAssessmentLang() throws Exception {
//
//		Thread.sleep(2000);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", AssessmentLang);
//	}
	public void SelectAssessmentLanguage(String Language)
	{
		SelectDropDownList.selectmultipleoptions(AssessmentLang);
	}

	public void ClickDisclaimer() throws Exception {

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Disclaimer);
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
	public void ClickOnSaveAndNext()
	{
		SaveAndNextButton.click();
	}
public void ClickOnOKButton()
{
	OkButton.click();
}



public void BatchinTimeSelect(String BatchInTiming) throws InterruptedException
{
	String parts[]=BatchInTiming.split(":");
	String day=parts[0];
	int hour=Integer.parseInt(day);
	//TrainingHours.sendKeys(Keys.TAB);
	for(int i=1;i<=hour;i++)
	{
		Thread.sleep(2000);
		BatchIntime.sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
	}
	BatchIntime.sendKeys(Keys.TAB);
	Thread.sleep(1000);
	BatchIntime.sendKeys(Keys.ARROW_UP);
	Thread.sleep(1000);
	BatchIntime.sendKeys(Keys.TAB);
	if(parts[2].equals("PM"))
	{
		BatchIntime.sendKeys(Keys.ARROW_DOWN);
	}
}
public void BatchoutTimeSelect(String Batchouttime) throws InterruptedException
{
	String parts[]=Batchouttime.split(":");
	String day=parts[0];
	int hour=Integer.parseInt(day);
	//TrainingHours.sendKeys(Keys.TAB);
	for(int i=1;i<=hour;i++)
	{
		Thread.sleep(1000);
		BatchOutTime.sendKeys(Keys.ARROW_UP);
		
	}
	BatchOutTime.sendKeys(Keys.TAB);
	Thread.sleep(1000);
	BatchOutTime.sendKeys(Keys.ARROW_UP);
	Thread.sleep(2000);
	BatchOutTime.sendKeys(Keys.TAB);
	if(parts[2].equals("PM"))
	{
		Thread.sleep(1000);
		BatchOutTime.sendKeys(Keys.ARROW_DOWN);
	}
}

}







