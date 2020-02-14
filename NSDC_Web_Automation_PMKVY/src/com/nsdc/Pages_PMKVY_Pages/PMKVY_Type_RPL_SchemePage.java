package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class PMKVY_Type_RPL_SchemePage {

	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Enter project proposal id']")
	private WebElement ProjectProposalIDTextBox;
	@FindBy(xpath="//input[@placeholder='Enter project name']")
	private WebElement ProjecNameTextBox;
	@FindBy(xpath="(//label[input[@formcontrolname='projectType']])[1]/span")
	private WebElement ProjectTypeButton;
	@FindBy(xpath="//input[@placeholder='Select Date']")
	private WebElement AgreementDateDropdownlist;
	@FindBy(xpath="(//select[@class='custom-select'])[1]")
	private WebElement monthDropdownlist;
	@FindBy(xpath="(//select[@class='custom-select'])[2]")
	private WebElement yearDropdownlist;
	@FindBy(xpath="//input[@formcontrolname='projectDuration']")
	private WebElement projectDuration;

	@FindBy(xpath="//input[@placeholder='Facilitator Organization Name']")
	private WebElement FacilitatorOrganizationNameTextBox;
	@FindBy(xpath="//button[text()='Add']")
	private WebElement AddButton;
	@FindBy(xpath="//button[text()='Add Promoter']")
	private WebElement AddPromoterButton;
	
	
	@FindBy(xpath="(//input[@placeholder='Enter Name'])[3]")
	private WebElement FullNameTextbox;
	@FindBy(xpath="//input[@placeholder='Enter Designation']")
	private WebElement EnterDesignationTextbox;
	@FindBy(xpath="(//input[@placeholder='Enter Mobile Number'])[3]")
	private WebElement EnterMobilenumberTextbox;
	@FindBy(xpath="(//input[@placeholder='Enter Email Address'])[3]")
	private WebElement emailAddressTextbox;
	@FindBy(xpath="(//label[contains(text(),'Upload Resume:')]/..//span)[2]")
	private WebElement UploadDocumentRadiobutton;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement Browsertextbox;
	@FindBy(xpath="//textarea[@placeholder='Enter Address']")
	private WebElement adresstextbox;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement SubmitButton;
	@FindBy(xpath="//input[@placeholder='Total Project Target']")
	private WebElement projectTarget;
	@FindBy(xpath="//select[@formcontrolname='dualLogoRequired']")
	private WebElement dualLogoDropdownlist;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement DuallogoBrowser;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement UploadButton;
	@FindBy(xpath="//button[contains(text(),'Save & Next')]")
	private WebElement SaveAndNextButton;
	public PMKVY_Type_RPL_SchemePage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	
	
	
	
public void EnterTheProjectProposalID(String ProjectProposalID) 
{
	ProjectProposalIDTextBox.sendKeys(ProjectProposalID);
}
public void EnterTheProjecName(String ProjecName)
{
	ProjecNameTextBox.sendKeys(ProjecName);
}

public void ClickProjectType() throws InterruptedException

{
	Thread.sleep(2000);
	ProjectTypeButton.click();
}
public void ClickOnAgreementDate()
{
	AgreementDateDropdownlist.click();
}

public void SelectAgreementDate(String agreementDate) throws InterruptedException
{
	ToT_ToA_Batch_DatePicker.chooseDate(driver,agreementDate , AgreementDateDropdownlist, monthDropdownlist, yearDropdownlist);
}
public void EnterProjectDuration(String projectduration)
{
	projectDuration.sendKeys(projectduration);
}

public void EnterFacilitatorOrganizationNameTextBox(String  orgName)
{
	FacilitatorOrganizationNameTextBox.sendKeys(orgName);
}
public void ClickOnAddButton()
{
	AddButton.click();
}
public void ClickOnAddPromoterButton()
{
	AddPromoterButton.click();
}
public void EnterTheFullName(String fullname)
{
	FullNameTextbox.sendKeys(fullname);
}
public void EnterDesignationTextbox(String designation)
{
	EnterDesignationTextbox.sendKeys(designation);
}
public void EnterMobilenumberTextbox(String mobilenumber)
{
	EnterMobilenumberTextbox.sendKeys(mobilenumber);
}
public void EnterEmailAdress(String email)
{
	emailAddressTextbox.sendKeys(email);
}
public void ClickOnUploadDocumentRadiobutton()
{
	UploadDocumentRadiobutton.click();
}
public void ClickOnBrowser()
{
	Browsertextbox.click();
}
public void EnterAdress(String Address)
{
	adresstextbox.sendKeys(Address);
}
public void ClickOnSubmit()
{
	SubmitButton.click();
}
public void EnterprojectTarget(String target)
{
	projectTarget.sendKeys(target);
}
public void SelectdualLogoDropdownlist(String duallogo)
{
	SelectDropDownList.selectDropDownListByVisibleText(dualLogoDropdownlist, duallogo);
}
public void ClickOnDuallogoBrowser()
{
	DuallogoBrowser.click();
}
public void ClickonUploadButton()
{
	UploadButton.click();
}
public void ClickOnSaveAndNextButton()
{
	SaveAndNextButton.click();
}
}
