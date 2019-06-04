package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetaVersionOfSmartPage 
{
	WebDriver driver;
	@FindBy(xpath="//button[text()='Close']")
	private WebElement closeButton;
	public BetaVersionOfSmartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToClose()
	{
		closeButton.click();
	}
}