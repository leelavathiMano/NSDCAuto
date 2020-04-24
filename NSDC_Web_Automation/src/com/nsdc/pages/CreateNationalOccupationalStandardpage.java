package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class CreateNationalOccupationalStandardpage 
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
	@FindBy(xpath="//div[@class='selected-list']//span[text()='Select Sub Sector']")
	private WebElement subSectorList;
	@FindBy(xpath="//label[text()='Poultry']")
	private WebElement clickpolutry ;
	//
	@FindBy(xpath="(//div[@class='selected-list']//span[text()='Select Occupation'])[1]")
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
//
	
	
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
	@FindBy(xpath=("//label[input[@value='standalone']]"))
	private WebElement standaloneNosButton;
	
	
	
//
	@FindBy(xpath="//button[contains(text(),'Submit for Review')]")
	WebElement submitForApprovalButton;
	@FindBy(xpath="//button[@id='button']")
	private WebElement  saveAndExitButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
     @FindBy(xpath="//td[text()='Total:']")
     private WebElement totalText;
     @FindBy(xpath="//button[text()='Continue to Submit']")
     private WebElement continueToSubmit;


	
	//
	public  CreateNationalOccupationalStandardpage(WebDriver driver)
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
   
   public void clickSubSectorText()
   {
	   clickpolutry.click();  
	   }

   public void ClickOnOccupation(String occupationName) throws InterruptedException
  	{
	   
	   occupationDropDownList.click();
	   
     	Thread.sleep(2000);
     	driver.findElement(By.xpath("(//label[text()='Vegetable Crops Cultivation'])[1]")).click();

       }  
   
   public void selectCredits(String CreditsName)
  	{
	   
     	SelectDropDownList.selectDropDownListByVisibleText(creditDropdownList, CreditsName);

       }  

   public void selectNSQFlevel(String NSQFLevelName)
 	{
	   
    	SelectDropDownList.selectDropDownListByVisibleText(NsqfLevelDropdownLIst,NSQFLevelName );

      }  
   public void EnterTheNOsName(String nosName)
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
// 
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
//  
   public void clickSubmitForReview()
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
   public void clickContinueToSubmit()
   {
	   continueToSubmit.click();
   }
   }

