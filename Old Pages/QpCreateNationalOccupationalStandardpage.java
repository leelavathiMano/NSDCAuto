package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class QpCreateNationalOccupationalStandardpage 
{
	WebDriver driver;
	//declaration
	@FindBy(xpath="//li[contains(@class,'nav-item nos-nav-1')]")
	private WebElement NoofparametersButton;	
	@FindBy(xpath="//app-navigation-tabs//div[2]//li[1]")
	private WebElement elementandPerformanceCriteriaButton;
	@FindBy(xpath="//app-navigation-tabs//div[3]//li[1]")
	private WebElement knowledgeandUnderstandingButton;
	@FindBy(xpath="//div[4]//li[1]")
	private WebElement GenericskillButton;
	@FindBy(xpath="//li[@class='nav-item nos-nav-5']")
	private WebElement AssenmentcriteriaButton;
	@FindBy(xpath="//div[6]//li[1]")
	private WebElement acronymsAndDocumentsButton;
	//
	@FindBy(xpath="//input[@name='sectorName']")
	private WebElement sectortextbox;
	@FindBy(xpath="//div[@class='c-btn']")
	private WebElement subSectorList;
	@FindBy(xpath="//label[text()='Poultry']")
	private WebElement clickpolutry ;
	//
	@FindBy(xpath="//select[@name='option']")
	private WebElement occupationDropDownList;
	@FindBy(xpath="//select[@name='credits']")
	private WebElement creditDropdownList;
	
	@FindBy(xpath="//select[@name='nsqf']")
	private WebElement NsqfLevelDropdownLIst;
	
	@FindBy(xpath="//textarea[@placeholder='Enter NOS Name']")
	private WebElement nosNameTextBox;
	
	@FindBy(xpath="//textarea[@placeholder='Enter NOS Description']")
	private WebElement nosDescriptionTextBox;
	
	
	@FindBy(xpath="//textarea[@placeholder='Enter NOS Scope']")
	private WebElement nosScopeTextBox;
	@FindBy(xpath="//input[@placeholder='Enter the NOS Version(by default it will be 1.0)']")
	private WebElement nosversiontextbox;
	
	@FindBy(xpath="//input[@placeholder='Enter Next Review Period in months from the QRC date']")
	private WebElement nextReviewPeriodTextbox;
	

	@FindBy(xpath="//button[@id='button']")
	private WebElement saveandcontinoubtton;
	
	@FindBy(xpath="(//button[contains(text(),'Save as Draft')])[2]")
	private WebElement saveAsDraftbtton;
	@FindBy(xpath="(//button[contains(text(),'Preview NOS')])[2]")
	private WebElement previousNosbtton;

	//elements and performance criteria
	//insertElement
	@FindBy(xpath="//button[div[text()='Add Another Element']]")
	private WebElement addAnotherElement;
	
	
	
	
	
	//element1:
	@FindBy(xpath="(//input[@formcontrolname='element'])")
	private WebElement element1TextBox;
	@FindBy(xpath="//a[i[@class='la la-save green']]")
	private WebElement  elementSaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[1]")
	private WebElement element1PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[1]")
	private WebElement element1AddPC_Button;
	//element2
	@FindBy(xpath="//a[i[@class='la la-save green']]")
	private WebElement  element2SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[2]")
	private WebElement element2PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[2]")
	private WebElement element2AddPC_Button;
	// Element3
	@FindBy(xpath="(//a[i[@class='la la-save green']])[3]")
	private WebElement  element3SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[3]")
	private WebElement element3PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[3]")
	private WebElement element3AddPC_Button;
	//element4
	@FindBy(xpath="(//a[i[@class='la la-save green']])[4]")
	private WebElement  element4SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[4]")
	private WebElement element4PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[4]")
	private WebElement element4AddPC_Button;
	//element5
	@FindBy(xpath="(//a[i[@class='la la-save green']])[5]")
	private WebElement  element5SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[5]")
	private WebElement element5PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[5]")
	private WebElement element5AddPC_Button;
	//element6
	@FindBy(xpath="(//a[i[@class='la la-save green']])[6]")
	private WebElement  element6SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[6]")
	private WebElement element6PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[6]")
	private WebElement element6AddPC_Button;
	//element7
	@FindBy(xpath="(//a[i[@class='la la-save green']])[7]")
	private WebElement  element7SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[7]")
	private WebElement element7PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[7]")
	private WebElement element7AddPC_Button;
	//element8
	@FindBy(xpath="(//a[i[@class='la la-save green']])[8]")
	private WebElement  element8SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[8]")
	private WebElement element8PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[8]")
	private WebElement element8AddPC_Button;
	//e/ement9
	@FindBy(xpath="(//a[i[@class='la la-save green']])[9]")
	private WebElement  element9SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[9]")
	private WebElement element9PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[9]")
	private WebElement element9AddPC_Button;
	//element10
	@FindBy(xpath="(//a[i[@class='la la-save green']])[10]")
	private WebElement  element10SaveButton;
	@FindBy(xpath="(//textarea[@name='addText'])[10]")
	private WebElement element10PerformanceCritiriaTextBox;
	@FindBy(xpath="(//button[text()='+ Add PC'])[10]")
	private WebElement element10AddPC_Button;
	
	
	@FindBy(xpath="(//button[@class='pull-right btn btn-outline-info'])[1]")
	private WebElement deleteElementButton;
	
	//knowledgeAnd understanding
	@FindBy(xpath="//textarea[@name='addText']")
	private WebElement knowledgeAndUnderstandingTextBox;
	@FindBy(xpath="//button[text()='+ Add KU']")
	private WebElement addKUButton;
	//Generic skill
	@FindBy(xpath="//textarea[@name='addText']")
	private WebElement genericSkillTextBox;
	@FindBy(xpath="//button[text()='+ Add GS']")
	private WebElement addGenericSkillButton;
	//Assessment criteria
	@FindBy(xpath="//textarea[@id='exampleTextarea']")
	private WebElement assessmentTextBox;
	@FindBy(xpath="//input[@name='score']")
	private WebElement minimumScoreOFNOSTextBOx;
	//E1Pc1
	@FindBy(xpath="(//input[@formcontrolname='theory'])[1]")
	private WebElement pc1TheroyMarksTextBox ;
	@FindBy(xpath="(//input[@formcontrolname='practical'])[1]")
	private WebElement pc1PracticalMarksTextBox ;
	@FindBy(xpath="(//input[@formcontrolname='ojt'])[1]")
	private WebElement pc1ProjectMarksTextBox ;
	@FindBy(xpath="(//input[@formcontrolname='viva'])[1]")
	private WebElement pc1vivaMarksTextBox ;
	@FindBy(xpath="//input[@formcontrolname='elementTotalMarks']")
	private WebElement totalMarksTextBox ;
	
	
	//Acronaymadocuments
	@FindBy(xpath="(//input[@name='keyword'])[1]")
	private WebElement AcronymsKeywordTextBox;
	@FindBy(xpath="(//textarea[@name='addText'])[1]")
	private WebElement AcronymsDescriptionTextBox;
	@FindBy(xpath="(//input[@name='keyword'])[2]")
	private WebElement glossaryKeywordTextBox;
	@FindBy(xpath="(//textarea[@name='addText'])[2]")
	private WebElement glossaryDescriptionTextBox;
	@FindBy(xpath=("//label[input[@value='standalone']]	"))
	private WebElement standaloneNosButton;
	
	@FindBy(xpath="//label[contains(text(),'Governance Documents')]/..//input")
	private WebElement governmentDocumentsBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Governance Documents')]/..//button[contains(text(),'Upload')]")
	private WebElement governmentDocumentsUploadButton;
	@FindBy(xpath="//label[contains(text(),'RFP Documents')]/..//input")
	private WebElement RFPDocumentsBrowseButton;
	@FindBy(xpath="//label[contains(text(),'RFP Documents')]/..//button[contains(text(),'Upload')]")
	private WebElement RFPDocumentsUploadButton;
	@FindBy(xpath="//label[contains(text(),'About the Sector')]/..//input")
	private WebElement aboutSectorBrowseButton;
	@FindBy(xpath="//label[contains(text(),'About the Sector')]/..//button[contains(text(),'Upload')]")
	private WebElement aboutSectorUploadButton;
	@FindBy(xpath="//label[contains(text(),'Labour Market City')]/..//input")
	private WebElement labourMarketCityBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Labour Market City')]/..//button[contains(text(),'Upload')]")
	private WebElement labourMarketCityUploadButton;
	@FindBy(xpath="//label[contains(text(),'Stakeholder Engagement')]/..//input")
	private WebElement stakeholderEngagementBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Stakeholder Engagement')]/..//button[contains(text(),'Upload')]")
	private WebElement stakeholderEngagementUploadButton;
	@FindBy(xpath="//label[contains(text(),'Occupational mapping')]/..//input")
	private WebElement OccupationalMappingBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Occupational mapping')]/..//button[contains(text(),'Upload')]")
	private WebElement OccupationalMappingUploadButton;
	@FindBy(xpath="//label[contains(text(),'Functional Analysis')]/..//input")
	private WebElement FunctionalAnalysisBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Functional Analysis')]/..//button[contains(text(),'Upload')]")
	private WebElement FunctionalAnalysisUploadButton;
	@FindBy(xpath="//label[contains(text(),'Approval for QP-NOS')]/..//input")
	private WebElement approvalforQPNOSBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Approval for QP-NOS')]/..//button[contains(text(),'Upload')]")
	private WebElement approvalforQPNOSUploadButton;
	@FindBy(xpath="//label[contains(text(),'Q-files_NSQC')]/..//input")
	private WebElement QfilesNSQCBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Q-files_NSQC')]/..//button[contains(text(),'Upload')]")
	private WebElement  QfilesNSQcUploadButton;
	@FindBy(xpath="//label[contains(text(),'QRC Presentation')]/..//input")
	private WebElement QRCPresentationBrowseButton;
	@FindBy(xpath="//label[contains(text(),'QRC Presentation')]/..//button[contains(text(),'Upload')]")
	private WebElement QRCPresentationUploadButton;
	@FindBy(xpath="//label[contains(text(),'QRC Summary Sheet')]/..//input")
	private WebElement QRCSummarySheetBrowseButton;
	@FindBy(xpath="//label[contains(text(),'QRC Summary Sheet')]/..//button[contains(text(),'Upload')]")
	private WebElement QRCSummarySheetUploadButton;
	@FindBy(xpath="//label[contains(text(),'Other Documents')]/..//input")
	private WebElement otherDocumentsBrowseButton;
	@FindBy(xpath="//label[contains(text(),'Other Documents')]/..//button[contains(text(),'Upload')]")
	private WebElement otherDocumentsUploadButton;
	@FindBy(xpath="//button[contains(text(),'Submit for Approval')]")
	WebElement submitForApprovalButton;
	@FindBy(xpath="//button[@id='button']")
	private WebElement  saveAndExitButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
     @FindBy(xpath="//td[text()='Total:']")
     private WebElement totalText;


	
	//
	public  QpCreateNationalOccupationalStandardpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	//utilization
	
	public void  Noofparametersclick() {
	
		NoofparametersButton.click();
	}
	public void  clickElementandperformancecriteria() 
	
	{
		
		elementandPerformanceCriteriaButton.click();
		}
	
      public void clickknowledgeandunderstanding()
      {
		
    	  knowledgeandUnderstandingButton.click();
	}
      
       public void clickGenericskill()
     {

	 GenericskillButton.click();
	}
        public void clickAssenmentcriteria()
        {
	
        	AssenmentcriteriaButton.click();
	    }
        public void clickAcronymsanddocuments() 
        {
        	
        	acronymsAndDocumentsButton.click();
  	    }  

        
   public void clickSubSector()
   {
	   subSectorList.click();
    
	 
 }  
   
   public void clickSubSectorText(String polutry )
   {
	   clickpolutry.click();  
	   }

   public void selectOccupation(String occupationName)
  	{
	   
     	SelectDropDownList.selectDropDownListByVisibleText(occupationDropDownList,occupationName);

       }  
   
   public void selectCredits(String CreditsName)
  	{
	   
     	SelectDropDownList.selectDropDownListByVisibleText(creditDropdownList, CreditsName);;

       }  

   public void selectNSQFlevel(String NSQFLevelName)
 	{
	   
    	SelectDropDownList.selectDropDownListByVisibleText(NsqfLevelDropdownLIst,NSQFLevelName );

      }  
   public void setNOsName(String nosName)
	{
	   nosNameTextBox.clear();
	   nosNameTextBox.sendKeys(nosName);

     }  
   public void enterNOsDescription(String nosDescription)
  	{
	   nosDescriptionTextBox.clear();
	   nosDescriptionTextBox.sendKeys(nosDescription);

       } 
   public void entersetNosScope(String nosScope)
 	{
	   nosScopeTextBox.clear();
	   nosScopeTextBox.sendKeys(nosScope);

      }  
   public void enterSetNextReviewPeriod(String nextReviewPeriod)
	{
	   nextReviewPeriodTextbox.clear();
	   nextReviewPeriodTextbox.sendKeys(nextReviewPeriod);

     }  
   public void clickSaveAndContinouBtton()
  	{
	   saveandcontinoubtton.click();
  	   
       }  
   //element and performance criteria
   public void clickAddAnotherElement()
   {
	   addAnotherElement.click();
   }
   //e1
   public void enterTheElement(String elementName1) 
   {
	   element1TextBox.sendKeys(elementName1);
   }
  public void clickElementSaveButton()
   {
	   elementSaveButton.click();
	   
   }
  
   public void enterElement1PerformanceCriteria(String name)
   {
	   element1PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement1AddPc()
   {
	   element1AddPC_Button.click();
   }
   public void clickDeleteButton()
   {
	   deleteElementButton.click();
   }
   //E2
   public void clickElement2SaveButton()
   {
	   element2SaveButton.click();
   }
   public void enterElement2PerformanceCriteria(String name)
   {
	   element2PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement2AddPc()
   {
	   element2AddPC_Button.click();
   }
   ////E3
   public void clickElement3SaveButton()
   {
	   element3SaveButton.click();
   }
   public void enterElement3PerformanceCriteria(String name)
   {
	   element3PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement3AddPc()
   {
	   element3AddPC_Button.click();
   }
  
 //E4
   public void clickElement4SaveButton()
   {
	   element4SaveButton.click();
   }
   public void enterElement4PerformanceCriteria(String name)
   {
	   element4PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement4AddPc()
   {
	   element4AddPC_Button.click();
   }
 //E5
   public void clickElement5SaveButton()
   {
	   element5SaveButton.click();
   }
   public void enterElement5PerformanceCriteria(String name)
   {
	   element5PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement5AddPc()
   {
	   element5AddPC_Button.click();
   }
 //E6
   public void clickElement6SaveButton()
   {
	   element6SaveButton.click();
   }
   public void enterElement6PerformanceCriteria(String name)
   {
	   element6PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement6AddPc()
   {
	   element6AddPC_Button.click();
   }
 //E7
   public void clickElement7SaveButton()
   {
	   element7SaveButton.click();
   }
   public void enterElement7PerformanceCriteria(String name)
   {
	   element7PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement7AddPc()
   {
	   element7AddPC_Button.click();
   }
 //E8
   public void clickElement8SaveButton()
   {
	   element8SaveButton.click();
   }
   public void enterElement8PerformanceCriteria(String name)
   {
	   element8PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement8AddPc()
   {
	   element8AddPC_Button.click();
   }
 //E9
   public void clickElement9SaveButton()
   {
	   element9SaveButton.click();
   }
   public void enterElement9PerformanceCriteria(String name)
   {
	   element9PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement9AddPc()
   {
	   element9AddPC_Button.click();
   }
 //E10
   public void clickElement10SaveButton()
   {
	   element10SaveButton.click();
   }
   public void enterElement10PerformanceCriteria(String name)
   {
	   element10PerformanceCritiriaTextBox.sendKeys(name);
   }
   public void clickElement10AddPc()
   {
	   element10AddPC_Button.click();
   }
   //KU
     public void enterTheKnowledgeAndUnderstandingTextbox(String knowledgeAndUnderstanding)
   {   
	   knowledgeAndUnderstandingTextBox.clear();
	   knowledgeAndUnderstandingTextBox.sendKeys(knowledgeAndUnderstanding);
   }
   public void clickOnAddKU()
   {
	   addKUButton.click();
   }
   
   
   //Generic skill
   public void enterTheGenericSkill(String genericSkill)
   {
	   genericSkillTextBox.clear();
	   genericSkillTextBox.sendKeys(genericSkill);
   }
   public void clickOnAddGS()
   {
	   addGenericSkillButton.click();
   }
   //ASSESSMENT
   public void enterGuidelinesAssessment(String guidelineAssement)
   {
	   assessmentTextBox.clear();
	   assessmentTextBox.sendKeys( guidelineAssement);
   }
   public void enterTheMinimumScore(String minimumScore)
   {
	   minimumScoreOFNOSTextBOx.sendKeys(minimumScore);
   }
  // e1pc1
 //  public void enterTheTheoryMarks(String theoryMarks)
 //  {
	//   pc1TheroyMarksTextBox.sendKeys(theoryMarks);
  // }
  // public void enterThePracticalMarks(String practicalMarks)
  // {
	//   pc1PracticalMarksTextBox.sendKeys(practicalMarks);
 //  }
   
   //public void enterTheProjectMarks(String projectMarks)
  // {
	//   pc1ProjectMarksTextBox.sendKeys(projectMarks);
  // }
  
  // public void enterTheVivaMarks(String vivaMarks)
  // {
	//  pc1vivaMarksTextBox.sendKeys(vivaMarks);
	  //pc1ProjectMarksTextBox.click();//to make pc1 disable
   //}
   
   
  
   
   
   
 //  public void enterTheTotalMarks(String totalMarks)
  // {
	//   totalMarksTextBox.sendKeys(totalMarks);
  // }
   //Acronomys documents
   
   public void enterAcronymsKeyword(String acronymsKeyword)
   {
	   AcronymsKeywordTextBox.sendKeys(acronymsKeyword);
   }
   public void enterAcronymsDescription(String acronymsdescription)
   {
	   AcronymsDescriptionTextBox.sendKeys(acronymsdescription);
   }
   public void enterGlossaryKeyword(String keyword)
   {
	   glossaryKeywordTextBox.sendKeys(keyword);
   }
   public void enterGlossaryDescription(String glossaryDescription)
   {
	   glossaryDescriptionTextBox.sendKeys( glossaryDescription);
   }
   public void clickStandaloneNos()
   {
	   standaloneNosButton.click();
   }
   public void clickGoveranceDocuments()
   {
	   governmentDocumentsBrowseButton.click();
   }
   public void clickGoveranceDocumentsUploadButton()
   {
	   governmentDocumentsUploadButton.click();
   }
   public void clickRFPDocuments()
   {
	   
	   RFPDocumentsBrowseButton.click();
   }
   public void clickRFPDocumentsUploadButton()
   {
	   RFPDocumentsUploadButton.click();
   }
   public void clickAboutSector()
   {
	   aboutSectorBrowseButton.click();
   }
   public void clickAboutSectorUploadButton()
   {
	   aboutSectorUploadButton.click();
   }
   public void clickLabourMarketCity()
   {
	   labourMarketCityBrowseButton.click();
   }
   public void clicklabourMarketCityUploadButton()
   {
	   labourMarketCityUploadButton.click();
   }
   public void clickStakeHolderEnagged()
   {
	   stakeholderEngagementBrowseButton.click();
   }
   public void clickStakeHolderEnaggeduploadButton()
   {
	   stakeholderEngagementUploadButton.click();
   }
   public void clickOccupationalMapping()
   {
	   OccupationalMappingBrowseButton.click();
   }
   public void clickOccupationalMappinguploadButton()
   {
	   OccupationalMappingUploadButton.click();
   }
   public void clickFunctionalAnalysis()
   {
	   FunctionalAnalysisBrowseButton.click();
   }
   public void clickFunctionalAnalysisuploadButton()
   {
	   FunctionalAnalysisUploadButton.click();
   }
   public void clickApprovalForQpNos()
   {
	   approvalforQPNOSBrowseButton.click();
   }
   public void clickApprovalForQpNosuploadButton()
   {
	   approvalforQPNOSUploadButton.click();
   }
   public void clickQfilesNSQC()
   {
	   QfilesNSQCBrowseButton.click();
   }
   public void clickQfilesNSQCuploadButton()
   {
	   QfilesNSQcUploadButton.click();
   }
   public void clickQRCPresentationBrowser() 
   {
	   QRCPresentationBrowseButton.click();
   }
   public void clickQRCPresentationUploadButton()
   {
	   QRCPresentationUploadButton.click();
   }
   public void clickQRCSummarySheetBrowseButton() 
   {
	   QRCSummarySheetBrowseButton.click();
   }
   public void clickQRCSummarySheetUploadButton()
   {
	   QRCSummarySheetUploadButton.click();
   }
   public void clickotherDocumentsBrowseButton()
   {
	   otherDocumentsBrowseButton.click();
   }
   public void clickotherDocumentsUploadButton()
   {
	   otherDocumentsUploadButton.click();
   }
   public void clickSubmitForApproval()
   {
	   submitForApprovalButton.click();
   }
   public void clicksaveAndExitButton()
   {
	   saveAndExitButton.click();
   }
   public void clickOkButton()
   {
	   okButton.click();
   }
   public void clickSaveAsDraftButton()
 	{
	   saveAsDraftbtton.click();
 	   
      } 
   
   public void clickPreviewNosButton()
	{
	   previousNosbtton.click();
	   

     } 
   public void clickTotal()
   {
	   totalText.click();
   }
   }

