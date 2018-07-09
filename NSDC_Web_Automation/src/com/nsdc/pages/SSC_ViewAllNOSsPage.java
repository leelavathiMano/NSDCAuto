package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_ViewAllNOSsPage 
{
	WebDriver driver;
	
	@FindBy(css=".form-control.m-input.m-input--solid.ng-untouched.ng-pristine.ng-valid")
	private WebElement NOS_searchBox;
	@FindBy(css=".btn.btn-info.btn-basic")
	private WebElement searchButton;
	@FindBy(css=".btn.m-btn.m-btn--hover-accent.m-btn--icon.m-btn--icon-only.m-btn--pill")
	private WebElement actionButton;
	@FindBy(css=".dropdown-item")
	private WebElement updateAndResubmitNOS_button;
	@FindBy(xpath="(//a[@ng-reflect-router-link='../edit-nos,[object Object]'])[1]")
	private WebElement editNOS_Button;
	@FindBy(xpath="(//div[@class='dropdown-menu dropdown-menu-right show']/a[@href='javascript:;'])[1]")
	private WebElement deleteNOS_Button;
	
	public SSC_ViewAllNOSsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterNOS_codeInSearchBox(String NOS_code)
	{
		NOS_searchBox.clear();
		NOS_searchBox.sendKeys(NOS_code);
	}
	
	public void clickOnSearch()
	{
		searchButton.click();
	}
	
	public void clickOnAction()
	{
		actionButton.click();
	}
	
	public void clickOnupdateAndResubmitNOS()
	{
		updateAndResubmitNOS_button.click();
	}
	
	public void clickOnEditNOS()
	{
		editNOS_Button.click();
	}
	
	public void clickOnDeleteNOS()
	{
		deleteNOS_Button.click();
	}

}
