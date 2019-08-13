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

import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class STT_AddProject {

	WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//input[@placeholder='Enter project proposal id']")
	private WebElement ProjectProposalIDEditBox;
	@FindBy(xpath="//input[@placeholder='Enter project name']")
	private WebElement ProjecNameTextBox;
	@FindBy(xpath="(//label[input[@formcontrolname='projectType']])[1]")
	private WebElement ProjectTypeButton;
	@FindBy(xpath="//div[input[@placeholder='Select Agreement Date']]")
	private WebElement AggrementDate;
	
	@FindBy(xpath="(//select[@class='custom-select'][1]")
	private WebElement monthDropdownList;
	@FindBy(xpath="(//select[@class='custom-select'][2]")
	private WebElement yearDropdownList;

	public STT_AddProject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void EnterTheProjectProposalID(String ProjectProposalID) 
	{
		ProjectProposalIDEditBox.sendKeys(ProjectProposalID);
	}
	public void EnterTheProjecName(String ProjecName)
	{
		ProjecNameTextBox.sendKeys(ProjecName);
	}
	
	public void ClickProjectType()
	{
		ProjectTypeButton.click();
	}
	
	public void SelectAggrementDate(String aggrementDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, aggrementDate, AggrementDate, monthDropdownList, yearDropdownList);
	}
	
	
}
