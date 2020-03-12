package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SP_TC_ViewDetailsPage {
	WebDriver driver;
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement SP_ActionButton ;
	@FindBy(xpath="(//a[contains(text(),'View Details')])[1]")
	private WebElement ViewDetailsButton1 ;
	@FindBy(xpath="//div[div[p[text()='All My Batches']]]")
	private WebElement ViewDetailsButton ;
	@FindBy(xpath="//div[div[p[text()='All My Batches']]]")
	private WebElement  View_All_BatchesIcon;
	@FindBy(xpath="//button[contains(text(),'Create Batch')]")
	private WebElement CreateBatchaButton;
	public SP_TC_ViewDetailsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnSPAction() throws InterruptedException
	{
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", SP_ActionButton);
		//SP_ActionButton.click();
	}
	public void CLickOnViewDetails()
	{
		ViewDetailsButton1.click();
	}
	public void ClickOnView_All_Batches() throws InterruptedException
	{
		
		View_All_BatchesIcon.click();
	}
	 public void ClickOnCreateBatch() throws InterruptedException
	 {
		 
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", CreateBatchaButton);
		 //CreateBatchaButton.click();
	 }
}
