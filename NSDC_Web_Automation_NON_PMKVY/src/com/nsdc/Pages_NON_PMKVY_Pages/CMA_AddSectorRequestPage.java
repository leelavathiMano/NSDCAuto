package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class CMA_AddSectorRequestPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//select[@name='selectStatus']")
	private WebElement statusDropDownList;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="//input[@placeholder='TP ID']")
	private WebElement tpIDSearchTextbox;
	
	
	public CMA_AddSectorRequestPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectStatus(String status)
	{
		SelectDropDownList.selectDropDownListByVisibleText(statusDropDownList, status);
	}
	
	public void clickOnApply()throws Exception
	{
		Thread.sleep(3000);
		applyButton.click();
	}
	
	public void enterTPID(String tpID)throws Exception
	{
		tpIDSearchTextbox.clear();
		tpIDSearchTextbox.sendKeys(tpID);
		Thread.sleep(5000);
		tpIDSearchTextbox.sendKeys(Keys.ENTER);
	}

}
