package com.nsdc.Pages_PMKVY_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    ////////////////////////
	@FindBy(xpath="//div[p[text()='Result Verification']]")
	private WebElement Result_Verification_Button;
	
	
	@FindBy(xpath="//input[@placeholder='Search by Batch ID']")
	private WebElement BatchID_TextBox;
	
	
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement Apply_Button;
	
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])")
	private WebElement SSC_ActionIcon;
	
	@FindBy(xpath="(//span[@class='m-nav__link-text hover-padding'])[5]")
	private WebElement View_Batch_Details;
	
	@FindBy(xpath="//a[h5[contains(text(),'Assessed Candidates')]]")
	private WebElement AssessedCandidatesIcon;
	@FindBy(xpath="//tbody//tr//th//label//span")
	private WebElement CheckBox;
	
	@FindBy(xpath="//div//button[text()='Approve']")
	private WebElement ApproveButton;
	@FindBy(xpath="//button[text()='Approve for Certification']")
	private WebElement ApproveForCertification;
	
	
	
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
    //////////////////
    public void ClickOnResult_Verification()
    {
    	Result_Verification_Button.click();
    }
    
   public  void EnterTheBatchId(String batchId)
   {
	   BatchID_TextBox.sendKeys(batchId);
   }
  
   public void ClickOnApplyButton()
   {
	   Apply_Button.click();
   }
   public void ClickOnSSC_Action()
   {
	   SSC_ActionIcon.click();
   }
public void ClickOnView_Batch_Details()
{
	View_Batch_Details.click();
}
public  void ClickOnAssessedCandidates()
{
	AssessedCandidatesIcon.click();
}
  
public void ClickOnCheckBox()
{
	CheckBox.click();
}
 public void ClickOnApproveButton()
 {
	 ApproveButton.click();
 }
public void ClickOnApproveForCertification()
{
	ApproveForCertification.click();
}


	}

