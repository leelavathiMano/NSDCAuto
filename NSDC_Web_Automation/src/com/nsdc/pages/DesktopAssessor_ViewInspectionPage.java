package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class DesktopAssessor_ViewInspectionPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchTPIDTextbox;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement action_Button;
	@FindBy(xpath="(//a[contains(text(),'View Quick Details')])[1]")
	private WebElement viewQuickDetails_Button;
	@FindBy(xpath="(//a[contains(text(),'Take Action')])[1]")
	private WebElement takeAction_Button;
	@FindBy(xpath="//button[text()='View All TP Request']")
	private WebElement viewAllTPRequestButton;
	@FindBy(xpath="//button[text()='View All TC Request']")
	private WebElement viewAllTCCRequestButton;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateDropDownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropDownList;
	@FindBy(xpath="//select[@formcontrolname='status']")
	private WebElement stageDropDownList;
	@FindBy(xpath="//input[@formcontrolname='createdOn']")
	private WebElement assignOnTextbox;
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement resetButton;
	
	
	public DesktopAssessor_ViewInspectionPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void enterKeywordForTPID(String searchTPID)
	{
		searchTPIDTextbox.clear();
		searchTPIDTextbox.sendKeys(searchTPID);
	}
	
	public void clickOnAction()
	{
		action_Button.click();
	}
	
	public void clickOnViewQuickDetails()
	{
		viewQuickDetails_Button.click();
	}
	
	public void clickOnTakeAction()
	{
		takeAction_Button.click();
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnViewAllTPRequest()
	{
		viewAllTPRequestButton.click();
	}
	
	public void clickOnViewAllTCRequest()
	{
		viewAllTCCRequestButton.click();
	}
	
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
	}
	
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}
	
	public void selectStage(String stage)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stageDropDownList, stage);
	}
	
	public void enterForAssignOn(String assignOn)
	{
		assignOnTextbox.clear();
		assignOnTextbox.sendKeys(assignOn);
	}
	
	public void clickOnReset()
	{
		resetButton.click();
	}

}
