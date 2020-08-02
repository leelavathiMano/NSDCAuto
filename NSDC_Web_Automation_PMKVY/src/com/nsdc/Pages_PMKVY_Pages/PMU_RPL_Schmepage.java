package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class PMU_RPL_Schmepage {
WebDriver driver;
	
	
	@FindBy(xpath="//select[@formcontrolname='assessorCertified']")
	private WebElement AssessorCertifiedDropdownList;
	@FindBy(xpath="//select[@formcontrolname='spillOverAssessment']")
	private WebElement spillOverAssessmentDropdownList;
	@FindBy(xpath="//select[@formcontrolname='trainerCertified']")
	private WebElement trainerCertifiedDropdownList;
	@FindBy(xpath="//select[@formcontrolname='attendanceMode']")
	private WebElement AttendanceModeDropdownList;
	@FindBy(xpath="//textarea[@formcontrolname='projectDetailsComment']")
	private WebElement projectDetailsCommentTextBox;
	@FindBy(xpath="//button[contains(text(),'Save & Next')]")
	private WebElement SaveAndNextButton;
	////
	@FindBy(xpath="//textarea[@formcontrolname='locationComment']")
	private WebElement locationCommentTextBox;
	//next page
	@FindBy(xpath="//select[@formcontrolname='required']")
	private WebElement advancePaymentDropDownlist;
	@FindBy(xpath="//input[@formcontrolname='amount']")
	private WebElement amountTextBox;
	
	@FindBy(xpath="(//input[@placeholder='Enter Percentage (%)'])[1]")
	private WebElement discountOnCeilingCostTextBox;
	@FindBy(xpath="(//input[@formcontrolname='discountOnAssessmentFee'])[1]")
	private WebElement discountOnAssessmentFeeTextbox;
	
	@FindBy(xpath="(//input[@formcontrolname='discountOnAssessmentFee'])[2]")
	private WebElement discountOnCeilingCost2TextBox;
	@FindBy(xpath="//button[text()='Download Signed Termsheet']")
	private WebElement DownloadSignerTermSheetButton;
	@FindBy(xpath="//select[@formcontrolname='approvedBy']")
	private WebElement  approvedByDropdownlist;
	
	@FindBy(xpath="//input[@formcontrolname='referenceId']")
	private WebElement  referenceIdTextbox;
	@FindBy(xpath="//input[@placeholder='Select Date']")
	private WebElement  ApprovalDate;
	@FindBy(xpath="(//select[@class='custom-select'])[1]")
	private WebElement  monthDropdownlist;
	
	@FindBy(xpath="(//select[@class='custom-select'])[2]")
	private WebElement  yearDropdownlist;
	
	
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement ApprovalDocumentsBrowser;
	
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement UploadButton;
	
	@FindBy(xpath="//select[@formcontrolname='status']")
	private WebElement pmu_CommentsDropDownlist;
	
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement SaveAndSubmitButton;
	
	@FindBy(xpath="(//button[text()='OK'])")
	private WebElement OKButton;
	public PMU_RPL_Schmepage( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelectAssessorCertified(String Assessor)
	{
		SelectDropDownList.selectDropDownListByVisibleText(AssessorCertifiedDropdownList,Assessor );
	
	}
	
	public void SelectSpillOverAssessment(String spillOverAssessment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(spillOverAssessmentDropdownList,spillOverAssessment);
	
	}
	
	public void SelecttrainerCertified(String trainerCertified)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trainerCertifiedDropdownList, trainerCertified);
		
	}
	public void SelectAttendanceMode(String AttendanceMode)
	{
		SelectDropDownList.selectDropDownListByVisibleText(AttendanceModeDropdownList, AttendanceMode);
		
	}
	public void EnterprojectDetailsComments(String projectDetailsComment)
	{
		projectDetailsCommentTextBox.sendKeys(projectDetailsComment);
	}
	public void ClickOnSaveAndNextButton()
	{
		SaveAndNextButton.click();
	}
	public void EnterlocationCommentComments(String projectDetailsComment)
	{
		locationCommentTextBox.sendKeys(projectDetailsComment);
	}
public void SelectadvancePayment(String advancedpayment)
{
	SelectDropDownList.selectDropDownListByVisibleText(advancePaymentDropDownlist, advancedpayment);
	
}
public void Enteramount(String amount)
{
	amountTextBox.sendKeys(amount);
}
public void EnterdiscountOnCeilingCostTextBox(String discount)
{
	discountOnCeilingCostTextBox.sendKeys(discount);
}
public void EnterdiscountOnAssessmentFee1(String discountOnAssessment)
{
	discountOnAssessmentFeeTextbox.sendKeys(discountOnAssessment);
}
public void EnterdiscountOnAssessmentFee2(String discountOnAssessment2)
{
	discountOnCeilingCost2TextBox.sendKeys(discountOnAssessment2);
}

public void ClickOnDownloadSignerTermSheet() throws InterruptedException
{
	
	DownloadSignerTermSheetButton.click();
	Thread.sleep(3000);
	FilePreview.closeWindow(driver);
	Thread.sleep(3000);
}
public void SelectapprovedBy(String approvedBy)
{
	SelectDropDownList.selectDropDownListByVisibleText(approvedByDropdownlist, approvedBy);
}
public void EnterreferenceId(String referenceId)
{
	referenceIdTextbox.sendKeys(referenceId);
}
public void ClickOnApprovalDate()
{
	ApprovalDate.click();
}
public void SelectApprovalDate(String approvalDate) throws Exception
{
	ToT_ToA_Batch_DatePicker.chooseDate(driver, approvalDate, ApprovalDate, monthDropdownlist, yearDropdownlist);
}

public void ClickOnApprovalDocumentsBrowser()
{
	ApprovalDocumentsBrowser.click();
}
public void ClickOnUploadButton()
{
	UploadButton.click();
}
public void Selectpmu_CommentsTextBox(String Pmu_comments)
{
	SelectDropDownList.selectDropDownListByVisibleText(pmu_CommentsDropDownlist,Pmu_comments);
}
public void ClickOnSaveAndSubmit()
{
	SaveAndSubmitButton.click();
}
public void ClickOnOK()
{
	OKButton.click();
}
}


