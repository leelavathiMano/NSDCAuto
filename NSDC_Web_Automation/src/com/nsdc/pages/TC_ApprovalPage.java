package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.FilePreview;
import com.nsdc.generic.SelectDropDownList;

public class TC_ApprovalPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Preview Attached Proof Document')]")
	private WebElement previewAttachedProofDocument_First_Button;
	
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[1]")
	private WebElement first_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[2]")
	private WebElement second_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[3]")
	private WebElement third_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[4]")
	private WebElement fourth_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[5]")
	private WebElement fifth_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[6]")
	private WebElement sixth_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[7]")
	private WebElement seventh_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[8]")
	private WebElement eighth_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[9]")
	private WebElement ninth_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[10]")
	private WebElement tenth_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[11]")
	private WebElement eleventh_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[12]")
	private WebElement twelth_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[13]")
	private WebElement thirteen_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[14]")
	private WebElement fourteen_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[15]")
	private WebElement fifteen_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[16]")
	private WebElement sixteen_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[17]")
	private WebElement seventeen_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[18]")
	private WebElement eighteen_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[19]")
	private WebElement ninteen_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[20]")
	private WebElement twenty_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[21]")
	private WebElement twentyOne_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[22]")
	private WebElement twentyTwo_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[23]")
	private WebElement twentyThree_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[24]")
	private WebElement twentyFour_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[25]")
	private WebElement twentyFive_ReveiewCommentsDropDownList;
	@FindBy(xpath="(//select[option[text()='Select Review Comments']])[26]")
	private WebElement twentySix_ReveiewCommentsDropDownList;
	
	
	
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[1]")
	private WebElement first_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[2]")
	private WebElement second_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[3]")
	private WebElement third_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[4]")
	private WebElement fourth_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[5]")
	private WebElement fifth_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[6]")
	private WebElement sixth_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[7]")
	private WebElement seventh_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[8]")
	private WebElement eighth_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[9]")
	private WebElement ninth_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[10]")
	private WebElement tenth_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[11]")
	private WebElement eleventh_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[12]")
	private WebElement twelth_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[13]")
	private WebElement thirteen_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[14]")
	private WebElement fourteen_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[15]")
	private WebElement fifteen_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[16]")
	private WebElement sixteen_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[17]")
	private WebElement seventeen_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[18]")
	private WebElement eighteen_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[19]")
	private WebElement ninteen_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[20]")
	private WebElement twenty_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[21]")
	private WebElement twentyOne_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[22]")
	private WebElement twentyTwo_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[23]")
	private WebElement twentyThree_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[24]")
	private WebElement twentyFour_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[25]")
	private WebElement twentyFive_AdditionalCommentTextbox;
	@FindBy(xpath="(//textarea[@formcontrolname='reviewComment'])[26]")
	private WebElement twentySix_AdditionalCommentTextbox;
	
	
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[1]")
	private WebElement first_ActionButton;
	@FindBy(xpath="(//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill'])[2]")
	private WebElement second_ActionButton;
	@FindBy(xpath="(//a[contains(text(),'Take Action')])[1]")
	private WebElement first_TakeActionButton;
	@FindBy(xpath="(//a[contains(text(),'Take Action')])[2]")
	private WebElement second_TakeActionButton;
	
	@FindBy(xpath="(//button[contains(text(),'Next')])[4]")
	private WebElement next_JobRoleButton;
	@FindBy(xpath="(//button[contains(text(),'Save & Next')])[1]")
	private WebElement saveAndNext_First_Button;
	@FindBy(xpath="(//button[contains(text(),'Save & Next')])[2]")
	private WebElement saveAndNext_Second_Button;
	@FindBy(xpath="(//button[contains(text(),'Save & Next')])[3]")
	private WebElement saveAndNext_Third_Button;
	@FindBy(xpath="(//button[contains(text(),'Save & Next')])[4]")
	private WebElement saveAndNext_Fourth_Button;
	@FindBy(xpath="(//button[contains(text(),'Save & Next')])[5]")
	private WebElement saveAndNext_Fifth_Button;
	
	@FindBy(xpath="//button[contains(text(),'back')]")
	private WebElement backButton;
	
	@FindBy(xpath="//select[@formcontrolname='finalStatus']")
	private WebElement finalReviewStatusDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='finalReviewStatusComment']")
	private WebElement finalstatusReviewCommentsTextbox;
	@FindBy(xpath="//input[@id='customFile']")
	private WebElement finalStatus_BrowseFileButton;
	@FindBy(xpath="//button[contains(text(),'Upload')]")
	private WebElement finalStatus_UploadFileButton;
	@FindBy(xpath="//button[contains(text(),'Save & Continue')]")
	private WebElement saveAndContinueButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	@FindBy(xpath="//div[text()='1.Front View']")
	private WebElement frontView_Image_Button;
	@FindBy(xpath="//div[text()='2.Left View']")
	private WebElement leftView_Image_Button;	
	@FindBy(xpath="//div[text()='3.Right View']")
	private WebElement rightView_Image_Button;
	@FindBy(xpath="//div[text()='4.Internet Bill']")
	private WebElement internetConectivity_Image_Button;
	@FindBy(xpath="//div[text()='5.Power Backup']")
	private WebElement powerBackup_Image_Button;
	@FindBy(xpath="//div[text()='1.Functional Washroom for DifferentlyAbled']")
	private WebElement washroom_Image_Button;
	@FindBy(xpath="//div[text()='2.Ramp']")
	private WebElement ramp_Image_Button;
	@FindBy(xpath="//div[text()='3.Lift']")
	private WebElement lift_Image_Button;
	@FindBy(xpath="//div[text()='1.Daily Inspection']")
	private WebElement dailyInspection_Image_Button;
	@FindBy(xpath="//div[text()='2.Safe Drinking']")
	private WebElement safeDrinking_Image_Button;
	@FindBy(xpath="//div[text()='1.Fire Fighting Equipment']")
	private WebElement fireFightingEquipment_Image_Button;
	@FindBy(xpath="//div[text()='2.First Aid Kit']")
	private WebElement firstAidKit_Image_Button;
	
	@FindBy(xpath="(//div[text()='1.View 1'])[1]")
	private WebElement firstView_FirstImage_Button;
	@FindBy(xpath="(//div[text()='1.View 2'])[1]")
	private WebElement secondView_FirstImage_Button;
	@FindBy(xpath="(//div[text()='1.View 1'])[2]")
	private WebElement firstView_SecondImage_Button;
	@FindBy(xpath="(//div[text()='1.View 2'])[2]")
	private WebElement secondView_SecondImage_Button;
	@FindBy(xpath="//div[text()='1.SSC Certificate']")
	private WebElement sscCertificate_Image_Button;
	@FindBy(xpath="//div[text()='2.Highest Qualification Certificate']")
	private WebElement highestQualificationCertificate_Image_Button;
	@FindBy(xpath="//div[text()='3.NIESBUD/other agency certificate of entrepreneurship']")
	private WebElement nIESBUD_Image_Button;
	@FindBy(xpath="//div[text()='4.Industrial Experiance']")
	private WebElement industrialExperience_Image_Button;
	
	
	@FindBy(xpath="(//div[text()='1.View 1'])[3]")
	private WebElement firstView_ThirdImage_Button;
	@FindBy(xpath="(//div[text()='1.View 2'])[3]")
	private WebElement secondView_ThirdImage_Button;
	@FindBy(xpath="(//div[text()='1.View 1'])[4]")
	private WebElement firstView_FourthImage_Button;
	@FindBy(xpath="(//div[text()='1.View 2'])[4]")
	private WebElement secondView_FourthImage_Button;
	@FindBy(xpath="(//div[text()='1.View 1'])[5]")
	private WebElement firstView_FifthImage_Button;
	@FindBy(xpath="(//div[text()='1.View 2'])[5]")
	private WebElement secondView_FifthImage_Button;
	@FindBy(xpath="(//div[text()='1.View 1'])[6]")
	private WebElement firstView_SixthImage_Button;
	@FindBy(xpath="(//div[text()='1.View 2'])[6]")
	private WebElement secondView_SixthImage_Button;
	@FindBy(xpath="(//div[text()='1.View 1'])[7]")
	private WebElement firstView_SeventhImage_Button;
	@FindBy(xpath="(//div[text()='1.View 2'])[7]")
	private WebElement secondView_SeventhImage_Button;
	
	
	public TC_ApprovalPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	public void clickOn_First_PreviewAttachedProofDocument()throws Exception
	{
		previewAttachedProofDocument_First_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void select_First_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(first_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Second_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(second_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Third_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(third_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Fourth_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(fourth_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Fifth_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(fifth_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Sixth_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sixth_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Seventh_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(seventh_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Eighth_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(eighth_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Ninth_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(ninth_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Tenth_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tenth_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Eleventh_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(eleventh_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Twelth_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twelth_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Thirteen_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(thirteen_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Fourteen_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(fourteen_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Fifteen_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(fifteen_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Sixteen_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sixteen_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Seventeen_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(seventeen_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Eighteen_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(eighteen_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Ninteen_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(ninteen_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_Twenty_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twenty_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_TwentyOne_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twentyOne_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_TwentyTwo_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twentyTwo_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_TwentyThree_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twentyThree_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_TwentyFour_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twentyFour_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_twentyFive_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twentyFive_ReveiewCommentsDropDownList, reviewComments);
	}
	
	public void select_TwentySix_ReviewComments(String reviewComments)
	{
		SelectDropDownList.selectDropDownListByVisibleText(twentySix_ReveiewCommentsDropDownList, reviewComments);
	}
	
	
	public void enter_First_AdditionalComments(String additionalComments)
	{
		first_AdditionalCommentTextbox.clear();
		first_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Second_AdditionalComments(String additionalComments)
	{
		second_AdditionalCommentTextbox.clear();
		second_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Third_AdditionalComments(String additionalComments)
	{
		third_AdditionalCommentTextbox.clear();
		third_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Fourth_AdditionalComments(String additionalComments)
	{
		fourth_AdditionalCommentTextbox.clear();
		fourth_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Fifth_AdditionalComments(String additionalComments)
	{
		fifth_AdditionalCommentTextbox.clear();
		fifth_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Sixth_AdditionalComments(String additionalComments)
	{
		sixth_AdditionalCommentTextbox.clear();
		sixth_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Seventh_AdditionalComments(String additionalComments)
	{
		seventh_AdditionalCommentTextbox.clear();
		seventh_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Eighth_AdditionalComments(String additionalComments)
	{
		eighth_AdditionalCommentTextbox.clear();
		eighth_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Ninth_AdditionalComments(String additionalComments)
	{
		ninth_AdditionalCommentTextbox.clear();
		ninth_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Tenth_AdditionalComments(String additionalComments)
	{
		tenth_AdditionalCommentTextbox.clear();
		tenth_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Eleventh_AdditionalComments(String additionalComments)
	{
		eleventh_AdditionalCommentTextbox.clear();
		eleventh_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Twelth_AdditionalComments(String additionalComments)
	{
		twelth_AdditionalCommentTextbox.clear();
		twelth_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Thirteen_AdditionalComments(String additionalComments)
	{
		thirteen_AdditionalCommentTextbox.clear();
		thirteen_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Fourteen_AdditionalComments(String additionalComments)
	{
		fourteen_AdditionalCommentTextbox.clear();
		fourteen_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Fifteen_AdditionalComments(String additionalComments)
	{
		fifteen_AdditionalCommentTextbox.clear();
		fifteen_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Sixteen_AdditionalComments(String additionalComments)
	{
		sixteen_AdditionalCommentTextbox.clear();
		sixteen_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Seventeen_AdditionalComments(String additionalComments)
	{
		seventeen_AdditionalCommentTextbox.clear();
		seventeen_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Eighteen_AdditionalComments(String additionalComments)
	{
		eighteen_AdditionalCommentTextbox.clear();
		eighteen_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Ninteen_AdditionalComments(String additionalComments)
	{
		ninteen_AdditionalCommentTextbox.clear();
		ninteen_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_Twenty_AdditionalComments(String additionalComments)
	{
		twenty_AdditionalCommentTextbox.clear();
		twenty_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_TwentyOne_AdditionalComments(String additionalComments)
	{
		twentyOne_AdditionalCommentTextbox.clear();
		twentyOne_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_TwentyTwo_AdditionalComments(String additionalComments)
	{
		twentyTwo_AdditionalCommentTextbox.clear();
		twentyTwo_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_TwentyThree_AdditionalComments(String additionalComments)
	{
		twentyThree_AdditionalCommentTextbox.clear();
		twentyThree_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_TwentyFour_AdditionalComments(String additionalComments)
	{
		twentyFour_AdditionalCommentTextbox.clear();
		twentyFour_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_TwentyFive_AdditionalComments(String additionalComments)
	{
		twentyFive_AdditionalCommentTextbox.clear();
		twentyFive_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void enter_TwentySix_AdditionalComments(String additionalComments)
	{
		twentySix_AdditionalCommentTextbox.clear();
		twentySix_AdditionalCommentTextbox.sendKeys(additionalComments);
	}
	
	public void clickOn_First_Action()
	{
		first_ActionButton.click();
	}
	
	public void clickOn_Second_Action()
	{
		second_ActionButton.click();
	}
	
	public void clickOn_First_TakeAction()
	{
		first_TakeActionButton.click();
	}
	
	public void clickOn_Second_TakeAction()
	{
		second_TakeActionButton.click();
	}
	
	public void clickOnSaveAndNext_First()
	{
		saveAndNext_First_Button.click();
	}
	
	public void clickOnSaveAndNext_Second()
	{
		saveAndNext_Second_Button.click();
	}
	
	public void clickOnSaveAndNext_Third()
	{
		saveAndNext_Third_Button.click();
	}
	
	public void clickOnSaveAndNext_Fourth()
	{
		saveAndNext_Fourth_Button.click();
	}
	
	public void clickOnSaveAndNext_Fifth()
	{
		saveAndNext_Fifth_Button.click();
	}
	
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnNext_ForJobRole()
	{
		next_JobRoleButton.click();
	}
	
	public void selectFinalReviewStatus(String finalStatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(finalReviewStatusDropDownList, finalStatus);
	}
	
	public void enterFinalStatusReviewComments(String finalReviewComments)
	{
		finalstatusReviewCommentsTextbox.clear();
		finalstatusReviewCommentsTextbox.sendKeys(finalReviewComments);
	}
	
	public void clickOnBrowseFile_ForFinalStatus()
	{
		finalStatus_BrowseFileButton.click();
	}
	
	public void clickOnUploadFile_ForFinalStatus()
	{
		finalStatus_UploadFileButton.click();
	}
	
	public void clickOnSaveAndContinue()
	{
		saveAndContinueButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}
	
	public void clickOn_FrontView_Image()throws Exception
	{
		frontView_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_LeftView_Image()throws Exception
	{
		leftView_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_RightView_Image()throws Exception
	{
		rightView_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_InternetConectivity_Image()throws Exception
	{
		internetConectivity_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_PowerBackup_Image()throws Exception
	{
		powerBackup_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_DifferentyAbledWashroom_Image()throws Exception
	{
		washroom_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Ramp_Image()throws Exception
	{
		ramp_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_Lift_Image()throws Exception
	{
		lift_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_DailyInspection_Image()throws Exception
	{
		dailyInspection_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SafeDrinking_Image()throws Exception
	{
		safeDrinking_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FireFightingEquipment_Image()throws Exception
	{
		fireFightingEquipment_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstAidKit_Image()throws Exception
	{
		firstAidKit_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstView_FirstImage()throws Exception
	{
		firstView_FirstImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SecondView_FirstImage()throws Exception
	{
		secondView_FirstImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstView_SecondImage()throws Exception
	{
		firstView_SecondImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SecondView_SecondImage()throws Exception
	{
		secondView_SecondImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SSCCertificate_Image()throws Exception
	{
		sscCertificate_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_HighestQualification_Image()throws Exception
	{
		highestQualificationCertificate_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_NIESBUD_Image()throws Exception
	{
		nIESBUD_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_IndustrialExperience_Image()throws Exception
	{
		industrialExperience_Image_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstView_ThirdImage()throws Exception
	{
		firstView_ThirdImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SecondView_ThirdImage()throws Exception
	{
		secondView_ThirdImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstView_FourthImage()throws Exception
	{
		firstView_FourthImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SecondView_FourthImage()throws Exception
	{
		secondView_FourthImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstView_FifthImage()throws Exception
	{
		firstView_FifthImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SecondView_FifthImage()throws Exception
	{
		secondView_FifthImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstView_SixthImage()throws Exception
	{
		firstView_SixthImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SecondView_SixthImage()throws Exception
	{
		secondView_SixthImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_FirstView_SeventhImage()throws Exception
	{
		firstView_SeventhImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	public void clickOn_SecondView_SeventhImage()throws Exception
	{
		secondView_SeventhImage_Button.click();
		Thread.sleep(3000);
		FilePreview.closeWindow(driver);
	}
	
	

}
