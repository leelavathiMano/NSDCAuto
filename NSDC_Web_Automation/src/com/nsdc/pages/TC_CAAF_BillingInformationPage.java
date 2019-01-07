package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TC_CAAF_BillingInformationPage 
{
	
	WebDriver driver;
	
	@FindBy(id="orderBillCity")
	private WebElement cityTextbox;
	@FindBy(id="orderBillCountry")
	private WebElement countryDropDownList;
	@FindBy(xpath="//span[text()='Credit Card']")
	private WebElement creditCardsButton;
	@FindBy(xpath="(//span[text()='Debit Cards'])[2]")
	private WebElement debitCardsButton;
	@FindBy(xpath="(//span[text()='Net Banking'])[2]")
	private WebElement netBankingButton;
	@FindBy(id="creditCardNumber")
	private WebElement creditCardNumberTextbox;
	@FindBy(id="expiryMonthCreditCard")
	private WebElement monthCreditCard_ExpiryDate_DropDownList;
	@FindBy(id="expiryYearCreditCard")
	private WebElement yearCreditCard_ExpiryDate_DropDownList;
	@FindBy(id="CVVNumberCreditCard")
	private WebElement cvvCreditCardTextbox;
	@FindBy(xpath="(//span[text()='Make Payment'])[2]")
	private WebElement makePayment_CreditCard_Button;
	@FindBy(xpath="(//span[text()='Cancel'])[1]")
	private WebElement cancel_CreditCard_Button;
	@FindBy(id="debitCardNumber")
	private WebElement debitCardNumberTextbox;
	@FindBy(id="expiryMonthDebitCard")
	private WebElement monthDebitCard_ExpiryDate_DropDownList;
	@FindBy(id="expiryYearDebitCard")
	private WebElement yearDebitCard_ExpiryDate_DropDownList;
	@FindBy(id="CVVNumberDebitCard")
	private WebElement cvvDebitCardTextbox;
	@FindBy(xpath="(//span[text()='Make Payment'])[4]")
	private WebElement makePayment_DebitCard_Button;
	@FindBy(xpath="(//span[text()='Cancel'])[2]")
	private WebElement cancel_DebitCard_Button;
	@FindBy(id="netBankingBank")
	private WebElement bankNameDropDownList;
	@FindBy(xpath="(//span[text()='Make Payment'])[5]")
	private WebElement makePayment_NetBanking_Button;
	@FindBy(xpath="(//span[text()='Cancel'])[3]")
	private WebElement cancel_NetBanking_Button;
	@FindBy(xpath="//input[@value='Return To the Merchant Site']")
	private WebElement returnToTheMerchantSiteButton;
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueButton;
	
	
	public TC_CAAF_BillingInformationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCity(String city)
	{
		cityTextbox.clear();
		cityTextbox.sendKeys(city);
	}
	
	public void selectCountry(String Country)
	{
		SelectDropDownList.selectDropDownListByVisibleText(countryDropDownList, Country);
	}
	
	public void clickOnCreditCard()
	{
		creditCardsButton.click();
	}
	
	public void clickOnDebitCard()
	{
		debitCardsButton.click();
	}
	
	public void clickOnNetBanking()
	{
		netBankingButton.click();
	}
	
	public void enterCreditCardNumber(String creditCardNumber)
	{
		creditCardNumberTextbox.clear();
		creditCardNumberTextbox.sendKeys(creditCardNumber);
	}
	
	public void selectMonth_ForCreditCard(String month_CreditCard)
	{
		SelectDropDownList.selectDropDownListByVisibleText(monthCreditCard_ExpiryDate_DropDownList, month_CreditCard);
	}
	
	public void selectYear_ForCreditCard(String year_CreditCard)
	{
		SelectDropDownList.selectDropDownListByVisibleText(yearCreditCard_ExpiryDate_DropDownList, year_CreditCard);
	}
	
	public void enterCVVForCreditCard(String cvv_CreditCard)
	{
		cvvCreditCardTextbox.clear();
		cvvCreditCardTextbox.sendKeys(cvv_CreditCard);
	}
	
	public void clickOnMakePaymentForCreditCard()
	{
		makePayment_CreditCard_Button.click();
	}
	
	public void clickOnCancelForCreditCard()
	{
		cancel_CreditCard_Button.click();
	}
	
	public void enterDebitCardNumber(String debitCardNumber)
	{
		debitCardNumberTextbox.clear();
		debitCardNumberTextbox.sendKeys(debitCardNumber);
	}
	
	public void selectMonth_ForDebitCard(String month_DebitCard)
	{
		SelectDropDownList.selectDropDownListByVisibleText(monthDebitCard_ExpiryDate_DropDownList, month_DebitCard);
	}
	
	public void selectYear_ForDebitCard(String year_DebitCard)
	{
		SelectDropDownList.selectDropDownListByVisibleText(yearDebitCard_ExpiryDate_DropDownList, year_DebitCard);
	}
	
	public void enterCVVForDebitCard(String cvv_DebitCard)
	{
		cvvDebitCardTextbox.clear();
		cvvDebitCardTextbox.sendKeys(cvv_DebitCard);
	}
	
	public void clickOnMakePaymentForDebitCard()
	{
		makePayment_DebitCard_Button.click();
	}
	
	public void clickOnCancelForDebitCard()
	{
		cancel_DebitCard_Button.click();
	}
	
	public void selectBankName(String bankName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(bankNameDropDownList, bankName);
	}
	
	public void clickOnMakePaymentForNetBanking()
	{
		makePayment_NetBanking_Button.click();
	}
	
	public void clickOnCancelForNetBanking()
	{
		cancel_NetBanking_Button.click();
	}
	
	public void clickOnReturnToTheMerchantSite()
	{
		returnToTheMerchantSiteButton.click();
	}
	
	public void clickOnContinue()
    {
    	continueButton.click();
    }
	
	
	

}
