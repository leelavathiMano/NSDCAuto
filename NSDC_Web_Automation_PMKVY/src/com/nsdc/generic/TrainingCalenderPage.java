package com.nsdc.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrainingCalenderPage {

	WebDriver driver;
	@FindBy(xpath="(//button[@class='btn btn-outline-secondary calendar input-group-append'])[1]")
	private WebElement DateAndDay;
	
	@FindBy(xpath = "//select[@class='custom-select'][1]")
	private WebElement monthDropdownList;
	
	@FindBy(xpath = "//select[@class='custom-select'][2]")
	private WebElement yearDropdownList;
	
	@FindBy(xpath="(//select[@formcontrolname='sessionPlanned'])[1]")
	private WebElement SessionPlanned;
	
	@FindBy(xpath="(//select[@formcontrolname='nosTaught'])[1]")
	private WebElement NOS;
	
	@FindBy(xpath = "//input[@placeholder='Select Start Time']")
	private WebElement BatchIntime;

	@FindBy(xpath = "//input[@placeholder='Select End Time']")
	private WebElement BatchOutTime;
	
	@FindBy(xpath = "//button[contains(text(),'Add Session')]")
	private WebElement AddSession;
	

	public void ClickDayAndDate() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(DateAndDay).click().build().perform();
	}
	
	public void SelectDayAndDate(String DayDate) throws InterruptedException {
		Thread.sleep(2000);
		ToT_ToA_Batch_DatePicker.chooseDate(driver, DayDate, DateAndDay, monthDropdownList, yearDropdownList);
	}
	
	@DataProvider
	public Object[][] TrainingCalenderData() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
				"TrainingCalender");
	}

	@Test(dataProvider = "TrainingCalenderData")
	public void TrainingCalenderComplete() throws Exception {
		
		TrainingCalenderPage tcp= new TrainingCalenderPage();
		tcp.ClickDayAndDate();
		tcp.SelectBatchStartDate(BatchStartDate);
		

		
	}
	
}
