package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SA_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[p[text()='Job Role Scheme Recommendation Requests']]")
	private WebElement jobRoleSchemeRecommendationRequestButton;
	
	
	
	public SA_DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnJobRoleSchemeRecommendationRequest()
	{
		jobRoleSchemeRecommendationRequestButton.click();
	}

}
