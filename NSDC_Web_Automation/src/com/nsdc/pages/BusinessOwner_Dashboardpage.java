package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessOwner_Dashboardpage 
{
    WebDriver driver;
    
    @FindBy(xpath="//div[p[contains(text(),'All Approval requests')]]")
    private WebElement allApprovalRequestsCard;
    @FindBy(xpath="//div[p[contains(text(),'All Schemes')]]")
    private WebElement allSchemesCard;
    @FindBy(xpath="//div[p[contains(text(),'Add a Scheme Owner')]]")
    private WebElement addASchemeOwnerCard;
    @FindBy(xpath="//div[p[contains(text(),'Assign to Scheme Owner')]]")
    private WebElement assignToSchemeOwnerCard;
    @FindBy(xpath="//div[p[contains(text(),'Scheme Retirement Approval Requests')]]")
    private WebElement schemeRetirementApprovalRequestsCard;
    @FindBy(xpath="//span/span")
	private WebElement bOProfileButton;
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	private WebElement bOLogOutButton;
    
    
    public BusinessOwner_Dashboardpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnAllApprovalRequests()
	{
    	allApprovalRequestsCard.click();
	}
	
    public void clickOnAllSchemes()
    {
    	allSchemesCard.click();
    }
    
    public void clickOnAddASchemeOwner()
    {
    	addASchemeOwnerCard.click();
    }
    
    public void clickOnAssignToSchemeOwner()
    {
    	assignToSchemeOwnerCard.click();
    }
    
    public void clickOnSchemeRetirementApprovalRequests()
    {
    	schemeRetirementApprovalRequestsCard.click();
    }
	public void clickOnBOProfile()
	{
		bOProfileButton.click();
	}
	
	public void clickOnBOLogOut()
	{
		bOLogOutButton.click();
	}

}
    
    
    
    
