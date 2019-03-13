package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainerDashboardPage
{
	WebDriver driver;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[2]")
	private WebElement trainerDashboardLink;
	@FindBy(xpath="//strong[contains(text(),'All Batches')]")
	private WebElement allBatchesButton;
	@FindBy(xpath="//strong[contains(text(),'Update Batch Status')]")
	private WebElement updateBatchstatusButton;
	
	public TrainerDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGetTrainerDashboard()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(trainerDashboardLink));
		trainerDashboardLink.click();
	}
	public void clickAllBatches()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(allBatchesButton));
		allBatchesButton.click();
	}
	public void clickUpdateBatchStatus()
	{
		updateBatchstatusButton.click();
	}
}