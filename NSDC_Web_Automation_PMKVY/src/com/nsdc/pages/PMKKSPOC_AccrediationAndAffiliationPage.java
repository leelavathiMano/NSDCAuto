package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMKKSPOC_AccrediationAndAffiliationPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextbox;
	@FindBy(xpath="//label[input[@value='approved']]/span")
	private WebElement approvedRadioButton;
	@FindBy(xpath="//label[input[@value='rejected']]/span")
	private WebElement notApprovedRadioButton;
	@FindBy(xpath="//textarea[@formcontrolname='remark']")
	private WebElement reviewCommentTextbox;
	@FindBy(xpath="//button[@class='btn btn-next']")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	public PMKKSPOC_AccrediationAndAffiliationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterSearchForKeyword(String keyword)
	{
		searchByKeywordTextbox.clear();
		searchByKeywordTextbox.sendKeys(keyword);
	}
	
	public void clickOnApproved()
	{
		approvedRadioButton.click();
	}
	
	public void clickOnNotApproved()
	{
		notApprovedRadioButton.click();
	}
	
	public void enterReviewComments(String reviewComment)
	{
		reviewCommentTextbox.clear();
		reviewCommentTextbox.sendKeys(reviewComment);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}

}
