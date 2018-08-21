package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FDA_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//p[text()='View All Onboarding Requests']")
	private WebElement viewAllRequestButton;
	@FindBy(css=".m-nav__link-icon.la.la-home")
	private WebElement homeIconButton;
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement DashboardButton;
	
	public FDA_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickOnViewAllOnboardingRequest()
	{
		viewAllRequestButton.click();
	}
	
	public void clickOnHomeIcon()
	{
		homeIconButton.click();
	}
	
	public void clickOnDashboard()
	{
		DashboardButton.click();
	}

}
