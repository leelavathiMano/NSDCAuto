package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AssessmentAgencyViewBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Newly Assigned")
	private WebElement newlyAssignedBatchesLink;
	@FindBy(linkText="Accepted")
	private WebElement acceptedBatchesLink;
	@FindBy(linkText="Ongoing")
	private WebElement ongoingBatchesLink;
	@FindBy(linkText="Completed")
	private WebElement completedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
	@FindBy(xpath="//input[@placeholder='Search by Batch ID']")
	private WebElement searchByBatchIdTextfield;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement actionMenuDropdownLink;
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept/Reject Batch')]")
	private WebElement acceptOrRejectBatchOption;	
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[2]")
	private WebElement rejectBatchRadioButton;
	@FindBy(xpath="//textarea[@placeholder='If Batch is rejected, the reason should be provided to be reviewed by SSC']")
	private WebElement remarksTextArea;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[1]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//select[@formcontrolname='assessor']")
	private WebElement assessorsDropdownList;
	@FindBy(xpath="//span[contains(text(),'Assign Assessor')]")
	private WebElement assignAssessorsActionMenuOption;
					
	public AssessmentAgencyViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToViewNewlyAssignedBatches()
	{
		newlyAssignedBatchesLink.click();
	}
	public void clickToViewAcceptedBatches()
	{
		acceptedBatchesLink.click();
	}
	public void clickToViewOngoingBatches()
	{
		ongoingBatchesLink.click();
	}
	public void clickToViewCompletedBatches()
	{
		completedBatchesLink.click();
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
	public void clickToChooseViewBatchDetailsOption()
	{
		viewBatchDetailsOption.click();
	}
	public void clickToGoBack()
	{
		goBackButton.click();
	}
	public void clickToChooseAcceptOrRejectBatchOption()
	{
		acceptOrRejectBatchOption.click();
	}
	public void clickToAcceptBatch()
	{
		acceptBatchRadioButton.click();
	}
	public void clickToRejectBatch()
	{
		rejectBatchRadioButton.click();
	}
	public void enterRemarks(String remarks)
	{
		remarksTextArea.clear();
		remarksTextArea.sendKeys(remarks);
	}
	public void clickToSaveAndSubmit()
	{
		saveAndSubmitButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	public void selectAssessorsToBeAssignedForBatches(String assessorID)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assessorsDropdownList, assessorID);
	}
	public void clickToChooseAssignAssessorsActionMenuOption()
	{
		assignAssessorsActionMenuOption.click();
	}
}
