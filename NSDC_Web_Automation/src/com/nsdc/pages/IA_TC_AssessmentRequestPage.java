package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class IA_TC_AssessmentRequestPage 
{
	WebDriver driver;
	
	@FindBy(linkText="View All TC Request")
	private WebElement tcRequestButton;
	@FindBy(xpath="//input[@formcontrolname='tcId']")
	private WebElement tcIDSearchTextbox;
	@FindBy(xpath="//select[@formcontrolname='assignedNextUser']")
	private WebElement assignToDropDownList;
	@FindBy(xpath="(//select[@formcontrolname='status'])[2]")
	private WebElement stageDropDownList;
	@FindBy(xpath="(//input[@formcontrolname='createdOn'])[2]")
	private WebElement assignedOnTextbox;
	@FindBy(xpath="(//button[text()='Apply'])[2]")
	private WebElement applyButton;
	@FindBy(xpath="(//button[text()='Reset'])[2]")
	private WebElement resetButton;
	@FindBy(xpath="(//button[text()='De-Select All'])[2]")
	private WebElement deSelectAllButton;
	@FindBy(xpath="(//button[text()='Take Action'])[2]")
	private WebElement takeActionButton;
	@FindBy(xpath="(//select[@formcontrolname='da'])[2]")
	private WebElement assignTo_DA_DropDownList;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[4]")
	private WebElement assignButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[7]")
	private WebElement cancelButton;
	@FindBy(xpath="//select[@formcontrolname='centreInspector']")
	private WebElement assignTo_CentreInspector_DropDownList;
	@FindBy(xpath="//select[@formcontrolname='qualityControl']")
	private WebElement assignTo_QC_DropDownList;
	@FindBy(xpath="//input[@formcontrolname='inspectionDate']")
	private WebElement InspectionDateTextbox;
	@FindBy(xpath="(//label[contains(text(),'SPOC Name')])[5]")
	private WebElement spocNameTextbox;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[9]")
	private WebElement assign_ForCIButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[6]")
	private WebElement cancel_ForCIButton;
	
	
	
	public IA_TC_AssessmentRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnViewAllTCRequest()
	{
		tcRequestButton.click();
	}
	
	public void enterForSearch(String tcID)
	{
		tcIDSearchTextbox.clear();
		tcIDSearchTextbox.sendKeys(tcID);
	}
	
	public void selectForAssignTo(String assignDA)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignToDropDownList, assignDA);
	}
	
	public void selectStage(String stage)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stageDropDownList, stage);
	}
	
	public void enterDateForAssign()
	{
		assignedOnTextbox.click();
		assignedOnTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnReset()
	{
		resetButton.click();
	}
	
	public void clickOnDeSelectAll()
	{
		deSelectAllButton.click();
	}
	
	public void clickOnTakeAction()
	{
		takeActionButton.click();
	}
	
//	public void selectAssignTo_DA(String daUsername)
//	{
//		SelectDropDownList.selectDropDownListByVisibleText(assignTo_DA_DropDownList, daUsername);
//	}
//	
	public void selectAssignTo_DA(String daUsername)
	{
		SelectDropDownList.selectDropDownListByIndex(assignTo_DA_DropDownList, 1);
	}
	
	public void clickOnAssign()
	{
		assignButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
//	public void selectForAssign_CentreInspector(String ciUsername)
//	{
//		SelectDropDownList.selectDropDownListByVisibleText(assignTo_CentreInspector_DropDownList, ciUsername);
//	}
	
	public void selectForAssign_CentreInspector(String ciUsername)
	{
		SelectDropDownList.selectDropDownListByIndex(assignTo_CentreInspector_DropDownList, 1);
	}
	
//	public void selectForAssign_QC(String qcUsername)
//	{
//		SelectDropDownList.selectDropDownListByVisibleText(assignTo_QC_DropDownList, qcUsername);
//	}
	
	public void selectForAssign_QC(String qcUsername)
	{
		SelectDropDownList.selectDropDownListByIndex(assignTo_QC_DropDownList, 1);
	}
	
	public void enterForInspectionDate()
	{
		//InspectionDateTextbox.clear();
		InspectionDateTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnSpocName()
	{
		spocNameTextbox.click();
	}
	
	public void clickOnAssign_ForCI()
	{
		assign_ForCIButton.click();
	}
	
	public void clickOnCancel_ForCI()
	{
		cancel_ForCIButton.click();
	}
	

}
