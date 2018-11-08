package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class AssessorApplicantSearchAndApplyForAvailableBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="View all Batches")
	private WebElement viewAllBatchesLink;
	@FindBy(linkText="Search Batches")
	private WebElement searchBatchesSectionLink;
	@FindBy(xpath="(//select[@formcontrolname='state'])[1]")
	private WebElement stateDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='district'])[1]")
	private WebElement districtDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='subDistrict'])[1]")
	private WebElement subDistrictDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[1]")
	private WebElement sectorDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[1]")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[1]")
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
	@FindBy(xpath="//button[contains(text(),'Add Job Role & Location to My Preference')]")
	private WebElement addJobRoleAndLocationToMyPreferenceButton;
	@FindBy(xpath="//input[@placeholder='Search for Training Center Name']")
	private WebElement searchTextbox;
	//My Preferences
	@FindBy(linkText="My Preferences")
	private WebElement myPreferencesSectionLink;
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement actionDropdownMenu;
	@FindBy(linkText="Search Against Preference")
	private WebElement searchAgainstPreferenceActionOption;
	@FindBy(linkText="Remove Preference")
	private WebElement removePreferenceActionOption;
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
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="//button[contains(text(),'View My Batches')]")
	private WebElement viewMyBatchesButton;
	
	public AssessorApplicantSearchAndApplyForAvailableBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickToGoToApplicantDashboard()
	{
		applicantDashboardLink.click();
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropdownList, state);
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
	public void enterBatchStartDate(String batchStartDate)
	{
		batchStartDateTextbox.clear();
		batchStartDateTextbox.sendKeys(batchStartDate);
	}
	public void enterBatchEndDate(String batchEndDate)
	{
		batchEndDateTextbox.clear();
		batchEndDateTextbox.sendKeys(batchEndDate);
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
		searchTextbox.clear();
		searchTextbox.sendKeys(searchKeyword);
	}
	public void clickSearchBatches()
	{
		searchBatchesSectionLink.click();
	}
	public void clickMyPreferences()
	{
		myPreferencesSectionLink.click();
	}
	public void clickAddJobRoleAndLocationToMyPreference()
	{
		addJobRoleAndLocationToMyPreferenceButton.click();
	}
	public void clickAction()
	{
		actionDropdownMenu.click();
	}
	public void selectSearchAgainstPreference()
	{
		searchAgainstPreferenceActionOption.click();
	}
	public void selectRemovePreference()
	{
		removePreferenceActionOption.click();
	}
	public void clickToGetBatchActionMenu(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]//a[i]")).click();
	}
	public void selectViewBatchDetails(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'View Batch Details')]")).click();
	}
	public void selectApplyToBatch(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'Apply to the Batch')]")).click();
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
	public void clickGoBack()
	{
		goBackButton.click();
	}
	public void clickViewMyBatches()
	{
		viewMyBatchesButton.click();
	}
	public void clickToGetAcceptedBatchActionMenu(String batchID)
	{
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void selectAcceptedBatchViewDetailsOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'View Details')]")).click();
	}
	public void selectAcceptedBatchProvideFeedbackOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'Provide Feedback')]")).click();
	}
}
