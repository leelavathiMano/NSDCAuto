package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeAdmin_DashboardPage 
{
    WebDriver driver;
    
    @FindBy(xpath="//div[p[contains(text(),'Update-scheme')]]")
    private WebElement updateSchemeCard;
    @FindBy(xpath="//div[p[contains(text(),'View All Schemes')]]")
    private WebElement viewAllSchemesCard;
    @FindBy(xpath="//div[p[contains(text(),'Scheme Retirement')]]")
    private WebElement schemeRetirementCard;
    @FindBy(xpath="//div[p[contains(text(),'Instantialte Job Roles')]]")
    private WebElement instantialteJobRolesCard;
    @FindBy(xpath="//span/span")
	private WebElement saProfileButton;
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	private WebElement saLogOutButton;
    
    
    public SchemeAdmin_DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnUpdateScheme()
	{
    	updateSchemeCard.click();
	}
	
    public void clickOnViewAllSchemes()
    {
    	viewAllSchemesCard.click();
    }
    
    public void clickOnSchemeRetirement()
    {
    	schemeRetirementCard.click();
    }
    
    public void clickOnInstantialteJobRoles()
    {
    	instantialteJobRolesCard.click();
    }
    
	public void clickOnSaProfile()
	{
		saProfileButton.click();
	}
	
	public void clickOnSaLogOut()
	{
		saLogOutButton.click();
	}

}
    
    
    
    
