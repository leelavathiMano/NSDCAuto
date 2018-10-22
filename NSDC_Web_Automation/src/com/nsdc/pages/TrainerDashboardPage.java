package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		trainerDashboardLink.click();
	}
	public void clickAllBatches()
	{
		allBatchesButton.click();
	}
	public void clickUpdateBatchStatus()
	{
		updateBatchstatusButton.click();
	}
}
