package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SSCAllBatchesPage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextBox;
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement actionButton;
	@FindBy(xpath="//span[contains(text(),' View Details')]")
	private WebElement viewBatchDetailsButton;
	@FindBy(xpath="//span[contains(text(),' Assign Master Trainer')]")
	private WebElement assignMasterTrainerButton;
	@FindBy(xpath="//span[contains(text(),' Assign Assessment Agency')]")
	private WebElement assignAssessmentAgencyButton;
	@FindBy(xpath="//select[@class='form-control ng-pristine ng-valid ng-touched']")
	private WebElement assignMasterTrainerDropDownList;
	@FindBy(xpath="//button[contains(text(),'Assign')]")
	private WebElement assignButton;
	@FindBy(xpath="(//span[contains(text(),'Assign')])[1]")
	private WebElement assignButton1;
	@FindBy(xpath="(//span[contains(text(),'Assign')])[2]")
	private WebElement assignButton2;
	@FindBy(xpath="//button[contains(text(),'Yes, assign it!')]")
	private WebElement assignItButton;
	@FindBy(xpath="//button[contains(text(),'Pending')]")
	private WebElement  viewPendingBatchesButton;
	@FindBy(xpath="//button[contains(text(),'Rejected')]")
	private WebElement viewRejectedBatchesButton;
	@FindBy(xpath="//button[contains(text(),'Rescheduled')]")
	private WebElement viewRescheduledBatchesButton;
	@FindBy(xpath="//button[contains(text(),'Cancelled')]")
	private WebElement viewCancelledBatches;
	@FindBy(xpath="//button[contains(text(),'Published')]")
	private WebElement viewPublisshedBatchesButton;
	@FindBy(xpath="//button[contains(text(),'On-going')]")
	private WebElement viewOnGoingBatchesButton;
	@FindBy(xpath="//button[contains(text(),'Completed')]")
	private WebElement viewCompletedBatchesButton;
	@FindBy(xpath=" //span[contains(text(),' Re-Assign Training Centre')]")
	private WebElement reAssignTrainingCentreOption;
	@FindBy(xpath=" //span[contains(text(),' Rescheduled Batch')]")
	private WebElement resheduleBatchOption;
	@FindBy(linkText="Assign Batch")
	private WebElement assignBatchOption;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	@FindBy(xpath="//span[contains(text(),'Assign Master Trainer')]")
	private WebElement assignMasterTrainerOption;
	@FindBy(xpath="//span[contains(text(),'Assign Assessment Agency')]")
	private WebElement assignAssessmentAgencyOption;
	@FindBy(xpath="(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]")
	private WebElement sedRoleAssignMasterTrainerDropdownList;
	@FindBy(xpath="(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
	private WebElement sedRoleAssignAssessmentAgencyDropdownList;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[1]")
	private WebElement sedAssignButton1;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[2]")
	private WebElement sedAssignButton2;
	
	
	
	public SSCAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterSearchByWord(String search_By_Keyword)
	{
		searchByKeywordTextBox.clear();
		searchByKeywordTextBox.sendKeys(search_By_Keyword);                               
	}
	public void clickActionButton()
	{
		actionButton.click();
	}
	public void clickViewBatchButton()
	{
		viewBatchDetailsButton.click();
	}
	
	public void clickAssignMasterTrainerButton()
	{
		assignMasterTrainerButton.click();
	}
	
	public void clickAssessmentAgencyButton()
	{
		assignAssessmentAgencyButton.click();
	}
	
	public void selectAssignMasterTrainerDropDownList(String assign_MasterTrainer)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignMasterTrainerDropDownList, assign_MasterTrainer);
	}
	
	public void clickAssignButton()
	{
		assignButton.click();
	}
	public void clickSEDAssignButton1()
	{
		sedAssignButton1.click();
	}
	public void clickSEDAssignButton2()
	{
		sedAssignButton2.click();
	}
	
	public void clickAssignItButton()
	{
		assignItButton.click();
	}
	public void clickToViewPendingBatches()
	{
		viewPendingBatchesButton.click();
	}
	public void clickToViewRejectedBatches()
	{
		viewRejectedBatchesButton.click();
	}
	public void clickToViewRescheduledBatches()
	{
		viewRescheduledBatchesButton.click();
	}
	public void clickToViewCancelledBatches()
	{
		viewCancelledBatches.click();
	}
	public void clickToViewPublishedBatches()
	{
		viewPublisshedBatchesButton.click();
	}
	public void clickToViewOnGoingBatches()
	{
		viewOnGoingBatchesButton.click();
	}
	public void clickToViewCompletedBatches()
	{
		viewCompletedBatchesButton.click();
	}
	public void clickToReAssignTrainingCentre()
	{
		reAssignTrainingCentreOption.click();
	}
	public void clickToReSchedueBatch()
	{
		resheduleBatchOption.click();
	}
	public void clickToAssignBatch()
	{
		assignBatchOption.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	public void clickToChooseAssignMasterTrainerOption()
	{
		assignMasterTrainerOption.click();
	}
	public void clickToChooseAssignAssessmentAgencyOption()
	{
		assignAssessmentAgencyOption.click();
	}
	public void selectMasterTrainerForSEDJobrole(String sedMasterTrainer)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sedRoleAssignMasterTrainerDropdownList, sedMasterTrainer);
	}
	public void selectAssessmentAgencyForSEDJobRole(String sesAssessmentAgency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sedRoleAssignAssessmentAgencyDropdownList, sesAssessmentAgency);
	}
	public void clickToAssignMasterTrainer()
	{
		assignButton1.click();
	}
	public void clickToAssignAssessmentAgency()
	{
		//assignButton2.click();
		assignButton1.click();
	}
	public void clickToGoBack()
	{
		backButton.click();
	}
	
	
	
	
	
	
	
	
}