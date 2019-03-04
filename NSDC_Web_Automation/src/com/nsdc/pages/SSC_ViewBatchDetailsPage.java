package com.nsdc.pages;

import org.openqa.selenium.By;
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
	@FindBy(xpath="(//input[@type='radio'])[5]")
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
	@FindBy(xpath="(//input[@type='radio'])[5]")
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
	//Domain JobRole 2 ReAssign Assessment Agency elements
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='state']/div)[1]")
	private WebElement reAssignDomainJobRole2AssesmentAgencyStateFilterList;
	@FindBy(xpath="(//angular2-multiselect[@formcontrolname='district']/div)[1]")
	private WebElement reAssignDomainJobRole2AssesmentAgencyDistrictFilterList;
	@FindBy(xpath="(//button[contains(text(),'Search')])[1]")
	private WebElement searchFilterButton4;
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement reAssignDomainJobRole2AssesmentAgencyRadioButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[1]")
	private WebElement reAssignSelectedDomainJobRole2AssesmentAgencyButton;
	//Approving Applicants
	@FindBy(xpath="//a[h5[contains(text(),'Batch Details')]]")
	private WebElement batchDetailsSectionText;
	@FindBy(xpath="//a[h5[contains(text(),'Enrolled Applicants')]]")
	private WebElement enrolledApplicantsSectionText;
	@FindBy(xpath="//a[h5[contains(text(),'Approved Applicants')]]")
	private WebElement approvedApplicantsSectionText;
	@FindBy(xpath="//button[contains(text(),'Approve Applicants')]")
	private WebElement approveApplicantsButton;
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
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(stateFilterList));
		stateFilterList.click();
		driver.findElement(By.xpath("(//label[contains(text(),'"+sateFilter+"')])[1]")).click();
	}
	public void selectDistrictFilter(String districtFilter)
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//angular2-multiselect[@formcontrolname='district'])[1]/div")));
		wait.until(ExpectedConditions.elementToBeClickable(districtFilterList));
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
	public void clickDomainMasterTrainerAction(String domanJobRole)
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domanJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[1]")).click();
	}
	public void selectDomainAssignMasterTrainerOption()
	{
		domainAssignMasterTrainerActionOptionLink.click();
	}	
	public void selectDomainMasterTrainerStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(domainMasterTrainerStateFilterList));
		domainMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectDomainMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
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
	public void clickPlatformMasterTrainerAction(String platformJobRole)
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[1]")).click();
	}
	public void selectPlatformAssignMasterTrainerOption()
	{
		platformAssignMasterTrainerActionOptionLink.click();
	}
	public void selectPlatformMasterTrainerStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(platformMasterTrainerStateFilterList));
		platformMasterTrainerStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}	
	public void selectPlatformMasterTrainerDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
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
	public void clickDomainAssessmentAgencyAction(String domainJobRole)
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[2]")).click();
	}
	public void selectDomainAssignAssessmentAgencyOption()
	{
		domainAssignAssessmentAgencyActionOptionLink.click();
	}
	public void selectDomainAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(domainAssessmentAgencyStateFilterList));
		domainAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}
	public void selectDomainAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
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
		domainSearchFilterButton2.click();
	}
	public void clickToChooseDomainAssessmentAgency()
	{
		domainAssessmentAgencyRadioButton.click();
	}	
	public void clickToFinallyAssignSelectedDomainAssessmentAgency()
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(domainAssignSelectedAssessmentAgencyButton));
		domainAssignSelectedAssessmentAgencyButton.click();
	}
	//Assigning Platform QP Assessment Agency
	public void clickPlatformAssessmentAgencyAction(String platformJobRole)
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+platformJobRole+"')]]//a[i[@class='la la-ellipsis-h']])[2]")).click();
	}
	public void selectPlatformAssignAssessmentAgencyOption()
	{
		platformAssignAssessmentAgencyActionOptionLink.click();
	}
	public void selectPlatformAssessmentAgencyStateFilter(String state) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(platformAssessmentAgencyStateFilterList));
		platformAssessmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[2]")).click();
	}	
	public void selectPlatformAssessmentAgencyDistrictFilter(String district) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
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
	//Domain Job Role 2 Assessment Agency - View Comments option will disappear after reassigning aa for domain job role 1, as same aa for both job role
	public void selectReAssignAssessmentAgencyOptionForDomainJobRole2(String domainJobRoleCode2) throws InterruptedException
	{
		driver.findElement(By.xpath("((//tr[td[contains(text(),'"+domainJobRoleCode2+"')]])[2]//a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+domainJobRoleCode2+"')]])[2]//span[contains(text(),'Reassign Assessment Agency')]")).click();
	}
	public void selectReAssignDomainJobRole2AssessmentAgencyState(String state) throws InterruptedException
	{
		reAssignDomainJobRole2AssesmentAgencyStateFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+state+"')])[1]")).click();
	}
	public void selectReAssignDomainJobRole2AssessmentAgencyDistrict(String district) throws InterruptedException
	{
		reAssignDomainJobRole2AssesmentAgencyDistrictFilterList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+district+"')]")).click();
	}
	public void clickToChooseReAssignDomainJobrole2AssessmentAgency()
	{
		reAssignDomainJobRole2AssesmentAgencyRadioButton.click();
	}
	public void clickToFinallyReAsssignSelectedDomainJobRole2AssessmentAgency()
	{
		reAssignSelectedDomainJobRole2AssesmentAgencyButton.click();
	}
	public void clickToGetDomainJobRole2AssessmentAgencyFilterResult()
	{
		searchFilterButton4.click();
	}
	//Approving And Rejecting Applicants
	public void clickTogoToBatchDetailsSection()
	{
		batchDetailsSectionText.click();
	}
	public void clickToGoToEnrolledApplicantsSection()
	{
		enrolledApplicantsSectionText.click();
	}
	public void clickToGoToApprovedApplicantsSection()
	{
		approvedApplicantsSectionText.click();
	}
	public void clickToSelectApplicantToBeApproved(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//label[input[@type='checkbox']]/span")).click();
	}
	public void clickToGetApplicantActionMenu(String applicnatID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicnatID+"')]]//a[i[@class='la la-ellipsis-h']]")).click();
	}
	public void selectViewDetailsOfApplicantOption(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[contains(text(),'View Details')]")).click();
	}
	public void selectApproveOfApplicantOption(String applicantID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+applicantID+"')]]//a[contains(text(),'Approve Applicant')]")).click();
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
		approveBatchButton.click();
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
}
