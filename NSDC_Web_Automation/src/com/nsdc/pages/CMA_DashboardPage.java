package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMA_DashboardPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@ng-reflect-router-link='view-all-tc-requests']")
	private WebElement viewAllTCRequestButton;
	@FindBy(xpath="//div[@ng-reflect-router-link='view-all-add-sector-requests']")
	private WebElement viewAllSectorButton;
	@FindBy(xpath="//div[@ng-reflect-router-link='view-all-add-course-requests']")
	private WebElement viewAllCourseAddRequestButton;
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement dashboardButton;
	
	
	public CMA_DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnViewAllTCAddRequest()
	{
		viewAllTCRequestButton.click();
	}
	
	public void clickOnViewAllSector()
	{
		viewAllSectorButton.click();
	}
	
	public void clickOnViewAllCourseAddRequest()
	{
		viewAllCourseAddRequestButton.click();
	}
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}

}
