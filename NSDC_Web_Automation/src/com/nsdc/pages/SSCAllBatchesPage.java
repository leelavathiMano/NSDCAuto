package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSCAllBatchesPage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextBox;
	@FindBy(xpath="//i[@class='la la-ellipsis-h']")
	private WebElement actionButton;
	
	
	public SSCAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterSearchByWord(String search_By_Keyword)
	{
		searchByKeywordTextBox.sendKeys(search_By_Keyword);
	}
	public void clickActionButton()
	{
		actionButton.click();
	}
	
}