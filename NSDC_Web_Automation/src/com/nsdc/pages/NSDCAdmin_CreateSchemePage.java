package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class NSDCAdmin_CreateSchemePage 
{

	WebDriver driver;
	
	@FindBy(xpath="//select[@ng-reflect-name='scheme']")
	private WebElement selectSchemeDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='schemeType']")
	private WebElement selectASchemeTypeDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='trainingType']")
	private WebElement selectATrainingTypeDropDownList;
	@FindBy(xpath="//input[@ng-reflect-name='schemeName' or @placeholder='Enter Scheme Name']")
	private WebElement enterSchemeNameTextBox;
	@FindBy(xpath="//input[@ng-reflect-name='department' or @placeholder='Enter Department/Ministry Type']")
	private WebElement enterSchemeDepartmentOrMinistryTextBox;
	@FindBy(xpath="//select[@ng-reflect-name='paymentAdviceRequired']")
	private WebElement selectPayoutAdviceDropDownList;
	@FindBy(xpath="//select[@ng-reflect-name='assignedBo']")
	private WebElement assignToBusinessOwnerDropDownList;
	@FindBy(xpath="//button[contains(text(),'Submit and Assign to Business Admin')]")
	private WebElement submitAndAssignToBusinessAdminButton;
	@FindBy(xpath="//span[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	
	
	public NSDCAdmin_CreateSchemePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectScheme(String select_Scheme)
	{
	   SelectDropDownList.selectDropDownListByVisibleText(selectSchemeDropDownList, select_Scheme);
	}
	
	public void enterSchemeName(String enter_Scheme_Name)
	{
		enterSchemeNameTextBox.sendKeys(enter_Scheme_Name);
	}
	
	public void selectASchemeType(String select_A_Scheme_Type)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectASchemeTypeDropDownList, select_A_Scheme_Type);
	}
	
	public void selectATrainingType(String select_A_Training_Type)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectATrainingTypeDropDownList, select_A_Training_Type);
	}
	
	public void enterSchemeDepartmentOrMinistry(String enter_Scheme_Department_Or_Ministry)
	{
		enterSchemeDepartmentOrMinistryTextBox.sendKeys(enter_Scheme_Department_Or_Ministry);
	}
	
	public void selectPayoutAdvice(String select_Payout_Advice)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectPayoutAdviceDropDownList, select_Payout_Advice);
	}
	
	public void selectAssignToBusinessOwner(String assign_To_Business_Owner)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignToBusinessOwnerDropDownList, assign_To_Business_Owner);
	}
	
	public void clickOnSubmitAndAssignToBusinessAdmin() 
	{
		submitAndAssignToBusinessAdminButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void clickOnOk()
	{
		okButton.click();
	}
}
