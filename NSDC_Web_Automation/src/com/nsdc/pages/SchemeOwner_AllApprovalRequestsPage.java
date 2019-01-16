package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeOwner_AllApprovalRequestsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/a[@href='#']")
	private WebElement rplActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/div/span[contains(text(),' Approve/Reject Scheme')]")
	private WebElement rplApproveOrRejectSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/a[@href='#']")
	private WebElement sttActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/div/span[contains(text(),' Approve/Reject Scheme')]")
	private WebElement sttApproveOrRejectSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/a[@href='#']")
	private WebElement indiaInternalActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/div/span[contains(text(),' Approve/Reject Scheme')]")
	private WebElement indiaInternalApproveOrRejectSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/a[@href='#']")
	private WebElement specialProjectActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/div/span[contains(text(),' Approve/Reject Scheme')]")
	private WebElement specialProjectApproveOrRejectSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/a[@href='#']")
	private WebElement othersActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/div/span[contains(text(),' Approve/Reject Scheme')]")
	private WebElement othersApproveOrRejectSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/a[@href='#']")
	private WebElement nonPMKVYActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/div/span[contains(text(),' Approve/Reject Scheme')]")
	private WebElement nonPMKVYApproveOrRejectSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/a[@href='#']")
	private WebElement integrationActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/div/span[contains(text(),' Approve/Reject Scheme')]")
	private WebElement integrationApproveOrRejectSchemeButton;
	
	 public SchemeOwner_AllApprovalRequestsPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void clickOnRplAction()
		{
	    	rplActionButton.click();
		}
		
	    public void clickOnRplApproveOrRejectScheme()
	    {
	    	rplApproveOrRejectSchemeButton.click();
	    }
	    
	    public void clickOnSTTAction()
		{
	    	sttActionButton.click();
		}
		
	    public void clickOnSTTApproveOrRejectScheme()
	    {
	    	sttApproveOrRejectSchemeButton.click();
	    }
	
	    public void clickOnIndiaInternalAction()
		{
	    	indiaInternalActionButton.click();
		}
		
	    public void clickOnIndiaInternalApproveOrRejectScheme()
	    {
	    	indiaInternalApproveOrRejectSchemeButton.click();
	    }
	
	    public void clickOnSpecialProjectAction()
		{
	    	specialProjectActionButton.click();
		}
		
	    public void clickOnSpecialProjectApproveOrRejectScheme()
	    {
	    	specialProjectApproveOrRejectSchemeButton.click();
	    }
	
	    public void clickOnOthersAction()
	  	{
	  	   othersActionButton.click();
	  	}
	  		
	  	 public void clickOnOthersApproveOrRejectScheme()
	  	 {
	  	    othersApproveOrRejectSchemeButton.click();
	  	 }
	
	  	 public void clickOnNonPMKVYAction()
		 {
		    nonPMKVYActionButton.click();
		 }
			
		 public void clickOnNonPMKVYApproveOrRejectScheme()
		 {
		   nonPMKVYApproveOrRejectSchemeButton.click();
		 }
	
		 public void clickOnIntegrationAction()
		 {
		    integrationActionButton.click();
		 }
			
		  public void clickOnIntegrationApproveOrRejectScheme()
		   {
		     integrationApproveOrRejectSchemeButton.click();
		   }
	
	
	
}
