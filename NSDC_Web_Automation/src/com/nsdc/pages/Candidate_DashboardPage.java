package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Candidate_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='view-trainingcentres']")
	private WebElement viewAll_TC_Button;
	@FindBy(xpath="//div[@routerlink='view-preferences']")
	private WebElement viewPrefrencesButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement dashboardButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[2]")
	private WebElement myProfileButton;
	
	
	public Candidate_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickOnViewAllTrainingCentre()
	{
		viewAll_TC_Button.click();
	}
	
	public void clickOnViewPrefrences()
	{
		viewPrefrencesButton.click();
	}
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}
	
	public void clickOnMyProfile()
	{
		myProfileButton.click();
	}

}
