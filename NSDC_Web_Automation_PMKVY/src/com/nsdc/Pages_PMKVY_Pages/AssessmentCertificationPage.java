package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AssessmentCertificationPage {
	WebDriver driver;
	 public AssessmentCertificationPage(WebDriver driver)
	    {
	   	 this.driver = driver;
	   	 PageFactory.initElements(driver, this);
	    }
    @FindBy(xpath="(//span[@class='m-menu__link-text'])[5]")
    private WebElement AssessmentCertificationIcon;
    @FindBy(xpath="//div[p[text()='Batches Assigned']]")
    private WebElement BatchAssignedIcon;
    
    @FindBy(xpath="//li[a[contains(text(),'Accepted')]]")
    private WebElement AcceptedIcon;
    
    @FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
    private WebElement ActionIcon;
    @FindBy(xpath="(//a[contains(text(),'Assign Assessment Agency')])[1]")
    private WebElement AssignAssessmentAgency;
    
    
    
    @FindBy(xpath="(//select[@formcontrolname='aaId'])[1]")
	private WebElement AAselectDropDownlist;
	@FindBy(xpath="(//button[text()='Submit'])[2]")
	private WebElement submitButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement OkButton;
    
	
	
    public void ClickOnAssessmentCertification()
    {
    	AssessmentCertificationIcon.click();
    }
    public void ClickOnBatchAssigned()
    {
    	BatchAssignedIcon.click();
    }
    public void ClickOnAcceptedIcon()
    {
    	AcceptedIcon.click();
    }
    
    public void ClicKonAction()
    {
    	ActionIcon.click();
    }
    public void ClickOnAssignAssessmentAgency()
    {
    	AssignAssessmentAgency.click();
    }
    public void SelectAAId(String AAId)
    {
    	SelectDropDownList.selectDropDownListByValue(AAselectDropDownlist, AAId);
    }
    public void ClickOnSubmitButton()
    {
    	submitButton.click();
    }
    public void ClickOnOkButton()
    {
    	OkButton.click();
    }
}
