package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SmartBusiness_TCSetupReviewPage
{
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@formcontrolname='govtAccredationAmountIsRequired']")
	private WebElement tcRegularAccrediationFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='govtAccredationAmount']")
	private WebElement tcRegularAccrediationFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='govtContinuousMonitoringAmountIsRequired']")
	private WebElement tcRegularContinuousMonitoringFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='govtContinuousMonitoringAmount']")
	private WebElement tcRegularContinuousMonitoringFeeAmountTextbox;
	@FindBy(xpath="//Select[@formcontrolname='govtUnblockingAmountIsRequired']")
	private WebElement tcRegularUNBlockingFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='govtUnblockingAmount']")
	private WebElement tcRegularUNBlockingFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='govtAffilationAmountIsRequired']")
	private WebElement tcRegularAffiliationFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='govtAffilationAmount']")
	private WebElement tcRegularAffiliationFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='regularAccredationAmountIsRequired']")
	private WebElement tcGovernmentAccrediationFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='regularAccredationAmount']")
	private WebElement tcGovernmentAccrediationFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='regularContinuousMonitoringAmountIsRequired']")
	private WebElement tcGovernmentContinuousMonitoringFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='regularContinuousMonitoringAmount']")
	private WebElement tcGovernmentContinuousMonitoringFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='regularUnblockingAmountIsRequired']")
	private WebElement tcGovernmentUNBlockingFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='regularUnblockingAmount']")
	private WebElement tcGovernmentUNBlockingFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='regularAffilationAmountIsRequired']")
	private WebElement tcGovernmentAffiliationFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='regularAffilationAmount']")
	private WebElement tcGovernmentAffiliationFeeAmountTextbox;
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
	@FindBy(xpath="(//i[@class='la la-angle-right'])[1]")
	private WebElement cornerOfDateButton;
	@FindBy(xpath="//td[@data-date=\"1536364800000\"]")
	private WebElement lastDateButton;
	@FindBy(xpath="//span[@class=\"input-group-text\"]")
	private WebElement calendericonButton;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	
	
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
	}
	
	public void clickForEffectiveDate()
	{
		effectiveDateTextbox.click();
	}
	
	public void clickOnCornerOfDateField()
	{
		cornerOfDateButton.click();
	}
	
	public void clickOnLastDate()
	{
		lastDateButton.click();
	}
	
	public void clickOnCalenderIconButton()
	{
		calendericonButton.click();
	}
	
	public void clickForSubmit()
	{
		submitButton.click();
	}
	
	public void clickForCancel()
	{
		cancelButton.click();
	}
	
	public void clickForOK()
	{
		oKButton.click();
	}

}
