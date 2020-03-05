package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class Rpl_addTrainerpage {
	WebDriver driver;
	public Rpl_addTrainerpage(WebDriver driver) 
	{
	    this.driver	=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement  MyschemeOrprogram_Action;
	@FindBy(xpath="//a[contains(text(),'View Details')]")
	private WebElement viewDetailsIcon ;
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement Projectlist_Action;
	@FindBy(xpath="//a[contains(text(),'View Details')]")
	private WebElement Projectlist_viewDetailsIcon;
	@FindBy(xpath="//div[p[text()='View Trainers']]")
	private WebElement ViewTrainersTab;
	
	@FindBy(xpath="//div[p[text()='View All Batches']]")
	private WebElement ViewAllBatchesTab;
	@FindBy(xpath="//button[contains(text(),'Add Trainer')]")
	private WebElement AddTrainerButton;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	private WebElement NameTextBox;
	@FindBy(xpath="//input[@formcontrolname='email']")
	private WebElement EmailTextBox;
	@FindBy(xpath="//input[@formcontrolname='phone']")
	private WebElement PhoneTextbox;
	@FindBy(xpath="//input[@value='Adhaar']/..//span")
	private WebElement AdhaarRadioButton;
	@FindBy(xpath="//input[@value='PAN']/..//span")
	private WebElement panRadioButton;
	@FindBy(xpath="//input[@formcontrolname='aadhaar']")
	private WebElement PanOrAadharNumberTextBox;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement PanUploadBrowser;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement UploadButton;
	@FindBy(xpath="(//input[@placeholder='Select Date'])[1]")
	private WebElement  FromDate;
	@FindBy(xpath="(//select[@class='custom-select'])[1]")
	private WebElement  monthDropdownlist;
	@FindBy(xpath="(//select[@class='custom-select'])[2]")
	private WebElement  yearDropdownlist;
	@FindBy(xpath="(//input[@placeholder='Select Date'])[2]")
	private WebElement  ToDate;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement  associatedDocumentsBrowser;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement  associatedDocumentUploadButton;
	@FindBy(xpath="(//select[@formcontrolname='qpCode'])[2]")
	private WebElement  AssociatedJobRolesDropDownlist;
	
	@FindBy(xpath="//button[text()='Generate Otp']")
	private WebElement  GenerateOtpButton;
	@FindBy(xpath="//input[@formcontrolname='phoneOtp']")
	private WebElement  PhoneOtpTextbox;
	@FindBy(xpath="//input[@formcontrolname='emailOtp']")
	private WebElement  EmailOtpTextbox;
	
	@FindBy(xpath="//button[contains(text(),'Verify OTP')]")
	private WebElement VerifyOtpButton;
	//button[contains(text(),'Verify OTP')]
	public void ClickOnAdd_Camps()
	{
		MyschemeOrprogram_Action.click();
	}
	
	public void ClickOnviewDetails()
	{
		viewDetailsIcon.click();
		
	}
	public void Projectlist_Action()
	{
		Projectlist_Action.click();
	}
	public void Projectlist_viewDetailsIcon()
	{
		Projectlist_viewDetailsIcon.click();
	}
	
	public void ClickOnViewTrainers()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ViewTrainersTab);
		//ViewTrainersTab.click();
	}
	public void ClickOnViewAllBatches()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",ViewAllBatchesTab);
		//ViewTrainersTab.click();
	}
	
	public void ClickOnAddTrainer()
	{
		AddTrainerButton.click();
	}
	public void EnterName(String name)
	{
		NameTextBox.sendKeys(name);
	}
	
	public void EnterEmail(String email)
	{
		EmailTextBox.sendKeys(email);
	}
	public void EnterPhoneNumber(String Phonenumber)
	{
		PhoneTextbox.sendKeys(Phonenumber);
	}
	public void ClickOnPanRadio()
	{
		panRadioButton.click();
	}
	
	public void ClickOnAdhaarRadio()
	{
		AdhaarRadioButton.click();
	}
   public void EnterThePanOrAadharNumber(String Aadharnumber)
   {
	   PanOrAadharNumberTextBox.sendKeys(Aadharnumber);
   }
   public void ClickOnPanUploadBrowser()
   {
	   PanUploadBrowser.click();
   }
   public void ClickOnPanUploadButton()
   {
	   UploadButton.click();
   }
   
 ////////////////////////  
   public void ClickOnFromDate()
   {
	   FromDate.click();
   }
   public void SelectFromDate(String fromDate) throws Exception
   {
   	ToT_ToA_Batch_DatePicker.chooseDate(driver, fromDate, FromDate, monthDropdownlist, yearDropdownlist);
   }
   
   public void ClickOnToDate()
   {
	   ToDate.click();
   }
   public void SelectTODate(String toDate) throws Exception
   {
   	ToT_ToA_Batch_DatePicker.chooseDate(driver, toDate, ToDate, monthDropdownlist, yearDropdownlist);
   }
   public void ClickOnassociatedDocumentsBrowser()
   {
	   associatedDocumentsBrowser.click();
   }
   public void ClickOnassociatedDocumentUpload()
   {
	   associatedDocumentUploadButton.click();
   }
   public void SelectAssociatedJobRoles(String jobroles)
   {
	   SelectDropDownList.selectDropDownListByVisibleText(AssociatedJobRolesDropDownlist, jobroles); 
   }
   public void ClickOnGenerateOtp()
   {
	   GenerateOtpButton.click();
   }
   public void EnterMobileOtp(String mobileOtp)
   {
	   PhoneOtpTextbox.sendKeys(mobileOtp);
   }
   public void EnterEmailOtp(String emailOtp)
   {
	   EmailOtpTextbox.sendKeys(emailOtp);
   }
   public void ClickOnVerifyOtp()
   {
	   VerifyOtpButton.click();
   }
}

