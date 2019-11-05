package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class TP_MySchemeDashboardPage 
{
	
	WebDriver driver;
	public TP_MySchemeDashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".btn.m-btn--pill.btn-primary.tab-color-blue")
	private WebElement addSchemeButton;
	
	@FindBy(xpath="//tr[td[span[span[text()='NON-PMKVY']]]]//a[i[@class='la la-ellipsis-h']]")
	private WebElement ActionIcon;
	
	@FindBy(xpath="//tr[td[span[span[text()='NON-PMKVY']]]]//a[contains(text(),'Add Program')]")
	private WebElement Add_program;
	
	@FindBy(xpath="//select[option[text()='Select Financial Model Type']]")
	private WebElement SelectFinancialModelType_dropdownlist;
	
	@FindBy(xpath="//input[@placeholder='Select Agreement Date']")
	private WebElement AggrementDate;

//	@FindBy(xpath="(//tr//th[@class='datepicker-switch'])[1]")
//	private WebElement monthDropdownList;
//	@FindBy(xpath="(//tr//th[@class='next'])[1]")
//	private WebElement yearDropdownList;
	
	@FindBy(xpath="//div[@class='datepicker-days']//tr[3]//td[5]")
	private WebElement selectDate;
	@FindBy(xpath="//input[@placeholder='Select First Disbursement Date']")
	private WebElement FirstDisbursementDate;
	@FindBy(xpath="//input[@placeholder='Enter Project Proposal ID']")
	private WebElement ProjectProosalID;
	
	
	@FindBy(xpath="//input[@placeholder='Enter Project Name']")
	private WebElement Project_NameTextBox;
	@FindBy(xpath="//input[@placeholder='Enter Number of people who will be trained']")
	private WebElement TargetTextbox;
	
	@FindBy(xpath="//select[@id='assessmentMode']")
	private WebElement AssessmentModeDropdownlist;
	

	@FindBy(xpath="//input[@placeholder='Enter Sanction Loan Amount(in lakhs)']")
	private WebElement SanctionLoanAmountTextBox;
	
	@FindBy(xpath="//select[@id='moratoriumPeriod']")
	private WebElement MoratoriumPeriodDropDownlist;
	//////////////////
	
	@FindBy(xpath="//select[@id='loanDuration']")
	private WebElement LoanDurationDropDownlist;
	@FindBy(xpath="//select[@id='interestRate']")
	private WebElement InterestRateDropDownlist;
	@FindBy(xpath="(//label[@for='customFile'])[1]")
	private WebElement SignedTermSheetBrowser;
	
	
	public void clickOnAddSchemeOrProgram()
	{
		addSchemeButton.click();
	}
	
	public void ClickOnAction()
	{
		ActionIcon.click();
	}
  public void ClickOnAddProgram()
  {
	  Add_program.click();
  }
  public void SelectFinancialModelType(String Funded)
  {
	  SelectDropDownList.selectDropDownListByVisibleText(SelectFinancialModelType_dropdownlist, Funded);
  }
  public void ClickAggrementDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(AggrementDate).click().build().perform();
	}

//  public void SelectAggrementDate(String aggrementDate) throws InterruptedException 
//	{
//		Thread.sleep(3000);
//		ToT_ToA_Batch_DatePicker.chooseDate(driver, aggrementDate, AggrementDate, monthDropdownList, yearDropdownList);
//		
//	}
	
  public void ClickOnDate()
  {
	  selectDate.click();
  }
//  
  
  
  
 public void CliCkOnFirstDisbursementDate()
 {
	 FirstDisbursementDate.click();
 }
// public void SelectFirstDisbursementDate(String DisbursementDate) throws InterruptedException 
//	{
//		
//		ToT_ToA_Batch_DatePicker.chooseDate(driver, DisbursementDate, FirstDisbursementDate, monthDropdownList, yearDropdownList);
//		
//	}
  public void EnterProjectProosalID(String ProjectID)
  {
	  ProjectProosalID.sendKeys(ProjectID);
  }
  
  public void EnterProject_Name(String ProjectName)
  {
	  ProjectProosalID.sendKeys(ProjectName);
  }
  public void EnterNumberOfTrainedPeople(String trainedPeople)
  {
	  TargetTextbox.sendKeys(trainedPeople);
  }
   public void SelectAssessmentMode()
   {
	   SelectDropDownList.selectmultipleoptions(AssessmentModeDropdownlist);
   }
   public void EnterSanctionLoanAmount(String sanctionLoanAmount)
   {
	   SanctionLoanAmountTextBox.sendKeys(sanctionLoanAmount);
   }
   /////////////////
    public void SelectMoratoriumPeriod(String moratoriumPeriods)
    {
    	SelectDropDownList.selectDropDownListByValue(MoratoriumPeriodDropDownlist, moratoriumPeriods);
    }
    public void SelectLoanDurationDropDownlist(String loanduration)
    {
    	SelectDropDownList.selectDropDownListByValue(LoanDurationDropDownlist, loanduration);
    }
    public void SelectInterestRateDropDownlist(String interestRate)
    {
    	SelectDropDownList.selectDropDownListByValue(InterestRateDropDownlist, interestRate);
    }
    
    
    public void ClickonSignedTermSheet()
    {
    	SignedTermSheetBrowser.click();
    }
}
