package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_DashboardPage 
{
	WebDriver driver;

	@FindBy(xpath="(//a[@class='m-menu__link m-menu__toggle'])[2]")
	private WebElement QP_NOS_ModelCurriculumTab;
	@FindBy(linkText="ToT, ToA, ToMT,ToMA")
	private WebElement  totToAToMTToMALink;
	@FindBy(xpath="//span[contains(text(),'Create Exceptional Training Centre')]")
	private WebElement createTemporaryTrainingCentreButton;
	@FindBy(xpath="//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]")
	private WebElement createBatchButton;
	@FindBy(xpath="//strong[text()='All Batches New']")
	private WebElement allBatchesButton;
	@FindBy(linkText="Rozgar Mela")
	private WebElement rozgarMelaLink;
	
	public SSC_DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOn_QP_NOS_ModelCurriculum()
	{
		QP_NOS_ModelCurriculumTab.click();
	}
	public void clickToTToAToMTToMA()
	{
		totToAToMTToMALink.click();
	}
	
	public void clickCreateTemporaryTrainingCentre()
	{
		createTemporaryTrainingCentreButton.click();
	}
	
	public void clickCreateBatch()
	{
		createBatchButton.click();
	}
	public void clickAllBatches()
	{
		allBatchesButton.click();
	}
	public void clickRozgarMela()
	{
		rozgarMelaLink.click();
	}
}
