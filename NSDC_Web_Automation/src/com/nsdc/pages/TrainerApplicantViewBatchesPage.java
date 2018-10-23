package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerApplicantViewBatchesPage
{
	WebDriver driver;
	@FindBy(xpath="(//a[@class='m-menu__link m-menu__toggle']/span[2])[1]")
	private WebElement applicantDashboardLink;
	@FindBy(xpath="//button[@class='close align-data']")
	private WebElement viewTC_CommentsCloseButton;
	
	public TrainerApplicantViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGoToApplicantDashboard()
	{
		applicantDashboardLink.click();
	}
	public void clickToGetRejectedBatchActionMenu(String batchID)
	{
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void selectViewCommentsForRejection(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'View Comments')]")).click();
	}
	public void clickToCloseTC_CommentsView()
	{
		viewTC_CommentsCloseButton.click();
	}
}
