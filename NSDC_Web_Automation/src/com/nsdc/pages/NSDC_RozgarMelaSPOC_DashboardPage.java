package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSDC_RozgarMelaSPOC_DashboardPage
{
	WebDriver driver;
	@FindBy(xpath="//p[contains(text(),'Create Rozgar Melas')]")
	private WebElement createRozgarMelasCard;
	@FindBy(xpath="//p[contains(text(),'View Rozgar Melas')]")
	private WebElement viewRozgarMelasCard;
	
	public NSDC_RozgarMelaSPOC_DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickCreateRozgarMelas()
	{
		createRozgarMelasCard.click();
	}
	public void clickViewRozgarMelas()
	{
		viewRozgarMelasCard.click();
	}
}
