package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSDC_TCCAAFFormReviewPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[1]")
	private WebElement approved_ReviewCommentsCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[2]")
	private WebElement notApproved_ReviewCommentsCheckBox;
	@FindBy(xpath="//textarea[@placeholder='Enter your comments']")
	private WebElement enterReviewCommentTextbox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	
	public NSDC_TCCAAFFormReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickForApprove_ReviewComment()
	{
		approved_ReviewCommentsCheckBox.click();
	}
	
	public void clickForNotApprove_ReviewComment()
	{
		notApproved_ReviewCommentsCheckBox.click();
	}
	
	public void enterReviewComment(String comment)
	{
		enterReviewCommentTextbox.clear();
		enterReviewCommentTextbox.sendKeys(comment);
	}
	
	public void clickForSubmit()
	{
		submitButton.click();
	}
	
	public void clickForCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
