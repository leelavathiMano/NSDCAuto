package com.nsdc.RegressionTest_NON_PMKVY_STT_Test;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.Pages_NON_PMKVY_Pages.BetaVersionOfSmartPage;
import com.nsdc.Pages_NON_PMKVY_Pages.EnterLoginPage;
import com.nsdc.Pages_NON_PMKVY_Pages.LaunchPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TP_MySchemeDashboardPage;
import com.nsdc.Pages_NON_PMKVY_Pages.TrainingPartnerDashboardPage;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.testConfig.TestConfiguration;

public class Feebased_AddschemeworkFlowTest extends TestConfiguration {
	@DataProvider
	public Object[][] addScheme_FeeBased() {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/Feebased_addschme_workflow/feebased_addscheme_workflowData.xls",
				"feebasedaddscheme");
	}
		@Test(dataProvider="addScheme_FeeBased")
		public void addSchemeTC_01(String tpUsername, String tpPassword,String schemeName,String Funded,
				String aggrementDate,String DisbursementDate,String ProjectID,String ProjectName,
				String trainedPeople,String sanctionLoanAmount,String moratoriumPeriods,String loanduration,String interestRate,String img) throws Exception
		{
		
			precondition();
			LaunchPage lp = new LaunchPage(driver);
			lp.clickLogin();
		Thread.sleep(3000);
			BetaVersionOfSmartPage bsp = new BetaVersionOfSmartPage(driver);
			bsp.clickToClose();
			Thread.sleep(3000);
			EnterLoginPage elp = new EnterLoginPage(driver);
			elp.performlogin(tpUsername, tpPassword);
		
			TrainingPartnerDashboardPage tpd = new TrainingPartnerDashboardPage(driver);
			Thread.sleep(10000);
			tpd.clickOnMySchemes();
			//////////////////////////////
			
//			WebDriver driver;
//			public TP_MySchemeDashboardPage(WebDriver driver) 
//			{
//				this.driver = driver;
//				PageFactory.initElements(driver, this);
//			}
//			@FindBy(css=".btn.m-btn--pill.btn-primary.tab-color-blue")
//			private WebElement addSchemeButton;
//			
//			@FindBy(xpath="//tr[td[span[span[text()='NON-PMKVY']]]]//a[i[@class='la la-ellipsis-h']]")
//			private WebElement ActionIcon;
//			
//			@FindBy(xpath="//tr[td[span[span[text()='NON-PMKVY']]]]//a[contains(text(),'Add Program')]")
//			private WebElement Add_program;
//			
//			@FindBy(xpath="//select[option[text()='Select Financial Model Type']]")
//			private WebElement SelectFinancialModelType_dropdownlist;
//			
//			@FindBy(xpath="//input[@placeholder='Select Agreement Date']")
//			private WebElement AggrementDate;
//
////			@FindBy(xpath="(//tr//th[@class='datepicker-switch'])[1]")
////			private WebElement monthDropdownList;
////			@FindBy(xpath="(//tr//th[@class='next'])[1]")
////			private WebElement yearDropdownList;
//			
//			@FindBy(xpath="//div[@class='datepicker-days']//tr[3]//td[5]")
//			private WebElement selectDate;
//			@FindBy(xpath="//input[@placeholder='Select First Disbursement Date']")
//			private WebElement FirstDisbursementDate;
//			@FindBy(xpath="//input[@placeholder='Enter Project Proposal ID']")
//			private WebElement ProjectProosalID;
//			
//			
//			@FindBy(xpath="//input[@placeholder='Enter Project Name']")
//			private WebElement Project_NameTextBox;
//			@FindBy(xpath="//input[@placeholder='Enter Number of people who will be trained']")
//			private WebElement TargetTextbox;
//			
//			@FindBy(xpath="//select[@id='assessmentMode']")
//			private WebElement AssessmentModeDropdownlist;
//			
//
//			@FindBy(xpath="//input[@placeholder='Enter Sanction Loan Amount(in lakhs)']")
//			private WebElement SanctionLoanAmountTextBox;
//			
//			@FindBy(xpath="//select[@id='moratoriumPeriod']")
//			private WebElement MoratoriumPeriodDropDownlist;
//			//////////////////
//			
//			@FindBy(xpath="//select[@id='loanDuration']")
//			private WebElement LoanDurationDropDownlist;
//			@FindBy(xpath="//select[@id='interestRate']")
//			private WebElement InterestRateDropDownlist;
//			//////////////////////////////////////
//			@FindBy(xpath="//label[contains(text(),'Signed Termsheets:')]/..//input[@id='customFile']")
//			private WebElement SignedTermSheetBrowser;
//			@FindBy(xpath="//label[contains(text(),'Signed Termsheets:')]/..//button[contains(text(),'Upload')]")
//			private WebElement SignedTermSheetBrowserUPLoadButton;
//			
//			
//			@FindBy(xpath="//label[contains(text(),'Signed Agreement:')]/..//input[@id='customFile']")
//			private WebElement SignedAgreementBrowser;
//			@FindBy(xpath="//label[contains(text(),'Signed Agreement:')]/..//button[contains(text(),'Upload')]")
//			private WebElement SignedAgreementBrowser_UploadButton;
//			
//			@FindBy(xpath="//button[contains(text(),'Add Sector')]")
//			private WebElement Add_Sector_Button;
//			
//			//button[contains(text(),'Add Sector')]
//			public void clickOnAddSchemeOrProgram()
//			{
//				addSchemeButton.click();
//			}
//			
//			public void ClickOnAction()
//			{
//				ActionIcon.click();
//			}
//		  public void ClickOnAddProgram()
//		  {
//			  Add_program.click();
//		  }
//		  public void SelectFinancialModelType(String Funded)
//		  {
//			  SelectDropDownList.selectDropDownListByVisibleText(SelectFinancialModelType_dropdownlist, Funded);
//		  }
//		  public void ClickAggrementDate() throws InterruptedException 
//			{
//				Thread.sleep(2000);
//				  Actions actions = new Actions(driver); 
//				  actions.moveToElement(AggrementDate).click().build().perform();
//			}
//
//		//  public void SelectAggrementDate(String aggrementDate) throws InterruptedException 
////			{
////				Thread.sleep(3000);
////				ToT_ToA_Batch_DatePicker.chooseDate(driver, aggrementDate, AggrementDate, monthDropdownList, yearDropdownList);
////				
////			}
//			
//		  public void ClickOnDate()
//		  {
//			  selectDate.click();
//		  }
//		//  
//		  
//		  
//		  
//		 public void CliCkOnFirstDisbursementDate()
//		 {
//			 FirstDisbursementDate.click();
//		 }
//		// public void SelectFirstDisbursementDate(String DisbursementDate) throws InterruptedException 
////			{
////				
////				ToT_ToA_Batch_DatePicker.chooseDate(driver, DisbursementDate, FirstDisbursementDate, monthDropdownList, yearDropdownList);
////				
////			}
//		  public void EnterProjectProosalID(String ProjectID)
//		  {
//			  ProjectProosalID.sendKeys(ProjectID);
//		  }
//		  
//		  public void EnterProject_Name(String ProjectName)
//		  {
//			  ProjectProosalID.sendKeys(ProjectName);
//		  }
//		  public void EnterNumberOfTrainedPeople(String trainedPeople)
//		  {
//			  TargetTextbox.sendKeys(trainedPeople);
//		  }
//		   public void SelectAssessmentMode()
//		   {
//			   SelectDropDownList.selectmultipleoptions(AssessmentModeDropdownlist);
//		   }
//		   public void EnterSanctionLoanAmount(String sanctionLoanAmount)
//		   {
//			   SanctionLoanAmountTextBox.sendKeys(sanctionLoanAmount);
//		   }
//		   /////////////////
//		    public void SelectMoratoriumPeriod(String moratoriumPeriods)
//		    {
//		    	SelectDropDownList.selectDropDownListByVisibleText(MoratoriumPeriodDropDownlist, moratoriumPeriods);
//		    	
//		    }
//		    public void SelectLoanDurationDropDownlist(String loanduration)
//		    {
//		    	SelectDropDownList.selectDropDownListByVisibleText(LoanDurationDropDownlist, loanduration);
//		    	
//		    }
//		    public void SelectInterestRateDropDownlist(String interestRate)
//		    {
//		    	SelectDropDownList.selectDropDownListByVisibleText(InterestRateDropDownlist, interestRate);
//		    	
//		    }
//		    
//		    
//		    public void ClickonSignedTermSheet()
//		    {
//		    	SignedTermSheetBrowser.click();
//		    }
//		    public void ClickOnSignedTermSheetBrowserUPLoadButton()
//		    {
//		    	SignedTermSheetBrowserUPLoadButton.click();
//		    }
//		    public void ClickonSignedAgreementBrowser()
//		    {
//		    	SignedAgreementBrowser.click();
//		    }
//		    public void ClickOnSignedAgreementBrowser_UploadButton()
//		    {
//		    	SignedAgreementBrowser_UploadButton.click();
//		    }
//		    public void ClickOnAddSectorButton()
//		    {
//		    	Add_Sector_Button.click();
//		    }
//		}
//
//			
//			
			//////////////////////////////////
			TP_MySchemeDashboardPage tpms = new TP_MySchemeDashboardPage(driver);
			Thread.sleep(3000);
			tpms.clickOnAddSchemeOrProgram();
			Thread.sleep(3000);
            tpms.ClickOnAction();
			tpms.ClickOnAddProgram();
//			tpms.SelectFinancialModelType(Funded);
//			tpms.ClickAggrementDate();
//		
//		//tpms.SelectAggrementDate(aggrementDate);
//		tpms.ClickOnDate();	
//		tpms.CliCkOnFirstDisbursementDate();
//		//tpms.SelectFirstDisbursementDate(DisbursementDate);
//		tpms.ClickOnDate();
//		tpms.EnterProjectProosalID(ProjectID);
//		tpms.EnterProject_Name(ProjectName);
//		tpms.EnterNumberOfTrainedPeople(trainedPeople);
//		tpms.SelectAssessmentMode();
//		tpms.EnterSanctionLoanAmount(sanctionLoanAmount);
//		tpms.SelectMoratoriumPeriod(moratoriumPeriods);
//		tpms.SelectLoanDurationDropDownlist(loanduration);
//		tpms.SelectInterestRateDropDownlist(interestRate);
//		Thread.sleep(1000);
//		tpms.ClickonSignedTermSheet();
//		Thread.sleep(1000);
//		UploadFile.upload(img);
//		Thread.sleep(1000);
//		tpms.ClickOnSignedTermSheetBrowserUPLoadButton();
//		Thread.sleep(2000);
//		tpms.ClickonSignedAgreementBrowser();
//		Thread.sleep(1000);
//		UploadFile.upload(img);
//		Thread.sleep(3000);
//		tpms.ClickOnSignedAgreementBrowser_UploadButton();
//		Thread.sleep(1000);
//		tpms.ClickOnAddSectorButton();
	}
 

}
