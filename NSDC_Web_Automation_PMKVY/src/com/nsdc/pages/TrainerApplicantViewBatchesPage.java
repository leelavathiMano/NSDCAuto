package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsdc.generic.SelectDropDownList;

public class TrainerApplicantViewBatchesPage
{
	WebDriver driver;
	@FindBy(xpath="(//a[@class='m-menu__link m-menu__toggle']/span[2])[1]")
	private WebElement applicantDashboardLink;
	@FindBy(xpath="//button[@class='close align-data']")
	private WebElement viewTC_CommentsCloseButton;
	//Fees Payment Elements
	@FindBy(xpath="//select[@formcontrolname='modeOfPayment']")
	private WebElement modeOfPaymentDropdownList;
	@FindBy(xpath="//select[@formcontrolname='nameOfBank']")
	private WebElement bankNameDropdownList;
	@FindBy(xpath="//input[@formcontrolname='refNo']")
	private WebElement referenceNumberTextField;
	@FindBy(xpath="//input[@formcontrolname='dateOfPayment']")
	private WebElement dateOfPaymentTextField;
	@FindBy(xpath="//span[i[@class='la la-calendar-check-o']]")
	private WebElement closePaymentDateCalenderIcon;
	@FindBy(xpath="//textarea[@formcontrolname='remarks']")
	private WebElement paymentRemarksTextArea;
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement submitPaymetDetailsButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;	
	@FindBy(id="Search")
	private WebElement searchForBatchIDTextField;
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	private WebElement applySearchFilterButton;
	
	public TrainerApplicantViewBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToGoToApplicantDashboard()
	{
		applicantDashboardLink.click();
	}
	public void enterBatchIDTosearch(String batchID)
	{
		searchForBatchIDTextField.clear();
		searchForBatchIDTextField.sendKeys(batchID);
	}
	public void clickToGetSearchResult()
	{
		applySearchFilterButton.click();
	}
	public void clickToGetRejectedBatchActionMenu(String batchID)
	{
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void selectViewCommentsForRejection(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'View Comments')]")).click();
	}
	public void clickToCloseTC_CommentsView()
	{
		viewTC_CommentsCloseButton.click();
	}
	//TC Enrolled Batch Applicant
	public void clickToGetEnrolledBatchActionMenu(String batchID)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")));
		driver.findElement(By.xpath("(//tr[td[text()='"+batchID+"']]//a)[1]")).click();
	}
	public void selectViewDetailsForEnrolledBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'View Details')]")).click();
	}
	public void selectAddPaymentDetailsForEnrolledBatchOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'Add Payment Details')]")).click();
	}
	public void selectProvideFeedbackOption(String batchID)
	{
		driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]//a[contains(text(),'Provide Feedback')]")).click();
	}
	//Payment
	public void selectPaymentMode(String paymentMode)
	{
		SelectDropDownList.selectDropDownListByVisibleText(modeOfPaymentDropdownList, paymentMode);
	}
	public void selectBankName(String bankName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(bankNameDropdownList, bankName);
	}
	public void enterPaymentReferenceNumber(String paymentReferenceNumber)
	{
		referenceNumberTextField.clear();
		referenceNumberTextField.sendKeys(paymentReferenceNumber);
	}
	public void selectDateOfPayment() throws InterruptedException
	{
		dateOfPaymentTextField.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='today day']")).click();
		Thread.sleep(2000);
		closePaymentDateCalenderIcon.click();
	}
	public void enterPaymentRemarks(String paymentRemarks)
	{
		paymentRemarksTextArea.clear();
		paymentRemarksTextArea.sendKeys(paymentRemarks);
	}
	public void clickToSubmitPaymentDetails()
	{
		submitPaymetDetailsButton.click();
	}
	public void clickOK()
	{
		okButton.click();
	}	
}