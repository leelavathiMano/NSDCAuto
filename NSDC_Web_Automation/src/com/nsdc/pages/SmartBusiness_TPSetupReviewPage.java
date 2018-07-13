package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SmartBusiness_TPSetupReviewPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//select[@formcontrolname='regularRegistrationAmountIsRequired']")
	private WebElement regularTPRegistrationFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='regularRegistrationAmount']")
	private WebElement regularTPRegistrationFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='regularUnblockingAmountIsRequired']")
	private WebElement regularTPUNBlockingFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='regularUnblockingAmount']")
	private WebElement regularTPUNBlockingFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='govtRegistrationAmountIsRequired']")
	private WebElement governmentTPRegistrationFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='govtRegistrationAmount']")
	private WebElement governmentTPRegistrationFeeAmountTextbox;
	@FindBy(xpath="//select[@formcontrolname='govtUnblockingAmountIsRequired']")
	private WebElement governmentTPUNBlockingFeeDropDownList;
	@FindBy(xpath="//input[@formcontrolname='govtUnblockingAmount']")
	private WebElement governmentTPUNBlockingFeeAmountTextbox;
	@FindBy(xpath="//input[@formcontrolname='noOfBlockAttempts']")
	private WebElement numberOfBlockAttemptsAllowedForTPTextbox;
	@FindBy(xpath="//input[@formcontrolname='durationOfBlock']")
	private WebElement durationOfEachBlockTextbox;
	@FindBy(xpath="//input[@formcontrolname='noOfDaysToCompleteDesktopAssessment']")
	private WebElement desktopAssessmentComplitionInDaysTextbox;
	@FindBy(xpath="//input[@placeholder='Pick your Date']")
	private WebElement effectiveDateTextbox;
	@FindBy (xpath="(//i[@class=\"la la-angle-right\"])[1]")
	private WebElement cornerOfDateButton;
	@FindBy (xpath="//td[@data-date=\"1533340800000\"]")
	private WebElement lastDateButton;
	@FindBy(xpath="//div[@class='input-group-append']")
	private WebElement calenderButton;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement oKButton;
	
	public SmartBusiness_TPSetupReviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	public void selectRegistrationFeeForRegularTP(String registrationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(regularTPRegistrationFeeDropDownList, registrationFee);
	}
	
	public void enterRegistrationFeeAmountForRegularTP(String registrationFeeAmount)
	{
		regularTPRegistrationFeeAmountTextbox.clear();
		regularTPRegistrationFeeAmountTextbox.sendKeys(registrationFeeAmount);
	}
	
	public void selectUNBlockingFeeForRegularTP(String unBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(regularTPUNBlockingFeeDropDownList, unBlockingFee);
	}
	
	public void enterUNBlockingFeeAmountForRegularTP(String unBlockingFeeAmount)
	{
		regularTPUNBlockingFeeAmountTextbox.clear();
		regularTPUNBlockingFeeAmountTextbox.sendKeys(unBlockingFeeAmount);
	}
	
	public void selectRegistrationFeeForGovernmentTP(String registrationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(governmentTPRegistrationFeeDropDownList, registrationFee);
	}
	
	public void enterRegistrationFeeAmountForGovernmentTP(String registrationFeeAmount)
	{
		governmentTPRegistrationFeeAmountTextbox.clear();
		governmentTPRegistrationFeeAmountTextbox.sendKeys(registrationFeeAmount);
	}
	
	public void selectUNBlockingFeeForGovernmentTP(String unBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(governmentTPUNBlockingFeeDropDownList, unBlockingFee);
	}
	
	public void enterUNBlockingFeeAmountForGovernmentTP(String unBlockingFeeAmount)
	{
		governmentTPUNBlockingFeeAmountTextbox.clear();
		governmentTPUNBlockingFeeAmountTextbox.sendKeys(unBlockingFeeAmount);
	}
	
	public void enterNumberOfBlockAttemptAllowedForTP(String blockAttemptNumber)
	{
		numberOfBlockAttemptsAllowedForTPTextbox.clear();
		numberOfBlockAttemptsAllowedForTPTextbox.sendKeys(blockAttemptNumber);
	}
	
	public void enterDurationOfEachBlock(String durationOfBlock)
	{
		durationOfEachBlockTextbox.clear();
		durationOfEachBlockTextbox.sendKeys(durationOfBlock);
	}
	
	public void enterNumberOfDaysForDesktopAssessmentComplition(String daysForDesktopAssessment)
	{
		desktopAssessmentComplitionInDaysTextbox.clear();
		desktopAssessmentComplitionInDaysTextbox.sendKeys(daysForDesktopAssessment);
		desktopAssessmentComplitionInDaysTextbox.sendKeys(Keys.TAB);
	}
	
	public void clickOnEffectiveDate()
	{
		effectiveDateTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER);
	}
	
	/*public void clickOnCornerOfDateField()
	{
		cornerOfDateButton.click();
	}
	
	public void clickOnLastDate()
	{
		lastDateButton.click();
	}*/
	
	public void clickOnCalenderIcon()
	{
		calenderButton.click();
	}
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
