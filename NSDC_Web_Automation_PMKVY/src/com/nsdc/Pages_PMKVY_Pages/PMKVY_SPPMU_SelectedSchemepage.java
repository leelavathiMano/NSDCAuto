package com.nsdc.Pages_PMKVY_Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class PMKVY_SPPMU_SelectedSchemepage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Select Agreement Date']")
	private WebElement AggrementDate;
	
	@FindBy(xpath="//div[input[@placeholder='Select Start Date']]")
	private WebElement ProjectDurationStartDate;
	
	@FindBy(xpath="//div[input[@placeholder='Select End Date']]")
	private WebElement ProjectDurationEndDate;
	@FindBy(xpath="(//select[@class='custom-select'])[1]")
	private WebElement monthDropdownList;
	@FindBy(xpath="(//select[@class='custom-select'])[2]")
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
	@FindBy(xpath="//select[@formcontrolname='numberOfTranches']")
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
	
	@FindBy(xpath="//select[@formcontrolname='qpCode']")
	private WebElement jobRole_QpcodeDropdownlist ;
	@FindBy(xpath="//input[@formcontrolname='proposedTrainingTarget']")
	private WebElement ProposedTrainingTargetTextBox ;
	@FindBy(xpath="(//button[text()='Add'])[2]")
	private WebElement SectorAndJobRoleAddButton;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement SaveAndSubmitButton;
	//button[contains(text(),'Save & Submit')]
	////////////////button[text()='Save']
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement selectlocationStateDropDownlist;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement selectlocationdistrictDropDownlist;
	@FindBy(xpath="(//button[text()='Add'])[3]")
	private WebElement locationAddButton;
	//////////modification(approved location)
	@FindBy(xpath="(//select[@formcontrolname='qpCode'])[1]")
	private WebElement JobRoleTargetDistribution1DropDownlist;
	@FindBy(xpath="(//select[@formcontrolname='adharRequired'])[2]")
	private WebElement AdharReqTargetDistribution1;
	@FindBy(xpath="(//select[@formcontrolname='boardingAndLoadgingRequired'])[1]")
	private WebElement BAndLTargetDistribution1;
	@FindBy(xpath="(//select[@formcontrolname='convayenceRequired'])[1]")
	private WebElement TransportReqTargetDistribution1;
	@FindBy(xpath="(//input[@placeholder='Enter Target'])[2]")
	private WebElement TargetDistribution1;
	///////////////////////////////
	@FindBy(xpath="(//select[@formcontrolname='qpCode'])[2]")
	private WebElement JobRoleTargetDistribution2;
	@FindBy(xpath="(//select[@formcontrolname='adharRequired'])[3]")
	private WebElement AdharReqTargetDistribution2;
	@FindBy(xpath="(//select[@formcontrolname='boardingAndLoadgingRequired'])[2]")
	private WebElement BAndLTargetDistribution2;
	@FindBy(xpath="(//select[@formcontrolname='convayenceRequired'])[2]")
	private WebElement TransportReqTargetDistribution2;
	@FindBy(xpath="(//input[@placeholder='Enter Target'])[3]")
	private WebElement TargetDistribution2;
	@FindBy(xpath="//select[@formcontrolname='userName']")
	private WebElement TC_nameDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='target'])[2]")
	private WebElement TC_TargetTextBox;
	@FindBy(xpath="(//button[text()='Add'])[4]")
	private WebElement Tc_targetAddbutton;
	
	////
	@FindBy(xpath="//select[@formcontrolname='isAdvancePaymentDone']")
	private WebElement AdvanceTrancheDrpDownList;
	@FindBy(xpath="//input[@formcontrolname='percentageOfAdvance']")
	private WebElement percentageOfAdvanceTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Amount'])[2]")
	private WebElement AmountTobeOfAdvanceTextBox;
	@FindBy(xpath="//button[text()='Add']")
	private WebElement AdvanceAddButton;
	@FindBy(xpath="//button[text()='Save & Submit']")
	private WebElement SaveAndButton;
	
	@FindBy(xpath="//button[contains(text(), 'Add Sectors & Job Role')]")
	private WebElement AddSectorsAndjobRoleButton;
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement Action_Icon;
	@FindBy(xpath="(//a[contains(text(),'View Generated Termsheet')])[1]")
	private WebElement ViewGenerated_Termsheet;
	
	//
	public PMKVY_SPPMU_SelectedSchemepage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void ClickAggrementDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		AggrementDate.click();
