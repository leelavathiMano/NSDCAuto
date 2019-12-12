package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMKVY_SP_ApprovalInprogress_Additionaldetails_Page 
{
	WebDriver driver;
     @FindBy(xpath="(//a[@data-toggle='dropdown'])[1]")
     private WebElement ActionButton;
     @FindBy(xpath="(//a[contains(text(),'Additional Details Required')])[1]")
     private WebElement AdditionalDetailsRequried_ActionButton;
     
     public PMKVY_SP_ApprovalInprogress_Additionaldetails_Page(WebDriver driver)
     {
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
     }
     public void ClickOn_Action()
     {
    	 ActionButton.click();
     }
     public void Click_AdditionalDetailsRequried_Action()
     {
    	 AdditionalDetailsRequried_ActionButton.click();
     }
}
