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
	
	@FindBy(xpath="(//select[@formcontrolname='registrationAmountIsRequired'])[1]")
	private WebElement regularTPRegistrationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='registrationAmount'])[1]")
	private WebElement regularTPRegistrationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[1]")
	private WebElement regularTPUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[1]")
	private WebElement regularTPUNBlockingFeeAmountTextbox;
	
	@FindBy(xpath="(//select[@formcontrolname='registrationAmountIsRequired'])[2]")
	private WebElement governmentTPRegistrationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='registrationAmount'])[2]")
	private WebElement governmentTPRegistrationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[2]")
	private WebElement governmentTPUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[2]")
	private WebElement governmentTPUNBlockingFeeAmountTextbox;
	@FindBy(xpath="//a[contains(text(),'Add Another Training Partner Type')]")
	private WebElement addAnotherTrainingPartnerTypeButton;
	
	@FindBy(xpath="//input[@formcontrolname='type']")
	private WebElement tpTypeTextbox;
	@FindBy(xpath="(//select[@formcontrolname='registrationAmountIsRequired'])[3]")
	private WebElement first_TPRegistrationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='registrationAmount'])[3]")
	private WebElement first_TPRegistrationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[3]")
	private WebElement first_TPUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[3]")
	private WebElement first_TPUNBlockingFeeAmountTextbox;
	@FindBy(xpath="//button[contains(text(),'Save & Submit')]")
	private WebElement saveAndSubmitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	
	@FindBy(xpath="(//select[@formcontrolname='registrationAmountIsRequired'])[4]")
	private WebElement second_TPRegistrationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='registrationAmount'])[4]")
	private WebElement second_TPRegistrationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[4]")
	private WebElement second_TPUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[4]")
	private WebElement second_TPUNBlockingFeeAmountTextbox;
	
	@FindBy(xpath="(//select[@formcontrolname='registrationAmountIsRequired'])[5]")
	private WebElement third_TPRegistrationFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='registrationAmount'])[4]")
	private WebElement third_TPRegistrationFeeAmountTextbox;
	@FindBy(xpath="(//select[@formcontrolname='unblockingAmountIsRequired'])[5]")
	private WebElement third_TPUNBlockingFeeDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='unblockingAmount'])[4]")
	private WebElement third_TPUNBlockingFeeAmountTextbox;
	
	@FindBy(xpath="//input[@placeholder='Amount']")
	private WebElement registrationFeeAmountTextbox;
	@FindBy(xpath="//input[@placeholder='Amount ']")
	private WebElement unblockingFeeAmountTextbox;
	
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[1]")
	private WebElement first_RemoveTPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[2]")
	private WebElement second_RemoveTPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[3]")
	private WebElement third_RemoveTPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[4]")
	private WebElement fourth_RemoveTPTypeButton;
	@FindBy(xpath="(//a[text()='Remove Training Partner Type'])[5]")
	private WebElement fifth_RemoveTPTypeButton;
	
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
	private WebElement cancelForSubmitButton;
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath="//button[text()='Cancel']")
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
	
	public void clickOnAddAnotherTP()throws Exception
	{
		Thread.sleep(3000);
		addAnotherTrainingPartnerTypeButton.click();
	}
	
	public void enterTrainingPartnerType(String tpType)
	{
		tpTypeTextbox.clear();
		tpTypeTextbox.sendKeys(tpType);
	}
	
	public void selectFirst_TPRegistrationFee(String first_RegistrationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_TPRegistrationFeeDropDownList, first_RegistrationFee);
	}
	
	public void enterFirst_TPRegistrationFeeAmount(String first_RegistrationFeeAmount)
	{
		first_TPRegistrationFeeAmountTextbox.clear();
		first_TPRegistrationFeeAmountTextbox.sendKeys(first_RegistrationFeeAmount);
	}
	
	public void selectFirst_TPUNBlockingFee(String first_UNBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_TPUNBlockingFeeDropDownList, first_UNBlockingFee);
	}
	
	public void enterFirst_TPUNBlockingFeeAmount(String first_UNBlockingFeeAmount)
	{
		first_TPUNBlockingFeeAmountTextbox.clear();
		first_TPUNBlockingFeeAmountTextbox.sendKeys(first_UNBlockingFeeAmount);
	}
	
	public void clickOnSaveAndSubmit()
	{
		saveAndSubmitButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void selectSecond_TPRegistrationFee(String second_RegistrationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_TPRegistrationFeeDropDownList, second_RegistrationFee);
	}
	
	public void enterSecond_TPRegistrationFeeAmount(String second_RegistrationFeeAmount)
	{
		second_TPRegistrationFeeAmountTextbox.clear();
		second_TPRegistrationFeeAmountTextbox.sendKeys(second_RegistrationFeeAmount);
	}
	
	public void selectSecond_TPUNBlockingFee(String second_UNBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_TPUNBlockingFeeDropDownList, second_UNBlockingFee);
	}
	
	public void enterSecond_TPUNBlockingFeeAmount(String second_UNBlockingFeeAmount)
	{
		second_TPUNBlockingFeeAmountTextbox.clear();
		second_TPUNBlockingFeeAmountTextbox.sendKeys(second_UNBlockingFeeAmount);
	}
	
	public void selectThird_TPRegistrationFee(String third_RegistrationFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_TPRegistrationFeeDropDownList, third_RegistrationFee);
	}
	
	public void enterThird_TPRegistrationFeeAmount(String third_RegistrationFeeAmount)
	{
		third_TPRegistrationFeeAmountTextbox.clear();
		third_TPRegistrationFeeAmountTextbox.sendKeys(third_RegistrationFeeAmount);
	}
	
	public void selectThird_TPUNBlockingFee(String third_UNBlockingFee)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_TPUNBlockingFeeDropDownList, third_UNBlockingFee);
	}
	
	public void enterThird_TPUNBlockingFeeAmount(String third_UNBlockingFeeAmount)
	{
		third_TPUNBlockingFeeAmountTextbox.clear();
		third_TPUNBlockingFeeAmountTextbox.sendKeys(third_UNBlockingFeeAmount);
	}
	
	public void enterRegistrationFeeAmount(String registrationFeeAmount)
	{
		registrationFeeAmountTextbox.clear();
		registrationFeeAmountTextbox.sendKeys(registrationFeeAmount);
	}
	
	public void enterUnblockingFeeAmount(String unblockingFeeAmount)
	{
		unblockingFeeAmountTextbox.clear();
		unblockingFeeAmountTextbox.sendKeys(unblockingFeeAmount);
	}
	
	public void clickOnFirst_RemoveTrainingPartnerType()
	{
		first_RemoveTPTypeButton.click();
	}
	
	public void clickOnSecond_RemoveTrainingPartnerType()
	{
		second_RemoveTPTypeButton.click();
	}
	
	public void clickOnThird_RemoveTrainingPartnerType()
	{
		third_RemoveTPTypeButton.click();
	}
	
	public void clickOnFourth_RemoveTrainingPartnerType()
	{
		fourth_RemoveTPTypeButton.click();
	}
	
	public void clickOnFifth_RemoveTrainingPartnerType()
	{
		fifth_RemoveTPTypeButton.click();
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
	
	public void clickOnCalenderIcon()
	{
		calenderButton.click();
	}
	public void clickOnSubmit()
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
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