//		  Actions actions = new Actions(driver);
//		  actions.moveToElement(AggrementDate).click().build().perform();
		
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", AggrementDate);
//		
		//AggrementDate.click();
	}
	
	
	
	public void SelectAggrementDate(String aggrementDate) throws InterruptedException 
	{
		Thread.sleep(3000);
		ToT_ToA_Batch_DatePicker.chooseDate(driver, aggrementDate, AggrementDate, monthDropdownList, yearDropdownList);
		
	}
	
	public void ClickStartDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		ProjectDurationStartDate.click();
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", ProjectDurationStartDate);
//		  Actions actions = new Actions(driver); 
//		  actions.moveToElement(ProjectDurationStartDate).click().build().perform();
	}
	
	
	
	public void SelectProjectDurationStartDate(String StartDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, StartDate, ProjectDurationStartDate, monthDropdownList, yearDropdownList);
	}
	
	public void ClickEndDate() throws InterruptedException 
	{
		Thread.sleep(2000);
		ProjectDurationEndDate.click();
//		  Actions actions = new Actions(driver); 
//		  actions.moveToElement(ProjectDurationEndDate).click().build().perform();
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
	
	public void SelectTypeOfEmployment(String typeOfElement)
	{
		SelectDropDownList.selectDropDownListByVisibleText(TypeOfEmploymentDropDownList,typeOfElement);
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
	
	
	
	

	
	public void SelectReligion(String religion)
	{
		//SelectDropDownList.selectDropDownListByVisibleText(ReligionDropDownList, religion);

		SelectDropDownList.selectmultipleoptions(ReligionDropDownList);
     }
	
	
	
	
	public void SelectGender(String gender)
	{
		//SelectDropDownList.selectDropDownListByVisibleText(GenderDropDownList, male);
		SelectDropDownList.selectmultipleoptions(GenderDropDownList);
		
      }
	
	
	
	public void SelectCategory(String Category)
	{
		//SelectDropDownList.selectDropDownListByVisibleText(CategoryDropDownLIst, General);
		SelectDropDownList.selectmultipleoptions(CategoryDropDownLIst);
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
	
	
	public void SelectjobRoleQPCode(String jobrole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRole_QpcodeDropdownlist, jobrole);
	}
	
	public void EnterSectorAndJobTarget(String EnterTarget1)
	{
		ProposedTrainingTargetTextBox.sendKeys(EnterTarget1);
	}
	public void ClickOnSectorAndJobRoleAdd()
	{
		SectorAndJobRoleAddButton.click();
	}
	
	public void ClickOnSavebutton()
	{
		SaveButton.click();
	}
	
	public void ClickOnSaveAndSubmit()
	{
		SaveAndSubmitButton.click();
	}
	
	
	//////////////////////////////////////////////
	public void SelectlocationState(String State)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectlocationStateDropDownlist, State);
		
	}
	public void Selectlocationdistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectlocationdistrictDropDownlist, district);
		
	}
	
	public void ClicklocationAddButton()
	{
		locationAddButton.click();
		
	}
	public void SelectJobRoleTargetDistribution1(String Jobrole1) throws InterruptedException
	
	{
		Thread.sleep(3000);
		SelectDropDownList.selectDropDownListByVisibleText(JobRoleTargetDistribution1DropDownlist, Jobrole1);
		
	}
	public void SelectAdharReqTargetDistribution1(String Adhar)
	{
		SelectDropDownList.selectDropDownListByVisibleText(AdharReqTargetDistribution1, Adhar);
		
	}
	public void SelectBAndLTargetDistribution1(String yes)
	{
		SelectDropDownList.selectDropDownListByVisibleText(BAndLTargetDistribution1, yes);
		
	}
	public void EnterTargetDistribution1 (String target1)
	{
		TargetDistribution1.sendKeys(target1);
		
	}
	public void SelectJobRoleTargetDistribution2(String Jobrole2)
	{
		SelectDropDownList.selectDropDownListByVisibleText(JobRoleTargetDistribution2, Jobrole2);
		
	}
	public void EnterTargetDistribution2 (String target2)
	{
		TargetDistribution2.sendKeys(target2);
		
	}
	public void SelectTCName(String tcName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(TC_nameDropDownList, tcName);
	}
	public void EnterTcTarget(String tcTarget) throws InterruptedException
	{
		Thread.sleep(3000);
		TC_TargetTextBox.sendKeys(tcTarget);
	}
	public void ClickAddTcTargetButton()
	{
		Tc_targetAddbutton.click();
	}
	public void SelectAdvanceTranche (String yes)
	{
		SelectDropDownList.selectDropDownListByVisibleText(AdvanceTrancheDrpDownList, yes);
		
	}
	public void EnterpercentageOfAdvanceTextBox (String amount)
	{
		percentageOfAdvanceTextBox.sendKeys(amount);
		
	}
	
	public void ClickAmountTobeOfAdvance()
	{
		AmountTobeOfAdvanceTextBox.click();
		
	}
	public void ClickAdvanceAdd()
	{
		AdvanceAddButton.click();
	}
	public void ClickSaveAndSubmitButton()
	{
		SaveAndButton.click();
	}
	
	
	public void ClickOnAddSectorsAndjobRole()
	{
		AddSectorsAndjobRoleButton.click();
	}
	
	public  void ClickOnAction()
	{
		Action_Icon.click();
	}
	public void ClickOnViewGenerated_Termsheet()
	{
		ViewGenerated_Termsheet.click();
	}
	}

