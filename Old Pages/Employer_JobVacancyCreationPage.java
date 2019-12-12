package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class Employer_JobVacancyCreationPage
{
	WebDriver driver;
    @FindBy(css="input#jobTitle")
    private WebElement jobTitleTextField;
    @FindBy(css="input#jobVacancyCount")
    private WebElement jobVacancyCountTextField;
    @FindBy(css="select#jobSector")
    private WebElement jobSectorDropdownList;
    @FindBy(css="select#RequiredQualification")
    private WebElement eligibilityCriteriaDropdownList;
    @FindBy(css="textarea#jobDescription")
    private WebElement jobDescriptionTextArea;
    @FindBy(css="textarea#selectionProcess")
    private WebElement selectionProcessTextArea;
    @FindBy(css="input#monthlyCompensation")
    private WebElement monthlyCompensationTextField;
    @FindBy(css="input#monthlyincentives")
    private WebElement otherMonthlyIncentivesTextField;
    @FindBy(css="input#workingHours")
    private WebElement workingHoursPerDayTextField;
    @FindBy(css="input#daysoffPerMonth")
    private WebElement daysOffPerMonthTextField;
    @FindBy(css="textarea#address1")
    private WebElement jobLocationAddressTextField;
    @FindBy(css="input#pincode")
    private WebElement jobLocationPincodeTextField;
    @FindBy(css="select#state")
    private WebElement jobLocationStateDropdownList;
    @FindBy(css="select#district")
    private WebElement jobLocationDistrictDropdownList;
    @FindBy(xpath="//button[contains(text(),'Submit & Proceed For Job Fair Spoc')]")
    private WebElement submitAndProceesForJobFairSpocButton;
    @FindBy(css="input[placeholder='Enter Job Fair SPOC Name']")
    private WebElement  jobFairSpocNameTextField;
    @FindBy(css="input#email")
    private WebElement jobFairSpocEmailTextField;
    @FindBy(css="input#mobileNumber")
    private WebElement jobFairSpocMobileNumberTextField;
    @FindBy(xpath="//button[contains(text(),'Submit')]")
    private WebElement submitButton;
    @FindBy(xpath="//button[text()='OK']")
    private WebElement okButton;
    @FindBy(xpath="//button[text()='Offered Job Vacancies']")
    private WebElement offeredJobVacanciesButton;
    @FindBy(xpath="//button[contains(text(),'Post & Submit')]")
    private WebElement postAndSubmitButton;
    
    public Employer_JobVacancyCreationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterJobTitle(String jobTitle)
    {
    	jobTitleTextField.clear();
    	jobTitleTextField.sendKeys(jobTitle);
    }
    public void enterJobVacancyCount(String jobVacancyCount)
    {
    	jobVacancyCountTextField.clear();
    	jobVacancyCountTextField.sendKeys(jobVacancyCount);
    }
    public void  selectJobSector(String jobsector)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(jobSectorDropdownList, jobsector);
    }
    public void selectEligibilityCriteria(String eligibilityCriteria)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(eligibilityCriteriaDropdownList, eligibilityCriteria);
    }
    public void enterJobDescription(String jobDescription)
    {
    	jobDescriptionTextArea.clear();
    	jobDescriptionTextArea.sendKeys(jobDescription);
    }
    public void enterSelectionProcess(String selectionProcess)
    {
    	selectionProcessTextArea.clear();
    	selectionProcessTextArea.sendKeys(selectionProcess);
    }
    public void enterMonthlyCompensation(String monthlyCompensation)
    {
    	monthlyCompensationTextField.clear();
    	monthlyCompensationTextField.sendKeys(monthlyCompensation);
    }
    public void enterOtherMonthlyIncentives(String otherMonthlyIncentives)
    {
    	otherMonthlyIncentivesTextField.clear();
    	otherMonthlyIncentivesTextField.sendKeys(otherMonthlyIncentives);
    }
    public void enterWorkingHoursPerDay(String workingHoursPerDay)
    {
    	workingHoursPerDayTextField.clear();
    	workingHoursPerDayTextField.sendKeys(workingHoursPerDay);
    }
    public void enterDaysOffPerMonth(String daysOffPerMonth)
    {
    	daysOffPerMonthTextField.clear();
    	daysOffPerMonthTextField.sendKeys(daysOffPerMonth);
    }
    public void enterJobLocationAddress(String jobLocationAddress)
    {
    	jobLocationAddressTextField.clear();
    	jobLocationAddressTextField.sendKeys(jobLocationAddress);
    }
    public void enterJobLocationPinCode(String jobLocationPinCode)
    {
    	jobLocationPincodeTextField.clear();
    	jobLocationPincodeTextField.sendKeys(jobLocationPinCode);
    }
    public void selectJobLocationState(String jobLocationstate)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(jobLocationStateDropdownList, jobLocationstate);
    }
    public void selectJobLocationDistrict(String jobLocationDistrict)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(jobLocationDistrictDropdownList, jobLocationDistrict);
    }
    public void clickToSubmitAndProceedForJobFairSpoc()
    {
    	submitAndProceesForJobFairSpocButton.click();
    }
    public void enterJobFairSpocName(String jobFairSpocName)
    {
    	jobFairSpocNameTextField.clear();
    	jobFairSpocNameTextField.sendKeys(jobFairSpocName);
    }
    public void enterJobFairSpocEmail(String jobFairSpocEmail)
    {
    	jobFairSpocEmailTextField.clear();
    	jobFairSpocEmailTextField.sendKeys(jobFairSpocEmail);
    }
    public void enterJobFairSpocMobileNumber(String jobFairSpocMobileNumber)
    {
    	jobFairSpocMobileNumberTextField.clear();
    	jobFairSpocMobileNumberTextField.sendKeys(jobFairSpocMobileNumber);
    }
    public void clickSubmit()
    {
    	submitButton.click();
    }
    public void clickOk()
    {
    	okButton.click();
    }
    public void clickToGoToOfferedJobVacanciesSection()
    {
    	offeredJobVacanciesButton.click();
    }
    public void clickPostAndSubmit()
    {
    	postAndSubmitButton.click();
    }
}