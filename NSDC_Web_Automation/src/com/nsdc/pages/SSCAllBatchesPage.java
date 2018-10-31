package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSCAllBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="Pending Batches")
	private WebElement  pendingBatchesSectionLink;
	@FindBy(linkText="Published Batches")
	private WebElement publishedBatchesSectionLink;
	//Verifying Applied Trainer Batch applicants from SSC End after TC Approval
	@FindBy(xpath="//*[text()='Batch Details']")
	private WebElement batchDetailsSectionLink;
	@FindBy(xpath="//*[text()='Enrolled Candidates']")
	private WebElement enrolledCandidatesSectionLink;
	@FindBy(xpath="//*[contains(text(),'Approved Candidates')]")
	private WebElement approvedCandidatesSectionLink;
	@FindBy(xpath="//*[contains(text(),'Applicants')]")
	private WebElement applicantsSectionLink;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	
	public SSCAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void clickToViewAllPendingBatches()
	{
		pendingBatchesSectionLink.click();
	}
	public void clickToViewAllPublishedBatches()
	{
		publishedBatchesSectionLink.click();
	}
	public void clickToGetBatchActionMenu(String batchID)
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+batchID+"')]]/td[9]//a)[1]")).click();
	}
	public void selectViewDetailsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]//span[contains(text(),'View Details')]")).click();	
	}
	public void selectApproveApplicantsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchID+"')]]//span[contains(text(),'Approve Applicants')]")).click();
	}
	//Verifying Trainer Batch Applicants from SSC End
	public void clickToFoToBatchDetailsSection()
	{
		batchDetailsSectionLink.click();
	}
	public void clickToGoToEnrolledCandidatesSection()
	{
		enrolledCandidatesSectionLink.click();
	}
	public void clickToGoToApprovedCandidatesSection()
	{
		approvedCandidatesSectionLink.click();
	}
	public void clickToGoToApplicantsSection()
	{
		applicantsSectionLink.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	//Domain Master Trainer Action Menu
	public void selectViewDomainMasterTrainerCommentsOption(String domainJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewDomainMasterTrainerAttendenceOption(String domainJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToCloseDomainMasterTrainerViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[1]")).click();
	}
	//Platform Master Trainer Action Menu
	public void selectViewPlatformMasterTrainerCommentsOption(String platformJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewPlatformMasterTrainerAttendenceOption(String platformJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToClosePlatformMasterTrainerViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[1]")).click();
	}
	//Domain Assessment Agency Action Menu
	public void selectViewDomainAssessmentAgencyCommentsOption(String domainJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[6]//a/span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewDomainAssessmentAgencyAttendenceOption(String domainJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToCloseDomainAssessmentAgencyViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[3]")).click();
	}
	//Platform Assessment Agency Action Menu
	public void selectViewPlatformAssessmentAgencyCommentsOption(String platformJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]//a/span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewPlatformAssessmentAgencyAttendenceOption(String platformJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToClosePlatformAssessmentAgencyViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[3]")).click();
	}
}	
	
	
	
	
	
	
	
