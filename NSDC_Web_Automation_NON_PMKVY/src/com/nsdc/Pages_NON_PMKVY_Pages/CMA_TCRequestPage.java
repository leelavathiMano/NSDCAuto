package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class CMA_TCRequestPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//select[option[text()='Select a TP/PIA ID']]")
	private WebElement tpIDDropDownList;
	@FindBy(xpath="//select[option[text()='Select a TP/PIA Name']]")
	private WebElement tpNameDropDownList;
	@FindBy(xpath="//select[option[text()='Select a Type']]")
	private WebElement typeDropDownList;
	@FindBy(xpath="//select[option[text()='Select a Status']]")
	private WebElement statusDropDownList;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applyButton;
	
	
	public CMA_TCRequestPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectTPID(String tpID)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tpIDDropDownList, tpID);
	}
	
	public void selectTPName(String tpName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tpNameDropDownList, tpName);
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

}
