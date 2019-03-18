package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SmartBusiness_TCSetupReviewPage
{
	
	WebDriver driver;
	
	@FindBy(xpath="(//select[@formcontrolname='accredationAmountIsRequired'])[1]")
	private WebElement tcRegularAccrediationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='accredationAmount'])[1]")
	private WebElement tcRegularAccrediationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[1]")
	private WebElement tcRegularContinuousMonitoringFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='continuousMonitoringAmount'])[1]")
	private WebElement tcRegularContinuousMonitoringFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")
	private WebElement tcRegularUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[1]")
	private WebElement tcRegularUNBlockingFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='affilationAmountIsRequired'])[1]")
	private WebElement tcRegularAffiliationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='affilationAmount'])[1]")
	private WebElement tcRegularAffiliationFeeAmountTextbox;
	
	@FindBy(xpath="(//select[@formcontrolname='accredationAmountIsRequired'])[2]")
	private WebElement tcGovernmentAccrediationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='accredationAmount'])[2]")
	private WebElement tcGovernmentAccrediationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[2]")
	private WebElement tcGovernmentContinuousMonitoringFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='continuousMonitoringAmount'])[2]")
	private WebElement tcGovernmentContinuousMonitoringFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")
	private WebElement tcGovernmentUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[2]")
	private WebElement tcGovernmentUNBlockingFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='affilationAmountIsRequired'])[2]")
	private WebElement tcGovernmentAffiliationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='affilationAmount'])[2]")
	private WebElement tcGovernmentAffiliationFeeAmountTextbox;
	
	@FindBy(xpath="//a[contains(text(),'Add Another Training Centre Type')]")
	private WebElement addAnotherTCTypeButton;
	@FindBy(xpath="//input[@formcontrolname='type']")
	private WebElement tcTypeTextbox;
	@FindBy(xpath="(//select[@formcontrolname='accredationAmountIsRequired'])[3]")
	private WebElement first_TCAccrediationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='accredationAmount'])[3]")
	private WebElement first_TCAccrediationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[3]")
	private WebElement first_TCContinuousMonitoringFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='continuousMonitoringAmount'])[3]")
	private WebElement first_TCContinuousMonitoringFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")
	private WebElement first_TCUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[3]")
	private WebElement first_TCUNBlockingFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='affilationAmountIsRequired'])[3]")
	private WebElement first_TCAffiliationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='affilationAmount'])[3]")
	private WebElement first_TCAffiliationFeeAmountTextbox;
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement saveAndSubmitbutton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	
	@FindBy(xpath="(//select[@formcontrolname='accredationAmountIsRequired'])[4]")
	private WebElement second_TCAccrediationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='accredationAmount'])[4]")
	private WebElement second_TCAccrediationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[4]")
	private WebElement second_TCContinuousMonitoringFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='continuousMonitoringAmount'])[4]")
	private WebElement second_TCContinuousMonitoringFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[4]")
	private WebElement second_TCUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[4]")
	private WebElement second_TCUNBlockingFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='affilationAmountIsRequired'])[4]")
	private WebElement second_TCAffiliationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='affilationAmount'])[4]")
	private WebElement second_TCAffiliationFeeAmountTextbox;
	
	@FindBy(xpath="(//select[@formcontrolname='accredationAmountIsRequired'])[5]")
	private WebElement third_TCAccrediationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='accredationAmount'])[5]")
	private WebElement third_TCAccrediationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='continuousMonitoringAmountIsRequired'])[5]")
	private WebElement third_TCContinuousMonitoringFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='continuousMonitoringAmount'])[5]")
	private WebElement third_TCContinuousMonitoringFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[5]")
	private WebElement third_TCUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[5]")
	private WebElement third_TCUNBlockingFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='affilationAmountIsRequired'])[5]")
	private WebElement third_TCAffiliationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='affilationAmount'])[5]")
	private WebElement third_TCAffiliationFeeAmountTextbox;
	
	@FindBy(xpath="//div[label[contains(text(),'Accreditation Fee:')]]//input[@placeholder='Amount']")
	private WebElement accreditationFeeAmountTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Continuous Monitoring Fee :')]]//input[@placeholder='Amount']")
	private WebElement continousMonitoringFeeTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Un-Blocking Fee:')]]//input[@placeholder='Amount']")
	private WebElement unblockingFeeAmountTextbox;
	@FindBy(xpath="//div[label[contains(text(),'Per-Job Role Affiliation Fee :')]]//input[@placeholder='Amount']")
	private WebElement affiliationFeeAmountTextbox;
	
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[1]")
	private WebElement regular_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[2]")
	private WebElement gov_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[3]")
	private WebElement first_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[4]")
	private WebElement second_TC_RemoveButton;
	@FindBy(xpath="(//a[text()='Remove Training Centre Type'])[5]")
	private WebElement third_TC_RemoveButton;
	
	@FindBy(xpath="//input[@formcontrolname='noOfBlockAttempts']")
	private WebElement tcblockedAttemptsNumbersAllowedTextbox;
	@FindBy(xpath="//input[@formcontrolname='durationOfBlock']")
	private WebElement tcDurationOfEachBlockTextbox;
	@FindBy(xpath="//input[@formcontrolname='noOfDaysInAdvanceInspectionDateNotifications']")
	private WebElement tcAdvanceInspectionNotificationInDaysTextbox;
	@FindBy(xpath="//input[@formcontrolname='noOfDaysForOnsiteInspectionAfterDeemedReady']")
	private WebElement deemedReadyTCOnsiteInspectionInDaysTextbox;
	@FindBy(xpath="//input[@formcontrolname='noOfDaysForInspectionAgencyReplyBackOnAssessment']")
	private WebElement inspectionAgencyReplyBackOnAssessmentInDaysTexbox;
	@FindBy(xpath="//input[@formcontrolname='percentageOnRefusalOfCenterInspection']")
	private WebElement refundPercentageOnCentreInspectionRefusalBeforeOneWeekTextbox;
	@FindBy(xpath="//input[@formcontrolname='percentageOnRefusalOfCenterInspection1']")
	private WebElement refundPercentageOnCentreInspectionRefusalBeforeThreeWeekTextbox;
	@FindBy(xpath="//input[@formcontrolname='percentageOnRefusalOfCenterInspection2']")
	private WebElement refundPercentageOnCentreInspectionRefusalOnInspectionDateTextbox;
	@FindBy(xpath="//input[@formcontrolname='refundOnDNRIfTCDoesnotReapply']")
	private WebElement refundPercentageOnDNRTextbox;
	@FindBy(xpath="//input[@formcontrolname='refundOnSecondDNRIfTCDoesnotReapply']")
	private WebElement refundPercentageOnSecondDNRTextbox;
	@FindBy(xpath="//input[@placeholder='Pick your Date']")
	private WebElement effectiveDateTextbox;
	@FindBy(xpath="//span[@class='input-group-text']")
	private WebElement calendericonButton;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelForSubmitButton;
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	
	@FindBy(xpath="(//select[@formcontrolname='appealAmountIsRequired'])[1]")
	private WebElement appealFee_first_DropDownList;
	@FindBy(xpath="(//select[@formcontrolname='appealAmountIsRequired'])[2]")
	private WebElement appealFee_second_DropDownList;
	@FindBy(xpath="(//select[@formcontrolname='appealAmountIsRequired'])[3]")
	private WebElement appealFee_third_DropDownList;
	@FindBy(xpath="(//select[@formcontrolname='appealAmountIsRequired'])[4]")
	private WebElement appealFee_fourth_DropDownList;
	@FindBy(xpath="(//select[@formcontrolname='appealAmountIsRequired'])[5]")
	private WebElement appealFee_fifth_DropDownList;
	
	@FindBy(xpath="(//input[@formcontrolname='appealAmount'])[1]")
	private WebElement appealAmount_first_Textbox;
	@FindBy(xpath="(//input[@formcontrolname='appealAmount'])[2]")
	private WebElement appealAmount_second_Textbox;
	@FindBy(xpath="(//input[@formcontrolname='appealAmount'])[3]")
	private WebElement appealAmount_third_Textbox;
	@FindBy(xpath="(//input[@formcontrolname='appealAmount'])[4]")
	private WebElement appealAmount_fourth_Textbox;
	@FindBy(xpath="(//input[@formcontrolname='appealAmount'])[5]")
	private WebElement appealAmount_fifth_Textbox;
	
	
	public SmartBusiness_TCSetupReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	
	public void selectForRegularTCAccrediationFee(String accrediationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcRegularAccrediationFeeDropDownList, accrediationFee);
	}
	
	public void enterAmountForRegularTCAccrediationFee(String accrediationFeeAmount)
	{
		tcRegularAccrediationFeeAmountTextbox.clear();
		tcRegularAccrediationFeeAmountTextbox.sendKeys(accrediationFeeAmount);
	}
	
	public void selectForRegularTCContinuousMonitoringFee(String continuousMonitoringFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcRegularContinuousMonitoringFeeDropDownList, continuousMonitoringFee);
	}
	
	public void enterAmountForRegularTCContinuousMonitoringFee(String coninuousMonitoringFeeAmount)
	{
		tcRegularContinuousMonitoringFeeAmountTextbox.clear();
		tcRegularContinuousMonitoringFeeAmountTextbox.sendKeys(coninuousMonitoringFeeAmount);
	}
	
	public void selectForRegularTCUNBlockingFee(String unBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcRegularUNBlockingFeeDropDownList, unBlockingFee);
	}
	
	public void enterAmountForRegularTCUNBlockingFee(String unBlockingFeeAmount)
	{
		tcRegularUNBlockingFeeAmountTextbox.clear();
		tcRegularUNBlockingFeeAmountTextbox.sendKeys(unBlockingFeeAmount);
	}
	
	public void selectForRegularTCAffiliationFeePerJobRole(String affiliationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcRegularAffiliationFeeDropDownList, affiliationFee);
	}
	
	public void enterAmountForTCAffiliationFeePerJobRole(String affiliationFeeAmount)
	{
		tcRegularAffiliationFeeAmountTextbox.clear();
		tcRegularAffiliationFeeAmountTextbox.sendKeys(affiliationFeeAmount);
	}
	
	   
	public void selectForGovernmentTCAccrediationFee(String accrediationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcGovernmentAccrediationFeeDropDownList, accrediationFee);
	}
	
	public void enterAmountForGovernmentTCAccrediationFee(String accrediationFeeAmount)
	{
		tcGovernmentAccrediationFeeAmountTextbox.clear();
		tcGovernmentAccrediationFeeAmountTextbox.sendKeys(accrediationFeeAmount);
	}
	
	public void selectForGovernmentTCContinuousMonitoringFee(String continuousMonitoringFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcGovernmentContinuousMonitoringFeeDropDownList, continuousMonitoringFee);
	}
	
	public void enterAmountForGovernmentTCContinuousMonitoringFee(String coninuousMonitoringFeeAmount)
	{
		tcGovernmentContinuousMonitoringFeeAmountTextbox.clear();
		tcGovernmentContinuousMonitoringFeeAmountTextbox.sendKeys(coninuousMonitoringFeeAmount);
	}
	
	public void selectForGovernmentTCUNBlockingFee(String unBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcGovernmentUNBlockingFeeDropDownList, unBlockingFee);
	}
	
	public void enterAmountForGovernmentTCUNBlockingFee(String unBlockingFeeAmount)
	{
		tcGovernmentUNBlockingFeeAmountTextbox.clear();
		tcGovernmentUNBlockingFeeAmountTextbox.sendKeys(unBlockingFeeAmount);
	}
	
	public void selectForGovernmentTCAffiliationFeePerJobRole(String affiliationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcGovernmentAffiliationFeeDropDownList, affiliationFee);
	}
	
	public void enterAmountForGovernmentTCAffiliationFeePerJobRole(String affiliationFeeAmount)
	{
		tcGovernmentAffiliationFeeAmountTextbox.clear();
		tcGovernmentAffiliationFeeAmountTextbox.sendKeys(affiliationFeeAmount);
	}
	
	public void clickOnAddAnotherTrainingCentreType()
	{
		addAnotherTCTypeButton.click();
	}
	
	public void enterTrainingCentreType(String tcType)
	{
		tcTypeTextbox.clear();
		tcTypeTextbox.sendKeys(tcType);
	}
	
	public void selectFirst_TCAccrediationFee(String first_AccrediationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_TCAccrediationFeeDropDownList, first_AccrediationFee);
	}
	
	public void enterFirst_TCAccrediationFee(String first_AccrediationFeeAmount)
	{
		first_TCAccrediationFeeAmountTextbox.clear();
		first_TCAccrediationFeeAmountTextbox.sendKeys(first_AccrediationFeeAmount);
	}
	
	public void selectFirst_TCContinuousMonitoringFee(String first_ContinuousMonitoringFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_TCContinuousMonitoringFeeDropDownList, first_ContinuousMonitoringFee);
	}
	
	public void enterFirst_TCContinuousMonitoringFee(String first_ConinuousMonitoringFeeAmount)
	{
		first_TCContinuousMonitoringFeeAmountTextbox.clear();
		first_TCContinuousMonitoringFeeAmountTextbox.sendKeys(first_ConinuousMonitoringFeeAmount);
	}
	
	public void selectFirst_TCUNBlockingFee(String first_UNBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_TCUNBlockingFeeDropDownList, first_UNBlockingFee);
	}
	
	public void enterFirst_TCUNBlockingFee(String first_UNBlockingFeeAmount)
	{
		first_TCUNBlockingFeeAmountTextbox.clear();
		first_TCUNBlockingFeeAmountTextbox.sendKeys(first_UNBlockingFeeAmount);
	}
	
	public void selectFirst_TCAffiliationFeePerJobRole(String first_AffiliationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_TCAffiliationFeeDropDownList, first_AffiliationFee);
	}
	
	public void enterFirst_TCAffiliationFeePerJobRole(String first_AffiliationFeeAmount)
	{
		first_TCAffiliationFeeAmountTextbox.clear();
		first_TCAffiliationFeeAmountTextbox.sendKeys(first_AffiliationFeeAmount);
	}
	
	public void clickOnSaveAndSubmit()
	{
		saveAndSubmitbutton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void selectSecond_TCAccrediationFee(String second_AccrediationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_TCAccrediationFeeDropDownList, second_AccrediationFee);
	}
	
	public void enterSecond_TCAccrediationFee(String second_AccrediationFeeAmount)
	{
		second_TCAccrediationFeeAmountTextbox.clear();
		second_TCAccrediationFeeAmountTextbox.sendKeys(second_AccrediationFeeAmount);
	}
	
	public void selectSecond_TCContinuousMonitoringFee(String second_ContinuousMonitoringFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_TCContinuousMonitoringFeeDropDownList, second_ContinuousMonitoringFee);
	}
	
	public void enterSecond_TCContinuousMonitoringFee(String second_ConinuousMonitoringFeeAmount)
	{
		second_TCContinuousMonitoringFeeAmountTextbox.clear();
		second_TCContinuousMonitoringFeeAmountTextbox.sendKeys(second_ConinuousMonitoringFeeAmount);
	}
	
	public void selectSecond_TCUNBlockingFee(String second_UNBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_TCUNBlockingFeeDropDownList, second_UNBlockingFee);
	}
	
	public void enterSecond_TCUNBlockingFee(String second_UNBlockingFeeAmount)
	{
		second_TCUNBlockingFeeAmountTextbox.clear();
		second_TCUNBlockingFeeAmountTextbox.sendKeys(second_UNBlockingFeeAmount);
	}
	
	public void selectSecond_TCAffiliationFeePerJobRole(String second_AffiliationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_TCAffiliationFeeDropDownList, second_AffiliationFee);
	}
	
	public void enterSecond_TCAffiliationFeePerJobRole(String second_AffiliationFeeAmount)
	{
		second_TCAffiliationFeeAmountTextbox.clear();
		second_TCAffiliationFeeAmountTextbox.sendKeys(second_AffiliationFeeAmount);
	}
	
	public void selectThird_TCAccrediationFee(String third_AccrediationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_TCAccrediationFeeDropDownList, third_AccrediationFee);
	}
	
	public void enterThird_TCAccrediationFee(String third_AccrediationFeeAmount)
	{
		third_TCAccrediationFeeAmountTextbox.clear();
		third_TCAccrediationFeeAmountTextbox.sendKeys(third_AccrediationFeeAmount);
	}
	
	public void selectThird_TCContinuousMonitoringFee(String third_ContinuousMonitoringFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_TCContinuousMonitoringFeeDropDownList, third_ContinuousMonitoringFee);
	}
	
	public void enterThird_TCContinuousMonitoringFee(String third_ConinuousMonitoringFeeAmount)
	{
		third_TCContinuousMonitoringFeeAmountTextbox.clear();
		third_TCContinuousMonitoringFeeAmountTextbox.sendKeys(third_ConinuousMonitoringFeeAmount);
	}
	
	public void selectThird_TCUNBlockingFee(String third_UNBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_TCUNBlockingFeeDropDownList, third_UNBlockingFee);
	}
	
	public void enterThird_TCUNBlockingFee(String third_UNBlockingFeeAmount)
	{
		third_TCUNBlockingFeeAmountTextbox.clear();
		third_TCUNBlockingFeeAmountTextbox.sendKeys(third_UNBlockingFeeAmount);
	}
	
	public void selectThird_TCAffiliationFeePerJobRole(String third_AffiliationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_TCAffiliationFeeDropDownList, third_AffiliationFee);
	}
	
	public void enterThird_TCAffiliationFeePerJobRole(String third_AffiliationFeeAmount)
	{
		third_TCAffiliationFeeAmountTextbox.clear();
		third_TCAffiliationFeeAmountTextbox.sendKeys(third_AffiliationFeeAmount);
	}
	
	public void enterAccrediatationFeeAmount(String accreditationFeeAmount)
	{
		accreditationFeeAmountTextbox.clear();
		accreditationFeeAmountTextbox.sendKeys(accreditationFeeAmount);
	}
	
	public void enterContinousMonitoringFeeAmount(String continousMonitoringFeeAmount)
	{
		continousMonitoringFeeTextbox.clear();
		continousMonitoringFeeTextbox.sendKeys(continousMonitoringFeeAmount);
	}
	
	public void enterUnblockingFeeAmount(String unblockingFeeAmount)
	{
		unblockingFeeAmountTextbox.clear();
		unblockingFeeAmountTextbox.sendKeys(unblockingFeeAmount);
	}
	
	public void enterAffiliationFeeAmount(String affiliationFeeAmount)
	{
		affiliationFeeAmountTextbox.clear();
		affiliationFeeAmountTextbox.sendKeys(affiliationFeeAmount);
	}
	
	public void clickOnRegular_TCType_Remove()
	{
		regular_TC_RemoveButton.click();
	}
	
	public void clickOnGovernment_TCType_Remove()
	{
		gov_TC_RemoveButton.click();
	}
	
	public void clickOnFirst_TCType_Remove()
	{
		first_TC_RemoveButton.click();
	}
	
	public void clickOnSecond_TCType_Remove()
	{
		second_TC_RemoveButton.click();
	}
	
	public void clickOnThird_TCType_Remove()
	{
		third_TC_RemoveButton.click();
	}
	
	public void enterNumberOfBlockedAttemptsAllowedForTC(String blockedAttemptAllowedNumber)
	{
		tcblockedAttemptsNumbersAllowedTextbox.clear();
		tcblockedAttemptsNumbersAllowedTextbox.sendKeys(blockedAttemptAllowedNumber);
	}
	
	public void enterDurationOfEachBlockForTC(String durationOfBlock)
	{
		tcDurationOfEachBlockTextbox.clear();
		tcDurationOfEachBlockTextbox.sendKeys(durationOfBlock);
	}
	
	public void enterAdvanceInspectionNotificationInDaysForTC(String advanceInspectionNotification)
	{
		tcAdvanceInspectionNotificationInDaysTextbox.clear();
		tcAdvanceInspectionNotificationInDaysTextbox.sendKeys(advanceInspectionNotification);
	}
	
	public void enterOnSiteInspectionIndaysForDeemedReadyTC(String onSiteInspection)
	{
		deemedReadyTCOnsiteInspectionInDaysTextbox.clear();
		deemedReadyTCOnsiteInspectionInDaysTextbox.sendKeys(onSiteInspection);
	}
	
	public void enterNumberOfDaysForInspectionAgencyToReplyBackOnAssessment(String daysForReplyBackOnAssessment)
	{
		inspectionAgencyReplyBackOnAssessmentInDaysTexbox.clear();
		inspectionAgencyReplyBackOnAssessmentInDaysTexbox.sendKeys(daysForReplyBackOnAssessment);
	}
	public void enterRefundPercentageOnCentreInspectionRefusalBeforeOneWeek(String refundPercentageForOneweek)
	{
		refundPercentageOnCentreInspectionRefusalBeforeOneWeekTextbox.clear();
		refundPercentageOnCentreInspectionRefusalBeforeOneWeekTextbox.sendKeys(refundPercentageForOneweek);
	}
	
	public void enterRefundPercentageONCentreInspectionRefusalBeforeThreeWeek(String refundPercentageForThreeWeek)
	{
		refundPercentageOnCentreInspectionRefusalBeforeThreeWeekTextbox.clear();
		refundPercentageOnCentreInspectionRefusalBeforeThreeWeekTextbox.sendKeys(refundPercentageForThreeWeek);
	}
	
	public void enterRefundPercentageForCentreInspectionRefusalOnInspectionDate(String refundPercentageOnInspectionDate)
	{
		refundPercentageOnCentreInspectionRefusalOnInspectionDateTextbox.clear();
		refundPercentageOnCentreInspectionRefusalOnInspectionDateTextbox.sendKeys(refundPercentageOnInspectionDate);
	}
	
	public void enterRefundPercentageOnFirstDNRIfTCNotReapply(String refundPercentageOnFirstDNR)
	{
		refundPercentageOnDNRTextbox.clear();
		refundPercentageOnDNRTextbox.sendKeys(refundPercentageOnFirstDNR);
	}
	
	public void enterRefundPercentageOnSecondDNRIfTCNotReapply(String refundPercentageOnSecondDNR)
	{
		refundPercentageOnSecondDNRTextbox.clear();
		refundPercentageOnSecondDNRTextbox.sendKeys(refundPercentageOnSecondDNR);
		refundPercentageOnSecondDNRTextbox.sendKeys(Keys.TAB);
	}
	
	public void clickForEffectiveDate()throws Exception
	{
		Thread.sleep(2000);
		effectiveDateTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER);
	}
	
	public void clickOnCalenderIconButton()throws Exception
	{
		Thread.sleep(3000);
		calendericonButton.click();
	}
	
	public void clickForSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancelForSubmit()
	{
		cancelForSubmitButton.click();
	}
	
	public void clickOnYes()
	{
		yesButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickForOK()
	{
		oKButton.click();
	}
	
	public void select_First_AppealFee(String appealFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(appealFee_first_DropDownList, appealFee);
	}
	
	public void select_Second_AppealFee(String appealFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(appealFee_second_DropDownList, appealFee);
	}
	
	public void select_Third_AppealFee(String appealFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(appealFee_third_DropDownList, appealFee);
	}
	
	public void select_Fourth_AppealFee(String appealFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(appealFee_fourth_DropDownList, appealFee);
	}
	
	public void select_Fifth_AppealFee(String appealFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(appealFee_fifth_DropDownList, appealFee);
	}
	
	public void enter_First_AppealAmount(String appealAmount)
	{
		appealAmount_first_Textbox.clear();
		appealAmount_first_Textbox.sendKeys(appealAmount);
	}
	
	public void enter_Second_AppealAmount(String appealAmount)
	{
		appealAmount_second_Textbox.clear();
		appealAmount_second_Textbox.sendKeys(appealAmount);
	}
	
	public void enter_Third_AppealAmount(String appealAmount)
	{
		appealAmount_third_Textbox.clear();
		appealAmount_third_Textbox.sendKeys(appealAmount);
	}
	
	public void enter_Fourth_AppealAmount(String appealAmount)
	{
		appealAmount_fourth_Textbox.clear();
		appealAmount_fourth_Textbox.sendKeys(appealAmount);
	}
	
	public void enter_Fifth_AppealAmount(String appealAmount)
	{
		appealAmount_fifth_Textbox.clear();
		appealAmount_fifth_Textbox.sendKeys(appealAmount);
	}

}
