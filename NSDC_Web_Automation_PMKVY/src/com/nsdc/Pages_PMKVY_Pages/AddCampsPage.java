package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class AddCampsPage {

	WebDriver driver;
	public AddCampsPage(WebDriver driver) 
	{
	    this.driver	=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement  RPl_Action;
	@FindBy(xpath="(//a[contains(text(),'View Details')])[1]")
	private WebElement viewDetailsIcon ;
	@FindBy(xpath="//div[p[text()='View Camps']]")
	private WebElement viewCamps;
	@FindBy(xpath="//button[@data-target='#add_camps']")
	private WebElement Add_Camps_button;
	@FindBy(xpath="//input[@formcontrolname='locationName']")
	private WebElement locationNameTextBox;
	@FindBy(xpath="//textarea[@formcontrolname='address1']")
	private WebElement Addresstextbox;
	@FindBy(xpath="//input[@formcontrolname='pinCode']")
	private WebElement PincodeTextBox;
	@FindBy(xpath="(//select[@formcontrolname='name'])[1]")
	private WebElement stateDropdownlist;
	@FindBy(xpath="(//select[@formcontrolname='name'])[2]")
	private WebElement DistrictDropdownlist;
	@FindBy(xpath="(//select[@formcontrolname='name'])[4]")
	private WebElement ParliamentaryConsistuencyDropdownlist;
	@FindBy(xpath="(//input[@placeholder='Enter Name'])[1]")
	private WebElement PrimarySpocNameTextBox;
	@FindBy(xpath="(//input[@placeholder='Enter Contact Number'])[1]")
	private WebElement contactNumberTextbox;
	@FindBy(xpath="(//input[@formcontrolname='email'])[1]")
	private WebElement EmailTextbox;
	@FindBy(xpath="(//select[@formcontrolname='id'])[2]")
	private WebElement SectorDropdownlist;
	@FindBy(xpath="(//select[@formcontrolname='uniqueID'])[2]")
	private WebElement  JobRoleDropDownlist;
	@FindBy(xpath="(//input[@formcontrolname='target'])[2]")
	private WebElement Traingtarget;
	
	@FindBy(xpath="(//button[text()='Add'])[2]")
	private WebElement AddButton;
	@FindBy(xpath="//button[contains(text(),'Save Changes')]")
	private WebElement SaveChangesButton;
	
	@FindBy(xpath="(//button[text()='Close'])[4]")
	private WebElement CloseButton;
 public void ClickOnRPLAction()
	{
		RPl_Action.click();
	}
	public void ClickOnViewDetails()
	{
		viewDetailsIcon.click();
	}
	public void ClickonViewCamps()
	{

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", viewCamps);
		//viewCamps.click();
	}
	public void ClickOnAdd_Camps()
	{
		Add_Camps_button.click();
	}
	
	public void EnterlocationName(String locationName)
	{
		locationNameTextBox.sendKeys(locationName);
	}
	public void EnterAddress(String address)
	{
		Addresstextbox.sendKeys(address);
	}
	public void EnterPincode(String pincode)
	{
		PincodeTextBox.sendKeys(pincode);
	}
	public void ClickOnstate()
	{
		stateDropdownlist.click();
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
	public void SelectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(SectorDropdownlist,sector);
		
	}
	public void SelectJobRole(String jobrole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(JobRoleDropDownlist, jobrole);
		
	}
	public void EnterTrainingTarget(String target)
	{
		Traingtarget.sendKeys(target);
	}
	public void ClickonAdd()
	{
		AddButton.click();
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
