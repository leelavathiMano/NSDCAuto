package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class HoldingAgency_TCViewDetailsPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//select[@formcontrolname='review']")
	private WebElement reviewCommentDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='comment']")
	private WebElement commentTextBox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	
	public HoldingAgency_TCViewDetailsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void selectReviewComment(String review)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewCommentDropDownList, review);
	}
	
	public void enterComment(String comment)
	{
		commentTextBox.clear();
		commentTextBox.sendKeys(comment);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}

}
