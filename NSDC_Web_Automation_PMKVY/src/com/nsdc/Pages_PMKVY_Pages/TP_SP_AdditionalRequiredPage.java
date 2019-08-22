package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_SP_AdditionalRequiredPage {
	WebDriver driver;
    @FindBy(xpath="(//input[@id='customFile'])[1]")
    private WebElement Dual_logoBrowseButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
    private WebElement Dual_logoUpLoadButton;
    @FindBy(xpath="(//input[@id='customFile'])[2]")
    private WebElement Signed_TermSheetBrowseButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
    private WebElement Signed_TermSheetUpLoadButton;
    
    @FindBy(xpath="//select[@formcontrolname='status']")
    private WebElement   ReviewDropDownList;
    @FindBy(xpath="//button[text()='Download Termsheet']")
    private WebElement  DownloadTermsheetButton;
    
    @FindBy(xpath="//button[text()='Save & Submit']")
    private WebElement   SaveAndSubmitButton;
    
    
    public TP_SP_AdditionalRequiredPage(WebDriver driver)
    {
   	 this.driver = driver;
   	 PageFactory.initElements(driver, this);
    }

    public void ClickOnDual_logoBrowse()
    {
    	Dual_logoBrowseButton.click();
    }
    public void ClickOnDual_logoUpLoad()
    {
    	Dual_logoUpLoadButton.click();
    }
    public void ClickSigned_TermSheetBrowse()
    {
    	Signed_TermSheetBrowseButton.click();
    }
    public void clickSigned_TermSheetUpLoad()
    {
    	Signed_TermSheetUpLoadButton.click();
    }
    public void SelectReview(String review)
    
    {
    	SelectDropDownList.selectDropDownListByVisibleText(ReviewDropDownList, review);
    }
 public void SelectComments(String comments)
    
    {
    	SelectDropDownList.selectDropDownListByVisibleText(ReviewDropDownList, comments);
    }
 public void ClickOnDownloadTermsheet()
 {
	 DownloadTermsheetButton.click();
 }
    public void ClickSaveAndSubmit()
    {
    	SaveAndSubmitButton.click();
    }
    
}
