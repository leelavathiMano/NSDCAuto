package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCampsPage {

	WebDriver driver;
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement  RPl_Action;
	@FindBy(xpath="(//a[contains(text(),'View Details')])[1]")
	private WebElement viewDetailsIcon ;
	@FindBy(xpath="//div[p[text()='View Camps']]")
	private WebElement viewCamps;
	
	public AddCampsPage(WebDriver driver) 
	{
	    this.driver	=driver;
		PageFactory.initElements(driver, this);
	}
	public void ClickOnRPL_action()
	{
		RPl_Action.click();
	}
	public void ClickOnViewDetails()
	{
		viewDetailsIcon.click();
	}
	
}
