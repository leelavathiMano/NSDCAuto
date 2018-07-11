package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSDC_TPFormReviewPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[1]")
	private WebElement approved_ReviewCommentCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[2]")
	private WebElement notApproved_ReviewCommentCheckBox;
	@FindBy(xpath="//textarea[@placeholder='Enter your comments']")
	private WebElement reviewCommentsTextbox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	
	
	public NSDC_TPFormReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickForApproved_ReviewComment()
	{
		approved_ReviewCommentCheckBox.click();
	}
	
	public void clickForNotApproved_ReviewComment()
	{
		notApproved_ReviewCommentCheckBox.click();
	}
	
	public void enterReviewComment(String comment)
	{
		reviewCommentsTextbox.clear();
		reviewCommentsTextbox.sendKeys(comment);
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
