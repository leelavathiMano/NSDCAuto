package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SP_TC_MyApprovedSchemeOrProgramPage {
	WebDriver driver;

	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[2]")
	private WebElement SP_ActionButton ;
	@FindBy(xpath="(//a[contains(text(),'View Details')])[2]")
	private WebElement ViewDetailsButton ;
	
	
	public SP_TC_MyApprovedSchemeOrProgramPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnSPAction() throws InterruptedException
	{
		Thread.sleep(2000);
		SP_ActionButton.click();
	}
	public void CLickOnViewDetails()
	{
		ViewDetailsButton.click();
	}
}
