package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class CMA_TrainingCentreInfoPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Download Training Room Photos']")
	private WebElement downloadTrainingRoomPhotosButton;
	@FindBy(xpath="//button[text()='Download Laboratory Room Photos']")
	private WebElement downloadLaboratoryRoomPhotosButton;
	@FindBy(xpath="//button[text()='Download Washroom Room Photos']")
	private WebElement downloadWahRoomPhotosButton;
	@FindBy (xpath="//button[text()='Download Cafetaria/Dining Room Photos']")
	private WebElement downloadCafetariaPhotosButton;
	@FindBy(id="review")
	private WebElement reviewCommentsDropDownList;
	@FindBy(id="comment")
	private WebElement enterReviewCommentsTextbox;
	@FindBy(xpath="//button[text()='Submit Response']")
	private WebElement submitResponseButton;
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement oKButton;
	
	
	
	public CMA_TrainingCentreInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDownloadTrainingRoomPhotos()throws Exception
	{
		downloadTrainingRoomPhotosButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadLaboratoryRoomPhotos()throws Exception
	{
		downloadLaboratoryRoomPhotosButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadWashRoomPhotos()throws Exception
	{
		downloadWahRoomPhotosButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOnDownloadCafetariaOrDinningRoomPhotos()throws Exception
	{
		downloadCafetariaPhotosButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void selectReview(String review)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewCommentsDropDownList, review);
	}
	
	public void enterReviewComments(String reviewComments)
	{
		enterReviewCommentsTextbox.clear();
		enterReviewCommentsTextbox.sendKeys(reviewComments);
	}
	
	public void clickOnSubmitResponse()
	{
		submitResponseButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void clickOnOK()
	{
		oKButton.click();
	}

}
