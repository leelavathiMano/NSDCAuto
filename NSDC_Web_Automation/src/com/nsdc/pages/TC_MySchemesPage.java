package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TC_MySchemesPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Download LOR')]")
	private WebElement downloadLORButton;
	@FindBy(xpath="//button[contains(text(),'View Submitted CAAF Form')]")
	private WebElement viewSubmittedCAAFFormButton;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="//div[span[strong[contains(text(),' Edit CAAF & Re-Submit ')]]]")
	private WebElement ediCAAFAndResubmitButton;
	@FindBy(xpath="//div[span[strong[contains(text(),' Appeal ')]]]")
	private WebElement appealButton;
	@FindBy(xpath="//div[span[strong[contains(text(),' Re-Inspection ')]]]")
	private WebElement reInspectionButton;
	@FindBy(xpath="//div[span[strong[contains(text(),'Accept Inspection Date')]]]")
	private WebElement acceptInspectionDateButton;
	@FindBy(xpath="//div[span[strong[contains(text(),'Apply for Refund')]]]")
	private WebElement applyForRefundButton;
	@FindBy(xpath="//button[contains(text(),'Submit for Recommendation')]")
	private WebElement submitForRecommendationLetterButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement action_ForJobRoleNameButton;
	@FindBy(xpath="(//a[contains(text(),'View Details')])[1]")
	private WebElement viewDetails_ForJobRoleNameButton;
	@FindBy(xpath="(//a[contains(text(),'Apply for Scheme')])[1]")
	private WebElement applyScheme_ForJobRoleButton;
	@FindBy(xpath="//select[option[text()='Select Scheme']]")
	private WebElement selectSchemeDropDownList;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement assignScheme_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement assignScheme_UploadFileButton;
	@FindBy(xpath="(//button[@class='btn btn-next'])[1]")
	private WebElement submitButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	
	public TC_MySchemesPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnDownloadLOR()
	{
		downloadLORButton.click();
	}
	
	public void clickOnViewSubmittedCAAFForm()
	{
		viewSubmittedCAAFFormButton.click();
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnEditCAAFAndResubmit()
	{
		ediCAAFAndResubmitButton.click();
	}
	
	public void clickOnAppeal()
	{
		appealButton.click();
	}
	
	public void clickOnReInspection()
	{
		reInspectionButton.click();
	}
	
	public void clickOnAcceptInspectionDate()
	{
		acceptInspectionDateButton.click();
	}
	
	public void clickOnApplyForRefund()
	{
		applyForRefundButton.click();
	}
	
	public void clickOnSubmitForRecommendationLetter()
	{
		submitForRecommendationLetterButton.click();
	}
	
	public void clickOnActionForJobRoleName()
	{
		action_ForJobRoleNameButton.click();
	}
	
	public void clickOnViewDetailsForJobRoleName()
	{
		viewDetails_ForJobRoleNameButton.click();
	}
	
	public void clickOnApplyForScheme_ForJobRoleName()
	{
		applyScheme_ForJobRoleButton.click();
	}
	
	public void selectScheme_ForJobRoleName(String scheme)
	{
		SelectDropDownList.selectDropDownListByVisibleText(selectSchemeDropDownList, scheme);
	}
	
	public void clickOnBrowseFileForScheme()
	{
		assignScheme_BrowseFileButton.click();
	}
	
	public void clickOnUploadFileForScheme()
	{
		assignScheme_UploadFileButton.click();
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}

}
