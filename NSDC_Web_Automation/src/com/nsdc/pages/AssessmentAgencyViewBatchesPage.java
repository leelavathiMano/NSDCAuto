package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AssessmentAgencyViewBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Requests")
	private WebElement pendingRequestsLink;
	@FindBy(linkText="Accepted")
	private WebElement acceptedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
	@FindBy(xpath="//input[@placeholder='Search by Batch ID']")
	private WebElement searchByBatchIdTextfield;
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement actionMenuDropdownLink;
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept Batch')]")
	private WebElement acceptBatchOption;
	@FindBy(xpath="//span[contains(text(),'Reject Batch')]")
	private WebElement rejectBatchOption;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="//textarea[@formcontrolname='acceptComment']")
	private WebElement remarksForAcceptingBatchTextArea;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='rejectedReasons']/div")
	private WebElement rejectionReasonsList;
	@FindBy(xpath="//textarea[@formcontrolname='rejectionComment']")
	private WebElement remarksForRejectingBatchTextArea;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement acceptSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	private WebElement rejectSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//span[contains(text(),'Assign Assessor')]")
	private WebElement assignAssessorsOption;
	@FindBy(xpath="(//select[@formcontrolname='assessor'])[1]")
	private WebElement domain1AssessorsDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='assessor'])[2]")
	private WebElement domain2AssessorsDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='assessor'])[1]")
	private WebElement platformAssessorsDropdownList;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[4]")
	private WebElement submitMasterAssessorButton;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[1]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(linkText="Completed")
	private WebElement completedBatchesLink;
	//ReAssign Master Assessor
	@FindBy(xpath="(//span[contains(text(),'View')])[1]")
	private WebElement viewCommentsOptionText;
	@FindBy(xpath="(//span[contains(text(),'Re-Assign')])[1]")
	private WebElement reAssignAssessorOptionText;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='assessor']/div")
	private WebElement reAssignMasterAssessorList;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitReAssignedMasterAssessorButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	
	public AssessmentAgencyViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToViewPendingBatchRequests()
	{
		pendingRequestsLink.click();
	}
	public void clickToViewAcceptedBatches()
	{
		acceptedBatchesLink.click();
	}
	public void clickToViewRejectedBatches()
	{
		rejectedBatchesLink.click();
	}
	public void clickToGetActionMenuOptions()
	{
		actionMenuDropdownLink.click();
	}
	public void enterBatchIdToSearch(String batchID) throws InterruptedException
	{
		searchByBatchIdTextfield.clear();
		Thread.sleep(2000);
		searchByBatchIdTextfield.sendKeys(batchID);
	}
	public void clickToSelectViewBatchDetailsOption()
	{
		viewBatchDetailsOption.click();
	}
	public void clickToGoBack()
	{
		goBackButton.click();
	}
	public void clickToSelectAcceptBatchOption()
	{
		acceptBatchOption.click();
	}
	public void clickToSelectRejectBatchOption()
	{
		rejectBatchOption.click();
	}
	public void enterRemarksForAcceptingBatch(String remarksForAcceptingBatch)
	{
		remarksForAcceptingBatchTextArea.clear();
		remarksForAcceptingBatchTextArea.sendKeys(remarksForAcceptingBatch);
	}
	public void selectReasonForRejectingBatch(String rejectionReason) throws InterruptedException
	{
		rejectionReasonsList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+rejectionReason+"')]")).click();
	}
	public void enterRemarksForRejctingBatch(String remarksForRejectingBatch)
	{
		remarksForRejectingBatchTextArea.clear();
		remarksForRejectingBatchTextArea.sendKeys(remarksForRejectingBatch);
	}
	public void clickToSubmitBatchAcceptance()
	{
		acceptSubmitButton.click();
	}
	public void clickToSubmitBatchRejection()
	{
		rejectSubmitButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	public void clickToSelectAssignAssessorsOption()
	{
		assignAssessorsOption.click();
	}
	public void selectMasterAssessorForDomain1(String dmasterAssessorNameID)
	{
		SelectDropDownList.selectDropDownListByVisibleText(domain1AssessorsDropdownList, dmasterAssessorNameID);
	}
	public void selectMasterAssessorForDomain2(String dmasterAssessorNameID)
	{
		SelectDropDownList.selectDropDownListByVisibleText(domain2AssessorsDropdownList, dmasterAssessorNameID);
	}
	public void selectMasterAssessorForPlatform(String pmasterAssessorNameID)
	{
		SelectDropDownList.selectDropDownListByVisibleText(platformAssessorsDropdownList, pmasterAssessorNameID);
	}
	public void clickToSubmitMasterAssessors()
	{
		submitMasterAssessorButton.click();
	}
	public void clickToSaveAndSubmit()
	{
		saveAndSubmitButton.click();
	}
	public void clickToAcceptBatch()
	{
		acceptBatchRadioButton.click();
	}
	public void clickToViewCompletedBatches()
	{
		completedBatchesLink.click();
	}
	//ReAssign Master Assessors
	public void selectViewCommentsOfMasterAssessorOption()
	{
		viewCommentsOptionText.click();
	}
	public void selectReAssignMasterAssessorOption()
	{
		reAssignAssessorOptionText.click();
	}
	public void clickToCloseViewComments()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[1]")).click();
	}
	public void selectReAssignMasterAssessorForDomain(String dmasterAssessorName, String dmasterAssessorID)
	{
		reAssignMasterAssessorList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+dmasterAssessorName+" ( "+dmasterAssessorID+" )')]")).click();
	}
	public void clickToSubmitReAssignedMasterAssessor()
	{
		submitReAssignedMasterAssessorButton.click();
	}
	public void clickToCancel()
	{
		cancelButton.click();
	}
}
