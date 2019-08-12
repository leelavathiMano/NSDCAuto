package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySchemeOrProjectPage {

	 WebDriver driver;
	    
	    @FindBy(xpath="//*[contains(text(),'Apply Scheme/Program')]")
	    private WebElement ApplySchemeProgram;
	
	    public MySchemeOrProjectPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	

	    public void ClickApplySchemeProgram() throws Exception
	    {
	        
	    	ApplySchemeProgram.click();
	    }
	    
	    
	
}
