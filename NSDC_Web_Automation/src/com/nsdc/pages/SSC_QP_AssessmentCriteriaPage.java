package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_QP_AssessmentCriteriaPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//textarea[@formcontrolname='assmtGuidelns']")
	private WebElement guidelinesForAssessmentTextBox;
	@FindBy(xpath="//button[contains(text(),'Submit Criteria')]")
	private WebElement submitCriteriaButton;
	
	public SSC_QP_AssessmentCriteriaPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterguidelinesForAssessment(String guidelines)
	{
		guidelinesForAssessmentTextBox.clear();
		guidelinesForAssessmentTextBox.sendKeys(guidelines);
	}
	
	public void clickOnSubmitCriteria()
	{
		submitCriteriaButton.click();
	}
	
}
