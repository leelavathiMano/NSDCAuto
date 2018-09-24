package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessorViewBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Newly Assigned")
	private WebElement newlyAssignedBatchesLink;
	@FindBy(linkText="Accepted & Ongoing")
	private WebElement acceptedAndOngoingBatchesLink;
	@FindBy(linkText="Completed")
	private WebElement completedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
	@FindBy(xpath="//input[@placeholder='Start Date']")
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
	@FindBy(xpath="//span[contains(text(),'View Batch Details')]")
	private WebElement viewBatchDetailsOption;
	@FindBy(xpath="//span[contains(text(),'Accept/Reject Batch')]")
	private WebElement acceptOrRejectBatchOption;	
	@FindBy(xpath="//button[contains(text(),'View All Batches')]")
	private WebElement viewAllBatchesButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(xpath="(//label[@class='m-radio m-radio--state'])[2]")
	private WebElement rejectBatchRadioButton;
	@FindBy(xpath="//textarea[@formcontrolname='rejectionComment']")
	private WebElement remarksTextArea;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[1]")
	private WebElement saveAndSubmitButton;
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
	public void clicktoGoToNewlyAssignedBatchesSection()
	{
		newlyAssignedBatchesLink.click();
	}
	public void clickToGoToAcceptedAndOngoingBatchesSection()
	{
		acceptedAndOngoingBatchesLink.click();
	}
	public void clickTogoToCompletedBatchesSection()
	{
		completedBatchesLink.click();
	}
	public void clickToGoToRejectedBatchesSection()
	{
		rejectedBatchesLink.click();
	}
	public void clickToGetActionMenuOptions(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]/span/div")).click();
	}
	public void enterTrainingCentreNameToSearch(String trainingCentreName) throws InterruptedException
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
	public void clickToChooseViewBatchDetailsOption(String batchID)
	{
		//viewBatchDetailsOption.click();
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]/span/div/div/a[1]/span")).click();
	}
	public void clickToChooseAcceptOrRejectBatchOption(String batchID)
	{
		//acceptOrRejectBatchOption.click();
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[8]/span/div/div/a[2]/span")).click();
	}
	public void clickViewAllBatchesToGoBackFromBatchDetails()
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
	public void enterBatchStartDateToSearch(String batchStartDate)
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
	public void clickToGoBack()
	{
		goBackButton.click();
	}

}
