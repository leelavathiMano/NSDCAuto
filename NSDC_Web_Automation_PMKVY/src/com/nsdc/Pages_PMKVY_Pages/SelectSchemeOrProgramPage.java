package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectSchemeOrProgram {


		 WebDriver driver;
		    
		    @FindBy(xpath="//a[contains(text(),'4')]")
		    private WebElement PageNumber4;
		
		    public SelectSchemeOrProgram(WebDriver driver)
		    {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }
		

		    public void ClickPageNumber4() throws Exception
		    {
		        
		    	PageNumber4.click();
		    }
		    
		    
		
	}

	
