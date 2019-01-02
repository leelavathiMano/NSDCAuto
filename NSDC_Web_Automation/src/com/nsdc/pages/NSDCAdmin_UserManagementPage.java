package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSDCAdmin_UserManagementPage 
{

	WebDriver driver;
	
	@FindBy(xpath="//div[p[contains(text(),'Manage Users')]]")
	private WebElement manageUsersCard;
	
	public NSDCAdmin_UserManagementPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnManageUsers()
	{
		manageUsersCard.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
