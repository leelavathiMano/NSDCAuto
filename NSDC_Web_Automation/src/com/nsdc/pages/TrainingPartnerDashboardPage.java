package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingPartnerDashboardPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='./add-tc']")
	private WebElement addTrainingCentreButton;
	
	public TrainingPartnerDashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnAddATrainingCentre()
	{
		addTrainingCentreButton.click();
	}

}
