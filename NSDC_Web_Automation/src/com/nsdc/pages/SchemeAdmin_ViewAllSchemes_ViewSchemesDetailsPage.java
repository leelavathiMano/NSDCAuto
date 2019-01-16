package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeAdmin_ViewAllSchemes_ViewSchemesDetailsPage 
{
    WebDriver driver;
    
    //View Schemes Details First Page
    
    @FindBy(xpath="//button[contains(text(),'Next')]")
    private WebElement next1Button;
	@FindBy(xpath="//button[contains(text(),'Previous')]")
	private WebElement previous1Button;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancel1Button;
	
	 //View Schemes Details Second Page
	
	 @FindBy(xpath="//button[contains(text(),'Next')]")
	 private WebElement next2Button;
	 @FindBy(xpath="//button[contains(text(),'Previous')]")
	 private WebElement previous2Button;
	 @FindBy(xpath="//button[contains(text(),'Cancel')]")
	 private WebElement cancel2Button;
	  
	 //View Schemes Details Third Page
		
	 @FindBy(xpath="//button[contains(text(),'Next')]")
	 private WebElement next3Button;
	 @FindBy(xpath="//button[contains(text(),'Previous')]")
	 private WebElement previous3Button;
	 @FindBy(xpath="//button[contains(text(),'Cancel')]")
	 private WebElement cancel3Button;
	 
	 
	 //View Schemes Details Third Page
		
     @FindBy(xpath="//button[contains(text(),'Submit')]")
	 private WebElement submitButton;
     @FindBy(xpath="//button[contains(text(),'OK')]")
	 private WebElement okButton;
    
    public SchemeAdmin_ViewAllSchemes_ViewSchemesDetailsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    //View Schemes Details First Page
    
    public void clickOnNext1()
	{
    	next1Button.click();
	}
	
    public void clickOnPrevious1()
   	{
    	previous1Button.click();
   	}
    
    public void clickOnCancel1()
	{
    	cancel1Button.click();
	}
	
    //View Schemes Details Second Page
    
    public void clickOnNext2()
	{
    	next2Button.click();
	}
	
    public void clickOnPrevious2()
   	{
    	previous2Button.click();
   	}
    
    public void clickOnCancel2()
	{
    	cancel2Button.click();
	}
    

    //View Schemes Details Third Page
    
    public void clickOnNext3()
	{
    	next3Button.click();
	}
	
    public void clickOnPrevious3()
   	{
    	previous3Button.click();
   	}
    
    public void clickOnCancel3()
	{
    	cancel3Button.click();
	}
    
    //View Schemes Details Fourth Page
    
    public void clickOnSubmit()
	{
    	submitButton.click();
	}
  		
    public void clickOnOk()
  	{
      	okButton.click();
  	}
}
    
    
    
    
