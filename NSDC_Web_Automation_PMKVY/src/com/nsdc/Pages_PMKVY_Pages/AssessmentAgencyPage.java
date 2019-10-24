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
   
   @FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
   private WebElement AccetedActionButton;
   @FindBy(xpath="(//span[contains(text(),'Assign Assessor')])[1]")
   private WebElement AssignAssessorIcon;
   @FindBy(xpath="//select[@formcontrolname='assessor']")
   private WebElement SelectAssessorDropDownlist;
   
   
   
   @FindBy(xpath="(//button[@class='btn btn-primary bg-color'])[1]")
	private WebElement submitButton;
   public void ClickonAssessmentRequest()
   {
	   
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();",AssessmentRequest );
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
}
