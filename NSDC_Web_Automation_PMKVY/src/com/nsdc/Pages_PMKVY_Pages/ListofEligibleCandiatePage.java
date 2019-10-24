package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class ListofEligibleCandiatePage 
{
	WebDriver driver;

	public ListofEligibleCandiatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//wait = new WebDriverWait(driver, 30);
	}
	
	
	@FindBy(xpath="//input[@formcontrolname='candidateId']")
	private WebElement CandiateIdTextBOx;
	
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement ApplyClickButton;
	
	@FindBy(xpath = "//tbody[@_ngcontent-c39]//tr[1]//td[1]//span[@_ngcontent-c39]")
	private WebElement CandiateCheckBox;
	
	@FindBy(xpath="//tbody[@_ngcontent-c39]//tr[1]//td[13]//span[@_ngcontent-c39]")
	private WebElement BAndLCheckBox;
	@FindBy(xpath="//select[@formcontrolname='modeOfBkl']")
	private WebElement ModelofBAndLDropDownList;
	
	
	
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement StateDropDownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropDownList;
	
	
	//
	public void ClickOnCandiateId() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", CandiateIdTextBOx);
	}
	
	
	
	public void EnterCandiateID(String candiateId) throws InterruptedException
	{
		CandiateIdTextBOx.clear();
		Thread.sleep(3000);
		CandiateIdTextBOx.sendKeys(candiateId);
	}
	
	public void  ClickOnApply() throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ApplyClickButton);
		//ApplyClickButton.click();
	}
	
	public void ClickOnCandiateIdCheckBox() throws InterruptedException
	{   
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", CandiateCheckBox);
		//CandiateCheckBox.click();
	}
	public void ClickOnBAndLCheckBox() throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", BAndLCheckBox);
		//BAndLCheckBox.click();
	}
	public void SelectModelOfBandL(String Self) throws InterruptedException
	{
		Thread.sleep(3000);
		SelectDropDownList.selectDropDownListByVisibleText(ModelofBAndLDropDownList, Self);
	}
	public void SelectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(StateDropDownList, state);
	}
	
	public void Selectdistric(String distric)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, distric);
	}
}
