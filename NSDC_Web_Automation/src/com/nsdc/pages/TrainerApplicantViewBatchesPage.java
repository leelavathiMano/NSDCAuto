package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerApplicantViewBatchesPage
{
	WebDriver driver;
	@FindBy(xpath="(//a[@class='m-menu__link m-menu__toggle']/span[2])[1]")
	private WebElement applicantDashboardLink;
	@FindBy(linkText="Upcoming")
	private WebElement upcomingBatchesSectionLink;
	@FindBy(linkText="Applied")
	private WebElement appliedBatchesSectionLink;
	@FindBy(linkText="Approved")
	private WebElement approvedBatchesSectionLink;
	@FindBy(linkText="Completed and Certified")
	private WebElement CompletedAandCertifiedBatchesSectionLink;
	@FindBy(linkText="Completed and Not Certified")
	private WebElement CompletedAndNotCertifiedBatchesSectionLink;
	@FindBy(linkText="Rejected")
	private WebElement RejectedBatchesSectionLink;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchForKeywordTextField;
	
	public TrainerApplicantViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGoToApplicantDashboard()
	{
		applicantDashboardLink.click();
	}
	public void clickToGoToUpcomingBatchesSection()
	{
		upcomingBatchesSectionLink.click();
	}
	public void clickToGoToAppliedBatchesSection()
	{
		appliedBatchesSectionLink.click();
	}
	public void clickToGoToApprovedBatchesSection()
	{
		approvedBatchesSectionLink.click();
	}
	public void clickToGoToCompletedAndCertifiedBatchesSection()
	{
		CompletedAandCertifiedBatchesSectionLink.click();
	}
	public void clickToGoToCompletedAndNotCertifiedBatchesSection()
	{
		CompletedAndNotCertifiedBatchesSectionLink.click();
	}
	public void clickToGoToRejectedBatchesSection()
	{
		RejectedBatchesSectionLink.click();
	}
	public void enterToSearchForBatch(String batchKeywords)
	{
		searchForKeywordTextField.clear();
		searchForKeywordTextField.sendKeys(batchKeywords);
	}
	
}
