package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(createRozgarMelasCard));
		wait.until(ExpectedConditions.elementToBeClickable(createRozgarMelasCard));
		createRozgarMelasCard.click();
	}
	public void clickViewRozgarMelas()
	{
		viewRozgarMelasCard.click();
	}
}