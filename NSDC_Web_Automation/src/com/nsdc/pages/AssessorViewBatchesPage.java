package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessorViewBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Requests")
	private WebElement pendingRequestsLink;
	@FindBy(linkText="Accepted")
	private WebElement acceptedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
/*	@FindBy(xpath="//input[@placeholder='Start Date']")
	private WebElement batchStartDateFilter;
	@FindBy(xpath="(//span[i[@class='la la-calendar']])[1]")
	private WebElement closeBatchStartDateCalenderButton;
	@FindBy(xpath="//input[@placeholder='End Date']")
	private WebElement batchEndDateFilter;
	@FindBy(xpath="(//span[i[@class='la la-calendar']])[2]")
	private WebElement closeBatchEndDateCalenderButton;
	@FindBy(xpath="//input[@placeholder='Search by Training Centre Name']")
	private WebElement searchByTrainingCentreNameSearchTextfield;
	@FindBy(xpath="//span[contains(text(),'Select Batch Type')]")
	private WebElement filterByBatchTypeList;
	@FindBy(xpath="//span[contains(text(),'Select Job Role')]")
	private WebElement filterByJobRoleList;
	//@FindBy(xpath="//span[@class='c-angle-up']")
	@FindBy(xpath="//b[contains(text(),'Training Centre Name')]")
	private WebElement filterbyBatchTypeAngleUp;
	//@FindBy(xpath="//span[@class='c-angle-up']")
	@FindBy(xpath="//label[contains(text(),'Job Role')]")
	private WebElement filterbyJobRoleAngleUp;
*/	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept/Reject Batch')]")
	private WebElement acceptOrRejectBatchOption;	
	@FindBy(xpath="//button[contains(text(),'View All Batches')]")
	private WebElement viewAllBatchesButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[2]")
	private WebElement rejectBatchRadioButton;
	@FindBy(xpath="(//textarea[@placeholder='Enter remarks'])[1]")
	private WebElement remarksForAcceptingBatchTextArea;
	@FindBy(xpath="//angular2-multiselect[@name='reason']/div")
	private WebElement rejectionReasonsList;
	@FindBy(xpath="(//textarea[@placeholder='Enter remarks'])[2]")
	private WebElement remarksForRejectingBatchTextArea;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[1]")
	private WebElement saveAndSubmitOfAcceptBatchButton;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[2]")
	private WebElement saveAndSubmitOfRejectBatchButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	
	public AssessorViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clicktoGoToPendingRequestsSection()
	{
		pendingRequestsLink.click();
	}
	public void clickToGoToAcceptedBatchesSection()
	{
		acceptedBatchesLink.click();
	}
	public void clickToGoToRejectedBatchesSection()
	{
		rejectedBatchesLink.click();
	}
	public void clickToGetActionMenuOptions(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]/span/div/a")).click();
	}
/*	public void enterTrainingCentreNameToSearch(String trainingCentreName) throws InterruptedException
	{
		searchByTrainingCentreNameSearchTextfield.clear();
		Thread.sleep(2000);
		searchByTrainingCentreNameSearchTextfield.sendKeys(trainingCentreName);
	}
	public void clickToViewFilterByBatchTypeListOptions()
	{
		filterByBatchTypeList.click();
	}
	public void clickToViewFilterByJobRoleListOptions()
	{
		filterByJobRoleList.click();
	}
	public void clickToCloseFilterByBatchTypeList()
	{
		filterbyBatchTypeAngleUp.click();
	}
	public void clickToCloseFilterByJobRoleList()
	{
		filterbyJobRoleAngleUp.click();
	}
*/	public void clickToSelectViewBatchDetailsOption(String batchID)
	{
		//viewBatchDetailsOption.click();
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]/span/div/div/a/span[contains(text(),'View Batch Details')]")).click();
	}
	public void clickToSelectAcceptBatchOption(String batchID)
	{
		//acceptOrRejectBatchOption.click();
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]/span/div/div/a/span[contains(text(),'Accept Batch')]")).click();
	}
	public void clickToSelectRejectBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]/span/div/div/a/span[contains(text(),'Reject Batch')]")).click();
	}
/*	public void clickViewAllBatchesToGoBackFromBatchDetails()
	{
		viewAllBatchesButton.click();
	}
	public void clickToAcceptBatch()
	{
		acceptBatchRadioButton.click();
	}
	public void clickToRejectBatch()
	{
		rejectBatchRadioButton.click();
	}
*/	public void enterRemarksForAcceptingBatch(String remarks)
	{
		remarksForAcceptingBatchTextArea.clear();	
		remarksForAcceptingBatchTextArea.sendKeys(remarks);
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
	public void clickToSaveAndSubmitBatchAccceptance()
	{
		saveAndSubmitOfAcceptBatchButton.click();
	}
	public void clickToSaveAndSubmitBatchRejection()
	{
		saveAndSubmitOfRejectBatchButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
/*	public void enterBatchStartDateToSearch(String batchStartDate)
	{
		batchStartDateFilter.clear();
		batchStartDateFilter.sendKeys(batchStartDate);
	}
	public void clickToCloseBatchStartDateCalender()
	{
		closeBatchStartDateCalenderButton.click();
	}
	public void enterBatchEndDateToSearch(String batchEndDate)
	{
		batchEndDateFilter.clear();
		batchEndDateFilter.sendKeys(batchEndDate);
	}
	public void clickToCloseBatchEndDateCalender()
	{
		closeBatchEndDateCalenderButton.click();
	}
*/	public void clickToGoBack()
	{
		goBackButton.click();
	}

}
