package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_AssessmentsAndCertification_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@ng-reflect-router-link='assessment-request-dashboard']")
	private WebElement assessmentRequestsButton;
	@FindBy(xpath="//div[@ng-reflect-router-link='certification-request-dashboar']")
	private WebElement certificationsRequestsButton;
	
	
	public SSC_AssessmentsAndCertification_DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAssessmentsButton()
	{
		assessmentRequestsButton.click();
	}
	
	public void clickOnCertificationsRequestsButton()
	{
		certificationsRequestsButton.click();
	}

}
