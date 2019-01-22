package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class InspectionAgency_ViewInspectionPage 
{
	WebDriver driver;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[1]")
	private WebElement searchTPIDTextbox;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement action_Button;
	@FindBy(xpath="(//a[contains(text(),'View Quick Details')])[1]")
	private WebElement viewQuickDetails_Button;
	@FindBy(xpath="(//a[contains(text(),'Take Action')])[1]")
	private WebElement takeAction_Button;
	@FindBy(xpath="(//select[@formcontrolname='da'])[1]")
	private WebElement assignToDropDownList;
	@FindBy(xpath="(//select[@id='exampleSelect1'])[2]")
	private WebElement statusOfRequestDropDownList;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[3]")
	private WebElement assign_Button;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[2]")
	private WebElement cancel_Button;
	@FindBy(linkText="View All TP Request")
	private WebElement tpRequestButton;
	@FindBy(linkText="View All TC Request")
	private WebElement tcRequestButton;
	@FindBy(xpath="//select[@formcontrolname='status']")
	private WebElement stageDropDownList;
	@FindBy(xpath="//input[@placeholder='Select Date']")
	private WebElement assignedOnTextbox;
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement resetButton;
	@FindBy(xpath="//button[text()='De-Select All']")
	private WebElement deSelectAllButton;
	@FindBy(xpath="//button[text()='Take Action']")
	private WebElement takeActionButton;
	@FindBy(xpath="//select[@formcontrolname='assignedUser']")
	private WebElement assignTo_FirstDropDownList;
	
	
	public InspectionAgency_ViewInspectionPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterTPIDForSearch(String tpID)
	{
		searchTPIDTextbox.clear();
		searchTPIDTextbox.sendKeys(tpID);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnAction()
	{
		action_Button.click();
	}
	
	public void clickOn_ViewQuickDetails()
	{
		viewQuickDetails_Button.click();
	}
	
	public void clickOnTakeAction()
	{
		takeAction_Button.click();
	}
	
	public void selectForAssignTo_Second(String assignTo)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignToDropDownList, assignTo);
	}
	
	public void selectStatusForRequest(String statusForRequest)
	{
		SelectDropDownList.selectDropDownListByVisibleText(statusOfRequestDropDownList, statusForRequest);
	}
	
	public void clickForAssign()
	{
		assign_Button.click();
	}
	
	public void clickForCancel()
	{
		cancel_Button.click();
	}
	
	public void clickOnViewAllTPRequest()
	{
		tpRequestButton.click();
	}
	
	public void clickOnViewAllTCRequest()
	{
		tcRequestButton.click();
	}
	
	public void selectStage(String stage)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stageDropDownList, stage);
	}
	
	public void enterAssignedOn(String assignedOn)
	{
		assignedOnTextbox.clear();
		assignedOnTextbox.sendKeys(assignedOn);
	}
	
	public void clickOnReset()
	{
		resetButton.click();
	}
	
	public void clickOnDeSelectAllButton()
	{
		deSelectAllButton.click();
	}
	
	public void clickOnTakeAction_ForAll()
	{
		takeActionButton.click();
	}
	
	public void selectAssignTo_First(String assign)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignTo_FirstDropDownList, assign);
	}

}
