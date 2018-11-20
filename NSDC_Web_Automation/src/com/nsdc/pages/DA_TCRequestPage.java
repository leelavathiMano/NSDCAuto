package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class DA_TCRequestPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='View All TC Request']")
	private WebElement viewAllTCRequestButton;
	@FindBy(xpath="//input[@formcontrolname='tcId']")
	private WebElement searchTCIDTextbox;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateDropDownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropDownList;
	@FindBy(xpath="//select[@formcontrolname='status']")
	private WebElement stageDropDownList;
	@FindBy(xpath="//input[@formcontrolname='createdOn']")
	private WebElement assignedOnTextbox;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement resetButton;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement actionButton;
	@FindBy(xpath="//a[contains(text(),'Take Action')]")
	private WebElement takeActionButton;
	@FindBy(xpath="//a[contains(text(),'View Quick Details')]")
	private WebElement viewQuickDetailsButton;
	//tr[td[span[text()='TC_003186']]]//span[text()='New Request']
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'Review')]")
	private WebElement reviewButton;
	
	
	public DA_TCRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	public void clickOnViewAllTCRequest()
	{
		viewAllTCRequestButton.click();
	}
	
	public void enterForSearch(String tcID)
	{
		searchTCIDTextbox.clear();
		searchTCIDTextbox.sendKeys(tcID);
	}
	
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
	}
	
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
	}
	
	public void selectstage(String stage)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stageDropDownList, stage);
	}
	
	public void enterForAssignedOn_Date()
	{
		assignedOnTextbox.click();
		assignedOnTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnReset()
	{
		resetButton.click();
	}
	
	public void clickOnAction()
	{
		actionButton.click();
	}
	
	public void clickOnTakeAction()
	{
		takeActionButton.click();
	}
	
	public void clickOnViewQuickDetails()
	{
		viewQuickDetailsButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnReview()
	{
		reviewButton.click();
	}
	

}
