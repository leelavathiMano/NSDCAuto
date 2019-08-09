package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//li[@data-dropdown-toggle='click']")
	private WebElement profileLogoButton;
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	private WebElement logoutButton;
	
	public LogOutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnProfileLogo()
	{
		profileLogoButton.click();
	}
	
	public void clickOnLogout()
	{
		logoutButton.click();
	}
}
