package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySchemeOrProjectPage {

	 WebDriver driver;
	 private WebDriverWait wait;   
	    @FindBy(xpath="//*[contains(text(),'Apply Scheme/Program')]")
	    private WebElement ApplySchemeProgram;
	
	    public MySchemeOrProjectPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, 30);
	    }
	

	    public void ClickApplySchemeProgram() throws Exception
	    {
	    	Thread.sleep(2000);
	    	wait.until(ExpectedConditions.elementToBeClickable(ApplySchemeProgram)).click();
	    }
	    
	    
	
}