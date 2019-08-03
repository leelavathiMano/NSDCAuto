package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qpnos_createpage {
	WebDriver driver;
	 //declaration
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[2]")
	private WebElement QPNosmodelCirrculamButton;	
	@FindBy(xpath="(//div[contains(@class,'card-text')])[1]")
	private WebElement createnos;
	
	@FindBy(xpath="(//div[contains(@class,'card-text')])[2]")
	private WebElement viewALLNoss;
	
	@FindBy(xpath="(//div[contains(@class,'card-text')])[3]")
	private WebElement createAqp;
	
	
	@FindBy(xpath="(//div[contains(@class,'card-text')])[4]")
	private WebElement viewallQps;
	
	
	//initialization
	
	public Qpnos_createpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	//utilization	
	
	public void clickQPNosmodelCirrculam()
	{
		QPNosmodelCirrculamButton.click();
	}
	
	public void createNosclick()
	{
		 createnos.click();
	}
	
	public void  clickViewALLNoss() 
	{
		viewALLNoss.click();
	}
	
	public void createqpclick() 
	{
		 createAqp.click();	
	}
	
	public void viewallqpsclick() 
	{
		viewallQps.click();
	}
	
	
}