package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath="(//i[@class='la la-ellipsis-h'])[1]")
    private WebElement ActionIcon;
    @FindBy(xpath="(//button[contains(text(),'Upload')])")
    private WebElement Signed_TermSheetUpLoadButton;
    
    @FindBy(xpath="//select[@formcontrolname='status']")
    private WebElement   ReviewDropDownList;
    @FindBy(xpath="//button[text()='Download Termsheet']")
    private WebElement  DownloadTermsheetButton;
    
    @FindBy(xpath="//button[text()='Save & Submit']")
    private WebElement   SaveAndSubmitButton;
    
    public void ClickOnAssessmentCertification()
    {
    	AssessmentCertificationIcon.click();
    }
    public void ClickOnBatchAssigned()
    {
    	BatchAssignedIcon.click();
    }
    public void ClicKonAction()
    {
    	ActionIcon.click();
    }
    
}
