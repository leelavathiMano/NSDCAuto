package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HA_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='adding-govt-tc-requests']")
	private WebElement govtTCRequestButton;
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement dashboardButton;
	
	
	public HA_DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnGovtTCRequest()
	{
		govtTCRequestButton.click();
	}
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}

}
