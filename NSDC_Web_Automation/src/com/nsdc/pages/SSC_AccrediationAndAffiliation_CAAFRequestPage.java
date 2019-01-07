package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SSC_AccrediationAndAffiliation_CAAFRequestPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchByKeywordTextbox;
	@FindBy(xpath="(//button[contains(text(),'Download Attached Images from TC')])[1]")
	private WebElement downloadAttachedImagesFromTC_First_Button;
	@FindBy(xpath="(//button[contains(text(),'Download Attached Images from TC')])[2]")
	private WebElement downloadAttachedImagesFromTC_Second_Button;
	@FindBy(xpath="(//button[contains(text(),'Download Attached Images from TC')])[3]")
	private WebElement downloadAttachedImagesFromTC_Third_Button;
	@FindBy(xpath="(//button[contains(text(),'Download Attached Images from TC')])[4]")
	private WebElement downloadAttachedImagesFromTC_Fourth_Button;
	@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[1]")
	private WebElement first_Review_DropDownList;
	@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[2]")
	private WebElement second_Review_DropDownList;
	@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[3]")
	private WebElement third_Review_DropDownList;
	@FindBy(xpath="(//select[@class='form-control m-input ng-untouched ng-pristine ng-valid'])[4]")
	private WebElement fourth_Review_DropDownList;
	@FindBy(xpath="(//textarea[@class='form-control m-input ng-touched ng-pristine ng-valid'])[1]")
	private WebElement first_ReviewComments_Textbox;
	@FindBy(xpath="(//textarea[@class='form-control m-input ng-touched ng-pristine ng-valid'])[2]")
	private WebElement second_ReviewComments_Textbox;
	@FindBy(xpath="(//textarea[@class='form-control m-input ng-touched ng-pristine ng-valid'])[3]")
	private WebElement third_ReviewComments_Textbox;
	@FindBy(xpath="(//textarea[@class='form-control m-input ng-touched ng-pristine ng-valid'])[4]")
	private WebElement fourth_ReviewComments_Textbox;
	@FindBy(xpath="(//input[@id='customFile'])[1]")
	private WebElement first_BrowseFile_Button;
	@FindBy(xpath="(//input[@id='customFile'])[2]")
	private WebElement second_BrowseFile_Button;
	@FindBy(xpath="(//input[@id='customFile'])[3]")
	private WebElement third_BrowseFile_Button;
	@FindBy(xpath="(//input[@id='customFile'])[4]")
	private WebElement fourth_BrowseFile_Button;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
	private WebElement first_UploadFile_Button;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement second_UploadFile_Button;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
	private WebElement third_UploadFile_Button;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[4]")
	private WebElement fourth_UploadFile_Button;
	
	@FindBy(xpath="(//select[@formcontrolname='finalReviewType'])[1]")
	private WebElement first_finalReviewStatus_DropDownList;
	@FindBy(xpath="(//select[@formcontrolname='finalReviewType'])[2]")
	private WebElement second_finalReviewStatus_DropDownList;
	@FindBy(xpath="(//input[@class='ng-untouched ng-pristine ng-valid'])[1]")
	private WebElement first_EditAndSwitchFinalStatus_CheckBox;
	@FindBy(xpath="(//input[@class='ng-untouched ng-pristine ng-valid'])[2]")
	private WebElement second_EditAndSwitchFinalStatus_CheckBox;
	@FindBy(xpath="(//textarea[@formcontrolname='finalReviewComment'])[1]")
	private WebElement first_finalReviewComment_Textbox;
	@FindBy(xpath="(//textarea[@formcontrolname='finalReviewComment'])[2]")
	private WebElement second_finalReviewComment_Textbox;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement continueButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	
	
	
	
	public SSC_AccrediationAndAffiliation_CAAFRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterSearchByKeywords(String keywords)
	{
		searchByKeywordTextbox.clear();
		searchByKeywordTextbox.sendKeys(keywords);
	}
	
	public void clickOn_First_DownloadAttachedImagesFromTC()
	{
		downloadAttachedImagesFromTC_First_Button.click();
	}
	
	public void clickOn_Second_DownloadAttachedImagesFromTC()
	{
		downloadAttachedImagesFromTC_Second_Button.click();
	}
	
	public void clickOn_Third_DownloadAttachedImagesFromTC()
	{
		downloadAttachedImagesFromTC_Third_Button.click();
	}
	
	public void clickOn_Fourth_DownloadAttachedImagesFromTC()
	{
		downloadAttachedImagesFromTC_Fourth_Button.click();
	}
	
	public void select_First_Review(String review)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_Review_DropDownList, review);
	}
	
	public void select_Second_Review(String review)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_Review_DropDownList, review);
	}
	
	public void select_Third_Review(String review)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_Review_DropDownList, review);
	}
	
	public void select_Fourth_Review(String review)
	{
		SelectDropDownList.selectDropDownListByVisibleText(fourth_Review_DropDownList, review);
	}
	
	public void enter_First_ReviewComments(String reviewComments)
	{
		first_ReviewComments_Textbox.clear();
		first_ReviewComments_Textbox.sendKeys(reviewComments);
	}
	
	public void enter_Second_ReviewComments(String reviewComments)
	{
		second_ReviewComments_Textbox.clear();
		second_ReviewComments_Textbox.sendKeys(reviewComments);
	}
	
	public void enter_Third_ReviewComments(String reviewComments)
	{
		third_ReviewComments_Textbox.clear();
		third_ReviewComments_Textbox.sendKeys(reviewComments);
	}
	
	public void enter_Fourth_ReviewComments(String reviewComments)
	{
		fourth_ReviewComments_Textbox.clear();
		fourth_ReviewComments_Textbox.sendKeys(reviewComments);
	}
	
	public void clickOn_First_BrowseFile()
	{
		first_BrowseFile_Button.click();
	}
	
	public void clickOn_Second_BrowseFile()
	{
		second_BrowseFile_Button.click();
	}
	
	public void clickOn_Third_BrowseFile()
	{
		third_BrowseFile_Button.click();
	}
	
	public void clickOn_Fourth_BrowseFile()
	{
		fourth_BrowseFile_Button.click();
	}
	
	public void clickOn_First_UploadFile()
	{
		first_UploadFile_Button.click();
	}
	
	public void clickOn_Second_UploadFile()
	{
		second_UploadFile_Button.click();
	}
	
	public void clickOn_Third_UploadFile()
	{
		third_UploadFile_Button.click();
	}
	
	public void clickOn_Fourth_UploadFile()
	{
		fourth_UploadFile_Button.click();
	}
	
	public void select_First_FinalReviewStatus(String finalReview)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_finalReviewStatus_DropDownList, finalReview);
	}
	
	public void select_Second_FinalReviewStatus(String finalReview)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_finalReviewStatus_DropDownList, finalReview);
	}
	
	public void clickOn_First_EditAndSwitchFinalStatus()
	{
		first_EditAndSwitchFinalStatus_CheckBox.click();
	}
	
	public void clickOn_Second_EditAndSwitchFinalStatus()
	{
		second_EditAndSwitchFinalStatus_CheckBox.click();
	}
	
	public void enter_First_FinalReviewComments(String finalComments)
	{
		first_finalReviewComment_Textbox.clear();
		first_finalReviewComment_Textbox.sendKeys(finalComments);
	}
	
	public void enter_Second_FinalReviewComments(String finalComments)
	{
		second_finalReviewComment_Textbox.clear();
		second_finalReviewComment_Textbox.sendKeys(finalComments);
	}
	
	public void clickOnSave()
	{
		saveButton.click();
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnContinue()
	{
		continueButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	

}
