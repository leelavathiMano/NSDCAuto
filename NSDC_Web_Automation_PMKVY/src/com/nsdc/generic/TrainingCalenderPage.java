package com.nsdc.generic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrainingCalenderPage {

	WebDriver driver;

	public TrainingCalenderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//wait = new WebDriverWait(driver, 30);
	}

	
	@FindBy(xpath="(//button[@class='btn btn-outline-secondary calendar input-group-append'])[1]")
	private WebElement DateAndDay;
	
	@FindBy(xpath = "//select[@class='custom-select'][1]")
	private WebElement monthDropdownList;
	
	@FindBy(xpath = "//select[@class='custom-select'][2]")
	private WebElement yearDropdownList;
	
	@FindBy(xpath="(//select[@formcontrolname='sessionPlanned'])[1]")
	private WebElement SessionPlanned;
	
	
	@FindBy(xpath = "//input[@placeholder='Select Start Time']")
	private WebElement BatchIntime;

	@FindBy(xpath = "//input[@placeholder='Select End Time']")
	private WebElement BatchOutTime;
	
	@FindBy(xpath = "//button[contains(text(),'Add Session')]")
	private WebElement AddSession;
	
	@FindBy(xpath = "//a[i[@class='la la-ellipsis-h']]")
	private WebElement ThreeDots;

	@FindBy(xpath ="//button[contains(text(),'Save & Update Training Calender')]")
	private WebElement UpdateTrainingCalender;
	
	@FindBy(xpath = "(//select[@id='exampleSelect1'])[2]")
	private WebElement NOSTaught;
	@FindBy(xpath = "(//textarea[@placeholder='Enter Description'])[1]")
	private WebElement EnterDescriptionTextArea;
	
	public void ClickDayAndDate() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(DateAndDay).click().build().perform();
	}
	public void ClickTrainingCalender() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(UpdateTrainingCalender).click().build().perform();
	}
	
	public void SelectDayAndDate(String DayDate) throws InterruptedException {
		Thread.sleep(2000);
		ToT_ToA_Batch_DatePicker.chooseDate(driver, DayDate, DateAndDay, monthDropdownList, yearDropdownList);
	}
	
	public void ClickThreeDots() throws InterruptedException
	{
		Thread.sleep(2000);
		ThreeDots.click();
	}
	
	public void SelectSessionPlanned(String SessionPlan) {
		SelectDropDownList.selectDropDownListByVisibleText(SessionPlanned, SessionPlan);
	}
	

	
	public void EnterStartTime(String StartTime) {
		BatchIntime.sendKeys(StartTime);
	}
	
	public void EnterEndTime(String EndTiming) {
		BatchOutTime.sendKeys(EndTiming);
	}
	
	public void TAB_FromNOSTaught() throws InterruptedException {
		Thread.sleep(2000);
		NOSTaught.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}
	
	public void TAB_BatchIntime() throws InterruptedException {
		Thread.sleep(2000);
		BatchIntime.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}
	public void EnterDescription(String Description) throws InterruptedException
	{
		Thread.sleep(2000);
		EnterDescriptionTextArea.sendKeys(Description);
	}
	
	public void ClickAddSession() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(AddSession).click().build().perform();
	}
	public void SelectNOSTaught(String SessionPlan) {
		SelectDropDownList.selectDropDownListByValue(NOSTaught, SessionPlan);
	}
	
	
	@DataProvider
	public Object[][] TrainingCalenderData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
				"TrainingCalender");
	}

	@Test(dataProvider = "TrainingCalenderData")
	public void TrainingCalenderComplete(String DayAndDate, String SessionPlan, String NOSTaught, String StartTime, String EndTime ,String Description) throws Exception {
		
		TrainingCalenderPage tcp= new TrainingCalenderPage(driver);
		tcp.ClickThreeDots();
		tcp.ClickDayAndDate();
		tcp.SelectDayAndDate(DayAndDate);
		tcp.SelectSessionPlanned(SessionPlan);
		tcp.SelectNOSTaught(NOSTaught);
		tcp.TAB_FromNOSTaught();
		tcp.EnterStartTime(StartTime);
		tcp.TAB_BatchIntime();
		tcp.EnterEndTime(EndTime);
		tcp.EnterDescription(Description);
		tcp.ClickAddSession();
		tcp.ClickTrainingCalender();
		
		
	}
	
}
