package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	 WebDriver driver;
	    
	    @FindBy(xpath="//*[contains(text(),'My Scheme/Program')]")
	    private WebElement MySchemesAndPrograms;
	
	    public DashboardPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void ClickMySchemeOrPrograms() throws Exception
	    {
	        
	    	MySchemesAndPrograms.click();
	    }
	    
	    
}
