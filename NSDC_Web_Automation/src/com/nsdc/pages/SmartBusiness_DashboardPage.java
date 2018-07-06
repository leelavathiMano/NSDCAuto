package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBusiness_DashboardPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='tcregistrationrules']")
	private WebElement tcRegistrationButton;
	@FindBy(xpath="//div[@routerlink='tpregistrationrules']")
	private WebElement tpRegistrationButton;
	@FindBy(xpath="//span[contains(text(),'SmartBusiness_1')]")
	private WebElement smart_Business_1Button;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logOutButton;
	
	public SmartBusiness_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnTCRegistrationSetup()
	{
		tcRegistrationButton.click();
	}
	
	public void clickOnTPRegistrationSetup()
	{
		tpRegistrationButton.click();
	}
	
	public void clickOnSmartBusiness1Profile()
	{
		smart_Business_1Button.click();
	}
	
	public void clickOnSmartBusinessLogOut()
	{
		logOutButton.click();
	}

}
