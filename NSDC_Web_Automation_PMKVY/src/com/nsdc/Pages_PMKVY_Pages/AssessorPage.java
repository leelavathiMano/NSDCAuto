package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessorPage {
	WebDriver driver;
	 public AssessorPage(WebDriver driver)
	    {
	   	 this.driver = driver;
	   	 PageFactory.initElements(driver, this);
	    }
  @FindBy(xpath="(//span[@class='m-menu__link-text'])[2]")
  private WebElement AssessorIcon;
  @FindBy(xpath="//strong[text()=' Assessment Request ']")
  private WebElement AssessmentRequest;
  
  @FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
  private WebElement ActionIcon;
  @FindBy(xpath="(//span[contains(text(),'Accept Batch')])[1]")
  private WebElement AcceptBatchIcon;
  @FindBy(xpath="//button[text()='Yes']")
  private WebElement YesButton;
  
  @FindBy(xpath="//button[text()='OK']")
  private WebElement OkButton;
  
  
  @FindBy(xpath="//li[a[contains(text(),'Assessed Batch Request')]]")
  private WebElement AssessedBatchRequestTAB;
  
  @FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
  private WebElement ARactionIcon;
  
  @FindBy(xpath="(//a[span[contains(text(),'View Details')]])[1]")
  private WebElement AR_ViewDetails;
  
  @FindBy(xpath="//a[span[contains(text(),'Assessed Candidates')]]")
  private WebElement AssessedCandidatesIcon;
  @FindBy(xpath="//button[contains(text(),'Save & Upload')]")
  private WebElement UploadButton;
  ////////
  public void ClickOnAssessor()
  {
	  AssessorIcon.click();
  }
  public void ClickOnAssessmentRequest()
  {
	  AssessmentRequest.click();
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
  ////////////
  
  
  public void ClickonAssessedBatchRequest()
  {
	  AssessedBatchRequestTAB.click();
  }
  public void ClickonARactionIcon()
  {
	  ARactionIcon.click();
  }
  public void ClickonAR_ViewDetails()
  {
	  AR_ViewDetails.click();
  }
  public void ClickOnAssessedCandidatesIcon()
  {
	  AssessedCandidatesIcon.click();
  }
  public void ClickOnUploadButton()
  {
	  UploadButton.click();
  }
}
