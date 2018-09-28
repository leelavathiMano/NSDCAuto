package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartAdmin_TPFormReviewPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[1]")
	private WebElement reviewComment_ApprovedCheckBox;
	@FindBy(xpath="(//label[@class='m-checkbox']/span)[2]")
	private WebElement reviewComment_NotApprovedCheckBox;
	@FindBy(xpath="//textarea[@placeholder='Enter your comments']")
	private WebElement enterYourCommentTextbox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelForSubmitButton;
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[1]")
	private WebElement removeFirst_TPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[2]")
	private WebElement removeSecond_TPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[3]")
	private WebElement removeThird_TPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[4]")
	private WebElement removeFourth_TPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[5]")
	private WebElement removeFifth_TPTypeButton;
	
	
	public SmartAdmin_TPFormReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnApproved_ReviewComments()
	{
		reviewComment_ApprovedCheckBox.click();
	}
	
	public void clickOnNotApproved_ReviewComments()
	{
		reviewComment_NotApprovedCheckBox.click();
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
	
	public void clickOnCancelForSubmit()
	{
		cancelForSubmitButton.click();
	}
	
	public void clickOnYes()
	{
		yesButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}
	
	public void clickOnRemoveFirst_TPType()
	{
		removeFirst_TPTypeButton.click();
	}
	
	public void clickOnRemoveSecond_TPType()
	{
		removeSecond_TPTypeButton.click();
	}
	
	public void clickOnRemoveThird_TPType()
	{
		removeThird_TPTypeButton.click();
	}
	
	public void clickOnRemoveFourth_TPType()
	{
		removeFourth_TPTypeButton.click();
	}
	
	public void clickOnRemoveFifth_TPType()
	{
		removeFifth_TPTypeButton.click();
	}

}
