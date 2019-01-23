package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeOwner_InstantialteJobRoleApprovalRequestsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/a[@href='#']")
	private WebElement rplActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/div/span[contains(text(),' Add Qps to scheme')]")
	private WebElement rplAddQpsToSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'RPL')]]/td/span/div/div/span[contains(text(),' View all qps of scheme')]")
	private WebElement rplViewAllQpsOfSchemeButton;
	
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/a[@href='#']")
	private WebElement sttActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/div/span[contains(text(),' Add Qps to scheme')]")
	private WebElement sttAddQpsToSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'STT')]]/td/span/div/div/span[contains(text(),' View all qps of scheme')]")
	private WebElement sttViewAllQpsOfSchemeButton;
	
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/a[@href='#']")
	private WebElement indiaInternalActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/div/span[contains(text(),' Add Qps to scheme')]")
	private WebElement indiaInternalAddQpsToSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'India Internal')]]/td/span/div/div/span[contains(text(),' View all qps of scheme')]")
	private WebElement indiaInternalViewAllQpsOfSchemeButton;
	
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/a[@href='#']")
	private WebElement specialProjectActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/div/span[contains(text(),' Add Qps to scheme')]")
	private WebElement specialProjectAddQpsToSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Special Project')]]/td/span/div/div/span[contains(text(),' View all qps of scheme')]")
	private WebElement specialProjectViewAllQpsOfSchemeButton;
	
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/a[@href='#']")
	private WebElement othersActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/div/span[contains(text(),' Add Qps to scheme')]")
	private WebElement othersAddQpsToSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Others')]]/td/span/div/div/span[contains(text(),' View all qps of scheme')]")
	private WebElement othersViewAllQpsOfSchemeButton;
	
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/a[@href='#']")
	private WebElement nonPMKVYSchemeActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/div/span[contains(text(),' Add Qps to scheme')]")
	private WebElement nonPMKVYSchemeAddQpsToSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/div/span[contains(text(),' View all qps of scheme')]")
	private WebElement nonPMKVYSchemeViewAllQpsOfSchemeButton;
	
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/a[@href='#']")
	private WebElement integrationSchemeActionButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/div/span[contains(text(),' Add Qps to scheme')]")
	private WebElement integrationSchemeAddQpsToSchemeButton;
	@FindBy(xpath="//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/div/span[contains(text(),' View all qps of scheme')]")
	private WebElement integrationSchemeViewAllQpsOfSchemeButton;
	
	 public SchemeOwner_InstantialteJobRoleApprovalRequestsPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void clickOnRplAction()
		{
	    	rplActionButton.click();
		}
		
	    public void clickOnRplAddQpsToScheme()
	    {
	    	rplAddQpsToSchemeButton.click();
	    }
	    
	    public void clickOnRplViewAllQpsOfScheme()
	    {
	    	rplViewAllQpsOfSchemeButton.click();
	    }
	    
	    public void clickOnSTTAction()
		{
	    	sttActionButton.click();
		}
		
	    public void clickOnSTTAddQpsToScheme()
	    {
	    	sttAddQpsToSchemeButton.click();
	    }
        
	    public void clickOnSTTViewAllQpsOfScheme()
	    {
	    	sttViewAllQpsOfSchemeButton.click();
	    }
	    public void clickOnIndiaInternalAction()
		{
	    	indiaInternalActionButton.click();
		}
		
	    public void clickOnIndiaInternalAddQpsToScheme()
	    {
	    	indiaInternalAddQpsToSchemeButton.click();
	    }
	    public void clickOnIndiaInternalViewAllQpsOfScheme()
	    {
	    	indiaInternalViewAllQpsOfSchemeButton.click();
	    }

	    public void clickOnSpecialProjectAction()
		{
	    	specialProjectActionButton.click();
		}
		
	    public void clickOnSpecialProjectAddQpsToScheme()
	    {
	    	specialProjectAddQpsToSchemeButton.click();
	    }
	    
	    public void clickOnSpecialProjectViewAllQpsOfScheme()
	    {
	    	specialProjectViewAllQpsOfSchemeButton.click();
	    }

	    public void clickOnOthersAction()
	  	{
	  	   othersActionButton.click();
	  	}
	  		
	    public void clickOnOthersAddQpsToScheme()
	    {
	    	othersAddQpsToSchemeButton.click();
	    }
	    
	    public void clickOnOthersViewAllQpsOfScheme()
	    {
	    	othersViewAllQpsOfSchemeButton.click();
	    }

	  	 public void clickOnNonPMKVYAction()
		 {
	  		nonPMKVYSchemeActionButton.click();
		 }
			
	  	public void clickOnNonPMKVYAddQpsToScheme()
	    {
	    	nonPMKVYSchemeAddQpsToSchemeButton.click();
	    }
	    
	    public void clickOnNonPMKVYViewAllQpsOfScheme()
	    {
	    	nonPMKVYSchemeViewAllQpsOfSchemeButton.click();
	    }

	    public void clickOnIntegrationAction()
	  	{
	  	    integrationSchemeActionButton.click();
	  	}
	  		
	     public void clickOnIntegrationAddQpsToScheme()
	  	 {
	  	    integrationSchemeAddQpsToSchemeButton.click();
	  	 }
	  	    
	  	 public void clickOnIntegrationViewAllQpsOfScheme()
	  	 {
	  	    integrationSchemeViewAllQpsOfSchemeButton.click();
	  	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
