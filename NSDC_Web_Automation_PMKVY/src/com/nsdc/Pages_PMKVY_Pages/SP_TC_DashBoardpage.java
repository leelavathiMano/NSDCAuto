package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SP_TC_DashBoardpage 
{
WebDriver driver;

	@FindBy(xpath="(//span[@class='m-menu__link-text'])[3]")
	private WebElement MySchemeIcon;
	
	@FindBy(xpath="//div[p[text()='View Schemes']]")
	private WebElement ViewSchemeIcon;
	
	public SP_TC_DashBoardpage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMyScheme()
	{
		MySchemeIcon.click();
	}
	public void ClickOnViewScheme()
	{
		ViewSchemeIcon.click();
	}
	

}


