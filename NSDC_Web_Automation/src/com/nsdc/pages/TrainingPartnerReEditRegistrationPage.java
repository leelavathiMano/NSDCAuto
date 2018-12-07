package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class TrainingPartnerReEditRegistrationPage
{
	WebDriver driver;
	@FindBy(xpath="//p[contains(text(),'Action DA Comments')]")
	private WebElement daCommentsButton;
	@FindBy(xpath="//h3[contains(text(),'Action & Update Registration Form')]")
	private WebElement actionAndUpdateFormHeaderText;
	@FindBy(xpath="(//button[contains(text(),'Save')])[1]")
	private WebElement nameOfOrganizationSaveButton;
	@FindBy(xpath="(//button[contains(text(),'Save')])[2]")
	private WebElement typeOfOrganizationSaveButton;
	@FindBy(xpath="(//button[contains(text(),'Save')])[3]")
	private WebElement yearOfEstablishmentSaveButton;
	@FindBy(xpath="(//button[contains(text(),'Save')])[4]")
	private WebElement addressOfOrganizationSaveButton;
	@FindBy(xpath="(//button[contains(text(),'Save')])[5]")
	private WebElement saveButton1;
	@FindBy(xpath="(//button[contains(text(),'Save')])[6]")
	private WebElement saveButton2;
	@FindBy(xpath="(//button[contains(text(),'Save')])[7]")
	private WebElement saveButton3;
	@FindBy(xpath="(//button[contains(text(),'Save')])[8]")
	private WebElement saveButton4;
	@FindBy(xpath="(//button[contains(text(),'Save')])[9]")
	private WebElement saveButton5;
	@FindBy(xpath="//button[contains(text(),'Save & Submit for Review')]")
	private WebElement submitForReviewButton;
	@FindBy(xpath="//div[@class='swal2-contentwrapper']")
    private WebElement sentForApprovalPopup;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement sentForApprovalPopupOkButton;
	@FindBy(xpath="//select[@formcontrolname='typeOfOrganisation']")
	private WebElement typeOfOrganizationDropdownList;
	@FindBy(xpath="//select[@formcontrolname='yearOfEstablishment']")
	private WebElement yearOfEstablishmentDropdownList;
	@FindBy(xpath="//input[@formcontrolname='PAN']")
	private WebElement panTextField;
	@FindBy(xpath="//app-upload-file[@filetype='pan']//input")
	private WebElement panBrowseFileButton;
	@FindBy(xpath="//app-upload-file[@filetype='pan']//button[contains(text(),'Upload')]")
	private WebElement panUploadFileButton;
	@FindBy(xpath="//input[@formcontrolname='GST']")
	private WebElement gstTextField;
	@FindBy(xpath="//app-upload-file[@filetype='gst']//input")
	private WebElement gstBrowseFileButton;
	@FindBy(xpath="//app-upload-file[@filetype='gst']//button[contains(text(),'Upload')]")
	private WebElement gstUploadFileButton;
	@FindBy(xpath="//input[@formcontrolname='aadhar']")
	private WebElement aadharTextField;
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	private WebElement aadharVerifyButton;
	@FindBy(xpath="//app-upload-file[@filetype='provisionalDocument']//input")
	private WebElement provisionalCertificateBrowseFileButton;
	@FindBy(xpath="//app-upload-file[@filetype='provisionalDocument']//button[contains(text(),'Upload')]")
	private WebElement provisionalCertificateUploadButton;
	@FindBy(xpath="//input[@formcontrolname='annuvalTurnover1']")
	private WebElement turnOver1TextField;
	@FindBy(xpath="//input[@formcontrolname='annuvalTurnover2']")
	private WebElement turnOver2TextField;
	@FindBy(xpath="//input[@formcontrolname='annuvalTurnover3']")
	private WebElement turnOver3TextField;
	@FindBy(xpath="//app-upload-file[@filetype='annuvalTurnover1']//input")
	private WebElement turnOver1FileBrowseButton;
	@FindBy(xpath="//app-upload-file[@filetype='annuvalTurnover1']//button[contains(text(),'Upload')]")
	private WebElement turnOver1FileUploadButton;
	@FindBy(xpath="//app-upload-file[@filetype='annuvalTurnover2']//input")
	private WebElement turnOver2FileBrowseButton;
	@FindBy(xpath="//app-upload-file[@filetype='annuvalTurnover2']//button[contains(text(),'Upload')]")
	private WebElement turnOver2FileUploadButton;
	@FindBy(xpath="//app-upload-file[@filetype='annuvalTurnover3']//input")
	private WebElement turnOver3FileBrowseButton;
	@FindBy(xpath="//app-upload-file[@filetype='annuvalTurnover3']//button[contains(text(),'Upload')]")
	private WebElement turnOver3FileUploadButton;
	@FindBy(xpath="//app-upload-file[@filetype='yearOfEstablishmentFile']//input")
	private WebElement yearOfEstablishmentFileBrowseButton;
	@FindBy(xpath="//app-upload-file[@filetype='yearOfEstablishmentFile']//button[contains(text(),'Upload')]")
	private WebElement yearOfEstablishmentFileUploadButton;
	
	public TrainingPartnerReEditRegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickDaComments()
	{
		daCommentsButton.click();
	}
	public void clicknameOfOrganizationSave()
	{
		nameOfOrganizationSaveButton.click();
	}
	public void clickTypeOfOrganizationSave()
	{
		typeOfOrganizationSaveButton.click();
	}
	public void clickYearOfEstablishmentSave()
	{
		yearOfEstablishmentSaveButton.click();
	}
	public void clickAddressOfOrganizationSave()
	{
		addressOfOrganizationSaveButton.click();
	}
	public void clickSave1()
	{
		saveButton1.click();
	}
	public void clickSave2()
	{
		saveButton2.click();
	}
	public void clickSave3()
	{
		saveButton3.click();
	}
	public void clickSave4()
	{
		saveButton4.click();
	}
	public void clickSave5()
	{
		saveButton5.click();
	}
	public void clickSubmitForReview()
	{
		submitForReviewButton.click();
	}
	public void clickSentforApprovalPopup()
	{
		sentForApprovalPopupOkButton.click();
	}	
	public void selectUpdatedTypeOfOrganization(String updateOrganizationType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(typeOfOrganizationDropdownList, updateOrganizationType);
	}
	public void selectUpdatedYearOfEstablishment(String updateYearOfEstablishment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(yearOfEstablishmentDropdownList, updateYearOfEstablishment);
	}
	public void enterPAN(String pan)
	{
		panTextField.clear();
		panTextField.sendKeys(pan);
	}
	public void clickToBrowseFileForPAN()
	{
		panBrowseFileButton.click();
	}
	public void clickToUploadPAN()
	{
		panUploadFileButton.click();
	}
	public void enterGST(String gst)
	{
		gstTextField.clear();
		gstTextField.sendKeys(gst);
	}
	public void clickToBrowseFileForGST()
	{
		gstBrowseFileButton.click();
	}
	public void clickToUploadGST()
	{
		gstUploadFileButton.click();
	}
	public void enterAadhar(String aadhar)
	{
		aadharTextField.clear();
		aadharTextField.sendKeys(aadhar);
	}
	public void clickToVerifyAadhar()
	{
		aadharVerifyButton.click();
	}
	public void clickToBrowseFileForYearOfEstablishment()
	{
		yearOfEstablishmentFileBrowseButton.click();
	}
	public void clickToUploadYearOfEstablishment()
	{
		yearOfEstablishmentFileUploadButton.click();
	}
	public void clickToBrowseFileForProvisionalCertificate()
	{
		provisionalCertificateBrowseFileButton.click();
	}
	public void clickToUploadProvisionalCertificate()
	{
		provisionalCertificateUploadButton.click();
	}
	public void enterFirstFinancialYearTurnOver(String updateFinancialYear1TurnOver)
	{
		turnOver1TextField.clear();
		turnOver1TextField.sendKeys(updateFinancialYear1TurnOver);
	}
	public void clickToBrowseFileForTurnOver1()
	{
		turnOver1FileBrowseButton.click();
	}
	public void clickToUploadFirstFinancialYearTurnOver()
	{
		turnOver1FileUploadButton.click();
	}
	public void enterSecondFinancialYearTurnOver(String updateFinancialYear2TurnOver)
	{
		turnOver2TextField.clear();
		turnOver2TextField.sendKeys(updateFinancialYear2TurnOver);
	}
	public void clickToBrowseFileForTurnOver2()
	{
		turnOver2FileBrowseButton.click();
	}
	public void clickToUploadSecondFinancialYearTurnOver()
	{
		turnOver2FileUploadButton.click();
	}
	public void enterThirdFinancialYearTurnOver(String updateFinancialYear3TurnOver)
	{
		turnOver3TextField.clear();
		turnOver3TextField.sendKeys(updateFinancialYear3TurnOver);
	}
	public void clickToBrowseFileForTurnOver3()
	{
		turnOver3FileBrowseButton.click();
	}
	public void clickToUploadThirdFinancialYearTurnOver()
	{
		turnOver3FileUploadButton.click();
	}
	
}
