package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class Sp_TrainingCentrePage {
	WebDriver driver;
	public Sp_TrainingCentrePage(WebDriver driver) 
	{
	    this.driver	=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement  SP_Action;
	@FindBy(xpath="(//a[contains(text(),'View Details')])[1]")
	private WebElement viewDetailsIcon ;
	@FindBy(xpath="//div[p[text()='View Training Centres']]")
	private WebElement viewTrainingCentre;
	@FindBy(xpath="//button[text()='Add Training Centre']")
	private WebElement Add_TC_button;
	@FindBy(xpath="//select[@formcontrolname='processType']")
	private WebElement processTypeDropdownlist;
	@FindBy(xpath="//button[text()='Save & Continue']")
	private WebElement SaveAndContinueButton;
	@FindBy(xpath="//input[@formcontrolname='trainingCentreName']")
	private WebElement trainingCentreNameTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='address1']")
	private WebElement AddressTextBox;
	@FindBy(xpath="//input[@formcontrolname='landmark']")
	private WebElement landmarkTextBox;
	@FindBy(xpath="//input[@formcontrolname='pincode']")
	private WebElement PincodeTextBox;
	@FindBy(xpath="(//select[@formcontrolname='name'])[1]")
	private WebElement stateDropdownlist;
	@FindBy(xpath="(//select[@formcontrolname='name'])[2]")
	private WebElement DistrictDropdownlist;
	@FindBy(xpath="(//select[@formcontrolname='name'])[5]")
	private WebElement ParliamentaryConsistuencyDropdownlist;
	@FindBy(xpath="//input[@id='search_places']")
	private WebElement geolacation;
	@FindBy(xpath="//li[@class='currentlocation']/..//a")
	private WebElement currentlocation;
	@FindBy(xpath="//input[@placeholder='Enter Name of the SPOC']")
	private WebElement PrimarySpocNameTextBox;
	@FindBy(xpath="//input[@formcontrolname=\"mobileNumber\"]")
	private WebElement contactNumberTextbox;
	@FindBy(xpath="(//input[@formcontrolname='email'])[1]")
	private WebElement EmailTextbox;
	@FindBy(xpath="//select[@formcontrolname='sectorId']")
	private WebElement SectorDropdownlist;
	@FindBy(xpath="//button[@class='blue-btn btn btn-info']")
	private WebElement AddSectorTargetButton;
	
	@FindBy(xpath="//select[@formcontrolname='qpCode']")
	private WebElement  JobRoleDropDownlist;
	@FindBy(xpath="//input[@formcontrolname='target']")
	private WebElement Traingtarget;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement SubmitButton;
//	////
	@FindBy(xpath="//button[text()='Generate OTP']")
	private WebElement  GenerateOtpButton;
	@FindBy(xpath="//input[@formcontrolname='phoneOtp']")
	private WebElement  PhoneOtpTextbox;
	@FindBy(xpath="//input[@formcontrolname='emailOtp']")
	private WebElement  EmailOtpTextbox;
	
	@FindBy(xpath="//button[contains(text(),'Verify OTP')]")
	private WebElement VerifyOtpButton;
	
	
	
	
	@FindBy(xpath="//button[contains(text(),'Save Changes')]")
	private WebElement SaveChangesButton;
	
	@FindBy(xpath="(//button[text()='Close'])[2]")
	private WebElement CloseButton;
 public void ClickOnSPAction()
	{
		SP_Action.click();
	}
	public void ClickOnViewDetails()
	{
		viewDetailsIcon.click();
	}
	public void ClickonViewTC()
	{

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", viewTrainingCentre);
		//viewCamps.click();
	}
	public void ClickOnAdd_TC()
	{
		Add_TC_button.click();
	}
	
	public void SelectProcessType(String processType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(processTypeDropdownlist, processType);
		
	}
	public void ClickOnSaveAndContinueButton()
	{
		SaveAndContinueButton.click();
	}
	
	public void trainingCentreName(String tcName)
	{
		trainingCentreNameTextBox.sendKeys(tcName);
	}
	
	public void EnterAddress(String address)
	{
		AddressTextBox.sendKeys(address);
	}
	public void Enterlandmark(String landmark)
	{
		landmarkTextBox.sendKeys(landmark);
	}
	public void EnterPincode(String pincode)
	{
		PincodeTextBox.sendKeys(pincode);
	}
	
	
	public void SelectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropdownlist, state);
		
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(DistrictDropdownlist, district);
	
	}
	public void SelectParliamentaryConsistuency(String ParliamentaryConsistuency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(ParliamentaryConsistuencyDropdownlist, ParliamentaryConsistuency);
	
	}
	public void EnterGeolaction(String geolaction)
	{
		geolacation.sendKeys(geolaction);
	}
	public void ClickOncurrentlocation()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", currentlocation);
		
		//currentlocation.click();
	}
	
	
	
	
	public void EnterPrimarySpocName(String Spocname)
	{
		PrimarySpocNameTextBox.sendKeys(Spocname);
	}
	public void EntercontactNumber(String contactnum)
	{
		contactNumberTextbox.sendKeys(contactnum);
	}
	public void EnterEmailid(String email)
	{
		EmailTextbox.sendKeys(email);
	}
	
	public void ClickOnAddSectorTarget()
	{
		AddSectorTargetButton.click();
	}
	public void SelectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(SectorDropdownlist,sector);
		
	}
	public void SelectJobRole(String jobrole)
	{
		SelectDropDownList.selectDropDownListByValue(JobRoleDropDownlist,jobrole );
		//SelectDropDownList.selectDropDownListByVisibleText(JobRoleDropDownlist, jobrole);
		
	}
	public void EnterTrainingTarget(String target)
	{
		Traingtarget.sendKeys(target);
	}
	public void ClickonSubmit()
	{
		SubmitButton.click();
	}
	////
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
	
	  
	
	public void ClickOnSaveChanges()
	{
		SaveChangesButton.click();
	}
	public void ClickOnClose()
	{
		CloseButton.click();
	}
}
