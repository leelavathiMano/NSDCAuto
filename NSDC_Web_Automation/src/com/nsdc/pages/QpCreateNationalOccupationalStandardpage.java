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
	
	@FindBy(xpath="//input[@formcontrolname='element']")
	private WebElement elementTextBox;
	
	@FindBy(xpath="(//a)[19]")
	private WebElement saveButton;
	
	
	
	
	//@FindBy(xpath="(//label[@class='m-radio m-radio--solid keyValue-style'])[2]")
	//private WebElement addOnlyPerformanceCriteriaRadioButton;
	//
	@FindBy(xpath="//textarea[@name='addText']")
	private WebElement enterThePerformanceCritiria;
	@FindBy(xpath="//button[text()='+ Add PC']")
	private WebElement addPCButton;
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
	
	@FindBy(xpath="//input[@formcontrolname='theory']")
	private WebElement pc1TheroyMarksTextBox ;
	@FindBy(xpath="//input[@formcontrolname='practical']")
	private WebElement pc1PracticalMarksTextBox ;
	@FindBy(xpath="//input[@formcontrolname='ojt']")
	private WebElement pc1ProjectMarksTextBox ;
	
	@FindBy(xpath="//input[@formcontrolname='viva']")
	private WebElement pc1vivaMarksTextBox ;
	@FindBy(xpath="//input[@formcontrolname='elementTotalMarks']")
	private WebElement totalMarksTextBox ;
	
	//@FindBy(xpath="//input[@formcontrolname='theory']")
	//private WebElement pcTheoryTextBox ;
	//@FindBy(xpath="//input[@formcontrolname='practical']")
	//private WebElement pcPracticalTextBox ;
	
	//@FindBy(xpath="//input[@formcontrolname='ojt']")
	//private WebElement pcProjectTextBox ;
	
	//Acronaymadocuments
	@FindBy(xpath="(//input[@name='keyword'])[1]")
	private WebElement AcronymsKeywordTextBox;
	@FindBy(xpath="(//textarea[@name='addText'])[1]")
	private WebElement AcronymsDescriptionTextBox;
	@FindBy(xpath="(//input[@name='keyword'])[2]")
	private WebElement glossaryKeywordTextBox;
	@FindBy(xpath="(//textarea[@name='addText'])[2]")
	private WebElement glossaryDescriptionTextBox;
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
	@FindBy(xpath="//button[@id='button']")
	private WebElement  saveAndExitButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;



	
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
   
   
   public void enterTheFirstElement(String elementName) 
   {
	   elementTextBox.sendKeys(elementName);
   }
   public void clickSaveButton()
   {
	   saveButton.click();
	   
   }
   public void clickDeleteButton()
   {
	   deleteElementButton.click();
   }
   public void enterThePerformanceCriteria(String name)
   {
	   enterThePerformanceCritiria.sendKeys(name);
   }
   public void clickOnAddPc()
   {
	   addPCButton.click();
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
   public void enterTheTheoryMarks(String theoryMarks)
   {
	   pc1TheroyMarksTextBox.sendKeys(theoryMarks);
   }
   public void enterThePracticalMarks(String practicalMarks)
   {
	   pc1PracticalMarksTextBox.sendKeys(practicalMarks);
   }
   
   public void enterTheProjectMarks(String projectMarks)
   {
	   pc1ProjectMarksTextBox.sendKeys(projectMarks);
   }
  
   public void enterTheVivaMarks(String vivaMarks)
   {
	  pc1vivaMarksTextBox.sendKeys(vivaMarks);
	  pc1ProjectMarksTextBox.click();//to make pc1 disable
   }
   public void enterTheTotalMarks(String totalMarks)
   {
	   totalMarksTextBox.sendKeys(totalMarks);
   }
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
}
