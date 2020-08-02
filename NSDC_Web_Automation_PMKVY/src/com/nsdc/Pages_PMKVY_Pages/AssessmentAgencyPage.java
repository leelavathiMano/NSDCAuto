package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AssessmentAgencyPage {
	WebDriver driver;
	 public AssessmentAgencyPage(WebDriver driver)
	    {
	   	 this.driver = driver;
	   	 PageFactory.initElements(driver, this);
	    }
   @FindBy(xpath="//span[Strong[text()='Assessment Requests']]")
   private WebElement AssessmentRequest;
   @FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
   private WebElement ActionIcon;
   
   @FindBy(xpath="(//span[contains(text(),'Accept Batch')])[1]")
   private WebElement AcceptBatchIcon;
   
   @FindBy(xpath="//button[text()='Yes']")
   private WebElement YesButton;
   @FindBy(xpath="//button[text()='OK']")
   private WebElement OkButton;
   
   @FindBy(xpath="//a[contains(text(),'Accepted')]")
   private WebElement AcceptedButton;
   
   @FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
   private WebElement AccetedActionButton;
   @FindBy(xpath="//input[@placeholder='Search by Batch ID']")
   private WebElement BatchIdTextBox;
   @FindBy(xpath="(//span[contains(text(),'Assign Assessor')])[1]")
   private WebElement AssignAssessorIcon;
   @FindBy(xpath="//select[@formcontrolname='assessor']")
   private WebElement SelectAssessorDropDownlist;
   @FindBy(xpath="(//button[@class='btn btn-primary bg-color'])[1]")
	private WebElement submitButton;
   
   ///////////////////////////////saturday
   @FindBy(xpath="//li[a[contains(text(),'Assessed Batch Request')]]")
  	private WebElement AssessedBatchRequest;
   
   @FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
   private WebElement AssessedBatchRequestActionButton;
   
   @FindBy(xpath="(//a[span[contains(text(),'View Batch Details')]])[1]")
   private WebElement  ViewBatchDetailsButton;
   
   @FindBy(xpath="//a[contains(text(),'Assessed Candidates')]")
   private WebElement AA_AssessedCandidatesTab;
   @FindBy(xpath="//button[text()='Approve']")
   private WebElement ApproveButton;
   
   @FindBy(xpath="//button[text()='Send to SSC']")
   private WebElement SendToSSCButton;
   
//  
   
   public void ClickonAssessmentRequest()
   {
	   
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();",AssessmentRequest);
	   //AssessmentRequest.click();
   }
   public void ClickonAction()
   {
	   ActionIcon.click();
   }
   public void ClickonAcceptBatch()
   {
	   AcceptBatchIcon.click();
   }
   public void ClickonYesButton()
   {
	   YesButton.click();
   }
   public void ClickOnOkButton()
   {
   	OkButton.click();
   }
   public void ClickOnAcceptedButton()
   {
	   AcceptedButton.click();
   }
   public void EnterBatchId(String batchid)
   {
	   BatchIdTextBox.sendKeys(batchid);
   }
   public void ClickOnAcceptedAction()
   {
	   AccetedActionButton.click();
   }
   public void ClickOnAssignAssessorIcon()
   {
	   AssignAssessorIcon.click();
   }
   public void SelectAssessor(String AssessorName)
   {
	   SelectDropDownList.selectDropDownListByVisibleText(SelectAssessorDropDownlist, AssessorName);
   }
   
   
   public void ClickOnSubmitButton()
   {
   	submitButton.click();
   }
   
   ///////////////stuarday
   
   public void ClickOnAssessedBatchRequestButton()
   {
	   AssessedBatchRequest.click();
   }
   
   public void ClickOnAssessedBatchRequestActionButton()
   {
	   AssessedBatchRequestActionButton.click();
   }
   public void ClickOnViewBatchDetailsButton()
   {
	   ViewBatchDetailsButton.click();
   }
   public void ClickOnAA_AssessedCandidatesTab()
   {
	   AA_AssessedCandidatesTab.click();
   }
   public void ClickOnApproveButton()
   {
	   ApproveButton.click();
   }
   public void CliCkOnSendToSSC()
   {
	   SendToSSCButton.click();
   }
}
