package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DA_TC_ContiniousMoniteringPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Continuous Monitoring']")
	private WebElement continiousMonitoringButton;
	
	
	
	public DA_TC_ContiniousMoniteringPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnConitiniousMonitering()
	{
		continiousMonitoringButton.click();
	}

}
