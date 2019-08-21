package com.nsdc.Pages_PMKVY_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsdc.generic.SelectDropDownList;

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
	
	public STT_BatchDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void EnterBatchSize(String BatchSizeInNumber)
	{
		BatchSize.sendKeys(BatchSizeInNumber);
	}
	
	public void SelectAssociatedQP(String AssociatedQP_JobRole)
	{	
		SelectDropDownList.selectDropDownListByVisibleText(AssociatedQP,AssociatedQP_JobRole);
	}
	
	public void SelectTrainingHours(String TrainingHoursPerHour)
	{	
		SelectDropDownList.selectDropDownListByVisibleText(TrainingHours,TrainingHoursPerHour);
	}
	
	public void ClickBatchInTime() throws InterruptedException
	{
		
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", BatchIntime);
	}
	
	public void EnterBatchInTime(String BatchInTiming)
	{
		BatchIntime.sendKeys(BatchInTiming);
	}
	
	public void EnterBatchOutTime(String BatchOutTiming)
	{
		BatchOutTime.sendKeys(BatchOutTiming);
	}
	
	public void ClickBatchOutTime() throws InterruptedException
	{
		
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", BatchOutTime);
	
	
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

}
