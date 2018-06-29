package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopAssessor_ViewInspectionPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextbox;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement action_Button;
	@FindBy(xpath="(//a[contains(text(),'View Quick Details')])[1]")
	private WebElement viewQuickDetails_Button;
	@FindBy(xpath="(//a[contains(text(),'Take Action')])[1]")
	private WebElement takeAction_Button;
	
	
	public DesktopAssessor_ViewInspectionPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void enterKeywordForSearch(String searchForKeyword)
	{
		searchByKeywordTextbox.clear();
		searchByKeywordTextbox.sendKeys(searchForKeyword);
	}
	
	public void clickOnAction()
	{
		action_Button.click();
	}
	
	public void clickOnViewQuickDetails()
	{
		viewQuickDetails_Button.click();
	}
	
	public void clickOnTakeAction()
	{
		takeAction_Button.click();
	}

}
