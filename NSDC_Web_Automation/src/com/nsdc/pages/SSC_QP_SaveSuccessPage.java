package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_QP_SaveSuccessPage 
{
	WebDriver driver;
	@FindBy(xpath="//input[@formcontrolname='reviewPeriod']")
	private WebElement reviewPeriodTextBox;
	@FindBy(xpath="//button[contains(text(),'Attach Documents')]")
	private WebElement attachDocumentsButton;
	@FindBy(xpath="//div[@class='card card-color ']")
	private WebElement attachToCurrentQPOnlyButton;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveAndSubmitForApprovalButton;
	@FindBy(xpath="//button[text()='Back to Dashboard']")
	private WebElement backToDashboardButton;
	
	
	public SSC_QP_SaveSuccessPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void enterReviewPeriod(String period)
	{
		reviewPeriodTextBox.clear();
		reviewPeriodTextBox.sendKeys(period);
	}
	
	public void clickOnAttachDocuments()
	{
		attachDocumentsButton.click();
	}
	
	public void clickOnAttachToCurrentQPOnly()
	{
		attachToCurrentQPOnlyButton.click();
	}
	
	public void clickOnSaveAndSubmitForApproval()
	{
		saveAndSubmitForApprovalButton.click();
	}
	
	public void clickOnBackToDashboard()
	{
		backToDashboardButton.click();
	}
}
