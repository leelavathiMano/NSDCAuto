package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HA_GovtTCRequestPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextbox;
	@FindBy(xpath="//button[text()='Back']")
	private WebElement backButton;
	@FindBy(xpath="//label[input[@value='Approved']]/span")
	private WebElement approvedRadioButton;
	@FindBy(xpath="//label[input[@value='Rejected']]/span")
	private WebElement notApprovedRadioButton;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement uploadRecommendationLetter_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement uploadRecommendationLetter_UploadFileButton;
	@FindBy(xpath="//textarea[@formcontrolname='remark']")
	private WebElement reviewCommentTextbox;
	@FindBy(xpath="//button[@class='btn btn-next']")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	//tr[td[span[text()='TC_003148']]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']
	//tr[td[span[text()='TC_003148']]]//a[contains(text(),'Approve/Reject')]
	//tr[td[span[text()='TC_003148']]]//a[contains(text(),'View Submitted CAAF')]
	//tr[td[span[text()='TC_003148']]]//span[text()='Appproved']
	
	
	
	public HA_GovtTCRequestPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterForSearchByKeyword(String searchKeyword)
	{
		searchByKeywordTextbox.clear();
		searchByKeywordTextbox.sendKeys(searchKeyword);
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnApprovedRadioButton()
	{
		approvedRadioButton.click();
	}
	
	public void clickOnNotApproved()
	{
		notApprovedRadioButton.click();
	}
	
	public void clickOnUploadRecommendationLetter_BrowseFile()
	{
		uploadRecommendationLetter_BrowseFileButton.click();
	}
	
	public void clickOnUploadRecommendationLetter_UploadButton()
	{
		uploadRecommendationLetter_UploadFileButton.click();
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
