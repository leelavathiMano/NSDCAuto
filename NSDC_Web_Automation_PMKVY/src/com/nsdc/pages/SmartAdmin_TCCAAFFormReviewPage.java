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
	private WebElement cancelForSubmitButton;
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[1]")
	private WebElement regular_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[2]")
	private WebElement gov_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[3]")
	private WebElement first_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[4]")
	private WebElement second_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[5]")
	private WebElement third_TC_RemoveButton;
	
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
	
	public void clickOnRegular_TCType_Remove()
	{
		regular_TC_RemoveButton.click();
	}
	
	public void clickOnGovernment_TCType_Remove()
	{
		gov_TC_RemoveButton.click();
	}
	
	public void clickOnFirst_TCType_Remove()
	{
		first_TC_RemoveButton.click();
	}
	
	public void clickOnSecond_TCType_Remove()
	{
		second_TC_RemoveButton.click();
	}
	
	public void clickOnThird_TCType_Remove()
	{
		third_TC_RemoveButton.click();
	}

}
