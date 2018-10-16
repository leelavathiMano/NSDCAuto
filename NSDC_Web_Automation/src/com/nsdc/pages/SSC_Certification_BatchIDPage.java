package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_Certification_BatchIDPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Batch Details']")
	private WebElement batchDetailsButton;
	@FindBy(xpath="//button[text()='Enrolled Candidates']")
	private WebElement enrolledCandidatesButton;
	@FindBy(xpath="//input[@placeholder='All']")
	private WebElement searchKeywordTextbox;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement actionButton;
	@FindBy(linkText="//a[contains(text(),'View All QPs')]")
	private WebElement viewAllQPsButton;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement action_generateCertificateButton;
	@FindBy(xpath="//a[contains(text(),'Generate Certificate')]")
	private WebElement generateCertificateButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	
	
	public SSC_Certification_BatchIDPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnbatchDetailsButton()
	{
		batchDetailsButton.click();
	}
	
	public void clickOnEnrolledCandidates()
	{
		enrolledCandidatesButton.click();
	}
	
	public void enterOnSearchKeyword(String keyword)
	{
		searchKeywordTextbox.clear();
		searchKeywordTextbox.sendKeys(keyword);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickForGenerateCertificate()throws Exception
	{
		for(int i=0; i<4; i++)
		{
			actionButton.click();
			Thread.sleep(3000);
			viewAllQPsButton.click();
			Thread.sleep(3000);
			action_generateCertificateButton.click();
			Thread.sleep(3000);
			generateCertificateButton.click();
			Thread.sleep(3000);
			okButton.click();
			Thread.sleep(3000);
			goBackButton.click();
			Thread.sleep(3000);
			enrolledCandidatesButton.click();
			
		}
	}

}
