package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BetaVersionOfSmartPage 
{
	WebDriver driver;
	@FindBy(css="button.close")
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
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(closeButton));
		closeButton.click();
	}
	
	public void clickOnClose_Second()
	{
		close_SecondButton.click();
	}
}