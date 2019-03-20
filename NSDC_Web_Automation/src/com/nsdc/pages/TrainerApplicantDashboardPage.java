package com.nsdc.pages;

import org.openqa.selenium.JavascriptExecutor;
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
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(applicantDashboardLink));
		applicantDashboardLink.click();
	}
	public void clickSearchAndApplyforAvailableBatches()
	{
		WebDriverWait wait= new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(searchAndApplyForAvailableBatchesCardText));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchAndApplyForAvailableBatchesCardText);
	}
	public void clickViewBatches()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", viewBatchesCardText);
	}
}