package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class FDA_SelectedSchemePage 
{
	WebDriver driver;
	
	
	@FindBy(xpath="//select[@id='projectDetailReview']")
	private WebElement ProjectDetailReviewDropdownlist;
	@FindBy(xpath="//textarea[@id='projectDetailComment']")
	private WebElement ProjectDetailCommentTextBOx;
	@FindBy(xpath=" //select[@id='loanDetailsReview']")
	private WebElement loanDetailsReviewDropdownlist;
	@FindBy(xpath="//textarea[@id='loanDetailsComment']")
	private WebElement loanDetailsCommentDropdownlist;
	
	
	
	
	
	@FindBy(xpath="//button[text()='Download Signed Termsheets']")
	private WebElement downloadSignedTermsheetButton;
	@FindBy(xpath="//button[text()='Download Signed Agreement']")
	private WebElement downloadSignedProposalButton;
	@FindBy(xpath="//button[text()='Download Other Supporting Document']")
	private WebElement downloadSupportingDocumentButton;
	//////////
	@FindBy(xpath="//select[@id='supportingDocumentsReview']")
	private WebElement supportingDocumentsReviewDropdownlist;
	@FindBy(xpath="//textarea[@id='supportingDocumentsComment']")
	private WebElement supportingDocumentsCommentTextrea;
	
	
	@FindBy(xpath="(//button[contains(text(),'View Attached Documents')])[1]")
	private WebElement viewAttachedDocument_SectorsButton;
	@FindBy(xpath="(//button[contains(text(),'View Attached Documents')])[2]")
	private WebElement viewAttachedDocument_CoursesButton;
	@FindBy(xpath="(//button[contains(text(),'View Attached Documents')])[3]")
	private WebElement viewAttachedDocument_SecondSectorButton;
	@FindBy(xpath="(//button[contains(text(),'View Attached Documents')])[4]")
	private WebElement viewAttachedDocument_SecondCourseButton;
	////////////////////////
	
	
	
	
	@FindBy(xpath="//select[option[contains(text(),'Select Comments')]]")
	private WebElement reviewCommentsDropDownList;
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement reviewCommentsTextbox;
	@FindBy(xpath="(//button[text()='Submit Response'])")
	private WebElement submitResponse_FirstButton;
	@FindBy(xpath="(//button[text()='Cancel'])[1]")
	private WebElement cancelButton;
	@FindBy(xpath="(//button[text()='Submit Response'])[2]")
	private WebElement submitResponse_SecondButton;
	@FindBy(xpath="//button[text()='Review & Edit']")
	private WebElement reviewAndEditButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement oKButton;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateLocationOfTCDropDownList;
	@FindBy(xpath="//select[@formcontrolname='districts']")
	private WebElement districtLocationOfTCDropDownList;
	
	public FDA_SelectedSchemePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	////////////////////
	public void SelectProjectDetailReviewDropdownlist(String ProjectReview)
	{
		SelectDropDownList.selectDropDownListByVisibleText(ProjectDetailReviewDropdownlist, ProjectReview);
	}
	
	public void EnterProjectDetailComment(String ProjectComments)
	{
		ProjectDetailCommentTextBOx.clear();
		ProjectDetailCommentTextBOx.sendKeys(ProjectComments);
	}
	public void SelectloanDetailsReview(String loanReview)
	{
		SelectDropDownList.selectDropDownListByVisibleText(loanDetailsReviewDropdownlist, loanReview);
	}
	
	public void EnterloanDetailsCommentDropdownlist(String loanDetails)
	{
		loanDetailsCommentDropdownlist.clear();
		loanDetailsCommentDropdownlist.sendKeys(loanDetails);
	}
	public void clickOnDownloadSignedTermsheet() throws Exception
	{
		downloadSignedTermsheetButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadSignedProposal()throws Exception
	{
		downloadSignedProposalButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadSupportingDocument()throws Exception
	{
		downloadSupportingDocumentButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	public void SelectSupportDocumentReview(String supportdocumentReview)
	{
		SelectDropDownList.selectDropDownListByVisibleText(supportingDocumentsReviewDropdownlist, supportdocumentReview);
	}
	
	public void EnterSupportDocumentReview(String documentReview)
	{
		supportingDocumentsCommentTextrea.clear();
		supportingDocumentsCommentTextrea.sendKeys(documentReview);
	}
	
	
	
	public void clickOnSectors_ViewAttachedDocument()throws Exception
	{
		viewAttachedDocument_SectorsButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnCourses_ViewAttachedDocument()throws Exception
	{
		viewAttachedDocument_CoursesButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnSecondSector_ViewAttachedDocument()throws Exception
	{
		viewAttachedDocument_SecondSectorButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnSecondCourses_ViewAttachedDocument()throws Exception
	{
		viewAttachedDocument_SecondCourseButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	//////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	public void selectStateLoacationForTC(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateLocationOfTCDropDownList, state);
	}
	
	public void selectDistrictLocationForTC(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtLocationOfTCDropDownList, district);
	}

}
