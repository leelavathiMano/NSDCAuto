package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSC_ViewBatchDetailsPage
{
	WebDriver driver;
	//After Batch Creation
	@FindBy(xpath="//button[contains(text(),'Save as Draft')]")
	private WebElement saveAsDraftButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'View All Batches')]")
	private WebElement viewAllBatchesButton;	
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
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	private WebElement batchSubmitOkButton;
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
	@FindBy(xpath="(//input[@type='radio'])[5]")
	private WebElement resultedTrainingCentreradioButton;
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement reAssignTrainingCentreradioButton;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	private WebElement submitSelectedTrainingCentreButton;	
	//Assign Master Trainer
	//DomainQP
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
	@FindBy(xpath="(//a[@class='dropdown-item']/span)[3]")
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
	@FindBy(xpath="(//a[@class='dropdown-item']/span)[4]")
	private WebElement domainAssignAssessmentAgencyActionOptionLink;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])[5]/div")
	private WebElement domainAssessmentAgencyStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])[5]/div")
	private WebElement domainAssessmentAgencyDistrictFilterList;
	@FindBy(xpath="//div[label[contains(text(),'Assessment Agency ID:')]]/input")
	private WebElement domainSearchByAssessmentAgencyIDTextField;
	@FindBy(xpath="(//button[contains(text(),'Search')])[4]")
	private WebElement domainSearchFilterButton2;
	@FindBy(xpath="(//input[@type='radio'])[15]")
	private WebElement domainAssessmentAgencyRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[3]")
	private WebElement domainAssignSelectedAssessmentAgencyButton;
	//Platform AA
	@FindBy(xpath="(//a[@class='dropdown-item']/span)[5]")
	private WebElement platformAssignAssessmentAgencyActionOptionLink;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])[5]/div")
	private WebElement platformAssessmentAgencyStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])[5]/div")
	private WebElement platformAssessmentAgencyDistrictFilterList;
	@FindBy(xpath="//div[label[contains(text(),'Assessment Agency ID:')]]/input")
	private WebElement platformSearchByAssessmentAgencyIDTextField;
	@FindBy(xpath="(//button[contains(text(),'Search')])[4]")
	private WebElement platformSearchFilterButton2;
	@FindBy(xpath="(//input[@type='radio'])[15]")
	private WebElement platformAssessmentAgencyRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[3]")
	private WebElement platformAssignSelectedAssessmentAgencyButton;
	//ReAssign TC
	@FindBy(xpath="//button[contains(text(),'Re-Assign')]")
	private WebElement reAssignTCButton;
	@FindBy(xpath="//input[@placeholder='Enter training centre id']")
	private WebElement reAssignTCSearchTextField;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitReAssignedTrainingCentreButton;
	//Rejection Batch - Two Domain JobRole and One Platform QP elements
	@FindBy(xpath="(//a[@class='dropdown-item']/span[contains(text(),'Assign Master Trainer')])[1]")
	private WebElement domain2AssignMasterTrainerActionOptionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span)[4]")
	private WebElement rplatformAssignMasterTrainerActionOptionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span)[5]")
	private WebElement domain1AssignAssessmentAgencyActionOptionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span)[6]")
	private WebElement domain2AssignAssessmentAgencyActionOptionLink;
	@FindBy(xpath="(//a[@class='dropdown-item']/span)[7]")
	private WebElement rplatformAssignAssessmentAgencyActionOptionLink;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	//ReAssign Actors Elements
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])/div")
	private WebElement reAssignMasterTrainerStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])/div")
	private WebElement reAssignMasterTrainerDistrictFilterList;
	@FindBy(xpath="//input[@type='radio']")
	private WebElement reAssignDomainMasterTrainerRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[1]")
	private WebElement reAssignSelectedDomainMasterTrainerButton;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state'])/div")
	private WebElement reAssignAssessmentAgencyStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district'])/div")
	private WebElement reAssignAssessmentAgencyDistrictFilterList;
	@FindBy(xpath="//input[@type='radio']")
	private WebElement reAssignDomainAssessmentAgencyRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[1]")
	private WebElement reAssignSelectedDomainAssessmentAgencyButton;
	//Domain JobRole ReAssign Assessment Agency elements
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state']/div)[1]")
	private WebElement reAssignDomainJobRoleAssesmentAgencyStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district']/div)[1]")
	private WebElement reAssignDomainJobRoleAssesmentAgencyDistrictFilterList;
	@FindBy(xpath="(//button[contains(text(),'Search')])[1]")
	private WebElement searchFilterButton4;
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement reAssignDomainJobRoleAssesmentAgencyRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[1]")
	private WebElement reAssignSelectedDomainJobRoleAssesmentAgencyButton;
	//Approving Applicants
	@FindBy(xpath="//a[h5[contains(text(),'Batch Details')]]")
	private WebElement batchDetailsSectionText;
	@FindBy(xpath="//a[h5[contains(text(),'Enrolled Applicants')]]")
	private WebElement enrolledApplicantsSectionText;
	@FindBy(xpath="//a[h5[contains(text(),'Approved Applicants')]]")
	private WebElement approvedApplicantsSectionText;
	@FindBy(xpath="//button[contains(text(),'Approve Applicants')]")
	private WebElement approveApplicantsButton;
	@FindBy(xpath="//button[contains(text(),'Approve without Payment')]")
	private WebElement approveWithoutPaymentButton;
	@FindBy(xpath="//button[contains(text(),'View Payment Details')]")
	private WebElement viewPaymentDetailsButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	//Applicants Rejection
	@FindBy(xpath="//angular2-multiselect[@name='rejectReason']/div")
	private WebElement reasonsForRejectingApplicantList;
	@FindBy(xpath="//textarea[@name='remarks']")
	private WebElement remarksForRejectingApplicantTextArea;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement rejectApplicantSubmitButton;
	@FindBy(xpath="//button[contains(text(),'Approve Batch')]")
	private WebElement approveBatchButton;
	@FindBy(xpath="//button[contains(text(),'Send Back Batch')]")
	private WebElement sendBackBatchButton;
	@FindBy(name="remarks")
	private WebElement sendBackBatchRemarksTextArea;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement sendBackBatchSubmitButton;
	@FindBy(xpath="//label[input[@name='confirmation']]")
	private WebElement confirmationCheckbox;
		
	public SSC_ViewBatchDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//After Batch creation and Assigning All Actors 
	public void clickConfirmation()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(confirmationCheckbox));
		confirmationCheckbox.click();
	}
	public void clickSaveAsDraft()
	{
		saveAsDraftButton.click();
	}
	public void clickToSubmitBatch()
	{
		submitButton.click();
	}
	public void clickViewAllBatchesAfterBatchSubmission()
	{
		viewAllBatchesButton.click();
	}
	//Search For Training Centre
	public void selectStateFilter(String sateFilter)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(stateFilterList));
		stateFilterList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+sateFilter+"')])[1]")).click();
	}
	public void selectDistrictFilter(String districtFilter)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(districtFilterList));
		districtFilterList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+districtFilter+"')])[1]")).click();
	}
	public void enterTrainingCentreIDToSearch(String trainingCentreIDToSearchFor) throws InterruptedException
	{
		searchByTrainingCentreIDTextField.clear();
		Thread.sleep(2000);
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(searchFilterButton1));
		searchFilterButton1.click();
	}
	public void clickToChooseResultedTrainingCentreToAssign()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(resultedTrainingCentreradioButton));
		wait.until(ExpectedConditions.elementToBeClickable(resultedTrainingCentreradioButton));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", resultedTrainingCentreradioButton);
	}
	public void clickToChooseResultedTCToReAssign()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(reAssignTrainingCentreradioButton));
		wait.until(ExpectedConditions.elementToBeClickable(reAssignTrainingCentreradioButton));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", reAssignTrainingCentreradioButton);
	}
	public void clickToSubmitSelectedTrainingCentre()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(submitSelectedTrainingCentreButton));
		submitSelectedTrainingCentreButton.click();
	}
	//Assigning Domain QP Master Trainer
	public void clickDomainMasterTrainerAction(String domanJobRole)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[contains(text(),'"+domanJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[1]")));
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domanJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[1]")).click();
	}
	public void selectDomainAssignMasterTrainerOption()
	{
		domainAssignMasterTrainerActionOptionLink.click();
	}	
	public void selectDomainMasterTrainerStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(domainMasterTrainerStateFilterList));
		domainMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectDomainMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(domainMasterTrainerDistrictFilterList));
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(domainSearchFilterButton1));
		domainSearchFilterButton1.click();
	}	
	public void clickToChooseDomainMasterTrainer()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(domainMasterTrainerRadioButton));
		wait.until(ExpectedConditions.elementToBeClickable(domainMasterTrainerRadioButton));
		domainMasterTrainerRadioButton.click();
	}
	public void clickToFinallyAssignSelectedDomainMasterTrainer()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(domainAssignSelectedMasterTrainerButton));
		domainAssignSelectedMasterTrainerButton.click();
	}	
	//Assigning Platform QP Master Trainer
	public void clickPlatformMasterTrainerAction(String platformJobRole)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[contains(text(),'"+platformJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[1]")));
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[1]")).click();
	}
	public void selectPlatformAssignMasterTrainerOption()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(platformAssignMasterTrainerActionOptionLink));
		platformAssignMasterTrainerActionOptionLink.click();
	}
	public void selectPlatformMasterTrainerStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(platformMasterTrainerStateFilterList));
		platformMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}	
	public void selectPlatformMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(platformMasterTrainerDistrictFilterList));
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(platformSearchFilterButton1));
		platformSearchFilterButton1.click();
	}
	public void clickToChoosePlatformMasterTrainer()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(platformMasterTrainerRadioButton));
		wait.until(ExpectedConditions.elementToBeClickable(platformMasterTrainerRadioButton));
		platformMasterTrainerRadioButton.click();
	}
	public void clickToFinallyAssignSelectedPlatformMasterTrainer()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(platformAssignSelectedMasterTrainerButton));
		platformAssignSelectedMasterTrainerButton.click();
	}	
	//Assigning Domain Assessment Agency
	public void clickDomainAssessmentAgencyAction(String domainJobRole)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[td[contains(text(),'"+domainJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[2]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[contains(text(),'"+domainJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[2]")));
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[2]")).click();
	}
	public void selectDomainAssignAssessmentAgencyOption()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(domainAssignAssessmentAgencyActionOptionLink));
		domainAssignAssessmentAgencyActionOptionLink.click();
	}
	public void selectDomainAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(domainAssessmentAgencyStateFilterList));
		domainAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectDomainAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(domainAssessmentAgencyDistrictFilterList));
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(domainSearchFilterButton2));
		domainSearchFilterButton2.click();
	}
	public void clickToChooseDomainAssessmentAgency()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(domainAssessmentAgencyRadioButton));
		wait.until(ExpectedConditions.elementToBeClickable(domainAssessmentAgencyRadioButton));
		domainAssessmentAgencyRadioButton.click();
	}	
	public void clickToFinallyAssignSelectedDomainAssessmentAgency()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(domainAssignSelectedAssessmentAgencyButton));
		domainAssignSelectedAssessmentAgencyButton.click();
	}
	//Assigning Platform QP Assessment Agency
	public void clickPlatformAssessmentAgencyAction(String platformJobRole)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[contains(text(),'"+platformJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[2]")));
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[2]")).click();
	}
	public void selectPlatformAssignAssessmentAgencyOption()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(platformAssignAssessmentAgencyActionOptionLink));
		platformAssignAssessmentAgencyActionOptionLink.click();
	}
	public void selectPlatformAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(platformAssessmentAgencyStateFilterList));
		platformAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}	
	public void selectPlatformAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(platformAssessmentAgencyDistrictFilterList));
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
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(platformSearchFilterButton2));
		platformSearchFilterButton2.click();
	}	
	public void clickToChoosePlatformAssessmentAgency()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(platformAssessmentAgencyRadioButton));
		wait.until(ExpectedConditions.elementToBeClickable(platformAssessmentAgencyRadioButton));
		platformAssessmentAgencyRadioButton.click();
	}
	public void clickToFinallyAssignSelectedPlatformAssessmentAgency()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(platformAssignSelectedAssessmentAgencyButton));
		platformAssignSelectedAssessmentAgencyButton.click();
	}
	//ReAssign TC
	public void clickReassignTC()
	{
		reAssignTCButton.click();
	}
	public void enterReAssignTrainingCentreIDToSearch(String trainingCentreIDToSearchFor) throws InterruptedException
	{
		reAssignTCSearchTextField.clear();
		Thread.sleep(4000);
		reAssignTCSearchTextField.sendKeys(trainingCentreIDToSearchFor);
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
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(batchSubmitOkButton));
		batchSubmitOkButton.click();
	}
	//Rejection Batches - Two Domain Jobroles and One Platform QP
	public void selectDomain2AssignMasterTrainerOption()
	{
		domain2AssignMasterTrainerActionOptionLink.click();
	}
	public void selectrPlatformAssignMasterTrainerOption()
	{
		rplatformAssignMasterTrainerActionOptionLink.click();
	}
	public void selectDomain1AssignAssessmentAgencyOption()
	{
		domain1AssignAssessmentAgencyActionOptionLink.click();
	}
	public void selectDomain2AssignAssessmentAgencyOption()
	{
		domain2AssignAssessmentAgencyActionOptionLink.click();
	}
	public void selectrPlatformAssignAssessmentAgencyOption()
	{
		rplatformAssignAssessmentAgencyActionOptionLink.click();
	}
	public void clickOk()
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(okButton));
		okButton.click();
	}
	//Master Trainer and Assessment Agency Action Menu - View Comments, View Attendence and Reassign Actors
	//Domain Master Trainer Action Menu
	public void selectViewDomainMasterTrainerCommentsOption(String domainJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewDomainMasterTrainerAttendenceOption(String domainJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToCloseDomainMasterTrainerViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[1]")).click();
	}
	public void selectReAssignDomainMasterTrainerOption(String domainJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'Reassign Master Trainer')]")).click();
	}
	//Platform Master Trainer Action Menu
	public void selectViewPlatformMasterTrainerCommentsOption(String platformJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewPlatformMasterTrainerAttendenceOption(String platformJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[1]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToClosePlatformMasterTrainerViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[1]")).click();
	}		
	//Domain Assessment Agency Action Menu
	public void selectReAssignDomainAssessmentAgencyOption(String domainJobroleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("((//tr[td[contains(text(),'"+domainJobroleCode+"')]])[2]//a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobroleCode+"')]])[2]//span[contains(text(),'Reassign Assessment Agency')]")).click();

	}
	public void selectViewDomainAssessmentAgencyCommentsOption(String domainJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("((//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]//a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]//span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewDomainAssessmentAgencyAttendenceOption(String domainJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode+"')]])[2]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToCloseDomainAssessmentAgencyViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[3]")).click();
	}			
	//Platform Assessment Agency Action Menu
	public void selectViewPlatformAssessmentAgencyCommentsOption(String platformJobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]//a/span[contains(text(),'View Comments')]")).click();
	}
	public void selectViewPlatformAssessmentAgencyAttendenceOption(String platformJobRoleCode)throws InterruptedException
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRoleCode+"')]])[2]/td[6]//a/span[contains(text(),'View Attendence')]")).click();
	}
	public void clickToClosePlatformAssessmentAgencyViewCommentsWindow()
	{
		driver.findElement(By.xpath("(//button[@class='close'])[3]")).click();
	}
	//ReAssign All Actors
	public void selectReAssignMasterTrainerState(String state) throws InterruptedException
	{
		reAssignMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+state+"')]")).click();
	}
	public void selectReAssignMasterTrainerDistrict(String district) throws InterruptedException
	{
		reAssignMasterTrainerDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void clickToFinallyReAsssignSelectedDomainMasterTrainer()
	{
		reAssignSelectedDomainMasterTrainerButton.click();
	}
	public void clickToChooseReAssignDomainMasterTrainer()
	{
		reAssignDomainMasterTrainerRadioButton.click();
	}
	public void selectReAssignAssessmentAgencyState(String state) throws InterruptedException
	{
		reAssignAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+state+"')]")).click();
	}
	public void selectReAssignAssessmentAgencyDistrict(String district) throws InterruptedException
	{
		reAssignAssessmentAgencyDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void clickToFinallyReAsssignSelectedDomainAssessmentAgency()
	{
		reAssignSelectedDomainAssessmentAgencyButton.click();
	}
	public void clickToChooseReAssignDomainAssessmentAgency()
	{
		reAssignDomainAssessmentAgencyRadioButton.click();
	}
	public void selectReAssignAssessmentAgencyOptionForJobRole(String jobRoleCode) throws InterruptedException
	{
		driver.findElement(By.xpath("((//tr[td[contains(text(),'"+jobRoleCode+"')]])[2]//a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+jobRoleCode+"')]])[2]//span[contains(text(),'Reassign Assessment Agency')]")).click();
	}
	public void selectReAssignDomainJobRoleAssessmentAgencyState(String state) throws InterruptedException
	{
		reAssignDomainJobRoleAssesmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[1]")).click();
	}
	public void selectReAssignDomainJobRoleAssessmentAgencyDistrict(String district) throws InterruptedException
	{
		reAssignDomainJobRoleAssesmentAgencyDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void clickToChooseReAssignDomainJobroleAssessmentAgency()
	{
		reAssignDomainJobRoleAssesmentAgencyRadioButton.click();
	}
	public void clickToFinallyReAsssignSelectedDomainJobRoleAssessmentAgency()
	{
		reAssignSelectedDomainJobRoleAssesmentAgencyButton.click();
	}
	public void clickToGetDomainJobRoleAssessmentAgencyFilterResult()
	{
		searchFilterButton4.click();
	}
	//Approving And Rejecting Applicants
	public void clickTogoToBatchDetailsSection()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",batchDetailsSectionText);
	}
	public void clickToGoToEnrolledApplicantsSection()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",enrolledApplicantsSectionText);
	}
	public void clickToGoToApprovedApplicantsSection()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",approvedApplicantsSectionText);
	}
	public void clickToSelectApplicantToBeApproved(String applicantID)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//label[input[@type='checkbox']]/span")));
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//label[input[@type='checkbox']]/span")).click();
	}
	public void clickToGetApplicantActionMenu(String applicnatID)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicnatID+"')]]//a[i[@class='la la-ellipsis-h']]")));
	}
	public void selectViewDetailsOfApplicantOption(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[contains(text(),'View Details')]")).click();
	}
	public void selectApproveOfApplicantOption(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[contains(text(),'Approve Applicant')]")).click();
	}
	public void selectApproveWithoutPaymentOption(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[contains(text(),'Approve without Payment')]")).click();
	}
	public void clickToApproveAllSelectedApplicants()
	{
		approveApplicantsButton.click();
	}
	public void clickToViewPaymentDetails()
	{
		viewPaymentDetailsButton.click();
	}
	public void clickGoBack()
	{
		goBackButton.click();
	}
	//Applicants Rejection
	public void selectRejectApplicantOption(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[contains(text(),'Reject Applicant')]")).click();
	}
	public void selectReasonForRejectingApplicant() throws InterruptedException
	{
		reasonsForRejectingApplicantList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Other')]")).click();
	}
	public void enterRemarksForRejectingApplicant()
	{
		remarksForRejectingApplicantTextArea.sendKeys("SSC Rejecting this Applicant");
	}
	public void clickToRejectApplicant()
	{
		rejectApplicantSubmitButton.click();
	}
	public void clickToApproveBatch()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(approveBatchButton));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", approveBatchButton);
	}
	public void clickToSendBackBatch()
	{
		sendBackBatchButton.click();
	}
	public void enterRemarksForSendBackBatch(String sendBackBatchRemarks)
	{
		sendBackBatchRemarksTextArea.clear();
		sendBackBatchRemarksTextArea.sendKeys(sendBackBatchRemarks);
	}
	public void clickToSubmitSendBackBatch()
	{
		sendBackBatchSubmitButton.click();
	}
	public void clickToApproveAllSelectedUnpaidApplicants()
	{
		approveWithoutPaymentButton.click();
	}
}