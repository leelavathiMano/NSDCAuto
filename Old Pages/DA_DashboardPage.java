package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DA_DashboardPage 
{
	WebDriver driver;
	
	
	@FindBy(xpath="//div[@routerlink='assessment-requests']")
	private WebElement viewAllAssessmentRequest_Button;
	
	public DA_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickOnViewAllAssessmentRequest()
	{
		viewAllAssessmentRequest_Button.click();
	}

}
