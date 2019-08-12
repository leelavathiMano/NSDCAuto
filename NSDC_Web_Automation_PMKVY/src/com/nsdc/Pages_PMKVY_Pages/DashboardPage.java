package com.nsdc.Pages_PMKVY_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	 WebDriver driver;
	    
	    @FindBy(xpath="//div[@routerlink='./my-schemes']")
	    private WebElement MySchemesAndPrograms;
	
	    public DashboardPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	    
	    public void ClickMySchemeOrPrograms() throws Exception
	    {
	        
	    	MySchemesAndPrograms.click();
	    }
	    
	    
}
