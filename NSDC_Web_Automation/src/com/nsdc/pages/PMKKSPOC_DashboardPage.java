package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMKKSPOC_DashboardPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[p[text()='Adding TC Requests']]")
	private WebElement viewTCrequestButton;
	@FindBy(xpath="//div[p[text()='View All Assessment Requests']]")
	private WebElement viewAllAssessmentRequest;
	
	
	
	public PMKKSPOC_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnaddingTCRequest()
	{
		viewTCrequestButton.click();
	}
	
	public void clickOnViewAllAssessmentRequest()
	{
		viewAllAssessmentRequest.click();
	}

}
