package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.AddingDaysToCurrentDate;
import com.nsdc.generic.SelectDropDownList;

public class TrainerApplicantSearchAndApplyForAvailableBatchesPage
{
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'View My Batches')]")
	private WebElement viewMyBatchesButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(linkText="Search Batches")
	private WebElement searchBatchesButton;
	@FindBy(linkText="My Preferences")
	private WebElement myPreferencesButton;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateOrUtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subDistrict']")
	private WebElement subDistrictDropdownList;
	@FindBy(xpath="//select[@formcontrolname='sector']")
	private WebElement sectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subSector']")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='jobRole']")
	private WebElement jobRoleDropdownList;
	@FindBy(xpath="//select[@title='Select Batch Type']")
	private WebElement batchTypeDropdownList;
	@FindBy(xpath="//select[@title='Select Batch Status']")
	private WebElement batchStatusDropdownList;
	@FindBy(xpath="(//input[@id='date'])[1]")
	private WebElement batchStartDateTextbox;
	@FindBy(xpath="(//input[@id='date'])[2]")
	private WebElement batchEndDateTextbox;
	@FindBy(xpath="(//div[@class='input-group-append'])[1]")
	private WebElement closeBatchStartDateCalender;
	@FindBy(xpath="(//div[@class='input-group-append'])[2]")
	private WebElement closeBatchEndDateCalender;
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(linkText="Edit My Search Parameters")
	private WebElement editMySearchParametersLink;
	@FindBy(xpath="//input[@placeholder='Search for Training Center Name']")
	private WebElement searchForBatchTextbox;
	@FindBy(xpath="//div[@class='dropdown dropup']")
	private WebElement actionDropdownMenu;
	@FindBy(linkText="View Details")
	private WebElement viewDetailsOption;
	@FindBy(linkText="Apply to the batch")
	private WebElement applyToTheBatchOption;
	@FindBy(xpath="//button[contains(text(),'Apply for the Batch')]")
	private WebElement applyForBatchButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement applicantDashboardLink;
	@FindBy(xpath="//button[contains(text(),'Add Job Role & Location to My Preference')]")
	private WebElement addJobRoleAndLocationButton;
	
	@FindBy(xpath="//button[contains(text(),'Add My Preferences')]")
	private WebElement addMyPrefrencesButton;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[2]")
	private WebElement sector_AddPreferencesDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[2]")
	private WebElement subSector_AddPreferencesDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[2]")
	private WebElement jobRole_AddPreferencesDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='state'])[2]")
	private WebElement state_AddPrefrencesDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='district'])[2]")
	private WebElement district_AddPreferencesDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='subDistrict'])[2]")
	private WebElement subDistrict_AddPreferencesDropDownList;
	@FindBy(xpath="//button[contains(text(),'Add Preferences')]")
	private WebElement addPrefrences_button;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	
	@FindBy(xpath="//button[contains(text(),'Search a Batch')]")
	private WebElement searchABatchButton;
	@FindBy(xpath="//span[text()='Select Batch Type']")
	private WebElement batchTypeDropDownList;
	@FindBy(xpath="//span[text()='Select State']")
	private WebElement state_MyBatchesDropDownList;
	@FindBy(xpath="//span[text()='Select District']")
	private WebElement district_MyBatchesDropDownList;
	@FindBy(xpath="//input[@placeholder='Search by Batch ID']")
	private WebElement keywordSearchTextbox;
	
	
	public TrainerApplicantSearchAndApplyForAvailableBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnViewMyBatches()
	{
		viewMyBatchesButton.click();
	}
	
	public void clickOnGoBack()
	{
		goBackButton.click();
	}
	
	public void clickOnSearchBatches()
	{
		searchBatchesButton.click();
	}
	
	public void clickOnMyPreferences()
	{
		myPreferencesButton.click();
	}
	
	public void clickToGoToApplicantDashboard()
	{
		applicantDashboardLink.click();
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateOrUtDropdownList, state);
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropdownList,district);
	}
	public void selectSubDistrict(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrictDropdownList,subDistrict);
	}
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropdownList,sector);
	}
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropdownList,subSector);
	}
	public void selectjobRole(String jobrole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropdownList,jobrole);
	}
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropdownList,batchType);
	}
	public void selectBatchStatus(String batchStatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchStatusDropdownList,batchStatus);
		//batchStatusDropdownList.sendKeys(Keys.TAB);
	}
	public void enterBatchStartDate()
	{
		batchStartDateTextbox.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(16));
	}
	public void enterBatchEndDate()
	{
		batchEndDateTextbox.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(25));
		
	}
	public void clickToCloseBatchStartDateCalender()
	{
		closeBatchStartDateCalender.click();
	}
	public void clickToCloseBatchEndDateCalender()
	{
		closeBatchEndDateCalender.click();
	}
	public void clickSearch()
	{
		searchButton.click();
	}
	public void enterSearchKeyword(String searchKeyword)
	{
		searchForBatchTextbox.clear();
		searchForBatchTextbox.sendKeys(searchKeyword);
	}
	public void clickAction()
	{
		actionDropdownMenu.click();
	}
	public void selectViewDetails()
	{
		viewDetailsOption.click();
	}
	public void selectApplyToBatch()
	{
		applyToTheBatchOption.click();
	}
	public void clickApplyForBatch()
	{
		applyForBatchButton.click();
	}
	public void clickCancel()
	{
		cancelButton.click();
	}
	public void clickOK()
	{
		okButton.click();
	}
	
	public void clickOnAddJobRoleAndLocationToMyPreference()
	{
		addJobRoleAndLocationButton.click();
	}
	
	public void clickOnAddMyPreferences()
	{
		addMyPrefrencesButton.click();
	}
	
	public void selectSector_AddPreferences(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sector_AddPreferencesDropdownList, sector);
	}
	
	public void selectSubSector_AddPreferences(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSector_AddPreferencesDropDownList, subSector);
	}
	
	public void selectJobRole_AddPreferences(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRole_AddPreferencesDropDownList, jobRole);
	}
	
	public void selectState_AddPreferences(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(state_AddPrefrencesDropDownList, state);
	}
	
	public void selectDistrict_AddPreferences(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(district_AddPreferencesDropDownList, district);
	}
	
	public void selectSubDidtrict_AddPreferences(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrict_AddPreferencesDropDownList, subDistrict);
	}
	
	public void clickOnAddPrefrences()
	{
		addPrefrences_button.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void clickOnSearch_a_Batch()
	{
		searchABatchButton.click();
	}
	
	public void selectForBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropDownList, batchType);
	}
	
	public void selectState_MyBatches(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(state_MyBatchesDropDownList, state);
	}
	
	public void selectDistrict_MyBatches(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(district_MyBatchesDropDownList, district);
	}
	
	public void enterKeywordForSearch_MyBatches(String keyword)
	{
		keywordSearchTextbox.clear();
		keywordSearchTextbox.sendKeys(keyword);
	}

}
