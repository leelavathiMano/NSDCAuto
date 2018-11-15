package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerViewBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Requests")
	private WebElement pendingBatchesLink;
	@FindBy(linkText="Accepted")
	private WebElement acceptedBatchesLink;
	@FindBy(linkText="Rejected")
	private WebElement rejectedBatchesLink;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="//textarea[@formcontrolname='acceptComment']")
	private WebElement remarksForAcceptingBatchTextArea;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='rejectedReasons']/div")
	private WebElement rejectionReasonsList;
	@FindBy(xpath="//textarea[@formcontrolname='rejectionComment']")
	private WebElement remarksForRejectingBatchTextArea;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	private WebElement rejectionSubmitButton;
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
		
	public TrainerViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clicktoGoPendingBatchesSection()
	{
		pendingBatchesLink.click();
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
		driver.findElement(By.xpath("(//tr[td[1][contains(text(),'"+batchID+"')]]//a)[1]")).click();
	}
	public void clickToSelectViewDetailsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'View Details')]")).click();
	}
	public void clickToSelectAcceptBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'Accept Batch')]")).click();
	}
	public void clickToSelectRejectBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]//span[contains(text(),'Reject Batch')]")).click();
	}
	public void clickGoBackFromBatchDetails()
	{
		goBackButton.click();
	}
	public void enterRemarksForAcceptingBatch(String remarks)
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
	public void enterRemarksForRejectingBatch(String remarksForRejectingBatch)
	{
		remarksForRejectingBatchTextArea.clear();
		remarksForRejectingBatchTextArea.sendKeys(remarksForRejectingBatch);
	}
	public void clickToSubmit()
	{
		submitButton.click();
	}
	public void clickToSubmitBatchRejection()
	{
		rejectionSubmitButton.click();
	}
	public void clickToClose()
	{
		closeButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
}
