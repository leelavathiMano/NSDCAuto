package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeAdmin_ViewAllSchemesPage 
{
    WebDriver driver;
    
    @FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/a[@href='#']")
    private WebElement rplActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/div/span[contains(text(),' View Scheme Details')]")
	private WebElement rplViewSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/a[@href='#']")
	private WebElement sttActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/div/span[contains(text(),' View Scheme Details')]")
	private WebElement sttViewSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/a[@href='#']")
	private WebElement indiaInternalActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/div/span[contains(text(),' View Scheme Details')]")
	private WebElement indiaInternalViewSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/a[@href='#']")
	private WebElement specialProjectActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/div/span[contains(text(),' View Scheme Details')]")
	private WebElement specialProjectViewSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/a[@href='#']")
	private WebElement othersActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/div/span[contains(text(),' View Scheme Details')]")
	private WebElement othersViewSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/a[@href='#']")
	private WebElement nonPMKVYActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/div/span[contains(text(),' View Scheme Details')]")
	private WebElement nonPMKVYViewSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/a[@href='#']")
	private WebElement integrationActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/div/span[contains(text(),' View Scheme Details')]")
	private WebElement integrationViewSchemeButton;
    
    
    public SchemeAdmin_ViewAllSchemesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnRplAction()
	{
    	rplActionButton.click();
	}
	
    public void clickOnRplViewScheme()
    {
    	rplViewSchemeButton.click();
    }
    
    public void clickOnSTTAction()
	{
    	sttActionButton.click();
	}
	
    public void clickOnSTTViewScheme()
    {
    	sttViewSchemeButton.click();
    }

    public void clickOnIndiaInternalAction()
	{
    	indiaInternalActionButton.click();
	}
	
    public void clickOnIndiaInternalViewScheme()
    {
    	indiaInternalViewSchemeButton.click();
    }

    public void clickOnSpecialProjectAction()
	{
    	specialProjectActionButton.click();
	}
	
    public void clickOnSpecialProjectViewScheme()
    {
    	specialProjectViewSchemeButton.click();
    }

    public void clickOnOthersAction()
  	{
  	   othersActionButton.click();
  	}
  		
  	 public void clickOnOthersViewScheme()
  	 {
  	    othersViewSchemeButton.click();
  	 }

  	 public void clickOnNonPMKVYAction()
	 {
	    nonPMKVYActionButton.click();
	 }
		
	 public void clickOnNonPMKVYViewScheme()
	 {
	   nonPMKVYViewSchemeButton.click();
	 }

	 public void clickOnIntegrationAction()
	 {
	    integrationActionButton.click();
	 }
		
	 public void clickOnIntegrationViewScheme()
	 {
		 integrationViewSchemeButton.click();
	 }
}
    
    
    
    
