package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IA_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='create-user']")
	private WebElement createANewUserButton;
	@FindBy(xpath="//div[@routerlink='view-all-appeal-requests']")
	private WebElement viewAllAssessmentRequestsButton;

	public IA_DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateANewUser()
	{
		createANewUserButton.click();
	}
	
	public void clickOnViewAllAssessmentRequest()
	{
		viewAllAssessmentRequestsButton.click();
	}
	

}
