package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMKVY_STTPMUpage {
	WebDriver driver;
	@FindBy(xpath="//div[div[p[text()='View All Scheme Add Requests']]]")
	private WebElement ViewAllSchemeAddRequestsIcon;
	//
	public  PMKVY_STTPMUpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//
	public void ClickOnViewAllSchemeAddRequests() throws InterruptedException
	{
		Thread.sleep(2000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ViewAllSchemeAddRequestsIcon);
	}
}
