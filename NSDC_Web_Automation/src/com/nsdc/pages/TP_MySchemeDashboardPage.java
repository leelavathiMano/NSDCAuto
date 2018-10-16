package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TP_MySchemeDashboardPage 
{
	
	WebDriver driver;
	
	@FindBy(css=".m-nav__link-icon.la.la-home")
	private WebElement homeIconButton;
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement dashboardButton;
	@FindBy(xpath="(//span[@class='m-nav__link-text'])[2]")
	private WebElement mySchemeButton;
	@FindBy(css=".btn.m-btn--pill.btn-primary.tab-color-blue")
	private WebElement addSchemeButton;
	@FindBy(xpath="//a[contains(text(),'Approved')]")
	private WebElement approvedSchemeButton;
	@FindBy(xpath="//a[contains(text(),'Approval in Progress')]")
	private WebElement approvalInProgressButton;
	@FindBy(xpath="//a[contains(text(),'Rejected')]")
	private WebElement rejectedSchemeButton;
	@FindBy(xpath="(//a[contains(text(),'View Scheme Details')])[1]")
	private WebElement viewDetailsButton;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement actionButton;
	
	public TP_MySchemeDashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnHomeIcon()
	{
		homeIconButton.click();
	}
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}
	
	public void clickOnMyScheme()
	{
		mySchemeButton.click();
	}
	
	public void clickOnAddSchemeOrProgram()
	{
		addSchemeButton.click();
	}
	
	public void clickOnApprovedScheme()
	{
		approvedSchemeButton.click();
	}
	
	public void clickOnApprovalInProgress()
	{
		approvalInProgressButton.click();
	}
	
	public void clickOnRejectedScheme()
	{
		rejectedSchemeButton.click();
	}
	
	public void clickOnViewDetails()
	{
		viewDetailsButton.click();
	}
	
	public void clickOnAction()
	{
		actionButton.click();
	}

}
