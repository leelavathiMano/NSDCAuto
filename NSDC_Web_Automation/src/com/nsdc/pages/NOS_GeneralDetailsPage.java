package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class NOS_GeneralDetailsPage 
{
	WebDriver driver;
	@FindBy(xpath="//select[@formcontrolname='subSectorName']")
	private WebElement subSectorDropDownList;
	@FindBy(xpath="//select[@formcontrolname='occupationDesc']")
	private WebElement occupationDropDownList;
	@FindBy(xpath="//input[@formcontrolname='credits']")
	private WebElement creditsTextBox;
	@FindBy(xpath="//select[@formcontrolname='nsqf']")
	private WebElement NSQF_levelDropDownList;
	@FindBy(xpath="//input[@formcontrolname='unitTitle']")
	private WebElement NOS_nameTextBox;
	@FindBy(xpath="//input[@formcontrolname='version']")
	private WebElement NOS_versionTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='description']")
	private WebElement NOS_descriptionTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='scopeDescription']")
	private WebElement NOS_scopeTextBox;
	@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
	private WebElement saveAndContinueButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	
	@FindBy(xpath="//div[label[contains(text(),'1. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")
	private WebElement performanceCriteria1_TextBox;
	@FindBy(xpath="//button[text()='Add Another Performance Criteria']")
	private WebElement addAnotherPerformanceCriteriaButton;
	@FindBy(xpath="//div[label[contains(text(),'2. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")
	private WebElement performanceCriteria2_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'3. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")
	private WebElement performanceCriteria3_TextBox;
	@FindBy(xpath="//button[text()='Previous']")
	private WebElement previousButton;
	@FindBy(xpath="//button[text()='Categorise under Elements']")
	private WebElement categoriseUnderElementsButton;
	@FindBy(xpath="//button[contains(text(),'Save & Continue to Next Step')]")
	private WebElement saveAndContinueToNextStepButton;
	
	@FindBy(xpath="//div[label[contains(text(),'1. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")
	private WebElement nameOfTheElement1_TextBox;
	
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[1]/div/label[1]/span")
	private WebElement element1_groupedPerformanceCriteria1_checkBox;
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[1]/div/label[2]/span")
	private WebElement element1_groupedPerformanceCriteria2_checkBox;
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[1]/div/label[3]/span")
	private WebElement element1_groupedPerformanceCriteria3_checkBox;
	
	@FindBy(xpath="//div[label[contains(text(),'2. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")
	private WebElement nameOfTheElement2_TextBox;
	
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[2]/div/label[1]/span")
	private WebElement element2_groupedPerformanceCriteria1_checkBox;
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[2]/div/label[2]/span")
	private WebElement element2_groupedPerformanceCriteria2_checkBox;
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[2]/div/label[3]/span")
	private WebElement element2_groupedPerformanceCriteria3_checkBox;
	
	@FindBy(xpath="//div[label[contains(text(),'3. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")
	private WebElement nameOfTheElement3_TextBox;
	
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[3]/div/label[1]/span")
	private WebElement element3_groupedPerformanceCriteria1_checkBox;
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[3]/div/label[2]/span")
	private WebElement element3_groupedPerformanceCriteria2_checkBox;
	@FindBy(xpath="(//div[label[contains(text(),'Grouped Performance Criterias')]])[3]/div/label[3]/span")
	private WebElement element3_groupedPerformanceCriteria3_checkBox;
	
	@FindBy(xpath="//button[contains(text(),'Add Another Element')]")
	private WebElement addAnotherElementButton;
	
	@FindBy(xpath="//div[label[contains(text(),'1. Knowledge Parameter')]]/div/input[@formcontrolname='knowledgeParam']")
	private WebElement knowledgeParameter1_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'2. Knowledge Parameter')]]/div/input[@formcontrolname='knowledgeParam']")
	private WebElement knowledgeParameter2_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'3. Knowledge Parameter')]]/div/input[@formcontrolname='knowledgeParam']")
	private WebElement knowledgeParameter3_TextBox;
	@FindBy(xpath="//button[text()='Add Another Knowledge Parameter']")
	private WebElement addAnotherKnowledgeParameterButton;
	@FindBy(xpath="//button[text()='Skip']")
	private WebElement skipButton;
	
	@FindBy(xpath="//div[label[contains(text(),'1. Generic Skills Parameter')]]/div/input[@formcontrolname='skillCrt']")
	private WebElement genericSkillsParameter1_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'2. Generic Skills Parameter')]]/div/input[@formcontrolname='skillCrt']")
	private WebElement genericSkillsParameter2_TextBox;
	@FindBy(xpath="//div[label[contains(text(),'3. Generic Skills Parameter')]]/div/input[@formcontrolname='skillCrt']")
	private WebElement genericSkillsParameter3_TextBox;
	@FindBy(xpath="//button[text()='Add Another Generic Skills Parameter']")
	private WebElement addAnotherGenericSkillsParameterButton;
	
	@FindBy(id="date")
	private WebElement nextReviewDateTextBox;
	@FindBy(css=".input-group-text")
	private WebElement calendarLogo;
	@FindBy(xpath="//button[contains(text(),'Submit for Approval')]")
	private WebElement submitForApprovalButton;
	@FindBy(xpath="//button[contains(text(),'Edit Details')]")
	private WebElement editDetailsButton;
	
	@FindBy(xpath="//button[text()='Back to Dashboard']")
	private WebElement backToDashboardButton;
	
	public NOS_GeneralDetailsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropDownList, subSector);
	}
	
	public void selectOccupation(String occupation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(occupationDropDownList, occupation);
	}
	
	public void enterCreditsOrNSQF(String credits)
	{
		creditsTextBox.clear();
		creditsTextBox.sendKeys(credits);
	}
	
	public void selectNSQF_Level(String NSQF_level)
	{
		SelectDropDownList.selectDropDownListByVisibleText(NSQF_levelDropDownList, NSQF_level);
	}
	
	public void enterNOS_Name(String NOS_name)
	{
		NOS_nameTextBox.clear();
		NOS_nameTextBox.sendKeys(NOS_name);
	}
	
	public void enterNOS_version(String NOS_version)
	{
		NOS_versionTextBox.clear();
		NOS_versionTextBox.sendKeys(NOS_version);
	}
	
	public void enterNOS_description(String NOS_description)
	{
		NOS_descriptionTextBox.clear();
		NOS_descriptionTextBox.sendKeys(NOS_description);
	}
	
	public void enterNOS_scope(String NOS_scope) 
	{
		NOS_scopeTextBox.clear();
		NOS_scopeTextBox.sendKeys(NOS_scope);
	}
	
	public void clickOnSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void enterPerformanceCriteria1(String criteria1)
	{
		performanceCriteria1_TextBox.clear();
		performanceCriteria1_TextBox.sendKeys(criteria1);
	}
	
	public void clickOnAddAnotherPerformanceCriteria()
	{
		addAnotherPerformanceCriteriaButton.click();
	}
	
	public void enterPerformanceCriteria2(String criteria2) 
	{
		performanceCriteria2_TextBox.clear();
		performanceCriteria2_TextBox.sendKeys(criteria2);
	}
	
	public void enterPerformanceCriteria3(String criteria3) 
	{
		performanceCriteria3_TextBox.clear();
		performanceCriteria3_TextBox.sendKeys(criteria3);
	}
	
	public void clickOnPrevious()
	{
		previousButton.click();
	}
	
	public void clickOnCategoriseUnderElements()
	{
		categoriseUnderElementsButton.click();
	}
	
	public void clickOnSaveAndContinueToNextStep()
	{
		saveAndContinueToNextStepButton.click();
	}
	
	
	
	public void enterNameOfTheElement1(String element1)
	{
		nameOfTheElement1_TextBox.clear();
		nameOfTheElement1_TextBox.sendKeys(element1);
	}
	
	public void clickOn_GroupedPerformanceCriteria1ForElement1()
	{
		element1_groupedPerformanceCriteria1_checkBox.click();
	}
	
	public void clickOn_GroupedPerformanceCriteria2ForElement1()
	{
		element1_groupedPerformanceCriteria2_checkBox.click();
	}
	
	public void clickOn_GroupedPerformanceCriteria3ForElement1()
	{
		element1_groupedPerformanceCriteria3_checkBox.click();
	}
	
	public void enterNameOfTheElement2(String element2)
	{
		nameOfTheElement2_TextBox.clear();
		nameOfTheElement2_TextBox.sendKeys(element2);
	}
	
	public void clickOn_GroupedPerformanceCriteria1ForElement2()
	{
		element2_groupedPerformanceCriteria1_checkBox.click();
	}
	
	public void clickOn_GroupedPerformanceCriteria2ForElement2()
	{
		element2_groupedPerformanceCriteria2_checkBox.click();
	}
	
	public void clickOn_GroupedPerformanceCriteria3ForElement2()
	{
		element2_groupedPerformanceCriteria3_checkBox.click();
	}
	
	public void enterNameOfTheElement3(String element3)
	{
		nameOfTheElement3_TextBox.clear();
		nameOfTheElement3_TextBox.sendKeys(element3);
	}
	
	public void clickOn_GroupedPerformanceCriteria1ForElement3()
	{
		element3_groupedPerformanceCriteria1_checkBox.click();
	}
	
	public void clickOn_GroupedPerformanceCriteria2ForElement3()
	{
		element3_groupedPerformanceCriteria2_checkBox.click();
	}
	
	public void clickOn_GroupedPerformanceCriteria3ForElement3()
	{
		element3_groupedPerformanceCriteria3_checkBox.click();
	}
	
	public void clickOn_addAnotherElement()
	{
		addAnotherElementButton.click();
	}
	
	public void enterKnowledgeParameter1(String parameter1)
	{
		knowledgeParameter1_TextBox.clear();
		knowledgeParameter1_TextBox.sendKeys(parameter1);
	}
	
	public void enterKnowledgeParameter2(String parameter2)
	{
		knowledgeParameter2_TextBox.clear();
		knowledgeParameter2_TextBox.sendKeys(parameter2);
	}
	
	public void enterKnowledgeParameter3(String parameter3)
	{
		knowledgeParameter3_TextBox.clear();
		knowledgeParameter3_TextBox.sendKeys(parameter3);
	}
	
	public void clickOnAddAnotherKnowledgeParameter()
	{
		addAnotherKnowledgeParameterButton.click();
	}
	
	public void clickOnSkip()
	{
		skipButton.click();
	}
	
	
	
	public void enterGenericSkillsParameter1(String parameter1)
	{
		genericSkillsParameter1_TextBox.clear();
		genericSkillsParameter1_TextBox.sendKeys(parameter1);
	}
	
	public void enterGenericSkillsParameter2(String parameter2)
	{
		genericSkillsParameter2_TextBox.clear();
		genericSkillsParameter2_TextBox.sendKeys(parameter2);
	}
	
	public void enterGenericSkillsParameter3(String parameter3)
	{
		genericSkillsParameter3_TextBox.clear();
		genericSkillsParameter3_TextBox.sendKeys(parameter3);
	}
	
	public void clickOnAddAnotherGenericSkillsParameter()
	{
		addAnotherGenericSkillsParameterButton.click();
	}
	
	
	
	public void enterNextReviewDate(String date)
	{
		nextReviewDateTextBox.clear();
		nextReviewDateTextBox.sendKeys(date);
	}
	
	public void clickOnCalendarLogo()
	{
		calendarLogo.click();
	}
	
	public void clickOnSubmitForApproval()
	{
		submitForApprovalButton.click();
	}
	
	public void clickOnEditDetails()
	{
		editDetailsButton.click();
	}
	
	public void clickOnBackToDashboard()
	{
		backToDashboardButton.click();
	}
}
