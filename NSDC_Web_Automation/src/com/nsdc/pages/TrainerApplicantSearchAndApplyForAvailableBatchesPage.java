package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsdc.generic.SelectDropDownList;

public class TrainerApplicantSearchAndApplyForAvailableBatchesPage
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
	//@FindBy(xpath="//button[contains(text(),'Search')]")
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement searchButton;
	@FindBy(xpath="//button[contains(text(),'Add Job Role & Location to Training Requests')]")
	private WebElement addJobRoleAndLocationToMyPreferenceButton;
	@FindBy(xpath="//input[@placeholder='Search for Training Centre Name']")
	private WebElement searchTextbox;
	//My Preferences
	@FindBy(xpath="//a[contains(text(),'Training Requests')]")
	private WebElement myPreferencesSectionLink;
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
	@FindBy(xpath="//button[contains(text(),'Add Training Requests')]")
	private WebElement addTrainingRequestsButton;
	@FindBy(xpath="(//select[@formcontrolname='sector'])[2]")
	private WebElement addTrainingRequestSectorDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='subSector'])[2]")
	private WebElement addTrainingRequestSubSectorDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='jobRole'])[2]")
	private WebElement addTrainingRequestJobRoleDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='state'])[2]")
	private WebElement addTrainingRequestStateDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='district'])[2]")
	private WebElement addTrainingRequestDistrictDropdownList;
	@FindBy(xpath="(//select[@formcontrolname='subDistrict'])[2]")
	private WebElement addTrainingRequestSubDistrictDropdownList;
	@FindBy(xpath="(//button[contains(text(),'Add Training Request')])[2]")
	private WebElement addTrainingRequestButton;
	@FindBy(xpath="//button[contains(text(),'Yes, delete it!')]")
	private WebElement yesDeleteItButton;
	
	public TrainerApplicantSearchAndApplyForAvailableBatchesPage(WebDriver driver)
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
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(searchBatchesSectionLink));
		searchBatchesSectionLink.click();
	}
	public void clickMyPreferences()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(myPreferencesSectionLink));
		myPreferencesSectionLink.click();
	}
	public void clickAddJobRoleAndLocationToMyPreference()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(addJobRoleAndLocationToMyPreferenceButton));
		addJobRoleAndLocationToMyPreferenceButton.click();
	}
	public void clickToGetMyPreferenceActionMenu(String preferredSector)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[contains(text(),'"+preferredSector+"')]]//a[i[@class='la la-ellipsis-h']]")));
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector+"')]]//a[i[@class='la la-ellipsis-h']]")).click();
	}
	public void selectSearchAgainstPreference(String preferredSector)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector+"')]]//a[contains(text(),'Search Against Training Requests')]")).click();
	}
	public void selectRemovePreference(String preferredSector)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+preferredSector+"')]]//a[contains(text(),'Remove Training Requests')]")).click();
	}
	public void clickToGetBatchActionMenu(String batchID)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]//a[i]")));
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
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")));
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void selectAcceptedBatchViewDetails(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'View Details')]")).click();
	}
	public void selectAcceptedBatchProvideFeedbackOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'Provide Feedback')]")).click();
	}
	public void selectAddTrainingRequestsSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addTrainingRequestSectorDropdownList, sector);
	}
	public void selectAddTrainingRequestsSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addTrainingRequestSubSectorDropdownList, subSector);
	}
	public void selectAddTrainingRequestsJobRole(String jobrole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addTrainingRequestJobRoleDropdownList, jobrole);
	}
	public void selectAddTrainingRequestsState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addTrainingRequestStateDropdownList, state);
	}
	public void selectAddTrainingRequestsDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addTrainingRequestDistrictDropdownList, district);
	}
	public void selectAddTrainingRequestsSubDistrict(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(addTrainingRequestSubDistrictDropdownList, subDistrict);
	}
	public void clickAddTrainingRequests()
	{
		addTrainingRequestsButton.click();
	}
	public void clickToAddTrainingRequest()
	{
		addTrainingRequestButton.click();
	}
	public void clickToFinallyRemoveTrainingRequest()
	{
		yesDeleteItButton.click();
	}
}