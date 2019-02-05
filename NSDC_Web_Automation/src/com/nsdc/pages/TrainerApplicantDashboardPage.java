package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainerApplicantDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement applicantDashboardLink;
	@FindBy(xpath="//*[contains(text(),'Search & Apply')]")
	private WebElement searchAndApplyForAvailableBatchesCardText;
	@FindBy(xpath="//span[contains(text(),'View Batches')]")
	private WebElement viewBatchesCardText;
	
	public TrainerApplicantDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGetApplicantDashboard()
	{
		WebDriverWait wait= new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(applicantDashboardLink));
		applicantDashboardLink.click();
	}
	public void clickSearchAndApplyforAvailableBatches()
	{
		searchAndApplyForAvailableBatchesCardText.click();
	}
	public void clickViewBatches()
	{
		viewBatchesCardText.click();
	}
}