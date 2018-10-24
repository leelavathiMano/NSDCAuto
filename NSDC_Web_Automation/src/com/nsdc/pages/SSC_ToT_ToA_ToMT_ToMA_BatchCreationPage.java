package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.nsdc.generic.AddingDaysToCurrentDate;
import com.nsdc.generic.SelectDropDownList;

public class SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage 
{
	WebDriver driver;
	@FindBy(xpath="//select[@formcontrolname='subSector']")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='batchType']")
	private WebElement batchTypeDropdownList;
	@FindBy(xpath="//select[@formcontrolname='reAssessmentBatch']")
	private WebElement batchCategoryDropdownList;
	@FindBy(id="startDates")
	private WebElement trainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[1]")
	private WebElement closeTrainingStartDateCalenderIcon;
	@FindBy(xpath="//div[@class='datepicker-days']")
	private WebElement datePicker;
	@FindBy(id="endDates")
	private WebElement trainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[2]")
	private WebElement closeTrainingEndDateCalenderIcon;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='domainJobRole']/div")
	private WebElement domainJobRoleCheckBoxList;
	@FindBy(xpath="//span[@class='c-angle-up']")
	private WebElement angleUpSVG;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='platformJobRole']/div")
	private WebElement platformJobRoleList;
	@FindBy(xpath="(//label[@class='m-radio m-radio--success']/span)[1]")
	private WebElement domainBaseQpRadioButton;
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[1]")
	private WebElement domainTrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[3]")
	private WebElement closeDomainTrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[1]")
	private WebElement domainTrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[4]")
	private WebElement closeDomainTrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[1]")
	private WebElement domainAssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[5]")
	private WebElement closeDomainAssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[1]")
	private WebElement domainAssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[6]")
	private WebElement closeDomainAssessmentEndDateCalenderIcon;
	//Platform
	@FindBy(xpath="(//label[@class='m-radio m-radio--success']/span)[2]")
	private WebElement platformBaseQpRadioButton;
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[2]")
	private WebElement platformTrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[7]")
	private WebElement closePlatformTrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[2]")
	private WebElement platformTrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[8]")
	private WebElement closePlatformTrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[2]")
	private WebElement platformAssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[9]")
	private WebElement closePlatformAssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[2]")
	private WebElement platformAssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[10]")
	private WebElement closePlatformAssessmentEndDateCalenderIcon;
	@FindBy(xpath="//input[@formcontrolname='batchFees']")
	private WebElement trainingFeesTextField;
	@FindBy(xpath="//button[contains(text(),'View')]")
	private WebElement viewFeesDetailsButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//select[@formcontrolname='batchSize']")
	private WebElement batchSizeDropdownLiast;
	@FindBy(xpath="//button[contains(text(),'Create Batch')]")
	private WebElement createBatchButton;
	@FindBy(linkText="Cancel")
	private WebElement cancelLink;
	//Add Exceptional TC and Search
	@FindBy(xpath="//button[contains(text(),'TC')]")
	private WebElement addExceptionalTCButton;
	@FindBy(xpath="//input[@formcontrolname='trainingPartnerName']")
	private WebElement trainingPartnerNameTextField;
	@FindBy(xpath="//input[@formcontrolname='trainingCenterName']")
	private WebElement exceptionalTrainingCentreNameTextField;
	@FindBy(xpath="//input[@formcontrolname='website']")
	private WebElement websiteTextField;
	@FindBy(xpath="//input[@formcontrolname='trainingCenterCapacity']")
	private WebElement trainingCentreCapacityTextField;
	@FindBy(xpath="(//label[input[@type='checkbox']])[1]")
	private WebElement residentialFacilityAvailableForMaleCheckBox;
	@FindBy(xpath="(//label[input[@type='checkbox']])[2]")
	private WebElement residentialFacilityAvailableForFemaleCheckBox;
	@FindBy(xpath="(//label[input[@type='checkbox']])[3]")
	private WebElement residentialFacilityAvailableForTransgenderCheckBox;
	@FindBy(xpath="(//input[@formcontrolname='contactPersonName'])[1]")
	private WebElement exceptionalTrainingCentreHeadNameTextField;
	@FindBy(xpath="(//input[@formcontrolname='phoneNumber'])[1]")
	private WebElement exceptionalTrainingCentreHeadMobileNumberTextField;
	@FindBy(xpath="(//input[@formcontrolname='emailId'])[1]")
	private WebElement exceptionalTrainingCentreHeadEmailTextField;
	@FindBy(xpath="(//input[@formcontrolname='contactPersonName'])[2]")
	private WebElement exceptionalTrainingCentreSPOCNameTextField;
	@FindBy(xpath="(//input[@formcontrolname='phoneNumber'])[2]")
	private WebElement exceptionalTrainingCentreSPOCMobileNumberTextField;
	@FindBy(xpath="(//input[@formcontrolname='emailId'])[2]")
	private WebElement exceptionalTrainingCentreSPOCEmailTextField;
	@FindBy(id="customFile")
	private WebElement spocIDProofBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement uploadButton1;
	@FindBy(xpath="//input[@formcontrolname='addressLine']")
	private WebElement addressTextField;
	@FindBy(xpath="//input[@formcontrolname='landmark']")
	private WebElement landmarkTextField;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state']/div)[3]")
	private WebElement exceptionalTrainingCentreStateList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district']/div)[3]")
	private WebElement exceptionalTrainingCentreDistrictList;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='subDistrict']/div")
	private WebElement exceptionalTrainingCentreSubDistrictList;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='constituency']/div")
	private WebElement exceptionalTrainingCentreConstituencyList;
	@FindBy(id="search_places")
	private WebElement exceptionalTrainingCentreGeoLocationTextField;
	@FindBy(xpath="//input[@formcontrolname='village']")
	private WebElement exceptionalTrainingCentreVillageTextField;
	@FindBy(xpath="//input[@formcontrolname='pincode']")
	private WebElement exceptionalTrainingCentrePincodeTextField;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement exceptionalTrainingCentrePhotoBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement uploadButton2;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement exceptionalTrainingCentreSupportDocBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement uploadButton3;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='subSector']/div")
	private WebElement subSectorList;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='jobRole']/div")
	private WebElement jobRoleList;
	@FindBy(xpath="(//button[text()='Add'])[1]")
	private WebElement addJobRoleButton;
	@FindBy(xpath="//label[input[@formcontrolname='confirmation']]")
	private WebElement confirmationCheckbox;
	@FindBy(xpath="(//button[text()='Add'])[2]")
	private WebElement addExceptionalTrainingCentreFinalButton;
	@FindBy(xpath="(//button[text()='Assign'])[1]")
	private WebElement assignCurrentlyCreatingExceptionalTrainingCentreButton;
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement closeButton;
	//Searching Exceptional Training Centre
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])[1]/div")
	private WebElement stateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])[1]/div")
	private WebElement districtFilterList;
	@FindBy(xpath="//input[@formcontrolname='trainingCentreId']")
	private WebElement searchByTrainingCentreIDTextField;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='trainingCentreType'])[1]/div")
	private WebElement trainingCentreTypeList;
	@FindBy(xpath="(//button[contains(text(),'Search')])[1]")
	private WebElement searchFilterButton1;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	private WebElement submitSelectedTrainingCentreButton;
	//Assign Master Trainer
	//DomainQP
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement domainMasterTrainerActionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span[contains(text(),'Assign Master Trainer')])[1]")
	private WebElement domainAssignMasterTrainerActionOptionLink;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])[4]/div")
	private WebElement domainMasterTrainerStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])[4]/div")
	private WebElement domainMasterTrainerDistrictFilterList;
	@FindBy(xpath="//div[label[contains(text(),'Master Trainer ID:')]]/input")
	private WebElement domainSearchByMasterTrainerIDTextField;
	@FindBy(xpath="(//button[contains(text(),'Search')])[3]")
	private WebElement domainSearchFilterButton1;
	@FindBy(xpath="(//td[input[@type='radio']])[5]")
	private WebElement domainMasterTrainerRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[2]")
	private WebElement domainAssignSelectedMasterTrainerButton;
	//platform QP
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[2]")
	private WebElement platformMasterTrainerActionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span[contains(text(),'Assign Master Trainer')])[2]")
	private WebElement platformAssignMasterTrainerActionOptionLink;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])[4]/div")
	private WebElement platformMasterTrainerStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])[4]/div")
	private WebElement platformMasterTrainerDistrictFilterList;
	@FindBy(xpath="//div[label[contains(text(),'Master Trainer ID:')]]/input")
	private WebElement platformSearchByMasterTrainerIDTextField;
	@FindBy(xpath="(//button[contains(text(),'Search')])[3]")
	private WebElement platformSearchFilterButton1;
	@FindBy(xpath="(//td[input[@type='radio']])[5]")
	private WebElement platformMasterTrainerRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[2]")
	private WebElement platformAssignSelectedMasterTrainerButton;
	//domain AA
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[3]")
	private WebElement domainAssessmentAgencyActionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span[contains(text(),'Assign Assessment Agency')])[1]")
	private WebElement domainAssignAssessmentAgencyActionOptionLink;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])[5]/div")
	private WebElement domainAssessmentAgencyStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])[5]/div")
	private WebElement domainAssessmentAgencyDistrictFilterList;
	@FindBy(xpath="//div[label[contains(text(),'Assessment Agency ID:')]]/input")
	private WebElement domainSearchByAssessmentAgencyIDTextField;
	@FindBy(xpath="(//button[contains(text(),'Search')])[4]")
	private WebElement domainSearchFilterButton2;
	@FindBy(xpath="(//td[input[@type='radio']])[5]")
	private WebElement domainAssessmentAgencyRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[3]")
	private WebElement domainAssignSelectedAssessmentAgencyButton;
	//Platform AA
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[4]")
	private WebElement platformAssessmentAgencyActionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span[contains(text(),'Assign Assessment Agency')])[2]")
	private WebElement platformAssignAssessmentAgencyActionOptionLink;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])[5]/div")
	private WebElement platformAssessmentAgencyStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])[5]/div")
	private WebElement platformAssessmentAgencyDistrictFilterList;
	@FindBy(xpath="//div[label[contains(text(),'Assessment Agency ID:')]]/input")
	private WebElement platformSearchByAssessmentAgencyIDTextField;
	@FindBy(xpath="(//button[contains(text(),'Search')])[4]")
	private WebElement platformSearchFilterButton2;
	@FindBy(xpath="(//td[input[@type='radio']])[5]")
	private WebElement platformAssessmentAgencyRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[3]")
	private WebElement platformAssignSelectedAssessmentAgencyButton;
	//After Batch Creation and Exceptional TC
	@FindBy(xpath="//button[contains(text(),'Save as Draft')]")
	private WebElement saveAsDraftButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'View All Batches')]")
	private WebElement viewAllBatchesButton;
	@FindBy(xpath="//input[@class='form-control ng-untouched ng-pristine']")
	private WebElement batchNameReadOnlyTextField;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateDropdownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subDistrict']")
	private WebElement subDistrictDropdownList;
	@FindBy(xpath="//button[text()='Search & Assign Training Centre']")
	private WebElement searchAndAssignTrainingCentreButton;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchTextBox;
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement actionDropdownMenu;
	@FindBy(linkText="View Details")
	private WebElement viewDetailsOptionLink;
	@FindBy(linkText="Assign Batch")
	private WebElement assignBatchOptionLink;
	@FindBy(xpath="(//button[text()='Assign'])[1]")
	private WebElement assignTrainingCentreButton1;
	@FindBy(xpath="(//button[text()='Back'])[1]")
	private WebElement backButton;
	@FindBy(xpath="(//button[text()='Assign'])[2]")
	private WebElement assignTrainingCentreButton2;
	@FindBy(xpath="//button[contains(text(),'Re-Assign')]")
	private WebElement reAssignTCButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitReAssignedTrainingCentreButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	private WebElement batchSubmitOkButton;
	
	public SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropdownList, subSector);
	}
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropdownList, batchType);
	}
	public void selectBatchCategory(String batchCategory)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchCategoryDropdownList, batchCategory);
	}
	public void selectTrainingStartDateForBatch() throws InterruptedException
	{
		trainingStartDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
	}
	public void clickToCloseTrainingStartDateCalender()
	{
		closeTrainingStartDateCalenderIcon.click();
	}
	public void selectTrainingEndDateForNewBatch() throws InterruptedException 
	{
		trainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectTrainingEndDateForExistingBatch() throws InterruptedException
	{	
		trainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
	}
	public void clickToCloseTrainingEndDateCalender()
	{
		closeTrainingEndDateCalenderIcon.click();
	}
	public void selectDomainJobRole(String domainJobRole) throws InterruptedException
	{
		domainJobRoleCheckBoxList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+domainJobRole+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Domain Job Role')]")).click();
	}
	public void selectPlatformJobRole(String platformJobRole) throws InterruptedException
	{
		platformJobRoleList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='"+platformJobRole+"']")).click();
	}
	//Domain QP
	public void clickToChooseDomainQP()
	{
		domainBaseQpRadioButton.click();
	}
	public void selectDomainTrainingStartDate() throws InterruptedException
	{
		domainTrainingStartDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
		
	}
	public void clickTocloseDomainTrainingStartDateCalender()
	{
		closeDomainTrainingStartDateCalenderIcon.click();
	}
	public void selectDomainTrainingEndDateForNewBatch() throws InterruptedException
	{
		domainTrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
		
	}
	public void selectDomainTrainingEndDateForExistingBatch() throws InterruptedException
	{
		domainTrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloseDomainTrainingEndDateCalender()
	{
		closeDomainTrainingEndDateCalenderIcon.click();
	}
	public void selectDomainAssessmentStartDateForNewBatch() throws InterruptedException
	{
		domainAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
	}
	public void selectDomainAssessmentStartDateForExistingBatch() throws InterruptedException
	{
		domainAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloseDomainAssessmentstartDateCalender()
	{
		closeDomainAssessmentStartDateCalenderIcon.click();
	}
	public void selectDomainAssessmentEndDateForNewBatch() throws InterruptedException
	{
		domainAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectDomainAssessmentEndDateForExistingBatch() throws InterruptedException
	{
		domainAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
		
	}
	public void clickToCloseDomainAssessmentEndDateCalender()
	{
		closeDomainAssessmentEndDateCalenderIcon.click();
	}
	//Platform QP
	public void clickToChoosePlatformQP()
	{
		platformBaseQpRadioButton.click();
	}
	public void selectPlatformTrainingStartDate() throws InterruptedException
	{
		platformTrainingStartDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
	}
	public void clickToclosePlatformTrainingStartDateCalender()
	{
		closePlatformTrainingStartDateCalenderIcon.click();
	}
	public void selectPlatformTrainingEndDateForNewBatch() throws InterruptedException
	{
		platformTrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
	}
	public void selectPlatformTrainingEndDateForExistingBatch() throws InterruptedException
	{
		platformTrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToClosePlatformTrainingEndDateCalender()
	{
		closePlatformTrainingEndDateCalenderIcon.click();
	}
	public void selectPlatformAssessmentStartDateForNewBatch() throws InterruptedException
	{
		platformAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
		
	}
	public void selectPlatformAssessmentStartDateForExistingBatch() throws InterruptedException
	{
		platformAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToClosePlatformAssessmentstartDateCalender()
	{
		closePlatformAssessmentStartDateCalenderIcon.click();
	}
	public void selectPlatformAssessmentEndDateForNewBatch() throws InterruptedException
	{
		platformAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectPlatformAssessmentEndDateForExistingBatch() throws InterruptedException
	{
		platformAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("class").contains("disabled"))
			{
				driver.findElement(By.xpath("(//th[@class='next']/i)[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//td[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
	}
	public void clickToClosePlatformAssessmentEndDateCalender()
	{
		closePlatformAssessmentEndDateCalenderIcon.click();
	}
	public void isFeesReadOnly()
	{
		Assert.assertFalse(trainingFeesTextField.isEnabled());
	}
	public void clickToViewFees()
	{
		trainingFeesTextField.click();
	}
	public void clickToGetInDetailBatchFees()
	{
		viewFeesDetailsButton.click();
	}
	public void selectBatchSize(String batchSize)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchSizeDropdownLiast, batchSize);
	}
	public void clickToCreateBatch()
	{
		createBatchButton.click();
	}
	public void clickToCancelBatchCreation()
	{
		cancelLink.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	//Add Exceptional Training Centre and Search
	public void clickAddExceptionalTC()
	{
		addExceptionalTCButton.click();
	}
	public void enterTrainingPartnerName(String tpName)
	{
		trainingPartnerNameTextField.clear();
		trainingPartnerNameTextField.sendKeys(tpName);
	}
	public void enterExceptionalTrainingCentreName(String exceptionalTCName)
	{
		exceptionalTrainingCentreNameTextField.clear();
		exceptionalTrainingCentreNameTextField.sendKeys(exceptionalTCName);
	}
	public void enterWebsite(String website)
	{
		websiteTextField.clear();
		websiteTextField.sendKeys(website);
	}
	public void enterExceptionalTrainingCentreCapacity(String capacity)
	{
		trainingCentreCapacityTextField.clear();
		trainingCentreCapacityTextField.sendKeys(capacity);
	}
	public void selectResidentialFacilityAvailableForAll()
	{
		residentialFacilityAvailableForMaleCheckBox.click();
		residentialFacilityAvailableForFemaleCheckBox.click();
		residentialFacilityAvailableForTransgenderCheckBox.click();
	}
	public void selectResidentialFacilityAvailableForOnlyMale()
	{
		residentialFacilityAvailableForMaleCheckBox.click();
	}
	public void selectResidentialFacilityAvailableForOnlyFemale()
	{
		residentialFacilityAvailableForFemaleCheckBox.click();
	}
	public void selectResidentialFacilityAvailableForOnlyTransgender()
	{
		residentialFacilityAvailableForTransgenderCheckBox.click();
	}
	public void enterExceptionalTrainingCentreHeadName(String exceptionalTCHeadName)
	{
		exceptionalTrainingCentreHeadNameTextField.clear();
		exceptionalTrainingCentreHeadNameTextField.sendKeys(exceptionalTCHeadName);
	}
	public void enterExceptionalTrainingCentreHeadMobile(String exceptionalTCHeadMobile)
	{
		exceptionalTrainingCentreHeadMobileNumberTextField.clear();
		exceptionalTrainingCentreHeadMobileNumberTextField.sendKeys(exceptionalTCHeadMobile);
	}
	public void enterExceptionalTrainingCentreHeadEmail(String exceptionalTCHeadEmail)
	{
		exceptionalTrainingCentreHeadEmailTextField.clear();
		exceptionalTrainingCentreHeadEmailTextField.sendKeys(exceptionalTCHeadEmail);
	}
	public void enterExceptionalTrainingCentreSPOCName(String exceptionalTCSPOCName)
	{
		exceptionalTrainingCentreSPOCNameTextField.clear();
		exceptionalTrainingCentreSPOCNameTextField.sendKeys(exceptionalTCSPOCName);
	}
	public void enterExceptionalTrainingCentreSPOCMobile(String exceptionalTCSPOCMobile)
	{
		exceptionalTrainingCentreSPOCMobileNumberTextField.clear();
		exceptionalTrainingCentreSPOCMobileNumberTextField.sendKeys(exceptionalTCSPOCMobile);
	}
	public void enterExceptionalTrainingCentreSPOCEmail(String exceptionalTCSPOCEmail)
	{
		exceptionalTrainingCentreSPOCEmailTextField.clear();
		exceptionalTrainingCentreSPOCEmailTextField.sendKeys(exceptionalTCSPOCEmail);
	}
	public void clickToBrowseExceptionalTCSPOCIDProof()
	{
		spocIDProofBrowseButton.click();
	}
	public void clickToUploadExceptionalTCSPOCIDProof()
	{
		uploadButton1.click();
	}
	public void enterExceptionalTCAddress(String exceptionalTCAddress)
	{
		addressTextField.clear();
		addressTextField.sendKeys(exceptionalTCAddress);
	}
	public void enterExceptionalTCLandmark(String exceptionalTCLandmark)
	{
		landmarkTextField.clear();
		landmarkTextField.sendKeys(exceptionalTCLandmark);
	}
	public void selectExceptionalTCState(String exceptionalTCState)
	{
		exceptionalTrainingCentreStateList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+exceptionalTCState+"')])[2]")).click();
	}
	public void selectExsceptionalTCDistrict(String exceptionalTCDistrict)
	{
		exceptionalTrainingCentreDistrictList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionalTCDistrict+"')]")).click();
	}
	public void selectExceptionalTCSubDistrict(String exceptionTCSubDistrict)
	{
		exceptionalTrainingCentreSubDistrictList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionTCSubDistrict+"')]")).click();
	}
	public void selectExceptionalTCConstituency(String exceptionTCConstituency)
	{
		exceptionalTrainingCentreConstituencyList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionTCConstituency+"')]")).click();
	}
	public void enterExceptionalTrainingCentreGeoLocation(String exceptionalTCGeoLocation) throws InterruptedException
	{
		exceptionalTrainingCentreGeoLocationTextField.clear();
		exceptionalTrainingCentreGeoLocationTextField.sendKeys(exceptionalTCGeoLocation);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//li/a/span[contains(text(),'"+exceptionalTCGeoLocation+"')])[1]")).click();
	}
	public void enterExceptionalTrainingCentreVillage(String exceptionalTCVillage)
	{
		exceptionalTrainingCentreVillageTextField.clear();
		exceptionalTrainingCentreVillageTextField.sendKeys(exceptionalTCVillage);
	}
	public void enterExceptionalTrainingCentrePincode(String exceptionalTCPincode)
	{
		exceptionalTrainingCentrePincodeTextField.clear();
		exceptionalTrainingCentrePincodeTextField.sendKeys(exceptionalTCPincode);
	}
	public void clickToBrowseExceptionalTrainingCentrePhoto()
	{
		exceptionalTrainingCentrePhotoBrowseButton.click();
	}
	public void clickToUploadExceptionalTrainingCentrePhoto()
	{
		uploadButton2.click();
	}
	public void clickToBrowseExceptionalTrainingCentreSupportDoc()
	{
		exceptionalTrainingCentreSupportDocBrowseButton.click();
	}
	public void clickToUploadExceptionalTrainingCentreSupportDoc()
	{
		uploadButton3.click();
	}
	public void selectExceptionalTrainingCentreSubSector(String exceptionalTCSubSector)
	{
		subSectorList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+exceptionalTCSubSector+"')])[2]")).click();
	}
	public void selectExceptionalTrainingCentreJobRole(String exceptionalTCJobRole)
	{
		jobRoleList.click();
		driver.findElement(By.xpath("//label[contains(text(),'"+exceptionalTCJobRole+"')]")).click();
	}
	public void clickToAddJobRole()
	{
		addJobRoleButton.click();
	}
	public void clickToConfirmDeclaration()
	{
		confirmationCheckbox.click();
	}
	public void clickToFinallyCreateExceptionalTrainingCentre()
	{
		addExceptionalTrainingCentreFinalButton.click();
	}
	public void clickToAssignCurrentlyCreatingExceptionalTrainingCentre()
	{
		assignCurrentlyCreatingExceptionalTrainingCentreButton.click();
	}
	public void clickClose()
	{
		closeButton.click();
	}
	//Search For Training Centre
	public void selectStateFilter(String sateFilter)
	{
		stateFilterList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+sateFilter+"')])[1]")).click();
	}
	public void selectDistrictFilter(String districtFilter)
	{
		districtFilterList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+districtFilter+"')])[1]")).click();
	}
	public void enterTrainingCentreIDToSearch(String trainingCentreIDToSearchFor) throws InterruptedException
	{
		searchByTrainingCentreIDTextField.clear();
		Thread.sleep(4000);
		searchByTrainingCentreIDTextField.sendKeys(trainingCentreIDToSearchFor);
	}
	public void selectExceptionalTrainingCentreTypeFilter() throws InterruptedException
	{
		trainingCentreTypeList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'exceptional')])[1]")).click();
	}
	public void clickToGetSearchFilterResult()
	{
		searchFilterButton1.click();
	}
	public void clickToChooseResultedTrainingCentreToAssign(String searchedTrainingCentreID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+searchedTrainingCentreID+"')]]/td/input[@type='radio']")).click();
	}
	public void clickToSubmitSelectedTrainingCentre()
	{
		submitSelectedTrainingCentreButton.click();
	}
	//Assigning Domain QP Master Trainer
	public void clickDomainMasterTrainerAction()
	{
		domainMasterTrainerActionLink.click();
	}
	public void clickDomainAssignMasterTrainerOption()
	{
		domainAssignMasterTrainerActionOptionLink.click();
	}
	//After just creating New TC - Variation in State and district filter numbering, so using newprefix for method name
	public void newSelectDomainMasterTrainerStateFilter(String state) throws InterruptedException
	{
		domainMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[3]")).click();
	}
	public void newSelectDomainMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		domainMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+district+"')])[2]")).click();
	}
	public void selectDomainMasterTrainerStateFilter(String state) throws InterruptedException
	{
		domainMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectDomainMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		domainMasterTrainerDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void enterDomainMasterTrainerIDToSearch(String masterTrainerID)
	{
		domainSearchByMasterTrainerIDTextField.clear();
		domainSearchByMasterTrainerIDTextField.sendKeys(masterTrainerID);
	}
	public void clickToGetDomainMasterSearchFilterResult()
	{
		domainSearchFilterButton1.click();
	}
	public void clickToChooseDomainMasterTrainer()
	{
		domainMasterTrainerRadioButton.click();
	}
	public void clickToFinallyAssignSelectedDomainMasterTrainer()
	{
		domainAssignSelectedMasterTrainerButton.click();
	}
	//Assigning Platform QP Master Trainer
	public void clickPlatformMasterTrainerAction()
	{
		platformMasterTrainerActionLink.click();
	}
	public void clickPlatformAssignMasterTrainerOption()
	{
		platformAssignMasterTrainerActionOptionLink.click();
	}
	public void newSelectPlatformMasterTrainerStateFilter(String state) throws InterruptedException
	{
		platformMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[3]")).click();
	}
	public void newSelectPlatformMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		platformMasterTrainerDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+district+"')])[2]")).click();
	}
	public void selectPlatformMasterTrainerStateFilter(String state) throws InterruptedException
	{
		platformMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectPlatformMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		platformMasterTrainerDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void enterPlatformMasterTrainerIDToSearch(String masterTrainerID)
	{
		platformSearchByMasterTrainerIDTextField.clear();
		platformSearchByMasterTrainerIDTextField.sendKeys(masterTrainerID);
	}
	public void clickToGetPlatformMasterSearchFilterResult()
	{
		platformSearchFilterButton1.click();
	}
	public void clickToChoosePlatformMasterTrainer()
	{
		platformMasterTrainerRadioButton.click();
	}
	public void clickToFinallyAssignSelectedPlatformMasterTrainer()
	{
		platformAssignSelectedMasterTrainerButton.click();
	}
	//Assigning Domain Assessment Agency
	public void clickDomainAssessmentAgencyAction()
	{
		domainAssessmentAgencyActionLink.click();
	}
	public void clickDomainAssignAssessmentAgencyOption()
	{
		domainAssignAssessmentAgencyActionOptionLink.click();
	}
	public void newSelectDomainAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		domainAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[3]")).click();
	}
	public void newSelectDomainAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		domainAssessmentAgencyDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+district+"')])[2]")).click();
	}
	public void selectDomainAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		domainAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectDomainAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		domainAssessmentAgencyDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void enterDomainAssessmentAgencyIDToSearch(String assessmentAgencyID)
	{
		domainSearchByAssessmentAgencyIDTextField.clear();
		domainSearchByAssessmentAgencyIDTextField.sendKeys(assessmentAgencyID);
	}
	public void clickToGetDomainAssessmentAgencySearchFilterResult()
	{
		domainSearchFilterButton2.click();
	}
	public void clickToChooseDomainAssessmentAgency()
	{
		domainAssessmentAgencyRadioButton.click();
	}
	public void clickToFinallyAssignSelectedDomainAssessmentAgency()
	{
		domainAssignSelectedAssessmentAgencyButton.click();
	}
	//Assigning Platform QP Assessment Agency
	public void clickPlatformAssessmentAgencyAction()
	{
		platformAssessmentAgencyActionLink.click();
	}
	public void clickPlatformAssignAssessmentAgencyOption()
	{
		platformAssignAssessmentAgencyActionOptionLink.click();
	}
	public void newSelectPlatformAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		platformAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[3]")).click();
	}
	public void newSelectPlatformAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		platformAssessmentAgencyDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+district+"')])[2]")).click();
	}
	public void selectPlatformAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		platformAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectPlatformAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		platformAssessmentAgencyDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void enterPlatformAssessmentAgencyIDToSearch(String assessmentAgencyID)
	{
		platformSearchByAssessmentAgencyIDTextField.clear();
		platformSearchByAssessmentAgencyIDTextField.sendKeys(assessmentAgencyID);
	}
	public void clickToGetPlatformAssessmentAgencySearchFilterResult()
	{
		platformSearchFilterButton2.click();
	}
	public void clickToChoosePlatformAssessmentAgency()
	{
		platformAssessmentAgencyRadioButton.click();
	}
	public void clickToFinallyAssignSelectedPlatformAssessmentAgency()
	{
		platformAssignSelectedAssessmentAgencyButton.click();
	}
	//After Batch creation and Exceptional TC 
	public void clickSaveAsDraft()
	{
		saveAsDraftButton.click();
	}
	public void clickToSubmitBatch()
	{
		submitButton.click();
	}
	public void clickBatchAction(String createdBatchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span/div/a")).click();
	}
	public void clickAssignOption(String createdBatchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span/div/div")).click();
	}
	public void clickViewAllBatchesAfterBatchSubmission()
	{
		viewAllBatchesButton.click();
	}
	public void clickViewDetailsOption(String createdBatchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]/td[9]/span/div/div")).click();
	}
	public void clickReassignTC()
	{
		reAssignTCButton.click();
	}
	public void clickToSubmitReAssignedTC()
	{
		submitReAssignedTrainingCentreButton.click();
	}
	public void clickToCancel()
	{
		cancelButton.click();
	}
	public void clickOkForBatchSubmission()
	{
		batchSubmitOkButton.click();
	}
}
