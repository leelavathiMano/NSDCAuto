package com.nsdc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class CMA_TrainingCentreInfoPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Download Franchise Documents']")
	private WebElement downloadFranchiseDocumentsButton;
	@FindBy(xpath="//app-upload[div[label[contains(text(),'Training Room Photos:')]]]//th[contains(text(),'Preview')]")
	private WebElement preview_TrainingRoomPhotos_Button;
	@FindBy(xpath="//app-upload[div[label[contains(text(),'Laboratory Room Photos:')]]]//th[contains(text(),'Preview')]")
	private WebElement preview_LaboratoryRoomPhotos_Button;
	@FindBy(xpath="//app-upload[div[label[contains(text(),'Male Washroom Photos:')]]]//th[contains(text(),'Preview')]")
	private WebElement preview_MaleWashRoomPhotos_Button;
	@FindBy(xpath="//app-upload[div[label[contains(text(),'Female Washroom Photos:')]]]//th[contains(text(),'Preview')]")
	private WebElement preview_FemaleWasRoomPhotos_Button;
	@FindBy(xpath="//app-upload[div[label[contains(text(),'Unisex Washroom Photos:')]]]//th[contains(text(),'Preview')]")
	private WebElement preview_UnisexWasRoomPhotos_Button;
	@FindBy(xpath="//button[text()='Download Washroom Room Photos:']")
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
	
	@FindBy(xpath="(//button[text()='Download'])[1]")
	private WebElement first_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[2]")
	private WebElement second_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[3]")
	private WebElement third_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[4]")
	private WebElement fourth_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[5]")
	private WebElement fifth_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[6]")
	private WebElement sixth_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[7]")
	private WebElement seventh_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[8]")
	private WebElement eighth_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[9]")
	private WebElement ninth_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[10]")
	private WebElement tenth_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[11]")
	private WebElement eleventh_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[12]")
	private WebElement twelth_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[13]")
	private WebElement thirteen_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[14]")
	private WebElement fourteen_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[15]")
	private WebElement fifteen_Facility_DownloadButton;
	@FindBy(xpath="(//button[text()='Download'])[16]")
	private WebElement sixteen_Facility_DownloadButton;
	
	@FindBy(xpath="(//button[@class='close'])[1]")
	private WebElement close_PreviewButton;
	
	@FindBy(xpath="//p[text()='Adding a Training Centre']")
	private WebElement addTCText;
	
	@FindBy(xpath="//button[contains(text(),'Download Address Proof:')]")
	private WebElement downloadAddressProofButton;
	
	
	public CMA_TrainingCentreInfoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnDownloadFranchiseDocuments()throws Exception
	{
		downloadFranchiseDocumentsButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Preview_TrainingRoomPhotos()throws Exception
	{
		preview_TrainingRoomPhotos_Button.click();
		//Thread.sleep(3000);
		//FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Preview_LaboratoryRoomPhotos()throws Exception
	{
		preview_LaboratoryRoomPhotos_Button.click();
		//Thread.sleep(3000);
		//FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Preview_MaleWashRoomPhotos() throws Exception
	{
		preview_MaleWashRoomPhotos_Button.click();
		//Thread.sleep(3000);
		//FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Preview_FemaleWashRoomPhotos()
	{
		preview_FemaleWasRoomPhotos_Button.click();
	}
	
	public void clickOn_Preview_UnisexWasRoomPhotos()
	{
		preview_UnisexWasRoomPhotos_Button.click();
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
	
	public void clickOn_First_Facility_Download()throws Exception
	{
		first_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Second_Facility_Download()throws Exception
	{
		second_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Third_Facility_Download()throws Exception
	{
		third_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Fourth_Facility_Download()throws Exception
	{
		fourth_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Fifth_Facility_Download()throws Exception
	{
		fifth_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Sixth_Facility_Download()throws Exception
	{
		sixth_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Seventh_Facility_Download()throws Exception
	{
		seventh_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Eighth_Facility_Download()throws Exception
	{
		eighth_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Ninth_Facility_Download()throws Exception
	{
		ninth_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Tenth_Facility_Download()throws Exception
	{
		tenth_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Eleventh_Facility_Download()throws Exception
	{
		eleventh_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_twelth_Facility_Download()throws Exception
	{
		twelth_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Thirteen_Facility_Download()throws Exception
	{
		thirteen_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Fourteen_Facility_Download()throws Exception
	{
		fourteen_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Fifteen_Facility_Download()throws Exception
	{
		fifteen_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Sixteen_Facility_Download()throws Exception
	{
		sixteen_Facility_DownloadButton.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickFor_Download_AllFacilities()throws Exception
	{
		List<WebElement> element = driver.findElements(By.xpath("//button[text()='Download']"));
		for(int i=0; i<element.size(); i++)
		{
			WebElement ele = element.get(i);
			ele.click();
			Thread.sleep(3000);
			FilePreview.closeWindow(driver);
		}
	}
	
	public void clickOn_ClosePreview()throws Exception
	{
		Thread.sleep(3000);
		close_PreviewButton.click();
	}
	
	public void clickOnDownloadAddressProof() throws Exception
	{
		downloadAddressProofButton.click();
		Thread.sleep(5000);
		FilePreview.closeWindow(driver);
	}
	
	
}
