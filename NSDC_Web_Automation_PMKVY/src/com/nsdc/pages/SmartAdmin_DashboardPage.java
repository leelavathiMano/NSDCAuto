package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartAdmin_DashboardPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='createuser']")
	private WebElement createUserButton;
	@FindBy(xpath="//div[@routerlink='view-all-sdms-users']")
	private WebElement allSDMSUsersButton;
	@FindBy(xpath="//div[@routerlink='tcregistrationrules']")
	private WebElement reviewTCRegistrationSetUpButton;
	@FindBy(xpath="//div[@routerlink='tpregistrationrules']")
	private WebElement reviewTPRegistrationSetUpButton;
	@FindBy(xpath="//div[@routerlink='financial-data']")
	private WebElement financialDataButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	@FindBy(xpath="//span[contains(text(),'SmartAdmin2')]")
	private WebElement smartAdminButton;
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	private WebElement logoutButton;
	
	
	public SmartAdmin_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnCreateUser()
	{
		createUserButton.click();
	}
	
	public void clickOnAllSDMSUser()
	{
		allSDMSUsersButton.click();
	}
	
	public void clickForReviewTCRegistrationSetUp()
	{
		reviewTCRegistrationSetUpButton.click();
	}
	
	public void clickReviewTPRegistrationSetUp()
	{
		reviewTPRegistrationSetUpButton.click();
	}
	
	public void clickForAddNSDC_FinancialData()
	{
		financialDataButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}
	
	public void clickOnSmartAdminProfile()
	{
		smartAdminButton.click();
	}
	
	public void clickOnSmartAdminLogOut()
	{
		logoutButton.click();
	}

}
