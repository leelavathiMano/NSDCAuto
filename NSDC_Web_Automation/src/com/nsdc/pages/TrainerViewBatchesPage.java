package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerViewBatchesPage
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
	@FindBy(xpath="(//label[@class='m-radio'])[1]")
	private WebElement acceptBatchRadioButton;
	@FindBy(xpath="(//label[@class='m-radio'])[2]")
	private WebElement rejectBatchRadioButton;
	@FindBy(xpath="//textarea[@placeholder='Enter the reamarks']")
	private WebElement remarksTextArea;
	@FindBy(xpath="(//button[contains(text(),'Save & Submit')])[1]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
		
	public TrainerViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clicktoGoToNewlyAssignedBatchesSection()
	{
		newlyAssignedBatchesLink.click();
	}
	public void clickToGoToAcceptAndOngoingBatchesSection()
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
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]/td[10]/div")).click();
	}
	public void enterTrainingCentreNameToSearch(String trainingCentreName)
	{
		searchByTrainingCentreNameSearchTextfield.clear();
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
	public void clickToChooseViewBatchDetailsOption()
	{
		viewBatchDetailsOption.click();
	}
	public void clickToChooseAcceptOrRejectBatchOption()
	{
		acceptOrRejectBatchOption.click();
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
}
