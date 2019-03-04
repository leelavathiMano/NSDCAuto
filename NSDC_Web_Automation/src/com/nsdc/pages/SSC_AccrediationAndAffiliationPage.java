package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_AccrediationAndAffiliationPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[p[text()='Accreditation & Affiliation']]")
	private WebElement allAffiliationsCAAFButton;
	@FindBy(xpath="//div[p[text()='All Recommended TCs']]")
	private WebElement allAppealsRecievedButton;
	
	
	public SSC_AccrediationAndAffiliationPage(WebDriver driver)
    {
		
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnAllAffiliationsCAAF()
	{
		allAffiliationsCAAFButton.click();
	}
	
	public void clickOnAllAppealsRecieved()
	{
		allAppealsRecievedButton.click();
	}

}
