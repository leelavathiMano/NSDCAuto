package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class InspectionAgency_ViewInspectionPage 
{
	WebDriver driver;
	
	@FindBy(xpath="(//input[@placeholder='Search by keyword'])[1]")
	private WebElement searchByKeywordTextbox;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement action_Button;
	@FindBy(xpath="(//a[contains(text(),'View Quick Details')])[1]")
	private WebElement viewQuickDetails_Button;
	@FindBy(xpath="(//a[contains(text(),'Take Action')])[1]")
	private WebElement takeAction_Button;
	@FindBy(xpath="(//select[@id='exampleSelect1'])[1]")
	private WebElement assignToDropDownList;
	@FindBy(xpath="(//select[@id='exampleSelect1'])[2]")
	private WebElement statusOfRequestDropDownList;
	@FindBy(xpath="//button[contains(text(),'Assign')]")
	private WebElement assign_Button;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[2]")
	private WebElement cancel_Button;
	
	public InspectionAgency_ViewInspectionPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterKeywordForSearch(String searchByKeyword)
	{
		searchByKeywordTextbox.clear();
		searchByKeywordTextbox.sendKeys(searchByKeyword);
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
	
	public void selectForAssign(String assignTo)
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

}
