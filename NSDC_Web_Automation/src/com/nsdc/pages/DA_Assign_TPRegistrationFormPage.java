package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;


public class DA_Assign_TPRegistrationFormPage
{
	
	
	WebDriver driver;
	
	@FindBy(xpath="(//button[contains(text(),'Preview Attached Proof Document')])[1]")
	private WebElement attachedProofDocument_NameOfOrganization_PreviewButton;
	@FindBy(xpath="//select[@formcontrolname='nameOfOrganisationReview']")
	private WebElement reviewComments_NameOfOrganizationDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='nameOfOrganisationComment']")
	private WebElement additionalComment_NameOfOrganizationTextbox;
	@FindBy(xpath="//select[@formcontrolname='typeOfOrganisationReview']")
	private WebElement reviewComments_TypeOfOrganizationDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='typeOfOrganisationComment']")
	private WebElement additionalComment_TypeOfOrganizationTextbox;
	@FindBy(xpath="(//button[contains(text(),'Preview Attached Proof Document')])[2]")
	private WebElement attachedProofDocument_Address_PreviewButton;
	@FindBy(xpath="//select[@formcontrolname='addressReview']")
	private WebElement reviewComment_AddressDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='addressOfOrganisationComment']")
	private WebElement additionalComment_AddressTextbox;
	@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
	private WebElement saveAndContinueButton;
	@FindBy(xpath="//button[contains(text(),'Save as Draft')]")
	private WebElement saveAsDraftButton;
	
	@FindBy(xpath="//select[@formcontrolname='aadharNumReview']")
	private WebElement aadharNumberReviewCommentDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='aadharNumComment']")
	private WebElement aadharNumber_AdditionalCommentTextbox;
	@FindBy(xpath="(//button[contains(text(),'Preview Attached Proof Document')])[1]")
	private WebElement attachedProofDocument_PAN_PreviewButton;
	@FindBy(xpath="//select[@formcontrolname='panReview']")
	private WebElement pANReviewCommentDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='panComment']")
	private WebElement pAN_AdditionalCommentTextbox;
	@FindBy(xpath="(//button[contains(text(),'Preview Attached Proof Document')])[2]")
	private WebElement gST_AttachedProofDocument_PreviewButton;
	@FindBy(xpath="//select[@formcontrolname='gstReview']")
	private WebElement gST_ReviewCommentsDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='gstComment']")
	private WebElement gST_AdditionalCommentTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Year of Establishment')]]/div/app-file-download/button[text()='Preview Attached Proof Document']")
	private WebElement establishmentYear_AttachedProofDocument_PreviewButton;
	@FindBy(xpath="//select[@formcontrolname='yearOfEstablishReview']")
	private WebElement establishmentYear_reviewCommentDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='yearOfEstablishComment']")
	private WebElement establishmentYear_AdditionalCommentTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Provisional Certificate:')]]/div/app-file-download/button[text()='Preview Attached Proof Document']")
	private WebElement provisionalCertificate_AttachedProofDocument_PreviewButton;
	@FindBy(xpath="//select[@formcontrolname='provisionalReview']")
	private WebElement provisionalCertificate_reviewCommentDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='provisionalComment']")
	private WebElement provisionalCertificate_AdditionalCommentTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Financial Year: 2017-2018')]]/div/app-file-download/button[text()='Preview Attached Proof Document']")
	private WebElement financialYearFirst_AttachedProofDocument_PreviewButton;
	@FindBy(xpath="(//select[@ng-reflect-name='financialYearReview'])[1]")
	private WebElement financialYearFirst_reviewCommentDropDownList;
	@FindBy(xpath="(//textarea[@ng-reflect-name='financialYearComment'])[1]")
	private WebElement financialYearFirst_AdditionalCommentTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Financial Year: 2016-2017')]]/div/app-file-download/button[text()='Preview Attached Proof Document']")
	private WebElement financialYearSecond_AttachedProofDocument_PreviewButton;
	@FindBy(xpath="(//select[@ng-reflect-name='financialYearReview'])[2]")
	private WebElement financialYearSecond_reviewCommentDropDownList;
	@FindBy(xpath="(//textarea[@ng-reflect-name='financialYearComment'])[2]")
	private WebElement financialYearSecond_AdditionalCommentTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Financial Year: 2015-2016')]]/div/app-file-download/button[text()='Preview Attached Proof Document']")
	private WebElement financialYearThird_AttachedProofDocument_PreviewButton;
	@FindBy(xpath="(//select[@ng-reflect-name='financialYearReview'])[3]")
	private WebElement financialYearThird_reviewCommentDropDownList;
	@FindBy(xpath="(//textarea[@ng-reflect-name='financialYearComment'])[3]")
	private WebElement financialYearThird_AdditionalCommentTextbox;
	
	
	@FindBy(xpath="//h5[contains(text(),'Review Field again')]")
	private WebElement reviewFieldAgainButton;
	@FindBy(xpath="//label[input[@type='checkbox']]/span")
	private WebElement editAndSwitchFinalStatusCheckBox;
	@FindBy(css=".form-control.m-input.ng-pristine.ng-valid.ng-touched")
	private WebElement finalReviewStatusDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='finalReviewStatusComment']")
	private WebElement finalStatus_AdditionalCommentTextbox;
	@FindBy(css=".custom-file-input.ng-untouched.ng-pristine.ng-valid")
	private WebElement finalStatus_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement finalStatus_UploadFileButton;
	@FindBy(css=".swal2-confirm.btn.btn-success.m-btn.m-btn--custom")
	private WebElement okButton;
	

	public DA_Assign_TPRegistrationFormPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickFordisplayPreviewofAttachedProofDocumentForOrganizationName()
	{
		attachedProofDocument_NameOfOrganization_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentsForOrganizationName(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewComments_NameOfOrganizationDropDownList, reviewComments);
	}
	
	public void enterAdditionalCommentForOrganisationName(String additionalComment)
	{
		additionalComment_NameOfOrganizationTextbox.clear();
		additionalComment_NameOfOrganizationTextbox.sendKeys(additionalComment);
	}
	
	public void selectReviewCommentsForTypeOFOrganization(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewComments_TypeOfOrganizationDropDownList, reviewComments);
	}
	
	public void enterAdditionalCommentForTypeOfOrganization(String additionalComment)
	{
		additionalComment_TypeOfOrganizationTextbox.clear();
		additionalComment_TypeOfOrganizationTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewofAttachedProofDocumentForAddress()
	{
		attachedProofDocument_Address_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentsForAddress(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewComment_AddressDropDownList, reviewComments);
	}
	
	public void enterAdditionalCommentForAddressOfOrganization(String additionalComment)
	{
		additionalComment_AddressTextbox.clear();
		additionalComment_AddressTextbox.sendKeys(additionalComment);
	}
	
	public void clickForSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	
	public void clickForSaveAsDraft()
	{
		saveAsDraftButton.click();
	}
	
	public void selectReviewCommentForAadharNumber(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(aadharNumberReviewCommentDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForAadharNumber(String additionalComment)
	{
		aadharNumber_AdditionalCommentTextbox.clear();
		aadharNumber_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewOfAttachedProofDocumentForPAN()
	{
		attachedProofDocument_PAN_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentForPAN(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(pANReviewCommentDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForPAN(String additionalComment)
	{
		pAN_AdditionalCommentTextbox.clear();
		pAN_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewOfAttachedProofDocumentForGST()
	{
		gST_AttachedProofDocument_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentsForGST(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(gST_ReviewCommentsDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForGST(String additionalComment)
	{
		gST_AdditionalCommentTextbox.clear();
		gST_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewOfAttachedProofDocumentForEstablishmentYear() 
	{
		establishmentYear_AttachedProofDocument_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentForEstablishmentYear(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(establishmentYear_reviewCommentDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForEstablishmentYear(String additionalComment)
	{
		establishmentYear_AdditionalCommentTextbox.clear();
		establishmentYear_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewOfAttachedProofDocumentForProvisionalCertificate() 
	{
		provisionalCertificate_AttachedProofDocument_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentForProvisionalCertificate(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(provisionalCertificate_reviewCommentDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForProvisionalCertificate(String additionalComment)
	{
		provisionalCertificate_AdditionalCommentTextbox.clear();
		provisionalCertificate_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewOfAttachedProofDocumentForFirstFinancialYear() 
	{
		financialYearFirst_AttachedProofDocument_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentForFirstFinancialYear(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(financialYearFirst_reviewCommentDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForFirstFinancialYear(String additionalComment)
	{
		financialYearFirst_AdditionalCommentTextbox.clear();
		financialYearFirst_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewOfAttachedProofDocumentForSecondFinancialYear() 
	{
		financialYearSecond_AttachedProofDocument_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentForSecondFinancialYear(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(financialYearSecond_reviewCommentDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForSecondFinancialYear(String additionalComment)
	{
		financialYearSecond_AdditionalCommentTextbox.clear();
		financialYearSecond_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForDisplayPreviewOfAttachedProofDocumentForThirdFinancialYear() 
	{
		financialYearThird_AttachedProofDocument_PreviewButton.click();
		FilePreview.closeWindow(driver);
	}
	
	public void selectReviewCommentForThirdFinancialYear(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(financialYearThird_reviewCommentDropDownList, reviewComment);
	}
	
	public void enterAdditionalCommentForThirdFinancialYear(String additionalComment)
	{
		financialYearThird_AdditionalCommentTextbox.clear();
		financialYearThird_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForReviewFieldAgain()
	{
		reviewFieldAgainButton.click();
	}
	
	public void clickForEditAndSwitchFinalStatus()
	{
		editAndSwitchFinalStatusCheckBox.click();
	}
	
	public void selectFinalReviewStatus(String finalstatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(finalReviewStatusDropDownList, finalstatus);
	}
	
	public void enterAdditionalCommentForFinalStatus(String additionalComment)
	{
		finalStatus_AdditionalCommentTextbox.clear();
		finalStatus_AdditionalCommentTextbox.sendKeys(additionalComment);
	}
	
	public void clickForFinalStatusBrowseFile()
	{
		finalStatus_BrowseFileButton.click();
	}
	
	public void clickForFinalStatusUploadFile()
	{
		finalStatus_UploadFileButton.click();
	}
	
	public void clickForOK()
	{
		okButton.click();
	}

}

