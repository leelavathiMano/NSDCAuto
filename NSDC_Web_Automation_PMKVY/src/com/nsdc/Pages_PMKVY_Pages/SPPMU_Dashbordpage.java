package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SPPMU_Dashbordpage 
{
	WebDriver driver;
	@FindBy(xpath = "//div[p[text()='View All TC Add Requests']]")
	private WebElement ViewAllTC_AddRequest;

public SPPMU_Dashbordpage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public void ClickOnViewAllTC_addRequest()
{
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", ViewAllTC_AddRequest);

}



}
