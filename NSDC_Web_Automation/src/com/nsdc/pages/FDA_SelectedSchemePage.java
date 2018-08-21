package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class FDA_SelectedSchemePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Download Signed Termsheet:']")
	private WebElement downloadSignedTermsheetButton;
	@FindBy(xpath="//button[text()='Download Signed Proposal:']")
	private WebElement downloadSignedProposalButton;
	@FindBy(xpath="//button[text()='Download Other Supporting Document:']")
	private WebElement downloadSupportingDocumentButton;
	@FindBy(xpath="//select[option[contains(text(),'Select Review Comments')]]")
	private WebElement reviewCommentsDropDownList;
	@FindBy(xpath="//textarea[@placeholder='Enter review comments here']")
	private WebElement reviewCommentsTextbox;
	@FindBy(xpath="(//button[text()='Submit Response'])[1]")
	private WebElement submitResponse_FirstButton;
	@FindBy(xpath="(//button[text()='Cancel'])[1]")
	private WebElement cancelButton;
	@FindBy(xpath="(//button[text()='Submit Response'])[2]")
	private WebElement submitResponse_SecondButton;
	@FindBy(xpath="//button[text()='Review & Edit']")
	private WebElement reviewAndEditButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement oKButton;
	
	public FDA_SelectedSchemePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	public void clickOnDownloadSignedTermsheet()
	{
		downloadSignedTermsheetButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadSignedProposal()
	{
		downloadSignedProposalButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadSupportingDocument()
	{
		downloadSupportingDocumentButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewComments(String comments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewCommentsDropDownList, comments);
	}
	
	public void enterReviewComments(String reviewComments)
	{
		reviewCommentsTextbox.clear();
		reviewCommentsTextbox.sendKeys(reviewComments);
	}
	
	public void clickOnFirst_SubmitResponse()
	{
		submitResponse_FirstButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnSecond_SubmitResponse()
	{
		submitResponse_SecondButton.click();
	}
	
	public void clickOnReviewAndEdit()
	{
		reviewAndEditButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
