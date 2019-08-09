package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationBasedTC_DashboardPage
{
	WebDriver driver;
	@FindBy(linkText="ToT, ToA, ToMT,ToMA")
	private WebElement toTtoAtoMTtoMALink;
	@FindBy(linkText="Rozgar Mela")
	private WebElement rozgarMelaLink;
	@FindBy(xpath="//p[contains(text(),'View Applications')]")
	private WebElement viewApplicationsCard;
	@FindBy(xpath="//strong[text()='View Batches']")
	private WebElement viewBatchesButton;
	@FindBy(xpath="(//p[contains(text(),'Associated Trainers')])[1]")
	private WebElement associatedTrainersCard;
	@FindBy(xpath="(//p[contains(text(),'TC SPOC Change')])[1]")
	private WebElement tcSPOC_ChangeCard;
		
	public LocationBasedTC_DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToT_ToA_ToMT_ToMA()
	{
		toTtoAtoMTtoMALink.click();
	}
	public void clickRozgarMela()
	{
		rozgarMelaLink.click();
	}
	public void clickViewApplications()
	{
		viewApplicationsCard.click();
	}
	public void clickToViewBatches()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='View Batches']")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", viewBatchesButton);
	}
	public void clickAssociatedTrainers()
	{
		associatedTrainersCard.click();
	}
	public void clickTC_SPOC_Change()
	{
		tcSPOC_ChangeCard.click();
	}
}