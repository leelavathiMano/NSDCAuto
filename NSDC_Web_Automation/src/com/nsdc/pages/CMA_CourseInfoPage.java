package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class CMA_CourseInfoPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Download Course Approval Documents:']")
	private WebElement downloadCourseApprovalDocumentButton;
	@FindBy(xpath="//button[text()='Download Upload Affiliation Certificates from SSC:']")
	private WebElement downloadAffiliationCertificateFromSSCButton;
	@FindBy(xpath="//button[text()='Download Upload Work Order:']")
	private WebElement downloadWorkOrderButton;
	@FindBy(xpath="//button[text()='Download Upload Challan of the Fee Paid:']")
	private WebElement downloadChallanOfFeePaidButton;
	@FindBy(xpath="//button[text()='Download Upload Stamp paper with Self Declaration:']")
	private WebElement downloadStampPaperButton;
	@FindBy(xpath="//select[@id='qpNosAlignedCentre']")
	private WebElement qpNosAllignedCentreDropDownList;
	@FindBy(xpath="//select[@id='review']")
	private WebElement reviewCommentsDropDownList;
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement reviewCommentsTextbox;
	@FindBy(xpath="//button[text()='Submit Response']")
	private WebElement submitResponseButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	
	public CMA_CourseInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnDownloadCourseApprovalDocument()throws Exception
	{
		downloadCourseApprovalDocumentButton.click();
		Thread.sleep(2000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadAffiliationCertificateFromSSC()throws Exception
	{
		downloadAffiliationCertificateFromSSCButton.click();
		Thread.sleep(2000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadWorkOrder()throws Exception
	{
		downloadWorkOrderButton.click();
		Thread.sleep(2000);
		FilePreview.closeWindow(driver);
	}
	
	public void clciOnDownloadChallanOfFeePaid()throws Exception
	{
		downloadChallanOfFeePaidButton.click();
		Thread.sleep(2000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadStampPaperWithSelfDeclaration()throws Exception
	{
		downloadStampPaperButton.click();
		Thread.sleep(2000);
		FilePreview.closeWindow(driver);
	}
	
	public void selectQPNosAlignedCentre(String qpNosCentre)
	{
		SelectDropDownList.selectDropDownListByVisibleText(qpNosAllignedCentreDropDownList, qpNosCentre);
	}
	
	public void selectReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewCommentsDropDownList, reviewComments);
	}
	
	public void enterComments(String comments)
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
