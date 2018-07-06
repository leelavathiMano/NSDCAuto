package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartAdmin_TCCAAFFormReviewPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[1]")
	private WebElement reviewComments_ApprovedCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[2]")
	private WebElement reviewComments_NotApprovedCheckBox;
	@FindBy(xpath="//textarea[@placeholder='Enter your comments']")
	private WebElement enterYourCommentTextbox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	
	public SmartAdmin_TCCAAFFormReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickForApprove_ReviewComments()
	{
		reviewComments_ApprovedCheckBox.click();
	}
	
	public void clickForNotApprove_ReviewComments()
	{
		reviewComments_NotApprovedCheckBox.click();
	}
	
	public void enterReviewComments(String comments)
	{
		enterYourCommentTextbox.clear();
		enterYourCommentTextbox.sendKeys(comments);
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
