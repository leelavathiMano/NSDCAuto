package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SSCAllBatchesPage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextBox;
	@FindBy(xpath="//i[@class='la la-ellipsis-h']")
	private WebElement actionButton;
	@FindBy(xpath="//span[contains(text(),' View Details')]")
	private WebElement viewBatchDetailsButton;
	@FindBy(xpath="//span[contains(text(),' Assign Master Trainer')]")
	private WebElement assignMasterTrainerButton;
	@FindBy(xpath="//span[contains(text(),' Assign Assessment Agency')]")
	private WebElement assignAssessmentAgencyButton;
	@FindBy(xpath="//select[@class='form-control ng-pristine ng-valid ng-touched']")
	private WebElement assignMasterTrainerDropDownList;
	@FindBy(xpath="//button[contains(text(),'Assign')]")
	private WebElement assignButton;
	@FindBy(xpath="//button[contains(text(),'Yes, assign it!')]")
	private WebElement assignItButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public SSCAllBatchesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterSearchByWord(String search_By_Keyword)
	{
		searchByKeywordTextBox.sendKeys(search_By_Keyword);
	}
	public void clickActionButton()
	{
		actionButton.click();
	}
	public void clickViewBatchButton()
	{
		viewBatchDetailsButton.click();
	}
	
	public void clickAssignMasterTrainerButton()
	{
		assignMasterTrainerButton.click();
	}
	
	public void clickAssessmentAgencyButton()
	{
		assignAssessmentAgencyButton.click();
	}
	
	public void selectAssignMasterTrainerDropDownList(String assign_MasterTrainer)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignMasterTrainerDropDownList, assign_MasterTrainer);
	}
	
	public void clickAssignButton()
	{
		assignButton.click();
	}
	
	public void clickAssignItButton()
	{
		assignItButton.click();
	}
	
	
	
	
	
	
	
}