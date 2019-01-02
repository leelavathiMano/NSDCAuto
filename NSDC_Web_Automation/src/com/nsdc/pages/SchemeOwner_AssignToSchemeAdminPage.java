package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeOwner_AssignToSchemeAdminPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/a[@href='#']")
	private WebElement rplActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/div/span[contains(text(),' Assign Scheme')]")
	private WebElement rplAssignSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/a[@href='#']")
	private WebElement sttActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/div/span[contains(text(),' Assign Scheme')]")
	private WebElement sttAssignSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/a[@href='#']")
	private WebElement indiaInternalActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/div/span[contains(text(),' Assign Scheme')]")
	private WebElement indiaInternalAssignSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/a[@href='#']")
	private WebElement specialProjectActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/div/span[contains(text(),' Assign Scheme')]")
	private WebElement specialProjectAssignSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/a[@href='#']")
	private WebElement othersActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/div/span[contains(text(),' Assign Scheme')]")
	private WebElement othersAssignSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/a[@href='#']")
	private WebElement nonPMKVYActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/div/span[contains(text(),' Assign Scheme')]")
	private WebElement nonPMKVYAssignSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/a[@href='#']")
	private WebElement integrationActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/div/span[contains(text(),' Assign Scheme')]")
	private WebElement integrationAssignSchemeButton;
	
	 public SchemeOwner_AssignToSchemeAdminPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void clickOnRplAction()
		{
	    	rplActionButton.click();
		}
		
	    public void clickOnRplAssignScheme()
	    {
	    	rplAssignSchemeButton.click();
	    }
	    
	    public void clickOnSTTAction()
		{
	    	sttActionButton.click();
		}
		
	    public void clickOnSTTAssignScheme()
	    {
	    	sttAssignSchemeButton.click();
	    }
	
	    public void clickOnIndiaInternalAction()
		{
	    	indiaInternalActionButton.click();
		}
		
	    public void clickOnIndiaInternalAssignScheme()
	    {
	    	indiaInternalAssignSchemeButton.click();
	    }
	
	    public void clickOnSpecialProjectAction()
		{
	    	specialProjectActionButton.click();
		}
		
	    public void clickOnSpecialProjectAssignScheme()
	    {
	    	specialProjectAssignSchemeButton.click();
	    }
	
	    public void clickOnOthersAction()
	  	{
	  	   othersActionButton.click();
	  	}
	  		
	  	 public void clickOnOthersAssignScheme()
	  	 {
	  	    othersAssignSchemeButton.click();
	  	 }
	
	  	 public void clickOnNonPMKVYAction()
		 {
		    nonPMKVYActionButton.click();
		 }
			
		 public void clickOnNonPMKVYAssignScheme()
		 {
		   nonPMKVYAssignSchemeButton.click();
		 }
	
		 public void clickOnIntegrationAction()
		 {
		    integrationActionButton.click();
		 }
			
		  public void clickOnIntegrationAssignScheme()
		   {
		     integrationAssignSchemeButton.click();
		   }
	
	
	
}
