package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RPL_dashboardpage {
	 WebDriver driver;
	    
	    @FindBy(xpath="//div[p[text()='View RPL Type I, II, III ,V Scheme Add Requests']]")
	    private WebElement RPLSchemeAddrequestTab;
	    public RPL_dashboardpage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	  public void ClicKOnRPLSchemeAddrequest()
	  
	  {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();",RPLSchemeAddrequestTab );
		 // RPLSchemeAddrequestTab.click();
	  }
	    
}


