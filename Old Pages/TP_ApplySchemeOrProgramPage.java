package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TP_ApplySchemeOrProgramPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//tr[td/span/span[contains(text(),'RPL')]]/td/span/span/div/a[@data-toggle='dropdown']")
	private WebElement rplActionButton;
	@FindBy(xpath="//tr[td/span/span[contains(text(),'RPL')]]/td/span/span/div/div/a[contains(text(),'Add Project')]")
	private WebElement addProjectButton;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	
	
	public TP_ApplySchemeOrProgramPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRplAction()
	{
		rplActionButton.click();
		
	}
	public void clickOnAddProject()
	{
		addProjectButton.click();
	}
	public void clickOnBack()
	{
		backButton.click();
	}

}
