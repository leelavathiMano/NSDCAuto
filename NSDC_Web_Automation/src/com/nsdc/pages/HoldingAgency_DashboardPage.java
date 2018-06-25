package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoldingAgency_DashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='adding-tc-requests']")
	private WebElement addingTCRequestsButton;
	
	public HoldingAgency_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnAddingTCRequest()
	{
		addingTCRequestsButton.click();
	}
}
