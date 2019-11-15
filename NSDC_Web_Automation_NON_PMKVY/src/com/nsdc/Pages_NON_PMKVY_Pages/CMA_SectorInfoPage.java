package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class CMA_SectorInfoPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Download Sector Approval Documents:']")
	private WebElement downlodSectorApprovalDocumentButton;
	@FindBy(xpath="//button[text()='Download Upload Affiliation Certificates from SSC:']")
	private WebElement downloadAffiliationCertificateFromSSCButton;
	@FindBy(xpath="//select[@id='review']")
	private WebElement reviewCommentsDropDownList;
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement reviewCommentsTextbox;
	@FindBy(xpath="//button[text()='Submit Response']")
	private WebElement submitResponseButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	
	
	public CMA_SectorInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDownloadSectorApprovalButton()throws Exception
	{
		downlodSectorApprovalDocumentButton.click();
		Thread.sleep(2000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadAffiliationCertificateFromSSC()throws Exception
	{
		downloadAffiliationCertificateFromSSCButton.click();
		Thread.sleep(2000);
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewCommentsDropDownList, reviewComments);
	}
	
	public void enterReviewComents_ForSector(String comments)
	{
		reviewCommentsTextbox.clear();
		reviewCommentsTextbox.sendKeys(comments);
	}
	
	public void clickOnSubmitResponse()
	{
		submitResponseButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}

}
