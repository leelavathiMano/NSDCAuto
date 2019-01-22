package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class PMKKSPOC_AssignedInspectionRequestPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='tcId']")
	private WebElement tcIDSearchTextbox;
	@FindBy(xpath="//select[@formcontrolname='assignedNextUser']")
	private WebElement assignToDropDownList;
	@FindBy(xpath="//select[@formcontrolname='status']")
	private WebElement stageDropDownList;
	@FindBy(xpath="//input[@formcontrolname='createdOn']")
	private WebElement assignedOnTextbox;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement resetButton;
	@FindBy(xpath="//button[text()='De-Select All']")
	private WebElement deSelectAllButton;
	@FindBy(xpath="//button[text()='Take Action']")
	private WebElement takeActionButton;
	@FindBy(xpath="(//select[@formcontrolname='da'])[1]")
	private WebElement assignTo_DA_DropDownList;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[3]")
	private WebElement assignButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//select[@formcontrolname='centreInspector']")
	private WebElement assignTo_CentreInspector_DropDownList;
	@FindBy(xpath="//input[@formcontrolname='inspectionDate']")
	private WebElement InspectionDateTextbox;
	@FindBy(xpath="(//label[contains(text(),'SPOC Name')])[3]")
	private WebElement spocNameTextbox;
	@FindBy(xpath="(//button[contains(text(),'Assign')])[3]")
	private WebElement assign_ForCIButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[3]")
	private WebElement cancel_ForCIButton;
	
	
	public PMKKSPOC_AssignedInspectionRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
	
	public void selectAssignTo_DA(String daUsername)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignTo_DA_DropDownList, daUsername);
	}
	
	public void clickOnAssign()
	{
		assignButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void selectForAssign_CentreInspector(String ciUsername)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignTo_CentreInspector_DropDownList, ciUsername);
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
