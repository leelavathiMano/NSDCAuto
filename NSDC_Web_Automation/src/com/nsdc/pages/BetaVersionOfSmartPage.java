package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetaVersionOfSmartPage 
{
	WebDriver driver;
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement closeButton;
	@FindBy(xpath="(//button[text()='Close'])[2]")
	private WebElement close_SecondButton;
	
	
	public BetaVersionOfSmartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	
	public void clickOnClose_Second()
	{
		close_SecondButton.click();
	}
}