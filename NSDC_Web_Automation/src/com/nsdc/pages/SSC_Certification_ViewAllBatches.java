package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SSC_Certification_ViewAllBatches 
{
	WebDriver driver;
	
	@FindBy(linkText="Certification not Completed")
	private WebElement certificationNotCompletedButton;
	@FindBy(linkText="Certification Completed")
	private WebElement CertificationCompletedButton;
	@FindBy(xpath="(//select[@name='selectStatus'])[1]")
	private WebElement batchIDDropDownList;
	@FindBy(xpath="(//select[@name='selectStatus'])[2]")
	private WebElement schemeNameDropDownList;
	@FindBy(xpath="//input[@placeholder='Search for the date']")
	private WebElement certificationDateTextbox;
	@FindBy(xpath="//input[@placeholder='All']")
	private WebElement searchKeywordTextbox;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	
	
	public SSC_Certification_ViewAllBatches(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCertificationNotCompleted()
	{
		certificationNotCompletedButton.click();
	}
	
	public void clickOnCertificationCompleted()
	{
		CertificationCompletedButton.click();
	}
	
	public void selectBatchID(String batchID)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchIDDropDownList, batchID);
	}
	
	public void selectSchemeName(String schemeName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(schemeNameDropDownList, schemeName);
	}
	
	public void enterCertificationDate(String date)
	{
		certificationDateTextbox.clear();
		certificationDateTextbox.sendKeys(date);
	}
	
	public void enterSearchKeyword(String keyword)
	{
		searchKeywordTextbox.clear();
		searchKeywordTextbox.sendKeys(keyword);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	

}
