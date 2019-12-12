package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class FDA_OnboardingRequestPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement dashboardButton;
	@FindBy(xpath="(//select[@name='selectStatus'])[1]")
	private WebElement tpOrPIAIDDropDownList;
	@FindBy(xpath="(//select[@name='selectStatus'])[2]")
	private WebElement tpOrPIANameDropDownList;
	@FindBy(xpath="(//select[@name='selectStatus'])[1]")
	private WebElement typeDropDownList;
	@FindBy(xpath="(//select[@name='selectStatus'])[2]")
	private WebElement statusDropDownList;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement actionButton;
	@FindBy(xpath="(//a[contains(text(),'Take Action')])[1]")
	private WebElement takeActionButton;
	
	
	public FDA_OnboardingRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}
	
	public void selectTPID(String tpID)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tpOrPIAIDDropDownList, tpID);
	}
	
	public void selectTPName(String tpName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tpOrPIANameDropDownList, tpName);
	}
	
	public void selectType(String type)
	{
		SelectDropDownList.selectDropDownListByVisibleText(typeDropDownList, type);
	}
	
	public void selectStatus(String status)
	{
		SelectDropDownList.selectDropDownListByVisibleText(statusDropDownList, status);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnAction()
	{
		actionButton.click();
	}
	
	public void clickOnTakeAction()
	{
		takeActionButton.click();
	}
	

}
