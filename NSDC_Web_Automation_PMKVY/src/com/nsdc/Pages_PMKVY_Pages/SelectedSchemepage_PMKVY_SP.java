package com.nsdc.Pages_PMKVY_Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class SelectedSchemepage_PMKVY_SP {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Select Agreement Date']")
	private WebElement AggrementDate;
	
	@FindBy(xpath="//div[input[@placeholder='Select Start Date']]")
	private WebElement ProjectDurationStartDate;
	
	@FindBy(xpath="//div[input[@placeholder='Select End Date']]")
	private WebElement ProjectDurationEndDate;
	@FindBy(xpath="//select[@class='custom-select'][1]")
	private WebElement monthDropdownList;
	@FindBy(xpath="//select[@class='custom-select'][2]")
	private WebElement yearDropdownList;
	//
	@FindBy(xpath="(//select[@formcontrolname='adharRequired'])[1]")
	private WebElement AdharRequirment ;
	@FindBy(xpath="//select[@formcontrolname='trainerCertified']")
	private WebElement  TrainerCertifiedDropDownList;
	@FindBy(xpath="//select[@formcontrolname='trainingCentreMode']")
	private WebElement  TypeofTrainingCentreDropDownList;
	@FindBy(xpath="//select[@formcontrolname='placementsRequirement']")
	private WebElement  PlacementsRequirementDropDownList;
	@FindBy(xpath="//select[@formcontrolname='type']")
	private WebElement  TypeOfEmploymentDropDownList;
	@FindBy(xpath="//input[@formcontrolname='noOfCandidatesToBePlacedPercentage']")
	private WebElement  MinimumPercentageofCandidatedtobeplacedTextBox;
	@FindBy(xpath="(//button[text()='Add'])[1]")
	private WebElement MinimumPercentageofCandidatedtobeplacedAddButton ;
	
	//
	@FindBy(xpath="//select[@formcontrolname='disability']")
	private WebElement DisabilityDropDownList ;
	@FindBy(xpath="//select[@formcontrolname='religion']")
	private WebElement  ReligionDropDownList;
	@FindBy(xpath="//select[@formcontrolname='gender']")
	private WebElement GenderDropDownList  ;
	@FindBy(xpath="//select[@formcontrolname='category']")
	private WebElement CategoryDropDownLIst ;
	
	@FindBy(xpath="//input[@formcontrolname='discountsOnBaseRate']")
	private WebElement EnterTheDiscountsOnBaseRateTestBox ;
	@FindBy(xpath="//input[@formcontrolname='batchDuration']")
	private WebElement EnterBatchDurationTextBox ;
	@FindBy(xpath="//select[@formcontrolname='numberofTranches']")
	private WebElement  NumberOfTranchesDropDownList;
	@FindBy(xpath="//select[@formcontrolname='trancheThreeToBePaidWithoutPlacement']")
	private WebElement trancheThreeToBepaidDropDownList ;
	//
	@FindBy(xpath="//select[@formcontrolname='dualLogoRequired']")
	private WebElement DualLogoRequiredDropDownList ;
	@FindBy(xpath="//textarea[@formcontrolname='targetBeneficiaries']")
	private WebElement TargetBeneficiariesTextArea ;
	@FindBy(xpath="//select[@formcontrolname='sector']")
	private WebElement  SectorDropDownList;
	@FindBy(xpath="//select[@formcontrolname='jobRoleName']")
	private WebElement jobRoleNameDropDownList ;
	@FindBy(xpath="//input[@formcontrolname='proposedTrainingTarget']")
	private WebElement ProposedTrainingTargetTextBox ;
	@FindBy(xpath="(//button[text()='Add'])[2]")
	private WebElement SectorAndJobRoleAddButton;
	
	
	
	
	//
	public SelectedSchemepage_PMKVY_SP (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void ClickAggrementDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(AggrementDate).click().build().perform();
	}
	
	
	
	public void SelectAggrementDate(String aggrementDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, aggrementDate, AggrementDate, monthDropdownList, yearDropdownList);
		
	}
	
	public void ClickStartDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(ProjectDurationStartDate).click().build().perform();
	}
	
	
	
	public void SelectProjectDurationStartDate(String StartDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, StartDate, ProjectDurationStartDate, monthDropdownList, yearDropdownList);
	}
	
	public void ClickEndDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(ProjectDurationEndDate).click().build().perform();
	}
	
	public void SelectProjectDurationEndDate(String EndDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, EndDate, ProjectDurationEndDate, monthDropdownList, yearDropdownList);
	}
	//
	public void SelectAdharRequirmentYes(String yes)
	{
		SelectDropDownList.selectDropDownListByVisibleText(AdharRequirment, yes);
	}
	public void selectAdharRequirmentNo(String No)
	{
		SelectDropDownList.selectDropDownListByVisibleText(AdharRequirment, No);
	}
	public void SelectTrainerCertifiedYes(String yes)
	{
		SelectDropDownList.selectDropDownListByVisibleText(TrainerCertifiedDropDownList, yes);
	}
	public void SelectTypeofTrainingCentre(String both)
	{
		SelectDropDownList.selectDropDownListByVisibleText(TypeofTrainingCentreDropDownList, both);
	}
	public void SelectPlacementsRequirementYes(String yes)
	{
		SelectDropDownList.selectDropDownListByVisibleText(PlacementsRequirementDropDownList,yes);
	}	
	
	public void SelectTypeOfEmployment(String selfEmployeement)
	{
		SelectDropDownList.selectDropDownListByVisibleText(PlacementsRequirementDropDownList,selfEmployeement);
	}	
	public void EnterTheMinimumPercentageofCandidatedtobeplacedTextBox(String percentage)
	{
		MinimumPercentageofCandidatedtobeplacedTextBox.sendKeys(percentage);
	}	
	public void ClickPercentageAdd()
	{
		MinimumPercentageofCandidatedtobeplacedAddButton.click();
	}
	public void SelectDisability(String Both)
	{
		SelectDropDownList.selectDropDownListByVisibleText(DisabilityDropDownList, Both);
	}
	//
	
	
	
	
	public void SelectReligion(String Hindu)
	{
		SelectDropDownList.selectDropDownListByVisibleText(ReligionDropDownList, Hindu);
	}
	public void SelectGender(String male)
	{
		SelectDropDownList.selectDropDownListByVisibleText(GenderDropDownList, male);
	}
	public void SelectCategory(String General)
	{
		SelectDropDownList.selectDropDownListByVisibleText(CategoryDropDownLIst, General);
	}
	public void EnterTheDiscountsOnBaseRate(String DiscountPer)
	{
		EnterTheDiscountsOnBaseRateTestBox.sendKeys(DiscountPer);
	}
	public void EnterBatchDuration(String batchDuration )
	{
		EnterBatchDurationTextBox.sendKeys(batchDuration);
	}
	//
	public void SelectNumberOfTranches(String value1)
	{
		SelectDropDownList.selectDropDownListByVisibleText(NumberOfTranchesDropDownList, value1);
	}
	public void SelecttrancheThreeToBepaid(String yes)
	{
		SelectDropDownList.selectDropDownListByVisibleText(trancheThreeToBepaidDropDownList, yes);
	}
	public void SelectDualLogoRequired(String yes)
	{
		SelectDropDownList.selectDropDownListByVisibleText(DualLogoRequiredDropDownList, yes);
	}
	public void EnterTheTargetBeneficiaries(String TargetBeneficiaries )
	{
		TargetBeneficiariesTextArea.sendKeys(TargetBeneficiaries);
	}
	public void SelectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(SectorDropDownList, sector);
	}
	public void SelectjobRoleName(String jobrole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleNameDropDownList, jobrole);
	}
	public void EnterSectorAndJobTarget(String EnterTarget1)
	{
		ProposedTrainingTargetTextBox.sendKeys(EnterTarget1);
	}
	public void ClickOnSectorAndJobRoleAdd()
	{
		SectorAndJobRoleAddButton.click();
	}
	
	
	
	}

